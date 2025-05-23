package com.tencent.richframework.argus.page.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.converter.ArgusNodeInfoTypeConverter;
import com.tencent.richframework.argus.page.converter.PageInfoTypeConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes25.dex */
public final class PageChangeRecordDao_Impl implements PageChangeRecordDao {
    private final ArgusNodeInfoTypeConverter __argusNodeInfoTypeConverter = new ArgusNodeInfoTypeConverter();
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PageChangeRecord> __insertionAdapterOfPageChangeRecord;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecordsOlderThan;

    public PageChangeRecordDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPageChangeRecord = new EntityInsertionAdapter<PageChangeRecord>(roomDatabase) { // from class: com.tencent.richframework.argus.page.db.PageChangeRecordDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `page_change_record_table` (`id`,`from_page`,`from_group_page`,`to_page`,`is_same_root`,`is_same_root_with_group`,`first_show_blocks`,`not_first_show_blocks`,`hide_blocks`,`add_blocks`,`pending_blocks`,`action_info`,`time`,`stay_time`,`version_code`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PageChangeRecord pageChangeRecord) {
                supportSQLiteStatement.bindLong(1, pageChangeRecord.f365099id);
                PageInfoTypeConverter pageInfoTypeConverter = PageInfoTypeConverter.INSTANCE;
                String pageInfoToString = pageInfoTypeConverter.pageInfoToString(pageChangeRecord.fromPage);
                if (pageInfoToString == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, pageInfoToString);
                }
                String pageInfoToString2 = pageInfoTypeConverter.pageInfoToString(pageChangeRecord.fromGroupPage);
                if (pageInfoToString2 == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, pageInfoToString2);
                }
                String pageInfoToString3 = pageInfoTypeConverter.pageInfoToString(pageChangeRecord.toPage);
                if (pageInfoToString3 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, pageInfoToString3);
                }
                supportSQLiteStatement.bindLong(5, pageChangeRecord.isSameRoot);
                supportSQLiteStatement.bindLong(6, pageChangeRecord.isSameRootWithGroup);
                String converter = PageChangeRecordDao_Impl.this.__argusNodeInfoTypeConverter.converter(pageChangeRecord.firstShowBlocks);
                if (converter == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, converter);
                }
                String converter2 = PageChangeRecordDao_Impl.this.__argusNodeInfoTypeConverter.converter(pageChangeRecord.notFirstShowBlocks);
                if (converter2 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, converter2);
                }
                String converter3 = PageChangeRecordDao_Impl.this.__argusNodeInfoTypeConverter.converter(pageChangeRecord.hideBlocks);
                if (converter3 == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, converter3);
                }
                String converter4 = PageChangeRecordDao_Impl.this.__argusNodeInfoTypeConverter.converter(pageChangeRecord.addBlocks);
                if (converter4 == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, converter4);
                }
                String converter5 = PageChangeRecordDao_Impl.this.__argusNodeInfoTypeConverter.converter(pageChangeRecord.pendingBlocks);
                if (converter5 == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, converter5);
                }
                String str = pageChangeRecord.actionInfo;
                if (str == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, str);
                }
                supportSQLiteStatement.bindLong(13, pageChangeRecord.time);
                supportSQLiteStatement.bindLong(14, pageChangeRecord.stayTime);
                supportSQLiteStatement.bindLong(15, pageChangeRecord.versionCode);
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.tencent.richframework.argus.page.db.PageChangeRecordDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM page_change_record_table";
            }
        };
        this.__preparedStmtOfDeleteRecordsOlderThan = new SharedSQLiteStatement(roomDatabase) { // from class: com.tencent.richframework.argus.page.db.PageChangeRecordDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM page_change_record_table WHERE time < ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.tencent.richframework.argus.page.db.PageChangeRecordDao
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

    @Override // com.tencent.richframework.argus.page.db.PageChangeRecordDao
    public List<HistoryPageChange> getPageCountAfterTime(int i3, PageInfoPO pageInfoPO, long j3) {
        String string;
        String string2;
        String string3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT to_page AS toPage, action_info AS actionInfo, first_show_blocks AS firstShowBlocks, add_blocks AS addBlocks, is_same_root_with_group AS isSameRootWithGroup, COUNT(*) AS count FROM page_change_record_table WHERE version_code = ? AND from_group_page = ? AND time > ? GROUP BY to_page, add_blocks, first_show_blocks", 3);
        acquire.bindLong(1, i3);
        String pageInfoToString = PageInfoTypeConverter.INSTANCE.pageInfoToString(pageInfoPO);
        if (pageInfoToString == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, pageInfoToString);
        }
        acquire.bindLong(3, j3);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                HistoryPageChange historyPageChange = new HistoryPageChange();
                if (query.isNull(0)) {
                    string = null;
                } else {
                    string = query.getString(0);
                }
                historyPageChange.toPage = PageInfoTypeConverter.INSTANCE.fromString(string);
                if (query.isNull(1)) {
                    historyPageChange.actionInfo = null;
                } else {
                    historyPageChange.actionInfo = query.getString(1);
                }
                if (query.isNull(2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(2);
                }
                historyPageChange.firstShowBlocks = this.__argusNodeInfoTypeConverter.revert(string2);
                if (query.isNull(3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(3);
                }
                historyPageChange.addBlocks = this.__argusNodeInfoTypeConverter.revert(string3);
                historyPageChange.isSameRootWithGroup = query.getInt(4);
                historyPageChange.count = query.getInt(5);
                arrayList.add(historyPageChange);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.richframework.argus.page.db.PageChangeRecordDao
    public void insert(PageChangeRecord pageChangeRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPageChangeRecord.insert((EntityInsertionAdapter<PageChangeRecord>) pageChangeRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.tencent.richframework.argus.page.db.PageChangeRecordDao
    public void insertAll(List<PageChangeRecord> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPageChangeRecord.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
