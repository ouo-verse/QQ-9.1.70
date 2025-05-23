package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.auth.NTAccountSigInfo;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.msf.sdk.report.StatReportManager;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfServiceSdk extends j {
    static IPatchRedirector $redirector_ = null;
    private static final int SERVICE_THREAD_CORE_POOL_SIZE = 2;
    static final String ServiceName = "com.tencent.mobileqq.msf.service.MsfService";
    private static final AtomicBoolean hasRegisterExpNoticeBroadcast;
    static boolean isMainProcess = false;
    public static boolean isUseNewProxy = false;
    private static Object netImplRef = null;
    private static MsfServiceSdk sdk = null;
    private static final String tag = "MsfServiceSdk";
    private final MSFMsgPushHandlerUtil msfMsgPushHandlerUtil;
    private final BroadcastReceiver msfServiceListener;
    private IMsfProxy proxy;
    private Executor sServiceThreadPool;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f250474a;

        a(Runnable runnable) {
            this.f250474a = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfServiceSdk.this, (Object) runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f250474a.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfServiceSdk.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (BaseConstants.ACTION_MSF_NOTIFY_REGISTER_SERVICE.equals(intent.getAction()) && (stringExtra = intent.getStringExtra(com.tencent.mobileqq.msf.service.d.f250864z)) != null && stringExtra.equals(BaseApplication.processName)) {
                MsfServiceSdk.this.proxy.registerMsfService(true, true);
                boolean booleanExtra = intent.getBooleanExtra(com.tencent.mobileqq.msf.service.d.f250860v, false);
                boolean booleanExtra2 = intent.getBooleanExtra(com.tencent.mobileqq.msf.service.d.A, false);
                boolean booleanExtra3 = intent.getBooleanExtra(com.tencent.mobileqq.msf.service.d.B, false);
                String stringExtra2 = intent.getStringExtra(com.tencent.mobileqq.msf.service.d.f250863y);
                if (booleanExtra) {
                    String stringExtra3 = intent.getStringExtra(com.tencent.mobileqq.msf.service.d.C);
                    String stringExtra4 = intent.getStringExtra(com.tencent.mobileqq.msf.service.d.f250861w);
                    QLog.i(MsfServiceSdk.tag, 1, stringExtra + " onReceive ACTION_MSF_NOTIFY_REGISTER_SERVICE, exceptionMsg=" + stringExtra4 + ", isAppConnected=" + booleanExtra2 + ", halfCloseStatus=" + booleanExtra3 + ", processDie=" + intent.getBooleanExtra(com.tencent.mobileqq.msf.service.d.f250862x, false) + ", triggerCmd=" + stringExtra2);
                    StatReportManager.c.b().a(stringExtra3, "main", stringExtra4, stringExtra);
                    return;
                }
                QLog.i(MsfServiceSdk.tag, 1, stringExtra + " onReceive ACTION_MSF_NOTIFY_REGISTER_SERVICE, notifyRegisterMSF, isAppConnected=" + booleanExtra2 + ", halfCloseStatus=" + booleanExtra3 + ", triggerCmd=" + stringExtra2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            hasRegisterExpNoticeBroadcast = new AtomicBoolean(false);
        }
    }

    MsfServiceSdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sServiceThreadPool = null;
        this.msfMsgPushHandlerUtil = new MSFMsgPushHandlerUtil();
        this.msfServiceListener = new b();
    }

    private void beforeSend(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return;
        }
        toServiceMsg.setAppId(this.appid);
        toServiceMsg.setTimeout(30000L);
        MsfSdkUtils.addToMsgProcessName(this.processName, toServiceMsg);
    }

    public static MsfServiceSdk get() {
        if (sdk == null) {
            synchronized (MsfServiceSdk.class) {
                if (sdk == null) {
                    testRandomProxy();
                    MsfServiceSdk msfServiceSdk = new MsfServiceSdk();
                    msfServiceSdk.sServiceThreadPool = ProxyExecutors.newFixedThreadPool(2);
                    if (BaseApplication.getContext().getPackageName().equals(BaseApplication.processName)) {
                        isMainProcess = true;
                    }
                    IMsfProxy a16 = d.a("com.tencent.mobileqq.msf.service.MsfService", isUseNewProxy);
                    msfServiceSdk.proxy = a16;
                    a16.init(msfServiceSdk);
                    msfServiceSdk.appid = 88886666;
                    netImplRef = AppNetConnInfo.getImpl();
                    sdk = msfServiceSdk;
                }
            }
        }
        return sdk;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void testRandomProxy() {
        int i3;
        SharedPreferences sharedPreferences;
        boolean z16 = false;
        try {
            if ("armeabi".equals(com.tencent.mobileqq.msf.core.c.h(BaseApplication.getContext())) && (sharedPreferences = MsfService.getCore().getSharedPreferences("msf_sdk_proxy_factory", 4)) != null) {
                i3 = sharedPreferences.getInt("useNewProxyRandomInt", -1);
                if (i3 == -1) {
                    try {
                        i3 = new Random().nextInt(100);
                        sharedPreferences.edit().putInt("useNewProxyRandomInt", i3).commit();
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        if (i3 < 1) {
                        }
                        isUseNewProxy = z16;
                        QLog.i(tag, 1, " create isUseNewProxy=" + isUseNewProxy + " randomInt=" + i3);
                    }
                }
            } else {
                i3 = 0;
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
        if (i3 < 1) {
            z16 = true;
        }
        isUseNewProxy = z16;
        QLog.i(tag, 1, " create isUseNewProxy=" + isUseNewProxy + " randomInt=" + i3);
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ boolean addServicePushMsg(FromServiceMsg fromServiceMsg) {
        return super.addServicePushMsg(fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ boolean addServiceRespMsg(MsfMessagePair msfMessagePair) {
        return super.addServiceRespMsg(msfMessagePair);
    }

    public ToServiceMsg checkQuickRegisterAccount(String str, int i3, byte b16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 50, this, str, Integer.valueOf(i3), Byte.valueOf(b16), str2);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.quick_register_checkAccount);
        toServiceMsg.setAppId(i3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_LANGUAGE, Byte.valueOf(b16));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str2);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg checkWTSigIfExisted(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 87, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_sig_checker_when_online);
        toServiceMsg.setTimeout(30000L);
        return toServiceMsg;
    }

    public ToServiceMsg getA1WithA1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_LOGIN_AUTH);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetA1WithA1);
        toServiceMsg.getAttributes().put("dwSrcAppid", 16L);
        toServiceMsg.getAttributes().put("dwSubSrcAppid", 16L);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ String getBootBroadcastName() {
        return super.getBootBroadcastName();
    }

    public ToServiceMsg getChangeTokenAfterLoginMsg(String str, int i3, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 41, this, str, Integer.valueOf(i3), hashMap);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_CHANGETOKEN);
        toServiceMsg.setMsfCommand(MsfCommand.changeToken);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_TOKEN_CMDHEAD, Integer.valueOf(i3));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_TOKEN_MAP, hashMap);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getChangeUinAndLoginMsg(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) bArr);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_LOGIN_AUTH);
        toServiceMsg.setMsfCommand(MsfCommand.changeUinLogin);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_PWD, bArr);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_CHANGEUIN, str);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getCheckMsfConErroMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 74, (Object) this);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", BaseConstants.CMD_CHECK_MSF_CONERRO);
        toServiceMsg.setMsfCommand(MsfCommand.check_msf_conErro);
        return toServiceMsg;
    }

    public ToServiceMsg getCheckSMSAndGetStMsg(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str, (Object) bArr);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(this.msfServiceName, str, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
        toServiceMsg.getAttributes().put("userInput", bArr);
        toServiceMsg.setTimeout(30000L);
        return toServiceMsg;
    }

    public int getConnectedIPFamily() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Integer) iPatchRedirector.redirect((short) 65, (Object) this)).intValue();
        }
        return this.proxy.getMsfConnectedIPFamily();
    }

    public int getConnectedNetowrkType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this)).intValue();
        }
        return this.proxy.getMsfConnectedNetType();
    }

    public ToServiceMsg getDataFlowMsg(String str, com.tencent.mobileqq.msf.sdk.utils.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, (Object) bVar);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "socketnetflow");
        toServiceMsg.setMsfCommand(MsfCommand.reportSocket);
        toServiceMsg.extraData.putString("processName", str);
        toServiceMsg.extraData.putString("ip", bVar.f250724b);
        toServiceMsg.extraData.putString("refer", bVar.f250725c);
        toServiceMsg.extraData.putInt("port", bVar.f250726d);
        toServiceMsg.extraData.putInt("flag", bVar.f250727e);
        toServiceMsg.extraData.putLong("buffersize", bVar.f250728f);
        toServiceMsg.extraData.putInt(QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, bVar.f250729g);
        toServiceMsg.extraData.putString(HttpMsg.MTYPE, bVar.f250730h);
        toServiceMsg.extraData.putByte("status", bVar.f250731i);
        toServiceMsg.extraData.putLong("updatetime", bVar.f250733k);
        toServiceMsg.setNeedCallback(false);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getDelLoginedAccount(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 33, this, str, str2, str3);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_DELLOGINEDACCOUNT);
        toServiceMsg.setMsfCommand(MsfCommand.delLoginedAccount);
        toServiceMsg.getAttributes().put(toServiceMsg.getServiceCmd(), str2);
        toServiceMsg.getAttributes().put("delAlias", str3);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public String getDeviceToken(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        }
        return com.tencent.mobileqq.msf.core.auth.l.a(str);
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ IErrorHandler getErrorHandler() {
        return super.getErrorHandler();
    }

    public ToServiceMsg getKeyMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 73, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_GETKEY);
        toServiceMsg.setMsfCommand(MsfCommand.getKey);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getListenInfoSyncEndMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 81, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_LISTEN_MSG_SYNC_END);
        toServiceMsg.setMsfCommand(MsfCommand.msf_listen_msg_sync_end);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getListenOnlineRegisterMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 83, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_LISTEN_ONLINE_REGISTER);
        toServiceMsg.setMsfCommand(MsfCommand.msf_listen_online_register);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getLoginMsg(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) bArr);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_LOGIN_AUTH);
        toServiceMsg.setMsfCommand(MsfCommand.loginAuth);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_PWD, bArr);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getLoginWithoutPasswdMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_LOGIN_AUTH);
        toServiceMsg.setMsfCommand(MsfCommand.wt_GetStWithoutPasswd);
        toServiceMsg.getAttributes().put("dwSrcAppid", 16L);
        toServiceMsg.getAttributes().put("dwDstAppid", 16L);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getMSFCoreStateMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 62, (Object) this);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", BaseConstants.CMD_MSF_CORE_STATE);
        toServiceMsg.setMsfCommand(MsfCommand.msfCoreState);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public MSFMsgPushHandlerUtil getMSFMsgPushHandlerUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MSFMsgPushHandlerUtil) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msfMsgPushHandlerUtil;
    }

    public ToServiceMsg getMSFTestCloseConn(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 86, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(get().getMsfServiceName(), str, BaseConstants.CMD_MSF_TEST_CLOSE_CONN);
        toServiceMsg.setMsfCommand(MsfCommand.msf_test_close_conn);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public String getMsfServiceName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "com.tencent.mobileqq.msf.service.MsfService";
    }

    public ToServiceMsg getNotifyWeakNetSwitchMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 78, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_NOTIFY_WEAK_NET_SWITCH);
        toServiceMsg.setMsfCommand(MsfCommand.msf_weak_net_switch);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getPluginConfigMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 72, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, "ResourceConfig.ClientReq");
        toServiceMsg.setMsfCommand(MsfCommand.getPluginConfig);
        beforeSend(toServiceMsg);
        QLog.d("Config", 1, "getPluginConfigMsg");
        return toServiceMsg;
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ int getPreHandleQueueSize() {
        return super.getPreHandleQueueSize();
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ MsfMessagePair getPreHandleServiceRespMsg() {
        return super.getPreHandleServiceRespMsg();
    }

    public IMsfProxy getProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IMsfProxy) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.proxy;
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ int getQueueSize() {
        return super.getQueueSize();
    }

    public ToServiceMsg getQuickRegisterAccount(String str, String str2, String str3, int i3, byte b16, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 51, this, str, str2, str3, Integer.valueOf(i3), Byte.valueOf(b16), str4);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.quick_register_getAccount);
        toServiceMsg.setAppId(i3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_PASS, str2);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_NICK, str3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_LANGUAGE, Byte.valueOf(b16));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str4);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRefreVerifyCodeMsg(VerifyCodeInfo verifyCodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 38, (Object) this, (Object) verifyCodeInfo);
        }
        if (verifyCodeInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "getRefreVerifyCodeMsg info null!");
                return null;
            }
            return null;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), verifyCodeInfo.uin, BaseConstants.CMD_LOGIN_AUTH);
        toServiceMsg.setMsfCommand(MsfCommand.refreVerifyCode);
        VerifyCodeInfo.putVerifyCodeInfo(toServiceMsg, verifyCodeInfo);
        toServiceMsg.setRequestSsoSeq(verifyCodeInfo.ssoSeq);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRefreshDevLockSmsMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(this.msfServiceName, str, BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.setMsfCommand(MsfCommand.wt_RefreshSMSData);
        toServiceMsg.getAttributes().put("smsAppid", 9L);
        toServiceMsg.setTimeout(30000L);
        return toServiceMsg;
    }

    public ToServiceMsg getRefreshTicketsMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 70, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_REFRESH_TICKETS);
        toServiceMsg.setMsfCommand(MsfCommand.refreshTickets);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegQueryAccountMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, str);
        toServiceMsg.setMsfCommand(MsfCommand.regUin_queryMobile);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegQueryAccountMsgWatch(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 89, (Object) this, (Object) str, (Object) bArr);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, str);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_LICENSE, bArr);
        toServiceMsg.setMsfCommand(MsfCommand.regUin_queryMobileWatch);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterCmdCallMsg(CommandCallbackerInfo commandCallbackerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 54, (Object) this, (Object) commandCallbackerInfo);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), commandCallbackerInfo.uin, BaseConstants.CMD_REGISTER_CMDCALLBACKER);
        toServiceMsg.setMsfCommand(MsfCommand.registerCmdCallback);
        o.a(toServiceMsg, commandCallbackerInfo);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterCommitMobileMsg(String str, byte b16, byte b17, byte b18, String str2, String str3, String str4, Long l3, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 43, this, str, Byte.valueOf(b16), Byte.valueOf(b17), Byte.valueOf(b18), str2, str3, str4, l3, hashMap);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_commitMobile);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_COUNTRY, Byte.valueOf(b16));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_LANGUAGE, Byte.valueOf(b17));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_PIGTYPE, Byte.valueOf(b18));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPNAME, str2);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, str4);
        toServiceMsg.getAttributes().put("appid", l3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CAPTCHA_SIG, str);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_MAP_PARAM, hashMap);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterCommitMobileMsgWatch(byte b16, byte b17, byte b18, String str, String str2, String str3, Long l3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 90, this, Byte.valueOf(b16), Byte.valueOf(b17), Byte.valueOf(b18), str, str2, str3, l3, bArr);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_commitMobileWatch);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_COUNTRY, Byte.valueOf(b16));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_LANGUAGE, Byte.valueOf(b17));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_PIGTYPE, Byte.valueOf(b18));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPNAME, str);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str2);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, str3);
        toServiceMsg.getAttributes().put("appid", l3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_LICENSE, bArr);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    @Deprecated
    public ToServiceMsg getRegisterCommitPassMsg(String str, String str2, String str3, boolean z16, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 47, this, str, str2, str3, Boolean.valueOf(z16), str4);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_commitPass);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_SMSCODE, str);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_PASS, str2);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_NICK, str3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_TYPE, Boolean.valueOf(z16));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str4);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterCommitPassMsgWatch(String str, String str2, String str3, byte[] bArr, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 94, this, str, str2, str3, bArr, str4);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_commitPassWatch);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_SMSCODE, str);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_PASS, str2);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_NICK, str3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_LICENSE, bArr);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str4);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterCommitSmsCodeMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_commitSmsCode);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_SMSCODE, str);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterCommitSmsCodeMsgWatch(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 93, (Object) this, (Object) str, (Object) bArr);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_commitSmsCodeWatch);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_SMSCODE, str);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_LICENSE, bArr);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterProxyMsg(int i3, String str, String str2, String str3, NotifyRegisterInfo notifyRegisterInfo, CommandCallbackerInfo commandCallbackerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 56, this, Integer.valueOf(i3), str, str2, str3, notifyRegisterInfo, commandCallbackerInfo);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_PUSH_REGISTERPROXY);
        toServiceMsg.setMsfCommand(MsfCommand.proxyRegisterPush);
        n nVar = new n();
        nVar.f250620a = i3;
        nVar.f250621b = str2;
        nVar.f250622c = str3;
        nVar.f250623d = notifyRegisterInfo;
        nVar.f250624e = commandCallbackerInfo;
        o.a(toServiceMsg, nVar);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterPushMsg(PushRegisterInfo pushRegisterInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 52, (Object) this, (Object) pushRegisterInfo);
        }
        if (pushRegisterInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "getRegisterPushMsg pushRegisterInfo null!");
                return null;
            }
            return null;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), pushRegisterInfo.uin, BaseConstants.CMD_REGISTER_PUSH);
        toServiceMsg.setMsfCommand(MsfCommand.registerPush);
        o.a(toServiceMsg, pushRegisterInfo);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterQueryUpSmsStatMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_querySmsStat);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterQueryUpSmsStatMsgWatch(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 92, (Object) this, (Object) bArr);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_querySmsStatWatch);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_LICENSE, bArr);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterSendReSendSmsMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_reSendSms);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getRegisterSendReSendSmsMsgWatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 91, (Object) this);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_reSendSmsWatch);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getReportMsg(byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 71, this, Byte.valueOf(b16), str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "ConfigService.ClientReq");
        toServiceMsg.setMsfCommand(MsfCommand.reportMsg);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REPORT_TYPE, Byte.valueOf(b16));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REPORT_CONTENT, str);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getReportTrafficeMsg4Highway(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 35, (Object) this, (Object) intent);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "socketnetflow");
        toServiceMsg.setMsfCommand(MsfCommand.reportSocket);
        toServiceMsg.extraData.putString("ip", intent.getStringExtra("ip"));
        toServiceMsg.extraData.putString("processName", BaseApplication.getContext().getPackageName());
        toServiceMsg.extraData.putString("refer", null);
        toServiceMsg.extraData.putInt("port", intent.getIntExtra("port", 0));
        toServiceMsg.extraData.putString(HttpMsg.MTYPE, intent.getStringExtra(HttpMsg.MTYPE));
        toServiceMsg.extraData.putInt("flag", intent.getIntExtra("flag", 0));
        toServiceMsg.extraData.putLong("buffersize", intent.getLongExtra("buffersize", -1L));
        toServiceMsg.extraData.putInt(QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, intent.getIntExtra(QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, 1));
        toServiceMsg.extraData.putByte("status", intent.getByteExtra("status", (byte) 0));
        toServiceMsg.setNeedCallback(false);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getResetCmdCallMsg(String str, CommandCallbackerInfo commandCallbackerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 55, (Object) this, (Object) str, (Object) commandCallbackerInfo);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_RESET_CMDCALLBACKER);
        toServiceMsg.setMsfCommand(MsfCommand.resetCmdCallback);
        o.a(toServiceMsg, commandCallbackerInfo);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ LinkedBlockingQueue getRespMsgQueue() {
        return super.getRespMsgQueue();
    }

    public ToServiceMsg getResumedMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", BaseConstants.CMD_SETRESUME);
        toServiceMsg.setMsfCommand(MsfCommand._setMsfResunmed);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getSecDispatchEventMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 85, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(get().getMsfServiceName(), str, BaseConstants.CMD_SEC_DISPATCH_EVENT);
        toServiceMsg.setMsfCommand(MsfCommand.msf_sec_dispatch_event);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getSendWtPkgMsg(String str, long j3, String str2, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 75, this, str, Long.valueOf(j3), str2, bArr, Integer.valueOf(i3));
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, str2);
        toServiceMsg.setMsfCommand(MsfCommand.msf_send_wtpkg);
        beforeSend(toServiceMsg);
        toServiceMsg.setTimeout(i3);
        toServiceMsg.getAttributes().put("wtsdkseq", Long.valueOf(j3));
        int length = bArr.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putInt(length);
        allocate.put(bArr);
        toServiceMsg.putWupBuffer(allocate.array());
        return toServiceMsg;
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ MsfMessagePair getServiceRespMsg() {
        return super.getServiceRespMsg();
    }

    public ToServiceMsg getSubmitPuzzleVerifyCodeTicketMsg(String str, VerifyCodeInfo verifyCodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str, (Object) verifyCodeInfo);
        }
        if (verifyCodeInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "getSubmitPuzzleVerifyCodeSigMsg info null!");
                return null;
            }
            return null;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), verifyCodeInfo.uin, BaseConstants.CMD_LOGIN_AUTH);
        toServiceMsg.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
        VerifyCodeInfo.putVerifyCodeInfo(toServiceMsg, verifyCodeInfo);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_PUZZLE_VERIFY_CODE_TICKET, str);
        toServiceMsg.setRequestSsoSeq(verifyCodeInfo.ssoSeq);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getSubmitVerifyCodeMsg(String str, VerifyCodeInfo verifyCodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, (Object) verifyCodeInfo);
        }
        if (verifyCodeInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "getSubmitVerifyCodeMsg info null!");
                return null;
            }
            return null;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), verifyCodeInfo.uin, BaseConstants.CMD_LOGIN_AUTH);
        toServiceMsg.setMsfCommand(MsfCommand.submitVerifyCode);
        VerifyCodeInfo.putVerifyCodeInfo(toServiceMsg, verifyCodeInfo);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_VERIFY_CODE, str);
        toServiceMsg.setRequestSsoSeq(verifyCodeInfo.ssoSeq);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getSuspendMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", BaseConstants.CMD_SETSUSPEND);
        toServiceMsg.setMsfCommand(MsfCommand._setMsfSuspend);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getUnRegisterProxyMsg(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 57, this, Integer.valueOf(i3), str, str2);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_PUSH_UNREGISTERPROXY);
        toServiceMsg.setMsfCommand(MsfCommand.proxyUnRegisterPush);
        toServiceMsg.getAttributes().put(toServiceMsg.getServiceCmd(), str2);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getUnRegisterPushMsg(PushRegisterInfo pushRegisterInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 53, (Object) this, (Object) pushRegisterInfo);
        }
        if (pushRegisterInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "getUnRegisterPushMsg pushRegisterInfo null!");
                return null;
            }
            return null;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), pushRegisterInfo.uin, BaseConstants.CMD_UNREGISTER_PUSH);
        toServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
        o.a(toServiceMsg, pushRegisterInfo);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getUpdateComplexConnectConfigMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 79, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_UPDATE_COMPLEX_CONNECT_CONFIG);
        toServiceMsg.setMsfCommand(MsfCommand.msf_update_complex_connect_config);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getUpdateMSFMMKVConfigMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 84, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_UPDATE_MMKV_CONFIG);
        toServiceMsg.setMsfCommand(MsfCommand.msf_update_mmkv_config);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getUpdateMsfBeforeMsgSyncControlMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 82, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_BEFORE_MSG_SYNC_CONFIG);
        toServiceMsg.setMsfCommand(MsfCommand.msf_before_msg_sync_config);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getUpdateMsfCommonConfigMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 77, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_UPDATE_MSF_COMMON_CONFIG);
        toServiceMsg.setMsfCommand(MsfCommand.msf_update_common_config);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getUpdateMsfPushRegisterSwitch(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 80, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_PUSH_REGISTER_SWITCH);
        toServiceMsg.setMsfCommand(MsfCommand.msf_push_register_switch);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getUpdateMsfWeakNetConfigMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 76, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_UPDATE_MSF_WEAK_NET_CONFIG);
        toServiceMsg.setMsfCommand(MsfCommand.msf_update_weakNet_config);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getVerifyPasswdImageMsg(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, (Object) str2);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_VERIFY_PASSWD_IMAGE);
        toServiceMsg.setMsfCommand(MsfCommand.verifyPasswdImage);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_VERIFY_PASSWD_IMAGE, str2);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getVerifyPasswdMsg(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) bArr);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_VERIFY_PASSWD);
        toServiceMsg.setMsfCommand(MsfCommand.verifyPasswd);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_LOGIN_PWD, bArr);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getVerifyPasswdRefreshImageMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_VERIFY_PASSWD_REFRESH_IMAGE);
        toServiceMsg.setMsfCommand(MsfCommand.verifyPasswdRefreshImage);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public ToServiceMsg getWeakNetStatusMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", BaseConstants.CMD_GET_WEAK_NET);
        toServiceMsg.setMsfCommand(MsfCommand.msfGetWeakNet);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public void init(Context context, int i3, String str, String str2, IErrorHandler iErrorHandler, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, Integer.valueOf(i3), str, str2, iErrorHandler, str3);
            return;
        }
        super.initSub(str3, i3, str2, str, iErrorHandler);
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "MsfServiceSdk init proxyNew=" + isUseNewProxy + " appid=" + i3 + " msfServiceName=" + str2 + " bootBroadcastName=" + str + " processName=" + str3);
            return;
        }
        QLog.d(tag, 1, "MsfServiceSdk init proxyNew=" + isUseNewProxy + " processName=" + str3);
    }

    public void initMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 4, "initMsfService");
        }
        registerServiceListener();
        this.msfMsgPushHandlerUtil.handleMSFServiceInit();
        this.proxy.initMsfService();
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ void initSub(String str, int i3, String str2, String str3, IErrorHandler iErrorHandler) {
        super.initSub(str, i3, str2, str3, iErrorHandler);
    }

    public ToServiceMsg injectSigToMsf(NTAccountSigInfo nTAccountSigInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 88, (Object) this, (Object) nTAccountSigInfo);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", BaseConstants.CMD_APPUSEETLOGIN);
        toServiceMsg.addAttribute(com.tencent.mobileqq.msf.core.auth.g.f247459a, nTAccountSigInfo);
        toServiceMsg.setMsfCommand(MsfCommand.nt_login_inject_sig);
        toServiceMsg.setTimeout(30000L);
        return toServiceMsg;
    }

    public int onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return ((Integer) iPatchRedirector.redirect((short) 68, (Object) this)).intValue();
        }
        return this.proxy.onApplicationBackground();
    }

    public int onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return ((Integer) iPatchRedirector.redirect((short) 67, (Object) this)).intValue();
        }
        return this.proxy.onApplicationForeground();
    }

    public int onKillProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return ((Integer) iPatchRedirector.redirect((short) 69, (Object) this)).intValue();
        }
        return this.proxy.onKillProcess();
    }

    public int onProcessViewableChanged(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Integer) iPatchRedirector.redirect((short) 66, this, Boolean.valueOf(z16), Long.valueOf(j3))).intValue();
        }
        return this.proxy.onProcessViewableChanged(z16, j3, BaseApplication.processName);
    }

    public void postServiceTask(@NonNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
            return;
        }
        if (this.sServiceThreadPool == null) {
            synchronized (MsfServiceSdk.class) {
                if (this.sServiceThreadPool == null) {
                    this.sServiceThreadPool = ProxyExecutors.newFixedThreadPool(2);
                }
            }
        }
        this.sServiceThreadPool.execute(new a(runnable));
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ void preHandleQueueWait() {
        super.preHandleQueueWait();
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ void queueWait() {
        super.queueWait();
    }

    public void registerMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 4, "registerMsfService");
        }
        this.msfMsgPushHandlerUtil.handleRegisterMSFService();
        this.proxy.registerMsfService(false, false);
    }

    public void registerProxyDone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            QLog.d(tag, 1, "registerProxyDone");
            this.proxy.registerProxyDone();
        }
    }

    public void registerServiceListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.msf.service.n.a(BaseApplication.processName) && hasRegisterExpNoticeBroadcast.compareAndSet(false, true)) {
            BaseApplication.getContext().registerReceiver(this.msfServiceListener, new IntentFilter(BaseConstants.ACTION_MSF_NOTIFY_REGISTER_SERVICE));
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "register listener for IPC exception");
            }
        }
    }

    public int sendMsg(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Integer) iPatchRedirector.redirect((short) 63, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        if (toServiceMsg.getServiceName().equals(getMsfServiceName())) {
            return this.proxy.sendMsg(toServiceMsg);
        }
        return d.a(toServiceMsg);
    }

    public void sendStartUseAccountBroadcast(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context, (Object) str);
            return;
        }
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "sendStartUseAccountBroadcast context null!");
                return;
            }
            return;
        }
        Intent intent = new Intent(BaseConstants.BROADCAST_ACTION_USERSYNC);
        intent.putExtra("uin", str);
        intent.putExtra("action", BaseConstants.BROADCAST_USERSYNC_ENTER);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "send bootAction user " + str + " enter broadcast");
        }
    }

    public void sendstopUseAccountBroadcast(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) context, (Object) str);
            return;
        }
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "sendstopUseAccountBroadcast context null!");
                return;
            }
            return;
        }
        Intent intent = new Intent(BaseConstants.BROADCAST_ACTION_USERSYNC);
        intent.putExtra("uin", str);
        intent.putExtra("action", "exit");
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "send bootAction user " + str + " exit broadcast");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.j
    public /* bridge */ /* synthetic */ void setBootBroadcastName(String str) {
        super.setBootBroadcastName(str);
    }

    public void stopMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 4, "stopMsfService");
        }
        this.proxy.stopMsfService();
    }

    public List<SimpleAccount> syncGetLoginedAccountList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return MsfSdkUtils.getLoginedAccountList();
    }

    public int syncGetNetInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return AppNetConnInfo.getConnInfo();
    }

    public String syncGetServerAppConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return syncGetServerConfig("0", 2);
    }

    public String syncGetServerCommonConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return syncGetServerConfig("0", 0);
    }

    public String syncGetServerConfig(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, i3);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_GETSERVERCONFIG);
        toServiceMsg.setMsfCommand(MsfCommand.getServerConfig);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_GETSERVERCONFIG_TYPE, Integer.valueOf(i3));
        beforeSend(toServiceMsg);
        sendMsg(toServiceMsg);
        return MsfSdkUtils.getServerConfig(this.processName, i3, str);
    }

    public String syncGetServerUserConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        return syncGetServerConfig(str, 1);
    }

    public void unRegisterMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 4, "unRegisterMsfService");
        }
        this.proxy.unRegisterMsfService(Boolean.TRUE);
    }

    public void unbindMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 4, "unbindMsfService");
        }
        unregisterServiceListener();
        this.proxy.unbindMsfService();
    }

    public void unregisterServiceListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.msf.service.n.a(BaseApplication.processName) && hasRegisterExpNoticeBroadcast.compareAndSet(true, false)) {
            try {
                BaseApplication.getContext().unregisterReceiver(this.msfServiceListener);
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, "unregister listener for IPC exception");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public ToServiceMsg updateBatterStatusMsg(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 58, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), str, BaseConstants.CMD_REGISTER_PUSH);
        toServiceMsg.setMsfCommand(MsfCommand.msf_update_battery);
        toServiceMsg.getAttributes().put("battery_capacity", Integer.valueOf(i3));
        toServiceMsg.getAttributes().put("power_connect", Integer.valueOf(i16));
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }

    public void unRegisterMsfService(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bool);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 4, "unRegisterMsfService " + bool);
        }
        this.proxy.unRegisterMsfService(bool);
    }

    @Deprecated
    public ToServiceMsg getRegisterCommitPassMsg(String str, String str2, String str3, boolean z16, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) ? getRegisterCommitPassMsg(str, str2, str3, z16, str4, str5, str6, null) : (ToServiceMsg) iPatchRedirector.redirect((short) 48, this, str, str2, str3, Boolean.valueOf(z16), str4, str5, str6);
    }

    public ToServiceMsg getRegisterCommitPassMsg(String str, String str2, String str3, boolean z16, String str4, String str5, String str6, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 49, this, str, str2, str3, Boolean.valueOf(z16), str4, str5, str6, hashMap);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.register");
        toServiceMsg.setMsfCommand(MsfCommand.regUin_commitPass);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_SMSCODE, str);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_PASS, str2);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_NICK, str3);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_TYPE, Boolean.valueOf(z16));
        if (str4 != null && str4.length() > 0) {
            toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_LH_UIN, str4);
        } else if (str5 != null && str5.length() > 0) {
            toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_UNBIND_LH_UIN, str5);
        }
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_MAP_PARAM, hashMap);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REGISTER_CM_APPVERSION, str6);
        beforeSend(toServiceMsg);
        return toServiceMsg;
    }
}
