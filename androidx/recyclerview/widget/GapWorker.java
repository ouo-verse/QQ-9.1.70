package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    static Comparator<Task> sTaskComparator = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            RecyclerView recyclerView = task.view;
            if ((recyclerView == null) != (task2.view == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z16 = task.immediate;
            if (z16 != task2.immediate) {
                return z16 ? -1 : 1;
            }
            int i3 = task2.viewVelocity - task.viewVelocity;
            if (i3 != 0) {
                return i3;
            }
            int i16 = task.distanceToItem - task2.distanceToItem;
            if (i16 != 0) {
                return i16;
            }
            return 0;
        }
    };
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    private ArrayList<Task> mTasks = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i3, int i16) {
            if (i3 >= 0) {
                if (i16 >= 0) {
                    int i17 = this.mCount * 2;
                    int[] iArr = this.mPrefetchArray;
                    if (iArr == null) {
                        int[] iArr2 = new int[4];
                        this.mPrefetchArray = iArr2;
                        Arrays.fill(iArr2, -1);
                    } else if (i17 >= iArr.length) {
                        int[] iArr3 = new int[i17 * 2];
                        this.mPrefetchArray = iArr3;
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    }
                    int[] iArr4 = this.mPrefetchArray;
                    iArr4[i17] = i3;
                    iArr4[i17 + 1] = i16;
                    this.mCount++;
                    return;
                }
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clearPrefetchPositions() {
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mCount = 0;
        }

        void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z16) {
            this.mCount = 0;
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z16) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                int i3 = this.mCount;
                if (i3 > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i3;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z16;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean lastPrefetchIncludedPosition(int i3) {
            if (this.mPrefetchArray != null) {
                int i16 = this.mCount * 2;
                for (int i17 = 0; i17 < i16; i17 += 2) {
                    if (this.mPrefetchArray[i17] == i3) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setPrefetchVector(int i3, int i16) {
            this.mPrefetchDx = i3;
            this.mPrefetchDy = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    private void buildTaskList() {
        Task task;
        boolean z16;
        int size = this.mRecyclerViews.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i16);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                i3 += recyclerView.mPrefetchRegistry.mCount;
            }
        }
        this.mTasks.ensureCapacity(i3);
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i18);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                for (int i19 = 0; i19 < layoutPrefetchRegistryImpl.mCount * 2; i19 += 2) {
                    if (i17 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i17);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.mPrefetchArray;
                    int i26 = iArr[i19 + 1];
                    if (i26 <= abs) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    task.immediate = z16;
                    task.viewVelocity = abs;
                    task.distanceToItem = i26;
                    task.view = recyclerView2;
                    task.position = iArr[i19];
                    i17++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(Task task, long j3) {
        long j16;
        if (task.immediate) {
            j16 = Long.MAX_VALUE;
        } else {
            j16 = j3;
        }
        RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task.view, task.position, j16);
        if (prefetchPositionWithDeadline != null && prefetchPositionWithDeadline.mNestedRecyclerView != null && prefetchPositionWithDeadline.isBound() && !prefetchPositionWithDeadline.isInvalid()) {
            prefetchInnerRecyclerViewWithDeadline(prefetchPositionWithDeadline.mNestedRecyclerView.get(), j3);
        }
    }

    private void flushTasksWithDeadline(long j3) {
        for (int i3 = 0; i3 < this.mTasks.size(); i3++) {
            Task task = this.mTasks.get(i3);
            if (task.view != null) {
                flushTaskWithDeadline(task, j3);
                task.clear();
            } else {
                return;
            }
        }
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i3) {
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        for (int i16 = 0; i16 < unfilteredChildCount; i16++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i16));
            if (childViewHolderInt.mPosition == i3 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j3) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
        if (layoutPrefetchRegistryImpl.mCount != 0) {
            try {
                TraceCompat.beginSection("RV Nested Prefetch");
                recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                for (int i3 = 0; i3 < layoutPrefetchRegistryImpl.mCount * 2; i3 += 2) {
                    prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[i3], j3);
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i3, long j3) {
        if (isPrefetchPositionAttached(recyclerView, i3)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i3, false, j3);
            if (tryGetViewHolderForPositionByDeadline != null) {
                if (tryGetViewHolderForPositionByDeadline.isBound() && !tryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
                } else {
                    recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
                }
            }
            return tryGetViewHolderForPositionByDeadline;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postFromTraversal(RecyclerView recyclerView, int i3, int i16) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(i3, i16);
    }

    void prefetch(long j3) {
        buildTaskList();
        flushTasksWithDeadline(j3);
    }

    public void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                int size = this.mRecyclerViews.size();
                long j3 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView recyclerView = this.mRecyclerViews.get(i3);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j3 = Math.max(recyclerView.getDrawingTime(), j3);
                    }
                }
                if (j3 != 0) {
                    prefetch(TimeUnit.MILLISECONDS.toNanos(j3) + this.mFrameIntervalNs);
                }
            }
        } finally {
            this.mPostTimeNs = 0L;
            TraceCompat.endSection();
        }
    }
}
