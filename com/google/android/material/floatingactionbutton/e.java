package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.g;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
@RequiresApi(21)
/* loaded from: classes2.dex */
class e extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a extends MaterialShapeDrawable {
        a(g gVar) {
            super(gVar);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FloatingActionButton floatingActionButton, i1.b bVar) {
        super(floatingActionButton, bVar);
    }

    @NonNull
    private Animator f0(float f16, float f17) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f33717w, "elevation", f16).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f33717w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f17).setDuration(100L));
        animatorSet.setInterpolator(d.D);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void B(float f16, float f17, float f18) {
        int i3 = Build.VERSION.SDK_INT;
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(d.E, f0(f16, f18));
        stateListAnimator.addState(d.F, f0(f16, f17));
        stateListAnimator.addState(d.G, f0(f16, f17));
        stateListAnimator.addState(d.H, f0(f16, f17));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f33717w, "elevation", f16).setDuration(0L));
        if (i3 <= 24) {
            FloatingActionButton floatingActionButton = this.f33717w;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f33717w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(d.D);
        stateListAnimator.addState(d.I, animatorSet);
        stateListAnimator.addState(d.J, f0(0.0f, 0.0f));
        this.f33717w.setStateListAnimator(stateListAnimator);
        if (V()) {
            b0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean G() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void R(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f33697c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(h1.b.d(colorStateList));
        } else {
            super.R(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean V() {
        if (!this.f33718x.a() && X()) {
            return false;
        }
        return true;
    }

    @NonNull
    c e0(int i3, ColorStateList colorStateList) {
        Context context = this.f33717w.getContext();
        c cVar = new c((g) Preconditions.checkNotNull(this.f33695a));
        cVar.e(ContextCompat.getColor(context, R.color.bhq), ContextCompat.getColor(context, R.color.bhp), ContextCompat.getColor(context, R.color.bhn), ContextCompat.getColor(context, R.color.bho));
        cVar.d(i3);
        cVar.c(colorStateList);
        return cVar;
    }

    @NonNull
    MaterialShapeDrawable g0() {
        return new a((g) Preconditions.checkNotNull(this.f33695a));
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float l() {
        return this.f33717w.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void p(@NonNull Rect rect) {
        if (this.f33718x.a()) {
            super.p(rect);
        } else if (!X()) {
            int p16 = (this.f33705k - this.f33717w.p()) / 2;
            rect.set(p16, p16, p16, p16);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void t(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i3) {
        Drawable drawable;
        MaterialShapeDrawable g06 = g0();
        this.f33696b = g06;
        g06.setTintList(colorStateList);
        if (mode != null) {
            this.f33696b.setTintMode(mode);
        }
        this.f33696b.N(this.f33717w.getContext());
        if (i3 > 0) {
            this.f33698d = e0(i3, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f33698d), (Drawable) Preconditions.checkNotNull(this.f33696b)});
        } else {
            this.f33698d = null;
            drawable = this.f33696b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(h1.b.d(colorStateList2), drawable, null);
        this.f33697c = rippleDrawable;
        this.f33699e = rippleDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void y() {
        b0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void Z() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void w() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void A(int[] iArr) {
    }
}
