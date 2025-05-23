package mqq.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.Constants;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WtloginServlet extends MSFServlet implements Constants.Action {
    private void handleSMSAction(int i3, Intent intent, String str) {
        if (i3 != 2215) {
            switch (i3) {
                case 2112:
                    sendToMSF(intent, MsfMsgUtil.get_wt_RefreshSMSData(str, intent.getStringExtra("userAccount"), 30000L));
                    return;
                case Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST /* 2113 */:
                    sendToMSF(intent, MsfMsgUtil.get_wt_CheckSMSAndGetSt(str, intent.getStringExtra("userAccount"), intent.getByteArrayExtra("userInput"), 30000L));
                    return;
                case 2114:
                    sendToMSF(intent, MsfMsgUtil.get_wt_CheckSMSAndGetStExt(str, intent.getStringExtra("userAccount"), intent.getByteArrayExtra("userInput"), 30000L));
                    return;
                default:
                    switch (i3) {
                        case Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT /* 2117 */:
                            sendToMSF(intent, MsfMsgUtil.get_wt_RegGetSMSVerifyLoginAccount(str, intent.getByteArrayExtra("msgchk"), intent.getByteArrayExtra("nick"), intent.getStringExtra("lhuin"), intent.getStringExtra("unBindlhUin"), intent.getStringExtra("appVersion"), 30000L));
                            return;
                        case Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT /* 2118 */:
                            ToServiceMsg toServiceMsg = MsfMsgUtil.get_wt_CheckSMSVerifyLoginAccount(str, intent.getStringExtra("userAccount"), intent.getStringExtra("countryCode"), intent.getIntExtra("appid", 0), 30000L);
                            byte[] byteArrayExtra = intent.getByteArrayExtra("verifyToken");
                            if (byteArrayExtra != null) {
                                toServiceMsg.addAttribute("verifyToken", byteArrayExtra);
                            }
                            sendToMSF(intent, toServiceMsg);
                            return;
                        case 2119:
                            sendToMSF(intent, MsfMsgUtil.get_wt_RefreshSMSVerifyLoginCode(str, intent.getStringExtra("countryCode"), intent.getStringExtra("userAccount"), 30000L));
                            return;
                        case 2120:
                            sendToMSF(intent, MsfMsgUtil.get_wt_VerifySMSVerifyLoginCode(str, intent.getStringExtra("countryCode"), intent.getStringExtra("userAccount"), intent.getStringExtra("code"), 30000L));
                            return;
                        case 2121:
                            ToServiceMsg toServiceMsg2 = MsfMsgUtil.get_wt_GetStViaSMSVerifyLogin(str, intent.getStringExtra("countryCode"), intent.getStringExtra("userAccount"), intent.getIntExtra("appid", 0), 30000L);
                            toServiceMsg2.addAttribute("from_where", intent.getStringExtra("from_where"));
                            sendToMSF(intent, toServiceMsg2);
                            return;
                        case 2122:
                            sendToMSF(intent, MsfMsgUtil.get_wt_GetSubaccountStViaSMSVerifyLogin(str, intent.getStringExtra("mainaccount"), intent.getStringExtra("countryCode"), intent.getStringExtra("userAccount"), intent.getIntExtra("appid", 0), 30000L));
                            return;
                        default:
                            return;
                    }
            }
        }
        sendToMSF(intent, MsfMsgUtil.get_wt_QuickLoginByGateway(str, intent, 30000L));
    }

    private void onRecvAskDevLockSms(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putParcelable("devLockInfo", (Parcelable) fromServiceMsg.attributes.get("devLockInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2109, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvCheckDevLockSms(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2110, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvCheckDevLockStatus(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putParcelable("devLockInfo", (Parcelable) fromServiceMsg.attributes.get("devLockInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2108, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvCheckPictureAndGetSt(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putByteArray("userInput", (byte[]) fromServiceMsg.attributes.get("userInput"));
            bundle.putByteArray("pictureData", (byte[]) fromServiceMsg.attributes.get("pictureData"));
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.attributes.get("userSigInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2102, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvCheckSMSAndGetSt(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putByteArray("userInput", (byte[]) fromServiceMsg.attributes.get("userInput"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvCheckSMSAndGetStExt(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putByteArray("userInput", (byte[]) fromServiceMsg.attributes.get("userInput"));
            bundle.putParcelable("st", null);
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2114, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvCheckSMSVerifyLoginAccount(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<String, Object> hashMap = fromServiceMsg.attributes;
        if (hashMap != null) {
            bundle.putString("countryCode", (String) hashMap.get("countryCode"));
            bundle.putString(DeviceType.DeviceCategory.MOBILE, (String) fromServiceMsg.attributes.get(DeviceType.DeviceCategory.MOBILE));
            bundle.putParcelable("errMsg", (ErrMsg) fromServiceMsg.attributes.get("errMsg"));
            bundle.putString("msg", (String) fromServiceMsg.attributes.get("msg"));
            Object attribute = fromServiceMsg.getAttribute("ret");
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            if (attribute instanceof Integer) {
                businessFailCode = ((Integer) attribute).intValue();
            }
            bundle.putInt("ret", businessFailCode);
        }
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvCloseCode(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putByteArray("appName", (byte[]) fromServiceMsg.attributes.get("appName"));
            bundle.putLong("time", ((Long) fromServiceMsg.attributes.get("time")).longValue());
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.attributes.get("userSigInfo"));
            bundle.putByteArray("errMsg", (byte[]) fromServiceMsg.attributes.get("errMsg"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2105, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvCloseDevLock(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2111, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvException(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        bundle.putString("error", (String) fromServiceMsg.attributes.get("error"));
        bundle.putInt("cmd", ((Integer) fromServiceMsg.attributes.get("cmd")).intValue());
        notifyObserver(intent, 2107, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvGetA1WithA1(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putLong("dwSrcAppid", ((Long) fromServiceMsg.attributes.get("dwSrcAppid")).longValue());
            bundle.putInt("dwMainSigMap", ((Integer) fromServiceMsg.attributes.get("dwMainSigMap")).intValue());
            bundle.putLong("dwSubSrcAppid", ((Long) fromServiceMsg.attributes.get("dwSubSrcAppid")).longValue());
            bundle.putByteArray("dstAppName", (byte[]) fromServiceMsg.attributes.get("dstAppName"));
            bundle.putLong("dwDstSsoVer", ((Long) fromServiceMsg.attributes.get("dwDstSsoVer")).longValue());
            bundle.putLong("dwSubDstAppid", ((Long) fromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
            bundle.putLong("dwSubDstAppid", ((Long) fromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
            bundle.putByteArray("dstAppVer", (byte[]) fromServiceMsg.attributes.get("dstAppVer"));
            bundle.putByteArray("dstAppSign", (byte[]) fromServiceMsg.attributes.get("dstAppSign"));
            bundle.putParcelable("userSigInfo", (WUserSigInfo) fromServiceMsg.attributes.get("userSigInfo"));
            bundle.putParcelable("fastLoginInfo", (WFastLoginInfo) fromServiceMsg.attributes.get("fastLoginInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2106, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvGetOpenKeyWithoutPasswd(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putLong("dwSrcAppid", ((Long) fromServiceMsg.attributes.get("dwSrcAppid")).longValue());
            bundle.putLong("dwDstAppid", ((Long) fromServiceMsg.attributes.get("dwDstAppid")).longValue());
            bundle.putInt("dwMainSigMap", ((Integer) fromServiceMsg.attributes.get("dwMainSigMap")).intValue());
            bundle.putByteArray("appid", (byte[]) fromServiceMsg.attributes.get("appid"));
            bundle.putByteArray("openid", (byte[]) fromServiceMsg.attributes.get("openid"));
            bundle.putByteArray(CommonConstant.KEY_ACCESS_TOKEN, (byte[]) fromServiceMsg.attributes.get(CommonConstant.KEY_ACCESS_TOKEN));
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.attributes.get("userSigInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_GET_OPEN_KEY_WITHOUT_PASSWD, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvGetStViaSMSVerifyLogin(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        String str;
        int i3;
        byte[] bArr;
        QLog.i(MSFServlet.TAG, 1, "onRecvGetStViaSMSVerifyLogin");
        if (fromServiceMsg.attributes != null) {
            getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
            bundle.putString("uin", fromServiceMsg.getUin());
            bundle.putString(NotificationActivity.KEY_ALIAS, intent.getStringExtra("userAccount"));
            bundle.putString("error", fromServiceMsg.getBusinessFailMsg());
            bundle.putByteArray("st_temp", (byte[]) fromServiceMsg.getAttribute("st_temp"));
            bundle.putByteArray("st_temp_key", (byte[]) fromServiceMsg.getAttribute("st_temp_key"));
            Object attribute = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_URL);
            if (attribute != null && (attribute instanceof String)) {
                str = (String) attribute;
            } else {
                str = "";
            }
            Object attribute2 = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_RET);
            if (attribute2 instanceof Integer) {
                i3 = ((Integer) attribute2).intValue();
            } else {
                i3 = 0;
            }
            Object attribute3 = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_LHSIG);
            if (attribute3 instanceof byte[]) {
                bArr = (byte[]) attribute3;
            } else {
                bArr = null;
            }
            bundle.putString("errorurl", str);
            bundle.putInt("loginret", i3);
            bundle.putInt("code", fromServiceMsg.getResultCode());
            bundle.putByteArray("lhsig", bArr);
            if (fromServiceMsg.isSuccess()) {
                if (!"com.tencent.mobileqq:openSdk".equals(getAppRuntime().getApplication().getQQProcessName())) {
                    MsfSdkUtils.addSimpleAccount(fromServiceMsg.getUin());
                    MsfSdkUtils.updateSimpleAccount(fromServiceMsg.getUin(), true);
                    if (!fromServiceMsg.getUin().equals(intent.getStringExtra("userAccount"))) {
                        MsfSdkUtils.delSimpleAccount(intent.getStringExtra("userAccount"));
                    }
                }
                String stringExtra = intent.getStringExtra("userAccount");
                if (!TextUtils.isEmpty(stringExtra)) {
                    getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + fromServiceMsg.getUin(), stringExtra);
                    List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
                    if (loginedAccountList != null) {
                        for (int i16 = 0; i16 < loginedAccountList.size(); i16++) {
                            SimpleAccount simpleAccount = loginedAccountList.get(i16);
                            if (simpleAccount != null) {
                                String uin = simpleAccount.getUin();
                                MobileQQ application = getAppRuntime().getApplication();
                                StringBuilder sb5 = new StringBuilder();
                                Constants.PropertiesKey propertiesKey = Constants.PropertiesKey.uinDisplayName;
                                sb5.append(propertiesKey.toString());
                                sb5.append(uin);
                                String property = application.getProperty(sb5.toString());
                                if (!TextUtils.isEmpty(property) && property.equals(stringExtra) && !uin.equals(fromServiceMsg.getUin())) {
                                    getAppRuntime().getApplication().setProperty(propertiesKey.toString() + uin, uin);
                                }
                            }
                        }
                    }
                }
            }
            getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            int resultCode = fromServiceMsg.getResultCode();
            Object obj = fromServiceMsg.attributes.get("ret");
            if (obj != null && (obj instanceof Integer)) {
                resultCode = ((Integer) obj).intValue();
            }
            bundle.putInt("ret", resultCode);
        }
        notifyObserver(intent, 2121, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvGetStWithPasswd(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putLong("dwAppid", ((Long) fromServiceMsg.attributes.get("dwAppid")).longValue());
            bundle.putInt("dwMainSigMap", ((Integer) fromServiceMsg.attributes.get("dwMainSigMap")).intValue());
            bundle.putLong("dwSubDstAppid", ((Long) fromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
            bundle.putString("userPasswd", (String) fromServiceMsg.attributes.get("userPasswd"));
            bundle.putByteArray("pictureData", (byte[]) fromServiceMsg.attributes.get("pictureData"));
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.attributes.get("userSigInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2100, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvGetStWithoutPasswd(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putLong("dwSrcAppid", ((Long) fromServiceMsg.attributes.get("dwSrcAppid")).longValue());
            bundle.putLong("dwDstAppid", ((Long) fromServiceMsg.attributes.get("dwDstAppid")).longValue());
            bundle.putInt("dwMainSigMap", ((Integer) fromServiceMsg.attributes.get("dwMainSigMap")).intValue());
            bundle.putLong("dwSubDstAppid", ((Long) fromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.attributes.get("userSigInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2101, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvGetSubaccountStViaSMSVerifyLogin(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        QLog.i(MSFServlet.TAG, 1, "onRecvGetSubaccountStViaSMSVerifyLogin");
        if (fromServiceMsg.attributes != null) {
            getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
            if (fromServiceMsg.isSuccess()) {
                MsfSdkUtils.addSimpleAccount(fromServiceMsg.getUin());
                MsfSdkUtils.updateSimpleAccount(fromServiceMsg.getUin(), true);
                if (!fromServiceMsg.getUin().equals(intent.getStringExtra("userAccount"))) {
                    MsfSdkUtils.delSimpleAccount(intent.getStringExtra("userAccount"));
                }
                String stringExtra = intent.getStringExtra("userAccount");
                if (!TextUtils.isEmpty(stringExtra)) {
                    getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + fromServiceMsg.getUin(), stringExtra);
                    List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
                    if (loginedAccountList != null) {
                        for (int i3 = 0; i3 < loginedAccountList.size(); i3++) {
                            SimpleAccount simpleAccount = loginedAccountList.get(i3);
                            if (simpleAccount != null) {
                                String uin = simpleAccount.getUin();
                                MobileQQ application = getAppRuntime().getApplication();
                                StringBuilder sb5 = new StringBuilder();
                                Constants.PropertiesKey propertiesKey = Constants.PropertiesKey.uinDisplayName;
                                sb5.append(propertiesKey.toString());
                                sb5.append(uin);
                                String property = application.getProperty(sb5.toString());
                                if (!TextUtils.isEmpty(property) && property.equals(stringExtra) && !uin.equals(fromServiceMsg.getUin())) {
                                    getAppRuntime().getApplication().setProperty(propertiesKey.toString() + uin, uin);
                                }
                            }
                        }
                    }
                }
            }
            String str = (String) fromServiceMsg.getAttribute("mainaccount");
            bundle.putString("submainaccount", str);
            SimpleAccount firstSimpleAccount = getAppRuntime().getApplication().getFirstSimpleAccount();
            long currentTimeMillis = System.currentTimeMillis();
            if (firstSimpleAccount != null) {
                try {
                    long string2Long = MobileQQ.string2Long(getAppRuntime().getApplication().getProperty(firstSimpleAccount.getUin() + Constants.Key._logintime));
                    if (currentTimeMillis <= string2Long) {
                        currentTimeMillis = string2Long + 1;
                        if (QLog.isColorLevel()) {
                            QLog.d("mqq", 2, "CNR account savetime => system time is error..");
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            if (fromServiceMsg.getUin() != null) {
                getAppRuntime().getApplication().setProperty(fromServiceMsg.getUin() + Constants.Key._logintime, String.valueOf(currentTimeMillis));
            }
            if (str != null) {
                getAppRuntime().getApplication().setProperty(str + Constants.Key._logintime, String.valueOf(currentTimeMillis + 1));
            }
            getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
            bundle.putString("userAccount", fromServiceMsg.getUin());
            int resultCode = fromServiceMsg.getResultCode();
            Object obj = fromServiceMsg.attributes.get("ret");
            if (obj != null && (obj instanceof Integer)) {
                resultCode = ((Integer) obj).intValue();
            }
            bundle.putInt("ret", resultCode);
        }
        notifyObserver(intent, 2122, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvRefreshPictureData(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putByteArray("pictureData", (byte[]) fromServiceMsg.attributes.get("pictureData"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2103, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvRefreshSMSData(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putLong("smsAppid", ((Long) fromServiceMsg.attributes.get("smsAppid")).longValue());
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putInt("remainMsgCnt", ((Integer) fromServiceMsg.attributes.get("remainMsgCnt")).intValue());
            bundle.putInt("timeLimit", ((Integer) fromServiceMsg.attributes.get("timeLimit")).intValue());
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2112, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvRefreshSMSVerifyLoginCode(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<String, Object> hashMap = fromServiceMsg.attributes;
        if (hashMap != null) {
            bundle.putString(DeviceType.DeviceCategory.MOBILE, (String) hashMap.get(DeviceType.DeviceCategory.MOBILE));
            bundle.putParcelable("errMsg", (ErrMsg) fromServiceMsg.attributes.get("errMsg"));
            bundle.putString("msg", (String) fromServiceMsg.attributes.get("msg"));
            Object attribute = fromServiceMsg.getAttribute("ret");
            Integer valueOf = Integer.valueOf(fromServiceMsg.getBusinessFailCode());
            if (attribute instanceof Integer) {
                valueOf = (Integer) attribute;
            }
            bundle.putInt("ret", valueOf.intValue());
        }
        notifyObserver(intent, 2119, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvRegGetSMSVerifyLoginAccount(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.attributes != null) {
            Object attribute = fromServiceMsg.getAttribute("userAccount");
            Long l3 = 0L;
            if (attribute != null) {
                l3 = (Long) attribute;
            }
            bundle.putLong("userAccount", l3.longValue());
            bundle.putByteArray("supersig", (byte[]) fromServiceMsg.attributes.get("supersig"));
            bundle.putByteArray("contactssig", (byte[]) fromServiceMsg.attributes.get("contactssig"));
            bundle.putByteArray("msg", (byte[]) fromServiceMsg.attributes.get("msg"));
            byte[] bArr = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_LH_SIG, null);
            if (bArr != null && bArr.length > 0) {
                bundle.putByteArray("lhsig", bArr);
                if (QLog.isColorLevel()) {
                    QLog.d("wtLogin_LiangHao", 2, "wtloginServlet|lhsig= " + new String(bArr));
                }
            }
            Object attribute2 = fromServiceMsg.getAttribute("ret");
            Integer valueOf = Integer.valueOf(fromServiceMsg.getBusinessFailCode());
            if (attribute2 instanceof Integer) {
                valueOf = (Integer) attribute2;
            }
            bundle.putInt("ret", valueOf.intValue());
            if (QLog.isColorLevel()) {
                QLog.d("wtLogin_LiangHao", 2, "wtloginServlet|RegGetAccount|ret=" + valueOf + ",uin=" + l3);
            }
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("lhuin"))) {
            bundle.putBoolean("reg_LiangHao", true);
        }
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvVerifyCode(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putByteArray("appName", (byte[]) fromServiceMsg.attributes.get("appName"));
            bundle.putLong("time", ((Long) fromServiceMsg.attributes.get("time")).longValue());
            bundle.putStringArrayList("data", (ArrayList) fromServiceMsg.attributes.get("data"));
            bundle.putByteArray("errMsg", (byte[]) fromServiceMsg.attributes.get("errMsg"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2104, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    private void onRecvVerifySMSVerifyLoginCode(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<String, Object> hashMap = fromServiceMsg.attributes;
        if (hashMap != null) {
            bundle.putString("msgCode", (String) hashMap.get("msgCode"));
            bundle.putString(DeviceType.DeviceCategory.MOBILE, (String) fromServiceMsg.attributes.get(DeviceType.DeviceCategory.MOBILE));
            bundle.putParcelable("errMsg", (ErrMsg) fromServiceMsg.attributes.get("errMsg"));
            bundle.putParcelable("userSigInfo", (WUserSigInfo) fromServiceMsg.attributes.get("userSigInfo"));
            Object attribute = fromServiceMsg.getAttribute("ret");
            Integer valueOf = Integer.valueOf(fromServiceMsg.getBusinessFailCode());
            if (attribute instanceof Integer) {
                valueOf = (Integer) attribute;
            }
            bundle.putInt("ret", valueOf.intValue());
        }
        notifyObserver(intent, 2120, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int intExtra;
        if (fromServiceMsg.getBusinessFailCode() == 3002) {
            intExtra = 2107;
        } else {
            intExtra = intent.getIntExtra("action", 0);
        }
        Bundle bundle = new Bundle();
        if (intExtra != 2208) {
            if (intExtra != 2215) {
                switch (intExtra) {
                    case 2100:
                        onRecvGetStWithPasswd(intent, fromServiceMsg, bundle);
                        return;
                    case 2101:
                        onRecvGetStWithoutPasswd(intent, fromServiceMsg, bundle);
                        return;
                    case 2102:
                        onRecvCheckPictureAndGetSt(intent, fromServiceMsg, bundle);
                        return;
                    case 2103:
                        onRecvRefreshPictureData(intent, fromServiceMsg, bundle);
                        return;
                    case 2104:
                        onRecvVerifyCode(intent, fromServiceMsg, bundle);
                        return;
                    case 2105:
                        onRecvCloseCode(intent, fromServiceMsg, bundle);
                        return;
                    case 2106:
                        onRecvGetA1WithA1(intent, fromServiceMsg, bundle);
                        return;
                    case 2107:
                        onRecvException(intent, fromServiceMsg, bundle);
                        return;
                    case 2108:
                        onRecvCheckDevLockStatus(intent, fromServiceMsg, bundle);
                        return;
                    case 2109:
                        onRecvAskDevLockSms(intent, fromServiceMsg, bundle);
                        return;
                    case 2110:
                        onRecvCheckDevLockSms(intent, fromServiceMsg, bundle);
                        return;
                    case 2111:
                        onRecvCloseDevLock(intent, fromServiceMsg, bundle);
                        return;
                    case 2112:
                        onRecvRefreshSMSData(intent, fromServiceMsg, bundle);
                        return;
                    case Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST /* 2113 */:
                        onRecvCheckSMSAndGetSt(intent, fromServiceMsg, bundle);
                        return;
                    case 2114:
                        onRecvCheckSMSAndGetStExt(intent, fromServiceMsg, bundle);
                        return;
                    default:
                        switch (intExtra) {
                            case Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT /* 2117 */:
                                onRecvRegGetSMSVerifyLoginAccount(intent, fromServiceMsg, bundle);
                                return;
                            case Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT /* 2118 */:
                                onRecvCheckSMSVerifyLoginAccount(intent, fromServiceMsg, bundle);
                                return;
                            case 2119:
                                onRecvRefreshSMSVerifyLoginCode(intent, fromServiceMsg, bundle);
                                return;
                            case 2120:
                                onRecvVerifySMSVerifyLoginCode(intent, fromServiceMsg, bundle);
                                return;
                            case 2121:
                                onRecvGetStViaSMSVerifyLogin(intent, fromServiceMsg, bundle);
                                return;
                            case 2122:
                                onRecvGetSubaccountStViaSMSVerifyLogin(intent, fromServiceMsg, bundle);
                                return;
                            default:
                                return;
                        }
                }
            }
            onRecvQuickLoginByGateway(intent, fromServiceMsg, bundle);
            return;
        }
        onRecvGetOpenKeyWithoutPasswd(intent, fromServiceMsg, bundle);
    }

    protected void onRecvQuickLoginByGateway(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<String, Object> hashMap = fromServiceMsg.attributes;
        if (hashMap != null) {
            WUserSigInfo wUserSigInfo = (WUserSigInfo) hashMap.get("userSigInfo");
            bundle.putParcelable("userSigInfo", (WUserSigInfo) fromServiceMsg.attributes.get("userSigInfo"));
            bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO));
            if (wUserSigInfo != null) {
                bundle.putInt(BaseConstants.ATTR_KET_SSO_SEQ, (int) wUserSigInfo._seqence);
            }
            bundle.putParcelable(BaseConstants.ATTR_KET_TO_SERVICE_MSG, (ToServiceMsg) fromServiceMsg.attributes.get(BaseConstants.ATTR_KET_TO_SERVICE_MSG));
            bundle.putParcelable("errMsg", (ErrMsg) fromServiceMsg.attributes.get("errMsg"));
            Object attribute = fromServiceMsg.getAttribute("ret");
            bundle.putString("uin", (String) fromServiceMsg.attributes.get("uin"));
            Integer valueOf = Integer.valueOf(fromServiceMsg.getBusinessFailCode());
            if (attribute instanceof Integer) {
                valueOf = (Integer) attribute;
            }
            bundle.putInt("ret", valueOf.intValue());
        }
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_QUICK_LOGIN_BY_GATEWAY, fromServiceMsg.isSuccess(), bundle, WtloginObserver.class);
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        super.service(intent);
        int intExtra = intent.getIntExtra("action", 0);
        String msfServiceName = MsfServiceSdk.get().getMsfServiceName();
        if (intExtra != 2125) {
            if (intExtra != 2129) {
                if (intExtra != 2208) {
                    if (intExtra != 2213) {
                        switch (intExtra) {
                            case 2100:
                                sendToMSF(intent, MsfMsgUtil.get_wt_GetStWithPasswd(msfServiceName, intent.getStringExtra("uin"), intent.getLongExtra("appid", 0L), intent.getStringExtra("passwd"), 30000L));
                                return;
                            case 2101:
                                sendToMSF(intent, MsfMsgUtil.get_wt_GetStWithoutPasswd(msfServiceName, intent.getStringExtra("uin"), intent.getLongExtra("dwSrcAppid", 0L), intent.getLongExtra("dwDstAppid", 0L), 30000L));
                                return;
                            case 2102:
                                sendToMSF(intent, MsfMsgUtil.get_wt_CheckPictureAndGetSt(msfServiceName, intent.getStringExtra("uin"), intent.getByteArrayExtra("userInput"), 30000L));
                                return;
                            case 2103:
                                sendToMSF(intent, MsfMsgUtil.get_wt_RefreshPictureData(msfServiceName, intent.getStringExtra("uin"), 30000L));
                                return;
                            case 2104:
                                sendToMSF(intent, MsfMsgUtil.get_wt_VerifyCode(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("appid", 0L), intent.getBooleanExtra("close", false), intent.getByteArrayExtra("code"), intent.getIntArrayExtra("tlv"), intent.getIntExtra("version", 0), 30000L));
                                return;
                            case 2105:
                                sendToMSF(intent, MsfMsgUtil.get_wt_CloseCode(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("appid", 0L), intent.getByteArrayExtra("code"), intent.getIntExtra("version", 0), intent.getStringArrayListExtra("data"), 30000L));
                                return;
                            case 2106:
                                sendToMSF(intent, MsfMsgUtil.get_wt_GetA1WithA1(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("dwSrcAppid", 0L), intent.getLongExtra("dwSubSrcAppid", 0L), intent.getByteArrayExtra("dstAppName"), intent.getLongExtra("dwDstSsoVer", 0L), intent.getLongExtra("dwDstAppid", 0L), intent.getLongExtra("dwSubDstAppid", 0L), intent.getByteArrayExtra("dstAppVer"), intent.getByteArrayExtra("dstAppSign"), (WFastLoginInfo) ((NewIntent) intent).intentMap.get("fastLoginInfo"), 30000L));
                                return;
                            default:
                                switch (intExtra) {
                                    case 2108:
                                        sendToMSF(intent, MsfMsgUtil.get_wt_CheckDevLockStatus(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("subAppid", 0L), 30000L));
                                        return;
                                    case 2109:
                                        sendToMSF(intent, MsfMsgUtil.get_wt_AskDevLockSms(msfServiceName, intent.getStringExtra("userAccount"), 30000L));
                                        return;
                                    case 2110:
                                        sendToMSF(intent, MsfMsgUtil.get_wt_CheckDevLockSms(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("subAppid", 0L), intent.getStringExtra("smsCode"), intent.getByteArrayExtra("sppKey"), 30000L));
                                        return;
                                    case 2111:
                                        sendToMSF(intent, MsfMsgUtil.get_wt_CloseDevLock(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("subAppid", 0L), 30000L));
                                        return;
                                    default:
                                        handleSMSAction(intExtra, intent, msfServiceName);
                                        return;
                                }
                        }
                    }
                    sendToMSF(intent, MsfMsgUtil.get_wt_CancelCode(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("appid", 0L), intent.getByteArrayExtra("code"), intent.getByteArrayExtra(BaseConstants.ATTRIBUTE_KEY_PB_DATA), 30000L));
                    return;
                }
                sendToMSF(intent, MsfMsgUtil.get_wt_GetOpenKeyWithoutPasswd(msfServiceName, intent.getStringExtra("uin"), intent.getLongExtra("dwSrcAppid", 0L), intent.getLongExtra("dwDstAppid", 0L), 30000L));
                return;
            }
            sendToMSF(intent, MsfMsgUtil.get_wt_SetDevlockMobileType(msfServiceName, intent.getIntExtra("mobile_type", 0), 30000L));
            return;
        }
        sendToMSF(intent, MsfMsgUtil.get_wt_setRegDevLockFlag(msfServiceName, intent.getIntExtra("flag", 0), 30000L));
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
    }
}
