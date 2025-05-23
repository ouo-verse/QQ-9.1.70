package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerApi;
import com.tencent.mobileqq.avatar.handler.AvatarHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarHandlerApiImpl implements IQQAvatarHandlerApi {
    static IPatchRedirector $redirector_;
    public static final String MESSAGE_HANDLER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            MESSAGE_HANDLER = AvatarHandler.class.getName();
        }
    }

    public QQAvatarHandlerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerApi
    public String getClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return MESSAGE_HANDLER;
    }
}
