package com.tencent.mobileqq.zootopia.service;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaMapComment;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapTab;
import com.tencent.sqshow.zootopia.data.ZootopiaUserData;
import com.tencent.sqshow.zootopia.data.ZootopiaVersionData;
import com.tencent.sqshow.zootopia.data.ZootopiaVersionUpdateInfo;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import pv4.y;
import qv4.ao;
import qv4.as;
import qv4.bt;
import qv4.bu;
import qv4.o;
import qv4.p;
import qv4.q;
import qv4.r;
import zb3.ZootopiaMapCommentResp;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 62\u00020\u0001:\u0001-B\u000f\u0012\u0006\u00101\u001a\u00020(\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J%\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\nH\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010'\u001a\u0004\u0018\u00010&2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u001c\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0$J$\u0010,\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$R\u0017\u00101\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010.\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lqv4/p;", "rsp", "Lzb3/h;", tl.h.F, "Lqv4/ao;", "mapInfoDetail", "", "Lqv4/as;", "tabList", "Lcom/tencent/sqshow/zootopia/data/m;", "l", "(Lqv4/ao;[Lqv4/as;)Lcom/tencent/sqshow/zootopia/data/m;", "", "labels", "", "o", "([Ljava/lang/String;)Ljava/util/List;", "photos", DomainData.DOMAIN_NAME, "Lqv4/bt;", "verDesList", "Lcom/tencent/sqshow/zootopia/data/ab;", "p", "tabInfos", "Lcom/tencent/sqshow/zootopia/data/n;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "([Lqv4/as;)Ljava/util/List;", "Lqv4/f;", "commentInfos", "Lcom/tencent/sqshow/zootopia/data/l;", "k", "([Lqv4/f;)Ljava/util/List;", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "Lcom/tencent/mobileqq/app/QQAppInterface;", "f", "", "mapId", "j", "count", "i", "a", "I", "g", "()I", "source", "b", "commentPage", "<init>", "(I)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaMapDetailService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int commentPage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements td3.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZootopiaMapCommentResp> f329135b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f329136c;

        b(com.tencent.mobileqq.zootopia.api.e<ZootopiaMapCommentResp> eVar, int i3) {
            this.f329135b = eVar;
            this.f329136c = i3;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaMapDetailService", 1, "loadMapComments mapId: " + this.f329136c + " -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f329135b.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                QLog.e("ZootopiaMapDetailService", 1, "loadMapComments error! data is null!");
                return;
            }
            ZootopiaMapDetailService zootopiaMapDetailService = ZootopiaMapDetailService.this;
            zootopiaMapDetailService.commentPage++;
            int unused = zootopiaMapDetailService.commentPage;
            try {
                com.tencent.mobileqq.zootopia.api.e<ZootopiaMapCommentResp> eVar = this.f329135b;
                ZootopiaMapDetailService zootopiaMapDetailService2 = ZootopiaMapDetailService.this;
                p c16 = p.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(zootopiaMapDetailService2.h(c16));
            } catch (Exception e16) {
                QLog.e("ZootopiaMapDetailService", 1, "loadMapComments throw e:" + e16.getMessage());
            }
        }
    }

    public ZootopiaMapDetailService(int i3) {
        this.source = i3;
    }

    private final QQAppInterface f(com.tencent.mobileqq.zootopia.api.e<?> callback) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        boolean z16 = waitAppRuntime instanceof QQAppInterface;
        if (!z16) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
        }
        if (z16) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZootopiaMapCommentResp h(p rsp) {
        qv4.f[] fVarArr = rsp.f430191a;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "rsp.commentInfos");
        return new ZootopiaMapCommentResp(k(fVarArr), !rsp.f430192b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        if (r3 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<ZootopiaMapTab> m(as[] tabInfos) {
        List emptyList;
        ArrayList arrayList = new ArrayList();
        for (as asVar : tabInfos) {
            int i3 = asVar.f430001a;
            String str = asVar.f430002b;
            Intrinsics.checkNotNullExpressionValue(str, "it.tabName");
            int i16 = asVar.f430003c;
            String str2 = asVar.f430004d;
            Intrinsics.checkNotNullExpressionValue(str2, "it.url");
            pv4.f[] guideStatusList = asVar.f430005e;
            if (guideStatusList != null) {
                Intrinsics.checkNotNullExpressionValue(guideStatusList, "guideStatusList");
                emptyList = ArraysKt___ArraysKt.toList(guideStatusList);
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            ZootopiaMapTab zootopiaMapTab = new ZootopiaMapTab(i3, str, i16, str2, emptyList);
            if (zootopiaMapTab.i()) {
                arrayList.add(zootopiaMapTab);
            }
        }
        return arrayList;
    }

    private final List<String> n(String[] photos) {
        ArrayList arrayList = new ArrayList();
        for (String str : photos) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private final List<String> o(String[] labels) {
        ArrayList arrayList = new ArrayList();
        for (String str : labels) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private final ZootopiaVersionUpdateInfo p(bt verDesList) {
        String str;
        ArrayList arrayList = new ArrayList();
        bu[] buVarArr = verDesList.f430122f;
        Intrinsics.checkNotNullExpressionValue(buVarArr, "verDesList.versionDes");
        for (bu buVar : buVarArr) {
            arrayList.add(new ZootopiaVersionData(buVar.f430124a, buVar.f430125b));
        }
        String str2 = verDesList.f430118b;
        if (TextUtils.isEmpty(verDesList.f430119c)) {
            str = "\u4e0a\u4f20\u8005";
        } else {
            str = verDesList.f430119c;
        }
        String str3 = str;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = BaseApplication.getContext().getString(R.string.xkk);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026topia_version_upload_map)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(verDesList.f430120d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return new ZootopiaVersionUpdateInfo(new ZootopiaUserData(str2, str3, format, null, false, 24, null), verDesList.f430121e, arrayList);
    }

    /* renamed from: g, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public final void i(int mapId, int count, com.tencent.mobileqq.zootopia.api.e<ZootopiaMapCommentResp> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQAppInterface f16 = f(callback);
        if (f16 == null) {
            return;
        }
        o oVar = new o();
        oVar.f430188a = mapId;
        oVar.f430189b = this.commentPage;
        oVar.f430190c = count;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(oVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, f16, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetMapComment", byteArray, emptyMap, new b(callback, mapId), this.source, 0, 128, null);
    }

    public final void j(final int mapId, final com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final QQAppInterface f16 = f(callback);
        if (f16 == null) {
            return;
        }
        QLog.i("ZootopiaMapDetailService", 1, "loadMapDetail mapId:" + mapId);
        ZootopiaDownloadManager.f327992a.c0(String.valueOf(mapId), new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.service.ZootopiaMapDetailService$loadMapDetail$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService$loadMapDetail$1$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements td3.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f329137a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> f329138b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ ZootopiaMapDetailService f329139c;

                a(int i3, com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> eVar, ZootopiaMapDetailService zootopiaMapDetailService) {
                    this.f329137a = i3;
                    this.f329138b = eVar;
                    this.f329139c = zootopiaMapDetailService;
                }

                @Override // td3.a
                public void a(Integer errCode, String errMsg) {
                    QLog.e("ZootopiaMapDetailService", 1, "loadMapDetail mapId:" + this.f329137a + " -- errCode:" + errCode + ", errMsg:" + errMsg);
                    this.f329138b.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
                }

                @Override // td3.a
                public void onReceive(byte[] data) {
                    ZootopiaMapDetail l3;
                    y yVar;
                    y yVar2;
                    try {
                        r c16 = r.c(data);
                        int i3 = this.f329137a;
                        ao aoVar = c16.f430194a;
                        Integer valueOf = (aoVar == null || (yVar2 = aoVar.f429967s) == null) ? null : Integer.valueOf(yVar2.f427736i);
                        ao aoVar2 = c16.f430194a;
                        QLog.i("ZootopiaMapDetailService", 1, "loadMapDetail mapId:" + i3 + ", mapStatus = " + valueOf + ", nowMapVer = " + ((aoVar2 == null || (yVar = aoVar2.f429967s) == null) ? null : yVar.f427731d) + ", name = " + (aoVar2 != null ? aoVar2.f429952d : null));
                        ZootopiaMapStatusManager zootopiaMapStatusManager = ZootopiaMapStatusManager.f370743d;
                        String valueOf2 = String.valueOf(this.f329137a);
                        y yVar3 = c16.f430194a.f429967s;
                        Intrinsics.checkNotNullExpressionValue(yVar3, "rsp.mapInfo.verControlInfo");
                        zootopiaMapStatusManager.e(valueOf2, yVar3);
                        com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> eVar = this.f329138b;
                        ZootopiaMapDetailService zootopiaMapDetailService = this.f329139c;
                        ao aoVar3 = c16.f430194a;
                        Intrinsics.checkNotNullExpressionValue(aoVar3, "rsp.mapInfo");
                        as[] asVarArr = c16.f430195b;
                        Intrinsics.checkNotNullExpressionValue(asVarArr, "rsp.tabList");
                        l3 = zootopiaMapDetailService.l(aoVar3, asVarArr);
                        eVar.onResultSuccess(l3);
                        this.f329139c.q();
                    } catch (Exception e16) {
                        QLog.e("ZootopiaMapDetailService", 1, "loadMapDetail throw e:" + e16.getMessage());
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                invoke2(zootopiaResData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaResData zootopiaResData) {
                Map emptyMap;
                q qVar = new q();
                qVar.f430193a = ZootopiaMapListService.INSTANCE.a(mapId, zootopiaResData);
                QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
                QQAppInterface qQAppInterface = QQAppInterface.this;
                byte[] byteArray = MessageNano.toByteArray(qVar);
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
                emptyMap = MapsKt__MapsKt.emptyMap();
                IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, qQAppInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetMapInfo", byteArray, emptyMap, new a(mapId, callback, this), this.getSource(), 0, 128, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        this.commentPage = 0;
    }

    private final List<ZootopiaMapComment> k(qv4.f[] commentInfos) {
        String str;
        qv4.f[] fVarArr = commentInfos;
        ArrayList arrayList = new ArrayList();
        int length = fVarArr.length;
        int i3 = 0;
        while (i3 < length) {
            qv4.f fVar = fVarArr[i3];
            String str2 = fVar.f430134a;
            Intrinsics.checkNotNullExpressionValue(str2, "it.commentID");
            String str3 = fVar.f430140g;
            Intrinsics.checkNotNullExpressionValue(str3, "it.content");
            long j3 = fVar.f430139f;
            String str4 = fVar.f430136c;
            if (TextUtils.isEmpty(fVar.f430137d)) {
                str = "\u6e38\u5ba2";
            } else {
                str = fVar.f430137d;
            }
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ZootopiaMapComment(str2, str3, j3, new ZootopiaUserData(str4, str, new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT).format(Long.valueOf(fVar.f430139f * 1000)), fVar.f430138e, false)));
            i3++;
            arrayList = arrayList2;
            length = length;
            fVarArr = commentInfos;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZootopiaMapDetail l(ao mapInfoDetail, as[] tabList) {
        int i3 = mapInfoDetail.f429949a;
        int i16 = mapInfoDetail.f429950b;
        String typeStr = mapInfoDetail.f429951c;
        String name = mapInfoDetail.f429952d;
        String desc = mapInfoDetail.f429953e;
        String descDetail = mapInfoDetail.f429954f;
        String background = mapInfoDetail.f429955g;
        int i17 = mapInfoDetail.f429956h;
        String[] strArr = mapInfoDetail.f429957i;
        Intrinsics.checkNotNullExpressionValue(strArr, "mapInfoDetail.labels");
        List<String> o16 = o(strArr);
        String button = mapInfoDetail.f429958j;
        int i18 = mapInfoDetail.f429959k;
        String[] strArr2 = mapInfoDetail.f429960l;
        Intrinsics.checkNotNullExpressionValue(strArr2, "mapInfoDetail.photos");
        List<String> n3 = n(strArr2);
        int i19 = mapInfoDetail.f429961m;
        int i26 = mapInfoDetail.f429962n;
        bt btVar = mapInfoDetail.f429963o;
        Intrinsics.checkNotNullExpressionValue(btVar, "mapInfoDetail.verDesList");
        ZootopiaVersionUpdateInfo p16 = p(btVar);
        long j3 = mapInfoDetail.f429964p;
        long j16 = mapInfoDetail.f429965q;
        float f16 = mapInfoDetail.f429966r;
        if (f16 == 0.0f) {
            f16 = 1.0f;
        }
        float f17 = f16;
        long j17 = mapInfoDetail.f429968t;
        long j18 = mapInfoDetail.f429969u;
        qv4.f[] fVarArr = mapInfoDetail.f429970v;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "mapInfoDetail.commentInfos");
        List<ZootopiaMapComment> k3 = k(fVarArr);
        String barPic = mapInfoDetail.f429971w;
        int i27 = mapInfoDetail.f429972z;
        boolean z16 = mapInfoDetail.E;
        y yVar = mapInfoDetail.f429967s;
        int i28 = yVar.f427729b;
        int i29 = yVar.f427730c;
        int i36 = yVar.f427736i;
        ZPlanModVersionSimpleData.Companion companion = ZPlanModVersionSimpleData.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(yVar, "mapInfoDetail.verControlInfo");
        ZPlanModVersionSimpleData b16 = companion.b(yVar);
        String mapProjName = mapInfoDetail.A;
        String typeIcon = mapInfoDetail.B;
        String backColor = mapInfoDetail.C;
        String videoUrl = mapInfoDetail.D;
        List<ZootopiaMapTab> m3 = m(tabList);
        pv4.j jVar = mapInfoDetail.F;
        String str = mapInfoDetail.G;
        ZootopiaMapLoadingParams a16 = ZootopiaMapLoadingParams.INSTANCE.a(mapInfoDetail.H);
        ZPlanCloudGameInfo b17 = ZPlanCloudGameInfo.INSTANCE.b(mapInfoDetail.f429967s.f427741n);
        ZPlanMapDiffPatchInfo.Companion companion2 = ZPlanMapDiffPatchInfo.INSTANCE;
        y yVar2 = mapInfoDetail.f429967s;
        ZPlanMapDiffPatchInfo b18 = companion2.b(yVar2 != null ? yVar2.f427742o : null);
        Intrinsics.checkNotNullExpressionValue(name, "name");
        Intrinsics.checkNotNullExpressionValue(desc, "desc");
        Intrinsics.checkNotNullExpressionValue(descDetail, "descDetail");
        Intrinsics.checkNotNullExpressionValue(barPic, "barPic");
        Intrinsics.checkNotNullExpressionValue(typeStr, "typeStr");
        Intrinsics.checkNotNullExpressionValue(button, "button");
        Intrinsics.checkNotNullExpressionValue(background, "background");
        Intrinsics.checkNotNullExpressionValue(mapProjName, "mapProjName");
        Intrinsics.checkNotNullExpressionValue(typeIcon, "typeIcon");
        Intrinsics.checkNotNullExpressionValue(backColor, "backColor");
        Intrinsics.checkNotNullExpressionValue(videoUrl, "videoUrl");
        return new ZootopiaMapDetail(i3, name, desc, descDetail, barPic, i16, typeStr, button, o16, background, i17, b16, j16, f17, i18, i26, j3, n3, i19, j17, j18, p16, k3, i27, z16, i28, i29, mapProjName, typeIcon, backColor, videoUrl, false, m3, jVar, str, b17, i36, a16, b18, Integer.MIN_VALUE, 0, null);
    }
}
