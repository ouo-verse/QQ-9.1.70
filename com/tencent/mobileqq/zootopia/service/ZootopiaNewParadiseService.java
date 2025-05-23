package com.tencent.mobileqq.zootopia.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdSilentHelper;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapListService;
import com.tencent.mobileqq.zootopia.service.ZootopiaNewParadiseService;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardGroupData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardTitleData;
import com.tencent.sqshow.zootopia.data.ZootopiaFaceAdListData;
import com.tencent.sqshow.zootopia.data.ZootopiaGuideListData;
import com.tencent.sqshow.zootopia.data.ZootopiaMainRecommendListData;
import com.tencent.sqshow.zootopia.data.ZootopiaTabConfigData;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import pv4.r;
import pv4.t;
import qv4.ag;
import qv4.ah;
import qv4.bq;
import qv4.bs;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0002\u001c#B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b!\u0010\"J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\bH\u0002J\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u001c\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/ZootopiaNewParadiseService;", "", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaNewParadiseService$b;", "requestParam", "", "startTime", "", "param", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/k;", "callback", "", "e", "Lqv4/ah;", "netRsp", "c", "", "Lpv4/r;", "sceneIndexModules", "", "d", "([Lpv4/r;)Ljava/util/List;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "g", "Lcom/tencent/mobileqq/app/QQAppInterface;", "f", tl.h.F, "", "a", "I", "getSource", "()I", "source", "<init>", "(I)V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaNewParadiseService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0016\u0010\u0013R*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b\u0015\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/ZootopiaNewParadiseService$b;", "", "", "a", "Z", "e", "()Z", tl.h.F, "(Z)V", "isMapInfoFinish", "b", "f", "k", "isOpenIdFinish", "", "c", "J", "()J", "g", "(J)V", "mapInfoCostTime", "d", "j", "openIdCostTime", "", "Lqv4/bs;", "[Lqv4/bs;", "()[Lqv4/bs;", "i", "([Lqv4/bs;)V", "mapInfoResult", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "()Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "l", "(Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;)V", "openIdResult", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isMapInfoFinish;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isOpenIdFinish;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long mapInfoCostTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long openIdCostTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private bs[] mapInfoResult;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private ZootopiaOpenIdResult openIdResult;

        /* renamed from: a, reason: from getter */
        public final long getMapInfoCostTime() {
            return this.mapInfoCostTime;
        }

        /* renamed from: b, reason: from getter */
        public final bs[] getMapInfoResult() {
            return this.mapInfoResult;
        }

        /* renamed from: c, reason: from getter */
        public final long getOpenIdCostTime() {
            return this.openIdCostTime;
        }

        /* renamed from: d, reason: from getter */
        public final ZootopiaOpenIdResult getOpenIdResult() {
            return this.openIdResult;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsMapInfoFinish() {
            return this.isMapInfoFinish;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsOpenIdFinish() {
            return this.isOpenIdFinish;
        }

        public final void g(long j3) {
            this.mapInfoCostTime = j3;
        }

        public final void h(boolean z16) {
            this.isMapInfoFinish = z16;
        }

        public final void i(bs[] bsVarArr) {
            this.mapInfoResult = bsVarArr;
        }

        public final void j(long j3) {
            this.openIdCostTime = j3;
        }

        public final void k(boolean z16) {
            this.isOpenIdFinish = z16;
        }

        public final void l(ZootopiaOpenIdResult zootopiaOpenIdResult) {
            this.openIdResult = zootopiaOpenIdResult;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/ZootopiaNewParadiseService$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f329155a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f329156b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZootopiaNewParadiseService f329157c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZootopiaMainRecommendListData> f329158d;

        c(long j3, long j16, ZootopiaNewParadiseService zootopiaNewParadiseService, com.tencent.mobileqq.zootopia.api.e<ZootopiaMainRecommendListData> eVar) {
            this.f329155a = j3;
            this.f329156b = j16;
            this.f329157c = zootopiaNewParadiseService;
            this.f329158d = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaNewParadiseService", 1, "loadParadiseRecommendList -- errCode:" + errCode + ", errMsg:" + errMsg + ", netReqCostTime=" + (System.currentTimeMillis() - this.f329155a) + ", totalStepCostTime=" + (System.currentTimeMillis() - this.f329156b));
            this.f329158d.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                ah rsp = ah.c(data);
                QLog.i("ZootopiaNewParadiseService", 1, "loadParadiseRecommendList success, netReqCostTime=" + (System.currentTimeMillis() - this.f329155a) + ", totalStepCostTime=" + (System.currentTimeMillis() - this.f329156b));
                ZootopiaNewParadiseService zootopiaNewParadiseService = this.f329157c;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                ZootopiaMainRecommendListData c16 = zootopiaNewParadiseService.c(rsp);
                IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
                String str = rsp.f429920f;
                Intrinsics.checkNotNullExpressionValue(str, "rsp.cdkeyUrl");
                iZPlanMMKVApi.setString("key_cd_key_url", str);
                ZPlanRedDotManager.f373437a.w(c16);
                this.f329158d.onResultSuccess(c16);
            } catch (Exception e16) {
                QLog.e("ZootopiaNewParadiseService", 1, "loadParadiseRecommendList throw e:" + e16.getMessage(), e16);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/service/ZootopiaNewParadiseService$d", "Lcom/tencent/mobileqq/zootopia/openid/a;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.openid.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> f329159a;

        d(com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> eVar) {
            this.f329159a = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void a(ZootopiaOpenIdResult result) {
            this.f329159a.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void b(int errCode, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f329159a.onResultFailure(errCode, errMsg);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/ZootopiaNewParadiseService$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f329160d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f329161e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f329162f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ZootopiaNewParadiseService f329163h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZootopiaMainRecommendListData> f329164i;

        e(String str, b bVar, long j3, ZootopiaNewParadiseService zootopiaNewParadiseService, com.tencent.mobileqq.zootopia.api.e<ZootopiaMainRecommendListData> eVar) {
            this.f329160d = str;
            this.f329161e = bVar;
            this.f329162f = j3;
            this.f329163h = zootopiaNewParadiseService;
            this.f329164i = eVar;
        }

        private final void a(ZootopiaOpenIdResult result) {
            this.f329161e.k(true);
            this.f329161e.j(System.currentTimeMillis() - this.f329162f);
            this.f329161e.l(result);
            this.f329163h.e(this.f329161e, this.f329162f, this.f329160d, this.f329164i);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaOpenIdResult result) {
            QLog.i("ZootopiaNewParadiseService", 1, "loadParadiseRecommendList- " + this.f329160d + ", openId result");
            a(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZootopiaNewParadiseService", 1, "loadParadiseRecommendList- " + this.f329160d + ", openId result error " + error + " - " + message);
            a(null);
        }
    }

    public ZootopiaNewParadiseService(int i3) {
        this.source = i3;
    }

    private final List<r> d(r[] sceneIndexModules) {
        ArrayList arrayList = new ArrayList();
        if ((sceneIndexModules != null ? sceneIndexModules.length : 0) > 0) {
            Intrinsics.checkNotNull(sceneIndexModules);
            for (r rVar : sceneIndexModules) {
                if (rVar.f427657a != 0) {
                    arrayList.add(rVar);
                } else {
                    QLog.e("ZootopiaNewParadiseService", 1, "!!!invalid card data - " + rVar);
                }
            }
        }
        return arrayList;
    }

    private final QQAppInterface f(com.tencent.mobileqq.zootopia.api.e<?> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof QQAppInterface;
        if (!z16) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
        }
        if (z16) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void g(com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> callback) {
        ZootopiaOpenIdSilentHelper.INSTANCE.a().h(new d(callback), true);
    }

    public final void h(final String param, final com.tencent.mobileqq.zootopia.api.e<ZootopiaMainRecommendListData> callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final long currentTimeMillis = System.currentTimeMillis();
        final b bVar = new b();
        ZootopiaDownloadManager.f327992a.W(new Function1<List<? extends ZootopiaResData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.service.ZootopiaNewParadiseService$loadParadiseRecommendList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaResData> list) {
                invoke2((List<ZootopiaResData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ZootopiaResData> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QLog.i("ZootopiaNewParadiseService", 1, "loadParadiseRecommendList- " + param + ", localDownloadInfo result");
                bVar.h(true);
                bVar.g(System.currentTimeMillis() - currentTimeMillis);
                ZootopiaNewParadiseService.b bVar2 = bVar;
                Object[] array = ZootopiaMapListService.Companion.c(ZootopiaMapListService.INSTANCE, it, false, 2, null).toArray(new bs[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                bVar2.i((bs[]) array);
                this.e(bVar, currentTimeMillis, param, callback);
            }
        });
        g(new e(param, bVar, currentTimeMillis, this, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(b requestParam, long startTime, String param, com.tencent.mobileqq.zootopia.api.e<ZootopiaMainRecommendListData> callback) {
        Map emptyMap;
        if (requestParam.getIsMapInfoFinish() && requestParam.getIsOpenIdFinish()) {
            QLog.i("ZootopiaNewParadiseService", 1, "finalLoadParadiseRecommendList- " + param + ", mapInfoCostTime=" + requestParam.getMapInfoCostTime() + ", openIdCostTime=" + requestParam.getOpenIdCostTime() + ", totalCostTime=" + (System.currentTimeMillis() - startTime));
            QQAppInterface f16 = f(callback);
            if (f16 == null) {
                return;
            }
            ag agVar = new ag();
            bs[] mapInfoResult = requestParam.getMapInfoResult();
            if (mapInfoResult != null) {
                agVar.f429908a = mapInfoResult;
            }
            ZootopiaOpenIdResult openIdResult = requestParam.getOpenIdResult();
            if (openIdResult != null) {
                agVar.f429910c = openIdResult.getOpenId();
                agVar.f429911d = openIdResult.getAccessToken();
            }
            long currentTimeMillis = System.currentTimeMillis();
            QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
            byte[] byteArray = MessageNano.toByteArray(agVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(reqInfo)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, f16, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetSceneIndex", byteArray, emptyMap, new c(currentTimeMillis, startTime, this, callback), this.source, 0, 128, null);
            return;
        }
        QLog.i("ZootopiaNewParadiseService", 1, "not finishAll");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0136, code lost:
    
        r4 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x014e, code lost:
    
        r4 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ZootopiaMainRecommendListData c(ah netRsp) {
        List arrayList;
        List arrayList2;
        int i3;
        int i16;
        t[] tVarArr = netRsp.f429921g;
        Integer valueOf = tVarArr != null ? Integer.valueOf(tVarArr.length) : null;
        r[] rVarArr = netRsp.f429915a;
        QLog.i("ZootopiaNewParadiseService", 1, "loadParadiseRecommendList convertRecommendListData -- group.size = " + valueOf + ", module.size = " + (rVarArr != null ? Integer.valueOf(rVarArr.length) : null));
        String str = netRsp.f429918d;
        Intrinsics.checkNotNullExpressionValue(str, "netRsp.tabConfig");
        ZootopiaTabConfigData zootopiaTabConfigData = new ZootopiaTabConfigData(str);
        ArrayList arrayList3 = new ArrayList();
        t[] tVarArr2 = netRsp.f429921g;
        if ((tVarArr2 != null ? tVarArr2.length : 0) > 0) {
            int length = tVarArr2.length;
            int i17 = 0;
            while (i17 < length) {
                t tVar = netRsp.f429921g[i17];
                List<r> d16 = d(tVar.f427699d);
                if (!d16.isEmpty()) {
                    int i18 = tVar.f427698c;
                    if (i18 <= 0) {
                        i3 = i17;
                        i16 = length;
                        arrayList3.add(ZootopiaCardData.Companion.b(ZootopiaCardData.INSTANCE, d16.get(0), zootopiaTabConfigData, i17, 0, null, 24, null));
                    } else {
                        i3 = i17;
                        i16 = length;
                        String str2 = tVar.f427697b;
                        Intrinsics.checkNotNullExpressionValue(str2, "moduleGroup.bgColor");
                        ZootopiaCardGroupData zootopiaCardGroupData = new ZootopiaCardGroupData(i18, str2, new ZootopiaCardTitleData(tVar.f427696a, null), d16.size());
                        int size = d16.size();
                        int i19 = 0;
                        while (i19 < size) {
                            arrayList3.add(ZootopiaCardData.INSTANCE.a(d16.get(i19), zootopiaTabConfigData, i3, i19, zootopiaCardGroupData));
                            i19++;
                            d16 = d16;
                        }
                    }
                } else {
                    i3 = i17;
                    i16 = length;
                    QLog.e("ZootopiaNewParadiseService", 1, "list is empty!!!");
                }
                i17 = i3 + 1;
                length = i16;
            }
        } else {
            r[] rVarArr2 = netRsp.f429915a;
            if ((rVarArr2 != null ? rVarArr2.length : 0) > 0) {
                List<r> d17 = d(rVarArr2);
                if (!d17.isEmpty()) {
                    int size2 = d17.size();
                    for (int i26 = 0; i26 < size2; i26++) {
                        arrayList3.add(ZootopiaCardData.Companion.b(ZootopiaCardData.INSTANCE, d17.get(i26), zootopiaTabConfigData, i26, 0, null, 24, null));
                    }
                }
            }
        }
        bq bqVar = netRsp.f429922h;
        if (bqVar != null) {
            hc4.a aVar = hc4.a.f404730a;
            Intrinsics.checkNotNullExpressionValue(bqVar, "netRsp.ugcEnterInfo");
            aVar.d(bqVar);
        }
        nw4.i iVar = netRsp.f429916b;
        if (iVar == null || (r4 = iVar.f421500a) == null || arrayList == null) {
            arrayList = new ArrayList();
        }
        ZootopiaFaceAdListData zootopiaFaceAdListData = new ZootopiaFaceAdListData(arrayList);
        int i27 = netRsp.f429917c;
        int i28 = netRsp.f429924j;
        pv4.f[] fVarArr = netRsp.f429919e;
        if (fVarArr == null || arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        return new ZootopiaMainRecommendListData(arrayList3, zootopiaTabConfigData, zootopiaFaceAdListData, i27, i28, new ZootopiaGuideListData(arrayList2, netRsp.f429923i), netRsp.f429922h);
    }
}
