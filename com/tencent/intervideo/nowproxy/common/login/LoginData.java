package com.tencent.intervideo.nowproxy.common.login;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.intervideo.nowproxy.common.AccountUtil;
import com.tencent.intervideo.nowproxy.common.log.XLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LoginData implements Serializable {
    static IPatchRedirector $redirector_;
    protected String authAppId;
    protected byte[] mKey;
    protected long mLoginAppid;
    protected LoginType mLoginType;
    protected String mOriginalId;
    protected byte[] mOriginalKey;
    protected LoginType mOriginalLoginType;
    protected String mQBId;
    protected byte[] mST;
    protected byte[] mSTkey;
    protected byte[] mSkey;
    protected String mUserId;
    protected String wxAccessToken;
    protected String wxOpenid;

    public LoginData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mLoginType = LoginType.TOURIST;
        }
    }

    public static Bundle getLoginBundle(LoginData loginData) {
        Bundle bundle = new Bundle();
        if (loginData.mLoginType == LoginType.WTLOGIN) {
            try {
                bundle.putLong("QQ", Long.parseLong(loginData.mUserId));
                bundle.putLong("WTAPPID", loginData.mLoginAppid);
                bundle.putByteArray(NowProxyConstants.AccountInfoKey.A2, loginData.mKey);
                bundle.putByteArray(NowProxyConstants.AccountInfoKey.SKEY, loginData.mSkey);
                bundle.putByteArray(NowProxyConstants.AccountInfoKey.ST, loginData.mST);
                bundle.putByteArray(NowProxyConstants.AccountInfoKey.STKEY, loginData.mSTkey);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        if (loginData.mLoginType == LoginType.QQConnect) {
            try {
                bundle.putByteArray(NowProxyConstants.AccountInfoKey.A2, loginData.mKey);
                bundle.putByteArray(NowProxyConstants.AccountInfoKey.SKEY, loginData.mSkey);
                bundle.putByteArray(NowProxyConstants.AccountInfoKey.ST, loginData.mST);
                bundle.putByteArray(NowProxyConstants.AccountInfoKey.STKEY, loginData.mSTkey);
                bundle.putLong("QQ", Long.parseLong(loginData.mUserId));
            } catch (NumberFormatException e17) {
                XLog.e("NowLogin", "QQConnect login happen NumberFormatException e = " + e17.getMessage());
                e17.printStackTrace();
            }
        }
        bundle.putString("UID", loginData.mUserId);
        bundle.putByteArray("KEY", loginData.mKey);
        bundle.putString("AUTH_APP_ID", loginData.authAppId);
        bundle.putString("ORIGINAL_ID", loginData.mOriginalId);
        bundle.putByteArray("ORIGINAL_KEY", loginData.mOriginalKey);
        bundle.putInt("ORIGINAL_LOGIN_TYPE", AccountUtil.getOriginalAccountType(loginData.mOriginalLoginType));
        bundle.putInt("platform", AccountUtil.getAccountType(loginData.mLoginType));
        bundle.putString("ORIGINAL_ID", loginData.mOriginalId);
        bundle.putString("ORIGINAL_ID", loginData.mOriginalId);
        bundle.putString("QBID", loginData.mQBId);
        return bundle;
    }

    public String getAuthAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.authAppId;
    }

    public byte[] getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mKey;
    }

    public long getLoginAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.mLoginAppid;
    }

    public LoginType getLoginType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LoginType) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mLoginType;
    }

    public String getQBId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mQBId;
    }

    public byte[] getSkey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mSkey;
    }

    public String getUserId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mUserId;
    }

    public String getWxAccessToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.wxAccessToken;
    }

    public String getWxOpenid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.wxOpenid;
    }

    public void setAuthAppId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            this.authAppId = str;
        }
    }

    public void setKey(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        } else {
            this.mKey = bArr;
        }
    }

    public void setLoginAppid(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.mLoginAppid = j3;
        }
    }

    public void setLoginType(LoginType loginType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginType);
        } else {
            this.mLoginType = loginType;
        }
    }

    public void setOriginalId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.mOriginalId = str;
        }
    }

    public void setOriginalKey(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
        } else {
            this.mOriginalKey = bArr;
        }
    }

    public void setOriginalLoginType(LoginType loginType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) loginType);
        } else {
            this.mOriginalLoginType = loginType;
        }
    }

    public void setQBId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.mQBId = str;
        }
    }

    public void setST(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
        } else {
            this.mST = bArr;
        }
    }

    public void setSTKey(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
        } else {
            this.mSTkey = bArr;
        }
    }

    public void setSkey(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
        } else {
            this.mSkey = bArr;
        }
    }

    public void setUserId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.mUserId = str;
        }
    }

    public void setWxAccessToken(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.wxAccessToken = str;
        }
    }

    public void setWxOpenid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            this.wxOpenid = str;
        }
    }
}
