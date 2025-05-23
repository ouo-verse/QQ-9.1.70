package e0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import h0.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public abstract class i<T extends View, Z> extends e0.a<Z> {
    private static int C = 2131369989;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f395284m;

    /* renamed from: d, reason: collision with root package name */
    protected final T f395285d;

    /* renamed from: e, reason: collision with root package name */
    private final a f395286e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f395287f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f395288h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f395289i;

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f395290e;

        /* renamed from: a, reason: collision with root package name */
        private final View f395291a;

        /* renamed from: b, reason: collision with root package name */
        private final List<g> f395292b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        boolean f395293c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private ViewTreeObserverOnPreDrawListenerC10209a f395294d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: e0.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserverOnPreDrawListenerC10209a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: d, reason: collision with root package name */
            private final WeakReference<a> f395295d;

            ViewTreeObserverOnPreDrawListenerC10209a(@NonNull a aVar) {
                this.f395295d = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f395295d.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }

        a(@NonNull View view) {
            this.f395291a = view;
        }

        private static int c(@NonNull Context context) {
            if (f395290e == null) {
                Display defaultDisplay = ((WindowManager) j.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f395290e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f395290e.intValue();
        }

        private int e(int i3, int i16, int i17) {
            int i18 = i16 - i17;
            if (i18 > 0) {
                return i18;
            }
            if (this.f395293c && this.f395291a.isLayoutRequested()) {
                return 0;
            }
            int i19 = i3 - i17;
            if (i19 > 0) {
                return i19;
            }
            if (this.f395291a.isLayoutRequested() || i16 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f395291a.getContext());
        }

        private int f() {
            int i3;
            int paddingTop = this.f395291a.getPaddingTop() + this.f395291a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f395291a.getLayoutParams();
            if (layoutParams != null) {
                i3 = layoutParams.height;
            } else {
                i3 = 0;
            }
            return e(this.f395291a.getHeight(), i3, paddingTop);
        }

        private int g() {
            int i3;
            int paddingLeft = this.f395291a.getPaddingLeft() + this.f395291a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f395291a.getLayoutParams();
            if (layoutParams != null) {
                i3 = layoutParams.width;
            } else {
                i3 = 0;
            }
            return e(this.f395291a.getWidth(), i3, paddingLeft);
        }

        private boolean h(int i3) {
            if (i3 <= 0 && i3 != Integer.MIN_VALUE) {
                return false;
            }
            return true;
        }

        private boolean i(int i3, int i16) {
            if (h(i3) && h(i16)) {
                return true;
            }
            return false;
        }

        private void j(int i3, int i16) {
            Iterator it = new ArrayList(this.f395292b).iterator();
            while (it.hasNext()) {
                ((g) it.next()).onSizeReady(i3, i16);
            }
        }

        void a() {
            if (this.f395292b.isEmpty()) {
                return;
            }
            int g16 = g();
            int f16 = f();
            if (!i(g16, f16)) {
                return;
            }
            j(g16, f16);
            b();
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f395291a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f395294d);
            }
            this.f395294d = null;
            this.f395292b.clear();
        }

        void d(@NonNull g gVar) {
            int g16 = g();
            int f16 = f();
            if (i(g16, f16)) {
                gVar.onSizeReady(g16, f16);
                return;
            }
            if (!this.f395292b.contains(gVar)) {
                this.f395292b.add(gVar);
            }
            if (this.f395294d == null) {
                ViewTreeObserver viewTreeObserver = this.f395291a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC10209a viewTreeObserverOnPreDrawListenerC10209a = new ViewTreeObserverOnPreDrawListenerC10209a(this);
                this.f395294d = viewTreeObserverOnPreDrawListenerC10209a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC10209a);
            }
        }

        void k(@NonNull g gVar) {
            this.f395292b.remove(gVar);
        }
    }

    public i(@NonNull T t16) {
        this.f395285d = (T) j.d(t16);
        this.f395286e = new a(t16);
    }

    @Nullable
    private Object i() {
        return this.f395285d.getTag(C);
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f395287f;
        if (onAttachStateChangeListener != null && !this.f395289i) {
            this.f395285d.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f395289i = true;
        }
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f395287f;
        if (onAttachStateChangeListener != null && this.f395289i) {
            this.f395285d.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f395289i = false;
        }
    }

    private void l(@Nullable Object obj) {
        f395284m = true;
        this.f395285d.setTag(C, obj);
    }

    @Override // e0.h
    @CallSuper
    public void a(@NonNull g gVar) {
        this.f395286e.d(gVar);
    }

    @Override // e0.a, e0.h
    @CallSuper
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        this.f395286e.b();
        if (!this.f395288h) {
            k();
        }
    }

    @Override // e0.h
    @CallSuper
    public void c(@NonNull g gVar) {
        this.f395286e.k(gVar);
    }

    @Override // e0.a, e0.h
    @CallSuper
    public void f(@Nullable Drawable drawable) {
        super.f(drawable);
        j();
    }

    @Override // e0.h
    @Nullable
    public com.bumptech.glide.request.c getRequest() {
        Object i3 = i();
        if (i3 != null) {
            if (i3 instanceof com.bumptech.glide.request.c) {
                return (com.bumptech.glide.request.c) i3;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // e0.h
    public void h(@Nullable com.bumptech.glide.request.c cVar) {
        l(cVar);
    }

    public String toString() {
        return "Target for: " + this.f395285d;
    }
}
