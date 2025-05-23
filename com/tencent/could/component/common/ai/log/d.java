package com.tencent.could.component.common.ai.log;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f99963a;

    /* renamed from: b, reason: collision with root package name */
    public long f99964b;

    /* renamed from: c, reason: collision with root package name */
    public String f99965c;

    /* renamed from: d, reason: collision with root package name */
    public String f99966d;

    /* renamed from: e, reason: collision with root package name */
    public String f99967e;

    /* renamed from: f, reason: collision with root package name */
    public String f99968f;

    public d(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2);
            return;
        }
        this.f99963a = i3;
        this.f99964b = System.currentTimeMillis();
        this.f99965c = str;
        this.f99966d = str2;
    }
}
