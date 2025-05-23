package mqq.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.qq.jce.wup.UniPacket;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.NotifyRegisterInfo;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import mqq.observer.BusinessObserver;
import mqq.observer.CheckConErroObserver;
import mqq.observer.SSOAccountObserver;
import mqq.observer.ServerConfigObserver;
import mqq.observer.SubAccountObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import protocol.KQQConfig.GetResourceRespV2;

/* compiled from: P */
/* loaded from: classes28.dex */
public class BuiltInServlet extends MSFServlet implements Constants.Action {
    public static final String KEY_TLV_543_IN_TLV_119 = "tlv543In119";
    public static final String MSF_KEY_SIG_INFO = "sigInfo";
    public static final String MSF_KEY_USER_SIG_INFO = "userSigInfo";
    private HighFreqLogUtil freqLogUtil = new HighFreqLogUtil(1);
    private boolean isRegist;

    BuiltInServlet() {
    }

    private void addOpenSdkExtra(Intent intent, ToServiceMsg toServiceMsg) {
        Bundle bundleExtra;
        if ("com.tencent.mobileqq:openSdk".equals(intent.getStringExtra("process")) && (bundleExtra = intent.getBundleExtra("extra")) != null) {
            for (String str : bundleExtra.keySet()) {
                toServiceMsg.addAttribute(str, bundleExtra.get(str));
                QLog.d("BuiltInServlet", 1, "BuiltInServlet --> key=" + str + ", value=" + bundleExtra.get(str));
            }
        }
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
        HashMap<Integer, tlv_t> hashMap;
        tlv_t tlv_tVar;
        byte[] bArr;
        if (fromServiceMsg != null && bundle != null) {
            WUserSigInfo wUserSigInfo = (WUserSigInfo) fromServiceMsg.getAttribute("userSigInfo");
            if ((wUserSigInfo == null && (wUserSigInfo = (WUserSigInfo) fromServiceMsg.getAttribute(MSF_KEY_SIG_INFO)) == null) || (hashMap = wUserSigInfo.loginResultTLVMap) == null || (tlv_tVar = hashMap.get(1347)) == null || (bArr = tlv_tVar.get_data()) == null) {
                return;
            }
            bundle.putByteArray("tlverror", bArr);
        }
    }

    private void bundlePutTlv543In119(FromServiceMsg fromServiceMsg, Bundle bundle) {
        HashMap<Integer, tlv_t> hashMap;
        tlv_t tlv_tVar;
        byte[] bArr;
        if (fromServiceMsg != null && bundle != null) {
            WUserSigInfo wUserSigInfo = (WUserSigInfo) fromServiceMsg.getAttribute("userSigInfo");
            if ((wUserSigInfo == null && (wUserSigInfo = (WUserSigInfo) fromServiceMsg.getAttribute(MSF_KEY_SIG_INFO)) == null) || (hashMap = wUserSigInfo.loginResultTLVMap) == null || (tlv_tVar = hashMap.get(Integer.valueOf(util.KEY_TLV543_IN_TLV199))) == null || (bArr = tlv_tVar.get_data()) == null) {
                return;
            }
            bundle.putByteArray(KEY_TLV_543_IN_TLV_119, bArr);
        }
    }

