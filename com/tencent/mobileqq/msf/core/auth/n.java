package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class n extends WtloginListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    MsfCore f247502a;

    public n(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
        } else {
            this.f247502a = msfCore;
        }
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnAskDevLockSms(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, devlockInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnAskDevLockSms found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCheckDevLockSms(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckDevLockSms found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCheckDevLockStatus(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.b(wUserSigInfo, devlockInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckDevLockStatus found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCheckPictureAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, bArr, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, bArr, wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckPictureAndGetSt found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, bArr, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.b(str, bArr, wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckSMSAndGetSt found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCheckSMSVerifyLoginAccount(long j3, long j16, String str, String str2, int i3, int i16, WUserSigInfo wUserSigInfo, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, Integer.valueOf(i3), Integer.valueOf(i16), wUserSigInfo, Integer.valueOf(i17), errMsg);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WtloginCenterCallback", 4, "OnCheckSMSVerifyLoginAccount ret =" + i17 + " mobile=" + str + " msg=" + str2 + " msgCnt=" + i3 + " timeLimit=" + i16);
            if (errMsg != null) {
                QLog.d("WtloginCenterCallback", 4, "OnCheckSMSVerifyLoginAccount errMsg =" + errMsg.getMessage());
            }
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(j3, j16, "", str, str2, i3, i16, i17, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckSMSVerifyLoginAccount found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCheckWebsigAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, bArr, wUserSigInfo, bArr2, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, bArr, wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckWebsigAndGetSt1 found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCloseCode(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, bArr, Long.valueOf(j3), wUserSigInfo, bArr2, Integer.valueOf(i3));
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, bArr, j3, wUserSigInfo, bArr2, i3);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCloseCode found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCloseDevLock(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.b(wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCloseDevLock found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnException(ErrMsg errMsg, int i3, WUserSigInfo wUserSigInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, errMsg, Integer.valueOf(i3), wUserSigInfo);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(errMsg.getMessage(), i3, wUserSigInfo);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnException found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnFetchCodeSig(byte[] bArr, long j3, long j16, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, bArr, Long.valueOf(j3), Long.valueOf(j16), wUserSigInfo, bArr2, Integer.valueOf(i3));
        }
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnGetStViaSMSVerifyLogin(String str, long j3, int i3, long j16, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), wUserSigInfo, Integer.valueOf(i16), errMsg);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WtloginCenterCallback", 4, "OnGetStViaSMSVerifyLogin ret =" + i16 + " userAccount=" + str);
            if (errMsg != null) {
                QLog.d("WtloginCenterCallback", 4, "OnGetStViaSMSVerifyLogin errMsg =" + errMsg.getMessage());
            }
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, i3, j16, "", wUserSigInfo, i16, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStViaSMSVerifyLogin found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnGetStWithPasswd(String str, long j3, int i3, long j16, String str2, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), str2, wUserSigInfo, Integer.valueOf(i16), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, i3, j16, str2, wUserSigInfo, i16, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStWithPasswd found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), wUserSigInfo, Integer.valueOf(i16), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, j16, i3, j17, wUserSigInfo, i16, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStWithoutPasswd1 found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnGuaranteeCheckValidUrl(WUserSigInfo wUserSigInfo, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) wUserSigInfo, (Object) bArr);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, bArr);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnGuaranteeCheckValidUrl found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnQueryCodeResult(long j3, List<byte[]> list, long j16, WUserSigInfo wUserSigInfo, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Long.valueOf(j3), list, Long.valueOf(j16), wUserSigInfo, bArr, Integer.valueOf(i3));
        }
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnQuickRegisterCheckAccount(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, i3, bArr);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnQuickRegisterCheckAccount found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnQuickRegisterGetAccount(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.b(wUserSigInfo, i3, bArr);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnQuickRegisterGetAccount found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRefreshPictureData(String str, WUserSigInfo wUserSigInfo, byte[] bArr, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, wUserSigInfo, bArr, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, wUserSigInfo, bArr, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRefreshPictureData found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, str, Long.valueOf(j3), wUserSigInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, wUserSigInfo, i3, i16, i17, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRefreshSMSData found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRefreshSMSVerifyLoginCode(String str, String str2, int i3, int i16, WUserSigInfo wUserSigInfo, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), wUserSigInfo, Integer.valueOf(i17), errMsg);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WtloginCenterCallback", 4, "OnRefreshSMSVerifyLoginCode ret =" + i17 + " mobile=" + str + " msg=" + str2 + " msgCnt=" + i3 + " timeLimit=" + i16);
            if (errMsg != null) {
                QLog.d("WtloginCenterCallback", 4, "OnRefreshSMSVerifyLoginCode errMsg =" + errMsg.getMessage());
            }
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, str2, i3, i16, i17, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRefreshSMSVerifyLoginAccount found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegCheckDownloadMsg(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.c(wUserSigInfo, i3, bArr);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckDownloadMsg found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegCheckIframe(WUserSigInfo wUserSigInfo, byte[] bArr, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, wUserSigInfo, bArr, obj);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, bArr, obj);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckIframe found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegCheckUploadMsg(WUserSigInfo wUserSigInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) wUserSigInfo, (Object) str);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, str);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckUploadMsg found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegCheckValidUrl(WUserSigInfo wUserSigInfo, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) wUserSigInfo, (Object) bArr);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.b(wUserSigInfo, bArr);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckValidUrl found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegCheckWebSig(WUserSigInfo wUserSigInfo, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, wUserSigInfo, str, str2);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, str, str2);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckWebSig found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegError(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.d(wUserSigInfo, i3, bArr);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegError found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegGetAccount(WUserSigInfo wUserSigInfo, int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, wUserSigInfo, Integer.valueOf(i3), Long.valueOf(j3), bArr, bArr2, bArr3);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        byte[] regTlvValue = WtloginHelper.getRegTlvValue(wUserSigInfo, 48);
        if (regTlvValue != null && regTlvValue.length > 0 && QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter", 2, "OnRegGetAccount|lhsig= " + new String(regTlvValue));
        }
        if (c16 != null) {
            c16.a(wUserSigInfo, i3, j3, bArr, bArr2, bArr3, regTlvValue);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegGetAccount found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegGetSMSVerifyLoginAccount(WUserSigInfo wUserSigInfo, int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, wUserSigInfo, Integer.valueOf(i3), Long.valueOf(j3), bArr, bArr2, bArr3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WtloginCenterCallback", 4, "OnRegGetSMSVerifyLoginAccount ret =" + i3 + " uin=" + j3);
        }
        byte[] regTlvValue = WtloginHelper.getRegTlvValue(wUserSigInfo, 48);
        if (regTlvValue != null && QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter", 2, "OnRegGetSMSVerifyLoginAccount|lhsig= " + new String(regTlvValue));
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(i3, j3, bArr, bArr2, bArr3, regTlvValue);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegGetSMSVerifyLoginAccount found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegQueryAccount(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("queryMobile", 2, "WTLoginCenter.OnRegQueryAccount ret = " + i3);
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.e(wUserSigInfo, i3, bArr);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegQueryAccount found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegQueryClientSentMsgStatus(WUserSigInfo wUserSigInfo, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, wUserSigInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, i3, i16, i17, str);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegQueryClientSendedMsgStatus found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegRequestServerResendMsg(WUserSigInfo wUserSigInfo, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, wUserSigInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(wUserSigInfo, i3, i16, i17);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegRequestServerResendMsg found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnRegSubmitMsgChk(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, wUserSigInfo, Integer.valueOf(i3), bArr);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.f(wUserSigInfo, i3, bArr);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnRegSubmitMsgChk found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnVerifyCode(String str, byte[] bArr, long j3, List<byte[]> list, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, bArr, Long.valueOf(j3), list, wUserSigInfo, bArr2, Integer.valueOf(i3));
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, bArr, j3, list, wUserSigInfo, bArr2, i3);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnVerifyCode found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnVerifySMSVerifyLoginCode(String str, String str2, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, str, str2, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WtloginCenterCallback", 4, "OnVerifySMSVerifyLoginCode ret =" + i3 + " mobile=" + str + " msgCode=" + str2);
            if (errMsg != null) {
                QLog.d("WtloginCenterCallback", 4, "OnVerifySMSVerifyLoginCode errMsg =" + errMsg.getMessage());
            }
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, str2, wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnVerifySMSVerifyLoginAccount found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), bArr, Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), bArr2, bArr3, wUserSigInfo, wFastLoginInfo, Integer.valueOf(i16), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, i3, j16, bArr, j17, j18, j19, bArr2, bArr3, wUserSigInfo, wFastLoginInfo, i16, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "onGetA1WithA1 found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void onGetSaltUinList(int i3, WUserSigInfo wUserSigInfo, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(i3), wUserSigInfo, errMsg);
            return;
        }
        super.onGetSaltUinList(i3, wUserSigInfo, errMsg);
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(i3, wUserSigInfo, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "onGetSaltUinList found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void onGetStByGateWay(int i3, long j3, int i16, long j16, WUserSigInfo wUserSigInfo, String str, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), wUserSigInfo, str, errMsg);
            return;
        }
        super.onGetStByGateWay(i3, j3, i16, j16, wUserSigInfo, str, errMsg);
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, i16, j16, "", wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "onGetStByGateWay found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void onGetStByPhoneAndPassword(int i3, long j3, int i16, long j16, WUserSigInfo wUserSigInfo, String str, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), wUserSigInfo, str, errMsg);
            return;
        }
        super.onGetStByPhoneAndPassword(i3, j3, i16, j16, wUserSigInfo, str, errMsg);
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, i16, j16, "", wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "onGetStByPhoneAndPassword found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void onGetStWithQrSig(String str, long j3, int i3, long j16, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), wUserSigInfo, Integer.valueOf(i16), errMsg);
        }
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void onLoginByGateway(int i3, WUserSigInfo wUserSigInfo, String str, ErrMsg errMsg, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Integer.valueOf(i3), wUserSigInfo, str, errMsg, hashMap);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WtloginCenterCallback", 4, "onLoginByGateway ret =" + i3);
            if (errMsg != null) {
                QLog.d("WtloginCenterCallback", 4, "onLoginByGateway errMsg =" + errMsg.getMessage());
            }
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(i3, wUserSigInfo, str, errMsg, hashMap);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "onLoginByGateway found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void onLoginByThirdPlatform(long j3, WtloginHelper.QuickLoginParam quickLoginParam, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Long.valueOf(j3), quickLoginParam, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(quickLoginParam.userSigInfo);
        if (c16 != null) {
            c16.a(j3, quickLoginParam, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "onLoginByWeChat found unknown userSigInfo " + quickLoginParam.userSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, str, bArr, wUserSigInfo, bArr2, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, bArr, wUserSigInfo, bArr2, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckSMSAndGetStExt found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnCheckWebsigAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, bArr, wUserSigInfo, Integer.valueOf(i3), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.c(str, bArr, wUserSigInfo, i3, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckWebsigAndGetSt2 found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnGetStWithPasswd(String str, long j3, int i3, long j16, long[] jArr, String str2, WUserSigInfo wUserSigInfo, byte[][] bArr, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), jArr, str2, wUserSigInfo, bArr, Integer.valueOf(i16), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, i3, j16, str2, wUserSigInfo, i16, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStWithPasswd found unknown userSigInfo " + wUserSigInfo);
    }

    @Override // oicq.wlogin_sdk.request.WtloginListener
    public void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, long[] jArr, WUserSigInfo wUserSigInfo, byte[][] bArr, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), jArr, wUserSigInfo, bArr, Integer.valueOf(i16), errMsg);
            return;
        }
        o c16 = m.c(wUserSigInfo);
        if (c16 != null) {
            c16.a(str, j3, j16, i3, j17, jArr, wUserSigInfo, bArr, i16, errMsg);
            return;
        }
        QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStWithoutPasswd2 found unknown userSigInfo " + wUserSigInfo);
    }
}
