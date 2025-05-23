package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure;

import android.graphics.Rect;
import android.view.View;
import java.lang.ref.WeakReference;
import pw2.n;
import pw2.s;

/* compiled from: P */
/* loaded from: classes19.dex */
class ExposureRunnable implements Runnable {
    private boolean C;
    private Class D;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<View> f303911d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<a> f303912e;

    /* renamed from: f, reason: collision with root package name */
    private float f303913f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f303914h = new Rect();

    /* renamed from: i, reason: collision with root package name */
    private long f303915i = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f303916m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(boolean z16, boolean z17, boolean z18, int i3, Rect rect, long j3, boolean z19);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExposureRunnable(float f16, boolean z16, boolean z17, a aVar) {
        this.f303912e = new WeakReference<>(aVar);
        this.f303913f = f16;
        this.f303916m = z16;
        this.C = z17;
    }

    private static Rect a(Rect rect, Rect rect2) {
        if (rect != null && rect2 != null) {
            Rect rect3 = new Rect(0, 0, 0, 0);
            int i3 = rect.left;
            int i16 = rect2.left;
            if (i3 <= i16) {
                i3 = i16;
            }
            rect3.left = i3;
            int i17 = rect.top;
            int i18 = rect2.top;
            if (i17 <= i18) {
                i17 = i18;
            }
            rect3.top = i17;
            int i19 = rect.right;
            int i26 = rect2.right;
            if (i19 >= i26) {
                i19 = i26;
            }
            rect3.right = i19;
            int i27 = rect.bottom;
            int i28 = rect2.bottom;
            if (i27 >= i28) {
                i27 = i28;
            }
            rect3.bottom = i27;
            if (i19 > i3 && i27 > i17) {
                return rect3;
            }
        }
        return null;
    }

    private void b(boolean z16, boolean z17, boolean z18, int i3, Rect rect, boolean z19) {
        a aVar;
        WeakReference<a> weakReference = this.f303912e;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.a(z16, z17, z18, i3, rect, this.f303915i, z19);
        }
    }

    private static Rect f(View view) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        if (globalVisibleRect) {
            Rect rect2 = new Rect(0, 0, s.c(), s.b());
            Rect a16 = a(rect2, rect);
            if (a16 != null) {
                n.a("ExposureRunnable", "getViewInScreenRect, rcScreen:" + rect2 + " rccross:" + a16 + " =true");
                return a16;
            }
            n.a("ExposureRunnable", "getViewInScreenRect, rcScreen:" + rect2 + " rccross:" + a16 + " =false");
        }
        n.a("ExposureRunnable", "getViewInScreenRect, view rect:" + rect + " bshowinparent:" + globalVisibleRect + "  =false");
        return null;
    }

    private static boolean g(View view, Rect rect) {
        if (view == null || !view.isShown()) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (rect != null) {
            rect.left = iArr[0];
            rect.top = iArr[1];
        }
        int i3 = iArr[1];
        if (i3 <= 0 || i3 >= s.b()) {
            return false;
        }
        return true;
    }

    public static boolean h(View view, float f16) {
        if (view == null) {
            return false;
        }
        view.getGlobalVisibleRect(new Rect());
        if ((((((r1.right - r1.left) * 1.0f) / view.getMeasuredWidth()) * (r1.bottom - r1.top)) * 1.0f) / view.getMeasuredHeight() <= f16) {
            return false;
        }
        return true;
    }

    public static boolean i(View view, float f16, Rect rect) {
        if (view == null || rect == null || (((((rect.right - rect.left) * 1.0f) / view.getMeasuredWidth()) * (rect.bottom - rect.top)) * 1.0f) / view.getMeasuredHeight() <= f16) {
            return false;
        }
        return true;
    }

    private static boolean j(View view, Rect rect) {
        Rect f16;
        if (view == null || rect == null || (f16 = f(view)) == null) {
            return false;
        }
        rect.set(f16);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(View view, Rect rect, boolean z16) {
        int i3;
        if (view == null || !view.isShown()) {
            return false;
        }
        if (rect == null) {
            rect = new Rect();
        }
        if (z16) {
            return j(view, rect);
        }
        view.getGlobalVisibleRect(rect);
        int i16 = rect.left;
        if (i16 < 0 || i16 >= s.c() || (i3 = rect.right) <= rect.left || i3 > s.c()) {
            return false;
        }
        return true;
    }

    public View e() {
        WeakReference<View> weakReference = this.f303911d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    protected boolean l(View view, float f16) {
        return h(view, f16);
    }

    protected boolean m(View view, Rect rect, boolean z16) {
        return k(view, rect, z16);
    }

    public void n(long j3) {
        this.f303915i = j3;
    }

    public void o(View view) {
        if (view == null) {
            this.f303911d = null;
        } else {
            this.f303911d = new WeakReference<>(view);
        }
    }

    public void p(Class cls) {
        this.D = cls;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        boolean g16;
        boolean i3;
        WeakReference<View> weakReference = this.f303911d;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view == null) {
            n.a("ExposureRunnable", "run\uff0c view is null");
            b(false, false, false, 0, null, this.f303916m);
            return;
        }
        boolean isShown = view.isShown();
        int hashCode = view.hashCode();
        boolean z16 = false;
        if (!this.f303916m) {
            g16 = m(view, this.f303914h, this.C);
            if (g16) {
                if (!this.C) {
                    i3 = l(view, this.f303913f);
                } else {
                    i3 = i(view, this.f303913f, this.f303914h);
                }
                z16 = i3;
            }
        } else {
            g16 = g(view, this.f303914h);
        }
        b(isShown, g16, z16, hashCode, this.f303914h, this.f303916m);
    }
}
