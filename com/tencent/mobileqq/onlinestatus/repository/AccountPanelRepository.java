package com.tencent.mobileqq.onlinestatus.repository;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.onlinestatus.ac;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.onlinestatus.bb;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.manager.g;
import com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAggregationHandler;
import com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository;
import com.tencent.mobileqq.onlinestatus.tencentvideo.TencentVideoNameHandler;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.utils.ae;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IFriendsUtils;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;
import tencent.im.onlinestatus.OnlineStatusExtInfo$SynchVideoBizInfo;

/* loaded from: classes16.dex */
public class AccountPanelRepository extends com.tencent.mobileqq.mvvm.a implements g.a {

    /* renamed from: a, reason: collision with root package name */
    private AccountPanelViewModel f256187a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.onlinestatus.manager.g f256188b;

    /* renamed from: d, reason: collision with root package name */
    private String f256190d;

    /* renamed from: c, reason: collision with root package name */
    private boolean f256189c = false;

    /* renamed from: e, reason: collision with root package name */
    private av f256191e = new c();

    /* renamed from: f, reason: collision with root package name */
    private bb f256192f = new d();

    /* renamed from: g, reason: collision with root package name */
    private wc2.c f256193g = new e();

    /* renamed from: h, reason: collision with root package name */
    private AccountObserver f256194h = new f();

    /* renamed from: i, reason: collision with root package name */
    private ac f256195i = new g();

