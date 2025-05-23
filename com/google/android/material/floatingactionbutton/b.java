package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import x0.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f33671a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final ExtendedFloatingActionButton f33672b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f33673c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.a f33674d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private h f33675e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private h f33676f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(x0.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.f33642j0.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f33672b.f33642j0.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f16) {
            int colorForState = extendedFloatingActionButton.f33642j0.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f33672b.f33642j0.getDefaultColor());
            ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (x0.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f16.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f16.floatValue() == 1.0f) {
                extendedFloatingActionButton.Q(extendedFloatingActionButton.f33642j0);
            } else {
                extendedFloatingActionButton.Q(valueOf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar) {
        this.f33672b = extendedFloatingActionButton;
        this.f33671a = extendedFloatingActionButton.getContext();
        this.f33674d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet d() {
        return h(i());
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void f(@Nullable h hVar) {
        this.f33676f = hVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @NonNull
    public final List<Animator.AnimatorListener> getListeners() {
        return this.f33673c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AnimatorSet h(@NonNull h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.j("opacity")) {
            arrayList.add(hVar.f("opacity", this.f33672b, View.ALPHA));
        }
        if (hVar.j("scale")) {
            arrayList.add(hVar.f("scale", this.f33672b, View.SCALE_Y));
            arrayList.add(hVar.f("scale", this.f33672b, View.SCALE_X));
        }
        if (hVar.j("width")) {
            arrayList.add(hVar.f("width", this.f33672b, ExtendedFloatingActionButton.f33629l0));
        }
        if (hVar.j("height")) {
            arrayList.add(hVar.f("height", this.f33672b, ExtendedFloatingActionButton.f33630m0));
        }
        if (hVar.j("paddingStart")) {
            arrayList.add(hVar.f("paddingStart", this.f33672b, ExtendedFloatingActionButton.f33631n0));
        }
        if (hVar.j("paddingEnd")) {
            arrayList.add(hVar.f("paddingEnd", this.f33672b, ExtendedFloatingActionButton.f33632o0));
        }
        if (hVar.j("labelOpacity")) {
            arrayList.add(hVar.f("labelOpacity", this.f33672b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        x0.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final h i() {
        h hVar = this.f33676f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f33675e == null) {
            this.f33675e = h.d(this.f33671a, b());
        }
        return (h) Preconditions.checkNotNull(this.f33675e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void onAnimationCancel() {
        this.f33674d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void onAnimationEnd() {
        this.f33674d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.f33674d.c(animator);
    }
}
