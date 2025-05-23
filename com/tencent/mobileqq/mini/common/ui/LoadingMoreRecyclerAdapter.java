package com.tencent.mobileqq.mini.common.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 -*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002-.B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0012H\u0014J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0012H\u0014J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0015\u0010$\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\b%J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\bJ\u0016\u0010+\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000RH\u0010\n\u001a6\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bj\u0002`\u0013X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0004R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter;", "()V", "mHasMore", "", "mLoadMoreListener", "Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter$OnLoadMoreListener;", "mLoadSuccess", "mLoadingMoreFooter", "Lkotlin/Function2;", "Landroid/view/LayoutInflater;", "Lkotlin/ParameterName;", "name", "layoutInflater", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "Lcom/tencent/mobileqq/mini/common/ui/ViewFactory;", "getMLoadingMoreFooter$annotations", "mPendingBindingLoadMoreStateToLoadMoreFooterView", "mShowLoadingMore", "canLoadMore", "view", "createLoadingMoreFooterView", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindLoadStatusToLoadMoreView", "success", "hasMore", "onCustomizeLoadLayout", "loadLayout", "Lcom/tencent/mobileqq/mini/common/ui/LoadLayout;", "onLoadFooterShown", "onLoadFooterShown$qqmini_impl_release", "onLoadMore", "performSetLoadingMoreVisible", "show", "setLoadMoreListener", "listener", "setLoadingComplete", "setShowLoadingMore", "Companion", "OnLoadMoreListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class LoadingMoreRecyclerAdapter<T extends RecyclerView.ViewHolder> extends RecyclerWrapperAdapter<T> {
    private static final String TAG = "LoadingMoreRecyclerAdapter";
    public static final int VIEW_TYPE_LOAD_MORE = -2147482623;
    private boolean mHasMore;
    private OnLoadMoreListener mLoadMoreListener;
    private boolean mPendingBindingLoadMoreStateToLoadMoreFooterView;
    private final Function2<LayoutInflater, ViewGroup, View> mLoadingMoreFooter = new LoadingMoreRecyclerAdapter$mLoadingMoreFooter$1(this);
    private boolean mShowLoadingMore = true;
    private boolean mLoadSuccess = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter$OnLoadMoreListener;", "", "onNeedLoadMore", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface OnLoadMoreListener {
        void onNeedLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void createLoadingMoreFooterView$lambda$0(LoadingMoreRecyclerAdapter this$0, Ref.ObjectRef view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        T t16 = view.element;
        Intrinsics.checkNotNull(t16);
        this$0.onLoadFooterShown$qqmini_impl_release((View) t16);
    }

    protected boolean canLoadMore(View view) {
        int mState;
        Intrinsics.checkNotNullParameter(view, "view");
        return (!(view instanceof LoadLayout) || (mState = ((LoadLayout) view).getMState()) == 4 || mState == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.mini.common.ui.LoadLayout, android.view.View] */
    public View createLoadingMoreFooterView(LayoutInflater layoutInflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        ?? loadLayout = new LoadLayout(context, new Runnable() { // from class: com.tencent.mobileqq.mini.common.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                LoadingMoreRecyclerAdapter.createLoadingMoreFooterView$lambda$0(LoadingMoreRecyclerAdapter.this, objectRef);
            }
        });
        objectRef.element = loadLayout;
        loadLayout.setState(1);
        onCustomizeLoadLayout(loadLayout);
        loadLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return loadLayout;
    }

    @Override // com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        performSetLoadingMoreVisible(this.mShowLoadingMore);
    }

    protected void onBindLoadStatusToLoadMoreView(boolean success, boolean hasMore, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof LoadLayout) {
            int i3 = 3;
            if (success && !hasMore) {
                i3 = 4;
            }
            ((LoadLayout) view).setState(i3);
        }
    }

    public void onCustomizeLoadLayout(LoadLayout loadLayout) {
        Intrinsics.checkNotNullParameter(loadLayout, "loadLayout");
    }

    public final void onLoadFooterShown$qqmini_impl_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mPendingBindingLoadMoreStateToLoadMoreFooterView) {
            onBindLoadStatusToLoadMoreView(this.mLoadSuccess, this.mHasMore, view);
            this.mPendingBindingLoadMoreStateToLoadMoreFooterView = false;
        }
        if (canLoadMore(view)) {
            onLoadMore(view);
        }
    }

    public void onLoadMore(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof LoadLayout) {
            ((LoadLayout) view).setState(2);
        }
        OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
        if (onLoadMoreListener != null) {
            onLoadMoreListener.onNeedLoadMore();
        }
    }

    public final void setLoadMoreListener(OnLoadMoreListener listener) {
        this.mLoadMoreListener = listener;
    }

    public final void setLoadingComplete(boolean success, boolean hasMore) {
        RecyclerView attachedRecyclerView;
        this.mLoadSuccess = success;
        this.mHasMore = hasMore;
        int findFooterIndex = findFooterIndex(-2147482623);
        if (findFooterIndex != -1 && (attachedRecyclerView = getAttachedRecyclerView()) != null && attachedRecyclerView.getChildCount() > 0) {
            for (int childCount = attachedRecyclerView.getChildCount() - 1; childCount < 1; childCount++) {
                View child = attachedRecyclerView.getChildAt(childCount);
                if (attachedRecyclerView.getChildViewHolder(child).getAdapterPosition() == findFooterIndex) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    onBindLoadStatusToLoadMoreView(success, hasMore, child);
                    return;
                }
            }
        }
        this.mPendingBindingLoadMoreStateToLoadMoreFooterView = true;
        notifyItemChanged(findFooterIndex);
    }

    public final void setShowLoadingMore(boolean show) {
        this.mShowLoadingMore = show;
        if (getAttachedRecyclerView() != null) {
            performSetLoadingMoreVisible(show);
        }
    }

    private final void performSetLoadingMoreVisible(boolean show) {
        if (show) {
            if (isFooterAdded(-2147482623)) {
                return;
            }
            addFooter(this.mLoadingMoreFooter, -2147482623, new RecyclerWrapperAdapter.OnShowListener(this) { // from class: com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter$performSetLoadingMoreVisible$1
                final /* synthetic */ LoadingMoreRecyclerAdapter<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                }

                @Override // com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter.OnShowListener
                public void onShow(View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    this.this$0.onLoadFooterShown$qqmini_impl_release(view);
                }
            });
            return;
        }
        removeFooter(-2147482623);
    }

    private static /* synthetic */ void getMLoadingMoreFooter$annotations() {
    }
}
