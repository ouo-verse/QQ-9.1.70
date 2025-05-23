package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.transient, reason: invalid class name */
/* loaded from: classes27.dex */
public class Ctransient {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Map<Integer, Long> f383452a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, Long> f383453b;

    public Ctransient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f383452a = new HashMap();
            this.f383453b = new HashMap();
        }
    }

    public void a(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.f383452a.put(Integer.valueOf(i3), Long.valueOf(j3));
        }
    }
}
