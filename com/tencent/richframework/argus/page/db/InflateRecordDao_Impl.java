package com.tencent.richframework.argus.page.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.converter.ArgusNodeInfoTypeConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class InflateRecordDao_Impl implements InflateRecordDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PageInflateRecord> __insertionAdapterOfPageInflateRecord;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecordsOlderThan;

    public InflateRecordDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPageInflateRecord = new EntityInsertionAdapter<PageInflateRecord>(roomDatabase) { // from class: com.tencent.richframework.argus.page.db.InflateRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `page_inflate_record_table` (`id`,`from_page`,`res_id`,`res_name`,`view_class_name`,`root_class_name`,`custom_context_class_name`,`attach_root`,`is_merge`,`patch_id`,`cost_time`,`is_from_cache`,`time`,`launch_stage_id`,`item_view_hashcode`,`item_view_type`,`item_view_layout_id`,`item_view_res_name`,`item_layout_manager`,`version_code`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PageInflateRecord pageInflateRecord) {
                supportSQLiteStatement.bindLong(1, pageInflateRecord.f365100id);
                String blockInfoToString = ArgusNodeInfoTypeConverter.blockInfoToString(pageInflateRecord.fromPage);
                if (blockInfoToString == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, blockInfoToString);
                }
                supportSQLiteStatement.bindLong(3, pageInflateRecord.resId);
                String str = pageInflateRecord.resName;
                if (str == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, str);
                }
                String str2 = pageInflateRecord.viewClassName;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, str2);
                }
                String str3 = pageInflateRecord.rootClassName;
                if (str3 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, str3);
                }
                String str4 = pageInflateRecord.customContextClassName;
                if (str4 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, str4);
                }
                supportSQLiteStatement.bindLong(8, pageInflateRecord.attachRoot);
                supportSQLiteStatement.bindLong(9, pageInflateRecord.isMerge);
                supportSQLiteStatement.bindLong(10, pageInflateRecord.patchId);
                supportSQLiteStatement.bindLong(11, pageInflateRecord.costTime);
                supportSQLiteStatement.bindLong(12, pageInflateRecord.isFromCache);
                supportSQLiteStatement.bindLong(13, pageInflateRecord.time);
                supportSQLiteStatement.bindLong(14, pageInflateRecord.launchStageId);
                supportSQLiteStatement.bindLong(15, pageInflateRecord.itemViewHashcode);
                supportSQLiteStatement.bindLong(16, pageInflateRecord.itemViewType);
                supportSQLiteStatement.bindLong(17, pageInflateRecord.itemViewLayoutId);
                String str5 = pageInflateRecord.itemViewResName;
                if (str5 == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, str5);
                }
                String str6 = pageInflateRecord.recyclerViewLayoutManager;
                if (str6 == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, str6);
                }
                supportSQLiteStatement.bindLong(20, pageInflateRecord.versionCode);
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.tencent.richframework.argus.page.db.InflateRecordDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM page_inflate_record_table";
            }
        };
        this.__preparedStmtOfDeleteRecordsOlderThan = new SharedSQLiteStatement(roomDatabase) { // from class: com.tencent.richframework.argus.page.db.InflateRecordDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM page_inflate_record_table WHERE time < ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.tencent.richframework.argus.page.db.InflateRecordDao
    public void deleteRecordsOlderThan(long j3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteRecordsOlderThan.acquire();
        acquire.bindLong(1, j3);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteRecordsOlderThan.release(acquire);
        }
    }

    @Override // com.tencent.richframework.argus.page.db.InflateRecordDao
    public List<HistoryInflateRecord> getInflateCountAfterTime(int i3, NodePO nodePO, long j3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT is_from_cache AS isFromCache, launch_stage_id AS launchStageId, res_name AS resName, res_id AS resId, view_class_name AS viewClassName, patch_id AS patchId, time, COUNT(*) AS count, custom_context_class_name AS customContextName, item_view_res_name AS itemViewResName, item_view_type AS itemViewType, item_view_hashcode AS itemViewHashcode, root_class_name AS rootClassName, item_layout_manager AS itemLayoutManager, attach_root AS attachRoot, AVG(cost_time) AS avgCostTime FROM page_inflate_record_table WHERE version_code = ? AND from_page = ? AND time > ? GROUP BY res_name, view_class_name, root_class_name, attach_root, patch_id, launch_stage_id ORDER BY time DESC", 3);
        acquire.bindLong(1, i3);
        String blockInfoToString = ArgusNodeInfoTypeConverter.blockInfoToString(nodePO);
        if (blockInfoToString == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, blockInfoToString);
        }
        acquire.bindLong(3, j3);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                HistoryInflateRecord historyInflateRecord = new HistoryInflateRecord();
                historyInflateRecord.isFromCache = query.getInt(0);
                historyInflateRecord.launchStageId = query.getInt(1);
                if (query.isNull(2)) {
                    historyInflateRecord.resName = null;
                } else {
                    historyInflateRecord.resName = query.getString(2);
                }
                historyInflateRecord.resId = query.getInt(3);
                if (query.isNull(4)) {
                    historyInflateRecord.viewClassName = null;
                } else {
                    historyInflateRecord.viewClassName = query.getString(4);
                }
                historyInflateRecord.patchId = query.getInt(5);
                historyInflateRecord.time = query.getLong(6);
                historyInflateRecord.count = query.getInt(7);
                if (query.isNull(8)) {
                    historyInflateRecord.customContextName = null;
                } else {
                    historyInflateRecord.customContextName = query.getString(8);
                }
                if (query.isNull(9)) {
                    historyInflateRecord.itemViewResName = null;
                } else {
                    historyInflateRecord.itemViewResName = query.getString(9);
                }
                historyInflateRecord.itemViewType = query.getInt(10);
                historyInflateRecord.itemViewHashcode = query.getInt(11);
                if (query.isNull(12)) {
                    historyInflateRecord.rootClassName = null;
                } else {
                    historyInflateRecord.rootClassName = query.getString(12);
                }
                if (query.isNull(13)) {
                    historyInflateRecord.itemLayoutManager = null;
                } else {
                    historyInflateRecord.itemLayoutManager = query.getString(13);
                }
                historyInflateRecord.attachRoot = query.getInt(14);
                historyInflateRecord.avgCostTime = query.getLong(15);
                arrayList.add(historyInflateRecord);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.richframework.argus.page.db.InflateRecordDao
    public List<HistoryInflateRecord> getInflateCountAfterTimeForLaunch(int i3, long j3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT is_from_cache AS isFromCache, launch_stage_id AS launchStageId, res_name AS resName, res_id AS resId, view_class_name AS viewClassName, patch_id AS patchId, time, COUNT(*) AS count, custom_context_class_name AS customContextName, item_view_res_name AS itemViewResName, item_view_type AS itemViewType, item_view_hashcode AS itemViewHashcode, root_class_name AS rootClassName, item_layout_manager AS itemLayoutManager, attach_root AS attachRoot, AVG(cost_time) AS avgCostTime FROM page_inflate_record_table WHERE version_code = ? AND launch_stage_id > 0 AND time > ? GROUP BY res_name, view_class_name, root_class_name, attach_root, patch_id, launch_stage_id ORDER BY time DESC", 2);
        acquire.bindLong(1, i3);
        acquire.bindLong(2, j3);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                HistoryInflateRecord historyInflateRecord = new HistoryInflateRecord();
                historyInflateRecord.isFromCache = query.getInt(0);
                historyInflateRecord.launchStageId = query.getInt(1);
                if (query.isNull(2)) {
                    historyInflateRecord.resName = null;
                } else {
                    historyInflateRecord.resName = query.getString(2);
                }
                historyInflateRecord.resId = query.getInt(3);
                if (query.isNull(4)) {
                    historyInflateRecord.viewClassName = null;
                } else {
                    historyInflateRecord.viewClassName = query.getString(4);
                }
                historyInflateRecord.patchId = query.getInt(5);
                historyInflateRecord.time = query.getLong(6);
                historyInflateRecord.count = query.getInt(7);
                if (query.isNull(8)) {
                    historyInflateRecord.customContextName = null;
                } else {
                    historyInflateRecord.customContextName = query.getString(8);
                }
                if (query.isNull(9)) {
                    historyInflateRecord.itemViewResName = null;
                } else {
                    historyInflateRecord.itemViewResName = query.getString(9);
                }
                historyInflateRecord.itemViewType = query.getInt(10);
                historyInflateRecord.itemViewHashcode = query.getInt(11);
                if (query.isNull(12)) {
                    historyInflateRecord.rootClassName = null;
                } else {
                    historyInflateRecord.rootClassName = query.getString(12);
                }
                if (query.isNull(13)) {
                    historyInflateRecord.itemLayoutManager = null;
                } else {
                    historyInflateRecord.itemLayoutManager = query.getString(13);
                }
                historyInflateRecord.attachRoot = query.getInt(14);
                historyInflateRecord.avgCostTime = query.getLong(15);
                arrayList.add(historyInflateRecord);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.richframework.argus.page.db.InflateRecordDao
    public List<HistoryInflateRecord> getInflateCountAfterTimeWithListPage(int i3, NodePO nodePO, long j3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT is_from_cache AS isFromCache, launch_stage_id AS launchStageId, res_name AS resName, res_id AS resId, view_class_name AS viewClassName, patch_id AS patchId, time, COUNT(*) AS count, custom_context_class_name AS customContextName, item_view_res_name AS itemViewResName, item_view_type AS itemViewType, item_view_hashcode AS itemViewHashcode, root_class_name AS rootClassName, item_layout_manager AS itemLayoutManager, attach_root AS attachRoot, AVG(cost_time) AS avgCostTime FROM page_inflate_record_table WHERE version_code = ? AND from_page = ? AND time > ? GROUP BY res_name, view_class_name, root_class_name, attach_root, item_view_hashcode, patch_id, launch_stage_id ORDER BY time DESC LIMIT 1000", 3);
        acquire.bindLong(1, i3);
        String blockInfoToString = ArgusNodeInfoTypeConverter.blockInfoToString(nodePO);
        if (blockInfoToString == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, blockInfoToString);
        }
        acquire.bindLong(3, j3);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                HistoryInflateRecord historyInflateRecord = new HistoryInflateRecord();
                historyInflateRecord.isFromCache = query.getInt(0);
                historyInflateRecord.launchStageId = query.getInt(1);
                if (query.isNull(2)) {
                    historyInflateRecord.resName = null;
                } else {
                    historyInflateRecord.resName = query.getString(2);
                }
                historyInflateRecord.resId = query.getInt(3);
                if (query.isNull(4)) {
                    historyInflateRecord.viewClassName = null;
                } else {
                    historyInflateRecord.viewClassName = query.getString(4);
                }
                historyInflateRecord.patchId = query.getInt(5);
                historyInflateRecord.time = query.getLong(6);
                historyInflateRecord.count = query.getInt(7);
                if (query.isNull(8)) {
                    historyInflateRecord.customContextName = null;
                } else {
                    historyInflateRecord.customContextName = query.getString(8);
                }
                if (query.isNull(9)) {
                    historyInflateRecord.itemViewResName = null;
                } else {
                    historyInflateRecord.itemViewResName = query.getString(9);
                }
                historyInflateRecord.itemViewType = query.getInt(10);
                historyInflateRecord.itemViewHashcode = query.getInt(11);
                if (query.isNull(12)) {
                    historyInflateRecord.rootClassName = null;
                } else {
                    historyInflateRecord.rootClassName = query.getString(12);
                }
                if (query.isNull(13)) {
                    historyInflateRecord.itemLayoutManager = null;
                } else {
                    historyInflateRecord.itemLayoutManager = query.getString(13);
                }
                historyInflateRecord.attachRoot = query.getInt(14);
                historyInflateRecord.avgCostTime = query.getLong(15);
                arrayList.add(historyInflateRecord);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.richframework.argus.page.db.InflateRecordDao
    public void insert(PageInflateRecord pageInflateRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPageInflateRecord.insert((EntityInsertionAdapter<PageInflateRecord>) pageInflateRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.tencent.richframework.argus.page.db.InflateRecordDao
    public void insertAll(List<PageInflateRecord> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPageInflateRecord.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
