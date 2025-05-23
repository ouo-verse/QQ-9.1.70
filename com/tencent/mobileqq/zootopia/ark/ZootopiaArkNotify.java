package com.tencent.mobileqq.zootopia.ark;

import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.helper.SmallHomeHelper;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapListService;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import com.tencent.sqshow.zootopia.mapstatus.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import pv4.y;
import qv4.v;
import si3.c;
import yb4.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J8\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u001a\u0010#\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0012\u0010$\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J&\u0010(\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010*\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010-\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.H\u0016R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ark/ZootopiaArkNotify;", "Lcom/tencent/mobileqq/ark/module/g;", "Lcom/tencent/sqshow/zootopia/mapstatus/a;", "", "params", "", "v", "", "mapId", "l", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "localResData", "g", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "status", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sceneType", "Lorg/json/JSONObject;", "extInfo", IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, "", "", "p", "action", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "i", DomainData.DOMAIN_NAME, "source", "k", "", ReportConstant.COSTREPORT_PREFIX, "r", "jumpFrom", "o", "u", "appID", "event", "data", "e", "progress", "t", "appName", AdMetricTag.EVENT_NAME, "notify", "Lcom/tencent/sqshow/zootopia/mapstatus/b;", "result", "r1", "Ljava/util/concurrent/ConcurrentHashMap;", "Lqv4/v;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "localVerCache", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaArkNotify implements com.tencent.mobileqq.ark.module.g, com.tencent.sqshow.zootopia.mapstatus.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Integer, v> localVerCache = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f327916a;

        static {
            int[] iArr = new int[MapStatus.values().length];
            try {
                iArr[MapStatus.MAP_STATUS_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_WAITING_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_UNZIPPING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_NEED_UPDATE_QQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_HIGHER_QQ_VERSION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_UPDATE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_DOWNLOAD_INTERRUPT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_DOWNLOAD_FAILED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_OFF_SHELF.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_DEPRESS_FAILED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f327916a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/ark/ZootopiaArkNotify$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/v;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<v> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f327918e;

        c(int i3) {
            this.f327918e = i3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(v result) {
            Intrinsics.checkNotNullParameter(result, "result");
            y[] yVarArr = result.f430204a;
            if (yVarArr != null) {
                Intrinsics.checkNotNullExpressionValue(yVarArr, "result.verControlInfos");
                if (!(yVarArr.length == 0)) {
                    ZootopiaArkNotify.this.localVerCache.put(Integer.valueOf(this.f327918e), result);
                }
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZootopiaArkNotify", 2, "errorCode:" + error + ", message:" + message);
        }
    }

    private final void e(final String appID, final String event, final String data) {
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(appID, new Runnable() { // from class: com.tencent.mobileqq.zootopia.ark.f
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaArkNotify.f(appID, event, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, String str2, String str3) {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify(str, "", str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int mapId, ZootopiaResData localResData) {
        ZootopiaMapStatusManager.f370743d.g(String.valueOf(mapId), this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ZootopiaMapListService.INSTANCE.a(mapId, localResData));
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        m.d(new m(), appInterface, arrayList, 0, new c(mapId), 4, null);
    }

    private final int h(MapStatus status) {
        switch (b.f327916a[status.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            case 6:
                return 7;
            case 7:
                return 10;
            case 8:
                return 9;
            case 9:
                return 8;
            case 10:
            case 11:
                return 4;
            case 12:
                return 11;
            case 13:
                return 6;
            default:
                return -1;
        }
    }

    private final void i(final int mapId) {
        ZootopiaMapStatusManager.f370743d.g(String.valueOf(mapId), this);
        ZootopiaDownloadManager.f327992a.c0(String.valueOf(mapId), new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.ark.ZootopiaArkNotify$doDownLoadFromNetWork$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/ark/ZootopiaArkNotify$doDownLoadFromNetWork$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/v;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements com.tencent.mobileqq.zootopia.api.e<v> {
                a() {
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(v result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ZootopiaDownloadParams b16 = com.tencent.mobileqq.zootopia.download.c.b(com.tencent.mobileqq.zootopia.download.c.f328029a, result, false, false, false, 14, null);
                    if (b16 != null) {
                        ZootopiaDownloadManager.M0(ZootopiaDownloadManager.f327992a, b16, false, null, false, 14, null);
                    }
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    QLog.e("ZootopiaArkNotify", 1, "startDownload  error:" + error + ", message:" + message);
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
                ArrayList arrayList = new ArrayList();
                arrayList.add(ZootopiaMapListService.INSTANCE.a(mapId, zootopiaResData));
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
                if (appInterface == null) {
                    return;
                }
                m.d(new m(), appInterface, arrayList, 0, new a(), 4, null);
            }
        });
    }

    private final void j(int mapId) {
        ZootopiaDownloadParams b16;
        if (this.localVerCache.containsKey(Integer.valueOf(mapId))) {
            v vVar = this.localVerCache.get(Integer.valueOf(mapId));
            if (vVar == null || (b16 = com.tencent.mobileqq.zootopia.download.c.b(com.tencent.mobileqq.zootopia.download.c.f328029a, vVar, false, false, false, 14, null)) == null) {
                return;
            }
            ZootopiaDownloadManager.M0(ZootopiaDownloadManager.f327992a, b16, false, null, false, 14, null);
            return;
        }
        i(mapId);
    }

    private final void k(int mapId, String gameTeamParams, String source) {
        Map mapOf;
        si3.c cVar = (si3.c) vb3.a.f441346a.a(si3.c.class);
        ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Ark, source, null, 4, null);
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, gameTeamParams));
        c.a.a(cVar, mapId, d16, mapOf, null, 8, null);
    }

    private final void l(final int mapId) {
        ZootopiaDownloadManager.f327992a.c0(String.valueOf(mapId), new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.ark.ZootopiaArkNotify$doRealQueryDownloadStatus$1
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
                ZootopiaArkNotify.this.g(mapId, zootopiaResData);
            }
        });
    }

    private final void n(String params) {
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaArkNotify", 2, "enterGame  params: " + params);
        }
        if (params != null) {
            try {
                JSONObject jSONObject = new JSONObject(params);
                int optInt = jSONObject.optInt(IZootopiaShareArkService.ARK_MAP_ID);
                String gameTeamParams = jSONObject.optString(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS);
                int optInt2 = jSONObject.optInt("sceneType");
                JSONObject optJSONObject = jSONObject.optJSONObject("extInfo");
                String jumpFrom = jSONObject.optString("jumpFrom");
                if (!s(optInt, optInt2) && !r(optInt, optInt2)) {
                    Intrinsics.checkNotNullExpressionValue(gameTeamParams, "gameTeamParams");
                    Intrinsics.checkNotNullExpressionValue(jumpFrom, "jumpFrom");
                    k(optInt, gameTeamParams, jumpFrom);
                }
                Intrinsics.checkNotNullExpressionValue(jumpFrom, "jumpFrom");
                o(optJSONObject, jumpFrom);
            } catch (Throwable th5) {
                QLog.d("ZootopiaArkNotify", 1, th5, new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, Object> p(int mapId, int sceneType, JSONObject extInfo, String gameTeamParams) {
        String optString;
        boolean z16;
        boolean isBlank;
        HashMap hashMap = new HashMap();
        if (!s(mapId, sceneType) && !r(mapId, sceneType)) {
            if (gameTeamParams != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(gameTeamParams);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        hashMap.put(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, gameTeamParams);
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        } else if (extInfo != null && (optString = extInfo.optString("visitUin")) != null) {
            hashMap.putAll(SmallHomeHelper.f328312a.a("3", optString));
        }
        return hashMap;
    }

    private final boolean r(int mapId, int sceneType) {
        if (mapId != 200001 || sceneType != 3) {
            return false;
        }
        return true;
    }

    private final boolean s(int mapId, int sceneType) {
        if (mapId != 200001 || sceneType != 2) {
            return false;
        }
        return true;
    }

    private final void t(int status, int progress, int mapId) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        jSONObject.put("progress", progress);
        jSONObject.put(IZootopiaShareArkService.ARK_MAP_ID, mapId);
        e(IZootopiaShareArkService.ZOOTOPIA_ARK_NAME, "game_download_status_result", jSONObject.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0068, code lost:
    
        r13 = r1.getString("visitUin");
     */
    /* JADX WARN: Type inference failed for: r13v7, types: [T, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.util.HashMap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(String params) {
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaArkNotify", 2, "openDetailPage  params: " + params);
        }
        if (params != null) {
            try {
                JSONObject jSONObject = new JSONObject(params);
                int optInt = jSONObject.optInt(IZootopiaShareArkService.ARK_MAP_ID);
                String gameTeamParams = jSONObject.optString(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS);
                int optInt2 = jSONObject.optInt("sceneType");
                JSONObject optJSONObject = jSONObject.optJSONObject("extInfo");
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new HashMap();
                if (!s(optInt, optInt2) && !r(optInt, optInt2)) {
                    Map map = (Map) objectRef.element;
                    Intrinsics.checkNotNullExpressionValue(gameTeamParams, "gameTeamParams");
                    map.put(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, gameTeamParams);
                    ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Ark, ZootopiaSource.SUB_SOURCE_ARK_GAME, null, 4, null);
                    ((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class)).T(optInt, true, d16, (Map) objectRef.element, new ZootopiaArkNotify$openDetailPage$1$1(optInt, d16, objectRef));
                }
                String str = null;
                Map<String, Object> a16 = SmallHomeHelper.f328312a.a("3", str);
                Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
                objectRef.element = (HashMap) a16;
                ZootopiaSource d162 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Ark, ZootopiaSource.SUB_SOURCE_ARK_GAME, null, 4, null);
                ((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class)).T(optInt, true, d162, (Map) objectRef.element, new ZootopiaArkNotify$openDetailPage$1$1(optInt, d162, objectRef));
            } catch (Throwable th5) {
                QLog.d("ZootopiaArkNotify", 1, th5, new Object[0]);
            }
        }
    }

    private final void v(String params) {
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaArkNotify", 2, "queryDownloadStatus  params: " + params);
        }
        if (params != null) {
            try {
                l(new JSONObject(params).optInt(IZootopiaShareArkService.ARK_MAP_ID));
            } catch (Throwable th5) {
                QLog.e("ZootopiaArkNotify", 1, th5, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.ark.module.g
    public boolean notify(String appName, String eventName, String params) {
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaArkNotify", 2, "notify --->  appName: " + appName + ", eventName: " + eventName + ", params: " + params);
        }
        if (!TextUtils.equals(appName, IZootopiaShareArkService.ZOOTOPIA_ARK_NAME) || eventName == null) {
            return true;
        }
        switch (eventName.hashCode()) {
            case -818772743:
                if (!eventName.equals("enter_game")) {
                    return true;
                }
                n(params);
                return true;
            case 31478089:
                if (!eventName.equals("download_game")) {
                    return true;
                }
                m(params);
                return true;
            case 1848518739:
                if (!eventName.equals("query_game_download_status")) {
                    return true;
                }
                v(params);
                return true;
            case 2023963337:
                if (!eventName.equals("open_game_detail")) {
                    return true;
                }
                u(params);
                return true;
            default:
                return true;
        }
    }

    @Override // com.tencent.sqshow.zootopia.mapstatus.a
    public void r1(com.tencent.sqshow.zootopia.mapstatus.b result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String mapId = result.getMapId();
        b.MapStatusResult c16 = result.c();
        MapStatus mapStatus = c16.getMapStatus();
        try {
            t(h(mapStatus), b.f327916a[mapStatus.ordinal()] == 6 ? 100 : MathKt__MathJVMKt.roundToInt(c16.getProgress() * 99), Integer.parseInt(mapId));
        } catch (Exception e16) {
            QLog.e("ZootopiaArkNotify", 1, "onStateChangeWithErrorCode notifyDownloadStatus error mapId:" + mapId + " e:" + e16.getMessage());
        }
    }

    private final void o(JSONObject extInfo, String jumpFrom) {
        if (extInfo != null) {
            try {
                c.a.a((si3.c) vb3.a.f441346a.a(si3.c.class), AdMetricID.Click.SUCCESS, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Ark, jumpFrom, null, 4, null), SmallHomeHelper.f328312a.a("3", extInfo.getString("visitUin")), null, 8, null);
            } catch (Throwable th5) {
                QLog.d("ZootopiaArkNotify", 2, th5, new Object[0]);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.Map] */
    private final void m(String params) {
        QLog.i("ZootopiaArkNotify", 1, "downloadGame  params: " + params);
        if (params != null) {
            try {
                JSONObject jSONObject = new JSONObject(params);
                final int optInt = jSONObject.optInt("action");
                final int optInt2 = jSONObject.optInt(IZootopiaShareArkService.ARK_MAP_ID);
                String optString = jSONObject.optString(IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS);
                int optInt3 = jSONObject.optInt("sceneType");
                JSONObject optJSONObject = jSONObject.optJSONObject("extInfo");
                String jumpFrom = jSONObject.optString("jumpFrom");
                if (optInt == 1 && !com.tencent.mobileqq.zootopia.utils.m.f329564a.c()) {
                    ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                    Source source = Source.Ark;
                    Intrinsics.checkNotNullExpressionValue(jumpFrom, "jumpFrom");
                    final ZootopiaSource d16 = ZootopiaSource.Companion.d(companion, source, jumpFrom, null, 4, null);
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = p(optInt2, optInt3, optJSONObject, optString);
                    ZootopiaDownloadManager.f327992a.c0(String.valueOf(optInt2), new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.ark.ZootopiaArkNotify$downloadGame$1$1
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
                            if (zootopiaResData != null && zootopiaResData.getDownloadStatus() != 0) {
                                this.q(optInt2, optInt);
                                return;
                            }
                            com.tencent.mobileqq.zplan.cloudmod.api.a aVar = (com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class);
                            final int i3 = optInt2;
                            ZootopiaSource zootopiaSource = d16;
                            Map<String, ? extends Object> map = (Map) objectRef.element;
                            final ZootopiaArkNotify zootopiaArkNotify = this;
                            final int i16 = optInt;
                            aVar.T(i3, true, zootopiaSource, map, new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.ark.ZootopiaArkNotify$downloadGame$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                                    invoke2(enterModCheckResult);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(EnterModCheckResult result) {
                                    Intrinsics.checkNotNullParameter(result, "result");
                                    if (result.isPassed()) {
                                        return;
                                    }
                                    ZootopiaArkNotify.this.q(i3, i16);
                                }
                            });
                        }
                    });
                } else {
                    q(optInt2, optInt);
                }
            } catch (Throwable th5) {
                QLog.d("ZootopiaArkNotify", 1, th5, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int mapId, int action) {
        if (action == 1) {
            j(mapId);
            return;
        }
        if (action == 2) {
            ZootopiaDownloadManager.y0(ZootopiaDownloadManager.f327992a, String.valueOf(mapId), false, 2, null);
            return;
        }
        if (action != 3) {
            return;
        }
        com.tencent.mobileqq.zootopia.utils.k kVar = new com.tencent.mobileqq.zootopia.utils.k();
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            com.tencent.mobileqq.zootopia.utils.k.e(kVar, qBaseActivity, null, 2, null);
        }
    }
}
