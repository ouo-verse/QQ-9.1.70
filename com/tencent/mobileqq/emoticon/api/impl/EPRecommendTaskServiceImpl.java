package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.EPRecommendTask;
import com.tencent.mobileqq.emoticon.IEPRecommendTask;
import com.tencent.mobileqq.emoticon.api.IEPRecommendTaskService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class EPRecommendTaskServiceImpl implements IEPRecommendTaskService {
    static IPatchRedirector $redirector_;

    public EPRecommendTaskServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEPRecommendTaskService
    public IEPRecommendTask createEPRecommendTask(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IEPRecommendTask) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface);
        }
        return new EPRecommendTask(baseQQAppInterface);
    }
}
