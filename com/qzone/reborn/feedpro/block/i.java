package com.qzone.reborn.feedpro.block;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.qzone.util.ar;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/feedpro/block/i;", "Lcom/qzone/reborn/base/m;", "Landroid/content/Context;", "context", "", "topPartHeight", "", "l0", "m0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewAttachedToWindow", "Lwd/e;", "emptyStateBean", "n0", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "emptyView", BdhLogUtil.LogTag.Tag_Conn, "Lwd/e;", "emptyStateData", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private wd.e emptyStateData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView emptyView;

    public i(Bundle bundle) {
        super(bundle);
    }

    private final void l0(Context context, int topPartHeight) {
        ViewGroup.LayoutParams layoutParams;
        QZoneBlankStateView qZoneBlankStateView = this.emptyView;
        if (qZoneBlankStateView == null || (layoutParams = qZoneBlankStateView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = -1;
        layoutParams.height = m0(context, topPartHeight);
        QZoneBlankStateView qZoneBlankStateView2 = this.emptyView;
        if (qZoneBlankStateView2 == null) {
            return;
        }
        qZoneBlankStateView2.setLayoutParams(layoutParams);
    }

    private final int m0(Context context, int topPartHeight) {
        return ar.k() - topPartHeight;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        QZoneBlankStateView qZoneBlankStateView = new QZoneBlankStateView(getContext(), null);
        this.emptyView = qZoneBlankStateView;
        Intrinsics.checkNotNull(qZoneBlankStateView);
        return qZoneBlankStateView;
    }

    public final void n0(Context context, wd.e emptyStateBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(emptyStateBean, "emptyStateBean");
        this.emptyStateData = emptyStateBean;
        l0(context, emptyStateBean.getTopPartHeight());
        QZoneBlankStateView qZoneBlankStateView = this.emptyView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.setData(emptyStateBean.getBlankData());
        }
        if (emptyStateBean.getIsShowError()) {
            QZoneBlankStateView qZoneBlankStateView2 = this.emptyView;
            if (qZoneBlankStateView2 != null) {
                qZoneBlankStateView2.showErrorView();
                return;
            }
            return;
        }
        QZoneBlankStateView qZoneBlankStateView3 = this.emptyView;
        if (qZoneBlankStateView3 != null) {
            qZoneBlankStateView3.s0();
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        wd.e eVar = this.emptyStateData;
        if (eVar != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            n0(context, eVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
    }
}
