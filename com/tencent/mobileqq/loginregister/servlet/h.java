package com.tencent.mobileqq.loginregister.servlet;

import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class h implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void t(Bundle bundle) {
        m(bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getBoolean("needPuzzleVerify"), bundle.getParcelable("puzzleVerifyInfo"));
    }

    private void u(Bundle bundle) {
        String str;
        String str2;
        int i3 = bundle.getInt("ret");
        String string = bundle.getString("uin");
        ErrMsg errMsg = (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR);
        if (errMsg != null) {
            str = errMsg.getMessage();
        } else {
            str = "";
        }
        String str3 = str;
        if (errMsg != null && errMsg.getType() == 1) {
            str2 = errMsg.getOtherinfo();
        } else {
            str2 = null;
        }
        byte[] byteArray = bundle.getByteArray("LHSig");
        String string2 = bundle.getString("LHUin");
        aj ajVar = new aj(i3, i3, str3, errMsg, str2, null);
        ajVar.f241870g = byteArray;
        ajVar.f241871h = string2;
        DevlockInfo devlockInfo = (DevlockInfo) bundle.getParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
        ajVar.f241869f = bundle.getByteArray("errorTlv");
        n(i3, string, ajVar, devlockInfo);
    }

    private void v(Bundle bundle) {
        String str;
        String str2;
        int i3 = bundle.getInt("ret");
        String string = bundle.getString("uin");
        ErrMsg errMsg = (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR);
        if (errMsg != null) {
            str = errMsg.getMessage();
        } else {
            str = "";
        }
        String str3 = str;
        if (errMsg != null && errMsg.getType() == 1) {
            str2 = errMsg.getOtherinfo();
        } else {
            str2 = null;
        }
        byte[] byteArray = bundle.getByteArray("LHSig");
        String string2 = bundle.getString("LHUin");
        aj ajVar = new aj(i3, i3, str3, errMsg, str2, null);
        ajVar.f241870g = byteArray;
        ajVar.f241871h = string2;
        DevlockInfo devlockInfo = (DevlockInfo) bundle.getParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
        ajVar.f241869f = bundle.getByteArray("errorTlv");
        o(i3, string, ajVar, devlockInfo, bundle);
    }

    public void A(String str, String str2, int i3, int i16, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
        }
    }

    public void B(int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Long.valueOf(j3), bArr, bArr2, bArr3);
        }
    }

    public void C(int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Long.valueOf(j3), bArr, bArr2, bArr3, bArr4);
        }
    }

    public void D(String str, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), errMsg);
        }
    }

    public void E(String str, byte[] bArr, long j3, ArrayList<String> arrayList, byte[] bArr2, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, bArr, Long.valueOf(j3), arrayList, bArr2, Integer.valueOf(i3), errMsg);
        }
    }

    public void F(String str, String str2, int i3, WUserSigInfo wUserSigInfo, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, str, str2, Integer.valueOf(i3), wUserSigInfo, errMsg);
        }
    }

    public void a(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
        }
    }

    public void b(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
        }
    }

    public void c(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, wUserSigInfo, devlockInfo, Integer.valueOf(i3), errMsg);
        }
    }

    public void d(String str, byte[] bArr, byte[] bArr2, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, bArr, bArr2, wUserSigInfo, Integer.valueOf(i3), errMsg);
        }
    }

    public void e(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, bArr, wUserSigInfo, Integer.valueOf(i3), errMsg);
        }
    }

    public void f(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, bArr, wUserSigInfo, bArr2, Integer.valueOf(i3), errMsg);
        }
    }

    public void g(long j3, long j16, String str, String str2, String str3, int i3, int i16, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Long.valueOf(j3), Long.valueOf(j16), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
        }
    }

    public void h(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, bArr, Long.valueOf(j3), wUserSigInfo, bArr2, Integer.valueOf(i3), errMsg);
        }
    }

    public void i(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, wUserSigInfo, Integer.valueOf(i3), errMsg);
        }
    }

    public void j(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public void k(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), bArr, Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), bArr2, bArr3, wUserSigInfo, wFastLoginInfo, Integer.valueOf(i16), errMsg);
    }

    public void l(String str, long j3, long j16, int i3, byte[] bArr, byte[] bArr2, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), bArr, bArr2, Integer.valueOf(i16), errMsg);
        }
    }

    public void m(int i3, ErrMsg errMsg, WUserSigInfo wUserSigInfo, boolean z16, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), errMsg, wUserSigInfo, Boolean.valueOf(z16), parcelable);
        }
    }

    public void n(int i3, String str, aj ajVar, DevlockInfo devlockInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, ajVar, devlockInfo);
        }
    }

    public void o(int i3, String str, aj ajVar, DevlockInfo devlockInfo, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, ajVar, devlockInfo, bundle);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x007b. Please report as an issue. */
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (i3 != 2208) {
            if (i3 != 2403) {
                if (i3 != 2215) {
                    if (i3 != 2216) {
                        if (i3 != 2400) {
                            if (i3 != 2401) {
                                switch (i3) {
                                    case 2100:
                                        q(bundle.getString("userAccount"), bundle.getLong("dwAppid"), bundle.getInt("dwMainSigMap"), bundle.getLong("dwSubDstAppid"), bundle.getString("userPasswd"), bundle.getByteArray("pictureData"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2101:
                                        r(bundle.getString("userAccount"), bundle.getLong("dwSrcAppid"), bundle.getLong("dwDstAppid"), bundle.getInt("dwMainSigMap"), bundle.getLong("dwSubDstAppid"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2102:
                                        d(bundle.getString("userAccount"), bundle.getByteArray("userInput"), bundle.getByteArray("pictureData"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2103:
                                        y(bundle.getString("userAccount"), bundle.getByteArray("pictureData"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2104:
                                        E(bundle.getString("userAccount"), bundle.getByteArray("appName"), bundle.getLong("time"), bundle.getStringArrayList("data"), bundle.getByteArray("errMsg"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2105:
                                        h(bundle.getString("userAccount"), bundle.getByteArray("appName"), bundle.getLong("time"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getByteArray("errMsg"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2106:
                                        k(bundle.getString("userAccount"), bundle.getLong("dwSrcAppid"), bundle.getInt("dwMainSigMap"), bundle.getLong("dwSubSrcAppid"), bundle.getByteArray("dstAppName"), bundle.getLong("dwDstSsoVer"), bundle.getLong("dwSubDstAppid"), bundle.getLong("dwSubDstAppid"), bundle.getByteArray("dstAppVer"), bundle.getByteArray("dstAppSign"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), (WFastLoginInfo) bundle.getParcelable("fastLoginInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable("errMsg"));
                                        return;
                                    case 2107:
                                        j(bundle.getString("error"), bundle.getInt("cmd"));
                                        return;
                                    case 2108:
                                        c((WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), (DevlockInfo) bundle.getParcelable("devLockInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2109:
                                        a((WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), (DevlockInfo) bundle.getParcelable("devLockInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2110:
                                        b((WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2111:
                                        i((WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2112:
                                        z(bundle.getString("userAccount"), bundle.getLong("smsAppid"), (WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), bundle.getInt("remainMsgCnt"), bundle.getInt("timeLimit"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST /* 2113 */:
                                        e(bundle.getString("userAccount"), bundle.getByteArray("userInput"), (WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    case 2114:
                                        f(bundle.getString("userAccount"), bundle.getByteArray("userInput"), (WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), null, bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                                        return;
                                    default:
                                        switch (i3) {
                                            case Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT /* 2117 */:
                                                x(bundle);
                                                break;
                                            case Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT /* 2118 */:
                                                g(bundle.getLong("appid"), bundle.getLong("subAppid"), bundle.getString("countryCode"), bundle.getString(DeviceType.DeviceCategory.MOBILE), bundle.getString("msg"), bundle.getInt("msgCnt"), bundle.getInt("timeLimit"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable("errMsg"));
                                                break;
                                            case 2119:
                                                A(bundle.getString(DeviceType.DeviceCategory.MOBILE), bundle.getString("msg"), bundle.getInt("msgCnt"), bundle.getInt("timeLimit"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable("errMsg"));
                                                break;
                                            case 2120:
                                                F(bundle.getString(DeviceType.DeviceCategory.MOBILE), bundle.getString("msgCode"), bundle.getInt("ret"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), (ErrMsg) bundle.getParcelable("errMsg"));
                                                break;
                                            case 2121:
                                                w(bundle);
                                                break;
                                        }
                                        return;
                                }
                            }
                            v(bundle);
                            return;
                        }
                        t(bundle);
                        return;
                    }
                    u(bundle);
                    return;
                }
                s(bundle.getInt("ret"), (ErrMsg) bundle.getParcelable("errMsg"), (WUserSigInfo) bundle.getParcelable("userSigInfo"));
                return;
            }
            D(bundle.getString("userAccount"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
            return;
        }
        l(bundle.getString("userAccount"), bundle.getLong("dwSrcAppid"), bundle.getLong("dwDstAppid"), bundle.getInt("dwMainSigMap"), bundle.getByteArray("openid"), bundle.getByteArray(CommonConstant.KEY_ACCESS_TOKEN), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
    }

    public void p(int i3, String str, aj ajVar, DevlockInfo devlockInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), str, ajVar, devlockInfo);
        }
    }

    public void q(String str, long j3, int i3, long j16, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), str2, bArr, wUserSigInfo, Integer.valueOf(i16), errMsg);
        }
    }

    public void r(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Long.valueOf(j17), wUserSigInfo, Integer.valueOf(i16), errMsg);
        }
    }

    public void s(int i3, ErrMsg errMsg, WUserSigInfo wUserSigInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), errMsg, wUserSigInfo);
        }
    }

    protected void w(Bundle bundle) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) bundle);
            return;
        }
        int i3 = bundle.getInt("ret");
        String string = bundle.getString("uin");
        ErrMsg errMsg = (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR);
        if (errMsg != null) {
            str = errMsg.getMessage();
        } else {
            str = "";
        }
        String str3 = str;
        if (errMsg != null && errMsg.getType() == 1) {
            str2 = errMsg.getOtherinfo();
        } else {
            str2 = null;
        }
        byte[] byteArray = bundle.getByteArray("LHSig");
        String string2 = bundle.getString("LHUin");
        aj ajVar = new aj(i3, i3, str3, errMsg, str2, null);
        ajVar.f241870g = byteArray;
        ajVar.f241871h = string2;
        DevlockInfo devlockInfo = (DevlockInfo) bundle.getParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
        ajVar.f241869f = bundle.getByteArray("errorTlv");
        p(i3, string, ajVar, devlockInfo);
    }

    protected void x(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) bundle);
            return;
        }
        if (bundle.getBoolean("reg_LiangHao")) {
            if (QLog.isColorLevel()) {
                QLog.d("wtLogin_LiangHao", 2, "OnRegGetSMSVerifyLoginAccountWithLhSig");
            }
            C(bundle.getInt("ret"), bundle.getLong("userAccount"), bundle.getByteArray("supersig"), bundle.getByteArray("contactssig"), bundle.getByteArray("msg"), bundle.getByteArray("lhsig"));
        } else {
            B(bundle.getInt("ret"), bundle.getLong("userAccount"), bundle.getByteArray("supersig"), bundle.getByteArray("contactssig"), bundle.getByteArray("msg"));
        }
        B(bundle.getInt("ret"), bundle.getLong("userAccount"), bundle.getByteArray("supersig"), bundle.getByteArray("contactssig"), bundle.getByteArray("msg"));
    }

    public void y(String str, byte[] bArr, int i3, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, bArr, Integer.valueOf(i3), errMsg);
        }
    }

    public void z(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Long.valueOf(j3), wUserSigInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), errMsg);
        }
    }
}
