package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.f0.a;
import com.tencent.mobileqq.msf.core.push.MSFProbeNewManager;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.core.startup.MSFStartupListener;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.report.LogEventReporter;
import com.tencent.qphone.base.util.log.report.LogManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import oicq.wlogin_sdk.request.WtloginHelper;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfCore {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_CHECK_VERSION_TIME = "checkVersionTime";
    private static final String KEY_INIT_ACCOUNT_CENTER_TIME = "initAccountCenterTime";
    private static final String KEY_INIT_BASE_EVENT_MANAGER_TIME = "initBaseEventManagerTime";
    private static final String KEY_INIT_CONFIG_TIME = "initConfigTime";
    private static final String KEY_INIT_DEVICE_INFO_TIME = "initDeviceInfoTime";
    private static final String KEY_INIT_MSF_CORE_TIME = "initMsfCoreTime";
    private static final String KEY_INIT_MSF_STORE_TIME = "initMsfStoreTime";
    private static final String KEY_INIT_NET_INFO_CENTER_TIME = "initNetInfoCenterTime";
    private static final String KEY_INIT_NET_SERVICE_TIME = "initNetServiceTime";
    private static final String KEY_INIT_NT_WTLOGIN_TIME = "initNtWtloginTime";
    private static final String KEY_INIT_PUSH_MANAGER_TIME = "initPushManagerTime";
    private static final String KEY_INIT_WTLOGIN_TIME = "initWtloginTime";
    public static final String KEY_IS_USE_NEW_INIT = "key_isUseNewInit";
    private static final String SAVEPATH_IMEI;
    private static final AtomicBoolean isServiceReady;
    public static int mLocaleId = 0;
    public static MsfCore sCore = null;
    private static final AtomicInteger seqFactory;
    private static final String tag = "MSF.J.MsfCore";
    private static final ConcurrentLinkedQueue<ToServiceMsg> toServiceMsgQueue;
    private com.tencent.mobileqq.msf.core.auth.b accountCenter;
    public boolean bLoadUseTxlib;
    public com.tencent.mobileqq.msf.core.x.b configManager;
    AtomicBoolean coreInitFinished;
    private int installAppVersionCode;
    private final AtomicBoolean isCreatedByAutoBoot;
    private boolean isNewVersion;
    public AtomicBoolean isReconnectSso;
    private boolean isUseNewService;
    private final ConcurrentHashMap<String, String> mMSFCoreInitParams;
    public MsfMonitorCallback mMsfMonitorCallback;
    public AtomicBoolean mbIsInfoLoginGetted;
    private final Object[] mgrLockArray;
    private final com.tencent.mobileqq.msf.core.x.f[] msfConfigs;
    private MsfExitReceiver msfExitReceiver;
    LinkedBlockingQueue<MsfMessagePair> msfMessagePairs;
    private com.tencent.mobileqq.msf.core.f0.a msfNetService;
    private com.tencent.mobileqq.msf.core.push.b msfProbe;
    private final com.tencent.mobileqq.msf.service.l msfServiceReqHandler;
    private com.tencent.mobileqq.msf.service.m msfServiceRespHandler;
    private final ReentrantLock msgQueueLock;
    public com.tencent.mobileqq.msf.core.c0.e netFlowStore;
    public volatile String nowSocketConnAdd;
    public com.tencent.mobileqq.msf.core.auth.h ntWtloginWrapper;
    public com.tencent.mobileqq.msf.core.push.h pushManager;
    private long serviceInitTime;
    private long serviceReadyTime;
    private final u ssoRespHandler;
    com.tencent.mobileqq.msf.core.g0.a standbyModeManager;
    public com.tencent.mobileqq.msf.core.c0.j statReporter;
    private MsfStore store;
    private int storeAppVersionCode;
    AtomicBoolean suspended;
    public SimpleDateFormat timeFormatter;
    private com.tencent.mobileqq.msf.core.h0.c wakeUpLockManager;
    private com.tencent.mobileqq.msf.core.auth.i wtLoginCenter;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements MSFStartupListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfCore.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.startup.MSFStartupListener
        public void onTasksComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MsfCore.this.coreInitFinished.set(true);
            MsfCore.this.serviceReadyTime = SystemClock.elapsedRealtime();
            long j3 = MsfCore.this.serviceReadyTime - MsfCore.this.serviceInitTime;
            QLog.i(MsfCore.tag, 1, "MsfCore init finished. cost=" + j3);
            MsfCore.this.doReportOnInitComplete(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f247297a;

        b(long j3) {
            this.f247297a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MsfCore.this, Long.valueOf(j3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MsfCore.this.initBusinessModule();
                MsfCore.this.doReportOnInitComplete(this.f247297a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f247299a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f247300b;

        c(Context context, int i3) {
            this.f247299a = context;
            this.f247300b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MsfCore.this, context, Integer.valueOf(i3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                com.tencent.mobileqq.msf.core.c.a(this.f247299a, this.f247300b);
                com.tencent.mobileqq.msf.core.c.a(this.f247299a);
            } catch (Exception e16) {
                QLog.e(MsfCore.tag, 1, "storeVersion or copyJniFile error ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements a.InterfaceC8075a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfCore.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.f0.a.InterfaceC8075a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MsfCore.this.setMSFNetServiceReady();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements Runnable {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfCore.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MsfCore.initAppProMsg("*", BaseApplication.getContext().getAppId());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28974);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SAVEPATH_IMEI = BaseApplication.getContext().getFilesDir() + "/imei";
        mLocaleId = 2052;
        isServiceReady = new AtomicBoolean(false);
        toServiceMsgQueue = new ConcurrentLinkedQueue<>();
        seqFactory = new AtomicInteger(new Random().nextInt(100000));
    }

    public MsfCore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.msfServiceReqHandler = new com.tencent.mobileqq.msf.service.l();
        this.mbIsInfoLoginGetted = new AtomicBoolean();
        this.msfMessagePairs = new LinkedBlockingQueue<>();
        this.ssoRespHandler = new u();
        this.isReconnectSso = new AtomicBoolean();
        this.timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
        this.coreInitFinished = new AtomicBoolean();
        this.bLoadUseTxlib = false;
        this.mMsfMonitorCallback = null;
        int i3 = com.tencent.mobileqq.msf.core.x.c.f250228w;
        this.msfConfigs = new com.tencent.mobileqq.msf.core.x.f[i3];
        this.mgrLockArray = new Object[i3];
        this.isNewVersion = false;
        this.storeAppVersionCode = -1;
        this.installAppVersionCode = -1;
        this.serviceInitTime = 0L;
        this.serviceReadyTime = 0L;
        this.msgQueueLock = new ReentrantLock();
        this.mMSFCoreInitParams = new ConcurrentHashMap<>();
        this.isUseNewService = false;
        this.isCreatedByAutoBoot = new AtomicBoolean(false);
        this.suspended = new AtomicBoolean(false);
    }

    private void addConfigManager(int i3, com.tencent.mobileqq.msf.core.x.f fVar) {
        com.tencent.mobileqq.msf.core.x.f[] fVarArr = this.msfConfigs;
        if (fVarArr[i3] == null && fVar != null) {
            fVarArr[i3] = fVar;
        }
    }

    private void checkAccountToken() {
        try {
            this.accountCenter.f247404j.g();
        } catch (Exception e16) {
            QLog.d(tag, 1, e16.toString(), e16);
        }
    }

    private void checkMSFConfig() {
        if (this.isNewVersion) {
            try {
                this.configManager.a(getMainAccount(), 60000);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, e16.toString(), e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doReportOnInitComplete(long j3) {
        reportMsfCoreInit(j3);
        tryReportMSFAlive();
        tryReportSoLoadUseTxlib();
        tryReportJobAlive();
        tryReportLoadCfgTempFile();
    }

    public static String getIMEIPath() {
        return SAVEPATH_IMEI;
    }

    public static void initAppProMsg(String str, int i3) {
        try {
            int uin_reportlog_level = QLog.getUIN_REPORTLOG_LEVEL();
            FromServiceMsg fromServiceMsg = new FromServiceMsg("0", BaseConstants.CMD_PUSHSETCONFIG);
            fromServiceMsg.setAppId(i3);
            fromServiceMsg.setMsfCommand(MsfCommand.pushSetConfig);
            MsfSdkUtils.addFromMsgProcessName(str, fromServiceMsg);
            fromServiceMsg.addAttribute(fromServiceMsg.getServiceCmd(), Integer.valueOf(uin_reportlog_level));
            fromServiceMsg.addAttribute(BaseConstants.Attribute_SOCKET_CONNSTATE, Integer.valueOf(NetConnInfoCenter.socketConnState));
            fromServiceMsg.addAttribute(BaseConstants.Attribute_SERVERTIME, Long.valueOf(NetConnInfoCenter.servetTimeSecondInterv));
            fromServiceMsg.addAttribute(BaseConstants.Attribute_DEVICEGUID, NetConnInfoCenter.GUID);
            fromServiceMsg.addAttribute(BaseConstants.Attribute_RESP_APP_TIMEOUT, Integer.valueOf(com.tencent.mobileqq.msf.core.x.b.i()));
            fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_GATEWAY_IP, MsfService.getCore().getGatewayIp());
            MsfCore core = MsfService.getCore();
            if (core != null) {
                fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_INIT_TIME, Long.valueOf(core.getServiceInitTime()));
                fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_READY_TIME, Long.valueOf(core.getServiceReadyTime()));
            }
            fromServiceMsg.setMsgSuccess();
            com.tencent.mobileqq.msf.service.e.b("*", null, fromServiceMsg);
        } catch (Exception e16) {
            QLog.e(tag, 1, "initAppProMsg error, ", e16);
        }
    }

    private void initLogManager() {
        try {
            LogManager.init();
            LogManager.initLogLevel(BaseApplication.getContext(), true);
            LogEventReporter.checkUnreportEvent(LogEventReporter.EVENT_UPLOAD_LOG);
        } catch (Exception e16) {
            QLog.e(tag, 1, "initLogManager error", e16);
        }
    }

    private void initNetFlowMonitor() {
        NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
        this.netFlowStore = new com.tencent.mobileqq.msf.core.c0.e(sCore, BaseApplication.getContext());
        try {
            BaseApplication.monitor.start();
        } catch (Throwable th5) {
            QLog.d(tag, 1, "", th5);
        }
    }

    private void initStepCounterManager(boolean z16) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            com.tencent.mobileqq.msf.core.stepcount.f.c().a(sCore, z16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, e16.toString(), e16);
            }
        }
        QLog.d(tag, 1, "MsfCore init health step cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    public static boolean isIpv6() {
        MsfCore msfCore = sCore;
        if (msfCore == null || msfCore.getConnectedIPFamily() != 2) {
            return false;
        }
        return true;
    }

    private void reportMsfCoreInit(long j3) {
        boolean z16;
        if (this.statReporter == null) {
            return;
        }
        this.mMSFCoreInitParams.put(KEY_INIT_MSF_CORE_TIME, String.valueOf(j3));
        this.mMSFCoreInitParams.put(KEY_IS_USE_NEW_INIT, String.valueOf(com.tencent.mobileqq.msf.core.x.m.d()));
        HashMap hashMap = new HashMap(this.mMSFCoreInitParams);
        com.tencent.mobileqq.msf.core.c0.j jVar = this.statReporter;
        if (j3 <= 2000) {
            z16 = true;
        } else {
            z16 = false;
        }
        jVar.a("msfInitCost", z16, j3, 0L, (Map<String, String>) hashMap, false, false);
    }

    private void sendAllMsg() {
        while (true) {
            ToServiceMsg poll = toServiceMsgQueue.poll();
            if (poll == null) {
                return;
            }
            try {
                QLog.d(tag, 1, "ResendMsg: " + com.tencent.mobileqq.msf.core.z.a.b(poll));
                this.msfNetService.a(poll);
            } catch (Exception unused) {
                FromServiceMsg a16 = o.a(poll);
                a16.setBusinessFail(1001, "MSF Send Message fail");
                addRespToQuque(poll, a16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMSFNetServiceReady() {
        this.msgQueueLock.lock();
        try {
            try {
                isServiceReady.set(true);
                QLog.d(tag, 1, "onServiceReady, sendAllMsg begin");
                sendAllMsg();
            } catch (Exception e16) {
                QLog.e(tag, 1, "sendAllMsg error", e16);
            }
        } finally {
            this.msgQueueLock.unlock();
        }
    }

    private boolean tryInitMsfStore() {
        try {
            MsfStore msfStore = new MsfStore();
            this.store = msfStore;
            if (msfStore.init(BaseApplication.getContext())) {
                return true;
            }
            QLog.e(tag, 1, "MsfStore init fail");
            return false;
        } catch (Exception e16) {
            QLog.e(tag, 1, "MsfStore init error " + e16);
            return false;
        }
    }

    private void tryReportJobAlive() {
        if (com.tencent.mobileqq.msf.service.j.f250933h) {
            QLog.d(tag, 1, "MSF_Alive_Log do report JobScheduler alive MSF to beacon in msfcore init");
            com.tencent.mobileqq.msf.service.j.a(true);
        }
    }

    private void tryReportLoadCfgTempFile() {
        this.store.reportLoadCfgTempFile();
    }

    private void tryReportMSFAlive() {
        if (com.tencent.mobileqq.msf.service.k.f250960i) {
            QLog.d(tag, 1, "MSF_Alive_REPORT_Log do report MSF alive to bigT in msfcore init");
            com.tencent.mobileqq.msf.service.k.a((Handler) null);
        }
    }

    private void tryReportSoLoadUseTxlib() {
        String e16;
        if (this.bLoadUseTxlib) {
            HashMap hashMap = new HashMap();
            hashMap.put("bLoadUseTxlib", String.valueOf(this.bLoadUseTxlib));
            hashMap.put("newVersion", String.valueOf(this.installAppVersionCode));
            hashMap.put("oldVersion", String.valueOf(this.storeAppVersionCode));
            if (o.e() == null) {
                e16 = "null";
            } else {
                e16 = o.e();
            }
            hashMap.put("imei", e16);
            hashMap.put("product", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
            hashMap.put("uin", String.valueOf(sCore.getAccountCenter().e()));
            hashMap.put("platform", com.tencent.mobileqq.msf.core.c.h(BaseApplication.getContext()));
            com.tencent.mobileqq.msf.core.c0.j jVar = this.statReporter;
            if (jVar != null) {
                jVar.a(com.tencent.mobileqq.msf.core.c0.g.D2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        }
    }

    public int ChangeUinLogin(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this, (Object) toServiceMsg)).intValue();
        }
        toServiceMsg.getAttributes().put(com.tencent.mobileqq.msf.core.auth.b.f247387r, Boolean.TRUE);
        if (isUseWtlogin()) {
            return this.wtLoginCenter.a(toServiceMsg, true);
        }
        return this.accountCenter.b(toServiceMsg);
    }

    public void addRespToQuque(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            addRespToQuque(null, toServiceMsg, fromServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    public int changeTokenAfterLogin(ToServiceMsg toServiceMsg, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, this, toServiceMsg, Boolean.valueOf(z16), str)).intValue();
        }
        if (isUseWtlogin()) {
            return this.wtLoginCenter.a(toServiceMsg, z16, str);
        }
        return this.accountCenter.a(toServiceMsg, z16);
    }

    public void checkAppVersionCode(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            this.storeAppVersionCode = com.tencent.mobileqq.msf.core.c.j(BaseApplication.getContext());
            int c16 = com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext());
            this.installAppVersionCode = c16;
            int i3 = this.storeAppVersionCode;
            if (i3 == -1 || c16 == -1 || c16 != i3) {
                this.isNewVersion = true;
            }
        } catch (Exception e16) {
            QLog.e(tag, 1, "checkAppVersionCode error " + e16, e16);
            this.isNewVersion = true;
        }
        if (this.isNewVersion) {
            q.s().post(new c(context, this.installAppVersionCode));
        }
        com.tencent.mobileqq.msf.service.j.P = this.isNewVersion;
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.mMSFCoreInitParams.put(KEY_CHECK_VERSION_TIME, String.valueOf(elapsedRealtime2));
        QLog.d(tag, 1, "checkAppVersionCode cost=" + elapsedRealtime2);
    }

    public void closeConn(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            iPatchRedirector.redirect((short) 121, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.mobileqq.msf.core.f0.a aVar2 = this.msfNetService;
        if (aVar2 == null) {
            QLog.e(tag, 1, "invoke closeConn before MSFNetService init");
        } else {
            aVar2.a(aVar);
        }
    }

    public com.tencent.mobileqq.msf.core.auth.b getAccountCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (com.tencent.mobileqq.msf.core.auth.b) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        return this.accountCenter;
    }

    public com.tencent.mobileqq.msf.core.x.f getConfigManager(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (com.tencent.mobileqq.msf.core.x.f) iPatchRedirector.redirect((short) 71, (Object) this, i3);
        }
        if (i3 >= 0) {
            com.tencent.mobileqq.msf.core.x.f[] fVarArr = this.msfConfigs;
            if (i3 < fVarArr.length) {
                com.tencent.mobileqq.msf.core.x.f fVar = fVarArr[i3];
                if (fVar == null) {
                    Object[] objArr = this.mgrLockArray;
                    if (objArr[objArr.length - 1] == null) {
                        synchronized (objArr) {
                            Object[] objArr2 = this.mgrLockArray;
                            if (objArr2[objArr2.length - 1] == null) {
                                int i16 = 0;
                                while (true) {
                                    Object[] objArr3 = this.mgrLockArray;
                                    if (i16 >= objArr3.length) {
                                        break;
                                    }
                                    objArr3[i16] = new Object();
                                    i16++;
                                }
                            }
                        }
                    }
                    synchronized (this.mgrLockArray[i3]) {
                        fVar = this.msfConfigs[i3];
                        if (fVar == null) {
                            fVar = com.tencent.mobileqq.msf.core.x.c.a(i3);
                            addConfigManager(i3, fVar);
                        }
                    }
                }
                return fVar;
            }
        }
        QLog.e(tag, 1, "getConfigManager with error ID: " + i3);
        return null;
    }

    public long getConnSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            return ((Long) iPatchRedirector.redirect((short) 123, (Object) this)).longValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke getConnSeq before MSFNetService init");
            return -1L;
        }
        return aVar.l();
    }

    public int getConnectedIPFamily() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            return ((Integer) iPatchRedirector.redirect((short) 125, (Object) this)).intValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke getConnectedIPFamily before MSFNetService init");
            return 0;
        }
        return aVar.a();
    }

    public int getConnectedNetType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            return ((Integer) iPatchRedirector.redirect((short) 124, (Object) this)).intValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke getConnectedNetType before MSFNetService init");
            return 0;
        }
        return aVar.d();
    }

    public String getGatewayIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            return (String) iPatchRedirector.redirect((short) 127, (Object) this);
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke getGatewayIp before MSFNetService init");
            return "";
        }
        return aVar.g();
    }

    public String getMainAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return (String) iPatchRedirector.redirect((short) 115, (Object) this);
        }
        com.tencent.mobileqq.msf.core.auth.b bVar = this.accountCenter;
        if (bVar != null) {
            return bVar.e();
        }
        return "0";
    }

    public LinkedBlockingQueue<MsfMessagePair> getMsfMessagePairs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (LinkedBlockingQueue) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.msfMessagePairs;
    }

    public com.tencent.mobileqq.msf.core.f0.a getMsfNetService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (com.tencent.mobileqq.msf.core.f0.a) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.msfNetService;
    }

    public com.tencent.mobileqq.msf.core.push.b getMsfProbeManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (com.tencent.mobileqq.msf.core.push.b) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        return this.msfProbe;
    }

    public com.tencent.mobileqq.msf.service.l getMsfServiceReqHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.msf.service.l) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msfServiceReqHandler;
    }

    public com.tencent.mobileqq.msf.service.m getMsfServiceRespHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.msf.service.m) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.msfServiceRespHandler;
    }

    public com.tencent.mobileqq.msf.core.c0.e getNetFlowStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (com.tencent.mobileqq.msf.core.c0.e) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.netFlowStore;
    }

    public HandlerThread getNetworkHandlerThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 112, (Object) this);
        }
        return q.n();
    }

    public synchronized int getNextSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Integer) iPatchRedirector.redirect((short) 58, (Object) this)).intValue();
        }
        AtomicInteger atomicInteger = seqFactory;
        int incrementAndGet = atomicInteger.incrementAndGet();
        if (incrementAndGet > 1000000) {
            atomicInteger.set(new Random().nextInt(100000) + 60000);
        }
        return incrementAndGet;
    }

    public String getNowUsedSsoAddress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            return (String) iPatchRedirector.redirect((short) 126, (Object) this);
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke getNowUsedSsoAddress before MSFNetService init");
            return "";
        }
        return aVar.c();
    }

    public void getPluginConfig(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) toServiceMsg);
        } else {
            this.configManager.b(toServiceMsg);
        }
    }

    public com.tencent.mobileqq.msf.core.push.h getPushManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (com.tencent.mobileqq.msf.core.push.h) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return this.pushManager;
    }

    public long getServiceInitTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.serviceInitTime;
    }

    public long getServiceReadyTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.serviceReadyTime;
    }

    public SharedPreferences getSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 113, (Object) this, (Object) str, i3);
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !com.tencent.mobileqq.msf.core.x.i.a().c()) {
            return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
        }
        return com.tencent.mobileqq.msf.core.b0.a.b().b(str, i3);
    }

    public u getSsoRespHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (u) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return this.ssoRespHandler;
    }

    public com.tencent.mobileqq.msf.core.g0.a getStandByModeManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            return (com.tencent.mobileqq.msf.core.g0.a) iPatchRedirector.redirect((short) 110, (Object) this);
        }
        return this.standbyModeManager;
    }

    public com.tencent.mobileqq.msf.core.c0.j getStatReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (com.tencent.mobileqq.msf.core.c0.j) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        return this.statReporter;
    }

    public long getUinPushExtStatus(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Long) iPatchRedirector.redirect((short) 56, (Object) this, (Object) str)).longValue();
        }
        return this.pushManager.a(str);
    }

    public int getUinPushStatus(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this, (Object) str)).intValue();
        }
        return this.pushManager.b(str);
    }

    public com.tencent.mobileqq.msf.core.h0.c getWakeUpLockManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.msf.core.h0.c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.wakeUpLockManager;
    }

    public com.tencent.mobileqq.msf.core.auth.i getWtLoginCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (com.tencent.mobileqq.msf.core.auth.i) iPatchRedirector.redirect((short) 73, (Object) this);
        }
        return this.wtLoginCenter;
    }

    public void handleAccountSyncRequest(Context context, ToServiceMsg toServiceMsg, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, context, toServiceMsg, Integer.valueOf(i3));
        } else {
            this.accountCenter.f247399e.a(toServiceMsg, context.getPackageManager().getPackagesForUid(i3), context.getPackageName(), i3);
        }
    }

    public String handleGetAccountKey(Context context, ToServiceMsg toServiceMsg, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (String) iPatchRedirector.redirect((short) 69, this, context, toServiceMsg, Integer.valueOf(i3));
        }
        Signature[] a16 = com.tencent.mobileqq.msf.core.auth.c.a(BaseApplication.getContext().getPackageManager(), new String[]{BaseApplication.getContext().getPackageName()});
        if (a16 != null) {
            int length = a16.length;
            String[] strArr = new String[length];
            for (int i16 = 0; i16 < length; i16++) {
                strArr[i16] = MD5.toMD5(a16[i16].toCharsString()).toLowerCase();
            }
            Signature[] a17 = com.tencent.mobileqq.msf.core.auth.c.a(BaseApplication.getContext().getPackageManager(), i3);
            if (a17 != null) {
                boolean z17 = false;
                for (Signature signature : a17) {
                    String lowerCase = MD5.toMD5(signature.toCharsString()).toLowerCase();
                    int i17 = 0;
                    while (true) {
                        if (i17 >= length) {
                            break;
                        }
                        if (strArr[i17].equals(lowerCase)) {
                            z17 = true;
                            break;
                        }
                        i17++;
                    }
                    if (z17) {
                        break;
                    }
                }
                z16 = z17;
            }
            if (z16) {
                return this.accountCenter.b();
            }
            return "";
        }
        return "";
    }

    public boolean hasIPV6List() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            return ((Boolean) iPatchRedirector.redirect((short) 133, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke hasIPV6List before MSFNetService init");
            return false;
        }
        return aVar.e();
    }

    public boolean init(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, context, Boolean.valueOf(z16))).booleanValue();
        }
        QLog.d(tag, 1, "MsfCore init begin. isPublic=" + BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() + " isGray=" + BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() + "\uff0cappVersion=" + BaseApplication.getContext().getPublishVersion());
        this.serviceInitTime = SystemClock.elapsedRealtime();
        sCore = this;
        this.mbIsInfoLoginGetted.set(false);
        this.isCreatedByAutoBoot.set(z16);
        initStateReporter();
        checkAppVersionCode(context);
        initMSFDeviceInfo();
        initBaseEventManager();
        if (!initMSFStore()) {
            return false;
        }
        initWtlogin();
        initAccountCenter();
        initNtWtlogin();
        initMSFConfig();
        initNetConnInfoCenter();
        initTestEnvManager(context);
        if (!initNetworkService(context)) {
            return false;
        }
        initPushManager(context);
        initAppProcessManager(context);
        initMSFServiceRespHandler();
        this.coreInitFinished.set(true);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.serviceReadyTime = elapsedRealtime;
        long j3 = elapsedRealtime - this.serviceInitTime;
        QLog.i(tag, 1, "MsfCore init finished. cost=" + j3);
        q.q().post(new b(j3));
        return true;
    }

    public void initAccountCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.mobileqq.msf.core.auth.b bVar = new com.tencent.mobileqq.msf.core.auth.b(this);
        this.accountCenter = bVar;
        bVar.a(true);
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.mMSFCoreInitParams.put(KEY_INIT_ACCOUNT_CENTER_TIME, String.valueOf(elapsedRealtime2));
        QLog.d(tag, 2, "init accountCenter cost=" + elapsedRealtime2);
    }

    public void initAppProcessManager(Context context) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) context);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            com.tencent.mobileqq.msf.service.e.a(context, this);
            j3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        } catch (Exception e16) {
            QLog.e(tag, 1, "AppProcessManager init failed " + e16);
            j3 = -1;
        }
        QLog.d(tag, 1, "init AppProcessManager cost=" + j3);
    }

    public void initBaseEventManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.mobileqq.msf.core.y.a.h().f();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.mMSFCoreInitParams.put(KEY_INIT_BASE_EVENT_MANAGER_TIME, String.valueOf(elapsedRealtime2));
        QLog.d(tag, 1, "init BaseEventManager cost=" + elapsedRealtime2);
    }

    public void initBusinessModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        this.standbyModeManager = new com.tencent.mobileqq.msf.core.g0.a(this);
        this.msfExitReceiver = new MsfExitReceiver();
        checkMSFConfig();
        checkAccountToken();
        initLogManager();
        initNetFlowMonitor();
        initStepCounterManager(isCreatedByAutoBoot());
    }

    public void initMSFConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            com.tencent.mobileqq.msf.core.x.b bVar = new com.tencent.mobileqq.msf.core.x.b(this);
            this.configManager = bVar;
            bVar.Y0();
            com.tencent.mobileqq.msf.core.x.o.x().l();
            this.statReporter.m();
        } catch (Exception e16) {
            QLog.e(tag, 1, "configManager init failed ", e16);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.mMSFCoreInitParams.put(KEY_INIT_CONFIG_TIME, String.valueOf(elapsedRealtime2));
        QLog.d(tag, 1, "init config cost=" + elapsedRealtime2);
    }

    public void initMSFDeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        o.p();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.mMSFCoreInitParams.put(KEY_INIT_DEVICE_INFO_TIME, String.valueOf(elapsedRealtime2));
        QLog.d(tag, 1, "init deviceInfo cost=" + elapsedRealtime2);
    }

    public void initMSFServiceRespHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.mobileqq.msf.service.m mVar = new com.tencent.mobileqq.msf.service.m(this);
        this.msfServiceRespHandler = mVar;
        mVar.setName("MsfServiceRespHandler");
        this.msfServiceRespHandler.start();
        QLog.d(tag, 1, "init MsfServiceRespHandler cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    public boolean initMSFStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (tryInitMsfStore()) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            this.mMSFCoreInitParams.put(KEY_INIT_MSF_STORE_TIME, String.valueOf(elapsedRealtime2));
            QLog.d(tag, 1, "init msfStore cost=" + elapsedRealtime2);
            return true;
        }
        QLog.d(tag, 1, "init msfStore return false");
        return false;
    }

    public void initNetConnInfoCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            NetConnInfoCenter.init(this);
        } catch (Exception e16) {
            QLog.e(tag, 1, "MsfCore init netConnInfoCenter error ", e16);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.mMSFCoreInitParams.put(KEY_INIT_NET_INFO_CENTER_TIME, String.valueOf(elapsedRealtime2));
        QLog.d(tag, 1, "init network center cost=" + elapsedRealtime2);
    }

    public boolean initNetworkService(Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) context)).booleanValue();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            com.tencent.mobileqq.msf.core.f0.a a16 = com.tencent.mobileqq.msf.core.f0.b.a(this, com.tencent.mobileqq.msf.core.x.m.e());
            setMSFNetService(a16);
            z16 = a16.a(context, new d());
        } catch (Exception e16) {
            QLog.e(tag, 1, "MSFNetService init failed " + e16);
            z16 = false;
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.mMSFCoreInitParams.put(KEY_INIT_NET_SERVICE_TIME, String.valueOf(elapsedRealtime2));
        QLog.d(tag, 1, "init MSFNetService Cost=" + elapsedRealtime2 + ", isUseNewService = " + this.isUseNewService + ", result:" + z16);
        return z16;
    }

    public void initNtWtlogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (BaseApplication.getContext() != null && BaseApplication.getContext().getMSFInterfaceAdapter().useNtWtLogin()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.tencent.mobileqq.msf.core.auth.h hVar = new com.tencent.mobileqq.msf.core.auth.h();
            this.ntWtloginWrapper = hVar;
            hVar.a(this);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            this.mMSFCoreInitParams.put(KEY_INIT_NT_WTLOGIN_TIME, String.valueOf(elapsedRealtime2));
            QLog.d(tag, 1, "init NtWtloginCenter cost=" + elapsedRealtime2);
        }
    }

    public void initPushManager(Context context) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) context);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            com.tencent.mobileqq.msf.core.push.h hVar = new com.tencent.mobileqq.msf.core.push.h(this);
            this.pushManager = hVar;
            hVar.a(context, isCreatedByAutoBoot());
            if (com.tencent.mobileqq.msf.core.x.d.i0().booleanValue()) {
                this.msfProbe = new MSFProbeNewManager(this);
            } else {
                this.msfProbe = new com.tencent.mobileqq.msf.core.push.e(this);
            }
            j3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        } catch (Exception e16) {
            QLog.e(tag, 1, "PushManager init failed " + e16);
            j3 = -1;
        }
        this.mMSFCoreInitParams.put(KEY_INIT_PUSH_MANAGER_TIME, String.valueOf(j3));
        QLog.d(tag, 1, "init PushManager cost=" + j3);
    }

    public void initStateReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.statReporter = new com.tencent.mobileqq.msf.core.c0.j(this);
        QLog.d(tag, 1, "init StatReporter cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    public void initTestEnvManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.mobileqq.msf.core.e0.k.c().a(context);
        QLog.d(tag, 1, "init Test Env cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    public void initWtlogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.mobileqq.msf.core.auth.i iVar = new com.tencent.mobileqq.msf.core.auth.i();
        this.wtLoginCenter = iVar;
        iVar.a(this);
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        this.mMSFCoreInitParams.put(KEY_INIT_WTLOGIN_TIME, String.valueOf(elapsedRealtime2));
        QLog.d(tag, 1, "init wtlogin cost=" + elapsedRealtime2);
    }

    public void injectSigToMsf(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.j(toServiceMsg);
        }
    }

    public boolean isConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            return ((Boolean) iPatchRedirector.redirect((short) 122, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke isConnected before MSFNetService init");
            return false;
        }
        return aVar.b();
    }

    public boolean isCreatedByAutoBoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isCreatedByAutoBoot.get();
    }

    public boolean isFirstMsgReceived() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            return ((Boolean) iPatchRedirector.redirect((short) 134, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke isFirstMsgReceived before MSFNetService init");
            return false;
        }
        return aVar.j();
    }

    public boolean isOffline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.auth.b bVar = this.accountCenter;
        if (bVar != null) {
            return "0".equals(bVar.e());
        }
        return true;
    }

    public boolean isSubSenderEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            return ((Boolean) iPatchRedirector.redirect((short) 132, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke isSubSenderEnable before MSFNetService init");
            return false;
        }
        return aVar.i();
    }

    public boolean isSupportNewSSO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            return ((Boolean) iPatchRedirector.redirect((short) 131, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke isSupportNewSSO before MSFNetService init");
            return false;
        }
        return aVar.m();
    }

    public boolean isSuspended() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return ((Boolean) iPatchRedirector.redirect((short) 68, (Object) this)).booleanValue();
        }
        return this.suspended.get();
    }

    public boolean isUseNewService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isUseNewService;
    }

    public boolean isUseWtlogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.msf.core.x.b.n1();
    }

    public boolean isWeakNet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            return ((Boolean) iPatchRedirector.redirect((short) 130, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke isWeakNet before MSFNetService init");
            return false;
        }
        return aVar.k();
    }

    public int login(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) ? login(toServiceMsg, 16, 0, new byte[0]) : ((Integer) iPatchRedirector.redirect((short) 35, (Object) this, (Object) toServiceMsg)).intValue();
    }

    public boolean newServiceInit(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, context, Boolean.valueOf(z16))).booleanValue();
        }
        QLog.d(tag, 1, "MsfCore init begin. isPublic=" + BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() + "\uff0cisGray=" + BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() + "\uff0cbBoot=" + z16 + "\uff0cappVersion=" + BaseApplication.getContext().getPublishVersion());
        this.serviceInitTime = SystemClock.elapsedRealtime();
        sCore = this;
        this.mbIsInfoLoginGetted.set(false);
        this.isCreatedByAutoBoot.set(z16);
        BaseApplication.getContext().getMSFInterfaceAdapter().onServiceInit(context, new a());
        return true;
    }

    public void proxyRegister(com.tencent.mobileqq.msf.sdk.n nVar, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) nVar, (Object) toServiceMsg);
        } else {
            this.pushManager.a(nVar, toServiceMsg);
        }
    }

    public void proxyUnRegister(String str, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str, (Object) toServiceMsg);
        } else {
            this.pushManager.a(str, toServiceMsg);
        }
    }

    public void reSendMsg(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) toServiceMsg);
        } else {
            this.msfNetService.a(toServiceMsg);
        }
    }

    public int refreVerifycode(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (isUseWtlogin()) {
            return this.wtLoginCenter.k(toServiceMsg);
        }
        return this.accountCenter.a(toServiceMsg);
    }

    public void refreshDA2(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.l(toServiceMsg);
        }
    }

    public void refreshWebviewTickets(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this, (Object) str, (Object) str2);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("", str, BaseConstants.CMD_CHANGETOKEN_WEBVIEW_KEY);
        toServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
        toServiceMsg.setRequestSsoSeq(getNextSeq());
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_REFRESH_TICKET_SRC, str2);
        changeTokenAfterLogin(toServiceMsg, true, "refreshWebviewTickets");
    }

    public void registerCmdCall(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) toServiceMsg);
        } else {
            this.pushManager.a(com.tencent.mobileqq.msf.sdk.o.a(toServiceMsg), toServiceMsg);
        }
    }

    public void registerPush(ToServiceMsg toServiceMsg, RegPushReason regPushReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) toServiceMsg, (Object) regPushReason);
            return;
        }
        if (this.accountCenter != null && !TextUtils.isEmpty(toServiceMsg.getUin())) {
            this.accountCenter.d(toServiceMsg.getUin(), "regPush");
        }
        this.pushManager.a(toServiceMsg, regPushReason);
    }

    public void removeAccountKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke removeAccountKey before MSFNetService init");
        } else {
            aVar.a(str);
        }
    }

    public int report(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this, (Object) toServiceMsg)).intValue();
        }
        return this.configManager.a(toServiceMsg);
    }

    public void reportDeadObjException(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            iPatchRedirector.redirect((short) 116, this, str, str2, str3, str4);
            return;
        }
        com.tencent.mobileqq.msf.core.c0.j jVar = this.statReporter;
        if (jVar != null) {
            jVar.a(str, str2, str3, str4);
        }
    }

    public void reportRDM(String str, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), map, Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        com.tencent.mobileqq.msf.core.c0.j jVar = this.statReporter;
        if (jVar != null) {
            jVar.a(str, z16, j3, j16, map, z17, z18);
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
        } else {
            this.suspended.set(false);
        }
    }

    public void sendMSFPingCheck(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            iPatchRedirector.redirect((short) 135, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke sendMSFPingProbe before MSFNetService init");
        } else {
            aVar.a(i3);
        }
    }

    public void sendMsgSignal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, (Object) this);
        } else {
            sendSsoMsg(MsfMsgUtil.getSignalMsg());
        }
    }

    public int sendSsoMsg(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            return ((Integer) iPatchRedirector.redirect((short) 118, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (this.msfNetService == null || !isServiceReady.get()) {
            this.msgQueueLock.lock();
            try {
                if (this.msfNetService == null || !isServiceReady.get()) {
                    ConcurrentLinkedQueue<ToServiceMsg> concurrentLinkedQueue = toServiceMsgQueue;
                    concurrentLinkedQueue.add(toServiceMsg);
                    QLog.d(tag, 1, "send Msg before MSFNetService ready, add to queue(" + concurrentLinkedQueue.size() + "), Msg: " + com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
                    return toServiceMsg.getRequestSsoSeq();
                }
            } finally {
                this.msgQueueLock.unlock();
            }
        }
        return this.msfNetService.a(toServiceMsg);
    }

    public void setAccountKey(String str, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            iPatchRedirector.redirect((short) 119, this, str, Integer.valueOf(i3), bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, str2);
            return;
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke setAccountKey before MSFNetService init");
        } else {
            aVar.a(str, i3, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, str2);
        }
    }

    public void setGatewayIp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            iPatchRedirector.redirect((short) 128, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke setGatewayIp before MSFNetService init");
            return;
        }
        aVar.b(str);
        NetConnInfoCenter.setGateWayIp(str);
        q.s().post(new e());
    }

    public void setGatewayPort(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            iPatchRedirector.redirect((short) 129, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar == null) {
            QLog.e(tag, 1, "invoke setGatewayPort before MSFNetService init");
        } else {
            aVar.b(i3);
        }
    }

    public void setMSFNetService(com.tencent.mobileqq.msf.core.f0.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            this.isUseNewService = aVar instanceof com.tencent.mobileqq.msf.core.f0.c.b;
            this.msfNetService = aVar;
        }
    }

    public void setMsfMonitorCallback(MsfMonitorCallback msfMonitorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            iPatchRedirector.redirect((short) 111, (Object) this, (Object) msfMonitorCallback);
        } else {
            this.mMsfMonitorCallback = msfMonitorCallback;
        }
    }

    public int submitPuzzleVerifyCodeTicket(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Integer) iPatchRedirector.redirect((short) 46, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (isUseWtlogin()) {
            return this.wtLoginCenter.m(toServiceMsg);
        }
        return -1;
    }

    public int submitVerifycode(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (isUseWtlogin()) {
            return this.wtLoginCenter.n(toServiceMsg);
        }
        return this.accountCenter.c(toServiceMsg);
    }

    public void suspend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this);
        } else {
            this.suspended.set(true);
        }
    }

    public boolean syncDelAccount(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        String str = (String) toServiceMsg.getAttribute(toServiceMsg.getServiceCmd());
        String str2 = (String) toServiceMsg.getAttribute("delAlias");
        QLog.d(tag, 1, "syncDelAccount delUin = " + str + ", alias = " + str2);
        this.accountCenter.b(str, str2);
        return true;
    }

    public ArrayList<SimpleAccount> syncGetLoginedAccountList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (ArrayList) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return this.accountCenter.i();
    }

    public String syncGetServerConfig(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this, (Object) toServiceMsg);
        }
        return this.configManager.c(toServiceMsg);
    }

    public void triggerNetServiceToConnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            iPatchRedirector.redirect((short) 117, (Object) this);
            return;
        }
        com.tencent.mobileqq.msf.core.f0.a aVar = this.msfNetService;
        if (aVar instanceof com.tencent.mobileqq.msf.core.f0.d.a) {
            ToServiceMsg connOpenMsg = MsfMsgUtil.getConnOpenMsg("");
            MsfSdkUtils.addToMsgProcessName("", connOpenMsg);
            sendSsoMsg(connOpenMsg);
        } else if (aVar instanceof com.tencent.mobileqq.msf.core.f0.c.b) {
            ((com.tencent.mobileqq.msf.core.f0.c.b) aVar).A();
        }
    }

    public void unRegisterCmdCall(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) toServiceMsg);
        } else {
            this.pushManager.b(com.tencent.mobileqq.msf.sdk.o.a(toServiceMsg), toServiceMsg);
        }
    }

    public void unRegisterPush(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) toServiceMsg);
        } else {
            this.pushManager.a(com.tencent.mobileqq.msf.sdk.o.d(toServiceMsg), toServiceMsg);
        }
    }

    public void updateBatteryStatus(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) toServiceMsg);
        } else {
            this.pushManager.a(toServiceMsg);
        }
    }

    public void verifyPasswd(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.o(toServiceMsg);
        }
    }

    public void verifyPasswdImage(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.p(toServiceMsg);
        }
    }

    public void verifyPasswdRefreshImage(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.q(toServiceMsg);
        }
    }

    public void wt_AskDevLockSms(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.r(toServiceMsg);
        }
    }

    public void wt_CancelCode(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.s(toServiceMsg);
        }
    }

    public void wt_CheckDevLockSms(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.t(toServiceMsg);
        }
    }

    public void wt_CheckDevLockStatus(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.u(toServiceMsg);
        }
    }

    public void wt_CheckPictureAndGetSt(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.v(toServiceMsg);
        }
    }

    public void wt_CheckSMSAndGetSt(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.w(toServiceMsg);
        }
    }

    public void wt_CheckSMSAndGetStExt(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.x(toServiceMsg);
        }
    }

    public void wt_CheckSMSVerifyLoginAccount(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.y(toServiceMsg);
        }
    }

    public void wt_CloseCode(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.z(toServiceMsg);
        }
    }

    public void wt_CloseDevLock(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.A(toServiceMsg);
        }
    }

    public void wt_GetA1WithA1(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.B(toServiceMsg);
        }
    }

    public void wt_GetOpenKeyWithoutPasswd(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.C(toServiceMsg);
        }
    }

    public void wt_GetSaltUinList(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.D(toServiceMsg);
        }
    }

    public void wt_GetStByPhoneAndPassword(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.E(toServiceMsg);
        }
    }

    public void wt_GetStViaGatewayLogin(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.F(toServiceMsg);
        }
    }

    public void wt_GetStViaSMSVerifyLogin(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.G(toServiceMsg);
        }
    }

    public void wt_GetStWithPasswd(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.H(toServiceMsg);
        }
    }

    public void wt_GetStWithoutPasswd(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.I(toServiceMsg);
        }
    }

    public void wt_GetUIDWithoutPasswd(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.J(toServiceMsg);
        }
    }

    public void wt_QuickLoginByGateway(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.K(toServiceMsg);
        }
    }

    public void wt_RefreshPictureData(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.L(toServiceMsg);
        }
    }

    public void wt_RefreshSMSData(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.M(toServiceMsg);
        }
    }

    public void wt_RefreshSMSVerifyLoginCode(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.N(toServiceMsg);
        }
    }

    public void wt_RegGetSMSVerifyLoginAccount(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.O(toServiceMsg);
        }
    }

    public void wt_SetDevlockMobileType(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.P(toServiceMsg);
        }
    }

    public void wt_VerifyCode(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.Q(toServiceMsg);
        }
    }

    public void wt_VerifySMSVerifyLoginCode(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.R(toServiceMsg);
        }
    }

    public void wt_check_sig(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.h(toServiceMsg);
        }
    }

    public void wt_getStViaWxLogin(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.S(toServiceMsg);
        }
    }

    public void wt_loginByWx(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.T(toServiceMsg);
        }
    }

    public void wt_refreshMemorySig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this);
            return;
        }
        WtloginHelper wtloginHelper = com.tencent.mobileqq.msf.core.auth.i.f247480n;
        if (wtloginHelper != null) {
            wtloginHelper.RefreshMemorySig();
        }
    }

    public void wt_setRegDevLockFlag(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this, (Object) toServiceMsg);
        } else {
            this.wtLoginCenter.U(toServiceMsg);
        }
    }

    public void addRespToQuque(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, toServiceMsg, fromServiceMsg);
            return;
        }
        if (toServiceMsg != null) {
            if (fromServiceMsg.isSuccess()) {
                if (toServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin || toServiceMsg.getMsfCommand() == MsfCommand.loginAuth || toServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaGatewayLogin || toServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin) {
                    long currentTimeMillis = System.currentTimeMillis() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE)).longValue();
                    long a16 = com.tencent.mobileqq.msf.core.c0.j.a(toServiceMsg, fromServiceMsg);
                    if (getStatReporter() != null) {
                        getStatReporter().a(true, currentTimeMillis, fromServiceMsg.getBusinessFailCode(), a16, fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH), 0L);
                    }
                    if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH)) {
                        toServiceMsg.setUin((String) fromServiceMsg.getAttribute(fromServiceMsg.getServiceCmd()));
                        byte[] bArr = new byte[0];
                        if (fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SIGSESSION) != null) {
                            bArr = (byte[]) fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SIGSESSION);
                        }
                        toServiceMsg.setRequestSsoSeq(getNextSeq());
                        toServiceMsg.setServiceCmd(BaseConstants.CMD_LOGIN_AUTH);
                        this.accountCenter.a(toServiceMsg, 16, 0, bArr);
                        return;
                    }
                }
            } else if (fromServiceMsg.getResultCode() == 1012) {
                try {
                    if (toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_LOGIN_ALSOCHECKTIME) == null) {
                        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_LOGIN_ALSOCHECKTIME, 1);
                        if (toServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) {
                            ChangeUinLogin(toServiceMsg);
                            return;
                        } else if (toServiceMsg.getMsfCommand() == MsfCommand.loginAuth) {
                            login(toServiceMsg);
                            return;
                        } else if (toServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin) {
                            wt_GetStViaSMSVerifyLogin(toServiceMsg);
                            return;
                        }
                    }
                } catch (Exception e16) {
                    QLog.d(tag, 1, "addRespToQuque process code client time error failed " + e16.toString());
                }
            } else if (toServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin && toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_APP2MSF)) {
                long currentTimeMillis2 = toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_ADDSENDQUEUE) ? System.currentTimeMillis() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE)).longValue() : -1L;
                long a17 = com.tencent.mobileqq.msf.core.c0.j.a(toServiceMsg, fromServiceMsg);
                boolean equals = fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_LOGIN_CHANGEUIN_AUTH);
                if (fromServiceMsg.getBusinessFailCode() == 1002) {
                    if (toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_MSF2NET)) {
                        long longValue = toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_ADDSENDQUEUE) ? ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE)).longValue() : 0L;
                        if (getStatReporter() != null) {
                            getStatReporter().a(false, currentTimeMillis2, 1014, a17, equals, longValue);
                        }
                    } else if (getStatReporter() != null) {
                        getStatReporter().a(false, currentTimeMillis2, fromServiceMsg.getBusinessFailCode(), a17, equals, 0L);
                    }
                } else if (fromServiceMsg.getBusinessFailCode() == 2008) {
                    if (getStatReporter() != null) {
                        getStatReporter().a(toServiceMsg.getUin(), false, currentTimeMillis2, fromServiceMsg.getBusinessFailCode(), a17);
                    }
                } else if (getStatReporter() != null) {
                    getStatReporter().a(true, currentTimeMillis2, fromServiceMsg.getBusinessFailCode(), a17, equals, 0L);
                }
            }
            if (toServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_LOGIN_CHANGEUIN)) {
                String str2 = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_LOGIN_CHANGEUIN);
                fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_LOGIN_CHANGEUIN, fromServiceMsg.getUin());
                toServiceMsg.setUin(str2);
            }
            if (toServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_TOSERVICEMSG_SRCCMD)) {
                String str3 = (String) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_TOSERVICEMSG_SRCCMD);
                toServiceMsg.setServiceCmd(str3);
                fromServiceMsg.setServiceCmd(str3);
            }
        }
        if (toServiceMsg != null) {
            toServiceMsg.getAttributes().remove(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER);
            if (com.tencent.mobileqq.msf.core.x.e.o().a()) {
                toServiceMsg.getAttributes().remove(MsfConstants.ATTRIBUTE_PREDETECT_TIMEOUT_CALLBACKER);
            }
        }
        fromServiceMsg.addAttribute(BaseConstants.TIMESTAMP_MSF2APP, Long.valueOf(System.currentTimeMillis()));
        this.msfMessagePairs.add(new MsfMessagePair(str, toServiceMsg, fromServiceMsg));
        if (toServiceMsg != null) {
            QLog.d(tag, 1, " addRespToQueue:" + toServiceMsg.getRequestSsoSeq() + ", fromServiceMsg:" + fromServiceMsg);
            return;
        }
        QLog.d(tag, 1, " addPushToQueue:" + fromServiceMsg.getRequestSsoSeq() + ", fromServiceMsg:" + fromServiceMsg);
    }

    public int login(ToServiceMsg toServiceMsg, int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, this, toServiceMsg, Integer.valueOf(i3), Integer.valueOf(i16), bArr)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "recv " + toServiceMsg.getUin() + " login req");
        }
        toServiceMsg.getAttributes().put(com.tencent.mobileqq.msf.core.auth.b.f247387r, Boolean.TRUE);
        if (isUseWtlogin()) {
            return this.wtLoginCenter.a(toServiceMsg, false);
        }
        return this.accountCenter.a(toServiceMsg, i3, i16, bArr);
    }
}
