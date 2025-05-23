package com.tencent.imcore.message;

import com.tencent.imcore.message.t;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class u implements t.b {
    static IPatchRedirector $redirector_;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.t.b
    public Object a(AppRuntime appRuntime, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, appRuntime, str, str2);
        }
        return com.tencent.mobileqq.utils.ac.s((QQAppInterface) appRuntime, str, str2, 1, 0);
    }

    @Override // com.tencent.imcore.message.t.b
    public Object b(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, appRuntime, str, Integer.valueOf(i3));
        }
        if (i3 == 3000) {
            return com.tencent.mobileqq.utils.ac.r((QQAppInterface) appRuntime, str);
        }
        if (i3 == 1) {
            return ((TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).F(str);
        }
        return com.tencent.mobileqq.utils.ac.F((QQAppInterface) appRuntime, str);
    }

    @Override // com.tencent.imcore.message.t.b
    public Object c(String str, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) appRuntime);
        }
        return Integer.valueOf(((FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).J(str));
    }
}
