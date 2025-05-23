package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FriendHandlerTempServiceImpl implements IFriendHandlerTempService {
    static IPatchRedirector $redirector_;
    private FriendListHandler mFriendListHandler;

    public FriendHandlerTempServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IFriendHandlerTempService
    public void getFriendInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.mFriendListHandler.getFriendInfo(str);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IFriendHandlerTempService
    public void getOnlineInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
        } else {
            this.mFriendListHandler.getOnlineInfo(str, z16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mFriendListHandler = (FriendListHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IFriendHandlerTempService
    public void getFriendInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.mFriendListHandler.getFriendInfo(str, z16);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        }
    }
}
