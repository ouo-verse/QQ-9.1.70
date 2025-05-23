package com.tencent.robot.discoveryv2.common.recommend.page.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadType;
import com.tencent.robot.discoveryv2.common.recommend.page.core.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import v34.PageReserveParams;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0016\u0010\u001d\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\u0018\u0010'\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001eH\u0016R\u0016\u0010-\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00108R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010:R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00108R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendRobotsPage;", "", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", DomainData.DOMAIN_NAME, "root", "", "o", "p", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "i", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "loadState", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "loadType", HippyTKDListViewAdapter.X, "l", "k", "", "Ls34/b;", "recommendRobotList", "w", "", "haveNextPage", "v", ReportConstant.COSTREPORT_PREFIX, "t", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/a;", "recommendPageParams", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendPageViewModel;", "viewModel", "r", "onLoadMoreStart", "hasMore", "onLoadMoreEnd", "d", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/a;", "mRecommendPageParams", "e", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendPageViewModel;", "mViewModel", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "f", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mSmartRefreshLayout", h.F, "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerview", "Z", "mHaveNextPage", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "mLoadState", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "mLoadType", "Lu34/a;", "D", "Lu34/a;", "mLoadMoreAdapter", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/d;", "E", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/d;", "mRecommendAdapter", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "mPageReserveLayout", "G", "mNeedScrollToFirstItem", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "H", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "mAdapterDataObserver", "<init>", "()V", "I", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RecommendRobotsPage implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: D, reason: from kotlin metadata */
    private u34.a mLoadMoreAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.robot.discoveryv2.common.recommend.page.core.d mRecommendAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout mPageReserveLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mNeedScrollToFirstItem;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView.AdapterDataObserver mAdapterDataObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecommendPageParams mRecommendPageParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecommendPageViewModel mViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout mSmartRefreshLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerview;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mHaveNextPage = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadState mLoadState = LoadState.NONE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private SingleCategoryLoadType mLoadType = SingleCategoryLoadType.NONE;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367689a;

        static {
            int[] iArr = new int[LoadState.values().length];
            try {
                iArr[LoadState.LOAD_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadState.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f367689a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/discoveryv2/common/recommend/page/core/RecommendRobotsPage$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            RecommendRobotsPage.this.m(recyclerView, newState);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/robot/discoveryv2/common/recommend/page/core/RecommendRobotsPage$d", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeInserted", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends RecyclerView.AdapterDataObserver {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
            if (RecommendRobotsPage.this.mNeedScrollToFirstItem && positionStart == 0) {
                RecyclerView recyclerView = RecommendRobotsPage.this.mRecyclerview;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerview");
                    recyclerView = null;
                }
                recyclerView.scrollToPosition(0);
                RecommendRobotsPage.this.mNeedScrollToFirstItem = false;
            }
        }
    }

    private final void i() {
        RecommendPageViewModel recommendPageViewModel = this.mViewModel;
        RecommendPageParams recommendPageParams = null;
        if (recommendPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            recommendPageViewModel = null;
        }
        MutableLiveData<com.tencent.robot.discoveryv2.common.recommend.page.core.b> P1 = recommendPageViewModel.P1();
        RecommendPageParams recommendPageParams2 = this.mRecommendPageParams;
        if (recommendPageParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams2 = null;
        }
        P1.removeObservers(recommendPageParams2.getLifecycleOwner());
        RecommendPageViewModel recommendPageViewModel2 = this.mViewModel;
        if (recommendPageViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            recommendPageViewModel2 = null;
        }
        MutableLiveData<com.tencent.robot.discoveryv2.common.recommend.page.core.b> P12 = recommendPageViewModel2.P1();
        RecommendPageParams recommendPageParams3 = this.mRecommendPageParams;
        if (recommendPageParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
            recommendPageParams3 = null;
        }
        LifecycleOwner lifecycleOwner = recommendPageParams3.getLifecycleOwner();
        final Function1<com.tencent.robot.discoveryv2.common.recommend.page.core.b, Unit> function1 = new Function1<com.tencent.robot.discoveryv2.common.recommend.page.core.b, Unit>() { // from class: com.tencent.robot.discoveryv2.common.recommend.page.core.RecommendRobotsPage$bindViewMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                if (bVar instanceof b.UpdatePageLoadStateUIState) {
                    b.UpdatePageLoadStateUIState updatePageLoadStateUIState = (b.UpdatePageLoadStateUIState) bVar;
                    RecommendRobotsPage.this.x(updatePageLoadStateUIState.getLoadState(), updatePageLoadStateUIState.getLoadType());
                } else if (bVar instanceof b.UpdatePageDataUIState) {
                    RecommendRobotsPage.this.w(((b.UpdatePageDataUIState) bVar).a());
                } else if (bVar instanceof b.UpdateHaveNextPageUIState) {
                    RecommendRobotsPage.this.v(((b.UpdateHaveNextPageUIState) bVar).getHaveNextPage());
                }
            }
        };
        P12.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.discoveryv2.common.recommend.page.core.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecommendRobotsPage.j(Function1.this, obj);
            }
        });
        RecommendPageViewModel recommendPageViewModel3 = this.mViewModel;
        if (recommendPageViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            recommendPageViewModel3 = null;
        }
        RecommendPageParams recommendPageParams4 = this.mRecommendPageParams;
        if (recommendPageParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendPageParams");
        } else {
            recommendPageParams = recommendPageParams4;
        }
        recommendPageViewModel3.f2(recommendPageParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void k() {
        u34.a aVar = this.mLoadMoreAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aVar = null;
        }
        aVar.setLoadState(com.tencent.robot.discoveryv2.common.data.c.b(this.mLoadState), this.mHaveNextPage);
    }

    private final void l() {
        v34.a bVar;
        if (com.tencent.robot.discoveryv2.common.data.h.a(this.mLoadType)) {
            int i3 = b.f367689a[this.mLoadState.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    bVar = new v34.b();
                } else {
                    bVar = new v34.e();
                }
            } else {
                bVar = new v34.d();
            }
        } else {
            bVar = new v34.b();
        }
        RecommendPageViewModel recommendPageViewModel = this.mViewModel;
        FrameLayout frameLayout = null;
        if (recommendPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            recommendPageViewModel = null;
        }
        PageReserveParams pageReserveParams = new PageReserveParams(recommendPageViewModel);
        FrameLayout frameLayout2 = this.mPageReserveLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageReserveLayout");
        } else {
            frameLayout = frameLayout2;
        }
        bVar.a(pageReserveParams, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(RecyclerView recyclerView, int newState) {
        if (newState == 0 && !recyclerView.canScrollVertically(1) && !com.tencent.robot.discoveryv2.common.data.c.b(this.mLoadState) && this.mHaveNextPage) {
            u34.a aVar = this.mLoadMoreAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
                aVar = null;
            }
            aVar.setLoadState(true, true);
        }
    }

    private final View n(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168568fy1, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026          false\n        )");
        return inflate;
    }

    private final void o(View root) {
        View findViewById = root.findViewById(R.id.f220602p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.page_reserve_layout)");
        this.mPageReserveLayout = (FrameLayout) findViewById;
    }

    private final void p(View root, ViewGroup parent) {
        u34.a aVar = new u34.a();
        aVar.registerLoadMoreListener(this);
        this.mLoadMoreAdapter = aVar;
        com.tencent.robot.discoveryv2.common.recommend.page.core.d dVar = new com.tencent.robot.discoveryv2.common.recommend.page.core.d();
        dVar.setHasStableIds(true);
        this.mRecommendAdapter = dVar;
        View findViewById = root.findViewById(R.id.i4m);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.addOnScrollListener(new c());
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(parent.getContext()));
        RecyclerView.AdapterDataObserver adapterDataObserver = null;
        recyclerView.setItemAnimator(null);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.tencent.robot.discoveryv2.common.recommend.page.core.d dVar2 = this.mRecommendAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
            dVar2 = null;
        }
        adapterArr[0] = dVar2;
        u34.a aVar2 = this.mLoadMoreAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aVar2 = null;
        }
        adapterArr[1] = aVar2;
        recyclerView.setAdapter(new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr));
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById<Recycl\u2026r\n            )\n        }");
        this.mRecyclerview = recyclerView;
        this.mAdapterDataObserver = new d();
        RecyclerView recyclerView2 = this.mRecyclerview;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerview");
            recyclerView2 = null;
        }
        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
        if (adapter != null) {
            RecyclerView.AdapterDataObserver adapterDataObserver2 = this.mAdapterDataObserver;
            if (adapterDataObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapterDataObserver");
            } else {
                adapterDataObserver = adapterDataObserver2;
            }
            adapter.registerAdapterDataObserver(adapterDataObserver);
        }
    }

    private final void q(View root) {
        View findViewById = root.findViewById(R.id.f72383qp);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setEnableLoadMore(false);
        smartRefreshLayout.setEnableOverScrollDrag(true);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById<SmartR\u2026crollDrag(true)\n        }");
        this.mSmartRefreshLayout = smartRefreshLayout;
    }

    private final void u() {
        List<? extends s34.b> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        w(emptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(boolean haveNextPage) {
        this.mHaveNextPage = haveNextPage;
        u34.a aVar = this.mLoadMoreAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aVar = null;
        }
        aVar.setLoadState(com.tencent.robot.discoveryv2.common.data.c.b(this.mLoadState), this.mHaveNextPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(List<? extends s34.b> recommendRobotList) {
        QLog.i("RecommendRobotsPage", 1, "updatePageDataUI size = " + recommendRobotList.size());
        com.tencent.robot.discoveryv2.common.recommend.page.core.d dVar = this.mRecommendAdapter;
        ArrayList arrayList = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
            dVar = null;
        }
        if (!recommendRobotList.isEmpty()) {
            arrayList = new ArrayList();
            arrayList.addAll(recommendRobotList);
        }
        dVar.setItems(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(LoadState loadState, SingleCategoryLoadType loadType) {
        this.mLoadState = loadState;
        this.mLoadType = loadType;
        l();
        k();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        RecommendPageViewModel recommendPageViewModel = this.mViewModel;
        if (recommendPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            recommendPageViewModel = null;
        }
        recommendPageViewModel.a2(SingleCategoryLoadType.LOAD_MORE);
    }

    public void r(@NotNull RecommendPageParams recommendPageParams, @NotNull RecommendPageViewModel viewModel) {
        Intrinsics.checkNotNullParameter(recommendPageParams, "recommendPageParams");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.mRecommendPageParams = recommendPageParams;
        this.mViewModel = viewModel;
        i();
    }

    @NotNull
    public View s(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View n3 = n(parent);
        o(n3);
        p(n3, parent);
        q(n3);
        return n3;
    }

    public void t() {
        this.mNeedScrollToFirstItem = true;
        u();
        RecommendPageViewModel recommendPageViewModel = this.mViewModel;
        if (recommendPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            recommendPageViewModel = null;
        }
        recommendPageViewModel.g2();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
