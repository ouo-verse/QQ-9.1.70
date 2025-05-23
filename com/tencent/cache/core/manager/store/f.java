package com.tencent.cache.core.manager.store;

import com.tencent.cache.api.util.Priority;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class f implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Priority f98782d;

    public f(Priority priority) {
        this.f98782d = priority;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) priority);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("evict, ");
        a16.append(this.f98782d);
        bVar.j("GlobalImageCache", 1, a16.toString());
        com.tencent.cache.core.manager.report.c cVar = new com.tencent.cache.core.manager.report.c(ClearMode.UserEvictAction);
        i.f98786c.a();
        i.f98785b.h(this.f98782d);
        cVar.c("evict_" + this.f98782d.name(), null);
    }
}
