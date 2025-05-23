package cooperation.qzone;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import cooperation.qzone.api.FeedListView;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneTopGestureLayout extends TopGestureLayout implements NestedScrollingParent3 {
    private static boolean backEnabled = true;
    private static boolean shallIntercept = true;
    private INestScrollListener mNestScrollListener;
    private View mNestTargetView;
    private View mNestTargetViewWrapper;
    private NestedScrollingParentHelper mParentHelper;
    private int mTouchSlop;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface INestScrollListener {
        boolean isParentConsume(int i3, View view);

        void onTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class QZoneTopGestureDetector extends TopGestureLayout.TopGestureDetector {
        public static final float MIN_VELOCITYX = 500.0f;

        QZoneTopGestureDetector(Context context) {
            super(context);
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (motionEvent != null && motionEvent2 != null) {
                if (!QZoneTopGestureLayout.backEnabled) {
                    QZoneTopGestureLayout.super.setGestureFlag(-1);
                }
                if (QZoneTopGestureLayout.super.isGestureEnd()) {
                    return super.onFling(motionEvent, motionEvent2, f16, f17);
                }
                float x16 = motionEvent.getX() - motionEvent2.getX();
                float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
                if (QZoneTopGestureLayout.super.hasGestureFlag(1)) {
                    if (x16 < 0.0f && abs < 0.5f) {
                        QZoneTopGestureLayout qZoneTopGestureLayout = QZoneTopGestureLayout.this;
                        if (qZoneTopGestureLayout.mOnFlingGesture != null && f16 > 500.0f) {
                            QZoneTopGestureLayout.super.setGestureFlag(-1);
                            QZoneTopGestureLayout.this.mOnFlingGesture.flingLToR();
                            return true;
                        }
                    }
                } else if (QZoneTopGestureLayout.super.hasGestureFlag(0) && x16 > 0.0f && abs < 0.5f) {
                    QZoneTopGestureLayout qZoneTopGestureLayout2 = QZoneTopGestureLayout.this;
                    if (qZoneTopGestureLayout2.mOnFlingGesture != null && f16 * (-1.0f) > 500.0f) {
                        QZoneTopGestureLayout.super.setGestureFlag(-1);
                        QZoneTopGestureLayout.this.mOnFlingGesture.flingRToL();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (!QZoneTopGestureLayout.backEnabled) {
                QZoneTopGestureLayout.super.setGestureFlag(-1);
            }
            return super.onScroll(motionEvent, motionEvent2, f16, f17);
        }
    }

    public QZoneTopGestureLayout(Context context) {
        super(context);
    }

    private NestedScrollingParentHelper getScrollingParentHelper() {
        if (this.mParentHelper == null) {
            this.mParentHelper = new NestedScrollingParentHelper(this);
        }
        return this.mParentHelper;
    }

    private boolean isParentConsume(int i3, FeedListView feedListView) {
        INestScrollListener iNestScrollListener = this.mNestScrollListener;
        if (iNestScrollListener != null) {
            return iNestScrollListener.isParentConsume(i3, feedListView);
        }
        return false;
    }

    public static void setBackEnabled(boolean z16) {
        backEnabled = z16;
    }

    public static void shouldInterceptEvent(boolean z16) {
        shallIntercept = z16;
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        INestScrollListener iNestScrollListener = this.mNestScrollListener;
        if (iNestScrollListener != null) {
            iNestScrollListener.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return getScrollingParentHelper().getNestedScrollAxes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout
    public void init(Context context) {
        backEnabled = true;
        shallIntercept = true;
        this.mTopGestureDetector = new GestureDetector(context, new QZoneTopGestureDetector(context), new Handler(Looper.getMainLooper()));
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        INestScrollListener iNestScrollListener = this.mNestScrollListener;
        if (iNestScrollListener != null && iNestScrollListener.isParentConsume(0, null)) {
            return true;
        }
        if (!shallIntercept) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr, int i17) {
        if ((view instanceof FeedListView) && isParentConsume(i16, (FeedListView) view)) {
            iArr[1] = i16;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18, int i19) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i3, int i16) {
        this.mNestTargetView = view;
        this.mNestTargetViewWrapper = view2;
        if (getScrollingParentHelper() != null) {
            getScrollingParentHelper().onNestedScrollAccepted(view, view2, i3, i16);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i3, int i16) {
        if ((i3 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i3) {
        getScrollingParentHelper().onStopNestedScroll(view, i3);
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        INestScrollListener iNestScrollListener = this.mNestScrollListener;
        if (iNestScrollListener != null && iNestScrollListener.isParentConsume(0, null)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setNestScrollListener(INestScrollListener iNestScrollListener) {
        this.mNestScrollListener = iNestScrollListener;
    }

    public QZoneTopGestureLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
    }
}
