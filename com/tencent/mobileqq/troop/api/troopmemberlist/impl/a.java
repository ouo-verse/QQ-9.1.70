package com.tencent.mobileqq.troop.api.troopmemberlist.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements com.tencent.mobileqq.troop.api.troopmemberlist.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AddFrdStateMng f294336a;

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f294336a = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).y();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.a
    public int a(String str, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) appInterface)).intValue();
        }
        return this.f294336a.c(str, (QQAppInterface) appInterface);
    }
}
