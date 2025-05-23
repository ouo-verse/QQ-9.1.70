package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TopContentLayout extends RelativeLayout {
    static IPatchRedirector $redirector_ = null;
    private static final int OUTING_DURATION = 350;
    private static final String TAG = "TopContentLayout";
    private boolean mCanMoveLayout;
    private ContentWrapView mContent;
    private OnOutScreenListener mOnOutScreenListener;
    private Scroller mScroller;
    private GestureDetector mTopLayoutGestureDetector;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface OnOutScreenListener {
        void outing(int i3, int i16, View view);

        void startDrag();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class TopLayoutGestureDetector extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_ = null;
        private static final int MIN_DISTANCE = 50;
        private float mMinDistanceX;

        public TopLayoutGestureDetector(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TopContentLayout.this, (Object) context);
            } else {
                this.mMinDistanceX = TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (TopContentLayout.this.mCanMoveLayout) {
                TopContentLayout.this.mCanMoveLayout = false;
                int width = TopContentLayout.this.getWidth();
                int abs = Math.abs((int) TopContentLayout.this.getMovingViewTransX());
                if (f16 > 0.0f) {
                    i3 = width - abs;
                } else {
                    i3 = -abs;
                }
                TopContentLayout.this.mScroller.startScroll((int) TopContentLayout.this.getMovingViewTransX(), 0, i3, 0, 350);
                TopContentLayout.this.invalidate();
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (!TopContentLayout.this.mCanMoveLayout) {
                float abs = Math.abs(f17 / f16);
                float abs2 = Math.abs(motionEvent.getX() - motionEvent2.getX());
                if (f16 < 0.0f && abs < 0.5f && abs2 > this.mMinDistanceX) {
                    TopContentLayout.this.mCanMoveLayout = true;
                    if (TopContentLayout.this.mOnOutScreenListener != null) {
                        TopContentLayout.this.mOnOutScreenListener.startDrag();
                    }
                    return true;
                }
            } else {
                int movingViewWidth = TopContentLayout.this.getMovingViewWidth();
                int abs3 = Math.abs((int) TopContentLayout.this.getMovingViewTransX());
                if (f16 < 0.0f && abs3 < movingViewWidth) {
                    float f18 = movingViewWidth - abs3;
                    if (Math.abs(f16) > f18) {
                        f16 = f18;
                        if (Math.abs(f16) > 0.0f) {
                        }
                    }
                    f16 = -f16;
                    if (Math.abs(f16) > 0.0f) {
                    }
                } else {
                    if (f16 > 0.0f && abs3 > 0) {
                        if (Math.abs(f16) > abs3) {
                            f16 = -abs3;
                        }
                        f16 = -f16;
                    } else {
                        f16 = 0.0f;
                    }
                    if (Math.abs(f16) > 0.0f) {
                        TopContentLayout.this.movingViewTransBy((int) f16, 0.0f);
                        if (TopContentLayout.this.mOnOutScreenListener != null) {
                            TopContentLayout.this.mOnOutScreenListener.outing((int) TopContentLayout.this.getMovingViewTransX(), 0, TopContentLayout.this);
                        }
                    }
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f16, f17);
        }
    }

    public TopContentLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void init(Context context) {
        this.mTopLayoutGestureDetector = new GestureDetector(context, new TopLayoutGestureDetector(context));
        this.mScroller = new Scroller(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            movingViewTrans(currX, currY);
            OnOutScreenListener onOutScreenListener = this.mOnOutScreenListener;
            if (onOutScreenListener != null) {
                onOutScreenListener.outing(currX, currY, this);
            }
            invalidate();
        }
    }

    public float getMovingViewTransX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        ContentWrapView contentWrapView = this.mContent;
        if (contentWrapView != null) {
            return contentWrapView.getTransX();
        }
        return 0.0f;
    }

    public int getMovingViewWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        ContentWrapView contentWrapView = this.mContent;
        if (contentWrapView != null) {
            return contentWrapView.getWidth();
        }
        return getWidth();
    }

    public OnOutScreenListener getOnOutScreenListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (OnOutScreenListener) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mOnOutScreenListener;
    }

    public void movingViewTrans(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        ContentWrapView contentWrapView = this.mContent;
        if (contentWrapView != null) {
            contentWrapView.transX(f16);
            this.mContent.transY(f17);
        }
    }

    public void movingViewTransBy(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        ContentWrapView contentWrapView = this.mContent;
        if (contentWrapView != null) {
            contentWrapView.transXBy(f16);
            this.mContent.transYBy(f17);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean onTouchEvent = this.mTopLayoutGestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.mCanMoveLayout) {
            this.mCanMoveLayout = false;
            int movingViewWidth = getMovingViewWidth();
            int abs = (int) Math.abs(getMovingViewTransX());
            if (abs > movingViewWidth / 2) {
                i3 = movingViewWidth - abs;
            } else {
                i3 = -abs;
            }
            this.mScroller.startScroll((int) getMovingViewTransX(), 0, i3, 0, 350);
            invalidate();
        }
        return onTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        this.mTopLayoutGestureDetector.onTouchEvent(motionEvent);
        if (action == 1 && this.mCanMoveLayout) {
            this.mCanMoveLayout = false;
            int movingViewWidth = getMovingViewWidth();
            int abs = (int) Math.abs(getMovingViewTransX());
            if (abs > movingViewWidth / 2) {
                i3 = movingViewWidth - abs;
            } else {
                i3 = -abs;
            }
            this.mScroller.startScroll((int) getMovingViewTransX(), 0, i3, 0, 350);
            invalidate();
        }
        return true;
    }

    public void setContent(ContentWrapView contentWrapView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) contentWrapView);
            return;
        }
        ContentWrapView contentWrapView2 = this.mContent;
        if (contentWrapView2 != null) {
            removeView(contentWrapView2);
        }
        this.mContent = contentWrapView;
        addView(contentWrapView);
    }

    public void setOnOutScreenListener(OnOutScreenListener onOutScreenListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onOutScreenListener);
        } else {
            this.mOnOutScreenListener = onOutScreenListener;
        }
    }

    public TopContentLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TopContentLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
