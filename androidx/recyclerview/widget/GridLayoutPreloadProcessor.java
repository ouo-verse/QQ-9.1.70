package androidx.recyclerview.widget;

import android.util.SparseIntArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\r"}, d2 = {"Landroidx/recyclerview/widget/GridLayoutPreloadProcessor;", "Landroidx/recyclerview/widget/AbsPreloadProcessor;", "()V", "isTargetProcess", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "preloadAfterScrolled", "", "preloadConfig", "Landroidx/recyclerview/widget/ItemPreloadConfig;", "historyInfo", "Landroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class GridLayoutPreloadProcessor extends AbsPreloadProcessor {
    @Override // androidx.recyclerview.widget.AbsPreloadProcessor
    public boolean isTargetProcess(@NotNull RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getLayoutManager() instanceof GridLayoutManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    @Override // androidx.recyclerview.widget.AbsPreloadProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preloadAfterScrolled(@NotNull RecyclerView view, @NotNull ItemPreloadConfig preloadConfig, @Nullable RecyclerViewInflateHistoryInfo historyInfo) {
        int findPositionOffset;
        int coerceAtMost;
        Iterator it;
        boolean z16;
        int i3;
        RecyclerView view2 = view;
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(preloadConfig, "preloadConfig");
        RecyclerView.Adapter adapter = view.getAdapter();
        if (adapter != null) {
            Intrinsics.checkNotNullExpressionValue(adapter, "view.adapter ?: return");
            RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
            if (layoutManager != null) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
                Intrinsics.checkNotNullExpressionValue(spanSizeLookup, "manager.spanSizeLookup");
                spanSizeLookup.setSpanIndexCacheEnabled(true);
                GridLayoutManager.SpanSizeLookup spanSizeLookup2 = gridLayoutManager.getSpanSizeLookup();
                Intrinsics.checkNotNullExpressionValue(spanSizeLookup2, "manager.spanSizeLookup");
                spanSizeLookup2.setSpanGroupIndexCacheEnabled(true);
                int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition() + 1;
                LinkedHashSet<RecyclerView.ViewHolder> allAttachedViewHolder = RecyclerViewHelper.INSTANCE.getAllAttachedViewHolder(view2);
                long nanoTime = System.nanoTime();
                Map<Integer, ViewHolderData> historyViewHolderData = getHistoryViewHolderData(allAttachedViewHolder, view2);
                int height = view.getHeight();
                int i16 = height / 4;
                int spanCount = gridLayoutManager.getSpanCount();
                SparseIntArray sparseIntArray = new SparseIntArray();
                int i17 = 0;
                int i18 = 0;
                while (true) {
                    int i19 = findLastVisibleItemPosition;
                    findPositionOffset = view2.mAdapterHelper.findPositionOffset(findLastVisibleItemPosition + i18);
                    if (findPositionOffset < 0) {
                        break;
                    }
                    RecyclerView.Adapter adapter2 = view2.mAdapter;
                    Intrinsics.checkNotNullExpressionValue(adapter2, "view.mAdapter");
                    if (findPositionOffset >= adapter2.getNUM_BACKGOURND_ICON()) {
                        break;
                    }
                    int itemViewType = adapter.getItemViewType(findPositionOffset);
                    int spanSize = gridLayoutManager.getSpanSizeLookup().getSpanSize(findPositionOffset);
                    if (spanSize != gridLayoutManager.getSpanCount()) {
                        if (spanCount >= spanSize) {
                            if (spanCount == gridLayoutManager.getSpanCount()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            spanCount -= spanSize;
                            if (!z16) {
                                if (i17 >= height) {
                                    break;
                                }
                                ViewHolderData viewHolderData = historyViewHolderData.get(Integer.valueOf(itemViewType));
                                if (viewHolderData != null) {
                                    i3 = RangesKt___RangesKt.coerceAtLeast(viewHolderData.getTotalHeight() / viewHolderData.getTotalCount(), i16);
                                } else {
                                    i3 = i16;
                                }
                                i17 += i3;
                                i18++;
                                sparseIntArray.put(itemViewType, sparseIntArray.get(itemViewType, 0) + 1);
                            } else {
                                i18++;
                                sparseIntArray.put(itemViewType, sparseIntArray.get(itemViewType, 0) + 1);
                            }
                            view2 = view;
                            findLastVisibleItemPosition = i19;
                        } else {
                            spanCount = gridLayoutManager.getSpanCount() - spanSize;
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                    view2 = view;
                    findLastVisibleItemPosition = i19;
                }
                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "stop with offsetPosition:" + findPositionOffset);
                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "can preload count " + i18 + " height:" + i17 + " cost: " + (System.nanoTime() - nanoTime));
                if (i18 == 0) {
                    return;
                }
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i17, height);
                Iterator it5 = allAttachedViewHolder.iterator();
                int i26 = coerceAtMost;
                boolean z17 = false;
                while (it5.hasNext()) {
                    RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it5.next();
                    if (!z17) {
                        int spanIndex = gridLayoutManager.getSpanSizeLookup().getSpanIndex(viewHolder.getAdapterPosition(), gridLayoutManager.getSpanCount());
                        View view3 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view3, "attachHolder.itemView");
                        int height2 = view3.getHeight();
                        if (spanIndex == 0) {
                            if (i26 > 0) {
                                i26 -= height2;
                                int i27 = sparseIntArray2.get(viewHolder.getItemViewType(), 0) + 1;
                                sparseIntArray2.put(viewHolder.getItemViewType(), i27);
                                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "target remove height:" + height2 + " itemType:" + viewHolder.getItemViewType() + " itemCount:" + i27 + " spanIndex 0");
                                it = it5;
                                z17 = z17;
                            } else {
                                it = it5;
                                z17 = true;
                            }
                        } else {
                            boolean z18 = z17;
                            int i28 = sparseIntArray2.get(viewHolder.getItemViewType(), 0) + 1;
                            sparseIntArray2.put(viewHolder.getItemViewType(), i28);
                            it = it5;
                            RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "target remove height:" + height2 + " itemType:" + viewHolder.getItemViewType() + " itemCount:" + i28 + " spanIndex:" + spanIndex);
                            z17 = z18;
                        }
                        it5 = it;
                    }
                }
                preloadView(view, sparseIntArray, sparseIntArray2, historyInfo);
                RFWLog.i(ArgusRecycleViewPreloader.TAG, RFWLog.USR, "cost: " + (System.nanoTime() - nanoTime));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        }
    }
}
