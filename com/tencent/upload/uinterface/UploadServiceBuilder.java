package com.tencent.upload.uinterface;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.impl.UploadServiceProxy;
import com.tencent.upload.uinterface.token.ITokenEncryptor;
import com.tencent.upload.uinterface.token.TokenProvider;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadServiceBuilder {
    static IPatchRedirector $redirector_;

    public UploadServiceBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final IUploadService getInstance() {
        return UploadServiceProxy.getInstance();
    }

    public static final void init(Context context, IUploadConfig iUploadConfig, IUploadLog iUploadLog, IUploadReport iUploadReport, IUploadEnv iUploadEnv, IUploadSoLoader iUploadSoLoader, ITokenEncryptor iTokenEncryptor) {
        UploadServiceProxy.getInstance().init(context, iUploadConfig, iUploadLog, iUploadReport, iUploadEnv, iUploadSoLoader);
        TokenProvider.getInstance().setTokenEncryptor(iTokenEncryptor);
    }
}
