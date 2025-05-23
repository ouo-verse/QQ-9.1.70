package com.tencent.imcore.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.api.IOnLinePushMessageProcessorService;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ac;

/* loaded from: classes7.dex */
public class OnLinePushMessageProcessorServiceImpl implements IOnLinePushMessageProcessorService {
    static IPatchRedirector $redirector_;

    public OnLinePushMessageProcessorServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.api.IOnLinePushMessageProcessorService
    public void changeBuddyOnline(AppInterface appInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, Long.valueOf(j3));
        } else {
            ((FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).j(j3);
        }
    }

    @Override // com.tencent.imcore.message.api.IOnLinePushMessageProcessorService
    public String getPhoneNumByUin(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        }
        return ac.V(appInterface, str);
    }
}
