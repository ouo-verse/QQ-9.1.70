package com.tencent.mobileqq.dov.story.api.impl;

import ad0.a;
import com.tencent.mobileqq.dov.story.api.IStoryEntityManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StoryEntityManagerImpl implements IStoryEntityManager {
    static IPatchRedirector $redirector_;

    public StoryEntityManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.dov.story.api.IStoryEntityManager
    public EntityManager createEntityManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EntityManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        a aVar = new a(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
        aVar.verifyAuthentication();
        return aVar.createEntityManager();
    }
}
