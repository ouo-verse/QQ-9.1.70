package com.tencent.common.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.dd;
import com.tencent.mobileqq.api.IBuildConfig;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.multilanguage.MultiLanguageEngine;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.utils.DisplayMetricsUtil;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.app.utils.i;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.mobileqq.haoliyou.IATHandler;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.qfix.QFixApplication;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.utils.ProcessChecker;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.MSFInterfaceAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.trace.NTTraceManager;
import cooperation.qzone.QUA;
import cooperation.qzone.util.PerfTracer;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.ThirdAppReportHelper;
import mqq.app.ThirdPushSupportHelper;
import mqq.app.api.ProcessConstant;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BaseApplicationImpl extends MobileQQ {
    static IPatchRedirector $redirector_ = null;
    public static String ASanEscapedMsg = null;
    public static boolean IS_SUPPORT_THEME = false;
    private static final String TAG = "BaseApplicationImpl";
    public static final String[] TOOL_PROCS;
    public static boolean appMainActivityHasLanuch = false;
    public static final String bootBroadcastName = "com.tencent.mobileqq.broadcast.qq";
    public static boolean isInActionS;
    private static volatile com.tencent.common.app.b sAppRuntimeFactory;
    public static BaseApplicationImpl sApplication;
    public static long sAttachBaseContextTime;
    public static long sAttachBaseDoneContextTime;
    public static String sFoo2Version;
    public static String sFooVersion;
    public static boolean sIsBgStartup;
    public static String sNativeMonitorEscapedMsg;
    public static String sQQAppInterfaceEscapedMsg;
    public static String sSplashActivityEscapedMsg;
    public static long sToolShowTime;
    public static MqqHandler sUiHandler;
    private dd mHotSplash;
    private MSFInterfaceAdapter mMSFInterfaceAdapter;
    private final com.tencent.mobileqq.qroute.route.g mQRouteLogger;
    private final com.tencent.mobileqq.qroute.remote.a mQRouteRemoteProxy;
    private final com.tencent.mobileqq.qroute.utils.c mQRouterProcessCheck;
    private Intent pcActiveNoticeIntent;
    private String pcactiveContent;
    private String pcactiveLButton;
    private String pcactiveRButton;
    private String pcactiveUin;
    private Resources resourcesWrapper;

    /* compiled from: P */
    /* renamed from: com.tencent.common.app.BaseApplicationImpl$6, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BroadcastReceiver f99508d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IntentFilter f99509e;
        final /* synthetic */ BaseApplicationImpl this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d(BaseApplicationImpl.TAG, 1, "registerReceiverAsync");
                this.this$0.registerReceiverImpl(this.f99508d, this.f99509e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements com.tencent.mobileqq.qroute.route.g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseApplicationImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.w(str, 1, str2);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void b(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, str2, th5);
            } else {
                QLog.w(str, 1, str2, th5);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void debug(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.d(str, 4, str2);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public void info(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                QLog.i(str, 1, str2);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.g
        public boolean isColorLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return QLog.isColorLevel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements com.tencent.mobileqq.qroute.utils.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseApplicationImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.utils.c
        public boolean a(Class<?> cls, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, cls, str, Boolean.valueOf(z16))).booleanValue();
            }
            return ProcessChecker.check(cls, str, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements com.tencent.mobileqq.qroute.remote.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseApplicationImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.qroute.remote.a
        public com.tencent.mobileqq.qroute.remote.c a(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.qroute.remote.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle);
            }
            EIPCResult callServer = QIPCClientHelper.getInstance().callServer("QRouteIPCModule", str, bundle);
            com.tencent.mobileqq.qroute.remote.c cVar = new com.tencent.mobileqq.qroute.remote.c();
            cVar.f276474a = callServer.code;
            cVar.f276475b = callServer.data;
            cVar.f276476c = callServer.f396321e;
            return cVar;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66005);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
            return;
        }
        sQQAppInterfaceEscapedMsg = "";
        sSplashActivityEscapedMsg = "";
        sFooVersion = "";
        sFoo2Version = "";
        IS_SUPPORT_THEME = true;
        sAttachBaseContextTime = 0L;
        sAttachBaseDoneContextTime = 0L;
        sIsBgStartup = false;
        appMainActivityHasLanuch = false;
        sToolShowTime = 0L;
        isInActionS = true;
        sAppRuntimeFactory = new com.tencent.common.app.c();
        TOOL_PROCS = new String[]{":tool", ":peak", ":qzone"};
    }

    public BaseApplicationImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pcactiveUin = null;
        this.pcactiveContent = null;
        this.pcactiveLButton = null;
        this.pcactiveRButton = null;
        this.mHotSplash = new dd();
        this.mQRouteLogger = new a();
        this.mQRouterProcessCheck = new b();
        this.mQRouteRemoteProxy = new c();
        this.pcActiveNoticeIntent = null;
        BaseApplication.buildNum = AppSetting.f99542b;
        BaseApplication.reportVersionName = AppSetting.f99554n;
    }

    public static BaseApplicationImpl getApplication() {
        return sApplication;
    }

    public static String getLocalVerify(ArrayList<String> arrayList, boolean z16) {
        int i3;
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            i3 = time.minute - 1;
        } else {
            i3 = time.minute;
        }
        sb5.append(i3);
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + ((Object) sb5));
    }

    private boolean registerReceiverAsync(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent registerReceiverImpl(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            return super.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "", e16);
                return null;
            }
            return null;
        }
    }

    private boolean sendBroadcastAsync(Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return false;
        }
        if (!action.startsWith("com.tencent.process.") && !action.equals("com.tencent.qq.syncQQMessage")) {
            return false;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(intent) { // from class: com.tencent.common.app.BaseApplicationImpl.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Intent f99512d;

            {
                this.f99512d = intent;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseApplicationImpl.this, (Object) intent);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    BaseApplicationImpl.this.doSendBroadcast(this.f99512d);
                }
            }
        });
        return true;
    }

    public static void setAppRuntimeFactory(com.tencent.common.app.b bVar) {
        sAppRuntimeFactory = bVar;
    }

    private void setupAppSettings() {
        AppSetting.y(((IBuildConfig) QRoute.api(IBuildConfig.class)).isQRun());
        AppSetting.w(((IBuildConfig) QRoute.api(IBuildConfig.class)).isUITest());
        AppSetting.z(((IBuildConfig) QRoute.api(IBuildConfig.class)).isQRunCompact());
    }

    public static boolean useQIPCStart(String str) {
        for (String str2 : TOOL_PROCS) {
            if (str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // mqq.app.MobileQQ
    public void addCommonActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.addCommonActivity(activity);
            com.tencent.qqperf.monitor.crash.tools.b.f(activity);
        }
    }

    @Override // mqq.app.MobileQQ
    public void addOtherTypeActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.addOtherTypeActivity(activity);
            com.tencent.qqperf.monitor.crash.tools.b.f(activity);
        }
    }

    @Override // mqq.app.MobileQQ, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) context);
            return;
        }
        sAttachBaseContextTime = SystemClock.uptimeMillis();
        initProcess();
        int i3 = MobileQQ.sProcessId;
        if (i3 != 14 && i3 != 16) {
            super.attachBaseContext(context);
            if (MobileQQ.sProcessId == 7) {
                sToolShowTime = SystemClock.uptimeMillis();
            }
            setupAppSettings();
            com.tencent.mobileqq.startup.director.a.A(new com.tencent.mobileqq.startup.director.a());
            com.tencent.mobileqq.startup.director.a.n().t(context);
            NTTraceManager.f362318a.h();
            String[] strArr = TOOL_PROCS;
            int length = strArr.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length) {
                    break;
                }
                String str = strArr[i16];
                String str2 = MobileQQ.processName;
                if (str2 != null && str2.endsWith(str)) {
                    MobileQQ.sIsToolProc = true;
                    break;
                }
                i16++;
            }
            sAttachBaseDoneContextTime = SystemClock.uptimeMillis();
            return;
        }
        super.attachBaseContext(context);
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, this, intent, serviceConnection, Integer.valueOf(i3))).booleanValue();
        }
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 2);
        return super.bindService(intent, serviceConnection, i3);
    }

    @Override // mqq.app.MobileQQ
    public AppRuntime createRuntime(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
        }
        if (z16) {
            AppRuntime peekAppRuntime = peekAppRuntime();
            if ((peekAppRuntime instanceof QQAppInterface) && peekAppRuntime.getLongAccountUin() > 10000) {
                ((QQAppInterface) peekAppRuntime).startInspect();
            }
        }
        return com.tencent.common.app.a.a(this, str);
    }

    public void doSendBroadcast(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) intent);
            return;
        }
        try {
            super.sendBroadcast(intent);
        } catch (Throwable th5) {
            QLog.e("mqq", 1, "", th5);
        }
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public Object getAppData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        }
        if (str == null || !"channel_id".equals(str)) {
            return null;
        }
        return AppSetting.h();
    }

    @Override // mqq.app.MobileQQ
    public int getAppId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).intValue();
        }
        int f16 = AppSetting.f();
        QLog.d(TAG, 1, "getAppId = " + f16);
        return f16;
    }

    @Override // mqq.app.MobileQQ
    public String getBootBroadcastName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        if (str.equals(MobileQQ.PACKAGE_NAME)) {
            return bootBroadcastName;
        }
        if (str.equals(MobileQQ.PACKAGE_NAME + MsfConstants.PROCESS_VIDEO)) {
            return "com.tencent.av.ui.VChatActivity";
        }
        if (str.equals(MobileQQ.PACKAGE_NAME + ":nearby_video")) {
            return "com.tencent.mobileqq.nearbyvideochat.awake";
        }
        return "";
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public String getChannelId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return AppSetting.h();
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    @NonNull
    public MSFInterfaceAdapter getMSFInterfaceAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (MSFInterfaceAdapter) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        if (this.mMSFInterfaceAdapter == null) {
            synchronized (MSFInterfaceAdapter.class) {
                if (this.mMSFInterfaceAdapter == null) {
                    this.mMSFInterfaceAdapter = new f();
                }
            }
        }
        return this.mMSFInterfaceAdapter;
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public int getNTCoreVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return 100;
    }

    public Intent getPCActiveNoticeIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Intent) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        if (this.pcactiveUin != null && this.pcactiveContent != null && this.pcactiveLButton != null && this.pcactiveRButton != null) {
            Intent intent = new Intent(NewIntent.ACTION_PCACTIVE_TIPS);
            this.pcActiveNoticeIntent = intent;
            intent.putExtra("Message", this.pcactiveContent);
            this.pcActiveNoticeIntent.putExtra("uin", this.pcactiveUin);
            this.pcActiveNoticeIntent.putExtra("lButton", this.pcactiveLButton);
            this.pcActiveNoticeIntent.putExtra("rButton", this.pcactiveRButton);
            this.pcActiveNoticeIntent.addFlags(268435456);
            return this.pcActiveNoticeIntent;
        }
        return null;
    }

    public String getPCActiveUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.pcactiveUin;
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public String getPublishVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return AppSetting.j(this);
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public String getQua() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return QUA.getQUA3();
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (Resources) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        Resources resources = super.getResources();
        DisplayMetricsUtil.checkAndCorrectDensity(resources.getDisplayMetrics());
        GlobalDisplayMetricsManager.checkDensity(resources);
        return resources;
    }

    public AppRuntime getRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.common.app.b bVar = sAppRuntimeFactory;
        if (bVar != null) {
            return bVar.a(this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, i3);
        }
        if (str != null && str.startsWith("QV1")) {
            return getSystemSharedPreferences(str, i3);
        }
        return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
    }

    public SharedPreferences getSystemSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, i3);
        }
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication != null && (qFixApplication instanceof QFixApplicationImpl)) {
            return ((QFixApplicationImpl) qFixApplication).getSystemSharedPreferences(str, i3);
        }
        return super.getSharedPreferences(str, i3);
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public int getThirdPushType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        return ThirdPushManager.getInstance().getThirdPushType();
    }

    @Override // mqq.app.MobileQQ
    public boolean isNeedMSF(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        return !str.endsWith(ProcessConstant.LOLA);
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public boolean isUserAllow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return PrivacyPolicyHelper.isUserAllow();
    }

    @Override // mqq.app.MobileQQ
    public boolean onActivityCreate(Object obj, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, obj, (Object) intent)).booleanValue();
        }
        if (Build.VERSION.SDK_INT >= 24 && (obj instanceof Activity)) {
            GlobalDisplayMetricsManager.adjustDisplayMetrics((Activity) obj);
        }
        GlobalDisplayMetricsManager.adjustDisplayMetrics(this);
        if (MobileQQ.sProcessId == 7) {
            QLog.i(TAG, 1, String.format("onActivityCreate %s", obj));
        }
        com.tencent.mobileqq.startup.director.a n3 = com.tencent.mobileqq.startup.director.a.n();
        if (n3 != null) {
            if (this.startComponentInfo == null && obj != null) {
                this.startComponentInfo = obj.toString();
            }
            return n3.w(obj);
        }
        return this.mHotSplash.m(obj);
    }

    @Override // mqq.app.MobileQQ
    public void onActivityFocusChanged(AppActivity appActivity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, appActivity, Boolean.valueOf(z16));
            return;
        }
        com.tencent.mobileqq.startup.director.a n3 = com.tencent.mobileqq.startup.director.a.n();
        if (n3 != null) {
            n3.r(appActivity, z16);
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) configuration);
            return;
        }
        int i3 = MobileQQ.sProcessId;
        if (i3 != 14 && i3 != 16) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("BaseApplicationImpl onConfigurationChanged called, localeInfo1:");
                if (configuration != null) {
                    sb5.append("\n");
                    sb5.append("newConfig#Locale:");
                    sb5.append(configuration.locale.toString());
                } else {
                    sb5.append("\n");
                    sb5.append("newConfig is null");
                }
                if (sApplication != null) {
                    sb5.append("\n");
                    sb5.append("sApplication#Locale pre:");
                    sb5.append(sApplication.getResources().getConfiguration().locale.toString());
                }
                if (MobileQQ.sMobileQQ != null) {
                    sb5.append("\n");
                    sb5.append("sMobileQQ#Locale pre:");
                    sb5.append(MobileQQ.sMobileQQ.getResources().getConfiguration().locale.toString());
                }
                LocaleManager.printLog(sb5.toString());
            }
            if (configuration != null) {
                i iVar = i.f196664a;
                iVar.i(configuration.fontScale, true);
                iVar.a(BaseApplication.getContext(), false);
                QLog.d(TAG, 1, "BaseApplicationImpl onConfigurationChanged: newConfig fontScale=: " + configuration.fontScale);
            }
            super.onConfigurationChanged(configuration);
            GlobalDisplayMetricsManager.adjustDisplayMetrics(this);
            ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).onConfigurationChanged();
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("BaseApplicationImpl onConfigurationChanged called, localeInfo2:");
                if (sApplication != null) {
                    sb6.append("\n");
                    sb6.append("sApplication#Locale end:");
                    sb6.append(sApplication.getResources().getConfiguration().locale.toString());
                }
                if (MobileQQ.sMobileQQ != null) {
                    sb6.append("\n");
                    sb6.append("sMobileQQ#Locale end:");
                    sb6.append(MobileQQ.sMobileQQ.getResources().getConfiguration().locale.toString());
                }
                if (!TextUtils.isEmpty(sb6.toString())) {
                    LocaleManager.printLog(sb6.toString());
                }
            }
            GlobalDisplayMetricsManager.checkChangeOfSysDensity(configuration, this);
        }
    }

    @Override // mqq.app.MobileQQ, com.tencent.qphone.base.util.BaseApplication, android.app.Application
    @TargetApi(15)
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        int i3 = MobileQQ.sProcessId;
        if (i3 == 14 || i3 == 16 || sApplication != null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        com.tencent.mobileqq.startup.a.f289662c = uptimeMillis;
        com.tencent.mobileqq.startup.a.f289663d = uptimeMillis;
        sApplication = this;
        MobileQQ.sMobileQQ = this;
        BaseApplication.context = this;
        if (MobileQQ.sProcessId == 2) {
            com.tencent.mobileqq.startup.a.f289672m = true;
            PerfTracer.traceStart(PerfTracer.APP_ONCREATE);
        }
        com.tencent.mobileqq.startup.director.a.n().s(this);
        if (com.tencent.mobileqq.startup.a.f289672m) {
            PerfTracer.traceEnd(PerfTracer.APP_ONCREATE);
        }
        ThirdAppReportHelper.sThirdAppReporter = new ThirdAppReportImpl();
        ThirdPushSupportHelper.sThirdPushSupport = new com.tencent.mobileqq.pushnotice.e();
        try {
            util.LOGCAT_OUT = true;
        } catch (Throwable unused) {
        }
        superOnCreate();
        com.tencent.mobileqq.alpha.a.b(this);
        com.tencent.qqnt.c.b(this);
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Intent) iPatchRedirector.redirect((short) 19, (Object) this, (Object) broadcastReceiver, (Object) intentFilter);
        }
        if (registerReceiverAsync(broadcastReceiver, intentFilter)) {
            return null;
        }
        return registerReceiverImpl(broadcastReceiver, intentFilter);
    }

    @Override // mqq.app.MobileQQ
    public void removeCommonActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.removeCommonActivity(activity);
            com.tencent.qqperf.monitor.crash.tools.b.g(activity);
        }
    }

    @Override // mqq.app.MobileQQ
    public void removeOtherTypeActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.removeOtherTypeActivity(activity);
            com.tencent.qqperf.monitor.crash.tools.b.g(activity);
        }
    }

    @Override // mqq.app.MobileQQ
    public void reportPCActive(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, i3);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_retryIndex", Integer.toString(i3));
        hashMap.put("param_uin", str);
        StatisticCollector.getInstance(getApplication()).collectPerformance(str, "PcActiveSucc", true, 0L, 0L, hashMap, "", true);
        sUiHandler.postDelayed(new Runnable(i3, str) { // from class: com.tencent.common.app.BaseApplicationImpl.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f99510d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f99511e;

            {
                this.f99510d = i3;
                this.f99511e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BaseApplicationImpl.this, Integer.valueOf(i3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("param_retryIndex", Integer.toString(this.f99510d));
                hashMap2.put("param_uin", this.f99511e);
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.f99511e, "PcActiveSuccB", true, 0L, 0L, hashMap2, "", true);
            }
        }, 10000L);
        ReportController.o(null, "CliOper", "", "", "0X8004974", "0X8004974", 0, 0, "", "", "", "");
    }

    @Override // mqq.app.MobileQQ, com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) intent);
        } else if (!sendBroadcastAsync(intent)) {
            doSendBroadcast(intent);
        }
    }

    public void setPCActiveNotice(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, str2, str3, str4);
            return;
        }
        this.pcactiveUin = str;
        this.pcactiveContent = str2;
        this.pcactiveLButton = str3;
        this.pcactiveRButton = str4;
    }

    protected void setupMultiLanguage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            MultiLanguageEngine.getInstance().loadLanguage(this);
        }
    }

    @Override // mqq.app.MobileQQ, com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent);
            return;
        }
        try {
            FileProvider7Helper.intentCompatForN(this, intent);
            ThirdAppReportHelper.reportThirdAppOpen(this, intent, 0);
            JumpActivity.processIntent(intent);
            try {
                IATHandler.shellCheckAndDoSync(this, intent, new TeleScreenRunnable(intent) { // from class: com.tencent.common.app.BaseApplicationImpl.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Intent f99505d;

                    {
                        this.f99505d = intent;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseApplicationImpl.this, (Object) intent);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            try {
                                BaseApplicationImpl.super.startActivity(this.f99505d);
                                return;
                            } catch (Throwable th5) {
                                QLog.e(BaseApplicationImpl.TAG, 1, th5, new Object[0]);
                                return;
                            }
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (ComponentName) iPatchRedirector.redirect((short) 37, (Object) this, (Object) intent);
        }
        ThirdAppReportHelper.reportThirdAppOpen(this, intent, 1);
        return super.startService(intent);
    }

    public void superOnCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onCreate();
            sUiHandler = new MqqHandler();
        }
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public int getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) ? AppSetting.f() : ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
    }

    @Override // mqq.app.MobileQQ, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) intent, (Object) bundle);
            return;
        }
        try {
            FileProvider7Helper.intentCompatForN(this, intent);
            ThirdAppReportHelper.reportThirdAppOpen(this, intent, 0);
            JumpActivity.processIntent(intent);
            try {
                IATHandler.shellCheckAndDoSync(this, intent, new TeleScreenRunnable(intent, bundle) { // from class: com.tencent.common.app.BaseApplicationImpl.5
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Intent f99506d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Bundle f99507e;

                    {
                        this.f99506d = intent;
                        this.f99507e = bundle;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, BaseApplicationImpl.this, intent, bundle);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            try {
                                BaseApplicationImpl.super.startActivity(this.f99506d, this.f99507e);
                                return;
                            } catch (Throwable th5) {
                                QLog.e(BaseApplicationImpl.TAG, 1, th5, new Object[0]);
                                return;
                            }
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }
}