    private void dispatchService(int i3, Intent intent) {
        if (i3 != 1007) {
            if (i3 != 1012) {
                if (i3 != 1018) {
                    if (i3 != 1030) {
                        if (i3 != 1032) {
                            if (i3 != 2124) {
                                if (i3 != 2200) {
                                    if (i3 != 2210) {
                                        if (i3 != 2212) {
                                            if (i3 != 2214) {
                                                switch (i3) {
                                                    case 1042:
                                                        serviceForActionNetExceptionEvent(intent);
                                                        return;
                                                    case 1043:
                                                        serviceForActionSendWirelessPSWReq(intent);
                                                        return;
                                                    case 1044:
                                                        serviceForActionSendWirelessMeiBaoReq(intent);
                                                        return;
                                                    default:
                                                        switch (i3) {
                                                            case Constants.Action.ACTION_START_PCACTIVE_POLLING /* 2126 */:
                                                                serviceForActionStartPCActivePolling(intent);
                                                                return;
                                                            case Constants.Action.ACTION_STOP_PCACTIVE_POLLING /* 2127 */:
                                                                serviceForActionStopPCActivePolling(intent);
                                                                return;
                                                            case Constants.Action.ACTION_OPEN_PCACTIVE /* 2128 */:
                                                                serviceForActionOpenPCActive(intent);
                                                                return;
                                                            default:
                                                                switch (i3) {
                                                                    case 2202:
                                                                        serviceForActionSendMSGSignal(intent);
                                                                        return;
                                                                    case Constants.Action.ACTION_SEND_WTPKG /* 2203 */:
                                                                        serviceForActionSendWTPKG(intent);
                                                                        return;
                                                                    case Constants.Action.ACTION_SAVE_GEOG_INFO /* 2204 */:
                                                                        serviceForActionSaveGEOGInfo(intent);
                                                                        return;
                                                                    default:
                                                                        switch (i3) {
                                                                            case 2217:
                                                                                serviceForActionUpdateMSFToggle(intent);
                                                                                return;
                                                                            case 2218:
                                                                                serviceForActionSecSdk(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_ACTIVE_LOG_REPORT /* 2219 */:
                                                                                serviceForActiveLogReport(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_UPDATE_MSF_WEAK_NET_CONFIG /* 2220 */:
                                                                                serviceForActionUpdateMSFWeakNetConfig(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_UPDATE_MSF_COMMON_CONFIG /* 2221 */:
                                                                                serviceForActionUpdateMSFCommonConfig(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_NOTIFY_MSF_WEAK_NET_SWITCH /* 2222 */:
                                                                                serviceForActionNotifyMSFWeakNetSwitch(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_AFTER_FETCH_CONFIG_LOG_REPORT /* 2223 */:
                                                                                serviceForAfterFetchConfigLogReport(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_UPDATE_COMPLEX_CONNECT_CONFIG /* 2224 */:
                                                                                serviceForActionUpdateComplexConnectConfig(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_UPDATE_MSF_MMKV_CONFIG /* 2225 */:
                                                                                serviceForActionUpdateMSFMMKVConfig(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_NOTIFY_MSF_MSG_SYNC_END /* 2226 */:
                                                                                serviceForActionNotifyMSFMsgSyncEnd(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_UPDATE_BEFORE_MSG_SYNC_CONTROL_CONFIG /* 2227 */:
                                                                                serviceForActionUpdateMsfBeforeMsgSyncControlMsg(intent);
                                                                                return;
                                                                            case Constants.Action.ACTION_NOTIFY_MSF_ONLINE_REGISTER /* 2228 */:
                                                                                serviceForActionNotifyMSFOnlineRegister(intent);
                                                                                return;
                                                                            default:
                                                                                return;
                                                                        }
                                                                }
                                                        }
                                                }
                                            }
                                            serviceForActionUpdateMSFConfig(intent);
                                            return;
                                        }
                                        serviceForActionActionMSFUpdateLocaleID(intent);
                                        return;
                                    }
                                    serviceForActionManualSetLogLevel(intent);
                                    return;
                                }
                                serviceForActionAppGuard(intent);
                                return;
                            }
                            serviceForActionGetAlterTickets(intent);
                            return;
                        }
                        serviceForActionChangeToken(intent);
                        return;
                    }
                    serviceForActionGetKey(intent);
                    return;
                }
                serviceForActionGetPluginConfig(intent);
                return;
            }
            serviceForActionReport(intent);
            return;
        }
        serviceForActionDeleteAccount(intent);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0024. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0027. Please report as an issue. */
    private boolean dispatchServiceForLogin(int i3, Intent intent) {
        if (i3 != 1001) {
            if (i3 != 1002) {
                if (i3 != 1025) {
                    if (i3 != 1026) {
                        if (i3 != 1035) {
                            if (i3 != 1037) {
                                if (i3 != 1040) {
                                    if (i3 != 2123) {
                                        if (i3 != 2201) {
                                            switch (i3) {
                                                case 1100:
                                                    serviceForActionSSOLoginAccount(intent);
                                                    break;
                                                case 1101:
                                                    serviceForActionGetTicketNoPasswd(intent);
                                                    break;
                                                case 1102:
                                                    serviceForActionSSOGetA1WithA1(intent);
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case Constants.Action.ACTION_VERIFY_PASSWD /* 2205 */:
                                                            serviceForActionVeriftyPasswd(intent);
                                                            break;
                                                        case Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE /* 2206 */:
                                                            serviceForActionVerifyPasswdSubmitImageCode(intent);
                                                            break;
                                                        case Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE /* 2207 */:
                                                            serviceForActionVerifyPassWDRefreshImageCode(intent);
                                                            break;
                                                        default:
                                                            return false;
                                                    }
                                            }
                                        } else {
                                            serviceForActionTransFileCheckMSFConerro(intent);
                                        }
                                    } else {
                                        serviceForActionNotifyRefreshWebviewTicket(intent);
                                    }
                                } else {
                                    serviceForActionRegistCommandPush(intent);
                                }
                            } else {
                                serviceForActionSubAccountGetKey(intent);
                            }
                        } else {
                            serviceForActionSubAccountLogin(intent);
                        }
                    } else {
                        serviceForActionUnregistMessagePushProxy(intent);
                    }
                } else {
                    serviceForActionRegistMessagePushProxy(intent);
                }
            } else {
                serviceForActionRegistMessagePush(intent);
            }
        } else {
            serviceForActionLogin(intent);
        }
        return true;
    }

    static boolean isQQUin(String str) {
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

    private void notifyLoginStart(Intent intent, ToServiceMsg toServiceMsg, Class<? extends BusinessObserver> cls) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("toServiceMsg", toServiceMsg);
        notifyObserver(intent, Constants.Action.ACTION_LOGIN_START_NOTIFY, true, bundle, cls);
    }

    private void onReceiveForActionChangeToken(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("map", fromServiceMsg.attributes);
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, AccountObserver.class);
    }

    private void onReceiveForActionGetAlterTickets(FromServiceMsg fromServiceMsg) {
        new Bundle();
        String uin = fromServiceMsg.getUin();
        HashMap<String, String> hashMap = (HashMap) fromServiceMsg.getAttributes().get("keyMap");
        if (!TextUtils.isEmpty(uin) && getAppRuntime() != null && uin.equals(getAppRuntime().getAccount())) {
            ((TicketManager) getAppRuntime().getManager(2)).setAlterTicket(hashMap);
        }
    }

    private void onReceiveForActionGetKey(Intent intent, FromServiceMsg fromServiceMsg, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("key", (String) fromServiceMsg.getAttribute(fromServiceMsg.getServiceCmd()));
        notifyObserver(intent, i3, fromServiceMsg.isSuccess(), bundle, AccountObserver.class);
    }

    private void onReceiveForActionGetPluginConfig(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        if (fromServiceMsg.isSuccess()) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            bundle.putSerializable("jce", (GetResourceRespV2) uniPacket.getByClass("GetResourceRespV2", new GetResourceRespV2()));
        }
        bundle.putInt("iPluginType", intent.getIntExtra("iPluginType", 64));
        notifyObserver(intent, 1018, fromServiceMsg.isSuccess(), bundle, ServerConfigObserver.class);
    }

    private void onReceiveForActionGetTicketNoPasswd(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        if (QLog.isColorLevel()) {
            QLog.d("onReceive", 2, "builtInServlet action_sso_login_no_passwd...");
        }
        bundle.putString("ssoAccount", (String) fromServiceMsg.getAttribute("userAccount"));
        if (fromServiceMsg.isSuccess()) {
            bundle.putByteArray("wtTicket", (byte[]) fromServiceMsg.getAttribute("wtTicket"));
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.getAttribute("userSigInfo"));
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (Parcelable) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR));
            bundle.putInt("targetTicket", intent.getIntExtra("targetTicket", 4096));
            bundle.putByteArray("st_temp", (byte[]) fromServiceMsg.getAttribute("st_temp"));
            bundle.putByteArray("st_temp_key", (byte[]) fromServiceMsg.getAttribute("st_temp_key"));
        }
        bundle.putInt("code", fromServiceMsg.getResultCode());
        bundle.putParcelable("errMsg", (Parcelable) fromServiceMsg.getAttribute("errMsg"));
        Object attribute = fromServiceMsg.getAttribute("ret");
        if (attribute instanceof Integer) {
            bundle.putInt("ret", ((Integer) attribute).intValue());
        } else {
            bundle.putInt("ret", -1);
        }
        bundle.putString("error", fromServiceMsg.getBusinessFailMsg());
        notifyObserver(intent, 1101, fromServiceMsg.isSuccess(), bundle, SSOAccountObserver.class);
    }

    private void onReceiveForActionLogin(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        int i3;
        byte[] bArr;
        Bundle bundle = new Bundle();
        QLog.i("BuiltInServlet", 1, "login in back from msf build servlets start");
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        bundle.putString("uin", fromServiceMsg.getUin());
        bundle.putString(NotificationActivity.KEY_ALIAS, intent.getStringExtra("account"));
        bundle.putString("error", fromServiceMsg.getBusinessFailMsg());
        Object attribute = fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_RESP_LOGIN_URL);
        if (attribute instanceof String) {
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
        try {
            ErrMsg errMsg = (ErrMsg) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
            if (errMsg != null) {
                bundle.putInt("errorver", errMsg.getVersion());
                bundle.putString("title", errMsg.getTitle());
            }
        } catch (Exception e16) {
            QLog.e("mqq", 1, "getAttribute error:" + e16.getMessage());
        }
        bundle.putString("errorurl", str);
        bundle.putInt("loginret", i3);
        bundle.putInt("code", fromServiceMsg.getResultCode());
        bundle.putByteArray("lhsig", bArr);
        if (fromServiceMsg.isSuccess()) {
            MsfSdkUtils.addLoginSimpleAccount(fromServiceMsg.getUin(), true);
            String stringExtra = intent.getStringExtra("account");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (intent.getByteArrayExtra(MsfConstants.ATTRIBUTE_LOGIN_UIN_ENCRYPT) != null) {
                    getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName + fromServiceMsg.getUin(), fromServiceMsg.getUin());
                } else {
                    getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName + fromServiceMsg.getUin(), stringExtra);
                }
            }
            try {
                bundlePutTlv543In119(fromServiceMsg, bundle);
            } catch (Exception e17) {
                QLog.e("ACTION_LOGIN", 1, "getAttribute userSignInfo error:" + e17.getMessage());
            }
        } else {
            MsfSdkUtils.updateSimpleAccountNotCreate(fromServiceMsg.getUin(), false);
            try {
                bundlePutTlv543(fromServiceMsg, bundle);
            } catch (Exception e18) {
                QLog.e("ACTION_LOGIN", 1, "getAttribute userSignInfo error:" + e18.getMessage());
            }
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        notifyObserver(intent, 1001, fromServiceMsg.isSuccess(), bundle, AccountObserver.class);
        if (QLog.isColorLevel()) {
            QLog.d("BuiltInServlet", 2, "login in back from msf build servlets end");
        }
    }

    private void onReceiveForActionRegistCommandPush(Intent intent, FromServiceMsg fromServiceMsg) {
        notifyObserver(intent, 1040, fromServiceMsg.isSuccess(), new Bundle(), AccountObserver.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onReceiveForActionRegistMessagePush(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        AppRuntime.Status status;
        long j3;
        boolean z16;
        boolean z17;
        int i3;
        long j16;
        AppRuntime.Status status2;
        byte b16;
        boolean z18;
        AppRuntime.Status status3;
        boolean z19;
        int i16;
        boolean z26;
        boolean z27;
        long j17;
        boolean z28;
        int i17;
        boolean z29;
        Bundle bundle = new Bundle();
        if (BaseConstants.CMD_REGISTER_PUSH.equals(fromServiceMsg.getServiceCmd()) || BaseConstants.CMD_UNREGISTER_PUSH.equals(fromServiceMsg.getServiceCmd())) {
            boolean z36 = true;
            long j18 = 0;
            if (!fromServiceMsg.isSuccess()) {
                str = "mqq";
                status = (AppRuntime.Status) intent.getSerializableExtra(QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD);
                QLog.d(str, 1, "register.push fail!");
                j3 = 0;
                z16 = false;
                z17 = false;
                z36 = false;
            } else {
                if (!BaseConstants.CMD_REGISTER_PUSH.equals(fromServiceMsg.getServiceCmd())) {
                    str = "mqq";
                    status = AppRuntime.Status.offline;
                } else if (fromServiceMsg.getWupBuffer() == null || fromServiceMsg.getWupBuffer().length <= 0) {
                    str = "mqq";
                    status = (AppRuntime.Status) intent.getSerializableExtra("onlineStatus");
                    QLog.d(str, 1, "register.push return empty packet! status: " + status);
                    z36 = true;
                } else {
                    SvcRespRegister svcRespRegister = (SvcRespRegister) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
                    if (svcRespRegister == null || svcRespRegister.cReplyCode != 0) {
                        str = "mqq";
                        AppRuntime.Status status4 = (AppRuntime.Status) intent.getSerializableExtra(QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD);
                        if (svcRespRegister != null) {
                            b16 = svcRespRegister.cReplyCode;
                        } else {
                            b16 = -1;
                        }
                        Object[] objArr = new Object[2];
                        if (svcRespRegister == null) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        objArr[0] = Boolean.valueOf(z18);
                        objArr[1] = Integer.valueOf(b16);
                        QLog.d(str, 1, String.format("register.push resp is null [%s], cReplyCode: [%s]", objArr));
                        status3 = status4;
                        z19 = false;
                        i16 = 0;
                        z26 = false;
                        z27 = false;
                        j17 = -1;
                    } else {
                        if (svcRespRegister.bUpdateFlag == 1) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        if (svcRespRegister.bLargeSeqUpdate == 1) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        int i18 = svcRespRegister.iStatus;
                        j18 = svcRespRegister.timeStamp;
                        status3 = AppRuntime.Status.build(i18);
                        long j19 = svcRespRegister.uExtOnlineStatus;
                        if (status3 == null) {
                            str = "mqq";
                            QLog.d(str, 1, String.format("invalid iStatus: %s", Integer.valueOf(i18)));
                            if (fromServiceMsg.attributes.containsKey("attr_online_status")) {
                                i18 = ((Integer) fromServiceMsg.getAttribute("attr_online_status")).intValue();
                                status3 = AppRuntime.Status.build(i18);
                                i17 = 1;
                                QLog.d(str, 1, String.format("update iStatus: %s", Integer.valueOf(i18)));
                                z29 = z27;
                            } else {
                                i17 = 1;
                                z29 = z27;
                                QLog.d(str, 1, String.format("don't containsKey attr_online_status", new Object[0]));
                            }
                            if (status3 == null) {
                                status3 = (AppRuntime.Status) intent.getSerializableExtra(QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD);
                                QLog.e(str, i17, "register.push onlineStatus == null");
                            }
                            z19 = z28;
                            i16 = i18;
                            z27 = z29;
                        } else {
                            str = "mqq";
                            z19 = z28;
                            i16 = i18;
                        }
                        z26 = true;
                        j17 = j19;
                    }
                    z17 = z19;
                    z36 = z26;
                    z16 = z27;
                    long j26 = j17;
                    i3 = i16;
                    j3 = j18;
                    status2 = status3;
                    j16 = j26;
                    String str2 = str;
                    boolean booleanExtra = intent.getBooleanExtra("isUserSet", false);
                    bundle.putSerializable("onlineStatus", status2);
                    bundle.putLong("extOnlineStatus", j16);
                    bundle.putBoolean("isChanged", z16);
                    bundle.putLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, j3);
                    bundle.putBoolean("isLargeChanged", z17);
                    bundle.putBoolean("isUserSet", booleanExtra);
                    long j27 = j3;
                    notifyObserver(intent, 1002, z36, bundle, AccountObserver.class);
                    if (!QLog.isColorLevel()) {
                        this.freqLogUtil.d(str2, 2, String.format("register.push, isSuc = %s, onlineStatus = %s, isUserSet = %s, isChanged = %s, timeStamp = %s, isLargeChanged = %s, iStatus = %s, extStatus = %s", Boolean.valueOf(z36), status2, Boolean.valueOf(booleanExtra), Boolean.valueOf(z16), Long.valueOf(j27), Boolean.valueOf(z17), Integer.valueOf(i3), Long.valueOf(j16)));
                        return;
                    }
                    return;
                }
                j3 = 0;
                z16 = false;
                z17 = false;
            }
            i3 = 0;
            j16 = -1;
            status2 = status;
            String str22 = str;
            boolean booleanExtra2 = intent.getBooleanExtra("isUserSet", false);
            bundle.putSerializable("onlineStatus", status2);
            bundle.putLong("extOnlineStatus", j16);
            bundle.putBoolean("isChanged", z16);
            bundle.putLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, j3);
            bundle.putBoolean("isLargeChanged", z17);
            bundle.putBoolean("isUserSet", booleanExtra2);
            long j272 = j3;
            notifyObserver(intent, 1002, z36, bundle, AccountObserver.class);
            if (!QLog.isColorLevel()) {
            }
        }
    }

    private void onReceiveForActionSSOGetA1WithA1(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        bundle.putString("ssoAccount", (String) fromServiceMsg.getAttribute("userAccount"));
        if (fromServiceMsg.isSuccess()) {
            Object attribute = fromServiceMsg.getAttribute("dwSrcAppid");
            if (attribute instanceof Long) {
                bundle.putLong("dwSrcAppid", ((Long) attribute).longValue());
            }
            Object attribute2 = fromServiceMsg.getAttribute("dwMainSigMap");
            if (attribute2 instanceof Integer) {
                bundle.putInt("dwMainSigMap", ((Integer) attribute2).intValue());
            }
            Object attribute3 = fromServiceMsg.getAttribute("dwSubSrcAppid");
            if (attribute3 instanceof Long) {
                bundle.putLong("dwSubSrcAppid", ((Long) attribute3).longValue());
            }
            bundle.putByteArray("dstAppName", (byte[]) fromServiceMsg.getAttribute("dstAppName"));
            Object attribute4 = fromServiceMsg.getAttribute("dwDstSsoVer");
            if (attribute4 instanceof Long) {
                bundle.putLong("dwDstSsoVer", ((Long) attribute4).longValue());
            }
            Object attribute5 = fromServiceMsg.getAttribute("dwDstAppid");
            if (attribute5 instanceof Long) {
                bundle.putLong("dwDstAppid", ((Long) attribute5).longValue());
            }
            Object attribute6 = fromServiceMsg.getAttribute("dwSubDstAppid");
            if (attribute6 instanceof Long) {
                bundle.putLong("dwSubDstAppid", ((Long) attribute6).longValue());
            }
            bundle.putParcelable("userSigInfo", (Parcelable) fromServiceMsg.getAttribute("userSigInfo"));
            bundle.putParcelable("fastLoginInfo", (Parcelable) fromServiceMsg.getAttribute("fastLoginInfo"));
            bundle.putByteArray("dstAppVer", (byte[]) fromServiceMsg.getAttribute("dstAppVer"));
            bundle.putByteArray("dstAppSign", (byte[]) fromServiceMsg.getAttribute("dstAppSign"));
            bundle.putByteArray("wtTicket", (byte[]) fromServiceMsg.getAttribute("wtTicket"));
        }
        bundle.putInt("code", fromServiceMsg.getResultCode());
        bundle.putParcelable("errMsg", (Parcelable) fromServiceMsg.getAttribute("errMsg"));
        Object attribute7 = fromServiceMsg.getAttribute("ret");
        if (attribute7 instanceof Integer) {
            bundle.putInt("ret", ((Integer) attribute7).intValue());
        } else {
            bundle.putInt("ret", -1);
        }
        notifyObserver(intent, 1102, fromServiceMsg.isSuccess(), bundle, SSOAccountObserver.class);
    }

    private void onReceiveForActionSSOLoginAccount(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        if (QLog.isColorLevel()) {
            QLog.d("onReceive", 2, "builtInServlet action_sso_login_account...");
        }
        bundle.putString("ssoAccount", (String) fromServiceMsg.getAttribute("userAccount"));
        bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (Parcelable) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR));
        if (fromServiceMsg.isSuccess()) {
            bundle.putByteArray("wtTicket", (byte[]) fromServiceMsg.getAttribute("wtTicket"));
            bundle.putInt("targetTicket", intent.getIntExtra("targetTicket", 4096));
            bundle.putByteArray("st_temp", (byte[]) fromServiceMsg.getAttribute("st_temp"));
            bundle.putByteArray("st_temp_key", (byte[]) fromServiceMsg.getAttribute("st_temp_key"));
        }
        Object attribute = fromServiceMsg.getAttribute("ret");
        if (attribute instanceof Integer) {
            bundle.putInt("ret", ((Integer) attribute).intValue());
            bundlePutTlv543(fromServiceMsg, bundle);
            bundlePutErrorUrl(fromServiceMsg, bundle);
        } else {
            bundle.putInt("ret", -1);
        }
        bundle.putInt("code", fromServiceMsg.getResultCode());
        bundle.putString("error", fromServiceMsg.getBusinessFailMsg());
        notifyObserver(intent, 1100, fromServiceMsg.isSuccess(), bundle, SSOAccountObserver.class);
        if (fromServiceMsg.getResultCode() == 1013) {
            report(fromServiceMsg.getUin(), false, "ssoLoginAppTimeout", 0L, 0L, null, true);
        }
    }

