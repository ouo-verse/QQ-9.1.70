package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.mViewPager = viewPager2;
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mRecyclerView = recyclerView;
    }

    private void addFakeMotionEvent(long j3, int i3, float f16, float f17) {
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, j3, i3, f16, f17, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
        } else {
            velocityTracker.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean beginFakeDrag() {
        if (this.mScrollEventAdapter.isDragging()) {
            return false;
        }
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if (!this.mScrollEventAdapter.isIdle()) {
            this.mRecyclerView.stopScroll();
        }
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean endFakeDrag() {
        if (!this.mScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        if (!this.mRecyclerView.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            this.mViewPager.snapToPage();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public boolean fakeDragBy(float f16) {
        boolean z16;
        int i3;
        float f17;
        int i16 = 0;
        if (!this.mScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        float f18 = this.mRequestedDragDistance - f16;
        this.mRequestedDragDistance = f18;
        int round = Math.round(f18 - this.mActualDraggedDistance);
        this.mActualDraggedDistance += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mViewPager.getOrientation() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = round;
        } else {
            i3 = 0;
        }
        if (!z16) {
            i16 = round;
        }
        float f19 = 0.0f;
        if (z16) {
            f17 = this.mRequestedDragDistance;
        } else {
            f17 = 0.0f;
        }
        if (!z16) {
            f19 = this.mRequestedDragDistance;
        }
        this.mRecyclerView.scrollBy(i3, i16);
        addFakeMotionEvent(uptimeMillis, 2, f17, f19);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}
