package com.tencent.mobileqq.qqlive.base.room.multipage.controller;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes17.dex */
public class VerticalViewPager extends ViewGroup {
    static IPatchRedirector $redirector_;
    private static final int[] D0;
    private static boolean E0;
    private static final Comparator<c> F0;
    private static final Interpolator G0;
    private static final f H0;
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
    private int f271062a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f271063b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f271064c0;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f271065d;

    /* renamed from: d0, reason: collision with root package name */
    private float f271066d0;

    /* renamed from: e, reason: collision with root package name */
    private int f271067e;

    /* renamed from: e0, reason: collision with root package name */
    private float f271068e0;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<c> f271069f;

    /* renamed from: f0, reason: collision with root package name */
    private float f271070f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f271071g0;

    /* renamed from: h, reason: collision with root package name */
    private final c f271072h;

    /* renamed from: h0, reason: collision with root package name */
    private int f271073h0;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f271074i;

    /* renamed from: i0, reason: collision with root package name */
    private VelocityTracker f271075i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f271076j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f271077k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f271078l0;

    /* renamed from: m, reason: collision with root package name */
    private PagerAdapter f271079m;

    /* renamed from: m0, reason: collision with root package name */
    private int f271080m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f271081n0;

    /* renamed from: o0, reason: collision with root package name */
    private EdgeEffectCompat f271082o0;

    /* renamed from: p0, reason: collision with root package name */
    private EdgeEffectCompat f271083p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f271084q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f271085r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f271086s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f271087t0;

    /* renamed from: u0, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.base.room.multipage.controller.a f271088u0;

    /* renamed from: v0, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f271089v0;

    /* renamed from: w0, reason: collision with root package name */
    private ViewPager.PageTransformer f271090w0;

    /* renamed from: x0, reason: collision with root package name */
    private Method f271091x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f271092y0;

    /* renamed from: z0, reason: collision with root package name */
    private ArrayList<View> f271093z0;

    /* loaded from: classes17.dex */
    public static class SavedState extends View.BaseSavedState {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<SavedState> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        int f271101d;

        /* renamed from: e, reason: collision with root package name */
        Parcelable f271102e;

        /* renamed from: f, reason: collision with root package name */
        ClassLoader f271103f;

