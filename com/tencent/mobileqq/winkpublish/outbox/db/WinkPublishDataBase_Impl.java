package com.tencent.mobileqq.winkpublish.outbox.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.ark.ark;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes35.dex */
public final class WinkPublishDataBase_Impl extends WinkPublishDataBase {

    /* renamed from: a, reason: collision with root package name */
    private volatile b f327233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.winkpublish.outbox.db.WinkPublishDataBase
    public b c() {
        b bVar;
        if (this.f327233a != null) {
            return this.f327233a;
        }
        synchronized (this) {
            if (this.f327233a == null) {
                this.f327233a = new c(this);
            }
            bVar = this.f327233a;
        }
        return bVar;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `task_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "task_table");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(17), "a2d55b3487590fd3f1438d2d76e7b00f", "48e635fa5784eefd26a7d93f24acf13f")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(b.class, c.b());
        return hashMap;
    }

    /* loaded from: classes35.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `task_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `task_id` INTEGER NOT NULL, `json` TEXT)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a2d55b3487590fd3f1438d2d76e7b00f')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `task_table`");
            if (((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) WinkPublishDataBase_Impl.this).mDatabase = supportSQLiteDatabase;
            WinkPublishDataBase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkPublishDataBase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(3);
            hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            hashMap.put("task_id", new TableInfo.Column("task_id", "INTEGER", true, 0, null, 1));
            hashMap.put(ark.ARKMETADATA_JSON, new TableInfo.Column(ark.ARKMETADATA_JSON, "TEXT", false, 0, null, 1));
            TableInfo tableInfo = new TableInfo("task_table", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "task_table");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "task_table(com.tencent.mobileqq.winkpublish.outbox.db.TaskTableRecord).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
