package com.tencent.mobileqq.onlinestatus;

import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.app.BatteryBroadcastReceiver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class OnLineStatusPresenter implements z {

    /* renamed from: a, reason: collision with root package name */
    private int f255321a;

    /* renamed from: b, reason: collision with root package name */
    private bw f255322b;

    /* renamed from: c, reason: collision with root package name */
    private hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> f255323c;

    /* renamed from: d, reason: collision with root package name */
    private String f255324d;

    /* renamed from: e, reason: collision with root package name */
    private String f255325e;

    /* renamed from: f, reason: collision with root package name */
    private h43.a f255326f = null;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.mobileqq.onlinestatus.observer.b f255327g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f255328h;

    /* renamed from: i, reason: collision with root package name */
    private int f255329i;

    /* renamed from: j, reason: collision with root package name */
    private BatteryBroadcastReceiver f255330j;

    /* renamed from: k, reason: collision with root package name */
    private int f255331k;

    public OnLineStatusPresenter(@NonNull QBaseActivity qBaseActivity, @NonNull bw bwVar) {
        com.tencent.mobileqq.onlinestatus.observer.b bVar = new com.tencent.mobileqq.onlinestatus.observer.b() { // from class: com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter.1
            private void e(long j3) {
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                if (!from.isAccessible()) {
                    return;
                }
                from.encodeLong(IOnLineStatueHelperApi.ONLINE_STATUS_TIMEOUT, System.currentTimeMillis() + j3);
            }

            @Override // com.tencent.mobileqq.onlinestatus.observer.b
            protected void c(boolean z16, Map<String, Object> map) {
                int intValue;
                QLog.d("OnLineStatusPresenter", 1, "updateLikeListStatus isSuccess=" + z16);
                if (!z16) {
                    return;
                }
                String str = (String) map.get("from");
                if (!"login".equals(str) && !"push".equals(str)) {
                    return;
                }
                long longValue = ((Long) map.get("time_out")).longValue();
                e(longValue);
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OnLineStatusPresenter.this.c("LikeListStatus");
                    }
                }, longValue + 10);
                Integer num = (Integer) map.get("unread_num");
                OnLineStatusPresenter onLineStatusPresenter = OnLineStatusPresenter.this;
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                onLineStatusPresenter.f255321a = intValue;
                OnLineStatusPresenter onLineStatusPresenter2 = OnLineStatusPresenter.this;
                onLineStatusPresenter2.H(onLineStatusPresenter2.f255321a);
                OnLineStatusPresenter.this.c("LikeListStatus");
            }
        };
        this.f255327g = bVar;
        this.f255328h = new Handler(Looper.getMainLooper());
        this.f255329i = 0;
        this.f255331k = -2147483548;
        this.f255322b = bwVar;
        ((AppInterface) qBaseActivity.getAppRuntime()).addObserver(bVar);
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, au auVar, AppRuntime.Status status, long j3, h43.f fVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).setStepStatusInfo(fVar);
        q(cVar, auVar, status, j3);
    }

    private void B(AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusPresenter", 2, "registerBatteryBroadcastReceiver start");
        }
        try {
            if (this.f255330j == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                this.f255330j = new BatteryBroadcastReceiver(appRuntime);
                BaseApplication.getContext().registerReceiver(this.f255330j, intentFilter);
                if (QLog.isColorLevel()) {
                    QLog.d("OnLineStatusPresenter", 2, "registerBatteryBroadcastReceiver success");
                }
            }
            ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).registerBatteryBroadcastReceiver();
        } catch (Throwable th5) {
            QLog.e("OnLineStatusPresenter", 1, th5, "registerBatteryBroadcastReceiver fail");
        }
    }

    private void C() {
        String str = this.f255324d;
        hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> bVar = this.f255323c;
        if (str != null && bVar != null) {
            ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).removeOnlineStatusSimpleInfoCallback(str, "OnLineStatusPresenter", bVar);
        }
    }

    private void D() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        this.f255321a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("KEY_RED_HEART_UNREAD_NUM_" + peekAppRuntime.getCurrentUin(), 0);
    }

    private boolean E() {
        if (this.f255321a <= 0) {
            return false;
        }
        if (System.currentTimeMillis() >= QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(IOnLineStatueHelperApi.ONLINE_STATUS_TIMEOUT, 0L)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void x(String str) {
        long j3;
        QLog.d("OnLineStatusPresenter", 1, "[status][conversation] updateOnlineStatusAsync from: " + str);
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        final AppRuntime.Status onlineStatus = ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        final long M = af.C().M(peekAppRuntime);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.aj
            @Override // java.lang.Runnable
            public final void run() {
                OnLineStatusPresenter.this.y(peekAppRuntime, onlineStatus, M);
            }
        }, 16, null, true);
        if (MobileQQ.sMobileQQ.getFirstSimpleAccount() == null) {
            QLog.e("OnLineStatusPresenter", 1, "getFirstSimpleAccount failed!");
            return;
        }
        final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnLineStatusPresenterupdateOnlineStatusAsync");
        if (H == null) {
            QLog.w("OnLineStatusPresenter", 1, "updateOnlineStatusInternal simpleInfo is null");
            return;
        }
        AppRuntime.Status status = AppRuntime.Status.online;
        if (onlineStatus == status && M == 1000) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.ak
                @Override // java.lang.Runnable
                public final void run() {
                    OnLineStatusPresenter.this.z(peekAppRuntime, onlineStatus, M, H);
                }
            }, 16, null, true);
            return;
        }
        final au I = af.C().I(onlineStatus, M);
        if (OnlineStatusToggleUtils.A() && onlineStatus == status && M == 2017) {
            this.f255326f = new h43.a() { // from class: com.tencent.mobileqq.onlinestatus.al
                @Override // h43.a
                public final void a(h43.f fVar) {
                    OnLineStatusPresenter.this.A(H, I, onlineStatus, M, fVar);
                }
            };
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo(H.f0(), Boolean.TRUE, this.f255326f);
            return;
        }
        if (!af.C().h0(I, H, true)) {
            onlineStatus = status;
            j3 = 0;
        } else {
            j3 = M;
        }
        q(H, I, onlineStatus, j3);
    }

    private void G(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, AppRuntime.Status status, long j3, au auVar) {
        if (this.f255322b == null) {
            QLog.i("OnLineStatusPresenter", 1, "updateStatusInfo FrameHelperActivity is already destroy");
            return;
        }
        Drawable O = af.C().O(j3, status, 0, cVar, 4);
        TextView a16 = this.f255322b.a();
        if (a16 == null) {
            return;
        }
        String w3 = af.C().w(MobileQQ.sMobileQQ.waitAppRuntime(null), auVar, status, cVar, a16, 4);
        if (TextUtils.isEmpty(w3)) {
            return;
        }
        if (E()) {
            com.tencent.mobileqq.onlinestatus.utils.z.q();
            com.tencent.mobileqq.onlinestatus.view.ay ayVar = new com.tencent.mobileqq.onlinestatus.view.ay(a16.getResources());
            ayVar.d(String.valueOf(this.f255321a));
            this.f255322b.b(w3, O, ayVar);
        } else {
            this.f255322b.b(w3, O, null);
        }
        QLog.d("OnLineStatusPresenter", 1, "updateStatusInfo status=" + status + ", extOnlineStatus=" + j3 + ", simpleInfo=(" + ((int) cVar.u()) + "," + cVar.e0() + "), statusInfo=" + com.tencent.util.k.d(w3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("KEY_RED_HEART_UNREAD_NUM_" + peekAppRuntime.getCurrentUin(), i3);
    }

    private void p() {
        String str;
        if (!OnlineStatusToggleUtils.F()) {
            return;
        }
        this.f255323c = new hx3.b() { // from class: com.tencent.mobileqq.onlinestatus.ah
            @Override // hx3.b
            public final void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
                OnLineStatusPresenter.this.v(eVar);
            }
        };
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUid();
        } else {
            str = null;
        }
        if (str != null && !str.isEmpty()) {
            this.f255324d = str;
            ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).addOnlineStatusSimpleInfoCallback(str, "OnLineStatusPresenter_registerNTOnlineStatusCallback", this.f255323c);
        } else {
            QLog.w("OnLineStatusPresenter", 1, "registerNTOnlineStatusCallback fail, uid is empty");
        }
    }

    private void q(final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, final au auVar, final AppRuntime.Status status, final long j3) {
        this.f255328h.removeCallbacksAndMessages(null);
        this.f255328h.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.am
            @Override // java.lang.Runnable
            public final void run() {
                OnLineStatusPresenter.this.w(cVar, status, j3, auVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar;
        AppRuntime.Status c16;
        if (eVar == null || eVar.a() != 0 || eVar.b() == null || eVar.b().isEmpty() || (cVar = (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) eVar.b().get(0)) == null || (c16 = com.tencent.mobileqq.onlinestatus.utils.ae.c(cVar)) == null) {
            return;
        }
        String str = this.f255325e;
        if (str != null && str.equals(cVar.toString())) {
            return;
        }
        this.f255325e = cVar.toString();
        QLog.d("OnLineStatusPresenter", 1, "onNTQueryResult uin: " + cVar.f0());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
        final String str2 = "OnLineStatusPresenter_OnNTQueryResult";
        iOnlineStatusService.setOnlineStatus(c16, "OnLineStatusPresenter_OnNTQueryResult");
        iOnlineStatusService.setExtOnlineStatus(cVar.e0());
        iOnlineStatusService.setDiyInfo(new DiyStatusEmoInfo(cVar.x(), cVar.w(), cVar.v()));
        com.tencent.mobileqq.onlinestatus.utils.aa.i(cVar.w(), cVar.x(), cVar.v(), peekAppRuntime);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.ai
            @Override // java.lang.Runnable
            public final void run() {
                OnLineStatusPresenter.this.u(str2);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, AppRuntime.Status status, long j3, au auVar) {
        try {
            G(cVar, status, j3, auVar);
        } catch (Exception e16) {
            QLog.e("OnLineStatusPresenter", 1, "doUpdateStatus " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(AppRuntime appRuntime, AppRuntime.Status status, long j3, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).checkBatteryStatus();
        au I = af.C().I(status, j3);
        if (!af.C().h0(I, cVar, true)) {
            status = AppRuntime.Status.online;
            j3 = 0;
        }
        q(cVar, I, status, j3);
    }

    @Override // com.tencent.mobileqq.onlinestatus.z
    public void a(AppInterface appInterface) {
        if (!appInterface.containObserver(this.f255327g, false)) {
            appInterface.addObserver(this.f255327g);
        }
        C();
        p();
    }

    @Override // com.tencent.mobileqq.onlinestatus.z
    public void b(AppInterface appInterface) {
        if (appInterface != null && appInterface.containObserver(this.f255327g, false)) {
            appInterface.removeObserver(this.f255327g);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.z
    public void c(final String str) {
        if ("from_user_click".equals(str)) {
            if (this.f255321a > 0) {
                com.tencent.mobileqq.onlinestatus.utils.z.p();
                this.f255321a = 0;
                H(0);
            }
        } else if (!"OnlineStatusObserver.onSetOnlineStatus".equals(str) && !"from_user_click_dianzan_num".equals(str)) {
            if ("AccountChange".equals(str)) {
                D();
            }
        } else {
            this.f255321a = 0;
            H(0);
        }
        if (this.f255322b == null) {
            QLog.i("OnLineStatusPresenter", 1, "FrameHelperActivity is already destroy");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.ag
            @Override // java.lang.Runnable
            public final void run() {
                OnLineStatusPresenter.this.x(str);
            }
        }, 16, null, true);
        if (this.f255323c == null) {
            p();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.z
    public void d(bw bwVar) {
        this.f255322b = bwVar;
    }

    @Override // com.tencent.mobileqq.onlinestatus.z
    public void e(int i3) {
        int i16;
        if (i3 > 0) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        this.f255329i = i16;
    }

    public int r() {
        if (this.f255331k == -2147483548) {
            this.f255331k = -1;
            if (t()) {
                try {
                    this.f255331k = SystemMethodProxy.getIntProperty((BatteryManager) BaseApplication.getContext().getSystemService("batterymanager"), 4);
                    if (QLog.isColorLevel()) {
                        QLog.d("OnLineStatusPresenter", 2, "BatterManager ", Integer.valueOf(this.f255331k));
                    }
                } catch (NoSuchMethodError e16) {
                    QLog.e("OnLineStatusPresenter", 1, e16, "getLocalBatteryCapacity fail");
                }
            }
        }
        return this.f255331k;
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void y(AppRuntime appRuntime, AppRuntime.Status status, long j3) {
        if (appRuntime != null) {
            if (r() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("OnLineStatusPresenter", 2, "handleBatteryChangeBroadcastReceiver LocalBattery correct");
                }
                if (status == AppRuntime.Status.online && j3 == 1000) {
                    B(appRuntime);
                    return;
                } else {
                    unRegisterBatteryBroadcastReceiver();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("OnLineStatusPresenter", 2, "handleBatteryChangeBroadcastReceiver LocalBattery wrong");
            }
            int i3 = this.f255329i;
            if (i3 == 0) {
                B(appRuntime);
                return;
            }
            if (i3 == 1) {
                if (status == AppRuntime.Status.online && j3 == 1000) {
                    B(appRuntime);
                    return;
                } else {
                    unRegisterBatteryBroadcastReceiver();
                    return;
                }
            }
            if (i3 == 2) {
                unRegisterBatteryBroadcastReceiver();
            }
        }
    }

    boolean t() {
        return true;
    }

    @Override // com.tencent.mobileqq.onlinestatus.z
    public void unRegisterBatteryBroadcastReceiver() {
        if (QLog.isColorLevel()) {
            QLog.d("OnLineStatusPresenter", 2, "unRegisterBatteryBroadcastReceiver start");
        }
        try {
            if (this.f255330j != null) {
                BaseApplication.getContext().unregisterReceiver(this.f255330j);
                this.f255330j = null;
                if (QLog.isColorLevel()) {
                    QLog.d("OnLineStatusPresenter", 2, "unRegisterBatteryBroadcastReceiver success");
                }
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).unRegisterBatteryBroadcastReceiver();
            }
        } catch (Throwable th5) {
            QLog.e("OnLineStatusPresenter", 1, th5, "unRegisterBatteryBroadcastReceiver fail");
        }
    }
}
