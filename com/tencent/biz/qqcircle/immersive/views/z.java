package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class z extends PagerSnapHelper {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f91339a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<ViewPager2> f91340b;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f91341c;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private OrientationHelper f91343e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private OrientationHelper f91344f;

    /* renamed from: g, reason: collision with root package name */
    private final int f91345g;

    /* renamed from: l, reason: collision with root package name */
    private a f91350l;

    /* renamed from: d, reason: collision with root package name */
    private float f91342d = 3.0f;

    /* renamed from: h, reason: collision with root package name */
    private int f91346h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f91347i = false;

    /* renamed from: j, reason: collision with root package name */
    private int f91348j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f91349k = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f91351m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f91352n = -1;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        boolean a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class b extends LinearSmoothScroller {

        /* renamed from: c, reason: collision with root package name */
        private RecyclerView.LayoutManager f91353c;

        public b(Context context, RecyclerView.LayoutManager layoutManager) {
            super(context);
            this.f91353c = layoutManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return z.this.f() / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int[] calculateDistanceToFinalSnap = z.this.calculateDistanceToFinalSnap(this.f91353c, view);
            int i3 = calculateDistanceToFinalSnap[0];
            int i16 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i3), Math.abs(i16)));
            if (i3 > 0 && i16 > 0) {
                QLog.d("QFSPagerTurnSnapHelper", 1, "[onTargetFound] dx > 0 && dy > 0.");
            } else if (calculateTimeForDeceleration <= 0) {
                QLog.d("QFSPagerTurnSnapHelper", 1, "[onTargetFound] time <= 0.");
            } else {
                action.update(i3, i16, calculateTimeForDeceleration, z.this.d());
            }
        }
    }

    public z(@NonNull ViewPager2 viewPager2, @NonNull Context context) {
        this.f91339a = new WeakReference<>(context);
        this.f91340b = new WeakReference<>(viewPager2);
        this.f91345g = ViewConfiguration.get(context).getScaledTouchSlop();
        com.tencent.biz.qqcircle.debug.mocklbs.d.ga(uq3.c.C4(20.0f));
        com.tencent.biz.qqcircle.debug.mocklbs.d.ea(uq3.c.B4(com.tencent.biz.qqcircle.debug.mocklbs.d.E));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Interpolator d() {
        Float[] K9 = com.tencent.biz.qqcircle.debug.mocklbs.d.K9();
        if (K9 == null) {
            K9 = new Float[]{Float.valueOf(0.27f), Float.valueOf(0.27f), Float.valueOf(0.26f), Float.valueOf(0.99f)};
        }
        if (K9.length == 4) {
            float floatValue = K9[0].floatValue();
            float floatValue2 = K9[1].floatValue();
            float floatValue3 = K9[2].floatValue();
            float floatValue4 = K9[3].floatValue();
            QLog.d("QFSPagerTurnSnapHelper", 2, "[getCubicBezierInterpolator] cubic bezier array: " + ("{x1:" + floatValue + ",y1:" + floatValue2 + "|x2:" + floatValue3 + "|y2:" + floatValue4 + "}"));
            this.f91341c = new jc0.a(floatValue, floatValue2, floatValue3, floatValue4);
        } else {
            QLog.d("QFSPagerTurnSnapHelper", 2, "[getCubicBezierInterpolator] current interpolator factor: " + this.f91342d);
            this.f91341c = new DecelerateInterpolator(this.f91342d);
        }
        return this.f91341c;
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, @NonNull OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    private int e() {
        ViewPager2 viewPager2;
        WeakReference<ViewPager2> weakReference = this.f91340b;
        RecyclerView.Adapter adapter = null;
        if (weakReference == null) {
            viewPager2 = null;
        } else {
            viewPager2 = weakReference.get();
        }
        if (viewPager2 != null) {
            adapter = viewPager2.getAdapter();
        }
        if (adapter == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float f() {
        return com.tencent.biz.qqcircle.debug.mocklbs.d.N9();
    }

    private View findCenterView(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull OrientationHelper orientationHelper) {
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

    private boolean g() {
        if (this.f91352n != this.f91349k) {
            QLog.d("QFSPagerTurnSnapHelper", 1, "[isDisableFastScroll] mFastScrollType: " + this.f91349k);
            this.f91352n = this.f91349k;
        }
        if (this.f91349k == 2) {
            return true;
        }
        return false;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f91344f;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f91344f = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f91344f;
    }

    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return getVerticalHelper(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return getHorizontalHelper(layoutManager);
        }
        return null;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f91343e;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f91343e = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f91343e;
    }

    private boolean h(int i3) {
        boolean z16;
        if (i3 != -1 && i3 != this.f91351m) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && QLog.isColorLevel()) {
            QLog.w("QFSPagerTurnSnapHelper", 2, "[isLegalPosition] current position illegality, currentPosition: " + i3 + " | mCurrentPosition: " + this.f91351m);
        }
        return z16;
    }

    private boolean i(int i3) {
        if (this.f91348j == 2 && i3 < 0) {
            return true;
        }
        return false;
    }

    private boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int i3, int i16) {
        if (layoutManager.canScrollHorizontally()) {
            if (i3 > 0) {
                return true;
            }
            return false;
        }
        if (i16 > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        if (computeScrollVectorForPosition.x >= 0.0f && computeScrollVectorForPosition.y >= 0.0f) {
            return false;
        }
        return true;
    }

    private boolean j(int i3) {
        if (this.f91348j == 1 && i3 > 0) {
            return true;
        }
        return false;
    }

    public void c(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f91346h = Math.round(motionEvent.getY());
            l(0);
            return;
        }
        if (action == 1) {
            int round = this.f91346h - Math.round(motionEvent.getY());
            if (round < 0 && Math.abs(round) > this.f91345g) {
                this.f91348j = 2;
            } else if (round > 0 && Math.abs(round) > this.f91345g) {
                this.f91348j = 1;
            } else {
                this.f91348j = 0;
            }
        }
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        Context context;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        WeakReference<Context> weakReference = this.f91339a;
        if (weakReference == null) {
            context = null;
        } else {
            context = weakReference.get();
        }
        if (context == null) {
            return null;
        }
        if (this.f91347i) {
            return new LinearSmoothScroller(context);
        }
        return new b(context, layoutManager);
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        if (layoutManager == null) {
            QLog.d("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] layoutManager == null.");
            this.f91351m = -1;
            return -1;
        }
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            QLog.d("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] itemCount == 0.");
            this.f91351m = -1;
            return -1;
        }
        OrientationHelper orientationHelper = getOrientationHelper(layoutManager);
        if (orientationHelper == null) {
            QLog.d("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] orientationHelper == null.");
            this.f91351m = -1;
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        View view = null;
        int i26 = Integer.MAX_VALUE;
        int i27 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = layoutManager.getChildAt(i28);
            if (childAt != null) {
                int distanceToCenter = distanceToCenter(layoutManager, childAt, orientationHelper);
                if (distanceToCenter <= 0 && distanceToCenter > i27) {
                    i27 = distanceToCenter;
                    view2 = childAt;
                }
                if (distanceToCenter >= 0 && distanceToCenter < i26) {
                    i26 = distanceToCenter;
                    view = childAt;
                }
            }
        }
        View findSnapView = findSnapView(layoutManager);
        if (findSnapView == null) {
            return -1;
        }
        try {
            int position = layoutManager.getPosition(findSnapView);
            if (g()) {
                l(0);
                QLog.d("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] not fast scroll, scroll conflict, velocityX: " + i3 + " | velocityY: " + i16 + " | currentPosition: " + position);
                this.f91351m = position;
                return position;
            }
            l(0);
            boolean isForwardFling = isForwardFling(layoutManager, i3, i16);
            if (isForwardFling && view != null && h(position)) {
                if (j(i16)) {
                    i19 = position + 1;
                    int e16 = e();
                    if (i19 >= e16) {
                        i19 = e16 - 1;
                    }
                } else {
                    i19 = position;
                }
                QLog.w("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] closest child after center pre position: " + position + " | newPosition: " + i19 + " | mMoveState: " + this.f91348j + " | velocityX: " + i3 + " | velocityY: " + i16);
                if (!k(position, i19)) {
                    position = i19;
                }
                this.f91351m = position;
                return position;
            }
            if (!isForwardFling && view2 != null && h(position)) {
                if (i(i16)) {
                    i18 = position - 1;
                    if (i18 < 0) {
                        i18 = 0;
                    }
                } else {
                    i18 = position;
                }
                QLog.w("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] closest child before center pre position: " + position + " | newPosition: " + i18 + " | mMoveState: " + this.f91348j + " | velocityX: " + i3 + " | velocityY: " + i16);
                if (!k(position, i18)) {
                    position = i18;
                }
                this.f91351m = position;
                return position;
            }
            if (isForwardFling) {
                view = view2;
            }
            if (view == null) {
                QLog.w("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] visibleView == null.");
                this.f91351m = -1;
                return -1;
            }
            try {
                int position2 = layoutManager.getPosition(view);
                if (isReverseLayout(layoutManager) == isForwardFling) {
                    i17 = -1;
                } else {
                    i17 = 1;
                }
                int i29 = i17 + position2;
                if (i29 >= 0 && i29 < itemCount) {
                    QLog.d("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] snapToPosition: " + i29 + " | visiblePosition: " + position2 + " | velocityY: " + i16);
                    if (!k(position2, i29)) {
                        position2 = i29;
                    }
                    this.f91351m = position2;
                    return position2;
                }
                QLog.w("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] snapToPosition < 0 || snapToPosition >= itemCount.");
                this.f91351m = -1;
                return -1;
            } catch (Throwable th5) {
                QLog.e("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] error: ", th5);
                return -1;
            }
        } catch (Throwable th6) {
            QLog.e("QFSPagerTurnSnapHelper", 1, "[findTargetSnapPosition] error: ", th6);
            return -1;
        }
    }

    public boolean k(int i3, int i16) {
        a aVar = this.f91350l;
        if (aVar != null) {
            return aVar.a(i3, i16);
        }
        return false;
    }

    public void l(int i3) {
        this.f91349k = i3;
    }

    public void m(a aVar) {
        this.f91350l = aVar;
    }

    public void n(boolean z16) {
        this.f91347i = z16;
    }
}
