package com.tencent.mobileqq.addfriend.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IFriendRequestApi;
import com.tencent.mobileqq.addfriend.handler.AddFriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FriendRequestApiImpl implements IFriendRequestApi {
    static IPatchRedirector $redirector_;

    public FriendRequestApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.api.IFriendRequestApi
    public void friendRequestTag(AppInterface appInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Long.valueOf(j3));
        } else {
            ((AddFriendHandler) appInterface.getBusinessHandler(AddFriendHandler.class.getName())).D2(j3);
        }
    }
}
