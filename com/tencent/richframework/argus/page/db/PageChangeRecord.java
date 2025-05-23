package com.tencent.richframework.argus.page.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.tencent.biz.richframework.util.RFWAppUtil;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.converter.ArgusNodeInfoTypeConverter;
import com.tencent.richframework.argus.page.converter.PageInfoTypeConverter;
import java.util.List;

@TypeConverters({PageInfoTypeConverter.class, ArgusNodeInfoTypeConverter.class})
@Entity(tableName = "page_change_record_table")
/* loaded from: classes25.dex */
public class PageChangeRecord {

    @ColumnInfo(name = "action_info")
    public String actionInfo;

    @ColumnInfo(name = "add_blocks")
    public List<NodePO> addBlocks;

    @ColumnInfo(name = "first_show_blocks")
    public List<NodePO> firstShowBlocks;

    @ColumnInfo(name = "from_group_page")
    public PageInfoPO fromGroupPage;

    @ColumnInfo(name = "from_page")
    public PageInfoPO fromPage;

    @ColumnInfo(name = "hide_blocks")
    public List<NodePO> hideBlocks;

    /* renamed from: id, reason: collision with root package name */
    @PrimaryKey(autoGenerate = true)
    public int f365099id;

    @ColumnInfo(name = "is_same_root")
    public int isSameRoot;

    @ColumnInfo(name = "is_same_root_with_group")
    public int isSameRootWithGroup;

    @ColumnInfo(name = "not_first_show_blocks")
    public List<NodePO> notFirstShowBlocks;

    @ColumnInfo(name = "pending_blocks")
    public List<NodePO> pendingBlocks;

    @ColumnInfo(name = "stay_time")
    public long stayTime;
    public long time;

    @ColumnInfo(name = "to_page")
    public PageInfoPO toPage;

    @ColumnInfo(name = "version_code")
    public int versionCode = RFWAppUtil.INSTANCE.getVersionCode();
}
