package com.tencent.richframework.argus.page.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.tencent.richframework.argus.node.NodePO;
import java.util.List;

/* compiled from: P */
@Dao
/* loaded from: classes25.dex */
public interface ListLayoutInflateRecordDao {
    @Query("DELETE FROM list_layout_inflate_record_table")
    void deleteAll();

    @Query("SELECT item_view_type, layout_type, res_name, res_id, is_merge, count, root_class_name, item_layout_manager, last_update_time, root_class_name, item_layout_manager FROM list_layout_inflate_record_table WHERE version_code = :versionCode AND from_list_node = :fromListPage")
    List<ListHistoryInflateRecord> getALlListLayoutInflateRecord(int i3, NodePO nodePO);

    @Insert(onConflict = 1)
    void insertAll(List<ListLayoutInflateRecord> list);
}
