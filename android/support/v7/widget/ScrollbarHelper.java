package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class ScrollbarHelper {
    ScrollbarHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeScrollExtent(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z16) {
        if (layoutManager.getChildCount() != 0 && state.getItemCount() != 0 && view != null && view2 != null) {
            if (!z16) {
                return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
            }
            return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeScrollOffset(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z16, boolean z17) {
        int max;
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max2 = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z17) {
            max = Math.max(0, (state.getItemCount() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z16) {
            return max;
        }
        return Math.round((max * (Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) + (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeScrollRange(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z16) {
        if (layoutManager.getChildCount() != 0 && state.getItemCount() != 0 && view != null && view2 != null) {
            if (!z16) {
                return state.getItemCount();
            }
            return (int) (((orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)) * state.getItemCount());
        }
        return 0;
    }
}
