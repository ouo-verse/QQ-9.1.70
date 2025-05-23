package com.tencent.biz.qqcircle.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.HotEventInfo;
import com.tencent.biz.qqcircle.beans.HotEventInfoKt;
import com.tencent.biz.qqcircle.widgets.polymerization.QCircleHotEventPolymerizationHeadView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import feedcloud.FeedCloudMeta$StHotTagInfo;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StHotTagData;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\"\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/adapter/f;", "Lcom/tencent/biz/qqcircle/bizparts/c;", "Landroid/os/Bundle;", "bundle", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "", "getLogTag", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "multiViewBlock", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "i", "onBindViewHolder", "Lcom/tencent/biz/qqcircle/widgets/polymerization/QCircleHotEventPolymerizationHeadView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/widgets/polymerization/QCircleHotEventPolymerizationHeadView;", "headView", "initParam", "<init>", "(Landroid/os/Bundle;)V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f extends com.tencent.biz.qqcircle.bizparts.c {

    /* renamed from: C, reason: from kotlin metadata */
    private QCircleHotEventPolymerizationHeadView headView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Bundle initParam) {
        super(initParam);
        Intrinsics.checkNotNullParameter(initParam, "initParam");
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    @NotNull
    protected BaseWidgetView<?> createBlockRootView(@NotNull ViewGroup viewGroup, @Nullable MultiViewBlock<?> multiViewBlock) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        QCircleHotEventPolymerizationHeadView qCircleHotEventPolymerizationHeadView = new QCircleHotEventPolymerizationHeadView(context);
        qCircleHotEventPolymerizationHeadView.setReportBean(getReportBean());
        this.headView = qCircleHotEventPolymerizationHeadView;
        return qCircleHotEventPolymerizationHeadView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    @NotNull
    protected String getLogTag() {
        return "QCircleHotEventPolymerizationHeadBlock";
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData;
        QQCircleFeedBase$StHotTagData qQCircleFeedBase$StHotTagData;
        QQCircleFeedBase$StHotTagData qQCircleFeedBase$StHotTagData2;
        FeedCloudMeta$StHotTagInfo feedCloudMeta$StHotTagInfo;
        FeedCloudMeta$StHotTagInfo feedCloudMeta$StHotTagInfo2;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Collection collection = this.mDataList;
        if (collection != null && !collection.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        QCircleHotEventPolymerizationHeadView qCircleHotEventPolymerizationHeadView = this.headView;
        HotEventInfo hotEventInfo = null;
        if (qCircleHotEventPolymerizationHeadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headView");
            qCircleHotEventPolymerizationHeadView = null;
        }
        Object obj = this.mDataList.get(i3);
        if (obj instanceof QQCircleFeedBase$StFeedListBusiRspData) {
            qQCircleFeedBase$StFeedListBusiRspData = (QQCircleFeedBase$StFeedListBusiRspData) obj;
        } else {
            qQCircleFeedBase$StFeedListBusiRspData = null;
        }
        if (qQCircleFeedBase$StFeedListBusiRspData != null && (qQCircleFeedBase$StHotTagData = qQCircleFeedBase$StFeedListBusiRspData.hotTagData) != null && (qQCircleFeedBase$StHotTagData2 = qQCircleFeedBase$StHotTagData.get()) != null && (feedCloudMeta$StHotTagInfo = qQCircleFeedBase$StHotTagData2.hotTagsInfo) != null && (feedCloudMeta$StHotTagInfo2 = feedCloudMeta$StHotTagInfo.get()) != null) {
            hotEventInfo = HotEventInfoKt.toHotEventInfo(feedCloudMeta$StHotTagInfo2);
        }
        qCircleHotEventPolymerizationHeadView.setData(hotEventInfo);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle bundle) {
    }
}
