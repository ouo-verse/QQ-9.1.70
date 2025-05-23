package com.tencent.ams.fusion.service.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Method f70268a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadMode f70269b;

    /* renamed from: c, reason: collision with root package name */
    private final Class<?> f70270c;

    public d(Method method, ThreadMode threadMode, Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, method, threadMode, cls);
            return;
        }
        this.f70268a = method;
        this.f70269b = threadMode;
        this.f70270c = cls;
    }

    public Method a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Method) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70268a;
    }

    public ThreadMode b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ThreadMode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f70269b;
    }

    public Class<?> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f70270c;
    }
}
