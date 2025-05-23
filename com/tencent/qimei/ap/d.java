package com.tencent.qimei.ap;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ao.a;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static volatile d f343090b;

    /* renamed from: a, reason: collision with root package name */
    public c f343091a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static d c() {
        if (f343090b == null) {
            synchronized (d.class) {
                if (f343090b == null) {
                    f343090b = new d();
                }
            }
        }
        return f343090b;
    }

    @Override // com.tencent.qimei.ap.c
    @Nullable
    public synchronized Context e() {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ConcurrentHashMap<String, com.tencent.qimei.aq.a> concurrentHashMap = com.tencent.qimei.ao.a.f343086a;
        a.C9309a.f343087a.getClass();
        com.tencent.qimei.aq.a aVar = com.tencent.qimei.ao.a.f343086a.get("SdkInfo");
        if (aVar instanceof c) {
            cVar = (c) aVar;
            this.f343091a = cVar;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            return null;
        }
        return cVar.e();
    }
}
