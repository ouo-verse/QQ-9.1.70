package com.tencent.sqshow.zootopia.recommend.main.tab.network;

import android.os.Looper;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabData;
import com.tencent.sqshow.zootopia.utils.ab;
import com.tencent.sqshow.zootopia.utils.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qv4.az;
import qv4.ba;
import qv4.x;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u001a\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000e\u001a\u00020\u0003J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0018\u0010\u0014\u001a\u00020\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0015j\b\u0012\u0004\u0012\u00020\u0007`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/network/ZPlanTabServerDataManager;", "", "Lkotlin/Function0;", "", "callback", "i", "", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/f;", DomainData.DOMAIN_NAME, "Lqv4/x;", "serverRsp", ReportConstant.COSTREPORT_PREFIX, "", "k", "o", "l", "tabList", "u", "Lcom/tencent/mobileqq/zootopia/api/e;", "cb", "p", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "mServerTabList", "com/tencent/sqshow/zootopia/recommend/main/tab/network/ZPlanTabServerDataManager$b", "c", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/network/ZPlanTabServerDataManager$b;", "studyModeChangeListener", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTabServerDataManager {

    /* renamed from: a */
    public static final ZPlanTabServerDataManager f372670a = new ZPlanTabServerDataManager();

    /* renamed from: b, reason: from kotlin metadata */
    private static final ArrayList<ZPlanTabData> mServerTabList = new ArrayList<>();

    /* renamed from: c, reason: from kotlin metadata */
    private static final b studyModeChangeListener = new b();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/tab/network/ZPlanTabServerDataManager$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/x;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<x> {

        /* renamed from: d */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<x> f372673d;

        a(com.tencent.mobileqq.zootopia.api.e<x> eVar) {
            this.f372673d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a */
        public void onResultSuccess(x result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ba[] baVarArr = result.f430208a;
            QLog.i("ZPlanTabServerDataManager_", 1, "doGetPortalV2BottomTabsReq success - " + (baVarArr != null ? Integer.valueOf(baVarArr.length) : null));
            try {
                ZPlanTabServerDataManager.f372670a.u(com.tencent.sqshow.zootopia.recommend.main.tab.b.f372639a.g(result));
            } catch (Exception e16) {
                QLog.e("ZPlanTabServerDataManager_", 1, "transServerRspToTabList Exception", e16);
            }
            ZPlanTabServerDataManager.f372670a.s(result);
            com.tencent.mobileqq.zootopia.api.e<x> eVar = this.f372673d;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            com.tencent.mobileqq.zootopia.api.e<x> eVar = this.f372673d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            QLog.e("ZPlanTabServerDataManager_", 1, "doGetPortalV2BottomTabsReq error - " + error + " - " + message);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/tab/network/ZPlanTabServerDataManager$b", "Lcom/tencent/mobileqq/studymode/StudyModeChangeListener;", "", "isStudyMode", "", "onChange", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements StudyModeChangeListener {
        b() {
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean isStudyMode) {
            QLog.i("ZPlanTabServerDataManager_", 1, "studyModeChangeListener#onChange - " + isStudyMode);
            ZPlanTabServerDataManager.q(ZPlanTabServerDataManager.f372670a, null, 1, null);
        }
    }

    static {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.tab.network.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTabServerDataManager.f();
            }
        }, 32, null, false);
    }

    ZPlanTabServerDataManager() {
    }

    public static final void f() {
        long currentTimeMillis = System.currentTimeMillis();
        final List<ZPlanTabData> n3 = f372670a.n();
        QLog.i("ZPlanTabServerDataManager_", 1, "init###serverDataCache, costTime = " + (System.currentTimeMillis() - currentTimeMillis) + ", size = " + mServerTabList.size());
        if (!n3.isEmpty()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.tab.network.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTabServerDataManager.m(n3);
                }
            });
        }
    }

    private final void i(final Function0<Unit> callback) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            callback.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.tab.network.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTabServerDataManager.j(Function0.this);
                }
            });
        }
    }

    public static final void j(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    private final String k() {
        return "zplan_server_tab_data_" + w.f373306a.b() + "_" + ab.INSTANCE.b();
    }

    public static final void m(List cacheData) {
        Intrinsics.checkNotNullParameter(cacheData, "$cacheData");
        if (mServerTabList.isEmpty()) {
            f372670a.u(cacheData);
        } else {
            QLog.e("ZPlanTabServerDataManager_", 1, "initCache but already exist data");
        }
    }

    private final List<ZPlanTabData> n() {
        byte[] bytes = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes(k(), new byte[0]);
        if (!(bytes.length == 0)) {
            try {
                x rsp = x.c(bytes);
                com.tencent.sqshow.zootopia.recommend.main.tab.b bVar = com.tencent.sqshow.zootopia.recommend.main.tab.b.f372639a;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                List<ZPlanTabData> g16 = bVar.g(rsp);
                QLog.i("ZPlanTabServerDataManager_", 1, "readServerTabCache - " + rsp);
                return g16;
            } catch (Exception e16) {
                QLog.e("ZPlanTabServerDataManager_", 1, "readServerTabCache error", e16);
            }
        }
        return new ArrayList();
    }

    public static final void r(com.tencent.mobileqq.zootopia.api.e eVar) {
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        QLog.i("ZPlanTabServerDataManager_", 1, "doGetPortalV2BottomTabsReq studyMode - " + studyModeSwitch);
        qv4.w wVar = new qv4.w();
        az azVar = new az();
        azVar.f430028d = studyModeSwitch;
        wVar.f430207a = azVar;
        com.tencent.sqshow.zootopia.recommend.main.e.b(com.tencent.sqshow.zootopia.recommend.main.e.f372619a, wVar, new a(eVar), 0, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if ((!(r0.length == 0)) == true) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(final x xVar) {
        boolean z16;
        ba[] baVarArr = xVar.f430208a;
        if (baVarArr != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.tab.network.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTabServerDataManager.t(x.this);
                }
            }, 32, null, false);
        }
    }

    public static final void t(x serverRsp) {
        Intrinsics.checkNotNullParameter(serverRsp, "$serverRsp");
        try {
            byte[] bytes = MessageNano.toByteArray(serverRsp);
            Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
            if (!(bytes.length == 0)) {
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBytes(f372670a.k(), bytes);
            }
        } catch (Exception e16) {
            QLog.e("ZPlanTabServerDataManager_", 1, "saveServerTabCache error", e16);
        }
    }

    public final List<ZPlanTabData> l() {
        return mServerTabList;
    }

    public final void o() {
        ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(studyModeChangeListener);
    }

    public final void p(final com.tencent.mobileqq.zootopia.api.e<x> cb5) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.tab.network.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTabServerDataManager.r(com.tencent.mobileqq.zootopia.api.e.this);
            }
        }, 128, null, false);
    }

    public final void u(final List<ZPlanTabData> tabList) {
        Intrinsics.checkNotNullParameter(tabList, "tabList");
        if (!tabList.isEmpty()) {
            QLog.i("ZPlanTabServerDataManager_", 1, "updateServerTabData, size = " + tabList.size());
            i(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.main.tab.network.ZPlanTabServerDataManager$updateServerTabData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    arrayList = ZPlanTabServerDataManager.mServerTabList;
                    arrayList.clear();
                    arrayList2 = ZPlanTabServerDataManager.mServerTabList;
                    arrayList2.addAll(tabList);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q(ZPlanTabServerDataManager zPlanTabServerDataManager, com.tencent.mobileqq.zootopia.api.e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eVar = null;
        }
        zPlanTabServerDataManager.p(eVar);
    }
}
