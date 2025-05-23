package com.tencent.richframework.argus.page.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.tencent.richframework.argus.page.PageInfoPO;
import java.util.List;

@Dao
/* loaded from: classes25.dex */
public interface PageChangeRecordDao {
    @Query("DELETE FROM page_change_record_table WHERE time < :fromTime")
    void deleteRecordsOlderThan(long j3);

    @Query("SELECT to_page AS toPage, action_info AS actionInfo, first_show_blocks AS firstShowBlocks, add_blocks AS addBlocks, is_same_root_with_group AS isSameRootWithGroup, COUNT(*) AS count FROM page_change_record_table WHERE version_code = :versionCode AND from_group_page = :fromPage AND time > :startTime GROUP BY to_page, add_blocks, first_show_blocks")
    List<HistoryPageChange> getPageCountAfterTime(int i3, PageInfoPO pageInfoPO, long j3);

    @Insert(onConflict = 1)
    void insert(PageChangeRecord pageChangeRecord);

    @Insert(onConflict = 1)
    void insertAll(List<PageChangeRecord> list);
}
