package com.tencent.upload.uinterface.token;

import SLICE_UPLOAD.AuthToken;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.utils.UploadLog;

/* loaded from: classes27.dex */
public class TokenProvider {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TokenProvider";
    private static volatile TokenProvider sInstance;
    private ITokenEncryptor mTokenEncryptor;

    public TokenProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AuthToken getAuthToken(byte[] bArr, byte[] bArr2) {
        Object valueOf;
        byte[] encryptTokenData = getInstance().getEncryptTokenData(bArr);
        int tokenEncTye = getInstance().getTokenEncTye();
        AuthToken authToken = new AuthToken(tokenEncTye, encryptTokenData, bArr2, UploadGlobalConfig.getConfig().getAppId(), UploadGlobalConfig.getConfig().getWtAppId());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" vLoginData.size: ");
        if (encryptTokenData == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(encryptTokenData.length);
        }
        sb5.append(valueOf);
        sb5.append(" vLoginKey.size: ");
        sb5.append(bArr2.length);
        sb5.append(" tokenEncType: ");
        sb5.append(tokenEncTye);
        UploadLog.i(TAG, sb5.toString());
        return authToken;
    }

    public static TokenProvider getInstance() {
        if (sInstance == null) {
            synchronized (TokenProvider.class) {
                if (sInstance == null) {
                    sInstance = new TokenProvider();
                }
            }
        }
        return sInstance;
    }

    public byte[] getEncryptTokenData(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        }
        ITokenEncryptor iTokenEncryptor = this.mTokenEncryptor;
        if (iTokenEncryptor == null) {
            return bArr;
        }
        return iTokenEncryptor.getTokenData(bArr);
    }

    public int getTokenEncTye() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        ITokenEncryptor iTokenEncryptor = this.mTokenEncryptor;
        if (iTokenEncryptor == null) {
            return 2;
        }
        return iTokenEncryptor.getTokenEncTye();
    }

    public TokenProvider setTokenEncryptor(ITokenEncryptor iTokenEncryptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TokenProvider) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTokenEncryptor);
        }
        this.mTokenEncryptor = iTokenEncryptor;
        return this;
    }
}
