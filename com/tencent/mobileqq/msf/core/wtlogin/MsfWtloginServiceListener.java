package com.tencent.mobileqq.msf.core.wtlogin;

import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.IWtloginServiceCallbacker;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class MsfWtloginServiceListener extends IWtloginServiceCallbacker.Stub {
    static IPatchRedirector $redirector_;

    public MsfWtloginServiceListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnCheckPictureAndGetSt(String str, byte[] bArr, byte[] bArr2, WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, bArr, bArr2, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, bArr, wUserSigInfo, Integer.valueOf(i3), errMsg);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnCloseCode(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, bArr, Long.valueOf(j3), wUserSigInfo, bArr2, Integer.valueOf(i3), errMsg);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnException(String str, int i3) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnGetStWithPasswd(String str, long j3, int i3, long j16, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i16, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), str2, bArr, wUserSigInfo, devlockInfo, Integer.valueOf(i16), errMsg);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), wUserSigInfo, Integer.valueOf(i16), errMsg);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnRefreshPictureData(String str, byte[] bArr, int i3, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, bArr, Integer.valueOf(i3), errMsg);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnRefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3), wUserSigInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void OnVerifyCode(String str, byte[] bArr, long j3, List list, byte[] bArr2, int i3, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, bArr, Long.valueOf(j3), list, bArr2, Integer.valueOf(i3), errMsg);
        }
    }

    @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
    public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), bArr, Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), bArr2, bArr3, wUserSigInfo, wFastLoginInfo, Integer.valueOf(i16), errMsg);
    }
}
