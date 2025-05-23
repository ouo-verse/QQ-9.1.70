package com.tencent.mobileqq.app.message.messageclean;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes11.dex */
public class w extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public long f196253g;

    /* renamed from: h, reason: collision with root package name */
    public long f196254h;

    /* renamed from: i, reason: collision with root package name */
    public String f196255i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f196256j;

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f196216a = 10003;
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
        if ((obj instanceof w) && this.f196253g == ((w) obj).f196253g) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Objects.hash(Long.valueOf(this.f196253g));
    }
}
