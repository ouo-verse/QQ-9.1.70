package com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager;

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
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class OrientedViewPager extends ViewGroup {
    static IPatchRedirector $redirector_;
    private static final int[] C0;
    private static final Comparator<c> D0;
    private static final Interpolator E0;
    private static final j F0;
    private final Runnable A0;
    private int B0;
    private int C;
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
    private int f71040a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f71041b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f71042c0;

    /* renamed from: d, reason: collision with root package name */
    private int f71043d;

    /* renamed from: d0, reason: collision with root package name */
    private float f71044d0;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<c> f71045e;

    /* renamed from: e0, reason: collision with root package name */
    private float f71046e0;

    /* renamed from: f, reason: collision with root package name */
    private final c f71047f;

    /* renamed from: f0, reason: collision with root package name */
    private float f71048f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f71049g0;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f71050h;

    /* renamed from: h0, reason: collision with root package name */
    private int f71051h0;

    /* renamed from: i, reason: collision with root package name */
    private Orientation f71052i;

    /* renamed from: i0, reason: collision with root package name */
    private VelocityTracker f71053i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f71054j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f71055k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f71056l0;

    /* renamed from: m, reason: collision with root package name */
    private PagerAdapter f71057m;

    /* renamed from: m0, reason: collision with root package name */
    private int f71058m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f71059n0;

    /* renamed from: o0, reason: collision with root package name */
    private EdgeEffectCompat f71060o0;

    /* renamed from: p0, reason: collision with root package name */
    private EdgeEffectCompat f71061p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f71062q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f71063r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f71064s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f71065t0;

    /* renamed from: u0, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f71066u0;

    /* renamed from: v0, reason: collision with root package name */
    private ViewPager.OnPageChangeListener f71067v0;

    /* renamed from: w0, reason: collision with root package name */
    private ViewPager.PageTransformer f71068w0;

    /* renamed from: x0, reason: collision with root package name */
    private Method f71069x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f71070y0;

    /* renamed from: z0, reason: collision with root package name */
    private ArrayList<View> f71071z0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Orientation {
        private static final /* synthetic */ Orientation[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Orientation HORIZONTAL;
        public static final Orientation VERTICAL;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54707);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Orientation orientation = new Orientation("VERTICAL", 0);
            VERTICAL = orientation;
            Orientation orientation2 = new Orientation("HORIZONTAL", 1);
            HORIZONTAL = orientation2;
            $VALUES = new Orientation[]{orientation, orientation2};
        }

        Orientation(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Orientation valueOf(String str) {
            return (Orientation) Enum.valueOf(Orientation.class, str);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }
    }

    /* loaded from: classes3.dex */
    public static class ViewPagerSavedState extends View.BaseSavedState {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<ViewPagerSavedState> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        int f71079d;

        /* renamed from: e, reason: collision with root package name */
        Parcelable f71080e;

        /* renamed from: f, reason: collision with root package name */
        ClassLoader f71081f;

        /* loaded from: classes3.dex */
        class a implements g<ViewPagerSavedState> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.OrientedViewPager.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ViewPagerSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (ViewPagerSavedState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, (Object) classLoader);
                }
                return new ViewPagerSavedState(parcel, classLoader);
            }

            @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.OrientedViewPager.g
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ViewPagerSavedState[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (ViewPagerSavedState[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new ViewPagerSavedState[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54720);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = f.a(new a());
            }
        }

        public ViewPagerSavedState(Parcelable parcelable) {
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
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f71079d + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
                return;
            }
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f71079d);
            parcel.writeParcelable(this.f71080e, i3);
        }

        ViewPagerSavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, (Object) classLoader);
                return;
            }
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f71079d = parcel.readInt();
            this.f71080e = parcel.readParcelable(classLoader);
            this.f71081f = classLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
            return cVar.f71083b - cVar2.f71083b;
        }
    }

    /* loaded from: classes3.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Object f71082a;

        /* renamed from: b, reason: collision with root package name */
        int f71083b;

        /* renamed from: c, reason: collision with root package name */
        boolean f71084c;

        /* renamed from: d, reason: collision with root package name */
        float f71085d;

        /* renamed from: e, reason: collision with root package name */
        float f71086e;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ c(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OrientedViewPager.this);
            }
        }

        private boolean canScroll() {
            if (OrientedViewPager.this.f71057m != null && OrientedViewPager.this.f71057m.getF373114d() > 1) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
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
            if (accessibilityEvent.getEventType() == 4096 && OrientedViewPager.this.f71057m != null) {
                obtain.setItemCount(OrientedViewPager.this.f71057m.getF373114d());
                obtain.setFromIndex(OrientedViewPager.this.C);
                obtain.setToIndex(OrientedViewPager.this.C);
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
            if (OrientedViewPager.this.f71052i == Orientation.VERTICAL) {
                if (OrientedViewPager.this.y(1)) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
                if (OrientedViewPager.this.y(-1)) {
                    accessibilityNodeInfoCompat.addAction(8192);
                    return;
                }
                return;
            }
            if (OrientedViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (OrientedViewPager.this.canScrollHorizontally(-1)) {
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
                if (i3 != 8192) {
                    return false;
                }
                if ((OrientedViewPager.this.f71052i != Orientation.VERTICAL || !OrientedViewPager.this.y(-1)) && (OrientedViewPager.this.f71052i != Orientation.HORIZONTAL || !OrientedViewPager.this.canScrollHorizontally(-1))) {
                    return false;
                }
                OrientedViewPager orientedViewPager = OrientedViewPager.this;
                orientedViewPager.setCurrentItem(orientedViewPager.C - 1);
                return true;
            }
            if ((OrientedViewPager.this.f71052i != Orientation.VERTICAL || !OrientedViewPager.this.y(1)) && (OrientedViewPager.this.f71052i != Orientation.HORIZONTAL || !OrientedViewPager.this.canScrollHorizontally(1))) {
                return false;
            }
            OrientedViewPager orientedViewPager2 = OrientedViewPager.this;
            orientedViewPager2.setCurrentItem(orientedViewPager2.C + 1);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    private class e extends DataSetObserver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) OrientedViewPager.this);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                OrientedViewPager.this.k();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                OrientedViewPager.this.k();
            }
        }

        /* synthetic */ e(OrientedViewPager orientedViewPager, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) orientedViewPager, (Object) aVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        public static <T> Parcelable.Creator<T> a(g<T> gVar) {
            return i.a(gVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface g<T> {
        T createFromParcel(Parcel parcel, ClassLoader classLoader);

        T[] newArray(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class h<T> implements Parcelable.ClassLoaderCreator<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final g<T> f71089a;

        public h(g<T> gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            } else {
                this.f71089a = gVar;
            }
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f71089a.createFromParcel(parcel, null) : (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (T[]) ((Object[]) iPatchRedirector.redirect((short) 4, (Object) this, i3));
            }
            return this.f71089a.newArray(i3);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f71089a.createFromParcel(parcel, classLoader) : (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, (Object) classLoader);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class i {
        static IPatchRedirector $redirector_;

        public static <T> Parcelable.Creator<T> a(g<T> gVar) {
            return new h(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class j implements Comparator<View> {
        static IPatchRedirector $redirector_;

        j() {
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
            boolean z16 = layoutParams.f71072a;
            if (z16 != layoutParams2.f71072a) {
                if (z16) {
                    return 1;
                }
                return -1;
            }
            return layoutParams.f71077f - layoutParams2.f71077f;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54726);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 54)) {
            redirector.redirect((short) 54);
            return;
        }
        C0 = new int[]{R.attr.layout_gravity};
        D0 = new a();
        E0 = new b();
        F0 = new j();
    }

    public OrientedViewPager(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f71045e = new ArrayList<>();
        this.f71047f = new c(null);
        this.f71050h = new Rect();
        this.f71052i = Orientation.HORIZONTAL;
        this.D = -1;
        this.E = null;
        this.F = null;
        this.M = -3.4028235E38f;
        this.N = Float.MAX_VALUE;
        this.U = 1;
        this.f71051h0 = -1;
        this.f71062q0 = true;
        this.f71063r0 = false;
        this.A0 = new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.OrientedViewPager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OrientedViewPager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    OrientedViewPager.this.P(0);
                    OrientedViewPager.this.G();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.B0 = 0;
        x();
    }

    private void B(MotionEvent motionEvent) {
        int i3;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f71051h0) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.f71052i == Orientation.VERTICAL) {
                this.f71046e0 = MotionEventCompat.getY(motionEvent, i3);
            } else {
                this.f71044d0 = MotionEventCompat.getX(motionEvent, i3);
            }
            this.f71051h0 = MotionEventCompat.getPointerId(motionEvent, i3);
            VelocityTracker velocityTracker = this.f71053i0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean E(int i3) {
        if (this.f71045e.size() == 0) {
            this.f71064s0 = false;
            A(0, 0.0f, 0);
            if (this.f71064s0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        c v3 = v();
        int r16 = r();
        int i16 = this.I;
        int i17 = r16 + i16;
        float f16 = r16;
        int i18 = v3.f71083b;
        float f17 = ((i3 / f16) - v3.f71086e) / (v3.f71085d + (i16 / f16));
        this.f71064s0 = false;
        A(i18, f17, (int) (i17 * f17));
        if (this.f71064s0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean F(float f16) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        boolean z19 = false;
        if (this.f71052i == Orientation.VERTICAL) {
            float f17 = this.f71046e0 - f16;
            this.f71046e0 = f16;
            float scrollY = getScrollY() + f17;
            float r16 = r();
            float f18 = this.M * r16;
            float f19 = this.N * r16;
            c cVar = this.f71045e.get(0);
            ArrayList<c> arrayList = this.f71045e;
            c cVar2 = arrayList.get(arrayList.size() - 1);
            if (cVar.f71083b != 0) {
                f18 = cVar.f71086e * r16;
                z17 = false;
            } else {
                z17 = true;
            }
            if (cVar2.f71083b != this.f71057m.getF373114d() - 1) {
                f19 = cVar2.f71086e * r16;
                z18 = false;
            }
            if (scrollY < f18) {
                if (z17) {
                    z19 = this.f71060o0.onPull(Math.abs(f18 - scrollY) / r16);
                }
                scrollY = f18;
            } else if (scrollY > f19) {
                if (z18) {
                    z19 = this.f71061p0.onPull(Math.abs(scrollY - f19) / r16);
                }
                scrollY = f19;
            }
            int i3 = (int) scrollY;
            this.f71044d0 += scrollY - i3;
            scrollTo(getScrollX(), i3);
            E(i3);
        } else {
            float f26 = this.f71044d0 - f16;
            this.f71044d0 = f16;
            float scrollX = getScrollX() + f26;
            float r17 = r();
            float f27 = this.M * r17;
            float f28 = this.N * r17;
            c cVar3 = this.f71045e.get(0);
            ArrayList<c> arrayList2 = this.f71045e;
            c cVar4 = arrayList2.get(arrayList2.size() - 1);
            if (cVar3.f71083b != 0) {
                f27 = cVar3.f71086e * r17;
                z16 = false;
            } else {
                z16 = true;
            }
            if (cVar4.f71083b != this.f71057m.getF373114d() - 1) {
                f28 = cVar4.f71086e * r17;
                z18 = false;
            }
            if (scrollX < f27) {
                if (z16) {
                    z19 = this.f71060o0.onPull(Math.abs(f27 - scrollX) / r17);
                }
                scrollX = f27;
            } else if (scrollX > f28) {
                if (z18) {
                    z19 = this.f71061p0.onPull(Math.abs(scrollX - f28) / r17);
                }
                scrollX = f28;
            }
            int i16 = (int) scrollX;
            this.f71044d0 += scrollX - i16;
            scrollTo(i16, getScrollY());
            E(i16);
        }
        return z19;
    }

    private void I(int i3, int i16, int i17, int i18) {
        float f16 = 0.0f;
        if (this.f71052i == Orientation.VERTICAL) {
            if (i16 > 0 && !this.f71045e.isEmpty()) {
                int scrollY = (int) ((getScrollY() / (((i16 - getPaddingTop()) - getPaddingBottom()) + i18)) * (((i3 - getPaddingTop()) - getPaddingBottom()) + i17));
                scrollTo(getScrollX(), scrollY);
                if (!this.G.isFinished()) {
                    this.G.startScroll(0, scrollY, 0, (int) (w(this.C).f71086e * i3), this.G.getDuration() - this.G.timePassed());
                    return;
                }
                return;
            }
            c w3 = w(this.C);
            if (w3 != null) {
                f16 = Math.min(w3.f71086e, this.N);
            }
            int paddingTop = (int) (f16 * ((i3 - getPaddingTop()) - getPaddingBottom()));
            if (paddingTop != getScrollY()) {
                j(false);
                scrollTo(getScrollX(), paddingTop);
                return;
            }
            return;
        }
        if (i16 > 0 && !this.f71045e.isEmpty()) {
            int scrollX = (int) ((getScrollX() / (((i16 - getPaddingLeft()) - getPaddingRight()) + i18)) * (((i3 - getPaddingLeft()) - getPaddingRight()) + i17));
            scrollTo(scrollX, getScrollY());
            if (!this.G.isFinished()) {
                this.G.startScroll(scrollX, 0, (int) (w(this.C).f71086e * i3), 0, this.G.getDuration() - this.G.timePassed());
                return;
            }
            return;
        }
        c w16 = w(this.C);
        if (w16 != null) {
            f16 = Math.min(w16.f71086e, this.N);
        }
        int paddingLeft = (int) (f16 * ((i3 - getPaddingLeft()) - getPaddingRight()));
        if (paddingLeft != getScrollX()) {
            j(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    private void J() {
        int i3 = 0;
        while (i3 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i3).getLayoutParams()).f71072a) {
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
        ViewPager.OnPageChangeListener onPageChangeListener2;
        ViewPager.OnPageChangeListener onPageChangeListener3;
        ViewPager.OnPageChangeListener onPageChangeListener4;
        c w3 = w(i3);
        if (w3 != null) {
            i17 = (int) (r() * Math.max(this.M, Math.min(w3.f71086e, this.N)));
        } else {
            i17 = 0;
        }
        if (z16) {
            if (this.f71052i == Orientation.VERTICAL) {
                R(0, i17, i16);
            } else {
                R(i17, 0, i16);
            }
            if (z17 && (onPageChangeListener4 = this.f71066u0) != null) {
                onPageChangeListener4.onPageSelected(i3);
            }
            if (z17 && (onPageChangeListener3 = this.f71067v0) != null) {
                onPageChangeListener3.onPageSelected(i3);
                return;
            }
            return;
        }
        if (z17 && (onPageChangeListener2 = this.f71066u0) != null) {
            onPageChangeListener2.onPageSelected(i3);
        }
        if (z17 && (onPageChangeListener = this.f71067v0) != null) {
            onPageChangeListener.onPageSelected(i3);
        }
        j(false);
        if (this.f71052i == Orientation.VERTICAL) {
            scrollTo(0, i17);
        } else {
            scrollTo(i17, 0);
        }
        E(i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i3) {
        boolean z16;
        if (this.B0 == i3) {
            return;
        }
        this.B0 = i3;
        if (this.f71068w0 != null) {
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            n(z16);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f71066u0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
    }

    private void Q(boolean z16) {
        if (this.S != z16) {
            this.S = z16;
        }
    }

    private void S() {
        if (this.f71070y0 != 0) {
            ArrayList<View> arrayList = this.f71071z0;
            if (arrayList == null) {
                this.f71071z0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.f71071z0.add(getChildAt(i3));
            }
            Collections.sort(this.f71071z0, F0);
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
        int f373114d = this.f71057m.getF373114d();
        int r16 = r();
        if (r16 > 0) {
            f16 = this.I / r16;
        } else {
            f16 = 0.0f;
        }
        if (cVar2 != null) {
            int i18 = cVar2.f71083b;
            int i19 = cVar.f71083b;
            if (i18 < i19) {
                float f19 = cVar2.f71086e + cVar2.f71085d + f16;
                int i26 = i18 + 1;
                int i27 = 0;
                while (i26 <= cVar.f71083b && i27 < this.f71045e.size()) {
                    c cVar5 = this.f71045e.get(i27);
                    while (true) {
                        cVar4 = cVar5;
                        if (i26 <= cVar4.f71083b || i27 >= this.f71045e.size() - 1) {
                            break;
                        }
                        i27++;
                        cVar5 = this.f71045e.get(i27);
                    }
                    while (i26 < cVar4.f71083b) {
                        f19 += this.f71057m.getPageWidth(i26) + f16;
                        i26++;
                    }
                    cVar4.f71086e = f19;
                    f19 += cVar4.f71085d + f16;
                    i26++;
                }
            } else if (i18 > i19) {
                int size = this.f71045e.size() - 1;
                float f26 = cVar2.f71086e;
                while (true) {
                    i18--;
                    if (i18 < cVar.f71083b || size < 0) {
                        break;
                    }
                    c cVar6 = this.f71045e.get(size);
                    while (true) {
                        cVar3 = cVar6;
                        if (i18 >= cVar3.f71083b || size <= 0) {
                            break;
                        }
                        size--;
                        cVar6 = this.f71045e.get(size);
                    }
                    while (i18 > cVar3.f71083b) {
                        f26 -= this.f71057m.getPageWidth(i18) + f16;
                        i18--;
                    }
                    f26 -= cVar3.f71085d + f16;
                    cVar3.f71086e = f26;
                }
            }
        }
        int size2 = this.f71045e.size();
        float f27 = cVar.f71086e;
        int i28 = cVar.f71083b;
        int i29 = i28 - 1;
        if (i28 == 0) {
            f17 = f27;
        } else {
            f17 = -3.4028235E38f;
        }
        this.M = f17;
        int i36 = f373114d - 1;
        if (i28 == i36) {
            f18 = (cVar.f71085d + f27) - 1.0f;
        } else {
            f18 = Float.MAX_VALUE;
        }
        this.N = f18;
        int i37 = i3 - 1;
        while (i37 >= 0) {
            c cVar7 = this.f71045e.get(i37);
            while (true) {
                i17 = cVar7.f71083b;
                if (i29 <= i17) {
                    break;
                }
                f27 -= this.f71057m.getPageWidth(i29) + f16;
                i29--;
            }
            f27 -= cVar7.f71085d + f16;
            cVar7.f71086e = f27;
            if (i17 == 0) {
                this.M = f27;
            }
            i37--;
            i29--;
        }
        float f28 = cVar.f71086e + cVar.f71085d + f16;
        int i38 = cVar.f71083b + 1;
        int i39 = i3 + 1;
        while (i39 < size2) {
            c cVar8 = this.f71045e.get(i39);
            while (true) {
                i16 = cVar8.f71083b;
                if (i38 >= i16) {
                    break;
                }
                f28 += this.f71057m.getPageWidth(i38) + f16;
                i38++;
            }
            if (i16 == i36) {
                this.N = (cVar8.f71085d + f28) - 1.0f;
            }
            cVar8.f71086e = f28;
            f28 += cVar8.f71085d + f16;
            i39++;
            i38++;
        }
        this.f71063r0 = false;
    }

    private void j(boolean z16) {
        boolean z17;
        if (this.B0 == 2) {
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
        for (int i3 = 0; i3 < this.f71045e.size(); i3++) {
            c cVar = this.f71045e.get(i3);
            if (cVar.f71084c) {
                cVar.f71084c = false;
                z17 = true;
            }
        }
        if (z17) {
            if (z16) {
                ViewCompat.postOnAnimation(this, this.A0);
            } else {
                this.A0.run();
            }
        }
    }

    private int l(int i3, float f16, int i16, int i17) {
        float f17;
        if (Math.abs(i17) > this.f71056l0 && Math.abs(i16) > this.f71054j0) {
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
        if (this.f71045e.size() > 0) {
            return Math.max(this.f71045e.get(0).f71083b, Math.min(i3, this.f71045e.get(r4.size() - 1).f71083b));
        }
        return i3;
    }

    @SuppressLint({"WrongConstant"})
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
        VelocityTracker velocityTracker = this.f71053i0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f71053i0 = null;
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
        int measuredWidth;
        int paddingRight;
        if (this.f71052i == Orientation.VERTICAL) {
            measuredWidth = getMeasuredHeight() - getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth() - getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        return measuredWidth - paddingRight;
    }

    private c v() {
        float f16;
        float f17;
        int i3;
        int scrollX;
        int r16 = r();
        float f18 = 0.0f;
        if (r16 > 0) {
            if (this.f71052i == Orientation.VERTICAL) {
                scrollX = getScrollY();
            } else {
                scrollX = getScrollX();
            }
            f16 = scrollX / r16;
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
        while (i16 < this.f71045e.size()) {
            c cVar2 = this.f71045e.get(i16);
            if (!z16 && cVar2.f71083b != (i3 = i17 + 1)) {
                cVar2 = this.f71047f;
                cVar2.f71086e = f18 + f19 + f17;
                cVar2.f71083b = i3;
                cVar2.f71085d = this.f71057m.getPageWidth(i3);
                i16--;
            }
            c cVar3 = cVar2;
            f18 = cVar3.f71086e;
            float f26 = cVar3.f71085d + f18 + f17;
            if (!z16 && f16 < f18) {
                return cVar;
            }
            if (f16 >= f26 && i16 != this.f71045e.size() - 1) {
                int i18 = cVar3.f71083b;
                float f27 = cVar3.f71085d;
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
        int width;
        if (f16 >= this.f71041b0 || f17 <= 0.0f) {
            if (this.f71052i == Orientation.VERTICAL) {
                width = getHeight();
            } else {
                width = getWidth();
            }
            if (f16 <= width - this.f71041b0 || f17 >= 0.0f) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void A(int i3, float f16, int i16) {
        int scrollX;
        int left;
        int max;
        int i17;
        int left2;
        int max2;
        int i18;
        int top;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        if (this.f71065t0 > 0) {
            if (this.f71052i == Orientation.VERTICAL) {
                int scrollY = getScrollY();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int childCount = getChildCount();
                for (int i19 = 0; i19 < childCount; i19++) {
                    View childAt = getChildAt(i19);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.f71072a) {
                        int i26 = layoutParams.f71073b & 112;
                        if (i26 != 16) {
                            if (i26 != 48) {
                                if (i26 != 80) {
                                    i18 = paddingTop;
                                } else {
                                    max2 = (height - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                            } else {
                                i18 = childAt.getHeight() + paddingTop;
                            }
                            top = (paddingTop + scrollY) - childAt.getTop();
                            if (top != 0) {
                                childAt.offsetTopAndBottom(top);
                            }
                            paddingTop = i18;
                        } else {
                            max2 = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i27 = max2;
                        i18 = paddingTop;
                        paddingTop = i27;
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                        }
                        paddingTop = i18;
                    }
                }
            } else {
                int scrollX2 = getScrollX();
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int width = getWidth();
                int childCount2 = getChildCount();
                for (int i28 = 0; i28 < childCount2; i28++) {
                    View childAt2 = getChildAt(i28);
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (layoutParams2.f71072a) {
                        int i29 = layoutParams2.f71073b & 7;
                        if (i29 != 1) {
                            if (i29 != 3) {
                                if (i29 != 5) {
                                    i17 = paddingLeft;
                                } else {
                                    max = (width - paddingRight) - childAt2.getMeasuredWidth();
                                    paddingRight += childAt2.getMeasuredWidth();
                                }
                            } else {
                                i17 = childAt2.getWidth() + paddingLeft;
                            }
                            left2 = (paddingLeft + scrollX2) - childAt2.getLeft();
                            if (left2 != 0) {
                                childAt2.offsetLeftAndRight(left2);
                            }
                            paddingLeft = i17;
                        } else {
                            max = Math.max((width - childAt2.getMeasuredWidth()) / 2, paddingLeft);
                        }
                        int i36 = paddingLeft;
                        paddingLeft = max;
                        i17 = i36;
                        left2 = (paddingLeft + scrollX2) - childAt2.getLeft();
                        if (left2 != 0) {
                        }
                        paddingLeft = i17;
                    }
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f71066u0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f16, i16);
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.f71067v0;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i3, f16, i16);
        }
        if (this.f71068w0 != null) {
            if (this.f71052i == Orientation.VERTICAL) {
                scrollX = getScrollY();
            } else {
                scrollX = getScrollX();
            }
            int childCount3 = getChildCount();
            for (int i37 = 0; i37 < childCount3; i37++) {
                View childAt3 = getChildAt(i37);
                if (!((LayoutParams) childAt3.getLayoutParams()).f71072a) {
                    if (this.f71052i == Orientation.VERTICAL) {
                        left = childAt3.getTop();
                    } else {
                        left = childAt3.getLeft();
                    }
                    this.f71068w0.transformPage(childAt3, (left - scrollX) / r());
                }
            }
        }
        this.f71064s0 = true;
    }

    boolean C() {
        int i3 = this.C;
        if (i3 > 0) {
            setCurrentItem(i3 - 1, true);
            return true;
        }
        return false;
    }

    boolean D() {
        PagerAdapter pagerAdapter = this.f71057m;
        if (pagerAdapter != null && this.C < pagerAdapter.getF373114d() - 1) {
            setCurrentItem(this.C + 1, true);
            return true;
        }
        return false;
    }

    void G() {
        H(this.C);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r10 == r11) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void H(int i3) {
        int i16;
        c cVar;
        String hexString;
        c cVar2;
        Object obj;
        c u16;
        c cVar3;
        c u17;
        c cVar4;
        float paddingLeft;
        c cVar5;
        float paddingRight;
        c cVar6;
        int i17 = this.C;
        if (i17 != i3) {
            if (i17 < i3) {
                i16 = 130;
            } else {
                i16 = 33;
            }
            cVar = w(i17);
            this.C = i3;
        } else {
            i16 = 2;
            cVar = null;
        }
        if (this.f71057m == null) {
            S();
            return;
        }
        if (this.T) {
            S();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.f71057m.startUpdate((ViewGroup) this);
        int i18 = this.U;
        int max = Math.max(0, this.C - i18);
        int f373114d = this.f71057m.getF373114d();
        int min = Math.min(f373114d - 1, this.C + i18);
        if (f373114d == this.f71043d) {
            int i19 = 0;
            while (true) {
                if (i19 >= this.f71045e.size()) {
                    break;
                }
                cVar2 = this.f71045e.get(i19);
                int i26 = cVar2.f71083b;
                int i27 = this.C;
                if (i26 < i27) {
                    i19++;
                }
            }
            cVar2 = null;
            if (cVar2 == null && f373114d > 0) {
                cVar2 = f(this.C, i19);
            }
            if (cVar2 != null) {
                int i28 = i19 - 1;
                if (i28 >= 0) {
                    cVar4 = this.f71045e.get(i28);
                } else {
                    cVar4 = null;
                }
                int r16 = r();
                if (r16 <= 0) {
                    paddingLeft = 0.0f;
                } else {
                    paddingLeft = (2.0f - cVar2.f71085d) + (getPaddingLeft() / r16);
                }
                float f16 = 0.0f;
                for (int i29 = this.C - 1; i29 >= 0; i29--) {
                    if (f16 >= paddingLeft && i29 < max) {
                        if (cVar4 == null) {
                            break;
                        }
                        if (i29 == cVar4.f71083b && !cVar4.f71084c) {
                            this.f71045e.remove(i28);
                            this.f71057m.destroyItem((ViewGroup) this, i29, cVar4.f71082a);
                            i28--;
                            i19--;
                            if (i28 >= 0) {
                                cVar6 = this.f71045e.get(i28);
                                cVar4 = cVar6;
                            }
                            cVar6 = null;
                            cVar4 = cVar6;
                        }
                    } else if (cVar4 != null && i29 == cVar4.f71083b) {
                        f16 += cVar4.f71085d;
                        i28--;
                        if (i28 >= 0) {
                            cVar6 = this.f71045e.get(i28);
                            cVar4 = cVar6;
                        }
                        cVar6 = null;
                        cVar4 = cVar6;
                    } else {
                        f16 += f(i29, i28 + 1).f71085d;
                        i19++;
                        if (i28 >= 0) {
                            cVar6 = this.f71045e.get(i28);
                            cVar4 = cVar6;
                        }
                        cVar6 = null;
                        cVar4 = cVar6;
                    }
                }
                float f17 = cVar2.f71085d;
                int i36 = i19 + 1;
                if (f17 < 2.0f) {
                    if (i36 < this.f71045e.size()) {
                        cVar5 = this.f71045e.get(i36);
                    } else {
                        cVar5 = null;
                    }
                    if (r16 <= 0) {
                        paddingRight = 0.0f;
                    } else {
                        paddingRight = (getPaddingRight() / r16) + 2.0f;
                    }
                    int i37 = this.C;
                    while (true) {
                        i37++;
                        if (i37 >= f373114d) {
                            break;
                        }
                        if (f17 >= paddingRight && i37 > min) {
                            if (cVar5 == null) {
                                break;
                            }
                            if (i37 == cVar5.f71083b && !cVar5.f71084c) {
                                this.f71045e.remove(i36);
                                this.f71057m.destroyItem((ViewGroup) this, i37, cVar5.f71082a);
                                if (i36 < this.f71045e.size()) {
                                    cVar5 = this.f71045e.get(i36);
                                } else {
                                    cVar5 = null;
                                }
                            }
                        } else if (cVar5 != null && i37 == cVar5.f71083b) {
                            f17 += cVar5.f71085d;
                            i36++;
                            if (i36 >= this.f71045e.size()) {
                                cVar5 = null;
                            } else {
                                cVar5 = this.f71045e.get(i36);
                            }
                        } else {
                            c f18 = f(i37, i36);
                            i36++;
                            f17 += f18.f71085d;
                            if (i36 >= this.f71045e.size()) {
                                cVar5 = null;
                            } else {
                                cVar5 = this.f71045e.get(i36);
                            }
                        }
                    }
                }
                h(cVar2, i19, cVar);
            }
            PagerAdapter pagerAdapter = this.f71057m;
            int i38 = this.C;
            if (cVar2 != null) {
                obj = cVar2.f71082a;
            } else {
                obj = null;
            }
            pagerAdapter.setPrimaryItem((ViewGroup) this, i38, obj);
            this.f71057m.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            if (this.f71052i == Orientation.VERTICAL) {
                for (int i39 = 0; i39 < childCount; i39++) {
                    View childAt = getChildAt(i39);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.f71078g = i39;
                    if (!layoutParams.f71072a && layoutParams.f71074c == 0.0f && (u17 = u(childAt)) != null) {
                        layoutParams.f71074c = u17.f71085d;
                        layoutParams.f71077f = u17.f71083b;
                    }
                }
            } else {
                for (int i46 = 0; i46 < childCount; i46++) {
                    View childAt2 = getChildAt(i46);
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    layoutParams2.f71078g = i46;
                    if (!layoutParams2.f71072a && layoutParams2.f71075d == 0.0f && (u16 = u(childAt2)) != null) {
                        layoutParams2.f71075d = u16.f71085d;
                        layoutParams2.f71077f = u16.f71083b;
                    }
                }
            }
            S();
            if (hasFocus()) {
                View findFocus = findFocus();
                if (findFocus != null) {
                    cVar3 = t(findFocus);
                } else {
                    cVar3 = null;
                }
                if (cVar3 == null || cVar3.f71083b != this.C) {
                    for (int i47 = 0; i47 < getChildCount(); i47++) {
                        View childAt3 = getChildAt(i47);
                        c u18 = u(childAt3);
                        if (u18 != null && u18.f71083b == this.C && childAt3.requestFocus(i16)) {
                            return;
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
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f71043d + ", found: " + f373114d + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f71057m.getClass());
    }

    void M(boolean z16) {
        if (this.f71069x0 == null) {
            try {
                this.f71069x0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e16) {
                Log.e("OrientedViewPager", "Can't find setChildrenDrawingOrderEnabled", e16);
            }
        }
        try {
            this.f71069x0.invoke(this, Boolean.valueOf(z16));
        } catch (Exception e17) {
            Log.e("OrientedViewPager", "Error changing children drawing order", e17);
        }
    }

    void N(int i3, boolean z16, boolean z17) {
        O(i3, z16, z17, 0);
    }

    void O(int i3, boolean z16, boolean z17, int i16) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        PagerAdapter pagerAdapter = this.f71057m;
        boolean z18 = false;
        if (pagerAdapter != null && pagerAdapter.getF373114d() > 0) {
            if (!z17 && this.C == i3 && this.f71045e.size() != 0) {
                Q(false);
                return;
            }
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 >= this.f71057m.getF373114d()) {
                i3 = this.f71057m.getF373114d() - 1;
            }
            int i17 = this.U;
            int i18 = this.C;
            if (i3 > i18 + i17 || i3 < i18 - i17) {
                for (int i19 = 0; i19 < this.f71045e.size(); i19++) {
                    this.f71045e.get(i19).f71084c = true;
                }
            }
            if (this.C != i3) {
                z18 = true;
            }
            if (this.f71062q0) {
                this.C = i3;
                if (z18 && (onPageChangeListener2 = this.f71066u0) != null) {
                    onPageChangeListener2.onPageSelected(i3);
                }
                if (z18 && (onPageChangeListener = this.f71067v0) != null) {
                    onPageChangeListener.onPageSelected(i3);
                }
                requestLayout();
                return;
            }
            H(i3);
            L(i3, z16, i16, z18);
            return;
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
            abs = (int) (((Math.abs(i18) / ((f16 * this.f71057m.getPageWidth(this.C)) + this.I)) + 1.0f) * 100.0f);
        }
        this.G.startScroll(scrollX, scrollY, i18, i19, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i16) {
        c u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, arrayList, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                if (childAt.getVisibility() == 0 && (u16 = u(childAt)) != null && u16.f71083b == this.C) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) arrayList);
            return;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (u16 = u(childAt)) != null && u16.f71083b == this.C) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, view, Integer.valueOf(i3), layoutParams);
            return;
        }
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z16 = false | layoutParams2.f71072a;
        layoutParams2.f71072a = z16;
        if (this.R) {
            if (!z16) {
                layoutParams2.f71076e = true;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this, (Object) layoutParams)).booleanValue();
        }
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (!this.G.isFinished() && this.G.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.G.getCurrX();
            int currY = this.G.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (this.f71052i == Orientation.VERTICAL) {
                    if (!E(currY)) {
                        this.G.abortAnimation();
                        scrollTo(currX, 0);
                    }
                } else if (!E(currX)) {
                    this.G.abortAnimation();
                    scrollTo(0, currY);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (!super.dispatchKeyEvent(keyEvent) && !p(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        c u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, (Object) accessibilityEvent)).booleanValue();
        }
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (u16 = u(childAt)) != null && u16.f71083b == this.C && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z16 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f71057m) == null || pagerAdapter.getF373114d() <= 1)) {
            this.f71060o0.finish();
            this.f71061p0.finish();
        } else if (this.f71052i == Orientation.VERTICAL) {
            if (!this.f71060o0.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.M * height);
                this.f71060o0.setSize(width, height);
                z16 = false | this.f71060o0.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f71061p0.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.N + 1.0f)) * height2);
                this.f71061p0.setSize(width2, height2);
                z16 |= this.f71061p0.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            if (!this.f71060o0.isFinished()) {
                int save3 = canvas.save();
                int height3 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width3 = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height3) + getPaddingTop(), this.M * width3);
                this.f71060o0.setSize(height3, width3);
                z16 = false | this.f71060o0.draw(canvas);
                canvas.restoreToCount(save3);
            }
            if (!this.f71061p0.isFinished()) {
                int save4 = canvas.save();
                int width4 = getWidth();
                int height4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.N + 1.0f)) * width4);
                this.f71061p0.setSize(height4, width4);
                z16 |= this.f71061p0.draw(canvas);
                canvas.restoreToCount(save4);
            }
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.drawableStateChanged();
        Drawable drawable = this.J;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    c f(int i3, int i16) {
        c cVar = new c(null);
        cVar.f71083b = i3;
        cVar.f71082a = this.f71057m.instantiateItem((ViewGroup) this, i3);
        cVar.f71085d = this.f71057m.getPageWidth(i3);
        if (i16 >= 0 && i16 < this.f71045e.size()) {
            this.f71045e.add(i16, cVar);
        } else {
            this.f71045e.add(cVar);
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(int i3) {
        boolean z16;
        View findNextFocus;
        boolean requestFocus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, i3)).booleanValue();
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
                    Log.e("OrientedViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb5.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i3 == 33) {
                    if (this.f71052i == Orientation.VERTICAL) {
                        int i16 = q(this.f71050h, findNextFocus).top;
                        int i17 = q(this.f71050h, findFocus).top;
                        if (findFocus != null && i16 >= i17) {
                            requestFocus = C();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    } else {
                        int i18 = q(this.f71050h, findNextFocus).left;
                        int i19 = q(this.f71050h, findFocus).left;
                        if (findFocus != null && i18 >= i19) {
                            requestFocus = C();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    }
                } else if (i3 == 130) {
                    if (this.f71052i == Orientation.VERTICAL) {
                        int i26 = q(this.f71050h, findNextFocus).bottom;
                        int i27 = q(this.f71050h, findFocus).bottom;
                        if (findFocus != null && i26 <= i27) {
                            requestFocus = D();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    } else {
                        int i28 = q(this.f71050h, findNextFocus).left;
                        int i29 = q(this.f71050h, findFocus).left;
                        if (findFocus != null && i28 <= i29) {
                            requestFocus = D();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    }
                }
                z17 = requestFocus;
            } else if (i3 == 33 && i3 != 1) {
                if (i3 == 130 || i3 == 2) {
                    z17 = D();
                }
            } else {
                z17 = C();
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
        z17 = C();
        if (z17) {
        }
        return z17;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) ? generateDefaultLayoutParams() : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 51, (Object) this, (Object) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (this.f71070y0 == 2) {
            i16 = (i3 - 1) - i16;
        }
        return ((LayoutParams) this.f71071z0.get(i16).getLayoutParams()).f71078g;
    }

    protected boolean i(View view, boolean z16, int i3, int i16, int i17) {
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, this, view, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (this.f71052i == Orientation.VERTICAL) {
                    int i26 = i17 + scrollY;
                    if (i26 >= childAt.getTop() && i26 < childAt.getBottom() && (i19 = i16 + scrollX) >= childAt.getLeft() && i19 < childAt.getRight() && i(childAt, true, i3, i19 - childAt.getLeft(), i26 - childAt.getTop())) {
                        return true;
                    }
                } else {
                    int i27 = i16 + scrollX;
                    if (i27 >= childAt.getLeft() && i27 < childAt.getRight() && (i18 = i17 + scrollY) >= childAt.getTop() && i18 < childAt.getBottom() && i(childAt, true, i3, i27 - childAt.getLeft(), i18 - childAt.getTop())) {
                        return true;
                    }
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
        int f373114d = this.f71057m.getF373114d();
        this.f71043d = f373114d;
        if (this.f71045e.size() < (this.U * 2) + 1 && this.f71045e.size() < f373114d) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.C;
        int i16 = 0;
        boolean z17 = false;
        while (i16 < this.f71045e.size()) {
            c cVar = this.f71045e.get(i16);
            int itemPosition = this.f71057m.getItemPosition(cVar.f71082a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f71045e.remove(i16);
                    i16--;
                    if (!z17) {
                        this.f71057m.startUpdate((ViewGroup) this);
                        z17 = true;
                    }
                    this.f71057m.destroyItem((ViewGroup) this, cVar.f71083b, cVar.f71082a);
                    int i17 = this.C;
                    if (i17 == cVar.f71083b) {
                        i3 = Math.max(0, Math.min(i17, f373114d - 1));
                    }
                } else {
                    int i18 = cVar.f71083b;
                    if (i18 != itemPosition) {
                        if (i18 == this.C) {
                            i3 = itemPosition;
                        }
                        cVar.f71083b = itemPosition;
                    }
                }
                z16 = true;
            }
            i16++;
        }
        if (z17) {
            this.f71057m.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f71045e, D0);
        if (z16) {
            int childCount = getChildCount();
            for (int i19 = 0; i19 < childCount; i19++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i19).getLayoutParams();
                if (!layoutParams.f71072a) {
                    layoutParams.f71074c = 0.0f;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.f71062q0 = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            removeCallbacks(this.A0);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        float f16;
        float f17;
        int i16;
        int i17;
        float f18;
        int i18;
        float f19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.I > 0 && this.J != null && this.f71045e.size() > 0 && this.f71057m != null) {
            int i19 = 0;
            if (this.f71052i == Orientation.VERTICAL) {
                int scrollY = getScrollY();
                float height = getHeight();
                float f26 = this.I / height;
                c cVar = this.f71045e.get(0);
                float f27 = cVar.f71086e;
                int size = this.f71045e.size();
                int i26 = cVar.f71083b;
                int i27 = this.f71045e.get(size - 1).f71083b;
                while (i26 < i27) {
                    while (true) {
                        i17 = cVar.f71083b;
                        if (i26 <= i17 || i19 >= size) {
                            break;
                        }
                        i19++;
                        cVar = this.f71045e.get(i19);
                    }
                    if (i26 == i17) {
                        float f28 = cVar.f71086e;
                        float f29 = cVar.f71085d;
                        f18 = (f28 + f29) * height;
                        f27 = f28 + f29 + f26;
                    } else {
                        float pageWidth = this.f71057m.getPageWidth(i26);
                        f18 = (f27 + pageWidth) * height;
                        f27 += pageWidth + f26;
                    }
                    int i28 = this.I;
                    if (i28 + f18 > scrollY) {
                        i18 = i19;
                        f19 = f26;
                        this.J.setBounds(this.K, (int) f18, this.L, (int) (i28 + f18 + 0.5f));
                        this.J.draw(canvas);
                    } else {
                        i18 = i19;
                        f19 = f26;
                    }
                    if (f18 <= scrollY + r3) {
                        i26++;
                        i19 = i18;
                        f26 = f19;
                    } else {
                        return;
                    }
                }
                return;
            }
            int scrollX = getScrollX();
            float width = getWidth();
            float f36 = this.I / width;
            c cVar2 = this.f71045e.get(0);
            float f37 = cVar2.f71086e;
            int size2 = this.f71045e.size();
            int i29 = cVar2.f71083b;
            int i36 = this.f71045e.get(size2 - 1).f71083b;
            while (i29 < i36) {
                while (true) {
                    i3 = cVar2.f71083b;
                    if (i29 <= i3 || i19 >= size2) {
                        break;
                    }
                    i19++;
                    cVar2 = this.f71045e.get(i19);
                }
                if (i29 == i3) {
                    float f38 = cVar2.f71086e;
                    float f39 = cVar2.f71085d;
                    f16 = (f38 + f39) * width;
                    f37 = f38 + f39 + f36;
                } else {
                    float pageWidth2 = this.f71057m.getPageWidth(i29);
                    f16 = (f37 + pageWidth2) * width;
                    f37 += pageWidth2 + f36;
                }
                int i37 = this.I;
                if (i37 + f16 > scrollX) {
                    f17 = f36;
                    i16 = i19;
                    this.J.setBounds((int) f16, this.K, (int) (i37 + f16 + 0.5f), this.L);
                    this.J.draw(canvas);
                } else {
                    f17 = f36;
                    i16 = i19;
                }
                if (f16 <= scrollX + r3) {
                    i29++;
                    f36 = f17;
                    i19 = i16;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.V) {
                    return true;
                }
                if (this.W) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        B(motionEvent);
                    }
                } else {
                    int i3 = this.f71051h0;
                    if (i3 != -1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i3);
                        if (this.f71052i == Orientation.VERTICAL) {
                            float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                            float f18 = y16 - this.f71046e0;
                            float abs = Math.abs(f18);
                            float x16 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                            float abs2 = Math.abs(x16 - this.f71048f0);
                            if (f18 != 0.0f && !z(this.f71046e0, f18) && i(this, false, (int) f18, (int) x16, (int) y16)) {
                                this.f71044d0 = x16;
                                this.f71046e0 = y16;
                                this.W = true;
                                return false;
                            }
                            int i16 = this.f71042c0;
                            if (abs > i16 && abs * 0.5f > abs2) {
                                this.V = true;
                                K(true);
                                P(1);
                                if (f18 > 0.0f) {
                                    f17 = this.f71049g0 + this.f71042c0;
                                } else {
                                    f17 = this.f71049g0 - this.f71042c0;
                                }
                                this.f71046e0 = f17;
                                this.f71044d0 = x16;
                                Q(true);
                            } else if (abs2 > i16) {
                                this.W = true;
                            }
                            if (this.V && F(y16)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        } else {
                            float x17 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                            float f19 = x17 - this.f71044d0;
                            float abs3 = Math.abs(f19);
                            float y17 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                            float abs4 = Math.abs(y17 - this.f71049g0);
                            if (f19 != 0.0f && !z(this.f71044d0, f19) && i(this, false, (int) f19, (int) x17, (int) y17)) {
                                this.f71044d0 = x17;
                                this.f71046e0 = y17;
                                this.W = true;
                                return false;
                            }
                            int i17 = this.f71042c0;
                            if (abs3 > i17 && abs3 * 0.5f > abs4) {
                                this.V = true;
                                K(true);
                                P(1);
                                if (f19 > 0.0f) {
                                    f16 = this.f71048f0 + this.f71042c0;
                                } else {
                                    f16 = this.f71048f0 - this.f71042c0;
                                }
                                this.f71044d0 = f16;
                                this.f71046e0 = y17;
                                Q(true);
                            } else if (abs4 > i17) {
                                this.W = true;
                            }
                            if (this.V && F(x17)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    }
                }
            } else {
                float x18 = motionEvent.getX();
                this.f71048f0 = x18;
                this.f71044d0 = x18;
                float y18 = motionEvent.getY();
                this.f71049g0 = y18;
                this.f71046e0 = y18;
                this.f71051h0 = MotionEventCompat.getPointerId(motionEvent, 0);
                this.W = false;
                this.G.computeScrollOffset();
                if (this.f71052i == Orientation.VERTICAL) {
                    if (this.B0 == 2 && Math.abs(this.G.getFinalY() - this.G.getCurrY()) > this.f71058m0) {
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
                } else if (this.B0 == 2 && Math.abs(this.G.getFinalX() - this.G.getCurrX()) > this.f71058m0) {
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
            if (this.f71053i0 == null) {
                this.f71053i0 = VelocityTracker.obtain();
            }
            this.f71053i0.addMovement(motionEvent);
            return this.V;
        }
        this.V = false;
        this.W = false;
        this.f71051h0 = -1;
        VelocityTracker velocityTracker = this.f71053i0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f71053i0 = null;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        boolean z17;
        int i26;
        int i27;
        c u16;
        int i28;
        int i29;
        int max;
        int i36;
        int max2;
        int i37;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i38 = 3;
        int i39 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int childCount = getChildCount();
        int i46 = i17 - i3;
        int i47 = i18 - i16;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = this.f71052i == Orientation.VERTICAL ? getScrollY() : getScrollX();
        int i48 = 0;
        int i49 = 0;
        while (true) {
            i19 = 8;
            if (i48 >= childCount) {
                break;
            }
            View childAt = getChildAt(i48);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f71072a) {
                    int i56 = layoutParams.f71073b;
                    int i57 = i56 & 7;
                    int i58 = i56 & 112;
                    if (i57 == i39) {
                        max = Math.max((i46 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i57 == i38) {
                            i36 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i57 != 5) {
                            i36 = paddingLeft;
                        } else {
                            max = (i46 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i58 != 16) {
                            max2 = Math.max((i47 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i58 == 48) {
                                i37 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i58 != 80) {
                                i37 = paddingTop;
                            } else {
                                max2 = (i47 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            if (this.f71052i == Orientation.VERTICAL) {
                                paddingTop += scrollY;
                            } else {
                                paddingLeft += scrollY;
                            }
                            childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                            i49++;
                            paddingTop = i37;
                            paddingLeft = i36;
                        }
                        int i59 = paddingTop;
                        paddingTop = max2;
                        i37 = i59;
                        if (this.f71052i == Orientation.VERTICAL) {
                        }
                        childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                        i49++;
                        paddingTop = i37;
                        paddingLeft = i36;
                    }
                    int i65 = paddingLeft;
                    paddingLeft = max;
                    i36 = i65;
                    if (i58 != 16) {
                    }
                    int i592 = paddingTop;
                    paddingTop = max2;
                    i37 = i592;
                    if (this.f71052i == Orientation.VERTICAL) {
                    }
                    childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                    i49++;
                    paddingTop = i37;
                    paddingLeft = i36;
                }
            }
            i48++;
            i38 = 3;
            i39 = 1;
        }
        int i66 = this.f71052i == Orientation.VERTICAL ? (i47 - paddingTop) - paddingBottom : (i46 - paddingLeft) - paddingRight;
        int i67 = 0;
        while (i67 < childCount) {
            View childAt2 = getChildAt(i67);
            if (childAt2.getVisibility() != i19) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f71072a && (u16 = u(childAt2)) != null) {
                    float f16 = i66;
                    int i68 = (int) (u16.f71086e * f16);
                    i26 = childCount;
                    i27 = i66;
                    if (this.f71052i == Orientation.VERTICAL) {
                        int i69 = i68 + paddingTop;
                        if (layoutParams2.f71076e) {
                            layoutParams2.f71076e = false;
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec((i46 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f16 * layoutParams2.f71074c), 1073741824));
                        }
                        i29 = i69;
                        i28 = paddingLeft;
                    } else {
                        i28 = i68 + paddingLeft;
                        if (layoutParams2.f71076e) {
                            layoutParams2.f71076e = false;
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f16 * layoutParams2.f71075d), 1073741824), View.MeasureSpec.makeMeasureSpec((i47 - paddingTop) - paddingBottom, 1073741824));
                        }
                        i29 = paddingTop;
                    }
                    childAt2.layout(i28, i29, childAt2.getMeasuredWidth() + i28, childAt2.getMeasuredHeight() + i29);
                    i67++;
                    childCount = i26;
                    i66 = i27;
                    i19 = 8;
                }
            }
            i26 = childCount;
            i27 = i66;
            i67++;
            childCount = i26;
            i66 = i27;
            i19 = 8;
        }
        Orientation orientation = this.f71052i;
        Orientation orientation2 = Orientation.VERTICAL;
        if (orientation != orientation2) {
            paddingLeft = paddingTop;
        }
        this.K = paddingLeft;
        this.L = orientation == orientation2 ? i46 - paddingRight : i47 - paddingBottom;
        this.f71065t0 = i49;
        if (this.f71062q0) {
            z17 = false;
            L(this.C, false, 0, false);
        } else {
            z17 = false;
        }
        this.f71062q0 = z17;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int measuredWidth;
        int paddingLeft;
        int measuredHeight;
        int paddingBottom;
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z16;
        boolean z17;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 3;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i16));
        Orientation orientation = this.f71052i;
        Orientation orientation2 = Orientation.VERTICAL;
        if (orientation == orientation2) {
            measuredWidth = getMeasuredHeight();
        } else {
            measuredWidth = getMeasuredWidth();
        }
        this.f71041b0 = Math.min(measuredWidth / 10, this.f71040a0);
        if (this.f71052i == orientation2) {
            paddingLeft = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = measuredWidth - getPaddingTop();
            paddingBottom = getPaddingBottom();
        } else {
            paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
            measuredHeight = getMeasuredHeight() - getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i19 = measuredHeight - paddingBottom;
        int childCount = getChildCount();
        int i26 = 0;
        while (true) {
            int i27 = 1073741824;
            if (i26 >= childCount) {
                break;
            }
            View childAt = getChildAt(i26);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f71072a) {
                int i28 = layoutParams2.f71073b;
                int i29 = i28 & 7;
                int i36 = i28 & 112;
                if (i36 != 48 && i36 != 80) {
                    z16 = z18;
                } else {
                    z16 = true;
                }
                if (i29 != i18 && i29 != 5) {
                    z17 = z18;
                } else {
                    z17 = true;
                }
                int i37 = Integer.MIN_VALUE;
                if (z16) {
                    i17 = Integer.MIN_VALUE;
                    i37 = 1073741824;
                } else if (z17) {
                    i17 = 1073741824;
                } else {
                    i17 = Integer.MIN_VALUE;
                }
                int i38 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i38 != -2) {
                    if (i38 == -1) {
                        i38 = paddingLeft;
                    }
                    i37 = 1073741824;
                } else {
                    i38 = paddingLeft;
                }
                int i39 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i39 != -2) {
                    if (i39 == -1) {
                        i39 = i19;
                    }
                } else {
                    i39 = i19;
                    i27 = i17;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i38, i37), View.MeasureSpec.makeMeasureSpec(i39, i27));
                if (z16) {
                    i19 -= childAt.getMeasuredHeight();
                } else if (z17) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i26++;
            i18 = 3;
            z18 = false;
        }
        this.P = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.Q = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
        this.R = true;
        G();
        this.R = false;
        int childCount2 = getChildCount();
        for (int i46 = 0; i46 < childCount2; i46++) {
            View childAt2 = getChildAt(i46);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f71072a)) {
                if (this.f71052i == Orientation.VERTICAL) {
                    childAt2.measure(this.P, View.MeasureSpec.makeMeasureSpec((int) (i19 * layoutParams.f71074c), 1073741824));
                } else {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.f71075d), 1073741824), this.Q);
                }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, i3, (Object) rect)).booleanValue();
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
            if (childAt.getVisibility() == 0 && (u16 = u(childAt)) != null && u16.f71083b == this.C && childAt.requestFocus(i3, rect)) {
                return true;
            }
            i16 += i18;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) parcelable);
            return;
        }
        if (!(parcelable instanceof ViewPagerSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ViewPagerSavedState viewPagerSavedState = (ViewPagerSavedState) parcelable;
        super.onRestoreInstanceState(viewPagerSavedState.getSuperState());
        PagerAdapter pagerAdapter = this.f71057m;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(viewPagerSavedState.f71080e, viewPagerSavedState.f71081f);
            N(viewPagerSavedState.f71079d, false, true);
        } else {
            this.D = viewPagerSavedState.f71079d;
            this.E = viewPagerSavedState.f71080e;
            this.F = viewPagerSavedState.f71081f;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Parcelable) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        ViewPagerSavedState viewPagerSavedState = new ViewPagerSavedState(super.onSaveInstanceState());
        viewPagerSavedState.f71079d = this.C;
        PagerAdapter pagerAdapter = this.f71057m;
        if (pagerAdapter != null) {
            viewPagerSavedState.f71080e = pagerAdapter.saveState();
        }
        return viewPagerSavedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.f71052i == Orientation.VERTICAL) {
            if (i16 != i18) {
                int i19 = this.I;
                I(i16, i18, i19, i19);
                return;
            }
            return;
        }
        if (i3 != i17) {
            int i26 = this.I;
            I(i3, i17, i26, i26);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        int xVelocity;
        int i3;
        float f16;
        float x16;
        float f17;
        boolean onRelease;
        boolean onRelease2;
        boolean F;
        float f18;
        float f19;
        int actionIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f71059n0) {
            return true;
        }
        boolean z16 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f71057m) == null || pagerAdapter.getF373114d() == 0) {
            return false;
        }
        if (this.f71053i0 == null) {
            this.f71053i0 = VelocityTracker.obtain();
        }
        this.f71053i0.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                B(motionEvent);
                                if (this.f71052i == Orientation.VERTICAL) {
                                    this.f71046e0 = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f71051h0));
                                } else {
                                    this.f71044d0 = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f71051h0));
                                }
                            }
                        } else {
                            if (this.f71052i == Orientation.VERTICAL) {
                                actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                this.f71046e0 = MotionEventCompat.getY(motionEvent, actionIndex);
                            } else {
                                actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                this.f71044d0 = MotionEventCompat.getX(motionEvent, actionIndex);
                            }
                            this.f71051h0 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        }
                    } else if (this.V) {
                        L(this.C, true, 0, false);
                        this.f71051h0 = -1;
                        o();
                        onRelease = this.f71060o0.onRelease();
                        onRelease2 = this.f71061p0.onRelease();
                        z16 = onRelease | onRelease2;
                    }
                } else {
                    if (!this.V) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f71051h0);
                        float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float abs = Math.abs(y16 - this.f71046e0);
                        float x17 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(x17 - this.f71044d0);
                        if (this.f71052i == Orientation.VERTICAL) {
                            if (abs > this.f71042c0 && abs > abs2) {
                                this.V = true;
                                K(true);
                                float f26 = this.f71049g0;
                                if (y16 - f26 > 0.0f) {
                                    f19 = f26 + this.f71042c0;
                                } else {
                                    f19 = f26 - this.f71042c0;
                                }
                                this.f71046e0 = f19;
                                this.f71044d0 = x17;
                                P(1);
                                Q(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        } else if (abs2 > this.f71042c0 && abs2 > abs) {
                            this.V = true;
                            K(true);
                            float f27 = this.f71048f0;
                            if (x17 - f27 > 0.0f) {
                                f18 = f27 + this.f71042c0;
                            } else {
                                f18 = f27 - this.f71042c0;
                            }
                            this.f71044d0 = f18;
                            this.f71046e0 = y16;
                            P(1);
                            Q(true);
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.V) {
                        int findPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, this.f71051h0);
                        if (this.f71052i == Orientation.VERTICAL) {
                            F = F(MotionEventCompat.getY(motionEvent, findPointerIndex2));
                        } else {
                            F = F(MotionEventCompat.getX(motionEvent, findPointerIndex2));
                        }
                        z16 = F | false;
                    }
                }
            } else if (this.V) {
                if (this.f71052i == Orientation.VERTICAL) {
                    VelocityTracker velocityTracker = this.f71053i0;
                    velocityTracker.computeCurrentVelocity(1000, this.f71055k0);
                    xVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.f71051h0);
                    this.T = true;
                    int r16 = r();
                    int scrollY = getScrollY();
                    c v3 = v();
                    i3 = v3.f71083b;
                    f16 = ((scrollY / r16) - v3.f71086e) / v3.f71085d;
                    x16 = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f71051h0));
                    f17 = this.f71049g0;
                } else {
                    VelocityTracker velocityTracker2 = this.f71053i0;
                    velocityTracker2.computeCurrentVelocity(1000, this.f71055k0);
                    xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker2, this.f71051h0);
                    this.T = true;
                    int r17 = r();
                    int scrollX = getScrollX();
                    c v16 = v();
                    i3 = v16.f71083b;
                    f16 = ((scrollX / r17) - v16.f71086e) / v16.f71085d;
                    x16 = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f71051h0));
                    f17 = this.f71048f0;
                }
                O(l(i3, f16, xVelocity, (int) (x16 - f17)), true, true, xVelocity);
                this.f71051h0 = -1;
                o();
                onRelease = this.f71060o0.onRelease();
                onRelease2 = this.f71061p0.onRelease();
                z16 = onRelease | onRelease2;
            }
        } else {
            this.G.abortAnimation();
            this.T = false;
            G();
            float x18 = motionEvent.getX();
            this.f71048f0 = x18;
            this.f71044d0 = x18;
            float y17 = motionEvent.getY();
            this.f71049g0 = y17;
            this.f71046e0 = y17;
            this.f71051h0 = MotionEventCompat.getPointerId(motionEvent, 0);
        }
        if (z16) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public boolean p(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, (Object) keyEvent)).booleanValue();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else if (this.R) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.C;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pagerAdapter);
            return;
        }
        PagerAdapter pagerAdapter2 = this.f71057m;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.H);
            this.f71057m.startUpdate((ViewGroup) this);
            for (int i3 = 0; i3 < this.f71045e.size(); i3++) {
                c cVar = this.f71045e.get(i3);
                this.f71057m.destroyItem((ViewGroup) this, cVar.f71083b, cVar.f71082a);
            }
            this.f71057m.finishUpdate((ViewGroup) this);
            this.f71045e.clear();
            J();
            this.C = 0;
            scrollTo(0, 0);
        }
        this.f71057m = pagerAdapter;
        this.f71043d = 0;
        if (pagerAdapter != null) {
            a aVar = null;
            if (this.H == null) {
                this.H = new e(this, aVar);
            }
            this.f71057m.registerDataSetObserver(this.H);
            this.T = false;
            boolean z16 = this.f71062q0;
            this.f71062q0 = true;
            this.f71043d = this.f71057m.getF373114d();
            if (this.D >= 0) {
                this.f71057m.restoreState(this.E, this.F);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.T = false;
            N(i3, !this.f71062q0, false);
        }
    }

    public void setOffscreenPageLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        if (i3 < 1) {
            Log.w("OrientedViewPager", "Requested offscreen page limit " + i3 + " too small; defaulting to 1");
            i3 = 1;
        }
        if (i3 != this.U) {
            this.U = i3;
            G();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onPageChangeListener);
        } else {
            this.f71066u0 = onPageChangeListener;
        }
    }

    public void setOrientation(Orientation orientation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) orientation);
        } else {
            this.f71052i = orientation;
        }
    }

    public void setPageMargin(int i3) {
        int width;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        int i16 = this.I;
        this.I = i3;
        if (this.f71052i == Orientation.VERTICAL) {
            width = getHeight();
        } else {
            width = getWidth();
        }
        I(width, width, i3, i16);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) drawable);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), pageTransformer);
            return;
        }
        if (pageTransformer != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.f71068w0 != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 != z18) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.f71068w0 = pageTransformer;
        M(z17);
        if (z17) {
            if (!z16) {
                i3 = 1;
            }
            this.f71070y0 = i3;
        } else {
            this.f71070y0 = 0;
        }
        if (z19) {
            G();
        }
    }

    public void setScroller(Scroller scroller) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) scroller);
        } else {
            this.G = scroller;
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
        for (int i3 = 0; i3 < this.f71045e.size(); i3++) {
            c cVar = this.f71045e.get(i3);
            if (this.f71057m.isViewFromObject(view, cVar.f71082a)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) drawable)).booleanValue();
        }
        if (!super.verifyDrawable(drawable) && drawable != this.J) {
            return false;
        }
        return true;
    }

    c w(int i3) {
        for (int i16 = 0; i16 < this.f71045e.size(); i16++) {
            c cVar = this.f71045e.get(i16);
            if (cVar.f71083b == i3) {
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
        this.G = new Scroller(context, E0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.f71042c0 = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.f71054j0 = (int) (400.0f * f16);
        this.f71055k0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f71060o0 = new EdgeEffectCompat(context);
        this.f71061p0 = new EdgeEffectCompat(context);
        this.f71056l0 = (int) (25.0f * f16);
        this.f71058m0 = (int) (2.0f * f16);
        this.f71040a0 = (int) (f16 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public boolean y(int i3) {
        int scrollX;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, i3)).booleanValue();
        }
        if (this.f71057m == null) {
            return false;
        }
        int r16 = r();
        if (this.f71052i == Orientation.VERTICAL) {
            scrollX = getScrollY();
        } else {
            scrollX = getScrollX();
        }
        if (i3 < 0) {
            if (scrollX <= ((int) (r16 * this.M))) {
                return false;
            }
            return true;
        }
        if (i3 <= 0 || scrollX >= ((int) (r16 * this.N))) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 53)) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 53, (Object) this, (Object) attributeSet);
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f71072a;

        /* renamed from: b, reason: collision with root package name */
        public int f71073b;

        /* renamed from: c, reason: collision with root package name */
        float f71074c;

        /* renamed from: d, reason: collision with root package name */
        float f71075d;

        /* renamed from: e, reason: collision with root package name */
        boolean f71076e;

        /* renamed from: f, reason: collision with root package name */
        int f71077f;

        /* renamed from: g, reason: collision with root package name */
        int f71078g;

        public LayoutParams() {
            super(-1, -1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f71074c = 0.0f;
                this.f71075d = 0.0f;
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
                return;
            }
            this.f71074c = 0.0f;
            this.f71075d = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OrientedViewPager.C0);
            this.f71073b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public void setCurrentItem(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.T = false;
            N(i3, z16, false);
        }
    }

    public void setPageMarginDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            setPageMarginDrawable(getContext().getResources().getDrawable(i3));
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
    }

    public OrientedViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f71045e = new ArrayList<>();
        this.f71047f = new c(null);
        this.f71050h = new Rect();
        this.f71052i = Orientation.HORIZONTAL;
        this.D = -1;
        this.E = null;
        this.F = null;
        this.M = -3.4028235E38f;
        this.N = Float.MAX_VALUE;
        this.U = 1;
        this.f71051h0 = -1;
        this.f71062q0 = true;
        this.f71063r0 = false;
        this.A0 = new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.OrientedViewPager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OrientedViewPager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    OrientedViewPager.this.P(0);
                    OrientedViewPager.this.G();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.B0 = 0;
        x();
    }
}
