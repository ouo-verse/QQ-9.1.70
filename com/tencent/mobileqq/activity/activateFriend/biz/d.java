package com.tencent.mobileqq.activity.activateFriend.biz;

import Wallet.AcsMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public AcsMsg f177966a;

    /* renamed from: b, reason: collision with root package name */
    public String f177967b;

    /* renamed from: c, reason: collision with root package name */
    public int f177968c;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
