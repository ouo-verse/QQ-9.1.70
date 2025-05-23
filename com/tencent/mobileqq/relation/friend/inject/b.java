package com.tencent.mobileqq.relation.friend.inject;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.friend.inject.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements d {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.friend.inject.d
    public String a(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) str);
        }
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) ((IPublicAccountDataManager) appRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(str);
        if (publicAccountInfo != null) {
            return publicAccountInfo.name;
        }
        return "";
    }
}
