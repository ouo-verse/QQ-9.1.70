package com.tencent.biz.qqcircle.richframework.widget;

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
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RoundCorneredFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f92075d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f92076e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f92077f;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuffXfermode f92078h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffXfermode f92079i;

    /* renamed from: m, reason: collision with root package name */
    private a f92080m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    @TargetApi(11)
    public RoundCorneredFrameLayout(Context context) {
        super(context);
        this.f92075d = false;
        this.f92076e = new Paint();
        this.f92077f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f92078h = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f92079i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        b(context);
    }

    private void b(Context context) {
        this.f92076e.setAntiAlias(true);
        this.f92076e.setStyle(Paint.Style.FILL);
        this.f92076e.setXfermode(this.f92078h);
    }

    public void a(boolean z16) {
        this.f92075d = z16;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Path path = new Path();
        path.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), width - getPaddingRight(), height - getPaddingBottom()), this.f92077f, Path.Direction.CW);
        float f16 = width;
        float f17 = height;
        canvas.saveLayer(new RectF(0.0f, 0.0f, f16, f17), null, 31);
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f92076e.setXfermode(this.f92078h);
            canvas.drawPath(path, this.f92076e);
        } else {
            this.f92076e.setXfermode(this.f92079i);
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, f16, f17, Path.Direction.CW);
            path2.op(path, Path.Op.DIFFERENCE);
            canvas.drawPath(path2, this.f92076e);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f92080m;
        if (aVar != null) {
            if (!aVar.a(motionEvent) && !super.dispatchTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f92075d && isClickable() && isEnabled()) {
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
        this.f92077f = new float[]{f16, f16, f17, f17, f18, f18, f19, f19};
    }

    public void setTouchIntercept(a aVar) {
        this.f92080m = aVar;
    }

    public void setRadius(float f16) {
        setRadius(f16, f16, f16, f16);
    }

    @TargetApi(11)
    public RoundCorneredFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f92075d = false;
        this.f92076e = new Paint();
        this.f92077f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f92078h = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f92079i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        b(context);
    }
}
