package com.tencent.mobileqq.icgame.base.room.multipage.controller;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes15.dex */
public class VerticalViewPager extends ViewGroup {
    private static boolean E0 = true;
    private Handler A0;
    private final Runnable B0;
    private int C;
    private int C0;
    private int D;
    private Parcelable E;
    private ClassLoader F;
    private Scroller G;
    private e H;
    private int I;
    private Drawable J;
    private int K;
    private int L;
    private float M;
    private float N;
    private int P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private int f237177a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f237178b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f237179c0;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f237180d;

    /* renamed from: d0, reason: collision with root package name */
    private float f237181d0;

    /* renamed from: e, reason: collision with root package name */
    private int f237182e;

    /* renamed from: e0, reason: collision with root package name */
    private float f237183e0;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<c> f237184f;

    /* renamed from: f0, reason: collision with root package name */
    private float f237185f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f237186g0;

    /* renamed from: h, reason: collision with root package name */
    private final c f237187h;

    /* renamed from: h0, reason: collision with root package name */
    private int f237188h0;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f237189i;

    /* renamed from: i0, reason: collision with root package name */
    private VelocityTracker f237190i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f237191j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f237192k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f237193l0;

    /* renamed from: m, reason: collision with root package name */
    private PagerAdapter f237194m;

    /* renamed from: m0, reason: collision with root package name */
    private int f237195m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f237196n0;

    /* renamed from: o0, reason: collision with root package name */
    private EdgeEffectCompat f237197o0;

    /* renamed from: p0, reason: collision with root package name */
    private EdgeEffectCompat f237198p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f237199q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f237200r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f237201s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f237202t0;

    /* renamed from: u0, reason: collision with root package name */
    private com.tencent.mobileqq.icgame.base.room.multipage.controller.a f237203u0;

    /* renamed from: v0, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f237204v0;

    /* renamed from: w0, reason: collision with root package name */
    private ViewPager.PageTransformer f237205w0;

    /* renamed from: x0, reason: collision with root package name */
    private Method f237206x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f237207y0;

    /* renamed from: z0, reason: collision with root package name */
    private ArrayList<View> f237208z0;
    private static final int[] D0 = {R.attr.layout_gravity};
    private static final Comparator<c> F0 = new a();
    private static final Interpolator G0 = new b();
    private static final f H0 = new f();

    /* loaded from: classes15.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new a());

        /* renamed from: d, reason: collision with root package name */
        int f237216d;

        /* renamed from: e, reason: collision with root package name */
        Parcelable f237217e;

        /* renamed from: f, reason: collision with root package name */
        ClassLoader f237218f;

