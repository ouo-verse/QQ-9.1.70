package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes.dex */
public class LinearSnapHelper extends SnapHelper {
    private static final float INVALID_DISTANCE = 1.0f;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;

    private float computeDistancePerChild(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int i3 = Integer.MIN_VALUE;
        int i16 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = layoutManager.getChildAt(i17);
            int position = layoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i16) {
                    view = childAt;
                    i16 = position;
                }
                if (position > i3) {
                    view2 = childAt;
                    i3 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i3 - i16) + 1);
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i3, int i16) {
        int i17;
        int[] calculateScrollDistance = calculateScrollDistance(i3, i16);
        float computeDistancePerChild = computeDistancePerChild(layoutManager, orientationHelper);
        if (computeDistancePerChild <= 0.0f) {
            return 0;
        }
        if (Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1])) {
            i17 = calculateScrollDistance[0];
        } else {
            i17 = calculateScrollDistance[1];
        }
        return Math.round(i17 / computeDistancePerChild);
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i3 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = layoutManager.getChildAt(i16);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (abs < i3) {
                view = childAt;
                i3 = abs;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(layoutManager, view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(layoutManager, view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i3, int i16) {
        int itemCount;
        View findSnapView;
        int position;
        int i17;
        PointF computeScrollVectorForPosition;
        int i18;
        int i19;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        int i26 = 0;
        if (layoutManager.canScrollHorizontally()) {
            i18 = estimateNextPositionDiffForFling(layoutManager, getHorizontalHelper(layoutManager), i3, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i18 = -i18;
            }
        } else {
            i18 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i19 = estimateNextPositionDiffForFling(layoutManager, getVerticalHelper(layoutManager), 0, i16);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i19 = -i19;
            }
        } else {
            i19 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i18 = i19;
        }
        if (i18 == 0) {
            return -1;
        }
        int i27 = position + i18;
        if (i27 >= 0) {
            i26 = i27;
        }
        if (i26 < itemCount) {
            return i26;
        }
        return i17;
    }
}
