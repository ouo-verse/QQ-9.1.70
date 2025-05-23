package com.tencent.mobileqq.ptt.temp.api.impl;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.temp.api.IAudioPanelTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import y51.a;

/* loaded from: classes16.dex */
public class AudioPanelTempApiImpl implements IAudioPanelTempApi {
    static IPatchRedirector $redirector_;

    public AudioPanelTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IAudioPanelTempApi
    public void ListenPanel_startPlayAnimByType_RecordStopToPlayType(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            if (view == null) {
                return;
            }
            ((a) view.getParent().getParent()).d(201);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IAudioPanelTempApi
    public boolean getAppIsVideoChatting(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            return ((QQAppInterface) appRuntime).isVideoChatting();
        }
        return false;
    }
}
