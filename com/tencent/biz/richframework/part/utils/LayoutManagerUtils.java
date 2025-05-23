package com.tencent.biz.richframework.part.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LayoutManagerUtils {
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

    public static boolean needThrowException(Exception exc) {
        if (RFWApplication.isDebug()) {
            if (!(exc instanceof IndexOutOfBoundsException)) {
                return true;
            }
            RFWLog.e("LayoutManagerUtils", RFWLog.USR, "catch IndexOutOfBoundsException", exc);
            RFWReporter.reportThrowableCache(exc);
            return false;
        }
        RFWLog.e("LayoutManagerUtils", RFWLog.USR, "handleException e:" + exc.getMessage(), exc);
        RFWReporter.reportThrowableCache(exc);
        return false;
    }
}
