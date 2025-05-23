package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.UiThread;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTipsHelper;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.IVasNTFrequency;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb$CustomOnlineStatusMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4$RecommendReason;

/* compiled from: P */
@Deprecated
/* loaded from: classes11.dex */
public class FriendsManager implements Manager {
    static IPatchRedirector $redirector_;
    private MQLruCache<String, DateNickNameInfo> C;
    private ConcurrentHashMap<String, SpecialCareInfo> D;
    private final AddFrdStateMng E;
    private boolean F;
    private boolean G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f194682a0;

    /* renamed from: b0, reason: collision with root package name */
    private IFriendDataService f194683b0;

    /* renamed from: c0, reason: collision with root package name */
    private IFriendExtensionService f194684c0;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f194685d;

    /* renamed from: d0, reason: collision with root package name */
    private AccountObserver f194686d0;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f194687e;

    /* renamed from: e0, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f194688e0;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f194689f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f194690f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f194691g0;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f194692h;

    /* renamed from: h0, reason: collision with root package name */
    private ArrayList<String> f194693h0;

    /* renamed from: i, reason: collision with root package name */
    private AtomicBoolean f194694i;

    /* renamed from: i0, reason: collision with root package name */
    private ArrayList<String> f194695i0;

    /* renamed from: j0, reason: collision with root package name */
    ConcurrentHashMap<String, String> f194696j0;

    /* renamed from: m, reason: collision with root package name */
    private QQConcurrentHashMap<String, Entity> f194697m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.FriendsManager$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 extends AccountObserver {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendsManager.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16, long j3, boolean z17) {
            FriendsManager.this.f194685d.mAutomator.K2(z16, j3, z17);
        }

