package com.tencent.gdtad.views.videoceiling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVideoCeilingLandView extends RelativeLayout {
    public static final int BOTTOM_WEBVIEW_STATE = 0;
    private static final String TAG = "GdtVideoCeilingLandView";
    public static final int TOP_WEBVIEW_STATE = 2;
    private int TouchSlop;
    public int direction;
    public boolean isAnimating;
    private boolean mBeingDrag;
    private boolean mIgnoreInterceptTouchEvent;
    private boolean mIgnoreTouchEvent;
    private float mLastIntceptMotionX;
    private float mLastIntceptMotionY;
    private float mLastTouchMotionX;
    private float mLastTouchMotionY;
    private GdtVideoCeilingListener mListener;
    public int mState;
    private WebView mWebView;

    public GdtVideoCeilingLandView(Context context) {
        super(context);
        this.mState = 0;
        this.direction = 0;
        this.mBeingDrag = false;
        this.TouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public static boolean isScrollUp(float f16) {
        if (f16 < 0.0f) {
            return true;
        }
        return false;
    }

    private boolean noCanvasViewScrollY() {
        if (this.mWebView == null) {
            return false;
        }
        GdtLog.i(TAG, "noCanvasViewScrollY mWebView.getWebScrollY() -> " + this.mWebView.getWebScrollY());
        if (Math.abs(this.mWebView.getWebScrollY()) >= 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        if (r0 != 3) goto L39;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.mIgnoreInterceptTouchEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean z16 = true;
        if (this.isAnimating || this.mBeingDrag) {
            return true;
        }
        GdtLog.i(TAG, "onInterceptTouchEvent mState " + this.mState);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    GdtLog.i(TAG, "onInterceptTouchEvent ACTION_MOVE mBeingDrag " + this.mBeingDrag);
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f16 = rawX - this.mLastIntceptMotionX;
                    float f17 = rawY - this.mLastIntceptMotionY;
                    if (Math.abs(f17) > this.TouchSlop && Math.abs(f17) > Math.abs(f16)) {
                        int i3 = this.mState;
                        if (i3 == 0) {
                            this.mBeingDrag = true;
                            GdtLog.i(TAG, "onInterceptTouchEvent ACTION_MOVE mState -> BOTTOM_WEBVIEW_STATE ");
                            return true;
                        }
                        if (i3 == 2) {
                            if (!this.mBeingDrag && (!noCanvasViewScrollY() || isScrollUp(f17))) {
                                z16 = false;
                            } else {
                                this.mBeingDrag = true;
                            }
                            GdtLog.i(TAG, "onInterceptTouchEvent ACTION_MOVE mState -> TOP_WEBVIEW_STATE, result -> " + z16 + ", noCanvasViewScrollY -> " + noCanvasViewScrollY() + ", isScrollUp -> " + isScrollUp(f17));
                            return z16;
                        }
                    }
                }
            }
            GdtLog.i(TAG, "onInterceptTouchEvent  ACTION_UP");
            this.mLastIntceptMotionX = 0.0f;
            this.mLastIntceptMotionY = 0.0f;
            this.mBeingDrag = false;
        } else {
            GdtLog.i(TAG, "onInterceptTouchEvent ACTION_DOWN mBeingDrag " + this.mBeingDrag);
            this.mLastIntceptMotionX = motionEvent.getRawX();
            this.mLastIntceptMotionY = motionEvent.getRawY();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        if (r0 != 3) goto L34;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.mIgnoreTouchEvent) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.isAnimating) {
            return true;
        }
        if (this.mLastTouchMotionX == 0.0f || this.mLastTouchMotionY == 0.0f) {
            this.mLastTouchMotionX = motionEvent.getRawX();
            this.mLastTouchMotionY = motionEvent.getRawY();
            GdtVideoCeilingListener gdtVideoCeilingListener = this.mListener;
            if (gdtVideoCeilingListener != null) {
                gdtVideoCeilingListener.onStart(this.mState);
            }
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    GdtLog.w(TAG, "onTouchEvent  ACTION_MOVE");
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f16 = rawY - this.mLastTouchMotionY;
                    if (Math.abs(f16) > Math.abs(rawX - this.mLastTouchMotionX)) {
                        if (this.mListener != null) {
                            GdtLog.w(TAG, "onTouchEvent  onDrag");
                            this.mListener.onDrag((int) f16);
                        }
                        this.mLastTouchMotionX = rawX;
                        this.mLastTouchMotionY = rawY;
                    }
                }
            }
            GdtLog.w(TAG, "onTouchEvent  ACTION_UP");
            this.mLastTouchMotionX = 0.0f;
            this.mLastTouchMotionY = 0.0f;
            GdtVideoCeilingListener gdtVideoCeilingListener2 = this.mListener;
            if (gdtVideoCeilingListener2 != null) {
                gdtVideoCeilingListener2.onEnd(this.mState);
                this.mBeingDrag = false;
            }
        } else {
            GdtLog.w(TAG, "onTouchEvent  ACTION_DOWN");
        }
        return true;
    }

    public void setGdtVideoCeilingListeners(GdtVideoCeilingListener gdtVideoCeilingListener, WebView webView) {
        this.mListener = gdtVideoCeilingListener;
        this.mWebView = webView;
    }

    public void setIgnoreInterceptTouchEvent(boolean z16) {
        this.mIgnoreInterceptTouchEvent = z16;
    }

    public void setIgnoreTouchEvent(boolean z16) {
        this.mIgnoreTouchEvent = z16;
    }

    public GdtVideoCeilingLandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.direction = 0;
        this.mBeingDrag = false;
        this.TouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public GdtVideoCeilingLandView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mState = 0;
        this.direction = 0;
        this.mBeingDrag = false;
        this.TouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
