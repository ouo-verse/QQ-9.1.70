package com.tencent.mobileqq.wink.storage.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import fa3.b;
import fa3.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class WinkRoomDatabase_Impl extends WinkRoomDatabase {

    /* renamed from: g, reason: collision with root package name */
    private volatile b f326409g;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `wink_publish_content_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "wink_publish_content_table");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(4), "d2ec52f71075d80ada9ef351dd1b01c2", "1d61b5433f32bdac3149709a1f533042")).build());
    }

    @Override // com.tencent.mobileqq.wink.storage.db.WinkRoomDatabase
    public b d() {
        b bVar;
        if (this.f326409g != null) {
            return this.f326409g;
        }
        synchronized (this) {
            if (this.f326409g == null) {
                this.f326409g = new c(this);
            }
            bVar = this.f326409g;
        }
        return bVar;
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(b.class, c.o());
        return hashMap;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `wink_publish_content_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `uin` INTEGER NOT NULL, `draftKey` TEXT NOT NULL, `content` TEXT, `missionId` TEXT, `selectedMedia` TEXT, `selectedMediaInfo` TEXT, `poiInfo` TEXT, `createTime` INTEGER NOT NULL, `hasSelectedCover` INTEGER NOT NULL, `uploadStatus` INTEGER NOT NULL, `toastStatus` INTEGER NOT NULL, `clientKey` TEXT, `isSyncQQ` INTEGER NOT NULL, `goodsId` TEXT, `goodsName` TEXT, `promotionParams` TEXT, `taskId` INTEGER NOT NULL, `clientTraceId` TEXT, `extraInfo` TEXT, `declarationParams` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_wink_publish_content_table_missionId` ON `wink_publish_content_table` (`missionId`)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd2ec52f71075d80ada9ef351dd1b01c2')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `wink_publish_content_table`");
            if (((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) WinkRoomDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            WinkRoomDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkRoomDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(21);
            hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            hashMap.put("uin", new TableInfo.Column("uin", "INTEGER", true, 0, null, 1));
            hashMap.put("draftKey", new TableInfo.Column("draftKey", "TEXT", true, 0, null, 1));
            hashMap.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, 1));
            hashMap.put("missionId", new TableInfo.Column("missionId", "TEXT", false, 0, null, 1));
            hashMap.put("selectedMedia", new TableInfo.Column("selectedMedia", "TEXT", false, 0, null, 1));
            hashMap.put("selectedMediaInfo", new TableInfo.Column("selectedMediaInfo", "TEXT", false, 0, null, 1));
            hashMap.put("poiInfo", new TableInfo.Column("poiInfo", "TEXT", false, 0, null, 1));
            hashMap.put(WadlProxyConsts.CREATE_TIME, new TableInfo.Column(WadlProxyConsts.CREATE_TIME, "INTEGER", true, 0, null, 1));
            hashMap.put("hasSelectedCover", new TableInfo.Column("hasSelectedCover", "INTEGER", true, 0, null, 1));
            hashMap.put("uploadStatus", new TableInfo.Column("uploadStatus", "INTEGER", true, 0, null, 1));
            hashMap.put("toastStatus", new TableInfo.Column("toastStatus", "INTEGER", true, 0, null, 1));
            hashMap.put("clientKey", new TableInfo.Column("clientKey", "TEXT", false, 0, null, 1));
            hashMap.put("isSyncQQ", new TableInfo.Column("isSyncQQ", "INTEGER", true, 0, null, 1));
            hashMap.put("goodsId", new TableInfo.Column("goodsId", "TEXT", false, 0, null, 1));
            hashMap.put("goodsName", new TableInfo.Column("goodsName", "TEXT", false, 0, null, 1));
            hashMap.put("promotionParams", new TableInfo.Column("promotionParams", "TEXT", false, 0, null, 1));
            hashMap.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, new TableInfo.Column(MiniAppGetGameTaskTicketServlet.KEY_TASKID, "INTEGER", true, 0, null, 1));
            hashMap.put("clientTraceId", new TableInfo.Column("clientTraceId", "TEXT", false, 0, null, 1));
            hashMap.put("extraInfo", new TableInfo.Column("extraInfo", "TEXT", false, 0, null, 1));
            hashMap.put("declarationParams", new TableInfo.Column("declarationParams", "TEXT", false, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new TableInfo.Index("index_wink_publish_content_table_missionId", true, Arrays.asList("missionId")));
            TableInfo tableInfo = new TableInfo("wink_publish_content_table", hashMap, hashSet, hashSet2);
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "wink_publish_content_table");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "wink_publish_content_table(com.tencent.mobileqq.wink.storage.model.WinkPublishContent).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
