package com.tencent.mobileqq.profilecard.bussiness.circle.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DynamicEffectTextView extends TextView {
    static IPatchRedirector $redirector_ = null;
    private static final int DEF_EFFECT_DURATION = 1200;
    private static final String TAG = "DynamicEffectTextView";
    private Paint mAnimationPaint;
    private ValueAnimator mAnimator;
    private BitmapShader mBitmapShader;
    private float mDrawOffsetY;
    private long mDuration;
    private Matrix mGradientMatrix;
    private int mTranslate;
    private int mViewHeight;
    private int mViewWidth;

    public DynamicEffectTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mTranslate = 0;
        this.mBitmapShader = null;
        this.mAnimationPaint = null;
        this.mDuration = 1200L;
        this.mDrawOffsetY = 0.0f;
    }

    public void cancelAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.mAnimator != null) {
            QLog.d(TAG, 1, "cancelAnimation");
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        QLog.d(TAG, 1, "onAttachedToWindow, w: " + this.mViewWidth + ", h: " + this.mViewHeight + ", this: " + hashCode());
        if (this.mViewWidth > 0 && this.mViewHeight > 0) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                startAnimation();
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        QLog.d(TAG, 1, "onDetachedFromWindow, this: " + hashCode());
        cancelAnimation();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        Matrix matrix = this.mGradientMatrix;
        if (matrix != null) {
            matrix.setTranslate(this.mTranslate, 0.0f);
            if (this.mAnimationPaint != null) {
                canvas.drawText(getText().toString(), 0.0f, this.mDrawOffsetY, this.mAnimationPaint);
            }
            BitmapShader bitmapShader = this.mBitmapShader;
            if (bitmapShader != null) {
                bitmapShader.setLocalMatrix(this.mGradientMatrix);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mViewWidth == 0) {
            this.mViewWidth = getMeasuredWidth();
            this.mViewHeight = getMeasuredHeight();
            QLog.d(TAG, 1, "onSizeChanged mViewWidth:", Integer.valueOf(this.mViewWidth), " | mViewHeight: ", Integer.valueOf(this.mViewHeight));
            if (this.mViewWidth > 0 && this.mViewHeight > 0) {
                this.mGradientMatrix = new Matrix();
                this.mDrawOffsetY = ((this.mViewHeight / 2.0f) - ((this.mAnimationPaint.descent() + this.mAnimationPaint.ascent()) / 2.0f)) + UIUtils.b(getContext(), 0.5f);
                startAnimation();
            }
        }
    }

    public void setDrawableResource(int i3) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        QLog.d(TAG, 1, "setDrawableResource drawableId: ", Integer.valueOf(i3));
        try {
            Drawable drawable = getContext().getResources().getDrawable(i3);
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else {
                bitmap = null;
            }
            if (drawable instanceof SkinnableBitmapDrawable) {
                bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
            }
            if (bitmap == null) {
                QLog.d(TAG, 1, "setDrawableResource bitmap not is null.");
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            Paint paint = new Paint(getPaint());
            this.mAnimationPaint = paint;
            paint.setShader(this.mBitmapShader);
            this.mAnimationPaint.setAntiAlias(true);
            this.mAnimationPaint.setFlags(1);
            startAnimation();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public void setDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.mDuration = j3;
        }
    }

    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        cancelAnimation();
        if (this.mBitmapShader == null) {
            QLog.w(TAG, 1, "startAnimation bitmap shader is null.");
            return;
        }
        if (this.mGradientMatrix == null) {
            QLog.w(TAG, 1, "startAnimation gradient matrix is null.");
            return;
        }
        int i3 = this.mViewWidth;
        ValueAnimator ofInt = ValueAnimator.ofInt((-i3) / 2, i3 + (i3 / 2));
        this.mAnimator = ofInt;
        ofInt.setDuration(this.mDuration);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.view.DynamicEffectTextView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicEffectTextView.this);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) valueAnimator);
                    return;
                }
                DynamicEffectTextView.this.mTranslate = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                DynamicEffectTextView.this.invalidate();
            }
        });
        QLog.d(TAG, 1, QZoneJsConstants.ACTION_START_ANIMATION);
        this.mAnimator.start();
    }

    public DynamicEffectTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mTranslate = 0;
        this.mBitmapShader = null;
        this.mAnimationPaint = null;
        this.mDuration = 1200L;
        this.mDrawOffsetY = 0.0f;
    }

    public DynamicEffectTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mTranslate = 0;
        this.mBitmapShader = null;
        this.mAnimationPaint = null;
        this.mDuration = 1200L;
        this.mDrawOffsetY = 0.0f;
    }
}
