package mqq.observer;

import android.os.Bundle;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.bean.OnLoginByGatewayParam;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class WtloginObserver implements BusinessObserver, Constants.Action {
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0049. Please report as an issue. */
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (i3 == 2208) {
            onGetOpenKeyWithoutPasswd(bundle.getString("userAccount"), bundle.getLong("dwSrcAppid"), bundle.getLong("dwDstAppid"), bundle.getInt("dwMainSigMap"), bundle.getByteArray("openid"), bundle.getByteArray(CommonConstant.KEY_ACCESS_TOKEN), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
            return;
        }
        if (i3 != 2215) {
            switch (i3) {
                case 2100:
                    onGetStWithPasswd(bundle.getString("userAccount"), bundle.getLong("dwAppid"), bundle.getInt("dwMainSigMap"), bundle.getLong("dwSubDstAppid"), bundle.getString("userPasswd"), bundle.getByteArray("pictureData"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2101:
                    onGetStWithoutPasswd(bundle.getString("userAccount"), bundle.getLong("dwSrcAppid"), bundle.getLong("dwDstAppid"), bundle.getInt("dwMainSigMap"), bundle.getLong("dwSubDstAppid"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2102:
                    onCheckPictureAndGetSt(bundle.getString("userAccount"), bundle.getByteArray("userInput"), bundle.getByteArray("pictureData"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2103:
                    onRefreshPictureData(bundle.getString("userAccount"), bundle.getByteArray("pictureData"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2104:
                    onVerifyCode(bundle.getString("userAccount"), bundle.getByteArray("appName"), bundle.getLong("time"), bundle.getStringArrayList("data"), bundle.getByteArray("errMsg"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2105:
                    onCloseCode(bundle.getString("userAccount"), bundle.getByteArray("appName"), bundle.getLong("time"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getByteArray("errMsg"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2106:
                    onGetA1WithA1(bundle.getString("userAccount"), bundle.getLong("dwSrcAppid"), bundle.getInt("dwMainSigMap"), bundle.getLong("dwSubSrcAppid"), bundle.getByteArray("dstAppName"), bundle.getLong("dwDstSsoVer"), bundle.getLong("dwSubDstAppid"), bundle.getLong("dwSubDstAppid"), bundle.getByteArray("dstAppVer"), bundle.getByteArray("dstAppSign"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), (WFastLoginInfo) bundle.getParcelable("fastLoginInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable("errMsg"));
                    return;
                case 2107:
                    onException(bundle.getString("error"), bundle.getInt("cmd"));
                    return;
                case 2108:
                    onCheckDevLockStatus((WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), (DevlockInfo) bundle.getParcelable("devLockInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2109:
                    onAskDevLockSms((WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), (DevlockInfo) bundle.getParcelable("devLockInfo"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2110:
                    onCheckDevLockSms((WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2111:
                    onCloseDevLock((WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2112:
                    onRefreshSMSData(bundle.getString("userAccount"), bundle.getLong("smsAppid"), (WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), bundle.getInt("remainMsgCnt"), bundle.getInt("timeLimit"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST /* 2113 */:
                    onCheckSMSAndGetSt(bundle.getString("userAccount"), bundle.getByteArray("userInput"), (WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                case 2114:
                    onCheckSMSAndGetStExt(bundle.getString("userAccount"), bundle.getByteArray("userInput"), (WUserSigInfo) bundle.getParcelable(BuiltInServlet.MSF_KEY_SIG_INFO), null, bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                    return;
                default:
                    switch (i3) {
                        case Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT /* 2117 */:
                            onReceiveRegGetSMSVerifyLoginAccount(bundle);
                            break;
                        case Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT /* 2118 */:
                            onCheckSMSVerifyLoginAccount(bundle.getLong("appid"), bundle.getLong("subAppid"), bundle.getString("countryCode"), bundle.getString(DeviceType.DeviceCategory.MOBILE), bundle.getString("msg"), bundle.getInt("msgCnt"), bundle.getInt("timeLimit"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable("errMsg"));
                            break;
                        case 2119:
                            onRefreshSMSVerifyLoginAccount(bundle.getString(DeviceType.DeviceCategory.MOBILE), bundle.getString("msg"), bundle.getInt("msgCnt"), bundle.getInt("timeLimit"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable("errMsg"));
                            break;
                        case 2120:
                            onVerifySMSVerifyLoginAccount(bundle.getString(DeviceType.DeviceCategory.MOBILE), bundle.getString("msgCode"), bundle.getInt("ret"), (WUserSigInfo) bundle.getParcelable("userSigInfo"), (ErrMsg) bundle.getParcelable("errMsg"));
                            break;
                        case 2121:
                            onReceiveGetStViaSMSVerifyLogin(bundle);
                            break;
                        case 2122:
                            onGetSubaccountStViaSMSVerifyLogin(bundle.getString("submainaccount"), bundle.getString("userAccount"), bundle.getLong("dwAppid"), bundle.getInt("dwMainSigMap"), bundle.getLong("dwSubDstAppid"), bundle.getInt("ret"), (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
                            break;
                    }
                    return;
            }
        }
        onLoginByGateway(bundle.getInt("ret"), new OnLoginByGatewayParam(bundle.getInt(BaseConstants.ATTR_KET_SSO_SEQ), (DevlockInfo) bundle.getParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO), (ToServiceMsg) bundle.getParcelable(BaseConstants.ATTR_KET_TO_SERVICE_MSG), (WUserSigInfo) bundle.getParcelable("userSigInfo"), bundle.getString("uin"), (ErrMsg) bundle.getParcelable("errMsg")));
    }

    protected void onReceiveGetStViaSMSVerifyLogin(Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("lhsig");
        int i3 = bundle.getInt("ret");
        String string = bundle.getString("userAccount");
        if (i3 != 0 && byteArray != null) {
            string = bundle.getString("uin");
            if (QLog.isColorLevel()) {
                QLog.d("wtlogin_Lianghao", 2, "SMSVerifyLogin|phone=" + bundle.getString("userAccount") + "|" + string);
            }
        }
        onGetStViaSMSVerifyLogin(string, bundle.getLong("dwAppid"), bundle.getInt("dwMainSigMap"), bundle.getLong("dwSubDstAppid"), i3, byteArray, (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR));
    }

    protected void onReceiveRegGetSMSVerifyLoginAccount(Bundle bundle) {
        if (bundle.getBoolean("reg_LiangHao")) {
            if (QLog.isColorLevel()) {
                QLog.d("wtLogin_LiangHao", 2, "OnRegGetSMSVerifyLoginAccountWithLhSig");
            }
            onRegGetSMSVerifyLoginAccountWithLhSig(bundle.getInt("ret"), bundle.getLong("userAccount"), bundle.getByteArray("supersig"), bundle.getByteArray("contactssig"), bundle.getByteArray("msg"), bundle.getByteArray("lhsig"));
        } else {
            onRegGetSMSVerifyLoginAccount(bundle.getInt("ret"), bundle.getLong("userAccount"), bundle.getByteArray("supersig"), bundle.getByteArray("contactssig"), bundle.getByteArray("msg"));
        }
        onRegGetSMSVerifyLoginAccount(bundle.getInt("ret"), bundle.getLong("userAccount"), bundle.getByteArray("supersig"), bundle.getByteArray("contactssig"), bundle.getByteArray("msg"));
    }

    public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
    }

    public void onException(String str, int i3) {
    }

    public void onLoginByGateway(int i3, OnLoginByGatewayParam onLoginByGatewayParam) {
    }

    public void onCheckDevLockSms(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void onCloseDevLock(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void onAskDevLockSms(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
    }

    public void onCheckDevLockStatus(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
    }

    public void onRefreshPictureData(String str, byte[] bArr, int i3, ErrMsg errMsg) {
    }

    public void onCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void onRegGetSMSVerifyLoginAccount(int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
    }

    public void onVerifySMSVerifyLoginAccount(String str, String str2, int i3, WUserSigInfo wUserSigInfo, ErrMsg errMsg) {
    }

    public void onCheckSMSVerifyLoginAccount(long j3, long j16, String str, String str2, String str3, int i3, int i16, int i17, ErrMsg errMsg) {
    }

    public void onGetStWithPasswd(String str, long j3, int i3, long j16, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
    }

    public void onCloseCode(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) {
    }

    public void onGetStViaSMSVerifyLogin(String str, long j3, int i3, long j16, int i16, byte[] bArr, ErrMsg errMsg) {
    }

    public void onGetSubaccountStViaSMSVerifyLogin(String str, String str2, long j3, int i3, long j16, int i16, ErrMsg errMsg) {
    }

    public void onRefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) {
    }

    public void onVerifyCode(String str, byte[] bArr, long j3, ArrayList<String> arrayList, byte[] bArr2, int i3, ErrMsg errMsg) {
    }

    public void onCheckPictureAndGetSt(String str, byte[] bArr, byte[] bArr2, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void onCheckSMSAndGetStExt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3, ErrMsg errMsg) {
    }

    public void onRefreshSMSVerifyLoginAccount(String str, String str2, int i3, int i16, int i17, ErrMsg errMsg) {
    }

    public void onRegGetSMSVerifyLoginAccountWithLhSig(int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
    }

    public void onGetOpenKeyWithoutPasswd(String str, long j3, long j16, int i3, byte[] bArr, byte[] bArr2, int i16, ErrMsg errMsg) {
    }

    public void onGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
    }
}
