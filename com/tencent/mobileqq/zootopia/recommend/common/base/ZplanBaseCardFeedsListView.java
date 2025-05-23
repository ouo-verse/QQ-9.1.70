package com.tencent.mobileqq.zootopia.recommend.common.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.av.utils.ba;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.view.pull2refresh.RecyclerViewWithHeaderFooterFix;
import com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import gd3.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\u0018\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u001cH\u0004J\b\u0010\u001e\u001a\u00020\u0005H\u0004J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180!2\u0006\u0010 \u001a\u00020\u001fH\u0004J\u0012\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0014R\u001a\u0010*\u001a\u00020&8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\"\u00100\u001a\u00020\b8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b(\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u0002018\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b,\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010=\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010>R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\"\u0010H\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010L\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010C\u001a\u0004\bJ\u0010E\"\u0004\bK\u0010G\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/zootopia/recommend/common/base/ZplanBaseCardFeedsListView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView$c;", "Landroid/content/Context;", "context", "", "g", "k", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;", "d", "Lfd3/a;", "adapter", "setAdapter", "Lgd3/c;", "viewModel", "setViewModel", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView;", "recyclerView", "", "isMachineRefresh", "xe", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "", "reqType", "J3", "endOfRefresh", "Landroid/support/v7/widget/RecyclerView;", h.F, "i", "Landroid/support/v7/widget/LinearLayoutManager;", "linearLayoutManager", "", "a", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "TAG", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;", "f", "()Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;", "l", "(Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;)V", "xRecyclerView", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/RecyclerViewWithHeaderFooterFix;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/RecyclerViewWithHeaderFooterFix;", "c", "()Lcom/tencent/sqshow/zootopia/view/pull2refresh/RecyclerViewWithHeaderFooterFix;", "j", "(Lcom/tencent/sqshow/zootopia/view/pull2refresh/RecyclerViewWithHeaderFooterFix;)V", "listView", "Lgd3/c;", "getMViewModel", "()Lgd3/c;", "setMViewModel", "(Lgd3/c;)V", "mViewModel", "I", "itemDecorationMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lastPlayPosition", BdhLogUtil.LogTag.Tag_Conn, "Z", "getDisableTouchEvent", "()Z", "setDisableTouchEvent", "(Z)V", "disableTouchEvent", "D", "b", "setCanScroll", "canScroll", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ZplanBaseCardFeedsListView extends FrameLayout implements XPullToRefreshView.c {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean disableTouchEvent;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean canScroll;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected ZootopiaPullRefreshLayout xRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected RecyclerViewWithHeaderFooterFix listView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private c mViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int itemDecorationMargin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastPlayPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/recommend/common/base/ZplanBaseCardFeedsListView$a", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                ZplanBaseCardFeedsListView.this.h(recyclerView);
                ((gl3.a) vb3.a.f441346a.a(gl3.a.class)).K();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            if (recyclerView != null && dx5 == 0 && dy5 == 0 && recyclerView.isShown()) {
                ZplanBaseCardFeedsListView.this.h(recyclerView);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zootopia/recommend/common/base/ZplanBaseCardFeedsListView$b", "Landroid/support/v7/widget/LinearLayoutManager;", "", "targetPosition", "Landroid/graphics/PointF;", "b", "", "canScrollHorizontally", "canScrollVertically", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView$State;", "state", "position", "", "smoothScrollToPosition", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends LinearLayoutManager {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/recommend/common/base/ZplanBaseCardFeedsListView$b$a", "Landroid/support/v7/widget/LinearSmoothScroller;", "", "targetPosition", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "dx", "calculateTimeForDeceleration", "calculateTimeForScrolling", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a extends LinearSmoothScroller {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ZplanBaseCardFeedsListView f329043b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ZplanBaseCardFeedsListView zplanBaseCardFeedsListView, Context context) {
                super(context);
                this.f329043b = zplanBaseCardFeedsListView;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.support.v7.widget.LinearSmoothScroller
            public int calculateTimeForDeceleration(int dx5) {
                int calculateTimeForDeceleration = super.calculateTimeForDeceleration(dx5);
                QLog.i(this.f329043b.getTAG(), 1, "calculateTimeForDeceleration dx:" + dx5 + " " + calculateTimeForDeceleration);
                return calculateTimeForDeceleration;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.support.v7.widget.LinearSmoothScroller
            public int calculateTimeForScrolling(int dx5) {
                int coerceAtMost;
                int calculateTimeForScrolling = super.calculateTimeForScrolling(dx5);
                QLog.i(this.f329043b.getTAG(), 1, "calculateTimeForScrolling dx:" + dx5 + " " + calculateTimeForScrolling);
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(calculateTimeForScrolling, 200);
                return coerceAtMost;
            }

            @Override // android.support.v7.widget.LinearSmoothScroller
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return b.this.b(targetPosition);
            }
        }

        b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PointF b(int targetPosition) {
            PointF computeScrollVectorForPosition = computeScrollVectorForPosition(targetPosition);
            Intrinsics.checkNotNullExpressionValue(computeScrollVectorForPosition, "computeScrollVectorForPosition(targetPosition)");
            return computeScrollVectorForPosition;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return ZplanBaseCardFeedsListView.this.getCanScroll();
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            a aVar = new a(ZplanBaseCardFeedsListView.this, recyclerView.getContext());
            aVar.setTargetPosition(position);
            startSmoothScroll(aVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanBaseCardFeedsListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g(Context context) {
        l(new ZootopiaPullRefreshLayout(context, null, 0, 6, null));
        ZootopiaPullRefreshLayout f16 = f();
        f16.setPullRefreshMode(1);
        LoadingMoreHelper D = f16.D();
        if (D != null) {
            D.setPreLoaderCount(3);
        }
        f16.setRefreshCallback(this);
        RecyclerViewWithHeaderFooterFix E = f().E();
        Intrinsics.checkNotNullExpressionValue(E, "xRecyclerView.recyclerView");
        j(E);
        k();
        addView(f(), new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void J3(XPullToRefreshView recyclerView, int reqType) {
        if (QLog.isColorLevel()) {
            QLog.i(getTAG(), 1, "startLoadMore");
        }
        i();
        c cVar = this.mViewModel;
        boolean M1 = cVar != null ? c.M1(cVar, 0, 1, null) : true;
        if (!M1) {
            c cVar2 = this.mViewModel;
            if (cVar2 != null) {
                c.X1(cVar2, 0, 1, null);
                return;
            }
            return;
        }
        f().F(true, !M1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final List<Integer> a(LinearLayoutManager linearLayoutManager) {
        int i3;
        Intrinsics.checkNotNullParameter(linearLayoutManager, "linearLayoutManager");
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        ArrayList arrayList = new ArrayList();
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            int i16 = -1;
            i3 = -1;
            while (true) {
                View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition != 0) {
                    Rect rect = new Rect();
                    findViewByPosition.getGlobalVisibleRect(rect);
                    int i17 = rect.bottom - rect.top;
                    if (i17 > i16) {
                        i3 = findFirstVisibleItemPosition;
                        i16 = i17;
                    }
                    if ((findViewByPosition instanceof l84.a) && pf3.a.INSTANCE.b(((l84.a) findViewByPosition).getSelfItemType())) {
                        double height = (i17 * 1.0d) / findViewByPosition.getHeight();
                        QLog.i(getTAG(), 1, "video card " + i17 + " - " + findViewByPosition.getHeight() + " " + height);
                        if (height >= 0.5d) {
                            arrayList.add(Integer.valueOf(findFirstVisibleItemPosition));
                        }
                    }
                    if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                        break;
                    }
                    findFirstVisibleItemPosition++;
                } else {
                    return arrayList;
                }
            }
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            arrayList.add(Integer.valueOf(i3));
        }
        return arrayList;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCanScroll() {
        return this.canScroll;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RecyclerViewWithHeaderFooterFix c() {
        RecyclerViewWithHeaderFooterFix recyclerViewWithHeaderFooterFix = this.listView;
        if (recyclerViewWithHeaderFooterFix != null) {
            return recyclerViewWithHeaderFooterFix;
        }
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        return null;
    }

    public final ZootopiaPullRefreshLayout d() {
        return f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        if (this.disableTouchEvent) {
            return true;
        }
        try {
            return super.dispatchTouchEvent(ev5);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return true;
        }
    }

    /* renamed from: e, reason: from getter */
    protected String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void endOfRefresh() {
        QLog.i(getTAG(), 1, "endOfRefresh");
        h(c());
        f().H(true);
    }

    protected final ZootopiaPullRefreshLayout f() {
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = this.xRecyclerView;
        if (zootopiaPullRefreshLayout != null) {
            return zootopiaPullRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
        return null;
    }

    protected final void j(RecyclerViewWithHeaderFooterFix recyclerViewWithHeaderFooterFix) {
        Intrinsics.checkNotNullParameter(recyclerViewWithHeaderFooterFix, "<set-?>");
        this.listView = recyclerViewWithHeaderFooterFix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        RecyclerViewWithHeaderFooterFix c16 = c();
        c16.setOverScrollMode(2);
        c16.setItemAnimator(null);
        c16.setScrollingTouchSlop(1);
        c16.setVerticalScrollBarEnabled(false);
        c16.setEnabled(true);
        b bVar = new b(c16.getContext());
        bVar.setOrientation(1);
        c16.setLayoutManager(bVar);
        c16.setItemViewCacheSize(3);
        c16.addOnScrollListener(new a());
        c16.setMotionEventSplittingEnabled(false);
    }

    protected final void l(ZootopiaPullRefreshLayout zootopiaPullRefreshLayout) {
        Intrinsics.checkNotNullParameter(zootopiaPullRefreshLayout, "<set-?>");
        this.xRecyclerView = zootopiaPullRefreshLayout;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        QLog.e(getTAG(), 1, "onConfigurationChanged - width:" + ba.getScreenWidth(getContext()) + " height: " + ba.getScreenHeight(getContext()) + "  density: " + ba.getScreenDensity(getContext()));
        try {
            RecyclerView.Adapter adapter = c().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e16) {
            QLog.e(getTAG(), 1, "onConfigurationChanged crash!", e16);
        }
    }

    public void setAdapter(fd3.a adapter) {
        c().setClipChildren(false);
        c().setAdapter(adapter);
    }

    public final void setCanScroll(boolean z16) {
        this.canScroll = z16;
    }

    public final void setDisableTouchEvent(boolean z16) {
        this.disableTouchEvent = z16;
    }

    public void setViewModel(c viewModel) {
        this.mViewModel = viewModel;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void xe(XPullToRefreshView recyclerView, boolean isMachineRefresh) {
        if (QLog.isColorLevel()) {
            QLog.i(getTAG(), 1, "startTopRefresh");
        }
        i();
        c cVar = this.mViewModel;
        if (cVar != null) {
            c.U1(cVar, 0, 1, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZplanBaseCardFeedsListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected final void i() {
        this.lastPlayPosition = -1;
    }

    public /* synthetic */ ZplanBaseCardFeedsListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    protected final void h(RecyclerView recyclerView) {
        Object first;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            List<Integer> a16 = a(linearLayoutManager);
            QLog.i(getTAG(), 1, "visiblePositions " + a16);
            if (a16.isEmpty()) {
                QLog.i(getTAG(), 1, "pickItemToPlay view is not ready");
                return;
            }
            int intValue = a16.remove(a16.size() - 1).intValue();
            if (!a16.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) a16);
                KeyEvent.Callback findViewByPosition = linearLayoutManager.findViewByPosition(((Number) first).intValue());
                if (findViewByPosition instanceof l84.a) {
                    ((l84.a) findViewByPosition).i();
                }
            }
            QLog.i(getTAG(), 1, "pickItemToPlay curMaxPos " + intValue + " lastMaxPos " + this.lastPlayPosition);
            KeyEvent.Callback findViewByPosition2 = linearLayoutManager.findViewByPosition(intValue);
            if (findViewByPosition2 instanceof l84.a) {
                ((l84.a) findViewByPosition2).c();
            }
            this.lastPlayPosition = intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBaseCardFeedsListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ZplanBaseCardFeedsListView";
        this.itemDecorationMargin = getResources().getDimensionPixelSize(R.dimen.f11996_);
        this.lastPlayPosition = -1;
        this.canScroll = true;
        g(context);
    }
}
