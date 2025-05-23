package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0014J$\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/e;", "Lcom/tencent/biz/qqcircle/bizparts/c;", "", "getLogTag", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "i", "onBindViewHolder", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartStop", "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "i0", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyItemView;", "D", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyItemView;", "mPicDetailPageItemView", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e extends com.tencent.biz.qqcircle.bizparts.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QCircleInitBean mInitBean;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QFSNewContentDetailBodyItemView mPicDetailPageItemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull QCircleInitBean mInitBean) {
        super(null);
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        this.mInitBean = mInitBean;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    @Nullable
    protected BaseWidgetView<?> createBlockRootView(@NotNull ViewGroup viewGroup, @Nullable MultiViewBlock<?> adapter) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        QFSNewContentDetailBodyItemView qFSNewContentDetailBodyItemView = new QFSNewContentDetailBodyItemView(viewGroup.getContext(), this.mInitBean);
        this.mPicDetailPageItemView = qFSNewContentDetailBodyItemView;
        qFSNewContentDetailBodyItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return this.mPicDetailPageItemView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    @NotNull
    protected String getLogTag() {
        return "QFSNewContentDetailBodyItemBlock";
    }

    public final void i0(@Nullable Configuration configuration) {
        QFSNewContentDetailBodyItemView qFSNewContentDetailBodyItemView = this.mPicDetailPageItemView;
        if (qFSNewContentDetailBodyItemView != null) {
            qFSNewContentDetailBodyItemView.onConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i3) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder, i3);
        List<E> list = this.mDataList;
        if (list != 0 && i3 < list.size() && (this.mDataList.get(i3) instanceof e30.b)) {
            Object obj = this.mDataList.get(i3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.biz.qqcircle.extendpb.FeedBlockData");
            e30.b bVar = (e30.b) obj;
            QFSNewContentDetailBodyItemView qFSNewContentDetailBodyItemView = this.mPicDetailPageItemView;
            if (qFSNewContentDetailBodyItemView != null) {
                qFSNewContentDetailBodyItemView.bindData(bVar.g(), i3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QFSNewContentDetailBodyItemView qFSNewContentDetailBodyItemView = this.mPicDetailPageItemView;
        if (qFSNewContentDetailBodyItemView != null) {
            qFSNewContentDetailBodyItemView.f();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        QFSNewContentDetailBodyItemView qFSNewContentDetailBodyItemView = this.mPicDetailPageItemView;
        if (qFSNewContentDetailBodyItemView != null) {
            qFSNewContentDetailBodyItemView.m0();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        QFSNewContentDetailBodyItemView qFSNewContentDetailBodyItemView = this.mPicDetailPageItemView;
        if (qFSNewContentDetailBodyItemView != null) {
            qFSNewContentDetailBodyItemView.n0();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        QFSNewContentDetailBodyItemView qFSNewContentDetailBodyItemView = this.mPicDetailPageItemView;
        if (qFSNewContentDetailBodyItemView != null) {
            qFSNewContentDetailBodyItemView.o0();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
    }
}
