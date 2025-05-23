package com.tencent.mobileqq.relationx.icebreaking;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic$ImgInfo;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic$ReqBody;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic$RspBody;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecApi;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.emotion.stickerrecommended.o;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.ThrowablesUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes17.dex */
public class IceBreakingMng implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name */
    public static final String f280760f0;

    /* renamed from: g0, reason: collision with root package name */
    public static boolean f280761g0;
    private final ConcurrentHashMap<String, Integer> C;
    private MqqWeakReferenceHandler D;
    private Set<String> E;
    private Set<String> F;
    private Set<String> G;
    private Set<String> H;
    private Set<String> I;
    private volatile boolean J;
    private boolean K;
    private boolean L;
    private String M;
    private String N;
    private float P;
    private boolean Q;
    private int R;
    private int S;
    public int T;
    public int U;
    private boolean V;
    private final Object W;
    private WeakReference<f> X;
    private WeakReference<com.tencent.mobileqq.relationx.icebreaking.b> Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    ar f280762a0;

    /* renamed from: b0, reason: collision with root package name */
    private volatile String f280763b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.troop.api.observer.e f280764c0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f280765d;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.troop.api.observer.b f280766d0;

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f280767e;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.mobileqq.troop.api.observer.f f280768e0;

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f280769f;

    /* renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f280770h;

    /* renamed from: i, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f280771i;

    /* renamed from: m, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f280772m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        class C8499a implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f280777a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f280778b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Long f280779c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ IOtherInfoService f280780d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f280781e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f280782f;

            C8499a(String str, String str2, Long l3, IOtherInfoService iOtherInfoService, boolean z16, String str3) {
                this.f280777a = str;
                this.f280778b = str2;
                this.f280779c = l3;
                this.f280780d = iOtherInfoService;
                this.f280781e = z16;
                this.f280782f = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, str, str2, l3, iOtherInfoService, Boolean.valueOf(z16), str3);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
                com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar;
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> b16 = eVar.b();
                boolean z17 = true;
                if (eVar.a() == 0 && b16 != null && b16.size() > 0) {
                    z16 = false;
                    aVar = b16.get(0);
                } else {
                    aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a();
                    aVar.t(this.f280777a);
                    aVar.u(this.f280778b);
                    z16 = true;
                }
                if (aVar.z() >= this.f280779c.longValue()) {
                    z17 = z16;
                }
                f fVar = null;
                if (z17) {
                    com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar2 = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(this.f280777a, this.f280778b);
                    aVar2.m();
                    this.f280780d.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar2)), "IceBreak.Mng", null);
                }
                if (IceBreakingMng.this.X != null) {
                    fVar = (f) IceBreakingMng.this.X.get();
                }
                if (fVar != null) {
                    fVar.c(this.f280781e, this.f280782f, this.f280778b, this.f280779c);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IceBreakingMng.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onReqLastChatTime(boolean z16, String str, String str2, Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, l3);
            } else if (z16) {
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
                IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
                iOtherInfoService.getOtherInfoWithUid(uidFromUin, "IceBreak.Mng", new C8499a(uidFromUin, str2, l3, iOtherInfoService, z16, str));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IceBreakingMng.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopMemberCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.HotPic", 2, "onGetTroopMemberCard: isSuccess " + z16);
                }
                if (z16) {
                    Object[] objArr = (Object[]) obj;
                    long longValue = ((Long) objArr[0]).longValue();
                    TroopMemberCard troopMemberCard = (TroopMemberCard) objArr[2];
                    if (String.valueOf(longValue).equals(IceBreakingMng.this.f280763b0)) {
                        QLog.i("IceBreak.HotPic", 1, " onGetTroopMemberCard last_active_time: " + troopMemberCard.lastSpeak + " join_time: " + troopMemberCard.joinTime);
                        if (troopMemberCard.lastSpeak <= troopMemberCard.joinTime) {
                            IceBreakingMng.this.s(String.valueOf(longValue));
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.HotPic", 2, "onGetTroopMemberCard:" + e16.toString());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IceBreakingMng.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            } else if (i16 == 0) {
                if (i3 == 9 || i3 == 2) {
                    IceBreakingMng.this.b0(str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d extends com.tencent.mobileqq.troop.api.observer.f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IceBreakingMng.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.f
        public void b(String str, int i3, ITroopPushHandler.PushType pushType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), pushType);
            } else {
                IceBreakingMng.this.b0(str);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74633);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 49)) {
            redirector.redirect((short) 49);
        } else {
            f280760f0 = HardCodeUtil.qqStr(R.string.nd9);
            f280761g0 = false;
        }
    }

    public IceBreakingMng(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f280765d = false;
        this.f280767e = new ConcurrentHashMap<>();
        this.f280769f = new ConcurrentHashMap<>();
        this.f280770h = new ConcurrentHashMap<>();
        this.f280771i = new ConcurrentHashMap<>();
        this.f280772m = new ConcurrentHashMap<>();
        this.C = new ConcurrentHashMap<>();
        this.D = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this);
        this.E = new HashSet();
        this.F = new HashSet();
        this.G = new HashSet();
        this.H = new HashSet();
        this.I = new HashSet();
        this.J = false;
        this.K = true;
        this.L = false;
        String str = f280760f0;
        this.M = str;
        this.N = str;
        this.P = 30.0f;
        this.Q = true;
        this.R = 30;
        this.S = 50;
        this.T = 30;
        this.U = 5;
        this.V = true;
        this.W = new Object();
        this.Z = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105860", false);
        this.f280762a0 = new a();
        this.f280764c0 = new b();
        this.f280766d0 = new c();
        this.f280768e0 = new d();
        this.D.sendEmptyMessage(0);
        qQAppInterface.addObserver(this.f280762a0, true);
        qQAppInterface.addObserver(this.f280764c0, true);
        qQAppInterface.addObserver(this.f280768e0, true);
        qQAppInterface.addObserver(this.f280766d0, true);
    }

    private void B() {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        Object[] z16 = z();
        Object readObject = FileUtils.readObject(String.format("%s_%s", "break_ice_map", v().getCurrentAccountUin()));
        Object readObject2 = FileUtils.readObject(String.format("%s_%s", "entered_c2c", v().getCurrentAccountUin()));
        Object readObject3 = FileUtils.readObject(String.format("%s_%s", "entered_troop", v().getCurrentAccountUin()));
        Object readObject4 = FileUtils.readObject(String.format("%s_%s", "entered_match_chat", v().getCurrentAccountUin()));
        Object readObject5 = FileUtils.readObject(String.format("%s_%s", "entered_match_friend_chat", v().getCurrentAccountUin()));
        Object readObject6 = FileUtils.readObject(String.format("%s_%s", "entered_qcircle_chat", v().getCurrentAccountUin()));
        if (this.J) {
            return;
        }
        if (readObject != null && (readObject instanceof ConcurrentHashMap)) {
            concurrentHashMap = (ConcurrentHashMap) readObject;
        } else {
            concurrentHashMap = null;
        }
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        if (readObject2 != null) {
            synchronized (this.E) {
                QLog.i("IceBreak.Mng", 2, "classCastSwitch = " + this.Z);
                if (this.Z) {
                    if (readObject2 instanceof Set) {
                        this.E.addAll((Set) readObject2);
                    } else {
                        QLog.i("IceBreak.Mng", 2, "enteredC2c add enteredC2CObj fail ");
                    }
                } else {
                    this.E.addAll((Set) readObject2);
                }
            }
        }
        if (readObject3 != null) {
            synchronized (this.F) {
                this.F.addAll((Set) readObject3);
            }
        }
        if (readObject4 != null) {
            synchronized (this.G) {
                this.G.addAll((Set) readObject4);
            }
        }
        if (readObject5 != null) {
            synchronized (this.H) {
                this.H.addAll((Set) readObject5);
            }
        }
        if (readObject6 != null) {
            synchronized (this.I) {
                this.I.addAll((Set) readObject6);
            }
        }
        t(((Boolean) z16[0]).booleanValue(), ((Boolean) z16[1]).booleanValue(), concurrentHashMap);
        synchronized (this.W) {
            if (!this.J) {
                this.f280767e.putAll(concurrentHashMap);
                this.K = ((Boolean) z16[0]).booleanValue();
                this.L = ((Boolean) z16[1]).booleanValue();
                this.M = (String) z16[2];
                this.N = (String) z16[3];
                this.P = ((Float) z16[4]).floatValue();
                this.Q = ((Boolean) z16[5]).booleanValue();
                this.R = ((Integer) z16[6]).intValue();
                this.S = ((Integer) z16[7]).intValue();
                this.T = ((Integer) z16[8]).intValue();
                this.V = ((Boolean) z16[9]).booleanValue();
                this.J = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("IceBreak.Mng", 2, "init IceBreak Config: mSwitchNewFrd: " + this.K + ",mSwitchOldFrd: " + this.L + ",mTipNewFrd: " + this.M + ",mTipOldFrd: " + this.N + ",mDaysOldFrd: " + this.P + ",switchTroop: " + this.Q + ",troopMemberMinCount: " + this.R + ",troopMemberNotFriendRate: " + this.S + ",showDuration: " + this.T + ",mSwitchNewFrdMiniCard: " + this.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str, ArrayList arrayList) {
        boolean z16;
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                MsgRecord msgRecord = (MsgRecord) arrayList.get(i3);
                int i16 = msgRecord.msgType;
                if (i16 == -1000 || i16 == -1001 || i16 == -2000 || i16 == -2001) {
                    z16 = true;
                    if (msgRecord.getSendType() == 1) {
                        break;
                    }
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            this.C.put(str, 2);
            if (QLog.isColorLevel()) {
                QLog.d("IceBreak.Mng", 2, "checkNeedShowIceBreakGameChat mBreakingIceGameChatMap: " + this.C.size());
            }
            WeakReference<f> weakReference = this.X;
            if (weakReference != null && weakReference.get() != null) {
                this.X.get().b(str, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(String str, boolean z16, List list) {
        O(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(final String str, boolean z16, List list) {
        if (z16 && list.size() > 0) {
            O(str, list);
        } else {
            u(str, true, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.relationx.icebreaking.e
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z17, List list2) {
                    IceBreakingMng.this.M(str, z17, list2);
                }
            });
        }
    }

    private void O(String str, List<TroopMemberInfo> list) {
        int size = list.size();
        FriendsManager friendsManager = (FriendsManager) v().getManager(QQManagerFactory.FRIENDS_MANAGER);
        String currentAccountUin = v().getCurrentAccountUin();
        Iterator<TroopMemberInfo> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            String str2 = it.next().memberuin;
            if (!TextUtils.isEmpty(str2) && !str2.equals(currentAccountUin) && !friendsManager.c0(str2)) {
                i3++;
            }
        }
        QLog.i("IceBreak.HotPic", 1, "noFriendCount: " + i3 + " total count: " + list.size());
        if ((i3 * 1.0f) / (size - 1) > this.S / 100.0f) {
            C(str);
        }
    }

    private void c0() {
        if (!this.J) {
            B();
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.f280767e);
        FileUtils.writeObject(String.format("%s_%s", "break_ice_map", v().getCurrentAccountUin()), concurrentHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final String str) {
        TroopInfo B = ((TroopManager) v().getManager(QQManagerFactory.TROOP_MANAGER)).B(str);
        if (B == null) {
            QLog.i("IceBreak.HotPic", 1, "troop info is null.");
        } else if (B.wMemberNum < this.R) {
            u(str, false, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.relationx.icebreaking.d
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z16, List list) {
                    IceBreakingMng.this.N(str, z16, list);
                }
            });
        } else {
            C(str);
        }
    }

    private boolean t(boolean z16, boolean z17, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        boolean z18 = false;
        if (!z16 && concurrentHashMap.containsValue(0)) {
            Iterator<Map.Entry<String, Integer>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().intValue() == 0) {
                    it.remove();
                }
            }
            z18 = true;
        }
        if (!z17 && concurrentHashMap.containsValue(1)) {
            Iterator<Map.Entry<String, Integer>> it5 = concurrentHashMap.entrySet().iterator();
            while (it5.hasNext()) {
                if (it5.next().getValue().intValue() == 0) {
                    it5.remove();
                }
            }
            return true;
        }
        return z18;
    }

    private void u(String str, boolean z16, com.tencent.qqnt.troopmemberlist.f fVar) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, null, z16, "IceBreak.Mng", fVar);
    }

    private QQAppInterface v() {
        return (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime();
    }

    private String y(int i3, String str) {
        TroopInfo troopInfoFromCache;
        if (i3 == 1) {
            return ((IFriendNameService) v().getRuntimeService(IFriendNameService.class, "all")).getFriendNick(str);
        }
        if (i3 == 2 && (troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(str)) != null) {
            return troopInfoFromCache.getTroopDisplayName();
        }
        return "";
    }

    private Object[] z() {
        Boolean bool = Boolean.TRUE;
        String str = f280760f0;
        return new Object[]{bool, Boolean.FALSE, str, str, Float.valueOf(30.0f), bool, 30, 50, 30, bool};
    }

    public void A(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) bArr);
            return;
        }
        try {
            IcebreakHotPic$RspBody icebreakHotPic$RspBody = new IcebreakHotPic$RspBody();
            icebreakHotPic$RspBody.mergeFrom(bArr);
            if (icebreakHotPic$RspBody.int32_result.get() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse response code error,result:" + icebreakHotPic$RspBody.int32_result.get() + " message : " + icebreakHotPic$RspBody.bytes_fail_msg.get());
                    return;
                }
                return;
            }
            List<IcebreakHotPic$ImgInfo> list = icebreakHotPic$RspBody.rpt_msg_img_info.get();
            if (list != null && !list.isEmpty()) {
                int i3 = icebreakHotPic$RspBody.int32_img_num.get();
                String str = icebreakHotPic$RspBody.trace_id.get();
                ArrayList arrayList = new ArrayList();
                for (int i16 = 0; i16 < list.size(); i16++) {
                    IcebreakHotPic$ImgInfo icebreakHotPic$ImgInfo = list.get(i16);
                    o oVar = new o();
                    oVar.N(i16);
                    oVar.I(icebreakHotPic$ImgInfo.uint64_img_size.get());
                    oVar.M(icebreakHotPic$ImgInfo.uint32_img_width.get());
                    oVar.J(icebreakHotPic$ImgInfo.uint32_img_height.get());
                    oVar.K(icebreakHotPic$ImgInfo.bytes_img_md5.get().toStringUtf8());
                    oVar.L(icebreakHotPic$ImgInfo.bytes_img_down_url.get().toStringUtf8());
                    oVar.O(icebreakHotPic$ImgInfo.bytes_img_word.get().toStringUtf8());
                    oVar.P(icebreakHotPic$ImgInfo.kl_type.get());
                    oVar.V(icebreakHotPic$ImgInfo.uint64_thumb_size.get());
                    oVar.W(icebreakHotPic$ImgInfo.uint32_thumb_img_height.get());
                    oVar.Z(icebreakHotPic$ImgInfo.uint32_thumb_img_width.get());
                    oVar.Y(icebreakHotPic$ImgInfo.bytes_thumb_down_url.get().toStringUtf8());
                    oVar.X(icebreakHotPic$ImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
                    arrayList.add(oVar);
                }
                ThreadManager.getUIHandler().post(new Runnable(arrayList, i3, str) { // from class: com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f280773d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f280774e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f280775f;

                    {
                        this.f280773d = arrayList;
                        this.f280774e = i3;
                        this.f280775f = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, IceBreakingMng.this, arrayList, Integer.valueOf(i3), str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (IceBreakingMng.this.Y != null && IceBreakingMng.this.Y.get() != null) {
                            ((com.tencent.mobileqq.relationx.icebreaking.b) IceBreakingMng.this.Y.get()).a(true, this.f280773d, this.f280774e, this.f280775f);
                        }
                    }
                });
                if (QLog.isColorLevel()) {
                    QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse staticImageNum:" + i3 + "dateList: " + arrayList);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse imgInfos is null or empty");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("IceBreak.HotPic", 2, ThrowablesUtils.getStackTraceAsString(e16));
            }
        }
    }

    public void C(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
            return;
        }
        QLog.i("IceBreak.Mng", 1, "insertTroopToBreakingIceMap troopUin: " + str);
        this.f280769f.put(str, 0);
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.b(str, true);
        }
    }

    public boolean D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        return this.E.contains(str);
    }

    public boolean E(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        return this.G.contains(str);
    }

    public boolean F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        return this.H.contains(str);
    }

    public boolean G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        return this.I.contains(str);
    }

    public boolean H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        return this.F.contains(str);
    }

    public boolean I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        boolean containsKey = this.f280767e.containsKey(str);
        if (containsKey) {
            return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "IceBreak.Mng");
        }
        return containsKey;
    }

    public boolean J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        if (this.f280765d) {
            this.V = true;
        }
        return this.V;
    }

    public boolean K(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, z16)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        if (this.f280765d) {
            this.K = true;
            this.L = true;
        }
        if (z16) {
            return this.K;
        }
        return this.L;
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IceBreak.HotPic", 2, "removeAllEnteredMatchChat ");
        }
        if (!this.J) {
            B();
        }
        if (!this.G.isEmpty()) {
            synchronized (this.G) {
                this.G.clear();
            }
            e0();
        }
    }

    public void Q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IceBreak.HotPic", 2, "removeEnteredMatchChat " + str);
        }
        if (!this.J) {
            B();
        }
        if (this.G.contains(str)) {
            synchronized (this.G) {
                this.G.remove(str);
            }
            e0();
        }
    }

    public void R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IceBreak.HotPic", 2, "removeEnteredMatchFriendChat " + str);
        }
        if (!this.J) {
            B();
        }
        if (this.H.contains(str)) {
            synchronized (this.H) {
                this.H.remove(str);
            }
            f0();
        }
    }

    public boolean S(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.J) {
            B();
        }
        Integer remove = this.f280767e.remove(str);
        if (remove != null) {
            WeakReference<f> weakReference = this.X;
            if (weakReference != null && (fVar = weakReference.get()) != null) {
                fVar.a(str, false);
            }
            if (this.D.hasMessages(1)) {
                this.D.removeMessages(1);
            }
            this.D.sendEmptyMessage(1);
        }
        if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "removeFromBreakingIceList uin: %s , ret:%s", str, remove));
        }
        if (remove == null) {
            return false;
        }
        return true;
    }

    public void T(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            return;
        }
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.d(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i("IceBreak.Mng", 2, "removeFromPush uin:" + str);
        }
    }

    public void U(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
            return;
        }
        this.C.remove(str);
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.a(str, false);
        }
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        } else {
            this.Y = null;
        }
    }

    public void W(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
            return;
        }
        this.f280770h.remove(str);
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.a(str, false);
        }
    }

    public void X(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
            return;
        }
        this.f280771i.remove(str);
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.a(str, false);
        }
    }

    public void Y(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
            return;
        }
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && weakReference.get() == fVar) {
            this.X = null;
        }
    }

    public void a0(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
            return;
        }
        this.f280772m.remove(str);
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.a(str, false);
        }
    }

    public void b0(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
            return;
        }
        QLog.i("IceBreak.Mng", 1, "removeTroopFromBreakingIceMap troopUin: " + str);
        this.f280769f.remove(str);
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.a(str, true);
        }
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (!this.J) {
            B();
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.E);
        FileUtils.writeObject(String.format("%s_%s", "entered_c2c", v().getCurrentAccountUin()), hashSet);
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (!this.J) {
            B();
        }
        HashSet hashSet = new HashSet();
        synchronized (this.G) {
            hashSet.addAll(this.G);
        }
        FileUtils.writeObject(String.format("%s_%s", "entered_match_chat", v().getCurrentAccountUin()), hashSet);
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (!this.J) {
            B();
        }
        HashSet hashSet = new HashSet();
        synchronized (this.H) {
            hashSet.addAll(this.H);
        }
        FileUtils.writeObject(String.format("%s_%s", "entered_match_friend_chat", v().getCurrentAccountUin()), hashSet);
    }

    public void g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (!this.J) {
            B();
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.I);
        FileUtils.writeObject(String.format("%s_%s", "entered_qcircle_chat", v().getCurrentAccountUin()), hashSet);
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (!this.J) {
            B();
        }
        if (!this.E.contains(str)) {
            synchronized (this.E) {
                this.E.add(str);
            }
        }
    }

    public void h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (!this.J) {
            B();
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.F);
        FileUtils.writeObject(String.format("%s_%s", "entered_troop", v().getCurrentAccountUin()), hashSet);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                c0();
                return false;
            }
            return false;
        }
        B();
        return false;
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (!this.J) {
            B();
        }
        if (!this.G.contains(str)) {
            synchronized (this.G) {
                this.G.add(str);
            }
        }
    }

    public void i0(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IceBreak.Mng", 2, String.format("request HotPicList fromUin: %s, termType: %s, aioType: %s, toUin: %s", str, Integer.valueOf(i3), Integer.valueOf(i16), str2));
        }
        try {
            IcebreakHotPic$ReqBody icebreakHotPic$ReqBody = new IcebreakHotPic$ReqBody();
            icebreakHotPic$ReqBody.setHasFlag(true);
            String str3 = str + SystemClock.uptimeMillis();
            icebreakHotPic$ReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(str3));
            icebreakHotPic$ReqBody.uint64_src_uin.set(Long.parseLong(str));
            icebreakHotPic$ReqBody.uint32_src_term.set(i3);
            icebreakHotPic$ReqBody.uint32_aio_type.set(i16);
            icebreakHotPic$ReqBody.uint64_to_uin.set(Long.parseLong(str2));
            icebreakHotPic$ReqBody.str_client_ver.set(AppSetting.f99551k);
            icebreakHotPic$ReqBody.session_nick.set(y(i16, str2));
            Card r16 = ((FriendsManager) v().getManager(QQManagerFactory.FRIENDS_MANAGER)).r(v().getCurrentAccountUin());
            if (r16 != null) {
                icebreakHotPic$ReqBody.uint32_age.set(r16.age);
            } else {
                icebreakHotPic$ReqBody.uint32_age.set(0);
            }
            byte[] byteArray = icebreakHotPic$ReqBody.toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
            allocate.putInt(byteArray.length + 4).put(byteArray);
            NewIntent stickerRecIntent = ((IStickerRecApi) QRoute.api(IStickerRecApi.class)).getStickerRecIntent(v().getApp(), allocate.array(), "BreakIceSvr.Pull");
            if (QLog.isColorLevel()) {
                QLog.d("IceBreak.Mng", 2, "request HotPicList, sessionId = " + str3);
            }
            v().startServlet(stickerRecIntent);
        } catch (Exception e16) {
            QLog.d("IceBreak.Mng", 1, "request HotPicList exception", e16);
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (!this.J) {
            B();
        }
        if (!this.H.contains(str)) {
            synchronized (this.H) {
                this.H.add(str);
            }
        }
    }

    public void j0(com.tencent.mobileqq.relationx.icebreaking.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) bVar);
        } else {
            this.Y = new WeakReference<>(bVar);
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        if (!this.J) {
            B();
        }
        if (!this.I.contains(str)) {
            synchronized (this.I) {
                this.I.add(str);
            }
        }
    }

    public void k0(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
        } else {
            this.X = new WeakReference<>(fVar);
        }
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (!this.J) {
            B();
        }
        if (!this.F.contains(str)) {
            synchronized (this.F) {
                this.F.add(str);
            }
        }
    }

    public void m(String str, boolean z16) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Boolean.valueOf(z16));
            return;
        }
        if (!K(z16)) {
            return;
        }
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "IceBreak.Mng");
        if (isFriend) {
            this.f280767e.put(str, Integer.valueOf(!z16 ? 1 : 0));
            WeakReference<f> weakReference = this.X;
            if (weakReference != null && (fVar = weakReference.get()) != null) {
                fVar.b(str, false);
            }
            if (this.D.hasMessages(1)) {
                this.D.removeMessages(1);
            }
            this.D.sendEmptyMessage(1);
        } else {
            S(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "addToBreakingIceList uin: %s, ret: %s", str, Boolean.valueOf(isFriend)));
        }
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
            return;
        }
        if (!((IStickerRecManager) v().getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen()) {
            if (QLog.isColorLevel()) {
                QLog.i("IceBreak.HotPic", 2, "checkNeedShowIceBreakForTroop emotionRec switch is off");
                return;
            }
            return;
        }
        if (H(str)) {
            QLog.i("IceBreak.HotPic", 1, "entered toop.");
            return;
        }
        if (!this.Q) {
            QLog.i("IceBreak.HotPic", 1, "troop switch is off.");
            return;
        }
        TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, v().getCurrentAccountUin(), null, "IceBreak.Mng");
        if (troopMemberInfoSync != null && troopMemberInfoSync.last_active_time != troopMemberInfoSync.join_time) {
            QLog.i("IceBreak.HotPic", 1, "last_active_time: " + troopMemberInfoSync.last_active_time + " join_time: " + troopMemberInfoSync.join_time);
            if (troopMemberInfoSync.last_active_time > troopMemberInfoSync.join_time) {
                return;
            }
            s(str);
            return;
        }
        QLog.i("IceBreak.HotPic", 1, "troop member info is null.");
        this.f280763b0 = str;
        try {
            ((com.tencent.mobileqq.troop.api.handler.e) v().getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)).U(Long.parseLong(str), Long.parseLong(v().getCurrentAccountUin()), true);
        } catch (NumberFormatException e16) {
            QLog.e("IceBreak.Mng", 1, e16, new Object[0]);
        }
    }

    public void o(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) str);
        } else {
            ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getMsgList(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), 105, 60, new IGameMsgNtApi.b() { // from class: com.tencent.mobileqq.relationx.icebreaking.c
                @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi.b
                public final void onSuccess(ArrayList arrayList) {
                    IceBreakingMng.this.L(str, arrayList);
                }
            });
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.D.removeCallbacksAndMessages(null);
        v().removeObserver(this.f280762a0);
        v().removeObserver(this.f280764c0);
        v().removeObserver(this.f280768e0);
        v().removeObserver(this.f280766d0);
    }

    public void p(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
            return;
        }
        if (E(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat enter " + str);
                return;
            }
            return;
        }
        if (!((com.tencent.mobileqq.qqexpand.manager.e) v().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).y()) {
            if (QLog.isColorLevel()) {
                QLog.i("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat switch is off");
            }
        } else {
            this.f280770h.put(str, 0);
            WeakReference<f> weakReference = this.X;
            if (weakReference != null && (fVar = weakReference.get()) != null) {
                fVar.b(str, false);
            }
        }
    }

    public void q(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
            return;
        }
        if (F(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchFriendChat enter " + str);
                return;
            }
            return;
        }
        if (!((IFeatureRuntimeService) v().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qqstranger_aio_icebreak_emoji_panel_switch")) {
            return;
        }
        this.f280771i.put(str, 0);
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.b(str, false);
        }
    }

    public void r(String str) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
            return;
        }
        if (G(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat enter " + str);
                return;
            }
            return;
        }
        this.f280772m.put(str, 0);
        WeakReference<f> weakReference = this.X;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.b(str, false);
        }
    }

    public int w(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, i3)).intValue();
        }
        if (!this.J) {
            B();
        }
        if (i3 == 1) {
            Integer num = this.f280769f.get(str);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }
        if (IceBreakingUtil.u(i3)) {
            Integer num2 = this.f280770h.get(str);
            if (num2 == null) {
                return -1;
            }
            return num2.intValue();
        }
        if (i3 == 1046) {
            Integer num3 = this.f280771i.get(str);
            if (num3 == null) {
                return -1;
            }
            return num3.intValue();
        }
        if (IceBreakingUtil.w(i3)) {
            Integer num4 = this.f280772m.get(str);
            if (num4 == null) {
                return -1;
            }
            return num4.intValue();
        }
        if (i3 == 10007) {
            if (QLog.isColorLevel()) {
                QLog.d("IceBreak.Mng", 2, "getBreakIceType hasSendIceBreak : " + f280761g0 + " mBreakingIceGameChatMap.size() : " + this.C.size());
            }
            if (this.C.size() == 0 && !f280761g0) {
                o(str);
            }
            Integer num5 = this.C.get(str);
            if (num5 == null) {
                return -1;
            }
            return num5.intValue();
        }
        Integer num6 = this.f280767e.get(str);
        if (num6 == null) {
            return -1;
        }
        return num6.intValue();
    }

    public float x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Float) iPatchRedirector.redirect((short) 36, (Object) this)).floatValue();
        }
        if (!this.J) {
            B();
        }
        return this.P;
    }
}
