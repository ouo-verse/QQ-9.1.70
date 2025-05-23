package com.tencent.richframework.argus.page.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.tencent.richframework.argus.node.NodePO;
import java.util.List;

/* compiled from: P */
@Dao
/* loaded from: classes25.dex */
public interface InflateRecordDao {
    @Query("DELETE FROM page_inflate_record_table WHERE time < :fromTime")
    void deleteRecordsOlderThan(long j3);

    @Query("SELECT is_from_cache AS isFromCache, launch_stage_id AS launchStageId, res_name AS resName, res_id AS resId, view_class_name AS viewClassName, patch_id AS patchId, time, COUNT(*) AS count, custom_context_class_name AS customContextName, item_view_res_name AS itemViewResName, item_view_type AS itemViewType, item_view_hashcode AS itemViewHashcode, root_class_name AS rootClassName, item_layout_manager AS itemLayoutManager, attach_root AS attachRoot, AVG(cost_time) AS avgCostTime FROM page_inflate_record_table WHERE version_code = :versionCode AND from_page = :fromPage AND time > :startTime GROUP BY res_name, view_class_name, root_class_name, attach_root, patch_id, launch_stage_id ORDER BY time DESC")
    List<HistoryInflateRecord> getInflateCountAfterTime(int i3, NodePO nodePO, long j3);

    @Query("SELECT is_from_cache AS isFromCache, launch_stage_id AS launchStageId, res_name AS resName, res_id AS resId, view_class_name AS viewClassName, patch_id AS patchId, time, COUNT(*) AS count, custom_context_class_name AS customContextName, item_view_res_name AS itemViewResName, item_view_type AS itemViewType, item_view_hashcode AS itemViewHashcode, root_class_name AS rootClassName, item_layout_manager AS itemLayoutManager, attach_root AS attachRoot, AVG(cost_time) AS avgCostTime FROM page_inflate_record_table WHERE version_code = :versionCode AND launch_stage_id > 0 AND time > :startTime GROUP BY res_name, view_class_name, root_class_name, attach_root, patch_id, launch_stage_id ORDER BY time DESC")
    List<HistoryInflateRecord> getInflateCountAfterTimeForLaunch(int i3, long j3);

    @Query("SELECT is_from_cache AS isFromCache, launch_stage_id AS launchStageId, res_name AS resName, res_id AS resId, view_class_name AS viewClassName, patch_id AS patchId, time, COUNT(*) AS count, custom_context_class_name AS customContextName, item_view_res_name AS itemViewResName, item_view_type AS itemViewType, item_view_hashcode AS itemViewHashcode, root_class_name AS rootClassName, item_layout_manager AS itemLayoutManager, attach_root AS attachRoot, AVG(cost_time) AS avgCostTime FROM page_inflate_record_table WHERE version_code = :versionCode AND from_page = :listViewPage AND time > :startTime GROUP BY res_name, view_class_name, root_class_name, attach_root, item_view_hashcode, patch_id, launch_stage_id ORDER BY time DESC LIMIT 1000")
    List<HistoryInflateRecord> getInflateCountAfterTimeWithListPage(int i3, NodePO nodePO, long j3);

    @Insert(onConflict = 1)
    void insert(PageInflateRecord pageInflateRecord);

    @Insert(onConflict = 1)
    void insertAll(List<PageInflateRecord> list);
}
