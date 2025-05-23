package mqq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArraySet;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.msf.core.MsfExitReceiver;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.inject.MqqInjectorManager;
import mqq.util.LogUtil;
import mqq.util.MSFRegisterHelper;
import mqq.util.WeakReference;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class MobileQQ extends BaseApplication implements Handler.Callback {
    public static String ACTION_MAIN_PROCESS_ALIVE = "com.tencent.mobileqq__alive";
    public static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
    public static final long APP_CREATE_COST_THREAD_HOLD = 3000;
    public static final int BROADCAST_INFO_LIST_SIZE = 5;
    private static final ArraySet<String> BROADCAST_WHITE_LIST;
    public static final String FILE_COMMON = "common_mmkv_configurations";
    public static final String KEY_UIN = "uin";
    private static final String LAST_LOGIN_MIGRATE_FLAG = "_migrate_flag_";
    public static final long MSF_SERVICE_COST_THREAD_HOLD = 1000;
    private static final int MSG_ACCOUNT = 1;
    private static final int MSG_ACCOUNT_REAL = 4;
    protected static final int MSG_LAST_UIN = 3;
    private static final int MSG_MONITOR = 2;
    public static final String NT_LOGIN_SWITCH_KEY = "switch_nt_login";
    public static String PACKAGE_NAME = "com.tencent.mobileqq";
    private static final String[] PERMS;
    public static final String PREF_BROADCAST = "broadcast_white_pref";
    private static final String PREF_KEY = "currentAccount";
    private static final String PREF_SHARE = "share";
    public static final String PREF_WHITE_LIST_KEY = "white_list";
    public static final int PROCESS_ACCOUNT = 17;
    public static final int PROCESS_GROUP_VIDEO = 15;
    public static final int PROCESS_LOLA = 6;
    public static final int PROCESS_MINI = 11;
    public static final int PROCESS_MSF = 4;
    public static final int PROCESS_NEARBY = 5;
    public static final int PROCESS_OTHER = -1;
    public static final int PROCESS_PEAK = 9;
    public static final int PROCESS_QQ = 1;
    public static final int PROCESS_QQ_STRANGER = 13;
    public static final int PROCESS_TOOL = 7;
    public static final int PROCESS_VIDEO = 10;

    @Deprecated
    public static final int PROCESS_WEB = 3;
    public static final int PROCESS_WEBVIEW_PRIVILEGED = 14;
    public static final int PROCESS_WEBVIEW_SANDBOXED = 16;
    public static final int PROCESS_ZONE = 2;
    public static final int PROCESS_ZONE_LIVE = 8;
    private static final String PROPERTY_MMKV_PREFIX = "mqq_property_";
    private static final String PROPERTY_NAME = "Properties";
    public static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
    private static final String SP_LAST_LOGIN = "Last_Login";
    public static final int STATE_EMPTY = 1;
    public static final int STATE_INITING = 2;
    public static final int STATE_READY = 3;
    public static final ConcurrentHashMap<String, Boolean> S_MODULE_LOADED;
    private static boolean hasInit;
    private static boolean hasTryExit;
    public static String processName;
    private static volatile boolean sHasPhonePermission;
    private static volatile boolean sHasSDCardPermission;
    private static boolean sHasStoragePermission;
    public static String sImmersiveUtilsEscapedMsg;
    public static String sInjectResult;
    public static boolean sIsToolProc;
    public static MobileQQ sMobileQQ;
    public static int sProcessId;
    private boolean accountChanged;
    private boolean isCrashed;
    private AppRuntime mAppRuntime;
    private MainService mService;
    private volatile IAccountCallback ntsdkInitAccountCallback;
    private volatile Properties properties;
    private Handler subHandler;
    private final List<WeakReference<IAccountCallback>> accountCallbacks = new CopyOnWriteArrayList();
    private final List<WeakReference<BaseActivity>> baseActivities = new ArrayList();
    public final List<WeakReference<AppActivity>> appActivities = new ArrayList();
    public final List<WeakReference<BaseFragmentActivity>> baseFragmentActivities = new ArrayList();
    protected final List<WeakReference<Activity>> commonActivities = new ArrayList();
    protected final List<WeakReference<AppService>> appServices = new ArrayList();
    private boolean stopMsfOnCrash = false;
    public boolean isPCActive = false;
    public Queue<Pair<Long, String>> broadcastInfoQueue = new LinkedList();
    public String startComponentInfo = null;
    private final AtomicInteger mRuntimeState = new AtomicInteger(1);
    private volatile boolean hasNotify = false;
    final Handler mHandler = new Handler(this);
    private final ArrayList<IBroadcastCallback> mBroadcastCallbacks = new ArrayList<>();
    private boolean stopMSF = false;
    private final Runnable doExit = new Runnable() { // from class: mqq.app.MobileQQ.3
        private <T extends Activity> boolean isActListFinish(List<WeakReference<T>> list) {
            for (WeakReference<T> weakReference : list) {
                if (weakReference != null && !weakReference.get().isFinishing()) {
                    return false;
                }
            }
            return true;
        }

        private boolean isAllActFinish() {
            if (isActListFinish(MobileQQ.this.baseActivities) && isActListFinish(MobileQQ.this.appActivities) && isActListFinish(MobileQQ.this.commonActivities) && isActListFinish(MobileQQ.this.baseFragmentActivities)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (isAllActFinish()) {
                MobileQQ.this.sendBroadcast(new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName));
                if (MobileQQ.this.getQQProcessName().endsWith(MsfConstants.PROCESS_VIDEO)) {
                    MobileQQ.this.mService.msfSub.unbindMsfService();
                    MobileQQ.this.mAppRuntime.onDestroy();
                }
                MobileQQ.this.mHandler.postDelayed(new Runnable() { // from class: mqq.app.MobileQQ.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MobileQQ.this.stopMSF) {
                            MobileQQ.this.mService.msfSub.stopMsfService();
                            MobileQQ.killProcess(BaseApplication.getContext(), MainService.QQPROCESSNAME + ":MSF");
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("mqq", 2, String.format("Application(%s) exit.", MobileQQ.processName));
                            QLog.i("mqq", 2, "===========================================================");
                        }
                        System.exit(0);
                    }
                }, 300L);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator it = MobileQQ.this.baseActivities.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) ((WeakReference) it.next()).get();
                if (activity != null) {
                    sb5.append(activity.getClass().getSimpleName());
                    sb5.append(",");
                }
            }
            Iterator<WeakReference<AppActivity>> it5 = MobileQQ.this.appActivities.iterator();
            while (it5.hasNext()) {
                AppActivity appActivity = it5.next().get();
                if (appActivity != null) {
                    sb5.append(appActivity.getClass().getSimpleName());
                    sb5.append(",");
                }
            }
            Iterator<WeakReference<Activity>> it6 = MobileQQ.this.commonActivities.iterator();
            while (it6.hasNext()) {
                Activity activity2 = it6.next().get();
                if (activity2 != null) {
                    sb5.append(activity2.getClass().getSimpleName());
                    sb5.append(",");
                }
            }
            Iterator<WeakReference<BaseFragmentActivity>> it7 = MobileQQ.this.baseFragmentActivities.iterator();
            while (it7.hasNext()) {
                BaseFragmentActivity baseFragmentActivity = it7.next().get();
                if (baseFragmentActivity != null) {
                    sb5.append(baseFragmentActivity.getClass().getSimpleName());
                    sb5.append(",");
                }
            }
            if (!MobileQQ.hasTryExit && QLog.isColorLevel()) {
                QLog.i("mqq", 2, "do exit ->" + ((Object) sb5));
                MobileQQ.hasTryExit = true;
            }
            sb5.delete(0, sb5.length());
            MobileQQ.this.mHandler.postDelayed(this, 50L);
        }
    };
    List<SimpleAccount> sortAccountList = null;
    private volatile LogoutParam logoutParam = null;
    private volatile String ntInitUin = "";
    private final Object switchAccountLock = new Object();
    private boolean useMergeAccountChange = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: mqq.app.MobileQQ$5, reason: invalid class name */
    /* loaded from: classes28.dex */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ SimpleAccount val$account;
        final /* synthetic */ int val$cnrType;
        final /* synthetic */ boolean val$forLogin;
        final /* synthetic */ boolean val$needSaveLoginTime;
        final /* synthetic */ String val$process;

        AnonymousClass5(SimpleAccount simpleAccount, int i3, boolean z16, boolean z17, String str) {
            this.val$account = simpleAccount;
            this.val$cnrType = i3;
            this.val$forLogin = z16;
            this.val$needSaveLoginTime = z17;
            this.val$process = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(AppRuntime appRuntime) {
            if (appRuntime != null) {
                QLog.d("MobileQQ", 1, "mobileQQ Replace, new: ", MobileQQ.this.mAppRuntime, " old: " + appRuntime);
                appRuntime.resourceRelease();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            boolean z16;
            if (MobileQQ.this.mAppRuntime == null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            AppRuntime createRuntime = MobileQQ.this.createRuntime(MobileQQ.processName, true);
            if (createRuntime == null) {
                QLog.i("mqq", 1, MobileQQ.processName + " needn't AppRuntime!");
                return;
            }
            MobileQQ mobileQQ = MobileQQ.this;
            createRuntime.init(mobileQQ, mobileQQ.mService, this.val$account);
            createRuntime.setCurAccLoginType(this.val$cnrType);
            QLog.d("MobileQQ", 1, "createNewRuntime, hashcode=", Integer.valueOf(createRuntime.hashCode()));
            if (!MobileQQ.this.getQQProcessName().endsWith(MsfConstants.PROCESS_VIDEO)) {
                MSFRegisterHelper.INSTANCE.registerMSFService(createRuntime);
            }
            SimpleAccount simpleAccount = this.val$account;
            if (simpleAccount != null && simpleAccount.isLogined()) {
                if (this.val$cnrType != 2) {
                    z16 = createRuntime.canAutoLogin(this.val$account.getUin());
                } else {
                    z16 = true;
                }
                if (this.val$forLogin || z16) {
                    createRuntime.setLogined();
                }
                QLog.d("MobileQQ", 1, "createNewRuntime, canAutoOK: " + z16, " uin : ", MsfSdkUtils.getShortUin(this.val$account.getUin()));
            } else {
                SimpleAccount simpleAccount2 = this.val$account;
                if (simpleAccount2 != null) {
                    QLog.d("MobileQQ", 1, "CNR account != null and account.isLogined =", Boolean.valueOf(simpleAccount2.isLogined()), " uin : ", MsfSdkUtils.getShortUin(this.val$account.getUin()));
                } else {
                    QLog.d("MobileQQ", 1, "CNR account == null");
                }
            }
            MobileQQ.this.accountChanged = createRuntime.isLogin();
            final AppRuntime appRuntime = null;
            if (createRuntime.isLogin()) {
                if (MobileQQ.this.mAppRuntime != null) {
                    MobileQQ.this.mAppRuntime.logout(Constants.LogoutReason.switchAccount, true);
                    MobileQQ.this.mAppRuntime.onDestroy();
                }
                if (this.val$needSaveLoginTime) {
                    SimpleAccount firstSimpleAccount = MobileQQ.this.getFirstSimpleAccount();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (firstSimpleAccount != null) {
                        try {
                            long string2Long = MobileQQ.string2Long(MobileQQ.this.getProperty(firstSimpleAccount.getUin() + Constants.Key._logintime));
                            if (currentTimeMillis <= string2Long) {
                                currentTimeMillis = 1 + string2Long;
                                if (QLog.isColorLevel()) {
                                    QLog.d("mqq", 2, "CNR account savetime => system time is error..");
                                }
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                    String account = createRuntime.getAccount();
                    if (account != null && MobileQQ.this.getQQProcessName().equals(MobileQQ.this.getPackageName())) {
                        MobileQQ.this.mHandler.sendMessageDelayed(MobileQQ.this.mHandler.obtainMessage(3, account), 1000L);
                    }
                    MobileQQ.this.setProperty(createRuntime.getAccount() + Constants.Key._logintime, String.valueOf(currentTimeMillis));
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if ((MobileQQ.this.getPackageName() + ":" + ProcessConstant.QQFAV).equals(MobileQQ.processName)) {
                    try {
                        createRuntime.onCreate(null);
                    } catch (Throwable th5) {
                        QLog.e("MobileQQ", 1, "fav appRuntime onCreate error, ", th5);
                    }
                } else {
                    createRuntime.onCreate(null);
                }
                MobileQQ.this.checkInitCostTime(currentTimeMillis2, "onCreate", 3000L);
                appRuntime = MobileQQ.this.mAppRuntime;
                MobileQQ.this.mAppRuntime = createRuntime;
            } else if (MobileQQ.this.mAppRuntime == null) {
                createRuntime.onCreate(null);
                MobileQQ.this.mAppRuntime = createRuntime;
            }
            Message obtainMessage = MobileQQ.this.mHandler.obtainMessage(1);
            obtainMessage.arg2 = i3;
            obtainMessage.arg1 = this.val$cnrType;
            obtainMessage.obj = this.val$process;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                MobileQQ.this.mHandler.dispatchMessage(obtainMessage);
            } else {
                MobileQQ.this.mHandler.sendMessage(obtainMessage);
            }
            MobileQQ.this.mHandler.post(new Runnable() { // from class: mqq.app.c
                @Override // java.lang.Runnable
                public final void run() {
                    MobileQQ.AnonymousClass5.this.lambda$run$0(appRuntime);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class LogoutParam {
        int crnType;
        boolean isFirstTime;
        String process;
        Constants.LogoutReason reason;

        LogoutParam(Constants.LogoutReason logoutReason, int i3, boolean z16, String str) {
            this.reason = logoutReason;
            this.crnType = i3;
            this.isFirstTime = z16;
            this.process = str;
        }
    }

    static {
        ArraySet<String> arraySet = new ArraySet<>();
        BROADCAST_WHITE_LIST = arraySet;
        arraySet.add("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        arraySet.add("com.android.launcher.action.INSTALL_SHORTCUT");
        arraySet.add(CommonBadgeUtilImpl.ACTION_APPLICATION_MESSAGE_UPDATE);
        arraySet.add(CommonBadgeUtilImpl.ACTION_QQLAUNCHER_BADGE_UPDATE);
        arraySet.add("android.intent.action.BADGE_COUNT_UPDATE");
        arraySet.add("com.sonyericsson.home.action.UPDATE_BADGE");
        arraySet.add("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        arraySet.add("com.miui.util.LongScreenshotUtils.LongScreenshot");
        sIsToolProc = false;
        sProcessId = -1;
        PERMS = new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, DeviceInfoUtil.PERMISSION_READ_PHONE};
        sImmersiveUtilsEscapedMsg = "";
        S_MODULE_LOADED = new ConcurrentHashMap<>();
        hasTryExit = false;
    }

    public static void addBroadcastWhitList(Collection<String> collection) {
        if (collection != null) {
            ArraySet<String> arraySet = BROADCAST_WHITE_LIST;
            synchronized (arraySet) {
                arraySet.addAll(collection);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkInitCostTime(long j3, String str, long j16) {
        QLog.d("mqq", 1, "MobileQQ.doInit " + str + " cost:" + (System.currentTimeMillis() - j3));
    }

    private void checkSizeAndReport(String str, String str2) {
        if (str.length() < 100 && str2.length() < 100) {
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("name", "" + str.length());
        hashMap.put("value", "" + str2.length());
        hashMap.put("trace", Log.getStackTraceString(new RuntimeException("setPropertySizeLimit")));
        ThreadManagerV2.excute(new Runnable() { // from class: mqq.app.MobileQQ.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    StatisticCollectorProxy.collectPerformance(null, "setPropertySizeLimit", true, 0L, 0L, hashMap, null);
                } catch (Throwable th5) {
                    QLog.e("mqq", 1, "report size and report error: ", th5);
                }
            }
        }, 16, null, true);
    }

    private void dispatchAccountEventToAppActivity(AppActivity appActivity, Constants.LogoutReason logoutReason, boolean z16) {
        if (z16) {
            QLog.d("MobileQQ", 1, "onLogout, ", appActivity);
            appActivity.onLogout(logoutReason);
            return;
        }
        appActivity.setAppRuntime(this.mAppRuntime);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.accountChanged) {
            appActivity.onAccountChanged();
            QLog.d("MobileQQ", 1, "onAccountChanged, ", appActivity, " cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } else {
            appActivity.onAccoutChangeFailed();
            QLog.d("MobileQQ", 1, "onAccountChangeFailed, ", appActivity, " cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void dispatchAccountEventToAppService(AppService appService, Constants.LogoutReason logoutReason, boolean z16) {
        if (z16) {
            QLog.d("MobileQQ", 1, "onLogout, ", appService);
            appService.onLogout(logoutReason);
            return;
        }
        appService.setAppRuntime(this.mAppRuntime);
        if (this.accountChanged) {
            QLog.d("MobileQQ", 1, "onAccountChanged, ", appService);
            appService.onAccountChanged();
        } else {
            QLog.d("MobileQQ", 1, "onAccountChangeFailed, ", appService);
            appService.onAccoutChangeFailed();
        }
    }

    private void dispatchAccountEventToBaseActivity(Activity activity, Constants.LogoutReason logoutReason, boolean z16) {
        if (z16) {
            QLog.d("MobileQQ", 1, "onLogout, ", activity);
            onLogout(activity, logoutReason);
            return;
        }
        setAppRuntime(activity, this.mAppRuntime);
        if (this.accountChanged) {
            QLog.d("MobileQQ", 1, "onAccountChanged, ", activity);
            onAccountChanged(activity);
        } else {
            QLog.d("MobileQQ", 1, "onAccountChangeFailed, ", activity);
            onAccoutChangeFailed(activity);
        }
    }

    private void exit(final boolean z16, boolean z17) {
        if (!MqqInjectorManager.instance().isPublicVersion() && this.mService == null) {
            return;
        }
        this.stopMSF = z17;
        if (getQQProcessName().endsWith(MsfConstants.PROCESS_VIDEO)) {
            this.mService.msfSub.unRegisterMsfService(Boolean.valueOf(!z16));
        }
        this.mService.reportMSFCallBackCost(-1L, true);
        closeAllActivities();
        QLog.d("mqq", 1, "exit isCrashed=", Boolean.valueOf(this.isCrashed), " stopMsfOnCrash=", Boolean.valueOf(this.stopMsfOnCrash));
        Runnable runnable = new Runnable() { // from class: mqq.app.MobileQQ.1
            @Override // java.lang.Runnable
            public void run() {
                MobileQQ.this.realExit(z16);
            }
        };
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    private SharedPreferences getLastLoginSp() {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), SP_LAST_LOGIN, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), SP_LAST_LOGIN, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    public static String getLogExternalPath(Context context) {
        return QLog.getLogExternalPath(context);
    }

    public static MobileQQ getMobileQQ() {
        return sMobileQQ;
    }

    public static String getProcessSuffix(String str, String str2) {
        return str.replace(str2, "").replace(":", "");
    }

    public static String getShortUinStr(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 4) {
            return str;
        }
        return str.substring(0, 4);
    }

    public static boolean isHasStoragePermission(Context context) {
        boolean z16 = sHasStoragePermission;
        if (!z16 && context != null && context.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            sHasStoragePermission = true;
            return true;
        }
        return z16;
    }

    public static boolean killProcess(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || str == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("mqq", 2, "kill process = " + str);
                }
                SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                return true;
            }
        }
        return false;
    }

    private void onAccountChanged(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).onAccountChanged();
        } else if (activity instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) activity).onAccountChanged();
        }
    }

    private void onAccoutChangeFailed(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).onAccoutChangeFailed();
        } else if (activity instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) activity).onAccoutChangeFailed();
        }
    }

    private void onLogout(Activity activity, Constants.LogoutReason logoutReason) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).onLogout(logoutReason);
        } else if (activity instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) activity).onLogout(logoutReason);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realCloseAllActivities() {
        BaseFragmentActivity baseFragmentActivity;
        Activity activity;
        AppActivity appActivity;
        try {
            int size = this.baseActivities.size();
            QLog.d("mqq", 1, "closeAllActivities...BaseActivity count: " + size);
            int i3 = size - 1;
            while (true) {
                BaseActivity baseActivity = null;
                if (i3 < 0) {
                    break;
                }
                WeakReference<BaseActivity> weakReference = this.baseActivities.get(i3);
                if (weakReference != null) {
                    baseActivity = weakReference.get();
                }
                if (baseActivity == null) {
                    this.baseActivities.remove(i3);
                } else if (!baseActivity.isFinishing()) {
                    baseActivity.finish();
                } else {
                    this.baseActivities.remove(i3);
                }
                i3--;
            }
            int size2 = this.appActivities.size();
            QLog.d("mqq", 1, "closeAllActivities...AppActivity count: " + size2);
            for (int i16 = size2 - 1; i16 >= 0; i16--) {
                WeakReference<AppActivity> weakReference2 = this.appActivities.get(i16);
                if (weakReference2 != null) {
                    appActivity = weakReference2.get();
                } else {
                    appActivity = null;
                }
                if (appActivity == null) {
                    this.appActivities.remove(i16);
                } else if (!appActivity.isFinishing()) {
                    appActivity.finish();
                } else {
                    this.appActivities.remove(i16);
                }
            }
            int size3 = this.commonActivities.size();
            QLog.d("mqq", 1, "closeAllActivities...other Activity count: " + size3);
            for (int i17 = size3 - 1; i17 >= 0; i17--) {
                WeakReference<Activity> weakReference3 = this.commonActivities.get(i17);
                if (weakReference3 != null) {
                    activity = weakReference3.get();
                } else {
                    activity = null;
                }
                if (activity == null) {
                    this.commonActivities.remove(i17);
                } else if (!activity.isFinishing()) {
                    activity.finish();
                } else {
                    this.commonActivities.remove(i17);
                }
            }
            int size4 = this.baseFragmentActivities.size();
            QLog.d("mqq", 1, "closeAllActivities... BaseFragmentActivity count: " + size4);
            for (int i18 = size4 - 1; i18 >= 0; i18--) {
                WeakReference<BaseFragmentActivity> weakReference4 = this.baseFragmentActivities.get(i18);
                if (weakReference4 != null) {
                    baseFragmentActivity = weakReference4.get();
                } else {
                    baseFragmentActivity = null;
                }
                if (baseFragmentActivity == null) {
                    this.baseFragmentActivities.remove(i18);
                } else if (!baseFragmentActivity.isFinishing()) {
                    baseFragmentActivity.finish();
                } else {
                    this.baseFragmentActivities.remove(i18);
                }
            }
        } catch (Exception e16) {
            QLog.e("mqq", 1, "closeAllActivities: " + e16.getMessage());
        }
    }

    private void realDispatchAccountEvent(Constants.LogoutReason logoutReason, int i3, boolean z16, String str) {
        boolean z17;
        if (logoutReason != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("MobileQQ", 1, "realDispatchAccountEvent isLogout: " + z17 + ", accountChanged: " + this.accountChanged);
        for (int size = this.accountCallbacks.size() - 1; size >= 0; size--) {
            WeakReference<IAccountCallback> weakReference = this.accountCallbacks.get(size);
            if (weakReference == null) {
                this.accountCallbacks.remove(size);
            } else {
                IAccountCallback iAccountCallback = weakReference.get();
                if (iAccountCallback == null) {
                    this.accountCallbacks.remove(size);
                } else if (z17) {
                    iAccountCallback.onLogout(logoutReason);
                } else if (this.accountChanged) {
                    iAccountCallback.onAccountChanged(this.mAppRuntime);
                } else {
                    iAccountCallback.onAccountChangeFailed(this.mAppRuntime);
                }
            }
        }
        for (int size2 = this.baseActivities.size() - 1; size2 >= 0; size2--) {
            BaseActivity baseActivity = this.baseActivities.get(size2).get();
            if (baseActivity == null) {
                this.baseActivities.remove(size2);
            } else {
                dispatchAccountEventToBaseActivity(baseActivity, logoutReason, z17);
            }
        }
        for (int size3 = this.appActivities.size() - 1; size3 >= 0; size3--) {
            AppActivity appActivity = this.appActivities.get(size3).get();
            if (appActivity == null) {
                this.appActivities.remove(size3);
            } else {
                dispatchAccountEventToAppActivity(appActivity, logoutReason, z17);
            }
        }
        for (int size4 = this.appServices.size() - 1; size4 >= 0; size4--) {
            AppService appService = this.appServices.get(size4).get();
            if (appService == null) {
                this.appServices.remove(size4);
            } else {
                dispatchAccountEventToAppService(appService, logoutReason, z17);
            }
        }
        Foreground.updateRuntimeState(this.mAppRuntime);
        if (!getPackageName().equals(getQQProcessName())) {
            return;
        }
        if (z17) {
            ThreadManagerV2.excute(new Runnable() { // from class: mqq.app.MobileQQ.6
                @Override // java.lang.Runnable
                public void run() {
                    MobileQQ.this.sendBroadcast(new Intent(NewIntent.ACTION_LOGOUT));
                }
            }, 16, null, false);
            return;
        }
        if (!this.accountChanged) {
            return;
        }
        if (!z16) {
            Intent intent = new Intent(NewIntent.ACTION_ACCOUNT_CHANGED);
            intent.putExtra("account", this.mAppRuntime.getAccount());
            intent.putExtra("type", i3);
            intent.setPackage(PACKAGE_NAME);
            sendBroadcast(intent);
            Intent intent2 = new Intent("mqq.intent.action.EXIT_" + sMobileQQ.getPackageName());
            intent2.putExtra("K_EXCEP", str);
            intent2.setPackage(PACKAGE_NAME);
            sendBroadcast(intent2);
            try {
                QIPCServerHelper.getInstance().notifyOnAccountChanged();
                return;
            } catch (Exception e16) {
                QLog.d("mqq", 1, "onAccountChanged", e16);
                return;
            }
        }
        Intent intent3 = new Intent(ACTION_MAIN_PROCESS_ALIVE);
        intent3.setPackage(PACKAGE_NAME);
        sendBroadcast(intent3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realExit(boolean z16) {
        AppRuntime appRuntime;
        try {
            if (this.mAppRuntime == null) {
                waitAppRuntime();
            }
            if (!getQQProcessName().endsWith(MsfConstants.PROCESS_VIDEO)) {
                AppRuntime appRuntime2 = this.mAppRuntime;
                if (appRuntime2 != null) {
                    appRuntime2.onDestroy();
                }
                if (!z16) {
                    this.mService.msfSub.unRegisterMsfService();
                }
                this.mService.msfSub.unbindMsfService();
            }
            if (!this.isCrashed) {
                this.doExit.run();
                return;
            }
            sendBroadcast(new Intent("mqq.intent.action.EXIT_" + processName));
            String qQProcessName = getQQProcessName();
            if (qQProcessName.equals(MainService.QQPROCESSNAME) && this.stopMsfOnCrash) {
                QLog.d("mqq", 1, "stop msf service");
                this.mService.msfSub.stopMsfService();
            } else if (qQProcessName.endsWith(MsfConstants.PROCESS_VIDEO) && (appRuntime = this.mAppRuntime) != null) {
                appRuntime.onDestroy();
            }
            System.exit(0);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "exit exception=" + e16);
            }
            System.exit(0);
        }
    }

    public static void restrictBroadcast(Intent intent) {
        if (TextUtils.isEmpty(intent.getPackage()) && (intent.getFlags() & 16777216) == 0) {
            synchronized (BROADCAST_WHITE_LIST) {
                if (!hasInit) {
                    try {
                        String string = BaseApplication.getContext().getSharedPreferences(PREF_BROADCAST, 4).getString(PREF_WHITE_LIST_KEY, null);
                        if (string != null) {
                            JSONArray jSONArray = new JSONObject(string).getJSONArray(PREF_WHITE_LIST_KEY);
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                BROADCAST_WHITE_LIST.add(jSONArray.optString(i3, ""));
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    hasInit = true;
                }
                if (!BROADCAST_WHITE_LIST.contains(intent.getAction())) {
                    intent.setPackage(PACKAGE_NAME);
                }
            }
        }
    }

    private void setAppRuntime(Activity activity, AppRuntime appRuntime) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).setAppRuntime(appRuntime);
        } else if (activity instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) activity).setAppRuntime(appRuntime);
        }
    }

    public static void setMainProcessName(String str) {
        PACKAGE_NAME = str;
    }

    public static long string2Long(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.w("mqq", 2, "string2Long number is empty");
            }
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("mqq", 2, "string2Long catch exception");
            }
            e16.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBaseActivity(BaseActivity baseActivity) {
        this.baseActivities.add(0, new WeakReference<>(baseActivity));
    }

    public void addCommonActivity(Activity activity) {
        this.commonActivities.add(0, new WeakReference<>(activity));
    }

    @Deprecated
    public void addOtherTypeActivity(Activity activity) {
        addCommonActivity(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        sMobileQQ = this;
        initProcess();
    }

    public void closeAllActivities() {
        Runnable runnable = new Runnable() { // from class: mqq.app.MobileQQ.2
            @Override // java.lang.Runnable
            public void run() {
                MobileQQ.this.realCloseAllActivities();
            }
        };
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public void crashed() {
        this.isCrashed = true;
    }

    public void createNewRuntime(SimpleAccount simpleAccount, boolean z16, boolean z17, int i3, String str) {
        QLog.d("MobileQQ", 1, "createNewRuntime", ", needSaveLoginTime:", Boolean.valueOf(z17), ", forLogin:", Boolean.valueOf(z16), ", cnrType:", Integer.valueOf(i3), ", process:", str);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(simpleAccount, i3, z16, z17, str);
        if (this.mAppRuntime == null) {
            anonymousClass5.run();
        } else {
            this.mHandler.post(anonymousClass5);
        }
    }

    public abstract AppRuntime createRuntime(String str, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchAccountEvent(Constants.LogoutReason logoutReason, int i3, boolean z16, String str) {
        boolean z17;
        boolean z18 = false;
        if (logoutReason != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("MobileQQ", 1, "INIT|dispatch to ntsdk callback: ", this.ntsdkInitAccountCallback);
        if (this.ntsdkInitAccountCallback != null) {
            if (z17) {
                this.ntsdkInitAccountCallback.onLogout(logoutReason);
            } else if (this.accountChanged) {
                this.ntsdkInitAccountCallback.onAccountChanged(this.mAppRuntime);
            } else {
                this.ntsdkInitAccountCallback.onAccountChangeFailed(this.mAppRuntime);
            }
        }
        QLog.d("MobileQQ", 1, "INIT|dispatchAccountEvent, accChange: ", Boolean.valueOf(this.accountChanged), " processName: ", processName, " ntInitUin: ", LogUtil.wrapLogUin(this.ntInitUin), " curUin: ", LogUtil.wrapLogUin(this.mAppRuntime.getCurrentUin()), " useMergeAccChange: ", Boolean.valueOf(this.useMergeAccountChange));
        synchronized (this.switchAccountLock) {
            if (this.accountChanged && PACKAGE_NAME.equals(processName) && !this.ntInitUin.equals(this.mAppRuntime.getCurrentUin()) && this.useMergeAccountChange) {
                QLog.d("MobileQQ", 1, "INIT|dispatchAccountEvent wait nt init finish");
                this.logoutParam = new LogoutParam(logoutReason, i3, z16, str);
                z18 = true;
            }
        }
        if (!z18) {
            QLog.d("MobileQQ", 1, "INIT|dispatchAccountEvent directly");
            realDispatchAccountEvent(logoutReason, i3, z16, str);
        }
    }

    public final void doInit(boolean z16) {
        SimpleAccount simpleAccount;
        if (!this.mRuntimeState.compareAndSet(1, 2)) {
            QLog.d("mqq", 1, "doInit not need to execute, state:" + this.mRuntimeState.get());
            return;
        }
        try {
            boolean isNeedMSF = isNeedMSF(processName);
            QLog.d("mqq", 1, "doInit begin with" + processName);
            if (!processName.endsWith(":MSF") && isNeedMSF) {
                this.mService = new MainService(this, getAppId(processName), getBootBroadcastName(processName), z16);
                if (!getQQProcessName().endsWith(MsfConstants.PROCESS_VIDEO)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.mService.msfSub.initMsfService();
                    checkInitCostTime(currentTimeMillis, "initMsfService", 1000L);
                }
                List<SimpleAccount> allAccounts = getAllAccounts();
                if (allAccounts != null && allAccounts.size() > 0) {
                    simpleAccount = allAccounts.get(0);
                } else {
                    simpleAccount = null;
                }
                if (simpleAccount == null) {
                    QLog.d("mqq", 1, "doInit last == null goto to sharedPreferences....");
                    SharedPreferences sharedPreferences = getSharedPreferences("share", 0);
                    if (sharedPreferences != null) {
                        String string = sharedPreferences.getString(PREF_KEY, null);
                        if (QLog.isColorLevel()) {
                            QLog.d("mqq", 1, "doInit last == null goto to sharedPreferences....uin = " + string);
                        }
                        if (string != null) {
                            sharedPreferences.edit().remove(PREF_KEY).commit();
                            simpleAccount = new SimpleAccount();
                            simpleAccount.setUin(string);
                            simpleAccount.isLogined();
                            simpleAccount.setAttribute(SimpleAccount._ISLOGINED, String.valueOf(true));
                        }
                    }
                }
                createNewRuntime(simpleAccount, false, processName.equals(PACKAGE_NAME), 5, null);
            }
            sendBroadcast(new Intent("mqq.intent.action.LAUNCH_" + processName));
            synchronized (this.mRuntimeState) {
                this.mRuntimeState.set(3);
                this.mRuntimeState.notifyAll();
                this.hasNotify = true;
                QLog.d("mqq_wait", 1, "doInit finish, notifyAll");
            }
            QLog.d("mqq", 1, "doInit finished");
            this.mHandler.sendEmptyMessageDelayed(2, 1000L);
        } catch (Throwable th5) {
            try {
                QLog.e("mqq", 1, "doInit failed", th5);
                throw new RuntimeException(th5);
            } catch (Throwable th6) {
                synchronized (this.mRuntimeState) {
                    this.mRuntimeState.set(3);
                    this.mRuntimeState.notifyAll();
                    this.hasNotify = true;
                    QLog.d("mqq_wait", 1, "doInit finish, notifyAll");
                    QLog.d("mqq", 1, "doInit finished");
                    this.mHandler.sendEmptyMessageDelayed(2, 1000L);
                    throw th6;
                }
            }
        }
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public boolean doesHasPhonePermission() {
        BaseApplication baseApplication;
        if (!sHasPhonePermission && (baseApplication = BaseApplication.context) != null && baseApplication.checkSelfPermission(PERMS[1]) == 0) {
            sHasPhonePermission = true;
        }
        return sHasPhonePermission;
    }

    @Override // com.tencent.qphone.base.util.BaseApplication
    public boolean doesHasSDCardPermission() {
        BaseApplication baseApplication;
        if (!sHasSDCardPermission && (baseApplication = BaseApplication.context) != null && baseApplication.checkSelfPermission(PERMS[0]) == 0) {
            sHasSDCardPermission = true;
        }
        return sHasSDCardPermission;
    }

    public void ensureInitProperty() {
        if (this.properties != null) {
            return;
        }
        synchronized (this) {
            if (this.properties != null) {
                return;
            }
            Properties properties = new Properties();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = openFileInput(PROPERTY_NAME);
                properties.load(fileInputStream);
                if (properties.isEmpty()) {
                    QLog.i("mqq", 1, "ensureInitProperty is empty");
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e16) {
                        e = e16;
                        e.printStackTrace();
                        this.properties = properties;
                    }
                }
            } catch (Throwable th5) {
                try {
                    QLog.e("mqq", 1, "", th5);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            e = e17;
                            e.printStackTrace();
                            this.properties = properties;
                        }
                    }
                } finally {
                }
            }
            this.properties = properties;
        }
    }

    public List<SimpleAccount> getAllAccounts() {
        List<SimpleAccount> list = this.sortAccountList;
        if (list == null) {
            return refreAccountList();
        }
        return list;
    }

    public List<SimpleAccount> getAllNotSynAccountList() {
        return this.sortAccountList;
    }

    public abstract int getAppId(String str);

    public AppRuntime getAppRuntime(String str) throws AccountNotMatchException {
        AppRuntime waitAppRuntime = waitAppRuntime();
        if (Objects.equals(str, waitAppRuntime.getAccount())) {
            return waitAppRuntime;
        }
        throw new AccountNotMatchException(waitAppRuntime.getAccount(), str);
    }

    public abstract String getBootBroadcastName(String str);

    public SimpleAccount getFirstSimpleAccount() {
        List<SimpleAccount> allAccounts = getAllAccounts();
        if (allAccounts != null && allAccounts.size() != 0) {
            return allAccounts.get(0);
        }
        return null;
    }

    public String getLastLoginUin() {
        return getLastLoginSp().getString("uin", "");
    }

    public int getMsfConnectedNetType() {
        try {
            return this.mService.msfSub.getConnectedNetowrkType();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getProperty(String str) {
        ensureInitProperty();
        String property = this.properties.getProperty(str);
        if (TextUtils.isEmpty(property)) {
            String decodeString = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeString(PROPERTY_MMKV_PREFIX + str, null);
            if (!TextUtils.isEmpty(decodeString)) {
                QLog.e("mqq", 1, "getProperty is null, but mmkv contains value, name:" + str + " value:" + decodeString);
                return decodeString;
            }
            return property;
        }
        return property;
    }

    public String getQQProcessName() {
        String processName2;
        if (processName == null) {
            int i3 = 0;
            do {
                processName2 = MsfSdkUtils.getProcessName(this);
                i3++;
                if (i3 >= 3) {
                    break;
                }
            } while ("unknown".equals(processName2));
            if ("unknown".equals(processName2)) {
                processName2 = PACKAGE_NAME;
            }
            processName = processName2;
            BaseApplication.processName = processName2;
        }
        return processName;
    }

    public Activity getResumeActivity() {
        for (WeakReference<BaseActivity> weakReference : this.baseActivities) {
            BaseActivity baseActivity = weakReference.get();
            if (baseActivity != null && baseActivity.isResume()) {
                return weakReference.get();
            }
        }
        Iterator<WeakReference<BaseFragmentActivity>> it = this.baseFragmentActivities.iterator();
        while (it.hasNext()) {
            BaseFragmentActivity baseFragmentActivity = it.next().get();
            if (baseFragmentActivity != null && baseFragmentActivity.isResume()) {
                return baseFragmentActivity;
            }
        }
        Iterator<WeakReference<AppActivity>> it5 = this.appActivities.iterator();
        while (it5.hasNext()) {
            AppActivity appActivity = it5.next().get();
            if (appActivity != null && appActivity.isResume()) {
                return appActivity;
            }
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        if (message == null) {
            QLog.d("MobileQQ", 1, "handleMessage But msg is null", new Throwable("handleMessage But msg is null"));
            return true;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        LogoutParam logoutParam = (LogoutParam) message.obj;
                        realDispatchAccountEvent(logoutParam.reason, logoutParam.crnType, logoutParam.isFirstTime, logoutParam.process);
                    }
                } else {
                    String str = (String) message.obj;
                    String lastLoginUin = getLastLoginUin();
                    if (lastLoginUin == null || !lastLoginUin.equals(str)) {
                        setLastLoginUin(str);
                    }
                }
            } else {
                BaseApplication.monitor.setProcessName(processName);
                try {
                    BaseApplication.monitor.start();
                } catch (Throwable th5) {
                    QLog.d("mqq", 1, "", th5);
                }
            }
        } else {
            int i16 = message.arg1;
            if (message.arg2 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            dispatchAccountEvent(null, i16, z16, (String) message.obj);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initProcess() {
        String qQProcessName = getQQProcessName();
        if (PACKAGE_NAME.equals(qQProcessName)) {
            sProcessId = 1;
        } else if (qQProcessName.endsWith(ProcessConstant.MSF)) {
            sProcessId = 4;
        } else if (qQProcessName.endsWith("qzone")) {
            sProcessId = 2;
        } else if (qQProcessName.endsWith("web")) {
            sProcessId = 3;
        } else if (qQProcessName.endsWith(ProcessConstant.NEARBY)) {
            sProcessId = 5;
        } else if (qQProcessName.endsWith(ProcessConstant.LOLA)) {
            sProcessId = 6;
        } else if (qQProcessName.endsWith("tool")) {
            sProcessId = 7;
        } else if (qQProcessName.endsWith(ProcessConstant.QZONELIVE)) {
            sProcessId = 8;
        } else if (qQProcessName.endsWith("peak")) {
            sProcessId = 9;
        } else if (qQProcessName.endsWith("video")) {
            sProcessId = 10;
        } else if (qQProcessName.endsWith("miniapp")) {
            sProcessId = 11;
        } else if (qQProcessName.endsWith("qqstranger")) {
            sProcessId = 13;
        } else if (qQProcessName.contains(":privileged_process")) {
            sProcessId = 14;
        } else if (qQProcessName.contains(":troophomework")) {
            sProcessId = 15;
        } else if (qQProcessName.contains(":sandboxed_process")) {
            sProcessId = 16;
        } else if (qQProcessName.contains(":account")) {
            sProcessId = 17;
        } else {
            sProcessId = -1;
        }
        BaseApplication.processName = qQProcessName;
    }

    public boolean isLoginByNT() {
        return QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeBool(NT_LOGIN_SWITCH_KEY, false);
    }

    public boolean isModuleLoaded(String str) {
        Boolean bool;
        if (str != null && (bool = S_MODULE_LOADED.get(str)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public abstract boolean isNeedMSF(String str);

    public boolean isRuntimeReady() {
        if (this.mRuntimeState.get() == 3) {
            return true;
        }
        return false;
    }

    public void loadModule(String str) {
        if (str == null) {
            return;
        }
        S_MODULE_LOADED.put(str, Boolean.TRUE);
    }

    public boolean onActivityCreate(Object obj, Intent intent) {
        return false;
    }

    @Override // com.tencent.qphone.base.util.BaseApplication, android.app.Application
    public void onCreate() {
        sMobileQQ = this;
        super.onCreate();
    }

    public void onSendBroadcast(Context context, Intent intent) {
        synchronized (this.mBroadcastCallbacks) {
            Iterator<IBroadcastCallback> it = this.mBroadcastCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onSendBroadcast(context, intent);
            }
        }
    }

    public void otherProcessExit(boolean z16) {
        exit(z16, false);
    }

    public AppRuntime peekAppRuntime() {
        return this.mAppRuntime;
    }

    public void qqProcessExit(boolean z16) {
        exit(false, z16);
    }

    public void realInvokeDispatchAccountEvent(AppRuntime appRuntime) {
        synchronized (this.switchAccountLock) {
            QLog.d("MobileQQ", 1, "realInvokeDispatchAccountEvent, logoutParam: ", this.logoutParam, " curUin: ", LogUtil.wrapLogUin(appRuntime.getCurrentUin()));
            this.ntInitUin = appRuntime.getCurrentUin();
            if (this.logoutParam != null) {
                Message obtainMessage = this.mHandler.obtainMessage(4);
                obtainMessage.obj = this.logoutParam;
                this.logoutParam = null;
                obtainMessage.sendToTarget();
            }
        }
    }

    public List<SimpleAccount> refreAccountList() {
        return setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    }

    public void registerAccountCallback(IAccountCallback iAccountCallback) {
        this.accountCallbacks.add(0, new WeakReference<>(iAccountCallback));
    }

    public void registerBroadcastCallback(IBroadcastCallback iBroadcastCallback) {
        synchronized (this.mBroadcastCallbacks) {
            this.mBroadcastCallbacks.add(iBroadcastCallback);
        }
    }

    public void registerNTSDKAccountCallback(IAccountCallback iAccountCallback) {
        this.ntsdkInitAccountCallback = iAccountCallback;
        QLog.d("MobileQQ", 1, "INIT|registerNTSDKAccountCallback: ", iAccountCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeBaseActivity(BaseActivity baseActivity) {
        this.baseActivities.remove(new WeakReference(baseActivity));
    }

    public void removeCommonActivity(Activity activity) {
        this.commonActivities.remove(new WeakReference(activity));
    }

    @Deprecated
    public void removeOtherTypeActivity(Activity activity) {
        removeCommonActivity(activity);
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        restrictBroadcast(intent);
        super.sendBroadcast(intent);
        sMobileQQ.onSendBroadcast(this, intent);
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        restrictBroadcast(intent);
        super.sendOrderedBroadcast(intent, str);
        sMobileQQ.onSendBroadcast(this, intent);
    }

    public void setAutoLogin(boolean z16) {
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime != null && appRuntime.getAccount() != null && this.mAppRuntime.getAccount().length() > 0) {
            this.mAppRuntime.setAutoLogin(z16);
        }
    }

    public void setLastLoginUin(String str) {
        getLastLoginSp().edit().putString("uin", str).apply();
    }

    public void setProperty(final String str, final String str2) {
        if (str.length() > 100 && !MqqInjectorManager.instance().isPublicVersion()) {
            throw new IllegalArgumentException("too long property key");
        }
        checkSizeAndReport(str, str2);
        ensureInitProperty();
        this.properties.setProperty(str, str2);
        if (str.endsWith(Constants.Key._logintime.toString())) {
            setSortAccountList(this.sortAccountList);
        }
        if (this.subHandler == null) {
            synchronized (this.properties) {
                if (this.subHandler == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("property-saver");
                    baseHandlerThread.start();
                    this.subHandler = new Handler(baseHandlerThread.getLooper());
                }
            }
        }
        this.subHandler.post(new Runnable() { // from class: mqq.app.MobileQQ.8
            @Override // java.lang.Runnable
            public void run() {
                FileOutputStream fileOutputStream;
                Throwable th5;
                try {
                    try {
                        fileOutputStream = MobileQQ.this.openFileOutput(MobileQQ.PROPERTY_NAME, 0);
                    } catch (Throwable th6) {
                        fileOutputStream = null;
                        th5 = th6;
                    }
                    try {
                        MobileQQ.this.properties.store(fileOutputStream, (String) null);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th7) {
                        th5 = th7;
                        try {
                            QLog.e("mqq", 1, "", th5);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeString(MobileQQ.PROPERTY_MMKV_PREFIX + str, str2);
                        } catch (Throwable th8) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            throw th8;
                        }
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeString(MobileQQ.PROPERTY_MMKV_PREFIX + str, str2);
            }
        });
    }

    public List<SimpleAccount> setSortAccountList(List<SimpleAccount> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new Comparator<SimpleAccount>() { // from class: mqq.app.MobileQQ.4
                @Override // java.util.Comparator
                public int compare(SimpleAccount simpleAccount, SimpleAccount simpleAccount2) {
                    MobileQQ mobileQQ = MobileQQ.this;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(simpleAccount.getUin());
                    Constants.Key key = Constants.Key._logintime;
                    sb5.append(key);
                    long string2Long = MobileQQ.string2Long(mobileQQ.getProperty(sb5.toString()));
                    long string2Long2 = MobileQQ.string2Long(MobileQQ.this.getProperty(simpleAccount2.getUin() + key));
                    StringBuilder sb6 = new StringBuilder(32);
                    sb6.append(MsfSdkUtils.getShortUin(simpleAccount.getUin()));
                    sb6.append(TokenParser.SP);
                    sb6.append(simpleAccount.isLogined());
                    sb6.append(TokenParser.SP);
                    sb6.append(string2Long);
                    sb6.append(TokenParser.SP);
                    sb6.append(MsfSdkUtils.getShortUin(simpleAccount2.getUin()));
                    sb6.append(TokenParser.SP);
                    sb6.append(simpleAccount2.isLogined());
                    sb6.append(TokenParser.SP);
                    sb6.append(string2Long2);
                    QLog.d("mqq", 1, sb6.toString());
                    if (string2Long2 > string2Long) {
                        return 1;
                    }
                    return string2Long2 < string2Long ? -1 : 0;
                }
            });
            if (list != this.sortAccountList) {
                this.sortAccountList = list;
            }
            return this.sortAccountList;
        }
        return this.sortAccountList;
    }

    public void setUseMergeAccountChange(boolean z16) {
        QLog.d("MobileQQ", 1, "setUseMergeAccountChange: ", Boolean.valueOf(z16));
        this.useMergeAccountChange = z16;
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        intent.putExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY, getClass().getSimpleName());
        intent.putExtra("preAct_time", System.currentTimeMillis());
        super.startActivity(intent);
    }

    public void startService() {
        MainService mainService = this.mService;
        if (mainService != null) {
            mainService.start();
        }
    }

    public void stopMsfOnCrash(boolean z16) {
        this.stopMsfOnCrash = z16;
        if (z16) {
            QLog.d("mqq", 1, "stop and kill msf stopMsfOnCrash=true");
            try {
                this.mService.msfSub.unRegisterMsfService();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            try {
                this.mService.msfSub.unbindMsfService();
                this.mService.msfSub.stopMsfService();
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            try {
                Intent intent = new Intent("com.tencent.process.exit");
                String str = MainService.QQPROCESSNAME + ":MSF";
                intent.putExtra("procName", str);
                intent.putExtra("verify", MsfExitReceiver.getLocalVerify(str, false));
                sendBroadcast(intent);
            } catch (Throwable th7) {
                th7.printStackTrace();
            }
        }
    }

    public void unregisterAccountCallback(IAccountCallback iAccountCallback) {
        this.accountCallbacks.remove(new WeakReference(iAccountCallback));
    }

    public void unregisterBroadcastCallback(IBroadcastCallback iBroadcastCallback) {
        synchronized (this.mBroadcastCallbacks) {
            this.mBroadcastCallbacks.remove(iBroadcastCallback);
        }
    }

    public AppRuntime waitAppRuntime(BaseActivity baseActivity) {
        int i3 = this.mRuntimeState.get();
        if (i3 != 3) {
            if (i3 == 1) {
                int priority = Thread.currentThread().getPriority();
                Thread.currentThread().setPriority(10);
                QLog.e("mqq", 1, "waitInit when empty: ", new RuntimeException(""));
                doInit(true);
                Thread.currentThread().setPriority(priority);
            }
            synchronized (this.mRuntimeState) {
                if (this.mRuntimeState.get() == 2) {
                    try {
                        QLog.e("mqq_wait", 1, "wait when hasNotify=", Boolean.valueOf(this.hasNotify));
                        LockMethodProxy.wait(this.mRuntimeState);
                    } catch (InterruptedException e16) {
                        QLog.e("mqq", 1, "waitInit failed", e16);
                    }
                }
            }
        }
        return this.mAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBaseActivity(BaseFragmentActivity baseFragmentActivity) {
        this.baseFragmentActivities.add(0, new WeakReference<>(baseFragmentActivity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeBaseActivity(BaseFragmentActivity baseFragmentActivity) {
        this.baseFragmentActivities.remove(new WeakReference(baseFragmentActivity));
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        restrictBroadcast(intent);
        super.sendBroadcast(intent, str);
        sMobileQQ.onSendBroadcast(this, intent);
    }

    @Override // com.tencent.mobileqq.qfix.ApplicationDelegate, android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        restrictBroadcast(intent);
        super.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
        sMobileQQ.onSendBroadcast(this, intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        intent.putExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY, getClass().getSimpleName());
        intent.putExtra("preAct_time", System.currentTimeMillis());
        super.startActivity(intent, bundle);
    }

    public AppRuntime waitAppRuntime() {
        return waitAppRuntime(null);
    }

    public void onActivityFocusChanged(AppActivity appActivity, boolean z16) {
    }

    public void reportPCActive(String str, int i3) {
    }
}
