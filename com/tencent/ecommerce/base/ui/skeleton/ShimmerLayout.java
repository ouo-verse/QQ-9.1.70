package com.tencent.ecommerce.base.ui.skeleton;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ShimmerLayout extends FrameLayout {
    private Canvas C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    private float J;
    private float K;
    private ViewTreeObserver.OnPreDrawListener L;

    /* renamed from: d, reason: collision with root package name */
    private int f101232d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f101233e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f101234f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f101235h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f101236i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f101237m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ShimmerLayout.this.r();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f101239d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101240e;

        b(int i3, int i16) {
            this.f101239d = i3;
            this.f101240e = i16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerLayout.this.f101232d = this.f101239d + ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (ShimmerLayout.this.f101232d + this.f101240e >= 0) {
                ShimmerLayout.this.invalidate();
            }
        }
    }

    public ShimmerLayout(Context context) {
        this(context, null);
    }

    private Rect c() {
        return new Rect(0, 0, d(), getHeight());
    }

    private int d() {
        return (int) ((((getWidth() / 2) * this.J) / Math.cos(Math.toRadians(Math.abs(this.I)))) + (getHeight() * Math.tan(Math.toRadians(Math.abs(this.I)))));
    }

    private Bitmap e(int i3, int i16) {
        try {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    private void f() {
        if (this.f101234f != null) {
            return;
        }
        int n3 = n(this.H);
        float width = (getWidth() / 2) * this.J;
        float height = this.I >= 0 ? getHeight() : 0.0f;
        float cos = ((float) Math.cos(Math.toRadians(this.I))) * width;
        float sin = height + (((float) Math.sin(Math.toRadians(this.I))) * width);
        int i3 = this.H;
        LinearGradient linearGradient = new LinearGradient(0.0f, height, cos, sin, new int[]{n3, i3, i3, n3}, k(), Shader.TileMode.CLAMP);
        Bitmap bitmap = this.f101236i;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        ComposeShader composeShader = new ComposeShader(linearGradient, new BitmapShader(bitmap, tileMode, tileMode), PorterDuff.Mode.DST_IN);
        Paint paint = new Paint();
        this.f101234f = paint;
        paint.setAntiAlias(true);
        this.f101234f.setDither(true);
        this.f101234f.setFilterBitmap(true);
        this.f101234f.setShader(composeShader);
    }

    private void g(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap l3 = l();
        this.f101236i = l3;
        if (l3 == null) {
            return;
        }
        if (this.C == null) {
            this.C = new Canvas(this.f101236i);
        }
        this.C.drawColor(0, PorterDuff.Mode.CLEAR);
        this.C.save();
        this.C.translate(-this.f101232d, 0.0f);
        super.dispatchDraw(this.C);
        this.C.restore();
        h(canvas);
        this.f101236i = null;
    }

    private void h(Canvas canvas) {
        f();
        canvas.save();
        canvas.translate(this.f101232d, 0.0f);
        Rect rect = this.f101233e;
        canvas.drawRect(rect.left, 0.0f, rect.width(), this.f101233e.height(), this.f101234f);
        canvas.restore();
    }

    private int j(int i3) {
        return getContext().getColor(i3);
    }

    private Bitmap l() {
        if (this.f101237m == null) {
            this.f101237m = e(this.f101233e.width(), getHeight());
        }
        return this.f101237m;
    }

    private Animator m() {
        ValueAnimator ofInt;
        ValueAnimator valueAnimator = this.f101235h;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        if (this.f101233e == null) {
            this.f101233e = c();
        }
        int width = getWidth();
        int i3 = getWidth() > this.f101233e.width() ? -width : -this.f101233e.width();
        int width2 = this.f101233e.width();
        int i16 = width - i3;
        if (this.D) {
            ofInt = ValueAnimator.ofInt(i16, 0);
        } else {
            ofInt = ValueAnimator.ofInt(0, i16);
        }
        this.f101235h = ofInt;
        ofInt.setDuration(this.G);
        this.f101235h.setRepeatCount(-1);
        this.f101235h.addUpdateListener(new b(i3, width2));
        return this.f101235h;
    }

    private int n(int i3) {
        return Color.argb(0, Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    private void p() {
        if (this.E) {
            q();
            r();
        }
    }

    private void q() {
        ValueAnimator valueAnimator = this.f101235h;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f101235h.removeAllUpdateListeners();
        }
        this.f101235h = null;
        this.f101234f = null;
        this.E = false;
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.E && getWidth() > 0 && getHeight() > 0) {
            g(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        q();
        super.onDetachedFromWindow();
    }

    public void r() {
        if (this.E) {
            return;
        }
        if (getWidth() == 0) {
            this.L = new a();
            getViewTreeObserver().addOnPreDrawListener(this.L);
        } else {
            m().start();
            this.E = true;
        }
    }

    public void s() {
        if (this.L != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.L);
        }
        q();
    }

    public void setAnimationReversed(boolean z16) {
        this.D = z16;
        p();
    }

    public void setShimmerAnimationDuration(int i3) {
        this.G = i3;
        p();
    }

    public void setShimmerColor(int i3) {
        this.H = i3;
        p();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (i3 == 0) {
            if (this.F) {
                r();
                return;
            }
            return;
        }
        s();
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float[] k() {
        float[] fArr = {0.0f, 0.5f - (r1 / 2.0f), (r1 / 2.0f) + 0.5f, 1.0f};
        float f16 = this.K;
        return fArr;
    }

    private void o() {
        this.C = null;
        Bitmap bitmap = this.f101237m;
        if (bitmap != null) {
            bitmap.recycle();
            this.f101237m = null;
        }
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ok0.b.f423060x, 0, 0);
        try {
            this.I = obtainStyledAttributes.getInteger(ok0.b.f423061y, 20);
            this.G = obtainStyledAttributes.getInteger(ok0.b.f423062z, 1500);
            this.H = obtainStyledAttributes.getColor(ok0.b.B, j(R.color.f7103c));
            this.F = obtainStyledAttributes.getBoolean(ok0.b.A, false);
            this.J = obtainStyledAttributes.getFloat(ok0.b.D, 0.5f);
            this.K = obtainStyledAttributes.getFloat(ok0.b.C, 0.1f);
            this.D = obtainStyledAttributes.getBoolean(ok0.b.E, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.J);
            setGradientCenterColorWidth(this.K);
            setShimmerAngle(this.I);
            i();
            if (this.F && getVisibility() == 0) {
                r();
            }
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    public void setShimmerAngle(int i3) {
        if (i3 >= -45 && 45 >= i3) {
            this.I = i3;
            p();
            return;
        }
        throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", (byte) -45, Byte.valueOf(MultipartStream.DASH)));
    }

    public void setGradientCenterColorWidth(float f16) {
        if (f16 > 0.0f && 1.0f > f16) {
            this.K = f16;
            p();
            return;
        }
        throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", (byte) 0, (byte) 1));
    }

    public void setMaskWidth(float f16) {
        if (f16 > 0.0f && 1.0f >= f16) {
            this.J = f16;
            p();
            return;
        }
        throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", (byte) 0, (byte) 1));
    }

    private void i() {
    }
}
