package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class t0bih extends afk8T {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Map<Integer, String> f382374a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f382375b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f382376c;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f382374a = null;
            this.f382375b = true;
            this.f382376c = false;
        }
    }

    public t0bih(spXPg spxpg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spxpg);
            return;
        }
        this.f382130a = spxpg.f382374a;
        this.f382131b = spxpg.f382375b;
        this.f382132c = spxpg.f382376c;
    }
}
