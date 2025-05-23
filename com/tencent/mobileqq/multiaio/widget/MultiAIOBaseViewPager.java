package com.tencent.mobileqq.multiaio.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
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
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes15.dex */
public class MultiAIOBaseViewPager extends ViewGroup {
    static IPatchRedirector $redirector_;
    static final int[] I0;
    private static final Comparator<e> J0;
    private static final Interpolator K0;
    private i A0;
    private List<h> B0;
    private final e C;
    private int C0;
    private final Rect D;
    private int D0;
    PagerAdapter E;
    private ArrayList<View> E0;
    int F;
    private final l F0;
    private int G;
    private final Runnable G0;
    private Parcelable H;
    private int H0;
    private ClassLoader I;
    private Scroller J;
    private boolean K;
    private k L;
    private int M;
    private Drawable N;
    private int P;
    private int Q;
    private float R;
    private float S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f251435a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f251436b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f251437c0;

    /* renamed from: d, reason: collision with root package name */
    private int f251438d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f251439d0;

    /* renamed from: e, reason: collision with root package name */
    private int f251440e;

    /* renamed from: e0, reason: collision with root package name */
    private int f251441e0;

    /* renamed from: f, reason: collision with root package name */
    private Scroller f251442f;

    /* renamed from: f0, reason: collision with root package name */
    private int f251443f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f251444g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f251445h;

    /* renamed from: h0, reason: collision with root package name */
    private float f251446h0;

    /* renamed from: i, reason: collision with root package name */
    protected int f251447i;

    /* renamed from: i0, reason: collision with root package name */
    private float f251448i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f251449j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f251450k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f251451l0;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList<e> f251452m;

    /* renamed from: m0, reason: collision with root package name */
    private VelocityTracker f251453m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f251454n0;

    /* renamed from: o0, reason: collision with root package name */
    protected int f251455o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f251456p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f251457q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f251458r0;

    /* renamed from: s0, reason: collision with root package name */
    private EdgeEffect f251459s0;

    /* renamed from: t0, reason: collision with root package name */
    private EdgeEffect f251460t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f251461u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f251462v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f251463w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f251464x0;

    /* renamed from: y0, reason: collision with root package name */
    private List<i> f251465y0;

    /* renamed from: z0, reason: collision with root package name */
    private i f251466z0;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes15.dex */
    public @interface DecorView {
    }

    /* loaded from: classes15.dex */
    public static class SavedState extends AbsSavedState {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<SavedState> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        int f251473d;

        /* renamed from: e, reason: collision with root package name */
        Parcelable f251474e;

        /* renamed from: f, reason: collision with root package name */
        ClassLoader f251475f;

