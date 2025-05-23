package com.tencent.mobileqq.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0002)*B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0018\u0010 \u001a\u00060\u001fR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/util/bz;", "", "", "tryCheckScrollToDispatchChanged", "resetSum", "tryDispatchImpStates", "dispatchImpStates", "Lkotlin/ranges/IntRange;", "getVisibleItemRange", "", "position", "dispatchItemImp", QCircleLpReportDc05507.KEY_CLEAR, "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/util/bz$b;", "onItemDisplayCallback", "Lcom/tencent/mobileqq/util/bz$b;", "scrollThreshold", "I", "", "pendingIdleInterval", "J", HippyTKDListViewAdapter.SCROLL_STATE, "dxSum", "dySum", "Ljava/lang/Runnable;", "pendingRun", "Ljava/lang/Runnable;", "pendingDispatchRunnable", "Lcom/tencent/mobileqq/util/bz$c;", "adapterDataObserver", "Lcom/tencent/mobileqq/util/bz$c;", "", "displayItemSet", "Ljava/util/Set;", "getDisplayItemSet", "()Ljava/util/Set;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/util/bz$b;)V", "b", "c", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class bz {

    @NotNull
    private final c adapterDataObserver;

    @NotNull
    private final Set<Object> displayItemSet;
    private int dxSum;
    private int dySum;

    @Nullable
    private final b onItemDisplayCallback;

    @NotNull
    private final Runnable pendingDispatchRunnable;
    private final long pendingIdleInterval;

    @Nullable
    private Runnable pendingRun;

    @NotNull
    private final RecyclerView recycleView;
    private int scrollState;
    private final int scrollThreshold;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/util/bz$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            bz.this.scrollState = newState;
            bz.this.tryCheckScrollToDispatchChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            bz.this.dxSum += dx5;
            bz.this.dySum += dy5;
            bz.this.tryCheckScrollToDispatchChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/util/bz$b;", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u000f\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/util/bz$c;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "", "positionStart", "itemCount", "onItemRangeChanged", "", "payload", "onItemRangeInserted", "fromPosition", "toPosition", "onItemRangeMoved", "onItemRangeRemoved", "a", "<init>", "(Lcom/tencent/mobileqq/util/bz;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    private final class c extends RecyclerView.AdapterDataObserver {
        public c() {
        }

        public final void a() {
            bz.this.recycleView.removeCallbacks(bz.this.pendingDispatchRunnable);
            bz.this.recycleView.postDelayed(bz.this.pendingDispatchRunnable, bz.this.pendingIdleInterval);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
            a();
        }
    }

    public bz(@NotNull RecyclerView recycleView, @Nullable b bVar) {
        Intrinsics.checkNotNullParameter(recycleView, "recycleView");
        this.recycleView = recycleView;
        this.scrollThreshold = ViewUtils.dpToPx(20.0f);
        this.pendingIdleInterval = 200L;
        this.scrollState = recycleView.getScrollState();
        this.pendingDispatchRunnable = new Runnable() { // from class: com.tencent.mobileqq.util.bx
            @Override // java.lang.Runnable
            public final void run() {
                bz.pendingDispatchRunnable$lambda$0(bz.this);
            }
        };
        c cVar = new c();
        this.adapterDataObserver = cVar;
        this.displayItemSet = new LinkedHashSet();
        recycleView.addOnScrollListener(new a());
        RecyclerView.Adapter adapter = recycleView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(cVar);
        }
    }

    private final void dispatchImpStates() {
        IntRange visibleItemRange = getVisibleItemRange();
        if (visibleItemRange != null) {
            Iterator<Integer> it = visibleItemRange.iterator();
            while (it.hasNext()) {
                dispatchItemImp(((IntIterator) it).nextInt());
            }
        }
    }

    private final IntRange getVisibleItemRange() {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        RecyclerView.LayoutManager layoutManager = this.recycleView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) < 0 || (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) < findFirstVisibleItemPosition) {
            return null;
        }
        return new IntRange(findFirstVisibleItemPosition, findLastVisibleItemPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pendingDispatchRunnable$lambda$0(bz this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pendingRun = null;
        this$0.dispatchImpStates();
    }

    private final void resetSum() {
        this.dxSum = 0;
        this.dySum = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryCheckScrollToDispatchChanged() {
        if (this.scrollState == 0) {
            resetSum();
            tryDispatchImpStates();
        } else if (Math.abs(this.dxSum) >= this.scrollThreshold || Math.abs(this.dySum) >= this.scrollThreshold) {
            resetSum();
            tryDispatchImpStates();
        }
    }

    private final void tryDispatchImpStates() {
        this.recycleView.removeCallbacks(this.pendingDispatchRunnable);
        if (this.scrollState == 0) {
            this.recycleView.postDelayed(this.pendingDispatchRunnable, this.pendingIdleInterval);
        } else {
            dispatchImpStates();
        }
    }

    public final void clear() {
        this.displayItemSet.clear();
        this.recycleView.removeCallbacks(this.pendingRun);
        RecyclerView.Adapter adapter = this.recycleView.getAdapter();
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.adapterDataObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Set<Object> getDisplayItemSet() {
        return this.displayItemSet;
    }

    public void dispatchItemImp(int position) {
    }
}
