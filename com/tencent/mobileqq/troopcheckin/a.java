package com.tencent.mobileqq.troopcheckin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f302708a;

    /* renamed from: b, reason: collision with root package name */
    public String f302709b;

    /* renamed from: c, reason: collision with root package name */
    public long f302710c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "CheckInResEntity{filePath='" + this.f302708a + "', cover='" + this.f302709b + "', videoDuration=" + this.f302710c + '}';
    }
}
