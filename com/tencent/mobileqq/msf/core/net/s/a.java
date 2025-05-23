package com.tencent.mobileqq.msf.core.net.s;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a implements Runnable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    public static final int f249035d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f249036e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f249037f = -2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249038g = -3;

    /* renamed from: a, reason: collision with root package name */
    protected int f249039a;

    /* renamed from: b, reason: collision with root package name */
    protected InterfaceC8088a f249040b;

    /* renamed from: c, reason: collision with root package name */
    public Object f249041c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.net.s.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC8088a {
        void a(a aVar, int i3, int i16, String str, Object obj);
    }

    public a(int i3, InterfaceC8088a interfaceC8088a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) interfaceC8088a);
        } else {
            this.f249039a = i3;
            this.f249040b = interfaceC8088a;
        }
    }

    protected abstract int a(String str);

    protected void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EchoTask", 2, "notifyEchoResult: " + str);
        }
        b();
        InterfaceC8088a interfaceC8088a = this.f249040b;
        if (interfaceC8088a != null) {
            interfaceC8088a.a(this, this.f249039a, i3, str, d());
        }
    }

    protected abstract boolean a();

    protected abstract void b();

    protected abstract String c();

    protected abstract Object d();

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!a()) {
            a(-1, null);
            return;
        }
        String c16 = c();
        if (c16 == null) {
            a(-2, null);
        } else {
            a(a(c16), c16);
        }
    }
}
