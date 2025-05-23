package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes11.dex */
public class u extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public long f196246g;

    /* renamed from: h, reason: collision with root package name */
    public long f196247h;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f196216a = 10002;
            this.f196217b = 4;
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f196246g == uVar.f196246g && this.f196247h == uVar.f196247h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Objects.hash(Long.valueOf(this.f196246g), Long.valueOf(this.f196247h));
    }
}
