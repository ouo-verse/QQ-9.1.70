package com.tencent.mobileqq.faultreport.contextinfo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f205803a;

    /* renamed from: b, reason: collision with root package name */
    public int f205804b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f205805c;

    /* renamed from: d, reason: collision with root package name */
    public long f205806d;

    /* renamed from: e, reason: collision with root package name */
    public String f205807e;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f205805c = new ConcurrentHashMap<>();
        }
    }
}
