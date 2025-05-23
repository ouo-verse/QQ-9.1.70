package com.qzone.homepage.ui.Facade.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GiftBackgroundImageView extends ImageView {
    Matrix C;
    Matrix D;
    Matrix E;
    int F;
    boolean G;
    int H;
    int I;
    Bitmap J;
    Paint K;
    private boolean L;
    private boolean M;
    private float N;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;

    /* renamed from: d, reason: collision with root package name */
    float f47658d;

    /* renamed from: e, reason: collision with root package name */
    float f47659e;

    /* renamed from: f, reason: collision with root package name */
    PointF f47660f;

    /* renamed from: h, reason: collision with root package name */
    PointF f47661h;

    /* renamed from: i, reason: collision with root package name */
    float f47662i;

    /* renamed from: m, reason: collision with root package name */
    float f47663m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
    }

    public GiftBackgroundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47658d = 0.0f;
        this.f47659e = 0.0f;
        this.f47660f = new PointF();
        this.f47661h = new PointF();
        this.f47662i = 1.0f;
        this.f47663m = 0.0f;
        this.C = new Matrix();
        this.D = new Matrix();
        this.E = new Matrix();
        this.F = 0;
        this.G = false;
        this.K = new Paint();
        this.L = true;
        this.M = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410046f3);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            setImageDrawable(bitmapDrawable);
            this.J = bitmapDrawable.getBitmap();
        }
        obtainStyledAttributes.recycle();
        this.K.setAntiAlias(true);
        this.K.setFilterBitmap(true);
        this.C = new Matrix();
    }

    private boolean b() {
        a(this.D);
        float f16 = this.N;
        float f17 = this.Q;
        float f18 = (f16 - f17) * (f16 - f17);
        float f19 = this.P;
        float f26 = this.R;
        double sqrt = Math.sqrt(f18 + ((f19 - f26) * (f19 - f26)));
        int i3 = this.H;
        if (sqrt < i3 / 3.0f || sqrt > i3 * 3.0f) {
            return true;
        }
        float f27 = this.N;
        if ((f27 >= i3 / 3 || this.Q >= i3 / 3 || this.S >= i3 / 3 || this.U >= i3 / 3) && (f27 <= (i3 * 2) / 3 || this.Q <= (i3 * 2) / 3 || this.S <= (i3 * 2) / 3 || this.U <= (i3 * 2) / 3)) {
            float f28 = this.P;
            int i16 = this.I;
            if ((f28 >= i16 / 3 || this.R >= i16 / 3 || this.T >= i16 / 3 || this.V >= i16 / 3) && (f28 <= (i16 * 2) / 3 || this.R <= (i16 * 2) / 3 || this.T <= (i16 * 2) / 3 || this.V <= (i16 * 2) / 3)) {
                return false;
            }
        }
        return true;
    }

    public void a(Matrix matrix) {
        if (this.J == null) {
            return;
        }
        float[] fArr = new float[9];
        this.D.getValues(fArr);
        float f16 = fArr[0];
        this.N = (f16 * 0.0f) + (fArr[1] * 0.0f) + fArr[2];
        this.P = (fArr[3] * 0.0f) + (fArr[4] * 0.0f) + fArr[5];
        this.Q = (f16 * this.J.getWidth()) + (fArr[1] * 0.0f) + fArr[2];
        this.R = (fArr[3] * this.J.getWidth()) + (fArr[4] * 0.0f) + fArr[5];
        this.S = (fArr[0] * 0.0f) + (fArr[1] * this.J.getHeight()) + fArr[2];
        this.T = (fArr[3] * 0.0f) + (fArr[4] * this.J.getHeight()) + fArr[5];
        this.U = (fArr[0] * this.J.getWidth()) + (fArr[1] * this.J.getHeight()) + fArr[2];
        this.V = (fArr[3] * this.J.getWidth()) + (fArr[4] * this.J.getHeight()) + fArr[5];
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.J == null) {
            return;
        }
        canvas.save();
        canvas.drawBitmap(this.J, this.C, this.K);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0024, code lost:
    
        if (r0 != 6) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.M) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.L) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i3 = this.F;
                    if (i3 == 2) {
                        this.D.set(this.E);
                        float d16 = d(motionEvent) - this.f47663m;
                        float e16 = e(motionEvent) / this.f47662i;
                        Matrix matrix = this.D;
                        PointF pointF = this.f47661h;
                        matrix.postScale(e16, e16, pointF.x, pointF.y);
                        Matrix matrix2 = this.D;
                        PointF pointF2 = this.f47661h;
                        matrix2.postRotate(d16, pointF2.x, pointF2.y);
                        boolean b16 = b();
                        this.G = b16;
                        if (!b16) {
                            this.C.set(this.D);
                            invalidate();
                        }
                    } else if (i3 == 1) {
                        this.D.set(this.E);
                        this.D.postTranslate(motionEvent.getX() - this.f47658d, motionEvent.getY() - this.f47659e);
                        boolean b17 = b();
                        this.G = b17;
                        if (!b17) {
                            this.C.set(this.D);
                            invalidate();
                        }
                    }
                } else if (action == 5) {
                    this.F = 2;
                    this.f47662i = e(motionEvent);
                    this.f47663m = d(motionEvent);
                    this.E.set(this.C);
                    c(this.f47661h, motionEvent);
                }
            }
            this.F = 0;
        } else {
            this.F = 1;
            this.f47658d = motionEvent.getX();
            this.f47659e = motionEvent.getY();
            this.E.set(this.C);
        }
        return true;
    }

    public void setCanTouch(boolean z16) {
        this.L = z16;
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        this.M = z16;
    }

    public void setLimit(int i3, int i16) {
        this.H = i3;
        this.I = i16;
    }

    private void c(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    private float d(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }

    private float e(MotionEvent motionEvent) {
        float x16 = motionEvent.getX(0) - motionEvent.getX(1);
        float y16 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x16 * x16) + (y16 * y16));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        Bitmap bitmap2 = this.J;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.J.recycle();
        }
        this.J = bitmap;
        this.C.reset();
        float min = Math.min(this.H / (this.J.getWidth() * 1.0f), this.I / (this.J.getHeight() * 1.0f));
        this.C.setScale(min, min);
        this.C.postTranslate(Math.abs((bitmap.getWidth() * min) - this.H) * 0.5f, Math.abs((bitmap.getHeight() * min) - this.I) * 0.5f);
        invalidate();
    }

    public void setOnDrawFrameListener(a aVar) {
    }

    public void setOnTouchListener(b bVar) {
    }
}
