package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.l;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;
import g1.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BadgeDrawable extends Drawable implements l.b {

    @StyleRes
    private static final int J = 2131953400;

    @AttrRes
    private static final int K = 2130968835;
    private float C;
    private int D;
    private float E;
    private float F;
    private float G;

    @Nullable
    private WeakReference<View> H;

    @Nullable
    private WeakReference<FrameLayout> I;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final WeakReference<Context> f33251d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f33252e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final l f33253f;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final Rect f33254h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final BadgeState f33255i;

    /* renamed from: m, reason: collision with root package name */
    private float f33256m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface BadgeGravity {
    }

    BadgeDrawable(@NonNull Context context, @XmlRes int i3, @AttrRes int i16, @StyleRes int i17, @Nullable BadgeState.State state) {
        this.f33251d = new WeakReference<>(context);
        o.c(context);
        this.f33254h = new Rect();
        this.f33252e = new MaterialShapeDrawable();
        l lVar = new l(this);
        this.f33253f = lVar;
        lVar.e().setTextAlign(Paint.Align.CENTER);
        z(R.style.abz);
        this.f33255i = new BadgeState(context, i3, i16, i17, state);
        v();
    }

    private void A(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.zgz) {
            WeakReference<FrameLayout> weakReference = this.I;
            if (weakReference != null && weakReference.get() == viewGroup) {
                return;
            }
            B(view);
            final FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(R.id.zgz);
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            frameLayout.setLayoutParams(view.getLayoutParams());
            frameLayout.setMinimumWidth(view.getWidth());
            frameLayout.setMinimumHeight(view.getHeight());
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeViewAt(indexOfChild);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(view);
            viewGroup.addView(frameLayout, indexOfChild);
            this.I = new WeakReference<>(frameLayout);
            frameLayout.post(new Runnable() { // from class: com.google.android.material.badge.BadgeDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    BadgeDrawable.this.C(view, frameLayout);
                }
            });
        }
    }

    private static void B(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void D() {
        View view;
        Context context = this.f33251d.get();
        WeakReference<View> weakReference = this.H;
        FrameLayout frameLayout = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f33254h);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.I;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null || c.f33274a) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            b(context, rect2, view);
            c.i(this.f33254h, this.f33256m, this.C, this.F, this.G);
            this.f33252e.V(this.E);
            if (!rect.equals(this.f33254h)) {
                this.f33252e.setBounds(this.f33254h);
            }
        }
    }

    private void E() {
        this.D = ((int) Math.pow(10.0d, i() - 1.0d)) - 1;
    }

    private void b(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i3;
        float f16;
        float f17;
        float f18;
        int m3 = m();
        int f19 = this.f33255i.f();
        if (f19 != 8388691 && f19 != 8388693) {
            this.C = rect.top + m3;
        } else {
            this.C = rect.bottom - m3;
        }
        if (j() <= 9) {
            if (!n()) {
                f18 = this.f33255i.f33261c;
            } else {
                f18 = this.f33255i.f33262d;
            }
            this.E = f18;
            this.G = f18;
            this.F = f18;
        } else {
            float f26 = this.f33255i.f33262d;
            this.E = f26;
            this.G = f26;
            this.F = (this.f33253f.f(e()) / 2.0f) + this.f33255i.f33263e;
        }
        Resources resources = context.getResources();
        if (n()) {
            i3 = R.dimen.crc;
        } else {
            i3 = R.dimen.cr_;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i3);
        int l3 = l();
        int f27 = this.f33255i.f();
        if (f27 != 8388659 && f27 != 8388691) {
            if (ViewCompat.getLayoutDirection(view) == 0) {
                f17 = ((rect.right + this.F) - dimensionPixelSize) - l3;
            } else {
                f17 = (rect.left - this.F) + dimensionPixelSize + l3;
            }
            this.f33256m = f17;
            return;
        }
        if (ViewCompat.getLayoutDirection(view) == 0) {
            f16 = (rect.left - this.F) + dimensionPixelSize + l3;
        } else {
            f16 = ((rect.right + this.F) - dimensionPixelSize) - l3;
        }
        this.f33256m = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static BadgeDrawable c(@NonNull Context context, @NonNull BadgeState.State state) {
        return new BadgeDrawable(context, 0, K, J, state);
    }

    private void d(Canvas canvas) {
        Rect rect = new Rect();
        String e16 = e();
        this.f33253f.e().getTextBounds(e16, 0, e16.length(), rect);
        canvas.drawText(e16, this.f33256m, this.C + (rect.height() / 2), this.f33253f.e());
    }

    @NonNull
    private String e() {
        if (j() <= this.D) {
            return NumberFormat.getInstance(this.f33255i.o()).format(j());
        }
        Context context = this.f33251d.get();
        if (context == null) {
            return "";
        }
        return String.format(this.f33255i.o(), context.getString(R.string.f168492fs), Integer.valueOf(this.D), Marker.ANY_NON_NULL_MARKER);
    }

    private int l() {
        int l3;
        if (n()) {
            l3 = this.f33255i.k();
        } else {
            l3 = this.f33255i.l();
        }
        return l3 + this.f33255i.b();
    }

    private int m() {
        int r16;
        if (n()) {
            r16 = this.f33255i.q();
        } else {
            r16 = this.f33255i.r();
        }
        return r16 + this.f33255i.c();
    }

    private void o() {
        this.f33253f.e().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void p() {
        ColorStateList valueOf = ColorStateList.valueOf(this.f33255i.e());
        if (this.f33252e.x() != valueOf) {
            this.f33252e.Y(valueOf);
            invalidateSelf();
        }
    }

    private void q() {
        FrameLayout frameLayout;
        WeakReference<View> weakReference = this.H;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.H.get();
            WeakReference<FrameLayout> weakReference2 = this.I;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            } else {
                frameLayout = null;
            }
            C(view, frameLayout);
        }
    }

    private void r() {
        this.f33253f.e().setColor(this.f33255i.g());
        invalidateSelf();
    }

    private void s() {
        E();
        this.f33253f.i(true);
        D();
        invalidateSelf();
    }

    private void t() {
        this.f33253f.i(true);
        D();
        invalidateSelf();
    }

    private void u() {
        boolean t16 = this.f33255i.t();
        setVisible(t16, false);
        if (c.f33274a && g() != null && !t16) {
            ((ViewGroup) g().getParent()).invalidate();
        }
    }

    private void v() {
        s();
        t();
        o();
        p();
        r();
        q();
        D();
        u();
    }

    private void y(@Nullable d dVar) {
        Context context;
        if (this.f33253f.d() == dVar || (context = this.f33251d.get()) == null) {
            return;
        }
        this.f33253f.h(dVar, context);
        D();
    }

    private void z(@StyleRes int i3) {
        Context context = this.f33251d.get();
        if (context == null) {
            return;
        }
        y(new d(context, i3));
    }

    public void C(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.H = new WeakReference<>(view);
        boolean z16 = c.f33274a;
        if (z16 && frameLayout == null) {
            A(view);
        } else {
            this.I = new WeakReference<>(frameLayout);
        }
        if (!z16) {
            B(view);
        }
        D();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.l.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f33252e.draw(canvas);
            if (n()) {
                d(canvas);
            }
        }
    }

    @Nullable
    public CharSequence f() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (n()) {
            if (this.f33255i.j() == 0 || (context = this.f33251d.get()) == null) {
                return null;
            }
            if (j() <= this.D) {
                return context.getResources().getQuantityString(this.f33255i.j(), j(), Integer.valueOf(j()));
            }
            return context.getString(this.f33255i.h(), Integer.valueOf(this.D));
        }
        return this.f33255i.i();
    }

    @Nullable
    public FrameLayout g() {
        WeakReference<FrameLayout> weakReference = this.I;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f33255i.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f33254h.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f33254h.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f33255i.l();
    }

    public int i() {
        return this.f33255i.m();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int j() {
        if (n()) {
            return this.f33255i.n();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public BadgeState.State k() {
        return this.f33255i.p();
    }

    public boolean n() {
        return this.f33255i.s();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.l.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f33255i.x(i3);
        o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i3) {
        this.f33255i.v(i3);
        D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(@Px int i3) {
        this.f33255i.w(i3);
        D();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