        @Override // mqq.observer.AccountObserver
        public void onExchangeUin(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            } else {
                ThreadManagerV2.executeOnSubThread(new Runnable(str2, str) { // from class: com.tencent.mobileqq.app.FriendsManager.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f194699d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f194700e;

                    {
                        this.f194699d = str2;
                        this.f194700e = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, str2, str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            FriendsManager.this.B0(this.f194699d, this.f194700e);
                        }
                    }
                });
            }
        }

        @Override // mqq.observer.AccountObserver
        public void onOnlineStatusChanged(boolean z16, AppRuntime.Status status, long j3, boolean z17, final boolean z18, final long j16, final boolean z19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), status, Long.valueOf(j3), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j16), Boolean.valueOf(z19));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManagerfriend", 2, "onOnlineStatusChanged isSuccess = " + z16 + " ,curStatus =  , isUserSet = " + status + " ,isFriendListChang = " + z18 + " ,timeStamp = " + j16 + " ,isGatherListChange = " + z19);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.at
                @Override // java.lang.Runnable
                public final void run() {
                    FriendsManager.AnonymousClass1.this.b(z18, j16, z19);
                }
            }, 64, null, false);
            if (!z18) {
                FriendsManager.this.f194685d.mAutomator.L2(101, new QQProfileItem(FriendsManager.this.f194685d));
            }
            com.tencent.mobileqq.onlinestatus.manager.f fVar = (com.tencent.mobileqq.onlinestatus.manager.f) ((IOnlineStatusManagerService) FriendsManager.this.f194685d.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
            if (fVar != null) {
                fVar.o(z16, status);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mqq.observer.AccountObserver
        public void onOnlineStatusPush(AppRuntime.Status status, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, status, Long.valueOf(j3));
                return;
            }
            super.onOnlineStatusPush(status, j3);
            com.tencent.mobileqq.onlinestatus.manager.f fVar = (com.tencent.mobileqq.onlinestatus.manager.f) ((IOnlineStatusManagerService) FriendsManager.this.f194685d.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
            if (fVar != null) {
                fVar.k(j3);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.FriendsManager$3, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ FriendsManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("fetch_local_data_start_time", String.valueOf(com.tencent.mobileqq.friend.utils.b.d().c(true)));
            hashMap.put("fetch_local_data_end_time", String.valueOf(com.tencent.mobileqq.friend.utils.b.d().c(false)));
            com.tencent.mobileqq.app.friendlist.b.b(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f194704a;

        a(ArrayList arrayList) {
            this.f194704a = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendsManager.this, (Object) arrayList);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FriendsManager.this.J0(this.f194704a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements hx3.c<Boolean> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hx3.c f194706a;

        b(hx3.c cVar) {
            this.f194706a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendsManager.this, (Object) cVar);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            this.f194706a.onUpdateResult(eVar);
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManager", 2, "moveFriendToNewGroup responseData.getCode :" + eVar.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f194708a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f194709b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f194710c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f194711d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ hx3.c f194712e;

        c(boolean z16, boolean z17, String str, boolean z18, hx3.c cVar) {
            this.f194708a = z16;
            this.f194709b = z17;
            this.f194710c = str;
            this.f194711d = z18;
            this.f194712e = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FriendsManager.this, Boolean.valueOf(z16), Boolean.valueOf(z17), str, Boolean.valueOf(z18), cVar);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            if (this.f194708a && this.f194709b) {
                GatherContactsTipsHelper.d(FriendsManager.this.f194685d, this.f194710c);
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar2 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
            eVar2.d(eVar.a());
            ArrayList arrayList = new ArrayList();
            arrayList.add(Boolean.valueOf(this.f194711d));
            eVar2.e(arrayList);
            hx3.c cVar = this.f194712e;
            if (cVar != null) {
                cVar.onUpdateResult(eVar2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements hx3.c<Boolean> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendsManager.this);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else if (QLog.isColorLevel()) {
                QLog.d("FriendsManager", 2, "moveFriendToNewGroup responseData.getCode :" + eVar.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f194715a;

        e(String str) {
            this.f194715a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendsManager.this, (Object) str);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                ((FriendListHandler) FriendsManager.this.f194685d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, this.f194715a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class f implements uc1.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendsManager.this);
            }
        }

        @Override // uc1.a
        public void onResult(List<Groups> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                ((FriendListHandler) FriendsManager.this.f194685d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(99, true, null);
            }
        }
    }

    @Deprecated
    public FriendsManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f194689f = false;
        this.f194692h = false;
        this.f194694i = new AtomicBoolean(false);
        this.f194697m = new QQConcurrentHashMap<>(Business.Conversation, "FiendExtensionInfo");
        this.C = new MQLruCache<>(500);
        this.D = new ConcurrentHashMap<>();
        this.E = new AddFrdStateMng();
        this.F = false;
        this.G = false;
        this.H = 3;
        this.I = 30;
        this.J = 7;
        this.K = 30;
        this.L = 3;
        this.M = 30;
        this.N = 3;
        this.P = 30;
        this.Q = 3;
        this.R = 30;
        this.S = 5;
        this.T = 7;
        this.U = 30;
        this.V = 7;
        this.W = 30;
        this.X = 6;
        this.Y = -1;
        this.Z = true;
        this.f194682a0 = true;
        this.f194686d0 = new AnonymousClass1();
        this.f194688e0 = null;
        this.f194690f0 = false;
        this.f194691g0 = 0;
        this.f194696j0 = new ConcurrentHashMap<>(6);
    }

    private void E0(Friends friends) {
        String str;
        if (friends != null && (str = friends.uin) != null && !TextUtils.isEmpty(str)) {
            GatherContactsTipsHelper.a(this.f194685d, friends.uin);
            ArrayList arrayList = new ArrayList();
            arrayList.add(friends.uin);
            p(arrayList);
        }
    }

    private ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> I0(List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> list) {
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : list) {
            if (dVar.n() == null || dVar.n().byteValue() == 1) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(dVar.getUid(), dVar.x());
                dVar2.M();
                dVar2.h0((byte) 0);
                arrayList.add(dVar2);
                if (this.f194693h0 == null) {
                    this.f194693h0 = new ArrayList<>();
                }
                this.f194693h0.add(dVar.x());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(@NonNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> arrayList) {
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2 = new ArrayList<>();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.c next = it.next();
            if (next != null) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(next.getUid(), next.x());
                dVar.M();
                dVar.h0((byte) 1);
                arrayList2.add(dVar);
                if (this.f194695i0 == null) {
                    this.f194695i0 = new ArrayList<>();
                }
                this.f194695i0.add(next.x());
            }
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(arrayList2, "FriendsManager_updateNTFriendDetailGatherType", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
    }

    private void M0(List<BaseTransaction> list, Entity entity) {
        if (entity.getStatus() == 1000) {
            list.add(new PersistOrReplaceTransaction(entity));
        } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            list.add(new UpdateTransaction(entity));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0074 A[Catch: all -> 0x013f, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x0013, B:8:0x002e, B:10:0x0034, B:12:0x003f, B:23:0x004b, B:25:0x004f, B:27:0x0058, B:29:0x0074, B:30:0x0086, B:32:0x008c, B:35:0x0098, B:38:0x00a1, B:41:0x00a6, B:46:0x00ae, B:52:0x00b6, B:49:0x00bf, B:57:0x0055, B:66:0x00cd, B:68:0x00d3, B:69:0x0101, B:71:0x0107, B:73:0x012a), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized ConcurrentHashMap<String, ArrayList<Entity>> h(boolean z16) {
        ConcurrentHashMap<String, ArrayList<Entity>> concurrentHashMap;
        String str;
        String str2;
        ArrayList<Entity> arrayList;
        int b16;
        Integer num;
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManager", 2, "buildNormalAndGatheredUiMaps begin :");
        }
        concurrentHashMap = new ConcurrentHashMap<>(6);
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(4);
        List<Friends> allFriends = this.f194683b0.getAllFriends();
        int size = allFriends.size();
        int i3 = 0;
        for (Friends friends : allFriends) {
            byte b17 = friends.gathtertype;
            if (b17 == 1) {
                i3++;
            }
            if (z16) {
                if (b17 != 1) {
                    str = friends.mCompareSpell;
                    if (str != null || str.length() == 0) {
                        j.g(friends);
                    }
                    str2 = friends.groupid + "";
                    arrayList = concurrentHashMap.get(str2);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        concurrentHashMap.put(str2, arrayList);
                        Iterator<Groups> it = this.f194683b0.getGroupList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Groups next = it.next();
                            if (next.group_id == friends.groupid) {
                                arrayList.ensureCapacity(Math.min(size, next.group_friend_count));
                                break;
                            }
                        }
                    }
                    arrayList.add(friends);
                    if (z16 && (b16 = com.tencent.mobileqq.friend.status.b.b(friends)) != 0 && b16 != 6) {
                        num = (Integer) concurrentHashMap2.get(str2);
                        if (num != null) {
                            concurrentHashMap2.put(str2, 1);
                        } else {
                            concurrentHashMap2.put(str2, Integer.valueOf(num.intValue() + 1));
                        }
                    }
                }
            } else if (b17 != 0 && b17 != 2) {
                str = friends.mCompareSpell;
                if (str != null) {
                }
                j.g(friends);
                str2 = friends.groupid + "";
                arrayList = concurrentHashMap.get(str2);
                if (arrayList == null) {
                }
                arrayList.add(friends);
                if (z16) {
                    num = (Integer) concurrentHashMap2.get(str2);
                    if (num != null) {
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(300);
            sb5.append("buildNormalAndGatheredUiMaps end " + concurrentHashMap.size() + MsgSummary.STR_COLON);
            for (String str3 : concurrentHashMap.keySet()) {
                sb5.append(str3);
                sb5.append(", ");
                sb5.append(concurrentHashMap.get(str3).size());
                sb5.append("; ");
            }
            sb5.append(" gatherCount=");
            sb5.append(i3);
            QLog.d("FriendsManagerfriend", 2, sb5.toString());
        }
        return concurrentHashMap;
    }

    private boolean j0(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("FriendsManager", 2, "isValidUin empty uin");
                return false;
            }
            return false;
        }
        if (str.length() < 4) {
            if (QLog.isColorLevel()) {
                QLog.e("FriendsManager", 2, "isValidUin uin=" + str);
                return false;
            }
            return false;
        }
        return true;
    }

    private void l0() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.app.FriendsManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendsManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    FriendsManager friendsManager = FriendsManager.this;
                    friendsManager.f194682a0 = friendsManager.h0();
                }
            }
        });
    }

    private void n() {
        ArrayList arrayList = (ArrayList) this.f194687e.query(NoC2CExtensionInfo.class);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                NoC2CExtensionInfo noC2CExtensionInfo = (NoC2CExtensionInfo) ((Entity) it.next());
                if (noC2CExtensionInfo != null && noC2CExtensionInfo.uin != null) {
                    synchronized (this.f194697m) {
                        this.f194697m.put(NoC2CExtensionInfo.getNoC2Ckey(noC2CExtensionInfo.type, noC2CExtensionInfo.uin), noC2CExtensionInfo);
                    }
                }
            }
        }
    }

    private void n0(long j3, boolean z16, String str, String str2) {
        String str3;
        HashMap<String, String> hashMap = new HashMap<>(10);
        String str4 = "1";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put(StatisticCollector.SqliteOptCostInfo.MAINTHREAD_TAG, str3);
        hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTYPE_TAG, str);
        hashMap.put(StatisticCollector.SqliteOptCostInfo.BUS_TAG, str2);
        if (!z16) {
            str4 = "0";
        }
        hashMap.put(StatisticCollector.SqliteOptCostInfo.TAG_IN_TRANS, str4);
        hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTOTALCOST_TAG, String.valueOf(j3));
        hashMap.put(StatisticCollector.SqliteOptCostInfo.WALSWITCH_TAG, String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.FRIEND_SQLITE_OPERATE, true, j3, 0L, hashMap, (String) null, false);
    }

    private void o() {
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(this.f194685d);
        boolean x16 = l3.x();
        QLog.i("FriendsManager", 1, "doResetRingIdOfExtensionInfo: invoked.  hasResetGrayUserRingId: " + x16);
        if (!x16) {
            l3.Q(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("FriendsManager_doResetRingIdOfExtensionInfo"));
            l3.F();
        }
    }

    public void A(vc1.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, (Object) aVar);
        } else {
            ThreadManagerV2.excute(new Runnable(aVar) { // from class: com.tencent.mobileqq.app.FriendsManager.12
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ vc1.a f194703d;

                {
                    this.f194703d = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendsManager.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f194703d.a(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("FriendsManager_getAllFriendsCount").size());
                    }
                }
            }, 16, null, true);
        }
    }

    public void A0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, z16);
            return;
        }
        VipNtMMKV.getShowColorName().encodeBool(this.f194685d.getCurrentUin(), z16);
        ((IVasNTFrequency) QRoute.api(IVasNTFrequency.class)).refreshRecentColorNameFrequency();
        this.f194682a0 = z16;
    }

    public ArrayList<Entity> B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return (ArrayList) iPatchRedirector.redirect((short) 91, (Object) this);
        }
        new ConcurrentHashMap(4);
        ConcurrentHashMap<String, ArrayList<Entity>> h16 = h(true);
        ArrayList<Entity> arrayList = new ArrayList<>(16);
        List<Groups> groupList = this.f194683b0.getGroupList();
        if (groupList != null) {
            Iterator<Groups> it = groupList.iterator();
            while (it.hasNext()) {
                ArrayList<Entity> arrayList2 = h16.get(String.valueOf(it.next().group_id));
                if (arrayList2 != null) {
                    arrayList.addAll(arrayList2);
                }
            }
        }
        return arrayList;
    }

    protected void B0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str2 != null && str != null) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, str);
            dVar.M();
            dVar.Z(str2);
            dVar.g0(System.currentTimeMillis());
            if (str.equals(this.f194685d.getAccount())) {
                QLog.i("FriendsManager", 1, "setProperty uinDisplayName uin:" + StringUtil.getSimpleUinForPrint(str) + " disName:" + str2);
                MobileQQ application = this.f194685d.getApplication();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Constants.PropertiesKey.uinDisplayName.toString());
                sb5.append(str);
                application.setProperty(sb5.toString(), str2);
            }
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "FriendsManager_setUinNameForDisplay", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        }
    }

    public int C() {
        ExtensionInfo H;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return ((Integer) iPatchRedirector.redirect((short) 97, (Object) this)).intValue();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f194683b0.getAllFriends());
        StringBuilder sb5 = new StringBuilder();
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Friends friends = (Friends) ((Entity) it.next());
            if (friends.isFriend() && (H = H(friends.uin)) != null && com.tencent.mobileqq.activity.aio.intimate.e.e(H.intimate_type)) {
                i3++;
                if (QLog.isColorLevel()) {
                    sb5.append("\nuin:");
                    sb5.append(H.uin);
                    sb5.append(" type:");
                    sb5.append(H.intimate_type);
                    sb5.append(" level:");
                    sb5.append(H.intimate_level);
                }
            }
        }
        if (QLog.isColorLevel()) {
            sb5.append("\ncount:");
            sb5.append(i3);
            QLog.d("FriendsManager", 2, "getBindIntimateRelationshipFriendCount " + sb5.toString());
        }
        return i3;
    }

    public List<Groups> C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (List) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.f194683b0.getGroupList();
    }

    public DateNickNameInfo D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return (DateNickNameInfo) iPatchRedirector.redirect((short) 76, (Object) this, (Object) str);
        }
        if (!Friends.isValidUin(str)) {
            return null;
        }
        if (!this.f194690f0) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.app.FriendsManager.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendsManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        FriendsManager.this.U();
                    }
                }
            }, null, false);
        }
        return this.C.get(str);
    }

    public void D0(List<SpecialCareInfo> list, long j3, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagerfriend", 2, "syncSpecialCareInfos: " + i3 + ", " + j3 + ", " + z16);
        }
        ConcurrentHashMap<String, SpecialCareInfo> concurrentHashMap = this.D;
        if (concurrentHashMap != null) {
            synchronized (concurrentHashMap) {
                for (int i16 = 0; i16 < i3; i16++) {
                    try {
                        this.D.put(list.get(i16).uin, list.get(i16));
                    } finally {
                    }
                }
                if (z16) {
                    Iterator<Map.Entry<String, SpecialCareInfo>> it = this.D.entrySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().getValue().dateTime < j3) {
                            it.remove();
                        }
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i17 = 0; i17 < i3; i17++) {
            M0(arrayList, list.get(i17));
        }
        if (z16) {
            arrayList.add(new DeleteTransaction(new SpecialCareInfo().getTableName(), "dateTime<" + j3, null));
        }
        this.f194687e.doMultiDBOperateByTransaction(arrayList);
    }

    public boolean E(boolean z16) {
        TempGetProfileDetailProcessor tempGetProfileDetailProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, z16)).booleanValue();
        }
        boolean z17 = this.Z;
        int i3 = this.Y;
        if (i3 == -1) {
            if (z16 && (tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.f194685d, TempGetProfileDetailProcessor.class)) != null) {
                tempGetProfileDetailProcessor.getCalReactiveSwitch();
                return z17;
            }
            return z17;
        }
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    @Deprecated
    public String F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(uidFromUin);
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    public void F0(boolean z16, boolean z17, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29), Integer.valueOf(i36), Integer.valueOf(i37));
            return;
        }
        this.F = z16;
        this.G = z17;
        this.H = i3;
        this.I = i16;
        this.L = i17;
        this.M = i18;
        this.N = i19;
        this.P = i26;
        this.Q = i27;
        this.R = i28;
        this.S = i37;
        this.T = i29;
        this.U = i36;
    }

    public EntityTransaction G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return (EntityTransaction) iPatchRedirector.redirect((short) 80, (Object) this);
        }
        return this.f194687e.getTransaction();
    }

    public synchronized void G0(NearbyPeopleCard nearbyPeopleCard) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, (Object) nearbyPeopleCard);
            return;
        }
        if (nearbyPeopleCard != null && !TextUtils.isEmpty(nearbyPeopleCard.uin) && !TextUtils.isEmpty(nearbyPeopleCard.nickname)) {
            long j3 = nearbyPeopleCard.lastUpdateNickTime;
            if (j3 > 0) {
                DateNickNameInfo dateNickNameInfo = new DateNickNameInfo(nearbyPeopleCard.nickname, j3);
                long j16 = nearbyPeopleCard.tinyId;
                if (j16 > 0) {
                    str = String.valueOf(j16);
                } else {
                    str = nearbyPeopleCard.uin;
                }
                this.C.put((MQLruCache<String, DateNickNameInfo>) str, (String) dateNickNameInfo);
            }
        }
    }

    public ExtensionInfo H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (ExtensionInfo) iPatchRedirector.redirect((short) 62, (Object) this, (Object) str);
        }
        return I(str, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean H0(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) entity)).booleanValue();
        }
        if (this.f194687e.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.f194687e.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.f194687e.update(entity);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagerfriend", 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    public ExtensionInfo I(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (ExtensionInfo) iPatchRedirector.redirect((short) 63, this, str, Boolean.valueOf(z16));
        }
        ExtensionInfo extensionInfo = this.f194684c0.getExtensionInfo(str, z16);
        if (extensionInfo != null && com.tencent.mobileqq.vip.api.b.a().getVipDataForFriends(str).isSplendid()) {
            extensionInfo.pendantId = 0L;
        }
        return extensionInfo;
    }

    @Deprecated
    public int J(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str)).intValue();
        }
        Friends v3 = v(str);
        if (v3 != null) {
            return v3.detalStatusFlag;
        }
        return 10;
    }

    public int K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return ((Integer) iPatchRedirector.redirect((short) 89, (Object) this)).intValue();
        }
        List<Friends> allFriends = this.f194683b0.getAllFriends(true);
        if (allFriends != null) {
            return allFriends.size();
        }
        return 0;
    }

    public void K0(String str, GetOnlineInfoResp getOnlineInfoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) str, (Object) getOnlineInfoResp);
            return;
        }
        if (getOnlineInfoResp != null) {
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "FriendsManager_updateOnlineStatus");
            Friends friend = this.f194683b0.getFriend(str);
            if (friend == null) {
                return;
            }
            long j3 = getOnlineInfoResp.dwStatus;
            friend.detalStatusFlag = (byte) j3;
            friend.iTermType = (int) getOnlineInfoResp.iTermType;
            friend.abilityBits = getOnlineInfoResp.uAbiFlag;
            friend.eNetwork = getOnlineInfoResp.eNetworkType;
            friend.netTypeIconId = getOnlineInfoResp.eIconType;
            friend.strTermDesc = getOnlineInfoResp.strTermDesc;
            friend.uExtOnlineStatus = getOnlineInfoResp.uExtOnlineStatus;
            friend.iBatteryStatus = getOnlineInfoResp.iBatteryStatus;
            onlineStatusSimpleInfoWithUid.G0((byte) j3);
            onlineStatusSimpleInfoWithUid.L0((int) getOnlineInfoResp.iTermType);
            onlineStatusSimpleInfoWithUid.O0(getOnlineInfoResp.eIconType);
            onlineStatusSimpleInfoWithUid.r0(getOnlineInfoResp.uAbiFlag);
            onlineStatusSimpleInfoWithUid.P0(getOnlineInfoResp.eNetworkType);
            onlineStatusSimpleInfoWithUid.Y0(getOnlineInfoResp.strTermDesc);
            onlineStatusSimpleInfoWithUid.a1(getOnlineInfoResp.uExtOnlineStatus);
            onlineStatusSimpleInfoWithUid.K0(getOnlineInfoResp.iBatteryStatus);
            ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).parseFriendMusicInfo(friend, getOnlineInfoResp.vecMusicInfo, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
            ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).parseExtOnlineBusinessInfo(friend, getOnlineInfoResp.vecExtOnlineBusinessInfo, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
            ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).parseVecExtInfo(friend, getOnlineInfoResp.vecExtInfo, 0L, null);
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManager", 2, "updateOnlineStatus uin:", str, " status:", Long.valueOf(getOnlineInfoResp.dwStatus), " extOnline:", Long.valueOf(getOnlineInfoResp.uExtOnlineStatus), " battery:", Integer.valueOf(getOnlineInfoResp.iBatteryStatus), " iTermType: ", Long.valueOf(getOnlineInfoResp.iTermType), " friendStatus:", Integer.valueOf(com.tencent.mobileqq.friend.status.b.a(friend.detalStatusFlag, friend.iTermType)));
            }
            CustomOnlineStatusPb$CustomOnlineStatusMsg customOnlineStatusPb$CustomOnlineStatusMsg = new CustomOnlineStatusPb$CustomOnlineStatusMsg();
            try {
                CustomOnlineStatusManager.d().g(str);
                customOnlineStatusPb$CustomOnlineStatusMsg.mergeFrom(getOnlineInfoResp.strCustomOnlineStatusDesc.getBytes());
                friend.customOnlineStatusType = CustomOnlineStatusManager.Utils.h(customOnlineStatusPb$CustomOnlineStatusMsg);
                friend.customOnlineStatus = CustomOnlineStatusManager.Utils.g(customOnlineStatusPb$CustomOnlineStatusMsg);
                friend.customModel = CustomOnlineStatusManager.Utils.f(customOnlineStatusPb$CustomOnlineStatusMsg);
                if (QLog.isDevelopLevel()) {
                    QLog.d("CustomOnlineStatusManager", 4, "updateOnlineStatus : customOnlineStatusType = " + friend.customOnlineStatusType + " customOnlineStatus = " + friend.customOnlineStatus);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("CustomOnlineStatusManager", 2, e16, new Object[0]);
                }
            }
        }
    }

    @Deprecated
    public int L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return ((Integer) iPatchRedirector.redirect((short) 90, (Object) this)).intValue();
        }
        List<Friends> allFriends = this.f194683b0.getAllFriends();
        boolean M = com.tencent.mobileqq.utils.ac.M(this.f194685d);
        int i3 = 0;
        for (Friends friends : allFriends) {
            if (friends.gathtertype == 1) {
                if (M) {
                    E0(friends);
                } else {
                    i3++;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManager", 2, "getGatheredFriendsCount| gatherFriendCount: " + i3);
        }
        return i3;
    }

    public void L0(ArrayList<SimpleOnlineFriendInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("updateOnlineStatus size:");
            sb5.append(arrayList.size());
            sb5.append("\n");
            HashMap hashMap = new HashMap(arrayList.size());
            HashMap<String, Long> hashMap2 = new HashMap<>();
            Iterator<SimpleOnlineFriendInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                SimpleOnlineFriendInfo next = it.next();
                String valueOf = String.valueOf(next.friendUin);
                com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf), "FriendsManager");
                Friends friend = this.f194683b0.getFriend(valueOf);
                if (onlineStatusSimpleInfoWithUid != null) {
                    onlineStatusSimpleInfoWithUid.G0(next.detalStatusFlag);
                    onlineStatusSimpleInfoWithUid.L0(next.iTermType);
                    onlineStatusSimpleInfoWithUid.r0(next.uAbiFlag);
                    onlineStatusSimpleInfoWithUid.P0(next.eNetworkType);
                    onlineStatusSimpleInfoWithUid.O0(next.eIconType);
                    onlineStatusSimpleInfoWithUid.Y0(next.strTermDesc);
                    onlineStatusSimpleInfoWithUid.K0(next.iBatteryStatus);
                    onlineStatusSimpleInfoWithUid.a1(next.uExtOnlineStatus);
                    sb5.append("uin:");
                    sb5.append(valueOf);
                    sb5.append(" status:");
                    sb5.append((int) next.detalStatusFlag);
                    sb5.append(" battery:");
                    sb5.append(next.iBatteryStatus);
                    sb5.append(" extOnline:");
                    sb5.append(next.uExtOnlineStatus);
                    sb5.append(" iTermType:");
                    sb5.append(next.iTermType);
                    sb5.append(" friendStatus:");
                    sb5.append(com.tencent.mobileqq.friend.status.b.a(onlineStatusSimpleInfoWithUid.u(), onlineStatusSimpleInfoWithUid.z()));
                    sb5.append("\n");
                    if (friend != null) {
                        friend.detalStatusFlag = next.detalStatusFlag;
                        friend.iTermType = next.iTermType;
                        friend.abilityBits = next.uAbiFlag;
                        friend.eNetwork = next.eNetworkType;
                        friend.netTypeIconId = next.eIconType;
                        friend.strTermDesc = next.strTermDesc;
                        friend.iBatteryStatus = next.iBatteryStatus;
                        friend.uExtOnlineStatus = next.uExtOnlineStatus;
                    }
                    ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).parseFriendMusicInfo(friend, next.vecMusicInfo, "SimpleOnlie");
                    ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).parseExtOnlineBusinessInfo(friend, next.vecExtOnlineBusinessInfo, "SimpleOnlie");
                    ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).parseVecExtInfo(friend, next.vecExtInfo, friend.onlineStatusUpdateTime, hashMap2);
                    hashMap.put(valueOf, Boolean.TRUE);
                }
            }
            ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).sortAndSaveMap(hashMap2);
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManager", 2, sb5.toString());
            }
            List<Friends> allFriends = this.f194683b0.getAllFriends();
            if (allFriends != null) {
                for (Friends friends : allFriends) {
                    if (((Boolean) hashMap.get(friends.uin)) == null && friends.isFriend()) {
                        friends.detalStatusFlag = QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA;
                        friends.abilityBits = 0L;
                        friends.eNetwork = 0;
                    }
                }
            }
        }
    }

    @Deprecated
    public ArrayList<Friends> M(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (ArrayList) iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
        }
        try {
            return (ArrayList) this.f194683b0.getFriendList(Integer.parseInt(str));
        } catch (NumberFormatException e16) {
            if (str == null) {
                str = "null";
            }
            QLog.e("FriendsManager", 1, "[getMemberListByGroupIDEx] params:" + (str + ", error: " + e16), e16);
            return new ArrayList<>();
        }
    }

    public String N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (String) iPatchRedirector.redirect((short) 87, (Object) this, i3);
        }
        return this.f194696j0.get(String.valueOf(i3));
    }

    public SpecialCareInfo O(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (SpecialCareInfo) iPatchRedirector.redirect((short) 71, (Object) this, (Object) str);
        }
        SpecialCareInfo specialCareInfo = null;
        if (!TextUtils.isEmpty(str) && this.f194694i.get()) {
            ConcurrentHashMap<String, SpecialCareInfo> concurrentHashMap = this.D;
            if (concurrentHashMap != null) {
                synchronized (concurrentHashMap) {
                    specialCareInfo = this.D.get(str);
                }
            }
            if (specialCareInfo != null) {
                return (SpecialCareInfo) specialCareInfo.clone();
            }
        }
        return specialCareInfo;
    }

    public boolean P(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this, (Object) str)).booleanValue();
        }
        return ((IAddFriendServiceApi) this.f194685d.getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(str, false);
    }

    public boolean Q(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return ((IAddFriendServiceApi) this.f194685d.getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(str, z16, false);
    }

    public boolean R(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        return ((IAddFriendServiceApi) this.f194685d.getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(str, z16, z17);
    }

    protected void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManager", 2, "init begin");
        }
        X();
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManager", 2, "init end");
        }
    }

    public boolean T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean W = W();
        S();
        this.F = ea.z1(this.f194685d.getApp(), this.f194685d.getCurrentAccountUin(), 0);
        this.G = ea.z1(this.f194685d.getApp(), this.f194685d.getCurrentAccountUin(), 1);
        Y(ea.y1(this.f194685d.getApp()));
        return W;
    }

    public synchronized void U() {
        ArrayList arrayList;
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this);
            return;
        }
        if (this.f194690f0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            arrayList = (ArrayList) this.f194687e.query(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[]{"0"}, null, null, "_id desc", String.valueOf(100));
        } catch (OutOfMemoryError unused) {
            this.f194687e.drop(NearbyPeopleCard.class.getSimpleName());
            arrayList = null;
        }
        if (QLog.isColorLevel()) {
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            QLog.d("FriendsManager", 2, "nearby people card count = " + size);
        }
        if (arrayList == null) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) arrayList.get(i3);
            if (nearbyPeopleCard != null) {
                G0(nearbyPeopleCard);
            }
        }
        this.f194690f0 = true;
        if (QLog.isDevelopLevel()) {
            QLog.d("FriendsManager", 4, "initDateNickNameCache cost time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i("FriendsManagerfriend", 1, "initExtensionInfoCache begin");
        if (this.f194689f || this.f194689f) {
            return;
        }
        this.f194684c0.initCache();
        n();
        try {
            o();
        } catch (Throwable unused) {
        }
        this.f194689f = true;
    }

    public boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        this.f194683b0.initFriendCache();
        return true;
    }

    protected void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagerfriend", 2, "initGroupList begin");
        }
        this.f194683b0.initGroupCache();
    }

    public void Y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        SharedPreferences sharedPreferences = this.f194685d.getApp().getSharedPreferences(this.f194685d.getCurrentAccountUin(), 0);
        if (sharedPreferences.getInt("hotDisableInteractive", 1) == 1) {
            this.Z = true;
        } else {
            this.Z = false;
        }
        String[] split = str.split("\\|");
        if (split.length >= 9) {
            try {
                this.H = Integer.valueOf(split[0]).intValue();
                this.I = Integer.valueOf(split[1]).intValue();
                this.L = Integer.valueOf(split[2]).intValue();
                this.M = Integer.valueOf(split[3]).intValue();
                this.N = Integer.valueOf(split[4]).intValue();
                this.P = Integer.valueOf(split[5]).intValue();
                this.Q = Integer.valueOf(split[6]).intValue();
                this.R = Integer.valueOf(split[7]).intValue();
                this.S = Integer.valueOf(split[8]).intValue();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("FriendsManager", 2, str, e16);
                }
            }
        }
        if (split.length >= 11) {
            try {
                this.J = Integer.valueOf(split[9]).intValue();
                this.K = Integer.valueOf(split[10]).intValue();
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("FriendsManager", 2, str, e17);
                }
            }
        }
        if (split.length >= 13) {
            try {
                this.T = Integer.valueOf(split[11]).intValue();
                this.U = Integer.valueOf(split[12]).intValue();
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.e("FriendsManager", 2, str, e18);
                }
            }
        }
        com.tencent.mobileqq.mutualmark.oldlogic.a.i(sharedPreferences, this);
    }

    public void a0() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagerfriend", 2, "initSpecialCareInfoCache begin");
        }
        if (!this.f194694i.get()) {
            ArrayList arrayList = (ArrayList) this.f194687e.query(SpecialCareInfo.class, false, "globalSwitch!=?", new String[]{"0"}, null, null, null, null);
            if (arrayList != null) {
                synchronized (this.D) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        SpecialCareInfo specialCareInfo = (SpecialCareInfo) ((Entity) it.next());
                        if (specialCareInfo != null && (str = specialCareInfo.uin) != null) {
                            this.D.put(str, specialCareInfo);
                        }
                    }
                }
            }
            this.f194694i.set(true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagerfriend", 2, "initSpecialCareInfoCache end: " + this.D.size());
        }
    }

    public boolean b0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, i3)).booleanValue();
        }
        if ((i3 != 0 || this.F) && (i3 != 1 || this.G)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotFriend_FriendsManager", 2, "isEnableChatDays|config close, type=" + i3);
            return false;
        }
        return false;
    }

    public boolean c0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str)).booleanValue();
        }
        return this.f194683b0.isFriend(str);
    }

    public boolean d0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str)).booleanValue();
        }
        if (this.f194688e0 == null) {
            this.f194688e0 = new ConcurrentHashMap<>();
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManagerfriend", 2, "initBlackList begin");
            }
            List<? extends Entity> query = this.f194687e.query(Groups.class, false, "group_id=?", new String[]{"-1002"}, null, null, null, null);
            if (query != null) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    this.f194688e0.put(((Friends) it.next()).uin, "");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManagerfriend", 2, "initBlackList end, size=" + this.f194688e0.size());
            }
        }
        return this.f194688e0.containsKey(str);
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel() && !TextUtils.isEmpty(str) && str.length() > 3) {
            QLog.d("FriendsManager", 2, "add friend to black list " + str.substring(0, 2));
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f194688e0;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, "");
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).moveFriendToNewGroup(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), -1002, "FriendsManager_addFriendToBlackList", new d());
    }

    public boolean e0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str)).booleanValue();
        }
        return this.f194683b0.isFriend(str, false);
    }

    public boolean f(String str, int i3, boolean z16, hx3.c<Boolean> cVar) {
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        int i16 = 0;
        r4 = false;
        boolean z26 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), cVar)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagergroup", 2, "addFriendToFriendList" + str + ", " + i3 + ", " + z16);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uidFromUin, "FriendsManager_addFriendToFriendList");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, str);
        dVar.M();
        EntityTransaction entityTransaction = null;
        try {
            try {
                entityTransaction = this.f194687e.getTransaction();
                entityTransaction.begin();
                if (QLog.isColorLevel()) {
                    QLog.d(FriendListHandler.TAG, 2, "FriendsManager addFriendToFriendList f.uin = " + str + " ; gatherType = " + friendsSimpleInfoWithUid.n());
                }
                if (d0(str)) {
                    m0(str);
                }
                try {
                    if (friendsSimpleInfoWithUid.f() == -1) {
                        dVar.d0(i3);
                    } else {
                        friendsSimpleInfoWithUid.f();
                        dVar.d0(i3);
                    }
                    dVar.g0(System.currentTimeMillis());
                    if (z16) {
                        if (friendsSimpleInfoWithUid.n().byteValue() != 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        try {
                            dVar.h0((byte) 1);
                            dVar.l0(HardCodeUtil.qqStr(R.string.mtu));
                            Card r16 = r(str);
                            if (r16 != null) {
                                short s16 = r16.shGender;
                                if (s16 == 0) {
                                    i16 = 1;
                                } else if (s16 == 1) {
                                    i16 = 2;
                                }
                                dVar.q0(i16);
                                dVar.V(r16.age);
                            }
                            z26 = z17;
                        } catch (Exception e16) {
                            e = e16;
                            z19 = true;
                            if (QLog.isColorLevel()) {
                                QLog.e("FriendsManagergroup", 2, "addFriendToFriendList ex", e);
                            }
                            z18 = z19;
                            z26 = z17;
                            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "FriendsManager_addFriendToFriendList", new c(z16, z26, str, z18, cVar));
                            return z18;
                        }
                    }
                    Groups w3 = w(String.valueOf(i3));
                    if (w3 != null) {
                        w3.group_friend_count++;
                        this.f194687e.update(w3);
                    }
                    entityTransaction.commit();
                    entityTransaction.end();
                    z18 = true;
                } catch (Exception e17) {
                    e = e17;
                    z17 = z26;
                }
            } finally {
                if (entityTransaction != null) {
                    entityTransaction.end();
                }
            }
        } catch (Exception e18) {
            e = e18;
            z17 = false;
        }
        iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "FriendsManager_addFriendToFriendList", new c(z16, z26, str, z18, cVar));
        return z18;
    }

    public boolean f0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, (Object) this, (Object) str)).booleanValue();
        }
        Friends v3 = v(str);
        if (v3 != null) {
            return v3.isShield();
        }
        return false;
    }

    @UiThread
    @Deprecated
    public List<Groups> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (List) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.f194683b0.asyncGetGroupList(new f());
    }

    @Deprecated
    public boolean g0() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        List<Friends> allFriends = this.f194683b0.getAllFriends();
        List<Groups> groupList = this.f194683b0.getGroupList();
        if (allFriends != null) {
            i3 = allFriends.size();
        } else {
            i3 = 0;
        }
        if (groupList == null || (i3 <= 0 && groupList.size() <= 0)) {
            return false;
        }
        return true;
    }

    public boolean h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return ((Boolean) iPatchRedirector.redirect((short) 95, (Object) this)).booleanValue();
        }
        return VipNtMMKV.getShowColorName().decodeBool(this.f194685d.getCurrentUin(), true);
    }

    public void i(List<SpecialCareInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                w0(list.get(0));
                return;
            }
            ConcurrentHashMap<String, SpecialCareInfo> concurrentHashMap = this.D;
            if (concurrentHashMap != null) {
                synchronized (concurrentHashMap) {
                    for (SpecialCareInfo specialCareInfo : list) {
                        if (!TextUtils.isEmpty(specialCareInfo.uin)) {
                            this.D.put(specialCareInfo.uin, specialCareInfo);
                        }
                    }
                }
            }
            List<BaseTransaction> arrayList = new ArrayList<>();
            for (SpecialCareInfo specialCareInfo2 : list) {
                if (!TextUtils.isEmpty(specialCareInfo2.uin)) {
                    M0(arrayList, specialCareInfo2);
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendsManagerfriend", 2, "bulkSaveOrUpdateSpecialCareInfos: " + specialCareInfo2.toString());
                    }
                }
            }
            this.f194687e.doMultiDBOperateByTransaction(arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagerfriend", 2, "bulkSaveOrUpdateSpecialCareInfos, specialCareInfos is null");
        }
    }

    public boolean i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, (Object) this)).booleanValue();
        }
        return this.f194694i.get();
    }

    public void j(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this, j3);
            return;
        }
        if (!Friends.isValidUin(j3)) {
            return;
        }
        Friends friend = this.f194683b0.getFriend(String.valueOf(j3));
        if (friend != null) {
            int a16 = com.tencent.mobileqq.friend.status.b.a(friend.detalStatusFlag, friend.iTermType);
            if (a16 == 0 || a16 == 6) {
                friend.detalStatusFlag = (byte) 10;
            }
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this);
            return;
        }
        ArrayList<String> arrayList = this.f194695i0;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                ArrayList<String> arrayList2 = this.f194693h0;
                if (arrayList2 != null && arrayList2.contains(next)) {
                    this.f194693h0.remove(next);
                } else {
                    GatherContactsTipsHelper.d(this.f194685d, next);
                }
            }
        }
        ArrayList<String> arrayList3 = this.f194693h0;
        if (arrayList3 != null) {
            Iterator<String> it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                GatherContactsTipsHelper.a(this.f194685d, it5.next());
            }
        }
        this.f194693h0 = null;
        this.f194695i0 = null;
    }

    public void k0(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            List<BaseTransaction> arrayList2 = new ArrayList<>();
            for (String str : list) {
                Friends friend = this.f194683b0.getFriend(str);
                if (friend != null) {
                    byte b16 = friend.gathtertype;
                    byte b17 = 2;
                    if (b16 == 2 || b16 == 0) {
                        if (b16 == 0) {
                            friend.recommReason = HardCodeUtil.qqStr(R.string.mtt);
                        }
                        if (friend.gathtertype != 1) {
                            arrayList.add(str);
                        }
                        friend.gathtertype = (byte) 1;
                        Card r16 = r(friend.uin);
                        if (r16 != null) {
                            short s16 = r16.shGender;
                            if (s16 == 0) {
                                b17 = 1;
                            } else if (s16 != 1) {
                                b17 = 0;
                            }
                            friend.gender = b17;
                            friend.age = r16.age;
                        }
                        M0(arrayList2, friend);
                    }
                    this.f194687e.doMultiDBOperateByTransaction(arrayList2);
                }
            }
            GatherContactsTipsHelper.e(this.f194685d, arrayList);
        }
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) str);
            return;
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).deleteNTFriendSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "FriendsManager_deleteFriend", null);
        if (com.tencent.mobileqq.activity.specialcare.e.p(str, this.f194685d)) {
            com.tencent.mobileqq.activity.specialcare.e.b(str, this.f194685d);
        }
        if (com.tencent.mobileqq.activity.specialcare.e.q(str, this.f194685d)) {
            com.tencent.mobileqq.activity.specialcare.e.d(str, this.f194685d);
        }
        m(str);
        if (H(str) != null) {
            com.tencent.mobileqq.mutualmark.info.a.g(str);
        }
    }

    public void m(String str) {
        SpecialCareInfo specialCareInfo;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagerfriend", 2, "deleteSpecialCareInfo: uin=" + str);
        }
        ConcurrentHashMap<String, SpecialCareInfo> concurrentHashMap = this.D;
        if (concurrentHashMap != null) {
            synchronized (concurrentHashMap) {
                specialCareInfo = this.D.remove(str);
            }
        } else {
            specialCareInfo = null;
        }
        if (specialCareInfo == null) {
            specialCareInfo = (SpecialCareInfo) DBMethodProxy.find(this.f194687e, (Class<? extends Entity>) SpecialCareInfo.class, str);
        }
        if (specialCareInfo != null) {
            if (StatisticCollector.getSqliteSwitchBySample(10)) {
                j3 = SystemClock.uptimeMillis();
            } else {
                j3 = 0;
            }
            this.f194687e.remove(specialCareInfo);
            if (j3 != 0) {
                n0(SystemClock.uptimeMillis() - j3, false, "delete", "SpecialCare");
            }
        }
    }

    public void m0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f194688e0;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str);
        }
        this.f194683b0.moveFriendToNewGroup(str, -1);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManager", 2, "FriendsManager onDestory");
        }
        this.f194687e.close();
    }

    public ArrayList<String> p(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return (ArrayList) iPatchRedirector.redirect((short) 84, (Object) this, (Object) list);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        List<BaseTransaction> arrayList2 = new ArrayList<>();
        for (String str : list) {
            Friends friend = this.f194683b0.getFriend(str);
            if (friend != null) {
                if (friend.gathtertype != 0) {
                    arrayList.add(str);
                }
                friend.gathtertype = (byte) 0;
                M0(arrayList2, friend);
            }
        }
        ThreadManagerV2.excute(new Runnable(arrayList2) { // from class: com.tencent.mobileqq.app.FriendsManager.11
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f194702d;

            {
                this.f194702d = arrayList2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendsManager.this, (Object) arrayList2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FriendsManager.this.f194687e.doMultiDBOperateByTransaction(this.f194702d);
                }
            }
        }, 32, null, true);
        return arrayList;
    }

    public boolean p0(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) card)).booleanValue();
        }
        return ((IProfileDataService) this.f194685d.getRuntimeService(IProfileDataService.class, "all")).saveProfileCard(card);
    }

    public Card q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Card) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        return ((IProfileDataService) this.f194685d.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(str, true);
    }

    public void q0(String str, String str2, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, str, str2, Byte.valueOf(b16));
            return;
        }
        NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(this.f194687e, NearbyPeopleCard.class, "uin=?", new String[]{str});
        if (nearbyPeopleCard == null) {
            nearbyPeopleCard = new NearbyPeopleCard();
            nearbyPeopleCard.uin = str;
        }
        nearbyPeopleCard.lastUpdateNickTime = System.currentTimeMillis();
        nearbyPeopleCard.nickname = str2;
        if (b16 != -1) {
            nearbyPeopleCard.gender = b16;
        }
        G0(nearbyPeopleCard);
        H0(nearbyPeopleCard);
    }

    public Card r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Card) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return ((IProfileDataService) this.f194685d.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(str, false);
    }

    public Friends r0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Friends) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) str2);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uidFromUin, "FriendsManager_saveFriendRemark");
        if (str2 == null) {
            str2 = "";
        }
        if (!str2.equals(friendsSimpleInfoWithUid.r())) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, str);
            dVar.M();
            dVar.m0(str2);
            dVar.g0(System.currentTimeMillis());
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "FriendsManager_saveFriendRemark", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
        }
        return this.f194683b0.getFriend(str, true, true, true);
    }

    public Card s(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Card) iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
        }
        return ((IProfileDataService) this.f194685d.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(str, z16);
    }

    public void s0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, (Object) str2);
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str);
        dVar.M();
        if (str2 == null) {
            str2 = "";
        }
        dVar.m0(str2);
        dVar.g0(System.currentTimeMillis());
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, "FriendsManager_saveFriendRemarkForNT", new e(str));
    }

    public Card t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Card) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        return ((IProfileDataService) this.f194685d.getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(str);
    }

    public void t0(@android.support.annotation.NonNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) arrayList, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder((arrayList.size() * 12) + 48);
            sb5.append("saveGatherList size=");
            sb5.append(arrayList.size());
            sb5.append(" startIndex=");
            sb5.append(i3);
            sb5.append(" uin=");
            Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it = arrayList.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().x() + ",");
            }
            QLog.d(FriendListHandler.TAG, 2, sb5.toString());
        }
        if (arrayList.size() > 0) {
            this.f194685d.getApp().getSharedPreferences(this.f194685d.getAccount(), 0).edit().putBoolean("everHasGatheredContacts", true).commit();
        }
        if (i3 == 0) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(I0(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("FriendsManager_saveGatherList")), "FriendsManager_saveGatherList", new a(arrayList));
        } else {
            J0(arrayList);
        }
    }

    public Friends u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Friends) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return this.f194683b0.getFriend(str, true);
    }

    public void u0(Groups groups) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) groups);
        } else {
            this.f194683b0.saveGroup(groups);
        }
    }

    public Friends v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Friends) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
        }
        if (!j0(str)) {
            return null;
        }
        return this.f194683b0.getFriend(str, true, true);
    }

    @Deprecated
    public void v0(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) extensionInfo);
        } else {
            this.f194684c0.saveExtensionInfo(extensionInfo);
        }
    }

    public Groups w(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (Groups) iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        }
        try {
            return this.f194683b0.getGroup(Integer.parseInt(str), true);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void w0(SpecialCareInfo specialCareInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) specialCareInfo);
            return;
        }
        if (specialCareInfo != null && specialCareInfo.uin != null) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManagerfriend", 2, "saveOrUpdateSpecialCareInfo: " + specialCareInfo.toString());
            }
            ConcurrentHashMap<String, SpecialCareInfo> concurrentHashMap = this.D;
            if (concurrentHashMap != null) {
                synchronized (concurrentHashMap) {
                    this.D.put(specialCareInfo.uin, specialCareInfo);
                }
            }
            H0(specialCareInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManagerfriend", 2, "saveOrUpdateSpecialCareInfo, specailCareInfo is null");
        }
    }

    public KplCard x(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (KplCard) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        }
        if (StatisticCollector.getSqliteSwitchBySample(7)) {
            j3 = SystemClock.uptimeMillis();
        } else {
            j3 = 0;
        }
        KplCard kplCard = (KplCard) DBMethodProxy.find(this.f194687e, (Class<? extends Entity>) KplCard.class, str);
        if (j3 != 0) {
            n0(SystemClock.uptimeMillis() - j3, false, "query", "Card");
        }
        if (kplCard != null) {
            kplCard.transStringToList();
        }
        if (QLog.isColorLevel() && kplCard != null) {
            QLog.d("FriendsManager", 2, "findFriendCardByUin qqNick=" + kplCard.qqNick + ",gameNick=" + kplCard.gameNick + ",uin = " + kplCard.uin);
        }
        return kplCard;
    }

    public void x0(List<cmd0x7c4$RecommendReason> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            for (cmd0x7c4$RecommendReason cmd0x7c4_recommendreason : list) {
                String valueOf = String.valueOf(cmd0x7c4_recommendreason.uint32_reason_id.get());
                String stringUtf8 = cmd0x7c4_recommendreason.bytes_recommend_reason.get().toStringUtf8();
                this.f194696j0.put(valueOf, stringUtf8);
                if (QLog.isColorLevel()) {
                    QLog.i(FriendListHandler.TAG, 2, "key : " + valueOf + " ; reason : " + stringUtf8);
                }
            }
        }
    }

    public AddFrdStateMng y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return (AddFrdStateMng) iPatchRedirector.redirect((short) 96, (Object) this);
        }
        if (!this.E.f280685c) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.FriendsManager.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendsManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!FriendsManager.this.E.f280685c) {
                        FriendsManager.this.E.e(FriendsManager.this.f194685d);
                    }
                }
            }, 16, null, true);
        }
        return this.E;
    }

    public void y0(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, str, Boolean.valueOf(z16));
        } else {
            ((IAddFriendServiceApi) this.f194685d.getRuntimeService(IAddFriendServiceApi.class)).setAddFriendReqStatus(str, z16);
        }
    }

    @Deprecated
    public List<Friends> z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (List) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return this.f194683b0.getAllFriends();
    }

    public void z0(String str, int i3, hx3.c<Boolean> cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Integer.valueOf(i3), cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsManager", 2, "setFriendGroup| uin: " + str + ", groupId: " + i3);
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).moveFriendToNewGroup(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), i3, "FriendsManager_setFriendGroup", new b(cVar));
    }

    public FriendsManager(QQAppInterface qQAppInterface, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) entityManager);
            return;
        }
        this.f194689f = false;
        this.f194692h = false;
        this.f194694i = new AtomicBoolean(false);
        this.f194697m = new QQConcurrentHashMap<>(Business.Conversation, "FiendExtensionInfo");
        this.C = new MQLruCache<>(500);
        this.D = new ConcurrentHashMap<>();
        this.E = new AddFrdStateMng();
        this.F = false;
        this.G = false;
        this.H = 3;
        this.I = 30;
        this.J = 7;
        this.K = 30;
        this.L = 3;
        this.M = 30;
        this.N = 3;
        this.P = 30;
        this.Q = 3;
        this.R = 30;
        this.S = 5;
        this.T = 7;
        this.U = 30;
        this.V = 7;
        this.W = 30;
        this.X = 6;
        this.Y = -1;
        this.Z = true;
        this.f194682a0 = true;
        this.f194686d0 = new AnonymousClass1();
        this.f194688e0 = null;
        this.f194690f0 = false;
        this.f194691g0 = 0;
        this.f194696j0 = new ConcurrentHashMap<>(6);
        this.f194685d = qQAppInterface;
        qQAppInterface.registObserver(this.f194686d0);
        this.f194687e = entityManager;
        l0();
        this.f194683b0 = (IFriendDataService) qQAppInterface.getRuntimeService(IFriendDataService.class, "");
        this.f194684c0 = (IFriendExtensionService) qQAppInterface.getRuntimeService(IFriendExtensionService.class, "");
    }
}
