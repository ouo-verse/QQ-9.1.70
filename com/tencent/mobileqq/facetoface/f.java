package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public String f205755c;

    /* renamed from: d, reason: collision with root package name */
    public int f205756d;

    /* renamed from: e, reason: collision with root package name */
    public int f205757e;

    /* renamed from: f, reason: collision with root package name */
    public String f205758f;

    /* renamed from: g, reason: collision with root package name */
    public long f205759g;

    public f(String str, String str2, int i3, int i16, String str3) {
        super(2, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3);
            return;
        }
        this.f205759g = 0L;
        this.f205755c = str2;
        this.f205756d = i3;
        this.f205757e = i16;
        this.f205758f = str3;
    }
}
