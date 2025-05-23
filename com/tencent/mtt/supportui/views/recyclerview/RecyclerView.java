package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.tencent.mtt.supportui.views.ScrollChecker;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class RecyclerView extends RecyclerViewBase implements ScrollChecker.IScrollCheck, RecyclerViewBase.OnScrollListener {
    public CopyOnWriteArrayList<OnListScrollListener> mListScrollListeners;
    public RecyclerAdapter mRecyclerViewAdapter;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface OnListScrollListener {
        void onDragEnd();

        void onScroll(int i3, int i16);

        void onScrollEnd();

        void onStartDrag();

        void onStartFling();
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class ViewHolderWrapper extends RecyclerViewBase.ViewHolder {
        public ViewHolderWrapper(View view, RecyclerViewBase recyclerViewBase) {
            super(view, recyclerViewBase);
            if (view instanceof RecyclerViewItem) {
                this.mContent = ((RecyclerViewItem) view).mContentView;
            }
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder
        public void inTraversals(int i3) {
            if (i3 != 1991102 && i3 != 1991103) {
                ContentHolder contentHolder = this.mContentHolder;
                if (contentHolder != null) {
                    contentHolder.inTraversals(i3, this.mPosition, this.mParent);
                    return;
                }
                return;
            }
            this.mBindNextTime = true;
        }

        public void setContentHolder(ContentHolder contentHolder) {
            this.mContentHolder = contentHolder;
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewHolder
        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("holder:" + Integer.toHexString(hashCode()) + ",pos=" + getPosition() + ",");
            ContentHolder contentHolder = this.mContentHolder;
            if (contentHolder != null) {
                sb5.append(contentHolder.toString());
            }
            return sb5.toString();
        }
    }

    public RecyclerView(Context context) {
        super(context);
        this.mListScrollListeners = null;
        setOverScrollEnabled(true);
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(false);
        setOnScrollListener(this);
        setAnimationCacheEnabled(false);
    }

    public void addOnListScrollListener(OnListScrollListener onListScrollListener) {
        if (this.mListScrollListeners == null) {
            this.mListScrollListeners = new CopyOnWriteArrayList<>();
        }
        if (!this.mListScrollListeners.contains(onListScrollListener)) {
            this.mListScrollListeners.add(onListScrollListener);
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean canTranversal(int i3, RecyclerViewBase.ViewHolder viewHolder) {
        return super.canTranversal(i3, viewHolder);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void checkNotifyFooterAppearWithFewChild(int i3) {
        View childClosestToEndInScreen;
        RecyclerViewBase.Adapter adapter = getAdapter();
        if (adapter != null && this.mOffsetY + getHeight() >= adapter.getListTotalHeight() - adapter.getDefaultFooterHeight() && (childClosestToEndInScreen = getLayoutManager().getChildClosestToEndInScreen()) != null && (childClosestToEndInScreen instanceof IRecyclerViewFooter)) {
            adapter.notifyLastFooterAppeared();
        }
    }

    public View createFooterView(Context context) {
        return null;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public RecyclerViewBase.ViewHolder createViewHolder(View view, RecyclerViewBase recyclerViewBase) {
        return new ViewHolderWrapper(view, recyclerViewBase);
    }

    public RecyclerViewItem createViewItem() {
        return new RecyclerViewItem(getContext(), this);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public int findNextSuspentedPos(int i3) {
        return this.mAdapter.findNextSuspentedPos(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public int findPrevSuspentedPos(int i3) {
        return this.mAdapter.findPrevSuspentedPos(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public int getHeightBefore(int i3) {
        RecyclerAdapter recyclerAdapter = this.mRecyclerViewAdapter;
        if (recyclerAdapter != null) {
            return recyclerAdapter.getHeightBefore(i3);
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck
    public boolean horizontalCanScroll(int i3) {
        RecyclerViewBase.LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !this.mHorizontalCanScroll || !layoutManager.canScrollHorizontally()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    protected boolean needAdvancedStopDetachChildView() {
        return false;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        onOrientationChanged();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void onItemsFill(int i3) {
        super.onItemsFill(i3);
        RecyclerViewBase.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.onItemsFill(i3);
        }
    }

    public void onScrollStateChanged(int i3, int i16) {
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2 && i3 == 1) {
                    onScrollDragEnded();
                    onScrollFlingStarted();
                    CopyOnWriteArrayList<OnListScrollListener> copyOnWriteArrayList = this.mListScrollListeners;
                    if (copyOnWriteArrayList != null) {
                        Iterator<OnListScrollListener> it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            it.next().onStartFling();
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (i3 == 0) {
                onScrollDragStarted();
                CopyOnWriteArrayList<OnListScrollListener> copyOnWriteArrayList2 = this.mListScrollListeners;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<OnListScrollListener> it5 = copyOnWriteArrayList2.iterator();
                    while (it5.hasNext()) {
                        it5.next().onStartDrag();
                    }
                    return;
                }
                return;
            }
            if (i3 == 2) {
                onScrollFlingEnded();
                onScrollDragStarted();
                return;
            }
            return;
        }
        if (i3 == 2) {
            onScrollFlingEnded();
            CopyOnWriteArrayList<OnListScrollListener> copyOnWriteArrayList3 = this.mListScrollListeners;
            if (copyOnWriteArrayList3 != null) {
                Iterator<OnListScrollListener> it6 = copyOnWriteArrayList3.iterator();
                while (it6.hasNext()) {
                    it6.next().onScrollEnd();
                }
                return;
            }
            return;
        }
        if (i3 == 1) {
            onScrollDragEnded();
            CopyOnWriteArrayList<OnListScrollListener> copyOnWriteArrayList4 = this.mListScrollListeners;
            if (copyOnWriteArrayList4 != null) {
                Iterator<OnListScrollListener> it7 = copyOnWriteArrayList4.iterator();
                while (it7.hasNext()) {
                    it7.next().onDragEnd();
                }
            }
        }
    }

    public void onScrolled(int i3, int i16) {
        CopyOnWriteArrayList<OnListScrollListener> copyOnWriteArrayList = this.mListScrollListeners;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            Iterator<OnListScrollListener> it = this.mListScrollListeners.iterator();
            while (it.hasNext()) {
                it.next().onScroll(i3, i16);
            }
        }
    }

    public void removeOnListScrollListener(OnListScrollListener onListScrollListener) {
        CopyOnWriteArrayList<OnListScrollListener> copyOnWriteArrayList = this.mListScrollListeners;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.contains(onListScrollListener)) {
            this.mListScrollListeners.remove(onListScrollListener);
        }
    }

    public void reset() {
        scrollToPosition(0);
        this.mOffsetY = 0;
        this.mInitialTouchY = 0;
        this.mLastTouchY = 0;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mVelocityTracker = null;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase
    public void setAdapter(RecyclerViewBase.Adapter adapter) {
        super.setAdapter(adapter);
        this.mRecyclerViewAdapter = (RecyclerAdapter) adapter;
    }

    @Override // com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck
    public boolean verticalCanScroll(int i3) {
        RecyclerViewBase.LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !this.mVerticalCanScroll || !layoutManager.canScrollVertically()) {
            return false;
        }
        return true;
    }

    public void onOrientationChanged() {
    }

    protected void onScrollDragEnded() {
    }

    protected void onScrollDragStarted() {
    }

    protected void onScrollFlingEnded() {
    }

    protected void onScrollFlingStarted() {
    }
}
