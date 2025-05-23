package com.tencent.qqnt.emotion.ipc;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.api.IEmojiManagerService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
/* loaded from: classes24.dex */
public class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private BaseQQAppInterface f356282a;

    /* renamed from: b, reason: collision with root package name */
    private final AppRuntime f356283b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Class, com.tencent.qqnt.emotion.ipc.proxy.a<? extends IRuntimeService>> f356284c;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.qqnt.emotion.db.a f356285d;

    /* renamed from: e, reason: collision with root package name */
    protected EntityManagerFactory f356286e;

    public c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.f356284c = new ConcurrentHashMap<>();
        appRuntime = appRuntime == null ? MobileQQ.sMobileQQ.waitAppRuntime(null) : appRuntime;
        this.f356283b = appRuntime;
        if (appRuntime instanceof BaseQQAppInterface) {
            this.f356282a = (BaseQQAppInterface) appRuntime;
        }
        d();
    }

    private com.tencent.qqnt.emotion.ipc.proxy.a<? extends IRuntimeService> a(Class cls) {
        if (cls == IEmoticonManagerService.class) {
            return new com.tencent.qqnt.emotion.ipc.proxy.c(this.f356282a, this.f356285d);
        }
        if (cls == IEmojiManagerService.class) {
            return new com.tencent.qqnt.emotion.ipc.proxy.b(this.f356282a);
        }
        return null;
    }

    private void d() {
        if (this.f356282a == null) {
            this.f356286e = this.f356283b.getEntityManagerFactory(b());
            this.f356285d = com.tencent.qqnt.emotion.db.b.f356229a.a(this.f356282a);
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f356283b.getAccount();
    }

    public com.tencent.qqnt.emotion.ipc.proxy.a<? extends IRuntimeService> c(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.emotion.ipc.proxy.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        com.tencent.qqnt.emotion.ipc.proxy.a<? extends IRuntimeService> aVar = this.f356284c.get(cls);
        if (aVar == null) {
            synchronized (com.tencent.qqnt.emotion.ipc.proxy.a.class) {
                com.tencent.qqnt.emotion.ipc.proxy.a<? extends IRuntimeService> aVar2 = this.f356284c.get(cls);
                if (aVar2 != null) {
                    return aVar2;
                }
                aVar = a(cls);
                if (aVar != null) {
                    this.f356284c.put(cls, aVar);
                }
            }
        }
        return aVar;
    }
}
