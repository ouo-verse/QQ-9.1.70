package com.tencent.mobileqq.qwallet.hb.skin.local;

import android.annotation.SuppressLint;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.mtt.hippy.dom.node.TextNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes16.dex */
public final class HbSkinDatabase_Impl extends HbSkinDatabase {

    /* renamed from: c, reason: collision with root package name */
    private volatile com.tencent.mobileqq.qwallet.hb.skin.local.a f277853c;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `hb_skin_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "hb_skin_table");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(4), "575c810d09b7c2c911a2ef109717c76d", "8135a1f43b74e03f5862d24b9d1ae6bd")).build());
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.local.HbSkinDatabase
    public com.tencent.mobileqq.qwallet.hb.skin.local.a d() {
        com.tencent.mobileqq.qwallet.hb.skin.local.a aVar;
        if (this.f277853c != null) {
            return this.f277853c;
        }
        synchronized (this) {
            if (this.f277853c == null) {
                this.f277853c = new b(this);
            }
            aVar = this.f277853c;
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(com.tencent.mobileqq.qwallet.hb.skin.local.a.class, b.h());
        return hashMap;
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `hb_skin_table` (`skinId` INTEGER NOT NULL, `outerSkinId` TEXT NOT NULL, `skinFrom` INTEGER NOT NULL, `skinType` INTEGER NOT NULL, `price` INTEGER NOT NULL, `title` TEXT, `merchantName` TEXT, `merchantLogoUrl` TEXT, `activityEntryName` TEXT, `activityUrl` TEXT, `activityIcon` TEXT, `defaultSkinUrl` TEXT, `aioResUrl` TEXT, `popResUrl` TEXT, `popOpenUrl` TEXT, `popBrokenUrl` TEXT, `tail` TEXT NOT NULL, `storyResList` TEXT NOT NULL, `version` TEXT NOT NULL, `expireTimeMs` INTEGER NOT NULL, PRIMARY KEY(`skinId`, `outerSkinId`, `skinFrom`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '575c810d09b7c2c911a2ef109717c76d')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `hb_skin_table`");
            if (((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) HbSkinDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            HbSkinDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) HbSkinDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(20);
            hashMap.put("skinId", new TableInfo.Column("skinId", "INTEGER", true, 1, null, 1));
            hashMap.put("outerSkinId", new TableInfo.Column("outerSkinId", "TEXT", true, 2, null, 1));
            hashMap.put("skinFrom", new TableInfo.Column("skinFrom", "INTEGER", true, 3, null, 1));
            hashMap.put("skinType", new TableInfo.Column("skinType", "INTEGER", true, 0, null, 1));
            hashMap.put("price", new TableInfo.Column("price", "INTEGER", true, 0, null, 1));
            hashMap.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
            hashMap.put("merchantName", new TableInfo.Column("merchantName", "TEXT", false, 0, null, 1));
            hashMap.put("merchantLogoUrl", new TableInfo.Column("merchantLogoUrl", "TEXT", false, 0, null, 1));
            hashMap.put("activityEntryName", new TableInfo.Column("activityEntryName", "TEXT", false, 0, null, 1));
            hashMap.put("activityUrl", new TableInfo.Column("activityUrl", "TEXT", false, 0, null, 1));
            hashMap.put("activityIcon", new TableInfo.Column("activityIcon", "TEXT", false, 0, null, 1));
            hashMap.put("defaultSkinUrl", new TableInfo.Column("defaultSkinUrl", "TEXT", false, 0, null, 1));
            hashMap.put("aioResUrl", new TableInfo.Column("aioResUrl", "TEXT", false, 0, null, 1));
            hashMap.put("popResUrl", new TableInfo.Column("popResUrl", "TEXT", false, 0, null, 1));
            hashMap.put("popOpenUrl", new TableInfo.Column("popOpenUrl", "TEXT", false, 0, null, 1));
            hashMap.put("popBrokenUrl", new TableInfo.Column("popBrokenUrl", "TEXT", false, 0, null, 1));
            hashMap.put(TextNode.MODE_TAIL, new TableInfo.Column(TextNode.MODE_TAIL, "TEXT", true, 0, null, 1));
            hashMap.put("storyResList", new TableInfo.Column("storyResList", "TEXT", true, 0, null, 1));
            hashMap.put("version", new TableInfo.Column("version", "TEXT", true, 0, null, 1));
            hashMap.put("expireTimeMs", new TableInfo.Column("expireTimeMs", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("hb_skin_table", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "hb_skin_table");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "hb_skin_table(com.tencent.mobileqq.qwallet.hb.skin.HbSkinData).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
