package com.tencent.mobileqq.app.guard;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.guardmanager.a;
import com.tencent.mobileqq.h;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.u;
import com.tencent.mobileqq.utils.Cdo;
import com.tencent.mobileqq.utils.MemoryUtils;
import com.tencent.mobileqq.utils.as;
import com.tencent.mobileqq.utils.cj;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GuardManager extends BroadcastReceiver implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final String ACTION_PLUGIN_BG = "com.tencent.process.stopping";
    private static final String ACTION_PLUGIN_FG = "com.tencent.process.starting";
    public static final String ACTION_PLUGIN_STATE_CHANGE = "com.tencent.plugin.state.change";
    public static final int EVENT_MAIN = 6;
    public static final int EVENT_MSG = 0;
    public static final int EVENT_RESUME = 1;
    public static final String GM_VERSION = "20140619";
    public static final int GUARD_BGFETCH = 1;
    public static final int GUARD_EMPTY = 0;
    public static final int GUARD_LITE = 6;
    public static final String KEY_PLUGIN_STATE = "key_plugin_state";
    public static final long MIN_BETWEEN_TWO_REPORT = 600000;
    private static final int MSG_GUARD_EVENT = 4;
    private static final int MSG_NEXT_STATE = 6;
    private static final int MSG_QQPLUGIN_BG = 1;
    private static final int MSG_QQPLUGIN_FG = 2;
    private static final int MSG_REPORT_CHANGE = 3;
    private static final int MSG_TICK = 5;
    private static final int MSG_UNGUARD = 7;
    public static final int PERIOD_TIMER = 12000;
    protected static final String PROCESS_MSG = "fake_p_msg";
    public static final String PROCESS_NAME = "process";
    protected static final String PROCESS_TRICK = "trick_p_msg";
    public static final int REPORT_ALIVE = 0;
    public static final int REPORT_LOGIN_BACKGROUND = 2;
    public static final int REPORT_LOGIN_FOREGROUND = 1;
    public static final int STATE_TO_BACKGROUND = 0;
    public static final int STATE_TO_FOREGROUND = 1;
    public static int SUICIDE_FACTOR = 0;
    public static final String TAG = "GuardManager";
    protected static final int TICK_FOREGROUND_KILL_QZONE = 15;
    public static final int TICK_KILL_ALL = 50;
    protected static final int TICK_KILL_OTHER = 3;
    protected static final int TICK_MSG_GUARD = 2;
    public static final int TICK_REPORT_MEM = 1;
    public static final int TYPE_MM = 101;

    @ConfigInject(configPath = "AutoInjectYml/Foundation/QQGuardManager/Inject_guard_manager.yml", version = 1)
    public static ArrayList<Class<? extends u>> sInjectorList;
    public static GuardManager sInstance;
    public static int sTickQZoneBgKill;
    public static int sTickToolBgFgKill;
    private static ConcurrentHashMap<String, Long> timeMillisInTodayZeroMap;
    public u injector;
    private boolean isLastCallbackFG;
    long mBgTime;
    private Application mContext;
    protected long[][] mCountEvents;
    public volatile String mFgProcess;
    long mFgTime;
    private final Map<String, String> mForegroundProcessMap;
    private Handler mHandler;
    public List<String> mLastFgProcess;
    protected int mLastIndex;
    protected int mLastMinute;
    long mNoLoginedUinStartTime;
    private volatile BroadcastReceiver mScreenLockReceiver;
    long mStartTime;
    private GuardState mState;
    GuardState[] mStateCache;
    private int mStateId;
    Random random;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class ScreenLockReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        ScreenLockReceiver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GuardManager.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            QLog.d(GuardManager.TAG, 1, action);
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                GuardManager guardManager = GuardManager.this;
                if (guardManager.mStartTime > 0) {
                    guardManager.reportForegroundRunningTime(false, guardManager.mFgProcess);
                }
                GuardManagerCallbackDispatcher.dispatchOnScreenChange(false);
                return;
            }
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                GuardManagerCallbackDispatcher.dispatchOnScreenChange(true);
                GuardManager guardManager2 = GuardManager.this;
                if (guardManager2.mStartTime == 0 && guardManager2.mFgProcess != null) {
                    GuardManager.this.mStartTime = SystemClock.uptimeMillis();
                    GuardManager guardManager3 = GuardManager.this;
                    guardManager3.reportForegroundEvent(guardManager3.mFgProcess);
                    QLog.d(GuardManager.TAG, 1, "848QQDT [onReceive] resetTime: " + GuardManager.this.mStartTime);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        ArrayList<Class<? extends u>> arrayList = new ArrayList<>();
        sInjectorList = arrayList;
        arrayList.add(a.class);
        timeMillisInTodayZeroMap = new ConcurrentHashMap<>();
        SUICIDE_FACTOR = 5;
        sTickToolBgFgKill = 10;
        sTickQZoneBgKill = 15;
    }

    public GuardManager(Application application, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) application, i3);
            return;
        }
        this.injector = new h();
        this.mCountEvents = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 3, 15);
        this.mLastIndex = 0;
        this.mLastMinute = 0;
        this.mState = null;
        this.mStateId = 0;
        this.mStartTime = 0L;
        this.mNoLoginedUinStartTime = 0L;
        this.mFgTime = 0L;
        this.mBgTime = 0L;
        this.mFgProcess = null;
        this.mLastFgProcess = new ArrayList();
        this.mStateCache = new GuardState[9];
        this.isLastCallbackFG = false;
        if (MobileQQ.PACKAGE_NAME.equals(MobileQQ.processName)) {
            this.mContext = application;
            try {
                if (sInjectorList.size() > 0) {
                    this.injector = sInjectorList.get(0).newInstance();
                } else {
                    QLog.e(TAG, 1, "sInjectorList.size() == 0");
                }
            } catch (IllegalAccessException | InstantiationException e16) {
                QLog.e(TAG, 1, "IGuardManagerInjector new instance fail: ", e16);
            }
            this.mHandler = new Handler(this.injector.f(), this);
            this.mForegroundProcessMap = new ConcurrentHashMap();
            nextState(i3, null);
            IntentFilter intentFilter = new IntentFilter(ACTION_PLUGIN_BG);
            intentFilter.addAction(ACTION_PLUGIN_FG);
            try {
                this.mContext.registerReceiver(this, intentFilter);
            } catch (Throwable unused) {
            }
            Foreground.setReady();
            return;
        }
        throw new RuntimeException("GuardManager cannot instantiate at sub process!!!");
    }

    private static Map<String, String> filteredRealForegroundProcMap(Map<String, String> map) {
        BaseApplication baseApplication = BaseApplication.context;
        HashMap hashMap = new HashMap();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) baseApplication.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (key != null && key.equals(runningAppProcessInfo.processName) && runningAppProcessInfo.importance == 100) {
                        hashMap.put(key, map.get(key));
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "[process] filterRealForegroundProcMap: invoked. ", " realProcMap: ", hashMap);
        }
        return hashMap;
    }

    private static String getTopActivityName() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            return topActivity.getClass().getName();
        }
        return "Null";
    }

    private void handleMessageForGuardEvent(Message message) {
        int i3 = message.arg1;
        if (i3 < 3) {
            updateActiveStatistic(i3);
        }
        this.mState.onEvent(i3, message.obj);
    }

    private boolean handleMessageForQQPluginBG(Message message) {
        String string = ((Bundle) message.obj).getString("process");
        QLog.d(TAG, 1, "[handleMessageForQQPluginBG] fgProcess: ", this.mFgProcess, ", bgProcess: ", string, ", activityCount: ", Integer.valueOf(Foreground.getActivityCount()), ", foreground: ", Boolean.valueOf(isApplicationForeground()));
        GuardStateScheduler.getInstance().updateStateOnProcessBGEvent(string, String.valueOf(0));
        if (this.mFgProcess == null) {
            return true;
        }
        if (TextUtils.equals(this.mFgProcess, string)) {
            this.mFgProcess = null;
            if (Foreground.getActivityCount() > 0) {
                this.mFgProcess = MobileQQ.PACKAGE_NAME;
                updateLastFgProcess();
                return true;
            }
            if (isApplicationForeground()) {
                updateLastFgProcess();
                if (this.mFgProcess == null) {
                    long j3 = 0;
                    for (Map.Entry<String, String> entry : this.mForegroundProcessMap.entrySet()) {
                        String value = entry.getValue();
                        if (TextUtils.isDigitsOnly(value)) {
                            long parseLong = Long.parseLong(value);
                            if (parseLong > j3) {
                                this.mFgProcess = entry.getKey();
                                j3 = parseLong;
                            }
                        }
                    }
                }
                QLog.d(TAG, 1, "[handleMessageForQQPluginBG] multi process. fgProcess: ", this.mFgProcess);
                return true;
            }
            if (this.mScreenLockReceiver != null) {
                try {
                    this.mContext.unregisterReceiver(this.mScreenLockReceiver);
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, th5, new Object[0]);
                }
                this.mScreenLockReceiver = null;
            }
            reportForegroundRunningTime(false, string);
            onEvent(4, string);
            Intent intent = new Intent(ACTION_PLUGIN_STATE_CHANGE);
            intent.putExtra(KEY_PLUGIN_STATE, 0);
            BaseApplication.getContext().sendBroadcast(intent);
            return false;
        }
        updateLastFgProcess();
        return true;
    }

    private void handleMessageForQQPluginFG(Message message) {
        Bundle bundle = (Bundle) message.obj;
        String str = this.mFgProcess;
        this.mFgProcess = bundle.getString("process");
        QLog.d(TAG, 1, "[handleMessageForQQPluginFG] old: ", str, ", new: ", this.mFgProcess);
        GuardStateScheduler.getInstance().updateStateOnProcessFGEvent(this.mFgProcess, String.valueOf(bundle.getLong("event_time")));
        if (str == null) {
            updateStartTime(MobileQQ.sMobileQQ.waitAppRuntime());
            if (this.mScreenLockReceiver == null) {
                this.mScreenLockReceiver = new ScreenLockReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                try {
                    this.mContext.registerReceiver(this.mScreenLockReceiver, intentFilter);
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, th5, new Object[0]);
                }
            }
            Intent intent = new Intent(ACTION_PLUGIN_STATE_CHANGE);
            intent.putExtra(KEY_PLUGIN_STATE, 1);
            MobileQQ.sMobileQQ.sendBroadcast(intent);
            reportForegroundEvent(this.mFgProcess);
        }
        updateLastFgProcess();
        onEvent(3, this.mFgProcess);
    }

    private boolean handleMessageForReportChange(Message message) {
        int i3;
        try {
            int i16 = message.arg2;
            if ((i16 == 2 || i16 == 3) && ((i3 = message.arg1) == 4 || i3 == 5 || i3 == 6 || i3 == 7 || i3 == 0)) {
                this.injector.b(7, 0L, 0L);
            }
            if (this.random == null) {
                this.random = new Random();
            }
            if (this.random.nextInt(20000) != 0) {
                return true;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            String[] strArr = GuardState.NAME_STATE;
            hashMap.put("before", strArr[message.arg1]);
            hashMap.put("after", strArr[message.arg2]);
            report("GM_guardChangeS", hashMap);
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isLogin() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            QLog.d(TAG, 1, "[isLogin] app is null");
            return false;
        }
        AppRuntime waitAppRuntime = mobileQQ.waitAppRuntime();
        if (waitAppRuntime == null || !waitAppRuntime.isLogin()) {
            return false;
        }
        return true;
    }

    public static void reportDailyInfo(Context context, String str, int i3) {
        try {
            if (!cj.b()) {
                QLog.d(TAG, 1, "privacy is not allowed");
                return;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportDailyInfo err: ", th5);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!timeMillisInTodayZeroMap.containsKey(str)) {
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    timeMillisInTodayZeroMap.put(str, Long.valueOf(as.b(context, str)));
                }
            } else {
                timeMillisInTodayZeroMap.put(str, Long.valueOf(as.a(context)));
            }
        }
        if (currentTimeMillis - timeMillisInTodayZeroMap.get(str).longValue() < 86400000) {
            return;
        }
        long a16 = Cdo.a(currentTimeMillis);
        timeMillisInTodayZeroMap.put(str, Long.valueOf(a16));
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    as.d(context, str, a16);
                    sInstance.injector.h(MobileQQ.sMobileQQ.waitAppRuntime(), "login", "msf", "login", "", 1, "");
                }
            } else {
                as.d(context, str, a16);
                sInstance.injector.h(MobileQQ.sMobileQQ.waitAppRuntime(), "login", "front", "login", "", 1, "");
            }
        } else {
            as.c(context, a16);
            sInstance.injector.h(MobileQQ.sMobileQQ.waitAppRuntime(), "start_up", "front", "device_cnt", "", 1, "");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Daily Report info key=" + str + " timeMillisInTodayZero=" + a16 + " nowTime=" + currentTimeMillis);
        }
    }

    public static void reportLoginActive(Context context, boolean z16) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            AppRuntime waitAppRuntime = mobileQQ.waitAppRuntime();
            if (waitAppRuntime != null && mobileQQ.isRuntimeReady() && waitAppRuntime.isLogin()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "now login uin=" + waitAppRuntime.getAccount() + " isForeground=" + z16);
                }
                if (z16) {
                    reportDailyInfo(context, waitAppRuntime.getAccount() + "_Foreground", 1);
                }
                reportDailyInfo(context, waitAppRuntime.getAccount() + "_Background", 2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isRuntimeReady=" + mobileQQ.isRuntimeReady() + " now login uin=null");
            }
        }
    }

    public static void reportStart(boolean z16) {
        GuardConfig instance = GuardConfig.instance();
        sInstance.injector.b(5, instance.maxStartCount | (instance.maxRecordCount << 8), (z16 ? 1 : 0) | (GuardConfig.instance().tellWeakend << 8));
    }

    private void updateLastFgProcess() {
        List<String> foregroundProcess = GuardStateScheduler.getInstance().getForegroundProcess();
        if (!foregroundProcess.isEmpty()) {
            this.mLastFgProcess = foregroundProcess;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelTimer() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cancelTimer");
        }
        this.mHandler.removeMessages(5);
    }

    void dispatcherEvent(int i3, Object obj) {
        if (i3 != 3) {
            if (i3 == 4 && realForegroundProcessMap().size() == 0) {
                GuardManagerCallbackDispatcher.dispatchAppBackground();
                this.isLastCallbackFG = false;
                return;
            }
            return;
        }
        if (!this.isLastCallbackFG) {
            GuardManagerCallbackDispatcher.dispatchAppForeground();
            this.isLastCallbackFG = true;
        }
    }

    public void exit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        nextState(8, null);
        try {
            this.mContext.unregisterReceiver(this);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "", th5);
            }
        }
        if (this.mScreenLockReceiver != null) {
            try {
                QLog.d(TAG, 1, "exit unregisterReceiver");
                this.mContext.unregisterReceiver(this.mScreenLockReceiver);
            } catch (Throwable th6) {
                QLog.e(TAG, 1, th6, new Object[0]);
            }
            this.mScreenLockReceiver = null;
        }
        this.mHandler.removeMessages(5);
        CoreService.stopCoreService();
    }

    public int getActivateLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return GuardConfig.instance().getActiveLevel(this.mCountEvents, this.mLastIndex, this.mLastMinute);
    }

    public int[] getActiveCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (int[]) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        int[] iArr = new int[2];
        for (int i3 = 0; i3 < 15; i3++) {
            long j3 = iArr[0];
            long[][] jArr = this.mCountEvents;
            iArr[0] = (int) (j3 + jArr[1][i3]);
            iArr[1] = (int) (iArr[1] + jArr[0][i3]);
        }
        return iArr;
    }

    public Application getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Application) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mContext;
    }

    public String getForegroundProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mFgProcess;
    }

    GuardState getState(int i3) {
        GuardState guardState = this.mStateCache[i3];
        if (guardState == null) {
            switch (i3) {
                case 0:
                case 8:
                    guardState = new GuardState();
                    break;
                case 1:
                    guardState = new PrestartGuard();
                    break;
                case 2:
                    guardState = new ForgroundMain();
                    break;
                case 3:
                    guardState = new ForgroundOther();
                    break;
                case 4:
                    guardState = new BackgroundGuard();
                    break;
                case 5:
                    guardState = new BackgroundUnguard();
                    break;
                case 6:
                    guardState = new LiteGuard();
                    break;
                case 7:
                    guardState = new LiteUnguard();
                    break;
                default:
                    throw new RuntimeException("WTF");
            }
            guardState.mManager = this;
            guardState.mId = i3;
            this.mStateCache[i3] = guardState;
        }
        return guardState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStateId() {
        return this.mStateId;
    }

    public long getTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return GuardConfig.instance().getTimeout(this.mCountEvents, this.mLastIndex, this.mLastMinute, MemoryUtils.d(Process.myPid(), true)) / 12000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 1:
                handleMessageForQQPluginBG(message);
                return true;
            case 2:
                handleMessageForQQPluginFG(message);
                return true;
            case 3:
                handleMessageForReportChange(message);
                return true;
            case 4:
                handleMessageForGuardEvent(message);
                return true;
            case 5:
                this.mHandler.sendEmptyMessageDelayed(5, 12000L);
                this.mState.onTick();
                return true;
            case 6:
                nextState(message.arg1, message.obj);
                return true;
            case 7:
                if (isGuardState()) {
                    nextState(this.mStateId + 1, PROCESS_TRICK);
                }
                return true;
            default:
                return true;
        }
    }

    public boolean isApplicationForeground() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (realForegroundProcessMap().size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Application isForeground: ", Boolean.valueOf(z16));
        }
        return z16;
    }

    public boolean isGuardState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        int i3 = this.mStateId;
        if (i3 != 4 && i3 != 6) {
            return false;
        }
        return true;
    }

    public boolean isLiteOrUnguard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        int i3 = this.mStateId;
        if (i3 != 6 && i3 != 7 && i3 != 5) {
            return false;
        }
        return true;
    }

    public boolean isProcessForeground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        boolean containsKey = realForegroundProcessMap().containsKey(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "process: ", str, " isForeground: ", Boolean.valueOf(containsKey));
            QLog.d(TAG, 2, "call stack: ", new Throwable());
        }
        return containsKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nextState(int i3, Object obj) {
        if (Looper.myLooper() == this.injector.f()) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("nextState: ");
                String[] strArr = GuardState.NAME_STATE;
                sb5.append(strArr[this.mStateId]);
                sb5.append(", ");
                sb5.append(strArr[i3]);
                sb5.append(", ");
                sb5.append(obj);
                QLog.d(TAG, 2, sb5.toString());
            }
            int i16 = this.mStateId;
            if (i16 == 8) {
                return;
            }
            if (i16 != i3) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, i16, i3), 1000L);
                this.mState = getState(i3);
                this.mStateId = i3;
            } else if (i3 == 0) {
                this.mState = getState(i3);
            }
            this.mState.onEvent(5, obj);
            return;
        }
        this.mHandler.obtainMessage(6, i3, 0, obj).sendToTarget();
    }

    public void noticeSubThreadBackground(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("process", str);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, bundle));
    }

    public void onEvent(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, obj);
            return;
        }
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "GuradManager.onEvent: ", Integer.valueOf(i3), " param: ", obj);
        }
        this.mHandler.obtainMessage(4, i3, 0, obj).sendToTarget();
        if (i3 != 3) {
            if (i3 == 4) {
                reportDailyInfo(this.mContext, "daily_boot_report", 0);
                Application application = this.mContext;
                if (realForegroundProcessMap().size() <= 0) {
                    z16 = false;
                }
                reportLoginActive(application, z16);
                dispatcherEvent(4, obj);
            }
        } else {
            reportDailyInfo(this.mContext, "daily_boot_report", 0);
            Application application2 = this.mContext;
            if (realForegroundProcessMap().size() <= 0) {
                z16 = false;
            }
            reportLoginActive(application2, z16);
            dispatcherEvent(3, obj);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "state change:" + i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3 A[Catch: all -> 0x0197, TryCatch #0 {all -> 0x0197, blocks: (B:10:0x0020, B:12:0x003f, B:14:0x0078, B:16:0x0080, B:19:0x009a, B:23:0x00b2, B:25:0x00b8, B:29:0x00c4, B:34:0x00d3, B:35:0x0102, B:38:0x0118, B:40:0x0122, B:42:0x0128, B:46:0x0136, B:51:0x0145, B:52:0x0182), top: B:9:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0145 A[Catch: all -> 0x0197, TryCatch #0 {all -> 0x0197, blocks: (B:10:0x0020, B:12:0x003f, B:14:0x0078, B:16:0x0080, B:19:0x009a, B:23:0x00b2, B:25:0x00b8, B:29:0x00c4, B:34:0x00d3, B:35:0x0102, B:38:0x0118, B:40:0x0122, B:42:0x0128, B:46:0x0136, B:51:0x0145, B:52:0x0182), top: B:9:0x0020 }] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) intent);
            return;
        }
        try {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("runningProcessName");
            long longExtra = intent.getLongExtra("runningtime", 0L);
            long longExtra2 = intent.getLongExtra("event_time", 0L);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, action + " received with " + stringExtra + " at " + longExtra + ", when " + this.mBgTime + ", " + this.mFgTime);
            }
            if (stringExtra != null) {
                if (!stringExtra.equals(MobileQQ.PACKAGE_NAME)) {
                    if (!stringExtra.startsWith(MobileQQ.PACKAGE_NAME + ":")) {
                        return;
                    }
                }
                if (ACTION_PLUGIN_BG.equals(action)) {
                    long j3 = this.mBgTime;
                    if (longExtra < j3 && longExtra >= j3 - 1000000 && longExtra >= 0 && !this.mForegroundProcessMap.containsKey(stringExtra)) {
                        z17 = false;
                        if (z17) {
                            this.mBgTime = longExtra;
                            Bundle bundle = new Bundle();
                            bundle.putString("process", stringExtra);
                            bundle.putLong("event_time", longExtra2);
                            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, bundle), 50L);
                            this.mForegroundProcessMap.remove(stringExtra);
                            QLog.d(TAG, 1, "[process][remove] onReceive: invoked. ", " process: ", stringExtra);
                        }
                        QLog.d(TAG, 1, "[process][ACTION_PLUGIN_BG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(z17));
                        return;
                    }
                    z17 = true;
                    if (z17) {
                    }
                    QLog.d(TAG, 1, "[process][ACTION_PLUGIN_BG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(z17));
                    return;
                }
                if (ACTION_PLUGIN_FG.equals(action)) {
                    if (longExtra < this.mFgTime && longExtra >= this.mBgTime - 1000000 && longExtra >= 0 && this.mForegroundProcessMap.containsKey(stringExtra)) {
                        z16 = false;
                        if (z16) {
                            this.mFgTime = longExtra;
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("process", stringExtra);
                            bundle2.putLong("event_time", longExtra2);
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, bundle2));
                            this.mForegroundProcessMap.put(stringExtra, "" + longExtra2);
                            QLog.d(TAG, 1, "[process][put] onReceive: invoked. ", " process: ", stringExtra);
                        }
                        QLog.d(TAG, 1, "[process][ACTION_PLUGIN_FG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(z16));
                    }
                    z16 = true;
                    if (z16) {
                    }
                    QLog.d(TAG, 1, "[process][ACTION_PLUGIN_FG] onReceive: invoked. ", " runningTimeAllowed: ", Boolean.valueOf(z16));
                }
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "", th5);
        }
    }

    public Map<String, String> realForegroundProcessMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            return filteredRealForegroundProcMap(this.mForegroundProcessMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "realForegroundProcessMap: failed. ", th5);
            return this.mForegroundProcessMap;
        }
    }

    public void registerCallBack(IGuardInterface iGuardInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iGuardInterface);
        } else {
            GuardManagerCallbackDispatcher.registerCallBack(iGuardInterface);
        }
    }

    protected void report(String str, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) hashMap);
        } else {
            hashMap.put(DownloadInfo.spKey_Config, GuardConfig.instance().configId);
            this.injector.collectPerformance("", str, true, 0L, 0L, hashMap, "");
        }
    }

    public void reportForegroundEvent(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        try {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            String valueOf = String.valueOf(AppSetting.f());
            String topActivityName = getTopActivityName();
            boolean isLogin = isLogin();
            QLog.d(TAG, 1, "848QQDT [reportForegroundEvent] isLogin: " + isLogin);
            u uVar = this.injector;
            if (isLogin) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            uVar.a(waitAppRuntime, "dc00898", "", "", "qq_login", "front_open", 0, 1, i3, "", valueOf, topActivityName, str);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "848QQDT [reportForegroundEvent]", th5);
        }
    }

    public void reportForegroundRunningTime(boolean z16, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), str);
            return;
        }
        if (this.mStartTime == 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = uptimeMillis - this.mStartTime;
        int i3 = (int) (j3 / 1000);
        if (j3 % 1000 >= 500) {
            i3++;
        }
        String topActivityName = getTopActivityName();
        String valueOf = String.valueOf(AppSetting.f());
        boolean isLogin = isLogin();
        QLog.d(TAG, 1, "848QQDT _reportForeground(" + z16 + "):[" + this.mStartTime + " - " + uptimeMillis + " = " + i3 + "]\uff0cprocess:" + str + ", isLogin: " + isLogin + ", appid=" + valueOf + ", activity =" + topActivityName);
        if (i3 > 0) {
            String str3 = NetConnInfoCenter.getServerTimeMillis() + "";
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            String c16 = this.injector.c();
            str2 = TAG;
            this.injector.a(waitAppRuntime, "CliOper", "", "", "Online_time", "Fe_time", 0, i3, isLogin ? 1 : 0, str3, valueOf, topActivityName + "-" + str, c16);
        } else {
            str2 = TAG;
        }
        if (z16) {
            if (i3 > 0) {
                this.mStartTime = uptimeMillis;
                QLog.d(str2, 1, "848QQDT [reportForegroundRunningTime] resetTime: " + this.mStartTime);
                return;
            }
            return;
        }
        this.mStartTime = 0L;
        QLog.d(str2, 1, "848QQDT [reportForegroundRunningTime] resetTime: " + this.mStartTime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startTimer() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startTimer");
        }
        this.mHandler.removeMessages(5);
        this.mHandler.sendEmptyMessageDelayed(5, 12000L);
    }

    public void unregisterCallback(IGuardInterface iGuardInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iGuardInterface);
        } else {
            GuardManagerCallbackDispatcher.unregisterCallBack(iGuardInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateActiveStatistic(int i3) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 60000);
        int i16 = this.mLastMinute;
        if (currentTimeMillis == i16) {
            long[] jArr = this.mCountEvents[i3];
            int i17 = this.mLastIndex;
            jArr[i17] = jArr[i17] + 1;
            return;
        }
        if (currentTimeMillis < i16 || currentTimeMillis - i16 > 15) {
            for (int i18 = 0; i18 < 3; i18++) {
                for (int i19 = 0; i19 < 15; i19++) {
                    this.mCountEvents[i18][i19] = 0;
                }
            }
            this.mLastMinute = currentTimeMillis - 15;
            this.mLastIndex = 0;
        }
        int i26 = (currentTimeMillis - this.mLastMinute) % 15;
        for (int i27 = 1; i27 <= i26; i27++) {
            for (int i28 = 0; i28 < 3; i28++) {
                this.mCountEvents[i28][(this.mLastIndex + i27) % 15] = 0;
            }
        }
        this.mLastMinute = currentTimeMillis;
        int i29 = (this.mLastIndex + i26) % 15;
        this.mLastIndex = i29;
        this.mCountEvents[i3][i29] = 1;
    }

    public void updateStartTime(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime);
            return;
        }
        if (this.mStartTime == 0 && this.mFgProcess != null) {
            if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount())) {
                long j3 = this.mNoLoginedUinStartTime;
                if (j3 > 0) {
                    this.mStartTime = j3;
                    this.mNoLoginedUinStartTime = 0L;
                } else {
                    this.mStartTime = SystemClock.uptimeMillis();
                }
                QLog.d(TAG, 1, "848QQDT [updateStartTime] resetTime: " + this.mStartTime);
                return;
            }
            this.mNoLoginedUinStartTime = SystemClock.uptimeMillis();
        }
    }

    public void updateStateOnPreStartEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        int i16 = this.mStateId;
        int i17 = 1;
        if (i16 != 0) {
            QLog.d(TAG, 1, "GuardManager preStartEvent, but GuardStateIs null empty: ", Integer.valueOf(i16));
        }
        if (i3 != 2) {
            i17 = 6;
        }
        nextState(i17, null);
    }
}
