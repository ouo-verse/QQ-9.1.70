package com.tencent.msdk.dns.core;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.i.a;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface a<LookupExtra extends i.a> extends i.c {

    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC9211a {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name */
        public static final InterfaceC9211a f336239a;

        /* compiled from: P */
        /* renamed from: com.tencent.msdk.dns.core.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        class C9212a implements InterfaceC9211a {
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.msdk.dns.core.a$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes21.dex */
            class C9213a implements a<LookupExtra> {
                static IPatchRedirector $redirector_;

                C9213a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) C9212a.this);
                    }
                }

                @Override // com.tencent.msdk.dns.core.a, com.tencent.msdk.dns.core.i.c
                public boolean a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                    }
                    return false;
                }

                @Override // com.tencent.msdk.dns.core.a
                public void b(n nVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) nVar);
                    }
                }

                @Override // com.tencent.msdk.dns.core.a
                public void c(i iVar, i.c cVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar, (Object) cVar);
                    }
                }

                @Override // com.tencent.msdk.dns.core.a
                public void d(c cVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
                    }
                }

                @Override // com.tencent.msdk.dns.core.i.c
                public boolean e() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
                    }
                    return false;
                }

                @Override // com.tencent.msdk.dns.core.a
                public String f() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                        return (String) iPatchRedirector.redirect((short) 8, (Object) this);
                    }
                    return "{\"v4_ips\":\"\",\"v4_ttl\":\"\",\"v4_client_ip\":\"\",\"v6_ips\":\"\",\"v6_ttl\":\"\",\"v6_client_ip\":\"\"}";
                }
            }

            C9212a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.msdk.dns.core.a.InterfaceC9211a
            public <LookupExtra extends i.a> a<LookupExtra> a(Class<LookupExtra> cls, Context context) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls, (Object) context);
                }
                return new C9213a();
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(16808), (Class<?>) InterfaceC9211a.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                f336239a = new C9212a();
            }
        }

        <LookupExtra extends i.a> a<LookupExtra> a(Class<LookupExtra> cls, Context context);
    }

    @Override // com.tencent.msdk.dns.core.i.c
    /* synthetic */ boolean a();

    void b(n<LookupExtra> nVar);

    <Statistics extends i.c> void c(i iVar, Statistics statistics);

    void d(c cVar);

    String f();
}
