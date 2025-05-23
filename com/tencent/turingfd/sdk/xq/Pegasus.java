package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.Octans;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes27.dex */
public class Pegasus {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    public static int f382993d = -1;

    /* renamed from: a, reason: collision with root package name */
    public Map<Integer, Norma> f382994a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, Cygnus> f382995b;

    /* renamed from: c, reason: collision with root package name */
    public String f382996c;

    public Pegasus(Map<Integer, Norma> map, Map<Integer, Cygnus> map2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map, (Object) map2);
            return;
        }
        this.f382996c = "";
        this.f382994a = map;
        this.f382995b = map2;
    }

    public final long a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, j3)).longValue();
        }
        Iterator<Integer> it = this.f382994a.keySet().iterator();
        while (it.hasNext()) {
            this.f382995b.put(it.next(), new Octans(new Octans.Cdo(false, j3)));
        }
        return j3;
    }
}
