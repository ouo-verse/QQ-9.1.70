package com.tencent.qimei.n;

import android.content.Context;
import com.tencent.luggage.wxa.q2.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.a.b;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static Class f343348c;

    /* renamed from: d, reason: collision with root package name */
    public static Object f343349d;

    /* renamed from: e, reason: collision with root package name */
    public static Method f343350e;

    /* renamed from: f, reason: collision with root package name */
    public static Method f343351f;

    /* renamed from: a, reason: collision with root package name */
    public Context f343352a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.a.a f343353b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            com.tencent.qimei.ad.b.b("xm start");
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f343348c = cls;
            f343349d = cls.newInstance();
            f343350e = f343348c.getMethod(e.NAME, Context.class);
            f343351f = f343348c.getMethod("getAAID", Context.class);
        } catch (Exception e16) {
            com.tencent.qimei.ad.b.c("xm reflect exception!" + e16);
        }
    }

    public final String a(Context context, Object obj, Method method) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, context, obj, method);
        }
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

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        boolean z16;
        String str;
        Method method;
        Method method2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.qimei.a.a aVar = this.f343353b;
        if (aVar != null) {
            if (f343348c != null && f343349d != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Object obj = f343349d;
            String str2 = null;
            if (obj != null && (method2 = f343351f) != null) {
                str = a(this.f343352a, obj, method2);
            } else {
                str = null;
            }
            Object obj2 = f343349d;
            if (obj2 != null && (method = f343350e) != null) {
                str2 = a(this.f343352a, obj2, method);
            }
            aVar.callbackOaid(z16, str, str2, false);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f343352a = context;
            this.f343353b = aVar;
        }
    }
}
