package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g implements c {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.friend.name.c
    public String a(String str, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) dVar);
        }
        com.tencent.mobileqq.friend.inject.d c16 = com.tencent.mobileqq.friend.inject.a.c();
        if (c16 != null) {
            String a16 = c16.a(MobileQQ.sMobileQQ.waitAppRuntime(null), str);
            if (!TextUtils.isEmpty(a16)) {
                return a16;
            }
        } else {
            QLog.e("IMCore.friend..PublicAccountName", 1, "pubAccountService == null");
        }
        return null;
    }
}
