package com.tencent.raft.codegenmeta.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes25.dex */
public class Pair<A, B> {
    static IPatchRedirector $redirector_;
    public final A fst;
    public final B snd;

    public Pair(A a16, B b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) a16, (Object) b16);
        } else {
            this.fst = a16;
            this.snd = b16;
        }
    }

    private boolean equalsImp(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static <A, B> Pair<A, B> of(A a16, B b16) {
        return new Pair<>(a16, b16);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            if (equalsImp(this.fst, pair.fst) && equalsImp(this.snd, pair.snd)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        A a16 = this.fst;
        if (a16 == null) {
            B b16 = this.snd;
            if (b16 == null) {
                return 0;
            }
            return b16.hashCode() + 1;
        }
        if (this.snd == null) {
            return a16.hashCode() + 2;
        }
        return (a16.hashCode() * 17) + this.snd.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "Pair[" + this.fst + "," + this.snd + "]";
    }
}
