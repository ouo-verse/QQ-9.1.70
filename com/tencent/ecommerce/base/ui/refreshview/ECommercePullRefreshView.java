package com.tencent.ecommerce.base.ui.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001QB\u0019\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010N\u001a\u0004\u0018\u00010M\u00a2\u0006\u0004\bO\u0010PJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010 R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R*\u0010:\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010 \u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010>\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010 \u001a\u0004\b<\u00107\"\u0004\b=\u00109R\"\u0010B\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010 \u001a\u0004\b@\u00107\"\u0004\bA\u00109R$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u00a8\u0006R"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "Lcom/tencent/ecommerce/base/ui/refreshview/RefreshableLayout;", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView;", "B", "child", "", "onViewAdded", "", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "", "isSucceeded", "finishLoadMore", "hasMore", "updateHasMore", "isVisible", "visibleToList", "setVisible", NodeProps.ON_ATTACHED_TO_WINDOW, "Lcom/tencent/ecommerce/base/ui/refreshview/BaseRefreshHeader;", "V", "Lcom/tencent/ecommerce/base/ui/refreshview/BaseRefreshHeader;", "refreshHeader", "Lcom/tencent/ecommerce/base/ui/refreshview/QCircleLoadMoreFooter;", "W", "Lcom/tencent/ecommerce/base/ui/refreshview/QCircleLoadMoreFooter;", "loadMoreFooter", "a0", "Z", "isLoadingMore", "b0", "hasLoadingMore", "", "c0", UserInfo.SEX_FEMALE, "pullDownDistance", "d0", "hasAddRecyclerView", "e0", "recyclerViewVisible", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "f0", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "E", "()Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "setOnRefreshStateListener", "(Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;)V", "onRefreshStateListener", "value", "g0", BdhLogUtil.LogTag.Tag_Conn, "()Z", "setEnableLoadMore", "(Z)V", "enableLoadMore", "h0", "getHideFooterIfNoMore", "setHideFooterIfNoMore", "hideFooterIfNoMore", "i0", "getHideFooterBeforeLoadingMore", "setHideFooterBeforeLoadingMore", "hideFooterBeforeLoadingMore", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "j0", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "D", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "setOnRecyclerViewScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "onRecyclerViewScrollListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OnRefreshStateListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECommercePullRefreshView extends RefreshableLayout {

    /* renamed from: V, reason: from kotlin metadata */
    private BaseRefreshHeader refreshHeader;

    /* renamed from: W, reason: from kotlin metadata */
    private QCircleLoadMoreFooter loadMoreFooter;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean hasLoadingMore;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private float pullDownDistance;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean hasAddRecyclerView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean recyclerViewVisible;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private OnRefreshStateListener onRefreshStateListener;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean enableLoadMore;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean hideFooterIfNoMore;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean hideFooterBeforeLoadingMore;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.OnScrollListener onRecyclerViewScrollListener;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$a", "Lcom/tencent/ecommerce/base/ui/refreshview/OnRefreshListener;", "", Element.ELEMENT_NAME_DISTANCE, "", "onPullDownDistance", "", "onRefreshPrepare", "", "tag", "onRefreshing", "onRefreshIdle", "isSucceeded", "onRefreshFinish", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a implements OnRefreshListener {
        a() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.OnRefreshListener
        public void onPullDownDistance(float distance) {
            ECommercePullRefreshView.this.refreshHeader.a(distance);
            ECommercePullRefreshView.this.pullDownDistance = distance;
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.OnRefreshListener
        public void onRefreshFinish(boolean isSucceeded, int tag) {
            ECommercePullRefreshView.this.refreshHeader.b(isSucceeded);
            OnRefreshStateListener onRefreshStateListener = ECommercePullRefreshView.this.getOnRefreshStateListener();
            if (onRefreshStateListener != null) {
                onRefreshStateListener.onRefreshFinished(isSucceeded, tag);
            }
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.OnRefreshListener
        public boolean onRefreshIdle() {
            ECommercePullRefreshView.this.refreshHeader.c();
            return true;
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.OnRefreshListener
        public boolean onRefreshPrepare() {
            ECommercePullRefreshView.this.refreshHeader.d();
            return true;
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.OnRefreshListener
        public boolean onRefreshing(int tag) {
            ECommercePullRefreshView.this.hasLoadingMore = false;
            ECommercePullRefreshView.this.refreshHeader.e();
            OnRefreshStateListener onRefreshStateListener = ECommercePullRefreshView.this.getOnRefreshStateListener();
            if (onRefreshStateListener == null) {
                return true;
            }
            onRefreshStateListener.onRefreshBegin(tag);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$b", "Lcom/tencent/ecommerce/base/ui/refreshview/RecycleViewScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b extends RecycleViewScrollListener {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.RecycleViewScrollListener
        public void e() {
            super.e();
            if (!ECommercePullRefreshView.this.getEnableLoadMore() || ECommercePullRefreshView.this.isLoadingMore || ECommercePullRefreshView.this.pullDownDistance > 0.0f) {
                return;
            }
            ECommercePullRefreshView.this.isLoadingMore = true;
            ECommercePullRefreshView.this.hasLoadingMore = true;
            ECommercePullRefreshView.this.loadMoreFooter.c();
            OnRefreshStateListener onRefreshStateListener = ECommercePullRefreshView.this.getOnRefreshStateListener();
            if (onRefreshStateListener != null) {
                onRefreshStateListener.onLoadMoreBegin();
            }
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.RecycleViewScrollListener, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            RecyclerView.OnScrollListener onRecyclerViewScrollListener = ECommercePullRefreshView.this.getOnRecyclerViewScrollListener();
            if (onRecyclerViewScrollListener != null) {
                onRecyclerViewScrollListener.onScrollStateChanged(recyclerView, newState);
            }
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.RecycleViewScrollListener, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            RecyclerView.OnScrollListener onRecyclerViewScrollListener = ECommercePullRefreshView.this.getOnRecyclerViewScrollListener();
            if (onRecyclerViewScrollListener != null) {
                onRecyclerViewScrollListener.onScrolled(recyclerView, dx5, dy5);
            }
        }
    }

    public ECommercePullRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.refreshHeader = new QCircleRefreshHeader(context);
        this.loadMoreFooter = new QCircleLoadMoreFooter(context);
        this.recyclerViewVisible = true;
        setHeaderViewHeight(e.c(44.0f));
        setOnRefreshListener(new a());
    }

    private final RecyclerView B(View parent) {
        if (parent instanceof RecyclerView) {
            return (RecyclerView) parent;
        }
        if (!(parent instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView B = B(viewGroup.getChildAt(i3));
            if (B != null) {
                return B;
            }
        }
        return null;
    }

    /* renamed from: C, reason: from getter */
    public final boolean getEnableLoadMore() {
        return this.enableLoadMore;
    }

    /* renamed from: D, reason: from getter */
    public final RecyclerView.OnScrollListener getOnRecyclerViewScrollListener() {
        return this.onRecyclerViewScrollListener;
    }

    /* renamed from: E, reason: from getter */
    public final OnRefreshStateListener getOnRefreshStateListener() {
        return this.onRefreshStateListener;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        cg0.a.b("RefreshableLayout", "addView start, this=" + this);
        if (child instanceof BaseRefreshHeader) {
            return;
        }
        RecyclerView B = B(child);
        cg0.a.b("RefreshableLayout", "try findRecycleView, this=" + this + ", recyclerView=" + B);
        if (B != null) {
            if (B instanceof RecyclerViewWithHeaderFooter) {
                ((RecyclerViewWithHeaderFooter) B).E(this.loadMoreFooter);
            }
            B.addOnScrollListener(new b());
            r(child);
            B.setVisibility(this.recyclerViewVisible ? 0 : 8);
            Unit unit = Unit.INSTANCE;
            s(B);
            this.hasAddRecyclerView = true;
            cg0.a.b("RefreshableLayout", "addView end, this=" + this);
            return;
        }
        throw new RuntimeException("must add recycleView");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getHeaderView() == null) {
            setHeaderView(this.refreshHeader);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        cg0.a.b("RefreshableLayout", "onViewAdded this=" + this);
    }

    public final void setEnableLoadMore(boolean z16) {
        this.enableLoadMore = z16;
        if (z16) {
            if (this.hideFooterBeforeLoadingMore && !this.hasLoadingMore) {
                this.loadMoreFooter.setVisible(false);
                return;
            }
            if (g().getVisibility() == 0) {
                this.loadMoreFooter.setVisible(true);
                return;
            }
            return;
        }
        if (this.hideFooterIfNoMore) {
            this.loadMoreFooter.setVisible(false);
            return;
        }
        if (g().getVisibility() == 0) {
            this.loadMoreFooter.setVisible(true);
        }
    }

    public final void setHideFooterBeforeLoadingMore(boolean z16) {
        this.hideFooterBeforeLoadingMore = z16;
    }

    public final void setHideFooterIfNoMore(boolean z16) {
        this.hideFooterIfNoMore = z16;
    }

    public final void setOnRecyclerViewScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.onRecyclerViewScrollListener = onScrollListener;
    }

    public final void setOnRefreshStateListener(OnRefreshStateListener onRefreshStateListener) {
        this.onRefreshStateListener = onRefreshStateListener;
    }

    @Override // com.tencent.ecommerce.base.list.IStateRefreshView
    public void updateHasMore(boolean hasMore) {
        setEnableLoadMore(hasMore);
    }

    @Override // com.tencent.ecommerce.base.list.IStateRefreshView
    public void finishLoadMore(boolean isSucceeded) {
        this.isLoadingMore = false;
        if (!isSucceeded) {
            this.loadMoreFooter.a();
        } else {
            this.loadMoreFooter.b();
        }
    }

    @Override // com.tencent.ecommerce.base.list.IStateRefreshView
    public void setVisible(boolean isVisible, boolean visibleToList) {
        if (visibleToList) {
            cg0.a.b("RefreshableLayout", "setVisible, hasAddRecyclerView=" + this.hasAddRecyclerView + ", this=" + this);
            if (this.hasAddRecyclerView) {
                g().setVisibility(isVisible ? 0 : 8);
            }
            this.loadMoreFooter.setVisibility(isVisible ? 0 : 8);
            return;
        }
        setVisibility(isVisible ? 0 : 8);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "", "onLoadMoreBegin", "", "onRefreshBegin", "tag", "", "onRefreshFinished", "isSucceeded", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public interface OnRefreshStateListener {
        void onLoadMoreBegin();

        void onRefreshBegin(int tag);

        void onRefreshFinished(boolean isSucceeded, int tag);

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes32.dex */
        public static final class a {
            public static void a(OnRefreshStateListener onRefreshStateListener, boolean z16, int i3) {
            }
        }
    }
}
