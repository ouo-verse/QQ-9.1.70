package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.redpoint.RedPointItem;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public class TroopSettingRedPointHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.aio.api.help.b, com.tencent.mvi.base.route.g {
    private CenterProcessor C;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f178746d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f178747e;

    /* renamed from: f, reason: collision with root package name */
    private String f178748f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f178749h = "";

    /* renamed from: i, reason: collision with root package name */
    private List<Integer> f178750i = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private List<Integer> f178751m = new ArrayList();
    private boolean D = false;
    private boolean E = true;
    private com.tencent.mobileqq.troop.redpoint.c F = new a();
    private com.tencent.mvi.base.route.a G = new b();

    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.troop.redpoint.c {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.redpoint.c
        protected void d(String str, String str2, com.tencent.mobileqq.troop.redpoint.b bVar, HashSet<Integer> hashSet) {
            if (TroopSettingRedPointHelper.this.x(str, str2, bVar, hashSet)) {
                TroopSettingRedPointHelper.this.s(bVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NonNull MsgIntent msgIntent) {
            if (msgIntent instanceof AIOTitleEvent.Right1IvClickEvent) {
                if (TroopSettingRedPointHelper.this.C != null) {
                    TroopSettingRedPointHelper.this.C.b();
                }
                ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).cleanRedPointInfoByIds(TroopSettingRedPointHelper.this.f178746d, TroopSettingRedPointHelper.this.f178748f, TroopSettingRedPointHelper.this.f178749h, TroopSettingRedPointHelper.this.f178751m);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    private void A() {
        C();
        if (this.f178746d != null && !TextUtils.isEmpty(this.f178748f) && this.f178750i != null && this.f178751m != null) {
            final String str = this.f178748f;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.az
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingRedPointHelper.this.z(str);
                }
            }, 16, null, true);
        }
    }

    private void B() {
        QQAppInterface qQAppInterface = this.f178746d;
        if (qQAppInterface != null) {
            ((IRedPointInfoService) qQAppInterface.getRuntimeService(IRedPointInfoService.class, "")).removeRedPointListener(this.F);
        }
    }

    private void C() {
        com.tencent.aio.api.runtime.a aVar = this.f178747e;
        if (aVar != null) {
            aVar.e().h(new AIOTitleEvent.TitleResponseEvent(5, Boolean.FALSE));
        }
    }

    private void D() {
        com.tencent.aio.api.runtime.a aVar = this.f178747e;
        if (aVar != null) {
            aVar.e().h(new AIOTitleEvent.TitleResponseEvent(5, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(com.tencent.mobileqq.troop.redpoint.b bVar) {
        List<Integer> list;
        boolean z16;
        if (bVar != null && (list = this.f178750i) != null) {
            Iterator<Integer> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    RedPointItem a16 = bVar.a(it.next().intValue());
                    if (a16 != null && a16.unReadNum != 0) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopSettingRedPointHelper", 2, "UpdateUI: isShowRedPoint = " + z16 + ",mUin = " + this.f178748f + ", mUinType = " + this.f178749h);
            }
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101288", false)) {
                if (z16) {
                    D();
                    return;
                } else {
                    C();
                    return;
                }
            }
            C();
            QLog.d("TroopSettingRedPointHelper", 1, "hideGroupAIORedPoint");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        QQAppInterface qQAppInterface = this.f178746d;
        if (qQAppInterface != null) {
            ((IRedPointInfoService) qQAppInterface.getRuntimeService(IRedPointInfoService.class, "")).addRedPointListener(this.F);
        }
    }

    private void u() {
        this.f178751m.add(1);
    }

    private void v() {
        this.f178750i.add(1);
        this.f178750i.add(2);
        this.f178750i.add(3);
        this.f178750i.add(5);
        this.f178750i.add(6);
        this.f178750i.add(7);
    }

    private void w() {
        s(((IRedPointInfoService) this.f178746d.getRuntimeService(IRedPointInfoService.class, "")).getRedPointInfo(this.f178748f, this.f178749h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(String str, String str2, com.tencent.mobileqq.troop.redpoint.b bVar, HashSet<Integer> hashSet) {
        List<Integer> list;
        boolean z16 = false;
        if (!TextUtils.isEmpty(this.f178748f) && !TextUtils.isEmpty(this.f178749h) && this.f178748f.equals(str) && this.f178749h.equals(str2) && bVar != null && hashSet != null && (list = this.f178750i) != null) {
            Iterator<Integer> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (hashSet.contains(it.next())) {
                    z16 = true;
                    break;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopSettingRedPointHelper", 2, "mUin = " + this.f178748f + ", mUinType = " + this.f178749h + ", needUpdate = " + z16);
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str) {
        if (!this.D && str == this.f178748f && this.C == null) {
            v();
            u();
            CenterProcessor centerProcessor = new CenterProcessor(this.f178746d, this.f178748f);
            this.C = centerProcessor;
            centerProcessor.d();
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(final String str) {
        TroopInfo findTroopInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str)) != null && !findTroopInfo.isExited()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.ba
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingRedPointHelper.this.y(str);
                }
            });
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350655n;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.Right1IvClickEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopSettingRedPointHelper";
    }

    @Override // com.tencent.aio.api.help.b
    public void h(@NonNull com.tencent.aio.main.businesshelper.b bVar) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.TroopSettingRedPointHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (!TroopSettingRedPointHelper.this.D && TroopSettingRedPointHelper.this.f178747e != null && TroopSettingRedPointHelper.this.f178747e.e() != null) {
                    TroopSettingRedPointHelper.this.t();
                    com.tencent.mvi.base.route.j e16 = TroopSettingRedPointHelper.this.f178747e.e();
                    TroopSettingRedPointHelper troopSettingRedPointHelper = TroopSettingRedPointHelper.this;
                    e16.f(troopSettingRedPointHelper, troopSettingRedPointHelper.G);
                }
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NonNull com.tencent.aio.main.businesshelper.b bVar) {
        this.f178747e = bVar.a();
        this.f178746d = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.f178749h = "troop";
        this.f178748f = this.f178747e.g().r().c().j();
        this.E = true;
        this.D = false;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        CenterProcessor centerProcessor = this.C;
        if (centerProcessor != null) {
            centerProcessor.c();
            this.C = null;
        }
        List<Integer> list = this.f178750i;
        if (list != null) {
            list.clear();
        }
        List<Integer> list2 = this.f178751m;
        if (list2 != null) {
            list2.clear();
        }
        B();
        this.f178747e.e().i(this, this.G);
        this.D = true;
        this.f178746d = null;
        this.f178747e = null;
        this.f178748f = "";
        this.f178749h = "";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int i3) {
        if (i3 == 3 && this.E) {
            A();
            this.E = false;
        }
    }

    @Override // com.tencent.aio.api.help.b
    public void i() {
    }
}