    private void onReceiveForActionSendWTPKG(Intent intent, FromServiceMsg fromServiceMsg) {
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("cmd");
        long longExtra = intent.getLongExtra("wtsdkseq", -1L);
        ByteBuffer wrap = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
        wrap.order(ByteOrder.BIG_ENDIAN);
        int i3 = wrap.getInt() - 4;
        byte[] bArr = new byte[i3];
        wrap.get(bArr, 0, i3);
        if (fromServiceMsg.isSuccess()) {
            WtloginMsfListener.onAsyncReceive(stringExtra, stringExtra2, longExtra, bArr);
        } else {
            WtloginMsfListener.onAsyncReceiveFail(stringExtra, stringExtra2, longExtra, fromServiceMsg.getBusinessFailCode());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0082, code lost:
    
        r3 = r7[0].substring(3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onReceiveForActionSubAccountGetKey(Intent intent, FromServiceMsg fromServiceMsg) {
        String[] split;
        int indexOf;
        String substring;
        String[] split2;
        String str;
        Bundle bundle = new Bundle();
        String str2 = (String) fromServiceMsg.getAttribute(BaseConstants.CMD_GETKEY);
        String uin = fromServiceMsg.getUin();
        String str3 = null;
        if (str2 != null && (split = str2.split(";")) != null) {
            try {
                if (split.length > 0) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= split.length) {
                            break;
                        }
                        String str4 = split[i3];
                        if (str4 != null && str4.length() != 0) {
                            if (str4.startsWith("UIN=" + uin + ",") && (indexOf = str4.indexOf("A2=")) >= 0 && (substring = str4.substring(indexOf)) != null && substring.length() != 0 && (split2 = substring.split(",")) != null && split2.length > 0 && (str = split2[0]) != null && str.length() > 4) {
                                break;
                            }
                        }
                        i3++;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        bundle.putString("uin", uin);
        bundle.putString("error", fromServiceMsg.getBusinessFailMsg());
        bundle.putInt("code", fromServiceMsg.getResultCode());
        bundle.putString("subaccountA2", str3);
        bundle.putString("mainaccount", (String) fromServiceMsg.getAttribute("mainaccount"));
        notifyObserver(intent, 1037, fromServiceMsg.isSuccess(), bundle, SubAccountObserver.class);
    }

    private void onReceiveForActionSubAccountLogin(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        QLog.i("BuiltInServlet", 1, "sub account login in back from msf build servlets start");
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        bundle.putString("uin", fromServiceMsg.getUin());
        bundle.putString(NotificationActivity.KEY_ALIAS, intent.getStringExtra("subaccount"));
        bundle.putString("error", fromServiceMsg.getBusinessFailMsg());
        bundle.putInt("code", fromServiceMsg.getResultCode());
        if (fromServiceMsg.isSuccess()) {
            MsfSdkUtils.addLoginSimpleAccount(fromServiceMsg.getUin(), true);
            String stringExtra = intent.getStringExtra("subaccount");
            if (!TextUtils.isEmpty(stringExtra)) {
                getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + fromServiceMsg.getUin(), stringExtra);
            }
        } else {
            MsfSdkUtils.updateSimpleAccountNotCreate(fromServiceMsg.getUin(), false);
            bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, (Parcelable) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR));
            Object attribute = fromServiceMsg.getAttribute("ret");
            if (attribute instanceof Integer) {
                bundle.putInt("ret", ((Integer) attribute).intValue());
                bundlePutTlv543(fromServiceMsg, bundle);
                bundlePutErrorUrl(fromServiceMsg, bundle);
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
                        QLog.d("mqq", 2, "CNR account savetime => system time is error");
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
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "builtInservice onreceiver ACTION_SUBACCOUNT_LOGIN");
        }
        notifyObserver(intent, 1035, fromServiceMsg.isSuccess(), bundle, SubAccountObserver.class);
    }

    private void onReceiveForActionTransFileCheckMSFConerro(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        bundle.putString("msf_con_erro", (String) fromServiceMsg.getAttribute("msf_con_erro", ""));
        notifyObserver(intent, 2201, fromServiceMsg.isSuccess(), bundle, CheckConErroObserver.class);
    }

    private void onReceiveForActionVeriftyPasswdRefreshImageCode(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        String uin = fromServiceMsg.getUin();
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        String str = (String) fromServiceMsg.getAttribute("userAccount");
        byte[] bArr = (byte[]) fromServiceMsg.getAttribute("pictureData");
        int intValue = ((Integer) fromServiceMsg.getAttribute("ret")).intValue();
        ErrMsg errMsg = (ErrMsg) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
        bundle.putString("uin", uin);
        bundle.putInt(QzoneIPCModule.RESULT_CODE, businessFailCode);
        bundle.putString("errorMsg", businessFailMsg);
        bundle.putString("userAccount", str);
        bundle.putByteArray("pictureData", bArr);
        bundle.putInt("ret", intValue);
        bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, errMsg);
        notifyObserver(intent, Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE, fromServiceMsg.isSuccess(), bundle, AccountObserver.class);
    }

