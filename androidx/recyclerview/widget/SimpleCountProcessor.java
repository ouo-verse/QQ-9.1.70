package androidx.recyclerview.widget;

import android.util.SparseIntArray;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Landroidx/recyclerview/widget/SimpleCountProcessor;", "Landroidx/recyclerview/widget/AbsPreloadProcessor;", "()V", "getLastVisibleItemPosition", "", "manager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "isTargetProcess", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "preloadAfterScrolled", "", "preloadConfig", "Landroidx/recyclerview/widget/ItemPreloadConfig;", "historyInfo", "Landroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public abstract class SimpleCountProcessor extends AbsPreloadProcessor {
    public abstract int getLastVisibleItemPosition(@NotNull RecyclerView.LayoutManager manager);

    @Override // androidx.recyclerview.widget.AbsPreloadProcessor
    public boolean isTargetProcess(@NotNull RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return true;
    }

    @Override // androidx.recyclerview.widget.AbsPreloadProcessor
    public void preloadAfterScrolled(@NotNull RecyclerView view, @NotNull ItemPreloadConfig preloadConfig, @Nullable RecyclerViewInflateHistoryInfo historyInfo) {
        int findPositionOffset;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(preloadConfig, "preloadConfig");
        RecyclerView.Adapter adapter = view.getAdapter();
        if (adapter != null) {
            Intrinsics.checkNotNullExpressionValue(adapter, "view.adapter ?: return");
            RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
            if (layoutManager != null) {
                int lastVisibleItemPosition = getLastVisibleItemPosition(layoutManager);
                if (lastVisibleItemPosition < 0) {
                    return;
                }
                int i3 = lastVisibleItemPosition + 1;
                LinkedHashSet<RecyclerView.ViewHolder> allAttachedViewHolder = RecyclerViewHelper.INSTANCE.getAllAttachedViewHolder(view);
                long nanoTime = System.nanoTime();
                int size = allAttachedViewHolder.size() + i3;
                SparseIntArray sparseIntArray = new SparseIntArray();
                if (i3 <= size) {
                    while (true) {
                        findPositionOffset = view.mAdapterHelper.findPositionOffset(i3);
                        if (findPositionOffset < 0 || findPositionOffset >= adapter.getItemCount()) {
                            break;
                        }
                        int itemViewType = adapter.getItemViewType(findPositionOffset);
                        sparseIntArray.put(itemViewType, sparseIntArray.get(itemViewType, 0) + 1);
                        if (i3 == size) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "stop with offsetPosition:" + findPositionOffset);
                }
                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "can preload count " + allAttachedViewHolder.size());
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                for (RecyclerView.ViewHolder viewHolder : allAttachedViewHolder) {
                    int i16 = sparseIntArray2.get(viewHolder.getItemViewType(), 0) + 1;
                    sparseIntArray2.put(viewHolder.getItemViewType(), i16);
                    RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "target remove height itemType:" + viewHolder.getItemViewType() + " itemCount:" + i16);
                }
                preloadView(view, sparseIntArray, sparseIntArray2, historyInfo);
                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "cost: " + (System.nanoTime() - nanoTime));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }
}
