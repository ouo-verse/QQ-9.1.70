package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<Object> f286171a;

    /* renamed from: b, reason: collision with root package name */
    public AtTroopMemberInfo f286172b;

    public aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286171a = new ArrayList<>(2);
        }
    }
}
