package com.tencent.mobileqq.dov.story.api.impl;

import com.tencent.mobileqq.dov.story.api.IAudioHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQAudioHelper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AudioHelperImpl implements IAudioHelper {
    static IPatchRedirector $redirector_;

    public AudioHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.dov.story.api.IAudioHelper
    public boolean isHuaWeiGreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return QQAudioHelper.h();
    }
}
