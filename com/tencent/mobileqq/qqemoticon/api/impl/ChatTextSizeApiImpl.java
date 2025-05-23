package com.tencent.mobileqq.qqemoticon.api.impl;

import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.IChatTextSizeApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ChatTextSizeApiImpl implements IChatTextSizeApi {
    static IPatchRedirector $redirector_;

    public ChatTextSizeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.IChatTextSizeApi
    public int getChatTextSizeWithDP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return ChatTextSizeSettingActivity.getChatTextSizeWithDP();
    }
}
