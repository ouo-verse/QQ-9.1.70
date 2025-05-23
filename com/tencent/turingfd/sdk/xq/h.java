package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.turingfd.sdk.xq.Orion;
import com.tencent.turingfd.sdk.xq.TuringSecurityService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class h extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f383362a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Perseus f383363b;

    public h(Map map, Perseus perseus) {
        this.f383362a = map;
        this.f383363b = perseus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map, (Object) perseus);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Orion.Cdo cdo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Orion orion = Orion.f382973e;
        Map<Integer, Norma> map = this.f383362a;
        synchronized (orion.f382977b) {
            synchronized (Celse.class) {
                context = Celse.f383328a;
            }
            cdo = null;
            boolean z16 = false;
            for (int i3 = 0; i3 < orion.f382979d; i3++) {
                try {
                    if (i3 != 0) {
                        z16 = true;
                    }
                    cdo = orion.a(map, context, z16);
                    long j3 = cdo.f382980a;
                    if (j3 != 0 && j3 <= -2000000) {
                    }
                } catch (Throwable th5) {
                    String th6 = th5.toString();
                    String str = Walnut.f383198b;
                    HashMap hashMap = new HashMap();
                    hashMap.put("602", th6);
                    Walnut.a(context, hashMap);
                    cdo = new Orion.Cdo(-6000000L, new HashMap());
                }
            }
            if (cdo == null) {
                cdo = new Orion.Cdo(-10000000L, new HashMap());
            }
        }
        Map<Integer, Cygnus> map2 = cdo.f382981b;
        if (map2 != null) {
            ((TuringSecurityService.Cdo) this.f383363b).a(cdo.f382980a, map2);
        } else {
            ((TuringSecurityService.Cdo) this.f383363b).a(cdo.f382980a, new HashMap());
        }
    }
}
