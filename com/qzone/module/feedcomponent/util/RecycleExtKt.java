package com.qzone.module.feedcomponent.util;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"getAllItemViewList", "", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "getVisibleItemViewList", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class RecycleExtKt {
    public static final <R> List<R> getAllItemViewList(RecyclerView recyclerView) {
        IntRange until;
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            until = RangesKt___RangesKt.until(0, linearLayoutManager.getChildCount());
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                View childAt = linearLayoutManager.getChildAt(((IntIterator) it).nextInt());
                if (childAt == null) {
                    childAt = null;
                }
                if (childAt != null) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static final <R> List<R> getVisibleItemViewList(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return new ArrayList();
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        ArrayList arrayList = new ArrayList();
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            while (true) {
                View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition == null) {
                    findViewByPosition = null;
                }
                if (findViewByPosition != null) {
                    arrayList.add(findViewByPosition);
                }
                if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                    break;
                }
                findFirstVisibleItemPosition++;
            }
        }
        return arrayList;
    }
}
