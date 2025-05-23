package com.tenpay.sdk.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.impl.f;
import com.tenpay.QwLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CompleteView extends View {
    private static final String TAG = "CompleteView";
    Paint bgPaint;
    private Bitmap bitmap;
    private float curValue;
    private float density;
    private RectF finalRect;
    private Rect mRect;
    private TextPaint paint;
    private int shaderColor;
    private RectF shaderRect;

    public CompleteView(Context context) {
        super(context);
        this.paint = new TextPaint(1);
        this.density = getResources().getDisplayMetrics().density;
        this.finalRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.shaderRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.shaderColor = Color.argb(255, 11, 178, 255);
        this.curValue = 0.0f;
        this.mRect = new Rect();
        this.bgPaint = new Paint();
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i3) {
        this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dyo);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.H8, i3, 0);
        try {
            this.finalRect.right = obtainStyledAttributes.getLayoutDimension(f.I8, -1);
            this.finalRect.bottom = obtainStyledAttributes.getLayoutDimension(f.J8, -2);
            QwLog.i("AlbumView: finalRect = " + this.finalRect);
            obtainStyledAttributes.recycle();
            resetShader();
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    private void releaseBitmap() {
        if (!this.bitmap.isRecycled()) {
            this.bitmap.recycle();
        }
        this.bitmap = null;
    }

    private void resetShader() {
        RectF rectF = this.shaderRect;
        RectF rectF2 = this.finalRect;
        float f16 = rectF2.left;
        float f17 = this.density;
        rectF.left = f16 + (25.0f * f17);
        rectF.top = rectF2.top + (f17 * 38.0f);
        rectF.right = (rectF2.right - rectF2.left) * 0.875f;
        rectF.bottom = (rectF2.bottom - rectF2.top) * 0.71f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        QwLog.i("onDraw: ");
        canvas.clipRect(this.finalRect);
        this.mRect.set(0, 0, this.bitmap.getWidth(), this.bitmap.getHeight());
        canvas.drawBitmap(this.bitmap, this.mRect, this.finalRect, this.paint);
        canvas.clipRect(this.shaderRect);
        canvas.translate(this.curValue, 0.0f);
        this.bgPaint.setColor(this.shaderColor);
        canvas.drawRect(this.shaderRect, this.bgPaint);
    }

    public void start(long j3) {
        resetShader();
        postInvalidate();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) this.finalRect.right);
        ofInt.setDuration(j3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tenpay.sdk.view.CompleteView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CompleteView.this.curValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                QwLog.i("onAnimationUpdate: " + CompleteView.this.curValue);
                CompleteView.this.postInvalidate();
            }
        });
        ofInt.start();
    }

    public CompleteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new TextPaint(1);
        this.density = getResources().getDisplayMetrics().density;
        this.finalRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.shaderRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.shaderColor = Color.argb(255, 11, 178, 255);
        this.curValue = 0.0f;
        this.mRect = new Rect();
        this.bgPaint = new Paint();
        init(context, attributeSet, 0);
    }

    public CompleteView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.paint = new TextPaint(1);
        this.density = getResources().getDisplayMetrics().density;
        this.finalRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.shaderRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.shaderColor = Color.argb(255, 11, 178, 255);
        this.curValue = 0.0f;
        this.mRect = new Rect();
        this.bgPaint = new Paint();
        init(context, attributeSet, i3);
    }
}