        /* loaded from: classes17.dex */
        class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SavedState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, (Object) classLoader);
                }
                return new SavedState(parcel, classLoader);
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (SavedState[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new SavedState[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33547);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = ParcelableCompat.newCreator(new a());
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcelable);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f271101d + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
                return;
            }
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f271101d);
            parcel.writeParcelable(this.f271102e, i3);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, (Object) classLoader);
                return;
            }
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f271101d = parcel.readInt();
            this.f271102e = parcel.readParcelable(classLoader);
            this.f271103f = classLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements Comparator<c> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2)).intValue();
            }
            return cVar.f271105b - cVar2.f271105b;
        }
    }

    /* loaded from: classes17.dex */
    class b implements Interpolator {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Object f271104a;

        /* renamed from: b, reason: collision with root package name */
        int f271105b;

        /* renamed from: c, reason: collision with root package name */
        boolean f271106c;

        /* renamed from: d, reason: collision with root package name */
        float f271107d;

        /* renamed from: e, reason: collision with root package name */
        float f271108e;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class d extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerticalViewPager.this);
            }
        }

        private boolean canScroll() {
            if (VerticalViewPager.this.f271079m != null && VerticalViewPager.this.f271079m.getF373114d() > 1) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        @SuppressLint({"WrongConstant"})
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityEvent);
                return;
            }
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && VerticalViewPager.this.f271079m != null) {
                obtain.setItemCount(VerticalViewPager.this.f271079m.getF373114d());
                obtain.setFromIndex(VerticalViewPager.this.C);
                obtain.setToIndex(VerticalViewPager.this.C);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (VerticalViewPager.this.y(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (VerticalViewPager.this.y(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), bundle)).booleanValue();
            }
            if (super.performAccessibilityAction(view, i3, bundle)) {
                return true;
            }
            if (i3 != 4096) {
                if (i3 != 8192 || !VerticalViewPager.this.y(-1)) {
                    return false;
                }
                VerticalViewPager verticalViewPager = VerticalViewPager.this;
                verticalViewPager.setCurrentItem(verticalViewPager.C - 1);
                return true;
            }
            if (!VerticalViewPager.this.y(1)) {
                return false;
            }
            VerticalViewPager verticalViewPager2 = VerticalViewPager.this;
            verticalViewPager2.setCurrentItem(verticalViewPager2.C + 1);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class e extends DataSetObserver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerticalViewPager.this);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                VerticalViewPager.this.k();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                VerticalViewPager.this.k();
            }
        }

        /* synthetic */ e(VerticalViewPager verticalViewPager, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) verticalViewPager, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class f implements Comparator<View> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) view2)).intValue();
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z16 = layoutParams.f271095a;
            if (z16 != layoutParams2.f271095a) {
                if (z16) {
                    return 1;
                }
                return -1;
            }
            return layoutParams.f271099e - layoutParams2.f271099e;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 53)) {
            redirector.redirect((short) 53);
            return;
        }
        D0 = new int[]{R.attr.layout_gravity};
        E0 = true;
        F0 = new a();
        G0 = new b();
        H0 = new f();
    }

    public VerticalViewPager(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f271065d = false;
        this.f271069f = new ArrayList<>();
        this.f271072h = new c();
        this.f271074i = new Rect();
        this.D = -1;
        this.E = null;
        this.F = null;
        this.M = -3.4028235E38f;
        this.N = Float.MAX_VALUE;
        this.U = 1;
        this.f271073h0 = -1;
        this.f271084q0 = true;
        this.f271085r0 = false;
        this.A0 = new Handler(Looper.getMainLooper());
        this.B0 = new Runnable() { // from class: com.tencent.mobileqq.qqlive.base.room.multipage.controller.VerticalViewPager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VerticalViewPager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    VerticalViewPager.this.P(0);
                    VerticalViewPager.this.G();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.C0 = 0;
        x();
    }

    private void B(MotionEvent motionEvent) {
        int i3;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f271073h0) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.f271068e0 = MotionEventCompat.getY(motionEvent, i3);
            this.f271073h0 = MotionEventCompat.getPointerId(motionEvent, i3);
            VelocityTracker velocityTracker = this.f271075i0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean D(int i3) {
        if (this.f271069f.size() == 0) {
            this.f271086s0 = false;
            A(0, 0.0f, 0);
            if (this.f271086s0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        c v3 = v();
        if (v3 == null) {
            return false;
        }
        int r16 = r();
        int i16 = this.I;
        int i17 = r16 + i16;
        float f16 = r16;
        int i18 = v3.f271105b;
        float f17 = ((i3 / f16) - v3.f271108e) / (v3.f271107d + (i16 / f16));
        this.f271086s0 = false;
        A(i18, f17, (int) (i17 * f17));
        if (this.f271086s0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean F(float f16) {
        boolean z16;
        float f17 = this.f271068e0 - f16;
        this.f271068e0 = f16;
        float scrollY = getScrollY() + f17;
        float r16 = r();
        float f18 = this.M * r16;
        float f19 = this.N * r16;
        boolean z17 = false;
        c cVar = this.f271069f.get(0);
        ArrayList<c> arrayList = this.f271069f;
        boolean z18 = true;
        c cVar2 = arrayList.get(arrayList.size() - 1);
        if (cVar.f271105b != 0) {
            f18 = cVar.f271108e * r16;
            z16 = false;
        } else {
            z16 = true;
        }
        if (cVar2.f271105b != this.f271079m.getF373114d() - 1) {
            f19 = cVar2.f271108e * r16;
            z18 = false;
        }
        if (scrollY < f18) {
            if (z16) {
                z17 = this.f271082o0.onPull(Math.abs(f18 - scrollY) / r16);
            }
            scrollY = f18;
        } else if (scrollY > f19) {
            if (z18) {
                z17 = this.f271083p0.onPull(Math.abs(scrollY - f19) / r16);
            }
            scrollY = f19;
        }
        int i3 = (int) scrollY;
        this.f271066d0 += scrollY - i3;
        scrollTo(getScrollX(), i3);
        D(i3);
        return z17;
    }

    private void I(int i3, int i16, int i17, int i18) {
        float f16;
        if (i16 > 0 && !this.f271069f.isEmpty()) {
            int scrollY = (int) ((getScrollY() / (((i16 - getPaddingTop()) - getPaddingBottom()) + i18)) * (((i3 - getPaddingTop()) - getPaddingBottom()) + i17));
            scrollTo(getScrollX(), scrollY);
            if (!this.G.isFinished()) {
                int duration = this.G.getDuration() - this.G.timePassed();
                c w3 = w(this.C);
                if (w3 != null) {
                    this.G.startScroll(0, scrollY, 0, (int) (w3.f271108e * i3), duration);
                    return;
                }
                return;
            }
            return;
        }
        c w16 = w(this.C);
        if (w16 != null) {
            f16 = Math.min(w16.f271108e, this.N);
        } else {
            f16 = 0.0f;
        }
        int paddingTop = (int) (f16 * ((i3 - getPaddingTop()) - getPaddingBottom()));
        if (paddingTop != getScrollY()) {
            j(false);
            scrollTo(getScrollX(), paddingTop);
        }
    }

    private void J() {
        int i3 = 0;
        while (i3 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i3).getLayoutParams()).f271095a) {
                removeViewAt(i3);
                i3--;
            }
            i3++;
        }
    }

    private void K(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void L(int i3, boolean z16, int i16, boolean z17) {
        int i17;
        ViewPager.OnPageChangeListener onPageChangeListener;
        com.tencent.mobileqq.qqlive.base.room.multipage.controller.a aVar;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        c w3 = w(i3);
        if (w3 != null) {
            i17 = (int) (r() * Math.max(this.M, Math.min(w3.f271108e, this.N)));
        } else {
            i17 = 0;
        }
        if (z16) {
            R(0, i17, i16);
            com.tencent.mobileqq.qqlive.base.room.multipage.controller.a aVar2 = this.f271088u0;
            if (aVar2 != null) {
                if (z17) {
                    aVar2.onPageSelected(i3);
                } else if (i3 == 0) {
                    aVar2.t1();
                } else if (i3 == this.f271079m.getF373114d() - 1) {
                    this.f271088u0.y0();
                }
            }
            if (z17 && (onPageChangeListener2 = this.f271089v0) != null) {
                onPageChangeListener2.onPageSelected(i3);
                return;
            }
            return;
        }
        if (z17 && (aVar = this.f271088u0) != null) {
            aVar.onPageSelected(i3);
        }
        if (z17 && (onPageChangeListener = this.f271089v0) != null) {
            onPageChangeListener.onPageSelected(i3);
        }
        j(false);
        scrollTo(0, i17);
        D(i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i3) {
        boolean z16;
        if (this.C0 == i3) {
            return;
        }
        this.C0 = i3;
        if (this.f271090w0 != null) {
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            n(z16);
        }
        com.tencent.mobileqq.qqlive.base.room.multipage.controller.a aVar = this.f271088u0;
        if (aVar != null) {
            aVar.onPageScrollStateChanged(i3);
        }
    }

    private void Q(boolean z16) {
        if (this.S != z16) {
            this.S = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (this.f271092y0 != 0) {
            ArrayList<View> arrayList = this.f271093z0;
            if (arrayList == null) {
                this.f271093z0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.f271093z0.add(getChildAt(i3));
            }
            Collections.sort(this.f271093z0, H0);
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
        int f373114d = this.f271079m.getF373114d();
        int r16 = r();
        if (r16 > 0) {
            f16 = this.I / r16;
        } else {
            f16 = 0.0f;
        }
        if (cVar2 != null) {
            int i18 = cVar2.f271105b;
            int i19 = cVar.f271105b;
            if (i18 < i19) {
                float f19 = cVar2.f271108e + cVar2.f271107d + f16;
                int i26 = i18 + 1;
                int i27 = 0;
                while (i26 <= cVar.f271105b && i27 < this.f271069f.size()) {
                    c cVar5 = this.f271069f.get(i27);
                    while (true) {
                        cVar4 = cVar5;
                        if (i26 <= cVar4.f271105b || i27 >= this.f271069f.size() - 1) {
                            break;
                        }
                        i27++;
                        cVar5 = this.f271069f.get(i27);
                    }
                    while (i26 < cVar4.f271105b) {
                        f19 += this.f271079m.getPageWidth(i26) + f16;
                        i26++;
                    }
                    cVar4.f271108e = f19;
                    f19 += cVar4.f271107d + f16;
                    i26++;
                }
            } else if (i18 > i19) {
                int size = this.f271069f.size() - 1;
                float f26 = cVar2.f271108e;
                while (true) {
                    i18--;
                    if (i18 < cVar.f271105b || size < 0) {
                        break;
                    }
                    c cVar6 = this.f271069f.get(size);
                    while (true) {
                        cVar3 = cVar6;
                        if (i18 >= cVar3.f271105b || size <= 0) {
                            break;
                        }
                        size--;
                        cVar6 = this.f271069f.get(size);
                    }
                    while (i18 > cVar3.f271105b) {
                        f26 -= this.f271079m.getPageWidth(i18) + f16;
                        i18--;
                    }
                    f26 -= cVar3.f271107d + f16;
                    cVar3.f271108e = f26;
                }
            }
        }
        int size2 = this.f271069f.size();
        float f27 = cVar.f271108e;
        int i28 = cVar.f271105b;
        int i29 = i28 - 1;
        if (i28 == 0) {
            f17 = f27;
        } else {
            f17 = -3.4028235E38f;
        }
        this.M = f17;
        int i36 = f373114d - 1;
        if (i28 == i36) {
            f18 = (cVar.f271107d + f27) - 1.0f;
        } else {
            f18 = Float.MAX_VALUE;
        }
        this.N = f18;
        int i37 = i3 - 1;
        while (i37 >= 0) {
            c cVar7 = this.f271069f.get(i37);
            while (true) {
                i17 = cVar7.f271105b;
                if (i29 <= i17) {
                    break;
                }
                f27 -= this.f271079m.getPageWidth(i29) + f16;
                i29--;
            }
            f27 -= cVar7.f271107d + f16;
            cVar7.f271108e = f27;
            if (i17 == 0) {
                this.M = f27;
            }
            i37--;
            i29--;
        }
        float f28 = cVar.f271108e + cVar.f271107d + f16;
        int i38 = cVar.f271105b + 1;
        int i39 = i3 + 1;
        while (i39 < size2) {
            c cVar8 = this.f271069f.get(i39);
            while (true) {
                i16 = cVar8.f271105b;
                if (i38 >= i16) {
                    break;
                }
                f28 += this.f271079m.getPageWidth(i38) + f16;
                i38++;
            }
            if (i16 == i36) {
                this.N = (cVar8.f271107d + f28) - 1.0f;
            }
            cVar8.f271108e = f28;
            f28 += cVar8.f271107d + f16;
            i39++;
            i38++;
        }
        this.f271085r0 = false;
    }

    private void j(boolean z16) {
        boolean z17;
        if (this.C0 == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Q(false);
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
        for (int i3 = 0; i3 < this.f271069f.size(); i3++) {
            c cVar = this.f271069f.get(i3);
            if (cVar.f271106c) {
                cVar.f271106c = false;
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
        if (Math.abs(i17) > this.f271078l0 && Math.abs(i16) > this.f271076j0) {
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
        if (this.f271069f.size() > 0) {
            return Math.max(this.f271069f.get(0).f271105b, Math.min(i3, this.f271069f.get(r4.size() - 1).f271105b));
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
        VelocityTracker velocityTracker = this.f271075i0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f271075i0 = null;
        }
    }

    private Rect q(Rect rect, View view) {
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

    private int r() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fb, code lost:
    
        if (r5 != r9.f271105b) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00fd, code lost:
    
        r4 = r4 + r9.f271107d;
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0108, code lost:
    
        if (r8 >= r14.f271069f.size()) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010a, code lost:
    
        r9 = r14.f271069f.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x006c, code lost:
    
        if (r10 != r9.f271105b) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x006e, code lost:
    
        r11 = r11 + r9.f271107d;
        r4 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0073, code lost:
    
        if (r4 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0075, code lost:
    
        r9 = r14.f271069f.get(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void s(c cVar, int i3, int i16, int i17, c cVar2, int i18) {
        c cVar3;
        float paddingLeft;
        c cVar4;
        if (cVar != null) {
            int i19 = i16 - 1;
            if (i19 >= 0) {
                cVar3 = this.f271069f.get(i19);
            } else {
                cVar3 = null;
            }
            int r16 = r();
            float f16 = 0.0f;
            if (r16 <= 0) {
                paddingLeft = 0.0f;
            } else {
                paddingLeft = (2.0f - cVar.f271107d) + (getPaddingLeft() / r16);
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
                    if (i26 == cVar5.f271105b && !cVar5.f271106c) {
                        this.f271069f.remove(i27);
                        this.f271079m.destroyItem((ViewGroup) this, i26, cVar5.f271104a);
                        i27--;
                        i28--;
                        if (i27 >= 0) {
                            cVar5 = this.f271069f.get(i27);
                        }
                        cVar5 = null;
                    }
                    i26--;
                }
                f17 += f(i26, i27 + 1).f271107d;
                i28++;
                if (i27 >= 0) {
                    cVar5 = this.f271069f.get(i27);
                    i26--;
                }
                cVar5 = null;
                i26--;
            }
            float f18 = cVar.f271107d;
            int i29 = i28 + 1;
            if (f18 < 2.0f) {
                if (i29 < this.f271069f.size()) {
                    cVar4 = this.f271069f.get(i29);
                } else {
                    cVar4 = null;
                }
                if (r16 > 0) {
                    f16 = (getPaddingRight() / r16) + 2.0f;
                }
                int i36 = this.C + 1;
                while (i36 < i18) {
                    if (f18 >= f16 && i36 > i17) {
                        if (cVar4 == null) {
                            break;
                        }
                        if (i36 == cVar4.f271105b && !cVar4.f271106c) {
                            this.f271069f.remove(i29);
                            this.f271079m.destroyItem((ViewGroup) this, i36, cVar4.f271104a);
                            if (i29 < this.f271069f.size()) {
                                cVar4 = this.f271069f.get(i29);
                            }
                            cVar4 = null;
                        }
                        i36++;
                    }
                    c f19 = f(i36, i29);
                    i29++;
                    f18 += f19.f271107d;
                    if (i29 < this.f271069f.size()) {
                        cVar4 = this.f271069f.get(i29);
                        i36++;
                    }
                    cVar4 = null;
                    i36++;
                }
            }
            h(cVar, i28, cVar2);
        }
    }

    private c v() {
        float f16;
        float f17;
        int i3;
        int r16 = r();
        float f18 = 0.0f;
        if (r16 > 0) {
            f16 = getScrollY() / r16;
        } else {
            f16 = 0.0f;
        }
        if (r16 > 0) {
            f17 = this.I / r16;
        } else {
            f17 = 0.0f;
        }
        int i16 = 0;
        boolean z16 = true;
        c cVar = null;
        int i17 = -1;
        float f19 = 0.0f;
        while (i16 < this.f271069f.size()) {
            c cVar2 = this.f271069f.get(i16);
            if (!z16 && cVar2.f271105b != (i3 = i17 + 1)) {
                cVar2 = this.f271072h;
                cVar2.f271108e = f18 + f19 + f17;
                cVar2.f271105b = i3;
                cVar2.f271107d = this.f271079m.getPageWidth(i3);
                i16--;
            }
            c cVar3 = cVar2;
            f18 = cVar3.f271108e;
            float f26 = cVar3.f271107d + f18 + f17;
            if (!z16 && f16 < f18) {
                return cVar;
            }
            if (f16 >= f26 && i16 != this.f271069f.size() - 1) {
                int i18 = cVar3.f271105b;
                float f27 = cVar3.f271107d;
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

    private boolean z(float f16, float f17) {
        if ((f16 < this.f271063b0 && f17 > 0.0f) || (f16 > getHeight() - this.f271063b0 && f17 < 0.0f)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void A(int i3, float f16, int i16) {
        int max;
        int i17;
        int top;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        if (this.f271087t0 > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f271095a) {
                    int i19 = layoutParams.f271096b & 112;
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
        com.tencent.mobileqq.qqlive.base.room.multipage.controller.a aVar = this.f271088u0;
        if (aVar != null) {
            aVar.onPageScrolled(i3, f16, i16);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f271089v0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f16, i16);
        }
        if (this.f271090w0 != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i27 = 0; i27 < childCount2; i27++) {
                View childAt2 = getChildAt(i27);
                if (!((LayoutParams) childAt2.getLayoutParams()).f271095a) {
                    this.f271090w0.transformPage(childAt2, (childAt2.getTop() - scrollY2) / r());
                }
            }
        }
        this.f271086s0 = true;
    }

    boolean C() {
        PagerAdapter pagerAdapter = this.f271079m;
        if (pagerAdapter != null && this.C < pagerAdapter.getF373114d() - 1) {
            setCurrentItem(this.C + 1, true);
            return true;
        }
        return false;
    }

    boolean E() {
        int i3 = this.C;
        if (i3 > 0) {
            setCurrentItem(i3 - 1, true);
            return true;
        }
        return false;
    }

    void G() {
        H(this.C);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
    
        if (r4 == r5) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H(int i3) {
        int i16;
        c cVar;
        String hexString;
        c cVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        int i17 = this.C;
        Object obj = null;
        if (i17 != i3) {
            if (i17 < i3) {
                i16 = 130;
            } else {
                i16 = 33;
            }
            c w3 = w(i17);
            this.C = i3;
            cVar = w3;
        } else {
            i16 = 2;
            cVar = null;
        }
        if (this.f271079m == null) {
            S();
            return;
        }
        if (this.T) {
            QLog.i("ViewPager", 1, "populate is pending, skipping for now...");
            S();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.f271079m.startUpdate((ViewGroup) this);
        int i18 = this.U;
        int max = Math.max(0, this.C - i18);
        int f373114d = this.f271079m.getF373114d();
        int min = Math.min(f373114d - 1, this.C + i18);
        if (f373114d == this.f271067e) {
            int i19 = 0;
            while (true) {
                if (i19 >= this.f271069f.size()) {
                    break;
                }
                cVar2 = this.f271069f.get(i19);
                int i26 = cVar2.f271105b;
                int i27 = this.C;
                if (i26 < i27) {
                    i19++;
                }
            }
            if (cVar2 == null && f373114d > 0) {
                cVar2 = f(this.C, i19);
            }
            s(cVar2, max, i19, min, cVar, f373114d);
            if (QLog.isColorLevel()) {
                for (int i28 = 0; i28 < this.f271069f.size(); i28++) {
                    QLog.i("ViewPager", 2, "#" + i28 + ": page " + this.f271069f.get(i28).f271105b);
                }
            }
            PagerAdapter pagerAdapter = this.f271079m;
            int i29 = this.C;
            if (cVar2 != null) {
                obj = cVar2.f271104a;
            }
            pagerAdapter.setPrimaryItem((ViewGroup) this, i29, obj);
            Runnable runnable = new Runnable(i16) { // from class: com.tencent.mobileqq.qqlive.base.room.multipage.controller.VerticalViewPager.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f271094d;

                {
                    this.f271094d = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VerticalViewPager.this, i16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar3;
                    c u16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    VerticalViewPager.this.f271079m.finishUpdate((ViewGroup) VerticalViewPager.this);
                    int childCount = VerticalViewPager.this.getChildCount();
                    for (int i36 = 0; i36 < childCount; i36++) {
                        View childAt = VerticalViewPager.this.getChildAt(i36);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        layoutParams.f271100f = i36;
                        if (!layoutParams.f271095a && layoutParams.f271097c == 0.0f && (u16 = VerticalViewPager.this.u(childAt)) != null) {
                            layoutParams.f271097c = u16.f271107d;
                            layoutParams.f271099e = u16.f271105b;
                        }
                    }
                    VerticalViewPager.this.S();
                    if (VerticalViewPager.this.hasFocus()) {
                        View findFocus = VerticalViewPager.this.findFocus();
                        if (findFocus != null) {
                            cVar3 = VerticalViewPager.this.t(findFocus);
                        } else {
                            cVar3 = null;
                        }
                        if (cVar3 == null || cVar3.f271105b != VerticalViewPager.this.C) {
                            for (int i37 = 0; i37 < VerticalViewPager.this.getChildCount(); i37++) {
                                View childAt2 = VerticalViewPager.this.getChildAt(i37);
                                c u17 = VerticalViewPager.this.u(childAt2);
                                if (u17 != null && u17.f271105b == VerticalViewPager.this.C && childAt2.requestFocus(this.f271094d)) {
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
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f271067e + ", found: " + f373114d + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f271079m.getClass());
    }

    void M(boolean z16) {
        if (this.f271091x0 == null) {
            try {
                this.f271091x0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e16) {
                QLog.e("ViewPager", 1, "Can't find setChildrenDrawingOrderEnabled", e16);
            }
        }
        try {
            Method method = this.f271091x0;
            if (method != null) {
                method.invoke(this, Boolean.valueOf(z16));
            }
        } catch (Exception e17) {
            QLog.e("ViewPager", 1, "Error changing children drawing order", e17);
        }
    }

    void N(int i3, boolean z16, boolean z17) {
        O(i3, z16, z17, 0);
    }

    void O(int i3, boolean z16, boolean z17, int i16) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        com.tencent.mobileqq.qqlive.base.room.multipage.controller.a aVar;
        PagerAdapter pagerAdapter = this.f271079m;
        boolean z18 = false;
        if (pagerAdapter != null && pagerAdapter.getF373114d() > 0) {
            if (!z17 && this.C == i3 && this.f271069f.size() != 0) {
                Q(false);
                return;
            }
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 >= this.f271079m.getF373114d()) {
                i3 = this.f271079m.getF373114d() - 1;
            }
            int i17 = this.U;
            int i18 = this.C;
            if (i3 > i18 + i17 || i3 < i18 - i17) {
                for (int i19 = 0; i19 < this.f271069f.size(); i19++) {
                    this.f271069f.get(i19).f271106c = true;
                }
            }
            if (this.C != i3) {
                z18 = true;
            }
            if (this.f271084q0) {
                this.C = i3;
                if (z18 && (aVar = this.f271088u0) != null) {
                    aVar.onPageSelected(i3);
                }
                if (z18 && (onPageChangeListener = this.f271089v0) != null) {
                    onPageChangeListener.onPageSelected(i3);
                }
                requestLayout();
                return;
            }
            if (i3 == 0) {
                H(i3);
                L(i3, z16, i16, z18);
                return;
            } else {
                L(i3, z16, i16, z18);
                H(i3);
                return;
            }
        }
        Q(false);
    }

    void R(int i3, int i16, int i17) {
        int abs;
        if (getChildCount() == 0) {
            Q(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i18 = i3 - scrollX;
        int i19 = i16 - scrollY;
        if (i18 == 0 && i19 == 0) {
            j(false);
            G();
            P(0);
            return;
        }
        Q(true);
        P(2);
        int r16 = r();
        int i26 = r16 / 2;
        float f16 = r16;
        float f17 = i26;
        float m3 = f17 + (m(Math.min(1.0f, (Math.abs(i18) * 1.0f) / f16)) * f17);
        int abs2 = Math.abs(i17);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(m3 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i18) / ((f16 * this.f271079m.getPageWidth(this.C)) + this.I)) + 5.0f) * 100.0f);
        }
        this.G.startScroll(scrollX, scrollY, i18, i19, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        c u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, arrayList, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() == 0 && (u16 = u(childAt)) != null && u16.f271105b == this.C) {
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
        c u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) arrayList);
            return;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (u16 = u(childAt)) != null && u16.f271105b == this.C) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, view, Integer.valueOf(i3), layoutParams);
            return;
        }
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z16 = false | layoutParams2.f271095a;
        layoutParams2.f271095a = z16;
        if (this.R) {
            if (!z16) {
                layoutParams2.f271098d = true;
                addViewInLayout(view, i3, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i3, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this, (Object) layoutParams)).booleanValue();
        }
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (!this.G.isFinished() && this.G.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.G.getCurrX();
            int currY = this.G.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!D(currY)) {
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (!super.dispatchKeyEvent(keyEvent) && !p(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        c u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, (Object) accessibilityEvent)).booleanValue();
        }
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (u16 = u(childAt)) != null && u16.f271105b == this.C && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z16 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f271079m) == null || pagerAdapter.getF373114d() <= 1)) {
            this.f271082o0.finish();
            this.f271083p0.finish();
        } else {
            if (!this.f271082o0.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.M * height);
                this.f271082o0.setSize(width, height);
                z16 = false | this.f271082o0.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f271083p0.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.N + 1.0f)) * height2);
                this.f271083p0.setSize(width2, height2);
                z16 |= this.f271083p0.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.drawableStateChanged();
        Drawable drawable = this.J;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    c f(int i3, int i16) {
        c cVar = new c();
        cVar.f271105b = i3;
        cVar.f271104a = this.f271079m.instantiateItem((ViewGroup) this, i3);
        cVar.f271107d = this.f271079m.getPageWidth(i3);
        if (i16 >= 0 && i16 < this.f271069f.size()) {
            this.f271069f.add(i16, cVar);
        } else {
            this.f271069f.add(cVar);
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(int i3) {
        boolean z16;
        View findNextFocus;
        boolean requestFocus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this, i3)).booleanValue();
        }
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
                    int i16 = q(this.f271074i, findNextFocus).top;
                    int i17 = q(this.f271074i, findFocus).top;
                    if (findFocus != null && i16 >= i17) {
                        requestFocus = E();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                } else if (i3 == 130) {
                    int i18 = q(this.f271074i, findNextFocus).bottom;
                    int i19 = q(this.f271074i, findFocus).bottom;
                    if (findFocus != null && i18 <= i19) {
                        requestFocus = C();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                }
                z17 = requestFocus;
            } else if (i3 == 33 && i3 != 1) {
                if (i3 == 130 || i3 == 2) {
                    z17 = C();
                }
            } else {
                z17 = E();
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
        z17 = E();
        if (z17) {
        }
        return z17;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) ? generateDefaultLayoutParams() : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 49, (Object) this, (Object) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (this.f271092y0 == 2) {
            i16 = (i3 - 1) - i16;
        }
        return ((LayoutParams) this.f271093z0.get(i16).getLayoutParams()).f271100f;
    }

    protected boolean i(View view, boolean z16, int i3, int i16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, this, view, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
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
        int f373114d = this.f271079m.getF373114d();
        this.f271067e = f373114d;
        if (this.f271069f.size() < (this.U * 2) + 1 && this.f271069f.size() < f373114d) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.C;
        int i16 = 0;
        boolean z17 = false;
        while (i16 < this.f271069f.size()) {
            c cVar = this.f271069f.get(i16);
            int itemPosition = this.f271079m.getItemPosition(cVar.f271104a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f271069f.remove(i16);
                    i16--;
                    if (!z17) {
                        this.f271079m.startUpdate((ViewGroup) this);
                        z17 = true;
                    }
                    this.f271079m.destroyItem((ViewGroup) this, cVar.f271105b, cVar.f271104a);
                    int i17 = this.C;
                    if (i17 == cVar.f271105b) {
                        i3 = Math.max(0, Math.min(i17, f373114d - 1));
                    }
                } else {
                    int i18 = cVar.f271105b;
                    if (i18 != itemPosition) {
                        if (i18 == this.C) {
                            i3 = itemPosition;
                        }
                        cVar.f271105b = itemPosition;
                    }
                }
                z16 = true;
            }
            i16++;
        }
        if (z17) {
            this.f271079m.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f271069f, F0);
        if (z16) {
            int childCount = getChildCount();
            for (int i19 = 0; i19 < childCount; i19++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i19).getLayoutParams();
                if (!layoutParams.f271095a) {
                    layoutParams.f271097c = 0.0f;
                }
            }
            N(i3, false, true);
            requestLayout();
        }
    }

    float m(float f16) {
        return (float) Math.sin((float) ((f16 - 0.5f) * 0.4712389167638204d));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.f271084q0 = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            removeCallbacks(this.B0);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        float f16;
        float f17;
        float f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.I > 0 && this.J != null && this.f271069f.size() > 0 && this.f271079m != null) {
            int scrollY = getScrollY();
            float height = getHeight();
            float f19 = this.I / height;
            int i16 = 0;
            c cVar = this.f271069f.get(0);
            float f26 = cVar.f271108e;
            int size = this.f271069f.size();
            int i17 = cVar.f271105b;
            int i18 = this.f271069f.get(size - 1).f271105b;
            while (i17 < i18) {
                while (true) {
                    i3 = cVar.f271105b;
                    if (i17 <= i3 || i16 >= size) {
                        break;
                    }
                    i16++;
                    cVar = this.f271069f.get(i16);
                }
                if (i17 == i3) {
                    float f27 = cVar.f271108e;
                    float f28 = cVar.f271107d;
                    f16 = (f27 + f28) * height;
                    f26 = f27 + f28 + f19;
                } else {
                    float pageWidth = this.f271079m.getPageWidth(i17);
                    f16 = (f26 + pageWidth) * height;
                    f26 += pageWidth + f19;
                }
                int i19 = this.I;
                if (i19 + f16 > scrollY) {
                    f17 = f19;
                    f18 = height;
                    this.J.setBounds(this.K, (int) f16, this.L, (int) (i19 + f16 + 0.5f));
                    this.J.draw(canvas);
                } else {
                    f17 = f19;
                    f18 = height;
                }
                if (f16 <= scrollY + r3) {
                    i17++;
                    f19 = f17;
                    height = f18;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.V) {
                    QLog.d("ViewPager", 4, "Intercept returning true!");
                    return true;
                }
                if (this.W) {
                    QLog.i("ViewPager", 1, "Intercept returning false!");
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        B(motionEvent);
                    }
                } else {
                    int i3 = this.f271073h0;
                    if (i3 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i3);
                        float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float f17 = y16 - this.f271068e0;
                        float abs = Math.abs(f17);
                        float x16 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(x16 - this.f271070f0);
                        if (this.f271065d && abs >= ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                            this.V = true;
                        } else {
                            if (f17 != 0.0f && !z(this.f271068e0, f17) && i(this, false, (int) f17, (int) x16, (int) y16)) {
                                this.f271066d0 = x16;
                                this.f271068e0 = y16;
                                this.W = true;
                                return false;
                            }
                            int i16 = this.f271064c0;
                            if (abs > i16 && abs * 0.5f > abs2) {
                                this.V = true;
                                K(true);
                                P(1);
                                if (f17 > 0.0f) {
                                    f16 = this.f271071g0 + this.f271064c0;
                                } else {
                                    f16 = this.f271071g0 - this.f271064c0;
                                }
                                this.f271068e0 = f16;
                                this.f271066d0 = x16;
                                Q(true);
                            } else if (abs2 > i16) {
                                this.W = true;
                            }
                            if (this.V && F(y16)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    }
                }
            } else {
                float x17 = motionEvent.getX();
                this.f271070f0 = x17;
                this.f271066d0 = x17;
                float y17 = motionEvent.getY();
                this.f271071g0 = y17;
                this.f271068e0 = y17;
                this.f271073h0 = MotionEventCompat.getPointerId(motionEvent, 0);
                this.W = false;
                this.G.computeScrollOffset();
                if (this.C0 == 2 && Math.abs(this.G.getFinalY() - this.G.getCurrY()) > this.f271080m0) {
                    this.G.abortAnimation();
                    this.T = false;
                    G();
                    this.V = true;
                    K(true);
                    P(1);
                } else {
                    j(false);
                    this.V = false;
                }
            }
            if (this.f271075i0 == null) {
                this.f271075i0 = VelocityTracker.obtain();
            }
            this.f271075i0.addMovement(motionEvent);
            return this.V;
        }
        QLog.d("ViewPager", 4, "Intercept done!");
        this.V = false;
        this.W = false;
        this.f271073h0 = -1;
        VelocityTracker velocityTracker = this.f271075i0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f271075i0 = null;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        c u16;
        int max;
        int i19;
        int max2;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 3;
        int i28 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int childCount = getChildCount();
        int i29 = i17 - i3;
        int i36 = i18 - i16;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i37 = 0;
        int i38 = 0;
        while (i37 < childCount) {
            View childAt = getChildAt(i37);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f271095a) {
                    int i39 = layoutParams.f271096b;
                    int i46 = i39 & 7;
                    int i47 = i39 & 112;
                    if (i46 == i28) {
                        max = Math.max((i29 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i46 == i27) {
                            i19 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i46 != 5) {
                            i19 = paddingLeft;
                        } else {
                            max = (i29 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i47 != 16) {
                            max2 = Math.max((i36 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i47 == 48) {
                                i26 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i47 != 80) {
                                i26 = paddingTop;
                            } else {
                                max2 = (i36 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i48 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i48, paddingLeft + childAt.getMeasuredWidth(), i48 + childAt.getMeasuredHeight());
                            i38++;
                            paddingTop = i26;
                            paddingLeft = i19;
                        }
                        int i49 = paddingTop;
                        paddingTop = max2;
                        i26 = i49;
                        int i482 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i482, paddingLeft + childAt.getMeasuredWidth(), i482 + childAt.getMeasuredHeight());
                        i38++;
                        paddingTop = i26;
                        paddingLeft = i19;
                    }
                    int i56 = paddingLeft;
                    paddingLeft = max;
                    i19 = i56;
                    if (i47 != 16) {
                    }
                    int i492 = paddingTop;
                    paddingTop = max2;
                    i26 = i492;
                    int i4822 = paddingTop + scrollY;
                    childAt.layout(paddingLeft, i4822, paddingLeft + childAt.getMeasuredWidth(), i4822 + childAt.getMeasuredHeight());
                    i38++;
                    paddingTop = i26;
                    paddingLeft = i19;
                }
            }
            i37++;
            i27 = 3;
            i28 = 1;
        }
        int i57 = (i36 - paddingTop) - paddingBottom;
        for (int i58 = 0; i58 < childCount; i58++) {
            View childAt2 = getChildAt(i58);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f271095a && (u16 = u(childAt2)) != null) {
                    float f16 = i57;
                    int i59 = ((int) (u16.f271108e * f16)) + paddingTop;
                    if (layoutParams2.f271098d) {
                        layoutParams2.f271098d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i29 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f16 * layoutParams2.f271097c), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i59, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i59);
                }
            }
        }
        this.K = paddingLeft;
        this.L = i29 - paddingRight;
        this.f271087t0 = i38;
        if (this.f271084q0) {
            z17 = false;
            L(this.C, false, 0, false);
        } else {
            z17 = false;
        }
        this.f271084q0 = z17;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z16;
        boolean z17;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 3;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i16));
        int measuredHeight = getMeasuredHeight();
        this.f271063b0 = Math.min(measuredHeight / 10, this.f271062a0);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i19 = 0;
        while (true) {
            int i26 = 1073741824;
            if (i19 >= childCount) {
                break;
            }
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f271095a) {
                int i27 = layoutParams2.f271096b;
                int i28 = i27 & 7;
                int i29 = i27 & 112;
                if (i29 != 48 && i29 != 80) {
                    z16 = z18;
                } else {
                    z16 = true;
                }
                if (i28 != i18 && i28 != 5) {
                    z17 = z18;
                } else {
                    z17 = true;
                }
                int i36 = Integer.MIN_VALUE;
                if (z16) {
                    i17 = Integer.MIN_VALUE;
                    i36 = 1073741824;
                } else if (z17) {
                    i17 = 1073741824;
                } else {
                    i17 = Integer.MIN_VALUE;
                }
                int i37 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i37 != -2) {
                    if (i37 == -1) {
                        i37 = measuredWidth;
                    }
                    i36 = 1073741824;
                } else {
                    i37 = measuredWidth;
                }
                int i38 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i38 != -2) {
                    if (i38 == -1) {
                        i38 = paddingTop;
                    }
                } else {
                    i38 = paddingTop;
                    i26 = i17;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i37, i36), View.MeasureSpec.makeMeasureSpec(i38, i26));
                if (z16) {
                    paddingTop -= childAt.getMeasuredHeight();
                } else if (z17) {
                    measuredWidth -= childAt.getMeasuredWidth();
                }
            }
            i19++;
            i18 = 3;
            z18 = false;
        }
        this.P = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.Q = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.R = true;
        G();
        this.R = false;
        int childCount2 = getChildCount();
        for (int i39 = 0; i39 < childCount2; i39++) {
            View childAt2 = getChildAt(i39);
            if (childAt2.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt2.getLayoutParams()) != null && !layoutParams.f271095a) {
                childAt2.measure(this.P, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * layoutParams.f271097c), 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        int i16;
        int i17;
        int i18;
        c u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, i3, (Object) rect)).booleanValue();
        }
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
            if (childAt.getVisibility() == 0 && (u16 = u(childAt)) != null && u16.f271105b == this.C && childAt.requestFocus(i3, rect)) {
                return true;
            }
            i16 += i18;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) parcelable);
            return;
        }
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.f271079m;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f271102e, savedState.f271103f);
            N(savedState.f271101d, false, true);
        } else {
            this.D = savedState.f271101d;
            this.E = savedState.f271102e;
            this.F = savedState.f271103f;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Parcelable) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f271101d = this.C;
        PagerAdapter pagerAdapter = this.f271079m;
        if (pagerAdapter != null) {
            savedState.f271102e = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (i16 != i18) {
            int i19 = this.I;
            I(i16, i18, i19, i19);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        boolean onRelease;
        boolean onRelease2;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f271065d || this.f271081n0) {
            return true;
        }
        boolean z16 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f271079m) == null || pagerAdapter.getF373114d() == 0) {
            return false;
        }
        if (this.f271075i0 == null) {
            this.f271075i0 = VelocityTracker.obtain();
        }
        this.f271075i0.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                B(motionEvent);
                                this.f271068e0 = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f271073h0));
                            }
                        } else {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            this.f271068e0 = MotionEventCompat.getY(motionEvent, actionIndex);
                            this.f271073h0 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        }
                    } else if (this.V) {
                        L(this.C, true, 0, false);
                        this.f271073h0 = -1;
                        o();
                        onRelease = this.f271082o0.onRelease();
                        onRelease2 = this.f271083p0.onRelease();
                        z16 = onRelease | onRelease2;
                    }
                } else {
                    if (!this.V) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f271073h0);
                        float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float abs = Math.abs(y16 - this.f271068e0);
                        float x16 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(x16 - this.f271066d0);
                        if (abs > this.f271064c0 && abs > abs2) {
                            this.V = true;
                            K(true);
                            float f17 = this.f271071g0;
                            if (y16 - f17 > 0.0f) {
                                f16 = f17 + this.f271064c0;
                            } else {
                                f16 = f17 - this.f271064c0;
                            }
                            this.f271068e0 = f16;
                            this.f271066d0 = x16;
                            P(1);
                            Q(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.V) {
                        z16 = false | F(MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f271073h0)));
                    }
                }
            } else if (this.V) {
                VelocityTracker velocityTracker = this.f271075i0;
                velocityTracker.computeCurrentVelocity(1000, this.f271077k0);
                int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.f271073h0);
                this.T = true;
                int r16 = r();
                int scrollY = getScrollY();
                c v3 = v();
                if (v3 != null) {
                    O(l(v3.f271105b, ((scrollY / r16) - v3.f271108e) / v3.f271107d, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f271073h0)) - this.f271071g0)), true, true, yVelocity);
                }
                this.f271073h0 = -1;
                o();
                onRelease = this.f271082o0.onRelease();
                onRelease2 = this.f271083p0.onRelease();
                z16 = onRelease | onRelease2;
            }
        } else {
            this.G.abortAnimation();
            this.T = false;
            G();
            float x17 = motionEvent.getX();
            this.f271070f0 = x17;
            this.f271066d0 = x17;
            float y17 = motionEvent.getY();
            this.f271071g0 = y17;
            this.f271068e0 = y17;
            this.f271073h0 = MotionEventCompat.getPointerId(motionEvent, 0);
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public boolean p(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, (Object) keyEvent)).booleanValue();
        }
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

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
        } else if (this.R) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pagerAdapter);
            return;
        }
        PagerAdapter pagerAdapter2 = this.f271079m;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.H);
            this.f271079m.startUpdate((ViewGroup) this);
            for (int i3 = 0; i3 < this.f271069f.size(); i3++) {
                c cVar = this.f271069f.get(i3);
                this.f271079m.destroyItem((ViewGroup) this, cVar.f271105b, cVar.f271104a);
            }
            this.f271079m.finishUpdate((ViewGroup) this);
            this.f271069f.clear();
            J();
            this.C = 0;
            scrollTo(0, 0);
        }
        this.f271079m = pagerAdapter;
        this.f271067e = 0;
        if (pagerAdapter != null) {
            a aVar = null;
            if (this.H == null) {
                this.H = new e(this, aVar);
            }
            this.f271079m.registerDataSetObserver(this.H);
            this.T = false;
            boolean z16 = this.f271084q0;
            this.f271084q0 = true;
            this.f271067e = this.f271079m.getF373114d();
            if (this.D >= 0) {
                this.f271079m.restoreState(this.E, this.F);
                N(this.D, false, true);
                this.D = -1;
                this.E = null;
                this.F = null;
                return;
            }
            if (!z16) {
                G();
            } else {
                requestLayout();
            }
        }
    }

    public void setCurrentItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.T = false;
            N(i3, !this.f271084q0, false);
        }
    }

    public void setOffscreenPageLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (i3 < 1) {
            QLog.w("ViewPager", 1, "Requested offscreen page limit " + i3 + " too small; defaulting to 1");
            i3 = 1;
        }
        if (i3 != this.U) {
            this.U = i3;
            G();
        }
    }

    public void setOnPageChangeListener(com.tencent.mobileqq.qqlive.base.room.multipage.controller.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            this.f271088u0 = aVar;
        }
    }

    public void setPageMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        int i16 = this.I;
        this.I = i3;
        int height = getHeight();
        I(height, height, i3, i16);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) drawable);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), pageTransformer);
            return;
        }
        if (pageTransformer != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.f271090w0 != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 != z18) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.f271090w0 = pageTransformer;
        M(z17);
        if (z17) {
            if (!z16) {
                i3 = 1;
            }
            this.f271092y0 = i3;
        } else {
            this.f271092y0 = 0;
        }
        if (z19) {
            G();
        }
    }

    public void setScrollForbidden(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, z16);
        } else {
            this.f271065d = z16;
        }
    }

    c t(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view = (View) parent;
                } else {
                    return null;
                }
            } else {
                return u(view);
            }
        }
    }

    c u(View view) {
        for (int i3 = 0; i3 < this.f271069f.size(); i3++) {
            c cVar = this.f271069f.get(i3);
            if (this.f271079m.isViewFromObject(view, cVar.f271104a)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) drawable)).booleanValue();
        }
        if (!super.verifyDrawable(drawable) && drawable != this.J) {
            return false;
        }
        return true;
    }

    c w(int i3) {
        for (int i16 = 0; i16 < this.f271069f.size(); i16++) {
            c cVar = this.f271069f.get(i16);
            if (cVar.f271105b == i3) {
                return cVar;
            }
        }
        return null;
    }

    void x() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.G = new Scroller(context, G0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.f271064c0 = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.f271076j0 = (int) (400.0f * f16);
        this.f271077k0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f271082o0 = new EdgeEffectCompat(context);
        this.f271083p0 = new EdgeEffectCompat(context);
        this.f271078l0 = (int) (25.0f * f16);
        this.f271080m0 = (int) (2.0f * f16);
        this.f271062a0 = (int) (f16 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public boolean y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, i3)).booleanValue();
        }
        if (this.f271079m == null) {
            return false;
        }
        int r16 = r();
        int scrollY = getScrollY();
        if (i3 < 0) {
            if (scrollY <= ((int) (r16 * this.M))) {
                return false;
            }
            return true;
        }
        if (i3 <= 0 || scrollY >= ((int) (r16 * this.N))) {
            return false;
        }
        return true;
    }

    /* loaded from: classes17.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f271095a;

        /* renamed from: b, reason: collision with root package name */
        public int f271096b;

        /* renamed from: c, reason: collision with root package name */
        float f271097c;

        /* renamed from: d, reason: collision with root package name */
        boolean f271098d;

        /* renamed from: e, reason: collision with root package name */
        int f271099e;

        /* renamed from: f, reason: collision with root package name */
        int f271100f;

        public LayoutParams() {
            super(-1, -1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f271097c = 0.0f;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
                return;
            }
            this.f271097c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.D0);
            this.f271096b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 51, (Object) this, (Object) attributeSet);
    }

    public void setCurrentItem(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.T = false;
            N(i3, z16, false);
        }
    }

    public void setPageMarginDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            setPageMarginDrawable(getContext().getResources().getDrawable(i3));
        } else {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f271065d = false;
        this.f271069f = new ArrayList<>();
        this.f271072h = new c();
        this.f271074i = new Rect();
        this.D = -1;
        this.E = null;
        this.F = null;
        this.M = -3.4028235E38f;
        this.N = Float.MAX_VALUE;
        this.U = 1;
        this.f271073h0 = -1;
        this.f271084q0 = true;
        this.f271085r0 = false;
        this.A0 = new Handler(Looper.getMainLooper());
        this.B0 = new Runnable() { // from class: com.tencent.mobileqq.qqlive.base.room.multipage.controller.VerticalViewPager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VerticalViewPager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    VerticalViewPager.this.P(0);
                    VerticalViewPager.this.G();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.C0 = 0;
        x();
    }
}
