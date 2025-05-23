package com.tencent.mobileqq.loginregister.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.login.verify.DevLockVerifyComponent;
import com.tencent.mobileqq.login.verify.PuzzleVerifyInfo;
import com.tencent.mobileqq.login.verify.j;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.util.AppSetting;
import cooperation.qzone.util.WnsError;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MSFServlet;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.login.GatewayVerify$RspBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i extends MSFServlet {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(Intent intent, ToServiceMsg toServiceMsg) {
        Bundle bundleExtra = intent.getBundleExtra("extra");
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                Object obj = bundleExtra.get(str);
                toServiceMsg.addAttribute(str, obj);
                QLog.d("WtloginServlet", 2, "WtloginServlet --> key=" + str + ", value=" + obj);
            }
        }
    }

    private void addOpenSdkExtra(Intent intent, ToServiceMsg toServiceMsg) {
        Bundle bundleExtra;
        if (BaseConstants.SSO_ACCOUNT_ACTION.equals(intent.getStringExtra("from_where")) && (bundleExtra = intent.getBundleExtra("extra")) != null) {
            for (String str : bundleExtra.keySet()) {
                Object obj = bundleExtra.get(str);
                toServiceMsg.addAttribute(str, obj);
                QLog.d("WtloginServlet", 2, "WtloginServlet --> key=" + str + ", value=" + obj);
            }
        }
    }

    private void b(FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<Integer, tlv_t> hashMap;
        tlv_t tlv_tVar;
        Object attribute = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_LHSIG);
        if (attribute instanceof byte[]) {
            bundle.putByteArray("LHSig", (byte[]) attribute);
        }
        WUserSigInfo wUserSigInfo = (WUserSigInfo) fromServiceMsg.getAttribute("userSigInfo");
        if (wUserSigInfo == null) {
            wUserSigInfo = (WUserSigInfo) fromServiceMsg.getAttribute(BuiltInServlet.MSF_KEY_SIG_INFO);
        }
        byte[] bArr = null;
        if (wUserSigInfo != null) {
            hashMap = wUserSigInfo.loginResultTLVMap;
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            tlv_tVar = hashMap.get(1347);
        } else {
            tlv_tVar = null;
        }
        if (tlv_tVar != null) {
            bArr = tlv_tVar.get_data();
        }
        if (bArr == null) {
            return;
        }
        bundle.putByteArray("errorTlv", bArr);
        try {
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(bArr);
            long j3 = gatewayVerify$RspBody.msg_rsp_third_login.uint64_qq_uin.get();
            if (j3 > 0) {
                bundle.putString("LHUin", String.valueOf(j3));
            }
        } catch (Exception e16) {
            QLog.e("WtloginServlet", 1, "bundlePutLHExpiredResp", e16);
        }
    }

    private void c(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        boolean z16;
        PuzzleVerifyInfo e16;
        if (fromServiceMsg.attributes != null) {
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            Object attribute = fromServiceMsg.getAttribute("ret");
            if (attribute instanceof Integer) {
                businessFailCode = ((Integer) attribute).intValue();
            }
            bundle.putInt("ret", businessFailCode);
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
            if (businessFailCode == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            bundle.putBoolean("needPuzzleVerify", z16);
            if (z16 && (e16 = j.e(fromServiceMsg)) != null && !TextUtils.isEmpty(e16.D)) {
                bundle.putParcelable("puzzleVerifyInfo", e16);
            }
            bundle.putParcelable("userSigInfo", (WUserSigInfo) fromServiceMsg.attributes.get("userSigInfo"));
        }
        notifyObserver(intent, WnsError.WNS_CODE_DIS_STAT_BEGIN, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void d(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<String, Object> hashMap = fromServiceMsg.attributes;
        if (hashMap != null) {
            bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) hashMap.get(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO));
            bundle.putParcelable(BaseConstants.ATTR_KET_TO_SERVICE_MSG, (ToServiceMsg) fromServiceMsg.attributes.get(BaseConstants.ATTR_KET_TO_SERVICE_MSG));
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            Object attribute = fromServiceMsg.getAttribute("ret");
            if (attribute instanceof Integer) {
                businessFailCode = ((Integer) attribute).intValue();
            }
            bundle.putInt("ret", businessFailCode);
        }
        bundle.putString("uin", fromServiceMsg.getUin());
        if (fromServiceMsg.isSuccess()) {
            String uin = fromServiceMsg.getUin();
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(uin, (byte) 0);
            if (z.p(uin)) {
                MsfSdkUtils.addLoginSimpleAccount(uin, true);
            }
            MobileQQ.sMobileQQ.refreAccountList();
        } else {
            b(fromServiceMsg, bundle);
        }
        notifyObserver(intent, Constants.Action.ACTION_LOGIN_START_NOTIFY, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void e(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.attributes != null) {
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            Object attribute = fromServiceMsg.getAttribute("ret");
            if (attribute instanceof Integer) {
                businessFailCode = ((Integer) attribute).intValue();
            }
            bundle.putInt("ret", businessFailCode);
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
            bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO));
        }
        bundle.putString("uin", fromServiceMsg.getUin());
        if (fromServiceMsg.isSuccess()) {
            String uin = fromServiceMsg.getUin();
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(fromServiceMsg.getUin(), (byte) 0);
            boolean equals = BaseConstants.SSO_ACCOUNT_ACTION.equals(intent.getStringExtra("from_where"));
            if (z.p(uin) && !equals) {
                MsfSdkUtils.addLoginSimpleAccount(uin, true);
                MobileQQ.sMobileQQ.refreAccountList();
            }
            if ("sub_account".equals(intent.getStringExtra("from_where"))) {
                j(intent.getStringExtra("mainaccount"), fromServiceMsg.getUin());
            }
            bundle.putByteArray("wtTicket", (byte[]) fromServiceMsg.getAttribute("wtTicket"));
            bundle.putInt("targetTicket", intent.getIntExtra("targetTicket", 64));
            bundle.putByteArray("st_temp", (byte[]) fromServiceMsg.getAttribute("st_temp"));
            bundle.putByteArray("st_temp_key", (byte[]) fromServiceMsg.getAttribute("st_temp_key"));
        } else {
            b(fromServiceMsg, bundle);
        }
        notifyObserver(intent, JsonGrayBusiId.AIO_GROUP_ESSENCE_MSG_TIP, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void f(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        bundle.putString("uin", fromServiceMsg.getUin());
        Object attribute = fromServiceMsg.getAttribute("ret");
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        if (attribute instanceof Integer) {
            businessFailCode = ((Integer) attribute).intValue();
        }
        bundle.putInt("ret", businessFailCode);
        QLog.i("WtloginServlet", 1, "onRecvGetStViaWxLogin ret=" + businessFailCode);
        if (businessFailCode == 0) {
            if (z.p(fromServiceMsg.getUin())) {
                MsfSdkUtils.addLoginSimpleAccount(fromServiceMsg.getUin(), true);
            }
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(fromServiceMsg.getUin(), (byte) 0);
        } else if (DevLockVerifyComponent.o(businessFailCode)) {
            bundle.putBoolean("needDevLockVerify", true);
            Object attribute2 = fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
            if (attribute2 instanceof DevlockInfo) {
                bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) attribute2);
            }
        } else {
            try {
                bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR));
            } catch (Exception e16) {
                QLog.e("WtloginServlet", 1, "getAttribute error:" + e16.getMessage());
            }
            b(fromServiceMsg, bundle);
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        notifyObserver(intent, 2307, fromServiceMsg.isSuccess(), bundle, com.tencent.mobileqq.login.servlet.e.class);
    }

    private void g(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, JsonGrayBusiId.GROUP_AIO_UPLOAD_PERMISSIONS_GRAY_TIP_ID, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void h(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        bundle.putString("uin", fromServiceMsg.getUin());
        Object attribute = fromServiceMsg.getAttribute("ret");
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        if (attribute instanceof Integer) {
            businessFailCode = ((Integer) attribute).intValue();
        }
        bundle.putInt("ret", businessFailCode);
        boolean z16 = true;
        QLog.i("WtloginServlet", 1, "onRecvWxLogin ret=" + businessFailCode);
        if (businessFailCode != 0) {
            try {
                bundle.putParcelable("errMsg", (ErrMsg) fromServiceMsg.getAttribute("errMsg"));
            } catch (Exception e16) {
                QLog.e("WtloginServlet", 1, "getAttribute error:" + e16.getMessage());
            }
        }
        if (businessFailCode != 0) {
            z16 = false;
        }
        notifyObserver(intent, 2306, z16, bundle, com.tencent.mobileqq.login.servlet.e.class);
    }

    private void handleSMSAction(int i3, Intent intent, String str) {
        if (i3 != 2215) {
            if (i3 != 2216) {
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
                                toServiceMsg.addAttribute("from_where", intent.getStringExtra("from_where"));
                                addOpenSdkExtra(intent, toServiceMsg);
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
                                String stringExtra = intent.getStringExtra("mainaccount");
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    toServiceMsg2.addAttribute("mainaccount", stringExtra);
                                }
                                byte[] byteArrayExtra2 = intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_WTLOGIN_542);
                                if (byteArrayExtra2 != null) {
                                    toServiceMsg2.addAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_542, byteArrayExtra2);
                                }
                                sendToMSF(intent, toServiceMsg2);
                                return;
                            default:
                                return;
                        }
                }
            }
            ToServiceMsg toServiceMsg3 = MsfMsgUtil.get_wt_GetStViaGatewayLogin(str, intent.getIntExtra("appid", 0), 30000L);
            toServiceMsg3.addAttribute("from_where", intent.getStringExtra("from_where"));
            String stringExtra2 = intent.getStringExtra("mainaccount");
            if (!TextUtils.isEmpty(stringExtra2)) {
                toServiceMsg3.addAttribute("mainaccount", stringExtra2);
            }
            byte[] byteArrayExtra3 = intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_WTLOGIN_542);
            if (byteArrayExtra3 != null) {
                toServiceMsg3.addAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_542, byteArrayExtra3);
            }
            sendToMSF(intent, toServiceMsg3);
            return;
        }
        ToServiceMsg toServiceMsg4 = MsfMsgUtil.get_wt_QuickLoginByGateway(str, intent, 30000L);
        toServiceMsg4.addAttribute("from_where", intent.getStringExtra("from_where"));
        String stringExtra3 = intent.getStringExtra("mainaccount");
        if (!TextUtils.isEmpty(stringExtra3)) {
            toServiceMsg4.addAttribute("mainaccount", stringExtra3);
        }
        sendToMSF(intent, toServiceMsg4);
    }

    private void j(String str, String str2) {
        SimpleAccount firstSimpleAccount = getAppRuntime().getApplication().getFirstSimpleAccount();
        long currentTimeMillis = System.currentTimeMillis();
        if (firstSimpleAccount != null) {
            try {
                long string2Long = MobileQQ.string2Long(getAppRuntime().getApplication().getProperty(firstSimpleAccount.getUin() + Constants.Key._logintime));
                if (currentTimeMillis <= string2Long) {
                    currentTimeMillis = string2Long + 1;
                    if (QLog.isColorLevel()) {
                        QLog.d("WtloginServlet", 2, "CNR account savetime => system time is error..");
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            QLog.i("WtloginServlet", 1, "setProperty _logintime uin:" + StringUtil.getSimpleUinForPrint(str2) + " time:" + currentTimeMillis);
            MobileQQ application = getAppRuntime().getApplication();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(Constants.Key._logintime);
            application.setProperty(sb5.toString(), String.valueOf(currentTimeMillis));
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("setProperty _logintime uin:");
            sb6.append(StringUtil.getSimpleUinForPrint(str));
            sb6.append(" time:");
            long j3 = currentTimeMillis + 1;
            sb6.append(j3);
            QLog.i("WtloginServlet", 1, sb6.toString());
            getAppRuntime().getApplication().setProperty(str + Constants.Key._logintime, String.valueOf(j3));
        }
    }

    private void onRecvAskDevLockSms(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putParcelable("devLockInfo", (Parcelable) fromServiceMsg.attributes.get("devLockInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2109, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void onRecvCheckDevLockSms(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2110, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void onRecvCheckDevLockStatus(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putParcelable("devLockInfo", (Parcelable) fromServiceMsg.attributes.get("devLockInfo"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2108, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2102, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void onRecvCheckSMSAndGetSt(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putByteArray("userInput", (byte[]) fromServiceMsg.attributes.get("userInput"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_CHECK_SMS_AND_GET_ST, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2114, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_CHECK_SMS_VERIFY_LOGIN_ACCOUNT, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2105, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void onRecvCloseDevLock(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putParcelable(BuiltInServlet.MSF_KEY_SIG_INFO, (Parcelable) fromServiceMsg.attributes.get(BuiltInServlet.MSF_KEY_SIG_INFO));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2111, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void onRecvException(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        bundle.putString("error", (String) fromServiceMsg.attributes.get("error"));
        bundle.putInt("cmd", ((Integer) fromServiceMsg.attributes.get("cmd")).intValue());
        notifyObserver(intent, 2107, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2106, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_GET_OPEN_KEY_WITHOUT_PASSWD, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void onRecvGetStViaSMSVerifyLogin(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        String str;
        int i3;
        bundle.putString("uin", fromServiceMsg.getUin());
        if (fromServiceMsg.attributes != null) {
            getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
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
            bundle.putString("errorurl", str);
            bundle.putInt("loginret", i3);
            bundle.putInt("code", fromServiceMsg.getResultCode());
            if (fromServiceMsg.isSuccess()) {
                String stringExtra = intent.getStringExtra("from_where");
                if (!BaseConstants.SSO_ACCOUNT_ACTION.equals(stringExtra)) {
                    MsfSdkUtils.addSimpleAccount(fromServiceMsg.getUin());
                    MsfSdkUtils.updateSimpleAccount(fromServiceMsg.getUin(), true);
                    if (!fromServiceMsg.getUin().equals(intent.getStringExtra("userAccount"))) {
                        MsfSdkUtils.delSimpleAccount(intent.getStringExtra("userAccount"));
                    }
                    ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(fromServiceMsg.getUin(), (byte) 2);
                }
                if ("sub_account".equals(stringExtra)) {
                    j(intent.getStringExtra("mainaccount"), fromServiceMsg.getUin());
                }
            } else {
                b(fromServiceMsg, bundle);
            }
            getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            Object obj = fromServiceMsg.attributes.get("ret");
            if (obj instanceof Integer) {
                businessFailCode = ((Integer) obj).intValue();
            }
            bundle.putInt("ret", businessFailCode);
            Object obj2 = fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
            if (obj2 instanceof DevlockInfo) {
                bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) obj2);
            }
        }
        notifyObserver(intent, 2121, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2100, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2101, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void onRecvRefreshPictureData(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        if (fromServiceMsg.isSuccess()) {
            bundle.putString("userAccount", (String) fromServiceMsg.attributes.get("userAccount"));
            bundle.putByteArray("pictureData", (byte[]) fromServiceMsg.attributes.get("pictureData"));
            bundle.putInt("ret", ((Integer) fromServiceMsg.attributes.get("ret")).intValue());
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) fromServiceMsg.attributes.get(NotificationActivity.KEY_LAST_ERROR));
        }
        notifyObserver(intent, 2103, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2112, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2119, fromServiceMsg.isSuccess(), bundle, h.class);
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
                    QLog.d("WtloginServlet", 2, "wtloginServlet|lhsig= " + new String(bArr));
                }
            }
            Object attribute2 = fromServiceMsg.getAttribute("ret");
            Integer valueOf = Integer.valueOf(fromServiceMsg.getBusinessFailCode());
            if (attribute2 instanceof Integer) {
                valueOf = (Integer) attribute2;
            }
            bundle.putInt("ret", valueOf.intValue());
            if (QLog.isColorLevel()) {
                QLog.d("WtloginServlet", 2, "wtloginServlet|RegGetAccount|ret=" + valueOf + ",uin=" + l3);
            }
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("lhuin"))) {
            bundle.putBoolean("reg_LiangHao", true);
        }
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_REG_GET_SMS_VERIFY_LOGIN_ACCOUNT, fromServiceMsg.isSuccess(), bundle, h.class);
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
        notifyObserver(intent, 2104, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    private void onRecvVerifySMSVerifyLoginCode(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<String, Object> hashMap = fromServiceMsg.attributes;
        if (hashMap != null) {
            bundle.putString("msgCode", (String) hashMap.get("msgCode"));
            bundle.putString(DeviceType.DeviceCategory.MOBILE, (String) fromServiceMsg.attributes.get(DeviceType.DeviceCategory.MOBILE));
            bundle.putParcelable("errMsg", (ErrMsg) fromServiceMsg.attributes.get("errMsg"));
            bundle.putParcelable("userSigInfo", (WUserSigInfo) fromServiceMsg.attributes.get("userSigInfo"));
            Object obj = fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
            if (obj instanceof DevlockInfo) {
                bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) obj);
            } else {
                QLog.e("WtloginServlet", 1, "onRecvVerifySMSVerifyLoginCode devlockInfo is null");
            }
            Object attribute = fromServiceMsg.getAttribute("ret");
            Integer valueOf = Integer.valueOf(fromServiceMsg.getBusinessFailCode());
            if (attribute instanceof Integer) {
                valueOf = (Integer) attribute;
            }
            bundle.putInt("ret", valueOf.intValue());
        }
        notifyObserver(intent, 2120, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int intExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg.getBusinessFailCode() == 3002) {
            intExtra = 2107;
        } else {
            intExtra = intent.getIntExtra("action", 0);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WtloginServlet", 4, "[FromServiceMsg] serviceCmd:" + fromServiceMsg.getServiceCmd() + " msfCommand:" + fromServiceMsg.getMsfCommand() + " uin:" + fromServiceMsg.getUin() + " appSeq:" + fromServiceMsg.getAppSeq() + " ssoSeq:" + fromServiceMsg.getRequestSsoSeq() + " attributes:" + fromServiceMsg.getAttributes());
        }
        Bundle bundle = new Bundle();
        if (intExtra != 2208) {
            if (intExtra != 2403) {
                if (intExtra != 2215) {
                    if (intExtra != 2216) {
                        if (intExtra != 2306) {
                            if (intExtra != 2307) {
                                if (intExtra != 2400) {
                                    if (intExtra != 2401) {
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
                                                    default:
                                                        return;
                                                }
                                        }
                                    }
                                    e(intent, fromServiceMsg, bundle);
                                    return;
                                }
                                c(intent, fromServiceMsg, bundle);
                                return;
                            }
                            f(intent, fromServiceMsg, bundle);
                            return;
                        }
                        h(intent, fromServiceMsg, bundle);
                        return;
                    }
                    d(intent, fromServiceMsg, bundle);
                    return;
                }
                onRecvQuickLoginByGateway(intent, fromServiceMsg, bundle);
                return;
            }
            g(intent, fromServiceMsg, bundle);
            return;
        }
        onRecvGetOpenKeyWithoutPasswd(intent, fromServiceMsg, bundle);
    }

    protected void onRecvQuickLoginByGateway(Intent intent, FromServiceMsg fromServiceMsg, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, intent, fromServiceMsg, bundle);
            return;
        }
        HashMap<String, Object> hashMap = fromServiceMsg.attributes;
        if (hashMap != null) {
            WUserSigInfo wUserSigInfo = (WUserSigInfo) hashMap.get("userSigInfo");
            bundle.putParcelable("userSigInfo", (WUserSigInfo) fromServiceMsg.attributes.get("userSigInfo"));
            if (wUserSigInfo != null) {
                bundle.putInt(BaseConstants.ATTR_KET_SSO_SEQ, (int) wUserSigInfo._seqence);
            }
            bundle.putParcelable(BaseConstants.ATTR_KET_TO_SERVICE_MSG, (ToServiceMsg) fromServiceMsg.attributes.get(BaseConstants.ATTR_KET_TO_SERVICE_MSG));
            bundle.putParcelable("errMsg", (ErrMsg) fromServiceMsg.attributes.get("errMsg"));
            Object attribute = fromServiceMsg.getAttribute("ret");
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            if (attribute instanceof Integer) {
                businessFailCode = ((Integer) attribute).intValue();
            }
            bundle.putInt("ret", businessFailCode);
        }
        notifyObserver(intent, Constants.Action.ACTION_WTLOGIN_QUICK_LOGIN_BY_GATEWAY, fromServiceMsg.isSuccess(), bundle, h.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) packet);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) toServiceMsg);
            return;
        }
        super.sendToMSF(intent, toServiceMsg);
        if (QLog.isDevelopLevel()) {
            QLog.d("WtloginServlet", 4, "[ToServiceMsg] serviceCmd:" + toServiceMsg.getServiceCmd() + " msfCommand:" + toServiceMsg.getMsfCommand() + " uin:" + toServiceMsg.getUin() + " appSeq:" + toServiceMsg.getAppSeq() + " ssoSeq:" + toServiceMsg.getRequestSsoSeq() + " attributes:" + toServiceMsg.getAttributes());
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.service(intent);
        int intExtra = intent.getIntExtra("action", 0);
        String msfServiceName = MsfServiceSdk.get().getMsfServiceName();
        if (intExtra == 2125) {
            sendToMSF(intent, MsfMsgUtil.get_wt_setRegDevLockFlag(msfServiceName, intent.getIntExtra("flag", 0), 30000L));
            return;
        }
        if (intExtra == 2129) {
            sendToMSF(intent, MsfMsgUtil.get_wt_SetDevlockMobileType(msfServiceName, intent.getIntExtra("mobile_type", 0), 30000L));
            return;
        }
        if (intExtra == 2208) {
            sendToMSF(intent, MsfMsgUtil.get_wt_GetOpenKeyWithoutPasswd(msfServiceName, intent.getStringExtra("uin"), intent.getLongExtra("dwSrcAppid", 0L), intent.getLongExtra("dwDstAppid", 0L), 30000L));
            return;
        }
        if (intExtra != 2213) {
            switch (intExtra) {
                case 2100:
                    sendToMSF(intent, MsfMsgUtil.get_wt_GetStWithPasswd(msfServiceName, intent.getStringExtra("uin"), intent.getLongExtra("appid", 0L), intent.getStringExtra("passwd"), 30000L));
                    return;
                case 2101:
                    ToServiceMsg uIDWithoutPasswd = MsfMsgUtil.getUIDWithoutPasswd(msfServiceName, intent.getStringExtra("uin"), intent.getLongExtra("dwSrcAppid", 0L), intent.getLongExtra("dwDstAppid", 0L), 30000L);
                    uIDWithoutPasswd.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
                    sendToMSF(intent, uIDWithoutPasswd);
                    return;
                case 2102:
                    sendToMSF(intent, MsfMsgUtil.get_wt_CheckPictureAndGetSt(msfServiceName, intent.getStringExtra("uin"), intent.getByteArrayExtra("userInput"), 30000L));
                    return;
                case 2103:
                    sendToMSF(intent, MsfMsgUtil.get_wt_RefreshPictureData(msfServiceName, intent.getStringExtra("uin"), 30000L));
                    return;
                case 2104:
                    ToServiceMsg toServiceMsg = MsfMsgUtil.get_wt_VerifyCode(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("appid", 0L), intent.getBooleanExtra("close", false), intent.getByteArrayExtra("code"), intent.getIntArrayExtra("tlv"), intent.getIntExtra("version", 0), 30000L);
                    a(intent, toServiceMsg);
                    sendToMSF(intent, toServiceMsg);
                    return;
                case 2105:
                    ToServiceMsg toServiceMsg2 = MsfMsgUtil.get_wt_CloseCode(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("appid", 0L), intent.getByteArrayExtra("code"), intent.getIntExtra("version", 0), intent.getStringArrayListExtra("data"), 30000L);
                    a(intent, toServiceMsg2);
                    sendToMSF(intent, toServiceMsg2);
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
                            switch (intExtra) {
                                case 2305:
                                    sendToMSF(intent, MsfMsgUtil.getWtRefreshMemorySigMsg(msfServiceName));
                                    return;
                                case 2306:
                                    ToServiceMsg wxLoginMsg = MsfMsgUtil.getWxLoginMsg(msfServiceName, intent.getIntExtra("appid", 16), 30000L);
                                    wxLoginMsg.addAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_542, intent.getByteArrayExtra("wxLoginData"));
                                    sendToMSF(intent, wxLoginMsg);
                                    return;
                                case 2307:
                                    ToServiceMsg toServiceMsg3 = MsfMsgUtil.get_wt_GetStViaWxLogin(msfServiceName, intent.getIntExtra("appid", 16), AppSetting.getAppId(), 30000L);
                                    toServiceMsg3.addAttribute("from_where", intent.getStringExtra("from_where"));
                                    String stringExtra = intent.getStringExtra("mainaccount");
                                    if (!TextUtils.isEmpty(stringExtra)) {
                                        toServiceMsg3.addAttribute("mainaccount", stringExtra);
                                    }
                                    toServiceMsg3.addAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_542, intent.getByteArrayExtra("wxLoginData"));
                                    sendToMSF(intent, toServiceMsg3);
                                    return;
                                default:
                                    switch (intExtra) {
                                        case WnsError.WNS_CODE_DIS_STAT_BEGIN /* 2400 */:
                                            ToServiceMsg toServiceMsg4 = MsfMsgUtil.get_wt_GetSaltUinList(msfServiceName, intent.getLongExtra("appid", 0L), intent.getIntExtra("subappid", 0), !intent.getBooleanExtra("needPuzzleVerify", true), intent.getByteArrayExtra(NotificationActivity.PASSWORD), 30000L);
                                            toServiceMsg4.addAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_542, intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_WTLOGIN_542));
                                            sendToMSF(intent, toServiceMsg4);
                                            return;
                                        case JsonGrayBusiId.AIO_GROUP_ESSENCE_MSG_TIP /* 2401 */:
                                            ToServiceMsg toServiceMsg5 = MsfMsgUtil.get_wt_GetStViaPhonePwdLogin(msfServiceName, intent.getLongExtra("appid", 0L), intent.getIntExtra("subappid", 0), 30000L);
                                            toServiceMsg5.addAttribute(MsfConstants.ATTRIBUTE_WTLOGIN_542, intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_WTLOGIN_542));
                                            toServiceMsg5.addAttribute("from_where", intent.getStringExtra("from_where"));
                                            String stringExtra2 = intent.getStringExtra("mainaccount");
                                            if (!TextUtils.isEmpty(stringExtra2)) {
                                                toServiceMsg5.addAttribute("mainaccount", stringExtra2);
                                            }
                                            sendToMSF(intent, toServiceMsg5);
                                            return;
                                        case 2402:
                                            sendToMSF(intent, MsfServiceSdk.get().checkWTSigIfExisted(getAppRuntime().getCurrentUin()));
                                            return;
                                        case JsonGrayBusiId.GROUP_AIO_UPLOAD_PERMISSIONS_GRAY_TIP_ID /* 2403 */:
                                            ToServiceMsg toServiceMsg6 = MsfMsgUtil.get_wt_GetStWithoutPasswd(msfServiceName, intent.getStringExtra("uin"), intent.getIntExtra("appid", 0), intent.getIntExtra("appid", 0), 30000L);
                                            toServiceMsg6.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
                                            String stringExtra3 = intent.getStringExtra("from_where");
                                            if (!TextUtils.isEmpty(stringExtra3)) {
                                                toServiceMsg6.addAttribute("from_where", stringExtra3);
                                            }
                                            Bundle bundleExtra = intent.getBundleExtra("extra");
                                            if (bundleExtra != null) {
                                                for (String str : bundleExtra.keySet()) {
                                                    toServiceMsg6.addAttribute(str, bundleExtra.get(str));
                                                    QLog.d("WtloginServlet", 1, "addOpenSdkExtra --> key=" + str + ", value=" + bundleExtra.get(str));
                                                }
                                            }
                                            sendToMSF(intent, toServiceMsg6);
                                            return;
                                        default:
                                            handleSMSAction(intExtra, intent, msfServiceName);
                                            return;
                                    }
                            }
                    }
            }
        }
        sendToMSF(intent, MsfMsgUtil.get_wt_CancelCode(msfServiceName, intent.getStringExtra("userAccount"), intent.getLongExtra("appid", 0L), intent.getByteArrayExtra("code"), intent.getByteArrayExtra(BaseConstants.ATTRIBUTE_KEY_PB_DATA), 30000L));
    }
}
