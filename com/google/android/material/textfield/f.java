package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f34421a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final TextInputLayout f34422b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f34423c;

    /* renamed from: d, reason: collision with root package name */
    private int f34424d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f34425e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Animator f34426f;

    /* renamed from: g, reason: collision with root package name */
    private final float f34427g;

    /* renamed from: h, reason: collision with root package name */
    private int f34428h;

    /* renamed from: i, reason: collision with root package name */
    private int f34429i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private CharSequence f34430j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f34431k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private TextView f34432l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private CharSequence f34433m;

    /* renamed from: n, reason: collision with root package name */
    private int f34434n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private ColorStateList f34435o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f34436p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f34437q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    private TextView f34438r;

    /* renamed from: s, reason: collision with root package name */
    private int f34439s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    private ColorStateList f34440t;

    /* renamed from: u, reason: collision with root package name */
    private Typeface f34441u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f34442d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f34443e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f34444f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ TextView f34445h;

        a(int i3, TextView textView, int i16, TextView textView2) {
            this.f34442d = i3;
            this.f34443e = textView;
            this.f34444f = i16;
            this.f34445h = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f34428h = this.f34442d;
            f.this.f34426f = null;
            TextView textView = this.f34443e;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f34444f == 1 && f.this.f34432l != null) {
                    f.this.f34432l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f34445h;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f34445h.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f34445h;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText L = f.this.f34422b.L();
            if (L != null) {
                accessibilityNodeInfo.setLabeledBy(L);
            }
        }
    }

    public f(@NonNull TextInputLayout textInputLayout) {
        this.f34421a = textInputLayout.getContext();
        this.f34422b = textInputLayout;
        this.f34427g = r0.getResources().getDimensionPixelSize(R.dimen.c9d);
    }

    private void A(int i3, int i16) {
        TextView m3;
        TextView m16;
        if (i3 == i16) {
            return;
        }
        if (i16 != 0 && (m16 = m(i16)) != null) {
            m16.setVisibility(0);
            m16.setAlpha(1.0f);
        }
        if (i3 != 0 && (m3 = m(i3)) != null) {
            m3.setVisibility(4);
            if (i3 == 1) {
                m3.setText((CharSequence) null);
            }
        }
        this.f34428h = i16;
    }

    private void I(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void K(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean L(@Nullable TextView textView, @NonNull CharSequence charSequence) {
        if (ViewCompat.isLaidOut(this.f34422b) && this.f34422b.isEnabled() && (this.f34429i != this.f34428h || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    private void O(int i3, int i16, boolean z16) {
        if (i3 == i16) {
            return;
        }
        if (z16) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f34426f = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f34437q, this.f34438r, 2, i3, i16);
            i(arrayList, this.f34431k, this.f34432l, 1, i3, i16);
            x0.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i16, m(i3), i3, m(i16)));
            animatorSet.start();
        } else {
            A(i3, i16);
        }
        this.f34422b.N0();
        this.f34422b.S0(z16);
        this.f34422b.a1();
    }

    private boolean g() {
        if (this.f34423c != null && this.f34422b.L() != null) {
            return true;
        }
        return false;
    }

    private void i(@NonNull List<Animator> list, boolean z16, @Nullable TextView textView, int i3, int i16, int i17) {
        boolean z17;
        if (textView != null && z16) {
            if (i3 == i17 || i3 == i16) {
                if (i17 == i3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                list.add(j(textView, z17));
                if (i17 == i3) {
                    list.add(k(textView));
                }
            }
        }
    }

    private ObjectAnimator j(TextView textView, boolean z16) {
        float f16;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, f16);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(x0.a.f446810a);
        return ofFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f34427g, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(x0.a.f446813d);
        return ofFloat;
    }

    @Nullable
    private TextView m(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            return this.f34438r;
        }
        return this.f34432l;
    }

    private int s(boolean z16, @DimenRes int i3, int i16) {
        if (z16) {
            return this.f34421a.getResources().getDimensionPixelSize(i3);
        }
        return i16;
    }

    private boolean v(int i3) {
        if (i3 == 1 && this.f34432l != null && !TextUtils.isEmpty(this.f34430j)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(@Nullable CharSequence charSequence) {
        this.f34433m = charSequence;
        TextView textView = this.f34432l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(boolean z16) {
        if (this.f34431k == z16) {
            return;
        }
        h();
        if (z16) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f34421a);
            this.f34432l = appCompatTextView;
            appCompatTextView.setId(R.id.f95955gd);
            this.f34432l.setTextAlignment(5);
            Typeface typeface = this.f34441u;
            if (typeface != null) {
                this.f34432l.setTypeface(typeface);
            }
            D(this.f34434n);
            E(this.f34435o);
            B(this.f34433m);
            this.f34432l.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f34432l, 1);
            e(this.f34432l, 0);
        } else {
            t();
            z(this.f34432l, 0);
            this.f34432l = null;
            this.f34422b.N0();
            this.f34422b.a1();
        }
        this.f34431k = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(@StyleRes int i3) {
        this.f34434n = i3;
        TextView textView = this.f34432l;
        if (textView != null) {
            this.f34422b.z0(textView, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(@Nullable ColorStateList colorStateList) {
        this.f34435o = colorStateList;
        TextView textView = this.f34432l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(@StyleRes int i3) {
        this.f34439s = i3;
        TextView textView = this.f34438r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z16) {
        if (this.f34437q == z16) {
            return;
        }
        h();
        if (z16) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f34421a);
            this.f34438r = appCompatTextView;
            appCompatTextView.setId(R.id.f95965ge);
            this.f34438r.setTextAlignment(5);
            Typeface typeface = this.f34441u;
            if (typeface != null) {
                this.f34438r.setTypeface(typeface);
            }
            this.f34438r.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f34438r, 1);
            F(this.f34439s);
            H(this.f34440t);
            e(this.f34438r, 1);
            this.f34438r.setAccessibilityDelegate(new b());
        } else {
            u();
            z(this.f34438r, 1);
            this.f34438r = null;
            this.f34422b.N0();
            this.f34422b.a1();
        }
        this.f34437q = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(@Nullable ColorStateList colorStateList) {
        this.f34440t = colorStateList;
        TextView textView = this.f34438r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(Typeface typeface) {
        if (typeface != this.f34441u) {
            this.f34441u = typeface;
            I(this.f34432l, typeface);
            I(this.f34438r, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(CharSequence charSequence) {
        h();
        this.f34430j = charSequence;
        this.f34432l.setText(charSequence);
        int i3 = this.f34428h;
        if (i3 != 1) {
            this.f34429i = 1;
        }
        O(i3, this.f34429i, L(this.f34432l, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(CharSequence charSequence) {
        h();
        this.f34436p = charSequence;
        this.f34438r.setText(charSequence);
        int i3 = this.f34428h;
        if (i3 != 2) {
            this.f34429i = 2;
        }
        O(i3, this.f34429i, L(this.f34438r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(TextView textView, int i3) {
        if (this.f34423c == null && this.f34425e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f34421a);
            this.f34423c = linearLayout;
            linearLayout.setOrientation(0);
            this.f34422b.addView(this.f34423c, -1, -2);
            this.f34425e = new FrameLayout(this.f34421a);
            this.f34423c.addView(this.f34425e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f34422b.L() != null) {
                f();
            }
        }
        if (w(i3)) {
            this.f34425e.setVisibility(0);
            this.f34425e.addView(textView);
        } else {
            this.f34423c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f34423c.setVisibility(0);
        this.f34424d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            EditText L = this.f34422b.L();
            boolean i3 = g1.c.i(this.f34421a);
            ViewCompat.setPaddingRelative(this.f34423c, s(i3, R.dimen.cpf, ViewCompat.getPaddingStart(L)), s(i3, R.dimen.cpg, this.f34421a.getResources().getDimensionPixelSize(R.dimen.cpe)), s(i3, R.dimen.cpf, ViewCompat.getPaddingEnd(L)), 0);
        }
    }

    void h() {
        Animator animator = this.f34426f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return v(this.f34429i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CharSequence n() {
        return this.f34430j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public int o() {
        TextView textView = this.f34432l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList p() {
        TextView textView = this.f34432l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence q() {
        return this.f34436p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public View r() {
        return this.f34438r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        this.f34430j = null;
        h();
        if (this.f34428h == 1) {
            if (this.f34437q && !TextUtils.isEmpty(this.f34436p)) {
                this.f34429i = 2;
            } else {
                this.f34429i = 0;
            }
        }
        O(this.f34428h, this.f34429i, L(this.f34432l, ""));
    }

    void u() {
        h();
        int i3 = this.f34428h;
        if (i3 == 2) {
            this.f34429i = 0;
        }
        O(i3, this.f34429i, L(this.f34438r, ""));
    }

    boolean w(int i3) {
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.f34431k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f34437q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(TextView textView, int i3) {
        FrameLayout frameLayout;
        if (this.f34423c == null) {
            return;
        }
        if (w(i3) && (frameLayout = this.f34425e) != null) {
            frameLayout.removeView(textView);
        } else {
            this.f34423c.removeView(textView);
        }
        int i16 = this.f34424d - 1;
        this.f34424d = i16;
        K(this.f34423c, i16);
    }
}
