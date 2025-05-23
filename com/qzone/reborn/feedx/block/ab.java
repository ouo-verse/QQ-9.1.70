package com.qzone.reborn.feedx.block;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneLoadMoreUpView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0014J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/feedx/block/ab;", "Lcom/qzone/reborn/base/m;", "", "q0", "o0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "", "p0", "Lcom/qzone/reborn/feedx/widget/QZoneLoadMoreUpView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneLoadMoreUpView;", "mLoadMoreUpView", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsLoadingMoreUp", "Lcom/qzone/reborn/feedx/viewmodel/r;", "D", "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedx/viewmodel/w;", "E", "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "<init>", "(Landroid/os/Bundle;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ab extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsLoadingMoreUp;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mUserHomeViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneLoadMoreUpView mLoadMoreUpView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/block/ab$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 0 || ab.this.mLoadMoreUpView == null) {
                return;
            }
            QZoneLoadMoreUpView qZoneLoadMoreUpView = ab.this.mLoadMoreUpView;
            Intrinsics.checkNotNull(qZoneLoadMoreUpView);
            if (qZoneLoadMoreUpView.getTop() >= 0) {
                int a16 = com.qzone.reborn.feedx.util.ah.a(recyclerView);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if ((layoutManager != null ? layoutManager.findViewByPosition(a16) : null) instanceof QZoneLoadMoreUpView) {
                    ab.this.q0();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/block/ab$c", "Lcom/qzone/reborn/feedx/viewmodel/s;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedsData", "", "updateCount", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.qzone.reborn.feedx.viewmodel.s {
        c() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.s
        public void a(List<? extends BusinessFeedData> feedsData, int updateCount) {
            ab.this.o0();
        }
    }

    public ab(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        if (this.mIsLoadingMoreUp) {
            return;
        }
        this.mIsLoadingMoreUp = true;
        QZoneLoadMoreUpView qZoneLoadMoreUpView = this.mLoadMoreUpView;
        if (qZoneLoadMoreUpView != null) {
            qZoneLoadMoreUpView.p0();
        }
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        wVar.T2();
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        QZoneLoadMoreUpView qZoneLoadMoreUpView = new QZoneLoadMoreUpView(getContext());
        this.mLoadMoreUpView = qZoneLoadMoreUpView;
        qZoneLoadMoreUpView.setPadding(0, QZoneFeedxViewUtils.e(getContext()) + QZoneFeedxViewUtils.c(), 0, 0);
        QZoneLoadMoreUpView qZoneLoadMoreUpView2 = this.mLoadMoreUpView;
        Intrinsics.checkNotNull(qZoneLoadMoreUpView2);
        return qZoneLoadMoreUpView2;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.qzone.reborn.feedx.viewmodel.QZoneUserHomeViewModel");
        this.mUserHomeViewModel = (com.qzone.reborn.feedx.viewmodel.w) viewModel;
        ViewModel viewModel2 = getViewModel(com.qzone.reborn.feedx.viewmodel.r.class);
        Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type com.qzone.reborn.feedx.viewmodel.QZoneFriendFeedxScrollViewModel");
        com.qzone.reborn.feedx.viewmodel.r rVar = (com.qzone.reborn.feedx.viewmodel.r) viewModel2;
        this.mScrollViewModel = rVar;
        com.qzone.reborn.feedx.viewmodel.w wVar = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
            rVar = null;
        }
        rVar.N1(new b());
        com.qzone.reborn.feedx.viewmodel.w wVar2 = this.mUserHomeViewModel;
        if (wVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            wVar = wVar2;
        }
        wVar.f3(new c());
    }

    public final int p0() {
        if (this.mLoadMoreUpView == null || getActivity() == null) {
            return 0;
        }
        QZoneLoadMoreUpView qZoneLoadMoreUpView = this.mLoadMoreUpView;
        Intrinsics.checkNotNull(qZoneLoadMoreUpView);
        int height = qZoneLoadMoreUpView.getHeight();
        QZoneLoadMoreUpView qZoneLoadMoreUpView2 = this.mLoadMoreUpView;
        Intrinsics.checkNotNull(qZoneLoadMoreUpView2);
        return height - qZoneLoadMoreUpView2.getPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        this.mIsLoadingMoreUp = false;
        QZoneLoadMoreUpView qZoneLoadMoreUpView = this.mLoadMoreUpView;
        if (qZoneLoadMoreUpView != null) {
            qZoneLoadMoreUpView.n0();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
