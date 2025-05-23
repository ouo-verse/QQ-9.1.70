package com.tencent.qqnt.pluspanel.data.loader;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pluspanel.ITroopPanelAppLoaderUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopPlusAppService;
import com.tencent.mobileqq.troop.troopapps.data.PlusPanelAppsInfo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.pluspanel.utils.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001f2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b*\u0010+JD\u0010\n\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JD\u0010\u000b\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\tH\u0002J \u0010\u0013\u001a\u00020\u00122\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\tH\u0002J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\tH\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\tH\u0002Jj\u0010\"\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007`\t2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\t2\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\tH\u0002J\b\u0010#\u001a\u00020\fH\u0002JD\u0010$\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JD\u0010&\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\tJ\"\u0010'\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/loader/h;", "Lcom/tencent/qqnt/pluspanel/data/loader/d;", "", "curId", "", "curType", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "g", "f", "", "hasLoadPublicClass", "Lcom/tencent/mobileqq/troop/data/TroopAIOAppInfo;", "troopAppInfo", "list", "d", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", CommonConstant.KEY_USER_IDENTIFY, tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", DomainData.DOMAIN_NAME, "appID", "Lcom/tencent/qqnt/pluspanel/data/b;", "e", "p", "c", "appList", "moreList", "j", "i", "a", "troopAppInfos", "o", "b", "Ljava/lang/Boolean;", "isMoreListSwitchCache", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h implements d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile Boolean isMoreListSwitchCache;

    private final ArrayList<Integer> c() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        q(arrayList);
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        arrayList.add(Integer.valueOf(companion.P()));
        if (!StudyModeManager.t()) {
            arrayList.add(Integer.valueOf(companion.d()));
        }
        arrayList.add(Integer.valueOf(companion.e()));
        return arrayList;
    }

    private final boolean d(boolean hasLoadPublicClass, TroopAIOAppInfo troopAppInfo, ArrayList<Integer> list) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i3 = troopAppInfo.appid;
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        if (i3 == companion.i0() && !ScribbleResMgr.H(peekAppRuntime.getApp().getApplicationContext(), peekAppRuntime.getCurrentAccountUin())) {
            return hasLoadPublicClass;
        }
        if (troopAppInfo.appid == companion.R() && AppSetting.p(BaseApplication.getContext())) {
            return hasLoadPublicClass;
        }
        list.add(Integer.valueOf(troopAppInfo.appid));
        return hasLoadPublicClass;
    }

    private final com.tencent.qqnt.pluspanel.data.b e(int appID, String curId, int curType) {
        return new com.tencent.qqnt.pluspanel.data.b(0);
    }

    private final ArrayList<Pair<Integer, Bundle>> f(String curId, int curType) {
        ArrayList<Integer> arrayList;
        ITroopPlusAppService iTroopPlusAppService = (ITroopPlusAppService) bg.m(ITroopPlusAppService.class, "all");
        PlusPanelAppsInfo appsFromCache = iTroopPlusAppService != null ? iTroopPlusAppService.getAppsFromCache(Long.parseLong(curId)) : null;
        QLog.d("TroopAppLoaderInjector", 4, "[fillAppListWithMore] getAppFromCache: " + appsFromCache);
        if (appsFromCache == null || (arrayList = appsFromCache.getAppList()) == null) {
            arrayList = new ArrayList<>();
        }
        return j(arrayList, appsFromCache != null ? appsFromCache.getMoreList() : null);
    }

    private final ArrayList<Pair<Integer, Bundle>> g(String curId, int curType) {
        if (p(curId)) {
            return k(this, c(), null, 2, null);
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopAioAppService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        ((ITroopAioAppService) runtimeService).getAppsInObserver(com.tencent.mobileqq.troop.troopapps.g.e(curId));
        ArrayList<Integer> arrayList = new ArrayList<>();
        long m3 = m(curId);
        List<TroopAIOAppInfo> l3 = l(curId);
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppLoaderInjector", 2, "use config: ", Integer.valueOf(l3.size()));
        }
        if (!l3.isEmpty()) {
            o(curId, curType, m3, l3, arrayList);
            ((ITroopPanelAppLoaderUtils) QRoute.api(ITroopPanelAppLoaderUtils.class)).fillAppListIfNeed(curId, arrayList);
        } else {
            arrayList = n();
        }
        return k(this, arrayList, null, 2, null);
    }

    private final boolean h(String curId, long userIdentify, TroopAIOAppInfo troopAppInfo) {
        if (!TextUtils.isEmpty(troopAppInfo.minVersion) && AppSetting.b(troopAppInfo.minVersion) < 0) {
            return true;
        }
        if ((troopAppInfo.identifyMask & ((int) userIdentify)) == 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(".troop.troop_appTroopAppLoaderInjector", 1, "reloadTroop, appInfo is filtered: info: ", troopAppInfo.toString(), " userIdentify: ", Long.toBinaryString(userIdentify));
            }
            return true;
        }
        if (StudyModeManager.t() && troopAppInfo.appid == com.tencent.qqnt.pluspanel.utils.a.INSTANCE.c()) {
            return true;
        }
        if (!((ITroopPanelAppLoaderUtils) QRoute.api(ITroopPanelAppLoaderUtils.class)).checkIfNeedHideApp(curId, troopAppInfo)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppLoaderInjector", 2, "need hide app: " + troopAppInfo.name);
        }
        return true;
    }

    private final boolean i() {
        if (this.isMoreListSwitchCache == null) {
            ITroopPlusAppService iTroopPlusAppService = (ITroopPlusAppService) bg.m(ITroopPlusAppService.class, "all");
            this.isMoreListSwitchCache = iTroopPlusAppService != null ? Boolean.valueOf(iTroopPlusAppService.isMoreListSwitchOn()) : null;
        }
        Boolean bool = this.isMoreListSwitchCache;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final ArrayList<Pair<Integer, Bundle>> j(ArrayList<Integer> appList, ArrayList<Integer> moreList) {
        Bundle bundle;
        ArrayList<Pair<Integer, Bundle>> arrayList = new ArrayList<>();
        Iterator<T> it = appList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (102686667 == intValue) {
                bundle = new Bundle();
                bundle.putIntegerArrayList("child_list", moreList);
            } else {
                bundle = null;
            }
            arrayList.add(new Pair<>(Integer.valueOf(intValue), bundle));
        }
        return arrayList;
    }

    private final List<TroopAIOAppInfo> l(String curId) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopAioAppService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        List<TroopAIOAppInfo> troopAppInfos = ((ITroopAioAppService) runtimeService).getAppsFromCache(com.tencent.mobileqq.troop.troopapps.g.e(curId));
        if (QQAudioHelper.f() && QQAudioHelper.c(4) == 1) {
            QQAudioHelper.w(HardCodeUtil.qqStr(R.string.p_q));
            troopAppInfos = null;
        }
        Intrinsics.checkNotNullExpressionValue(troopAppInfos, "troopAppInfos");
        return troopAppInfos;
    }

    private final long m(String curId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
        TroopInfo B = ((TroopManager) manager).B(curId);
        boolean isTroopOwner = B.isTroopOwner(peekAppRuntime.getCurrentUin());
        return (((B.isOwnerOrAdmin() ? 1 : 0) & 1) << 1) | (((isTroopOwner ? 1 : 0) & 1) << 2) | 1;
    }

    private final boolean p(String curId) {
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppLoaderInjector", 1, " isAnonymousTroop| error for kernelMsgService is null");
            }
            return false;
        }
        GroupAnonymousInfo anonymousInfo = e16.getAnonymousInfo(curId);
        if (anonymousInfo != null) {
            return anonymousInfo.isAnonymousChat;
        }
        return false;
    }

    private final void q(ArrayList<Integer> list) {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
            list.add(Integer.valueOf(companion.f0()));
            list.add(Integer.valueOf(companion.j0()));
        }
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.d
    public ArrayList<Pair<Integer, Bundle>> a(String curId, int curType) {
        Intrinsics.checkNotNullParameter(curId, "curId");
        boolean i3 = i();
        if (!i3) {
            return g(curId, curType);
        }
        if (i3) {
            return f(curId, curType);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.d
    public com.tencent.qqnt.pluspanel.data.b b(int appID, String curId, int curType) {
        Intrinsics.checkNotNullParameter(curId, "curId");
        if (i()) {
            return e(appID, curId, curType);
        }
        for (TroopAIOAppInfo troopAIOAppInfo : l(curId)) {
            if (troopAIOAppInfo.appid == appID) {
                com.tencent.qqnt.pluspanel.data.b bVar = new com.tencent.qqnt.pluspanel.data.b(0);
                bVar.v(troopAIOAppInfo.url);
                bVar.q(troopAIOAppInfo.name);
                bVar.p(troopAIOAppInfo.iconUrl);
                bVar.l(troopAIOAppInfo.action);
                bVar.m(troopAIOAppInfo.actionType);
                bVar.o(troopAIOAppInfo.enName);
                bVar.r(troopAIOAppInfo.redPoint);
                bVar.t(troopAIOAppInfo.simpleDayUrl);
                bVar.u(troopAIOAppInfo.simpleNightUrl);
                return bVar;
            }
        }
        return null;
    }

    public final void o(String curId, int curType, long userIdentify, List<? extends TroopAIOAppInfo> troopAppInfos, ArrayList<Integer> list) {
        Intrinsics.checkNotNullParameter(curId, "curId");
        Intrinsics.checkNotNullParameter(troopAppInfos, "troopAppInfos");
        Intrinsics.checkNotNullParameter(list, "list");
        q(list);
        boolean z16 = false;
        for (TroopAIOAppInfo troopAIOAppInfo : troopAppInfos) {
            if (!h(curId, userIdentify, troopAIOAppInfo)) {
                z16 = d(z16, troopAIOAppInfo, list);
            }
        }
    }

    private final ArrayList<Integer> n() {
        ArrayList<Integer> arrayListOf;
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(companion.c0()), Integer.valueOf(companion.e0()), Integer.valueOf(companion.q0()), Integer.valueOf(companion.V()), Integer.valueOf(companion.u0()), Integer.valueOf(companion.c()), Integer.valueOf(companion.Q()), Integer.valueOf(companion.Y()), Integer.valueOf(companion.a0()), Integer.valueOf(companion.b0()), Integer.valueOf(companion.m0()));
        if (StudyModeManager.t()) {
            arrayListOf.remove(Integer.valueOf(companion.c()));
        }
        return arrayListOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ArrayList k(h hVar, ArrayList arrayList, ArrayList arrayList2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            arrayList2 = new ArrayList();
        }
        return hVar.j(arrayList, arrayList2);
    }
}
