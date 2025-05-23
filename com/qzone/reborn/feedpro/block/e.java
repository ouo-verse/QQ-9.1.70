package com.qzone.reborn.feedpro.block;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.widget.header.QzoneBaseFeedProHeaderContainerView;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\tH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0014J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/feedpro/block/e;", "Lcom/qzone/reborn/base/m;", "Lcom/qzone/reborn/feedx/viewmodel/c;", "", "n0", "m0", "Landroid/os/Bundle;", "p0", "onInitBlock", "Lcom/qzone/reborn/feedpro/widget/header/QzoneBaseFeedProHeaderContainerView;", "o0", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadData", "Landroid/view/ViewGroup;", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "p1", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPostThemeChanged", "", "hasFocus", "k0", "Landroid/content/res/Configuration;", "newConfig", "j0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/widget/header/QzoneBaseFeedProHeaderContainerView;", "mHeaderView", "initParams", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class e extends com.qzone.reborn.base.m {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QzoneBaseFeedProHeaderContainerView mHeaderView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/block/e$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = e.this.mHeaderView;
            if (qzoneBaseFeedProHeaderContainerView != null) {
                qzoneBaseFeedProHeaderContainerView.b(recyclerView, dx5, dy5);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/block/e$b", "Lcom/qzone/reborn/feedx/widget/header/QZoneFeedxRefreshView$b;", "", "offSet", "sumOffSet", "", "a", "", "onRelease", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneFeedxRefreshView.b {
        b() {
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public boolean a(float offSet, float sumOffSet) {
            QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = e.this.mHeaderView;
            return qzoneBaseFeedProHeaderContainerView != null && qzoneBaseFeedProHeaderContainerView.c(offSet, sumOffSet);
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public void onRelease() {
            QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = e.this.mHeaderView;
            if (qzoneBaseFeedProHeaderContainerView != null) {
                qzoneBaseFeedProHeaderContainerView.M();
            }
        }
    }

    public e(Bundle bundle) {
        super(bundle);
    }

    private final void m0() {
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.qzone.reborn.feedpro.viewmodel.QzoneFriendFeedProScrollViewModel");
        com.qzone.reborn.feedpro.viewmodel.n nVar = (com.qzone.reborn.feedpro.viewmodel.n) viewModel;
        nVar.N1(new a());
        nVar.M1(new b());
    }

    private final void n0() {
        if (this.mHeaderView == null) {
            this.mHeaderView = o0();
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup p06, MultiViewBlock<?> p16) {
        m0();
        QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = this.mHeaderView;
        Intrinsics.checkNotNull(qzoneBaseFeedProHeaderContainerView);
        return qzoneBaseFeedProHeaderContainerView;
    }

    @Override // com.qzone.reborn.base.m
    public void j0(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.j0(newConfig);
        QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = this.mHeaderView;
        if (qzoneBaseFeedProHeaderContainerView != null) {
            qzoneBaseFeedProHeaderContainerView.onConfigurationChanged(newConfig);
        }
    }

    @Override // com.qzone.reborn.base.m
    public void k0(boolean hasFocus) {
        super.k0(hasFocus);
        QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = this.mHeaderView;
        if (qzoneBaseFeedProHeaderContainerView != null) {
            qzoneBaseFeedProHeaderContainerView.onWindowFocusChanged(hasFocus);
        }
    }

    public abstract QzoneBaseFeedProHeaderContainerView o0();

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        n0();
        QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = this.mHeaderView;
        if (qzoneBaseFeedProHeaderContainerView != null) {
            qzoneBaseFeedProHeaderContainerView.L(recyclerView);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle p06) {
        n0();
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        try {
            QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = this.mHeaderView;
            if (qzoneBaseFeedProHeaderContainerView != null) {
                qzoneBaseFeedProHeaderContainerView.onDestroy();
            }
        } catch (Throwable th5) {
            RFWLog.fatal(getClass().getSimpleName(), RFWLog.USR, th5);
        }
    }

    public void onPostThemeChanged() {
        QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = this.mHeaderView;
        if (qzoneBaseFeedProHeaderContainerView != null) {
            qzoneBaseFeedProHeaderContainerView.onPostThemeChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = this.mHeaderView;
        if (qzoneBaseFeedProHeaderContainerView != null) {
            qzoneBaseFeedProHeaderContainerView.N(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = this.mHeaderView;
        if (qzoneBaseFeedProHeaderContainerView != null) {
            qzoneBaseFeedProHeaderContainerView.g0(holder);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo p06) {
    }
}
