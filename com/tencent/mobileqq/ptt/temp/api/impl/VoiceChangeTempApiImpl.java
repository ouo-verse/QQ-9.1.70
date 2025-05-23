package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.mobileqq.ptt.temp.api.IVoiceChangeTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class VoiceChangeTempApiImpl implements IVoiceChangeTempApi {
    static IPatchRedirector $redirector_;

    public VoiceChangeTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoiceChangeTempApi
    public String getContentPicHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ClubContentJsonTask.ContentPicHost;
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoiceChangeTempApi
    public boolean isLaterVersion(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return IndividuationConfigInfo.isLaterVersion(str, str2);
    }
}
