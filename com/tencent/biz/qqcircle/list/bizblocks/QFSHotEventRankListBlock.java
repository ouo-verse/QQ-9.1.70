package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.HotEventInfoKt;
import com.tencent.biz.qqcircle.beans.QCircleHotEventRankInitBean;
import com.tencent.biz.qqcircle.immersive.views.QFSHotEventRankItemView;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetHotEventRankListRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StHotTagInfo;
import feedcloud.FeedCloudRead$GetHotTagRankPageRsp;
import feedcloud.FeedCloudRead$HotTagRankItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B\u000f\u0012\u0006\u00104\u001a\u00020\r\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0014J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001cH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\nH\u0016J\u001a\u0010(\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u001aH\u0016J\u0012\u0010*\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010%H\u0016J\"\u0010.\u001a\u00020\u000f2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u00100\u001a\u0004\u0018\u00010%2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u00102\u001a\u0004\u0018\u00010\n2\b\u00101\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u00103\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u00069"}, d2 = {"Lcom/tencent/biz/qqcircle/list/bizblocks/QFSHotEventRankListBlock;", "Lcom/tencent/biz/qqcircle/list/QCircleBaseListBlock;", "Lfeedcloud/FeedCloudRead$HotTagRankItem;", "Lfeedcloud/FeedCloudRead$GetHotTagRankPageRsp;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "", "getDaTongPageId", "getPageId", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "holder", "position", "onBindViewHolder", "getViewTypeCount", "getLogTag", "lastAttachInfo", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "getRequest", "rsp", "", "p1", "", "getListDataFromRsp", "getAttachInfoFromRsp", "getIsFinishFromRsp", "getPageCount", "Lcom/tencent/biz/richframework/part/Part;", "getCustomParts", "getEmptyHint", "getTitle", "Landroid/view/View;", "view", "isSelected", "onTitleTabSelectedChanged", "titleContainer", "initTitleBar", "Lcom/tencent/richframework/data/idata/IDataCallBack;", "callback", ReportConstant.COSTREPORT_PREFIX, "getListDataAsync", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "getTitleTabView", "p0", "getAttachInfoFromItemData", "getDropFrameMonitorTag", "initBean", "<init>", "(Landroid/os/Bundle;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSHotEventRankListBlock extends QCircleBaseListBlock<FeedCloudRead$HotTagRankItem, FeedCloudRead$GetHotTagRankPageRsp> {
    private static final int PAGE_COUNT = 10;

    @NotNull
    private static final String TAG = "QFSHotEventRankListBlock";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSHotEventRankListBlock(@NotNull Bundle initBean) {
        super(initBean);
        Intrinsics.checkNotNullParameter(initBean, "initBean");
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @Nullable
    public String getAttachInfoFromItemData(@Nullable FeedCloudRead$HotTagRankItem p06) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public List<Part> getCustomParts() {
        return new ArrayList();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_HOT_LIST_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @Nullable
    public String getDropFrameMonitorTag() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getEmptyHint() {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f182993hz);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qcircle_empty_data_tips)");
        return a16;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getPageCount() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public int getPageId() {
        return 302;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getTitle() {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f183553jh);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qcircle_hot_event_rank_title)");
        return a16;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @Nullable
    public View getTitleTabView(@Nullable ViewGroup rootView) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        BaseListBlock.BaseListVH baseListVH;
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<E> list = this.mDataList;
        if (list != 0) {
            if (holder instanceof BaseListBlock.BaseListVH) {
                baseListVH = (BaseListBlock.BaseListVH) holder;
            } else {
                baseListVH = null;
            }
            if (baseListVH != null) {
                baseListVH.setData(list.get(position), position, this.mExtraTypeInfo);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new BaseListBlock.BaseListVH(new QFSHotEventRankItemView(context, null, 2, 0 == true ? 1 : 0));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
        QCircleFullScreenStatusView qCircleFullScreenStatusView;
        super.onInitBlock(initParams);
        IStatusViewProvider statusInterface = getHostFragment().sh().getStatusInterface();
        if (statusInterface instanceof QCircleFullScreenStatusView) {
            qCircleFullScreenStatusView = (QCircleFullScreenStatusView) statusInterface;
        } else {
            qCircleFullScreenStatusView = null;
        }
        if (qCircleFullScreenStatusView != null) {
            qCircleFullScreenStatusView.setEmptyImageAndText(5, uq3.c.n3(), getContext().getString(R.string.f183003i0));
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public String getAttachInfoFromRsp(@Nullable FeedCloudRead$GetHotTagRankPageRsp rsp) {
        PBStringField pBStringField;
        String str = (rsp == null || (pBStringField = rsp.feedAttachInfo) == null) ? null : pBStringField.get();
        return str == null ? "" : str;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(@Nullable FeedCloudRead$GetHotTagRankPageRsp rsp) {
        PBUInt32Field pBUInt32Field;
        return (rsp == null || (pBUInt32Field = rsp.isFinish) == null || pBUInt32Field.get() != 1) ? false : true;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public List<FeedCloudRead$HotTagRankItem> getListDataFromRsp(@Nullable FeedCloudRead$GetHotTagRankPageRsp rsp, boolean p16) {
        PBRepeatMessageField<FeedCloudRead$HotTagRankItem> pBRepeatMessageField;
        List<FeedCloudRead$HotTagRankItem> list = (rsp == null || (pBRepeatMessageField = rsp.items) == null) ? null : pBRepeatMessageField.get();
        return list == null ? new ArrayList() : list;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    @NotNull
    public BaseRequest getRequest(@Nullable String lastAttachInfo) {
        Serializable serializable = this.mInitBean;
        QCircleHotEventRankInitBean qCircleHotEventRankInitBean = serializable instanceof QCircleHotEventRankInitBean ? (QCircleHotEventRankInitBean) serializable : null;
        if (qCircleHotEventRankInitBean == null) {
            QLog.e(TAG, 1, "QFSHotEventRankListBlock initBean is null");
            qCircleHotEventRankInitBean = new QCircleHotEventRankInitBean(HotEventInfoKt.toHotEventInfo(new FeedCloudMeta$StHotTagInfo()));
        }
        return new QCircleGetHotEventRankListRequest(lastAttachInfo, qCircleHotEventRankInitBean);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(@Nullable View titleContainer) {
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(@Nullable IDataCallBack<FeedCloudRead$HotTagRankItem> callback, @Nullable String s16) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(@Nullable View view, boolean isSelected) {
    }
}
