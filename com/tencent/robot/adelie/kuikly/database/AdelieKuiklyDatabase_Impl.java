package com.tencent.robot.adelie.kuikly.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import e24.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class AdelieKuiklyDatabase_Impl extends AdelieKuiklyDatabase {

    /* renamed from: b, reason: collision with root package name */
    private volatile e24.a f366720b;

    @Override // com.tencent.robot.adelie.kuikly.database.AdelieKuiklyDatabase
    public e24.a c() {
        e24.a aVar;
        if (this.f366720b != null) {
            return this.f366720b;
        }
        synchronized (this) {
            if (this.f366720b == null) {
                this.f366720b = new b(this);
            }
            aVar = this.f366720b;
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `kuikly_data`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "kuikly_data");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(2), "666125262753605783ecd8373474a156", "92de1bb368d38e21fb1e900a1e5420a1")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(e24.a.class, b.d());
        return hashMap;
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kuikly_data` (`dataKey` TEXT NOT NULL, `dataValue` TEXT NOT NULL, `byteArray` BLOB NOT NULL, PRIMARY KEY(`dataKey`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '666125262753605783ecd8373474a156')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `kuikly_data`");
            if (((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            AdelieKuiklyDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AdelieKuiklyDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
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
            hashMap.put(QAdRewardDefine$SecurityData.DATA_KEY, new TableInfo.Column(QAdRewardDefine$SecurityData.DATA_KEY, "TEXT", true, 1, null, 1));
            hashMap.put("dataValue", new TableInfo.Column("dataValue", "TEXT", true, 0, null, 1));
            hashMap.put("byteArray", new TableInfo.Column("byteArray", "BLOB", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("kuikly_data", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "kuikly_data");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "kuikly_data(com.tencent.robot.adelie.kuikly.database.KuiklyData).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
