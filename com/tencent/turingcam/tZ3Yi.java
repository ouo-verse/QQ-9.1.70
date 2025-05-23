package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class tZ3Yi {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382386a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f382387b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382388c;

    /* renamed from: d, reason: collision with root package name */
    public final String f382389d;

    /* renamed from: e, reason: collision with root package name */
    public final int f382390e;

    public tZ3Yi(int i3, byte[] bArr, String str, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), bArr, str, str2, Integer.valueOf(i16));
            return;
        }
        this.f382386a = i3;
        this.f382387b = bArr;
        this.f382388c = str;
        this.f382389d = str2;
        this.f382390e = i16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder a16 = tmnyR.a("symmetricAlgorithm : ");
        a16.append(this.f382386a);
        a16.append(" randomKey : ");
        a16.append(this.f382388c);
        a16.append(" sessionId : ");
        a16.append(this.f382389d);
        a16.append(" expireTime : ");
        a16.append(this.f382390e);
        return a16.toString();
    }
}
