package com.tencent.mm.ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.lo.f;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.statusbar.a;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DrawStatusBarFrameLayout extends FrameLayout implements a.d {
    public static final boolean E = com.tencent.mm.ui.statusbar.a.f152668g;
    public int C;
    public e D;

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f152646a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.mm.ui.statusbar.a f152647b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f152648c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f152649d;

    /* renamed from: e, reason: collision with root package name */
    public volatile int f152650e;

    /* renamed from: f, reason: collision with root package name */
    public int f152651f;

    /* renamed from: g, reason: collision with root package name */
    public int f152652g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f152653h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f152654i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f152655j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f152656k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f152657l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f152658m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DrawStatusBarFrameLayout.this.f152654i) {
                if (DrawStatusBarFrameLayout.this.f152647b != null) {
                    DrawStatusBarFrameLayout.this.f152647b.b(DrawStatusBarFrameLayout.this);
                    DrawStatusBarFrameLayout.this.f152647b = null;
                }
                DrawStatusBarFrameLayout.this.f152648c = null;
                DrawStatusBarFrameLayout.this.f152655j = true;
                return;
            }
            DrawStatusBarFrameLayout.this.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements d.a {
        public b() {
        }

        @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout.d.a
        public void a(Context context) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                if (ViewCompat.isAttachedToWindow(DrawStatusBarFrameLayout.this)) {
                    DrawStatusBarFrameLayout drawStatusBarFrameLayout = DrawStatusBarFrameLayout.this;
                    drawStatusBarFrameLayout.post(drawStatusBarFrameLayout.f152646a);
                    return;
                } else {
                    c0.a(DrawStatusBarFrameLayout.this.f152646a);
                    return;
                }
            }
            DrawStatusBarFrameLayout.this.f152646a.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f152661a;

        public c(boolean z16) {
            this.f152661a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            DrawStatusBarFrameLayout.this.setLayoutFrozen(this.f152661a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d extends MutableContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        public boolean f152663a;

        /* renamed from: b, reason: collision with root package name */
        public a f152664b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public interface a {
            void a(Context context);
        }

        public d(MutableContextWrapper mutableContextWrapper) {
            super(mutableContextWrapper);
            this.f152663a = true;
        }

        public void a(a aVar) {
            this.f152664b = aVar;
        }

        @Override // android.content.MutableContextWrapper
        public void setBaseContext(Context context) {
            if (this.f152663a) {
                if (context == getBaseContext()) {
                    return;
                }
                ((MutableContextWrapper) getBaseContext()).setBaseContext(context);
                a aVar = this.f152664b;
                if (aVar != null) {
                    aVar.a(context);
                    return;
                }
                return;
            }
            super.setBaseContext(context);
        }

        public static Context a(Context context) {
            return context instanceof MutableContextWrapper ? new d((MutableContextWrapper) context) : context;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f152665a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f152666b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f152667c;

        public e(int i3, boolean z16, boolean z17) {
            this.f152665a = i3;
            this.f152666b = z16;
            this.f152667c = z17;
        }
    }

    public DrawStatusBarFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
        b(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSystemUiVisibilityChanged(int i3) {
        super.dispatchSystemUiVisibilityChanged(i3);
        k();
    }

    public final boolean f() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void g() {
        this.D = null;
    }

    public int getDrawnStatusBarHeight() {
        return Math.max(0, this.f152650e);
    }

    public final void h() {
        if (f()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public final boolean i() {
        return this.f152654i;
    }

    public void j() {
        Activity activity = this.f152648c;
        if (activity == null) {
            return;
        }
        com.tencent.luggage.wxa.po.b.b(activity.getWindow());
    }

    public final void k() {
        com.tencent.mm.ui.statusbar.a aVar = this.f152647b;
        if (aVar == null) {
            return;
        }
        a(aVar.c());
    }

    public void l() {
        this.D = null;
        if (!E) {
            this.f152648c = null;
            this.f152649d = null;
            return;
        }
        setPadding(0, 0, 0, 0);
        this.f152650e = 0;
        com.tencent.mm.ui.statusbar.a aVar = this.f152647b;
        if (aVar != null) {
            aVar.b(this);
        }
        Activity h16 = com.tencent.luggage.wxa.po.b.h(getContext());
        this.f152648c = h16;
        if (h16 != null) {
            com.tencent.mm.ui.statusbar.a a16 = com.tencent.mm.ui.statusbar.a.a(h16);
            this.f152647b = a16;
            a16.a(this);
        }
        Paint paint = new Paint(0);
        this.f152649d = paint;
        paint.setStyle(Paint.Style.FILL);
        super.setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f152647b != null && !this.f152654i) {
            getLocationInWindow(this.f152658m);
            if (this.C != this.f152658m[1]) {
                this.f152647b.d();
            }
            this.C = this.f152658m[1];
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f152654i) {
            this.f152657l = true;
        } else {
            super.requestLayout();
        }
    }

    @AnyThread
    @SuppressLint({"WrongThread"})
    public final void setLayoutFrozen(boolean z16) {
        if (!f()) {
            post(new c(z16));
            return;
        }
        boolean z17 = true;
        w.a("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b], mReInitializeDeferred[%b]", Boolean.valueOf(z16), Boolean.valueOf(this.f152654i), Boolean.valueOf(this.f152657l), Boolean.valueOf(this.f152656k), Boolean.valueOf(this.f152655j));
        if (z16 == this.f152654i) {
            z17 = false;
        }
        this.f152654i = z16;
        if (z17 && !z16) {
            if (this.f152655j) {
                l();
                this.f152655j = false;
            }
            if (this.f152657l || this.f152656k) {
                b(this.f152650e);
                this.f152657l = false;
                this.f152656k = false;
            }
        }
    }

    public void setStatusBarColor(int i3) {
        if (!E) {
            return;
        }
        a(i3, com.tencent.luggage.wxa.po.b.a(this.f152648c));
    }

    @Override // android.view.View
    public final boolean willNotDraw() {
        return super.willNotDraw();
    }

    public DrawStatusBarFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(d.a(context), attributeSet);
        this.f152646a = new a();
        this.f152651f = 0;
        this.f152652g = 0;
        this.f152653h = false;
        this.f152654i = false;
        this.f152655j = false;
        this.f152656k = false;
        this.f152657l = false;
        this.f152658m = new int[2];
        this.C = 0;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            l();
            if (getContext() instanceof d) {
                ((d) getContext()).a(new b());
                return;
            }
            return;
        }
        throw new RuntimeException("Should be called on main-thread");
    }

    public final void b(int i3) {
        getLocationInWindow(this.f152658m);
        this.C = this.f152658m[1];
        if (w.d() <= 1) {
            w.a("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", Integer.valueOf(i3), Boolean.valueOf(this.f152654i), Integer.valueOf(this.f152658m[0]), Integer.valueOf(this.f152658m[1]));
        }
        this.f152650e = Math.max(0, i3 - Math.max(this.f152658m[1], 0));
        if (this.f152654i) {
            this.f152656k = true;
            return;
        }
        try {
            setPadding(0, this.f152653h ? 0 : this.f152650e, 0, 0);
        } catch (IllegalStateException e16) {
            w.h("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", e16.getMessage());
        }
        if (isLayoutRequested()) {
            h();
        }
    }

    public boolean c(boolean z16) {
        Activity activity = this.f152648c;
        if (activity == null) {
            return false;
        }
        return f.b(activity.getWindow(), z16);
    }

    public void a(int i3) {
        b(i3);
    }

    public final void a(boolean z16) {
        this.f152653h = z16;
        if (ViewCompat.isAttachedToWindow(this)) {
            b(this.f152650e);
        }
    }

    public void a(int i3, boolean z16) {
        a(i3, z16, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0034, code lost:
    
        if (com.tencent.luggage.wxa.lo.f.a() != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3, boolean z16, boolean z17) {
        e eVar = this.D;
        if (eVar != null && i3 == eVar.f152665a && z16 == eVar.f152666b && z17 == eVar.f152667c) {
            return;
        }
        try {
            int i16 = this.f152651f;
            int i17 = this.f152652g;
            this.f152651f = i3;
            if (E) {
                j();
                if (z17) {
                    if (c(z16)) {
                        this.f152651f = i3;
                        this.f152652g = 0;
                    }
                    this.f152651f = z16 ? f.a(i3, -16777216, 0.78f) : i3;
                    this.f152652g = z16 ? Color.argb(51, 0, 0, 0) : 0;
                }
                int i18 = this.f152651f;
                if (i18 == 0 && this.f152652g == 0) {
                    super.setWillNotDraw(true);
                    h();
                } else if (i16 != i18 || i17 != this.f152652g) {
                    super.setWillNotDraw(false);
                    h();
                }
            }
        } finally {
            this.D = new e(i3, z16, z17);
        }
    }

    public final void b(Canvas canvas) {
        if (this.f152650e <= 0 || !E || !this.f152653h || willNotDraw()) {
            return;
        }
        Paint paint = this.f152649d;
        if (paint == null) {
            w.b("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
        } else {
            paint.setColor(this.f152652g);
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.f152650e, this.f152649d);
        }
    }

    @Override // android.view.View
    public final void setWillNotDraw(boolean z16) {
    }

    public final void a(Canvas canvas) {
        if (this.f152650e <= 0 || !E || this.f152653h || willNotDraw()) {
            return;
        }
        Paint paint = this.f152649d;
        if (paint == null) {
            w.b("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarBackground NULL paint");
        } else {
            paint.setColor(this.f152651f);
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.f152650e, this.f152649d);
        }
    }
}
