package mqq.app;

import PushNotifyPack.RequestPushForceOffline;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.widget.Toast;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.msf.service.protocol.push.RequestMSFForceOffline;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.msghandle.MsgRespHandler;
import mqq.inject.MqqInjectorManager;
import mqq.manager.IProxyIpService;
import mqq.manager.TicketManager;
import mqq.observer.TicketObserver;
import mqq.os.MqqRegulatorCallback;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.IServiceCmdCallback;
import mqq.util.MainServiceHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MainService {
    public static final String CMD_PRE_AUTH = "QQConnectLogin.pre_auth";
    public static final String MSFPROCESSNAMETAG = ":MSF";
    public static final String MSF_SERVICE_NAME = "com.tencent.mobileqq.msf.service.MsfService";
    public static final String SERVICE_CMD = "serviceCmd";
    private static final String TAG = "MainService";
    public static final String TO_SERVICE_MSG_AFTER_SENT = "AfterSendToServiceMsg";
    public static final String UIN_NOT_MATCH_TAG = "uinNotMatch";
    public static boolean isDebugVersion = false;
    public static boolean isGrayVersion = false;
    public static long sPwdPacketTime;
    public static MqqRegulatorCallback sRegulatorCallback;
    private final IAuthHandler authHandler;
    private final IErrorHandler errorHandler;
    private final MobileQQ mApplication;
    private IErrorHandler mCustomErrorHandler;
    private volatile AppRuntime.InterceptKickListener mInterceptKickListener;
    private final boolean mKickedBugfix;
    private Thread mProcessAdvanceMSFRecvThread;
    private final IMsfMsgHandler msfMsgHandler;
    private Thread msfRecvThread;
    private final MsfRespHandleUtil msfRespHandleUtil;
    public final MsfServiceSdk msfSub;
    INotifyHandler notifyHandler;
    private final IPushHandler pushHandler;
    private final IRegisterUinHandler registerUinHandler;
    private final IServerInfoHandler serverInfoHandler;
    private final IServerMsgPushHandler serverMsgPushHandler;
    public static final String QQPROCESSNAME = MobileQQ.PACKAGE_NAME;

    /* renamed from: um, reason: collision with root package name */
    private static AbstractUnifiedMonitor f417203um = null;
    private static IServiceCmdCallback sCmdCallback = null;
    public static int sNativeTidOfReceiver = -1;
    public static long sReceiverCpuTime = 0;
    private final Map<Integer, Class<? extends MSFServlet>> mRequestServlets = new ConcurrentHashMap();
    private boolean recvThreadRegulatoring = false;
    private boolean mAdvanceRecvThreadRegulatoring = false;
    private final Object mReceiverCpuTimeLock = new Object();
    public long cbIncreaseTime = 0;
    public int cbIncreaseCount = 0;
    public long cbLastUpdateSPTime = 0;
    public int cbExceedCount = 0;
    private final Runnable mProcessAdvanceReceiver = new Runnable() { // from class: mqq.app.MainService.1
        @Override // java.lang.Runnable
        public void run() {
            FromServiceMsg fromServiceMsg;
            MsgRespHandler msgRespHandler = new MsgRespHandler();
            while (true) {
                try {
                    if (MainService.this.mAdvanceRecvThreadRegulatoring) {
                        MainService.sRegulatorCallback.checkInRegulatorMsg();
                    }
                    MsfMessagePair preHandleServiceRespMsg = MainService.this.msfSub.getPreHandleServiceRespMsg();
                    if (preHandleServiceRespMsg != null) {
                        fromServiceMsg = preHandleServiceRespMsg.fromServiceMsg;
                        msgRespHandler.dispatchRespMsg(MainService.this.mApplication, preHandleServiceRespMsg, MainService.this.msfRespHandleUtil, MainService.this.msfSub);
                    } else {
                        fromServiceMsg = null;
                    }
                    if (fromServiceMsg == null && preHandleServiceRespMsg == null) {
                        MainService.this.msfSub.preHandleQueueWait();
                    }
                } catch (Exception e16) {
                    QLog.e(MainService.TAG, 1, "[MSF Receive]", e16);
                }
            }
        }
    };
    private final Runnable msfReceiver = new Runnable() { // from class: mqq.app.MainService.2
        @Override // java.lang.Runnable
        public void run() {
            FromServiceMsg fromServiceMsg;
            BaseApplication.gMsfReceiverStarted = 1;
            MainService.sNativeTidOfReceiver = Process.myTid();
            MsgRespHandler msgRespHandler = new MsgRespHandler();
            while (true) {
                try {
                    if (MainService.this.recvThreadRegulatoring) {
                        MainService.sRegulatorCallback.checkInRegulatorMsg();
                    }
                    MsfMessagePair serviceRespMsg = MainService.this.msfSub.getServiceRespMsg();
                    if (serviceRespMsg != null) {
                        fromServiceMsg = serviceRespMsg.fromServiceMsg;
                        msgRespHandler.dispatchRespMsg(MainService.this.mApplication, serviceRespMsg, MainService.this.msfRespHandleUtil, MainService.this.msfSub);
                    } else {
                        fromServiceMsg = null;
                    }
                    if (fromServiceMsg == null && serviceRespMsg == null) {
                        MainService.this.msfSub.queueWait();
                    }
                } catch (Exception e16) {
                    QLog.e(MainService.TAG, 1, "[MSF Receive]" + e16);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class MyErrorHandler implements IErrorHandler {
        private static final String SEC_TAG = "sec_sig_tag";

        MyErrorHandler() {
        }

        private boolean isCloneErrorKicked(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
            if (fromServiceMsg != null && ((Boolean) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_APP_CLONE, Boolean.FALSE)).booleanValue()) {
                return true;
            }
            return false;
        }

        private void onCloneError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
            AppRuntime waitAppRuntime = MainService.this.mApplication.waitAppRuntime();
            List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
            if (loginedAccountList != null) {
                Iterator<SimpleAccount> it = loginedAccountList.iterator();
                while (it.hasNext()) {
                    MsfSdkUtils.updateSimpleAccount(it.next().getUin(), false);
                }
            }
            MobileQQ.sMobileQQ.refreAccountList();
            popupNotification(NewIntent.ACTION_CLONE_LOGIN, waitAppRuntime.getAccount(), "", "", Constants.LogoutReason.forceLogout, false);
        }

        private void onInterceptKicked(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, boolean z17) {
            AppRuntime.InterceptKickListener interceptKickListener = MainService.this.mInterceptKickListener;
            if (interceptKickListener != null) {
                interceptKickListener.onInterceptKicked(new AppRuntime.KickParams(toServiceMsg, fromServiceMsg, z17, z16));
            } else {
                onKickedInternal(toServiceMsg, fromServiceMsg, z17, z16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void popupNotification(String str, String str2, String str3, String str4, Constants.LogoutReason logoutReason, boolean z16) {
            popupNotification(str, str2, str3, str4, logoutReason, z16, "");
        }

        private void popupNotificationEx(final String str, final String str2, final String str3, final String str4, final Constants.LogoutReason logoutReason, final byte[] bArr) {
            final AppRuntime waitAppRuntime = MainService.this.mApplication.waitAppRuntime();
            if (QLog.isColorLevel()) {
                QLog.d(SEC_TAG, 2, "popupNotificationEx");
            } else {
                QLog.d(SEC_TAG, 1, "popupNotificationEx action: " + str);
            }
            waitAppRuntime.runOnUiThread(new Runnable() { // from class: mqq.app.MainService.MyErrorHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime appRuntime = waitAppRuntime;
                    if (MainService.this.mApplication != null && MainServiceHelper.INSTANCE.isSwitchMainThread()) {
                        appRuntime = MainService.this.mApplication.waitAppRuntime();
                        QLog.d("mqq", 1, "popupNotificationEx get runtime main thread");
                    }
                    if (str2.equals(appRuntime.getAccount())) {
                        if (QLog.isColorLevel()) {
                            QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification start");
                        }
                        if (logoutReason != Constants.LogoutReason.tips && appRuntime.isLogin()) {
                            QLog.d("mqq", 1, "kickPC in popupNotificationEx  do logout");
                            appRuntime.logout(logoutReason, true);
                        }
                        Intent intent = new Intent(str);
                        intent.putExtra("title", str3);
                        intent.putExtra("msg", str4);
                        intent.putExtra("reason", logoutReason);
                        intent.putExtra("data", bArr);
                        intent.addFlags(268435456);
                        try {
                            MainService.this.mApplication.startActivity(intent);
                        } catch (ActivityNotFoundException unused) {
                            appRuntime.runOnUiThread(new Runnable() { // from class: mqq.app.MainService.MyErrorHandler.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(MainService.this.mApplication, "[mqq]" + logoutReason + "\n" + str3 + "\n" + str4, 0).show();
                                }
                            });
                        }
                        Intent intent2 = new Intent(str);
                        intent2.putExtra("reason", logoutReason);
                        MainService.this.mApplication.sendBroadcast(intent2);
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onGrayError(ToServiceMsg toServiceMsg, final FromServiceMsg fromServiceMsg, final boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked.....onGrayError start");
            }
            if (MsfCommand.wt_GetStViaSMSVerifyLogin.equals(fromServiceMsg.getMsfCommand()) || MsfCommand.wt_loginAuth.equals(fromServiceMsg.getMsfCommand())) {
                if (QLog.isColorLevel()) {
                    QLog.d("mqq", 2, "onGrayError:" + fromServiceMsg);
                }
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }
            MsfSdkUtils.updateSimpleAccount(fromServiceMsg.getUin(), false);
            MainService.this.mApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
            final String str = (String) fromServiceMsg.getAttribute(fromServiceMsg.getServiceCmd(), "false");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: mqq.app.MainService.MyErrorHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    MyErrorHandler.this.popupNotification(NewIntent.ACTION_GRAY, fromServiceMsg.getUin(), str, fromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.gray, z16);
                }
            }, 500L);
            if (MainService.this.mCustomErrorHandler != null) {
                MainService.this.mCustomErrorHandler.onGrayError(toServiceMsg, fromServiceMsg, z16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked.....onGrayError end");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onInvalidSign(boolean z16) {
            AppRuntime waitAppRuntime = MainService.this.mApplication.waitAppRuntime();
            if (waitAppRuntime != null) {
                waitAppRuntime.runOnUiThread(new Runnable() { // from class: mqq.app.MainService.MyErrorHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(MainService.this.mApplication, "Appid is invalid!", 0).show();
                    }
                });
            }
            if (MainService.this.mCustomErrorHandler != null) {
                MainService.this.mCustomErrorHandler.onInvalidSign(z16);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onKicked(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            QLog.d("mqq", 1, "kicked.....onKicked start");
            if (isCloneErrorKicked(toServiceMsg, fromServiceMsg)) {
                onCloneError(toServiceMsg, fromServiceMsg);
            } else {
                onInterceptKicked(toServiceMsg, fromServiceMsg, z16, false);
            }
            if (MainService.this.mCustomErrorHandler != null) {
                MainService.this.mCustomErrorHandler.onKicked(toServiceMsg, fromServiceMsg, z16);
            }
            QLog.d("mqq", 1, "kicked.....onKicked end");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onKickedAndClearToken(ToServiceMsg toServiceMsg, final FromServiceMsg fromServiceMsg, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked ... onKickedAndClearToken start");
            }
            ThreadManagerV2.excute(new Runnable() { // from class: mqq.app.MainService.MyErrorHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime peekAppRuntime;
                    if (MobileQQ.sProcessId == 1 && (peekAppRuntime = MainService.this.mApplication.peekAppRuntime()) != null) {
                        NewIntent newIntent = new NewIntent(MainService.this.mApplication.getApplicationContext(), BuiltInServlet.class);
                        newIntent.putExtra("action", 2218);
                        newIntent.putExtra("uin", fromServiceMsg.getUin());
                        newIntent.putExtra(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_CMD, "onKicked");
                        newIntent.putExtra(BaseConstants.ATTR_KEY_SEC_DISPATCH_EVENT_PARAM, fromServiceMsg.getUin());
                        peekAppRuntime.startServlet(newIntent);
                        QLog.d("mqq", 1, "kicked ... send to msf");
                    }
                }
            }, 16, null, true);
            onInterceptKicked(toServiceMsg, fromServiceMsg, z16, true);
            if (MainService.this.mCustomErrorHandler != null) {
                MainService.this.mCustomErrorHandler.onKickedAndClearToken(toServiceMsg, fromServiceMsg, z16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked ... onKickedAndClearToken end");
            }
        }

        void onKickedInternal(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, boolean z17) {
            boolean z18;
            if (z16) {
                QLog.d(SEC_TAG, 1, "kicked.....onKicked:isTokenExpired start");
                MsfSdkUtils.updateSimpleAccount(fromServiceMsg.getUin(), false);
                MainService.this.mApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
                RequestMSFForceOffline requestMSFForceOffline = (RequestMSFForceOffline) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "RequestMSFForceOffline", new RequestMSFForceOffline());
                if (requestMSFForceOffline.bSigKick == 1) {
                    QLog.d(SEC_TAG, 1, "kicked.....onKicked:result.bSigKick == 1");
                    popupNotificationEx(NewIntent.ACTION_ACCOUNT_KICKED, fromServiceMsg.getUin(), requestMSFForceOffline.strTitle, requestMSFForceOffline.strInfo, Constants.LogoutReason.secKicked, requestMSFForceOffline.vecSigKickData);
                } else {
                    QLog.d(SEC_TAG, 1, "kicked.....onKicked:result.bSigKick != 1");
                    popupNotification(NewIntent.ACTION_ACCOUNT_KICKED, fromServiceMsg.getUin(), requestMSFForceOffline.strTitle, requestMSFForceOffline.strInfo, Constants.LogoutReason.kicked, z17);
                }
                QLog.d(SEC_TAG, 1, "kicked.....onKicked:isTokenExpired end");
                return;
            }
            QLog.d(SEC_TAG, 1, "kicked.....onKicked: not isTokenExpired start");
            MainService.this.mApplication.setAutoLogin(false);
            RequestPushForceOffline requestPushForceOffline = (RequestPushForceOffline) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "req_PushForceOffline", new RequestPushForceOffline());
            if (requestPushForceOffline != null) {
                QLog.d(SEC_TAG, 1, "kicked.....onKicked: not isTokenExpired start req != null");
                String uin = fromServiceMsg.getUin();
                String str = requestPushForceOffline.strTitle;
                String str2 = requestPushForceOffline.strTips;
                Constants.LogoutReason logoutReason = Constants.LogoutReason.forceLogout;
                if (requestPushForceOffline.bSameDevice == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                popupNotification(NewIntent.ACTION_ACCOUNT_KICKED, uin, str, str2, logoutReason, z18);
            } else {
                popupNotification(NewIntent.ACTION_ACCOUNT_KICKED, fromServiceMsg.getUin(), null, null, Constants.LogoutReason.forceLogout, false);
            }
            QLog.d(SEC_TAG, 1, "kicked.....onKicked: not isTokenExpired end");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onRecvServerTip(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            String[] split = businessFailMsg.split(RedTouch.NEWLINE_CHAR);
            int indexOf = businessFailMsg.indexOf("\n");
            if (indexOf != -1) {
                businessFailMsg = businessFailMsg.substring(indexOf + 1);
            }
            popupNotification(NewIntent.ACTION_ACCOUNT_TIPS, fromServiceMsg.getUin(), split[0], businessFailMsg, Constants.LogoutReason.tips, z16);
            if (MainService.this.mCustomErrorHandler != null) {
                MainService.this.mCustomErrorHandler.onRecvServerTip(toServiceMsg, fromServiceMsg, z16);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onServerSuspended(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked.....onServerSuspended start");
            }
            if (toServiceMsg == null) {
                popupNotification(NewIntent.ACTION_SUSPEND, fromServiceMsg.getUin(), null, fromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.suspend, z16);
            }
            if (MainService.this.mCustomErrorHandler != null) {
                MainService.this.mCustomErrorHandler.onServerSuspended(toServiceMsg, fromServiceMsg, z16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked.....onServerSuspended end");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IErrorHandler
        public void onUserTokenExpired(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked...onUserTokenExpired start");
            }
            QLog.e("mqq", 1, "onUserTokenExpired ", new RuntimeException("onUserTokenExpired "));
            if (MainService.this.mKickedBugfix) {
                MsfSdkUtils.updateSimpleAccountNotCreate(fromServiceMsg.getUin(), false);
            } else {
                MsfSdkUtils.updateSimpleAccount(fromServiceMsg.getUin(), false);
            }
            MainService.this.mApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
            popupNotification(NewIntent.ACTION_ACCOUNT_EXPIRED, fromServiceMsg.getUin(), null, fromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.expired, z16, fromServiceMsg.getServiceCmd());
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked....onUserTokenExpired end ");
            }
            if (MainService.this.mCustomErrorHandler != null) {
                MainService.this.mCustomErrorHandler.onUserTokenExpired(toServiceMsg, fromServiceMsg, z16);
            }
        }

        private void popupNotification(final String str, final String str2, final String str3, final String str4, final Constants.LogoutReason logoutReason, final boolean z16, final String str5) {
            final AppRuntime waitAppRuntime = MainService.this.mApplication.waitAppRuntime();
            if (waitAppRuntime == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification isSameDevice = " + z16 + "; runnbackGroud = " + waitAppRuntime.isBackgroundStop + ";action = " + str + "; mApplicaiton.getProcessName() = " + MainService.this.mApplication.getQQProcessName());
            } else {
                QLog.d("mqq", 1, "kicked....kickPC...... in popupNotification isSameDevice = " + z16 + "; runnbackGroud = " + waitAppRuntime.isBackgroundStop + ";action = " + str + "; processName = " + MobileQQ.processName);
            }
            waitAppRuntime.runOnUiThread(new Runnable() { // from class: mqq.app.MainService.MyErrorHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    boolean z17;
                    String str6;
                    AppRuntime appRuntime = waitAppRuntime;
                    if (MainService.this.mApplication != null && MainServiceHelper.INSTANCE.isSwitchMainThread()) {
                        appRuntime = MainService.this.mApplication.waitAppRuntime();
                        QLog.d("mqq", 1, "popupNotification get runtime main thread");
                    }
                    String str7 = str2;
                    if (str7 != null && str7.equals(appRuntime.getAccount())) {
                        Constants.LogoutReason logoutReason2 = logoutReason;
                        Constants.LogoutReason logoutReason3 = Constants.LogoutReason.expired;
                        if (logoutReason2 == logoutReason3 && !appRuntime.isLogin()) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (logoutReason != Constants.LogoutReason.tips && appRuntime.isLogin()) {
                            QLog.d("mqq", 1, "kickPC in popupNotification do logout by " + logoutReason);
                            appRuntime.logout(logoutReason, true);
                        }
                        if (z17 && MainService.this.mApplication != null && MainService.this.mApplication.getQQProcessName().equalsIgnoreCase(MainService.this.mApplication.getPackageName())) {
                            Intent intent = new Intent(str);
                            intent.setPackage(MainService.this.mApplication.getPackageName());
                            intent.putExtra("title", str3);
                            intent.putExtra("msg", str4);
                            intent.putExtra("reason", logoutReason);
                            intent.putExtra("isSameDevice", z16);
                            intent.addFlags(268435456);
                            boolean z18 = MqqInjectorManager.instance().getSwitch("kick_to_login_page", true);
                            Constants.LogoutReason logoutReason4 = logoutReason;
                            if ((logoutReason4 == Constants.LogoutReason.forceLogout || logoutReason4 == logoutReason3 || logoutReason4 == Constants.LogoutReason.kicked) && z18) {
                                intent.setAction(NewIntent.ACTION_KICK_TO_LOGIN);
                                intent.putExtra("login_page_action", str);
                                intent.putExtra("loginFragmentType", 5);
                                intent.putExtra("uin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
                            }
                            if (!appRuntime.isClearTaskBySystem && (!z16 || (str6 = str) == null || !str6.equalsIgnoreCase(NewIntent.ACTION_ACCOUNT_KICKED) || !appRuntime.isBackgroundStop)) {
                                if (!appRuntime.onReceiveUnhandledKickedMsg(str, intent)) {
                                    try {
                                        MainService.this.mApplication.startActivity(intent);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("mqq", 2, "kicked start notification......");
                                        }
                                    } catch (Exception unused) {
                                        appRuntime.runOnUiThread(new Runnable() { // from class: mqq.app.MainService.MyErrorHandler.3.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Toast.makeText(MainService.this.mApplication, "[mqq]" + logoutReason + "\n" + str3 + "\n" + str4, 0).show();
                                            }
                                        });
                                    }
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("mqq", 2, "kicked samedevice and set kickIntent ");
                                }
                                appRuntime.setKickIntent(intent);
                            }
                        }
                        Intent intent2 = new Intent(str);
                        intent2.putExtra("reason", logoutReason);
                        intent2.putExtra("title", str3);
                        intent2.putExtra("msg", str4);
                        intent2.putExtra("reason", logoutReason);
                        intent2.putExtra("isSameDevice", z16);
                        intent2.putExtra("needNotify", false);
                        intent2.setPackage(MainService.this.mApplication.getPackageName());
                        if (MainService.CMD_PRE_AUTH.equals(str5)) {
                            intent2.putExtra(MainService.SERVICE_CMD, str5);
                        }
                        MainService.this.mApplication.sendBroadcast(intent2);
                        if (QLog.isColorLevel()) {
                            QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification end isNeedNotify = " + z17);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MainService(MobileQQ mobileQQ, int i3, String str, boolean z16) {
        MyErrorHandler myErrorHandler = new MyErrorHandler();
        this.errorHandler = myErrorHandler;
        IMsfMsgHandler iMsfMsgHandler = new IMsfMsgHandler() { // from class: mqq.app.MainService.3
            @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler
            public void onRecvResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }
        };
        this.msfMsgHandler = iMsfMsgHandler;
        IPushHandler iPushHandler = new IPushHandler() { // from class: mqq.app.MainService.4
            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onOverloadPushNotify(final String str2) {
                QLog.d("mqq", 1, "overload push notify, msg: " + str2);
                if (MainService.this.mApplication != null) {
                    AppRuntime waitAppRuntime = MainService.this.mApplication.waitAppRuntime();
                    if (waitAppRuntime != null) {
                        waitAppRuntime.runOnUiThread(new Runnable() { // from class: mqq.app.MainService.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    Intent intent = new Intent(NewIntent.ACTION_OVERLOAD_PUSH);
                                    intent.putExtra("msg", str2);
                                    intent.addFlags(268435456);
                                    MainService.this.mApplication.startActivity(intent);
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    QLog.d("mqq", 1, "overload push notify fail, except: " + e16.getMessage());
                                }
                            }
                        });
                    } else {
                        QLog.d("mqq", 1, "overload push notify fail, app is null");
                    }
                }
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onProxyIpChanged(String str2) {
                AppRuntime waitAppRuntime;
                QLog.d("mqq", 1, "proxy ip changed, uin: " + MsfSdkUtils.getShortUin(str2));
                if (MainService.this.mApplication != null && (waitAppRuntime = MainService.this.mApplication.waitAppRuntime()) != null) {
                    ((IProxyIpService) waitAppRuntime.getRuntimeService(IProxyIpService.class, "all")).reloadCache(str2, false);
                }
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onRecvCmdPush(FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(null, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onRegisterCmdPushResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onRegisterPushResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onSecDispatchToAppEvent(FromServiceMsg fromServiceMsg) {
                try {
                    int i16 = com.tencent.mobileqq.dt.api.impl.b.f203702d;
                    AppRuntime peekAppRuntime = MainService.this.mApplication.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        peekAppRuntime.getServletContainer().notifyMSFServlet(com.tencent.mobileqq.dt.api.impl.b.class, fromServiceMsg);
                    }
                } catch (Exception e16) {
                    QLog.e(MainService.TAG, 1, "onSecDispatchToAppEvent error", e16);
                }
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onTicketChanged(FromServiceMsg fromServiceMsg) {
                AppRuntime waitAppRuntime;
                if (fromServiceMsg != null) {
                    QLog.d("mqq", 1, "ticket changed by uin: " + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                }
                if (MainService.this.mApplication != null && (waitAppRuntime = MainService.this.mApplication.waitAppRuntime()) != null) {
                    ((TicketManager) waitAppRuntime.getManager(2)).reloadCache(MainService.this.mApplication);
                    if (fromServiceMsg != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("uin", fromServiceMsg.getUin());
                        waitAppRuntime.notifyObservers(TicketObserver.class, 0, true, bundle);
                    }
                }
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onUnRegisterPushResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IPushHandler
            public void onResetCmdPushResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
            }
        };
        this.pushHandler = iPushHandler;
        this.notifyHandler = new INotifyHandler() { // from class: mqq.app.MainService.5
            @Override // com.tencent.mobileqq.msf.sdk.handler.INotifyHandler
            public void onRecvNotify(long j3, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(null, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.INotifyHandler
            public void onRegisterNotifyResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.INotifyHandler
            public void onUnRegisterNotifyResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
            }
        };
        IRegisterUinHandler iRegisterUinHandler = new IRegisterUinHandler() { // from class: mqq.app.MainService.6
            @Override // com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
            public void onCheckQuickRegisterResp(int i16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
            public void onGetQuickRegisterResp(int i16, String str2, String str3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
            public void onRegQueryAccountResp(int i16, byte[] bArr, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
            public void onRegisterCommitMobileResp(int i16, byte[] bArr, byte[] bArr2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
            public void onRegisterCommitPassResp(int i16, String str2, byte[] bArr, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
            public void onRegisterCommitSmsCodeResp(int i16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
            public void onRegisterQuerySmsStatResp(int i16, byte[] bArr, int i17, int i18, String str2, String str3, String str4, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
            public void onRegisterSendResendSmsreqResp(int i16, byte[] bArr, int i17, int i18, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }
        };
        this.registerUinHandler = iRegisterUinHandler;
        IAuthHandler iAuthHandler = new IAuthHandler() { // from class: mqq.app.MainService.7
            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onDelLoginedAccountResp(int i16, int i17, String str2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onGetKeyResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onGetSidResp(int i16, int i17, String str2, String str3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                fromServiceMsg.attributes.put("sid", str3);
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onGetUinSignResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr) {
                fromServiceMsg.attributes.put(fromServiceMsg.getServiceCmd(), bArr);
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onReceVerifyCode(VerifyCodeInfo verifyCodeInfo, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                fromServiceMsg.addAttribute("VerifyCodeInfo", verifyCodeInfo);
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onRecvChangeTokenResp(int i16, int i17, String str2, RespondCustomSig respondCustomSig, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                byte[] bArr;
                if (respondCustomSig != null) {
                    Iterator<CustomSigContent> it = respondCustomSig.SigList.iterator();
                    while (it.hasNext()) {
                        CustomSigContent next = it.next();
                        long j3 = next.ulSigType;
                        if (j3 == 14) {
                            if (next.sResult == 0) {
                                fromServiceMsg.attributes.put("vkey", HexUtil.bytes2HexStr(next.SigContent));
                            }
                        } else if (j3 == 8) {
                            if (next.sResult == 0) {
                                fromServiceMsg.attributes.put("STwxWeb", HexUtil.bytes2HexStr(next.SigContent));
                            }
                        } else if (j3 == 13) {
                            if (next.sResult == 0) {
                                Object attribute = fromServiceMsg.getAttribute(fromServiceMsg.getServiceCmd());
                                if (attribute instanceof ArrayList) {
                                    fromServiceMsg.attributes.put("arrD3", (ArrayList) attribute);
                                }
                            }
                        } else if (j3 == 19) {
                            if (next.sResult == 0 && (bArr = next.SigContent) != null) {
                                fromServiceMsg.attributes.put("skey", new String(bArr));
                            } else {
                                try {
                                    byte[] bArr2 = next.SigContent;
                                    if (bArr2 != null) {
                                        fromServiceMsg.attributes.put("skeyError", new String(bArr2, "utf-8"));
                                    }
                                } catch (UnsupportedEncodingException e16) {
                                    e16.printStackTrace();
                                }
                            }
                        } else if (j3 == 21 && next.sResult == 0) {
                            fromServiceMsg.attributes.put("superkey", next.SigContent);
                        }
                    }
                }
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onRecvChangeUinLoginResp(int i16, int i17, String str2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                boolean z17;
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
                String str3 = (String) toServiceMsg.getAttribute("from_where");
                boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("forbiddenCreateRuntime", Boolean.FALSE)).booleanValue();
                if (!"subaccount".equals(str3) && !BaseConstants.SSO_ACCOUNT_ACTION.equals(str3) && !booleanValue) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (fromServiceMsg.isSuccess() && z17) {
                    MainService.this.mApplication.createNewRuntime(SimpleAccount.parseSimpleAccount((String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_SIMPLEACCOUNT)), true, true, 4, null);
                }
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onRecvChangeUinResp(int i16, int i17, String str2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onRecvLoginResp(int i16, int i17, String str2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                boolean z17;
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
                String str3 = (String) toServiceMsg.getAttribute("from_where");
                boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("forbiddenCreateRuntime", Boolean.FALSE)).booleanValue();
                if (!"subaccount".equals(str3) && !BaseConstants.SSO_ACCOUNT_ACTION.equals(str3) && !booleanValue) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (fromServiceMsg.isSuccess() && z17) {
                    MainService.this.mApplication.createNewRuntime(SimpleAccount.parseSimpleAccount((String) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_SIMPLEACCOUNT)), true, true, 3, null);
                }
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IAuthHandler
            public void onRefreSidResp(int i16, int i17, String str2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                fromServiceMsg.attributes.put("sid", str2);
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }
        };
        this.authHandler = iAuthHandler;
        IServerInfoHandler iServerInfoHandler = new IServerInfoHandler() { // from class: mqq.app.MainService.8
            @Override // com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler
            public void onReportResp(int i16, int i17, String str2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(toServiceMsg, fromServiceMsg);
            }
        };
        this.serverInfoHandler = iServerInfoHandler;
        IServerMsgPushHandler iServerMsgPushHandler = new IServerMsgPushHandler() { // from class: mqq.app.MainService.9
            @Override // com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler
            public void onConnClose(FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(null, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler
            public void onConnOpened(FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(null, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler
            public void onOpenConnAllFailed(FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(null, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler
            public void onReceFirstResp(FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(null, fromServiceMsg);
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler
            public void onRecvServerConfigPush(FromServiceMsg fromServiceMsg) {
                MainService.this.receiveMessageFromMSF(null, fromServiceMsg);
            }
        };
        this.serverMsgPushHandler = iServerMsgPushHandler;
        this.mApplication = mobileQQ;
        MsfServiceSdk msfServiceSdk = MsfServiceSdk.get();
        this.msfSub = msfServiceSdk;
        msfServiceSdk.init(mobileQQ, i3, str, MSF_SERVICE_NAME, myErrorHandler, MobileQQ.processName);
        this.msfRespHandleUtil = new MsfRespHandleUtil(new IMsfHandler[]{iMsfMsgHandler, iPushHandler, this.notifyHandler, iAuthHandler, iRegisterUinHandler, iServerMsgPushHandler, iServerInfoHandler});
        boolean z17 = MqqInjectorManager.instance().getSwitch("102595", true);
        this.mKickedBugfix = z17;
        QLog.i(TAG, 1, "MainService mKickedBugfix: " + z17);
        if (z16) {
            start();
        }
    }

    private boolean isValidAccount(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, AppRuntime appRuntime, boolean z16, String str2) {
        if (!z16 && !str2.equals(appRuntime.getAccount()) && !isWhiteCommand(fromServiceMsg) && ((str == null || !str.equals("subaccount")) && (toServiceMsg == null || !toServiceMsg.getAttributes().containsKey(UIN_NOT_MATCH_TAG)))) {
            return false;
        }
        return true;
    }

    private boolean isWhiteCommand(FromServiceMsg fromServiceMsg) {
        if (!BaseConstants.CMD_LOGIN_AUTH.equals(fromServiceMsg.getServiceCmd()) && !BaseConstants.CMD_WT_LOGIN_AUTH.equals(fromServiceMsg.getServiceCmd()) && !MsfCommand.wt_GetStViaSMSVerifyLogin.equals(fromServiceMsg.getMsfCommand()) && !MsfCommand.wt_loginAuth.equals(fromServiceMsg.getMsfCommand()) && !MsfCommand.wt_name2uin.equals(fromServiceMsg.getMsfCommand()) && !BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH.equals(fromServiceMsg.getServiceCmd())) {
            return false;
        }
        return true;
    }

    private void notifyCostTooLongIfDebug(FromServiceMsg fromServiceMsg, AppRuntime appRuntime, long j3) {
        if (isDebugVersion && j3 >= 5000) {
            QLog.d(TAG, 4, "Caution! running too long. cmd=" + fromServiceMsg.getServiceCmd() + " time=" + j3 + "ms.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveMessageFromMSF(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        String str;
        String str2;
        Class<? extends MSFServlet> cls;
        boolean z16;
        boolean z17;
        AppRuntime waitAppRuntime = this.mApplication.waitAppRuntime();
        if (toServiceMsg != null) {
            waitAppRuntime = waitAppRuntime.getAppRuntime(toServiceMsg.extraData.getString("moduleId"));
        }
        AppRuntime appRuntime = waitAppRuntime;
        if (QLog.isColorLevel()) {
            j3 = SystemClock.currentThreadTimeMillis();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        if (toServiceMsg != null) {
            Class<? extends MSFServlet> remove = this.mRequestServlets.remove(Integer.valueOf(toServiceMsg.getAppSeq()));
            long currentTimeMillis = System.currentTimeMillis() - toServiceMsg.extraData.getLong(RemoteMessageConst.SEND_TIME);
            fromServiceMsg.addAttribute("msf_receive", Long.valueOf(System.currentTimeMillis()));
            if (fromServiceMsg.isSuccess()) {
                if (QLog.isColorLevel()) {
                    QLog.d("mqq", 2, "[MSF Receive]" + fromServiceMsg.getServiceCmd() + " appSeq:" + toServiceMsg.getAppSeq() + "  " + appRuntime.getClass().getSimpleName() + "@" + appRuntime.hashCode() + "  cost=" + currentTimeMillis + "ms.");
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("mqq", 2, "[MSF Receive]" + fromServiceMsg.getServiceCmd() + " appSeq:" + toServiceMsg.getAppSeq() + "  " + appRuntime.getClass().getSimpleName() + "@" + appRuntime.hashCode() + "  code=" + fromServiceMsg.getResultCode() + ",cost=" + currentTimeMillis + "ms.");
            }
            IServiceCmdCallback iServiceCmdCallback = sCmdCallback;
            if (iServiceCmdCallback != null) {
                iServiceCmdCallback.onCmdResponse(fromServiceMsg.getServiceCmd());
            }
            recordKeyTimestamp(toServiceMsg, fromServiceMsg);
            String str3 = (String) toServiceMsg.getAttribute("from_where");
            str = (String) toServiceMsg.getAttribute("mainaccount");
            cls = remove;
            str2 = str3;
            z16 = false;
        } else {
            if (this.mApplication.getQQProcessName().endsWith(MsfConstants.PROCESS_VIDEO) || QLog.isColorLevel()) {
                QLog.d("mqq", 1, "[MSF Push]" + fromServiceMsg.getServiceCmd() + ",ssoseq=" + fromServiceMsg.getRequestSsoSeq());
            }
            str = null;
            str2 = null;
            cls = null;
            z16 = true;
        }
        if ("0".equals(fromServiceMsg.getUin())) {
            fromServiceMsg.setUin(appRuntime.getAccount());
            z17 = true;
        } else {
            z17 = false;
        }
        String uin = fromServiceMsg.getUin();
        if (str2 != null && str2.length() > 0) {
            fromServiceMsg.addAttribute("from_where", str2);
        }
        if (str != null && str.length() > 0) {
            fromServiceMsg.addAttribute("mainaccount", str);
        }
        Class<? extends MSFServlet> cls2 = cls;
        if (isValidAccount(toServiceMsg, fromServiceMsg, str2, appRuntime, z17, uin)) {
            MsgRespHandler.onRespHandleStart(f417203um);
            long uptimeMillis = SystemClock.uptimeMillis();
            fromServiceMsg.addAttribute(TO_SERVICE_MSG_AFTER_SENT, toServiceMsg);
            appRuntime.getServletContainer().notifyMSFServlet(cls2, fromServiceMsg);
            if (z16) {
                try {
                    Iterator<AppRuntime> it = appRuntime.subRuntimeMap.values().iterator();
                    while (it.hasNext()) {
                        it.next().getServletContainer().notifyMSFServlet(cls2, fromServiceMsg);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "", e16);
                    }
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            MsgRespHandler.onRespHandleFinish(this.mApplication, f417203um, fromServiceMsg, uptimeMillis2, this.msfSub);
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            synchronized (this.mReceiverCpuTimeLock) {
                sReceiverCpuTime = currentThreadTimeMillis;
            }
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "[MSF End][notifyMSFServlet]", fromServiceMsg.getServiceCmd(), ",ssoseq=", Integer.valueOf(fromServiceMsg.getRequestSsoSeq()), ",cost=", Long.valueOf(uptimeMillis2), "ms, cpucost=", Long.valueOf(currentThreadTimeMillis - j16), "(", Long.valueOf(currentThreadTimeMillis), ").");
            }
            reportMsfLongCallback(fromServiceMsg, uptimeMillis2);
            reportMSFCallBackCost(uptimeMillis2, false);
            notifyCostTooLongIfDebug(fromServiceMsg, appRuntime, uptimeMillis2);
        }
    }

    private void recordKeyTimestamp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            long j3 = toServiceMsg.extraData.getLong(RemoteMessageConst.SEND_TIME, 0L);
            long longValue = ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_APP2MSF, 0L)).longValue();
            long longValue2 = ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET, 0L)).longValue();
            long longValue3 = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF, 0L)).longValue();
            long longValue4 = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2APP, 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            fromServiceMsg.extraData.putLong("timestamp_app2msf_atAppSite", j3);
            fromServiceMsg.extraData.putLong("timestamp_app2msf_atMsfSite", longValue);
            fromServiceMsg.extraData.putLong("timestamp_msf2net_atMsfSite", longValue2);
            fromServiceMsg.extraData.putLong("timestamp_net2msf_atMsfSite", longValue3);
            fromServiceMsg.extraData.putLong("timestamp_msf2app_atMsfSite", longValue4);
            fromServiceMsg.extraData.putLong("timestamp_msf2app_atAppSite", currentTimeMillis);
        }
    }

    private void reportMsfLongCallback(FromServiceMsg fromServiceMsg, long j3) {
        if (j3 >= 2000) {
            HashMap hashMap = new HashMap();
            hashMap.put("cmd", fromServiceMsg.getServiceCmd());
            RdmReq rdmReq = new RdmReq();
            rdmReq.eventName = "longTimeCallback";
            rdmReq.elapse = j3;
            rdmReq.size = 0L;
            rdmReq.isSucceed = true;
            rdmReq.isRealTime = false;
            rdmReq.params = hashMap;
            ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), rdmReq);
            rdmReportMsg.setNeedCallback(false);
            rdmReportMsg.extraData.putLong(RemoteMessageConst.SEND_TIME, System.currentTimeMillis());
            this.msfSub.sendMsg(rdmReportMsg);
        }
    }

    public static void setServiceCmdCallback(IServiceCmdCallback iServiceCmdCallback) {
        sCmdCallback = iServiceCmdCallback;
    }

    public static void setUnifiedMonitorInstance(AbstractUnifiedMonitor abstractUnifiedMonitor) {
        f417203um = abstractUnifiedMonitor;
    }

    private void startAdvance() {
        if (this.mProcessAdvanceMSFRecvThread == null) {
            this.mProcessAdvanceMSFRecvThread = new BaseThread(this.mProcessAdvanceReceiver, "MSF-Advance-Receiver");
            QLog.d(TAG, 1, "start MSF-Advance-Receiver " + this.mProcessAdvanceMSFRecvThread.getId());
            this.mProcessAdvanceMSFRecvThread.setPriority(10);
            this.mProcessAdvanceMSFRecvThread.start();
            MqqRegulatorCallback mqqRegulatorCallback = sRegulatorCallback;
            if (mqqRegulatorCallback != null) {
                this.mAdvanceRecvThreadRegulatoring = mqqRegulatorCallback.regulatorThread(this.mProcessAdvanceMSFRecvThread);
            }
        }
    }

    private void startCommon() {
        if (this.msfRecvThread == null) {
            this.msfRecvThread = new BaseThread(this.msfReceiver, "MSF-Receiver");
            QLog.d(TAG, 1, "start MSF-Receiver " + this.msfRecvThread.getId());
            MobileQQ mobileQQ = this.mApplication;
            if (mobileQQ != null && mobileQQ.getQQProcessName() != null && this.mApplication.getQQProcessName().endsWith(MsfConstants.PROCESS_VIDEO)) {
                this.msfRecvThread.setPriority(10);
            } else {
                this.msfRecvThread.setPriority(5);
            }
            this.msfRecvThread.start();
            MqqRegulatorCallback mqqRegulatorCallback = sRegulatorCallback;
            if (mqqRegulatorCallback != null) {
                this.recvThreadRegulatoring = mqqRegulatorCallback.regulatorThread(this.msfRecvThread);
            }
        }
    }

    public void clearServlets() {
        this.mRequestServlets.clear();
    }

    public void kick(AppRuntime.KickParams kickParams) {
        if (kickParams != null) {
            IErrorHandler iErrorHandler = this.errorHandler;
            if (iErrorHandler instanceof MyErrorHandler) {
                ((MyErrorHandler) iErrorHandler).onKickedInternal((ToServiceMsg) kickParams.toServiceMsg, (FromServiceMsg) kickParams.fromServiceMsg, kickParams.isTokenExpired, kickParams.isSameDevice);
            }
        }
    }

    public void onRecvVerifyManagerCallback(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        fromServiceMsg.setAppSeq(toServiceMsg.getAppSeq());
        this.msfRespHandleUtil.handleRespMsg(toServiceMsg, fromServiceMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void reportMSFCallBackCost(long j3, boolean z16) {
        boolean z17;
        long currentTimeMillis;
        long j16;
        long j17;
        if (j3 >= 0) {
            this.cbIncreaseTime += j3;
            this.cbIncreaseCount++;
            if (j3 >= 2000) {
                this.cbExceedCount++;
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j18 = this.cbLastUpdateSPTime;
        if (j18 > 0) {
            if (elapsedRealtime - j18 > 600000) {
                z17 = true;
                if (z17 && this.cbIncreaseTime > 0) {
                    currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = this.mApplication.getSharedPreferences("msf_cb_report", 0);
                    j16 = sharedPreferences.getLong("cbLastReportTime", currentTimeMillis);
                    long j19 = sharedPreferences.getLong("cbTotalTime", 0L) + this.cbIncreaseTime;
                    int i3 = sharedPreferences.getInt("cbTotalCount", 0) + this.cbIncreaseCount;
                    int i16 = sharedPreferences.getInt("cbExceedCount", 0) + this.cbExceedCount;
                    if (currentTimeMillis - j16 < 86400000) {
                        if (i3 > 0) {
                            j17 = j19 / i3;
                        } else {
                            j17 = 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("mqq", 2, "reportMSFCallBackCost-->cbTotalTime:" + j19 + " ,cbTotalCount:" + i3 + " ,cbAverageTime:" + j17);
                        }
                        RdmReq rdmReq = new RdmReq();
                        HashMap hashMap = new HashMap();
                        hashMap.put("cbAverageTime", String.valueOf(j17));
                        hashMap.put("cbTotalCount", String.valueOf(i3));
                        hashMap.put("cbExceedCount", String.valueOf(i16));
                        rdmReq.eventName = "MSFCallBackAvgCost";
                        rdmReq.elapse = j17;
                        rdmReq.size = 0L;
                        rdmReq.isSucceed = true;
                        rdmReq.isRealTime = false;
                        rdmReq.params = hashMap;
                        ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), rdmReq);
                        rdmReportMsg.extraData.putLong(RemoteMessageConst.SEND_TIME, System.currentTimeMillis());
                        this.msfSub.sendMsg(rdmReportMsg);
                        j19 = 0;
                        i3 = 0;
                        i16 = 0;
                    } else if (j16 <= currentTimeMillis) {
                        currentTimeMillis = j16;
                    }
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong("cbLastReportTime", currentTimeMillis);
                    edit.putLong("cbTotalTime", j19);
                    edit.putInt("cbTotalCount", i3);
                    edit.putInt("cbExceedCount", i16);
                    edit.commit();
                    this.cbLastUpdateSPTime = SystemClock.elapsedRealtime();
                    this.cbIncreaseTime = 0L;
                    this.cbIncreaseCount = 0;
                    this.cbExceedCount = 0;
                }
            }
        } else {
            this.cbLastUpdateSPTime = elapsedRealtime;
        }
        z17 = z16;
        if (z17) {
            currentTimeMillis = System.currentTimeMillis();
            SharedPreferences sharedPreferences2 = this.mApplication.getSharedPreferences("msf_cb_report", 0);
            j16 = sharedPreferences2.getLong("cbLastReportTime", currentTimeMillis);
            long j192 = sharedPreferences2.getLong("cbTotalTime", 0L) + this.cbIncreaseTime;
            int i36 = sharedPreferences2.getInt("cbTotalCount", 0) + this.cbIncreaseCount;
            int i162 = sharedPreferences2.getInt("cbExceedCount", 0) + this.cbExceedCount;
            if (currentTimeMillis - j16 < 86400000) {
            }
            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
            edit2.putLong("cbLastReportTime", currentTimeMillis);
            edit2.putLong("cbTotalTime", j192);
            edit2.putInt("cbTotalCount", i36);
            edit2.putInt("cbExceedCount", i162);
            edit2.commit();
            this.cbLastUpdateSPTime = SystemClock.elapsedRealtime();
            this.cbIncreaseTime = 0L;
            this.cbIncreaseCount = 0;
            this.cbExceedCount = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void sendMessageToMSF(ToServiceMsg toServiceMsg, MSFServlet mSFServlet) {
        if (toServiceMsg.getServiceName() == null) {
            toServiceMsg.setServiceName(this.msfSub.getMsfServiceName());
        }
        this.mRequestServlets.put(Integer.valueOf(toServiceMsg.getAppSeq()), mSFServlet.getClass());
        toServiceMsg.extraData.putLong(RemoteMessageConst.SEND_TIME, System.currentTimeMillis());
        toServiceMsg.extraData.putString("moduleId", mSFServlet.getAppRuntime().getModuleId());
        int sendMsg = this.msfSub.sendMsg(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "[MSF Send]" + toServiceMsg.getServiceCmd() + " appSeq:" + toServiceMsg.getAppSeq() + "  " + mSFServlet.getAppRuntime().getClass().getSimpleName() + "@" + mSFServlet.getAppRuntime().hashCode() + "  from " + mSFServlet.getClass().getSimpleName() + ", res = " + sendMsg);
        }
        IServiceCmdCallback iServiceCmdCallback = sCmdCallback;
        if (iServiceCmdCallback != null) {
            iServiceCmdCallback.onCmdRequest(toServiceMsg.getServiceCmd());
        }
    }

    public void setCustomErrorHandler(IErrorHandler iErrorHandler) {
        this.mCustomErrorHandler = iErrorHandler;
    }

    public void setInterceptKickListener(AppRuntime.InterceptKickListener interceptKickListener) {
        this.mInterceptKickListener = interceptKickListener;
    }

    public void start() {
        startAdvance();
        startCommon();
    }
}