    /* renamed from: j, reason: collision with root package name */
    private Observer f256196j = new Observer() { // from class: com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.6
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                QLog.d("AccountPanelRepository", 1, String.format("mObserver update return", new Object[0]));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelRepository", 2, "update");
            }
            if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                if (strArr.length == 2 && AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(strArr[0])) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AccountPanelRepository", 2, "update() -> before update");
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AccountPanelRepository.this.f256187a.l3();
                        }
                    });
                }
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.mobileqq.avatar.observer.a f256197k = new h();

    /* renamed from: l, reason: collision with root package name */
    private BusinessObserver f256198l = ((IFriendsUtils) QRoute.api(IFriendsUtils.class)).createFriendObserver(new i());

    /* renamed from: m, reason: collision with root package name */
    private final hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> f256199m = new j();

    /* renamed from: n, reason: collision with root package name */
    private BusinessObserver f256200n = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).createSubAccountBindObserver(new a());

    /* renamed from: o, reason: collision with root package name */
    private BusinessObserver f256201o = ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).createMessageObserver(new b());

    /* loaded from: classes16.dex */
    class a implements ISubAccountApi.e {
        a() {
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.e
        public void a(boolean z16, boolean z17) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && peekAppRuntime != null && !z17) {
                AccountPanelRepository.this.f256187a.l3();
                if (QLog.isColorLevel()) {
                    QLog.d("AccountPanelRepository", 2, String.format("onGetBindSubAccount, isSuccess: %s", Boolean.valueOf(z16)));
                    return;
                }
                return;
            }
            QLog.d("AccountPanelRepository", 1, String.format("onGetBindSubAccount return, isSuccess: %s", Boolean.valueOf(z16)));
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.e
        public void b(boolean z16, boolean z17) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && peekAppRuntime != null && !z17) {
                AccountPanelRepository.this.f256187a.l3();
                if (QLog.isColorLevel()) {
                    QLog.d("AccountPanelRepository", 2, String.format("onUnBindSubAccount, isSuccess: %s", Boolean.valueOf(z16)));
                    return;
                }
                return;
            }
            QLog.d("AccountPanelRepository", 1, String.format("onUnBindSubAccount return, isSuccess: %s", Boolean.valueOf(z16)));
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.e
        public void c(boolean z16, boolean z17) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && peekAppRuntime != null && !z17) {
                AccountPanelRepository.this.f256187a.l3();
                if (QLog.isColorLevel()) {
                    QLog.d("AccountPanelRepository", 2, String.format("onBindSubAccount, isSuccess: %s", Boolean.valueOf(z16)));
                    return;
                }
                return;
            }
            QLog.d("AccountPanelRepository", 1, String.format("onBindSubAccount return, isSuccess: %s", Boolean.valueOf(z16)));
        }
    }

    /* loaded from: classes16.dex */
    class b implements ISubAccountApi.d {
        b() {
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.d
        public void a(boolean z16, String str, String str2) {
            AccountPanelRepository.this.f256187a.V2(z16, str, str2);
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.d
        public void b(boolean z16, String str, boolean z17) {
            if (AccountPanelRepository.this.w(z16, str, z17)) {
                return;
            }
            AccountPanelRepository.this.f256187a.m3(z16, str, false);
        }

        @Override // com.tencent.mobileqq.subaccount.api.ISubAccountApi.d
        public void c(boolean z16, String str, boolean z17) {
            if (AccountPanelRepository.this.v(str, z17)) {
                QLog.d("AccountPanelRepository", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", Boolean.valueOf(z16), str));
            } else {
                AccountPanelRepository.this.f256187a.m3(z16, str, true);
            }
        }
    }

    /* loaded from: classes16.dex */
    class c extends av {
        c() {
        }

        private void k(AppRuntime appRuntime, byte[] bArr) {
            au I = af.C().I(((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), af.C().M(appRuntime));
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("AccountPanelRepository");
            OnlineStatusExtInfo$SynchVideoBizInfo onlineStatusExtInfo$SynchVideoBizInfo = new OnlineStatusExtInfo$SynchVideoBizInfo();
            try {
                onlineStatusExtInfo$SynchVideoBizInfo.mergeFrom(bArr);
                if (onlineStatusExtInfo$SynchVideoBizInfo.synch_type.get() == 1) {
                    if (H != null) {
                        H.d1("");
                        H.e1("");
                        H.f1("");
                        ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).updateOnlineStatusSimpleInfo(H, "", (hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a>) null);
                        return;
                    }
                    return;
                }
                String str = onlineStatusExtInfo$SynchVideoBizInfo.string_cid.get();
                String str2 = onlineStatusExtInfo$SynchVideoBizInfo.string_tvURL.get();
                if (onlineStatusExtInfo$SynchVideoBizInfo.synch_type.get() == 2 && I.f255489b == 1021 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (H != null) {
                        H.d1(str);
                        H.f1(str2);
                        ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).updateOnlineStatusSimpleInfo(H, "", (hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a>) null);
                    }
                    ((TencentVideoNameHandler) ((BaseQQAppInterface) appRuntime).getBusinessHandler(TencentVideoNameHandler.class.getName())).D2(1, str, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
                }
            } catch (Exception e16) {
                QLog.e("AccountPanelRepository", 1, "onSetTencentVideoExtInfo: " + e16);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void e(boolean z16, Bundle bundle) {
            super.e(z16, bundle);
            AccountPanelRepository.this.f256187a.R2(z16, bundle);
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean z16, Bundle bundle) {
            int i3;
            if (bundle != null) {
                i3 = (int) bundle.getLong("onlineStatus", 0L);
            } else {
                i3 = 0;
            }
            AppRuntime.Status build = AppRuntime.Status.build(i3);
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16) {
                AccountPanelRepository.this.f256187a.U2(build);
                af.C().q0();
                if (bs.Z(appInterface)) {
                    ((OnlineStatusAggregationHandler) appInterface.getBusinessHandler(OnlineStatusAggregationHandler.class.getName())).d("initiative");
                }
            } else if (bundle != null && bundle.getLong("cCode") == 99) {
                QQToast.makeText(appInterface.getApplicationContext(), R.string.zsn, 1).show();
            }
            AccountPanelRepository.this.f256187a.S2(z16, bundle, build, appInterface);
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void g(boolean z16, Bundle bundle) {
            super.g(z16, bundle);
            AccountPanelRepository.this.f256187a.T2(z16, bundle);
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void h(boolean z16, Bundle bundle) {
            AppRuntime peekAppRuntime;
            byte[] byteArray;
            super.h(z16, bundle);
            if (!z16 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (byteArray = bundle.getByteArray("TencentVideoInfo")) == null) {
                return;
            }
            k(peekAppRuntime, byteArray);
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void j(boolean z16, pc2.a aVar) {
            AccountPanelRepository.this.f256187a.W2(aVar);
        }
    }

    /* loaded from: classes16.dex */
    class d extends bb {
        d() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.bb
        public void a(boolean z16, Bundle bundle) {
            super.a(z16, bundle);
            AccountPanelRepository.this.f256187a.P2(z16, bundle);
        }
    }

    /* loaded from: classes16.dex */
    class e extends wc2.c {
        e() {
        }

        @Override // wc2.c
        public void a(boolean z16, Bundle bundle) {
            super.a(z16, bundle);
            AccountPanelRepository.this.f256187a.Q2(z16, bundle, (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
        }
    }

    /* loaded from: classes16.dex */
    class f extends AccountObserver {
        f() {
        }

        @Override // mqq.observer.AccountObserver
        protected void onOnlineStatusChanged(boolean z16, AppRuntime.Status status, long j3, boolean z17, boolean z18, long j16, boolean z19) {
            if (z16) {
                AccountPanelRepository.this.f256187a.U2(status);
            }
            if (!z17) {
                return;
            }
            AccountPanelRepository.this.f256187a.N2(z16, (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), status);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mqq.observer.AccountObserver
        public void onOnlineStatusPush(AppRuntime.Status status, long j3) {
            AccountPanelRepository.this.f256187a.O2(status, j3);
        }
    }

    /* loaded from: classes16.dex */
    class g extends ac {
        g() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.ac
        public void a(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelRepository", 2, "onBatteryChanged updateOnlineStatusItem");
            }
            AccountPanelRepository.this.f256187a.k2().setValue(Integer.valueOf(i3));
        }

        @Override // com.tencent.mobileqq.onlinestatus.ac
        public void b() {
            AccountPanelRepository.this.f256187a.A2().setValue(Boolean.TRUE);
        }
    }

    /* loaded from: classes16.dex */
    class h extends com.tencent.mobileqq.avatar.observer.a {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && !TextUtils.isEmpty(str) && peekAppRuntime != null) {
                AccountPanelRepository.this.f256187a.m2().setValue(str);
                if (QLog.isColorLevel()) {
                    QLog.d("AccountPanelRepository", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", Boolean.valueOf(z16), str));
                    return;
                }
                return;
            }
            QLog.d("AccountPanelRepository", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", Boolean.valueOf(z16), str));
        }
    }

    /* loaded from: classes16.dex */
    class i implements IFriendsUtils.a {
        i() {
        }

        @Override // com.tencent.mobileqq.relation.api.IFriendsUtils.a
        public void a(String str, boolean z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && !TextUtils.isEmpty(str) && peekAppRuntime != null) {
                AccountPanelRepository.this.f256187a.o2().setValue(str);
                if (QLog.isColorLevel()) {
                    QLog.d("AccountPanelRepository", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", Boolean.valueOf(z16), str));
                    return;
                }
                return;
            }
            QLog.d("AccountPanelRepository", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", Boolean.valueOf(z16), str));
        }

        @Override // com.tencent.mobileqq.relation.api.IFriendsUtils.a
        public void b(boolean z16, long j3, String str) {
            if (!OnlineStatusToggleUtils.b() || OnlineStatusToggleUtils.F()) {
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && peekAppRuntime != null) {
                if (!TextUtils.equals(str, peekAppRuntime.getCurrentUin())) {
                    return;
                }
                com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("AccountPanelRepository");
                if (H == null) {
                    QLog.d("AccountPanelRepository", 1, "Get info from cache failed!");
                    return;
                }
                if (AppRuntime.Status.online.equals(ae.c(H)) && H.e0() == 1028) {
                    AccountPanelRepository.this.f256187a.A2().setValue(Boolean.TRUE);
                    return;
                }
                return;
            }
            QLog.e("AccountPanelRepository", 1, "Get online info failed or runtime is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class j implements hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(AppRuntime.Status status, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
            AccountPanelRepository.this.f256187a.O2(status, cVar.e0());
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> eVar) {
            final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar;
            String str;
            if (!OnlineStatusToggleUtils.F() || eVar == null || eVar.b() == null || eVar.b().isEmpty() || (cVar = eVar.b().get(0)) == null) {
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(cVar.f0()) && TextUtils.equals(cVar.f0(), str)) {
                if (AccountPanelRepository.this.f256190d == null || !AccountPanelRepository.this.f256190d.equals(cVar.toString())) {
                    AccountPanelRepository.this.f256190d = cVar.toString();
                    final AppRuntime.Status c16 = ae.c(cVar);
                    QLog.d("AccountPanelRepository", 1, "onNTQueryResult update status=" + c16 + ", extOnlineStatus=" + cVar.e0());
                    if (OnlineStatusToggleUtils.b() && AppRuntime.Status.online.equals(c16) && cVar.e0() == 1028) {
                        AccountPanelRepository.this.f256187a.A2().postValue(Boolean.TRUE);
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.repository.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            AccountPanelRepository.j.this.b(c16, cVar);
                        }
                    });
                }
            }
        }
    }

    public AccountPanelRepository(AppInterface appInterface) {
    }

    private void A(@NonNull List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list, @NonNull List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list2, @NonNull List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list3, @NonNull List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list4, @NonNull List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list5, long j3) {
        boolean z16;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            return;
        }
        String currentUin = appInterface.getCurrentUin();
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> allFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("AccountPanelRepository");
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        long M = af.C().M(appInterface);
        long serverTime = NetConnInfoCenter.getServerTime();
        ArrayList<String> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : allFriend) {
            if (dVar != null && !currentUin.equals(dVar.x())) {
                arrayList.add(dVar.getUid());
            }
        }
        Map<String, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> E = E(arrayList);
        Map<String, com.tencent.qqnt.ntrelation.intimateinfo.bean.a> B = B(arrayList);
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 : allFriend) {
            if (dVar2 != null && !currentUin.equals(dVar2.x())) {
                list4.add(dVar2);
                com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar = E.get(dVar2.getUid());
                com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = B.get(dVar2.getUid());
                if (cVar != null) {
                    if (aVar != null && aVar.j() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        z16 = Boolean.TRUE.equals(dVar2.F());
                    }
                    if (z16) {
                        list5.add(dVar2);
                    }
                    if (Math.abs(serverTime - cVar.F()) <= 86400) {
                        if (j3 <= cVar.F()) {
                            list.add(dVar2);
                            if (onlineStatus != null && onlineStatus.equals(ae.c(cVar)) && M == cVar.e0()) {
                                list2.add(dVar2);
                            }
                            if (z16) {
                                list3.add(dVar2);
                            }
                        }
                    }
                }
            }
        }
    }

    private Map<String, com.tencent.qqnt.ntrelation.intimateinfo.bean.a> B(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(arrayList, "AccountPanelRepository");
            if (intimateSimpleInfoWithUid != null && !intimateSimpleInfoWithUid.isEmpty()) {
                HashMap hashMap = new HashMap();
                Iterator<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> it = intimateSimpleInfoWithUid.iterator();
                while (it.hasNext()) {
                    com.tencent.qqnt.ntrelation.intimateinfo.bean.a next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.getUid())) {
                        hashMap.put(next.getUid(), next);
                    }
                }
                return hashMap;
            }
            return new HashMap(0);
        }
        return new HashMap(0);
    }

    private Map<String, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> E(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(arrayList, "AccountPanelRepository");
            if (onlineStatusSimpleInfoWithUid != null && !onlineStatusSimpleInfoWithUid.isEmpty()) {
                HashMap hashMap = new HashMap();
                Iterator<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> it = onlineStatusSimpleInfoWithUid.iterator();
                while (it.hasNext()) {
                    com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.getUid())) {
                        hashMap.put(next.getUid(), next);
                    }
                }
                return hashMap;
            }
            return new HashMap(0);
        }
        return new HashMap(0);
    }

    private List<au> F() {
        return af.C().n(new ArrayList<>(af.C().q()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int H(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar2) {
        return Long.compare(cVar2.F(), cVar.F());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(com.tencent.mobileqq.onlinestatus.manager.g gVar) {
        this.f256189c = true;
        gVar.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        if (y() || z()) {
            return;
        }
        final com.tencent.mobileqq.onlinestatus.manager.g gVar = this.f256188b;
        if (gVar == null) {
            this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(0, new String[0], 0));
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.repository.d
                @Override // java.lang.Runnable
                public final void run() {
                    AccountPanelRepository.this.I(gVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        int w26 = this.f256187a.w2();
        if (w26 > 0) {
            this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(3, new String[0], w26));
            return;
        }
        long j3 = QMMKV.withAccount(MobileQQ.sMobileQQ, "common_mmkv_configurations").getLong(QMMKVFile.getKeyWithUin(IOnLineStatueHelperApi.ONLINE_STATUS_AGGREGATION_SCENE, IOnLineStatueHelperApi.ONLINE_STATUS_AGGREGATION_LAST_CLICK_TIME), -1L, true);
        QLog.d("AccountPanelRepository", 1, "last click time: " + j3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        A(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, j3);
        if (!arrayList2.isEmpty()) {
            QLog.d("AccountPanelRepository", 1, "hit friends with same status size: " + arrayList2.size());
            M(arrayList2, 4);
            return;
        }
        if (!arrayList3.isEmpty()) {
            QLog.d("AccountPanelRepository", 1, "hit special friends size: " + arrayList3.size());
            M(arrayList3, 5);
            return;
        }
        if (!arrayList.isEmpty()) {
            QLog.d("AccountPanelRepository", 1, "hit friends update size: " + arrayList.size());
            M(arrayList, 6);
            return;
        }
        if (j3 < 0) {
            if (!arrayList5.isEmpty()) {
                QLog.d("AccountPanelRepository", 1, "hit random special friends size: " + arrayList5.size());
                M(arrayList5, 7);
                return;
            }
            if (!arrayList4.isEmpty()) {
                QLog.d("AccountPanelRepository", 1, "hit random all friends size: " + arrayList4.size());
                M(arrayList4, 7);
                return;
            }
        }
        this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(8, new String[0], 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int L(TreeSet treeSet, TreeSet treeSet2) {
        if (treeSet.size() == treeSet2.size()) {
            return 0;
        }
        if (treeSet.size() > treeSet2.size()) {
            return -1;
        }
        return 1;
    }

    private void M(@NonNull List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list, int i3) {
        int random = (int) (Math.random() * list.size());
        if (random < 0) {
            random = 0;
        } else if (random >= list.size()) {
            random = list.size() - 1;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = list.get(random);
        if (dVar == null) {
            return;
        }
        QLog.d("AccountPanelRepository", 1, "random friend idx: " + random + " uin: " + dVar.x() + " type: " + i3);
        this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(i3, new String[]{dVar.x()}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        List<au> F = F();
        com.tencent.mobileqq.onlinestatus.manager.g gVar = this.f256188b;
        if (F != null && !F.isEmpty() && gVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            Iterator<au> it = F.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                TreeSet<com.tencent.mobileqq.onlinestatus.model.d> f16 = gVar.f(it.next());
                if (f16 != null && !f16.isEmpty()) {
                    arrayList.add(f16);
                    i3 += f16.size();
                }
            }
            if (i3 == 0) {
                this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(0, new String[0], 0));
                return;
            }
            Collections.sort(arrayList, new Comparator() { // from class: com.tencent.mobileqq.onlinestatus.repository.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int L;
                    L = AccountPanelRepository.L((TreeSet) obj, (TreeSet) obj2);
                    return L;
                }
            });
            ArrayList arrayList2 = new ArrayList();
            Iterator it5 = arrayList.iterator();
            int i16 = 0;
            boolean z16 = false;
            while (it5.hasNext()) {
                Iterator it6 = ((TreeSet) it5.next()).iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    arrayList2.add(((com.tencent.mobileqq.onlinestatus.model.d) it6.next()).getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
                    i16++;
                    if (i16 >= 3) {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    break;
                }
            }
            String[] strArr = new String[arrayList2.size()];
            arrayList2.toArray(strArr);
            this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(0, strArr, i3));
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelRepository", 2, "processFriendData spend time: " + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            return;
        }
        this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(0, new String[0], 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(String str, boolean z16) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && !z16 && !TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(boolean z16, String str, boolean z17) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && !z17 && !TextUtils.isEmpty(str)) {
            if (TextUtils.equals(str, peekAppRuntime.getCurrentAccountUin())) {
                return false;
            }
            QLog.d("AccountPanelRepository", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", str));
            return true;
        }
        QLog.d("AccountPanelRepository", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", Boolean.valueOf(z16), str));
        return true;
    }

    private boolean y() {
        AppInterface appInterface;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar;
        long decodeLong = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(IOnLineStatueHelperApi.FRIENDS_UPDATE_ONLINE_STATUS_MIN_TIME_KEY, -1L);
        if (decodeLong < 0 || (appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        String currentUin = appInterface.getCurrentUin();
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        long M = af.C().M(appInterface);
        if (onlineStatus == null) {
            return false;
        }
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> allFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("AccountPanelRepository");
        ArrayList<String> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : allFriend) {
            if (dVar != null && !currentUin.equals(dVar.x())) {
                arrayList.add(dVar.getUid());
            }
        }
        Map<String, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> E = E(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 : allFriend) {
            if (!TextUtils.isEmpty(dVar2.x()) && !dVar2.x().equals(currentUin) && (cVar = E.get(dVar2.getUid())) != null && onlineStatus.equals(ae.c(cVar)) && M == cVar.e0() && cVar.F() >= decodeLong) {
                arrayList2.add(cVar);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelRepository", 2, "filter online status info size = " + arrayList2.size());
        }
        int size = arrayList2.size();
        if (size <= 0) {
            return false;
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.tencent.mobileqq.onlinestatus.repository.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int H;
                H = AccountPanelRepository.H((com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) obj, (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) obj2);
                return H;
            }
        });
        int min = Math.min(size, 3);
        String[] strArr = new String[min];
        for (int i3 = 0; i3 < min; i3++) {
            strArr[i3] = ((com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) arrayList2.get(i3)).f0();
        }
        this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(2, strArr, size));
        return true;
    }

    private boolean z() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        int decodeInt = from.decodeInt(IOnLineStatueHelperApi.FRIENDS_UPDATE_ONLINE_STATUS_NUMS_KEY, 0);
        if (decodeInt == 0) {
            return false;
        }
        Set<String> decodeStringSet = from.decodeStringSet(IOnLineStatueHelperApi.FIRST_FRIENDS_UIN_KEY, new HashSet());
        String[] strArr = new String[decodeStringSet.size()];
        decodeStringSet.toArray(strArr);
        this.f256187a.s2().postValue(new com.tencent.mobileqq.onlinestatus.model.e(1, strArr, decodeInt));
        return true;
    }

    public void C() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.repository.b
            @Override // java.lang.Runnable
            public final void run() {
                AccountPanelRepository.this.J();
            }
        }, 16, null, true);
    }

    public void D() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.repository.c
            @Override // java.lang.Runnable
            public final void run() {
                AccountPanelRepository.this.K();
            }
        }, 16, null, true);
    }

    public void G() {
        if (this.f256188b == null) {
            com.tencent.mobileqq.onlinestatus.manager.g gVar = (com.tencent.mobileqq.onlinestatus.manager.g) ((IOnlineStatusManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.g.class);
            this.f256188b = gVar;
            if (gVar != null) {
                gVar.s(this);
            }
        }
    }

    public void O(boolean z16) {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            appInterface.removeObserver(this.f256198l);
            appInterface.removeObserver(this.f256197k);
            appInterface.removeObserver(this.f256200n);
            appInterface.removeObserver(this.f256201o);
            appInterface.unRegistObserver(this.f256195i);
            appInterface.unRegistObserver(this.f256192f);
            appInterface.unRegistObserver(this.f256193g);
            if (z16) {
                appInterface.unRegistObserver(this.f256194h);
                appInterface.removeObserver(this.f256191e);
            }
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this.f256196j);
            String currentUid = appInterface.getCurrentUid();
            if (!TextUtils.isEmpty(currentUid)) {
                ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).removeOnlineStatusSimpleInfoCallback(currentUid, "AccountPanelRepository", this.f256199m);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelRepository", 2, "removeObservers");
            }
        }
    }

    public void P(AccountPanelViewModel accountPanelViewModel) {
        this.f256187a = accountPanelViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.a
    public void onDestroy() {
        super.onDestroy();
        x();
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.g.a
    public void onUpdate() {
        if (!this.f256189c) {
            return;
        }
        this.f256189c = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.repository.e
                @Override // java.lang.Runnable
                public final void run() {
                    AccountPanelRepository.this.N();
                }
            }, 16, null, true);
        } else {
            N();
        }
    }

    public void u() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            appInterface.addObserver(this.f256198l);
            appInterface.addObserver(this.f256197k);
            appInterface.addObserver(this.f256200n);
            appInterface.addObserver(this.f256201o);
            appInterface.registObserver(this.f256195i);
            appInterface.registObserver(this.f256192f);
            appInterface.registObserver(this.f256193g);
            appInterface.registObserver(this.f256194h);
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).addObserver(this.f256196j);
            appInterface.addObserver(this.f256191e);
            String currentUid = appInterface.getCurrentUid();
            if (!TextUtils.isEmpty(currentUid)) {
                ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).addOnlineStatusSimpleInfoCallback(currentUid, "AccountPanelRepository", this.f256199m);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelRepository", 2, "addObservers");
            }
        }
    }

    public void x() {
        com.tencent.mobileqq.onlinestatus.manager.g gVar = this.f256188b;
        if (gVar != null) {
            gVar.d(this);
            this.f256188b = null;
        }
    }
}
