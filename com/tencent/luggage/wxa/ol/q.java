package com.tencent.luggage.wxa.ol;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.luggage.wxa.ol.d1;
import com.tencent.luggage.wxa.ol.q;
import com.tencent.mm.plugin.appbrand.widget.input.KeyboardHeightProvider;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q extends FrameLayout {
    public static final int E = 2131363186;
    public static boolean F = false;
    public static final LinkedList G = new LinkedList();
    public final Runnable C;
    public final Set D;

    /* renamed from: a, reason: collision with root package name */
    public View f136899a;

    /* renamed from: b, reason: collision with root package name */
    public View f136900b;

    /* renamed from: c, reason: collision with root package name */
    public int f136901c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f136902d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference f136903e;

    /* renamed from: f, reason: collision with root package name */
    public int f136904f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f136905g;

    /* renamed from: h, reason: collision with root package name */
    public KeyboardHeightProvider f136906h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f136907i;

    /* renamed from: j, reason: collision with root package name */
    public d1 f136908j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.xl.a f136909k;

    /* renamed from: l, reason: collision with root package name */
    public WeakHashMap f136910l;

    /* renamed from: m, reason: collision with root package name */
    public Runnable f136911m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f136899a == null) {
                return;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", q.this.f136899a.getClass().getSimpleName());
            for (int i3 = 0; i3 < q.this.getChildCount(); i3++) {
                View childAt = q.this.getChildAt(i3);
                if (childAt != null && childAt != q.this.f136900b && childAt != q.this.f136899a) {
                    q.this.a(childAt, 8);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", Integer.valueOf(q.this.D.size()));
            if (q.this.D.size() <= 0) {
                return;
            }
            int size = q.this.D.size();
            d[] dVarArr = new d[size];
            q.this.D.toArray(dVarArr);
            if (size <= 0) {
                return;
            }
            d dVar = dVarArr[0];
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
    }

    public q(Context context, View view) {
        super(new MutableContextWrapper(context));
        this.f136901c = -1;
        this.f136902d = false;
        this.f136904f = 0;
        this.f136905g = new int[2];
        this.f136907i = false;
        this.f136910l = new WeakHashMap();
        this.f136911m = new a();
        this.C = new b();
        this.D = new HashSet();
        super.setId(E);
        this.f136900b = view;
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
        if (a16 instanceof FragmentActivity) {
            this.f136906h = new KeyboardHeightProvider(a16);
        }
        if (a16 != null) {
            this.f136903e = new WeakReference(a16);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view == this.f136900b || view == this.f136899a) {
            super.addView(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view;
        e eVar = (e) this.f136910l.get(this.f136899a);
        if (eVar != null && eVar.f136915a && (view = this.f136899a) != null && view.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.f136899a.getLocationOnScreen(this.f136905g);
            float f16 = this.f136905g[1];
            float height = this.f136899a.getHeight() + f16;
            if (rawY < f16 || rawY > height) {
                this.f136899a.setVisibility(8);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public View getCurrentBottomPanel() {
        return this.f136899a;
    }

    public com.tencent.luggage.wxa.xl.a getOnLayoutListener() {
        return this.f136909k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            if (this.f136908j == null) {
                c();
            }
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f136908j);
            getViewTreeObserver().addOnGlobalLayoutListener(this.f136908j);
        }
        if (i3 >= 30) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandUIdRootFrameLayout", "attach input root layout above android Q");
            ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: p31.b
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat a16;
                    a16 = q.this.a(view, windowInsetsCompat);
                    return a16;
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.tencent.luggage.wxa.xl.a aVar = this.f136909k;
        if (aVar != null) {
            aVar.onDestroy();
        }
        this.f136909k = null;
        this.f136906h = null;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            this.f136908j.b();
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f136908j);
        }
        if (i3 >= 30) {
            ViewCompat.setOnApplyWindowInsetsListener(this, null);
        }
        removeAllViews();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (Build.VERSION.SDK_INT >= 30) {
            super.onLayout(z16, i3, i16, i17, i18);
            return;
        }
        this.f136902d = true;
        a();
        super.onLayout(z16, i3, i16, i17, i18);
        com.tencent.luggage.wxa.xl.a aVar = this.f136909k;
        if (aVar != null) {
            aVar.a(this, z16, i3, i16, i17, i18);
        }
        this.f136902d = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17 = this.f136901c;
        if (i17 > 0) {
            i16 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f136910l.remove(view);
        if (this.f136899a == view) {
            this.f136899a = null;
        }
    }

    public void setForceHeight(int i3) {
        boolean z16;
        if (i3 != this.f136901c) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f136901c = i3;
        if (!z16 || !ViewCompat.isLaidOut(this) || this.f136902d) {
            return;
        }
        requestLayout();
    }

    public void setOnLayoutListener(com.tencent.luggage.wxa.xl.a aVar) {
        this.f136909k = aVar;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements d1.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public Activity a() {
            if (q.this.f136903e == null || q.this.f136903e.get() == null) {
                return null;
            }
            return (Activity) q.this.f136903e.get();
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public int b() {
            return q.this.f136904f;
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public View getContentView() {
            return q.this;
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public void a(boolean z16) {
            if (q.this.f136909k != null) {
                if (z16) {
                    com.tencent.luggage.wxa.xl.a aVar = q.this.f136909k;
                    q qVar = q.this;
                    aVar.a(qVar, true, qVar.f136904f);
                    return;
                }
                q.this.f136909k.a(q.this, false, 0);
            }
        }

        @Override // com.tencent.luggage.wxa.ol.d1.b
        public void a(int i3) {
            if (q.this.f136909k != null) {
                q.this.f136909k.a(q.this, i3 > 0, i3);
            }
            q.this.f136904f = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f136915a;

        /* renamed from: b, reason: collision with root package name */
        public int f136916b;

        public e() {
            this.f136916b = 8;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static q b(View view) {
        return (q) view.getRootView().findViewById(E);
    }

    public static x c(View view) {
        q b16 = b(view);
        if (b16 == null) {
            return null;
        }
        if (b16.getOnLayoutListener() == null || !(b16.getOnLayoutListener() instanceof x)) {
            x xVar = new x();
            xVar.c(F);
            b16.setOnLayoutListener(xVar);
            KeyboardHeightProvider keyboardHeightProvider = b16.f136906h;
            if (keyboardHeightProvider != null) {
                xVar.a(keyboardHeightProvider);
            }
        }
        return (x) b16.getOnLayoutListener();
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z16) {
        return false;
    }

    public static q b(Activity activity) {
        return (q) activity.findViewById(E);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        if (view == this.f136900b || view == this.f136899a) {
            super.addView(view, i3);
        }
    }

    public void b() {
        View view = this.f136899a;
        if (view != null) {
            view.setVisibility(8);
            this.f136899a = null;
        }
    }

    public static void a(Activity activity) {
        q b16 = b(activity);
        if (b16 != null) {
            b16.b();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i16) {
        if (view == this.f136900b || view == this.f136899a) {
            super.addView(view, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        this.f136902d = true;
        a();
        com.tencent.luggage.wxa.xl.a aVar = this.f136909k;
        if (aVar != null) {
            if (this.f136907i) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
                com.tencent.luggage.wxa.xl.a aVar2 = this.f136909k;
                if (aVar2 instanceof x) {
                    ((x) aVar2).f(insets.bottom);
                }
            } else {
                aVar.a(view, false, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        this.f136902d = false;
        return windowInsetsCompat;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == this.f136900b || view == this.f136899a) {
            super.addView(view, layoutParams);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (view == this.f136900b || view == this.f136899a) {
            super.addView(view, i3, layoutParams);
        }
    }

    public final void c() {
        this.f136908j = new d1(new c());
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            View view = this.f136899a;
            if (view != null && view.isShown()) {
                this.f136899a.setVisibility(8);
                return true;
            }
            if (com.tencent.luggage.wxa.h6.h.a(getContext())) {
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void a(View view, boolean z16) {
        View view2 = this.f136899a;
        a aVar = null;
        if (view2 != view && view2 != null) {
            view2.setVisibility(8);
            this.f136899a = null;
        }
        this.f136899a = view;
        if (view.getParent() != this) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            super.addView(view, layoutParams);
        } else {
            view.bringToFront();
        }
        e eVar = (e) this.f136910l.get(this.f136899a);
        if (eVar == null) {
            eVar = new e(aVar);
            this.f136910l.put(this.f136899a, eVar);
        }
        eVar.f136915a = z16;
    }

    @Override // android.view.View
    public void setId(int i3) {
    }

    public void a(View view) {
        a(view, false);
    }

    public final void a() {
        e eVar;
        if (ViewCompat.isLaidOut(this)) {
            boolean z16 = true;
            boolean z17 = false;
            boolean z18 = false;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt != this.f136900b && (eVar = (e) this.f136910l.get(childAt)) != null) {
                    if (!z17 && eVar.f136916b != 0 && childAt.getVisibility() == 0) {
                        this.f136899a = childAt;
                        post(this.f136911m);
                        z17 = true;
                    }
                    z18 |= eVar.f136916b == 0;
                    z16 &= childAt.getVisibility() != 0;
                    eVar.f136916b = childAt.getVisibility();
                }
            }
            if (z17 || (z18 && z16)) {
                post(this.C);
            }
        }
    }

    public final void a(View view, int i3) {
        if (view == null || view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }
}
