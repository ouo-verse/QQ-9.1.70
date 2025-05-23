package com.tencent.ams.monitor.metric;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
class AdMetricThreadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f70564a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<m> f70565b;

    public AdMetricThreadManager(WeakReference<j> weakReference, WeakReference<m> weakReference2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference, (Object) weakReference2);
        } else {
            this.f70564a = new d(weakReference);
            this.f70565b = weakReference2;
        }
    }

    private m a() {
        WeakReference<m> weakReference = this.f70565b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static Map<Integer, Integer> b() {
        return new HashMap<Integer, Integer>() { // from class: com.tencent.ams.monitor.metric.AdMetricThreadManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    put(1, 1);
                    put(10, 10);
                }
            }
        };
    }

    public boolean c(Runnable runnable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable, i3)).booleanValue();
        }
        return d(runnable, i3, 0L);
    }

    public boolean d(Runnable runnable, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, runnable, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        Map<Integer, Integer> b16 = b();
        if (b16 == null) {
            this.f70564a.c("AdMetricThreadManager", "[post] error, type:" + i3);
            return false;
        }
        Integer num = b16.get(Integer.valueOf(i3));
        if (num == null) {
            this.f70564a.c("AdMetricThreadManager", "[post] error, finalType is null, type:" + i3);
            return false;
        }
        m a16 = a();
        if (a16 == null) {
            this.f70564a.c("AdMetricThreadManager", "[post] error, adapter is null");
            return false;
        }
        try {
            return a16.postDelayed(runnable, num.intValue(), j3);
        } catch (Throwable th5) {
            this.f70564a.d("AdMetricThreadManager", "[post]", th5);
            return false;
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        m a16 = a();
        if (a16 == null) {
            this.f70564a.c("AdMetricThreadManager", "[quitSafely] error, adapter is null");
            return false;
        }
        return a16.quitSafely();
    }
}
