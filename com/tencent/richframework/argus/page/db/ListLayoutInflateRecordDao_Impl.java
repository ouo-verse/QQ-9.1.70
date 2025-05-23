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
public final class ListLayoutInflateRecordDao_Impl implements ListLayoutInflateRecordDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ListLayoutInflateRecord> __insertionAdapterOfListLayoutInflateRecord;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public ListLayoutInflateRecordDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfListLayoutInflateRecord = new EntityInsertionAdapter<ListLayoutInflateRecord>(roomDatabase) { // from class: com.tencent.richframework.argus.page.db.ListLayoutInflateRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `list_layout_inflate_record_table` (`from_list_node`,`item_view_type`,`layout_type`,`res_id`,`res_name`,`is_merge`,`count`,`root_class_name`,`item_layout_manager`,`last_update_time`,`version_code`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ListLayoutInflateRecord listLayoutInflateRecord) {
                String blockInfoToString = ArgusNodeInfoTypeConverter.blockInfoToString(listLayoutInflateRecord.fromListNode);
                if (blockInfoToString == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, blockInfoToString);
                }
                supportSQLiteStatement.bindLong(2, listLayoutInflateRecord.itemViewType);
                supportSQLiteStatement.bindLong(3, listLayoutInflateRecord.layoutType);
                supportSQLiteStatement.bindLong(4, listLayoutInflateRecord.resId);
                String str = listLayoutInflateRecord.resName;
                if (str == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, str);
                }
                supportSQLiteStatement.bindLong(6, listLayoutInflateRecord.isMerge);
                supportSQLiteStatement.bindLong(7, listLayoutInflateRecord.count);
                String str2 = listLayoutInflateRecord.rootClassName;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, str2);
                }
                String str3 = listLayoutInflateRecord.itemLayoutManager;
                if (str3 == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, str3);
                }
                supportSQLiteStatement.bindLong(10, listLayoutInflateRecord.lastUpdateTime);
                supportSQLiteStatement.bindLong(11, listLayoutInflateRecord.versionCode);
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.tencent.richframework.argus.page.db.ListLayoutInflateRecordDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM list_layout_inflate_record_table";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.tencent.richframework.argus.page.db.ListLayoutInflateRecordDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    @Override // com.tencent.richframework.argus.page.db.ListLayoutInflateRecordDao
    public List<ListHistoryInflateRecord> getALlListLayoutInflateRecord(int i3, NodePO nodePO) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT item_view_type, layout_type, res_name, res_id, is_merge, count, root_class_name, item_layout_manager, last_update_time, root_class_name, item_layout_manager FROM list_layout_inflate_record_table WHERE version_code = ? AND from_list_node = ?", 2);
        acquire.bindLong(1, i3);
        String blockInfoToString = ArgusNodeInfoTypeConverter.blockInfoToString(nodePO);
        if (blockInfoToString == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, blockInfoToString);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ListHistoryInflateRecord listHistoryInflateRecord = new ListHistoryInflateRecord();
                listHistoryInflateRecord.item_view_type = query.getInt(0);
                listHistoryInflateRecord.layout_type = query.getInt(1);
                if (query.isNull(2)) {
                    listHistoryInflateRecord.res_name = null;
                } else {
                    listHistoryInflateRecord.res_name = query.getString(2);
                }
                listHistoryInflateRecord.res_id = query.getInt(3);
                listHistoryInflateRecord.is_merge = query.getInt(4);
                listHistoryInflateRecord.count = query.getInt(5);
                if (query.isNull(6)) {
                    listHistoryInflateRecord.root_class_name = null;
                } else {
                    listHistoryInflateRecord.root_class_name = query.getString(6);
                }
                if (query.isNull(7)) {
                    listHistoryInflateRecord.item_layout_manager = null;
                } else {
                    listHistoryInflateRecord.item_layout_manager = query.getString(7);
                }
                listHistoryInflateRecord.last_update_time = query.getLong(8);
                if (query.isNull(6)) {
                    listHistoryInflateRecord.root_class_name = null;
                } else {
                    listHistoryInflateRecord.root_class_name = query.getString(6);
                }
                if (query.isNull(7)) {
                    listHistoryInflateRecord.item_layout_manager = null;
                } else {
                    listHistoryInflateRecord.item_layout_manager = query.getString(7);
                }
                arrayList.add(listHistoryInflateRecord);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.richframework.argus.page.db.ListLayoutInflateRecordDao
    public void insertAll(List<ListLayoutInflateRecord> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfListLayoutInflateRecord.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
