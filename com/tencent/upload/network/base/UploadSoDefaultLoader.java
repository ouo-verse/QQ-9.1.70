package com.tencent.upload.network.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.utils.UploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadSoDefaultLoader implements IUploadSoLoader {
    static IPatchRedirector $redirector_;

    public UploadSoDefaultLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadSoLoader
    public String getSoVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "v1.3";
    }

    @Override // com.tencent.upload.uinterface.IUploadSoLoader
    public boolean loadLibrary(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        try {
            System.loadLibrary(str);
            UploadLog.d("UploadSoDefaultLoader", "loadLibrary :" + str);
            return true;
        } catch (Throwable th5) {
            UploadLog.e("UploadSoDefaultLoader", "error :" + th5.toString());
            return false;
        }
    }
}
