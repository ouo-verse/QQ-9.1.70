package g1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final ColorStateList f401059a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final ColorStateList f401060b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final ColorStateList f401061c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f401062d;

    /* renamed from: e, reason: collision with root package name */
    public final int f401063e;

    /* renamed from: f, reason: collision with root package name */
    public final int f401064f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f401065g;

    /* renamed from: h, reason: collision with root package name */
    public final float f401066h;

    /* renamed from: i, reason: collision with root package name */
    public final float f401067i;

    /* renamed from: j, reason: collision with root package name */
    public final float f401068j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f401069k;

    /* renamed from: l, reason: collision with root package name */
    public final float f401070l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private ColorStateList f401071m;

    /* renamed from: n, reason: collision with root package name */
    private float f401072n;

    /* renamed from: o, reason: collision with root package name */
    @FontRes
    private final int f401073o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f401074p = false;

    /* renamed from: q, reason: collision with root package name */
    private Typeface f401075q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends ResourcesCompat.FontCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f401076a;

        a(f fVar) {
            this.f401076a = fVar;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i3) {
            d.this.f401074p = true;
            this.f401076a.a(i3);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            d dVar = d.this;
            dVar.f401075q = Typeface.create(typeface, dVar.f401063e);
            d.this.f401074p = true;
            this.f401076a.b(d.this.f401075q, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f401078a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f401079b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f401080c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.f401078a = context;
            this.f401079b = textPaint;
            this.f401080c = fVar;
        }

        @Override // g1.f
        public void a(int i3) {
            this.f401080c.a(i3);
        }

        @Override // g1.f
        public void b(@NonNull Typeface typeface, boolean z16) {
            d.this.p(this.f401078a, this.f401079b, typeface);
            this.f401080c.b(typeface, z16);
        }
    }

    public d(@NonNull Context context, @StyleRes int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, w0.a.Y8);
        l(obtainStyledAttributes.getDimension(w0.a.Z8, 0.0f));
        k(c.a(context, obtainStyledAttributes, w0.a.f443842c9));
        this.f401059a = c.a(context, obtainStyledAttributes, w0.a.f443854d9);
        this.f401060b = c.a(context, obtainStyledAttributes, w0.a.f443866e9);
        this.f401063e = obtainStyledAttributes.getInt(w0.a.f443830b9, 0);
        this.f401064f = obtainStyledAttributes.getInt(w0.a.f443818a9, 1);
        int f16 = c.f(obtainStyledAttributes, w0.a.f443935k9, w0.a.f443924j9);
        this.f401073o = obtainStyledAttributes.getResourceId(f16, 0);
        this.f401062d = obtainStyledAttributes.getString(f16);
        this.f401065g = obtainStyledAttributes.getBoolean(w0.a.f443946l9, false);
        this.f401061c = c.a(context, obtainStyledAttributes, w0.a.f443878f9);
        this.f401066h = obtainStyledAttributes.getFloat(w0.a.f443890g9, 0.0f);
        this.f401067i = obtainStyledAttributes.getFloat(w0.a.f443902h9, 0.0f);
        this.f401068j = obtainStyledAttributes.getFloat(w0.a.f443913i9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i3, w0.a.f443953m5);
        int i16 = w0.a.f443964n5;
        this.f401069k = obtainStyledAttributes2.hasValue(i16);
        this.f401070l = obtainStyledAttributes2.getFloat(i16, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f401075q == null && (str = this.f401062d) != null) {
            this.f401075q = Typeface.create(str, this.f401063e);
        }
        if (this.f401075q == null) {
            int i3 = this.f401064f;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.f401075q = Typeface.DEFAULT;
                    } else {
                        this.f401075q = Typeface.MONOSPACE;
                    }
                } else {
                    this.f401075q = Typeface.SERIF;
                }
            } else {
                this.f401075q = Typeface.SANS_SERIF;
            }
            this.f401075q = Typeface.create(this.f401075q, this.f401063e);
        }
    }

    private boolean m(Context context) {
        Typeface typeface;
        if (e.a()) {
            return true;
        }
        int i3 = this.f401073o;
        if (i3 != 0) {
            typeface = ResourcesCompat.getCachedFont(context, i3);
        } else {
            typeface = null;
        }
        if (typeface != null) {
            return true;
        }
        return false;
    }

    public Typeface e() {
        d();
        return this.f401075q;
    }

    @NonNull
    @VisibleForTesting
    public Typeface f(@NonNull Context context) {
        if (this.f401074p) {
            return this.f401075q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.f401073o);
                this.f401075q = font;
                if (font != null) {
                    this.f401075q = Typeface.create(font, this.f401063e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e16) {
                Log.d("TextAppearance", "Error loading font " + this.f401062d, e16);
            }
        }
        d();
        this.f401074p = true;
        return this.f401075q;
    }

    public void g(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(@NonNull Context context, @NonNull f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i3 = this.f401073o;
        if (i3 == 0) {
            this.f401074p = true;
        }
        if (this.f401074p) {
            fVar.b(this.f401075q, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i3, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f401074p = true;
            fVar.a(1);
        } catch (Exception e16) {
            Log.d("TextAppearance", "Error loading font " + this.f401062d, e16);
            this.f401074p = true;
            fVar.a(-3);
        }
    }

    @Nullable
    public ColorStateList i() {
        return this.f401071m;
    }

    public float j() {
        return this.f401072n;
    }

    public void k(@Nullable ColorStateList colorStateList) {
        this.f401071m = colorStateList;
    }

    public void l(float f16) {
        this.f401072n = f16;
    }

    public void n(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        int i3;
        int i16;
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f401071m;
        if (colorStateList != null) {
            i3 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i3 = -16777216;
        }
        textPaint.setColor(i3);
        float f16 = this.f401068j;
        float f17 = this.f401066h;
        float f18 = this.f401067i;
        ColorStateList colorStateList2 = this.f401061c;
        if (colorStateList2 != null) {
            i16 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i16 = 0;
        }
        textPaint.setShadowLayer(f16, f17, f18, i16);
    }

    public void o(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        boolean z16;
        float f16;
        Typeface a16 = i.a(context, typeface);
        if (a16 != null) {
            typeface = a16;
        }
        textPaint.setTypeface(typeface);
        int i3 = this.f401063e & (~typeface.getStyle());
        if ((i3 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        textPaint.setFakeBoldText(z16);
        if ((i3 & 2) != 0) {
            f16 = -0.25f;
        } else {
            f16 = 0.0f;
        }
        textPaint.setTextSkewX(f16);
        textPaint.setTextSize(this.f401072n);
        if (this.f401069k) {
            textPaint.setLetterSpacing(this.f401070l);
        }
    }
}
