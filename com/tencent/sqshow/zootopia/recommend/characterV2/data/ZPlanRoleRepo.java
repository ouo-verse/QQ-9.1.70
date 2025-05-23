package com.tencent.sqshow.zootopia.recommend.characterV2.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.hippy.api.IZPlanParadiseHippyApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.data.ZootopiaFaceAdListData;
import com.tencent.sqshow.zootopia.operation.f;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import nw4.i;
import pv4.r;
import qv4.ak;
import qv4.az;
import qv4.bi;
import qv4.bj;
import qv4.bk;
import qv4.y;
import qv4.z;
import tl.h;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0007*\u00018\u0018\u0000 )2\u00020\u0001:\u0001\u001eB\u0011\u0012\b\u0010;\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\"\u0010\u0019\u001a\u00020\u00042\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u0004R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001f\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u001d8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001f\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u001d8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\u001f\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0+8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001b\u00107\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00105\u001a\u0004\b2\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/ZPlanRoleRepo;", "", "Lqv4/z;", "rsp", "", "p", "", "from", "l", "Lqv4/bi;", "info", ReportConstant.COSTREPORT_PREFIX, "j", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/b;", "r", "", "error", "message", "o", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/d;", "roleData", "k", "Lcom/tencent/mobileqq/zootopia/api/e;", "cb", "tianshuAdId", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "roleLiveData", "Lcom/tencent/sqshow/zootopia/data/i;", "b", "g", "faceAdLiveData", "Lqv4/bj;", "c", h.F, "notificationLiveData", "Lmqq/util/WeakReference;", "Lcom/tencent/sqshow/zootopia/operation/facead/c;", "d", "Lmqq/util/WeakReference;", "f", "()Lmqq/util/WeakReference;", "faceAdLifeCycleDispatcher", "e", "Lqv4/z;", "mCacheData", "Lkotlin/Lazy;", "()Z", "enableFaceAdFromTianShu", "com/tencent/sqshow/zootopia/recommend/characterV2/data/ZPlanRoleRepo$c", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/ZPlanRoleRepo$c;", "tianShuGetAdvCallback", "faceAdLifeCycle", "<init>", "(Lcom/tencent/sqshow/zootopia/operation/facead/c;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRoleRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ZPlanRoleData> roleLiveData = new MutableLiveData<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ZootopiaFaceAdListData> faceAdLiveData = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<bj> notificationLiveData = new MutableLiveData<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<com.tencent.sqshow.zootopia.operation.facead.c> faceAdLifeCycleDispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private z mCacheData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableFaceAdFromTianShu;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final c tianShuGetAdvCallback;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/data/ZPlanRoleRepo$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/z;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<z> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<z> f372473e;

        b(com.tencent.mobileqq.zootopia.api.e<z> eVar) {
            this.f372473e = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(z result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZPlanRoleRepo_", 1, "onResultSuccess ");
            ZPlanRoleRepo.this.p(result);
            ZPlanRoleRepo.this.l(result, "network");
            com.tencent.mobileqq.zootopia.api.e<z> eVar = this.f372473e;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ZPlanRoleRepo.this.o(error, message);
            com.tencent.mobileqq.zootopia.api.e<z> eVar = this.f372473e;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/data/ZPlanRoleRepo$c", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "onGetAdvs", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements TianShuGetAdvCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean result, TianShuAccess.GetAdsRsp getAdsRsp) {
            List list;
            if (!result) {
                QLog.e("ZPlanRoleRepo_", 1, "requestFaceAdv from TianShu failed.");
                return;
            }
            if (getAdsRsp == null) {
                QLog.e("ZPlanRoleRepo_", 1, "requestFaceAdv from TianShu success but rsp null.");
                return;
            }
            ArrayList<nw4.h> m3 = ab4.b.f25786a.m(getAdsRsp);
            if (m3.isEmpty()) {
                QLog.e("ZPlanRoleRepo_", 1, "tianShuGetAdvCallback, adList after transToFaceAdList empty.");
                com.tencent.sqshow.zootopia.operation.facead.c cVar = ZPlanRoleRepo.this.f().get();
                if (cVar != null) {
                    cVar.o7();
                    return;
                }
                return;
            }
            MutableLiveData<ZootopiaFaceAdListData> g16 = ZPlanRoleRepo.this.g();
            list = CollectionsKt___CollectionsKt.toList(m3);
            g16.postValue(new ZootopiaFaceAdListData(list));
        }
    }

    public ZPlanRoleRepo(com.tencent.sqshow.zootopia.operation.facead.c cVar) {
        Lazy lazy;
        this.faceAdLifeCycleDispatcher = new WeakReference<>(cVar);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.data.ZPlanRoleRepo$enableFaceAdFromTianShu$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanQQMC.INSTANCE.enableRequestFaceAdFromTianShu());
            }
        });
        this.enableFaceAdFromTianShu = lazy;
        this.tianShuGetAdvCallback = new c();
        this.mCacheData = ya4.b.f449938a.a();
        QLog.i("ZPlanRoleRepo_", 1, "init hasCache:" + q());
        u();
    }

    private final boolean e() {
        return ((Boolean) this.enableFaceAdFromTianShu.getValue()).booleanValue();
    }

    private final void k(z rsp, ZPlanRoleData roleData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(rsp.f430211a.f430075a.f430068c));
        arrayList.add(Integer.valueOf(rsp.f430211a.f430079e.f430068c));
        arrayList.add(Integer.valueOf(rsp.f430211a.f430080f.f430068c));
        int size = roleData.c().size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(Integer.valueOf(roleData.c().get(i3).f427688i));
        }
        ZPlanRedDotManager zPlanRedDotManager = ZPlanRedDotManager.f373437a;
        Object[] array = arrayList.toArray(new Integer[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ZPlanRedDotManager.z(zPlanRedDotManager, 0, (Integer[]) array, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c7, code lost:
    
        r6 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x004a, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysKt.toList(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(final z rsp, String from) {
        List emptyList;
        pu4.d[] coinList;
        List arrayList;
        nw4.h[] hVarArr;
        QLog.i("ZPlanRoleRepo_", 1, "handleRoleDataRsp rsp.dressUpSwitch:" + rsp.f430215e + ", dynamicBackgroundSwitch: " + rsp.f430216f);
        com.tencent.sqshow.zootopia.recommend.characterV2.data.c cVar = com.tencent.sqshow.zootopia.recommend.characterV2.data.c.f372487a;
        cVar.b().e(Boolean.valueOf(rsp.f430215e));
        cVar.a().e(Boolean.valueOf(rsp.f430216f));
        r rVar = rsp.f430212b;
        if (rVar == null || (r0 = rVar.f427671o) == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        final ZPlanRoleData zPlanRoleData = new ZPlanRoleData(emptyList, r(rsp), from);
        this.roleLiveData.setValue(zPlanRoleData);
        if (Intrinsics.areEqual(from, "network")) {
            bj bjVar = rsp.f430217g;
            if (bjVar != null && bjVar.f430074f != 0) {
                QLog.i("ZPlanRoleRepo_", 1, "handleRoleDataRsp notificationLiveData " + bjVar);
                this.notificationLiveData.postValue(rsp.f430217g);
            } else if (!e()) {
                i iVar = rsp.f430214d;
                QLog.i("ZPlanRoleRepo_", 1, "handleRoleDataRsp faceAdLiveData " + ((iVar == null || (hVarArr = iVar.f421500a) == null) ? null : Integer.valueOf(hVarArr.length)));
                MutableLiveData<ZootopiaFaceAdListData> mutableLiveData = this.faceAdLiveData;
                i iVar2 = rsp.f430214d;
                if (iVar2 == null || (r6 = iVar2.f421500a) == null || arrayList == null) {
                    arrayList = new ArrayList();
                }
                mutableLiveData.postValue(new ZootopiaFaceAdListData(arrayList));
            }
        }
        bk bkVar = rsp.f430211a;
        if (bkVar != null) {
            gb4.a aVar = gb4.a.f401894a;
            aVar.e().postValue(bkVar);
            aVar.h(bkVar);
            if (Intrinsics.areEqual(from, "network")) {
                s(bkVar.f430082h);
            }
            if (Intrinsics.areEqual(from, "network") && (coinList = bkVar.f430076b) != null) {
                Intrinsics.checkNotNullExpressionValue(coinList, "coinList");
                if (!(coinList.length == 0)) {
                    int i3 = 0;
                    int i16 = 0;
                    for (pu4.d dVar : coinList) {
                        int i17 = dVar.f427426a;
                        if (i17 == 1) {
                            i3 = dVar.f427427b;
                        }
                        if (i17 == 0) {
                            i16 = dVar.f427427b;
                        }
                    }
                    f.f372119a.c(i3, i16);
                }
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.data.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRoleRepo.n(ZPlanRoleRepo.this, rsp, zPlanRoleData);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ZPlanRoleRepo this$0, z rsp, ZPlanRoleData roleData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        Intrinsics.checkNotNullParameter(roleData, "$roleData");
        this$0.k(rsp, roleData);
        this$0.j(rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int error, String message) {
        QLog.e("ZPlanRoleRepo_", 1, "handleRoleReqFailed error:" + error + ", message:" + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(z rsp) {
        this.mCacheData = rsp;
        ya4.b.f449938a.c(rsp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        r5 = kotlin.collections.ArraysKt___ArraysKt.toList(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ZPlanFloatBannerData r(z rsp) {
        List emptyList;
        r rVar = rsp.f430213c;
        int i3 = rVar != null ? rVar.f427661e : 0;
        String str = rVar != null ? rVar.f427662f : null;
        if (str == null) {
            str = "";
        }
        int i16 = rVar != null ? rVar.f427664h : 0;
        if (rVar == null || (r5 = rVar.f427671o) == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new ZPlanFloatBannerData(i3, str, i16, emptyList);
    }

    private final void s(bi info) {
        int i3;
        Map<String, Object> mutableMapOf;
        String str;
        id3.d dVar = new id3.d(null, 1, null);
        Pair[] pairArr = new Pair[1];
        if (info != null && (str = info.f430066a) != null) {
            if (str.length() > 0) {
                i3 = 1;
                pairArr[0] = TuplesKt.to("zplan_is_create_role", Integer.valueOf(i3 ^ 1));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                dVar.d("ev_zplan_portal_create_success", mutableMapOf);
            }
        }
        i3 = 0;
        pairArr[0] = TuplesKt.to("zplan_is_create_role", Integer.valueOf(i3 ^ 1));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        dVar.d("ev_zplan_portal_create_success", mutableMapOf);
    }

    public final WeakReference<com.tencent.sqshow.zootopia.operation.facead.c> f() {
        return this.faceAdLifeCycleDispatcher;
    }

    public final MutableLiveData<ZootopiaFaceAdListData> g() {
        return this.faceAdLiveData;
    }

    public final MutableLiveData<bj> h() {
        return this.notificationLiveData;
    }

    public final MutableLiveData<ZPlanRoleData> i() {
        return this.roleLiveData;
    }

    public final boolean q() {
        return this.mCacheData != null;
    }

    public final void t(com.tencent.mobileqq.zootopia.api.e<z> cb5, int tianshuAdId) {
        y yVar = new y();
        az azVar = new az();
        azVar.f430028d = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        yVar.f430209a = azVar;
        yVar.f430210b = tianshuAdId;
        QLog.i("ZPlanRoleRepo_", 1, "requestRoleData req: " + yVar);
        com.tencent.sqshow.zootopia.recommend.main.e.d(com.tencent.sqshow.zootopia.recommend.main.e.f372619a, yVar, new b(cb5), 0, 4, null);
        if (e()) {
            ab4.b.f25786a.h(this.tianShuGetAdvCallback);
        }
    }

    public final void u() {
        z zVar = this.mCacheData;
        if (zVar == null) {
            return;
        }
        m(this, zVar, null, 2, null);
    }

    private final void j(z rsp) {
        ak akVar;
        QLog.i("ZPlanRoleRepo_", 1, "handleHippyRes");
        bk bkVar = rsp.f430211a;
        if (bkVar == null || (akVar = bkVar.f430081g) == null) {
            return;
        }
        ((IZPlanParadiseHippyApi) QRoute.api(IZPlanParadiseHippyApi.class)).preloadHippyRes(akVar);
    }

    static /* synthetic */ void m(ZPlanRoleRepo zPlanRoleRepo, z zVar, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "init";
        }
        zPlanRoleRepo.l(zVar, str);
    }
}
