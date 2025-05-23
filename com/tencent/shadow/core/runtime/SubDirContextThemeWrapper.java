package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextThemeWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes25.dex */
abstract class SubDirContextThemeWrapper extends ContextThemeWrapper {
    private File mCacheDir;
    private File mCodeCacheDir;
    private File mDataDir;
    private File mExternalCacheDir;
    private File mFilesDir;
    private File mNoBackupFilesDir;
    private File mObbDir;
    private final Object mSync;

    public SubDirContextThemeWrapper() {
        this.mSync = new Object();
    }

    private static File ensurePrivateDirExists(File file) {
        file.mkdirs();
        return file;
    }

    private static File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private String makeSubName(String str) {
        return getSubDirName() + "_" + str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (getSubDirName() == null) {
            return super.databaseList();
        }
        String[] databaseList = super.databaseList();
        int length = databaseList.length;
        boolean[] zArr = new boolean[length];
        int i3 = 0;
        for (int i16 = 0; i16 < databaseList.length; i16++) {
            if (databaseList[i16].startsWith(getSubDirName())) {
                zArr[i16] = true;
                i3++;
            } else {
                zArr[i16] = false;
            }
        }
        String[] strArr = new String[i3];
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            if (zArr[i18]) {
                strArr[i17] = databaseList[i18];
                i17++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        if (getSubDirName() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return makeFilename(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (getSubDirName() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File ensurePrivateDirExists;
        if (getSubDirName() == null) {
            return super.getCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mCacheDir == null) {
                this.mCacheDir = new File(super.getCacheDir(), getSubDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File ensurePrivateDirExists;
        if (getSubDirName() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mCodeCacheDir == null) {
                this.mCodeCacheDir = new File(super.getCodeCacheDir(), getSubDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mCodeCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File ensurePrivateDirExists;
        if (getSubDirName() == null) {
            return super.getDataDir();
        }
        synchronized (this.mSync) {
            if (this.mDataDir == null) {
                this.mDataDir = new File(super.getDataDir(), getSubDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mDataDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (getSubDirName() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(makeSubName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i3) {
        if (i3 == 0 && getSubDirName() != null) {
            return ensurePrivateDirExists(new File(super.getDir(str, i3), getSubDirName()));
        }
        return super.getDir(str, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File ensurePrivateDirExists;
        if (getSubDirName() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.mSync) {
            if (this.mExternalCacheDir == null) {
                this.mExternalCacheDir = new File(super.getExternalCacheDir(), getSubDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mExternalCacheDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (getSubDirName() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i3 = 0; i3 < externalCacheDirs.length; i3++) {
            fileArr[i3] = ensurePrivateDirExists(new File(externalCacheDirs[i3], getSubDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (getSubDirName() == null) {
            return super.getExternalFilesDir(str);
        }
        return ensurePrivateDirExists(new File(super.getExternalFilesDir(str), getSubDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (getSubDirName() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i3 = 0; i3 < externalFilesDirs.length; i3++) {
            fileArr[i3] = ensurePrivateDirExists(new File(externalFilesDirs[i3], getSubDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (getSubDirName() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i3 = 0; i3 < externalMediaDirs.length; i3++) {
            fileArr[i3] = ensurePrivateDirExists(new File(externalMediaDirs[i3], getSubDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File ensurePrivateDirExists;
        if (getSubDirName() == null) {
            return super.getFilesDir();
        }
        synchronized (this.mSync) {
            if (this.mFilesDir == null) {
                this.mFilesDir = new File(super.getFilesDir(), getSubDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mFilesDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File ensurePrivateDirExists;
        if (getSubDirName() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.mSync) {
            if (this.mNoBackupFilesDir == null) {
                this.mNoBackupFilesDir = new File(super.getNoBackupFilesDir(), getSubDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mNoBackupFilesDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File ensurePrivateDirExists;
        if (getSubDirName() == null) {
            return super.getObbDir();
        }
        synchronized (this.mSync) {
            if (this.mObbDir == null) {
                this.mObbDir = new File(super.getObbDir(), getSubDirName());
            }
            ensurePrivateDirExists = ensurePrivateDirExists(this.mObbDir);
        }
        return ensurePrivateDirExists;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (getSubDirName() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i3 = 0; i3 < obbDirs.length; i3++) {
            fileArr[i3] = ensurePrivateDirExists(new File(obbDirs[i3], getSubDirName()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        if (i3 == 0 && getSubDirName() != null) {
            return super.getSharedPreferences(makeSubName(str), i3);
        }
        return super.getSharedPreferences(str, i3);
    }

    abstract String getSubDirName();

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (getSubDirName() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("\u6682\u4e0d\u652f\u6301");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (getSubDirName() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(makeFilename(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i3) throws FileNotFoundException {
        boolean z16;
        if (i3 == 0 && getSubDirName() != null) {
            if ((i3 & 32768) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new FileOutputStream(makeFilename(getFilesDir(), str), z16);
        }
        return super.openFileOutput(str, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory) {
        if (i3 == 0 && getSubDirName() != null) {
            return super.openOrCreateDatabase(makeSubName(str), i3, cursorFactory);
        }
        return super.openOrCreateDatabase(str, i3, cursorFactory);
    }

    public SubDirContextThemeWrapper(Context context, int i3) {
        super(context, i3);
        this.mSync = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i3 == 0 && getSubDirName() != null) {
            return super.openOrCreateDatabase(makeSubName(str), i3, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i3, cursorFactory, databaseErrorHandler);
    }

    @TargetApi(23)
    public SubDirContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context, theme);
        this.mSync = new Object();
    }
}
