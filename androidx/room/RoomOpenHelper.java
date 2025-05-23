package androidx.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    @Nullable
    private DatabaseConfiguration mConfiguration;

    @NonNull
    private final Delegate mDelegate;

    @NonNull
    private final String mIdentityHash;

    @NonNull
    private final String mLegacyHash;

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class ValidationResult {

        @Nullable
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z16, @Nullable String str) {
            this.isValid = z16;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration, @NonNull Delegate delegate, @NonNull String str, @NonNull String str2) {
        super(delegate.version);
        this.mConfiguration = databaseConfiguration;
        this.mDelegate = delegate;
        this.mIdentityHash = str;
        this.mLegacyHash = str2;
    }

    private void checkIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        String str;
        if (hasRoomMasterTable(supportSQLiteDatabase)) {
            Cursor query = supportSQLiteDatabase.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
            try {
                if (query.moveToFirst()) {
                    str = query.getString(0);
                } else {
                    str = null;
                }
                query.close();
                if (!this.mIdentityHash.equals(str) && !this.mLegacyHash.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
                return;
            } catch (Throwable th5) {
                query.close();
                throw th5;
            }
        }
        ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
        if (onValidateSchema.isValid) {
            this.mDelegate.onPostMigrate(supportSQLiteDatabase);
            updateIdentity(supportSQLiteDatabase);
        } else {
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
        }
    }

    private void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private static boolean hasEmptySchema(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor query = supportSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z16 = false;
            if (query.moveToFirst()) {
                if (query.getInt(0) == 0) {
                    z16 = true;
                }
            }
            return z16;
        } finally {
            query.close();
        }
    }

    private static boolean hasRoomMasterTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor query = supportSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z16 = false;
            if (query.moveToFirst()) {
                if (query.getInt(0) != 0) {
                    z16 = true;
                }
            }
            return z16;
        } finally {
            query.close();
        }
    }

    private void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.mIdentityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onConfigure(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean hasEmptySchema = hasEmptySchema(supportSQLiteDatabase);
        this.mDelegate.createAllTables(supportSQLiteDatabase);
        if (!hasEmptySchema) {
            ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(supportSQLiteDatabase);
        this.mDelegate.onCreate(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i3, int i16) {
        onUpgrade(supportSQLiteDatabase, i3, i16);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onOpen(supportSQLiteDatabase);
        checkIdentity(supportSQLiteDatabase);
        this.mDelegate.onOpen(supportSQLiteDatabase);
        this.mConfiguration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i3, int i16) {
        boolean z16;
        List<Migration> findMigrationPath;
        DatabaseConfiguration databaseConfiguration = this.mConfiguration;
        if (databaseConfiguration != null && (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i3, i16)) != null) {
            this.mDelegate.onPreMigrate(supportSQLiteDatabase);
            Iterator<Migration> it = findMigrationPath.iterator();
            while (it.hasNext()) {
                it.next().migrate(supportSQLiteDatabase);
            }
            ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
            if (onValidateSchema.isValid) {
                this.mDelegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                z16 = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg);
            }
        } else {
            z16 = false;
        }
        if (!z16) {
            DatabaseConfiguration databaseConfiguration2 = this.mConfiguration;
            if (databaseConfiguration2 != null && !databaseConfiguration2.isMigrationRequired(i3, i16)) {
                this.mDelegate.dropAllTables(supportSQLiteDatabase);
                this.mDelegate.createAllTables(supportSQLiteDatabase);
                return;
            }
            throw new IllegalStateException("A migration from " + i3 + " to " + i16 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
    }

    public RoomOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration, @NonNull Delegate delegate, @NonNull String str) {
        this(databaseConfiguration, delegate, "", str);
    }

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i3) {
            this.version = i3;
        }

        protected abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        protected abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        @NonNull
        protected ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, null);
        }

        @Deprecated
        protected void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        protected void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        protected void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
