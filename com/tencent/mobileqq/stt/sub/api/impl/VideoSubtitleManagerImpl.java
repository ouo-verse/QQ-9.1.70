package com.tencent.mobileqq.stt.sub.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager;
import com.tencent.mobileqq.stt.sub.api.b;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoSubtitleManagerImpl implements IVideoSubtitleManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoSubtitleManagerImpl";
    final VideoSubtitleManager videoSubtitleManager;

    public VideoSubtitleManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.videoSubtitleManager = new VideoSubtitleManager();
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public void getVideoSubtitle(String str, int i3, long j3, String str2, String str3, int i16, com.tencent.mobileqq.stt.sub.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, str3, Integer.valueOf(i16), aVar);
        } else if (isMainProcess()) {
            this.videoSubtitleManager.getVideoSubtitle(str, i3, j3, str2, str3, i16, aVar);
        } else {
            b.C8626b.a(str, i3, j3, str2, str3, i16, aVar);
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public boolean isCacheDisabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (isMainProcess()) {
            return this.videoSubtitleManager.isCacheDisabled();
        }
        return false;
    }

    boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public boolean isSkipQueryServerCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (isMainProcess()) {
            return this.videoSubtitleManager.isSkipQueryServerCache();
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else if (isMainProcess()) {
            this.videoSubtitleManager.onCreate(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (isMainProcess()) {
            this.videoSubtitleManager.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public void setCacheDisabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (isMainProcess()) {
            this.videoSubtitleManager.setCacheDisabled(z16);
        } else {
            QLog.i(TAG, 1, "setCacheDisabled not called in main process");
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public void setSkipQueryServerCache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else if (isMainProcess()) {
            this.videoSubtitleManager.setSkipQueryServerCache(z16);
        } else {
            QLog.i(TAG, 1, "setSkipQueryServerCache not called in main process");
        }
    }

    @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleManager
    public void getVideoSubtitle(MessageRecord messageRecord, String str, String str2, int i3, com.tencent.mobileqq.stt.sub.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, messageRecord, str, str2, Integer.valueOf(i3), aVar);
        } else if (isMainProcess()) {
            this.videoSubtitleManager.getVideoSubtitle(messageRecord, str, str2, i3, aVar);
        } else {
            QLog.i(TAG, 1, "getVideoSubtitle not called in main process");
        }
    }
}
