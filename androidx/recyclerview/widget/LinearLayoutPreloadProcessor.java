package androidx.recyclerview.widget;

import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\r"}, d2 = {"Landroidx/recyclerview/widget/LinearLayoutPreloadProcessor;", "Landroidx/recyclerview/widget/AbsPreloadProcessor;", "()V", "isTargetProcess", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "preloadAfterScrolled", "", "preloadConfig", "Landroidx/recyclerview/widget/ItemPreloadConfig;", "historyInfo", "Landroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class LinearLayoutPreloadProcessor extends AbsPreloadProcessor {
    @Override // androidx.recyclerview.widget.AbsPreloadProcessor
    public boolean isTargetProcess(@NotNull RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if ((view.getLayoutManager() instanceof LinearLayoutManager) && !(view.getLayoutManager() instanceof GridLayoutManager)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0112 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0113  */
    @Override // androidx.recyclerview.widget.AbsPreloadProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preloadAfterScrolled(@NotNull RecyclerView view, @NotNull ItemPreloadConfig preloadConfig, @Nullable RecyclerViewInflateHistoryInfo historyInfo) {
        int coerceAtMost;
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(preloadConfig, "preloadConfig");
        RecyclerView.Adapter adapter = view.mAdapter;
        if (adapter != null) {
            RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
            if (layoutManager != null) {
                int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() + 1;
                if (view.hashCode() == getLastHandleRecyclerView() && findLastVisibleItemPosition == getLastHandlePosition()) {
                    if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                        RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "same lastPosition: " + getLastHandlePosition());
                        return;
                    }
                    return;
                }
                setLastHandleRecyclerView(view.hashCode());
                setLastHandlePosition(findLastVisibleItemPosition);
                LinkedHashSet<RecyclerView.ViewHolder> allAttachedViewHolder = RecyclerViewHelper.INSTANCE.getAllAttachedViewHolder(view);
                long nanoTime = System.nanoTime();
                Map<Integer, ViewHolderData> historyViewHolderData = getHistoryViewHolderData(allAttachedViewHolder, view);
                int height = (int) (view.getHeight() * preloadConfig.getPreloadPageCount());
                int i16 = height / 8;
                SparseIntArray sparseIntArray = new SparseIntArray();
                int i17 = 0;
                int i18 = 0;
                while (i17 < height) {
                    int findPositionOffset = view.mAdapterHelper.findPositionOffset(findLastVisibleItemPosition + i18);
                    if (findPositionOffset >= 0 && findPositionOffset < adapter.getNUM_BACKGOURND_ICON()) {
                        int itemViewType = adapter.getItemViewType(findPositionOffset);
                        sparseIntArray.put(itemViewType, sparseIntArray.get(itemViewType, 0) + 1);
                        ViewHolderData viewHolderData = historyViewHolderData.get(Integer.valueOf(itemViewType));
                        if (viewHolderData != null) {
                            i3 = RangesKt___RangesKt.coerceAtLeast(viewHolderData.getTotalHeight() / viewHolderData.getTotalCount(), i16);
                        } else {
                            i3 = i16;
                        }
                        i17 += i3;
                        i18++;
                    } else {
                        if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                            RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "stop with offsetPosition:" + findPositionOffset);
                        }
                        if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                            RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "can preload count " + i18 + " height:" + i17);
                        }
                        if (i18 != 0) {
                            return;
                        }
                        SparseIntArray sparseIntArray2 = new SparseIntArray();
                        if (preloadConfig.getConsiderRecycler()) {
                            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i17, height);
                            for (RecyclerView.ViewHolder viewHolder : allAttachedViewHolder) {
                                View view2 = viewHolder.itemView;
                                Intrinsics.checkNotNullExpressionValue(view2, "attachHolder.itemView");
                                int height2 = view2.getHeight();
                                if (coerceAtMost > 0) {
                                    coerceAtMost -= height2;
                                    int i19 = sparseIntArray2.get(viewHolder.getItemViewType(), 0) + 1;
                                    sparseIntArray2.put(viewHolder.getItemViewType(), i19);
                                    if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                                        RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "target remove height:" + height2 + " itemType:" + viewHolder.getItemViewType() + " itemCount:" + i19);
                                    }
                                }
                            }
                        }
                        preloadView(view, sparseIntArray, sparseIntArray2, historyInfo);
                        if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                            RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "cost: " + (System.nanoTime() - nanoTime));
                            return;
                        }
                        return;
                    }
                }
                if (ArgusRecycleViewPreloader.INSTANCE.getDEBUG()) {
                }
                if (i18 != 0) {
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        }
    }
}
