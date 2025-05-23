package com.tencent.qqnt.audio.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.audio.AudioNTPopupWindow;
import com.tencent.qqnt.audio.INTFullScreenAudioApi;
import com.tencent.qqnt.audio.m;
import com.tencent.qqnt.audio.o;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NTFullScreenAudioApiImpl implements INTFullScreenAudioApi {
    static IPatchRedirector $redirector_;

    public NTFullScreenAudioApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.audio.INTFullScreenAudioApi
    public m createAudioNTPopupWindow(o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (m) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar);
        }
        return new AudioNTPopupWindow(oVar);
    }
}
