package com.tencent.mobileqq.relation.friend.inject;

import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.inject.c;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.friend.inject.c
    public String getPhoneContactName(String str) {
        PhoneContact queryPhoneContactByUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService == null || (queryPhoneContactByUin = iPhoneContactService.queryPhoneContactByUin(str)) == null) {
            return null;
        }
        return queryPhoneContactByUin.name;
    }
}
