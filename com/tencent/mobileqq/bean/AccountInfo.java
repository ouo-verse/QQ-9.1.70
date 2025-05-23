package com.tencent.mobileqq.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.UinInfo;
import java.io.Serializable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AccountInfo implements Serializable {
    static IPatchRedirector $redirector_;
    private final byte[] mA1Sig;
    private final String mImgUrl;
    private final String mKeyUin;
    private final String mMaskNick;
    private final String mMaskUin;
    private final byte[] mUinToken;

    public AccountInfo(String str, String str2, byte[] bArr, String str3, String str4, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, bArr, str3, str4, bArr2);
            return;
        }
        this.mMaskNick = str;
        this.mMaskUin = str2;
        this.mUinToken = bArr;
        this.mImgUrl = str3;
        this.mKeyUin = str4;
        this.mA1Sig = bArr2;
    }

    public byte[] getA1Sig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mA1Sig;
    }

    public String getImgUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mImgUrl;
    }

    public String getKeyUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mKeyUin;
    }

    public String getMaskNick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mMaskNick;
    }

    public String getMaskUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mMaskUin;
    }

    public UinInfo getNtUinInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (UinInfo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        UinInfo uinInfo = new UinInfo();
        uinInfo.maskUin = this.mMaskUin;
        uinInfo.keyUin = this.mKeyUin;
        uinInfo.encryptUin = this.mUinToken;
        uinInfo.a1Sig = this.mA1Sig;
        uinInfo.nick = this.mMaskNick;
        uinInfo.imageUrl = this.mImgUrl;
        return uinInfo;
    }

    public byte[] getUinToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mUinToken;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AccountInfo{mMaskNick='" + this.mMaskNick + "', mMaskUin='" + this.mMaskUin + "', mImgUrl='" + this.mImgUrl + "', mUinToken='" + Arrays.toString(this.mUinToken) + "'}";
    }

    public AccountInfo(UinInfo uinInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uinInfo);
            return;
        }
        this.mMaskUin = uinInfo.maskUin;
        this.mKeyUin = uinInfo.keyUin;
        this.mUinToken = uinInfo.encryptUin;
        this.mA1Sig = uinInfo.a1Sig;
        this.mMaskNick = uinInfo.nick;
        this.mImgUrl = uinInfo.imageUrl;
    }
}
