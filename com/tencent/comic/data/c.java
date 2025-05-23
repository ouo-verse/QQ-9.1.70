package com.tencent.comic.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f99317a;

    /* renamed from: b, reason: collision with root package name */
    public String f99318b;

    /* renamed from: c, reason: collision with root package name */
    public String f99319c;

    /* renamed from: d, reason: collision with root package name */
    public String f99320d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
