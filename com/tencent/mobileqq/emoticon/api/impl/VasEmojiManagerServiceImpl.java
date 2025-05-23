package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.IVasEmojiManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VasEmojiManagerServiceImpl implements IVasEmojiManagerService {
    static IPatchRedirector $redirector_;

    public VasEmojiManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService
    public IVasEmojiManager createVasEmojiManager(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IVasEmojiManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface);
        }
        return new VasEmojiManager(baseQQAppInterface);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService
    public boolean emoticonPkgNeedUpdate(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        return com.tencent.mobileqq.core.util.a.a(i3, i16);
    }

    @Override // com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService
    public boolean isAuthorized(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iEmoticonMainPanelApp, i3)).booleanValue();
        }
        if (iEmoticonMainPanelApp == null) {
            return false;
        }
        int currentUserVipType = ((SVIPHandlerProxy) iEmoticonMainPanelApp.getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).getCurrentUserVipType();
        if (i3 == 4) {
            if (currentUserVipType != 1 && currentUserVipType != 3) {
                return false;
            }
            return true;
        }
        if (i3 == 5 && currentUserVipType != 3) {
            return false;
        }
        return true;
    }
}