        /* loaded from: classes15.dex */
        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (SavedState) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
                }
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SavedState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, (Object) classLoader);
                }
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (SavedState[]) iPatchRedirector.redirect((short) 4, (Object) this, i3);
                }
                return new SavedState[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73156);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
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
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f251473d + "}";
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
                return;
            }
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f251473d);
            parcel.writeParcelable(this.f251474e, i3);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, (Object) classLoader);
                return;
            }
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f251473d = parcel.readInt();
            this.f251474e = parcel.readParcelable(classLoader);
            this.f251475f = classLoader;
        }
    }

    /* loaded from: classes15.dex */
    class a implements Comparator<e> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e eVar, e eVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) eVar2)).intValue();
            }
            return eVar.f251479b - eVar2.f251479b;
        }
    }

    /* loaded from: classes15.dex */
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
    /* loaded from: classes15.dex */
    public class c implements OnApplyWindowInsetsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f251476d;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiAIOBaseViewPager.this);
            } else {
                this.f251476d = new Rect();
            }
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WindowInsetsCompat) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) windowInsetsCompat);
            }
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (onApplyWindowInsets.isConsumed()) {
                return onApplyWindowInsets;
            }
            Rect rect = this.f251476d;
            rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = MultiAIOBaseViewPager.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(MultiAIOBaseViewPager.this.getChildAt(i3), onApplyWindowInsets);
                rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    /* loaded from: classes15.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Object f251478a;

        /* renamed from: b, reason: collision with root package name */
        int f251479b;

        /* renamed from: c, reason: collision with root package name */
        boolean f251480c;

        /* renamed from: d, reason: collision with root package name */
        float f251481d;

        /* renamed from: e, reason: collision with root package name */
        float f251482e;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes15.dex */
    static class f extends l {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final MultiAIOBaseViewPager f251483d;

        public f(MultiAIOBaseViewPager multiAIOBaseViewPager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) multiAIOBaseViewPager);
            } else {
                this.f251483d = multiAIOBaseViewPager;
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
            boolean z16 = layoutParams.f251467a;
            if (z16 != layoutParams2.f251467a) {
                if (!z16) {
                    return -1;
                }
                return 1;
            }
            int p16 = this.f251483d.p();
            int i3 = layoutParams.f251471e;
            if (p16 == i3) {
                return 1;
            }
            int i16 = layoutParams2.f251471e;
            if (p16 == i16) {
                return -1;
            }
            return i3 - i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class g extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiAIOBaseViewPager.this);
            }
        }

        private boolean canScroll() {
            PagerAdapter pagerAdapter = MultiAIOBaseViewPager.this.E;
            if (pagerAdapter != null && pagerAdapter.getF373114d() > 1) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityEvent);
                return;
            }
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(MultiAIOBaseViewPager.class.getName());
            accessibilityEvent.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = MultiAIOBaseViewPager.this.E) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.getF373114d());
                accessibilityEvent.setFromIndex(MultiAIOBaseViewPager.this.F);
                accessibilityEvent.setToIndex(MultiAIOBaseViewPager.this.F);
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
            accessibilityNodeInfoCompat.setClassName(MultiAIOBaseViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (MultiAIOBaseViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (MultiAIOBaseViewPager.this.canScrollHorizontally(-1)) {
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
                if (i3 != 8192 || !MultiAIOBaseViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                MultiAIOBaseViewPager multiAIOBaseViewPager = MultiAIOBaseViewPager.this;
                multiAIOBaseViewPager.setCurrentItem(multiAIOBaseViewPager.F - 1);
                return true;
            }
            if (!MultiAIOBaseViewPager.this.canScrollHorizontally(1)) {
                return false;
            }
            MultiAIOBaseViewPager multiAIOBaseViewPager2 = MultiAIOBaseViewPager.this;
            multiAIOBaseViewPager2.setCurrentItem(multiAIOBaseViewPager2.F + 1);
            return true;
        }
    }

    /* loaded from: classes15.dex */
    public interface h {
        void a(MultiAIOBaseViewPager multiAIOBaseViewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes15.dex */
    public interface i {
        void onPageScrollStateChanged(int i3);

        void onPageScrolled(int i3, float f16, int i16);

        void onPageSelected(int i3);
    }

    /* loaded from: classes15.dex */
    public interface j {
    }

    /* loaded from: classes15.dex */
    private class k extends DataSetObserver {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiAIOBaseViewPager.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MultiAIOBaseViewPager.this.f();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                MultiAIOBaseViewPager.this.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class l implements Comparator<View> {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73159);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 68)) {
            redirector.redirect((short) 68);
            return;
        }
        I0 = new int[]{R.attr.layout_gravity};
        J0 = new a();
        K0 = new b();
    }

    public MultiAIOBaseViewPager(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f251438d = 0;
        this.f251445h = true;
        this.f251452m = new ArrayList<>();
        this.C = new e();
        this.D = new Rect();
        this.G = -1;
        this.H = null;
        this.I = null;
        this.R = -3.4028235E38f;
        this.S = Float.MAX_VALUE;
        this.f251436b0 = 1;
        this.f251451l0 = -1;
        this.f251461u0 = true;
        this.f251462v0 = false;
        this.F0 = new f(this);
        this.G0 = new Runnable() { // from class: com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiAIOBaseViewPager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MultiAIOBaseViewPager.this.M(0);
                    MultiAIOBaseViewPager.this.D();
                }
            }
        };
        this.H0 = 0;
        u();
    }

    private boolean C(float f16) {
        boolean z16;
        boolean z17;
        float f17 = this.f251446h0 - f16;
        this.f251446h0 = f16;
        float scrollX = getScrollX() + f17;
        float o16 = o();
        float f18 = this.R * o16;
        float f19 = this.S * o16;
        boolean z18 = false;
        e eVar = this.f251452m.get(0);
        ArrayList<e> arrayList = this.f251452m;
        e eVar2 = arrayList.get(arrayList.size() - 1);
        if (eVar.f251479b != 0) {
            f18 = eVar.f251482e * o16;
            z16 = false;
        } else {
            z16 = true;
        }
        if (eVar2.f251479b != this.E.getF373114d() - 1) {
            f19 = eVar2.f251482e * o16;
            z17 = false;
        } else {
            z17 = true;
        }
        if (scrollX < f18) {
            if (z16) {
                this.f251459s0.onPull(Math.abs(f18 - scrollX) / o16);
                z18 = true;
            }
            scrollX = f18;
        } else if (scrollX > f19) {
            if (z17) {
                this.f251460t0.onPull(Math.abs(scrollX - f19) / o16);
                z18 = true;
            }
            scrollX = f19;
        }
        int i3 = (int) scrollX;
        this.f251446h0 += scrollX - i3;
        scrollTo(i3, getScrollY());
        B(i3);
        return z18;
    }

    private void F(int i3, int i16, int i17, int i18) {
        float f16;
        if (i16 > 0 && !this.f251452m.isEmpty()) {
            if (!this.J.isFinished()) {
                this.J.setFinalX(p() * o());
                return;
            }
            scrollTo((int) ((getScrollX() / (((i16 - getPaddingLeft()) - getPaddingRight()) + i18)) * (((i3 - getPaddingLeft()) - getPaddingRight()) + i17)), getScrollY());
            return;
        }
        e t16 = t(this.F);
        if (t16 != null) {
            f16 = Math.min(t16.f251482e, this.S);
        } else {
            f16 = 0.0f;
        }
        int paddingLeft = (int) (f16 * ((i3 - getPaddingLeft()) - getPaddingRight()));
        if (paddingLeft != getScrollX()) {
            e(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    private void G() {
        int i3 = 0;
        while (i3 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i3).getLayoutParams()).f251467a) {
                removeViewAt(i3);
                i3--;
            }
            i3++;
        }
    }

    private void H(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private boolean I() {
        if (QLog.isColorLevel()) {
            QLog.d("MultiAIOBaseViewPager", 2, "resetTouch() called");
        }
        this.f251451l0 = -1;
        l();
        this.f251459s0.onRelease();
        this.f251460t0.onRelease();
        if (!this.f251459s0.isFinished() && !this.f251460t0.isFinished()) {
            return false;
        }
        return true;
    }

    private void J(int i3, boolean z16, int i16, boolean z17) {
        int i17;
        e t16 = t(i3);
        if (t16 != null) {
            i17 = (int) (o() * Math.max(this.R, Math.min(t16.f251482e, this.S)));
        } else {
            i17 = 0;
        }
        if (z16) {
            P(i17, 0, i16);
            if (z17) {
                i(i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiAIOBaseViewPager", 2, "scrollToItem() called with: item = [" + i3 + "], smoothScroll = [" + z16 + "], velocity = [" + i16 + "], dispatchSelected = [" + z17 + "]");
                return;
            }
            return;
        }
        if (z17) {
            i(i3);
        }
        e(false);
        scrollTo(i17, 0);
        B(i17);
    }

    static void O(PagerAdapter pagerAdapter, DataSetObserver dataSetObserver) {
        try {
            Method declaredMethod = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", DataSetObserver.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(pagerAdapter, dataSetObserver);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void c(e eVar, int i3, e eVar2) {
        float f16;
        float f17;
        float f18;
        int i16;
        int i17;
        e eVar3;
        e eVar4;
        int f373114d = this.E.getF373114d();
        int o16 = o();
        if (o16 > 0) {
            f16 = this.M / o16;
        } else {
            f16 = 0.0f;
        }
        if (eVar2 != null) {
            int i18 = eVar2.f251479b;
            int i19 = eVar.f251479b;
            if (i18 < i19) {
                float f19 = eVar2.f251482e + eVar2.f251481d + f16;
                int i26 = i18 + 1;
                int i27 = 0;
                while (i26 <= eVar.f251479b && i27 < this.f251452m.size()) {
                    e eVar5 = this.f251452m.get(i27);
                    while (true) {
                        eVar4 = eVar5;
                        if (i26 <= eVar4.f251479b || i27 >= this.f251452m.size() - 1) {
                            break;
                        }
                        i27++;
                        eVar5 = this.f251452m.get(i27);
                    }
                    while (i26 < eVar4.f251479b) {
                        f19 += this.E.getPageWidth(i26) + f16;
                        i26++;
                    }
                    eVar4.f251482e = f19;
                    f19 += eVar4.f251481d + f16;
                    i26++;
                }
            } else if (i18 > i19) {
                int size = this.f251452m.size() - 1;
                float f26 = eVar2.f251482e;
                while (true) {
                    i18--;
                    if (i18 < eVar.f251479b || size < 0) {
                        break;
                    }
                    e eVar6 = this.f251452m.get(size);
                    while (true) {
                        eVar3 = eVar6;
                        if (i18 >= eVar3.f251479b || size <= 0) {
                            break;
                        }
                        size--;
                        eVar6 = this.f251452m.get(size);
                    }
                    while (i18 > eVar3.f251479b) {
                        f26 -= this.E.getPageWidth(i18) + f16;
                        i18--;
                    }
                    f26 -= eVar3.f251481d + f16;
                    eVar3.f251482e = f26;
                }
            }
        }
        int size2 = this.f251452m.size();
        float f27 = eVar.f251482e;
        int i28 = eVar.f251479b;
        int i29 = i28 - 1;
        if (i28 == 0) {
            f17 = f27;
        } else {
            f17 = -3.4028235E38f;
        }
        this.R = f17;
        int i36 = f373114d - 1;
        if (i28 == i36) {
            f18 = (eVar.f251481d + f27) - 1.0f;
        } else {
            f18 = Float.MAX_VALUE;
        }
        this.S = f18;
        int i37 = i3 - 1;
        while (i37 >= 0) {
            e eVar7 = this.f251452m.get(i37);
            while (true) {
                i17 = eVar7.f251479b;
                if (i29 <= i17) {
                    break;
                }
                f27 -= this.E.getPageWidth(i29) + f16;
                i29--;
            }
            f27 -= eVar7.f251481d + f16;
            eVar7.f251482e = f27;
            if (i17 == 0) {
                this.R = f27;
            }
            i37--;
            i29--;
        }
        float f28 = eVar.f251482e + eVar.f251481d + f16;
        int i38 = eVar.f251479b + 1;
        int i39 = i3 + 1;
        while (i39 < size2) {
            e eVar8 = this.f251452m.get(i39);
            while (true) {
                i16 = eVar8.f251479b;
                if (i38 >= i16) {
                    break;
                }
                f28 += this.E.getPageWidth(i38) + f16;
                i38++;
            }
            if (i16 == i36) {
                this.S = (eVar8.f251481d + f28) - 1.0f;
            }
            eVar8.f251482e = f28;
            f28 += eVar8.f251481d + f16;
            i39++;
            i38++;
        }
        this.f251462v0 = false;
    }

    private void e(boolean z16) {
        boolean z17;
        if (this.H0 == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            N(false);
            if (!this.J.isFinished()) {
                this.J.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.J.getCurrX();
                int currY = this.J.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        B(currX);
                    }
                }
            }
        }
        this.f251435a0 = false;
        for (int i3 = 0; i3 < this.f251452m.size(); i3++) {
            e eVar = this.f251452m.get(i3);
            if (eVar.f251480c) {
                eVar.f251480c = false;
                z17 = true;
            }
        }
        if (z17) {
            if (z16) {
                ViewCompat.postOnAnimation(this, this.G0);
            } else {
                this.G0.run();
            }
        }
    }

    private void h(int i3, float f16, int i16) {
        i iVar = this.f251466z0;
        if (iVar != null) {
            iVar.onPageScrolled(i3, f16, i16);
        }
        List<i> list = this.f251465y0;
        if (list != null) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                i iVar2 = this.f251465y0.get(i17);
                if (iVar2 != null) {
                    iVar2.onPageScrolled(i3, f16, i16);
                }
            }
        }
        i iVar3 = this.A0;
        if (iVar3 != null) {
            iVar3.onPageScrolled(i3, f16, i16);
        }
    }

    private void i(int i3) {
        i iVar = this.f251466z0;
        if (iVar != null) {
            iVar.onPageSelected(i3);
        }
        List<i> list = this.f251465y0;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                i iVar2 = this.f251465y0.get(i16);
                if (iVar2 != null) {
                    iVar2.onPageSelected(i3);
                }
            }
        }
        i iVar3 = this.A0;
        if (iVar3 != null) {
            iVar3.onPageSelected(i3);
        }
    }

    private void j(int i3) {
        i iVar = this.f251466z0;
        if (iVar != null) {
            iVar.onPageScrollStateChanged(i3);
        }
        List<i> list = this.f251465y0;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                i iVar2 = this.f251465y0.get(i16);
                if (iVar2 != null) {
                    iVar2.onPageScrollStateChanged(i3);
                }
            }
        }
        i iVar3 = this.A0;
        if (iVar3 != null) {
            iVar3.onPageScrollStateChanged(i3);
        }
    }

    private void l() {
        if (QLog.isColorLevel()) {
            QLog.d("MultiAIOBaseViewPager", 2, "endDrag() called");
        }
        this.f251437c0 = false;
        this.f251439d0 = false;
        VelocityTracker velocityTracker = this.f251453m0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f251453m0 = null;
        }
    }

    private Rect n(Rect rect, View view) {
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

    private int o() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private e s() {
        float f16;
        float f17;
        int i3;
        int o16 = o();
        float f18 = 0.0f;
        if (o16 > 0) {
            f16 = getScrollX() / o16;
        } else {
            f16 = 0.0f;
        }
        if (o16 > 0) {
            f17 = this.M / o16;
        } else {
            f17 = 0.0f;
        }
        int i16 = 0;
        boolean z16 = true;
        e eVar = null;
        int i17 = -1;
        float f19 = 0.0f;
        while (i16 < this.f251452m.size()) {
            e eVar2 = this.f251452m.get(i16);
            if (!z16 && eVar2.f251479b != (i3 = i17 + 1)) {
                eVar2 = this.C;
                eVar2.f251482e = f18 + f19 + f17;
                eVar2.f251479b = i3;
                eVar2.f251481d = this.E.getPageWidth(i3);
                i16--;
            }
            e eVar3 = eVar2;
            f18 = eVar3.f251482e;
            float f26 = eVar3.f251481d + f18 + f17;
            if (!z16 && f16 < f18) {
                return eVar;
            }
            if (f16 >= f26 && i16 != this.f251452m.size() - 1) {
                int i18 = eVar3.f251479b;
                float f27 = eVar3.f251481d;
                i16++;
                z16 = false;
                i17 = i18;
                f19 = f27;
                eVar = eVar3;
            } else {
                return eVar3;
            }
        }
        return eVar;
    }

    private static boolean v(View view) {
        if (view.getClass().getAnnotation(DecorView.class) != null) {
            return true;
        }
        return false;
    }

    private boolean w(float f16, float f17) {
        if ((f16 < this.f251443f0 && f17 > 0.0f) || (f16 > getWidth() - this.f251443f0 && f17 < 0.0f)) {
            return true;
        }
        return false;
    }

    private void y(MotionEvent motionEvent) {
        int i3;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f251451l0) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.f251446h0 = motionEvent.getX(i3);
            this.f251451l0 = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f251453m0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    boolean A() {
        PagerAdapter pagerAdapter = this.E;
        if (pagerAdapter != null && this.F < pagerAdapter.getF373114d() - 1) {
            setCurrentItem(this.F + 1, true);
            return true;
        }
        return false;
    }

    boolean B(int i3) {
        if (this.f251452m.size() == 0) {
            if (this.f251461u0) {
                return false;
            }
            this.f251463w0 = false;
            x(0, 0.0f, 0);
            if (this.f251463w0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        e s16 = s();
        if (s16 == null) {
            return false;
        }
        int o16 = o();
        int i16 = this.M;
        int i17 = o16 + i16;
        float f16 = o16;
        int i18 = s16.f251479b;
        float f17 = ((i3 / f16) - s16.f251482e) / (s16.f251481d + (i16 / f16));
        this.f251463w0 = false;
        x(i18, f17, (int) (i17 * f17));
        if (this.f251463w0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    void D() {
        E(this.F);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0095, code lost:
    
        if (r10 == r11) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(int i3) {
        e eVar;
        String hexString;
        e eVar2;
        e eVar3;
        e r16;
        e eVar4;
        float paddingLeft;
        e eVar5;
        float paddingRight;
        e eVar6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiAIOBaseViewPager", 2, "populate() called with: newCurrentItem = [" + i3 + "]");
        }
        int i16 = this.F;
        if (i16 != i3) {
            eVar = t(i16);
            this.F = i3;
        } else {
            eVar = null;
        }
        if (this.E == null) {
            Q();
            return;
        }
        if (this.f251435a0) {
            Q();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.E.startUpdate((ViewGroup) this);
        int i17 = this.f251436b0;
        int max = Math.max(0, this.F - i17);
        int f373114d = this.E.getF373114d();
        int min = Math.min(f373114d - 1, this.F + i17);
        if (f373114d == this.f251440e) {
            int i18 = 0;
            while (true) {
                if (i18 >= this.f251452m.size()) {
                    break;
                }
                eVar2 = this.f251452m.get(i18);
                int i19 = eVar2.f251479b;
                int i26 = this.F;
                if (i19 < i26) {
                    i18++;
                }
            }
            eVar2 = null;
            if (eVar2 == null && f373114d > 0) {
                eVar2 = a(this.F, i18);
            }
            if (eVar2 != null) {
                int i27 = i18 - 1;
                if (i27 >= 0) {
                    eVar4 = this.f251452m.get(i27);
                } else {
                    eVar4 = null;
                }
                int o16 = o();
                if (o16 <= 0) {
                    paddingLeft = 0.0f;
                } else {
                    paddingLeft = (2.0f - eVar2.f251481d) + (getPaddingLeft() / o16);
                }
                float f16 = 0.0f;
                for (int i28 = this.F - 1; i28 >= 0; i28--) {
                    if (f16 >= paddingLeft && i28 < max) {
                        if (eVar4 == null) {
                            break;
                        }
                        if (i28 == eVar4.f251479b && !eVar4.f251480c) {
                            this.f251452m.remove(i27);
                            this.E.destroyItem((ViewGroup) this, i28, eVar4.f251478a);
                            i27--;
                            i18--;
                            if (i27 >= 0) {
                                eVar6 = this.f251452m.get(i27);
                                eVar4 = eVar6;
                            }
                            eVar6 = null;
                            eVar4 = eVar6;
                        }
                    } else if (eVar4 != null && i28 == eVar4.f251479b) {
                        f16 += eVar4.f251481d;
                        i27--;
                        if (i27 >= 0) {
                            eVar6 = this.f251452m.get(i27);
                            eVar4 = eVar6;
                        }
                        eVar6 = null;
                        eVar4 = eVar6;
                    } else {
                        f16 += a(i28, i27 + 1).f251481d;
                        i18++;
                        if (i27 >= 0) {
                            eVar6 = this.f251452m.get(i27);
                            eVar4 = eVar6;
                        }
                        eVar6 = null;
                        eVar4 = eVar6;
                    }
                }
                float f17 = eVar2.f251481d;
                int i29 = i18 + 1;
                if (f17 < 2.0f) {
                    if (i29 < this.f251452m.size()) {
                        eVar5 = this.f251452m.get(i29);
                    } else {
                        eVar5 = null;
                    }
                    if (o16 <= 0) {
                        paddingRight = 0.0f;
                    } else {
                        paddingRight = (getPaddingRight() / o16) + 2.0f;
                    }
                    int i36 = this.F;
                    while (true) {
                        i36++;
                        if (i36 >= f373114d) {
                            break;
                        }
                        if (f17 >= paddingRight && i36 > min) {
                            if (eVar5 == null) {
                                break;
                            }
                            if (i36 == eVar5.f251479b && !eVar5.f251480c) {
                                this.f251452m.remove(i29);
                                this.E.destroyItem((ViewGroup) this, i36, eVar5.f251478a);
                                if (i29 < this.f251452m.size()) {
                                    eVar5 = this.f251452m.get(i29);
                                } else {
                                    eVar5 = null;
                                }
                            }
                        } else if (eVar5 != null && i36 == eVar5.f251479b) {
                            f17 += eVar5.f251481d;
                            i29++;
                            if (i29 >= this.f251452m.size()) {
                                eVar5 = null;
                            } else {
                                eVar5 = this.f251452m.get(i29);
                            }
                        } else {
                            e a16 = a(i36, i29);
                            i29++;
                            f17 += a16.f251481d;
                            if (i29 >= this.f251452m.size()) {
                                eVar5 = null;
                            } else {
                                eVar5 = this.f251452m.get(i29);
                            }
                        }
                    }
                }
                c(eVar2, i18, eVar);
                this.E.setPrimaryItem((ViewGroup) this, this.F, eVar2.f251478a);
            }
            this.E.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i37 = 0; i37 < childCount; i37++) {
                View childAt = getChildAt(i37);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f251472f = i37;
                if (!layoutParams.f251467a && layoutParams.f251469c == 0.0f && (r16 = r(childAt)) != null) {
                    layoutParams.f251469c = r16.f251481d;
                    layoutParams.f251471e = r16.f251479b;
                }
            }
            Q();
            if (hasFocus()) {
                View findFocus = findFocus();
                if (findFocus != null) {
                    eVar3 = q(findFocus);
                } else {
                    eVar3 = null;
                }
                if (eVar3 == null || eVar3.f251479b != this.F) {
                    for (int i38 = 0; i38 < getChildCount(); i38++) {
                        View childAt2 = getChildAt(i38);
                        e r17 = r(childAt2);
                        if (r17 != null && r17.f251479b == this.F) {
                            if (childAt2.requestFocus(2)) {
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        try {
            hexString = getResources().getResourceName(getId());
        } catch (Resources.NotFoundException unused) {
            hexString = Integer.toHexString(getId());
        }
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f251440e + ", found: " + f373114d + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.E.getClass());
    }

    void K(int i3, boolean z16, boolean z17) {
        L(i3, z16, z17, 0);
    }

    void L(int i3, boolean z16, boolean z17, int i16) {
        PagerAdapter pagerAdapter = this.E;
        boolean z18 = false;
        if (pagerAdapter != null && pagerAdapter.getF373114d() > 0) {
            if (!z17 && this.f251438d == i3 && this.f251452m.size() != 0) {
                N(false);
                return;
            }
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 >= this.E.getF373114d()) {
                i3 = this.E.getF373114d() - 1;
            }
            int i17 = this.f251436b0;
            int i18 = this.F;
            if (i3 > i18 + i17 || i3 < i18 - i17) {
                for (int i19 = 0; i19 < this.f251452m.size(); i19++) {
                    this.f251452m.get(i19).f251480c = true;
                }
            }
            if (this.f251438d != i3) {
                z18 = true;
            }
            if (this.f251461u0) {
                this.F = i3;
                this.f251438d = i3;
                if (z18) {
                    i(i3);
                }
                requestLayout();
                return;
            }
            E(i3);
            this.f251438d = this.F;
            J(i3, z16, i16, z18);
            return;
        }
        N(false);
    }

    void M(int i3) {
        if (this.H0 == i3) {
            return;
        }
        this.H0 = i3;
        j(i3);
    }

    void N(boolean z16) {
        if (this.W != z16) {
            this.W = z16;
        }
    }

    void P(int i3, int i16, int i17) {
        boolean z16;
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            N(false);
            return;
        }
        Scroller scroller = this.J;
        if (scroller != null && !scroller.isFinished()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.K) {
                scrollX = this.J.getCurrX();
            } else {
                scrollX = this.J.getStartX();
            }
            this.J.abortAnimation();
            N(false);
        } else {
            scrollX = getScrollX();
        }
        int i18 = scrollX;
        int scrollY = getScrollY();
        int i19 = i3 - i18;
        int i26 = i16 - scrollY;
        if (i19 == 0 && i26 == 0) {
            e(false);
            D();
            M(0);
            return;
        }
        N(true);
        M(2);
        int o16 = o();
        int i27 = o16 / 2;
        float f16 = o16;
        float f17 = i27;
        float k3 = f17 + (k(Math.min(1.0f, (Math.abs(i19) * 1.0f) / f16)) * f17);
        int abs2 = Math.abs(i17);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(k3 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i19) / ((f16 * this.E.getPageWidth(this.F)) + this.M)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.K = false;
        this.J.startScroll(i18, scrollY, i19, i26, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    protected void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (this.D0 != 0) {
            ArrayList<View> arrayList = this.E0;
            if (arrayList == null) {
                this.E0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.E0.add(getChildAt(i3));
            }
            Collections.sort(this.E0, this.F0);
        }
    }

    e a(int i3, int i16) {
        e eVar = new e();
        eVar.f251479b = i3;
        eVar.f251478a = this.E.instantiateItem((ViewGroup) this, i3);
        eVar.f251481d = this.E.getPageWidth(i3);
        if (i16 >= 0 && i16 < this.f251452m.size()) {
            this.f251452m.add(i16, eVar);
        } else {
            this.f251452m.add(eVar);
        }
        return eVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        e r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, arrayList, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() == 0 && (r16 = r(childAt)) != null && r16.f251479b == this.F) {
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
        e r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) arrayList);
            return;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (r16 = r(childAt)) != null && r16.f251479b == this.F) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, view, Integer.valueOf(i3), layoutParams);
            return;
        }
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean v3 = layoutParams2.f251467a | v(view);
        layoutParams2.f251467a = v3;
        if (this.V) {
            if (!v3) {
                layoutParams2.f251470d = true;
                addViewInLayout(view, i3, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i3, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(int i3) {
        boolean z16;
        View findNextFocus;
        boolean requestFocus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this, i3)).booleanValue();
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
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb5.append(" => ");
                        sb5.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("MultiAIOBaseViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb5.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i3 == 17) {
                    int i16 = n(this.D, findNextFocus).left;
                    int i17 = n(this.D, findFocus).left;
                    if (findFocus != null && i16 >= i17) {
                        requestFocus = z();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                } else if (i3 == 66) {
                    int i18 = n(this.D, findNextFocus).left;
                    int i19 = n(this.D, findFocus).left;
                    if (findFocus != null && i18 <= i19) {
                        requestFocus = A();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                }
                z17 = requestFocus;
            } else if (i3 == 17 && i3 != 1) {
                if (i3 == 66 || i3 == 2) {
                    z17 = A();
                }
            } else {
                z17 = z();
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
        if (i3 == 17) {
        }
        z17 = z();
        if (z17) {
        }
        return z17;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, i3)).booleanValue();
        }
        if (this.E == null) {
            return false;
        }
        int o16 = o();
        int scrollX = getScrollX();
        if (i3 < 0) {
            if (scrollX <= ((int) (o16 * this.R))) {
                return false;
            }
            return true;
        }
        if (i3 <= 0 || scrollX >= ((int) (o16 * this.S))) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this, (Object) layoutParams)).booleanValue();
        }
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        this.K = true;
        if (!this.J.isFinished() && this.J.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.J.getCurrX();
            int currY = this.J.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!B(currX)) {
                    this.J.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        e(true);
    }

    protected boolean d(View view, boolean z16, int i3, int i16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, this, view, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i19 = i16 + scrollX;
                if (i19 >= childAt.getLeft() && i19 < childAt.getRight() && (i18 = i17 + scrollY) >= childAt.getTop() && i18 < childAt.getBottom() && d(childAt, true, i3, i19 - childAt.getLeft(), i18 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z16 || !view.canScrollHorizontally(-i3)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (!super.dispatchKeyEvent(keyEvent) && !m(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        e r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this, (Object) accessibilityEvent)).booleanValue();
        }
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (r16 = r(childAt)) != null && r16.f251479b == this.F && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z16 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.E) == null || pagerAdapter.getF373114d() <= 1)) {
            this.f251459s0.finish();
            this.f251460t0.finish();
        } else {
            if (!this.f251459s0.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.R * width);
                this.f251459s0.setSize(height, width);
                z16 = false | this.f251459s0.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f251460t0.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.S + 1.0f)) * width2);
                this.f251460t0.setSize(height2, width2);
                z16 |= this.f251460t0.draw(canvas);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        super.drawableStateChanged();
        Drawable drawable = this.N;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    void f() {
        boolean z16;
        int f373114d = this.E.getF373114d();
        this.f251440e = f373114d;
        if (this.f251452m.size() < (this.f251436b0 * 2) + 1 && this.f251452m.size() < f373114d) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.F;
        int i16 = 0;
        boolean z17 = false;
        while (i16 < this.f251452m.size()) {
            e eVar = this.f251452m.get(i16);
            int itemPosition = this.E.getItemPosition(eVar.f251478a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f251452m.remove(i16);
                    i16--;
                    if (!z17) {
                        this.E.startUpdate((ViewGroup) this);
                        z17 = true;
                    }
                    this.E.destroyItem((ViewGroup) this, eVar.f251479b, eVar.f251478a);
                    int i17 = this.F;
                    if (i17 == eVar.f251479b) {
                        i3 = Math.max(0, Math.min(i17, f373114d - 1));
                    }
                } else {
                    int i18 = eVar.f251479b;
                    if (i18 != itemPosition) {
                        if (i18 == this.F) {
                            i3 = itemPosition;
                        }
                        eVar.f251479b = itemPosition;
                    }
                }
                z16 = true;
            }
            i16++;
        }
        if (z17) {
            this.E.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f251452m, J0);
        if (z16) {
            int childCount = getChildCount();
            for (int i19 = 0; i19 < childCount; i19++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i19).getLayoutParams();
                if (!layoutParams.f251467a) {
                    layoutParams.f251469c = 0.0f;
                }
            }
            K(i3, false, true);
            requestLayout();
        }
    }

    protected int g(int i3, float f16, int i16, int i17) {
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        if (Math.abs(i17) > this.f251456p0 && Math.abs(i16) > this.f251454n0) {
            if (i16 <= 0) {
                i3++;
            }
        } else {
            if (i3 >= this.F) {
                f17 = 0.4f;
            } else {
                f17 = 0.6f;
            }
            i3 += (int) (f16 + f17);
        }
        if (this.f251452m.size() > 0) {
            e eVar = this.f251452m.get(0);
            ArrayList<e> arrayList = this.f251452m;
            return Math.max(eVar.f251479b, Math.min(i3, arrayList.get(arrayList.size() - 1).f251479b));
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 58)) ? generateDefaultLayoutParams() : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 58, (Object) this, (Object) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (this.D0 == 2) {
            i16 = (i3 - 1) - i16;
        }
        return ((LayoutParams) this.E0.get(i16).getLayoutParams()).f251472f;
    }

    float k(float f16) {
        return (float) Math.sin((f16 - 0.5f) * 0.47123894f);
    }

    public boolean m(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return b(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return b(1);
                        }
                    }
                } else {
                    if (keyEvent.hasModifiers(2)) {
                        return A();
                    }
                    return b(66);
                }
            } else {
                if (keyEvent.hasModifiers(2)) {
                    return z();
                }
                return b(17);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.f251461u0 = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        removeCallbacks(this.G0);
        Scroller scroller = this.J;
        if (scroller != null && !scroller.isFinished()) {
            this.J.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        float f16;
        float f17;
        float f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.M > 0 && this.N != null && this.f251452m.size() > 0 && this.E != null) {
            int scrollX = getScrollX();
            float width = getWidth();
            float f19 = this.M / width;
            int i16 = 0;
            e eVar = this.f251452m.get(0);
            float f26 = eVar.f251482e;
            int size = this.f251452m.size();
            int i17 = eVar.f251479b;
            int i18 = this.f251452m.get(size - 1).f251479b;
            while (i17 < i18) {
                while (true) {
                    i3 = eVar.f251479b;
                    if (i17 <= i3 || i16 >= size) {
                        break;
                    }
                    i16++;
                    eVar = this.f251452m.get(i16);
                }
                if (i17 == i3) {
                    float f27 = eVar.f251482e;
                    float f28 = eVar.f251481d;
                    f16 = (f27 + f28) * width;
                    f26 = f27 + f28 + f19;
                } else {
                    float pageWidth = this.E.getPageWidth(i17);
                    f16 = (f26 + pageWidth) * width;
                    f26 += pageWidth + f19;
                }
                if (this.M + f16 > scrollX) {
                    f17 = f19;
                    f18 = width;
                    this.N.setBounds(Math.round(f16), this.P, Math.round(this.M + f16), this.Q);
                    this.N.draw(canvas);
                } else {
                    f17 = f19;
                    f18 = width;
                }
                if (f16 <= scrollX + r3) {
                    i17++;
                    f19 = f17;
                    width = f18;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int findPointerIndex;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.f251437c0) {
                    return true;
                }
                if (this.f251439d0) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        y(motionEvent);
                    }
                } else {
                    int i3 = this.f251451l0;
                    if (i3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i3)) >= 0 && findPointerIndex <= motionEvent.getPointerCount() - 1) {
                        float f17 = this.f251446h0;
                        try {
                            f17 = motionEvent.getX(findPointerIndex);
                        } catch (Exception e16) {
                            QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", e16);
                        }
                        float f18 = f17;
                        float f19 = f18 - this.f251446h0;
                        float abs = Math.abs(f19);
                        float f26 = this.f251448i0;
                        try {
                            f26 = motionEvent.getY(findPointerIndex);
                        } catch (Exception e17) {
                            QLog.e("MultiAIOBaseViewPager", 1, "onInterceptTouchEvent: ", e17);
                        }
                        float f27 = f26;
                        float abs2 = Math.abs(f27 - this.f251450k0);
                        if (f19 != 0.0f && !w(this.f251446h0, f19) && d(this, false, (int) f19, (int) f18, (int) f27)) {
                            this.f251446h0 = f18;
                            this.f251448i0 = f27;
                            this.f251439d0 = true;
                            return false;
                        }
                        int i16 = this.f251444g0;
                        if (abs > i16 && abs * 0.5f > abs2) {
                            this.f251437c0 = true;
                            H(true);
                            M(1);
                            if (f19 > 0.0f) {
                                f16 = this.f251449j0 + this.f251444g0;
                            } else {
                                f16 = this.f251449j0 - this.f251444g0;
                            }
                            this.f251446h0 = f16;
                            this.f251448i0 = f27;
                            N(true);
                        } else if (abs2 > i16) {
                            this.f251439d0 = true;
                        }
                        if (this.f251437c0 && C(f18)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                    }
                }
            } else {
                float x16 = motionEvent.getX();
                this.f251449j0 = x16;
                this.f251446h0 = x16;
                float y16 = motionEvent.getY();
                this.f251450k0 = y16;
                this.f251448i0 = y16;
                this.f251451l0 = motionEvent.getPointerId(0);
                this.f251439d0 = false;
                this.K = true;
                this.J.computeScrollOffset();
                if (this.H0 == 2 && Math.abs(this.J.getFinalX() - this.J.getCurrX()) > this.f251457q0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.J.abortAnimation();
                    this.f251435a0 = false;
                    D();
                    this.f251437c0 = true;
                    H(true);
                    M(1);
                } else {
                    e(false);
                    this.f251437c0 = false;
                }
            }
            if (this.f251453m0 == null) {
                this.f251453m0 = VelocityTracker.obtain();
            }
            this.f251453m0.addMovement(motionEvent);
            return this.f251437c0;
        }
        I();
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
        e r16;
        int max;
        int i19;
        int max2;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 3;
        int i28 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int childCount = getChildCount();
        int i29 = i17 - i3;
        int i36 = i18 - i16;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i37 = 0;
        int i38 = 0;
        while (i37 < childCount) {
            View childAt = getChildAt(i37);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f251467a) {
                    int i39 = layoutParams.f251468b;
                    int i46 = i39 & 7;
                    int i47 = i39 & 112;
                    if (i46 != i28) {
                        if (i46 != i27) {
                            if (i46 != 5) {
                                i19 = paddingLeft;
                            } else {
                                max = (i29 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i19 = childAt.getMeasuredWidth() + paddingLeft;
                        }
                        if (i47 == 16) {
                            if (i47 != 48) {
                                if (i47 != 80) {
                                    i26 = paddingTop;
                                } else {
                                    max2 = (i36 - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                            } else {
                                i26 = childAt.getMeasuredHeight() + paddingTop;
                            }
                            int i48 = paddingLeft + scrollX;
                            childAt.layout(i48, paddingTop, i48 + childAt.getMeasuredWidth(), paddingTop + childAt.getMeasuredHeight());
                            i38++;
                            paddingTop = i26;
                            paddingLeft = i19;
                        } else {
                            max2 = Math.max((i36 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i49 = paddingTop;
                        paddingTop = max2;
                        i26 = i49;
                        int i482 = paddingLeft + scrollX;
                        childAt.layout(i482, paddingTop, i482 + childAt.getMeasuredWidth(), paddingTop + childAt.getMeasuredHeight());
                        i38++;
                        paddingTop = i26;
                        paddingLeft = i19;
                    } else {
                        max = Math.max((i29 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i56 = paddingLeft;
                    paddingLeft = max;
                    i19 = i56;
                    if (i47 == 16) {
                    }
                    int i492 = paddingTop;
                    paddingTop = max2;
                    i26 = i492;
                    int i4822 = paddingLeft + scrollX;
                    childAt.layout(i4822, paddingTop, i4822 + childAt.getMeasuredWidth(), paddingTop + childAt.getMeasuredHeight());
                    i38++;
                    paddingTop = i26;
                    paddingLeft = i19;
                }
            }
            i37++;
            i27 = 3;
            i28 = 1;
        }
        int i57 = (i29 - paddingLeft) - paddingRight;
        for (int i58 = 0; i58 < childCount; i58++) {
            View childAt2 = getChildAt(i58);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f251467a && (r16 = r(childAt2)) != null) {
                    float f16 = i57;
                    int i59 = ((int) (r16.f251482e * f16)) + paddingLeft;
                    if (layoutParams2.f251470d) {
                        layoutParams2.f251470d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f16 * layoutParams2.f251469c), 1073741824), View.MeasureSpec.makeMeasureSpec((i36 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i59, paddingTop, childAt2.getMeasuredWidth() + i59, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.P = paddingTop;
        this.Q = i36 - paddingBottom;
        this.f251464x0 = i38;
        if (this.f251461u0) {
            z17 = false;
            J(this.F, false, 0, false);
        } else {
            z17 = false;
        }
        this.f251461u0 = z17;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        LayoutParams layoutParams;
        float f16;
        LayoutParams layoutParams2;
        boolean z16;
        boolean z17;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 3;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i16));
        int measuredWidth = getMeasuredWidth();
        this.f251443f0 = Math.min(measuredWidth / 10, this.f251441e0);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i19 = 0;
        while (true) {
            int i26 = 1073741824;
            if (i19 >= childCount) {
                break;
            }
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f251467a) {
                int i27 = layoutParams2.f251468b;
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
                        i37 = paddingLeft;
                    }
                    i36 = 1073741824;
                } else {
                    i37 = paddingLeft;
                }
                int i38 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i38 != -2) {
                    if (i38 == -1) {
                        i38 = measuredHeight;
                    }
                } else {
                    i38 = measuredHeight;
                    i26 = i17;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i37, i36), View.MeasureSpec.makeMeasureSpec(i38, i26));
                if (z16) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z17) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i19++;
            i18 = 3;
            z18 = false;
        }
        this.T = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.U = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.V = true;
        D();
        this.V = false;
        int childCount2 = getChildCount();
        for (int i39 = 0; i39 < childCount2; i39++) {
            View childAt2 = getChildAt(i39);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f251467a)) {
                if (layoutParams != null) {
                    f16 = layoutParams.f251469c;
                } else {
                    f16 = 0.0f;
                }
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * f16), 1073741824), this.U);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        int i16;
        int i17;
        int i18;
        e r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this, i3, (Object) rect)).booleanValue();
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
            if (childAt.getVisibility() == 0 && (r16 = r(childAt)) != null && r16.f251479b == this.F && childAt.requestFocus(i3, rect)) {
                return true;
            }
            i16 += i18;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) parcelable);
            return;
        }
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.E;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f251474e, savedState.f251475f);
            K(savedState.f251473d, false, true);
        } else {
            this.G = savedState.f251473d;
            this.H = savedState.f251474e;
            this.I = savedState.f251475f;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Parcelable) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f251473d = this.F;
        PagerAdapter pagerAdapter = this.E;
        if (pagerAdapter != null) {
            savedState.f251474e = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != i17) {
            int i19 = this.M;
            F(i3, i17, i19, i19);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        int findPointerIndex;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f251458r0) {
            return true;
        }
        boolean z16 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.E) == null || pagerAdapter.getF373114d() == 0) {
            return false;
        }
        if (this.f251453m0 == null) {
            this.f251453m0 = VelocityTracker.obtain();
        }
        this.f251453m0.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                y(motionEvent);
                                try {
                                    this.f251446h0 = motionEvent.getX(motionEvent.findPointerIndex(this.f251451l0));
                                } catch (Exception e16) {
                                    QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", e16);
                                }
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            try {
                                this.f251446h0 = motionEvent.getX(actionIndex);
                                this.f251451l0 = motionEvent.getPointerId(actionIndex);
                            } catch (Exception e17) {
                                QLog.e("MultiAIOBaseViewPager", 1, "onTouchEvent: ", e17);
                            }
                        }
                    } else if (this.f251437c0) {
                        J(this.F, true, 0, false);
                        z16 = I();
                    }
                } else {
                    if (!this.f251437c0) {
                        int findPointerIndex2 = motionEvent.findPointerIndex(this.f251451l0);
                        if (findPointerIndex2 == -1) {
                            z16 = I();
                        } else {
                            float x16 = motionEvent.getX(findPointerIndex2);
                            float abs = Math.abs(x16 - this.f251446h0);
                            float y16 = motionEvent.getY(findPointerIndex2);
                            float abs2 = Math.abs(y16 - this.f251448i0);
                            if (abs > this.f251444g0 && abs > abs2) {
                                this.f251437c0 = true;
                                H(true);
                                float f17 = this.f251449j0;
                                if (x16 - f17 > 0.0f) {
                                    f16 = f17 + this.f251444g0;
                                } else {
                                    f16 = f17 - this.f251444g0;
                                }
                                this.f251446h0 = f16;
                                this.f251448i0 = y16;
                                M(1);
                                N(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    if (this.f251437c0 && (findPointerIndex = motionEvent.findPointerIndex(this.f251451l0)) != -1) {
                        z16 = false | C(motionEvent.getX(findPointerIndex));
                    }
                }
            } else if (this.f251437c0) {
                VelocityTracker velocityTracker = this.f251453m0;
                velocityTracker.computeCurrentVelocity(1000, this.f251455o0);
                int xVelocity = (int) velocityTracker.getXVelocity(this.f251451l0);
                this.f251435a0 = true;
                int o16 = o();
                int scrollX = getScrollX();
                e s16 = s();
                if (s16 == null) {
                    return false;
                }
                float f18 = o16;
                int i3 = s16.f251479b;
                float f19 = ((scrollX / f18) - s16.f251482e) / (s16.f251481d + (this.M / f18));
                int findPointerIndex3 = motionEvent.findPointerIndex(this.f251451l0);
                float f26 = this.f251446h0;
                if (findPointerIndex3 != -1) {
                    f26 = motionEvent.getX(findPointerIndex3);
                }
                int i16 = (int) (f26 - this.f251449j0);
                if (Math.abs(i16) <= this.f251456p0 * 4 || Math.abs(xVelocity) <= this.f251454n0) {
                    L(g(i3, f19, xVelocity, i16), true, true, xVelocity);
                }
                z16 = I();
            }
        } else {
            this.J.abortAnimation();
            this.f251435a0 = false;
            D();
            float x17 = motionEvent.getX();
            this.f251449j0 = x17;
            this.f251446h0 = x17;
            float y17 = motionEvent.getY();
            this.f251450k0 = y17;
            this.f251448i0 = y17;
            this.f251451l0 = motionEvent.getPointerId(0);
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.F;
    }

    e q(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view = (View) parent;
                } else {
                    return null;
                }
            } else {
                return r(view);
            }
        }
    }

    e r(View view) {
        for (int i3 = 0; i3 < this.f251452m.size(); i3++) {
            e eVar = this.f251452m.get(i3);
            if (this.E.isViewFromObject(view, eVar.f251478a)) {
                return eVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) view);
        } else if (this.V) {
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
        PagerAdapter pagerAdapter2 = this.E;
        if (pagerAdapter2 != null) {
            O(pagerAdapter2, null);
            this.E.startUpdate((ViewGroup) this);
            for (int i3 = 0; i3 < this.f251452m.size(); i3++) {
                e eVar = this.f251452m.get(i3);
                this.E.destroyItem((ViewGroup) this, eVar.f251479b, eVar.f251478a);
            }
            this.E.finishUpdate((ViewGroup) this);
            this.f251452m.clear();
            G();
            this.F = 0;
            this.f251438d = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.E;
        this.E = pagerAdapter;
        this.f251440e = 0;
        if (pagerAdapter != null) {
            if (this.L == null) {
                this.L = new k();
            }
            O(this.E, this.L);
            this.f251435a0 = false;
            boolean z16 = this.f251461u0;
            this.f251461u0 = true;
            this.f251440e = this.E.getF373114d();
            if (this.G >= 0) {
                this.E.restoreState(this.H, this.I);
                K(this.G, false, true);
                this.G = -1;
                this.H = null;
                this.I = null;
            } else if (!z16) {
                D();
            } else {
                requestLayout();
            }
        }
        List<h> list = this.B0;
        if (list != null && !list.isEmpty()) {
            int size = this.B0.size();
            for (int i16 = 0; i16 < size; i16++) {
                this.B0.get(i16).a(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f251435a0 = false;
            K(i3, !this.f251461u0, false);
        }
    }

    public void setFlingListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) dVar);
        }
    }

    public void setOffscreenPageLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        if (i3 < 1) {
            Log.w("MultiAIOBaseViewPager", "Requested offscreen page limit " + i3 + " too small; defaulting to 1");
            i3 = 1;
        }
        if (i3 != this.f251436b0) {
            this.f251436b0 = i3;
            D();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iVar);
        } else {
            this.f251466z0 = iVar;
        }
    }

    public void setPageMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        int i16 = this.M;
        this.M = i3;
        int width = getWidth();
        F(width, width, i3, i16);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) drawable);
            return;
        }
        this.N = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z16, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            setPageTransformer(z16, jVar, 2);
        } else {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), jVar);
        }
    }

    e t(int i3) {
        for (int i16 = 0; i16 < this.f251452m.size(); i16++) {
            e eVar = this.f251452m.get(i16);
            if (eVar.f251479b == i3) {
                return eVar;
            }
        }
        return null;
    }

    void u() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.J = new Scroller(context, K0);
        this.f251442f = new Scroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.f251444g0 = viewConfiguration.getScaledPagingTouchSlop();
        this.f251454n0 = (int) (400.0f * f16);
        this.f251455o0 = viewConfiguration.getScaledMaximumFlingVelocity();
        int a16 = com.tencent.mobileqq.multiaio.utils.b.a(getContext(), this.f251455o0);
        this.f251447i = a16;
        this.f251455o0 = a16;
        this.f251459s0 = new EdgeEffect(context);
        this.f251460t0 = new EdgeEffect(context);
        this.f251456p0 = (int) (25.0f * f16);
        this.f251457q0 = (int) (2.0f * f16);
        this.f251441e0 = (int) (f16 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new g());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new c());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) drawable)).booleanValue();
        }
        if (!super.verifyDrawable(drawable) && drawable != this.N) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void x(int i3, float f16, int i16) {
        int max;
        int i17;
        int left;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        if (this.f251464x0 > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = getChildAt(i18);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f251467a) {
                    int i19 = layoutParams.f251468b & 7;
                    if (i19 != 1) {
                        if (i19 != 3) {
                            if (i19 != 5) {
                                i17 = paddingLeft;
                            } else {
                                max = (width - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                        } else {
                            i17 = childAt.getWidth() + paddingLeft;
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i17;
                    } else {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i26 = max;
                    i17 = paddingLeft;
                    paddingLeft = i26;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i17;
                }
            }
        }
        h(i3, f16, i16);
        this.f251463w0 = true;
    }

    boolean z() {
        int i3 = this.F;
        if (i3 > 0) {
            setCurrentItem(i3 - 1, true);
            return true;
        }
        return false;
    }

    /* loaded from: classes15.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f251467a;

        /* renamed from: b, reason: collision with root package name */
        public int f251468b;

        /* renamed from: c, reason: collision with root package name */
        float f251469c;

        /* renamed from: d, reason: collision with root package name */
        boolean f251470d;

        /* renamed from: e, reason: collision with root package name */
        int f251471e;

        /* renamed from: f, reason: collision with root package name */
        int f251472f;

        public LayoutParams() {
            super(-1, -1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f251469c = 0.0f;
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
            this.f251469c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MultiAIOBaseViewPager.I0);
            this.f251468b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 60)) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 60, (Object) this, (Object) attributeSet);
    }

    public void setPageTransformer(boolean z16, j jVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), jVar, Integer.valueOf(i3));
            return;
        }
        boolean z17 = jVar != null;
        setChildrenDrawingOrderEnabled(z17);
        if (z17) {
            this.D0 = z16 ? 2 : 1;
            this.C0 = i3;
        } else {
            this.D0 = 0;
        }
        if (z17) {
            D();
        }
    }

    public void setCurrentItem(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            setCurrentItem(i3, z16, false);
        } else {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    public void setCurrentItem(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.f251435a0 = false;
            K(i3, z16, z17);
        }
    }

    public void setPageMarginDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            setPageMarginDrawable(getResources().getDrawable(i3));
        } else {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        }
    }

    public MultiAIOBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f251438d = 0;
        this.f251445h = true;
        this.f251452m = new ArrayList<>();
        this.C = new e();
        this.D = new Rect();
        this.G = -1;
        this.H = null;
        this.I = null;
        this.R = -3.4028235E38f;
        this.S = Float.MAX_VALUE;
        this.f251436b0 = 1;
        this.f251451l0 = -1;
        this.f251461u0 = true;
        this.f251462v0 = false;
        this.F0 = new f(this);
        this.G0 = new Runnable() { // from class: com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiAIOBaseViewPager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MultiAIOBaseViewPager.this.M(0);
                    MultiAIOBaseViewPager.this.D();
                }
            }
        };
        this.H0 = 0;
        u();
    }
}
