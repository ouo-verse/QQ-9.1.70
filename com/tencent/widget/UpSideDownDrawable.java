package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UpSideDownDrawable extends Drawable implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_DURATION_MS = 12000;
    private static final int DEFAULT_TIME_SLOT_MS = 20;
    private static final int MSG_DEFAULT = 0;
    private static final int MSG_SCROLLER_DOWN = 2;
    private static final int MSG_SCROLLER_UP = 3;
    private static final int MSG_START = 1;
    private static final String TAG = "UpSideDownDrawable";
    private boolean isResume;
    private Bitmap mBitmap;
    private int mBottom;
    private int mCurX;
    private int mCurY;
    Rect mDesRect;
    private int mDisplayHeight;
    private int mHeight;
    private Paint mPaint;
    private Scroller mScroller;
    private Handler mScrollerHandler;
    Rect mSrcRect;
    private State mState;
    private int mTop;
    private int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class State {
        static IPatchRedirector $redirector_;
        public int derection;
        public int fromY;
        public int leftDurtion;
        public int toY;

        State() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpSideDownDrawable.this);
            }
        }
    }

    public UpSideDownDrawable(Context context, Bitmap bitmap, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, bitmap, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mCurX = 0;
        this.mCurY = 0;
        this.isResume = false;
        this.mSrcRect = new Rect();
        this.mDesRect = new Rect();
        this.mPaint = new Paint();
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.mBitmap = bitmap;
        if (i3 <= 0 && context != null && context.getResources() != null) {
            i3 = ScreenUtil.getInstantScreenWidth(context);
        }
        i16 = i16 <= 0 ? ScreenUtil.dip2px(170.0f) : i16;
        if (i3 <= 0) {
            QLog.e(TAG, 1, "UpSideDownDrawable mDisplayWidth <= 0");
            i3 = ScreenUtil.SCREEN_WIDTH;
        }
        try {
            this.mDisplayHeight = (this.mWidth * i16) / i3;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "UpSideDownDrawable error" + e16);
            this.mDisplayHeight = (this.mWidth * i16) / 320;
        }
        int i17 = this.mHeight;
        this.mTop = (i17 * 15) / 100;
        this.mBottom = (i17 * 85) / 100;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("UpSideDownDrawable bw=%d bh=%d dw=%d dh=%d mDisplayHeight=%d mTop=%d mBot=%d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(this.mDisplayHeight), Integer.valueOf(this.mTop), Integer.valueOf(this.mBottom)));
        }
        this.mScrollerHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.mScroller = new Scroller(context, new AccelerateDecelerateInterpolator());
        this.mCurY = this.mTop;
        this.mState = new State();
    }

    private void initMoveDown() {
        State state = this.mState;
        int i3 = this.mBottom;
        int i16 = this.mDisplayHeight;
        state.fromY = i3 - i16;
        state.toY = -((i3 - this.mTop) - i16);
        state.leftDurtion = 12000;
        state.derection = 3;
    }

    private void initMoveUp() {
        State state = this.mState;
        int i3 = this.mTop;
        state.fromY = i3;
        state.toY = (this.mBottom - i3) - this.mDisplayHeight;
        state.leftDurtion = 12000;
        state.derection = 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        this.mSrcRect.set(0, this.mCurY, this.mBitmap.getWidth(), this.mCurY + this.mDisplayHeight);
        this.mDesRect.set(0, 0, this.mBitmap.getWidth(), this.mDisplayHeight);
        canvas.drawBitmap(this.mBitmap, this.mSrcRect, this.mDesRect, this.mPaint);
    }

    public Bitmap getBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bitmap) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mDisplayHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.mScrollerHandler.removeMessages(3);
                    if (this.mScroller.computeScrollOffset()) {
                        int currY = this.mScroller.getCurrY();
                        this.mCurY = currY;
                        if (currY >= this.mTop) {
                            invalidateSelf();
                            this.mScrollerHandler.sendEmptyMessageDelayed(3, 20L);
                            return false;
                        }
                        initMoveUp();
                        this.mScrollerHandler.sendEmptyMessage(1);
                        return false;
                    }
                    initMoveUp();
                    this.mScrollerHandler.sendEmptyMessage(1);
                    return false;
                }
                return false;
            }
            this.mScrollerHandler.removeMessages(2);
            if (this.mScroller.computeScrollOffset()) {
                int currY2 = this.mScroller.getCurrY();
                this.mCurY = currY2;
                if (currY2 <= this.mBottom - this.mDisplayHeight) {
                    invalidateSelf();
                    this.mScrollerHandler.sendEmptyMessageDelayed(2, 20L);
                    return false;
                }
                initMoveDown();
                this.mScrollerHandler.sendEmptyMessage(1);
                return false;
            }
            initMoveDown();
            this.mScrollerHandler.sendEmptyMessage(1);
            return false;
        }
        Scroller scroller = this.mScroller;
        State state = this.mState;
        scroller.startScroll(0, state.fromY, 0, state.toY, state.leftDurtion);
        this.mScrollerHandler.sendEmptyMessage(this.mState.derection);
        this.isResume = true;
        return false;
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!this.isResume) {
            return;
        }
        if (this.mScrollerHandler.hasMessages(2)) {
            State state = this.mState;
            state.derection = 2;
            state.toY = (this.mBottom - this.mTop) - this.mDisplayHeight;
        } else if (this.mScrollerHandler.hasMessages(3)) {
            State state2 = this.mState;
            state2.derection = 3;
            state2.toY = -((this.mBottom - this.mTop) - this.mDisplayHeight);
        }
        State state3 = this.mState;
        state3.fromY = this.mCurY;
        state3.leftDurtion = this.mScroller.getDuration() - this.mScroller.timePassed();
        this.mScroller.abortAnimation();
        this.mScrollerHandler.removeMessages(2);
        this.mScrollerHandler.removeMessages(3);
        this.isResume = false;
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (!this.isResume) {
            this.mScrollerHandler.sendEmptyMessage(1);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (i3 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i3);
            super.invalidateSelf();
        }
    }

    public void setBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        } else {
            this.mBitmap = bitmap;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) colorFilter);
        } else {
            this.mPaint.setColorFilter(colorFilter);
            super.invalidateSelf();
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!this.isResume) {
            State state = this.mState;
            int i3 = this.mTop;
            state.fromY = i3;
            state.toY = (this.mBottom - i3) - this.mDisplayHeight;
            state.leftDurtion = 12000;
            state.derection = 2;
            this.mScrollerHandler.sendEmptyMessage(1);
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mScrollerHandler.removeMessages(1);
        this.mScrollerHandler.removeMessages(3);
        this.mScrollerHandler.removeMessages(2);
        State state = this.mState;
        int i3 = this.mTop;
        state.fromY = i3;
        state.toY = (this.mBottom - i3) - this.mDisplayHeight;
        state.leftDurtion = 12000;
        state.derection = 2;
        this.mCurY = i3;
        this.isResume = false;
        invalidateSelf();
    }
}
