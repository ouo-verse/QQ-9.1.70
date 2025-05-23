package com.tencent.mobileqq.emoticon.api.impl;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.ISogouEmoji;
import com.tencent.mobileqq.emoticon.NTSouGouEmojiSender;
import com.tencent.mobileqq.emoticon.api.ISogouEmojiService;
import com.tencent.mobileqq.emoticonview.NTEmoticonSenderApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SogouEmojiServiceImpl implements ISogouEmojiService {
    static IPatchRedirector $redirector_;

    public SogouEmojiServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.ISogouEmojiService
    public ISogouEmoji createSogouEmojiForNT(Activity activity, BaseQQAppInterface baseQQAppInterface, NTEmoticonSenderApi nTEmoticonSenderApi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ISogouEmoji) iPatchRedirector.redirect((short) 2, this, activity, baseQQAppInterface, nTEmoticonSenderApi);
        }
        return new NTSouGouEmojiSender(activity, baseQQAppInterface, nTEmoticonSenderApi);
    }
}
