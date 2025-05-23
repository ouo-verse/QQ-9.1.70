package l1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.internal.l;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.b;
import com.google.android.material.shape.c;
import com.google.android.material.shape.e;
import com.tencent.mobileqq.R;
import g1.d;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a extends MaterialShapeDrawable implements l.b {

    @Nullable
    private CharSequence W;

    @NonNull
    private final Context X;

    @Nullable
    private final Paint.FontMetrics Y;

    @NonNull
    private final l Z;

    /* renamed from: a0, reason: collision with root package name */
    @NonNull
    private final View.OnLayoutChangeListener f413623a0;

    /* renamed from: b0, reason: collision with root package name */
    @NonNull
    private final Rect f413624b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f413625c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f413626d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f413627e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f413628f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f413629g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f413630h0;

    /* renamed from: i0, reason: collision with root package name */
    private float f413631i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f413632j0;

    /* renamed from: k0, reason: collision with root package name */
    private final float f413633k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f413634l0;

    /* renamed from: m0, reason: collision with root package name */
    private float f413635m0;

    /* compiled from: P */
    /* renamed from: l1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class ViewOnLayoutChangeListenerC10700a implements View.OnLayoutChangeListener {
        ViewOnLayoutChangeListenerC10700a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            a.this.B0(view);
        }
    }

    a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        this.Y = new Paint.FontMetrics();
        l lVar = new l(this);
        this.Z = lVar;
        this.f413623a0 = new ViewOnLayoutChangeListenerC10700a();
        this.f413624b0 = new Rect();
        this.f413631i0 = 1.0f;
        this.f413632j0 = 1.0f;
        this.f413633k0 = 0.5f;
        this.f413634l0 = 0.5f;
        this.f413635m0 = 1.0f;
        this.X = context;
        lVar.e().density = context.getResources().getDisplayMetrics().density;
        lVar.e().setTextAlign(Paint.Align.CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.f413630h0 = iArr[0];
        view.getWindowVisibleDisplayFrame(this.f413624b0);
    }

    private float o0() {
        int i3;
        if (((this.f413624b0.right - getBounds().right) - this.f413630h0) - this.f413628f0 < 0) {
            i3 = ((this.f413624b0.right - getBounds().right) - this.f413630h0) - this.f413628f0;
        } else if (((this.f413624b0.left - getBounds().left) - this.f413630h0) + this.f413628f0 > 0) {
            i3 = ((this.f413624b0.left - getBounds().left) - this.f413630h0) + this.f413628f0;
        } else {
            return 0.0f;
        }
        return i3;
    }

    private float p0() {
        this.Z.e().getFontMetrics(this.Y);
        Paint.FontMetrics fontMetrics = this.Y;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float q0(@NonNull Rect rect) {
        return rect.centerY() - p0();
    }

    @NonNull
    public static a r0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        a aVar = new a(context, attributeSet, i3, i16);
        aVar.w0(attributeSet, i3, i16);
        return aVar;
    }

    private b s0() {
        float f16 = -o0();
        float width = ((float) (getBounds().width() - (this.f413629g0 * Math.sqrt(2.0d)))) / 2.0f;
        return new e(new c(this.f413629g0), Math.min(Math.max(f16, -width), width));
    }

    private void u0(@NonNull Canvas canvas) {
        if (this.W == null) {
            return;
        }
        int q06 = (int) q0(getBounds());
        if (this.Z.d() != null) {
            this.Z.e().drawableState = getState();
            this.Z.j(this.X);
            this.Z.e().setAlpha((int) (this.f413635m0 * 255.0f));
        }
        CharSequence charSequence = this.W;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), q06, this.Z.e());
    }

    private float v0() {
        CharSequence charSequence = this.W;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.Z.f(charSequence.toString());
    }

    private void w0(@Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        TypedArray h16 = o.h(this.X, attributeSet, w0.a.Ha, i3, i16, new int[0]);
        this.f413629g0 = this.X.getResources().getDimensionPixelSize(R.dimen.cw8);
        setShapeAppearanceModel(E().v().s(s0()).m());
        z0(h16.getText(w0.a.Oa));
        d g16 = g1.c.g(this.X, h16, w0.a.Ia);
        if (g16 != null) {
            int i17 = w0.a.Ja;
            if (h16.hasValue(i17)) {
                g16.k(g1.c.a(this.X, h16, i17));
            }
        }
        A0(g16);
        Y(ColorStateList.valueOf(h16.getColor(w0.a.Pa, z0.a.g(ColorUtils.setAlphaComponent(z0.a.c(this.X, android.R.attr.colorBackground, a.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(z0.a.c(this.X, R.attr.a7t, a.class.getCanonicalName()), 153)))));
        i0(ColorStateList.valueOf(z0.a.c(this.X, R.attr.a8g, a.class.getCanonicalName())));
        this.f413625c0 = h16.getDimensionPixelSize(w0.a.Ka, 0);
        this.f413626d0 = h16.getDimensionPixelSize(w0.a.Ma, 0);
        this.f413627e0 = h16.getDimensionPixelSize(w0.a.Na, 0);
        this.f413628f0 = h16.getDimensionPixelSize(w0.a.La, 0);
        h16.recycle();
    }

    public void A0(@Nullable d dVar) {
        this.Z.h(dVar, this.X);
    }

    @Override // com.google.android.material.internal.l.b
    public void a() {
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        float o06 = o0();
        float f16 = (float) (-((this.f413629g0 * Math.sqrt(2.0d)) - this.f413629g0));
        canvas.scale(this.f413631i0, this.f413632j0, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.f413634l0));
        canvas.translate(o06, f16);
        super.draw(canvas);
        u0(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.Z.e().getTextSize(), this.f413627e0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.f413625c0 * 2) + v0(), this.f413626d0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(E().v().s(s0()).m());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.l.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void t0(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.f413623a0);
    }

    public void x0(@Nullable View view) {
        if (view == null) {
            return;
        }
        B0(view);
        view.addOnLayoutChangeListener(this.f413623a0);
    }

    public void y0(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.f413634l0 = 1.2f;
        this.f413631i0 = f16;
        this.f413632j0 = f16;
        this.f413635m0 = x0.a.b(0.0f, 1.0f, 0.19f, 1.0f, f16);
        invalidateSelf();
    }

    public void z0(@Nullable CharSequence charSequence) {
        if (!TextUtils.equals(this.W, charSequence)) {
            this.W = charSequence;
            this.Z.i(true);
            invalidateSelf();
        }
    }
}
