package com.tencent.trackrecordlib.core;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.trackrecordlib.f.b;
import com.tencent.trackrecordlib.f.c;
import com.tencent.trackrecordlib.f.e;
import com.tencent.trackrecordlib.f.f;
import com.tencent.trackrecordlib.g.i;
import com.tencent.trackrecordlib.models.ViewRecord;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381013a;

    /* renamed from: g, reason: collision with root package name */
    private static Class f381014g;

    /* renamed from: h, reason: collision with root package name */
    private static Class f381015h;

    /* renamed from: i, reason: collision with root package name */
    private static Method f381016i;

    /* renamed from: j, reason: collision with root package name */
    private static Field f381017j;

    /* renamed from: k, reason: collision with root package name */
    private static Field f381018k;

    /* renamed from: l, reason: collision with root package name */
    private static Field f381019l;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.trackrecordlib.f.c f381020b;

    /* renamed from: c, reason: collision with root package name */
    private e f381021c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.trackrecordlib.f.d f381022d;

    /* renamed from: e, reason: collision with root package name */
    private View.AccessibilityDelegate f381023e;

    /* renamed from: f, reason: collision with root package name */
    private ViewRecord f381024f;

    /* compiled from: P */
    /* renamed from: com.tencent.trackrecordlib.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC10017a {
        void a(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f381031a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10761);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f381031a = new a(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f381013a = a.class.getSimpleName();
        try {
            f381014g = Class.forName("android.view.View");
            f381015h = Class.forName("android.view.View$ListenerInfo");
            Method declaredMethod = f381014g.getDeclaredMethod("getListenerInfo", new Class[0]);
            f381016i = declaredMethod;
            declaredMethod.setAccessible(true);
            Field declaredField = f381015h.getDeclaredField("mOnTouchListener");
            f381018k = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f381015h.getDeclaredField("mOnKeyListener");
            f381019l = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = f381014g.getDeclaredField("mAccessibilityDelegate");
            f381017j = declaredField3;
            declaredField3.setAccessible(true);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.tencent.trackrecordlib.core.b.a(new Runnable() { // from class: com.tencent.trackrecordlib.core.a.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.trackrecordlib.d.a.b().a();
                    a.this.d();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ArrayList<View> a16 = i.a();
        if (a(a16)) {
            boolean z16 = false;
            for (View view : a16) {
                com.tencent.trackrecordlib.d.a.b().a(view);
                if (!z16 && g(view)) {
                    com.tencent.trackrecordlib.g.b.a(i.c(view));
                    z16 = true;
                } else {
                    a(view);
                }
            }
            a(a16.size());
        }
    }

    private boolean e(View view) {
        if (view != null && view.getClass().getName().contains("EditText")) {
            return true;
        }
        return false;
    }

    private boolean f(View view) {
        if (view != null && view.getClass().getName().contains("canvasui.CanvasTitleView")) {
            return true;
        }
        return false;
    }

    private boolean g(View view) {
        if (view != null && (view instanceof TextView) && !"".equals(com.tencent.trackrecordlib.g.c.f381137c) && com.tencent.trackrecordlib.g.c.f381137c.equals(i.a(view))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view) {
        if (view == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.trackrecordlib.core.a.5
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                        }
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            a.this.c();
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
                viewTreeObserver.addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.tencent.trackrecordlib.core.a.6
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                        }
                    }

                    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                    public void onWindowFocusChanged(boolean z16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, z16);
                        } else if (!z16) {
                            a.this.c();
                        }
                    }
                });
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void i(View view) {
        try {
            Object invoke = f381016i.invoke(view, new Object[0]);
            View.OnTouchListener onTouchListener = (View.OnTouchListener) f381018k.get(invoke);
            if (onTouchListener != null && (onTouchListener instanceof e)) {
                return;
            }
            if (onTouchListener == null) {
                if (this.f381021c == null) {
                    this.f381021c = new e(null, this.f381020b.f381122a);
                }
                f381018k.set(invoke, this.f381021c);
            } else {
                f381018k.set(invoke, new e(onTouchListener, this.f381020b.f381122a));
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void j(View view) {
        try {
            Object invoke = f381016i.invoke(view, new Object[0]);
            View.OnKeyListener onKeyListener = (View.OnKeyListener) f381019l.get(invoke);
            if (onKeyListener != null && (onKeyListener instanceof com.tencent.trackrecordlib.f.d)) {
                return;
            }
            if (onKeyListener == null) {
                if (this.f381022d == null) {
                    this.f381022d = new com.tencent.trackrecordlib.f.d(null, this.f381020b.f381123b);
                }
                f381019l.set(invoke, this.f381022d);
            } else {
                f381019l.set(invoke, new com.tencent.trackrecordlib.f.d(onKeyListener, this.f381020b.f381123b));
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void k(View view) {
        if (view == null) {
            return;
        }
        TouchDelegate touchDelegate = view.getTouchDelegate();
        if (touchDelegate == null) {
            view.setTouchDelegate(new f(null, null, view));
        } else if (!(touchDelegate instanceof f)) {
            try {
                view.setTouchDelegate(new f(touchDelegate, null, view));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void l(View view) {
        try {
            if (((View.AccessibilityDelegate) f381017j.get(view)) != null) {
                return;
            }
            if (this.f381023e == null) {
                this.f381023e = new com.tencent.trackrecordlib.f.a(null);
            }
            view.setAccessibilityDelegate(this.f381023e);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381020b = b();
            this.f381024f = new ViewRecord();
        }
    }

    private boolean c(View view) {
        return view != null && (view.hasOnClickListeners() || view.isClickable() || view.isLongClickable() || view.isFocusable());
    }

    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            com.tencent.trackrecordlib.g.b.a(context);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }

    public static a a() {
        return b.f381031a;
    }

    private com.tencent.trackrecordlib.f.c b() {
        c.a aVar = new c.a();
        aVar.a(new b.InterfaceC10020b() { // from class: com.tencent.trackrecordlib.core.a.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.trackrecordlib.f.b.InterfaceC10020b
            public void a(View view, MotionEvent motionEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent);
                    return;
                }
                try {
                    int actionIndex = motionEvent.getActionIndex();
                    c.a().a(view, motionEvent.getAction(), motionEvent.getPointerId(actionIndex), motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getX(actionIndex), motionEvent.getY(actionIndex), motionEvent.getRawX(), motionEvent.getRawY());
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }).a(new b.a() { // from class: com.tencent.trackrecordlib.core.a.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.trackrecordlib.f.b.a
            public void a(View view, int i3, KeyEvent keyEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent);
                    return;
                }
                try {
                    c.a().a(view, i3, keyEvent);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
        return com.tencent.trackrecordlib.f.c.a(aVar);
    }

    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            com.tencent.trackrecordlib.g.b.a(context, new InterfaceC10017a() { // from class: com.tencent.trackrecordlib.core.a.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                @Override // com.tencent.trackrecordlib.core.a.InterfaceC10017a
                public void a(View view) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                        return;
                    }
                    try {
                        if (RecordManager.getInstance().isEnableRecord() && !com.tencent.trackrecordlib.g.a.a(RecordManager.getInstance().f381004a)) {
                            if (view != null) {
                                a.this.h(view);
                            }
                            a.this.c();
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }

    private boolean a(List<View> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        View view = list.get(0);
        if (!i.g(view)) {
            h(view);
            return true;
        }
        if (view.hashCode() == this.f381024f.mRecentDecorViewHashcode && list.size() == this.f381024f.mRecentTotalViewNum && Math.abs(System.currentTimeMillis() - this.f381024f.mRecentHookTime) < 200) {
            return false;
        }
        this.f381024f.mRecentDecorViewHashcode = view.hashCode();
        return true;
    }

    private boolean b(View view) {
        try {
            View.AccessibilityDelegate accessibilityDelegate = (View.AccessibilityDelegate) f381017j.get(view);
            if (accessibilityDelegate != null) {
                return accessibilityDelegate instanceof com.tencent.trackrecordlib.f.a;
            }
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    private boolean d(View view) {
        return view != null && view.getClass().getName().contains("Layout");
    }

    private void a(int i3) {
        ViewRecord viewRecord = this.f381024f;
        viewRecord.mRecentTotalViewNum = i3;
        viewRecord.mRecentHookTime = System.currentTimeMillis();
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if (c(view)) {
            l(view);
        }
        i(view);
        if (f(view)) {
            k(view);
        }
        if (e(view)) {
            j(view);
        }
    }
}
