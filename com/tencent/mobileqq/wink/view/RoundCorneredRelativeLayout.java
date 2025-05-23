package com.tencent.mobileqq.wink.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes21.dex */
public class RoundCorneredRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f326838d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f326839e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f326840f;

    @TargetApi(11)
    public RoundCorneredRelativeLayout(Context context) {
        super(context);
        this.f326838d = false;
        this.f326839e = new Paint();
        this.f326840f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context);
    }

    private void a(Context context) {
        this.f326839e.setAntiAlias(true);
        this.f326839e.setStyle(Paint.Style.FILL);
        this.f326839e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Path path = new Path();
        path.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), width - getPaddingRight(), height - getPaddingBottom()), this.f326840f, Path.Direction.CW);
        float f16 = width;
        float f17 = height;
        canvas.saveLayer(new RectF(0.0f, 0.0f, f16, f17), null, 31);
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f326839e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(path, this.f326839e);
        } else {
            this.f326839e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, f16, f17, Path.Direction.CW);
            path2.op(path, Path.Op.DIFFERENCE);
            canvas.drawPath(path2, this.f326839e);
        }
        canvas.restore();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f326838d && isClickable() && isEnabled()) {
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

    public void setBackground(int i3) {
        if (i3 == -1) {
            setBackground((Drawable) null);
        } else {
            setBackground(getResources().getDrawable(i3));
        }
    }

    public void setForeground(int i3) {
        if (i3 == -1) {
            setForeground((Drawable) null);
        } else {
            setForeground(getResources().getDrawable(i3));
        }
    }

    public void setRadius(float f16, float f17, float f18, float f19) {
        this.f326840f = new float[]{f16, f16, f17, f17, f18, f18, f19, f19};
    }

    @TargetApi(11)
    public RoundCorneredRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f326838d = false;
        this.f326839e = new Paint();
        this.f326840f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context);
    }
}
