package com.tencent.ecommerce.richtext.ui.view.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ecommerce.richtext.ui.component.image.VImage2;
import com.tencent.ecommerce.richtext.ui.dom.style.g;
import com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable;
import com.tencent.ecommerce.richtext.utils.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import fk0.d;
import java.lang.ref.WeakReference;
import lk0.h;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class VImageView2 extends ImageView {
    private static final ColorDrawable F = new ColorDrawable(0);
    private String C;
    private long D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<VImage2> f105467d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f105468e;

    /* renamed from: f, reason: collision with root package name */
    private float f105469f;

    /* renamed from: h, reason: collision with root package name */
    private float f105470h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f105471i;

    /* renamed from: m, reason: collision with root package name */
    private int f105472m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ImageDrawable.a {
        a() {
        }

        @Override // com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.a
        public void a(Drawable drawable, String str) {
            if (!VImageView2.this.o(drawable, str)) {
                VImageView2.this.s(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements ImageDrawable.a {
        b() {
        }

        @Override // com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.a
        public void a(Drawable drawable, String str) {
            if (!VImageView2.this.o(drawable, str)) {
                VImageView2.this.r(drawable);
                VImageView2.this.s(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ImageDrawable.a {
        c() {
        }

        @Override // com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.a
        public void a(Drawable drawable, String str) {
            if (!VImageView2.this.o(drawable, str)) {
                VImageView2.this.r(drawable);
                VImageView2.this.s(drawable);
            }
        }
    }

    public VImageView2(Context context) {
        super(context);
        this.f105468e = new float[8];
        this.f105471i = true;
        this.f105472m = 200;
        this.E = true;
    }

    private void g(Drawable drawable, int i3, ViewGroup.LayoutParams layoutParams) {
        ImageDrawable.d(drawable, getScaleType(), this.C, (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom(), i3, k(), new a(), v());
    }

    private void h(Drawable drawable, int i3, ViewGroup.LayoutParams layoutParams) {
        ImageDrawable.h(drawable, getScaleType(), this.C, i3, (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom(), k(), new c(), v());
    }

    private void i(Drawable drawable, ViewGroup.LayoutParams layoutParams) {
        ImageDrawable.g(drawable, getScaleType(), (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom(), this.C, new b(), v());
    }

    private int k() {
        int i3;
        VImage2 j3 = j();
        if (j3 != null) {
            i3 = j3.a0();
        } else {
            i3 = 7;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    private boolean l() {
        if (!p() && n()) {
            return false;
        }
        return true;
    }

    private boolean n() {
        for (float f16 : this.f105468e) {
            if (f16 != 0.0f) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(Drawable drawable, String str) {
        if (drawable != null) {
            if (str == null || str.equals(this.C)) {
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean p() {
        if (this.f105469f != 0.0f) {
            return true;
        }
        return false;
    }

    private boolean q() {
        long currentTimeMillis = System.currentTimeMillis() - this.D;
        if (this.E && currentTimeMillis > 100 && this.f105471i) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Drawable drawable) {
        if (drawable instanceof ImageDrawable) {
            ImageDrawable imageDrawable = (ImageDrawable) drawable;
            if (!n()) {
                imageDrawable.setCornerRadii(this.f105468e);
            } else if (p()) {
                imageDrawable.setCornerRadius(this.f105469f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Drawable drawable) {
        if (!q()) {
            super.setImageDrawable(drawable);
            return;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{F, drawable});
        super.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(this.f105472m);
    }

    private void t(final Drawable drawable) {
        if (!ImageDrawable.p()) {
            d.c().e(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.VImageView2.1
                @Override // java.lang.Runnable
                public void run() {
                    VImageView2.this.s(drawable);
                }
            });
        } else {
            s(drawable);
        }
    }

    private void u() {
        float f16;
        float f17;
        float f18;
        VImage2 j3 = j();
        if (j3 == null) {
            return;
        }
        float f19 = this.f105470h;
        if (f19 > 0.1f) {
            final float f26 = (float) (f19 / 1.5d);
            h g06 = j3.m().g0();
            int i06 = j3.m().i0();
            final float O = g06.O(i06);
            final float Q = g06.Q(i06);
            final float P = g06.P(i06);
            final float N = g06.N(i06);
            if (!e.q()) {
                d.c().e(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.VImageView2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float f27;
                        float f28;
                        float f29;
                        float f36;
                        VImageView2 vImageView2 = VImageView2.this;
                        if (!Float.isNaN(O)) {
                            f27 = O + f26;
                        } else {
                            f27 = f26;
                        }
                        int round = Math.round(f27);
                        if (!Float.isNaN(Q)) {
                            f28 = Q + f26;
                        } else {
                            f28 = f26;
                        }
                        int round2 = Math.round(f28);
                        if (!Float.isNaN(P)) {
                            f29 = P + f26;
                        } else {
                            f29 = f26;
                        }
                        int round3 = Math.round(f29);
                        if (!Float.isNaN(N)) {
                            f36 = N + f26;
                        } else {
                            f36 = f26;
                        }
                        vImageView2.setPadding(round, round2, round3, Math.round(f36));
                    }
                });
                return;
            }
            if (!Float.isNaN(O)) {
                f16 = O + f26;
            } else {
                f16 = f26;
            }
            int round = Math.round(f16);
            if (!Float.isNaN(Q)) {
                f17 = Q + f26;
            } else {
                f17 = f26;
            }
            int round2 = Math.round(f17);
            if (!Float.isNaN(P)) {
                f18 = P + f26;
            } else {
                f18 = f26;
            }
            int round3 = Math.round(f18);
            if (!Float.isNaN(N)) {
                f26 += N;
            }
            setPadding(round, round2, round3, Math.round(f26));
        }
    }

    private boolean v() {
        lk0.b m3;
        VImage2 j3 = j();
        if (j3 == null || (m3 = j3.m()) == null || !m3.Z().containsKey("sizeLimitIfCover")) {
            return true;
        }
        return e.f(m3.Z().get("sizeLimitIfCover"));
    }

    public void f(VImage2 vImage2) {
        this.f105467d = new WeakReference<>(vImage2);
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        VImage2 j3 = j();
        if (j3 != null && j3.m() != null) {
            Object obj = j3.m().Z().get("resize");
            if ((obj instanceof String) && !TextUtils.isEmpty(obj.toString())) {
                return VImage2.Z((String) obj);
            }
            return super.getScaleType();
        }
        return super.getScaleType();
    }

    public VImage2 j() {
        WeakReference<VImage2> weakReference = this.f105467d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void m(lk0.b bVar) {
        if (bVar == null) {
            return;
        }
        h g06 = bVar.g0();
        int i06 = bVar.i0();
        if (g06.containsKey(NodeProps.BORDER_TOP_LEFT_RADIUS)) {
            float j3 = g.j(g06.get(NodeProps.BORDER_TOP_LEFT_RADIUS), i06);
            float[] fArr = this.f105468e;
            fArr[0] = j3;
            fArr[1] = j3;
        }
        if (g06.containsKey(NodeProps.BORDER_TOP_RIGHT_RADIUS)) {
            float j16 = g.j(g06.get(NodeProps.BORDER_TOP_RIGHT_RADIUS), i06);
            float[] fArr2 = this.f105468e;
            fArr2[2] = j16;
            fArr2[3] = j16;
        }
        if (g06.containsKey(NodeProps.BORDER_BOTTOM_LEFT_RADIUS)) {
            float j17 = g.j(g06.get(NodeProps.BORDER_BOTTOM_LEFT_RADIUS), i06);
            float[] fArr3 = this.f105468e;
            fArr3[4] = j17;
            fArr3[5] = j17;
        }
        if (g06.containsKey(NodeProps.BORDER_BOTTOM_RIGHT_RADIUS)) {
            float j18 = g.j(g06.get(NodeProps.BORDER_BOTTOM_RIGHT_RADIUS), i06);
            float[] fArr4 = this.f105468e;
            fArr4[6] = j18;
            fArr4[7] = j18;
        }
        if (g06.containsKey(NodeProps.BORDER_RADIUS)) {
            this.f105469f = g.j(g06.get(NodeProps.BORDER_RADIUS), i06);
        }
    }

    public void setAlphaAnim(boolean z16) {
        this.E = z16;
    }

    public void setAlphaAnimDuration(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.f105472m = i3;
    }

    public void setBorderRadius(float f16) {
        this.f105469f = f16;
    }

    public void setBorderWidth(float f16) {
        this.f105470h = f16;
    }

    public void setBottomLeftBorderRadius(float f16) {
        float[] fArr = this.f105468e;
        fArr[6] = f16;
        fArr[7] = f16;
    }

    public void setBottomRightBorderRadius(float f16) {
        float[] fArr = this.f105468e;
        fArr[4] = f16;
        fArr[5] = f16;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setImageDrawable(null);
        } else {
            setInternalImageDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        setImageDrawable(getResources().getDrawable(i3));
    }

    public void setImageStartTs(long j3) {
        this.D = j3;
    }

    public void setInternalImageDrawable(@Nullable Drawable drawable) {
        boolean z16;
        VImage2 j3 = j();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (j3 != null && j3.m() != null && layoutParams != null) {
            u();
            int Y = j3.Y();
            boolean z17 = true;
            if (Y > 0 && drawable != null && drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (j() == null || !j().f0()) {
                z17 = false;
            }
            boolean l3 = l();
            if (z17) {
                t(drawable);
                return;
            }
            if (z16 && l3) {
                h(drawable, Y, layoutParams);
                return;
            }
            if (l3) {
                i(drawable, layoutParams);
            } else if (z16) {
                g(drawable, Y, layoutParams);
            } else {
                t(drawable);
            }
        }
    }

    public void setNeedFading(boolean z16) {
        this.f105471i = z16;
    }

    public void setTopLeftBorderRadius(float f16) {
        float[] fArr = this.f105468e;
        fArr[0] = f16;
        fArr[1] = f16;
    }

    public void setTopRightBorderRadius(float f16) {
        float[] fArr = this.f105468e;
        fArr[2] = f16;
        fArr[3] = f16;
    }

    public void setUrl(String str) {
        this.C = str;
    }
}
