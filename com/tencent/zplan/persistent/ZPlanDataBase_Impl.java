package com.tencent.zplan.persistent;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xx4.b;

/* loaded from: classes27.dex */
public final class ZPlanDataBase_Impl extends ZPlanDataBase {

    /* renamed from: f, reason: collision with root package name */
    private volatile xx4.a f385979f;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `RecordResource`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "RecordResource");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(3), "adc1cd9e216b8092606136ae347003eb", "8f06217e33665c23db69ba88d3d9b1ad")).build());
    }

    @Override // com.tencent.zplan.persistent.ZPlanDataBase
    public xx4.a g() {
        xx4.a aVar;
        if (this.f385979f != null) {
            return this.f385979f;
        }
        synchronized (this) {
            if (this.f385979f == null) {
                this.f385979f = new b(this);
            }
            aVar = this.f385979f;
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(xx4.a.class, b.c());
        return hashMap;
    }

    /* loaded from: classes27.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecordResource` (`resourceKey` TEXT NOT NULL, `localPath` TEXT, `remoteUrl` TEXT, `timestamp` INTEGER NOT NULL, `source` INTEGER NOT NULL, `actionId` INTEGER NOT NULL, `dressKey` TEXT, PRIMARY KEY(`resourceKey`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'adc1cd9e216b8092606136ae347003eb')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `RecordResource`");
            if (((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) ZPlanDataBase_Impl.this).mDatabase = supportSQLiteDatabase;
            ZPlanDataBase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ZPlanDataBase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(7);
            hashMap.put("resourceKey", new TableInfo.Column("resourceKey", "TEXT", true, 1, null, 1));
            hashMap.put("localPath", new TableInfo.Column("localPath", "TEXT", false, 0, null, 1));
            hashMap.put("remoteUrl", new TableInfo.Column("remoteUrl", "TEXT", false, 0, null, 1));
            hashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
            hashMap.put("source", new TableInfo.Column("source", "INTEGER", true, 0, null, 1));
            hashMap.put("actionId", new TableInfo.Column("actionId", "INTEGER", true, 0, null, 1));
            hashMap.put("dressKey", new TableInfo.Column("dressKey", "TEXT", false, 0, null, 1));
            TableInfo tableInfo = new TableInfo("RecordResource", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "RecordResource");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "RecordResource(com.tencent.zplan.record.model.ZPlanRecordResource).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
