package com.tencent.turingcam;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class yio3k implements ViewTreeObserver.OnPreDrawListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f382470a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XSZyU f382471b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f382472c;

    public yio3k(Window window, XSZyU xSZyU, String str) {
        this.f382470a = window;
        this.f382471b = xSZyU;
        this.f382472c = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, window, xSZyU, str);
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
            View decorView = this.f382470a.getDecorView();
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
            Method a17 = rBDKv.a(obj2.getClass(), "getAccessibilityInteractionController", (Class<?>[]) null);
            if (a17 != null) {
                obj = a17.invoke(obj2, null);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (obj == null || (a16 = rBDKv.a(obj.getClass(), "mHandler", obj)) == null) {
            return true;
        }
        Field declaredField = Handler.class.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        Handler.Callback callback = (Handler.Callback) declaredField.get(a16);
        if (callback instanceof q0QQ5) {
            return true;
        }
        declaredField.set(a16, new q0QQ5(callback, this.f382471b, this.f382472c));
        return true;
    }
}
