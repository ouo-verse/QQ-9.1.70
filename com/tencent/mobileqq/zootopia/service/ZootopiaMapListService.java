package com.tencent.mobileqq.zootopia.service;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapListService;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qv4.bs;
import qv4.s;
import qv4.t;
import zb3.ZootopiaMapListData;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u0001:\u0001\fB\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001c\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapListService;", "", "", "g", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/zootopia/b;", "Lzb3/i;", "callback", "f", "e", "", "a", "I", "d", "()I", "source", "b", "currPage", "<init>", "(I)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaMapListService {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currPage;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapListService$a;", "", "", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "list", "", "filterOnlyCompleted", "Ljava/util/ArrayList;", "Lqv4/bs;", "Lkotlin/collections/ArrayList;", "b", "", "mapId", "resData", "a", "", "METHOD", "Ljava/lang/String;", "NO_ERROR_CODE", "I", "REQ_NUM", "SERVICE", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.service.ZootopiaMapListService$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final bs a(int mapId, ZootopiaResData resData) {
            String str;
            bs bsVar = new bs();
            bsVar.f430115a = mapId;
            ZPlanMapDiffPatchInfo diffPatchInfo = resData != null ? resData.getDiffPatchInfo() : null;
            if (resData != null && (resData.getDownloadStatus() == 2 || resData.getDownloadStatus() == 1 || resData.getDownloadStatus() == 4 || resData.getDownloadStatus() == 8)) {
                boolean z16 = false;
                if (diffPatchInfo != null && diffPatchInfo.isValid()) {
                    z16 = true;
                }
                if (z16) {
                    pv4.e diffPatchInfo2 = diffPatchInfo.diffPatchInfo();
                    if (!TextUtils.isEmpty(diffPatchInfo2 != null ? diffPatchInfo2.f427595g : null) && ZPlanFeatureSwitch.f369852a.D0()) {
                        pv4.e diffPatchInfo3 = diffPatchInfo.diffPatchInfo();
                        String str2 = diffPatchInfo3 != null ? diffPatchInfo3.f427595g : null;
                        QLog.i("IZPlanMapListService", 1, "convertResDataToUserMapInfoForServer diff, mapId= " + mapId + ", status= " + resData.getDownloadStatus() + ", diffBaseVersion= " + str2 + ", newVersion= " + resData.getVersion());
                        bsVar.f430116b = str2;
                        return bsVar;
                    }
                }
            }
            if (resData == null || (str = resData.getVersion()) == null) {
                str = "";
            }
            bsVar.f430116b = str;
            return bsVar;
        }

        public final ArrayList<bs> b(List<ZootopiaResData> list, boolean filterOnlyCompleted) {
            Intrinsics.checkNotNullParameter(list, "list");
            ArrayList<bs> arrayList = new ArrayList<>();
            for (ZootopiaResData zootopiaResData : list) {
                if (!filterOnlyCompleted || zootopiaResData.getDownloadStatus() == 5) {
                    if (zootopiaResData.getDownloadStatus() != 6) {
                        arrayList.add(ZootopiaMapListService.INSTANCE.a(zootopiaResData.getId(), zootopiaResData));
                    }
                }
            }
            return arrayList;
        }

        Companion() {
        }

        public static /* synthetic */ ArrayList c(Companion companion, List list, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            return companion.b(list, z16);
        }
    }

    public ZootopiaMapListService() {
        this(0, 1, null);
    }

    /* renamed from: d, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public final void e(final AppInterface app, final com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZootopiaDownloadManager.f327992a.W(new Function1<List<? extends ZootopiaResData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.service.ZootopiaMapListService$loadMoreZootopiaMapList$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/ZootopiaMapListService$loadMoreZootopiaMapList$1$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements td3.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> f329143a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ ZootopiaMapListService f329144b;

                a(com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> bVar, ZootopiaMapListService zootopiaMapListService) {
                    this.f329143a = bVar;
                    this.f329144b = zootopiaMapListService;
                }

                @Override // td3.a
                public void a(Integer errCode, String errMsg) {
                    if (QLog.isColorLevel()) {
                        QLog.e("IZPlanMapListService", 4, "errCode" + errCode + "  " + errMsg);
                    }
                }

                @Override // td3.a
                public void onReceive(byte[] data) {
                    int i3;
                    if (data != null) {
                        com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> bVar = this.f329143a;
                        ZootopiaMapListService zootopiaMapListService = this.f329144b;
                        try {
                            t rsp = t.c(data);
                            QLog.i("IZPlanMapListService", 1, "loadMoreZootopiaMapList success");
                            boolean z16 = rsp.f430200b;
                            com.tencent.mobileqq.zootopia.utils.f fVar = com.tencent.mobileqq.zootopia.utils.f.f329556a;
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            bVar.Z(z16, fVar.b(rsp));
                            i3 = zootopiaMapListService.currPage;
                            zootopiaMapListService.currPage = i3 + 1;
                        } catch (Throwable unused) {
                            QLog.e("IZPlanMapListService", 1, "loadMoreZootopiaMapList parse data error");
                        }
                    }
                }
            }

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
                int i3;
                Map emptyMap;
                Intrinsics.checkNotNullParameter(it, "it");
                s sVar = new s();
                Object[] array = ZootopiaMapListService.Companion.c(ZootopiaMapListService.INSTANCE, it, false, 2, null).toArray(new bs[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                sVar.f430196a = (bs[]) array;
                i3 = ZootopiaMapListService.this.currPage;
                sVar.f430197b = i3;
                sVar.f430198c = 10;
                QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
                AppInterface appInterface = app;
                byte[] byteArray = MessageNano.toByteArray(sVar);
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(getMapListReq)");
                emptyMap = MapsKt__MapsKt.emptyMap();
                IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetMapList", byteArray, emptyMap, new a(callback, ZootopiaMapListService.this), ZootopiaMapListService.this.getSource(), 0, 128, null);
            }
        });
    }

    public final void f(final AppInterface app, final com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZootopiaDownloadManager.f327992a.W(new Function1<List<? extends ZootopiaResData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.service.ZootopiaMapListService$refreshZootopiaMapList$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/ZootopiaMapListService$refreshZootopiaMapList$1$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements td3.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> f329145a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ ZootopiaMapListService f329146b;

                a(com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> bVar, ZootopiaMapListService zootopiaMapListService) {
                    this.f329145a = bVar;
                    this.f329146b = zootopiaMapListService;
                }

                @Override // td3.a
                public void a(Integer errCode, String errMsg) {
                    QLog.e("IZPlanMapListService", 1, "errCode" + errCode + "  " + errMsg);
                    this.f329145a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
                }

                @Override // td3.a
                public void onReceive(byte[] data) {
                    if (data != null) {
                        com.tencent.mobileqq.zootopia.b<ZootopiaMapListData> bVar = this.f329145a;
                        ZootopiaMapListService zootopiaMapListService = this.f329146b;
                        try {
                            t rsp = t.c(data);
                            QLog.i("IZPlanMapListService", 1, "refreshZootopiaMapList success");
                            boolean z16 = rsp.f430200b;
                            com.tencent.mobileqq.zootopia.utils.f fVar = com.tencent.mobileqq.zootopia.utils.f.f329556a;
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            bVar.Z(z16, fVar.b(rsp));
                            zootopiaMapListService.g();
                        } catch (Throwable unused) {
                            QLog.e("IZPlanMapListService", 1, "refreshZootopiaMapList parse data error");
                        }
                    }
                }
            }

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
                Map emptyMap;
                Intrinsics.checkNotNullParameter(it, "it");
                Object[] array = ZootopiaMapListService.Companion.c(ZootopiaMapListService.INSTANCE, it, false, 2, null).toArray(new bs[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                bs[] bsVarArr = (bs[]) array;
                StringBuilder sb5 = new StringBuilder("");
                for (bs bsVar : bsVarArr) {
                    sb5.append(bsVar.f430115a);
                    sb5.append("_");
                    sb5.append(bsVar.f430116b);
                    sb5.append(", ");
                }
                QLog.i("IZPlanMapListService", 1, "refreshZootopiaMapList, localMapVersion = " + ((Object) sb5));
                s sVar = new s();
                sVar.f430196a = bsVarArr;
                sVar.f430197b = 0;
                sVar.f430198c = 10;
                QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
                AppInterface appInterface = AppInterface.this;
                byte[] byteArray = MessageNano.toByteArray(sVar);
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(getMapListReq)");
                emptyMap = MapsKt__MapsKt.emptyMap();
                IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetMapList", byteArray, emptyMap, new a(callback, this), this.getSource(), 0, 128, null);
            }
        });
    }

    public ZootopiaMapListService(int i3) {
        this.source = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.currPage = 1;
    }

    public /* synthetic */ ZootopiaMapListService(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3);
    }
}
