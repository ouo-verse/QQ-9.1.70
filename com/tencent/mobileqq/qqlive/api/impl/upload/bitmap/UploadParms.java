package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;

/* loaded from: classes17.dex */
public class UploadParms {
    static IPatchRedirector $redirector_;
    public String flag;
    public String format;
    public String localPhotoPath;
    public LoginInfo loginInfo;
    public String roomId;
    public boolean useTestEnv;

    public UploadParms() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
