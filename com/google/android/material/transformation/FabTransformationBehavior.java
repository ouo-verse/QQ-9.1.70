package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import x0.h;
import x0.i;
import x0.j;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: i, reason: collision with root package name */
    private final Rect f34501i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f34502j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f34503k;

    /* renamed from: l, reason: collision with root package name */
    private final int[] f34504l;

    /* renamed from: m, reason: collision with root package name */
    private float f34505m;

    /* renamed from: n, reason: collision with root package name */
    private float f34506n;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f34507d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f34508e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f34509f;

        a(boolean z16, View view, View view2) {
            this.f34507d = z16;
            this.f34508e = view;
            this.f34509f = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f34507d) {
                this.f34508e.setVisibility(4);
                this.f34509f.setAlpha(1.0f);
                this.f34509f.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f34507d) {
                this.f34508e.setVisibility(0);
                this.f34509f.setAlpha(0.0f);
                this.f34509f.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f34511d;

        b(View view) {
            this.f34511d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f34511d.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.b f34513d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Drawable f34514e;

        c(com.google.android.material.circularreveal.b bVar, Drawable drawable) {
            this.f34513d = bVar;
            this.f34514e = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f34513d.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f34513d.setCircularRevealOverlayDrawable(this.f34514e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.b f34516d;

        d(com.google.android.material.circularreveal.b bVar) {
            this.f34516d = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.e f16 = this.f34516d.f();
            f16.f33509c = Float.MAX_VALUE;
            this.f34516d.setRevealInfo(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public h f34518a;

        /* renamed from: b, reason: collision with root package name */
        public j f34519b;
    }

    public FabTransformationBehavior() {
        this.f34501i = new Rect();
        this.f34502j = new RectF();
        this.f34503k = new RectF();
        this.f34504l = new int[2];
    }

    private int A(@NonNull View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    @Nullable
    private ViewGroup C(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Nullable
    private ViewGroup h(@NonNull View view) {
        View findViewById = view.findViewById(R.id.zh9);
        if (findViewById != null) {
            return C(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return C(view);
        }
        return C(((ViewGroup) view).getChildAt(0));
    }

    private void i(@NonNull View view, @NonNull e eVar, @NonNull i iVar, @NonNull i iVar2, float f16, float f17, float f18, float f19, @NonNull RectF rectF) {
        float p16 = p(eVar, iVar, f16, f18);
        float p17 = p(eVar, iVar2, f17, f19);
        Rect rect = this.f34501i;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f34502j;
        rectF2.set(rect);
        RectF rectF3 = this.f34503k;
        q(view, rectF3);
        rectF3.offset(p16, p17);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void j(@NonNull View view, @NonNull RectF rectF) {
        q(view, rectF);
        rectF.offset(this.f34505m, this.f34506n);
    }

    @NonNull
    private Pair<i, i> k(float f16, float f17, boolean z16, @NonNull e eVar) {
        i h16;
        i h17;
        if (f16 != 0.0f && f17 != 0.0f) {
            if ((z16 && f17 < 0.0f) || (!z16 && f17 > 0.0f)) {
                h16 = eVar.f34518a.h("translationXCurveUpwards");
                h17 = eVar.f34518a.h("translationYCurveUpwards");
            } else {
                h16 = eVar.f34518a.h("translationXCurveDownwards");
                h17 = eVar.f34518a.h("translationYCurveDownwards");
            }
        } else {
            h16 = eVar.f34518a.h("translationXLinear");
            h17 = eVar.f34518a.h("translationYLinear");
        }
        return new Pair<>(h16, h17);
    }

    private float l(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f34502j;
        RectF rectF2 = this.f34503k;
        j(view, rectF);
        q(view2, rectF2);
        rectF2.offset(-n(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float m(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f34502j;
        RectF rectF2 = this.f34503k;
        j(view, rectF);
        q(view2, rectF2);
        rectF2.offset(0.0f, -o(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float n(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float centerX;
        float centerX2;
        float f16;
        RectF rectF = this.f34502j;
        RectF rectF2 = this.f34503k;
        j(view, rectF);
        q(view2, rectF2);
        int i3 = jVar.f446830a & 7;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 5) {
                    f16 = 0.0f;
                    return f16 + jVar.f446831b;
                }
                centerX = rectF2.right;
                centerX2 = rectF.right;
            } else {
                centerX = rectF2.left;
                centerX2 = rectF.left;
            }
        } else {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        }
        f16 = centerX - centerX2;
        return f16 + jVar.f446831b;
    }

    private float o(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float centerY;
        float centerY2;
        float f16;
        RectF rectF = this.f34502j;
        RectF rectF2 = this.f34503k;
        j(view, rectF);
        q(view2, rectF2);
        int i3 = jVar.f446830a & 112;
        if (i3 != 16) {
            if (i3 != 48) {
                if (i3 != 80) {
                    f16 = 0.0f;
                    return f16 + jVar.f446832c;
                }
                centerY = rectF2.bottom;
                centerY2 = rectF.bottom;
            } else {
                centerY = rectF2.top;
                centerY2 = rectF.top;
            }
        } else {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        }
        f16 = centerY - centerY2;
        return f16 + jVar.f446832c;
    }

    private float p(@NonNull e eVar, @NonNull i iVar, float f16, float f17) {
        long c16 = iVar.c();
        long d16 = iVar.d();
        i h16 = eVar.f34518a.h("expansion");
        return x0.a.a(f16, f17, iVar.e().getInterpolation(((float) (((h16.c() + h16.d()) + 17) - c16)) / ((float) d16)));
    }

    private void q(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f34504l);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void r(View view, View view2, boolean z16, boolean z17, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup h16;
        ObjectAnimator ofFloat;
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        if (((view2 instanceof com.google.android.material.circularreveal.b) && CircularRevealHelper.f33490j == 0) || (h16 = h(view2)) == null) {
            return;
        }
        if (z16) {
            if (!z17) {
                x0.d.f446816a.set(h16, Float.valueOf(0.0f));
            }
            ofFloat = ObjectAnimator.ofFloat(h16, x0.d.f446816a, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(h16, x0.d.f446816a, 0.0f);
        }
        eVar.f34518a.h("contentFade").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s(@NonNull View view, View view2, boolean z16, boolean z17, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (!(view2 instanceof com.google.android.material.circularreveal.b)) {
            return;
        }
        com.google.android.material.circularreveal.b bVar = (com.google.android.material.circularreveal.b) view2;
        int A = A(view);
        int i3 = 16777215 & A;
        if (z16) {
            if (!z17) {
                bVar.setCircularRevealScrimColor(A);
            }
            ofInt = ObjectAnimator.ofInt(bVar, b.d.f33506a, i3);
        } else {
            ofInt = ObjectAnimator.ofInt(bVar, b.d.f33506a, A);
        }
        ofInt.setEvaluator(x0.c.b());
        eVar.f34518a.h("color").a(ofInt);
        list.add(ofInt);
    }

    private void t(@NonNull View view, @NonNull View view2, boolean z16, @NonNull e eVar, @NonNull List<Animator> list) {
        float n3 = n(view, view2, eVar.f34519b);
        float o16 = o(view, view2, eVar.f34519b);
        Pair<i, i> k3 = k(n3, o16, z16, eVar);
        i iVar = (i) k3.first;
        i iVar2 = (i) k3.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z16) {
            n3 = this.f34505m;
        }
        fArr[0] = n3;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z16) {
            o16 = this.f34506n;
        }
        fArr2[0] = o16;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void u(View view, @NonNull View view2, boolean z16, boolean z17, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z16) {
            if (!z17) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.f34518a.h("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v(@NonNull View view, View view2, boolean z16, boolean z17, @NonNull e eVar, float f16, float f17, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (!(view2 instanceof com.google.android.material.circularreveal.b)) {
            return;
        }
        com.google.android.material.circularreveal.b bVar = (com.google.android.material.circularreveal.b) view2;
        float l3 = l(view, view2, eVar.f34519b);
        float m3 = m(view, view2, eVar.f34519b);
        ((FloatingActionButton) view).i(this.f34501i);
        float width = this.f34501i.width() / 2.0f;
        i h16 = eVar.f34518a.h("expansion");
        if (z16) {
            if (!z17) {
                bVar.setRevealInfo(new b.e(l3, m3, width));
            }
            if (z17) {
                width = bVar.f().f33509c;
            }
            animator = com.google.android.material.circularreveal.a.a(bVar, l3, m3, e1.a.b(l3, m3, 0.0f, 0.0f, f16, f17));
            animator.addListener(new d(bVar));
            y(view2, h16.c(), (int) l3, (int) m3, width, list);
        } else {
            float f18 = bVar.f().f33509c;
            Animator a16 = com.google.android.material.circularreveal.a.a(bVar, l3, m3, width);
            int i3 = (int) l3;
            int i16 = (int) m3;
            y(view2, h16.c(), i3, i16, f18, list);
            x(view2, h16.c(), h16.d(), eVar.f34518a.i(), i3, i16, width, list);
            animator = a16;
        }
        h16.a(animator);
        list.add(animator);
        list2.add(com.google.android.material.circularreveal.a.b(bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w(View view, View view2, boolean z16, boolean z17, @NonNull e eVar, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof com.google.android.material.circularreveal.b) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.b bVar = (com.google.android.material.circularreveal.b) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z16) {
                if (!z17) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, x0.e.f446817b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, x0.e.f446817b, 255);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.f34518a.h("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(bVar, drawable));
        }
    }

    private void x(View view, long j3, long j16, long j17, int i3, int i16, float f16, @NonNull List<Animator> list) {
        long j18 = j3 + j16;
        if (j18 < j17) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i3, i16, f16, f16);
            createCircularReveal.setStartDelay(j18);
            createCircularReveal.setDuration(j17 - j18);
            list.add(createCircularReveal);
        }
    }

    private void y(View view, long j3, int i3, int i16, float f16, @NonNull List<Animator> list) {
        if (j3 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i3, i16, f16, f16);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j3);
            list.add(createCircularReveal);
        }
    }

    private void z(@NonNull View view, @NonNull View view2, boolean z16, boolean z17, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float n3 = n(view, view2, eVar.f34519b);
        float o16 = o(view, view2, eVar.f34519b);
        Pair<i, i> k3 = k(n3, o16, z16, eVar);
        i iVar = (i) k3.first;
        i iVar2 = (i) k3.second;
        if (z16) {
            if (!z17) {
                view2.setTranslationX(-n3);
                view2.setTranslationY(-o16);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            i(view2, eVar, iVar, iVar2, -n3, -o16, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -n3);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -o16);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    protected abstract e B(Context context, boolean z16);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet g(@NonNull View view, @NonNull View view2, boolean z16, boolean z17) {
        e B = B(view2.getContext(), z16);
        if (z16) {
            this.f34505m = view.getTranslationX();
            this.f34506n = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        u(view, view2, z16, z17, B, arrayList, arrayList2);
        RectF rectF = this.f34502j;
        z(view, view2, z16, z17, B, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        t(view, view2, z16, B, arrayList);
        w(view, view2, z16, z17, B, arrayList, arrayList2);
        v(view, view2, z16, z17, B, width, height, arrayList, arrayList2);
        s(view, view2, z16, z17, B, arrayList, arrayList2);
        r(view, view2, z16, z17, B, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        x0.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z16, view2, view));
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            animatorSet.addListener(arrayList2.get(i3));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int j3 = ((FloatingActionButton) view2).j();
            if (j3 != 0 && j3 != view.getId()) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34501i = new Rect();
        this.f34502j = new RectF();
        this.f34503k = new RectF();
        this.f34504l = new int[2];
    }
}
