package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoAddedAuthCallbackServiceImpl implements IEmoAddedAuthCallbackService {
    static IPatchRedirector $redirector_;

    public EmoAddedAuthCallbackServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService
    public ad createEmoAddedAuthCallback(BaseQQAppInterface baseQQAppInterface, Context context, CustomEmotionData customEmotionData, Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ad) iPatchRedirector.redirect((short) 2, this, baseQQAppInterface, context, customEmotionData, obj, Integer.valueOf(i3));
        }
        return new EmoAddedAuthCallback(baseQQAppInterface, context, customEmotionData, obj, i3);
    }
}
