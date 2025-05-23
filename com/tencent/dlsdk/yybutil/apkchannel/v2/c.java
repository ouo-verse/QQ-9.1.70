package com.tencent.dlsdk.yybutil.apkchannel.v2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c<F, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final F f100553a;

    /* renamed from: b, reason: collision with root package name */
    public final S f100554b;

    public c(F f16, S s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) f16, (Object) s16);
        } else {
            this.f100553a = f16;
            this.f100554b = s16;
        }
    }

    public static <A, B> c<A, B> a(A a16, B b16) {
        return new c<>(a16, b16);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!Objects.equals(cVar.f100553a, this.f100553a) || !Objects.equals(cVar.f100554b, this.f100554b)) {
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
        F f16 = this.f100553a;
        int i3 = 0;
        if (f16 == null) {
            hashCode = 0;
        } else {
            hashCode = f16.hashCode();
        }
        S s16 = this.f100554b;
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
        return "Pair{" + String.valueOf(this.f100553a) + " " + String.valueOf(this.f100554b) + "}";
    }
}
