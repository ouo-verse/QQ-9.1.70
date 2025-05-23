package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.feedx.widget.QZoneLoadMoreUpView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0014J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/feedpro/block/QzoneFeedProLoadMoreUpBlock;", "Lcom/qzone/reborn/base/m;", "", "s0", "p0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "", "q0", "Lcom/qzone/reborn/feedx/widget/QZoneLoadMoreUpView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneLoadMoreUpView;", "mLoadMoreUpView", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsLoadingMoreUp", "Lcom/qzone/reborn/feedx/viewmodel/r;", "D", "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "E", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "mUserHomeViewModel", "<init>", "(Landroid/os/Bundle;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProLoadMoreUpBlock extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsLoadingMoreUp;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m mUserHomeViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneLoadMoreUpView mLoadMoreUpView;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/block/QzoneFeedProLoadMoreUpBlock$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 0 || QzoneFeedProLoadMoreUpBlock.this.mLoadMoreUpView == null) {
                return;
            }
            QZoneLoadMoreUpView qZoneLoadMoreUpView = QzoneFeedProLoadMoreUpBlock.this.mLoadMoreUpView;
            Intrinsics.checkNotNull(qZoneLoadMoreUpView);
            if (qZoneLoadMoreUpView.getTop() >= 0) {
                int a16 = ah.a(recyclerView);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if ((layoutManager != null ? layoutManager.findViewByPosition(a16) : null) instanceof QZoneLoadMoreUpView) {
                    QzoneFeedProLoadMoreUpBlock.this.s0();
                }
            }
        }
    }

    public QzoneFeedProLoadMoreUpBlock(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        if (this.mIsLoadingMoreUp) {
            return;
        }
        this.mIsLoadingMoreUp = true;
        QZoneLoadMoreUpView qZoneLoadMoreUpView = this.mLoadMoreUpView;
        if (qZoneLoadMoreUpView != null) {
            qZoneLoadMoreUpView.p0();
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        mVar.t2();
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        QZoneLoadMoreUpView qZoneLoadMoreUpView = new QZoneLoadMoreUpView(getContext());
        this.mLoadMoreUpView = qZoneLoadMoreUpView;
        qZoneLoadMoreUpView.setPadding(0, QZoneFeedxViewUtils.e(getContext()) + QZoneFeedxViewUtils.d(), 0, 0);
        QZoneLoadMoreUpView qZoneLoadMoreUpView2 = this.mLoadMoreUpView;
        Intrinsics.checkNotNull(qZoneLoadMoreUpView2);
        return qZoneLoadMoreUpView2;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedpro.viewmodel.m.class);
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.qzone.reborn.feedpro.viewmodel.QzoneFeedProUserHomeViewModel");
        this.mUserHomeViewModel = (com.qzone.reborn.feedpro.viewmodel.m) viewModel;
        ViewModel viewModel2 = getViewModel(com.qzone.reborn.feedx.viewmodel.r.class);
        Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type com.qzone.reborn.feedx.viewmodel.QZoneFriendFeedxScrollViewModel");
        com.qzone.reborn.feedx.viewmodel.r rVar = (com.qzone.reborn.feedx.viewmodel.r) viewModel2;
        this.mScrollViewModel = rVar;
        com.qzone.reborn.feedpro.viewmodel.m mVar = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
            rVar = null;
        }
        rVar.N1(new b());
        LifecycleOwner i06 = i0();
        if (i06 != null) {
            com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.mUserHomeViewModel;
            if (mVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            } else {
                mVar = mVar2;
            }
            MutableLiveData<com.qzone.reborn.feedpro.viewmodel.b> O1 = mVar.O1();
            final Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit> function1 = new Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProLoadMoreUpBlock$onInitBlock$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                    if (Intrinsics.areEqual(bVar, com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.b())) {
                        QzoneFeedProLoadMoreUpBlock.this.p0();
                    }
                }
            };
            O1.observe(i06, new Observer() { // from class: com.qzone.reborn.feedpro.block.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProLoadMoreUpBlock.r0(Function1.this, obj);
                }
            });
        }
    }

    public final int q0() {
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
    public final void p0() {
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
