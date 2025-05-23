package com.tencent.turingfd.sdk.xq;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.import, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cimport implements ViewTreeObserver.OnPreDrawListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f383369a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ctry f383370b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f383371c;

    public Cimport(Window window, Ctry ctry, String str) {
        this.f383369a = window;
        this.f383370b = ctry;
        this.f383371c = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, window, ctry, str);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        Object obj;
        Object obj2;
        Object a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            View decorView = this.f383369a.getDecorView();
            decorView.getViewTreeObserver().removeOnPreDrawListener(this);
            obj = null;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                declaredMethod.setAccessible(true);
                obj2 = declaredMethod.invoke(decorView, new Object[0]);
            } catch (Throwable unused) {
                obj2 = null;
            }
        } catch (Throwable unused2) {
        }
        if (obj2 == null) {
            return true;
        }
        try {
            Method a17 = Coconut.a(obj2.getClass(), "getAccessibilityInteractionController", (Class<?>[]) null);
            if (a17 != null) {
                obj = a17.invoke(obj2, null);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (obj == null || (a16 = Coconut.a(obj.getClass(), "mHandler", obj)) == null) {
            return true;
        }
        Field declaredField = Handler.class.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        Handler.Callback callback = (Handler.Callback) declaredField.get(a16);
        if (callback instanceof Cnew) {
            return true;
        }
        declaredField.set(a16, new Cnew(callback, this.f383370b, this.f383371c));
        return true;
    }
}
