package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ExecuteBinResponseCallback implements FFmpegExecuteResponseCallback {
    static IPatchRedirector $redirector_;
    public long startTime;

    public ExecuteBinResponseCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
    public void onFailure(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
    public void onFinish(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
    public void onProgress(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.startTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
    public void onSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }
}
