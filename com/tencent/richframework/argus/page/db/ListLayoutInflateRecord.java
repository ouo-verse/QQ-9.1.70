package com.tencent.richframework.argus.page.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.TypeConverters;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.util.RFWAppUtil;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.converter.ArgusNodeInfoTypeConverter;

/* compiled from: P */
@TypeConverters({ArgusNodeInfoTypeConverter.class})
@Entity(primaryKeys = {"from_list_node", "item_view_type", "res_name", "version_code"}, tableName = "list_layout_inflate_record_table")
/* loaded from: classes25.dex */
public class ListLayoutInflateRecord {
    public int count;

    @NonNull
    @ColumnInfo(name = "from_list_node")
    public NodePO fromListNode;

    @ColumnInfo(name = "is_merge")
    public int isMerge;

    @ColumnInfo(name = "item_layout_manager")
    public String itemLayoutManager;

    @NonNull
    @ColumnInfo(name = "item_view_type")
    public int itemViewType;

    @ColumnInfo(name = ParseCommon.LAYOUT_TYPE)
    public int layoutType;

    @ColumnInfo(name = IPreloadServiceProxy.KEY_RESID)
    public int resId;

    @NonNull
    @ColumnInfo(name = "res_name")
    public String resName;

    @ColumnInfo(name = "root_class_name")
    public String rootClassName;

    @ColumnInfo(name = DeviceProfileManager.KEY_LAST_UPDATE_TIME)
    public long lastUpdateTime = System.currentTimeMillis();

    @ColumnInfo(name = "version_code")
    public int versionCode = RFWAppUtil.INSTANCE.getVersionCode();
}
