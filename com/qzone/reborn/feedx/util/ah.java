package com.qzone.reborn.feedx.util;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ah {
    public static boolean b(RecyclerView recyclerView) {
        int findFirstCompletelyVisibleItemPosition;
        if (recyclerView == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        } else {
            if (!(layoutManager instanceof GridLayoutManager)) {
                return false;
            }
            findFirstCompletelyVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        return findFirstCompletelyVisibleItemPosition == 0;
    }

    public static int a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return 0;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)[0];
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        return 0;
    }
}
