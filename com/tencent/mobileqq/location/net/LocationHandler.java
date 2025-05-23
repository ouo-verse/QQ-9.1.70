package com.tencent.mobileqq.location.net;

import android.app.Notification;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.api.ILocationUtilApi;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationHandler extends BusinessHandler implements IGuardInterface {
    static IPatchRedirector $redirector_;
    private static final Handler D;
    private final AppInterface C;

    /* renamed from: d, reason: collision with root package name */
    private int f241309d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.location.net.b f241310e;

    /* renamed from: f, reason: collision with root package name */
    private c f241311f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.troop.api.observer.b f241312h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.friend.observer.a f241313i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f241314m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationHandler.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            super.l(i3, i16, str);
            if ((i3 == 2 || i3 == 9) && i16 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("LocationHandler", 2, "onTroopManagerSuccess: invoked. \u4e3b\u52a8\u9000\u7fa4 or \u89e3\u6563\u7fa4", " reqtype: ", Integer.valueOf(i3), " troopUin: ", str);
                }
                LocationShareViewModel.g2(LocationHandler.this.C, 1, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationHandler.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            super.onUpdateDelFriend(z16, obj);
            if (z16 && (obj instanceof Long)) {
                LocationShareViewModel.g2(LocationHandler.this.C, 0, String.valueOf(obj));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26090);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            D = new Handler(ThreadManagerV2.getSubThreadLooper());
        }
    }

    public LocationHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f241309d = -1;
        this.f241314m = false;
        this.C = appInterface;
        F2();
        this.f241310e = new com.tencent.mobileqq.location.net.b(appInterface.getAccount());
    }

    private void F2() {
        this.f241311f = new c();
        this.f241312h = new a();
        this.f241313i = new b();
        this.C.addObserver(this.f241311f);
        this.C.addObserver(this.f241312h);
        this.C.addObserver(this.f241313i);
    }

    public static int I2(int i3) {
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 3) {
            return 0;
        }
        return 1;
    }

    public static LocationHandler K2() {
        return (LocationHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ILocationUtilApi) QRoute.api(ILocationUtilApi.class)).getClassName());
    }

    public void G2(com.tencent.mobileqq.location.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) hVar);
        } else {
            this.f241310e.a(hVar);
        }
    }

    public int H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f241309d;
    }

    public LocationRoom J2(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LocationRoom) iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
        }
        return this.f241310e.c(bVar);
    }

    public void L2(LocationRoom.b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + bVar + " clientType: " + i3);
        }
        LocationShareLocationManager.h().o(bVar, true);
        this.f241310e.d(bVar, i3);
    }

    public void M2(LocationRoom.b bVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bVar, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f241310e.e(bVar, i3, i16);
        }
    }

    public void N2(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
            return;
        }
        e.c().f(bVar);
        LocationRoom.b bVar2 = new LocationRoom.b(LocationShareLocationManager.h().f241318a.p(), LocationShareLocationManager.h().f241318a.o());
        if (!bVar2.equals(bVar)) {
            if (QLog.isColorLevel()) {
                QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + bVar + " org roomKey: " + bVar2);
            }
            this.f241310e.h(bVar2);
        }
    }

    public void O2(LocationRoom.b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + bVar + " reason: " + i3);
        }
        LocationShareLocationManager.h().o(bVar, false);
        this.f241310e.f(bVar, i3);
    }

    public void P2(LocationRoom.b bVar, LocationRoom.Venue venue, List<com.tencent.mobileqq.location.data.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bVar, venue, list);
        } else {
            this.f241310e.g(bVar, venue, list);
        }
    }

    public void Q2(com.tencent.mobileqq.location.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) hVar);
        } else {
            this.f241310e.i(hVar);
        }
    }

    public void R2(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
        } else {
            this.f241310e.j(i3, str);
        }
    }

    public void S2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f241309d = -1;
        }
    }

    public void T2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f241309d = i3;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Class) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationHandler", 2, "[LocationManager] onAppBackground: invoked. ");
        }
        this.f241314m = false;
        Handler handler = D;
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.location.net.LocationHandler.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (LocationHandler.this.f241314m) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LocationHandler", 2, "run: invoked. ", " bgHandlerForDelayExitRoomStopped: ", Boolean.valueOf(LocationHandler.this.f241314m));
                        return;
                    }
                    return;
                }
                LocationShareLocationManager.h().o(e.c().f241358b, true);
                e.c().f241361e.m();
                QQToast.makeText(BaseApplication.getContext(), BaseApplication.getContext().getString(R.string.iq_), 0).show();
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if (qBaseActivity != null) {
                    String stringExtra = qBaseActivity.getIntent().getStringExtra("FRAGMENT_KEY");
                    if (QLog.isColorLevel()) {
                        QLog.d("LocationHandler", 2, "onAppBackground::run: invoked[\u4ec5\u7528\u6765\u5173\u95ed\u5730\u56fe\u9875]. ", " fragmentKey: ", stringExtra);
                    }
                    if ("LocationShareFragment".equals(stringExtra)) {
                        qBaseActivity.finish();
                    }
                }
                ReportController.o(null, "CliOper", "", "", "0X800A8BB", "0X800A8BB", 0, 0, "", "0", "0", "");
            }
        }, 60000L);
        if (!LocationShareLocationManager.h().i()) {
            return;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(BaseApplication.getContext());
        builder.setContentText(BaseApplication.getContext().getString(R.string.f171150iv4)).setWhen(System.currentTimeMillis()).setSmallIcon(R.drawable.b8g).setAutoCancel(true);
        Notification build = builder.build();
        QQNotificationManager.addChannelIfNeed(build, QQNotificationManager.CHANNEL_ID_OTHER);
        QQNotificationManager.getInstance().notify("LocationHandler", 525, build);
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.location.net.LocationHandler.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocationHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
                }
            }
        }, 3000L);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationHandler", 2, "[LocationManager] onAppForeground: invoked. ");
        }
        QQNotificationManager.getInstance().cancel("LocationHandler", 525);
        this.f241314m = true;
        D.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
        }
        LocationShareLocationManager.h().o(e.c().f241358b, true);
        this.C.removeObserver(this.f241312h);
        this.C.removeObserver(this.f241313i);
        this.C.removeObserver(this.f241311f);
        e.c().f241361e.e();
        LocationShareLocationManager.h().f241318a.k();
        this.f241310e.b();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQLBSShareSvc.room_operation".equals(fromServiceMsg.getServiceCmd())) {
            e.c().f241360d.f(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("QQLBSShareSvc.report_location".equals(fromServiceMsg.getServiceCmd())) {
            LocationShareLocationManager.h().f241318a.s(toServiceMsg, fromServiceMsg, obj);
        } else if ("QQLBSShareSvc.room_query".equals(fromServiceMsg.getServiceCmd())) {
            e.c().f241361e.l(toServiceMsg, fromServiceMsg, obj);
        } else if ("QQLBSShareSvc.assembly_point_operation".equals(fromServiceMsg.getServiceCmd())) {
            f.b().h(toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        }
    }
}
