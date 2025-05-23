package com.tencent.mobileqq.troop.troopshare;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f301553a;

    /* renamed from: b, reason: collision with root package name */
    public int f301554b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f301555c;

    /* renamed from: d, reason: collision with root package name */
    public String f301556d;

    /* renamed from: e, reason: collision with root package name */
    public String f301557e;

    /* renamed from: f, reason: collision with root package name */
    public String f301558f;

    /* renamed from: g, reason: collision with root package name */
    public String f301559g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopShareResp[  troopUin:" + this.f301553a + " errCode:" + this.f301554b + " isVerify:" + this.f301555c + " shareUrl:" + this.f301556d + " token:" + this.f301558f + " joinGroupAuth:" + this.f301559g + " signedArk:" + this.f301557e + "]";
    }
}
