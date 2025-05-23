package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class afk8T {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Map<Integer, String> f382130a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f382131b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f382132c;

    public afk8T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382130a = null;
        this.f382131b = true;
        this.f382132c = false;
    }
}
