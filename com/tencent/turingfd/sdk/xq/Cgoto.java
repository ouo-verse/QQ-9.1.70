package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.goto, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cgoto {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f383358a;

    /* renamed from: b, reason: collision with root package name */
    public String f383359b;

    /* renamed from: c, reason: collision with root package name */
    public String f383360c;

    /* renamed from: d, reason: collision with root package name */
    public String f383361d;

    public Cgoto() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
