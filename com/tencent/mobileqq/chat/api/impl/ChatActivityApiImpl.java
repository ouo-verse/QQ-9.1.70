package com.tencent.mobileqq.chat.api.impl;

import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ChatActivityApiImpl implements IChatActivityApi {
    static IPatchRedirector $redirector_;

    public ChatActivityApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.chat.api.IChatActivityApi
    public int FORWARD_REQUEST() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 21;
    }

    @Override // com.tencent.mobileqq.chat.api.IChatActivityApi
    public String KEY_AIO_MSG_SOURCE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "aio_msg_source";
    }

    @Override // com.tencent.mobileqq.chat.api.IChatActivityApi
    public String OPEN_CHAT_FRAGMENT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "open_chatfragment";
    }

    @Override // com.tencent.mobileqq.chat.api.IChatActivityApi
    public int TYPE_DETAIL_MSG_REMIND() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.chat.api.IChatActivityApi
    public Class getChatActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ChatActivity.class;
    }
}
