package com.tencent.gcloud.newapkchannel.v2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;

/* loaded from: classes6.dex */
public class Pair<F, S> {
    static IPatchRedirector $redirector_;
    public final F first;
    public final S second;

    public Pair(F f16, S s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) f16, (Object) s16);
        } else {
            this.first = f16;
            this.second = s16;
        }
    }

    public static <A, B> Pair<A, B> create(A a16, B b16) {
        return new Pair<>(a16, b16);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!Objects.equals(pair.first, this.first) || !Objects.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        F f16 = this.first;
        int i3 = 0;
        if (f16 == null) {
            hashCode = 0;
        } else {
            hashCode = f16.hashCode();
        }
        S s16 = this.second;
        if (s16 != null) {
            i3 = s16.hashCode();
        }
        return hashCode ^ i3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
