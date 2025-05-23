package com.tencent.richframework.argus.page.db;

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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class ArgusDatabase_Impl extends ArgusDatabase {
    private volatile InflateRecordDao _inflateRecordDao;
    private volatile ListLayoutInflateRecordDao _listLayoutInflateRecordDao;
    private volatile PageChangeRecordDao _pageChangeRecordDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `page_change_record_table`");
            writableDatabase.execSQL("DELETE FROM `page_inflate_record_table`");
            writableDatabase.execSQL("DELETE FROM `list_layout_inflate_record_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "page_change_record_table", "page_inflate_record_table", "list_layout_inflate_record_table");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.tencent.richframework.argus.page.db.ArgusDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `page_change_record_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `from_page` TEXT, `from_group_page` TEXT, `to_page` TEXT, `is_same_root` INTEGER NOT NULL, `is_same_root_with_group` INTEGER NOT NULL, `first_show_blocks` TEXT, `not_first_show_blocks` TEXT, `hide_blocks` TEXT, `add_blocks` TEXT, `pending_blocks` TEXT, `action_info` TEXT, `time` INTEGER NOT NULL, `stay_time` INTEGER NOT NULL, `version_code` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `page_inflate_record_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `from_page` TEXT, `res_id` INTEGER NOT NULL, `res_name` TEXT, `view_class_name` TEXT, `root_class_name` TEXT, `custom_context_class_name` TEXT, `attach_root` INTEGER NOT NULL, `is_merge` INTEGER NOT NULL, `patch_id` INTEGER NOT NULL, `cost_time` INTEGER NOT NULL, `is_from_cache` INTEGER NOT NULL, `time` INTEGER NOT NULL, `launch_stage_id` INTEGER NOT NULL, `item_view_hashcode` INTEGER NOT NULL, `item_view_type` INTEGER NOT NULL, `item_view_layout_id` INTEGER NOT NULL, `item_view_res_name` TEXT, `item_layout_manager` TEXT, `version_code` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `list_layout_inflate_record_table` (`from_list_node` TEXT NOT NULL, `item_view_type` INTEGER NOT NULL, `layout_type` INTEGER NOT NULL, `res_id` INTEGER NOT NULL, `res_name` TEXT NOT NULL, `is_merge` INTEGER NOT NULL, `count` INTEGER NOT NULL, `root_class_name` TEXT, `item_layout_manager` TEXT, `last_update_time` INTEGER NOT NULL, `version_code` INTEGER NOT NULL, PRIMARY KEY(`from_list_node`, `item_view_type`, `res_name`, `version_code`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3f9e394d389df1834ea723a694ef9dc7')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `page_change_record_table`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `page_inflate_record_table`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `list_layout_inflate_record_table`");
                if (((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) ArgusDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                ArgusDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) ArgusDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(15);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap.put("from_page", new TableInfo.Column("from_page", "TEXT", false, 0, null, 1));
                hashMap.put("from_group_page", new TableInfo.Column("from_group_page", "TEXT", false, 0, null, 1));
                hashMap.put("to_page", new TableInfo.Column("to_page", "TEXT", false, 0, null, 1));
                hashMap.put("is_same_root", new TableInfo.Column("is_same_root", "INTEGER", true, 0, null, 1));
                hashMap.put("is_same_root_with_group", new TableInfo.Column("is_same_root_with_group", "INTEGER", true, 0, null, 1));
                hashMap.put("first_show_blocks", new TableInfo.Column("first_show_blocks", "TEXT", false, 0, null, 1));
                hashMap.put("not_first_show_blocks", new TableInfo.Column("not_first_show_blocks", "TEXT", false, 0, null, 1));
                hashMap.put("hide_blocks", new TableInfo.Column("hide_blocks", "TEXT", false, 0, null, 1));
                hashMap.put("add_blocks", new TableInfo.Column("add_blocks", "TEXT", false, 0, null, 1));
                hashMap.put("pending_blocks", new TableInfo.Column("pending_blocks", "TEXT", false, 0, null, 1));
                hashMap.put("action_info", new TableInfo.Column("action_info", "TEXT", false, 0, null, 1));
                hashMap.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                hashMap.put("stay_time", new TableInfo.Column("stay_time", "INTEGER", true, 0, null, 1));
                hashMap.put("version_code", new TableInfo.Column("version_code", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("page_change_record_table", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "page_change_record_table");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "page_change_record_table(com.tencent.richframework.argus.page.db.PageChangeRecord).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(20);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap2.put("from_page", new TableInfo.Column("from_page", "TEXT", false, 0, null, 1));
                hashMap2.put(IPreloadServiceProxy.KEY_RESID, new TableInfo.Column(IPreloadServiceProxy.KEY_RESID, "INTEGER", true, 0, null, 1));
                hashMap2.put("res_name", new TableInfo.Column("res_name", "TEXT", false, 0, null, 1));
                hashMap2.put("view_class_name", new TableInfo.Column("view_class_name", "TEXT", false, 0, null, 1));
                hashMap2.put("root_class_name", new TableInfo.Column("root_class_name", "TEXT", false, 0, null, 1));
                hashMap2.put("custom_context_class_name", new TableInfo.Column("custom_context_class_name", "TEXT", false, 0, null, 1));
                hashMap2.put("attach_root", new TableInfo.Column("attach_root", "INTEGER", true, 0, null, 1));
                hashMap2.put("is_merge", new TableInfo.Column("is_merge", "INTEGER", true, 0, null, 1));
                hashMap2.put("patch_id", new TableInfo.Column("patch_id", "INTEGER", true, 0, null, 1));
                hashMap2.put("cost_time", new TableInfo.Column("cost_time", "INTEGER", true, 0, null, 1));
                hashMap2.put("is_from_cache", new TableInfo.Column("is_from_cache", "INTEGER", true, 0, null, 1));
                hashMap2.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, 1));
                hashMap2.put("launch_stage_id", new TableInfo.Column("launch_stage_id", "INTEGER", true, 0, null, 1));
                hashMap2.put("item_view_hashcode", new TableInfo.Column("item_view_hashcode", "INTEGER", true, 0, null, 1));
                hashMap2.put("item_view_type", new TableInfo.Column("item_view_type", "INTEGER", true, 0, null, 1));
                hashMap2.put("item_view_layout_id", new TableInfo.Column("item_view_layout_id", "INTEGER", true, 0, null, 1));
                hashMap2.put("item_view_res_name", new TableInfo.Column("item_view_res_name", "TEXT", false, 0, null, 1));
                hashMap2.put("item_layout_manager", new TableInfo.Column("item_layout_manager", "TEXT", false, 0, null, 1));
                hashMap2.put("version_code", new TableInfo.Column("version_code", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("page_inflate_record_table", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "page_inflate_record_table");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "page_inflate_record_table(com.tencent.richframework.argus.page.db.PageInflateRecord).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(11);
                hashMap3.put("from_list_node", new TableInfo.Column("from_list_node", "TEXT", true, 1, null, 1));
                hashMap3.put("item_view_type", new TableInfo.Column("item_view_type", "INTEGER", true, 2, null, 1));
                hashMap3.put(ParseCommon.LAYOUT_TYPE, new TableInfo.Column(ParseCommon.LAYOUT_TYPE, "INTEGER", true, 0, null, 1));
                hashMap3.put(IPreloadServiceProxy.KEY_RESID, new TableInfo.Column(IPreloadServiceProxy.KEY_RESID, "INTEGER", true, 0, null, 1));
                hashMap3.put("res_name", new TableInfo.Column("res_name", "TEXT", true, 3, null, 1));
                hashMap3.put("is_merge", new TableInfo.Column("is_merge", "INTEGER", true, 0, null, 1));
                hashMap3.put("count", new TableInfo.Column("count", "INTEGER", true, 0, null, 1));
                hashMap3.put("root_class_name", new TableInfo.Column("root_class_name", "TEXT", false, 0, null, 1));
                hashMap3.put("item_layout_manager", new TableInfo.Column("item_layout_manager", "TEXT", false, 0, null, 1));
                hashMap3.put(DeviceProfileManager.KEY_LAST_UPDATE_TIME, new TableInfo.Column(DeviceProfileManager.KEY_LAST_UPDATE_TIME, "INTEGER", true, 0, null, 1));
                hashMap3.put("version_code", new TableInfo.Column("version_code", "INTEGER", true, 4, null, 1));
                TableInfo tableInfo3 = new TableInfo("list_layout_inflate_record_table", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "list_layout_inflate_record_table");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "list_layout_inflate_record_table(com.tencent.richframework.argus.page.db.ListLayoutInflateRecord).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }
        }, "3f9e394d389df1834ea723a694ef9dc7", "7b7e1555906ff43ce0ece1df4385fab0")).build());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // com.tencent.richframework.argus.page.db.ArgusDatabase
    public ListLayoutInflateRecordDao getListInflateDao() {
        ListLayoutInflateRecordDao listLayoutInflateRecordDao;
        if (this._listLayoutInflateRecordDao != null) {
            return this._listLayoutInflateRecordDao;
        }
        synchronized (this) {
            if (this._listLayoutInflateRecordDao == null) {
                this._listLayoutInflateRecordDao = new ListLayoutInflateRecordDao_Impl(this);
            }
            listLayoutInflateRecordDao = this._listLayoutInflateRecordDao;
        }
        return listLayoutInflateRecordDao;
    }

    @Override // com.tencent.richframework.argus.page.db.ArgusDatabase
    public InflateRecordDao getPageInflateDao() {
        InflateRecordDao inflateRecordDao;
        if (this._inflateRecordDao != null) {
            return this._inflateRecordDao;
        }
        synchronized (this) {
            if (this._inflateRecordDao == null) {
                this._inflateRecordDao = new InflateRecordDao_Impl(this);
            }
            inflateRecordDao = this._inflateRecordDao;
        }
        return inflateRecordDao;
    }

    @Override // com.tencent.richframework.argus.page.db.ArgusDatabase
    public PageChangeRecordDao getPageRecordDao() {
        PageChangeRecordDao pageChangeRecordDao;
        if (this._pageChangeRecordDao != null) {
            return this._pageChangeRecordDao;
        }
        synchronized (this) {
            if (this._pageChangeRecordDao == null) {
                this._pageChangeRecordDao = new PageChangeRecordDao_Impl(this);
            }
            pageChangeRecordDao = this._pageChangeRecordDao;
        }
        return pageChangeRecordDao;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(PageChangeRecordDao.class, PageChangeRecordDao_Impl.getRequiredConverters());
        hashMap.put(InflateRecordDao.class, InflateRecordDao_Impl.getRequiredConverters());
        hashMap.put(ListLayoutInflateRecordDao.class, ListLayoutInflateRecordDao_Impl.getRequiredConverters());
        return hashMap;
    }
}