        /* loaded from: classes15.dex */
        class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            a() {
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f237216d + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f237216d);
            parcel.writeParcelable(this.f237217e, i3);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f237216d = parcel.readInt();
            this.f237217e = parcel.readParcelable(classLoader);
            this.f237218f = classLoader;
        }
    }

    /* loaded from: classes15.dex */
    class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            return cVar.f237220b - cVar2.f237220b;
        }
    }

    /* loaded from: classes15.dex */
    class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        Object f237219a;

        /* renamed from: b, reason: collision with root package name */
        int f237220b;

        /* renamed from: c, reason: collision with root package name */
        boolean f237221c;

        /* renamed from: d, reason: collision with root package name */
        float f237222d;

        /* renamed from: e, reason: collision with root package name */
        float f237223e;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class d extends AccessibilityDelegateCompat {
        d() {
        }

        private boolean canScroll() {
            if (VerticalViewPager.this.f237194m != null && VerticalViewPager.this.f237194m.getF373114d() > 1) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        @SuppressLint({"WrongConstant"})
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && VerticalViewPager.this.f237194m != null) {
                obtain.setItemCount(VerticalViewPager.this.f237194m.getF373114d());
                obtain.setFromIndex(VerticalViewPager.this.C);
                obtain.setToIndex(VerticalViewPager.this.C);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (VerticalViewPager.this.A(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (VerticalViewPager.this.A(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (super.performAccessibilityAction(view, i3, bundle)) {
                return true;
            }
            if (i3 != 4096) {
                if (i3 != 8192 || !VerticalViewPager.this.A(-1)) {
                    return false;
                }
                VerticalViewPager verticalViewPager = VerticalViewPager.this;
                verticalViewPager.setCurrentItem(verticalViewPager.C - 1);
                return true;
            }
            if (!VerticalViewPager.this.A(1)) {
                return false;
            }
            VerticalViewPager verticalViewPager2 = VerticalViewPager.this;
            verticalViewPager2.setCurrentItem(verticalViewPager2.C + 1);
            return true;
        }
    }

    /* loaded from: classes15.dex */
    private class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            VerticalViewPager.this.k();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            VerticalViewPager.this.k();
        }

        /* synthetic */ e(VerticalViewPager verticalViewPager, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class f implements Comparator<View> {
        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z16 = layoutParams.f237210a;
            if (z16 != layoutParams2.f237210a) {
                if (z16) {
                    return 1;
                }
                return -1;
            }
            return layoutParams.f237214e - layoutParams2.f237214e;
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        this.f237180d = false;
        this.f237184f = new ArrayList<>();
        this.f237187h = new c();
        this.f237189i = new Rect();
        this.D = -1;
        this.E = null;
        this.F = null;
        this.M = -3.4028235E38f;
        this.N = Float.MAX_VALUE;
        this.U = 1;
        this.f237188h0 = -1;
        this.f237199q0 = true;
        this.f237200r0 = false;
        this.A0 = new Handler(Looper.getMainLooper());
        this.B0 = new Runnable() { // from class: com.tencent.mobileqq.icgame.base.room.multipage.controller.VerticalViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                VerticalViewPager.this.R(0);
                VerticalViewPager.this.I();
            }
        };
        this.C0 = 0;
        z();
    }

    private boolean B(float f16, float f17) {
        if ((f16 < this.f237178b0 && f17 > 0.0f) || (f16 > getHeight() - this.f237178b0 && f17 < 0.0f)) {
            return true;
        }
        return false;
    }

    private void D(MotionEvent motionEvent) {
        int i3;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f237188h0) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.f237183e0 = MotionEventCompat.getY(motionEvent, i3);
            this.f237188h0 = MotionEventCompat.getPointerId(motionEvent, i3);
            VelocityTracker velocityTracker = this.f237190i0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean F(int i3) {
        if (this.f237184f.size() == 0) {
            this.f237201s0 = false;
            C(0, 0.0f, 0);
            if (this.f237201s0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        c x16 = x();
        int s16 = s();
        int i16 = this.I;
        int i17 = s16 + i16;
        float f16 = s16;
        int i18 = x16.f237220b;
        float f17 = ((i3 / f16) - x16.f237223e) / (x16.f237222d + (i16 / f16));
        this.f237201s0 = false;
        C(i18, f17, (int) (i17 * f17));
        if (this.f237201s0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean H(float f16) {
        boolean z16;
        float f17 = this.f237183e0 - f16;
        this.f237183e0 = f16;
        float scrollY = getScrollY() + f17;
        float s16 = s();
        float f18 = this.M * s16;
        float f19 = this.N * s16;
        boolean z17 = false;
        c cVar = this.f237184f.get(0);
        ArrayList<c> arrayList = this.f237184f;
        boolean z18 = true;
        c cVar2 = arrayList.get(arrayList.size() - 1);
        if (cVar.f237220b != 0) {
            f18 = cVar.f237223e * s16;
            z16 = false;
        } else {
            z16 = true;
        }
        if (cVar2.f237220b != this.f237194m.getF373114d() - 1) {
            f19 = cVar2.f237223e * s16;
            z18 = false;
        }
        if (scrollY < f18) {
            if (z16) {
                z17 = this.f237197o0.onPull(Math.abs(f18 - scrollY) / s16);
            }
            scrollY = f18;
        } else if (scrollY > f19) {
            if (z18) {
                z17 = this.f237198p0.onPull(Math.abs(scrollY - f19) / s16);
            }
            scrollY = f19;
        }
        int i3 = (int) scrollY;
        this.f237181d0 += scrollY - i3;
        scrollTo(getScrollX(), i3);
        F(i3);
        return z17;
    }

    private void K(int i3, int i16, int i17, int i18) {
        float f16;
        if (i16 > 0 && !this.f237184f.isEmpty()) {
            int scrollY = (int) ((getScrollY() / (((i16 - getPaddingTop()) - getPaddingBottom()) + i18)) * (((i3 - getPaddingTop()) - getPaddingBottom()) + i17));
            scrollTo(getScrollX(), scrollY);
            if (!this.G.isFinished()) {
                this.G.startScroll(0, scrollY, 0, (int) (y(this.C).f237223e * i3), this.G.getDuration() - this.G.timePassed());
                return;
            }
            return;
        }
        c y16 = y(this.C);
        if (y16 != null) {
            f16 = Math.min(y16.f237223e, this.N);
        } else {
            f16 = 0.0f;
        }
        int paddingTop = (int) (f16 * ((i3 - getPaddingTop()) - getPaddingBottom()));
        if (paddingTop != getScrollY()) {
            j(false);
            scrollTo(getScrollX(), paddingTop);
        }
    }

    private void L() {
        int i3 = 0;
        while (i3 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i3).getLayoutParams()).f237210a) {
                removeViewAt(i3);
                i3--;
            }
            i3++;
        }
    }

    private void M(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void N(int i3, boolean z16, int i16, boolean z17) {
        int i17;
        ViewPager.OnPageChangeListener onPageChangeListener;
        com.tencent.mobileqq.icgame.base.room.multipage.controller.a aVar;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        c y16 = y(i3);
        if (y16 != null) {
            i17 = (int) (s() * Math.max(this.M, Math.min(y16.f237223e, this.N)));
        } else {
            i17 = 0;
        }
        if (z16) {
            T(0, i17, i16);
            com.tencent.mobileqq.icgame.base.room.multipage.controller.a aVar2 = this.f237203u0;
            if (aVar2 != null) {
                if (z17) {
                    aVar2.onPageSelected(i3);
                } else if (i3 == 0) {
                    aVar2.t1();
                } else if (i3 == this.f237194m.getF373114d() - 1) {
                    this.f237203u0.y0();
                }
            }
            if (z17 && (onPageChangeListener2 = this.f237204v0) != null) {
                onPageChangeListener2.onPageSelected(i3);
                return;
            }
            return;
        }
        if (z17 && (aVar = this.f237203u0) != null) {
            aVar.onPageSelected(i3);
        }
        if (z17 && (onPageChangeListener = this.f237204v0) != null) {
            onPageChangeListener.onPageSelected(i3);
        }
        j(false);
        scrollTo(0, i17);
        F(i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i3) {
        boolean z16;
        if (this.C0 == i3) {
            return;
        }
        this.C0 = i3;
        if (this.f237205w0 != null) {
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            n(z16);
        }
        com.tencent.mobileqq.icgame.base.room.multipage.controller.a aVar = this.f237203u0;
        if (aVar != null) {
            aVar.onPageScrollStateChanged(i3);
        }
    }

    private void S(boolean z16) {
        if (this.S != z16) {
            this.S = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.f237207y0 != 0) {
            ArrayList<View> arrayList = this.f237208z0;
            if (arrayList == null) {
                this.f237208z0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.f237208z0.add(getChildAt(i3));
            }
            Collections.sort(this.f237208z0, H0);
        }
    }

    private void h(c cVar, int i3, c cVar2) {
        float f16;
        float f17;
        float f18;
        int i16;
        int i17;
        c cVar3;
        c cVar4;
        int f373114d = this.f237194m.getF373114d();
        int s16 = s();
        if (s16 > 0) {
            f16 = this.I / s16;
        } else {
            f16 = 0.0f;
        }
        if (cVar2 != null) {
            int i18 = cVar2.f237220b;
            int i19 = cVar.f237220b;
            if (i18 < i19) {
                float f19 = cVar2.f237223e + cVar2.f237222d + f16;
                int i26 = i18 + 1;
                int i27 = 0;
                while (i26 <= cVar.f237220b && i27 < this.f237184f.size()) {
                    c cVar5 = this.f237184f.get(i27);
                    while (true) {
                        cVar4 = cVar5;
                        if (i26 <= cVar4.f237220b || i27 >= this.f237184f.size() - 1) {
                            break;
                        }
                        i27++;
                        cVar5 = this.f237184f.get(i27);
                    }
                    while (i26 < cVar4.f237220b) {
                        f19 += this.f237194m.getPageWidth(i26) + f16;
                        i26++;
                    }
                    cVar4.f237223e = f19;
                    f19 += cVar4.f237222d + f16;
                    i26++;
                }
            } else if (i18 > i19) {
                int size = this.f237184f.size() - 1;
                float f26 = cVar2.f237223e;
                while (true) {
                    i18--;
                    if (i18 < cVar.f237220b || size < 0) {
                        break;
                    }
                    c cVar6 = this.f237184f.get(size);
                    while (true) {
                        cVar3 = cVar6;
                        if (i18 >= cVar3.f237220b || size <= 0) {
                            break;
                        }
                        size--;
                        cVar6 = this.f237184f.get(size);
                    }
                    while (i18 > cVar3.f237220b) {
                        f26 -= this.f237194m.getPageWidth(i18) + f16;
                        i18--;
                    }
                    f26 -= cVar3.f237222d + f16;
                    cVar3.f237223e = f26;
                }
            }
        }
        int size2 = this.f237184f.size();
        float f27 = cVar.f237223e;
        int i28 = cVar.f237220b;
        int i29 = i28 - 1;
        if (i28 == 0) {
            f17 = f27;
        } else {
            f17 = -3.4028235E38f;
        }
        this.M = f17;
        int i36 = f373114d - 1;
        if (i28 == i36) {
            f18 = (cVar.f237222d + f27) - 1.0f;
        } else {
            f18 = Float.MAX_VALUE;
        }
        this.N = f18;
        int i37 = i3 - 1;
        while (i37 >= 0) {
            c cVar7 = this.f237184f.get(i37);
            while (true) {
                i17 = cVar7.f237220b;
                if (i29 <= i17) {
                    break;
                }
                f27 -= this.f237194m.getPageWidth(i29) + f16;
                i29--;
            }
            f27 -= cVar7.f237222d + f16;
            cVar7.f237223e = f27;
            if (i17 == 0) {
                this.M = f27;
            }
            i37--;
            i29--;
        }
        float f28 = cVar.f237223e + cVar.f237222d + f16;
        int i38 = cVar.f237220b + 1;
        int i39 = i3 + 1;
        while (i39 < size2) {
            c cVar8 = this.f237184f.get(i39);
            while (true) {
                i16 = cVar8.f237220b;
                if (i38 >= i16) {
                    break;
                }
                f28 += this.f237194m.getPageWidth(i38) + f16;
                i38++;
            }
            if (i16 == i36) {
                this.N = (cVar8.f237222d + f28) - 1.0f;
            }
            cVar8.f237223e = f28;
            f28 += cVar8.f237222d + f16;
            i39++;
            i38++;
        }
        this.f237200r0 = false;
    }

    private void j(boolean z16) {
        boolean z17;
        if (this.C0 == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            S(false);
            this.G.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.G.getCurrX();
            int currY = this.G.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.T = false;
        for (int i3 = 0; i3 < this.f237184f.size(); i3++) {
            c cVar = this.f237184f.get(i3);
            if (cVar.f237221c) {
                cVar.f237221c = false;
                z17 = true;
            }
        }
        if (z17) {
            if (z16) {
                ViewCompat.postOnAnimation(this, this.B0);
            } else {
                this.B0.run();
            }
        }
    }

    private int l(int i3, float f16, int i16, int i17) {
        float f17;
        if (Math.abs(i17) > this.f237193l0 && Math.abs(i16) > this.f237191j0) {
            if (i16 <= 0) {
                i3++;
            }
        } else {
            if (i3 >= this.C) {
                f17 = 0.4f;
            } else {
                f17 = 0.6f;
            }
            i3 = (int) (i3 + f16 + f17);
        }
        if (this.f237184f.size() > 0) {
            return Math.max(this.f237184f.get(0).f237220b, Math.min(i3, this.f237184f.get(r4.size() - 1).f237220b));
        }
        return i3;
    }

    private void n(boolean z16) {
        int i3;
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            if (z16) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            ViewCompat.setLayerType(getChildAt(i16), i3, null);
        }
    }

    private void o() {
        this.V = false;
        this.W = false;
        VelocityTracker velocityTracker = this.f237190i0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f237190i0 = null;
        }
    }

    private Rect r(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int s() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fb, code lost:
    
        if (r5 != r9.f237220b) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00fd, code lost:
    
        r4 = r4 + r9.f237222d;
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0108, code lost:
    
        if (r8 >= r14.f237184f.size()) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010a, code lost:
    
        r9 = r14.f237184f.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x006c, code lost:
    
        if (r10 != r9.f237220b) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x006e, code lost:
    
        r11 = r11 + r9.f237222d;
        r4 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0073, code lost:
    
        if (r4 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0075, code lost:
    
        r9 = r14.f237184f.get(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(c cVar, int i3, int i16, int i17, c cVar2, int i18) {
        c cVar3;
        float paddingLeft;
        c cVar4;
        if (cVar != null) {
            int i19 = i16 - 1;
            if (i19 >= 0) {
                cVar3 = this.f237184f.get(i19);
            } else {
                cVar3 = null;
            }
            int s16 = s();
            float f16 = 0.0f;
            if (s16 <= 0) {
                paddingLeft = 0.0f;
            } else {
                paddingLeft = (2.0f - cVar.f237222d) + (getPaddingLeft() / s16);
            }
            float f17 = 0.0f;
            int i26 = this.C - 1;
            c cVar5 = cVar3;
            int i27 = i19;
            int i28 = i16;
            while (i26 >= 0) {
                if (f17 >= paddingLeft && i26 < i3) {
                    if (cVar5 == null) {
                        break;
                    }
                    if (i26 == cVar5.f237220b && !cVar5.f237221c) {
                        this.f237184f.remove(i27);
                        this.f237194m.destroyItem((ViewGroup) this, i26, cVar5.f237219a);
                        i27--;
                        i28--;
                        if (i27 >= 0) {
                            cVar5 = this.f237184f.get(i27);
                        }
                        cVar5 = null;
                    }
                    i26--;
                }
                f17 += f(i26, i27 + 1).f237222d;
                i28++;
                if (i27 >= 0) {
                    cVar5 = this.f237184f.get(i27);
                    i26--;
                }
                cVar5 = null;
                i26--;
            }
            float f18 = cVar.f237222d;
            int i29 = i28 + 1;
            if (f18 < 2.0f) {
                if (i29 < this.f237184f.size()) {
                    cVar4 = this.f237184f.get(i29);
                } else {
                    cVar4 = null;
                }
                if (s16 > 0) {
                    f16 = (getPaddingRight() / s16) + 2.0f;
                }
                int i36 = this.C + 1;
                while (i36 < i18) {
                    if (f18 >= f16 && i36 > i17) {
                        if (cVar4 == null) {
                            break;
                        }
                        if (i36 == cVar4.f237220b && !cVar4.f237221c) {
                            this.f237184f.remove(i29);
                            this.f237194m.destroyItem((ViewGroup) this, i36, cVar4.f237219a);
                            if (i29 < this.f237184f.size()) {
                                cVar4 = this.f237184f.get(i29);
                            }
                            cVar4 = null;
                        }
                        i36++;
                    }
                    c f19 = f(i36, i29);
                    i29++;
                    f18 += f19.f237222d;
                    if (i29 < this.f237184f.size()) {
                        cVar4 = this.f237184f.get(i29);
                        i36++;
                    }
                    cVar4 = null;
                    i36++;
                }
            }
            h(cVar, i28, cVar2);
        }
    }

    private c x() {
        float f16;
        float f17;
        int i3;
        int s16 = s();
        float f18 = 0.0f;
        if (s16 > 0) {
            f16 = getScrollY() / s16;
        } else {
            f16 = 0.0f;
        }
        if (s16 > 0) {
            f17 = this.I / s16;
        } else {
            f17 = 0.0f;
        }
        int i16 = 0;
        boolean z16 = true;
        c cVar = null;
        int i17 = -1;
        float f19 = 0.0f;
        while (i16 < this.f237184f.size()) {
            c cVar2 = this.f237184f.get(i16);
            if (!z16 && cVar2.f237220b != (i3 = i17 + 1)) {
                cVar2 = this.f237187h;
                cVar2.f237223e = f18 + f19 + f17;
                cVar2.f237220b = i3;
                cVar2.f237222d = this.f237194m.getPageWidth(i3);
                i16--;
            }
            c cVar3 = cVar2;
            f18 = cVar3.f237223e;
            float f26 = cVar3.f237222d + f18 + f17;
            if (!z16 && f16 < f18) {
                return cVar;
            }
            if (f16 >= f26 && i16 != this.f237184f.size() - 1) {
                int i18 = cVar3.f237220b;
                float f27 = cVar3.f237222d;
                i16++;
                z16 = false;
                i17 = i18;
                f19 = f27;
                cVar = cVar3;
            } else {
                return cVar3;
            }
        }
        return cVar;
    }

    public boolean A(int i3) {
        if (this.f237194m == null) {
            return false;
        }
        int s16 = s();
        int scrollY = getScrollY();
        if (i3 < 0) {
            if (scrollY <= ((int) (s16 * this.M))) {
                return false;
            }
            return true;
        }
        if (i3 <= 0 || scrollY >= ((int) (s16 * this.N))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void C(int i3, float f16, int i16) {
        int max;
        int i17;
        int top;
        if (this.f237202t0 > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f237210a) {
                    int i19 = layoutParams.f237211b & 112;
                    if (i19 != 16) {
                        if (i19 != 48) {
                            if (i19 != 80) {
                                i17 = paddingTop;
                            } else {
                                max = (height - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                        } else {
                            i17 = childAt.getHeight() + paddingTop;
                        }
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                            childAt.offsetTopAndBottom(top);
                        }
                        paddingTop = i17;
                    } else {
                        max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i26 = max;
                    i17 = paddingTop;
                    paddingTop = i26;
                    top = (paddingTop + scrollY) - childAt.getTop();
                    if (top != 0) {
                    }
                    paddingTop = i17;
                }
            }
        }
        com.tencent.mobileqq.icgame.base.room.multipage.controller.a aVar = this.f237203u0;
        if (aVar != null) {
            aVar.onPageScrolled(i3, f16, i16);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f237204v0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f16, i16);
        }
        if (this.f237205w0 != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i27 = 0; i27 < childCount2; i27++) {
                View childAt2 = getChildAt(i27);
                if (!((LayoutParams) childAt2.getLayoutParams()).f237210a) {
                    this.f237205w0.transformPage(childAt2, (childAt2.getTop() - scrollY2) / s());
                }
            }
        }
        this.f237201s0 = true;
    }

    boolean E() {
        PagerAdapter pagerAdapter = this.f237194m;
        if (pagerAdapter != null && this.C < pagerAdapter.getF373114d() - 1) {
            setCurrentItem(this.C + 1, true);
            return true;
        }
        return false;
    }

    boolean G() {
        int i3 = this.C;
        if (i3 > 0) {
            setCurrentItem(i3 - 1, true);
            return true;
        }
        return false;
    }

    void I() {
        J(this.C);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
    
        if (r3 == r4) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void J(int i3) {
        final int i16;
        c cVar;
        String hexString;
        c cVar2;
        int i17 = this.C;
        Object obj = null;
        if (i17 != i3) {
            if (i17 < i3) {
                i16 = 130;
            } else {
                i16 = 33;
            }
            c y16 = y(i17);
            this.C = i3;
            cVar = y16;
        } else {
            i16 = 2;
            cVar = null;
        }
        if (this.f237194m == null) {
            U();
            return;
        }
        if (this.T) {
            e22.b.f395373a.a().i("ICGameViewPager", "populate is pending, skipping for now...");
            U();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.f237194m.startUpdate((ViewGroup) this);
        int i18 = this.U;
        int max = Math.max(0, this.C - i18);
        int f373114d = this.f237194m.getF373114d();
        int min = Math.min(f373114d - 1, this.C + i18);
        if (f373114d == this.f237182e) {
            int i19 = 0;
            while (true) {
                if (i19 >= this.f237184f.size()) {
                    break;
                }
                cVar2 = this.f237184f.get(i19);
                int i26 = cVar2.f237220b;
                int i27 = this.C;
                if (i26 < i27) {
                    i19++;
                }
            }
            cVar2 = null;
            if (cVar2 == null && f373114d > 0) {
                cVar2 = f(this.C, i19);
            }
            u(cVar2, max, i19, min, cVar, f373114d);
            PagerAdapter pagerAdapter = this.f237194m;
            int i28 = this.C;
            if (cVar2 != null) {
                obj = cVar2.f237219a;
            }
            pagerAdapter.setPrimaryItem((ViewGroup) this, i28, obj);
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.base.room.multipage.controller.VerticalViewPager.4
                @Override // java.lang.Runnable
                public void run() {
                    c cVar3;
                    c w3;
                    VerticalViewPager.this.f237194m.finishUpdate((ViewGroup) VerticalViewPager.this);
                    int childCount = VerticalViewPager.this.getChildCount();
                    for (int i29 = 0; i29 < childCount; i29++) {
                        View childAt = VerticalViewPager.this.getChildAt(i29);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        layoutParams.f237215f = i29;
                        if (!layoutParams.f237210a && layoutParams.f237212c == 0.0f && (w3 = VerticalViewPager.this.w(childAt)) != null) {
                            layoutParams.f237212c = w3.f237222d;
                            layoutParams.f237214e = w3.f237220b;
                        }
                    }
                    VerticalViewPager.this.U();
                    if (VerticalViewPager.this.hasFocus()) {
                        View findFocus = VerticalViewPager.this.findFocus();
                        if (findFocus != null) {
                            cVar3 = VerticalViewPager.this.v(findFocus);
                        } else {
                            cVar3 = null;
                        }
                        if (cVar3 == null || cVar3.f237220b != VerticalViewPager.this.C) {
                            for (int i36 = 0; i36 < VerticalViewPager.this.getChildCount(); i36++) {
                                View childAt2 = VerticalViewPager.this.getChildAt(i36);
                                c w16 = VerticalViewPager.this.w(childAt2);
                                if (w16 != null && w16.f237220b == VerticalViewPager.this.C && childAt2.requestFocus(i16)) {
                                    return;
                                }
                            }
                        }
                    }
                }
            };
            if (E0 && i3 != 0) {
                this.A0.postAtFrontOfQueue(runnable);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        try {
            hexString = getResources().getResourceName(getId());
        } catch (Resources.NotFoundException unused) {
            hexString = Integer.toHexString(getId());
        }
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f237182e + ", found: " + f373114d + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f237194m.getClass());
    }

    void O(boolean z16) {
        if (this.f237206x0 == null) {
            try {
                this.f237206x0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e16) {
                e22.b.f395373a.a().e("ICGameViewPager", "Can't find setChildrenDrawingOrderEnabled", e16);
            }
        }
        try {
            Method method = this.f237206x0;
            if (method != null) {
                method.invoke(this, Boolean.valueOf(z16));
            }
        } catch (Exception e17) {
            e22.b.f395373a.a().e("ICGameViewPager", "Error changing children drawing order", e17);
        }
    }

    void P(int i3, boolean z16, boolean z17) {
        Q(i3, z16, z17, 0);
    }

    void Q(int i3, boolean z16, boolean z17, int i16) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        com.tencent.mobileqq.icgame.base.room.multipage.controller.a aVar;
        PagerAdapter pagerAdapter = this.f237194m;
        boolean z18 = false;
        if (pagerAdapter != null && pagerAdapter.getF373114d() > 0) {
            if (!z17 && this.C == i3 && this.f237184f.size() != 0) {
                S(false);
                return;
            }
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 >= this.f237194m.getF373114d()) {
                i3 = this.f237194m.getF373114d() - 1;
            }
            int i17 = this.U;
            int i18 = this.C;
            if (i3 > i18 + i17 || i3 < i18 - i17) {
                for (int i19 = 0; i19 < this.f237184f.size(); i19++) {
                    this.f237184f.get(i19).f237221c = true;
                }
            }
            if (this.C != i3) {
                z18 = true;
            }
            if (this.f237199q0) {
                this.C = i3;
                if (z18 && (aVar = this.f237203u0) != null) {
                    aVar.onPageSelected(i3);
                }
                if (z18 && (onPageChangeListener = this.f237204v0) != null) {
                    onPageChangeListener.onPageSelected(i3);
                }
                requestLayout();
                return;
            }
            if (i3 == 0) {
                J(i3);
                N(i3, z16, i16, z18);
                return;
            } else {
                N(i3, z16, i16, z18);
                J(i3);
                return;
            }
        }
        S(false);
    }

    void T(int i3, int i16, int i17) {
        int abs;
        if (getChildCount() == 0) {
            S(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i18 = i3 - scrollX;
        int i19 = i16 - scrollY;
        if (i18 == 0 && i19 == 0) {
            j(false);
            I();
            R(0);
            return;
        }
        S(true);
        R(2);
        int s16 = s();
        int i26 = s16 / 2;
        float f16 = s16;
        float f17 = i26;
        float m3 = f17 + (m(Math.min(1.0f, (Math.abs(i18) * 1.0f) / f16)) * f17);
        int abs2 = Math.abs(i17);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(m3 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i18) / ((f16 * this.f237194m.getPageWidth(this.C)) + this.I)) + 5.0f) * 100.0f);
        }
        this.G.startScroll(scrollX, scrollY, i18, i19, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        c w3;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() == 0 && (w3 = w(childAt)) != null && w3.f237220b == this.C) {
                    childAt.addFocusables(arrayList, i3, i16);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i16 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        arrayList.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        c w3;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (w3 = w(childAt)) != null && w3.f237220b == this.C) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z16 = layoutParams2.f237210a | false;
        layoutParams2.f237210a = z16;
        if (this.R) {
            if (!z16) {
                layoutParams2.f237213d = true;
                addViewInLayout(view, i3, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i3, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.G.isFinished() && this.G.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.G.getCurrX();
            int currY = this.G.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!F(currY)) {
                    this.G.abortAnimation();
                    scrollTo(currX, 0);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        j(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !p(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        c w3;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (w3 = w(childAt)) != null && w3.f237220b == this.C && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z16 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f237194m) == null || pagerAdapter.getF373114d() <= 1)) {
            this.f237197o0.finish();
            this.f237198p0.finish();
        } else {
            if (!this.f237197o0.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.M * height);
                this.f237197o0.setSize(width, height);
                z16 = false | this.f237197o0.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f237198p0.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.N + 1.0f)) * height2);
                this.f237198p0.setSize(width2, height2);
                z16 |= this.f237198p0.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.J;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    c f(int i3, int i16) {
        c cVar = new c();
        cVar.f237220b = i3;
        cVar.f237219a = this.f237194m.instantiateItem((ViewGroup) this, i3);
        cVar.f237222d = this.f237194m.getPageWidth(i3);
        if (i16 >= 0 && i16 < this.f237184f.size()) {
            this.f237184f.add(i16, cVar);
        } else {
            this.f237184f.add(cVar);
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(int i3) {
        boolean z16;
        View findNextFocus;
        boolean requestFocus;
        View findFocus = findFocus();
        boolean z17 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (parent instanceof ViewGroup) {
                        if (parent == this) {
                            z16 = true;
                            break;
                        }
                        parent = parent.getParent();
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        parent2.getClass();
                    }
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i3 == 33) {
                    int i16 = r(this.f237189i, findNextFocus).top;
                    int i17 = r(this.f237189i, findFocus).top;
                    if (findFocus != null && i16 >= i17) {
                        requestFocus = G();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                } else if (i3 == 130) {
                    int i18 = r(this.f237189i, findNextFocus).bottom;
                    int i19 = r(this.f237189i, findFocus).bottom;
                    if (findFocus != null && i18 <= i19) {
                        requestFocus = E();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                }
                z17 = requestFocus;
            } else if (i3 == 33 && i3 != 1) {
                if (i3 == 130 || i3 == 2) {
                    z17 = E();
                }
            } else {
                z17 = G();
            }
            if (z17) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i3));
            }
            return z17;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        if (findNextFocus == null) {
        }
        if (i3 == 33) {
        }
        z17 = G();
        if (z17) {
        }
        return z17;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        if (this.f237207y0 == 2) {
            i16 = (i3 - 1) - i16;
        }
        return ((LayoutParams) this.f237208z0.get(i16).getLayoutParams()).f237215f;
    }

    protected boolean i(View view, boolean z16, int i3, int i16, int i17) {
        int i18;
        if (view instanceof ViewGroup) {
            if (view.getVisibility() != 0) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i19 = i17 + scrollY;
                if (i19 >= childAt.getTop() && i19 < childAt.getBottom() && (i18 = i16 + scrollX) >= childAt.getLeft() && i18 < childAt.getRight() && i(childAt, true, i3, i18 - childAt.getLeft(), i19 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z16 || !ViewCompat.canScrollVertically(view, -i3)) {
            return false;
        }
        return true;
    }

    void k() {
        boolean z16;
        int f373114d = this.f237194m.getF373114d();
        this.f237182e = f373114d;
        if (this.f237184f.size() < (this.U * 2) + 1 && this.f237184f.size() < f373114d) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.C;
        int i16 = 0;
        boolean z17 = false;
        while (i16 < this.f237184f.size()) {
            c cVar = this.f237184f.get(i16);
            int itemPosition = this.f237194m.getItemPosition(cVar.f237219a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f237184f.remove(i16);
                    i16--;
                    if (!z17) {
                        this.f237194m.startUpdate((ViewGroup) this);
                        z17 = true;
                    }
                    this.f237194m.destroyItem((ViewGroup) this, cVar.f237220b, cVar.f237219a);
                    int i17 = this.C;
                    if (i17 == cVar.f237220b) {
                        i3 = Math.max(0, Math.min(i17, f373114d - 1));
                    }
                } else {
                    int i18 = cVar.f237220b;
                    if (i18 != itemPosition) {
                        if (i18 == this.C) {
                            i3 = itemPosition;
                        }
                        cVar.f237220b = itemPosition;
                    }
                }
                z16 = true;
            }
            i16++;
        }
        if (z17) {
            this.f237194m.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f237184f, F0);
        if (z16) {
            int childCount = getChildCount();
            for (int i19 = 0; i19 < childCount; i19++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i19).getLayoutParams();
                if (!layoutParams.f237210a) {
                    layoutParams.f237212c = 0.0f;
                }
            }
            P(i3, false, true);
            requestLayout();
        }
    }

    float m(float f16) {
        return (float) Math.sin((float) ((f16 - 0.5f) * 0.4712389167638204d));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f237199q0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.B0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        float f16;
        float f17;
        super.onDraw(canvas);
        if (this.I > 0 && this.J != null && this.f237184f.size() > 0 && this.f237194m != null) {
            int scrollY = getScrollY();
            float height = getHeight();
            float f18 = this.I / height;
            int i16 = 0;
            c cVar = this.f237184f.get(0);
            float f19 = cVar.f237223e;
            int size = this.f237184f.size();
            int i17 = cVar.f237220b;
            int i18 = this.f237184f.get(size - 1).f237220b;
            while (i17 < i18) {
                while (true) {
                    i3 = cVar.f237220b;
                    if (i17 <= i3 || i16 >= size) {
                        break;
                    }
                    i16++;
                    cVar = this.f237184f.get(i16);
                }
                if (i17 == i3) {
                    float f26 = cVar.f237223e;
                    float f27 = cVar.f237222d;
                    f16 = (f26 + f27) * height;
                    f19 = f26 + f27 + f18;
                } else {
                    float pageWidth = this.f237194m.getPageWidth(i17);
                    f16 = (f19 + pageWidth) * height;
                    f19 += pageWidth + f18;
                }
                int i19 = this.I;
                if (i19 + f16 > scrollY) {
                    f17 = f18;
                    this.J.setBounds(this.K, (int) f16, this.L, (int) (i19 + f16 + 0.5f));
                    this.J.draw(canvas);
                } else {
                    f17 = f18;
                }
                if (f16 <= scrollY + r2) {
                    i17++;
                    f18 = f17;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f16;
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.V) {
                    e22.b.f395373a.a().d("ICGameViewPager", "Intercept returning true!");
                    return true;
                }
                if (this.W) {
                    e22.b.f395373a.a().i("ICGameViewPager", "Intercept returning false!");
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        D(motionEvent);
                    }
                } else {
                    int i3 = this.f237188h0;
                    if (i3 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i3);
                        float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float f17 = y16 - this.f237183e0;
                        float abs = Math.abs(f17);
                        float x16 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(x16 - this.f237185f0);
                        if (this.f237180d && abs >= ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                            this.V = true;
                        } else {
                            if (f17 != 0.0f && !B(this.f237183e0, f17) && i(this, false, (int) f17, (int) x16, (int) y16)) {
                                this.f237181d0 = x16;
                                this.f237183e0 = y16;
                                this.W = true;
                                return false;
                            }
                            int i16 = this.f237179c0;
                            if (abs > i16 && abs * 0.5f > abs2) {
                                this.V = true;
                                M(true);
                                R(1);
                                if (f17 > 0.0f) {
                                    f16 = this.f237186g0 + this.f237179c0;
                                } else {
                                    f16 = this.f237186g0 - this.f237179c0;
                                }
                                this.f237183e0 = f16;
                                this.f237181d0 = x16;
                                S(true);
                            } else if (abs2 > i16) {
                                this.W = true;
                            }
                            if (this.V && H(y16)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    }
                }
            } else {
                float x17 = motionEvent.getX();
                this.f237185f0 = x17;
                this.f237181d0 = x17;
                float y17 = motionEvent.getY();
                this.f237186g0 = y17;
                this.f237183e0 = y17;
                this.f237188h0 = MotionEventCompat.getPointerId(motionEvent, 0);
                this.W = false;
                this.G.computeScrollOffset();
                if (this.C0 == 2 && Math.abs(this.G.getFinalY() - this.G.getCurrY()) > this.f237195m0) {
                    this.G.abortAnimation();
                    this.T = false;
                    I();
                    this.V = true;
                    M(true);
                    R(1);
                } else {
                    j(false);
                    this.V = false;
                }
            }
            if (this.f237190i0 == null) {
                this.f237190i0 = VelocityTracker.obtain();
            }
            this.f237190i0.addMovement(motionEvent);
            return this.V;
        }
        e22.b.f395373a.a().d("ICGameViewPager", "Intercept done!");
        this.V = false;
        this.W = false;
        this.f237188h0 = -1;
        VelocityTracker velocityTracker = this.f237190i0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f237190i0 = null;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        c w3;
        int max;
        int i19;
        int max2;
        int i26;
        int childCount = getChildCount();
        int i27 = i17 - i3;
        int i28 = i18 - i16;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i29 = 0;
        for (int i36 = 0; i36 < childCount; i36++) {
            View childAt = getChildAt(i36);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f237210a) {
                    int i37 = layoutParams.f237211b;
                    int i38 = i37 & 7;
                    int i39 = i37 & 112;
                    if (i38 != 1) {
                        if (i38 != 3) {
                            if (i38 != 5) {
                                i19 = paddingLeft;
                            } else {
                                max = (i27 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i19 = childAt.getMeasuredWidth() + paddingLeft;
                        }
                        if (i39 == 16) {
                            if (i39 != 48) {
                                if (i39 != 80) {
                                    i26 = paddingTop;
                                } else {
                                    max2 = (i28 - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                            } else {
                                i26 = childAt.getMeasuredHeight() + paddingTop;
                            }
                            int i46 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i46, childAt.getMeasuredWidth() + paddingLeft, i46 + childAt.getMeasuredHeight());
                            i29++;
                            paddingTop = i26;
                            paddingLeft = i19;
                        } else {
                            max2 = Math.max((i28 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i47 = max2;
                        i26 = paddingTop;
                        paddingTop = i47;
                        int i462 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i462, childAt.getMeasuredWidth() + paddingLeft, i462 + childAt.getMeasuredHeight());
                        i29++;
                        paddingTop = i26;
                        paddingLeft = i19;
                    } else {
                        max = Math.max((i27 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i48 = max;
                    i19 = paddingLeft;
                    paddingLeft = i48;
                    if (i39 == 16) {
                    }
                    int i472 = max2;
                    i26 = paddingTop;
                    paddingTop = i472;
                    int i4622 = paddingTop + scrollY;
                    childAt.layout(paddingLeft, i4622, childAt.getMeasuredWidth() + paddingLeft, i4622 + childAt.getMeasuredHeight());
                    i29++;
                    paddingTop = i26;
                    paddingLeft = i19;
                }
            }
        }
        int i49 = (i28 - paddingTop) - paddingBottom;
        for (int i56 = 0; i56 < childCount; i56++) {
            View childAt2 = getChildAt(i56);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f237210a && (w3 = w(childAt2)) != null) {
                    float f16 = i49;
                    int i57 = ((int) (w3.f237223e * f16)) + paddingTop;
                    if (layoutParams2.f237213d) {
                        layoutParams2.f237213d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i27 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f16 * layoutParams2.f237212c), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i57, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i57);
                }
            }
        }
        this.K = paddingLeft;
        this.L = i27 - paddingRight;
        this.f237202t0 = i29;
        if (this.f237199q0) {
            z17 = false;
            N(this.C, false, 0, false);
        } else {
            z17 = false;
        }
        this.f237199q0 = z17;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z16;
        int i17;
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i16));
        int measuredHeight = getMeasuredHeight();
        this.f237178b0 = Math.min(measuredHeight / 10, this.f237177a0);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i18 = 0;
        while (true) {
            boolean z17 = true;
            int i19 = 1073741824;
            if (i18 >= childCount) {
                break;
            }
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f237210a) {
                int i26 = layoutParams2.f237211b;
                int i27 = i26 & 7;
                int i28 = i26 & 112;
                if (i28 != 48 && i28 != 80) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i27 != 3 && i27 != 5) {
                    z17 = false;
                }
                int i29 = Integer.MIN_VALUE;
                if (z16) {
                    i17 = Integer.MIN_VALUE;
                    i29 = 1073741824;
                } else if (z17) {
                    i17 = 1073741824;
                } else {
                    i17 = Integer.MIN_VALUE;
                }
                int i36 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i36 != -2) {
                    if (i36 == -1) {
                        i36 = measuredWidth;
                    }
                    i29 = 1073741824;
                } else {
                    i36 = measuredWidth;
                }
                int i37 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i37 != -2) {
                    if (i37 == -1) {
                        i37 = paddingTop;
                    }
                } else {
                    i37 = paddingTop;
                    i19 = i17;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i36, i29), View.MeasureSpec.makeMeasureSpec(i37, i19));
                if (z16) {
                    paddingTop -= childAt.getMeasuredHeight();
                } else if (z17) {
                    measuredWidth -= childAt.getMeasuredWidth();
                }
            }
            i18++;
        }
        this.P = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.Q = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.R = true;
        I();
        this.R = false;
        int childCount2 = getChildCount();
        for (int i38 = 0; i38 < childCount2; i38++) {
            View childAt2 = getChildAt(i38);
            if (childAt2.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt2.getLayoutParams()) != null && !layoutParams.f237210a) {
                childAt2.measure(this.P, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * layoutParams.f237212c), 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        int i16;
        int i17;
        int i18;
        c w3;
        int childCount = getChildCount();
        if ((i3 & 2) != 0) {
            i17 = childCount;
            i16 = 0;
            i18 = 1;
        } else {
            i16 = childCount - 1;
            i17 = -1;
            i18 = -1;
        }
        while (i16 != i17) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 0 && (w3 = w(childAt)) != null && w3.f237220b == this.C && childAt.requestFocus(i3, rect)) {
                return true;
            }
            i16 += i18;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.f237194m;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f237217e, savedState.f237218f);
            P(savedState.f237216d, false, true);
        } else {
            this.D = savedState.f237216d;
            this.E = savedState.f237217e;
            this.F = savedState.f237218f;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f237216d = this.C;
        PagerAdapter pagerAdapter = this.f237194m;
        if (pagerAdapter != null) {
            savedState.f237217e = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i16 != i18) {
            int i19 = this.I;
            K(i16, i18, i19, i19);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        boolean onRelease;
        boolean onRelease2;
        float f16;
        if (this.f237180d || this.f237196n0) {
            return true;
        }
        boolean z16 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f237194m) == null || pagerAdapter.getF373114d() == 0) {
            return false;
        }
        if (this.f237190i0 == null) {
            this.f237190i0 = VelocityTracker.obtain();
        }
        this.f237190i0.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                D(motionEvent);
                                this.f237183e0 = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f237188h0));
                            }
                        } else {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            this.f237183e0 = MotionEventCompat.getY(motionEvent, actionIndex);
                            this.f237188h0 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        }
                    } else if (this.V) {
                        N(this.C, true, 0, false);
                        this.f237188h0 = -1;
                        o();
                        onRelease = this.f237197o0.onRelease();
                        onRelease2 = this.f237198p0.onRelease();
                        z16 = onRelease | onRelease2;
                    }
                } else {
                    if (!this.V) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f237188h0);
                        float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float abs = Math.abs(y16 - this.f237183e0);
                        float x16 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(x16 - this.f237181d0);
                        if (abs > this.f237179c0 && abs > abs2) {
                            this.V = true;
                            M(true);
                            float f17 = this.f237186g0;
                            if (y16 - f17 > 0.0f) {
                                f16 = f17 + this.f237179c0;
                            } else {
                                f16 = f17 - this.f237179c0;
                            }
                            this.f237183e0 = f16;
                            this.f237181d0 = x16;
                            R(1);
                            S(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.V) {
                        z16 = false | H(MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f237188h0)));
                    }
                }
            } else if (this.V) {
                VelocityTracker velocityTracker = this.f237190i0;
                velocityTracker.computeCurrentVelocity(1000, this.f237192k0);
                int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.f237188h0);
                this.T = true;
                int s16 = s();
                int scrollY = getScrollY();
                c x17 = x();
                Q(l(x17.f237220b, ((scrollY / s16) - x17.f237223e) / x17.f237222d, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f237188h0)) - this.f237186g0)), true, true, yVelocity);
                this.f237188h0 = -1;
                o();
                onRelease = this.f237197o0.onRelease();
                onRelease2 = this.f237198p0.onRelease();
                z16 = onRelease | onRelease2;
            }
        } else {
            this.G.abortAnimation();
            this.T = false;
            I();
            float x18 = motionEvent.getX();
            this.f237185f0 = x18;
            this.f237181d0 = x18;
            float y17 = motionEvent.getY();
            this.f237186g0 = y17;
            this.f237183e0 = y17;
            this.f237188h0 = MotionEventCompat.getPointerId(motionEvent, 0);
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return g(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return g(1);
                        }
                    }
                } else {
                    return g(66);
                }
            } else {
                return g(17);
            }
        }
        return false;
    }

    public PagerAdapter q() {
        return this.f237194m;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.R) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.f237194m;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.H);
            this.f237194m.startUpdate((ViewGroup) this);
            for (int i3 = 0; i3 < this.f237184f.size(); i3++) {
                c cVar = this.f237184f.get(i3);
                this.f237194m.destroyItem((ViewGroup) this, cVar.f237220b, cVar.f237219a);
            }
            this.f237194m.finishUpdate((ViewGroup) this);
            this.f237184f.clear();
            L();
            this.C = 0;
            scrollTo(0, 0);
        }
        this.f237194m = pagerAdapter;
        this.f237182e = 0;
        if (pagerAdapter != null) {
            a aVar = null;
            if (this.H == null) {
                this.H = new e(this, aVar);
            }
            this.f237194m.registerDataSetObserver(this.H);
            this.T = false;
            boolean z16 = this.f237199q0;
            this.f237199q0 = true;
            this.f237182e = this.f237194m.getF373114d();
            if (this.D >= 0) {
                this.f237194m.restoreState(this.E, this.F);
                P(this.D, false, true);
                this.D = -1;
                this.E = null;
                this.F = null;
                return;
            }
            if (!z16) {
                I();
            } else {
                requestLayout();
            }
        }
    }

    public void setCurrentItem(int i3) {
        this.T = false;
        P(i3, !this.f237199q0, false);
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1) {
            e22.b.f395373a.a().w("ICGameViewPager", "Requested offscreen page limit " + i3 + " too small; defaulting to 1");
            i3 = 1;
        }
        if (i3 != this.U) {
            this.U = i3;
            I();
        }
    }

    public void setOnPageChangeListener(com.tencent.mobileqq.icgame.base.room.multipage.controller.a aVar) {
        this.f237203u0 = aVar;
    }

    public void setPageMargin(int i3) {
        int i16 = this.I;
        this.I = i3;
        int height = getHeight();
        K(height, height, i3, i16);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.J = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z16, ViewPager.PageTransformer pageTransformer) {
        boolean z17;
        boolean z18;
        boolean z19;
        int i3 = 1;
        if (pageTransformer != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.f237205w0 != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 != z18) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.f237205w0 = pageTransformer;
        O(z17);
        if (z17) {
            if (z16) {
                i3 = 2;
            }
            this.f237207y0 = i3;
        } else {
            this.f237207y0 = 0;
        }
        if (z19) {
            I();
        }
    }

    public void setScrollForbidden(boolean z16) {
        this.f237180d = z16;
    }

    public int t() {
        return this.C;
    }

    c v(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view = (View) parent;
                } else {
                    return null;
                }
            } else {
                return w(view);
            }
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.J) {
            return false;
        }
        return true;
    }

    c w(View view) {
        for (int i3 = 0; i3 < this.f237184f.size(); i3++) {
            c cVar = this.f237184f.get(i3);
            if (this.f237194m.isViewFromObject(view, cVar.f237219a)) {
                return cVar;
            }
        }
        return null;
    }

    c y(int i3) {
        for (int i16 = 0; i16 < this.f237184f.size(); i16++) {
            c cVar = this.f237184f.get(i16);
            if (cVar.f237220b == i3) {
                return cVar;
            }
        }
        return null;
    }

    void z() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.G = new Scroller(context, G0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.f237179c0 = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.f237191j0 = (int) (400.0f * f16);
        this.f237192k0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f237197o0 = new EdgeEffectCompat(context);
        this.f237198p0 = new EdgeEffectCompat(context);
        this.f237193l0 = (int) (25.0f * f16);
        this.f237195m0 = (int) (2.0f * f16);
        this.f237177a0 = (int) (f16 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* loaded from: classes15.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f237210a;

        /* renamed from: b, reason: collision with root package name */
        public int f237211b;

        /* renamed from: c, reason: collision with root package name */
        float f237212c;

        /* renamed from: d, reason: collision with root package name */
        boolean f237213d;

        /* renamed from: e, reason: collision with root package name */
        int f237214e;

        /* renamed from: f, reason: collision with root package name */
        int f237215f;

        public LayoutParams() {
            super(-1, -1);
            this.f237212c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f237212c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.D0);
            this.f237211b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setCurrentItem(int i3, boolean z16) {
        this.T = false;
        P(i3, z16, false);
    }

    public void setPageMarginDrawable(int i3) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i3));
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f237180d = false;
        this.f237184f = new ArrayList<>();
        this.f237187h = new c();
        this.f237189i = new Rect();
        this.D = -1;
        this.E = null;
        this.F = null;
        this.M = -3.4028235E38f;
        this.N = Float.MAX_VALUE;
        this.U = 1;
        this.f237188h0 = -1;
        this.f237199q0 = true;
        this.f237200r0 = false;
        this.A0 = new Handler(Looper.getMainLooper());
        this.B0 = new Runnable() { // from class: com.tencent.mobileqq.icgame.base.room.multipage.controller.VerticalViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                VerticalViewPager.this.R(0);
                VerticalViewPager.this.I();
            }
        };
        this.C0 = 0;
        z();
    }
}
