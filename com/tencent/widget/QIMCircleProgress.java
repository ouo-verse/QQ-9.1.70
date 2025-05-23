package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes27.dex */
public class QIMCircleProgress extends ImageView {
    static IPatchRedirector $redirector_ = null;
    public static final int ANIM_MODE = 2;
    public static final int CAPTURE_MODE = 1;
    public static final int IDLE_MODE = 0;
    public static final int LOCK_MODE = 3;
    public static int MAX_PROGRESS = 0;
    public static final int NEXT_SEGMENT_BLINK_ANGLE = 5;
    public static final int SEGMENT_GAP_ANGLE = 4;
    public static final String TAG = "QIMCircleProgress";
    protected int captureSize;
    ValueAnimator capturedSegmentBlinkAnimator;
    protected int idleSize;
    boolean isCapturedSegmentBlink;
    boolean isNextSegmentBlink;
    int mBgAlpha;
    int mBgColor;
    float mBlinkAlpha;
    Paint mBlinkPaint;
    int mCenterCicleColor;
    protected float mCenterScale;
    float mDensity;
    protected int mHeight;
    float mMaxBlinkShadowRadius;
    protected int mMode;
    protected Paint mPaint;
    protected Paint mPaintOrangeFill;
    protected Paint mPaintWhite;
    protected float mProgress;
    int mProgressAlpha;
    int mProgressColor;
    protected float mProgressOffset;
    private List<Float> mSegmentTimePoints;
    protected int mStrokeWidth;
    protected int mWidth;
    boolean needNextSegmentAnimation;
    ValueAnimator nextSegmentBlinkAnimator;
    protected RectF oval;

    /* loaded from: classes27.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QIMCircleProgress.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            QIMCircleProgress.this.mBlinkAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            QIMCircleProgress.this.notifyChange();
        }
    }

    /* loaded from: classes27.dex */
    class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QIMCircleProgress.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            QIMCircleProgress.this.isCapturedSegmentBlink = false;
            if (QLog.isColorLevel()) {
                QLog.d(QIMCircleProgress.TAG, 2, "[segmentCapture] capturedSegmentBlinkAnimator cancel");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ValueAnimator valueAnimator;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            QIMCircleProgress qIMCircleProgress = QIMCircleProgress.this;
            qIMCircleProgress.isCapturedSegmentBlink = false;
            if (qIMCircleProgress.needNextSegmentAnimation && (valueAnimator = qIMCircleProgress.nextSegmentBlinkAnimator) != null) {
                valueAnimator.start();
            }
            if (QLog.isColorLevel()) {
                QLog.d(QIMCircleProgress.TAG, 2, "[segmentCapture] capturedSegmentBlinkAnimator end");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            QIMCircleProgress.this.isCapturedSegmentBlink = true;
            if (QLog.isColorLevel()) {
                QLog.d(QIMCircleProgress.TAG, 2, "capturedSegmentBlinkAnimator start");
            }
        }
    }

    /* loaded from: classes27.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QIMCircleProgress.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            QIMCircleProgress.this.mBlinkAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            QIMCircleProgress.this.notifyChange();
        }
    }

    /* loaded from: classes27.dex */
    class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QIMCircleProgress.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            QIMCircleProgress.this.isNextSegmentBlink = false;
            if (QLog.isColorLevel()) {
                QLog.d(QIMCircleProgress.TAG, 2, "[segmentCapture] nextSegmentBlinkAnimator cancel");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            QIMCircleProgress.this.isNextSegmentBlink = false;
            if (QLog.isColorLevel()) {
                QLog.d(QIMCircleProgress.TAG, 2, "[segmentCapture] nextSegmentBlinkAnimator end");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            QIMCircleProgress.this.isNextSegmentBlink = true;
            if (QLog.isColorLevel()) {
                QLog.d(QIMCircleProgress.TAG, 2, "[segmentCapture] nextSegmentBlinkAnimator start");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55342);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            MAX_PROGRESS = 10000;
        }
    }

