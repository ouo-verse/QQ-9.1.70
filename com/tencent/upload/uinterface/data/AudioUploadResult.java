package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AudioUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public int result;
    public String voice_id;
    public int voice_length;

    public AudioUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.voice_length = 0;
        this.result = 0;
        this.voice_id = "";
    }
}
