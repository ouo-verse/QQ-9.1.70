package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.favroaming.l;
import com.tencent.mobileqq.emoticon.api.IEmoticonFromGroupManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonFromGroupManagerServiceImpl implements IEmoticonFromGroupManagerService {
    static IPatchRedirector $redirector_;

    public EmoticonFromGroupManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmoticonFromGroupManagerService
    public l createEmoticonFromGroupManager(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (l) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface);
        }
        return new EmoticonFromGroupManager(baseQQAppInterface);
    }
}
