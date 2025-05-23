package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f181384a;

    /* renamed from: b, reason: collision with root package name */
    public int f181385b;

    /* renamed from: c, reason: collision with root package name */
    public TroopInfo f181386c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f181385b = 0;
        }
    }
}
