package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.g;
import com.google.android.material.shape.h;
import g1.c;
import j1.f;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ShapeableImageView extends AppCompatImageView implements f {
    private static final int U = 2131953477;
    private final RectF C;
    private final RectF D;
    private final Paint E;
    private final Paint F;
    private final Path G;

    @Nullable
    private ColorStateList H;

    @Nullable
    private MaterialShapeDrawable I;
    private g J;

    @Dimension
    private float K;
    private Path L;

    @Dimension
    private int M;

    @Dimension
    private int N;

    @Dimension
    private int P;

    @Dimension
    private int Q;

    @Dimension
    private int R;

    @Dimension
    private int S;
    private boolean T;

    /* renamed from: m, reason: collision with root package name */
    private final h f33746m;

    /* compiled from: P */
    @TargetApi(21)
    /* loaded from: classes2.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f33747a = new Rect();

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.J == null) {
                return;
            }
            if (ShapeableImageView.this.I == null) {
                ShapeableImageView.this.I = new MaterialShapeDrawable(ShapeableImageView.this.J);
            }
            ShapeableImageView.this.C.round(this.f33747a);
            ShapeableImageView.this.I.setBounds(this.f33747a);
            ShapeableImageView.this.I.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    private void A(int i3, int i16) {
        this.C.set(getPaddingLeft(), getPaddingTop(), i3 - getPaddingRight(), i16 - getPaddingBottom());
        this.f33746m.d(this.J, 1.0f, this.C, this.G);
        this.L.rewind();
        this.L.addPath(this.G);
        this.D.set(0.0f, 0.0f, i3, i16);
        this.L.addRect(this.D, Path.Direction.CCW);
    }

    private void q(Canvas canvas) {
        if (this.H == null) {
            return;
        }
        this.E.setStrokeWidth(this.K);
        int colorForState = this.H.getColorForState(getDrawableState(), this.H.getDefaultColor());
        if (this.K > 0.0f && colorForState != 0) {
            this.E.setColor(colorForState);
            canvas.drawPath(this.G, this.E);
        }
    }

    private boolean y() {
        if (this.R == Integer.MIN_VALUE && this.S == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private boolean z() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - r();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - t();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - u();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - v();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - w();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - x();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.L, this.F);
        q(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.T || !isLayoutDirectionResolved()) {
            return;
        }
        this.T = true;
        if (!isPaddingRelative() && !y()) {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        } else {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        A(i3, i16);
    }

    @Dimension
    public int r() {
        return this.Q;
    }

    public void setContentPadding(@Dimension int i3, @Dimension int i16, @Dimension int i17, @Dimension int i18) {
        this.R = Integer.MIN_VALUE;
        this.S = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.M) + i3, (super.getPaddingTop() - this.N) + i16, (super.getPaddingRight() - this.P) + i17, (super.getPaddingBottom() - this.Q) + i18);
        this.M = i3;
        this.N = i16;
        this.P = i17;
        this.Q = i18;
    }

    @RequiresApi(17)
    public void setContentPaddingRelative(@Dimension int i3, @Dimension int i16, @Dimension int i17, @Dimension int i18) {
        int i19;
        super.setPaddingRelative((super.getPaddingStart() - w()) + i3, (super.getPaddingTop() - this.N) + i16, (super.getPaddingEnd() - t()) + i17, (super.getPaddingBottom() - this.Q) + i18);
        if (z()) {
            i19 = i17;
        } else {
            i19 = i3;
        }
        this.M = i19;
        this.N = i16;
        if (!z()) {
            i3 = i17;
        }
        this.P = i3;
        this.Q = i18;
    }

    @Override // android.view.View
    public void setPadding(@Dimension int i3, @Dimension int i16, @Dimension int i17, @Dimension int i18) {
        super.setPadding(i3 + u(), i16 + x(), i17 + v(), i18 + r());
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int i3, @Dimension int i16, @Dimension int i17, @Dimension int i18) {
        super.setPaddingRelative(i3 + w(), i16 + x(), i17 + t(), i18 + r());
    }

    @Override // j1.f
    public void setShapeAppearanceModel(@NonNull g gVar) {
        this.J = gVar;
        MaterialShapeDrawable materialShapeDrawable = this.I;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(gVar);
        }
        A(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.H = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i3) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i3));
    }

    public void setStrokeWidth(@Dimension float f16) {
        if (this.K != f16) {
            this.K = f16;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i3) {
        setStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    @Dimension
    public final int t() {
        int i3 = this.S;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (z()) {
            return this.M;
        }
        return this.P;
    }

    @Dimension
    public int u() {
        int i3;
        int i16;
        if (y()) {
            if (z() && (i16 = this.S) != Integer.MIN_VALUE) {
                return i16;
            }
            if (!z() && (i3 = this.R) != Integer.MIN_VALUE) {
                return i3;
            }
        }
        return this.M;
    }

    @Dimension
    public int v() {
        int i3;
        int i16;
        if (y()) {
            if (z() && (i16 = this.R) != Integer.MIN_VALUE) {
                return i16;
            }
            if (!z() && (i3 = this.S) != Integer.MIN_VALUE) {
                return i3;
            }
        }
        return this.P;
    }

    @Dimension
    public final int w() {
        int i3 = this.R;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (z()) {
            return this.P;
        }
        return this.M;
    }

    @Dimension
    public int x() {
        return this.N;
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r0), attributeSet, i3);
        int i16 = U;
        this.f33746m = h.k();
        this.G = new Path();
        this.T = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.F = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.C = new RectF();
        this.D = new RectF();
        this.L = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, w0.a.f444061v7, i3, i16);
        this.H = c.a(context2, obtainStyledAttributes, w0.a.D7);
        this.K = obtainStyledAttributes.getDimensionPixelSize(w0.a.E7, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(w0.a.f444072w7, 0);
        this.M = dimensionPixelSize;
        this.N = dimensionPixelSize;
        this.P = dimensionPixelSize;
        this.Q = dimensionPixelSize;
        this.M = obtainStyledAttributes.getDimensionPixelSize(w0.a.f444108z7, dimensionPixelSize);
        this.N = obtainStyledAttributes.getDimensionPixelSize(w0.a.C7, dimensionPixelSize);
        this.P = obtainStyledAttributes.getDimensionPixelSize(w0.a.A7, dimensionPixelSize);
        this.Q = obtainStyledAttributes.getDimensionPixelSize(w0.a.f444084x7, dimensionPixelSize);
        this.R = obtainStyledAttributes.getDimensionPixelSize(w0.a.B7, Integer.MIN_VALUE);
        this.S = obtainStyledAttributes.getDimensionPixelSize(w0.a.f444096y7, Integer.MIN_VALUE);
        obtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.E = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.J = g.e(context2, attributeSet, i3, i16).m();
        setOutlineProvider(new a());
    }
}