    public QIMCircleProgress(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSegmentTimePoints = new ArrayList();
        this.mMode = 0;
        this.mCenterScale = 1.0f;
        this.mStrokeWidth = 10;
        this.mBlinkAlpha = 0.0f;
        this.mMaxBlinkShadowRadius = 5.0f;
        this.isCapturedSegmentBlink = false;
        this.isNextSegmentBlink = false;
        this.needNextSegmentAnimation = false;
        this.oval = new RectF();
        init();
    }

    public void cancelAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.capturedSegmentBlinkAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.needNextSegmentAnimation = false;
            this.capturedSegmentBlinkAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.nextSegmentBlinkAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.nextSegmentBlinkAnimator.cancel();
        }
    }

    public void changeMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.mMode = i3;
        if (i3 == 1) {
            cancelAnimation();
        }
        invalidate();
    }

    protected void drawCenterCircle(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
        } else {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.captureSize / 2, this.mPaintWhite);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.idleSize / 2, this.mPaintOrangeFill);
        }
    }

    public void forceNextSegmentAnimatorStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.capturedSegmentBlinkAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.needNextSegmentAnimation = false;
            this.capturedSegmentBlinkAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.nextSegmentBlinkAnimator;
        if (valueAnimator2 != null && !valueAnimator2.isRunning()) {
            this.nextSegmentBlinkAnimator.start();
        }
    }

    public float getCurrentProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, (Object) this)).floatValue();
        }
        return this.mProgress;
    }

    public int getMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mMode;
    }

    public List<Float> getSegmentPoints() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mSegmentTimePoints;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        setLayerType(1, null);
        this.mDensity = getResources().getDisplayMetrics().density;
        this.mBgColor = getResources().getColor(R.color.j_);
        this.mProgressColor = getResources().getColor(R.color.f157748yb);
        this.mBgAlpha = 51;
        this.mProgressAlpha = 100;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mProgressColor);
        Paint paint2 = new Paint();
        this.mBlinkPaint = paint2;
        paint2.setAntiAlias(true);
        this.mBlinkPaint.setStyle(Paint.Style.STROKE);
        this.mBlinkPaint.setColor(getResources().getColor(R.color.f158017al3));
        Paint paint3 = new Paint();
        this.mPaintOrangeFill = paint3;
        paint3.setAntiAlias(true);
        this.mPaintOrangeFill.setStyle(Paint.Style.FILL);
        this.mPaintOrangeFill.setColor(this.mProgressColor);
        this.mCenterCicleColor = -1;
        Paint paint4 = new Paint();
        this.mPaintWhite = paint4;
        paint4.setAntiAlias(true);
        this.mPaintWhite.setStyle(Paint.Style.FILL);
        this.mPaintWhite.setColor(this.mCenterCicleColor);
    }

    public void initBlinkAnimator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (this.capturedSegmentBlinkAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.capturedSegmentBlinkAnimator = ofFloat;
            ofFloat.setDuration(150L);
            this.capturedSegmentBlinkAnimator.setRepeatCount(3);
            this.capturedSegmentBlinkAnimator.setRepeatMode(2);
            this.capturedSegmentBlinkAnimator.addUpdateListener(new a());
            this.capturedSegmentBlinkAnimator.addListener(new b());
        }
        if (this.nextSegmentBlinkAnimator == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.nextSegmentBlinkAnimator = ofFloat2;
            ofFloat2.setDuration(400L);
            this.nextSegmentBlinkAnimator.setRepeatCount(-1);
            this.nextSegmentBlinkAnimator.setRepeatMode(2);
            this.nextSegmentBlinkAnimator.addUpdateListener(new c());
            this.nextSegmentBlinkAnimator.addListener(new d());
        }
    }

    public void notifyChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        this.mWidth = getWidth();
        int height = getHeight();
        this.mHeight = height;
        int i3 = this.mWidth;
        if (i3 <= 0) {
            return;
        }
        RectF rectF = this.oval;
        int i16 = this.mStrokeWidth;
        float f16 = this.mProgressOffset;
        rectF.set((i16 * 1.38f) + f16, (i16 * 1.38f) + f16, (i3 - (i16 * 1.38f)) - f16, (height - (i16 * 1.38f)) - f16);
        float f17 = MAX_PROGRESS * (-0.0055555557f);
        int i17 = 0;
        while (i17 < this.mSegmentTimePoints.size()) {
            float floatValue = this.mSegmentTimePoints.get(i17).floatValue();
            float f18 = (((f17 * 360.0f) / r12) - 90.0f) + 2.0f;
            float f19 = (((floatValue - f17) * 360.0f) / MAX_PROGRESS) - 4.0f;
            if (f19 > 0.0f) {
                if (this.isCapturedSegmentBlink && i17 == this.mSegmentTimePoints.size() - 1) {
                    this.mPaint.setStrokeWidth((int) (this.mStrokeWidth * (1.0d - (this.mBlinkAlpha * 0.38d))));
                    this.mBlinkPaint.setStrokeWidth((int) (this.mStrokeWidth * (1.0d - (this.mBlinkAlpha * 0.38d))));
                    this.mBlinkPaint.setAlpha((int) (this.mBlinkAlpha * 255.0f));
                    this.mBlinkPaint.setShadowLayer(this.mMaxBlinkShadowRadius * this.mBlinkAlpha, 0.0f, 0.0f, getResources().getColor(R.color.f158017al3));
                    canvas.drawArc(this.oval, f18, f19, false, this.mPaint);
                    canvas.drawArc(this.oval, f18, f19, false, this.mBlinkPaint);
                    this.mPaint.setStrokeWidth(this.mStrokeWidth);
                } else {
                    canvas.drawArc(this.oval, f18, f19, false, this.mPaint);
                }
            }
            i17++;
            f17 = floatValue;
        }
        float f26 = (((this.mProgress - f17) * 360.0f) / MAX_PROGRESS) - 4.0f;
        if (f26 > 0.0f) {
            canvas.drawArc(this.oval, (((f17 * 360.0f) / r4) - 90.0f) + 2.0f, f26, false, this.mPaint);
        } else if (this.isNextSegmentBlink) {
            this.mPaint.setAlpha((int) (this.mBlinkAlpha * 255.0f));
            canvas.drawArc(this.oval, (((f17 * 360.0f) / MAX_PROGRESS) - 90.0f) + 2.0f, 5.0f, false, this.mPaint);
            this.mPaint.setAlpha(255);
        }
        if (this.mMode != 2) {
            drawCenterCircle(canvas);
        }
    }

    public void setCenterCircleColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.mCenterCicleColor = i3;
        this.mPaintWhite.setColor(i3);
        invalidate();
    }

    public void setCenterScaleValue(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else {
            this.mCenterScale = f16;
            invalidate();
        }
    }

    public void setCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.idleSize = ViewUtils.dip2px(24.0f);
            this.captureSize = ViewUtils.dip2px(54.0f);
        }
    }

    public void setProgress(float f16) {
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            return;
        }
        int i3 = MAX_PROGRESS;
        if (f16 > i3) {
            f17 = i3;
        } else {
            f17 = f16;
        }
        this.mProgress = f17;
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        this.mProgress = f16;
        invalidate();
    }

    public void setProgressColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.mProgressColor = i3;
        this.mPaint.setColor(i3);
        this.mPaintOrangeFill.setColor(this.mProgressColor);
        invalidate();
    }

    public void setProgressOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mProgressOffset = f16;
        }
    }

    public void setStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
            return;
        }
        int i3 = (int) ((f16 * this.mDensity) + 0.5d);
        this.mStrokeWidth = i3;
        this.mPaint.setStrokeWidth(i3);
        this.mBlinkPaint.setStrokeWidth(this.mStrokeWidth);
    }

    public void startBlinkAnimation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
            return;
        }
        if (f16 == this.mProgress) {
            this.needNextSegmentAnimation = true;
            ValueAnimator valueAnimator = this.capturedSegmentBlinkAnimator;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    public QIMCircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mSegmentTimePoints = new ArrayList();
        this.mMode = 0;
        this.mCenterScale = 1.0f;
        this.mStrokeWidth = 10;
        this.mBlinkAlpha = 0.0f;
        this.mMaxBlinkShadowRadius = 5.0f;
        this.isCapturedSegmentBlink = false;
        this.isNextSegmentBlink = false;
        this.needNextSegmentAnimation = false;
        this.oval = new RectF();
        init();
    }
}
