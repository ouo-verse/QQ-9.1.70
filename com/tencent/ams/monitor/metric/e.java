package com.tencent.ams.monitor.metric;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static k a(l lVar) {
        WeakReference<j> weakReference;
        if (lVar != null) {
            weakReference = lVar.getWeakLogAdapter();
        } else {
            weakReference = null;
        }
        d dVar = new d(weakReference);
        if (lVar == null) {
            dVar.c("AdMetricServiceBuilder", "[build] error, config is null");
            return null;
        }
        l cloneDeeply = lVar.cloneDeeply();
        if (!new h(weakReference).c(cloneDeeply)) {
            dVar.c("AdMetricServiceBuilder", "[build] error, configCloned is not valid");
            return null;
        }
        return new AdMetricService(cloneDeeply);
    }
}
