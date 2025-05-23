package com.tencent.mobileqq.troop.honor;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.api.ISimpleUIUtil;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfigParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.p;
import com.tencent.qqnt.bus.event.q;
import com.tencent.qqnt.bus.event.r;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import com.tencent.qqnt.troop.TroopOperationRepo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.g;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9$HonorList;
import tencent.im.troop.honor.troop_honor$GroupUserCardHonor;
import tencent.im.troop.honor.troop_honor$HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor$UserHonor;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopHonorManager implements Manager {
    static IPatchRedirector $redirector_;
    private static final String C;

    /* renamed from: d, reason: collision with root package name */
    private List<oidb_0xdc9$HonorList> f297489d;

    /* renamed from: e, reason: collision with root package name */
    private AppRuntime f297490e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.troop.honor.config.b f297491f;

    /* renamed from: h, reason: collision with root package name */
    private EntityManager f297492h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f297493i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.troop.honor.a f297494m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TroopInfo f297496a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f297497b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f297496a = null;
                this.f297497b = false;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            C = ((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopListHandlerName();
        }
    }

    public TroopHonorManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f297493i = false;
        this.f297494m = new com.tencent.mobileqq.troop.honor.a();
        this.f297490e = appRuntime;
        this.f297492h = appRuntime.getEntityManagerFactory().createEntityManager();
        this.f297491f = new com.tencent.mobileqq.troop.honor.config.b();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.honor.TroopHonorManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHonorManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopHonorManager.this.u(TroopHonorConfigParser.d(), true);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a B(boolean z16, String str, int i3, String str2) {
        boolean z17;
        String str3;
        byte h16 = h();
        a aVar = new a();
        String str4 = "";
        TroopInfo troopInfo = ((ITroopInfoService) this.f297490e.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            String str5 = troopExtDBInfo.myHonorList;
            byte b16 = troopExtDBInfo.myHonorRichFlag;
            if (!z16) {
                if (troopExtDBInfo.troopHonorGrayFlag != i3) {
                    TroopExtDBInfoRepo.INSTANCE.updateTroopHonorGrayFlag(str, i3);
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (TextUtils.isEmpty(troopInfo.extDBInfo.myHonorList)) {
                    str3 = "";
                } else {
                    str3 = troopInfo.extDBInfo.myHonorList;
                }
                if (!TextUtils.isEmpty(str2)) {
                    str4 = str2;
                }
                if (!str3.equals(str4)) {
                    z17 = true;
                    if (troopInfo.extDBInfo.myHonorRichFlag != h16) {
                        aVar.f297497b = true;
                        b16 = h16;
                        z17 = true;
                    }
                    TroopExtDBInfoRepo.INSTANCE.updateMyTroopHonor(str, str2, b16);
                }
            } else {
                z17 = false;
            }
            str2 = str5;
            if (troopInfo.extDBInfo.myHonorRichFlag != h16) {
            }
            TroopExtDBInfoRepo.INSTANCE.updateMyTroopHonor(str, str2, b16);
        } else {
            z17 = false;
        }
        if (z17) {
            aVar.f297496a = troopInfo;
            if (QLog.isDebugVersion()) {
                QLog.d("TroopHonor.manager", 4, String.format("updateHostHonorList| update notUpdateHonors:%s, troopUin: %s, troopHonorGrayFlag: %s,honor_rich: %s", Boolean.valueOf(z16), str, Integer.valueOf(i3), Byte.valueOf(h16)));
            }
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TroopMemberInfo E(boolean z16, String str, String str2, List<Integer> list, String str3) {
        boolean z17;
        String str4;
        byte h16 = h();
        TroopMemberInfo troopMemberFromCache = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberFromCache(str2, str, null, "TroopHonor.manager");
        if (troopMemberFromCache == null && !TextUtils.isEmpty(str3)) {
            troopMemberFromCache = new TroopMemberInfo(str2, this.f297490e.getCurrentAccountUin());
        }
        if (troopMemberFromCache != null) {
            if (!z16) {
                String str5 = "";
                if (TextUtils.isEmpty(troopMemberFromCache.honorList)) {
                    str4 = "";
                } else {
                    str4 = troopMemberFromCache.honorList;
                }
                if (!TextUtils.isEmpty(str3)) {
                    str5 = str3;
                }
                if (!str4.equals(str5)) {
                    troopMemberFromCache.honorList = str3;
                    z17 = true;
                    if (troopMemberFromCache.mHonorRichFlag != h16) {
                        troopMemberFromCache.mHonorRichFlag = h16;
                        z17 = true;
                    }
                }
            }
            z17 = false;
            if (troopMemberFromCache.mHonorRichFlag != h16) {
            }
        } else {
            z17 = false;
        }
        if (!z17) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.manager", 2, String.format("updateHostHonorList| update host memberInfo, troopUin: %s, honorList: %s, honor_rich: %s", str2, list, Byte.valueOf(h16)));
        }
        return troopMemberFromCache;
    }

    private byte h() {
        return (byte) this.f297490e.getApp().getSharedPreferences(this.f297490e.getCurrentAccountUin(), 0).getInt("honor_rich_self", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(String str, String str2, ITroopHonorService.c cVar, TroopMemberInfo troopMemberInfo) {
        List<com.tencent.mobileqq.troop.honor.config.a> list;
        if (troopMemberInfo != null) {
            list = g(troopMemberInfo.honorList, Byte.valueOf(troopMemberInfo.mHonorRichFlag));
        } else {
            list = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", str, str2, list));
        }
        if (cVar != null) {
            cVar.onResult(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(String str, String str2, TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo != null) {
            QLog.i("TroopHonor.manager", 1, "notifyTroopMemberHonorUpdateEvent getTroopMemberInfoAsync callback  troopUin = " + str + " memberUin = " + str2 + " honorList = " + troopMemberInfo.honorList + " richFlag = " + ((int) troopMemberInfo.mHonorRichFlag));
            s(str, str2, troopMemberInfo.honorList, troopMemberInfo.mHonorRichFlag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(String str, String str2, String str3, long j3, byte b16, TroopMemberInfo troopMemberInfo) {
        TroopMemberInfo troopMemberInfo2;
        boolean z16;
        if (troopMemberInfo == null && !TextUtils.isEmpty(str)) {
            troopMemberInfo2 = new TroopMemberInfo(str2, str3);
        } else {
            troopMemberInfo2 = troopMemberInfo;
        }
        if (troopMemberInfo2 != null) {
            if (!TextUtils.equals(str, troopMemberInfo2.honorList) || f(j3, troopMemberInfo2.getLastMsgUpdateHonorRichTime(), b16, troopMemberInfo2.mHonorRichFlag)) {
                boolean z17 = false;
                if (QLog.isColorLevel()) {
                    QLog.d("TroopHonor.manager", 2, String.format("updateTroopMemberHonor troopUin: %s, memberUin: %s, newHonorList: %s, oldHonorList: %s", str2, str3, str, troopMemberInfo2.honorList));
                }
                boolean n3 = n(troopMemberInfo2.honorList, str, troopMemberInfo2.mHonorRichFlag, b16);
                troopMemberInfo2.honorList = str;
                if ((b16 != -96 && j3 == -101) || j3 > troopMemberInfo2.getLastMsgUpdateHonorRichTime()) {
                    if (troopMemberInfo2.mHonorRichFlag != b16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    troopMemberInfo2.mHonorRichFlag = b16;
                    ((ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class)).updateLastMsgUpdateHonorRichTime(str2, str3, j3, "TroopHonor.manager");
                    z17 = z16;
                }
                y(str2, str3, str, troopMemberInfo2.realLevel);
                if (n3) {
                    r(str2, str3);
                }
                if (z17) {
                    AppRuntime appRuntime = this.f297490e;
                    if (appRuntime instanceof AppInterface) {
                        ((TroopInfoHandler) ((AppInterface) appRuntime).getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, str2);
                    }
                }
            }
        }
    }

    private boolean n(String str, String str2, byte b16, byte b17) {
        if (TextUtils.equals(str, str2) && (TextUtils.isEmpty(str) || b16 == b17)) {
            return false;
        }
        return true;
    }

    private void o(String str, String str2, String str3, byte b16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str3 == null) {
                str3 = "";
            }
            QLog.i("TroopHonor.manager", 1, "notifyMutualMarkGroupMemberEvent  troopUin = " + str + " memberUin = " + str2 + " honorList = " + str3 + " richFlag = " + ((int) b16));
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new r(str2, str, str3, b16));
        }
    }

    private void s(String str, String str2, String str3, byte b16) {
        if (TextUtils.isEmpty(str3)) {
            o(str, str2, "", (byte) 0);
            return;
        }
        ITroopHonorService.b bVar = new ITroopHonorService.b(str, str2, str3, Byte.valueOf(b16));
        if (QLog.isColorLevel()) {
            QLog.i("TroopHonor.manager", 1, "notifyTroopMemberHonorUpdateByCheckIconDrawable troopUin = " + str + "memberUin = " + str2);
        }
        List<Drawable> honorIcon = ((ITroopHonorService) this.f297490e.getRuntimeService(ITroopHonorService.class, "")).getHonorIcon(bVar, new e(str2, str, str3, b16));
        if (honorIcon != null && !honorIcon.isEmpty()) {
            o(str, str2, str3, b16);
        }
    }

    private void y(String str, String str2, String str3, int i3) {
        QLog.i("TroopHonor.manager", 1, "[updateMemberInfoDb] troopUin = " + str + ", memberUin = " + str2 + ", honorStr = " + str3 + ", memberLevel = " + i3);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            List<Integer> d16 = com.tencent.mobileqq.troop.honor.util.a.d(str3);
            if (d16 == null) {
                d16 = new ArrayList<>();
            }
            troop_honor$GroupUserCardHonor troop_honor_groupusercardhonor = new troop_honor$GroupUserCardHonor();
            troop_honor_groupusercardhonor.f436061id.set(d16);
            troop_honor_groupusercardhonor.level.set(i3);
            ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).updateTroopMemberHonor(str, str2, troop_honor_groupusercardhonor.toByteArray());
        }
    }

    public void A(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Boolean.valueOf(z16));
            return;
        }
        TroopInfo troopInfo = ((ITroopInfoService) this.f297490e.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
        if (troopInfo == null) {
            QLog.d("TroopHonor.manager", 1, "updateTroopHonorAIOSwitch troopInfo is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.manager", 2, String.format("updateTroopHonorAIOSwitch, troopUin: %s, isOpen: %s, old: %s", str, Boolean.valueOf(z16), Boolean.valueOf(troopInfo.isTroopHonorOpen())));
        }
        if (troopInfo.isTroopHonorOpen() ^ z16) {
            TroopOperationRepo.INSTANCE.updateHonorAIOSwitch(str, z16);
            q(str);
        }
    }

    public void C(String str, String str2, String str3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3, Byte.valueOf(b16));
        } else {
            D(str, str2, str3, b16, -101L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0082, code lost:
    
        if (f(r24, r0.lastMsgUpdateMyHonorRichTime, r23, r0.myHonorRichFlag) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D(final String str, final String str2, final String str3, final byte b16, final long j3) {
        TroopInfo troopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, str3, Byte.valueOf(b16), Long.valueOf(j3));
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ITroopInfoService iTroopInfoService = (ITroopInfoService) this.f297490e.getRuntimeService(ITroopInfoService.class, "");
            if (this.f297490e.getCurrentAccountUin().equals(str2) && (troopInfo = iTroopInfoService.getTroopInfo(str)) != null && str3 != null) {
                if (str3.equals(troopInfo.extDBInfo.myHonorList)) {
                    TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
                }
                if (b16 != -96 && (j3 == -101 || j3 > troopInfo.extDBInfo.lastMsgUpdateMyHonorRichTime)) {
                    TroopExtDBInfoRepo troopExtDBInfoRepo = TroopExtDBInfoRepo.INSTANCE;
                    troopExtDBInfoRepo.updateMyTroopHonor(str, str3, b16);
                    troopExtDBInfoRepo.updateHonorUpdateTime(str, j3);
                } else {
                    TroopExtDBInfoRepo.INSTANCE.updateMyTroopHonor(str, str3, troopInfo.extDBInfo.myHonorRichFlag);
                }
            }
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfoWithExtInfo(str, str2, false, null, "TroopHonor.manager-update", new g() { // from class: com.tencent.mobileqq.troop.honor.b
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    TroopHonorManager.this.m(str3, str, str2, j3, b16, troopMemberInfo);
                }
            });
        }
    }

    public void e(final String str, final String str2, final ITroopHonorService.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, cVar);
        } else {
            ((ITroopMemberInfoService) this.f297490e.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(str, str2, "TroopHonor.manager-direct", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troop.honor.d
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    TroopHonorManager.this.k(str, str2, cVar, troopMemberInfo);
                }
            });
        }
    }

    public boolean f(long j3, long j16, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Long.valueOf(j16), Byte.valueOf(b16), Byte.valueOf(b17))).booleanValue();
        }
        if (b16 == b17) {
            return false;
        }
        if (j3 == -101 || j3 > j16) {
            return true;
        }
        return false;
    }

    public List<com.tencent.mobileqq.troop.honor.config.a> g(String str, Byte b16) {
        com.tencent.mobileqq.troop.honor.config.a c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) b16);
        }
        ArrayList arrayList = new ArrayList();
        List<Integer> d16 = com.tencent.mobileqq.troop.honor.util.a.d(str);
        if (d16 != null && d16.size() > 0) {
            for (Integer num : d16) {
                if (num.intValue() != 1 && num.intValue() != 2 && num.intValue() != 3) {
                    c16 = this.f297491f.c(num.intValue());
                } else {
                    int h16 = com.tencent.mobileqq.troop.honor.util.a.h(num.intValue(), b16.byteValue());
                    if (h16 == 1) {
                        c16 = this.f297491f.b(num.intValue(), h16);
                    } else {
                        c16 = this.f297491f.c(num.intValue());
                    }
                }
                if (c16 != null) {
                    arrayList.add(c16);
                }
            }
        }
        return arrayList;
    }

    public boolean i(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        com.tencent.mobileqq.troop.honor.config.b bVar = this.f297491f;
        boolean z17 = false;
        if (bVar != null && bVar.f297519f) {
            z16 = true;
        } else {
            z16 = false;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) this.f297490e.getRuntimeService(ITroopInfoService.class, "");
        if (z16) {
            return true;
        }
        TroopInfo troopInfo = iTroopInfoService.getTroopInfo(str);
        if (troopInfo != null && troopInfo.extDBInfo.troopHonorGrayFlag == 1) {
            z17 = true;
        }
        return z17;
    }

    public boolean j(String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        com.tencent.mobileqq.troop.honor.config.b bVar = this.f297491f;
        if (bVar != null && bVar.f297519f) {
            z16 = true;
        } else {
            z16 = false;
        }
        TroopInfo troopInfo = ((ITroopInfoService) this.f297490e.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
        if (!z16 && troopInfo != null && troopInfo.extDBInfo.troopHonorGrayFlag == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (troopInfo != null && (troopInfo.dwGroupFlagExt3 & 33554432) == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        ISimpleUIUtil iSimpleUIUtil = (ISimpleUIUtil) QRoute.api(ISimpleUIUtil.class);
        if (iSimpleUIUtil != null) {
            z19 = iSimpleUIUtil.getSimpleUISwitch();
        } else {
            z19 = false;
        }
        if ((z16 || z17) && z18 && !z19) {
            return true;
        }
        return false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.f297492h.close();
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            QLog.i("TroopHonor.manager", 1, "notifyTroopHonorGlobalUpdateEvent");
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(p.f353239a);
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i("TroopHonor.manager", 1, "notifyTroopHonorUpdateEvent troopUin = " + str);
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new q(str));
    }

    public void r(final String str, final String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!j(str)) {
                QLog.i("TroopHonor.manager", 1, "notifyTroopMemberHonorUpdateEvent isSupportTroopHonor false  troopUin = " + str + " memberUin = " + str2);
                o(str, str2, "", (byte) 0);
                return;
            }
            ((ITroopMemberInfoService) this.f297490e.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(str, str2, "TroopHonor.manager-notify", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troop.honor.c
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    TroopHonorManager.this.l(str, str2, troopMemberInfo);
                }
            });
        }
    }

    public void t(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Short.valueOf(s16));
        } else {
            this.f297490e.getApplication().getSharedPreferences(this.f297490e.getCurrentAccountUin(), 0).edit().putInt("honor_rich_self", s16).apply();
        }
    }

    public synchronized void u(com.tencent.mobileqq.troop.honor.config.b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bVar, Boolean.valueOf(z16));
            return;
        }
        if (bVar == null) {
            QLog.d("TroopHonor.manager", 1, "updateConfig, config == null");
            return;
        }
        if (z16 && this.f297493i) {
            QLog.d("TroopHonor.manager", 1, "had init config");
            return;
        }
        this.f297493i = true;
        this.f297491f = bVar;
        if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.manager", 2, String.format("updateConfig, isInit: %s, config: %s", Boolean.valueOf(z16), bVar));
        }
        if (!z16) {
            p();
        }
        this.f297494m.a(this.f297491f);
    }

    public boolean v(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) entity)).booleanValue();
        }
        if (entity.getStatus() == 1000) {
            this.f297492h.persistOrReplace(entity);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f297492h.update(entity);
    }

    public void w(List<oidb_0xdc9$HonorList> list, boolean z16) {
        int i3;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, list, Boolean.valueOf(z16));
            return;
        }
        if (list != null && list.size() != 0) {
            this.f297489d = list;
            StringBuilder sb5 = new StringBuilder();
            String currentAccountUin = this.f297490e.getCurrentAccountUin();
            if (TextUtils.isEmpty(currentAccountUin)) {
                QLog.d("TroopHonor.manager", 1, "updateHostHonorList memberUin is empty");
                return;
            }
            boolean z18 = false;
            boolean z19 = false;
            for (oidb_0xdc9$HonorList oidb_0xdc9_honorlist : list) {
                String valueOf = String.valueOf(oidb_0xdc9_honorlist.group_id.get());
                if (oidb_0xdc9_honorlist.is_gray.has()) {
                    i3 = oidb_0xdc9_honorlist.is_gray.get();
                } else {
                    i3 = 0;
                }
                List<Integer> list2 = oidb_0xdc9_honorlist.f436016id.get();
                String b16 = com.tencent.mobileqq.troop.honor.util.a.b(list2);
                sb5.append(valueOf);
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(b16);
                sb5.append("\n");
                if (!TextUtils.isEmpty(valueOf)) {
                    a B = B(z16, valueOf, i3, b16);
                    if (!z19 && B.f297497b) {
                        z17 = true;
                    } else {
                        z17 = z19;
                    }
                    TroopMemberInfo E = E(z16, currentAccountUin, valueOf, list2, b16);
                    if (B.f297496a == null && E == null) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    z19 = z17;
                } else {
                    QLog.d("TroopHonor.manager", 1, String.format("updateHostHonorList| troopUin is empty", new Object[0]));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopHonor.manager", 2, "updateHostHonorList, " + sb5.toString());
            }
            if (z18) {
                ThreadManagerV2.excute(new Runnable(z19) { // from class: com.tencent.mobileqq.troop.honor.TroopHonorManager.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ boolean f297495d;

                    {
                        this.f297495d = z19;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TroopHonorManager.this, Boolean.valueOf(z19));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        TroopHonorManager.this.p();
                        if (this.f297495d && (TroopHonorManager.this.f297490e instanceof AppInterface)) {
                            ((TroopInfoHandler) ((AppInterface) TroopHonorManager.this.f297490e).getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_GLOBAL_CHANGED, true, null);
                        }
                    }
                }, 32, null, true);
                return;
            }
            return;
        }
        QLog.d("TroopHonor.manager", 1, "updateHostHonorList| honorList is empty!");
    }

    public void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            w(this.f297489d, z16);
        }
    }

    public void z(String str, byte[] bArr, int i3) {
        List<Integer> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, bArr, Integer.valueOf(i3));
            return;
        }
        try {
            troop_honor$HonorChangeGrayTipsReserved troop_honor_honorchangegraytipsreserved = new troop_honor$HonorChangeGrayTipsReserved();
            troop_honor_honorchangegraytipsreserved.mergeFrom(bArr);
            List<troop_honor$UserHonor> list2 = troop_honor_honorchangegraytipsreserved.user_honor.get();
            if (list2 != null && list2.size() > 0) {
                for (troop_honor$UserHonor troop_honor_userhonor : list2) {
                    String valueOf = String.valueOf(troop_honor_userhonor.uin.get());
                    if (troop_honor_userhonor.f436062id.has()) {
                        list = troop_honor_userhonor.f436062id.get();
                    } else {
                        list = null;
                    }
                    C(str, valueOf, com.tencent.mobileqq.troop.honor.util.a.b(list), com.tencent.mobileqq.troop.honor.util.a.a(troop_honor_userhonor.rich_flag));
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopHonor.push", 2, String.format("updatePushTroopHonor, pushType: %s, troopUin: %s, memberUin: %s, ids: %s\uff0chonor_rich\uff1a%s", Integer.valueOf(i3), str, valueOf, list, Integer.valueOf(troop_honor_userhonor.rich_flag.get())));
                    }
                }
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            QLog.d("TroopHonor.manager", 1, "updatePushTroopHonor", e16);
        }
    }
}
