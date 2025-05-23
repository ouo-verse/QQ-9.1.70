package com.tencent.mobileqq.location;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.f;
import com.tencent.mobileqq.location.ui.LocationDialogUtil;
import com.tencent.mobileqq.location.window.FloatMapDialogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationShareViewModel extends com.tencent.mobileqq.mvvm.c<d> {
    static IPatchRedirector $redirector_;
    public static ViewModelProvider.Factory G;
    private LocationRoom.b C;
    public MutableLiveData<com.tencent.mobileqq.location.model.b> D;
    public MutableLiveData<Boolean> E;
    public MutableLiveData<com.tencent.mobileqq.location.model.c> F;

    /* renamed from: i, reason: collision with root package name */
    private AppInterface f241197i;

    /* renamed from: m, reason: collision with root package name */
    private QBaseActivity f241198m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            }
            return new LocationShareViewModel(new d());
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements f.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocationRoom.Venue f241202a;

        b(LocationRoom.Venue venue) {
            this.f241202a = venue;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationShareViewModel.this, (Object) venue);
            }
        }

        @Override // com.tencent.mobileqq.location.net.f.a
        public void a(LocationRoom.b bVar, LocationRoom.Venue venue, int i3, boolean z16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, bVar, venue, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.LocationShare", 2, "[venue] setVenue: onResult. roomKey: " + bVar + " venue: " + venue + " mRoomKey: " + LocationShareViewModel.this.C + " optType: " + i3, " isSuccess: " + z16 + " errorCode: " + i16);
            }
            if (bVar != null && bVar.equals(LocationShareViewModel.this.C) && venue != null) {
                if (!z16) {
                    if (i16 != 10001 && i16 != 10003 && i16 != 10004 && i16 != 10100) {
                        ReportController.o(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
                    } else {
                        ReportController.o(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
                    }
                }
                com.tencent.mobileqq.location.model.c cVar = new com.tencent.mobileqq.location.model.c();
                cVar.f241307d = 1;
                cVar.f241308e = 2;
                cVar.f241304a = this.f241202a;
                cVar.f241305b = z16;
                cVar.f241306c = i16;
                LocationShareViewModel.this.F.postValue(cVar);
            }
        }

        @Override // com.tencent.mobileqq.location.net.f.a
        public Pair<LocationRoom.b, LocationRoom.Venue> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Pair) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new Pair<>(LocationShareViewModel.this.C, this.f241202a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements f.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocationRoom.Venue f241204a;

        c(LocationRoom.Venue venue) {
            this.f241204a = venue;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocationShareViewModel.this, (Object) venue);
            }
        }

        @Override // com.tencent.mobileqq.location.net.f.a
        public void a(LocationRoom.b bVar, LocationRoom.Venue venue, int i3, boolean z16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, bVar, venue, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.LocationShare", 2, "[venue] removeVenue: onResult. roomKey: " + bVar + " optType: " + i3, " isSuccess: " + z16 + " errorCode: " + i16);
            }
            if (bVar != null && bVar.equals(LocationShareViewModel.this.C) && venue != null) {
                if (z16) {
                    ReportController.o(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
                } else {
                    QQToast.makeText(LocationShareViewModel.this.f241198m, 1, "\u79fb\u9664\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                    if (i16 != 10001 && i16 != 10003 && i16 != 10004 && i16 != 10100) {
                        ReportController.o(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
                    } else {
                        ReportController.o(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
                    }
                }
                com.tencent.mobileqq.location.model.c cVar = new com.tencent.mobileqq.location.model.c();
                cVar.f241307d = 2;
                cVar.f241308e = 2;
                cVar.f241305b = z16;
                LocationShareViewModel.this.F.postValue(cVar);
            }
        }

        @Override // com.tencent.mobileqq.location.net.f.a
        public Pair<LocationRoom.b, LocationRoom.Venue> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Pair) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new Pair<>(LocationShareViewModel.this.C, this.f241204a);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25335);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            G = new a();
        }
    }

    public LocationShareViewModel(d dVar) {
        super(dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            return;
        }
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit T1(Function1 function1, TroopMemberNickInfo troopMemberNickInfo) {
        function1.invoke(troopMemberNickInfo.getShowName());
        return null;
    }

    public static void g2(AppInterface appInterface, int i3, String str) {
        h2(appInterface, i3, str, -1);
    }

    public static void h2(AppInterface appInterface, int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "stopOnErrorSituationByReason: invoked. ", " uin: ", str, " reason: ", Integer.valueOf(i16));
        }
        LocationRoom.b bVar = new LocationRoom.b(i3, str);
        LocationShareLocationManager.h().o(bVar, false);
        com.tencent.mobileqq.location.net.e.c().f241361e.e();
        ThreadManagerV2.excute(new Runnable(i3, str) { // from class: com.tencent.mobileqq.location.LocationShareViewModel.4
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f241200e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f241201f;

            {
                this.f241200e = i3;
                this.f241201f = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AppInterface.this, Integer.valueOf(i3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.location.util.b.f(AppInterface.this, this.f241200e, this.f241201f, false);
                }
            }
        }, 32, null, false);
        LocationHandler.K2().O2(bVar, i16);
        ((ILocationShareService) appInterface.getRuntimeService(ILocationShareService.class, "")).notifyStateError(i3, str, false);
        ReportController.o(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
    }

    public void O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ((d) this.mRepository).l();
        }
    }

    public void P1(LocationRoom.Venue venue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) venue);
            return;
        }
        com.tencent.mobileqq.location.model.c cVar = new com.tencent.mobileqq.location.model.c();
        cVar.f241308e = 1;
        cVar.f241307d = 1;
        cVar.f241304a = venue;
        this.F.postValue(cVar);
        com.tencent.mobileqq.location.net.f.b().a(this.C, venue, new b(venue));
    }

    protected AppRuntime Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public String R1(String str, final Function1<String, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) function1);
        }
        if (Long.parseLong(str) <= 0) {
            return str;
        }
        String friendNick = ((IFriendNameService) Q1().getRuntimeService(IFriendNameService.class, "")).getFriendNick(str);
        if (this.C.b() == 0) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            aVar.d(uidFromUin);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            if (TextUtils.isEmpty(nameWithConfig)) {
                return nameWithConfig;
            }
            return friendNick;
        }
        if (this.C.b() == 1) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(this.C.c(), str, "Q.LocationShare", new Function1() { // from class: com.tencent.mobileqq.location.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit T1;
                    T1 = LocationShareViewModel.T1(Function1.this, (TroopMemberNickInfo) obj);
                    return T1;
                }
            });
            return friendNick;
        }
        return friendNick;
    }

    public void S1(AppInterface appInterface, QBaseActivity qBaseActivity, LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, qBaseActivity, bVar);
            return;
        }
        this.f241197i = appInterface;
        this.f241198m = qBaseActivity;
        this.C = bVar;
        ((d) this.mRepository).m(appInterface, this);
    }

    public void U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            ((d) this.mRepository).onDestroy();
            this.f241198m = null;
        }
    }

    public void W1(LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + bVar + " mRoomKey: " + this.C);
        }
        QQToast.makeText(BaseApplication.getContext(), "\u5df2\u5728\u5176\u4ed6\u8bbe\u5907\u8fdb\u884c\u5171\u4eab", 0).show();
        this.f241198m.finish();
    }

    public void X1(LocationRoom.b bVar, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar, i3);
            return;
        }
        if (!bVar.equals(this.C)) {
            return;
        }
        if (com.tencent.mobileqq.location.net.e.c().b() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.location.net.e.c().f(null);
        if (i3 != 2 && i3 != 1 && !z16) {
            LocationDialogUtil.k(this.f241198m);
        }
    }

    public void Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "myBtn onClick: invoked. set my btn black");
        }
        ReportController.o(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
        this.E.setValue(Boolean.TRUE);
    }

    public void a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.C != null) {
            FloatMapDialogUtil.a(this.f241198m);
            h2(this.f241197i, this.C.b(), this.C.c(), 2);
        }
    }

    public void b2(LocationRoom.b bVar, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, bVar, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.LocationShare", 2, "onOperateRoomResponse: invoked. ", " roomKey: ", bVar, " errorCode: ", Integer.valueOf(i3), " operateType: ", Integer.valueOf(i16));
        }
        if (!bVar.equals(this.C)) {
            return;
        }
        if (i3 == 10100) {
            if (i16 == 2 && LocationHandler.K2().H2() == 1) {
                if (this.C != null) {
                    com.tencent.mobileqq.location.net.e.c().f241360d.e(1, this.C.b(), this.C.c());
                    QLog.d("Q.LocationShare", 1, "onOperateRoomResponse: invoked. \u515c\u5e95\u5904\u7406\u623f\u95f4\u5173\u95ed\u72b6\u6001\uff0c\u5728\u8fdb\u623f\u5931\u8d25\u540e\u521b\u5efa\u623f\u95f4\u3002 ", " errorCode: ", Integer.valueOf(i3));
                    return;
                } else {
                    QLog.e("Q.LocationShare", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
                    return;
                }
            }
            QBaseActivity qBaseActivity = this.f241198m;
            if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                LocationDialogUtil.k(this.f241198m);
                return;
            }
            return;
        }
        if (i3 == 10101) {
            QBaseActivity qBaseActivity2 = this.f241198m;
            if (qBaseActivity2 != null && !qBaseActivity2.isFinishing()) {
                LocationDialogUtil.l(this.f241198m);
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.LocationShare", 2, "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", bVar);
            }
        }
    }

    public void c2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (this.C.b() == 1 && this.C.c().equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.LocationShare", 2, "onPassiveExit: invoked. ", " troopUin: ", str);
            }
            QBaseActivity qBaseActivity = this.f241198m;
            if (qBaseActivity != null) {
                qBaseActivity.finish();
                QQToast.makeText(BaseApplication.getContext(), R.string.iq9, 1).show();
            }
            g2(this.f241197i, 1, str);
        }
    }

    public void d2(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
            return;
        }
        if (z16 && str.equals(this.C.c())) {
            g2(this.f241197i, 0, str);
            QBaseActivity qBaseActivity = this.f241198m;
            if (qBaseActivity != null) {
                qBaseActivity.finish();
            }
        }
    }

    public void e2(LocationRoom.Venue venue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) venue);
            return;
        }
        com.tencent.mobileqq.location.model.c cVar = new com.tencent.mobileqq.location.model.c();
        cVar.f241307d = 2;
        cVar.f241308e = 1;
        this.F.postValue(cVar);
        com.tencent.mobileqq.location.net.f.b().g(this.C, venue, new c(venue));
    }

    @Override // com.tencent.mobileqq.mvvm.c
    /* renamed from: f2, reason: merged with bridge method [inline-methods] */
    public void setRepository(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else {
            super.setRepository(dVar);
        }
    }
}
