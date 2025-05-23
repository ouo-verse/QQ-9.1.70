package com.tencent.tfd.sdk.wxa;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.new, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cnew implements ViewTreeObserver.OnPreDrawListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f375759a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f375760b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Cfor f375761c;

    public Cnew(Window window, String str, Cfor cfor) {
        this.f375759a = window;
        this.f375760b = str;
        this.f375761c = cfor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, window, str, cfor);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Object obj;
        Object obj2;
        Object a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            View decorView = this.f375759a.getDecorView();
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
            Method a17 = Orion.a(obj2.getClass());
            if (a17 != null) {
                obj = a17.invoke(obj2, null);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (obj == null || (a16 = Orion.a(obj.getClass(), "mHandler", obj)) == null) {
            return true;
        }
        Field declaredField = Handler.class.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        Handler.Callback callback = (Handler.Callback) declaredField.get(a16);
        if (callback instanceof Ctry) {
            return true;
        }
        declaredField.set(a16, new Ctry(callback, this.f375761c, this.f375760b));
        return true;
    }
}
