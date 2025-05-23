package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.shape.g;
import com.google.android.material.shape.h;
import com.google.android.material.shape.i;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, j1.f {
    private static final String U = "MaterialShapeDrawable";
    private static final Paint V;
    private final Path C;
    private final Path D;
    private final RectF E;
    private final RectF F;
    private final Region G;
    private final Region H;
    private g I;
    private final Paint J;
    private final Paint K;
    private final i1.a L;

    @NonNull
    private final h.b M;
    private final h N;

    @Nullable
    private PorterDuffColorFilter P;

    @Nullable
    private PorterDuffColorFilter Q;
    private int R;

    @NonNull
    private final RectF S;
    private boolean T;

    /* renamed from: d, reason: collision with root package name */
    private c f34016d;

    /* renamed from: e, reason: collision with root package name */
    private final i.g[] f34017e;

    /* renamed from: f, reason: collision with root package name */
    private final i.g[] f34018f;

    /* renamed from: h, reason: collision with root package name */
    private final BitSet f34019h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f34020i;

    /* renamed from: m, reason: collision with root package name */
    private final Matrix f34021m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface CompatibilityShadowMode {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements h.b {
        a() {
        }

        @Override // com.google.android.material.shape.h.b
        public void a(@NonNull i iVar, Matrix matrix, int i3) {
            MaterialShapeDrawable.this.f34019h.set(i3, iVar.e());
            MaterialShapeDrawable.this.f34017e[i3] = iVar.f(matrix);
        }

        @Override // com.google.android.material.shape.h.b
        public void b(@NonNull i iVar, Matrix matrix, int i3) {
            MaterialShapeDrawable.this.f34019h.set(i3 + 4, iVar.e());
            MaterialShapeDrawable.this.f34018f[i3] = iVar.f(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements g.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f34023a;

        b(float f16) {
            this.f34023a = f16;
        }

        @Override // com.google.android.material.shape.g.c
        @NonNull
        public j1.c a(@NonNull j1.c cVar) {
            if (!(cVar instanceof j1.e)) {
                return new j1.b(this.f34023a, cVar);
            }
            return cVar;
        }
    }

    static {
        Paint paint = new Paint(1);
        V = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* synthetic */ MaterialShapeDrawable(c cVar, a aVar) {
        this(cVar);
    }

    private float F() {
        if (M()) {
            return this.K.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean K() {
        c cVar = this.f34016d;
        int i3 = cVar.f34041q;
        if (i3 != 1 && cVar.f34042r > 0 && (i3 == 2 || U())) {
            return true;
        }
        return false;
    }

    private boolean L() {
        Paint.Style style = this.f34016d.f34046v;
        if (style != Paint.Style.FILL_AND_STROKE && style != Paint.Style.FILL) {
            return false;
        }
        return true;
    }

    private boolean M() {
        Paint.Style style = this.f34016d.f34046v;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.K.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    private void O() {
        super.invalidateSelf();
    }

    private void R(@NonNull Canvas canvas) {
        if (!K()) {
            return;
        }
        canvas.save();
        T(canvas);
        if (!this.T) {
            n(canvas);
            canvas.restore();
            return;
        }
        int width = (int) (this.S.width() - getBounds().width());
        int height = (int) (this.S.height() - getBounds().height());
        if (width >= 0 && height >= 0) {
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.S.width()) + (this.f34016d.f34042r * 2) + width, ((int) this.S.height()) + (this.f34016d.f34042r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f16 = (getBounds().left - this.f34016d.f34042r) - width;
            float f17 = (getBounds().top - this.f34016d.f34042r) - height;
            canvas2.translate(-f16, -f17);
            n(canvas2);
            canvas.drawBitmap(createBitmap, f16, f17, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int S(int i3, int i16) {
        return (i3 * (i16 + (i16 >>> 7))) >>> 8;
    }

    private void T(@NonNull Canvas canvas) {
        canvas.translate(B(), C());
    }

    @Nullable
    private PorterDuffColorFilter f(@NonNull Paint paint, boolean z16) {
        if (z16) {
            int color = paint.getColor();
            int l3 = l(color);
            this.R = l3;
            if (l3 != color) {
                return new PorterDuffColorFilter(l3, PorterDuff.Mode.SRC_IN);
            }
            return null;
        }
        return null;
    }

    private void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.f34016d.f34034j != 1.0f) {
            this.f34021m.reset();
            Matrix matrix = this.f34021m;
            float f16 = this.f34016d.f34034j;
            matrix.setScale(f16, f16, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f34021m);
        }
        path.computeBounds(this.S, true);
    }

    private void i() {
        g y16 = E().y(new b(-F()));
        this.I = y16;
        this.N.d(y16, this.f34016d.f34035k, v(), this.D);
    }

    @NonNull
    private PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z16) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z16) {
            colorForState = l(colorForState);
        }
        this.R = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter k(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z16) {
        if (colorStateList != null && mode != null) {
            return j(colorStateList, mode, z16);
        }
        return f(paint, z16);
    }

    private boolean k0(int[] iArr) {
        boolean z16;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f34016d.f34028d != null && color2 != (colorForState2 = this.f34016d.f34028d.getColorForState(iArr, (color2 = this.J.getColor())))) {
            this.J.setColor(colorForState2);
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f34016d.f34029e != null && color != (colorForState = this.f34016d.f34029e.getColorForState(iArr, (color = this.K.getColor())))) {
            this.K.setColor(colorForState);
            return true;
        }
        return z16;
    }

    private boolean l0() {
        PorterDuffColorFilter porterDuffColorFilter = this.P;
        PorterDuffColorFilter porterDuffColorFilter2 = this.Q;
        c cVar = this.f34016d;
        this.P = k(cVar.f34031g, cVar.f34032h, this.J, true);
        c cVar2 = this.f34016d;
        this.Q = k(cVar2.f34030f, cVar2.f34032h, this.K, false);
        c cVar3 = this.f34016d;
        if (cVar3.f34045u) {
            this.L.d(cVar3.f34031g.getColorForState(getState(), 0));
        }
        if (!ObjectsCompat.equals(porterDuffColorFilter, this.P) || !ObjectsCompat.equals(porterDuffColorFilter2, this.Q)) {
            return true;
        }
        return false;
    }

    @NonNull
    public static MaterialShapeDrawable m(Context context, float f16) {
        int c16 = z0.a.c(context, R.attr.a8g, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.N(context);
        materialShapeDrawable.Y(ColorStateList.valueOf(c16));
        materialShapeDrawable.X(f16);
        return materialShapeDrawable;
    }

    private void m0() {
        float J = J();
        this.f34016d.f34042r = (int) Math.ceil(0.75f * J);
        this.f34016d.f34043s = (int) Math.ceil(J * 0.25f);
        l0();
        O();
    }

    private void n(@NonNull Canvas canvas) {
        if (this.f34019h.cardinality() > 0) {
            Log.w(U, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f34016d.f34043s != 0) {
            canvas.drawPath(this.C, this.L.c());
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.f34017e[i3].b(this.L, this.f34016d.f34042r, canvas);
            this.f34018f[i3].b(this.L, this.f34016d.f34042r, canvas);
        }
        if (this.T) {
            int B = B();
            int C = C();
            canvas.translate(-B, -C);
            canvas.drawPath(this.C, V);
            canvas.translate(B, C);
        }
    }

    private void o(@NonNull Canvas canvas) {
        q(canvas, this.J, this.C, this.f34016d.f34025a, u());
    }

    private void q(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull g gVar, @NonNull RectF rectF) {
        if (gVar.u(rectF)) {
            float a16 = gVar.t().a(rectF) * this.f34016d.f34035k;
            canvas.drawRoundRect(rectF, a16, a16, paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    @NonNull
    private RectF v() {
        this.F.set(u());
        float F = F();
        this.F.inset(F, F);
        return this.F;
    }

    @ColorInt
    public int A() {
        return this.R;
    }

    public int B() {
        c cVar = this.f34016d;
        return (int) (cVar.f34043s * Math.sin(Math.toRadians(cVar.f34044t)));
    }

    public int C() {
        c cVar = this.f34016d;
        return (int) (cVar.f34043s * Math.cos(Math.toRadians(cVar.f34044t)));
    }

    public int D() {
        return this.f34016d.f34042r;
    }

    @NonNull
    public g E() {
        return this.f34016d.f34025a;
    }

    public float G() {
        return this.f34016d.f34025a.r().a(u());
    }

    public float H() {
        return this.f34016d.f34025a.t().a(u());
    }

    public float I() {
        return this.f34016d.f34040p;
    }

    public float J() {
        return w() + I();
    }

    public void N(Context context) {
        this.f34016d.f34026b = new c1.a(context);
        m0();
    }

    public boolean P() {
        c1.a aVar = this.f34016d.f34026b;
        if (aVar != null && aVar.e()) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean Q() {
        return this.f34016d.f34025a.u(u());
    }

    public boolean U() {
        int i3 = Build.VERSION.SDK_INT;
        if (!Q() && !this.C.isConvex() && i3 < 29) {
            return true;
        }
        return false;
    }

    public void V(float f16) {
        setShapeAppearanceModel(this.f34016d.f34025a.w(f16));
    }

    public void W(@NonNull j1.c cVar) {
        setShapeAppearanceModel(this.f34016d.f34025a.x(cVar));
    }

    public void X(float f16) {
        c cVar = this.f34016d;
        if (cVar.f34039o != f16) {
            cVar.f34039o = f16;
            m0();
        }
    }

    public void Y(@Nullable ColorStateList colorStateList) {
        c cVar = this.f34016d;
        if (cVar.f34028d != colorStateList) {
            cVar.f34028d = colorStateList;
            onStateChange(getState());
        }
    }

    public void Z(float f16) {
        c cVar = this.f34016d;
        if (cVar.f34035k != f16) {
            cVar.f34035k = f16;
            this.f34020i = true;
            invalidateSelf();
        }
    }

    public void a0(int i3, int i16, int i17, int i18) {
        c cVar = this.f34016d;
        if (cVar.f34033i == null) {
            cVar.f34033i = new Rect();
        }
        this.f34016d.f34033i.set(i3, i16, i17, i18);
        invalidateSelf();
    }

    public void b0(Paint.Style style) {
        this.f34016d.f34046v = style;
        O();
    }

    public void c0(float f16) {
        c cVar = this.f34016d;
        if (cVar.f34038n != f16) {
            cVar.f34038n = f16;
            m0();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void d0(boolean z16) {
        this.T = z16;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.J.setColorFilter(this.P);
        int alpha = this.J.getAlpha();
        this.J.setAlpha(S(alpha, this.f34016d.f34037m));
        this.K.setColorFilter(this.Q);
        this.K.setStrokeWidth(this.f34016d.f34036l);
        int alpha2 = this.K.getAlpha();
        this.K.setAlpha(S(alpha2, this.f34016d.f34037m));
        if (this.f34020i) {
            i();
            g(u(), this.C);
            this.f34020i = false;
        }
        R(canvas);
        if (L()) {
            o(canvas);
        }
        if (M()) {
            r(canvas);
        }
        this.J.setAlpha(alpha);
        this.K.setAlpha(alpha2);
    }

    public void e0(int i3) {
        this.L.d(i3);
        this.f34016d.f34045u = false;
        O();
    }

    public void f0(int i3) {
        c cVar = this.f34016d;
        if (cVar.f34041q != i3) {
            cVar.f34041q = i3;
            O();
        }
    }

    public void g0(float f16, @ColorInt int i3) {
        j0(f16);
        i0(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f34016d.f34037m;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f34016d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f34016d.f34041q == 2) {
            return;
        }
        if (Q()) {
            outline.setRoundRect(getBounds(), G() * this.f34016d.f34035k);
            return;
        }
        g(u(), this.C);
        if (this.C.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.C);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f34016d.f34033i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.G.set(getBounds());
        g(u(), this.C);
        this.H.setPath(this.C, this.G);
        this.G.op(this.H, Region.Op.DIFFERENCE);
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void h(@NonNull RectF rectF, @NonNull Path path) {
        h hVar = this.N;
        c cVar = this.f34016d;
        hVar.e(cVar.f34025a, cVar.f34035k, rectF, this.M, path);
    }

    public void h0(float f16, @Nullable ColorStateList colorStateList) {
        j0(f16);
        i0(colorStateList);
    }

    public void i0(@Nullable ColorStateList colorStateList) {
        c cVar = this.f34016d;
        if (cVar.f34029e != colorStateList) {
            cVar.f34029e = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f34020i = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (!super.isStateful() && (((colorStateList = this.f34016d.f34031g) == null || !colorStateList.isStateful()) && (((colorStateList2 = this.f34016d.f34030f) == null || !colorStateList2.isStateful()) && (((colorStateList3 = this.f34016d.f34029e) == null || !colorStateList3.isStateful()) && ((colorStateList4 = this.f34016d.f34028d) == null || !colorStateList4.isStateful()))))) {
            return false;
        }
        return true;
    }

    public void j0(float f16) {
        this.f34016d.f34036l = f16;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int l(@ColorInt int i3) {
        float J = J() + z();
        c1.a aVar = this.f34016d.f34026b;
        if (aVar != null) {
            return aVar.c(i3, J);
        }
        return i3;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f34016d = new c(this.f34016d);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f34020i = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.l.b
    public boolean onStateChange(int[] iArr) {
        boolean z16;
        boolean k06 = k0(iArr);
        boolean l06 = l0();
        if (!k06 && !l06) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            invalidateSelf();
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void p(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        q(canvas, paint, path, this.f34016d.f34025a, rectF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void r(@NonNull Canvas canvas) {
        q(canvas, this.K, this.D, this.I, v());
    }

    public float s() {
        return this.f34016d.f34025a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i3) {
        c cVar = this.f34016d;
        if (cVar.f34037m != i3) {
            cVar.f34037m = i3;
            O();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f34016d.f34027c = colorFilter;
        O();
    }

    @Override // j1.f
    public void setShapeAppearanceModel(@NonNull g gVar) {
        this.f34016d.f34025a = gVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f34016d.f34031g = colorStateList;
        l0();
        O();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        c cVar = this.f34016d;
        if (cVar.f34032h != mode) {
            cVar.f34032h = mode;
            l0();
            O();
        }
    }

    public float t() {
        return this.f34016d.f34025a.l().a(u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public RectF u() {
        this.E.set(getBounds());
        return this.E;
    }

    public float w() {
        return this.f34016d.f34039o;
    }

    @Nullable
    public ColorStateList x() {
        return this.f34016d.f34028d;
    }

    public float y() {
        return this.f34016d.f34035k;
    }

    public float z() {
        return this.f34016d.f34038n;
    }

    public MaterialShapeDrawable() {
        this(new g());
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        this(g.e(context, attributeSet, i3, i16).m());
    }

    public MaterialShapeDrawable(@NonNull g gVar) {
        this(new c(gVar, null));
    }

    MaterialShapeDrawable(@NonNull c cVar) {
        h hVar;
        this.f34017e = new i.g[4];
        this.f34018f = new i.g[4];
        this.f34019h = new BitSet(8);
        this.f34021m = new Matrix();
        this.C = new Path();
        this.D = new Path();
        this.E = new RectF();
        this.F = new RectF();
        this.G = new Region();
        this.H = new Region();
        Paint paint = new Paint(1);
        this.J = paint;
        Paint paint2 = new Paint(1);
        this.K = paint2;
        this.L = new i1.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            hVar = h.k();
        } else {
            hVar = new h();
        }
        this.N = hVar;
        this.S = new RectF();
        this.T = true;
        this.f34016d = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        l0();
        k0(getState());
        this.M = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public g f34025a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public c1.a f34026b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public ColorFilter f34027c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public ColorStateList f34028d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public ColorStateList f34029e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public ColorStateList f34030f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public ColorStateList f34031g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public PorterDuff.Mode f34032h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public Rect f34033i;

        /* renamed from: j, reason: collision with root package name */
        public float f34034j;

        /* renamed from: k, reason: collision with root package name */
        public float f34035k;

        /* renamed from: l, reason: collision with root package name */
        public float f34036l;

        /* renamed from: m, reason: collision with root package name */
        public int f34037m;

        /* renamed from: n, reason: collision with root package name */
        public float f34038n;

        /* renamed from: o, reason: collision with root package name */
        public float f34039o;

        /* renamed from: p, reason: collision with root package name */
        public float f34040p;

        /* renamed from: q, reason: collision with root package name */
        public int f34041q;

        /* renamed from: r, reason: collision with root package name */
        public int f34042r;

        /* renamed from: s, reason: collision with root package name */
        public int f34043s;

        /* renamed from: t, reason: collision with root package name */
        public int f34044t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f34045u;

        /* renamed from: v, reason: collision with root package name */
        public Paint.Style f34046v;

        public c(g gVar, c1.a aVar) {
            this.f34028d = null;
            this.f34029e = null;
            this.f34030f = null;
            this.f34031g = null;
            this.f34032h = PorterDuff.Mode.SRC_IN;
            this.f34033i = null;
            this.f34034j = 1.0f;
            this.f34035k = 1.0f;
            this.f34037m = 255;
            this.f34038n = 0.0f;
            this.f34039o = 0.0f;
            this.f34040p = 0.0f;
            this.f34041q = 0;
            this.f34042r = 0;
            this.f34043s = 0;
            this.f34044t = 0;
            this.f34045u = false;
            this.f34046v = Paint.Style.FILL_AND_STROKE;
            this.f34025a = gVar;
            this.f34026b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this, null);
            materialShapeDrawable.f34020i = true;
            return materialShapeDrawable;
        }

        public c(@NonNull c cVar) {
            this.f34028d = null;
            this.f34029e = null;
            this.f34030f = null;
            this.f34031g = null;
            this.f34032h = PorterDuff.Mode.SRC_IN;
            this.f34033i = null;
            this.f34034j = 1.0f;
            this.f34035k = 1.0f;
            this.f34037m = 255;
            this.f34038n = 0.0f;
            this.f34039o = 0.0f;
            this.f34040p = 0.0f;
            this.f34041q = 0;
            this.f34042r = 0;
            this.f34043s = 0;
            this.f34044t = 0;
            this.f34045u = false;
            this.f34046v = Paint.Style.FILL_AND_STROKE;
            this.f34025a = cVar.f34025a;
            this.f34026b = cVar.f34026b;
            this.f34036l = cVar.f34036l;
            this.f34027c = cVar.f34027c;
            this.f34028d = cVar.f34028d;
            this.f34029e = cVar.f34029e;
            this.f34032h = cVar.f34032h;
            this.f34031g = cVar.f34031g;
            this.f34037m = cVar.f34037m;
            this.f34034j = cVar.f34034j;
            this.f34043s = cVar.f34043s;
            this.f34041q = cVar.f34041q;
            this.f34045u = cVar.f34045u;
            this.f34035k = cVar.f34035k;
            this.f34038n = cVar.f34038n;
            this.f34039o = cVar.f34039o;
            this.f34040p = cVar.f34040p;
            this.f34042r = cVar.f34042r;
            this.f34044t = cVar.f34044t;
            this.f34030f = cVar.f34030f;
            this.f34046v = cVar.f34046v;
            if (cVar.f34033i != null) {
                this.f34033i = new Rect(cVar.f34033i);
            }
        }
    }
}
