package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import com.google.android.material.internal.r;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.g;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import com.tencent.mobileqq.R;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {
    private static final String A0 = "BaseSlider";
    static final int B0 = 2131953478;

    @NonNull
    private final d C;
    private final AccessibilityManager D;
    private BaseSlider<S, L, T>.AccessibilityEventSender E;

    @NonNull
    private final e F;

    @NonNull
    private final List<l1.a> G;

    @NonNull
    private final List<L> H;

    @NonNull
    private final List<T> I;
    private boolean J;
    private ValueAnimator K;
    private ValueAnimator L;
    private final int M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f34122a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f34123b0;

    /* renamed from: c0, reason: collision with root package name */
    private MotionEvent f34124c0;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Paint f34125d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f34126d0;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final Paint f34127e;

    /* renamed from: e0, reason: collision with root package name */
    private float f34128e0;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final Paint f34129f;

    /* renamed from: f0, reason: collision with root package name */
    private float f34130f0;

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<Float> f34131g0;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final Paint f34132h;

    /* renamed from: h0, reason: collision with root package name */
    private int f34133h0;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final Paint f34134i;

    /* renamed from: i0, reason: collision with root package name */
    private int f34135i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f34136j0;

    /* renamed from: k0, reason: collision with root package name */
    private float[] f34137k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f34138l0;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    private final Paint f34139m;

    /* renamed from: m0, reason: collision with root package name */
    private int f34140m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f34141n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f34142o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f34143p0;

    /* renamed from: q0, reason: collision with root package name */
    @NonNull
    private ColorStateList f34144q0;

    /* renamed from: r0, reason: collision with root package name */
    @NonNull
    private ColorStateList f34145r0;

    /* renamed from: s0, reason: collision with root package name */
    @NonNull
    private ColorStateList f34146s0;

    /* renamed from: t0, reason: collision with root package name */
    @NonNull
    private ColorStateList f34147t0;

    /* renamed from: u0, reason: collision with root package name */
    @NonNull
    private ColorStateList f34148u0;

    /* renamed from: v0, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f34149v0;

    /* renamed from: w0, reason: collision with root package name */
    @Nullable
    private Drawable f34150w0;

    /* renamed from: x0, reason: collision with root package name */
    @NonNull
    private List<Drawable> f34151x0;

    /* renamed from: y0, reason: collision with root package name */
    private float f34152y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f34153z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        float f34155d;

        /* renamed from: e, reason: collision with root package name */
        float f34156e;

        /* renamed from: f, reason: collision with root package name */
        ArrayList<Float> f34157f;

        /* renamed from: h, reason: collision with root package name */
        float f34158h;

        /* renamed from: i, reason: collision with root package name */
        boolean f34159i;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<SliderState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i3) {
                return new SliderState[i3];
            }
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeFloat(this.f34155d);
            parcel.writeFloat(this.f34156e);
            parcel.writeList(this.f34157f);
            parcel.writeFloat(this.f34158h);
            parcel.writeBooleanArray(new boolean[]{this.f34159i});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.f34155d = parcel.readFloat();
            this.f34156e = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f34157f = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f34158h = parcel.readFloat();
            this.f34159i = parcel.createBooleanArray()[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AttributeSet f34160a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f34161b;

        a(AttributeSet attributeSet, int i3) {
            this.f34160a = attributeSet;
            this.f34161b = i3;
        }

        @Override // com.google.android.material.slider.BaseSlider.e
        public l1.a a() {
            TypedArray h16 = o.h(BaseSlider.this.getContext(), this.f34160a, w0.a.F7, this.f34161b, BaseSlider.B0, new int[0]);
            l1.a d06 = BaseSlider.d0(BaseSlider.this.getContext(), h16);
            h16.recycle();
            return d06;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.G.iterator();
            while (it.hasNext()) {
                ((l1.a) it.next()).y0(floatValue);
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator it = BaseSlider.this.G.iterator();
            while (it.hasNext()) {
                ViewUtils.f(BaseSlider.this).remove((l1.a) it.next());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class d extends ExploreByTouchHelper {

        /* renamed from: a, reason: collision with root package name */
        private final BaseSlider<?, ?, ?> f34165a;

        /* renamed from: b, reason: collision with root package name */
        final Rect f34166b;

        d(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f34166b = new Rect();
            this.f34165a = baseSlider;
        }

        @NonNull
        private String a(int i3) {
            if (i3 == this.f34165a.L().size() - 1) {
                return this.f34165a.getContext().getString(R.string.f16454264);
            }
            if (i3 == 0) {
                return this.f34165a.getContext().getString(R.string.f16455265);
            }
            return "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            for (int i3 = 0; i3 < this.f34165a.L().size(); i3++) {
                this.f34165a.s0(i3, this.f34166b);
                if (this.f34166b.contains((int) f16, (int) f17)) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int i3 = 0; i3 < this.f34165a.L().size(); i3++) {
                list.add(Integer.valueOf(i3));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (!this.f34165a.isEnabled()) {
                return false;
            }
            if (i16 == 4096 || i16 == 8192) {
                float l3 = this.f34165a.l(20);
                if (i16 == 8192) {
                    l3 = -l3;
                }
                if (this.f34165a.R()) {
                    l3 = -l3;
                }
                if (this.f34165a.q0(i3, MathUtils.clamp(this.f34165a.L().get(i3).floatValue() + l3, this.f34165a.H(), this.f34165a.K()))) {
                    this.f34165a.t0();
                    this.f34165a.postInvalidate();
                    invalidateVirtualView(i3);
                    return true;
                }
                return false;
            }
            if (i16 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                if (this.f34165a.q0(i3, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                    this.f34165a.t0();
                    this.f34165a.postInvalidate();
                    invalidateVirtualView(i3);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> L = this.f34165a.L();
            float floatValue = L.get(i3).floatValue();
            float H = this.f34165a.H();
            float K = this.f34165a.K();
            if (this.f34165a.isEnabled()) {
                if (floatValue > H) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < K) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, H, K, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb5 = new StringBuilder();
            if (this.f34165a.getContentDescription() != null) {
                sb5.append(this.f34165a.getContentDescription());
                sb5.append(",");
            }
            if (L.size() > 1) {
                sb5.append(a(i3));
                sb5.append(this.f34165a.A(floatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb5.toString());
            this.f34165a.s0(i3, this.f34166b);
            accessibilityNodeInfoCompat.setBoundsInParent(this.f34166b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface e {
        l1.a a();
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A(float f16) {
        String str;
        if (!M()) {
            if (((int) f16) == f16) {
                str = "%.0f";
            } else {
                str = "%.2f";
            }
            return String.format(str, Float.valueOf(f16));
        }
        throw null;
    }

    private void A0() {
        Iterator<Float> it = this.f34131g0.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() >= this.f34128e0 && next.floatValue() <= this.f34130f0) {
                if (this.f34136j0 > 0.0f && !B0(next.floatValue())) {
                    throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", next, Float.valueOf(this.f34128e0), Float.valueOf(this.f34136j0), Float.valueOf(this.f34136j0)));
                }
            } else {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", next, Float.valueOf(this.f34128e0), Float.valueOf(this.f34130f0)));
            }
        }
    }

    private float[] B() {
        float floatValue = ((Float) Collections.max(L())).floatValue();
        float floatValue2 = ((Float) Collections.min(L())).floatValue();
        if (this.f34131g0.size() == 1) {
            floatValue2 = this.f34128e0;
        }
        float Z = Z(floatValue2);
        float Z2 = Z(floatValue);
        if (R()) {
            return new float[]{Z2, Z};
        }
        return new float[]{Z, Z2};
    }

    private boolean B0(float f16) {
        return Q(f16 - this.f34128e0);
    }

    private float C0(float f16) {
        return (Z(f16) * this.f34140m0) + this.T;
    }

    private static float D(ValueAnimator valueAnimator, float f16) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
            return floatValue;
        }
        return f16;
    }

    private void D0() {
        float f16 = this.f34136j0;
        if (f16 == 0.0f) {
            return;
        }
        if (((int) f16) != f16) {
            Log.w(A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f16)));
        }
        float f17 = this.f34128e0;
        if (((int) f17) != f17) {
            Log.w(A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f17)));
        }
        float f18 = this.f34130f0;
        if (((int) f18) != f18) {
            Log.w(A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f18)));
        }
    }

    private float E(int i3, float f16) {
        float floatValue;
        float floatValue2;
        float G = G();
        if (this.f34153z0 == 0) {
            G = q(G);
        }
        if (R()) {
            G = -G;
        }
        int i16 = i3 + 1;
        if (i16 >= this.f34131g0.size()) {
            floatValue = this.f34130f0;
        } else {
            floatValue = this.f34131g0.get(i16).floatValue() - G;
        }
        int i17 = i3 - 1;
        if (i17 < 0) {
            floatValue2 = this.f34128e0;
        } else {
            floatValue2 = this.f34131g0.get(i17).floatValue() + G;
        }
        return MathUtils.clamp(f16, floatValue2, floatValue);
    }

    @ColorInt
    private int F(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float I() {
        double p06 = p0(this.f34152y0);
        if (R()) {
            p06 = 1.0d - p06;
        }
        float f16 = this.f34130f0;
        return (float) ((p06 * (f16 - r3)) + this.f34128e0);
    }

    private float J() {
        float f16 = this.f34152y0;
        if (R()) {
            f16 = 1.0f - f16;
        }
        float f17 = this.f34130f0;
        float f18 = this.f34128e0;
        return (f16 * (f17 - f18)) + f18;
    }

    private Drawable N(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        h(newDrawable);
        return newDrawable;
    }

    private void O() {
        this.f34125d.setStrokeWidth(this.S);
        this.f34127e.setStrokeWidth(this.S);
        this.f34134i.setStrokeWidth(this.S / 2.0f);
        this.f34139m.setStrokeWidth(this.S / 2.0f);
    }

    private boolean P() {
        ViewParent parent = getParent();
        while (true) {
            boolean z16 = false;
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) {
                z16 = true;
            }
            if (z16 && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private boolean Q(float f16) {
        if (Math.abs(Math.round(r0) - new BigDecimal(Float.toString(f16)).divide(new BigDecimal(Float.toString(this.f34136j0)), MathContext.DECIMAL64).doubleValue()) < 1.0E-4d) {
            return true;
        }
        return false;
    }

    private void S(@NonNull Resources resources) {
        this.Q = resources.getDimensionPixelSize(R.dimen.cvq);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.cvo);
        this.N = dimensionPixelOffset;
        this.T = dimensionPixelOffset;
        this.P = resources.getDimensionPixelSize(R.dimen.cvm);
        this.U = resources.getDimensionPixelOffset(R.dimen.cvp);
        this.f34122a0 = resources.getDimensionPixelSize(R.dimen.cvi);
    }

    private void T() {
        if (this.f34136j0 <= 0.0f) {
            return;
        }
        v0();
        int min = Math.min((int) (((this.f34130f0 - this.f34128e0) / this.f34136j0) + 1.0f), (this.f34140m0 / (this.S * 2)) + 1);
        float[] fArr = this.f34137k0;
        if (fArr == null || fArr.length != min * 2) {
            this.f34137k0 = new float[min * 2];
        }
        float f16 = this.f34140m0 / (min - 1);
        for (int i3 = 0; i3 < min * 2; i3 += 2) {
            float[] fArr2 = this.f34137k0;
            fArr2[i3] = this.T + ((i3 / 2) * f16);
            fArr2[i3 + 1] = m();
        }
    }

    private void U(@NonNull Canvas canvas, int i3, int i16) {
        if (n0()) {
            int Z = (int) (this.T + (Z(this.f34131g0.get(this.f34135i0).floatValue()) * i3));
            if (Build.VERSION.SDK_INT < 28) {
                int i17 = this.W;
                canvas.clipRect(Z - i17, i16 - i17, Z + i17, i17 + i16, Region.Op.UNION);
            }
            canvas.drawCircle(Z, i16, this.W, this.f34132h);
        }
    }

    private void V(@NonNull Canvas canvas) {
        if (this.f34138l0 && this.f34136j0 > 0.0f) {
            float[] B = B();
            int f06 = f0(this.f34137k0, B[0]);
            int f07 = f0(this.f34137k0, B[1]);
            int i3 = f06 * 2;
            canvas.drawPoints(this.f34137k0, 0, i3, this.f34134i);
            int i16 = f07 * 2;
            canvas.drawPoints(this.f34137k0, i3, i16 - i3, this.f34139m);
            float[] fArr = this.f34137k0;
            canvas.drawPoints(fArr, i16, fArr.length - i16, this.f34134i);
        }
    }

    private void W() {
        this.T = this.N + Math.max(this.V - this.P, 0);
        if (ViewCompat.isLaidOut(this)) {
            u0(getWidth());
        }
    }

    private boolean X(int i3) {
        int i16 = this.f34135i0;
        int clamp = (int) MathUtils.clamp(i16 + i3, 0L, this.f34131g0.size() - 1);
        this.f34135i0 = clamp;
        if (clamp == i16) {
            return false;
        }
        if (this.f34133h0 != -1) {
            this.f34133h0 = clamp;
        }
        t0();
        postInvalidate();
        return true;
    }

    private boolean Y(int i3) {
        if (R()) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = Integer.MAX_VALUE;
            } else {
                i3 = -i3;
            }
        }
        return X(i3);
    }

    private float Z(float f16) {
        float f17 = this.f34128e0;
        float f18 = (f16 - f17) / (this.f34130f0 - f17);
        if (R()) {
            return 1.0f - f18;
        }
        return f18;
    }

    private Boolean a0(int i3, @NonNull KeyEvent keyEvent) {
        if (i3 != 61) {
            if (i3 != 66) {
                if (i3 != 81) {
                    if (i3 != 69) {
                        if (i3 != 70) {
                            switch (i3) {
                                case 21:
                                    Y(-1);
                                    return Boolean.TRUE;
                                case 22:
                                    Y(1);
                                    return Boolean.TRUE;
                                case 23:
                                    break;
                                default:
                                    return null;
                            }
                        }
                    } else {
                        X(-1);
                        return Boolean.TRUE;
                    }
                }
                X(1);
                return Boolean.TRUE;
            }
            this.f34133h0 = this.f34135i0;
            postInvalidate();
            return Boolean.TRUE;
        }
        if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(X(1));
        }
        if (keyEvent.isShiftPressed()) {
            return Boolean.valueOf(X(-1));
        }
        return Boolean.FALSE;
    }

    private void b0() {
        Iterator<T> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void c0() {
        Iterator<T> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static l1.a d0(@NonNull Context context, @NonNull TypedArray typedArray) {
        return l1.a.r0(context, null, 0, typedArray.getResourceId(w0.a.N7, R.style.at9));
    }

    private static int f0(float[] fArr, float f16) {
        return Math.round(f16 * ((fArr.length / 2) - 1));
    }

    private void g0(Context context, AttributeSet attributeSet, int i3) {
        int i16;
        int i17;
        TypedArray h16 = o.h(context, attributeSet, w0.a.F7, i3, B0, new int[0]);
        this.f34128e0 = h16.getFloat(w0.a.I7, 0.0f);
        this.f34130f0 = h16.getFloat(w0.a.J7, 1.0f);
        setValues(Float.valueOf(this.f34128e0));
        this.f34136j0 = h16.getFloat(w0.a.H7, 0.0f);
        int i18 = w0.a.X7;
        boolean hasValue = h16.hasValue(i18);
        if (hasValue) {
            i16 = i18;
        } else {
            i16 = w0.a.Z7;
        }
        if (!hasValue) {
            i18 = w0.a.Y7;
        }
        ColorStateList a16 = g1.c.a(context, h16, i16);
        if (a16 == null) {
            a16 = AppCompatResources.getColorStateList(context, R.color.c4l);
        }
        setTrackInactiveTintList(a16);
        ColorStateList a17 = g1.c.a(context, h16, i18);
        if (a17 == null) {
            a17 = AppCompatResources.getColorStateList(context, R.color.c4i);
        }
        setTrackActiveTintList(a17);
        this.f34149v0.Y(g1.c.a(context, h16, w0.a.O7));
        int i19 = w0.a.R7;
        if (h16.hasValue(i19)) {
            setThumbStrokeColor(g1.c.a(context, h16, i19));
        }
        setThumbStrokeWidth(h16.getDimension(w0.a.S7, 0.0f));
        ColorStateList a18 = g1.c.a(context, h16, w0.a.K7);
        if (a18 == null) {
            a18 = AppCompatResources.getColorStateList(context, R.color.c4j);
        }
        setHaloTintList(a18);
        this.f34138l0 = h16.getBoolean(w0.a.W7, true);
        int i26 = w0.a.T7;
        boolean hasValue2 = h16.hasValue(i26);
        if (hasValue2) {
            i17 = i26;
        } else {
            i17 = w0.a.V7;
        }
        if (!hasValue2) {
            i26 = w0.a.U7;
        }
        ColorStateList a19 = g1.c.a(context, h16, i17);
        if (a19 == null) {
            a19 = AppCompatResources.getColorStateList(context, R.color.c4k);
        }
        setTickInactiveTintList(a19);
        ColorStateList a26 = g1.c.a(context, h16, i26);
        if (a26 == null) {
            a26 = AppCompatResources.getColorStateList(context, R.color.c4h);
        }
        setTickActiveTintList(a26);
        setThumbRadius(h16.getDimensionPixelSize(w0.a.Q7, 0));
        setHaloRadius(h16.getDimensionPixelSize(w0.a.L7, 0));
        setThumbElevation(h16.getDimension(w0.a.P7, 0.0f));
        setTrackHeight(h16.getDimensionPixelSize(w0.a.f443817a8, 0));
        setLabelBehavior(h16.getInt(w0.a.M7, 0));
        if (!h16.getBoolean(w0.a.G7, true)) {
            setEnabled(false);
        }
        h16.recycle();
    }

    private void h(Drawable drawable) {
        int i3 = this.V * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i3, i3);
        } else {
            float max = i3 / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
        }
    }

    private void h0(int i3) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.E;
        if (accessibilityEventSender == null) {
            this.E = new AccessibilityEventSender(this, null);
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.E.a(i3);
        postDelayed(this.E, 200L);
    }

    private void i(l1.a aVar) {
        aVar.x0(ViewUtils.e(this));
    }

    private Float j(int i3) {
        float k3;
        if (this.f34142o0) {
            k3 = l(20);
        } else {
            k3 = k();
        }
        if (i3 != 21) {
            if (i3 != 22) {
                if (i3 != 69) {
                    if (i3 != 70 && i3 != 81) {
                        return null;
                    }
                    return Float.valueOf(k3);
                }
                return Float.valueOf(-k3);
            }
            if (R()) {
                k3 = -k3;
            }
            return Float.valueOf(k3);
        }
        if (!R()) {
            k3 = -k3;
        }
        return Float.valueOf(k3);
    }

    private float k() {
        float f16 = this.f34136j0;
        if (f16 == 0.0f) {
            return 1.0f;
        }
        return f16;
    }

    private void k0(l1.a aVar, float f16) {
        aVar.z0(A(f16));
        int Z = (this.T + ((int) (Z(f16) * this.f34140m0))) - (aVar.getIntrinsicWidth() / 2);
        int m3 = m() - (this.f34122a0 + this.V);
        aVar.setBounds(Z, m3 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + Z, m3);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.d.c(ViewUtils.e(this), this, rect);
        aVar.setBounds(rect);
        ViewUtils.f(this).add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float l(int i3) {
        float k3 = k();
        if ((this.f34130f0 - this.f34128e0) / k3 <= i3) {
            return k3;
        }
        return Math.round(r1 / r4) * k3;
    }

    private void l0(@NonNull ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.f34131g0.size() == arrayList.size() && this.f34131g0.equals(arrayList)) {
                return;
            }
            this.f34131g0 = arrayList;
            this.f34143p0 = true;
            this.f34135i0 = 0;
            t0();
            o();
            s();
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private int m() {
        int i3 = this.U;
        int i16 = 0;
        if (this.R == 1 || m0()) {
            i16 = this.G.get(0).getIntrinsicHeight();
        }
        return i3 + i16;
    }

    private boolean m0() {
        if (this.R == 3) {
            return true;
        }
        return false;
    }

    private ValueAnimator n(boolean z16) {
        float f16;
        ValueAnimator valueAnimator;
        long j3;
        TimeInterpolator timeInterpolator;
        float f17 = 0.0f;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        if (z16) {
            valueAnimator = this.L;
        } else {
            valueAnimator = this.K;
        }
        float D = D(valueAnimator, f16);
        if (z16) {
            f17 = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(D, f17);
        if (z16) {
            j3 = 83;
        } else {
            j3 = 117;
        }
        ofFloat.setDuration(j3);
        if (z16) {
            timeInterpolator = x0.a.f446814e;
        } else {
            timeInterpolator = x0.a.f446812c;
        }
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private boolean n0() {
        if (!this.f34141n0 && (getBackground() instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    private void o() {
        if (this.G.size() > this.f34131g0.size()) {
            List<l1.a> subList = this.G.subList(this.f34131g0.size(), this.G.size());
            for (l1.a aVar : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    p(aVar);
                }
            }
            subList.clear();
        }
        while (this.G.size() < this.f34131g0.size()) {
            l1.a a16 = this.F.a();
            this.G.add(a16);
            if (ViewCompat.isAttachedToWindow(this)) {
                i(a16);
            }
        }
        int i3 = 1;
        if (this.G.size() == 1) {
            i3 = 0;
        }
        Iterator<l1.a> it = this.G.iterator();
        while (it.hasNext()) {
            it.next().j0(i3);
        }
    }

    private boolean o0(float f16) {
        return q0(this.f34133h0, f16);
    }

    private void p(l1.a aVar) {
        r f16 = ViewUtils.f(this);
        if (f16 != null) {
            f16.remove(aVar);
            aVar.t0(ViewUtils.e(this));
        }
    }

    private double p0(float f16) {
        float f17 = this.f34136j0;
        if (f17 > 0.0f) {
            return Math.round(f16 * r0) / ((int) ((this.f34130f0 - this.f34128e0) / f17));
        }
        return f16;
    }

    private float q(float f16) {
        if (f16 == 0.0f) {
            return 0.0f;
        }
        float f17 = (f16 - this.T) / this.f34140m0;
        float f18 = this.f34128e0;
        return (f17 * (f18 - this.f34130f0)) + f18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q0(int i3, float f16) {
        this.f34135i0 = i3;
        if (Math.abs(f16 - this.f34131g0.get(i3).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.f34131g0.set(i3, Float.valueOf(E(i3, f16)));
        r(i3);
        return true;
    }

    private void r(int i3) {
        Iterator<L> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f34131g0.get(i3).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.D;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            h0(i3);
        }
    }

    private boolean r0() {
        return o0(I());
    }

    private void s() {
        for (L l3 : this.H) {
            Iterator<Float> it = this.f34131g0.iterator();
            while (it.hasNext()) {
                l3.a(this, it.next().floatValue(), false);
            }
        }
    }

    private void t(@NonNull Canvas canvas, int i3, int i16) {
        float[] B = B();
        int i17 = this.T;
        float f16 = i3;
        float f17 = i16;
        canvas.drawLine(i17 + (B[0] * f16), f17, i17 + (B[1] * f16), f17, this.f34127e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        if (!n0() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int Z = (int) ((Z(this.f34131g0.get(this.f34135i0).floatValue()) * this.f34140m0) + this.T);
                int m3 = m();
                int i3 = this.W;
                DrawableCompat.setHotspotBounds(background, Z - i3, m3 - i3, Z + i3, m3 + i3);
            }
        }
    }

    private void u(@NonNull Canvas canvas, int i3, int i16) {
        float[] B = B();
        float f16 = i3;
        float f17 = this.T + (B[1] * f16);
        if (f17 < r1 + i3) {
            float f18 = i16;
            canvas.drawLine(f17, f18, r1 + i3, f18, this.f34125d);
        }
        int i17 = this.T;
        float f19 = i17 + (B[0] * f16);
        if (f19 > i17) {
            float f26 = i16;
            canvas.drawLine(i17, f26, f19, f26, this.f34125d);
        }
    }

    private void u0(int i3) {
        this.f34140m0 = Math.max(i3 - (this.T * 2), 0);
        T();
    }

    private void v(@NonNull Canvas canvas, int i3, int i16, float f16, @NonNull Drawable drawable) {
        canvas.save();
        canvas.translate((this.T + ((int) (Z(f16) * i3))) - (drawable.getBounds().width() / 2.0f), i16 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void v0() {
        if (this.f34143p0) {
            y0();
            z0();
            x0();
            A0();
            w0();
            D0();
            this.f34143p0 = false;
        }
    }

    private void w(@NonNull Canvas canvas, int i3, int i16) {
        for (int i17 = 0; i17 < this.f34131g0.size(); i17++) {
            float floatValue = this.f34131g0.get(i17).floatValue();
            Drawable drawable = this.f34150w0;
            if (drawable != null) {
                v(canvas, i3, i16, floatValue, drawable);
            } else if (i17 < this.f34151x0.size()) {
                v(canvas, i3, i16, floatValue, this.f34151x0.get(i17));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.T + (Z(floatValue) * i3), i16, this.V, this.f34129f);
                }
                v(canvas, i3, i16, floatValue, this.f34149v0);
            }
        }
    }

    private void w0() {
        float G = G();
        if (G >= 0.0f) {
            float f16 = this.f34136j0;
            if (f16 > 0.0f && G > 0.0f) {
                if (this.f34153z0 == 1) {
                    if (G < f16 || !Q(G)) {
                        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(G), Float.valueOf(this.f34136j0), Float.valueOf(this.f34136j0)));
                    }
                    return;
                }
                throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(G), Float.valueOf(this.f34136j0)));
            }
            return;
        }
        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(G)));
    }

    private void x() {
        if (this.R == 2) {
            return;
        }
        if (!this.J) {
            this.J = true;
            ValueAnimator n3 = n(true);
            this.K = n3;
            this.L = null;
            n3.start();
        }
        Iterator<l1.a> it = this.G.iterator();
        for (int i3 = 0; i3 < this.f34131g0.size() && it.hasNext(); i3++) {
            if (i3 != this.f34135i0) {
                k0(it.next(), this.f34131g0.get(i3).floatValue());
            }
        }
        if (it.hasNext()) {
            k0(it.next(), this.f34131g0.get(this.f34135i0).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.G.size()), Integer.valueOf(this.f34131g0.size())));
    }

    private void x0() {
        if (this.f34136j0 > 0.0f && !B0(this.f34130f0)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.f34136j0), Float.valueOf(this.f34128e0), Float.valueOf(this.f34130f0)));
        }
    }

    private void y() {
        if (this.J) {
            this.J = false;
            ValueAnimator n3 = n(false);
            this.L = n3;
            this.K = null;
            n3.addListener(new c());
            this.L.start();
        }
    }

    private void y0() {
        if (this.f34128e0 < this.f34130f0) {
        } else {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.f34128e0), Float.valueOf(this.f34130f0)));
        }
    }

    private void z(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 17) {
                    if (i3 == 66) {
                        Y(Integer.MIN_VALUE);
                        return;
                    }
                    return;
                }
                Y(Integer.MAX_VALUE);
                return;
            }
            X(Integer.MIN_VALUE);
            return;
        }
        X(Integer.MAX_VALUE);
    }

    private void z0() {
        if (this.f34130f0 > this.f34128e0) {
        } else {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.f34130f0), Float.valueOf(this.f34128e0)));
        }
    }

    public int C() {
        return this.f34133h0;
    }

    protected float G() {
        return 0.0f;
    }

    public float H() {
        return this.f34128e0;
    }

    public float K() {
        return this.f34130f0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public List<Float> L() {
        return new ArrayList(this.f34131g0);
    }

    public boolean M() {
        return false;
    }

    final boolean R() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.C.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f34125d.setColor(F(this.f34148u0));
        this.f34127e.setColor(F(this.f34147t0));
        this.f34134i.setColor(F(this.f34146s0));
        this.f34139m.setColor(F(this.f34145r0));
        for (l1.a aVar : this.G) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.f34149v0.isStateful()) {
            this.f34149v0.setState(getDrawableState());
        }
        this.f34132h.setColor(F(this.f34144q0));
        this.f34132h.setAlpha(63);
    }

    protected boolean e0() {
        boolean z16;
        if (this.f34133h0 != -1) {
            return true;
        }
        float J = J();
        float C0 = C0(J);
        this.f34133h0 = 0;
        float abs = Math.abs(this.f34131g0.get(0).floatValue() - J);
        for (int i3 = 1; i3 < this.f34131g0.size(); i3++) {
            float abs2 = Math.abs(this.f34131g0.get(i3).floatValue() - J);
            float C02 = C0(this.f34131g0.get(i3).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            if (!R() ? C02 - C0 < 0.0f : C02 - C0 > 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (Float.compare(abs2, abs) < 0) {
                this.f34133h0 = i3;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (Math.abs(C02 - C0) < this.M) {
                        this.f34133h0 = -1;
                        return false;
                    }
                    if (z16) {
                        this.f34133h0 = i3;
                    }
                }
            }
            abs = abs2;
        }
        if (this.f34133h0 != -1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0(int i3) {
        this.f34133h0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0(int i3) {
        this.f34153z0 = i3;
        this.f34143p0 = true;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<l1.a> it = this.G.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.E;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.J = false;
        Iterator<l1.a> it = this.G.iterator();
        while (it.hasNext()) {
            p(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        if (this.f34143p0) {
            v0();
            T();
        }
        super.onDraw(canvas);
        int m3 = m();
        u(canvas, this.f34140m0, m3);
        if (((Float) Collections.max(L())).floatValue() > this.f34128e0) {
            t(canvas, this.f34140m0, m3);
        }
        V(canvas);
        if ((this.f34126d0 || isFocused() || m0()) && isEnabled()) {
            U(canvas, this.f34140m0, m3);
            if (this.f34133h0 == -1 && !m0()) {
                y();
            } else {
                x();
            }
        } else {
            y();
        }
        w(canvas, this.f34140m0, m3);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z16, int i3, @Nullable Rect rect) {
        super.onFocusChanged(z16, i3, rect);
        if (!z16) {
            this.f34133h0 = -1;
            this.C.clearKeyboardFocusForVirtualView(this.f34135i0);
        } else {
            z(i3);
            this.C.requestKeyboardFocusForVirtualView(this.f34135i0);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i3, keyEvent);
        }
        if (this.f34131g0.size() == 1) {
            this.f34133h0 = 0;
        }
        if (this.f34133h0 == -1) {
            Boolean a06 = a0(i3, keyEvent);
            if (a06 != null) {
                return a06.booleanValue();
            }
            return super.onKeyDown(i3, keyEvent);
        }
        this.f34142o0 |= keyEvent.isLongPress();
        Float j3 = j(i3);
        if (j3 != null) {
            if (o0(this.f34131g0.get(this.f34133h0).floatValue() + j3.floatValue())) {
                t0();
                postInvalidate();
            }
            return true;
        }
        if (i3 != 23) {
            if (i3 != 61) {
                if (i3 != 66) {
                    return super.onKeyDown(i3, keyEvent);
                }
            } else {
                if (keyEvent.hasNoModifiers()) {
                    return X(1);
                }
                if (!keyEvent.isShiftPressed()) {
                    return false;
                }
                return X(-1);
            }
        }
        this.f34133h0 = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, @NonNull KeyEvent keyEvent) {
        this.f34142o0 = false;
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17 = this.Q;
        int i18 = 0;
        if (this.R == 1 || m0()) {
            i18 = this.G.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(i17 + i18, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.f34128e0 = sliderState.f34155d;
        this.f34130f0 = sliderState.f34156e;
        l0(sliderState.f34157f);
        this.f34136j0 = sliderState.f34158h;
        if (sliderState.f34159i) {
            requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f34155d = this.f34128e0;
        sliderState.f34156e = this.f34130f0;
        sliderState.f34157f = new ArrayList<>(this.f34131g0);
        sliderState.f34158h = this.f34136j0;
        sliderState.f34159i = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        u0(i3);
        t0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x16 = motionEvent.getX();
        float f16 = (x16 - this.T) / this.f34140m0;
        this.f34152y0 = f16;
        float max = Math.max(0.0f, f16);
        this.f34152y0 = max;
        this.f34152y0 = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.f34126d0) {
                        if (P() && Math.abs(x16 - this.f34123b0) < this.M) {
                            return false;
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                        b0();
                    }
                    if (e0()) {
                        this.f34126d0 = true;
                        r0();
                        t0();
                        invalidate();
                    }
                }
            } else {
                this.f34126d0 = false;
                MotionEvent motionEvent2 = this.f34124c0;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.f34124c0.getX() - motionEvent.getX()) <= this.M && Math.abs(this.f34124c0.getY() - motionEvent.getY()) <= this.M && e0()) {
                    b0();
                }
                if (this.f34133h0 != -1) {
                    r0();
                    this.f34133h0 = -1;
                    c0();
                }
                invalidate();
            }
        } else {
            this.f34123b0 = x16;
            if (!P()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (e0()) {
                    requestFocus();
                    this.f34126d0 = true;
                    r0();
                    t0();
                    invalidate();
                    b0();
                }
            }
        }
        setPressed(this.f34126d0);
        this.f34124c0 = MotionEvent.obtain(motionEvent);
        return true;
    }

    void s0(int i3, Rect rect) {
        int Z = this.T + ((int) (Z(L().get(i3).floatValue()) * this.f34140m0));
        int m3 = m();
        int i16 = this.V;
        rect.set(Z - i16, m3 - i16, Z + i16, m3 + i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawable(@DrawableRes int i3) {
        setCustomThumbDrawable(getResources().getDrawable(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            drawableArr[i3] = getResources().getDrawable(iArr[i3]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        int i3;
        super.setEnabled(z16);
        if (z16) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        setLayerType(i3, null);
    }

    public void setFocusedThumbIndex(int i3) {
        if (i3 >= 0 && i3 < this.f34131g0.size()) {
            this.f34135i0 = i3;
            this.C.requestKeyboardFocusForVirtualView(i3);
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i3) {
        if (i3 == this.W) {
            return;
        }
        this.W = i3;
        Drawable background = getBackground();
        if (!n0() && (background instanceof RippleDrawable)) {
            b1.a.b((RippleDrawable) background, this.W);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(@DimenRes int i3) {
        setHaloRadius(getResources().getDimensionPixelSize(i3));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f34144q0)) {
            return;
        }
        this.f34144q0 = colorStateList;
        Drawable background = getBackground();
        if (!n0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f34132h.setColor(F(colorStateList));
        this.f34132h.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i3) {
        if (this.R != i3) {
            this.R = i3;
            requestLayout();
        }
    }

    public void setStepSize(float f16) {
        if (f16 >= 0.0f) {
            if (this.f34136j0 != f16) {
                this.f34136j0 = f16;
                this.f34143p0 = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f16), Float.valueOf(this.f34128e0), Float.valueOf(this.f34130f0)));
    }

    public void setThumbElevation(float f16) {
        this.f34149v0.X(f16);
    }

    public void setThumbElevationResource(@DimenRes int i3) {
        setThumbElevation(getResources().getDimension(i3));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i3) {
        if (i3 == this.V) {
            return;
        }
        this.V = i3;
        W();
        this.f34149v0.setShapeAppearanceModel(g.a().q(0, this.V).m());
        MaterialShapeDrawable materialShapeDrawable = this.f34149v0;
        int i16 = this.V;
        materialShapeDrawable.setBounds(0, 0, i16 * 2, i16 * 2);
        Drawable drawable = this.f34150w0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator<Drawable> it = this.f34151x0.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i3) {
        setThumbRadius(getResources().getDimensionPixelSize(i3));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f34149v0.i0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i3) {
        if (i3 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i3));
        }
    }

    public void setThumbStrokeWidth(float f16) {
        this.f34149v0.j0(f16);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i3) {
        if (i3 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i3));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f34149v0.x())) {
            return;
        }
        this.f34149v0.Y(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f34145r0)) {
            return;
        }
        this.f34145r0 = colorStateList;
        this.f34139m.setColor(F(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f34146s0)) {
            return;
        }
        this.f34146s0 = colorStateList;
        this.f34134i.setColor(F(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z16) {
        if (this.f34138l0 != z16) {
            this.f34138l0 = z16;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f34147t0)) {
            return;
        }
        this.f34147t0 = colorStateList;
        this.f34127e.setColor(F(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i3) {
        if (this.S != i3) {
            this.S = i3;
            O();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f34148u0)) {
            return;
        }
        this.f34148u0 = colorStateList;
        this.f34125d.setColor(F(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f16) {
        this.f34128e0 = f16;
        this.f34143p0 = true;
        postInvalidate();
    }

    public void setValueTo(float f16) {
        this.f34130f0 = f16;
        this.f34143p0 = true;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        l0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class AccessibilityEventSender implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f34154d;

        AccessibilityEventSender() {
            this.f34154d = -1;
        }

        void a(int i3) {
            this.f34154d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.C.sendEventForVirtualView(this.f34154d, 4);
        }

        /* synthetic */ AccessibilityEventSender(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f156224ba0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        this.f34150w0 = N(drawable);
        this.f34151x0.clear();
        postInvalidate();
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, B0), attributeSet, i3);
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.J = false;
        this.f34126d0 = false;
        this.f34131g0 = new ArrayList<>();
        this.f34133h0 = -1;
        this.f34135i0 = -1;
        this.f34136j0 = 0.0f;
        this.f34138l0 = true;
        this.f34142o0 = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f34149v0 = materialShapeDrawable;
        this.f34151x0 = Collections.emptyList();
        this.f34153z0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f34125d = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f34127e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.f34129f = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f34132h = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f34134i = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f34139m = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        S(context2.getResources());
        this.F = new a(attributeSet, i3);
        g0(context2, attributeSet, i3);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.f0(2);
        this.M = ViewConfiguration.get(context2).getScaledTouchSlop();
        d dVar = new d(this);
        this.C = dVar;
        ViewCompat.setAccessibilityDelegate(this, dVar);
        this.D = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(@NonNull List<Float> list) {
        l0(new ArrayList<>(list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.f34150w0 = null;
        this.f34151x0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.f34151x0.add(N(drawable));
        }
        postInvalidate();
    }

    public void setLabelFormatter(@Nullable com.google.android.material.slider.c cVar) {
    }
}
