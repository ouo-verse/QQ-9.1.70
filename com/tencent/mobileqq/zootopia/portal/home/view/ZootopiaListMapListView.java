package com.tencent.mobileqq.zootopia.portal.home.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.portal.home.model.ZootopiaListViewModel;
import com.tencent.mobileqq.zootopia.portal.home.model.e;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.view.pull2refresh.RecyclerViewWithHeaderFooterFix;
import com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u00020\u0017\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014R\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00100\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaListMapListView;", "Landroid/widget/FrameLayout;", "", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView$c;", "Landroid/content/Context;", "context", "", "f", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;", "e", "Lcom/tencent/mobileqq/zootopia/portal/home/model/d;", "adapter", "setAdapter", "Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListViewModel;", "viewModel", "setViewModel", "Lcom/tencent/mobileqq/zootopia/portal/home/model/a;", "d", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView;", "recyclerView", "", "isMachineRefresh", "xe", "", "reqType", "J3", "endOfRefresh", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/support/v7/widget/LinearLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "linearLayoutManager", "Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListViewModel;", "mViewModel", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;", "xRecyclerView", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/RecyclerViewWithHeaderFooterFix;", h.F, "Lcom/tencent/sqshow/zootopia/view/pull2refresh/RecyclerViewWithHeaderFooterFix;", "listView", "i", "Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaListMapListView;", "root", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/zootopia/portal/home/model/a;", "controller", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaListMapListView extends FrameLayout implements XPullToRefreshView.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZootopiaListViewModel mViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZootopiaPullRefreshLayout xRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerViewWithHeaderFooterFix listView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ZootopiaListMapListView root;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy controller;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/view/ZootopiaListMapListView$b", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.bottom = LayoutAttrsKt.getDp(15);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/view/ZootopiaListMapListView$c", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            ZootopiaListMapListView.this.c().a(recyclerView, newState);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            ZootopiaListMapListView.this.c().b(recyclerView, dx5, dy5);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/portal/home/view/ZootopiaListMapListView$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v3) {
            ZootopiaListMapListView.this.c().onViewAttachedToWindow(v3);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v3) {
            ZootopiaListMapListView.this.c().onViewDetachedFromWindow(v3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaListMapListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.zootopia.portal.home.model.a c() {
        return (com.tencent.mobileqq.zootopia.portal.home.model.a) this.controller.getValue();
    }

    private final void f(Context context) {
        this.root = this;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dd9, (ViewGroup) this, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.linearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        View findViewById = inflate.findViewById(R.id.q7s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.map_list)");
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = (ZootopiaPullRefreshLayout) findViewById;
        this.xRecyclerView = zootopiaPullRefreshLayout;
        if (zootopiaPullRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            zootopiaPullRefreshLayout = null;
        }
        zootopiaPullRefreshLayout.setPullRefreshMode(1);
        LoadingMoreHelper D = zootopiaPullRefreshLayout.D();
        if (D != null) {
            D.setPreLoaderCount(3);
        }
        ZootopiaListMapListView zootopiaListMapListView = this.root;
        if (zootopiaListMapListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            zootopiaListMapListView = null;
        }
        zootopiaPullRefreshLayout.setRefreshCallback(zootopiaListMapListView);
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout2 = this.xRecyclerView;
        if (zootopiaPullRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            zootopiaPullRefreshLayout2 = null;
        }
        RecyclerViewWithHeaderFooterFix E = zootopiaPullRefreshLayout2.E();
        Intrinsics.checkNotNullExpressionValue(E, "xRecyclerView.recyclerView");
        this.listView = E;
        if (E == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            E = null;
        }
        E.setOverScrollMode(2);
        E.setVerticalScrollBarEnabled(false);
        E.setEnabled(true);
        E.setLayoutManager(this.linearLayoutManager);
        E.setItemAnimator(null);
        E.setItemViewCacheSize(3);
        E.addItemDecoration(new b());
        E.addOnScrollListener(new c());
        E.addOnAttachStateChangeListener(new d());
        E.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.a
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                ZootopiaListMapListView.g(viewHolder);
            }
        });
        setBackgroundColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        if (view instanceof ZootopiaMapItemView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView");
            ZootopiaMapItemView zootopiaMapItemView = (ZootopiaMapItemView) view;
            QLog.i("ZPlanMapListView", 1, zootopiaMapItemView + " clear");
            zootopiaMapItemView.k();
        }
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void J3(XPullToRefreshView recyclerView, int reqType) {
        if (QLog.isColorLevel()) {
            Log.i("ZPlanMapListView", "startLoadMore");
        }
        c().reset();
        ZootopiaListViewModel zootopiaListViewModel = this.mViewModel;
        boolean isEnd = zootopiaListViewModel != null ? zootopiaListViewModel.getIsEnd() : true;
        if (!isEnd) {
            ZootopiaListViewModel zootopiaListViewModel2 = this.mViewModel;
            if (zootopiaListViewModel2 != null) {
                zootopiaListViewModel2.loadMore();
                return;
            }
            return;
        }
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = this.xRecyclerView;
        if (zootopiaPullRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            zootopiaPullRefreshLayout = null;
        }
        zootopiaPullRefreshLayout.F(true, !isEnd);
    }

    public com.tencent.mobileqq.zootopia.portal.home.model.a d() {
        return c();
    }

    public ZootopiaPullRefreshLayout e() {
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = this.xRecyclerView;
        if (zootopiaPullRefreshLayout != null) {
            return zootopiaPullRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void endOfRefresh() {
        Log.e("ZPlanMapListView", "endOfRefresh");
        com.tencent.mobileqq.zootopia.portal.home.model.a c16 = c();
        RecyclerViewWithHeaderFooterFix recyclerViewWithHeaderFooterFix = this.listView;
        if (recyclerViewWithHeaderFooterFix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerViewWithHeaderFooterFix = null;
        }
        c16.c(recyclerViewWithHeaderFooterFix);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        QLog.e("ZPlanMapListView", 1, "onConfigurationChanged");
        try {
            RecyclerViewWithHeaderFooterFix recyclerViewWithHeaderFooterFix = this.listView;
            if (recyclerViewWithHeaderFooterFix == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                recyclerViewWithHeaderFooterFix = null;
            }
            RecyclerView.Adapter adapter = recyclerViewWithHeaderFooterFix.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e16) {
            QLog.e("ZPlanMapListView", 1, "onConfigurationChanged crash!", e16);
        }
    }

    public void setAdapter(com.tencent.mobileqq.zootopia.portal.home.model.d adapter) {
        RecyclerViewWithHeaderFooterFix recyclerViewWithHeaderFooterFix = this.listView;
        if (recyclerViewWithHeaderFooterFix == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerViewWithHeaderFooterFix = null;
        }
        recyclerViewWithHeaderFooterFix.setAdapter(adapter);
    }

    public void setViewModel(ZootopiaListViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void xe(XPullToRefreshView recyclerView, boolean isMachineRefresh) {
        if (QLog.isColorLevel()) {
            Log.i("ZPlanMapListView", "startTopRefresh");
        }
        ZootopiaListViewModel zootopiaListViewModel = this.mViewModel;
        if (zootopiaListViewModel != null) {
            zootopiaListViewModel.refresh();
        }
        c().reset();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaListMapListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaListMapListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaListMapListView(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.controller = LazyKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaListMapListView$controller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return new e(context);
            }
        });
        f(context);
    }
}
