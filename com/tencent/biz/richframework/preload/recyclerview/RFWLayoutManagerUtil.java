package com.tencent.biz.richframework.preload.recyclerview;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWLayoutManagerUtil {
    public static int findLastCompletelyVisibleItemPositions(RecyclerView recyclerView) {
        if (recyclerView != null) {
            try {
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    return ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                }
                if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                    int columnCountForAccessibility = recyclerView.getLayoutManager().getColumnCountForAccessibility(null, null);
                    int[] iArr = new int[columnCountForAccessibility];
                    ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPositions(iArr);
                    int i3 = iArr[columnCountForAccessibility - 1];
                    if (columnCountForAccessibility == 2) {
                        return Math.max(iArr[0], iArr[1]);
                    }
                    return i3;
                }
                return -1;
            } catch (Exception e16) {
                e16.printStackTrace();
                return -1;
            }
        }
        return -1;
    }
}
