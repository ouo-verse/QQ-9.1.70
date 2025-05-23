package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes26.dex */
public class w0 implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static Class f380895b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f380896c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f380897d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f380898e;

    /* renamed from: a, reason: collision with root package name */
    private Context f380899a;

    public w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            t0.b("xm start");
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f380895b = cls;
            f380896c = cls.newInstance();
            f380897d = f380895b.getMethod(com.tencent.luggage.wxa.q2.e.NAME, Context.class);
            f380898e = f380895b.getMethod("getAAID", Context.class);
        } catch (Exception e16) {
            t0.c("xm reflect exception!".concat(String.valueOf(e16)));
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f380899a = context;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Object obj = f380896c;
        if (obj != null && (method = f380898e) != null) {
            return a(this.f380899a, obj, method);
        }
        return null;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (f380895b != null && f380896c != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Object obj = f380896c;
        if (obj == null || (method = f380897d) == null) {
            return null;
        }
        return a(this.f380899a, obj, method);
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
