package com.tencent.mobileqq.text;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f292676a;

    /* renamed from: b, reason: collision with root package name */
    public int f292677b;

    /* renamed from: c, reason: collision with root package name */
    public int f292678c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f292676a = str;
        this.f292677b = i3;
        this.f292678c = i16;
    }
}
