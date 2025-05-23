package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @NonNull
    private final Context mContext;

    @Nullable
    private final String mCopyFromAssetPath;

    @Nullable
    private final File mCopyFromFile;

    @Nullable
    private final Callable<InputStream> mCopyFromInputStream;

    @Nullable
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;

    @NonNull
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCopyOpenHelper(@NonNull Context context, @Nullable String str, @Nullable File file, @Nullable Callable<InputStream> callable, int i3, @NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDatabaseVersion = i3;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    private void copyDatabaseFile(File file, boolean z16) throws IOException {
        ReadableByteChannel newChannel;
        if (this.mCopyFromAssetPath != null) {
            newChannel = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else if (this.mCopyFromFile != null) {
            newChannel = new FileInputStream(this.mCopyFromFile).getChannel();
        } else {
            Callable<InputStream> callable = this.mCopyFromInputStream;
            if (callable != null) {
                try {
                    newChannel = Channels.newChannel(callable.call());
                } catch (Exception e16) {
                    throw new IOException("inputStreamCallable exception on call", e16);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        createTempFile.deleteOnExit();
        FileUtil.copy(newChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        dispatchOnOpenPrepackagedDatabase(createTempFile, z16);
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) {
        try {
            return new FrameworkSQLiteOpenHelperFactory().create(SupportSQLiteOpenHelper.Configuration.builder(this.mContext).name(file.getAbsolutePath()).callback(new SupportSQLiteOpenHelper.Callback(Math.max(DBUtil.readVersion(file), 1)) { // from class: androidx.room.SQLiteCopyOpenHelper.1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                    int i3 = this.version;
                    if (i3 < 1) {
                        supportSQLiteDatabase.setVersion(i3);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i3, int i16) {
                }
            }).build());
        } catch (IOException e16) {
            throw new RuntimeException("Malformed database file, unable to read version.", e16);
        }
    }

    private void dispatchOnOpenPrepackagedDatabase(File file, boolean z16) {
        SupportSQLiteDatabase readableDatabase;
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        if (databaseConfiguration != null && databaseConfiguration.prepackagedDatabaseCallback != null) {
            SupportSQLiteOpenHelper createFrameworkOpenHelper = createFrameworkOpenHelper(file);
            try {
                if (z16) {
                    readableDatabase = createFrameworkOpenHelper.getWritableDatabase();
                } else {
                    readableDatabase = createFrameworkOpenHelper.getReadableDatabase();
                }
                this.mDatabaseConfiguration.prepackagedDatabaseCallback.onOpenPrepackagedDatabase(readableDatabase);
            } finally {
                createFrameworkOpenHelper.close();
            }
        }
    }

    private void verifyDatabaseFile(boolean z16) {
        boolean z17;
        String databaseName = getDatabaseName();
        File databasePath = this.mContext.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        if (databaseConfiguration != null && !databaseConfiguration.multiInstanceInvalidation) {
            z17 = false;
        } else {
            z17 = true;
        }
        CopyLock copyLock = new CopyLock(databaseName, this.mContext.getFilesDir(), z17);
        try {
            copyLock.lock();
            if (!databasePath.exists()) {
                try {
                    copyDatabaseFile(databasePath, z16);
                    copyLock.unlock();
                    return;
                } catch (IOException e16) {
                    throw new RuntimeException("Unable to copy database file.", e16);
                }
            }
            if (this.mDatabaseConfiguration == null) {
                copyLock.unlock();
                return;
            }
            try {
                int readVersion = DBUtil.readVersion(databasePath);
                int i3 = this.mDatabaseVersion;
                if (readVersion == i3) {
                    copyLock.unlock();
                    return;
                }
                if (this.mDatabaseConfiguration.isMigrationRequired(readVersion, i3)) {
                    copyLock.unlock();
                    return;
                }
                if (this.mContext.deleteDatabase(databaseName)) {
                    try {
                        copyDatabaseFile(databasePath, z16);
                    } catch (IOException e17) {
                        Log.w("ROOM", "Unable to copy database file.", e17);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                copyLock.unlock();
                return;
            } catch (IOException e18) {
                Log.w("ROOM", "Unable to read database version.", e18);
                copyLock.unlock();
                return;
            }
        } catch (Throwable th5) {
            copyLock.unlock();
            throw th5;
        }
        copyLock.unlock();
        throw th5;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.mDelegate.close();
        this.mVerified = false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile(false);
            this.mVerified = true;
        }
        return this.mDelegate.getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile(true);
            this.mVerified = true;
        }
        return this.mDelegate.getWritableDatabase();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDatabaseConfiguration(@Nullable DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z16) {
        this.mDelegate.setWriteAheadLoggingEnabled(z16);
    }
}
