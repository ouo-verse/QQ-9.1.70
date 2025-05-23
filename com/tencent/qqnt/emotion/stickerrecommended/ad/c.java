package com.tencent.qqnt.emotion.stickerrecommended.ad;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f356436a;

    /* renamed from: b, reason: collision with root package name */
    public String f356437b;

    /* renamed from: c, reason: collision with root package name */
    public long f356438c;

    /* renamed from: d, reason: collision with root package name */
    public int f356439d;

    /* renamed from: e, reason: collision with root package name */
    public int f356440e;

    /* renamed from: f, reason: collision with root package name */
    public String f356441f;

    /* renamed from: g, reason: collision with root package name */
    public String f356442g;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
