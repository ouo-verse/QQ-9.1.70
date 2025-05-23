package com.tencent.mobileqq.login.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.login.verify.PuzzleVerifyInfo;
import com.tencent.mobileqq.login.verify.j;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MSFServlet;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import tencent.im.login.GatewayVerify$RspBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends MSFServlet {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(FromServiceMsg fromServiceMsg, Bundle bundle) {
        tlv_t tlv_tVar;
        Object attribute = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_LHSIG);
        if (attribute instanceof byte[]) {
            bundle.putByteArray("LHSig", (byte[]) attribute);
        }
        HashMap<Integer, tlv_t> b16 = b(fromServiceMsg);
        byte[] bArr = null;
        if (b16 != null) {
            tlv_tVar = b16.get(1347);
        } else {
            tlv_tVar = null;
        }
        if (tlv_tVar != null) {
            bArr = tlv_tVar.get_data();
        }
        if (bArr == null) {
            return;
        }
        try {
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(bArr);
            long j3 = gatewayVerify$RspBody.msg_rsp_third_login.uint64_qq_uin.get();
            if (j3 > 0) {
                bundle.putString("LHUin", String.valueOf(j3));
            }
        } catch (Exception e16) {
            QLog.e("AccountLoginServlet", 1, "bundlePutLHExpiredResp", e16);
        }
    }

    private void addOpenSdkExtra(Intent intent, ToServiceMsg toServiceMsg) {
        Bundle bundleExtra = intent.getBundleExtra("extra");
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                toServiceMsg.addAttribute(str, bundleExtra.get(str));
                QLog.d("AccountLoginServlet", 1, "addOpenSdkExtra --> key=" + str + ", value=" + bundleExtra.get(str));
            }
        }
    }

    private HashMap<Integer, tlv_t> b(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return null;
        }
        WUserSigInfo wUserSigInfo = (WUserSigInfo) fromServiceMsg.getAttribute("userSigInfo");
        if (wUserSigInfo == null) {
            wUserSigInfo = (WUserSigInfo) fromServiceMsg.getAttribute(BuiltInServlet.MSF_KEY_SIG_INFO);
        }
        if (wUserSigInfo == null) {
            return null;
        }
        return wUserSigInfo.loginResultTLVMap;
    }

    private void bundlePutErrorUrl(FromServiceMsg fromServiceMsg, Bundle bundle) {
        String str;
        if (fromServiceMsg != null && bundle != null) {
            Object attribute = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_URL);
            if (attribute instanceof String) {
                str = (String) attribute;
            } else {
                str = "";
            }
            bundle.putString(OpenHippyInfo.EXTRA_KEY_ERROR_URL, str);
        }
    }

    private void bundlePutTlv543(FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<Integer, tlv_t> b16;
        tlv_t tlv_tVar;
        byte[] bArr;
        if (fromServiceMsg != null && bundle != null && (b16 = b(fromServiceMsg)) != null && (tlv_tVar = b16.get(1347)) != null && (bArr = tlv_tVar.get_data()) != null) {
            bundle.putByteArray("errorTlv", bArr);
        }
    }

    private void bundlePutTlv543In119(FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<Integer, tlv_t> b16;
        tlv_t tlv_tVar;
        byte[] bArr;
        if (fromServiceMsg != null && bundle != null && (b16 = b(fromServiceMsg)) != null && (tlv_tVar = b16.get(Integer.valueOf(util.KEY_TLV543_IN_TLV199))) != null && (bArr = tlv_tVar.get_data()) != null) {
            bundle.putByteArray(BuiltInServlet.KEY_TLV_543_IN_TLV_119, bArr);
        }
    }

    private Bundle c(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        int i3;
        boolean z16;
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        Bundle bundle = new Bundle();
        Object attribute = fromServiceMsg.getAttribute(MainService.TO_SERVICE_MSG_AFTER_SENT);
        if (attribute instanceof ToServiceMsg) {
            bundle.putParcelable("toServiceMsg", (ToServiceMsg) attribute);
        }
        bundle.putParcelable("fromServiceMsg", fromServiceMsg);
        bundle.putString("uin", fromServiceMsg.getUin());
        bundle.putString("businessFailMsg", fromServiceMsg.getBusinessFailMsg());
        if (fromServiceMsg.getBusinessFailCode() == 2002) {
            bundle.putBoolean("needPuzzleVerify", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action login, need puzzle verify");
            return bundle;
        }
        if (fromServiceMsg.getBusinessFailCode() == 2016) {
            bundle.putBoolean("needDevLockVerify", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action login, need dev lock verify");
            return bundle;
        }
        Object attribute2 = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_URL);
        if (attribute2 instanceof String) {
            str = (String) attribute2;
        } else {
            str = "";
        }
        Object attribute3 = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_RET);
        if (attribute3 instanceof Integer) {
            i3 = ((Integer) attribute3).intValue();
        } else {
            i3 = 0;
        }
        try {
            ErrMsg errMsg = (ErrMsg) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
            if (errMsg != null) {
                bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, errMsg);
            }
        } catch (Exception e16) {
            QLog.e("AccountLoginServlet", 1, "getAttribute error:" + e16.getMessage());
        }
        bundle.putString(OpenHippyInfo.EXTRA_KEY_ERROR_URL, str);
        bundle.putInt(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
        if (fromServiceMsg.isSuccess()) {
            if (z.p(fromServiceMsg.getUin())) {
                MsfSdkUtils.addLoginSimpleAccount(fromServiceMsg.getUin(), true);
            }
            boolean booleanExtra = intent.getBooleanExtra("loginByMask", false);
            if (intent.getByteArrayExtra(BaseConstants.ATTR_KET_SIF_SESSION) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!booleanExtra && !z16) {
                if (1 == intent.getIntExtra(TangramHippyConstants.LOGIN_TYPE, 1)) {
                    ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(fromServiceMsg.getUin(), (byte) 1);
                } else {
                    ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(fromServiceMsg.getUin(), (byte) 0);
                }
            } else {
                ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(fromServiceMsg.getUin(), (byte) 0);
            }
            try {
                bundlePutTlv543In119(fromServiceMsg, bundle);
            } catch (Exception e17) {
                QLog.e("AccountLoginServlet", 1, "ACTION_LOGIN getAttribute userSignInfo error:" + e17.getMessage());
            }
        } else {
            Object attribute4 = fromServiceMsg.getAttribute("ret");
            if (attribute4 instanceof Integer) {
                bundle.putInt("ret", ((Integer) attribute4).intValue());
            }
            try {
                bundlePutTlv543(fromServiceMsg, bundle);
            } catch (Exception e18) {
                QLog.e("AccountLoginServlet", 1, "ACTION_LOGINgetAttribute userSignInfo error:" + e18.getMessage());
            }
            a(fromServiceMsg, bundle);
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        if (i3 == 24) {
            bundle.putBoolean("needShowRemindDialog", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action login, need show remind dialog");
        }
        return bundle;
    }

    private Bundle d(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        Bundle bundle = new Bundle();
        Object attribute = fromServiceMsg.getAttribute(MainService.TO_SERVICE_MSG_AFTER_SENT);
        if (attribute instanceof ToServiceMsg) {
            bundle.putParcelable("toServiceMsg", (ToServiceMsg) attribute);
        }
        bundle.putParcelable("fromServiceMsg", fromServiceMsg);
        if (fromServiceMsg.getBusinessFailCode() == 2002) {
            bundle.putBoolean("needPuzzleVerify", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action sso login, need puzzle verify");
            return bundle;
        }
        if (fromServiceMsg.getBusinessFailCode() == 2016) {
            bundle.putBoolean("needDevLockVerify", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action sso login, need dev lock verify");
            return bundle;
        }
        Object attribute2 = fromServiceMsg.getAttribute("ret");
        if (attribute2 instanceof Integer) {
            i3 = ((Integer) attribute2).intValue();
        } else {
            i3 = -1;
        }
        if (!TextUtils.isEmpty(fromServiceMsg.getUin()) && !"0".equals(fromServiceMsg.getUin())) {
            bundle.putString("uin", fromServiceMsg.getUin());
        } else {
            bundle.putString("uin", (String) fromServiceMsg.getAttribute("userAccount"));
        }
        bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (Parcelable) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR));
        if (fromServiceMsg.isSuccess()) {
            bundle.putByteArray("wtTicket", (byte[]) fromServiceMsg.getAttribute("wtTicket"));
            bundle.putInt("targetTicket", intent.getIntExtra("targetTicket", 4096));
            bundle.putByteArray("st_temp", (byte[]) fromServiceMsg.getAttribute("st_temp"));
            bundle.putByteArray("st_temp_key", (byte[]) fromServiceMsg.getAttribute("st_temp_key"));
        }
        if (i3 != -1) {
            bundle.putInt("ret", i3);
            bundlePutTlv543(fromServiceMsg, bundle);
            bundlePutErrorUrl(fromServiceMsg, bundle);
        } else {
            bundle.putInt("ret", -1);
        }
        a(fromServiceMsg, bundle);
        bundle.putInt(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
        bundle.putString("businessFailMsg", fromServiceMsg.getBusinessFailMsg());
        if (i3 == 24) {
            bundle.putBoolean("needShowRemindDialog", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action login, need show remind dialog");
        }
        return bundle;
    }

    private Bundle e(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        Bundle bundle = new Bundle();
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        Object attribute = fromServiceMsg.getAttribute(MainService.TO_SERVICE_MSG_AFTER_SENT);
        if (attribute instanceof ToServiceMsg) {
            bundle.putParcelable("toServiceMsg", (ToServiceMsg) attribute);
        }
        bundle.putParcelable("fromServiceMsg", fromServiceMsg);
        bundle.putString("uin", fromServiceMsg.getUin());
        bundle.putString("businessFailMsg", fromServiceMsg.getBusinessFailMsg());
        bundle.putInt(QzoneIPCModule.RESULT_CODE, fromServiceMsg.getResultCode());
        try {
            ErrMsg errMsg = (ErrMsg) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
            if (errMsg != null) {
                bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, errMsg);
            }
        } catch (Exception e16) {
            QLog.e("AccountLoginServlet", 1, "getAttribute error:" + e16.getMessage());
        }
        if (fromServiceMsg.getBusinessFailCode() == 2002) {
            bundle.putBoolean("needPuzzleVerify", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action sub login, need puzzle verify");
            return bundle;
        }
        if (fromServiceMsg.getBusinessFailCode() == 2016) {
            bundle.putBoolean("needDevLockVerify", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action sub login, need dev lock verify");
            return bundle;
        }
        Object attribute2 = fromServiceMsg.getAttribute("ret");
        if (attribute2 instanceof Integer) {
            i3 = ((Integer) attribute2).intValue();
        } else {
            i3 = -1;
        }
        if (fromServiceMsg.isSuccess()) {
            if (z.p(fromServiceMsg.getUin())) {
                MsfSdkUtils.addLoginSimpleAccount(fromServiceMsg.getUin(), true);
            }
            if (2 == intent.getIntExtra(TangramHippyConstants.LOGIN_TYPE, 2)) {
                ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(fromServiceMsg.getUin(), (byte) 1);
            } else {
                ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setLoginType(fromServiceMsg.getUin(), (byte) 0);
            }
        } else {
            if (i3 != -1) {
                bundle.putInt("ret", i3);
                bundlePutTlv543(fromServiceMsg, bundle);
                bundlePutErrorUrl(fromServiceMsg, bundle);
            }
            a(fromServiceMsg, bundle);
        }
        SimpleAccount firstSimpleAccount = getAppRuntime().getApplication().getFirstSimpleAccount();
        long currentTimeMillis = System.currentTimeMillis();
        if (firstSimpleAccount != null) {
            try {
                long string2Long = MobileQQ.string2Long(getAppRuntime().getApplication().getProperty(firstSimpleAccount.getUin() + Constants.Key._logintime));
                if (currentTimeMillis <= string2Long) {
                    currentTimeMillis = string2Long + 1;
                    if (QLog.isColorLevel()) {
                        QLog.d("AccountLoginServlet", 2, "CNR account savetime => system time is error");
                    }
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        if (fromServiceMsg.getUin() != null) {
            QLog.i("AccountLoginServlet", 1, "setProperty _logintime uin:" + StringUtil.getSimpleUinForPrint(fromServiceMsg.getUin()) + " time:" + currentTimeMillis);
            MobileQQ application = getAppRuntime().getApplication();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fromServiceMsg.getUin());
            sb5.append(Constants.Key._logintime);
            application.setProperty(sb5.toString(), String.valueOf(currentTimeMillis));
        }
        String str = (String) fromServiceMsg.getAttribute("mainaccount");
        if (str != null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("setProperty _logintime uin:");
            sb6.append(StringUtil.getSimpleUinForPrint(str));
            sb6.append(" time:");
            long j3 = currentTimeMillis + 1;
            sb6.append(j3);
            QLog.i("AccountLoginServlet", 1, sb6.toString());
            getAppRuntime().getApplication().setProperty(str + Constants.Key._logintime, String.valueOf(j3));
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        if (i3 == 24) {
            bundle.putBoolean("needShowRemindDialog", true);
            QLog.i("AccountLoginServlet", 1, "onReceive action login, need show remind dialog");
        }
        return bundle;
    }

    private void f(int i3, Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        int intValue = ((Integer) fromServiceMsg.getAttribute("ret", 1001)).intValue();
        bundle.putInt("ret", intValue);
        Object attribute = fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
        if (attribute instanceof ErrMsg) {
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) attribute);
        }
        Object attribute2 = fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
        if (attribute2 instanceof DevlockInfo) {
            bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) attribute2);
        }
        Object attribute3 = fromServiceMsg.getAttribute("smsExtraData");
        if (attribute3 != null) {
            bundle.putByteArray("smsExtraData", (byte[]) attribute3);
        }
        QLog.i("AccountLoginServlet", 1, "onReceive action requestDevLockVerify ret=" + intValue);
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(int i3, Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle c16;
        Bundle bundle;
        Object attribute;
        Object attribute2;
        Bundle bundleExtra;
        int intExtra = intent.getIntExtra(TangramHippyConstants.LOGIN_TYPE, 1);
        if (intExtra != 1) {
            if (intExtra != 2) {
                if (intExtra != 3) {
                    if (intExtra != 6) {
                        if (intExtra != 7) {
                            c16 = new Bundle();
                        } else {
                            String stringExtra = intent.getStringExtra("from_where");
                            if (TextUtils.isEmpty(stringExtra) && (bundleExtra = intent.getBundleExtra("passThroughParams")) != null) {
                                stringExtra = bundleExtra.getString("from_where");
                            }
                            boolean equals = BaseConstants.SSO_ACCOUNT_ACTION.equals(stringExtra);
                            boolean equals2 = "subaccount".equals(stringExtra);
                            if (equals) {
                                c16 = d(intent, fromServiceMsg);
                            } else if (equals2) {
                                c16 = e(intent, fromServiceMsg);
                            } else {
                                c16 = c(intent, fromServiceMsg);
                            }
                        }
                    }
                } else {
                    c16 = d(intent, fromServiceMsg);
                }
            } else {
                c16 = e(intent, fromServiceMsg);
            }
            bundle = c16;
            int intValue = ((Integer) fromServiceMsg.getAttribute("ret", 1001)).intValue();
            attribute = fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
            attribute2 = fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
            if (!bundle.containsKey("ret")) {
                bundle.putInt("ret", intValue);
            }
            if (!bundle.containsKey(NotificationActivity.KEY_LAST_ERROR) && (attribute instanceof ErrMsg)) {
                bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) attribute);
            }
            if (!bundle.containsKey(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO) && (attribute2 instanceof DevlockInfo)) {
                bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) attribute2);
            }
            QLog.i("AccountLoginServlet", 1, "onReceive action devLockVerifyLogin ret=" + intValue);
            notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
        }
        c16 = c(intent, fromServiceMsg);
        bundle = c16;
        int intValue2 = ((Integer) fromServiceMsg.getAttribute("ret", 1001)).intValue();
        attribute = fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
        attribute2 = fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO);
        if (!bundle.containsKey("ret")) {
        }
        if (!bundle.containsKey(NotificationActivity.KEY_LAST_ERROR)) {
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (ErrMsg) attribute);
        }
        if (!bundle.containsKey(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO)) {
            bundle.putParcelable(MsfConstants.ATTRIBUTE_RESP_DEVLOCKINFO, (DevlockInfo) attribute2);
        }
        QLog.i("AccountLoginServlet", 1, "onReceive action devLockVerifyLogin ret=" + intValue2);
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    private void h(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle c16;
        int intExtra = intent.getIntExtra(TangramHippyConstants.LOGIN_TYPE, 1);
        if (intExtra != 1) {
            if (intExtra != 2) {
                if (intExtra != 3) {
                    c16 = new Bundle();
                } else {
                    c16 = d(intent, fromServiceMsg);
                }
            } else {
                c16 = e(intent, fromServiceMsg);
            }
        } else {
            c16 = c(intent, fromServiceMsg);
        }
        Bundle bundle = c16;
        int intValue = ((Integer) fromServiceMsg.getAttribute("ret", 1001)).intValue();
        if (!bundle.containsKey("ret")) {
            bundle.putInt("ret", intValue);
        }
        QLog.i("AccountLoginServlet", 1, "onReceive action submitPuzzle loginType=" + intExtra + " ret=" + intValue);
        notifyObserver(intent, 2300, fromServiceMsg.isSuccess(), bundle, d.class);
    }

    private void i(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("AccountLoginServlet", 2, "serviceForActionDevLockGatewayVerifyLogin");
        }
        String stringExtra = intent.getStringExtra("uin");
        byte[] byteArrayExtra = intent.getByteArrayExtra("gatewayData");
        Bundle bundleExtra = intent.getBundleExtra("passThroughParams");
        ToServiceMsg checkSMSAndGetStMsg = getAppRuntime().getService().msfSub.getCheckSMSAndGetStMsg(stringExtra, new byte[0]);
        if (byteArrayExtra != null) {
            checkSMSAndGetStMsg.addAttribute("smsExtraData", byteArrayExtra);
        }
        if (bundleExtra != null) {
            boolean equals = BaseConstants.SSO_ACCOUNT_ACTION.equals(bundleExtra.getString("from_where"));
            for (String str : bundleExtra.keySet()) {
                if (!equals || !AppConstants.Key.KEY_CONNECT_DATA.equals(str)) {
                    checkSMSAndGetStMsg.addAttribute(str, bundleExtra.get(str));
                }
            }
        }
        checkSMSAndGetStMsg.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
        sendToMSF(intent, checkSMSAndGetStMsg);
    }

    private boolean isQQUin(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= AppConstants.LBS_HELLO_UIN_LONGVALUE || parseLong >= 4000000000L) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void j(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("AccountLoginServlet", 2, "serviceForActionDevLockGetGatewayUrl");
        }
        String stringExtra = intent.getStringExtra("uin");
        byte[] byteArrayExtra = intent.getByteArrayExtra("gatewayData");
        Bundle bundleExtra = intent.getBundleExtra("passThroughParams");
        ToServiceMsg refreshDevLockSmsMsg = getAppRuntime().getService().msfSub.getRefreshDevLockSmsMsg(stringExtra);
        if (byteArrayExtra != null) {
            refreshDevLockSmsMsg.addAttribute("smsExtraData", byteArrayExtra);
        }
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                refreshDevLockSmsMsg.addAttribute(str, bundleExtra.get(str));
            }
        }
        refreshDevLockSmsMsg.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
        sendToMSF(intent, refreshDevLockSmsMsg);
    }

    private void k(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("AccountLoginServlet", 2, "serviceForActionDevLockGetSmsVerifyCode");
        }
        String stringExtra = intent.getStringExtra("uin");
        Bundle bundleExtra = intent.getBundleExtra("passThroughParams");
        ToServiceMsg refreshDevLockSmsMsg = getAppRuntime().getService().msfSub.getRefreshDevLockSmsMsg(stringExtra);
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                refreshDevLockSmsMsg.addAttribute(str, bundleExtra.get(str));
            }
        }
        refreshDevLockSmsMsg.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
        sendToMSF(intent, refreshDevLockSmsMsg);
    }

    private void l(Intent intent) {
        byte[] bArr;
        if (QLog.isColorLevel()) {
            QLog.i("AccountLoginServlet", 2, "serviceForActionDevLockSmsVerifyLogin");
        }
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("code");
        Bundle bundleExtra = intent.getBundleExtra("passThroughParams");
        if (stringExtra2 != null) {
            bArr = stringExtra2.getBytes();
        } else {
            bArr = null;
        }
        ToServiceMsg checkSMSAndGetStMsg = getAppRuntime().getService().msfSub.getCheckSMSAndGetStMsg(stringExtra, bArr);
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                checkSMSAndGetStMsg.addAttribute(str, bundleExtra.get(str));
            }
        }
        checkSMSAndGetStMsg.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
        sendToMSF(intent, checkSMSAndGetStMsg);
    }

    private void m(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("AccountLoginServlet", 2, "serviceForActionPuzzleVerifySubmit");
        }
        String stringExtra = intent.getStringExtra("ticket");
        PuzzleVerifyInfo puzzleVerifyInfo = (PuzzleVerifyInfo) intent.getParcelableExtra("verifyInfo");
        Bundle bundleExtra = intent.getBundleExtra("passThroughParams");
        ToServiceMsg submitPuzzleVerifyCodeTicketMsg = getAppRuntime().getService().msfSub.getSubmitPuzzleVerifyCodeTicketMsg(stringExtra, j.a(puzzleVerifyInfo));
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                submitPuzzleVerifyCodeTicketMsg.addAttribute(str, bundleExtra.get(str));
            }
        }
        submitPuzzleVerifyCodeTicketMsg.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
        sendToMSF(intent, submitPuzzleVerifyCodeTicketMsg);
    }

    private void onReceiveForActionLogin(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountLoginServlet", 2, "login in back from msf login servlets start");
        }
        notifyObserver(intent, 1001, fromServiceMsg.isSuccess(), c(intent, fromServiceMsg), a.class);
    }

    private void onReceiveForActionSSOLoginAccount(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountLoginServlet", 2, "onReceive action_sso_login_account...");
        }
        notifyObserver(intent, 1100, fromServiceMsg.isSuccess(), d(intent, fromServiceMsg), a.class);
    }

    private void onReceiveForActionSubAccountLogin(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountLoginServlet", 2, "sub account login in back from msf build servlets start");
        }
        notifyObserver(intent, 1035, fromServiceMsg.isSuccess(), e(intent, fromServiceMsg), a.class);
    }

    private void serviceForActionLogin(Intent intent) {
        ToServiceMsg changeUinAndLoginMsg;
        String stringExtra = intent.getStringExtra("account");
        byte[] byteArrayExtra = intent.getByteArrayExtra(NotificationActivity.PASSWORD);
        if (isQQUin(stringExtra)) {
            changeUinAndLoginMsg = getAppRuntime().getService().msfSub.getLoginMsg(stringExtra, byteArrayExtra);
        } else {
            changeUinAndLoginMsg = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg(stringExtra, byteArrayExtra);
        }
        byte[] byteArrayExtra2 = intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG);
        changeUinAndLoginMsg.setIsSupportRetry(true);
        changeUinAndLoginMsg.setTimeout(40000L);
        changeUinAndLoginMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_REGISTER_SUPER_SIG, byteArrayExtra2);
        byte[] byteArrayExtra3 = intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT);
        if (byteArrayExtra3 != null) {
            changeUinAndLoginMsg.addAttribute(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT, byteArrayExtra3);
        }
        byte[] byteArrayExtra4 = intent.getByteArrayExtra(BaseConstants.ATTR_KET_SIF_SESSION);
        if (byteArrayExtra4 != null) {
            changeUinAndLoginMsg.addAttribute(BaseConstants.ATTR_KET_SIF_SESSION, byteArrayExtra4);
        }
        int intExtra = intent.getIntExtra("businessType", 0);
        if (intExtra != 0) {
            changeUinAndLoginMsg.addAttribute("businessType", Integer.valueOf(intExtra));
        }
        if (intent.getBooleanExtra("forbiddenCreateRuntime", false)) {
            changeUinAndLoginMsg.addAttribute("forbiddenCreateRuntime", Boolean.TRUE);
        }
        sendToMSF(intent, changeUinAndLoginMsg);
    }

    private void serviceForActionSSOLoginAccount(Intent intent) {
        ToServiceMsg changeUinAndLoginMsg;
        String stringExtra = intent.getStringExtra("ssoAccount");
        String stringExtra2 = intent.getStringExtra("ssoPassword");
        if (isQQUin(stringExtra)) {
            changeUinAndLoginMsg = getAppRuntime().getService().msfSub.getLoginMsg(stringExtra, MD5.toMD5Byte(stringExtra2));
        } else {
            changeUinAndLoginMsg = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg(stringExtra, MD5.toMD5Byte(stringExtra2));
        }
        changeUinAndLoginMsg.setIsSupportRetry(true);
        changeUinAndLoginMsg.setTimeout(40000L);
        changeUinAndLoginMsg.addAttribute("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
        changeUinAndLoginMsg.addAttribute("targetTicket", Integer.valueOf(intent.getIntExtra("targetTicket", 4096)));
        byte[] byteArrayExtra = intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT);
        if (byteArrayExtra != null) {
            changeUinAndLoginMsg.addAttribute(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT, byteArrayExtra);
        }
        byte[] byteArrayExtra2 = intent.getByteArrayExtra(BaseConstants.ATTR_KET_SIF_SESSION);
        if (byteArrayExtra2 != null) {
            changeUinAndLoginMsg.addAttribute(BaseConstants.ATTR_KET_SIF_SESSION, byteArrayExtra2);
        }
        int intExtra = intent.getIntExtra("businessType", 0);
        if (intExtra != 0) {
            changeUinAndLoginMsg.addAttribute("businessType", Integer.valueOf(intExtra));
        }
        addOpenSdkExtra(intent, changeUinAndLoginMsg);
        sendToMSF(intent, changeUinAndLoginMsg);
    }

    private void serviceForActionSubAccountLogin(Intent intent) {
        ToServiceMsg changeUinAndLoginMsg;
        String stringExtra = intent.getStringExtra("subaccount");
        String stringExtra2 = intent.getStringExtra("subpassword");
        String stringExtra3 = intent.getStringExtra("mainaccount");
        if (isQQUin(stringExtra)) {
            changeUinAndLoginMsg = getAppRuntime().getService().msfSub.getLoginMsg(stringExtra, MD5.toMD5Byte(stringExtra2));
        } else {
            changeUinAndLoginMsg = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg(stringExtra, MD5.toMD5Byte(stringExtra2));
        }
        changeUinAndLoginMsg.setIsSupportRetry(true);
        changeUinAndLoginMsg.addAttribute("from_where", "subaccount");
        changeUinAndLoginMsg.addAttribute("mainaccount", stringExtra3);
        byte[] byteArrayExtra = intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT);
        if (byteArrayExtra != null) {
            changeUinAndLoginMsg.addAttribute(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT, byteArrayExtra);
        }
        byte[] byteArrayExtra2 = intent.getByteArrayExtra(BaseConstants.ATTR_KET_SIF_SESSION);
        if (byteArrayExtra2 != null) {
            changeUinAndLoginMsg.addAttribute(BaseConstants.ATTR_KET_SIF_SESSION, byteArrayExtra2);
        }
        int intExtra = intent.getIntExtra("businessType", 0);
        if (intExtra != 0) {
            changeUinAndLoginMsg.addAttribute("businessType", Integer.valueOf(intExtra));
        }
        changeUinAndLoginMsg.setTimeout(40000L);
        sendToMSF(intent, changeUinAndLoginMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (intent != null) {
            i3 = intent.getIntExtra("action", 0);
        } else {
            i3 = -1;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountLoginServlet", 4, "[FromServiceMsg] serviceCmd:" + fromServiceMsg.getServiceCmd() + " msfCommand:" + fromServiceMsg.getMsfCommand() + " uin:" + fromServiceMsg.getUin() + " appSeq:" + fromServiceMsg.getAppSeq() + " ssoSeq:" + fromServiceMsg.getRequestSsoSeq() + " attributes:" + fromServiceMsg.getAttributes());
        }
        if (i3 != 1001) {
            if (i3 != 1035) {
                if (i3 != 1100) {
                    switch (i3) {
                        case 2300:
                            h(intent, fromServiceMsg);
                            return;
                        case JsonGrayBusiId.AIO_ZPLAN_EMOTICON_GUIDE /* 2301 */:
                        case 2303:
                            f(i3, intent, fromServiceMsg);
                            return;
                        case JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE /* 2302 */:
                        case 2304:
                            g(i3, intent, fromServiceMsg);
                            return;
                        default:
                            return;
                    }
                }
                onReceiveForActionSSOLoginAccount(intent, fromServiceMsg);
                return;
            }
            onReceiveForActionSubAccountLogin(intent, fromServiceMsg);
            return;
        }
        onReceiveForActionLogin(intent, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) toServiceMsg);
            return;
        }
        super.sendToMSF(intent, toServiceMsg);
        if (QLog.isDevelopLevel()) {
            QLog.d("AccountLoginServlet", 4, "[ToServiceMsg] serviceCmd:" + toServiceMsg.getServiceCmd() + " msfCommand:" + toServiceMsg.getMsfCommand() + " uin:" + toServiceMsg.getUin() + " appSeq:" + toServiceMsg.getAppSeq() + " ssoSeq:" + toServiceMsg.getRequestSsoSeq() + " attributes:" + toServiceMsg.getAttributes());
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        super.service(intent);
        int intExtra = intent.getIntExtra("action", 0);
        if (intExtra != 1001) {
            if (intExtra != 1035) {
                if (intExtra != 1100) {
                    switch (intExtra) {
                        case 2300:
                            m(intent);
                            return;
                        case JsonGrayBusiId.AIO_ZPLAN_EMOTICON_GUIDE /* 2301 */:
                            j(intent);
                            return;
                        case JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE /* 2302 */:
                            i(intent);
                            return;
                        case 2303:
                            k(intent);
                            return;
                        case 2304:
                            l(intent);
                            return;
                        default:
                            return;
                    }
                }
                serviceForActionSSOLoginAccount(intent);
                return;
            }
            serviceForActionSubAccountLogin(intent);
            return;
        }
        serviceForActionLogin(intent);
    }
}
