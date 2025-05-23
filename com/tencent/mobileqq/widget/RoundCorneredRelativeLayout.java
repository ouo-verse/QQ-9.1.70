package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RoundCorneredRelativeLayout extends RelativeLayout {
    private static final float PRESS_ALPHA = 0.5f;
    private boolean mEnablePressEffect;
    private Paint mPaint;
    private float[] mRadii;

    @TargetApi(11)
    public RoundCorneredRelativeLayout(Context context) {
        super(context);
        this.mEnablePressEffect = false;
        this.mPaint = new Paint();
        this.mRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        init(context);
    }

    private void init(Context context) {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Path path = new Path();
        path.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), width - getPaddingRight(), height - getPaddingBottom()), this.mRadii, Path.Direction.CW);
        float f16 = width;
        float f17 = height;
        canvas.saveLayer(new RectF(0.0f, 0.0f, f16, f17), null, 31);
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT <= 27) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(path, this.mPaint);
        } else {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, f16, f17, Path.Direction.CW);
            path2.op(path, Path.Op.DIFFERENCE);
            canvas.drawPath(path2, this.mPaint);
        }
        canvas.restore();
    }

    public void enablePressEffect(boolean z16) {
        this.mEnablePressEffect = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mEnablePressEffect && isClickable() && isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                setAlpha(1.0f);
                return super.onTouchEvent(motionEvent);
            }
            setAlpha(0.5f);
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRadius(float f16, float f17, float f18, float f19) {
        this.mRadii = new float[]{f16, f16, f17, f17, f18, f18, f19, f19};
    }

    @TargetApi(11)
    public RoundCorneredRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnablePressEffect = false;
        this.mPaint = new Paint();
        this.mRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        init(context);
    }
}
