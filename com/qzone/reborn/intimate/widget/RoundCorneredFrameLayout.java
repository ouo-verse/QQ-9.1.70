package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RoundCorneredFrameLayout extends FrameLayout {
    private PorterDuffXfermode C;
    private RoundCorneredFrameLayout.a D;
    private int E;
    private int F;
    private LinearGradient G;
    private float H;
    private boolean I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private boolean f57705d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f57706e;

    /* renamed from: f, reason: collision with root package name */
    private Path f57707f;

    /* renamed from: h, reason: collision with root package name */
    private float[] f57708h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f57709i;

    /* renamed from: m, reason: collision with root package name */
    private PorterDuffXfermode f57710m;

    public RoundCorneredFrameLayout(Context context) {
        super(context);
        this.f57705d = false;
        this.f57706e = new Paint();
        this.f57707f = new Path();
        this.f57708h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f57709i = new RectF();
        this.f57710m = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.C = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.E = -1;
        this.F = -1;
        this.I = false;
        this.J = -1;
        a(context);
    }

    private void a(Context context) {
        this.f57706e.setAntiAlias(true);
        this.f57706e.setStyle(Paint.Style.FILL);
        this.f57706e.setXfermode(this.f57710m);
    }

    private void b() {
        this.G = new LinearGradient(this.J == 2 ? getWidth() : 0.0f, this.J == 4 ? getWidth() : 0.0f, this.J == 1 ? getWidth() : 0.0f, this.J == 3 ? getWidth() : 0.0f, this.E, this.F, Shader.TileMode.CLAMP);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.I) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Path path = new Path();
            path.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), width - getPaddingRight(), height - getPaddingBottom()), this.f57708h, Path.Direction.CW);
            float f16 = width;
            float f17 = height;
            canvas.saveLayer(new RectF(0.0f, 0.0f, f16, f17), null, 31);
            super.dispatchDraw(canvas);
            if (Build.VERSION.SDK_INT <= 27) {
                this.f57706e.setXfermode(this.f57710m);
                canvas.drawPath(path, this.f57706e);
            } else {
                this.f57706e.setXfermode(this.C);
                Path path2 = new Path();
                path2.addRect(0.0f, 0.0f, f16, f17, Path.Direction.CW);
                path2.op(path, Path.Op.DIFFERENCE);
                canvas.drawPath(path2, this.f57706e);
            }
            canvas.restore();
            return;
        }
        LinearGradient linearGradient = this.G;
        if (linearGradient != null) {
            this.f57706e.setShader(linearGradient);
        }
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.f57706e.setXfermode(null);
        this.f57707f.reset();
        this.f57707f.addRoundRect(rectF, this.f57708h, Path.Direction.CW);
        canvas.drawPath(this.f57707f, this.f57706e);
        canvas.clipPath(this.f57707f);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RoundCorneredFrameLayout.a aVar = this.D;
        if (aVar != null) {
            return aVar.a(motionEvent) || super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        b();
        this.f57709i.set(0.0f, 0.0f, i3, i16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f57705d && isClickable() && isEnabled()) {
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

    public void setGradient(int i3, int i16, int i17) {
        this.E = i3;
        this.F = i16;
        this.J = i17;
        this.I = true;
        invalidate();
    }

    public void setRadius(float f16, float f17, float f18, float f19) {
        this.f57708h = new float[]{f16, f16, f17, f17, f18, f18, f19, f19};
    }

    public void setTouchIntercept(RoundCorneredFrameLayout.a aVar) {
        this.D = aVar;
    }

    public void setRadius(float f16) {
        this.H = f16;
        setRadius(f16, f16, f16, f16);
    }

    public RoundCorneredFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57705d = false;
        this.f57706e = new Paint();
        this.f57707f = new Path();
        this.f57708h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f57709i = new RectF();
        this.f57710m = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.C = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.E = -1;
        this.F = -1;
        this.I = false;
        this.J = -1;
        a(context);
    }
}
