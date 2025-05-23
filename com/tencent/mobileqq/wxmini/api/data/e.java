package com.tencent.mobileqq.wxmini.api.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f327613a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f327614b;

    /* renamed from: c, reason: collision with root package name */
    public String f327615c;

    /* renamed from: d, reason: collision with root package name */
    public String f327616d;

    /* renamed from: e, reason: collision with root package name */
    public String f327617e;

    /* renamed from: f, reason: collision with root package name */
    public int f327618f;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