    private void onReceiveForActionVerifyPasswd(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        Bundle bundle = new Bundle();
        String uin = fromServiceMsg.getUin();
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        int intValue = ((Integer) fromServiceMsg.getAttribute("ret")).intValue();
        String str = null;
        if (fromServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE)) {
            bArr = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYIMAGE);
        } else {
            bArr = null;
        }
        if (fromServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG)) {
            str = (String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_VERIFYMSG);
        }
        bundle.putString("uin", uin);
        bundle.putInt(QzoneIPCModule.RESULT_CODE, businessFailCode);
        bundle.putString("errorMsg", businessFailMsg);
        bundle.putInt("ret", intValue);
        bundle.putString(UinConfigManager.KEY_ADS, str);
        bundle.putByteArray("image", bArr);
        notifyObserver(intent, Constants.Action.ACTION_VERIFY_PASSWD, fromServiceMsg.isSuccess(), bundle, AccountObserver.class);
    }

    private void onReceiveForActionVerifyPasswdSubmitImageCode(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        Bundle bundle = new Bundle();
        String uin = fromServiceMsg.getUin();
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        String str = (String) fromServiceMsg.getAttribute("userAccount");
        byte[] bArr2 = (byte[]) fromServiceMsg.getAttribute("userInput");
        int intValue = ((Integer) fromServiceMsg.getAttribute("ret")).intValue();
        ErrMsg errMsg = (ErrMsg) fromServiceMsg.getAttribute(NotificationActivity.KEY_LAST_ERROR);
        if (fromServiceMsg.getAttributes().containsKey("image_buf")) {
            bArr = (byte[]) fromServiceMsg.getAttribute("image_buf");
        } else {
            bArr = null;
        }
        bundle.putString("uin", uin);
        bundle.putInt(QzoneIPCModule.RESULT_CODE, businessFailCode);
        bundle.putString("errorMsg", businessFailMsg);
        bundle.putString("userAccount", str);
        bundle.putByteArray("userInput", bArr2);
        bundle.putInt("ret", intValue);
        bundle.putParcelable(NotificationActivity.KEY_LAST_ERROR, errMsg);
        bundle.putByteArray("image", bArr);
        notifyObserver(intent, Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE, fromServiceMsg.isSuccess(), bundle, AccountObserver.class);
    }

    private void serviceForActionActionMSFUpdateLocaleID(Intent intent) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
        toServiceMsg.getAttributes().put("localeId", Integer.valueOf(intent.getIntExtra("localeId", 0)));
        toServiceMsg.setMsfCommand(MsfCommand.msf_update_locale_id);
        toServiceMsg.setNeedCallback(false);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionAppGuard(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(MSFServlet.TAG, 2, "ACTION_UNGUARD_APP send now");
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), null, "");
        toServiceMsg.setMsfCommand(MsfCommand.gm_GuardEvent);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.addAttribute(MsfConstants.K_EVENT, Integer.valueOf(intent.getIntExtra(MsfConstants.K_EVENT, 0)));
        toServiceMsg.addAttribute(MsfConstants.K_ARG0, Long.valueOf(intent.getLongExtra(MsfConstants.K_ARG0, 0L)));
        toServiceMsg.addAttribute(MsfConstants.K_ARG1, Long.valueOf(intent.getLongExtra(MsfConstants.K_ARG1, 0L)));
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionChangeToken(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getChangeTokenAfterLoginMsg(getAppRuntime().getAccount(), 9, (HashMap) intent.getSerializableExtra("mapSt")));
    }

    private void serviceForActionDeleteAccount(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getDelLoginedAccount(getAppRuntime().getAccount(), intent.getStringExtra("uin"), intent.getStringExtra(NotificationActivity.KEY_ALIAS)));
    }

    private void serviceForActionGetAlterTickets(Intent intent) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), intent.getStringExtra("uin"), "");
        toServiceMsg.setMsfCommand(MsfCommand.getAlterTickets);
        toServiceMsg.setNeedCallback(true);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionGetKey(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getKeyMsg(getAppRuntime().getAccount()));
    }

    private void serviceForActionGetPluginConfig(Intent intent) {
        ToServiceMsg pluginConfigMsg = getAppRuntime().getService().msfSub.getPluginConfigMsg(getAppRuntime().getAccount());
        pluginConfigMsg.putWupBuffer(intent.getByteArrayExtra("buffer"));
        pluginConfigMsg.setTimeout(10000L);
        sendToMSF(intent, pluginConfigMsg);
    }

    private void serviceForActionGetTicketNoPasswd(Intent intent) {
        String stringExtra = intent.getStringExtra("process");
        String stringExtra2 = intent.getStringExtra("ssoAccount");
        String stringExtra3 = intent.getStringExtra("from_where");
        ToServiceMsg loginWithoutPasswdMsg = getAppRuntime().getService().msfSub.getLoginWithoutPasswdMsg(stringExtra2);
        loginWithoutPasswdMsg.addAttribute("targetTicket", Integer.valueOf(intent.getIntExtra("targetTicket", 4096)));
        loginWithoutPasswdMsg.addAttribute("process", stringExtra);
        if (stringExtra3 != null && stringExtra3.length() > 0) {
            loginWithoutPasswdMsg.addAttribute("from_where", stringExtra3);
            if (QLog.isColorLevel()) {
                QLog.d("builtInservert", 2, "ACTION_GET_TICKET_NO_PASSWD from_where is no null");
            }
        }
        addOpenSdkExtra(intent, loginWithoutPasswdMsg);
        loginWithoutPasswdMsg.setTimeout(40000L);
        sendToMSF(intent, loginWithoutPasswdMsg);
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
        sendToMSF(intent, changeUinAndLoginMsg);
        notifyLoginStart(intent, changeUinAndLoginMsg, AccountObserver.class);
    }

    private void serviceForActionManualSetLogLevel(Intent intent) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
        int intExtra = intent.getIntExtra("opType", 0);
        int intExtra2 = intent.getIntExtra("manualLogLevel", 2);
        toServiceMsg.getAttributes().put("opType", Integer.valueOf(intExtra));
        toServiceMsg.getAttributes().put("manualLogLevel", Integer.valueOf(intExtra2));
        toServiceMsg.setMsfCommand(MsfCommand.msf_manual_set_log_level);
        toServiceMsg.setNeedCallback(false);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionNetExceptionEvent(Intent intent) {
        int intExtra = intent.getIntExtra("value", 1);
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), BaseConstants.CMD_NETEXCEPTION);
        toServiceMsg.setMsfCommand(MsfCommand._msf_NetException);
        toServiceMsg.addAttribute(BaseConstants.NETEXCEPTION_ATTRIBUTE_EXCEPTYPE, Integer.valueOf(intExtra));
        toServiceMsg.setNeedCallback(false);
        if (QLog.isColorLevel()) {
            QLog.d(MSFServlet.TAG, 2, "ACTION_NET_EXCEPTION_EVENT send msgnow " + toServiceMsg.getServiceCmd());
        }
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionNotifyMSFMsgSyncEnd(Intent intent) {
        sendToMSF(intent, MsfServiceSdk.get().getListenInfoSyncEndMsg(getAppRuntime().getAccount()));
    }

    private void serviceForActionNotifyMSFOnlineRegister(Intent intent) {
        ToServiceMsg listenOnlineRegisterMsg = MsfServiceSdk.get().getListenOnlineRegisterMsg(getAppRuntime().getAccount());
        listenOnlineRegisterMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_SERVER_TIME, Long.valueOf(intent.getLongExtra(BaseConstants.ATTRIBUTE_KEY_SERVER_TIME, NetConnInfoCenter.getServerTime())));
        sendToMSF(intent, listenOnlineRegisterMsg);
    }

    private void serviceForActionNotifyMSFWeakNetSwitch(Intent intent) {
        ToServiceMsg notifyWeakNetSwitchMsg = MsfServiceSdk.get().getNotifyWeakNetSwitchMsg(getAppRuntime().getAccount());
        notifyWeakNetSwitchMsg.addAttribute(BaseConstants.KEY_WEAK_NET_DEBUG_FLOAT_SWITCH, Boolean.valueOf(intent.getBooleanExtra(BaseConstants.KEY_WEAK_NET_DEBUG_FLOAT_SWITCH, false)));
        sendToMSF(intent, notifyWeakNetSwitchMsg);
    }

    private void serviceForActionNotifyRefreshWebviewTicket(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getRefreshTicketsMsg(intent.getStringExtra("uin")));
    }

    private void serviceForActionOpenPCActive(Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("src");
        boolean booleanExtra = intent.getBooleanExtra("opened", false);
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), stringExtra, "");
        toServiceMsg.setMsfCommand(MsfCommand.openPCActive);
        toServiceMsg.getAttributes().put("src", stringExtra2);
        toServiceMsg.getAttributes().put("opened", Boolean.valueOf(booleanExtra));
        toServiceMsg.setNeedCallback(false);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionRegistCommandPush(Intent intent) {
        CommandCallbackerInfo commandCallbackerInfo = new CommandCallbackerInfo();
        commandCallbackerInfo.uin = getAppRuntime().getAccount();
        String[] stringArrayExtra = intent.getStringArrayExtra("pushCommands");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : stringArrayExtra) {
            arrayList.add(str);
        }
        commandCallbackerInfo.cmds = arrayList;
        sendToMSF(intent, getAppRuntime().getService().msfSub.getRegisterCmdCallMsg(commandCallbackerInfo));
    }

    private void serviceForActionRegistMessagePush(Intent intent) {
        byte b16;
        ToServiceMsg registerPushMsg;
        if (!this.isRegist) {
            serviceForActionRegistCommandPush(intent);
            this.isRegist = true;
        }
        PushRegisterInfo pushRegisterInfo = new PushRegisterInfo();
        pushRegisterInfo.bKikPC = intent.getBooleanExtra("kick", false) ? (byte) 1 : (byte) 0;
        pushRegisterInfo.bKikWeak = (byte) 0;
        AppRuntime.Status status = (AppRuntime.Status) intent.getSerializableExtra("onlineStatus");
        boolean booleanExtra = intent.getBooleanExtra("isUserSet", false);
        pushRegisterInfo.iStatus = status.getValue();
        long longExtra = intent.getLongExtra("extOnlineStatus", -1L);
        pushRegisterInfo.extStatus = longExtra;
        if (status == AppRuntime.Status.online && longExtra == 1000) {
            pushRegisterInfo.batteryCapacity = intent.getIntExtra("batteryCapacity", 0);
            pushRegisterInfo.powerConnect = intent.getIntExtra("powerConnect", -1);
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(1L);
        arrayList.add(2L);
        arrayList.add(4L);
        pushRegisterInfo.pushIds = arrayList;
        pushRegisterInfo.timeStamp = getAppRuntime().getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
        pushRegisterInfo.iLargeSeq = intent.getLongExtra("K_SEQ", 0L);
        pushRegisterInfo.uin = getAppRuntime().getAccount();
        int intExtra = intent.getIntExtra("bindUinNotifySwitch", -1);
        if (QLog.isColorLevel()) {
            QLog.d(MSFServlet.TAG, 4, "bindUinNotifySwitch=" + intExtra);
        }
        if (intExtra > 0) {
            b16 = 1;
        } else {
            b16 = 0;
        }
        pushRegisterInfo.cBindUinNotifySwitch = b16;
        AppRuntime.Status status2 = AppRuntime.Status.offline;
        if (status == status2) {
            registerPushMsg = getAppRuntime().getService().msfSub.getUnRegisterPushMsg(pushRegisterInfo);
        } else {
            registerPushMsg = getAppRuntime().getService().msfSub.getRegisterPushMsg(pushRegisterInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.CONTACTS, 2, "BuiltInServlet.ACTION_REGIST_MESSAGE_PUSH " + status + ", " + pushRegisterInfo.timeStamp + ", " + pushRegisterInfo.iLargeSeq + ", isUserSet: " + booleanExtra);
        }
        if (booleanExtra) {
            registerPushMsg.getAttributes().put("regPushReason", RegPushReason.setOnlineStatus);
        } else {
            registerPushMsg.getAttributes().put("regPushReason", RegPushReason.appRegister);
        }
        int intExtra2 = intent.getIntExtra(IOnlineStatusService.PARAMS_VENDOR_PUSH_TYPE, 1);
        registerPushMsg.getAttributes().put(IOnlineStatusService.PARAMS_VENDOR_PUSH_TYPE, Integer.valueOf(intExtra2));
        if (QLog.isColorLevel()) {
            QLog.d("Mqq", 2, "mqq-BuiltInServlet.vendor_push_type:" + intExtra2);
        }
        byte byteExtra = intent.getByteExtra(TangramHippyConstants.LOGIN_TYPE, (byte) 0);
        if (status != status2) {
            registerPushMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_TYPE, Byte.valueOf(byteExtra));
            if (QLog.isColorLevel()) {
                QLog.d(MSFServlet.TAG, 2, "loginType=" + ((int) byteExtra));
            }
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("vecRegisterExtData");
        if (byteArrayExtra != null) {
            registerPushMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_EXT_DATA, byteArrayExtra);
            if (QLog.isColorLevel()) {
                QLog.d(g.f249686o, 2, "before sendToMSF BuiltInServlet serviceForActionRegistMessagePush: " + HexUtil.bytes2HexStr(byteArrayExtra));
            }
        }
        sendToMSF(intent, registerPushMsg);
    }

    private void serviceForActionRegistMessagePushProxy(Intent intent) {
        int intExtra = intent.getIntExtra("appid", 0);
        String stringExtra = intent.getStringExtra("processName");
        String stringExtra2 = intent.getStringExtra("broadcastName");
        String[] stringArrayExtra = intent.getStringArrayExtra("commands");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : stringArrayExtra) {
            arrayList.add(str);
        }
        NotifyRegisterInfo notifyRegisterInfo = new NotifyRegisterInfo();
        notifyRegisterInfo.uin = getAppRuntime().getAccount();
        notifyRegisterInfo.notifyIds = new ArrayList<>();
        notifyRegisterInfo.notifyProperties = new HashMap();
        CommandCallbackerInfo commandCallbackerInfo = new CommandCallbackerInfo();
        commandCallbackerInfo.uin = getAppRuntime().getAccount();
        commandCallbackerInfo.cmds = arrayList;
        sendToMSF(intent, MsfServiceSdk.get().getRegisterProxyMsg(intExtra, getAppRuntime().getAccount(), stringExtra, stringExtra2, notifyRegisterInfo, commandCallbackerInfo));
    }

    private void serviceForActionReport(Intent intent) {
        sendToMSF(intent, getAppRuntime().getService().msfSub.getReportMsg(intent.getByteExtra("type", (byte) 0), intent.getStringExtra("content")));
    }

    private void serviceForActionSSOGetA1WithA1(Intent intent) {
        String stringExtra = intent.getStringExtra("ssoAccount");
        byte[] byteArrayExtra = intent.getByteArrayExtra("dstAppName");
        long longExtra = intent.getLongExtra("dwDstSsoVer", 0L);
        long longExtra2 = intent.getLongExtra("dwDstAppid", 0L);
        long longExtra3 = intent.getLongExtra("dwSubDstAppid", 0L);
        byte[] byteArrayExtra2 = intent.getByteArrayExtra("dstAppVer");
        byte[] byteArrayExtra3 = intent.getByteArrayExtra("dstAppSign");
        ToServiceMsg a1WithA1 = getAppRuntime().getService().msfSub.getA1WithA1(stringExtra);
        a1WithA1.addAttribute("dstAppName", byteArrayExtra);
        a1WithA1.addAttribute("dwDstSsoVer", Long.valueOf(longExtra));
        a1WithA1.addAttribute("dwDstAppid", Long.valueOf(longExtra2));
        a1WithA1.addAttribute("dwSubDstAppid", Long.valueOf(longExtra3));
        a1WithA1.addAttribute("dstAppVer", byteArrayExtra2);
        a1WithA1.addAttribute("dstAppSign", byteArrayExtra3);
        a1WithA1.addAttribute("fastLoginInfo", new WFastLoginInfo());
        String stringExtra2 = intent.getStringExtra("process");
        if (!TextUtils.isEmpty(stringExtra2)) {
            a1WithA1.addAttribute("process", stringExtra2);
        }
        addOpenSdkExtra(intent, a1WithA1);
        a1WithA1.setTimeout(40000L);
        sendToMSF(intent, a1WithA1);
    }

    private void serviceForActionSSOLoginAccount(Intent intent) {
        ToServiceMsg changeUinAndLoginMsg;
        String stringExtra = intent.getStringExtra("process");
        String stringExtra2 = intent.getStringExtra("ssoAccount");
        String stringExtra3 = intent.getStringExtra("ssoPassword");
        if (isQQUin(stringExtra2)) {
            changeUinAndLoginMsg = getAppRuntime().getService().msfSub.getLoginMsg(stringExtra2, MD5.toMD5Byte(stringExtra3));
        } else {
            changeUinAndLoginMsg = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg(stringExtra2, MD5.toMD5Byte(stringExtra3));
        }
        changeUinAndLoginMsg.setIsSupportRetry(true);
        changeUinAndLoginMsg.setTimeout(40000L);
        changeUinAndLoginMsg.addAttribute("from_where", BaseConstants.SSO_ACCOUNT_ACTION);
        changeUinAndLoginMsg.addAttribute("targetTicket", Integer.valueOf(intent.getIntExtra("targetTicket", 4096)));
        changeUinAndLoginMsg.addAttribute("process", stringExtra);
        addOpenSdkExtra(intent, changeUinAndLoginMsg);
        sendToMSF(intent, changeUinAndLoginMsg);
        notifyLoginStart(intent, changeUinAndLoginMsg, SSOAccountObserver.class);
    }

    private void serviceForActionSaveGEOGInfo(Intent intent) {
        String stringExtra = intent.getStringExtra("longitude");
        String stringExtra2 = intent.getStringExtra("latitude");
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
        toServiceMsg.setMsfCommand(MsfCommand.msf_save_geoginfo);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_GEOGINFO_LONGITUDE, stringExtra);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_GEOGINFO_LATITUDE, stringExtra2);
        toServiceMsg.setNeedCallback(false);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionSecSdk(Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_CMD);
        String stringExtra3 = intent.getStringExtra(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_PARAM);
        ToServiceMsg secDispatchEventMsg = MsfServiceSdk.get().getSecDispatchEventMsg(stringExtra);
        secDispatchEventMsg.setTimeout(30000L);
        secDispatchEventMsg.setNeedCallback(false);
        secDispatchEventMsg.getAttributes().put(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_CMD, stringExtra2);
        secDispatchEventMsg.getAttributes().put(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_PARAM, stringExtra3);
        sendToMSF(intent, secDispatchEventMsg);
    }

    private void serviceForActionSendMSGSignal(Intent intent) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
        toServiceMsg.setMsfCommand(MsfCommand.msf_msgsignal);
        toServiceMsg.setNeedCallback(false);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionSendWTPKG(Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("cmd");
        byte[] byteArrayExtra = intent.getByteArrayExtra("busBuf");
        int intExtra = intent.getIntExtra("timeout", 30000);
        ToServiceMsg sendWtPkgMsg = getAppRuntime().getService().msfSub.getSendWtPkgMsg(stringExtra, intent.getLongExtra("wtsdkseq", -1L), stringExtra2, byteArrayExtra, intExtra);
        sendWtPkgMsg.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
        sendToMSF(intent, sendWtPkgMsg);
    }

    private void serviceForActionSendWirelessMeiBaoReq(Intent intent) {
        int intExtra = intent.getIntExtra("cmd", 1);
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), BaseConstants.CMD_WIRELESSMEIBAOREQ);
        toServiceMsg.setMsfCommand(MsfCommand.SEND_WIRELESS_MEIBAOREQ);
        toServiceMsg.addAttribute("cmd", Integer.valueOf(intExtra));
        toServiceMsg.setNeedCallback(false);
        if (QLog.isColorLevel()) {
            QLog.d(MSFServlet.TAG, 2, "ACTION_SEND_WIRELESS_MEIBAOREQ send msgnow " + toServiceMsg.getServiceCmd());
        }
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionSendWirelessPSWReq(Intent intent) {
        if (QLog.isDevelopLevel()) {
            QLog.d(MSFServlet.TAG, 4, "WIRELESS_PSWREQ:");
        }
        int intExtra = intent.getIntExtra("cmd", 1);
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), BaseConstants.CMD_WIRELESSPSWREQ);
        toServiceMsg.setMsfCommand(MsfCommand.SEND_WIRELESS_PSWREQ);
        toServiceMsg.addAttribute("cmd", Integer.valueOf(intExtra));
        toServiceMsg.setNeedCallback(false);
        if (QLog.isColorLevel()) {
            QLog.d(MSFServlet.TAG, 2, "ACTION_SEND_WIRELESS_PSWREQ send msgnow " + toServiceMsg.getServiceCmd());
        }
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionStartPCActivePolling(Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("src");
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), stringExtra, "");
        toServiceMsg.setMsfCommand(MsfCommand.startPCActivePolling);
        toServiceMsg.getAttributes().put("src", stringExtra2);
        toServiceMsg.setNeedCallback(false);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionStopPCActivePolling(Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("src");
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), stringExtra, "");
        toServiceMsg.setMsfCommand(MsfCommand.stopPCActivePolling);
        toServiceMsg.getAttributes().put("src", stringExtra2);
        toServiceMsg.setNeedCallback(false);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionSubAccountGetKey(Intent intent) {
        String stringExtra = intent.getStringExtra("subaccountuin");
        String stringExtra2 = intent.getStringExtra("mainaccount");
        ToServiceMsg keyMsg = getAppRuntime().getService().msfSub.getKeyMsg(stringExtra);
        keyMsg.setTimeout(10000L);
        keyMsg.addAttribute("from_where", "subaccount");
        keyMsg.addAttribute("mainaccount", stringExtra2);
        sendToMSF(intent, keyMsg);
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
        changeUinAndLoginMsg.setTimeout(40000L);
        sendToMSF(intent, changeUinAndLoginMsg);
        notifyLoginStart(intent, changeUinAndLoginMsg, SubAccountObserver.class);
    }

    private void serviceForActionTransFileCheckMSFConerro(Intent intent) {
        ToServiceMsg checkMsfConErroMsg = getAppRuntime().getService().msfSub.getCheckMsfConErroMsg();
        checkMsfConErroMsg.setTimeout(10000L);
        sendToMSF(intent, checkMsfConErroMsg);
    }

    private void serviceForActionUnregistMessagePushProxy(Intent intent) {
        sendToMSF(intent, MsfServiceSdk.get().getUnRegisterProxyMsg(intent.getIntExtra("appid", 0), getAppRuntime().getAccount(), intent.getStringExtra("processName")));
    }

    private void serviceForActionUpdateComplexConnectConfig(Intent intent) {
        ToServiceMsg updateComplexConnectConfigMsg = MsfServiceSdk.get().getUpdateComplexConnectConfigMsg(getAppRuntime().getAccount());
        updateComplexConnectConfigMsg.addAttribute(BaseConstants.KEY_COMPLEX_CONNECT_CONFIG_ALL, intent.getStringExtra(BaseConstants.KEY_COMPLEX_CONNECT_CONFIG_ALL));
        sendToMSF(intent, updateComplexConnectConfigMsg);
    }

    private void serviceForActionUpdateMSFCommonConfig(Intent intent) {
        ToServiceMsg updateMsfCommonConfigMsg = MsfServiceSdk.get().getUpdateMsfCommonConfigMsg(getAppRuntime().getAccount());
        updateMsfCommonConfigMsg.addAttribute(BaseConstants.KEY_MSF_COMMON_CONFIG_STRING, intent.getStringExtra(BaseConstants.KEY_MSF_COMMON_CONFIG_STRING));
        sendToMSF(intent, updateMsfCommonConfigMsg);
    }

    private void serviceForActionUpdateMSFConfig(Intent intent) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", BaseConstants.CMD_UPDATE_MANAGER_CONFIG);
        toServiceMsg.setMsfCommand(MsfCommand.msfUpdateManagerConfig);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setNeedCallback(false);
        String stringExtra = intent.getStringExtra(BaseConstants.KEY_CONFIG_CONTENT);
        int intExtra = intent.getIntExtra(BaseConstants.KEY_CONFIG_MANAGER_ID, -1);
        toServiceMsg.getAttributes().put(BaseConstants.KEY_CONFIG_CONTENT, stringExtra);
        toServiceMsg.getAttributes().put(BaseConstants.KEY_CONFIG_MANAGER_ID, Integer.valueOf(intExtra));
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionUpdateMSFMMKVConfig(Intent intent) {
        ToServiceMsg updateMSFMMKVConfigMsg = MsfServiceSdk.get().getUpdateMSFMMKVConfigMsg(getAppRuntime().getAccount());
        updateMSFMMKVConfigMsg.addAttribute(BaseConstants.KEY_MSF_MMKV_CONFIG, intent.getStringExtra(BaseConstants.KEY_MSF_MMKV_CONFIG));
        sendToMSF(intent, updateMSFMMKVConfigMsg);
    }

    private void serviceForActionUpdateMSFToggle(Intent intent) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", BaseConstants.CMD_UPDATE_TOGGLE_CONFIG);
        toServiceMsg.setMsfCommand(MsfCommand.msfUpdateToggle);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_MSF_TOGGLE, intent.getStringExtra(BaseConstants.ATTRIBUTE_KEY_MSF_TOGGLE));
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForActionUpdateMSFWeakNetConfig(Intent intent) {
        ToServiceMsg updateMsfWeakNetConfigMsg = MsfServiceSdk.get().getUpdateMsfWeakNetConfigMsg(getAppRuntime().getAccount());
        updateMsfWeakNetConfigMsg.addAttribute(BaseConstants.KEY_MSF_WEAK_NET_CONFIG_ALL, intent.getStringExtra(BaseConstants.KEY_MSF_WEAK_NET_CONFIG_ALL));
        sendToMSF(intent, updateMsfWeakNetConfigMsg);
    }

    private void serviceForActionUpdateMsfBeforeMsgSyncControlMsg(Intent intent) {
        ToServiceMsg updateMsfBeforeMsgSyncControlMsg = MsfServiceSdk.get().getUpdateMsfBeforeMsgSyncControlMsg(getAppRuntime().getAccount());
        updateMsfBeforeMsgSyncControlMsg.addAttribute(BaseConstants.KEY_BEFORE_MSG_SYNC_CONFIG_ALL, intent.getStringExtra(BaseConstants.KEY_BEFORE_MSG_SYNC_CONFIG_ALL));
        sendToMSF(intent, updateMsfBeforeMsgSyncControlMsg);
    }

    private void serviceForActionVeriftyPasswd(Intent intent) {
        ToServiceMsg verifyPasswdMsg = getAppRuntime().getService().msfSub.getVerifyPasswdMsg(intent.getStringExtra("account"), MD5.toMD5Byte(intent.getStringExtra(NotificationActivity.PASSWORD)));
        verifyPasswdMsg.setTimeout(40000L);
        verifyPasswdMsg.setIsSupportRetry(true);
        sendToMSF(intent, verifyPasswdMsg);
    }

    private void serviceForActionVerifyPassWDRefreshImageCode(Intent intent) {
        ToServiceMsg verifyPasswdRefreshImageMsg = getAppRuntime().getService().msfSub.getVerifyPasswdRefreshImageMsg(intent.getStringExtra("account"));
        verifyPasswdRefreshImageMsg.setTimeout(40000L);
        sendToMSF(intent, verifyPasswdRefreshImageMsg);
    }

    private void serviceForActionVerifyPasswdSubmitImageCode(Intent intent) {
        ToServiceMsg verifyPasswdImageMsg = getAppRuntime().getService().msfSub.getVerifyPasswdImageMsg(intent.getStringExtra("account"), intent.getStringExtra("verifyCode"));
        verifyPasswdImageMsg.setTimeout(40000L);
        sendToMSF(intent, verifyPasswdImageMsg);
    }

    private void serviceForActiveLogReport(Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_PSKEY);
        boolean booleanExtra = intent.getBooleanExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_WITHOUTLOGIN, false);
        Long valueOf = Long.valueOf(intent.getLongExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_STARTTIME, 0L));
        Long valueOf2 = Long.valueOf(intent.getLongExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_ENDTIME, 0L));
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), stringExtra, "");
        toServiceMsg.setMsfCommand(MsfCommand.msf_active_log_report);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_WITHOUTLOGIN, Boolean.valueOf(booleanExtra));
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_PSKEY, stringExtra2);
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_STARTTIME, valueOf);
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_ENDTIME, valueOf2);
        sendToMSF(intent, toServiceMsg);
    }

    private void serviceForAfterFetchConfigLogReport(Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        boolean booleanExtra = intent.getBooleanExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_WITHOUTLOGIN, false);
        Long valueOf = Long.valueOf(intent.getLongExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_STARTTIME, 0L));
        Long valueOf2 = Long.valueOf(intent.getLongExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_ENDTIME, 0L));
        Long valueOf3 = Long.valueOf(intent.getLongExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_TASK_ID, 0L));
        String stringExtra2 = intent.getStringExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_QIMEI36);
        ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), stringExtra, "");
        toServiceMsg.setMsfCommand(MsfCommand.msf_after_fetch_config_log_report);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_WITHOUTLOGIN, Boolean.valueOf(booleanExtra));
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_STARTTIME, valueOf);
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_ENDTIME, valueOf2);
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_TASK_ID, valueOf3);
        toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_QIMEI36, stringExtra2);
        sendToMSF(intent, toServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        if (intent != null) {
            i3 = intent.getIntExtra("action", 0);
        } else {
            i3 = -1;
        }
        if (i3 != 1001) {
            if (i3 != 1002) {
                if (i3 != 1007) {
                    if (i3 != 1018) {
                        if (i3 != 1030) {
                            if (i3 != 1032) {
                                if (i3 != 1035) {
                                    if (i3 != 1037) {
                                        if (i3 != 1040) {
                                            if (i3 != 2124) {
                                                if (i3 != 2201) {
                                                    if (i3 != 2203) {
                                                        switch (i3) {
                                                            case 1100:
                                                                onReceiveForActionSSOLoginAccount(intent, fromServiceMsg);
                                                                return;
                                                            case 1101:
                                                                onReceiveForActionGetTicketNoPasswd(intent, fromServiceMsg);
                                                                return;
                                                            case 1102:
                                                                onReceiveForActionSSOGetA1WithA1(intent, fromServiceMsg);
                                                                return;
                                                            default:
                                                                switch (i3) {
                                                                    case Constants.Action.ACTION_VERIFY_PASSWD /* 2205 */:
                                                                        onReceiveForActionVerifyPasswd(intent, fromServiceMsg);
                                                                        return;
                                                                    case Constants.Action.ACTION_VERIFY_PASSWD_SUBMIT_IMAGECODE /* 2206 */:
                                                                        onReceiveForActionVerifyPasswdSubmitImageCode(intent, fromServiceMsg);
                                                                        return;
                                                                    case Constants.Action.ACTION_VERIFY_PASSWD_REFRESH_IMAGECODE /* 2207 */:
                                                                        onReceiveForActionVeriftyPasswdRefreshImageCode(intent, fromServiceMsg);
                                                                        return;
                                                                    default:
                                                                        return;
                                                                }
                                                        }
                                                    }
                                                    onReceiveForActionSendWTPKG(intent, fromServiceMsg);
                                                    return;
                                                }
                                                onReceiveForActionTransFileCheckMSFConerro(intent, fromServiceMsg);
                                                return;
                                            }
                                            onReceiveForActionGetAlterTickets(fromServiceMsg);
                                            return;
                                        }
                                        onReceiveForActionRegistCommandPush(intent, fromServiceMsg);
                                        return;
                                    }
                                    onReceiveForActionSubAccountGetKey(intent, fromServiceMsg);
                                    return;
                                }
                                onReceiveForActionSubAccountLogin(intent, fromServiceMsg);
                                return;
                            }
                            onReceiveForActionChangeToken(intent, fromServiceMsg, i3);
                            return;
                        }
                        onReceiveForActionGetKey(intent, fromServiceMsg, i3);
                        return;
                    }
                    onReceiveForActionGetPluginConfig(intent, fromServiceMsg);
                    return;
                }
                notifyObserver(intent, 1007, fromServiceMsg.isSuccess(), null, AccountObserver.class);
                return;
            }
            onReceiveForActionRegistMessagePush(intent, fromServiceMsg);
            return;
        }
        onReceiveForActionLogin(intent, fromServiceMsg);
    }

    public void report(String str, boolean z16, String str2, long j3, long j16, HashMap<String, String> hashMap, boolean z17) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        } else {
            for (String str3 : hashMap.keySet()) {
                if (hashMap.get(str3) == null) {
                    hashMap.put(str3, "");
                }
            }
        }
        RdmReq rdmReq = new RdmReq();
        rdmReq.eventName = str2;
        rdmReq.elapse = j3;
        rdmReq.size = j16;
        rdmReq.isSucceed = z16;
        rdmReq.isMerge = false;
        rdmReq.isRealTime = true;
        rdmReq.params = hashMap;
        try {
            MsfServiceSdk.get().sendMsg(MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq));
        } catch (Exception unused) {
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        super.service(intent);
        int intExtra = intent.getIntExtra("action", 0);
        if (dispatchServiceForLogin(intExtra, intent)) {
            return;
        }
        dispatchService(intExtra, intent);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
    }
}
