package com.tencent.richframework.argus.page.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.tencent.biz.richframework.util.RFWAppUtil;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.converter.PageInfoTypeConverter;

@TypeConverters({PageInfoTypeConverter.class})
@Entity(tableName = "page_inflate_record_table")
/* loaded from: classes25.dex */
public class PageInflateRecord {

    @ColumnInfo(name = "attach_root")
    public int attachRoot;

    @ColumnInfo(name = "cost_time")
    public long costTime;

    @ColumnInfo(name = "custom_context_class_name")
    public String customContextClassName;

    @ColumnInfo(name = "from_page")
    public NodePO fromPage;

    /* renamed from: id, reason: collision with root package name */
    @PrimaryKey(autoGenerate = true)
    public long f365100id;

    @ColumnInfo(name = "is_from_cache")
    public int isFromCache;

    @ColumnInfo(name = "is_merge")
    public int isMerge;

    @ColumnInfo(name = "item_view_hashcode")
    public int itemViewHashcode;

    @ColumnInfo(name = "item_view_layout_id")
    public int itemViewLayoutId;

    @ColumnInfo(name = "item_view_res_name")
    public String itemViewResName;

    @ColumnInfo(name = "item_view_type")
    public int itemViewType;

    @ColumnInfo(name = "launch_stage_id")
    public int launchStageId;

    @ColumnInfo(name = "patch_id")
    public int patchId;

    @ColumnInfo(name = IPreloadServiceProxy.KEY_RESID)
    public int resId;

    @ColumnInfo(name = "res_name")
    public String resName;

    @ColumnInfo(name = "root_class_name")
    public String rootClassName;
    public long time;

    @ColumnInfo(name = "view_class_name")
    public String viewClassName;

    @ColumnInfo(name = "item_layout_manager")
    public String recyclerViewLayoutManager = "";

    @ColumnInfo(name = "version_code")
    public int versionCode = RFWAppUtil.INSTANCE.getVersionCode();
}
