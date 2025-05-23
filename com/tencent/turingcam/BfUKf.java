package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BfUKf {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f381726a;

    /* renamed from: b, reason: collision with root package name */
    public final long f381727b;

    /* renamed from: c, reason: collision with root package name */
    public final String f381728c;

    public BfUKf(String str, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3), str2);
            return;
        }
        this.f381726a = str;
        this.f381727b = j3;
        this.f381728c = str2;
    }
}
