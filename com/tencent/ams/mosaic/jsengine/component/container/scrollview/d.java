package com.tencent.ams.mosaic.jsengine.component.container.scrollview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class d implements com.tencent.ams.mosaic.jsengine.component.container.scrollview.b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static Boolean f71108m;

    /* renamed from: d, reason: collision with root package name */
    private final ViewGroup f71109d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.ams.mosaic.jsengine.component.container.scrollview.c f71110e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f71111f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f71112h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f71113i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (d.this.f71110e != null) {
                Object obj = message.obj;
                if (obj instanceof View) {
                    view = (View) obj;
                } else {
                    view = null;
                }
                d.this.f71110e.onScrollStop(view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                d.this.f71112h = true;
            } else if (motionEvent.getAction() == 1) {
                d.this.f71112h = false;
                d.this.d(view);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends ScrollView {
        static IPatchRedirector $redirector_;

        c(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) context);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            } else {
                super.dispatchDraw(canvas);
                d.this.e(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                d.this.f71112h = true;
            } else if (motionEvent.getAction() == 1) {
                d.this.f71112h = false;
                d.this.d(this);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.View
        protected void onScrollChanged(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            super.onScrollChanged(i3, i16, i17, i18);
            if (d.this.f71110e != null) {
                d.this.f71110e.onScrollChange(this, i3, i16, i17, i18);
            }
            d.this.d(this);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.component.container.scrollview.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class ViewOnScrollChangeListenerC0690d implements View.OnScrollChangeListener {
        static IPatchRedirector $redirector_;

        ViewOnScrollChangeListenerC0690d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            if (d.this.f71110e != null) {
                d.this.f71110e.onScrollChange(view, i3, i16, i17, i18);
            }
            d.this.d(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56345);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f71108m = null;
        }
    }

    public d(Context context) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f71111f = false;
        this.f71113i = new a(Looper.getMainLooper());
        if (h()) {
            try {
                IPatchRedirector iPatchRedirector2 = NestedScrollViewMosaic.$redirector_;
                Object newInstance = NestedScrollViewMosaic.class.getConstructor(Context.class).newInstance(context);
                if (newInstance instanceof ViewGroup) {
                    viewGroup = (ViewGroup) newInstance;
                    viewGroup.setOnTouchListener(new b());
                } else {
                    viewGroup = null;
                }
                this.f71109d = viewGroup;
                this.f71111f = true;
                f.e("MOVerticalScrollView", "use NestedScrollView");
                return;
            } catch (Throwable unused) {
                f.b("MOVerticalScrollView", "build NestedScrollViewMosaic failed");
                this.f71109d = f(context);
                return;
            }
        }
        this.f71109d = f(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        if (!this.f71112h) {
            this.f71113i.removeMessages(0);
            Handler handler = this.f71113i;
            handler.sendMessageDelayed(handler.obtainMessage(0, view), 100L);
        }
    }

    @NonNull
    private ViewGroup f(Context context) {
        c cVar = new c(context);
        f.e("MOVerticalScrollView", "not support NestedScrollView, use ScrollView instead");
        return cVar;
    }

    public static boolean h() {
        if (f71108m == null) {
            f71108m = Boolean.valueOf(MosaicUtils.y("androidx.core.widget.NestedScrollView"));
        }
        return f71108m.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
        }
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f71109d.getScrollY();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.b
    @NonNull
    public ViewGroup getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71109d;
    }

    public void i(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f71109d.scrollTo(i3, i16);
        }
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f71109d.setNestedScrollingEnabled(z16);
        }
    }

    public void k(@Nullable com.tencent.ams.mosaic.jsengine.component.container.scrollview.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
            return;
        }
        this.f71110e = cVar;
        if (this.f71111f) {
            try {
                IPatchRedirector iPatchRedirector2 = NestedScrollViewMosaic.$redirector_;
                NestedScrollViewMosaic.class.getMethod("setOnScrollChangeListener", View.OnScrollChangeListener.class).invoke(this.f71109d, new ViewOnScrollChangeListenerC0690d());
                f.a("MOVerticalScrollView", "use NestedScrollView setOnScrollChangeListener :" + this.f71110e);
            } catch (Throwable unused) {
                f.b("MOVerticalScrollView", "NestedScrollViewMosaic setOnScrollChangeListener failed");
            }
        }
    }

    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f71109d.setVerticalScrollBarEnabled(z16);
        }
    }

    public void m(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (h()) {
            ((NestedScrollView) this.f71109d).smoothScrollTo(i3, i16);
        } else {
            ((ScrollView) this.f71109d).smoothScrollTo(i3, i16);
        }
    }
}
