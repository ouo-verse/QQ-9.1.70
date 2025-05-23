package com.tencent.mobileqq.onlinestatus.manager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.aa;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherModel;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import gc2.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.onlinestatus.OnlineStatusExtInfo$AutoStateBizInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusDataManager implements f, IGuardInterface, b.InterfaceC10368b {
    private aa D;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f255945d;

    /* renamed from: e, reason: collision with root package name */
    private final BusinessObserver f255946e;

    /* renamed from: f, reason: collision with root package name */
    private long f255947f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f255948h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.onlinestatus.location.b f255949i;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f255950m = new ConcurrentHashMap<>(10);
    StudyModeChangeListener C = new b();
    private boolean E = false;
    Runnable F = new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager.3
        @Override // java.lang.Runnable
        public void run() {
            Object valueOf;
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = "SyncBusinessInfoRunnable app.isRunning=";
                if (OnlineStatusDataManager.this.f255945d == null) {
                    valueOf = "null";
                } else {
                    valueOf = Boolean.valueOf(OnlineStatusDataManager.this.f255945d.isRunning());
                }
                objArr[1] = valueOf;
                objArr[2] = " mSyncPause:";
                objArr[3] = Boolean.valueOf(OnlineStatusDataManager.this.E);
                QLog.d("OnlineStatusDataManagerImpl", 2, objArr);
            }
            if (OnlineStatusDataManager.this.f255945d != null && OnlineStatusDataManager.this.f255945d.isRunning()) {
                int v3 = af.C().v(OnlineStatusDataManager.this.f255945d);
                if (v3 == 1) {
                    ((OnlineStatusHandler) OnlineStatusDataManager.this.f255945d.getBusinessHandler(OnlineStatusHandler.class.getName())).g3(v3, af.C().d(OnlineStatusDataManager.this.f255945d));
                } else if (v3 == 4) {
                    if (!OnlineStatusDataManager.this.E) {
                        OnlineStatusDataManager.this.O(7);
                    }
                } else if (v3 == 3) {
                    boolean p16 = kc2.c.p(OnlineStatusDataManager.this.f255945d);
                    boolean o16 = kc2.c.o(OnlineStatusDataManager.this.f255945d);
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusDataManagerImpl", 2, "run: invoked. [constellation] need fetch? ", " type: ", Integer.valueOf(v3), " constellationRequestExpired: ", Boolean.valueOf(o16), " constellationStatus: ", Boolean.valueOf(p16));
                    }
                    if (p16 && o16) {
                        OnlineStatusExtInfoServlet.b(OnlineStatusDataManager.this.f255945d, kc2.c.i(OnlineStatusDataManager.this.f255945d, OnlineStatusDataManager.this.f255945d.getCurrentAccountUin()));
                        kc2.c.q(OnlineStatusDataManager.this.f255945d, System.currentTimeMillis() / 1000);
                    }
                }
                OnlineStatusDataManager.this.M();
            }
        }
    };
    Runnable G = new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager.4
        @Override // java.lang.Runnable
        public void run() {
            OnlineStatusDataManager.this.E = true;
            QLog.d("OnlineStatusDataManagerImpl", 1, "cancel background runnable");
        }
    };

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends ProfileCardObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        public void onGetProfileDetail(boolean z16, String str, Card card) {
            boolean z17;
            boolean z18;
            if (str != null && str.equals(OnlineStatusDataManager.this.f255945d.getCurrentAccountUin())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (card != null && card.lBirthday != OnlineStatusDataManager.this.f255947f) {
                z18 = true;
            } else {
                z18 = false;
            }
            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) OnlineStatusDataManager.this.f255945d.getRuntimeService(IOnlineStatusService.class, "");
            if (z18 && iOnlineStatusService.getExtOnlineStatus() == 1040 && z17) {
                String currentAccountUin = OnlineStatusDataManager.this.f255945d.getCurrentAccountUin();
                String v3 = kc2.c.v(OnlineStatusDataManager.this.f255945d, currentAccountUin);
                boolean isEmpty = TextUtils.isEmpty(v3);
                if (isEmpty) {
                    OnlineStatusExtInfoServlet.b(OnlineStatusDataManager.this.f255945d, kc2.c.i(OnlineStatusDataManager.this.f255945d, currentAccountUin));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusDataManagerImpl", 2, "sendBussinessInfoRegisterPush: invoked. [constellation] (\u62c9\u53d6\u8d44\u6599\u56de\u8c03\u4e2d\uff0c\u5982\u679c\u8fd0\u52bf\u4e3a\u7a7a\uff0c\u624d\u6267\u884c\u8fd0\u52bf\u62c9\u53d6) ", " emptyTrend: ", Boolean.valueOf(isEmpty), " uin: ", currentAccountUin, " trend: ", v3);
                }
                OnlineStatusDataManager.this.f255947f = card.lBirthday;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements StudyModeChangeListener {
        b() {
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean z16) {
            if (z16) {
                IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) OnlineStatusDataManager.this.f255945d.getRuntimeService(IOnlineStatusService.class, "");
                AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
                AppRuntime.Status status = AppRuntime.Status.online;
                if (onlineStatus == status && !af.C().J(status, iOnlineStatusService.getExtOnlineStatus(), false).f255497j) {
                    iOnlineStatusService.updateOnlineStatus(status, 0L, 3);
                }
            }
        }
    }

    public OnlineStatusDataManager(AppInterface appInterface) {
        this.f255945d = appInterface;
        a aVar = new a();
        this.f255946e = aVar;
        this.f255945d.addObserver(aVar);
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(this.C);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this);
        }
        this.D = new aa();
        this.f255948h = new Handler(ThreadManagerV2.getSubThreadLooper());
    }

    private boolean F() {
        Object valueOf;
        AppInterface appInterface = this.f255945d;
        if (appInterface != null && appInterface.isRunning()) {
            return true;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "checkAppValid app.isRunning=";
            AppInterface appInterface2 = this.f255945d;
            if (appInterface2 == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(appInterface2.isRunning());
            }
            objArr[1] = valueOf;
            QLog.d("OnlineStatusDataManagerImpl", 2, objArr);
        }
        return false;
    }

    private long G(long j3) {
        if (j3 == 1000) {
            long c16 = this.D.c(1000);
            if (c16 == 0) {
                return 300L;
            }
            return c16;
        }
        return JoinTimeType.THIRTY_MINUTES;
    }

    public static boolean L(AppRuntime appRuntime, long j3) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnlineStatusDataManagerImpl");
        if (H == null || j3 - H.q0() > 3600) {
            return true;
        }
        return false;
    }

    public boolean D(int i3) {
        if (i3 != 6 && i3 != 7 && i3 != 8 && i3 != 9) {
            return false;
        }
        return true;
    }

    public void E() {
        Object valueOf;
        if (this.f255945d == null) {
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = "cancelTimedMsgTask app.isRunning=";
                AppInterface appInterface = this.f255945d;
                if (appInterface == null) {
                    valueOf = "null";
                } else {
                    valueOf = Boolean.valueOf(appInterface.isRunning());
                }
                objArr[1] = valueOf;
                QLog.d("OnlineStatusDataManagerImpl", 2, objArr);
                return;
            }
            return;
        }
        this.f255948h.removeCallbacks(this.F);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusDataManagerImpl", 2, "cancelTimedMsgTask");
        }
    }

    void H(int i3, com.tencent.mobileqq.onlinestatus.location.b bVar, Intent intent, boolean z16) {
        if (z16 || L(this.f255945d, NetConnInfoCenter.getServerTime()) || i3 == 9) {
            int i16 = 0;
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusDataManagerImpl", 2, "gotoNextStep type\uff1a", Integer.valueOf(i3), " isLocationChange:", Boolean.valueOf(z16));
            }
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(1);
            arrayList.add(10);
            arrayList.add(7);
            try {
                i16 = Integer.valueOf(bVar.f255922g).intValue();
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusDataManagerImpl", 4, "handleFetchWeatherInfo numberFormat", e16);
                }
            }
            wc2.b.e(this.f255945d, arrayList, i16, i3, intent.getExtras());
        }
    }

    public void I(Intent intent) {
        OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem;
        Bundle bundle = new Bundle();
        OnlineStatusExtInfo$AutoStateBizInfo onlineStatusExtInfo$AutoStateBizInfo = new OnlineStatusExtInfo$AutoStateBizInfo();
        onlineStatusExtInfo$AutoStateBizInfo.uint64_update_time.set(System.currentTimeMillis() / 1000);
        bundle.putByteArray("ExtInfo", onlineStatusExtInfo$AutoStateBizInfo.toByteArray());
        bundle.putInt("StatusId", 2017);
        bundle.putBoolean("from_need_update_delay_time", true);
        if (intent.hasExtra("online_status_permission_item")) {
            onlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem) intent.getSerializableExtra("online_status_permission_item");
        } else {
            onlineStatusPermissionItem = null;
        }
        bundle.putBoolean("from_modify", intent.getBooleanExtra("from_modify", false));
        bundle.putBoolean("from_register", false);
        ((OnlineStatusHandler) this.f255945d.getBusinessHandler(OnlineStatusHandler.class.getName())).b3(3, bundle, onlineStatusPermissionItem);
    }

    public void J(int i3, Intent intent) {
        OnlineStatusHandler onlineStatusHandler = (OnlineStatusHandler) this.f255945d.getBusinessHandler(OnlineStatusHandler.class.getName());
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnlineStatusDataManagerImpl");
        if (H == null) {
            QLog.e("OnlineStatusDataManagerImpl", 1, "handleReportWeatherInfo simpleInfo is null");
            return;
        }
        Bundle f16 = af.C().f(H);
        f16.putBoolean("from_need_update_delay_time", true);
        if (7 == i3 && this.D.b(1030)) {
            onlineStatusHandler.g3(3, f16);
            return;
        }
        OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = null;
        if (6 == i3) {
            f16.putBoolean("from_register", true);
            onlineStatusHandler.b3(3, f16, null);
        } else if (8 == i3) {
            if (intent.hasExtra("online_status_permission_item")) {
                onlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem) intent.getSerializableExtra("online_status_permission_item");
            }
            f16.putBoolean("from_modify", intent.getBooleanExtra("from_modify", false));
            f16.putBoolean("from_register", false);
            onlineStatusHandler.b3(3, f16, onlineStatusPermissionItem);
        }
    }

    public void K(int i3, Intent intent, OnlineStatusWeatherModel onlineStatusWeatherModel) {
        if (onlineStatusWeatherModel == null) {
            QLog.e("OnlineStatusDataManagerImpl", 1, "handleReportWeatherInfo weatherModel is null");
            J(i3, intent);
            return;
        }
        OnlineStatusHandler onlineStatusHandler = (OnlineStatusHandler) this.f255945d.getBusinessHandler(OnlineStatusHandler.class.getName());
        Bundle e16 = af.C().e(onlineStatusWeatherModel);
        e16.putBoolean("from_need_update_delay_time", true);
        if (7 == i3 && this.D.b(1030)) {
            onlineStatusHandler.g3(3, e16);
            return;
        }
        OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = null;
        if (6 == i3) {
            e16.putBoolean("from_register", true);
            onlineStatusHandler.b3(3, e16, null);
        } else if (8 == i3) {
            if (intent.hasExtra("online_status_permission_item")) {
                onlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem) intent.getSerializableExtra("online_status_permission_item");
            }
            e16.putBoolean("from_modify", intent.getBooleanExtra("from_modify", false));
            e16.putBoolean("from_register", false);
            onlineStatusHandler.b3(3, e16, onlineStatusPermissionItem);
        }
    }

    public void M() {
        Object valueOf;
        AppInterface appInterface = this.f255945d;
        if (appInterface != null && appInterface.isRunning()) {
            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.f255945d.getRuntimeService(IOnlineStatusService.class, "");
            AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
            long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
            if (onlineStatus == AppRuntime.Status.online && (extOnlineStatus == 1000 || extOnlineStatus == 1030 || extOnlineStatus == 1040)) {
                this.f255948h.removeCallbacks(this.F);
                long G = G(extOnlineStatus);
                this.f255948h.postDelayed(this.F, 1000 * G);
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusDataManagerImpl", 2, "launchTimedMsgTask schedule msgTimer after ", Long.valueOf(G), " seconds", " extStatus: ", Long.valueOf(extOnlineStatus));
                    return;
                }
                return;
            }
            E();
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusDataManagerImpl", 2, "launchTimedMsgTask cancel status", onlineStatus, " extStatus:", Long.valueOf(extOnlineStatus));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "launchTimedMsgTask app.isRunning=";
            AppInterface appInterface2 = this.f255945d;
            if (appInterface2 == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(appInterface2.isRunning());
            }
            objArr[1] = valueOf;
            QLog.d("OnlineStatusDataManagerImpl", 2, objArr);
        }
    }

    public void N(long j3) {
        if (!af.C().d0().booleanValue()) {
            QLog.d("OnlineStatusDataManagerImpl", 1, "resetWhenStatusConfigRemoved: ignore. [status][reset-default] config not loaded");
            return;
        }
        ArrayList arrayList = null;
        if (j3 > 0) {
            ArrayList<au> q16 = af.C().q();
            if (q16 != null) {
                arrayList = new ArrayList();
                Iterator<au> it = q16.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(it.next().f255489b));
                }
            }
            if (arrayList != null && !arrayList.isEmpty() && !arrayList.contains(Long.valueOf(j3))) {
                ((IOnlineStatusService) this.f255945d.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, 0L, true, 2);
                QLog.d("OnlineStatusDataManagerImpl", 1, "resetWhenStatusConfigRemoved: invoked. [status][reset-default] finish. ");
            }
        } else {
            QLog.d("OnlineStatusDataManagerImpl", 1, "resetWhenStatusConfigRemoved: invoked. [status][reset-default] no need reset", " extStatus: ", Long.valueOf(j3));
        }
        QLog.d("OnlineStatusDataManagerImpl", 1, "resetWhenStatusConfigRemoved: invoked. [status][reset-default] ", " configIds: ", arrayList, " extStatus: ", Long.valueOf(j3));
    }

    public void O(int i3) {
        P(i3, new Intent());
    }

    public void P(int i3, Intent intent) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusDataManagerImpl", 2, "sendLocationInfo type:", Integer.valueOf(i3));
        }
        if (D(i3)) {
            AppInterface appInterface = this.f255945d;
            if (appInterface != null && !appInterface.isBackgroundStop) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusDataManagerImpl", 2, "isAppForeground", Boolean.valueOf(z16));
            }
            intent.putExtra("isAppForeground", z16);
            gc2.a.c(i3, intent, this);
        }
    }

    public void Q(int i3, long j3) {
        this.D.d(i3, j3);
    }

    public void R(long j3, long j16) {
        this.D.d((int) j3, j16);
    }

    public void S(int i3, long j3) {
        this.D.e(i3, j3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.f
    public void b(boolean z16) {
        this.C.onChange(z16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.f
    public void k(long j3) {
        b(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
    }

    @Override // gc2.b.InterfaceC10368b
    public void n(int i3, double d16, double d17, String str, String str2, int i16, Intent intent) {
        boolean z16 = true;
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusDataManagerImpl", 2, "retCode\uff1a", Integer.valueOf(i3));
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.onlinestatus.location.b.a(this.f255949i, d16, d17, str)) {
            this.f255949i = new com.tencent.mobileqq.onlinestatus.location.b(d16, d17, str2, str);
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.onlinestatus.location.b bVar = this.f255949i;
        if (bVar == null) {
            return;
        }
        H(i16, bVar, intent, z16);
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.f
    public void o(boolean z16, AppRuntime.Status status) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusDataManagerImpl", 2, "sendBussinessInfoRegisterPush succ:", Boolean.valueOf(z16), " mSyncPause:", Boolean.valueOf(this.E));
        }
        if (z16 && status == AppRuntime.Status.online) {
            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.f255945d.getRuntimeService(IOnlineStatusService.class, "");
            long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
            OnlineStatusHandler onlineStatusHandler = (OnlineStatusHandler) this.f255945d.getBusinessHandler(OnlineStatusHandler.class.getName());
            if (extOnlineStatus == 1000) {
                try {
                    iOnlineStatusService.setPowerConnect(af.E());
                } catch (Throwable th5) {
                    QLog.e("OnlineStatusDataManagerImpl", 1, "registerPush t:", th5);
                }
                onlineStatusHandler.b3(1, af.C().c(this.f255945d, true), null);
            } else if (extOnlineStatus == 1030 && !this.E) {
                O(6);
            } else if (extOnlineStatus == 1040) {
                AppInterface appInterface = this.f255945d;
                String i3 = kc2.c.i(appInterface, appInterface.getCurrentAccountUin());
                if (TextUtils.isEmpty(i3)) {
                    IProfileProtocolService iProfileProtocolService = (IProfileProtocolService) this.f255945d.getRuntimeService(IProfileProtocolService.class, "all");
                    if (iProfileProtocolService != null) {
                        iProfileProtocolService.requestProfileCard(this.f255945d.getCurrentAccountUin(), this.f255945d.getCurrentUin(), 0, 0L, (byte) 1, 0L, 0L, null, "", 0L, 10004, null, (byte) 0);
                    }
                    IProfileCardUtil iProfileCardUtil = (IProfileCardUtil) QRoute.api(IProfileCardUtil.class);
                    AppInterface appInterface2 = this.f255945d;
                    this.f255947f = iProfileCardUtil.initCard(appInterface2, appInterface2.getCurrentAccountUin()).lBirthday;
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusDataManagerImpl", 2, "sendBussinessInfoRegisterPush: invoked. [constellation] (\u661f\u5ea7\u4e0d\u5b58\u5728\uff0c\u90a3\u4e48\u6267\u884c\u4e00\u6b21\u8d44\u6599\u62c9\u53d6\uff0c\u5728\u8d44\u6599\u56de\u8c03\u4e2d\u62c9\u53d6\u8fd0\u52bf)", " mSelfCurrentBirthday: ", Long.valueOf(this.f255947f));
                    }
                } else {
                    boolean isEmpty = TextUtils.isEmpty(kc2.c.v(this.f255945d, this.f255945d.getCurrentAccountUin()));
                    if (isEmpty) {
                        OnlineStatusExtInfoServlet.b(this.f255945d, i3);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusDataManagerImpl", 2, "sendBussinessInfoRegisterPush: invoked. (\u6ce8\u518c\u4e0a\u7ebf\u65f6\uff0c\u661f\u5ea7\u8d44\u6599\u4e0d\u7a7a\uff0c\u4f46\u8fd0\u52bf\u4e3a\u7a7a\uff0c\u90a3\u4e48\u6267\u884c\u4e00\u6b21\u8fd0\u52bf\u62c9\u53d6\u903b\u8f91)", " emptyTrend: ", Boolean.valueOf(isEmpty));
                    }
                }
            }
            k(extOnlineStatus);
            M();
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        if (!F()) {
            return;
        }
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.f255945d.getRuntimeService(IOnlineStatusService.class, "");
        AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
        long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
        if (onlineStatus == AppRuntime.Status.online && extOnlineStatus == 1030 && this.f255945d.isBackgroundStop) {
            this.f255948h.removeCallbacks(this.G);
            this.f255948h.post(this.G);
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusDataManagerImpl", 2, "onRunningBackground");
            }
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        if (!F()) {
            return;
        }
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) this.f255945d.getRuntimeService(IOnlineStatusService.class, "");
        AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
        long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
        if (onlineStatus == AppRuntime.Status.online && extOnlineStatus == 1030) {
            this.f255948h.removeCallbacks(this.G);
            this.E = false;
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusDataManagerImpl", 2, "onRunningForground");
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.j
    public void onDestroy() {
        E();
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).unregisterStudyModeChangeListener(this.C);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this);
        }
        this.D.a();
        this.f255945d.removeObserver(this.f255946e);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
    }
}
