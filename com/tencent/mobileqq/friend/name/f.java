package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f implements c {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.friend.name.c
    public String a(String str, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        MobileQQ mobileQQ;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) dVar);
        }
        if (!TextUtils.isEmpty(str) && (mobileQQ = MobileQQ.sMobileQQ) != null && mobileQQ.waitAppRuntime(null) != null) {
            Card profileCard = ((IProfileDataService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IProfileDataService.class, "all")).getProfileCard(str, false);
            if (profileCard == null || TextUtils.isEmpty(profileCard.strNick)) {
                return null;
            }
            return profileCard.strNick;
        }
        return "";
    }
}
