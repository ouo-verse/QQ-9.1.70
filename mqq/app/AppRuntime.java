package mqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ManagerFactory;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.msf.core.auth.api.UIDFileUtil;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qroute.utils.ProcessChecker;
import com.tencent.mobileqq.qroute.utils.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DBBuildUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import eipc.EIPCResult;
import java.io.File;
import java.lang.ref.Reference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import mqq.app.remote.ServiceRemoteProxy;
import mqq.inject.MqqInjectorManager;
import mqq.manager.ISecurityFileFrameworkService;
import mqq.manager.Manager;
import mqq.manager.impl.SecurityFileFrameworkServiceImpl;
import mqq.observer.AccountObserver;
import mqq.observer.BusinessObserver;
import mqq.util.NTAdapterThreadHelper;
import mqq.util.RuntimeServiceHelper;
import mqq.util.SampleUtils;
import mqq.util.UINotifyQueue;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AppRuntime {
    public static final int ACCOUNT_MANAGER = 0;
    public static final int END_UN_LOGIN_MANAGER = 4;
    private static final int IMPORT_RUNTIME_DEPEND_CNT = 2;
    public static final int LOGIN_AUTO = 2;
    public static final int LOGIN_MANUAL = 1;
    public static final int LOGIN_UNINIT = 0;
    public static final String PROCESS = "process";
    public static final int PUSH_MANAGER = 4;
    private static final int RUNTIME_SERVICE_CAPACITY = 1024;
    public static final int SERVER_CONFIG_MANAGER = 3;
    public static final String SP_UIN_TO_UID = "MSF_SP_UIN_TO_UID";
    protected static final String TAG = "mqq";
    public static final int TICKET_MANAGER = 2;
    public static final int TYPE_CREATENEWRUNTIME_CHANGUIN_LOGIN = 4;
    public static final int TYPE_CREATENEWRUNTIME_DIRECT_LOGIN = 1;
    public static final int TYPE_CREATENEWRUNTIME_DIRECT_NET_LOGIN = 3;
    public static final int TYPE_CREATENEWRUNTIME_DOINIT = 5;
    public static final int TYPE_CREATENEWRUNTIME_SWITCHACCOUNT = 2;
    public static final int WTLOGIN_MANAGER = 1;

    @ConfigInject(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends ManagerFactory>> sProxyManagerFactory;
    private BaseCacheManager cacheManager;
    protected boolean isAppRuntimeValid;
    protected boolean isLogin;
    private boolean isRunning;
    private SimpleAccount mAccount;
    private MobileQQ mContext;
    private volatile EntityManagerFactory mEntityManagerFactory;
    protected String mProcessName;
    private MainService mService;
    private String mTempPath;
    ToolProcReceiver mToolReceiver;
    Bundle modularSaveInstance;
    private BaseProxyManager proxyManager;
    private UINotifyQueue queue;
    private String uid;
    private int curAccLoginType = 5;
    private final boolean enableRuntimeReport = SampleUtils.hitReport(1000, 10);
    protected volatile boolean isRuntimeServiceCleared = false;
    private final List<Reference<BusinessObserver>> observers = new Vector();
    private final Set<Class> withoutUiNotifyObserver = new HashSet();
    private final Set<Class> directNotifyObserver = new HashSet();
    private final Set<Integer> directNotifyType = new HashSet();
    private final ThreadLocal<ArrayList<String>> mRuntimeServiceCycleCheck = new ThreadLocal<>();
    private final AtomicInteger dependTaskFinishCnt = new AtomicInteger(0);
    private long lUin = -1;
    private final SparseArray<Manager> managers = new SparseArray<>();
    private final ConcurrentHashMap<String, String> businessRootFilePaths = new ConcurrentHashMap<>();
    private final Object mEntityManagerFactoryLock = new Object();
    protected AtomicBoolean isNtLogout = new AtomicBoolean(false);
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private final ConcurrentHashMap<Class<?>, IRuntimeService> runtimeServices = new ConcurrentHashMap<>(1024);
    private final ConcurrentHashMap<Class<?>, Object> serviceLocks = new ConcurrentHashMap<>();
    private final AppRuntimeServiceHelper serviceHelper = new AppRuntimeServiceHelper();
    byte[] uinSign = null;
    private Intent mKickIntent = null;
    public boolean isBackgroundPause = false;
    public boolean isBackgroundStop = false;
    public boolean isClearTaskBySystem = false;
    public AppRuntime parentRuntime = null;
    ConcurrentHashMap<String, AppRuntime> subRuntimeMap = new ConcurrentHashMap<>();
    private final ServletContainer mServletContainer = new ServletContainer(this);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface InterceptKickListener {
        void onInterceptKicked(KickParams kickParams);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class KickParams {
        public Object fromServiceMsg;
        boolean isSameDevice;
        boolean isTokenExpired;
        public Object toServiceMsg;

        public KickParams(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, boolean z17) {
            this.toServiceMsg = toServiceMsg;
            this.fromServiceMsg = fromServiceMsg;
            this.isTokenExpired = z16;
            this.isSameDevice = z17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum Status {
        online(11),
        offline(21),
        away(31),
        invisiable(41),
        busy(50),
        qme(60),
        dnd(70),
        receiveofflinemsg(95);

        private final int value;

        Status(int i3) {
            this.value = i3;
        }

        public static Status build(int i3) {
            if (i3 != 11) {
                if (i3 != 21) {
                    if (i3 != 31) {
                        if (i3 != 41) {
                            if (i3 != 50) {
                                if (i3 != 60) {
                                    if (i3 != 70) {
                                        if (i3 != 95) {
                                            return null;
                                        }
                                        return receiveofflinemsg;
                                    }
                                    return dnd;
                                }
                                return qme;
                            }
                            return busy;
                        }
                        return invisiable;
                    }
                    return away;
                }
                return offline;
            }
            return online;
        }

        public int getValue() {
            return this.value;
        }
    }

    static {
        ArrayList<Class<? extends ManagerFactory>> arrayList = new ArrayList<>();
        sProxyManagerFactory = arrayList;
        arrayList.add(com.tencent.mobileqq.app.proxy.b.class);
    }

    @Nullable
    private String callMainProcessForSecurityFileResult(@Nullable ISecurityFileHelper iSecurityFileHelper) {
        if (QLog.isColorLevel()) {
            QLog.d(SecurityFileFrameworkServiceImpl.TAG, 2, "callMainProcessForSecurityFileResult from= ", MobileQQ.processName);
        }
        this.mTempPath = null;
        Bundle bundle = new Bundle();
        if (iSecurityFileHelper != null) {
            bundle.putString(SecurityFileModule.BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME, iSecurityFileHelper.getClass().getName());
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), SecurityFileModule.NAME, SecurityFileModule.ACTION_GET_BUSINESS_ROOT_PATH, bundle);
        if (callServer != null) {
            if (callServer.isSuccess()) {
                String string = callServer.data.getString(SecurityFileModule.BUNDLE_KEY_RETURN_FILE_PATH);
                this.mTempPath = string;
                if (TextUtils.isEmpty(string)) {
                    QLog.d(SecurityFileFrameworkServiceImpl.TAG, 1, "result success but path is empty");
                } else if (QLog.isColorLevel()) {
                    QLog.d(SecurityFileFrameworkServiceImpl.TAG, 2, this.mTempPath);
                }
            } else {
                QLog.d(SecurityFileFrameworkServiceImpl.TAG, 1, "result fail: code=", Integer.valueOf(callServer.code));
                if (callServer.f396321e != null && QLog.isColorLevel()) {
                    QLog.d(SecurityFileFrameworkServiceImpl.TAG, 2, "result fail: e=", callServer.f396321e.getMessage());
                }
            }
        } else {
            QLog.d(SecurityFileFrameworkServiceImpl.TAG, 1, "result null ");
        }
        return this.mTempPath;
    }

    @Deprecated
    public static boolean canAutoLoginFromCache(Context context, String str) {
        boolean z16;
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_login_auto", 4);
        int i3 = sharedPreferences.getInt(str, 0);
        if (i3 == 0) {
            if (sharedPreferences.getBoolean("login_auto" + str, true)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            sharedPreferences.edit().putInt(str, i3).commit();
        }
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "CNR getAutoLoginSharePre auto =", Boolean.valueOf(z16), ", loginState=", Integer.valueOf(i3));
        }
        return z16;
    }

    private void clearRuntimeServiceDelay() {
        this.serviceHelper.clearRuntimeServiceDelay();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: mqq.app.a
            @Override // java.lang.Runnable
            public final void run() {
                AppRuntime.this.lambda$clearRuntimeServiceDelay$0();
            }
        }, 16, null, true, 5000L);
    }

    private void ensureLock(Class<?> cls) {
        if (this.serviceLocks.get(cls) == null) {
            synchronized (this.serviceLocks) {
                if (this.serviceLocks.get(cls) == null) {
                    this.serviceLocks.put(cls, new Object());
                }
            }
        }
    }

    private String getClassLoaderInfo(Class cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return "";
        }
        return ", class loader name: " + classLoader.getClass().getName() + ", class loader hash:" + classLoader.hashCode();
    }

    @Nullable
    private String getCurrentUidFromSp() {
        String decodeString = QMMKV.from(getApplication(), "msf_mmkv_file").decodeString(getCurrentUin(), null);
        if (TextUtils.isEmpty(decodeString)) {
            decodeString = UIDFileUtil.getUIDFromFile(getCurrentUin());
        }
        this.uid = decodeString;
        QLog.i("mqq", 1, "setAppRuntime: " + this + " uid: " + this.uid);
        return this.uid;
    }

    private EntityManagerFactory getEntityManagerFactoryInner(String str) {
        if (this.mEntityManagerFactory == null) {
            synchronized (this.mEntityManagerFactoryLock) {
                if (this.mEntityManagerFactory == null) {
                    this.mEntityManagerFactory = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(str).build();
                }
            }
        }
        return this.mEntityManagerFactory;
    }

    @Nullable
    private <T extends IRuntimeService> T getInstance(Class<T> cls, String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (((MqqInjectorManager.instance().isGrayVersion() && this.enableRuntimeReport) || !MqqInjectorManager.instance().isPublicVersion()) && !this.isAppRuntimeValid) {
            QLog.d("mqq", 1, "getRuntimeService when appRuntime destroyed, ", str);
            reportGetRuntimeServiceWhenDestroyed(str);
        }
        if (this.serviceHelper.fixRuntimeServiceInstance()) {
            return (T) this.serviceHelper.getInstance(this, cls, str);
        }
        if (this.isRuntimeServiceCleared && RuntimeServiceHelper.hitRuntimeServiceSetNullWhiteList((Class<?>) cls)) {
            ensureLock(cls);
            synchronized (this.serviceLocks.get(cls)) {
                T t16 = (T) this.runtimeServices.get(cls);
                if (t16 != null && RuntimeServiceHelper.isRuntimeServiceProxy(t16)) {
                    return t16;
                }
                T t17 = (T) RuntimeServiceHelper.createRuntimeServiceProxy(cls);
                QLog.d("mqq", 1, "replace ", cls.getName(), " to Proxy Object: ", t17.getClass(), ", tmp:", t17, ", runtime:", this);
                this.runtimeServices.put(cls, t17);
                return t17;
            }
        }
        boolean isDebugVersion = MqqInjectorManager.instance().isDebugVersion();
        runtimeServiceCheck(cls, isDebugVersion, true);
        T t18 = (T) this.runtimeServices.get(cls);
        if (t18 == null) {
            if (this.isRuntimeServiceCleared && RuntimeServiceHelper.hitRuntimeServiceSetNullWhiteList((Class<?>) cls)) {
                QLog.d("mqq", 1, "getRuntimeService when runtimeService is clear: ", cls.getName(), ", apiClazz:", cls, ", runtime:", this);
                return (T) getRuntimeService(cls, str);
            }
            String account = getAccount();
            if (TextUtils.isEmpty(account) && checkNeedAccount(cls)) {
                String str2 = cls.getName() + " need uin " + account + " or should add @Service{needUin=false}";
                QLog.e("mqq", 2, str2);
                throw new IllegalStateException(str2);
            }
            ensureLock(cls);
            synchronized (this.serviceLocks.get(cls)) {
                T t19 = (T) this.runtimeServices.get(cls);
                if (t19 != null) {
                    return t19;
                }
                Class<?> cls2 = Class.forName(str);
                cycleCheckBegin(str, isDebugVersion);
                t18 = (T) cls2.newInstance();
                if (t18 != null) {
                    QLog.d("mqq", 1, "RuntimeService instance onCreate, ", str, ", ", Integer.valueOf(t18.hashCode()));
                    t18.onCreate(this);
                    this.runtimeServices.put(cls, t18);
                }
                cycleCheckEnd(str, isDebugVersion);
            }
        }
        return t18;
    }

    private <T extends IRuntimeService> T getRuntimeServiceIPCSyncInner(Class<T> cls) {
        String a16 = e.a(cls);
        if (!TextUtils.isEmpty(a16)) {
            runtimeServiceCheck(cls, MqqInjectorManager.instance().isDebugVersion(), false);
            try {
                Object proxy = ServiceRemoteProxy.getProxy(cls, Class.forName(a16));
                if (proxy instanceof IRuntimeService) {
                    return (T) proxy;
                }
                String str = "getServiceRemoteProxy null, class=" + cls;
                QLog.e("mqq", 1, str);
                throw new IllegalStateException(str);
            } catch (ClassNotFoundException e16) {
                String str2 = "ClassNotFoundException error, class= " + cls.getName() + "target Class= " + a16;
                QLog.e("mqq", 1, str2);
                throw new IllegalStateException(str2, e16);
            }
        }
        throw new IllegalStateException("api or impl service name fatal! class=" + cls.getName());
    }

    @NonNull
    private <T extends IRuntimeService> T getRuntimeServiceInner(@NonNull Class<T> cls) {
        String a16 = e.a(cls);
        if (!TextUtils.isEmpty(a16)) {
            try {
                T t16 = (T) getInstance(cls, a16);
                if (t16 != null) {
                    return t16;
                }
                throw new IllegalStateException("runtimeService is null, api:" + cls.getSimpleName());
            } catch (Exception e16) {
                String str = "build AppRuntime service fatal api:" + cls.getSimpleName();
                this.mRuntimeServiceCycleCheck.remove();
                QLog.e("mqq", 2, str, e16);
                throw new IllegalStateException(str, e16);
            }
        }
        throw new IllegalStateException("api or impl service name fatal! class=" + cls.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearRuntimeServiceDelay$0() {
        this.isRuntimeServiceCleared = true;
        ArrayList<Class<?>> arrayList = new ArrayList();
        for (Class<?> cls : this.runtimeServices.keySet()) {
            if (RuntimeServiceHelper.hitRuntimeServiceSetNullWhiteList(cls)) {
                arrayList.add(cls);
            }
        }
        for (Class<?> cls2 : arrayList) {
            ensureLock(cls2);
            this.runtimeServices.remove(cls2);
            QLog.i("mqq", 1, "clearRuntimeServiceDelay remove class: " + cls2 + ", runtime:" + this);
        }
        QLog.i("mqq", 1, "release|remove runtime service, size: " + arrayList.size());
    }

    private void reportGetRuntimeServiceWhenDestroyed(String str) {
        try {
            final HashMap hashMap = new HashMap();
            hashMap.put("implName", str);
            if (!MqqInjectorManager.instance().isPublicVersion()) {
                hashMap.put("trace", Log.getStackTraceString(new RuntimeException("getRuntimeService when appRuntime destroyed")));
            }
            ThreadManagerV2.excute(new Runnable() { // from class: mqq.app.AppRuntime.4
                @Override // java.lang.Runnable
                public void run() {
                    StatisticCollectorProxy.collectPerformance(null, "GetRuntimeServiceWhenDestroyed", true, 0L, 0L, hashMap, null);
                }
            }, 16, null, true);
        } catch (Throwable th5) {
            QLog.e("mqq", 1, "reportGetRuntimeServiceWhenDestroyed, ", th5);
        }
    }

    public <T extends BusinessObserver> void addDirectNotifyObserver(Class<T> cls, int i3) {
        this.directNotifyObserver.add(cls);
        this.directNotifyType.add(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addManager(int i3, Manager manager) {
        synchronized (this.managers) {
            if (this.managers.indexOfKey(i3) < 0) {
                this.managers.put(i3, manager);
            } else {
                throw new IllegalArgumentException("addManager duplicated name = " + i3);
            }
        }
    }

    public <T extends BusinessObserver> void addWithoutPostObserver(Class<T> cls) {
        this.withoutUiNotifyObserver.add(cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canAutoLogin(String str) {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.canAutoLogin(str);
        }
        if (str != null && str.length() != 0) {
            return AutoLoginUtil.canAutoLogin(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "CNR getAutoLoginSharePre uin is null");
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkNeedAccount(Class<?> cls) {
        Service service;
        if (cls.isAnnotationPresent(Service.class) && (service = (Service) cls.getAnnotation(Service.class)) != null) {
            return service.needUin();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cycleCheckBegin(String str, boolean z16) {
        if (z16) {
            if (this.mRuntimeServiceCycleCheck.get() == null) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                this.mRuntimeServiceCycleCheck.set(arrayList);
            } else {
                if (!this.mRuntimeServiceCycleCheck.get().contains(str)) {
                    this.mRuntimeServiceCycleCheck.get().add(str);
                    return;
                }
                String str2 = "find cycle init from:" + str;
                QLog.e("mqq", 2, str2, new Throwable());
                this.mRuntimeServiceCycleCheck.remove();
                throw new IllegalStateException(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cycleCheckEnd(String str, boolean z16) {
        if (z16 && this.mRuntimeServiceCycleCheck.get() != null && !this.mRuntimeServiceCycleCheck.get().isEmpty() && str.compareTo(this.mRuntimeServiceCycleCheck.get().get(0)) == 0) {
            this.mRuntimeServiceCycleCheck.remove();
        }
    }

    public void enableNotifyAggregate(boolean z16) {
        UINotifyQueue uINotifyQueue = this.queue;
        if (uINotifyQueue != null) {
            uINotifyQueue.setEnable(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void exitToolProc() {
        onDestroy();
        SystemMethodProxy.killProcess(Process.myPid());
    }

    public String getAccount() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.getAccount();
        }
        SimpleAccount simpleAccount = this.mAccount;
        if (simpleAccount == null) {
            return null;
        }
        return simpleAccount.getUin();
    }

    public abstract BaseApplication getApp();

    public AppRuntime getAppRuntime(String str) {
        AppRuntime appRuntime;
        AppRuntime appRuntime2 = this.parentRuntime;
        if (appRuntime2 != null) {
            return appRuntime2.getAppRuntime(str);
        }
        if (!TextUtils.isEmpty(str)) {
            synchronized (str.intern()) {
                appRuntime = this.subRuntimeMap.get(str);
                if (appRuntime == null && (appRuntime = onGetSubRuntime(str)) != null) {
                    appRuntime.setProxy(this);
                    appRuntime.onCreate(this.modularSaveInstance);
                    this.subRuntimeMap.put(str, appRuntime);
                }
            }
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return this;
        }
        return appRuntime;
    }

    public MobileQQ getApplication() {
        return MobileQQ.sMobileQQ;
    }

    public Context getApplicationContext() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    public BaseCacheManager getCacheManagerInner() {
        if (this.cacheManager == null) {
            try {
                this.cacheManager = sProxyManagerFactory.get(0).newInstance().getCacheManager(this);
            } catch (Throwable th5) {
                QLog.e("mqq", 1, th5, new Object[0]);
            }
        }
        return this.cacheManager;
    }

    public int getCurAccLoginType() {
        return this.curAccLoginType;
    }

    public abstract String getCurrentAccountUin();

    public String getCurrentUid() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.getCurrentUid();
        }
        String str = this.uid;
        if (str != null) {
            return str;
        }
        return getCurrentUidFromSp();
    }

    public String getCurrentUin() {
        if (!"0".equals(getCurrentAccountUin())) {
            return getCurrentAccountUin();
        }
        return "";
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return getEntityManagerFactoryInner(getAccount());
    }

    public Intent getKickIntent() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.getKickIntent();
        }
        return this.mKickIntent;
    }

    public long getLongAccountUin() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.getLongAccountUin();
        }
        if (this.lUin < 0) {
            try {
                String account = getAccount();
                if (account != null && account.length() > 0) {
                    this.lUin = Long.parseLong(getAccount());
                }
            } catch (NumberFormatException e16) {
                QLog.e("mqq", 1, "getLongAccountUin, ", e16);
            }
        }
        return this.lUin;
    }

    @Nullable
    public ArrayList<String> getLowerPriorityProcessList() {
        return null;
    }

    public Manager getManager(int i3) {
        Manager manager;
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null && (manager = appRuntime.getManager(i3)) != null) {
            return manager;
        }
        synchronized (this.managers) {
            Manager manager2 = this.managers.get(i3);
            if (manager2 != null) {
                return manager2;
            }
            if (this.parentRuntime == null) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            manager2 = new TicketManagerImpl(this);
                        }
                    } else {
                        manager2 = new WtloginManagerImpl(this);
                    }
                } else {
                    manager2 = new AccountManagerImpl(this);
                }
                if (manager2 != null) {
                    addManager(i3, manager2);
                }
            }
            return manager2;
        }
    }

    public String[] getMessagePushSSOCommands() {
        return null;
    }

    protected Class<? extends MSFServlet>[] getMessagePushServlets() {
        return null;
    }

    public String getModuleId() {
        return null;
    }

    public <T> T getMsgCache() {
        return null;
    }

    public final SharedPreferences getPreferences() {
        String account = getAccount();
        if (account == null) {
            account = "noLogin";
        }
        return getApplication().getSharedPreferences(account, 4);
    }

    public BaseProxyManager getProxyManagerInner() {
        if (this.proxyManager == null) {
            try {
                this.proxyManager = sProxyManagerFactory.get(0).newInstance().getProxyManager(this);
            } catch (Throwable th5) {
                QLog.e("mqq", 1, th5, new Object[0]);
            }
        }
        return this.proxyManager;
    }

    public SQLiteDatabase getReadableDatabase(String str) {
        SQLiteOpenHelper sQLiteOpenHelper = getSQLiteOpenHelper(str);
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper.getReadableDatabase();
        }
        return null;
    }

    public ToServiceMsg getRegisterCmdCallMsg(Intent intent) {
        CommandCallbackerInfo commandCallbackerInfo = new CommandCallbackerInfo();
        commandCallbackerInfo.uin = getAccount();
        String[] stringArrayExtra = intent.getStringArrayExtra("pushCommands");
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, stringArrayExtra);
        commandCallbackerInfo.cmds = arrayList;
        return getService().msfSub.getRegisterCmdCallMsg(commandCallbackerInfo);
    }

    public ToServiceMsg getRegisterPushMsg(PushRegisterInfo pushRegisterInfo) {
        return getService().msfSub.getRegisterPushMsg(pushRegisterInfo);
    }

    public int getRunningModuleSize() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.getRunningModuleSize();
        }
        return this.subRuntimeMap.size();
    }

    @NonNull
    public <T extends IRuntimeService> T getRuntimeService(@NonNull Class<T> cls, String str) {
        return (T) getRuntimeServiceInner(cls);
    }

    @NonNull
    public <T extends IRuntimeService> T getRuntimeServiceIPCSync(@NonNull Class<T> cls, String str) {
        if (str.compareTo("") == 0 || TextUtils.isEmpty(this.mProcessName)) {
            getRuntimeService(cls, str);
        }
        return (T) getRuntimeServiceIPCSyncInner(cls);
    }

    protected SQLiteOpenHelper getSQLiteOpenHelper() {
        if (getCurrentAccountUin().equals("0")) {
            return null;
        }
        return getEntityManagerFactory().build(getCurrentAccountUin());
    }

    @Nullable
    public File getSecurityBusinessRootFile(@NonNull ISecurityFileHelper iSecurityFileHelper) {
        if (this.businessRootFilePaths.containsKey(iSecurityFileHelper.declareBusinessFileName())) {
            return new File(this.businessRootFilePaths.get(iSecurityFileHelper.declareBusinessFileName()));
        }
        if ("com.tencent.mobileqq".equals(MobileQQ.processName)) {
            File uINRootFile = ((ISecurityFileFrameworkService) getRuntimeService(ISecurityFileFrameworkService.class, "")).getUINRootFile(iSecurityFileHelper);
            if (uINRootFile != null) {
                this.businessRootFilePaths.put(iSecurityFileHelper.declareBusinessFileName(), uINRootFile.getAbsolutePath());
            }
            return uINRootFile;
        }
        String callMainProcessForSecurityFileResult = callMainProcessForSecurityFileResult(iSecurityFileHelper);
        if (TextUtils.isEmpty(callMainProcessForSecurityFileResult)) {
            return null;
        }
        this.businessRootFilePaths.put(iSecurityFileHelper.declareBusinessFileName(), callMainProcessForSecurityFileResult);
        return new File(callMainProcessForSecurityFileResult);
    }

    @Nullable
    public File getSecurityUINRootFile() {
        if (this.businessRootFilePaths.containsKey("SecurityUINRootFile")) {
            return new File(this.businessRootFilePaths.get("SecurityUINRootFile"));
        }
        if ("com.tencent.mobileqq".equals(MobileQQ.processName)) {
            File uINRootFile = ((ISecurityFileFrameworkService) getRuntimeService(ISecurityFileFrameworkService.class, "")).getUINRootFile(null);
            if (uINRootFile != null) {
                this.businessRootFilePaths.put("SecurityUINRootFile", uINRootFile.getAbsolutePath());
            }
            return uINRootFile;
        }
        String callMainProcessForSecurityFileResult = callMainProcessForSecurityFileResult(null);
        if (TextUtils.isEmpty(callMainProcessForSecurityFileResult)) {
            return null;
        }
        this.businessRootFilePaths.put("SecurityUINRootFile", callMainProcessForSecurityFileResult);
        return new File(callMainProcessForSecurityFileResult);
    }

    public MainService getService() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.getService();
        }
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ServletContainer getServletContainer() {
        return this.mServletContainer;
    }

    public byte[] getUinSign() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.getUinSign();
        }
        if (this.uinSign == null) {
            this.uinSign = new byte[32];
            SimpleAccount simpleAccount = this.mAccount;
            if (simpleAccount != null) {
                byte[] bytes = simpleAccount.getUin().toLowerCase().getBytes(StandardCharsets.UTF_8);
                byte[] bytes2 = MD5.toMD5(bytes).toLowerCase().getBytes(StandardCharsets.UTF_8);
                byte[] bArr = new byte[bytes2.length + bytes.length];
                System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
                System.arraycopy(bytes, 0, bArr, bytes2.length, bytes.length);
                this.uinSign = MD5.toMD5(bArr).toLowerCase().getBytes(StandardCharsets.UTF_8);
            }
        }
        return this.uinSign;
    }

    public ToServiceMsg getUnRegisterPushMsg(PushRegisterInfo pushRegisterInfo) {
        return getService().msfSub.getUnRegisterPushMsg(pushRegisterInfo);
    }

    public SQLiteDatabase getWritableDatabase(String str) {
        SQLiteOpenHelper sQLiteOpenHelper = getSQLiteOpenHelper(str);
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper.getWritableDatabase();
        }
        return null;
    }

    public boolean highPriorityWhenBackground() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(MobileQQ mobileQQ, MainService mainService, SimpleAccount simpleAccount) {
        this.mService = mainService;
        this.mContext = mobileQQ;
        this.mAccount = simpleAccount;
        this.lUin = -1L;
    }

    public boolean isLogin() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.isLogin();
        }
        return this.isLogin;
    }

    public boolean isModuleRunning(String str) {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.isModuleRunning(str);
        }
        return this.subRuntimeMap.containsKey(str);
    }

    public boolean isProcessIdle() {
        return false;
    }

    public boolean isRunning() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            return appRuntime.isRunning();
        }
        return this.isRunning;
    }

    public void kick(KickParams kickParams) {
        MainService service = getService();
        if (service != null) {
            service.kick(kickParams);
        }
    }

    @Deprecated
    public void login(String str, byte[] bArr, AccountObserver accountObserver) {
        getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.setObserver(accountObserver);
        newIntent.putExtra("account", str);
        newIntent.putExtra(NotificationActivity.PASSWORD, bArr);
        newIntent.putExtra("action", 1001);
        getServletContainer().forward(this, newIntent);
    }

    public void logout(boolean z16) {
        logout(Constants.LogoutReason.user, z16);
    }

    public void logoutByRestartProcess() {
        logout(Constants.LogoutReason.restartProcess, true);
    }

    public void notifyObserver(final BusinessObserver businessObserver, final int i3, final boolean z16, final Bundle bundle) {
        Runnable runnable = new Runnable() { // from class: mqq.app.AppRuntime.3
            @Override // java.lang.Runnable
            public void run() {
                if (MainService.isDebugVersion) {
                    SystemClock.uptimeMillis();
                }
                businessObserver.onReceive(i3, z16, bundle);
                if (MainService.isDebugVersion && MsfServiceSdk.get() != null) {
                    try {
                        SystemClock.uptimeMillis();
                    } catch (Throwable unused) {
                    }
                }
            }
        };
        if (!this.withoutUiNotifyObserver.contains(businessObserver.getClass())) {
            if (this.queue != null && (!this.directNotifyObserver.contains(businessObserver.getClass()) || !this.directNotifyType.contains(Integer.valueOf(i3)))) {
                this.queue.postTask(businessObserver.getClass().getName(), runnable);
                return;
            } else {
                runOnUiThread(runnable);
                return;
            }
        }
        NTAdapterThreadHelper.INSTANCE.execute(runnable);
    }

    public void notifyObservers(Class<? extends BusinessObserver> cls, int i3, boolean z16, Bundle bundle) {
        synchronized (this.observers) {
            Iterator<Reference<BusinessObserver>> it = this.observers.iterator();
            while (it.hasNext()) {
                BusinessObserver businessObserver = it.next().get();
                if (businessObserver != null && cls != null && (cls == BusinessObserver.class || cls.isAssignableFrom(businessObserver.getClass()))) {
                    notifyObserver(businessObserver, i3, z16, bundle);
                }
            }
        }
    }

    public void ntTriggerLogout(Constants.LogoutReason logoutReason) {
        logout(logoutReason, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String shortUin;
        try {
            this.queue = new UINotifyQueue(this.mainHandler, 300L, true, MqqInjectorManager.instance().isDebugVersion());
        } catch (Throwable th5) {
            QLog.w("mqq", 1, "create UINotifyQueue error: ", th5);
        }
        this.modularSaveInstance = bundle;
        this.isRunning = true;
        this.isAppRuntimeValid = true;
        if (isLogin()) {
            start(true);
        }
        if (this.parentRuntime != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            shortUin = getAccount();
        } else {
            shortUin = MsfSdkUtils.getShortUin(getAccount());
        }
        QLog.i("mqq", 2, "[AppRuntime]" + getClass().getSimpleName() + " (" + shortUin + ") onCreate,savedInstanceState=" + bundle + " enableReport=" + this.enableRuntimeReport);
        addManager(0, new AccountManagerImpl(this));
        addManager(4, new PushManagerImpl(this));
        addManager(3, new ServerConfigManagerImpl(this));
        enableNotifyAggregate(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (this.isRunning) {
            if (QLog.isColorLevel()) {
                QLog.i("mqq", 2, "[AppRuntime]" + getClass().getSimpleName() + " (" + getAccount() + ") onDestroy");
            } else {
                QLog.i("mqq", 1, "[AppRuntime]" + getClass().getSimpleName() + " (" + MsfSdkUtils.getShortUin(getAccount()) + ") onDestroy");
            }
            this.isRunning = false;
            getServletContainer().destroy();
            MainService mainService = this.mService;
            if (mainService != null) {
                mainService.clearServlets();
            }
        }
        ToolProcReceiver toolProcReceiver = this.mToolReceiver;
        if (toolProcReceiver != null) {
            toolProcReceiver.unRegister();
        }
        Iterator<AppRuntime> it = this.subRuntimeMap.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    protected AppRuntime onGetSubRuntime(String str) {
        return null;
    }

    public void onGuardEvent(int i3, long j3, long j16) {
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", Constants.Action.ACTION_APP_GUARD);
        newIntent.putExtra(MsfConstants.K_EVENT, i3);
        newIntent.putExtra(MsfConstants.K_ARG0, j3);
        newIntent.putExtra(MsfConstants.K_ARG1, j16);
        newIntent.withouLogin = true;
        newIntent.runNow = true;
        startServlet(newIntent);
    }

    public void onProxyIpChanged() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.onProxyIpChanged();
        }
    }

    public boolean onReceiveUnhandledKickedMsg(String str, Intent intent) {
        return false;
    }

    public void onRelease() {
        for (Map.Entry<Class<?>, IRuntimeService> entry : this.runtimeServices.entrySet()) {
            if (!RuntimeServiceHelper.isImportantRuntimeService(entry.getKey())) {
                entry.getValue().onDestroy();
            }
        }
        QLog.i("mqq", 1, "release|all runtime service destroy");
        releaseImportRuntimeService();
        this.serviceHelper.onRelease();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRunningBackground() {
        this.isBackgroundStop = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRunningForeground() {
        this.isBackgroundStop = false;
    }

    public void openMsfPCActive(String str, String str2, boolean z16) {
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.setObserver(null);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("src", str2);
        newIntent.putExtra("opened", z16);
        newIntent.putExtra("action", Constants.Action.ACTION_OPEN_PCACTIVE);
        getServletContainer().forward(this, newIntent);
    }

    public void registObserver(BusinessObserver businessObserver) {
        this.observers.add(new WeakReference(businessObserver));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseImportRuntimeService() {
        if (2 == this.dependTaskFinishCnt.addAndGet(1)) {
            QLog.i("mqq", 1, "release important runtime service");
            for (Map.Entry<Class<?>, IRuntimeService> entry : this.runtimeServices.entrySet()) {
                if (RuntimeServiceHelper.isImportantRuntimeService(entry.getKey())) {
                    if (QLog.isColorLevel()) {
                        QLog.i("mqq", 2, "release| destroy important runtime service: " + entry.getKey().getName());
                    }
                    entry.getValue().onDestroy();
                }
            }
            this.isAppRuntimeValid = false;
        }
        this.serviceHelper.releaseImportRuntimeService();
    }

    public <T extends BusinessObserver> void removeDirectNotifyObserver(Class<T> cls, int i3) {
        this.directNotifyObserver.remove(cls);
        this.directNotifyType.remove(Integer.valueOf(i3));
    }

    public void reportNetworkException(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "reportNetworkException " + i3);
        }
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1042);
        newIntent.putExtra("value", i3);
        startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resourceRelease() {
        QLog.d("mqq", 1, "resourceRelease: ", this);
    }

    public final void runOnUiThread(Runnable runnable) {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.runOnUiThread(runnable);
        } else {
            this.mainHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T extends IRuntimeService> void runtimeServiceCheck(Class<T> cls, boolean z16, boolean z17) {
        if (z16) {
            if (cls.isAnnotationPresent(Service.class)) {
                if (z17 && !ProcessChecker.check(cls, this.mProcessName, z16)) {
                    String str = "service: " + cls.getName() + " can not run on this process: " + this.mProcessName + "\uff0c\u8bf7\u8054\u7cfbService\u5f00\u53d1\u8005\u6c9f\u901a\u5904\u7406\u3002\n";
                    QLog.e("mqq", 2, str);
                    throw new IllegalStateException(str);
                }
                com.tencent.mobileqq.qroute.remote.e.m(cls);
                return;
            }
            throw new IllegalStateException("IRuntimeService should have Service Annotation, class=" + cls.getName());
        }
    }

    public void sendAppDataIncermentMsg(String str, String[] strArr, long j3) {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.sendAppDataIncermentMsg(str, strArr, j3);
            return;
        }
        ToServiceMsg appDataIncermentMsg = MsfMsgUtil.getAppDataIncermentMsg(this.mService.msfSub.getMsfServiceName(), str, strArr, j3);
        appDataIncermentMsg.setAppSeq(MSFServlet.APP_SEQ_FACTORY.incrementAndGet());
        try {
            this.mService.msfSub.sendMsg(appDataIncermentMsg);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "[MSF Send]" + appDataIncermentMsg.getServiceCmd() + " error " + th5, th5);
            }
        }
    }

    public void sendMsgSignal() {
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.setObserver(null);
        newIntent.putExtra("action", 2202);
        getServletContainer().forward(this, newIntent);
    }

    public void sendOnlineStatus(Status status, Status status2, boolean z16, long j3, boolean z17, int i3, byte b16) {
        String[] messagePushSSOCommands = getMessagePushSSOCommands();
        if (messagePushSSOCommands != null) {
            NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
            newIntent.putExtra("action", 1002);
            newIntent.putExtra("pushCommands", messagePushSSOCommands);
            newIntent.putExtra("onlineStatus", status);
            newIntent.putExtra(QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, status2);
            newIntent.putExtra("kick", z16);
            newIntent.putExtra("K_SEQ", j3);
            newIntent.putExtra("isUserSet", z17);
            newIntent.putExtra("bindUinNotifySwitch", i3);
            newIntent.runNow = true;
            newIntent.putExtra(IOnlineStatusService.PARAMS_VENDOR_PUSH_TYPE, ThirdPushSupportHelper.getThirdPushType(getApplication(), null));
            newIntent.putExtra(TangramHippyConstants.LOGIN_TYPE, b16);
            startServlet(newIntent);
        }
    }

    public void sendOnlineStatusWithExt(Status status, Status status2, boolean z16, long j3, boolean z17, long j16, long j17, long j18, int i3, byte b16, byte[] bArr) {
        String[] messagePushSSOCommands = getMessagePushSSOCommands();
        if (messagePushSSOCommands != null) {
            NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
            newIntent.putExtra("action", 1002);
            newIntent.putExtra("pushCommands", messagePushSSOCommands);
            newIntent.putExtra("onlineStatus", status);
            newIntent.putExtra("extOnlineStatus", j16);
            newIntent.putExtra(QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, status2);
            newIntent.putExtra("kick", z16);
            newIntent.putExtra("K_SEQ", j3);
            newIntent.putExtra("isUserSet", z17);
            newIntent.putExtra("bindUinNotifySwitch", i3);
            if (status == Status.online && j16 == 1000) {
                newIntent.putExtra("batteryCapacity", j17);
                newIntent.putExtra("powerConnect", j18);
            }
            newIntent.putExtra(IOnlineStatusService.PARAMS_VENDOR_PUSH_TYPE, ThirdPushSupportHelper.getThirdPushType(getApplication(), null));
            newIntent.putExtra(TangramHippyConstants.LOGIN_TYPE, b16);
            newIntent.putExtra("vecRegisterExtData", bArr);
            newIntent.runNow = true;
            startServlet(newIntent);
        }
    }

    public void sendWirelessMeibaoReq(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "sendWirelessMeibaoReq cmd: " + i3);
        }
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1044);
        newIntent.putExtra("cmd", i3);
        startServlet(newIntent);
    }

    public void sendWirelessPswReq(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "sendWirelessPswReq cmd: " + i3);
        }
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1043);
        newIntent.putExtra("cmd", i3);
        startServlet(newIntent);
    }

    public void setAsToolRuntime() {
        ToolProcReceiver toolProcReceiver = this.mToolReceiver;
        if (toolProcReceiver != null) {
            toolProcReceiver.unRegister();
        }
        ToolProcReceiver toolProcReceiver2 = new ToolProcReceiver();
        this.mToolReceiver = toolProcReceiver2;
        toolProcReceiver2.mRt = this;
        toolProcReceiver2.register();
    }

    public void setAutoLogin(boolean z16) {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.setAutoLogin(z16);
        }
    }

    public void setCmdCallbacker() {
        String[] messagePushSSOCommands = getMessagePushSSOCommands();
        if (messagePushSSOCommands != null) {
            NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
            newIntent.putExtra("action", 1040);
            newIntent.putExtra("pushCommands", messagePushSSOCommands);
            newIntent.runNow = true;
            startServlet(newIntent);
        }
    }

    public void setCurAccLoginType(int i3) {
        this.curAccLoginType = i3;
    }

    public void setInterceptKickListener(InterceptKickListener interceptKickListener) {
        MainService service = getService();
        if (service != null) {
            service.setInterceptKickListener(interceptKickListener);
        }
    }

    public void setKickIntent(Intent intent) {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.setKickIntent(intent);
        } else {
            this.mKickIntent = intent;
        }
    }

    public void setLogined() {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.setLogined();
        }
        this.isLogin = true;
    }

    public void setProcessName(String str) {
        this.mProcessName = str;
    }

    public void setProxy(AppRuntime appRuntime) {
        this.parentRuntime = appRuntime;
        if (appRuntime != null) {
            this.isBackgroundPause = appRuntime.isBackgroundPause;
            this.isBackgroundStop = appRuntime.isBackgroundStop;
        }
    }

    public void start(boolean z16) {
        if (this.parentRuntime == null) {
            String account = getAccount();
            if (!TextUtils.isEmpty(account)) {
                NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_GET_ALTER_TICKETS);
                newIntent.putExtra("uin", account);
                startServlet(newIntent);
            }
        }
        Class<? extends MSFServlet>[] messagePushServlets = getMessagePushServlets();
        if (messagePushServlets != null) {
            for (Class<? extends MSFServlet> cls : messagePushServlets) {
                startServlet(new NewIntent(getApplication(), cls));
            }
        }
    }

    public void startPCActivePolling(String str, String str2) {
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.setObserver(null);
        newIntent.putExtra("uin", str);
        newIntent.putExtra("src", str2);
        newIntent.putExtra("action", Constants.Action.ACTION_START_PCACTIVE_POLLING);
        getServletContainer().forward(this, newIntent);
    }

    public void startServlet(NewIntent newIntent) {
        String str;
        boolean z16;
        String account;
        String str2 = "";
        if ((newIntent.withouLogin || isLogin()) && isRunning()) {
            getServletContainer().forward(this, newIntent);
            return;
        }
        if (!MqqInjectorManager.instance().isPublicVersion()) {
            getServletContainer().forwardForFail(newIntent);
        }
        try {
            try {
                str = newIntent.getStringExtra("action");
            } catch (Exception unused) {
                str = String.valueOf(newIntent.getIntExtra("action", 0));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        boolean z17 = true;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("can not send intent ");
            sb5.append(str);
            sb5.append(",isLogin:");
            sb5.append(isLogin());
            sb5.append(",isRunning:");
            sb5.append(isRunning());
            sb5.append(",parentRT:");
            if (this.parentRuntime == null) {
                z17 = false;
            }
            sb5.append(z17);
            QLog.e("mqq", 2, sb5.toString());
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("can not send intent ,");
            sb6.append(isLogin());
            sb6.append("|");
            sb6.append(isRunning());
            sb6.append("|");
            if (this.parentRuntime != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb6.append(z16);
            QLog.e("mqq", 1, sb6.toString());
        }
        if ((MainService.isDebugVersion || MainService.isGrayVersion) && MsfServiceSdk.get() != null) {
            try {
                if (getAccount() == null) {
                    account = "NoLogin";
                } else {
                    account = getAccount();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("uinpm", account);
                hashMap.put("intentWithLogin", String.valueOf(newIntent.withouLogin));
                hashMap.put(QAdLoginDefine$LoginStatus.IS_LOGIN, String.valueOf(isLogin()));
                hashMap.put("isRunning", String.valueOf(isRunning()));
                if (newIntent.getComponent() != null) {
                    str2 = newIntent.getComponent().getShortClassName();
                }
                hashMap.put("compClass", str2);
                hashMap.put("timepm", String.valueOf(System.currentTimeMillis()));
                RdmReq rdmReq = new RdmReq();
                rdmReq.eventName = "sendPBToMsfError";
                rdmReq.isRealTime = false;
                rdmReq.params = hashMap;
                ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
                rdmReportMsg.setNeedCallback(false);
                MsfServiceSdk.get().sendMsg(rdmReportMsg);
            } catch (Throwable unused2) {
            }
        }
    }

    public void stopPCActivePolling(String str) {
        NewIntent newIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        newIntent.setObserver(null);
        newIntent.putExtra("action", Constants.Action.ACTION_STOP_PCACTIVE_POLLING);
        newIntent.putExtra("src", str);
        getServletContainer().forward(this, newIntent);
    }

    public void switchAccount(SimpleAccount simpleAccount, String str) {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.switchAccount(simpleAccount, str);
        } else {
            if (simpleAccount != null) {
                getApplication().createNewRuntime(simpleAccount, false, true, 2, str);
                return;
            }
            throw new IllegalArgumentException("the newAccount can not be null.");
        }
    }

    public void unRegistObserver(BusinessObserver businessObserver) {
        if (businessObserver == null) {
            return;
        }
        this.observers.remove(new WeakReference(businessObserver));
    }

    public void updateSubAccountLogin(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "updateSubAccountLogin isLogined = " + z16 + ";subAccount =" + str);
        }
        MsfSdkUtils.updateSimpleAccount(str, z16);
    }

    public EntityManagerFactory getEntityManagerFactory(String str) {
        return getEntityManagerFactoryInner(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logout(final Constants.LogoutReason logoutReason, boolean z16) {
        if (isLogin()) {
            QLog.d("mqq", 1, "start to logout by " + logoutReason + ", " + z16);
            if (z16) {
                if (logoutReason != Constants.LogoutReason.kicked && this.isNtLogout.compareAndSet(false, true)) {
                    userLogoutWhenSendState();
                }
                sendOnlineStatus(Status.offline, Status.online, false, 0L, false, 1, (byte) 0);
                QLog.d("mqq", 1, "AppRuntime logout by has sent online status!");
            }
            userLogoutReleaseData();
            this.isLogin = false;
            if (QLog.isColorLevel()) {
                QLog.w("mqq", 2, getAccount() + " logout by " + logoutReason + ", " + z16);
            } else {
                QLog.w("mqq", 1, MsfSdkUtils.getShortUin(getAccount()) + " logout by " + logoutReason + ", " + z16);
            }
            if (logoutReason != Constants.LogoutReason.switchAccount) {
                runOnUiThread(new Runnable() { // from class: mqq.app.AppRuntime.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AppRuntime.this.getApplication().dispatchAccountEvent(logoutReason, 0, false, null);
                        if (QLog.isColorLevel()) {
                            QLog.d("mqq", 2, "real logout");
                        }
                    }
                });
            }
        }
    }

    public SQLiteDatabase getReadableDatabase() {
        SQLiteOpenHelper sQLiteOpenHelper = getSQLiteOpenHelper();
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper.getReadableDatabase();
        }
        return null;
    }

    protected SQLiteOpenHelper getSQLiteOpenHelper(String str) {
        return getEntityManagerFactory(str).build(str);
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteOpenHelper sQLiteOpenHelper = getSQLiteOpenHelper();
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper.getWritableDatabase();
        }
        return null;
    }

    public void login(final SimpleAccount simpleAccount) {
        AppRuntime appRuntime = this.parentRuntime;
        if (appRuntime != null) {
            appRuntime.login(simpleAccount);
        } else {
            runOnUiThread(new Runnable() { // from class: mqq.app.AppRuntime.1
                @Override // java.lang.Runnable
                public void run() {
                    AppRuntime.this.getApplication().createNewRuntime(simpleAccount, true, true, 1, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onProcPause() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onProcResume() {
    }

    public void preExit() {
    }

    protected void userLogoutReleaseData() {
    }

    protected void userLogoutWhenSendState() {
    }

    public void cancelSyncOnlineFriend(long j3) {
    }

    public void exit(boolean z16) {
    }
}
