package com.tencent.turingcam;

import android.hardware.Camera;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.DO0IX;

/* loaded from: classes27.dex */
public abstract class spXPg {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f382371a;

    /* renamed from: com.tencent.turingcam.spXPg$spXPg, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static class C10028spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f382372a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f382373b;

        public C10028spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public spXPg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f382371a = str;
        }
    }

    public abstract long a(DO0IX.spXPg spxpg);

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f382371a;
    }

    public abstract boolean a(C10028spXPg c10028spXPg, Camera camera2, EQsUZ eQsUZ);
}
