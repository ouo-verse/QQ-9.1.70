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
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b+\u0010,J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H\u0014J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/feedpro/block/ae;", "Lcom/qzone/reborn/base/m;", "", "hasBrowserPermission", "needQuestion", "needShowGuestBtn", "", "l0", "Landroid/content/Context;", "context", "", "m0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewAttachedToWindow", "Lwd/g;", "forbiddenData", "o0", "Lwd/e;", "emptyStateBean", "n0", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "emptyOrForbiddenView", BdhLogUtil.LogTag.Tag_Conn, "Lwd/g;", "forbiddenBlankData", "D", "Lwd/e;", "emptyStateData", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ae extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private wd.g forbiddenBlankData;

    /* renamed from: D, reason: from kotlin metadata */
    private wd.e emptyStateData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView emptyOrForbiddenView;

    public ae(Bundle bundle) {
        super(bundle);
    }

    private final void l0(boolean hasBrowserPermission, boolean needQuestion, boolean needShowGuestBtn) {
        ViewGroup.LayoutParams layoutParams;
        QZoneBlankStateView qZoneBlankStateView = this.emptyOrForbiddenView;
        if (qZoneBlankStateView == null || (layoutParams = qZoneBlankStateView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = -1;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        layoutParams.height = m0(context, hasBrowserPermission, needQuestion, needShowGuestBtn);
        QZoneBlankStateView qZoneBlankStateView2 = this.emptyOrForbiddenView;
        if (qZoneBlankStateView2 == null) {
            return;
        }
        qZoneBlankStateView2.setLayoutParams(layoutParams);
    }

    private final int m0(Context context, boolean hasBrowserPermission, boolean needQuestion, boolean needShowGuestBtn) {
        return ar.k() - com.qzone.reborn.feedpro.utils.p.n(hasBrowserPermission, needQuestion, needShowGuestBtn);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        QZoneBlankStateView qZoneBlankStateView = new QZoneBlankStateView(getContext(), null);
        this.emptyOrForbiddenView = qZoneBlankStateView;
        Intrinsics.checkNotNull(qZoneBlankStateView);
        return qZoneBlankStateView;
    }

    public final void n0(wd.e emptyStateBean) {
        Intrinsics.checkNotNullParameter(emptyStateBean, "emptyStateBean");
        this.emptyStateData = emptyStateBean;
        l0(true, false, false);
        QZoneBlankStateView qZoneBlankStateView = this.emptyOrForbiddenView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.setData(emptyStateBean.getBlankData());
        }
        if (emptyStateBean.getIsShowError()) {
            QZoneBlankStateView qZoneBlankStateView2 = this.emptyOrForbiddenView;
            if (qZoneBlankStateView2 != null) {
                qZoneBlankStateView2.showErrorView();
                return;
            }
            return;
        }
        QZoneBlankStateView qZoneBlankStateView3 = this.emptyOrForbiddenView;
        if (qZoneBlankStateView3 != null) {
            qZoneBlankStateView3.s0();
        }
    }

    public final void o0(wd.g forbiddenData) {
        Intrinsics.checkNotNullParameter(forbiddenData, "forbiddenData");
        this.forbiddenBlankData = forbiddenData;
        l0(forbiddenData.getHasBrowserPermission(), forbiddenData.getNeedQuestion(), forbiddenData.getNeedShowGuestBtn());
        QZoneBlankStateView qZoneBlankStateView = this.emptyOrForbiddenView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.setData(forbiddenData.getBlankData());
        }
        QZoneBlankStateView qZoneBlankStateView2 = this.emptyOrForbiddenView;
        if (qZoneBlankStateView2 != null) {
            qZoneBlankStateView2.s0();
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        wd.g gVar = this.forbiddenBlankData;
        if (gVar != null) {
            Intrinsics.checkNotNull(gVar);
            o0(gVar);
            return;
        }
        wd.e eVar = this.emptyStateData;
        if (eVar != null) {
            Intrinsics.checkNotNull(eVar);
            n0(eVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
    }
}
