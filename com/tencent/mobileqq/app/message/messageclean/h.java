package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public String f196222g;

    /* renamed from: h, reason: collision with root package name */
    public String f196223h;

    /* renamed from: i, reason: collision with root package name */
    public int f196224i;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f196216a = 10004;
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
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f196224i == hVar.f196224i && this.f196223h.equals(hVar.f196223h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Objects.hash(this.f196223h, Integer.valueOf(this.f196224i));
    }
}
