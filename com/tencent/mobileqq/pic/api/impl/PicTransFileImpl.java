package com.tencent.mobileqq.pic.api.impl;

import com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GuildPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GuildPicUploadProcessor;
import com.tencent.mobileqq.transfile.ZPlanPicUploadProcessor;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PicTransFileImpl implements IPicTransFile {
    static IPatchRedirector $redirector_;
    AppRuntime app;
    private SigInfo mSig;

    public PicTransFileImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public Class getC2CPicDownloadProClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return C2CPicDownloadProcessor.class;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public Class getC2CUploadProClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return C2CPicUploadProcessor.class;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public Class getGroupDownloadProClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return GroupPicDownloadProcessor.class;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public Class getGroupUploadProClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return GroupPicUploadProcessor.class;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public Class getGuildDownloadProClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return GuildPicDownloadProcessor.class;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public Class getGuildUploadProClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return GuildPicUploadProcessor.class;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public byte[] getSessionKey() {
        SigInfo sigInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.app.getAccount() != null && this.app.isLogin() && (sigInfo = this.mSig) != null) {
            return sigInfo.sessionKey;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public Class getZPlanUploadProClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Class) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return ZPlanPicUploadProcessor.class;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public boolean isSwitchOpenHttps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        RichmediaHttpsConfProcessor.a d16 = RichmediaHttpsConfProcessor.d();
        if (d16 != null) {
            return d16.a();
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appRuntime);
        } else {
            this.app = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile
    public void setSig(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) bArr2);
            return;
        }
        if (this.mSig == null) {
            this.mSig = new SigInfo();
        }
        if (bArr != null && bArr2 != null) {
            SigInfo sigInfo = this.mSig;
            byte[] bArr3 = new byte[bArr.length];
            sigInfo.sessionKey = bArr3;
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            SigInfo sigInfo2 = this.mSig;
            byte[] bArr4 = new byte[bArr2.length];
            sigInfo2.signature = bArr4;
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            SigInfo sigInfo3 = this.mSig;
            sigInfo3.wSignatureLen = (short) sigInfo3.signature.length;
        }
    }
}
