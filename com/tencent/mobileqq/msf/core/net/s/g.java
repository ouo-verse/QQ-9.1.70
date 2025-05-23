package com.tencent.mobileqq.msf.core.net.s;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    public static final int f249097c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f249098d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f249099e = 2;

    /* renamed from: a, reason: collision with root package name */
    public final int f249100a;

    /* renamed from: b, reason: collision with root package name */
    public final String f249101b;

    public g(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
        } else {
            this.f249100a = i3;
            this.f249101b = str;
        }
    }
}
