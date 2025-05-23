package com.tencent.upgrade.download;

import androidx.core.content.FileProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class UpdateFileProvider extends FileProvider {
    static IPatchRedirector $redirector_;

    public UpdateFileProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
