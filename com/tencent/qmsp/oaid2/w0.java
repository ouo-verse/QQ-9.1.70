package com.tencent.qmsp.oaid2;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public class w0 implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static Class f344303b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f344304c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f344305d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f344306e;

    /* renamed from: a, reason: collision with root package name */
    private Context f344307a;

    public w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            t0.b("xm start");
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f344303b = cls;
            f344304c = cls.newInstance();
            f344305d = f344303b.getMethod(com.tencent.luggage.wxa.q2.e.NAME, Context.class);
            f344306e = f344303b.getMethod("getAAID", Context.class);
        } catch (Exception e16) {
            t0.c("xm reflect exception!" + e16);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f344307a = context;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Object obj = f344304c;
        if (obj != null && (method = f344306e) != null) {
            return a(this.f344307a, obj, method);
        }
        return null;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (f344303b != null && f344304c != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Object obj = f344304c;
        if (obj == null || (method = f344305d) == null) {
            return null;
        }
        return a(this.f344307a, obj, method);
    }

    private String a(Context context, Object obj, Method method) {
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
