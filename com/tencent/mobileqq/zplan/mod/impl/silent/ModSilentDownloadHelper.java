package com.tencent.mobileqq.zplan.mod.impl.silent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import ck3.ZPlanModReqInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager;
import com.tencent.mobileqq.zootopia.mapstatus.ZootopiaMapStatusService;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapListService;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.mobileqq.zplan.push.i;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import com.tencent.sqshow.zootopia.utils.ag;
import gw4.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import pv4.y;
import qv4.aq;
import qv4.ar;
import qv4.bs;
import qv4.g;
import qv4.v;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0007*\u0003?CG\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bK\u0010LJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J*\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J,\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J \u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001eH\u0002J*\u0010#\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002J\"\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0002H\u0002J\u0010\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0002H\u0002R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper;", "", "", "sceneName", "", "forceRefresh", "", UserInfo.SEX_FEMALE, "isAfterPortalLoading", "forceDownload", "", "mapId", "isPlayDownloadTogether", "G", "w", "p", "onlyReserved", "I", "Lqv4/ar;", "mapSilentDownloadRsp", "Lqv4/v;", "u", "mapVerStatusRsp", "isNewRequest", "needNotification", "v", "finalMapVerStatusRsp", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "downloadData", "t", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "D", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "mapStatus", "o", "mapStatusInfoResult", "B", "E", "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, BdhLogUtil.LogTag.Tag_Conn, "logMsg", "y", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService;", "b", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService;", "mapStatusService", "c", "Lqv4/ar;", "silentDownloadModRspCache", "d", "Z", "isRequesting", "", "e", "J", "lastRequestTimeStamp", "com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$c", "f", "Lcom/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$c;", "oidbPushObserver", "com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$b", "g", "Lcom/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$b;", "netChangeReceiver", "com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$screenLockReceiver$1", h.F, "Lcom/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$screenLockReceiver$1;", "screenLockReceiver", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModSilentDownloadHelper {

    /* renamed from: a */
    public static final ModSilentDownloadHelper f334775a;

    /* renamed from: b, reason: from kotlin metadata */
    private static final ZootopiaMapStatusService mapStatusService;

    /* renamed from: c, reason: from kotlin metadata */
    private static ar silentDownloadModRspCache;

    /* renamed from: d, reason: from kotlin metadata */
    private static boolean isRequesting;

    /* renamed from: e, reason: from kotlin metadata */
    private static long lastRequestTimeStamp;

    /* renamed from: f, reason: from kotlin metadata */
    private static final c oidbPushObserver;

    /* renamed from: g, reason: from kotlin metadata */
    private static final b netChangeReceiver;

    /* renamed from: h */
    private static final ModSilentDownloadHelper$screenLockReceiver$1 screenLockReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements e<ZootopiaMapStatusService.MapStatusInfoResult> {

        /* renamed from: d */
        final /* synthetic */ int f334783d;

        /* renamed from: e */
        final /* synthetic */ boolean f334784e;

        a(int i3, boolean z16) {
            this.f334783d = i3;
            this.f334784e = z16;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a */
        public void onResultSuccess(ZootopiaMapStatusService.MapStatusInfoResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ModSilentDownloadHelper.A(ModSilentDownloadHelper.f334775a, this.f334783d, result, this.f334784e, false, 8, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ModSilentDownloadHelper.f334775a.x("finalHandleSingleReserveSilentDownloadAfterLimitCheck#onResultFailure - " + error + "-" + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$b", "Lcom/tencent/mobileqq/zootopia/download/ui/b;", "", "p0", "", "onNetNone2Wifi", "onNetMobile2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.zootopia.download.ui.b {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String p06) {
            ModSilentDownloadHelper modSilentDownloadHelper = ModSilentDownloadHelper.f334775a;
            modSilentDownloadHelper.y("netChangeReceiver# onNetMobile2Wifi - " + p06);
            modSilentDownloadHelper.F("onNetMobile2Wifi", false);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String p06) {
            ModSilentDownloadHelper modSilentDownloadHelper = ModSilentDownloadHelper.f334775a;
            modSilentDownloadHelper.y("netChangeReceiver# onNetNone2Wifi - " + p06);
            modSilentDownloadHelper.F("onNetNone2Wifi", false);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String p06) {
            ModSilentDownloadHelper.f334775a.y("netChangeReceiver# onNetWifi2Mobile - " + p06);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            ModSilentDownloadHelper.f334775a.y("netChangeReceiver# onNetWifi2None");
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper$screenLockReceiver$1] */
    static {
        ModSilentDownloadHelper modSilentDownloadHelper = new ModSilentDownloadHelper();
        f334775a = modSilentDownloadHelper;
        mapStatusService = new ZootopiaMapStatusService();
        c cVar = new c();
        oidbPushObserver = cVar;
        b bVar = new b();
        netChangeReceiver = bVar;
        screenLockReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper$screenLockReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent != null ? intent.getAction() : null;
                if (Intrinsics.areEqual(action, IECScreenReceiver.ACTION_SCREEN_ON) || Intrinsics.areEqual(action, IECScreenReceiver.ACTION_SCREEN_OFF)) {
                    ModSilentDownloadHelper modSilentDownloadHelper2 = ModSilentDownloadHelper.f334775a;
                    modSilentDownloadHelper2.y("screenLockReceiver - " + action);
                    modSilentDownloadHelper2.F(action, false);
                }
            }
        };
        QLog.i("ModSilentDownloadHelper", 1, "init###", new Throwable());
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        if (a16 != null) {
            a16.F2(cVar);
        }
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.context, bVar);
        modSilentDownloadHelper.C();
    }

    ModSilentDownloadHelper() {
    }

    private final void C() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        BaseApplication.context.registerReceiver(screenLockReceiver, intentFilter);
    }

    public final void D(boolean forceRefresh, final e<ar> callback) {
        int R1 = ZPlanFeatureSwitch.f369852a.R1();
        long max = Math.max(1, R1) * 60 * 60 * 1000;
        if (!forceRefresh && silentDownloadModRspCache != null && lastRequestTimeStamp > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = lastRequestTimeStamp;
            if (currentTimeMillis - j3 <= max) {
                y("requestSilentDownloadRsp, use cache, lastRequestTimeStamp= " + j3 + ", validHours= " + R1);
                if (callback != null) {
                    ar arVar = silentDownloadModRspCache;
                    Intrinsics.checkNotNull(arVar);
                    callback.onResultSuccess(arVar);
                    return;
                }
                return;
            }
        }
        y("requestSilentDownloadRsp#BEGIN, isRequesting= " + isRequesting + ", forceRefresh= " + forceRefresh + ", validHours= " + R1);
        if (isRequesting && !forceRefresh) {
            x("requestSilentDownloadRsp isRequesting");
            if (callback != null) {
                callback.onResultFailure(-9000, "pre requesting");
                return;
            }
            return;
        }
        isRequesting = true;
        ZootopiaDownloadManager.f327992a.W(new Function1<List<? extends ZootopiaResData>, Unit>() { // from class: com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper$requestSilentDownloadRsp$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$requestSilentDownloadRsp$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ar;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements e<ar> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ e<ar> f334793d;

                a(e<ar> eVar) {
                    this.f334793d = eVar;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(ar result) {
                    y[] yVarArr;
                    Intrinsics.checkNotNullParameter(result, "result");
                    ModSilentDownloadHelper modSilentDownloadHelper = ModSilentDownloadHelper.f334775a;
                    int i3 = result.f429999b;
                    v vVar = result.f429998a;
                    modSilentDownloadHelper.y("requestSilentDownloadRsp#onResultSuccess, retCode = " + i3 + ", size = " + ((vVar == null || (yVarArr = vVar.f430204a) == null) ? null : Integer.valueOf(yVarArr.length)) + "");
                    ModSilentDownloadHelper.lastRequestTimeStamp = System.currentTimeMillis();
                    ModSilentDownloadHelper.isRequesting = false;
                    ModSilentDownloadHelper.silentDownloadModRspCache = result;
                    e<ar> eVar = this.f334793d;
                    if (eVar != null) {
                        eVar.onResultSuccess(result);
                    }
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    ModSilentDownloadHelper.f334775a.x("requestSilentDownloadRsp#onResultFailure, " + error + " - " + message);
                    ModSilentDownloadHelper.isRequesting = false;
                    e<ar> eVar = this.f334793d;
                    if (eVar != null) {
                        eVar.onResultFailure(error, message);
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
            public final void invoke2(List<ZootopiaResData> resInfoList) {
                Intrinsics.checkNotNullParameter(resInfoList, "resInfoList");
                Object[] array = ZootopiaMapListService.INSTANCE.b(resInfoList, true).toArray(new bs[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                bs[] bsVarArr = (bs[]) array;
                ModSilentDownloadHelper.f334775a.y("requestSilentDownloadRsp, localDownloadedMaps.size = " + bsVarArr.length);
                wi3.a aVar = wi3.a.f445703a;
                aq aqVar = new aq();
                aqVar.f429997a = bsVarArr;
                wi3.a.b(aVar, aqVar, new a(callback), 0, 4, null);
            }
        });
    }

    public final void E(int mapId, ZootopiaMapStatusService.MapStatusInfoResult result) {
        String str;
        ZootopiaResData resData;
        ZPlanModVersionSimpleData modVersionSimpleData;
        ZootopiaResData resData2;
        ZPlanModVersionSimpleData modVersionSimpleData2;
        y("silentCheckModHotPatch- " + mapId + ", mapStatus= " + result.getMapStatus());
        if (result.getMapStatus() == MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE) {
            ZPlanModHotPatchManager zPlanModHotPatchManager = ZPlanModHotPatchManager.f328077a;
            String valueOf = String.valueOf(mapId);
            ZootopiaDownloadData data = result.getData();
            if (data == null || (resData2 = data.getResData()) == null || (modVersionSimpleData2 = resData2.getModVersionSimpleData()) == null || (str = modVersionSimpleData2.getNowMapVer()) == null) {
                str = "";
            }
            ZootopiaDownloadData data2 = result.getData();
            ZPlanModHotPatchManager.u(zPlanModHotPatchManager, "silentCheck", new ZPlanModReqInfo(valueOf, str, (data2 == null || (resData = data2.getResData()) == null || (modVersionSimpleData = resData.getModVersionSimpleData()) == null) ? 0 : modVersionSimpleData.getPackType()), null, false, false, 28, null);
        }
    }

    private final void I(boolean onlyReserved, boolean forceRefresh) {
        boolean Z;
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        if (onlyReserved) {
            Z = zPlanFeatureSwitch.a0();
        } else {
            Z = zPlanFeatureSwitch.Z();
        }
        if (!Z) {
            y("silentDownloadReserveModIfNecessary- " + onlyReserved + ", but not enabled!!!");
            return;
        }
        D(forceRefresh, new d(onlyReserved));
    }

    public final boolean o(MapStatus mapStatus) {
        return mapStatus == MapStatus.MAP_STATUS_INIT || mapStatus == MapStatus.MAP_STATUS_UPDATE || mapStatus == MapStatus.MAP_STATUS_PAUSE || mapStatus == MapStatus.MAP_STATUS_DOWNLOAD_INTERRUPT || mapStatus == MapStatus.MAP_STATUS_CAN_APPOINTMENT || mapStatus == MapStatus.MAP_STATUS_APPOINTED;
    }

    private final boolean q() {
        if (!ZPlanModHotPatchManager.f328077a.x()) {
            y("enableSilentHotPatch false");
            return false;
        }
        if (m.f329564a.a() != 1) {
            return false;
        }
        y("checkSilentHotPatchEnvValid getNetWorkType = WIFI");
        return true;
    }

    private final boolean r(boolean forceDownload) {
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        boolean K = zPlanFeatureSwitch.K();
        if (!forceDownload && !K) {
            y("enableSilentDownloadXiaowo false");
            return false;
        }
        m mVar = m.f329564a;
        if (mVar.a() == 1) {
            y("getNetWorkType = WIFI");
            return true;
        }
        if (!zPlanFeatureSwitch.L()) {
            y("enableSilentDownloadWhenKingCard false");
            return false;
        }
        if (!(com.tencent.mobileqq.vip.d.d() == 1) || !mVar.c()) {
            return false;
        }
        y("isKingCard true");
        return true;
    }

    private final boolean s(boolean z16) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100337", false)) {
            y("checkSilentWhenCloud :: isSwitchOn = false");
            return false;
        }
        if (!lg3.a.f414537a.c() && !z16) {
            y("checkSilentWhenCloud :: isLaunchedCloudGame = false");
            return false;
        }
        return w();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
    
        r1 = kotlin.collections.ArraysKt___ArraysKt.getIndices(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final v u(int mapId, ar mapSilentDownloadRsp) {
        IntRange indices;
        g gVar;
        y yVar;
        f fVar;
        Object orNull;
        Object orNull2;
        Object orNull3;
        v vVar = mapSilentDownloadRsp.f429998a;
        if (vVar != null && (r1 = vVar.f430204a) != null && indices != null) {
            Iterator<Integer> it = indices.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                g[] downloadExtraInfos = vVar.f430205b;
                if (downloadExtraInfos != null) {
                    Intrinsics.checkNotNullExpressionValue(downloadExtraInfos, "downloadExtraInfos");
                    orNull3 = ArraysKt___ArraysKt.getOrNull(downloadExtraInfos, nextInt);
                    gVar = (g) orNull3;
                } else {
                    gVar = null;
                }
                if (gVar != null && gVar.f430142a == mapId) {
                    y[] verControlInfos = vVar.f430204a;
                    if (verControlInfos != null) {
                        Intrinsics.checkNotNullExpressionValue(verControlInfos, "verControlInfos");
                        orNull2 = ArraysKt___ArraysKt.getOrNull(verControlInfos, nextInt);
                        yVar = (y) orNull2;
                    } else {
                        yVar = null;
                    }
                    f[] checkPhoneResults = vVar.f430206c;
                    if (checkPhoneResults != null) {
                        Intrinsics.checkNotNullExpressionValue(checkPhoneResults, "checkPhoneResults");
                        orNull = ArraysKt___ArraysKt.getOrNull(checkPhoneResults, nextInt);
                        fVar = (f) orNull;
                    } else {
                        fVar = null;
                    }
                    if (yVar != null && fVar != null) {
                        v vVar2 = new v();
                        vVar2.f430204a = new y[]{yVar};
                        vVar2.f430205b = new g[]{gVar};
                        vVar2.f430206c = new f[]{fVar};
                        return vVar2;
                    }
                }
            }
        }
        return null;
    }

    public final void v(final int mapId, final v mapVerStatusRsp, final boolean isNewRequest, final boolean needNotification) {
        if (m.f329564a.a() != 1) {
            x("handleSingleReserveSilentDownload but not WIFI, needNotification= " + needNotification);
            return;
        }
        ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
        if (zootopiaDownloadManager.f0(String.valueOf(mapId))) {
            x("handleSingleReserveSilentDownload hasModManualInterrupted, needNotification= " + needNotification);
            return;
        }
        zootopiaDownloadManager.Y(String.valueOf(mapId), new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper$handleSingleReserveSilentDownload$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$handleSingleReserveSilentDownload$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "mapStatusInfoResult", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements e<ZootopiaMapStatusService.MapStatusInfoResult> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f334786d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f334787e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ ZootopiaDownloadData f334788f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f334789h;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$handleSingleReserveSilentDownload$1$a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ar;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
                /* renamed from: com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper$handleSingleReserveSilentDownload$1$a$a, reason: collision with other inner class name */
                /* loaded from: classes34.dex */
                public static final class C9188a implements e<ar> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f334790d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ZootopiaDownloadData f334791e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f334792f;

                    C9188a(int i3, ZootopiaDownloadData zootopiaDownloadData, boolean z16) {
                        this.f334790d = i3;
                        this.f334791e = zootopiaDownloadData;
                        this.f334792f = z16;
                    }

                    @Override // com.tencent.mobileqq.zootopia.api.e
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onResultSuccess(ar result) {
                        v u16;
                        Intrinsics.checkNotNullParameter(result, "result");
                        ModSilentDownloadHelper modSilentDownloadHelper = ModSilentDownloadHelper.f334775a;
                        modSilentDownloadHelper.y("handleSingleReserveSilentDownload - limitCheck - " + result.f429999b);
                        if (result.f429999b == 0) {
                            u16 = modSilentDownloadHelper.u(this.f334790d, result);
                            modSilentDownloadHelper.t(this.f334790d, u16, this.f334791e, this.f334792f);
                        } else {
                            modSilentDownloadHelper.x("handleSingleReserveSilentDownload - limitCheck max!!!");
                        }
                    }

                    @Override // com.tencent.mobileqq.zootopia.api.e
                    public void onResultFailure(int error, String message) {
                        ModSilentDownloadHelper.f334775a.x("handleSingleReserveSilentDownload - limitCheck#onResultFailure - " + error + "-" + message);
                    }
                }

                a(boolean z16, int i3, ZootopiaDownloadData zootopiaDownloadData, boolean z17) {
                    this.f334786d = z16;
                    this.f334787e = i3;
                    this.f334788f = zootopiaDownloadData;
                    this.f334789h = z17;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(ZootopiaMapStatusService.MapStatusInfoResult mapStatusInfoResult) {
                    boolean o16;
                    Intrinsics.checkNotNullParameter(mapStatusInfoResult, "mapStatusInfoResult");
                    ModSilentDownloadHelper modSilentDownloadHelper = ModSilentDownloadHelper.f334775a;
                    o16 = modSilentDownloadHelper.o(mapStatusInfoResult.getMapStatus());
                    if (o16) {
                        modSilentDownloadHelper.y("handleSingleReserveSilentDownload - limitCheck#START");
                        modSilentDownloadHelper.D(!this.f334786d, new C9188a(this.f334787e, this.f334788f, this.f334789h));
                        return;
                    }
                    modSilentDownloadHelper.x("handleSingleReserveSilentDownload, but status wrong - " + mapStatusInfoResult.getMapStatus());
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    ModSilentDownloadHelper.f334775a.x("handleSingleReserveSilentDownload - onQueryVerSuccess#onResultFailure - " + error + "-" + message);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                ZootopiaMapStatusService zootopiaMapStatusService;
                zootopiaMapStatusService = ModSilentDownloadHelper.mapStatusService;
                zootopiaMapStatusService.b(v.this, zootopiaDownloadData, new a(isNewRequest, mapId, zootopiaDownloadData, needNotification));
            }
        });
    }

    public final void x(String str) {
        QLog.e("ModSilentDownloadHelper", 1, str);
    }

    public final void y(String logMsg) {
        QLog.i("ModSilentDownloadHelper", 1, logMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean z(int i3, ZootopiaMapStatusService.MapStatusInfoResult mapStatusInfoResult, boolean z16, boolean z17) {
        String str;
        Object orNull;
        MapStatus mapStatus = mapStatusInfoResult.getMapStatus();
        g[] gVarArr = mapStatusInfoResult.getMapVerStatusRsp().f430205b;
        if (gVarArr != null) {
            orNull = ArraysKt___ArraysKt.getOrNull(gVarArr, 0);
            g gVar = (g) orNull;
            if (gVar != null) {
                str = gVar.f430145d;
                y("preHandleSilentDownload - " + mapStatus + ", " + str + ", needNotification= " + z16 + ", isPlayDownloadTogether " + z17);
                if (!o(mapStatus)) {
                    com.tencent.sqshow.zootopia.report.a aVar = com.tencent.sqshow.zootopia.report.a.f372690a;
                    ButtonStatus a16 = ButtonStatus.INSTANCE.a(mapStatus);
                    ZootopiaSource b16 = ag.f373258a.b();
                    if (b16 == null) {
                        b16 = ZootopiaSource.INSTANCE.g();
                    }
                    aVar.e(i3, a16, b16, null);
                    B(mapStatusInfoResult, z16, z17);
                    return true;
                }
                y("mapStatus not valid - " + mapStatus);
                return false;
            }
        }
        str = null;
        y("preHandleSilentDownload - " + mapStatus + ", " + str + ", needNotification= " + z16 + ", isPlayDownloadTogether " + z17);
        if (!o(mapStatus)) {
        }
    }

    public final void F(String sceneName, boolean z16) {
        Intrinsics.checkNotNullParameter(sceneName, "sceneName");
        y("silentDownloadModInQQScene, sceneName= " + sceneName + ", forceRefresh= " + z16);
        I(true, z16);
    }

    public final boolean G(boolean isAfterPortalLoading, boolean forceDownload, final int mapId, final boolean isPlayDownloadTogether) {
        y("silentDownloadModInZPlan BEGIN - " + isAfterPortalLoading + ", forceDownload = " + forceDownload + " , mapId == " + mapId + " , isPlayDownloadTogether == " + isPlayDownloadTogether);
        if (isAfterPortalLoading) {
            J(this, false, false, 2, null);
        }
        boolean r16 = r(forceDownload);
        boolean q16 = q();
        if (!r16 && !q16) {
            x("checkEnvValid both false");
            return false;
        }
        final boolean z16 = (r16 && (forceDownload || !ZootopiaDownloadManager.f327992a.f0(String.valueOf(mapId)))) || s(isPlayDownloadTogether);
        final boolean z17 = q16 && ZPlanModHotPatchManager.f328077a.o(String.valueOf(mapId));
        y("silentDownloadModInZPlan, finalSilentCheckMainPak= " + z16 + ", finalSilentCheckHotPatch= " + z17);
        if (!z16 && !z17) {
            return false;
        }
        ZootopiaDownloadManager.f327992a.Y(String.valueOf(mapId), new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper$silentDownloadModInZPlan$1

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$silentDownloadModInZPlan$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements e<ZootopiaMapStatusService.MapStatusInfoResult> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f334794d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f334795e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f334796f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f334797h;

                a(boolean z16, int i3, boolean z17, boolean z18) {
                    this.f334794d = z16;
                    this.f334795e = i3;
                    this.f334796f = z17;
                    this.f334797h = z18;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(ZootopiaMapStatusService.MapStatusInfoResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if ((this.f334794d ? ModSilentDownloadHelper.f334775a.z(this.f334795e, result, false, this.f334796f) : false) || !this.f334797h) {
                        return;
                    }
                    ModSilentDownloadHelper.f334775a.E(this.f334795e, result);
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    ModSilentDownloadHelper.f334775a.x("queryMapVerStatus#onResultFailure - " + error + "-" + message);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                ZootopiaMapStatusService zootopiaMapStatusService;
                zootopiaMapStatusService = ModSilentDownloadHelper.mapStatusService;
                int i3 = mapId;
                zootopiaMapStatusService.c(i3, zootopiaDownloadData, new a(z16, i3, isPlayDownloadTogether, z17));
            }
        });
        return true;
    }

    public final boolean p() {
        return ZPlanFeatureSwitch.f369852a.L() && com.tencent.mobileqq.vip.d.d() == 1;
    }

    public final boolean w() {
        m mVar = m.f329564a;
        if (mVar.a() == 1) {
            y("checkSilentWhenCloud :: getNetWorkType = WIFI");
            return true;
        }
        if (!ZPlanFeatureSwitch.f369852a.L()) {
            y("checkSilentWhenCloud :: enableSilentDownloadWhenKingCard false");
            return false;
        }
        if (!(com.tencent.mobileqq.vip.d.d() == 1) || !mVar.c()) {
            return false;
        }
        y("checkSilentWhenCloud :: isKingCard true");
        return true;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$c", "Lcom/tencent/mobileqq/zplan/push/i;", "", "buf", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends i {
        @Override // com.tencent.mobileqq.zplan.push.i
        public void b(byte[] buf) {
            Intrinsics.checkNotNullParameter(buf, "buf");
            try {
                mv4.e c16 = mv4.e.c(buf);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(buf)");
                ModSilentDownloadHelper modSilentDownloadHelper = ModSilentDownloadHelper.f334775a;
                modSilentDownloadHelper.y("oidbPushObserver, receive push " + c16.f417675a);
                if (c16.f417675a == 8) {
                    modSilentDownloadHelper.F("oidbPush", true);
                }
            } catch (Exception unused) {
                ModSilentDownloadHelper.f334775a.x("oidbPushObserver exception - " + buf);
            }
        }

        c() {
            super(337);
        }
    }

    private final void B(ZootopiaMapStatusService.MapStatusInfoResult mapStatusInfoResult, boolean needNotification, boolean isPlayDownloadTogether) {
        ZootopiaDownloadParams a16 = com.tencent.mobileqq.zootopia.download.c.f328029a.a(mapStatusInfoResult.getMapVerStatusRsp(), !isPlayDownloadTogether, needNotification, isPlayDownloadTogether);
        if (a16 != null && !TextUtils.isEmpty(a16.getUrl())) {
            y("realStartSilentDownload BEGIN!");
            ZootopiaDownloadManager.M0(ZootopiaDownloadManager.f327992a, a16, true, null, false, 12, null);
        } else {
            x("realStartSilentDownload but downloadParams is invalid - " + a16);
        }
    }

    public final void t(int mapId, v finalMapVerStatusRsp, ZootopiaDownloadData downloadData, boolean needNotification) {
        if (finalMapVerStatusRsp == null) {
            x("finalHandleSingleReserveSilentDownloadAfterLimitCheck, empty!!!");
        } else {
            mapStatusService.b(finalMapVerStatusRsp, downloadData, new a(mapId, needNotification));
        }
    }

    static /* synthetic */ boolean A(ModSilentDownloadHelper modSilentDownloadHelper, int i3, ZootopiaMapStatusService.MapStatusInfoResult mapStatusInfoResult, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z17 = false;
        }
        return modSilentDownloadHelper.z(i3, mapStatusInfoResult, z16, z17);
    }

    static /* synthetic */ void J(ModSilentDownloadHelper modSilentDownloadHelper, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        modSilentDownloadHelper.I(z16, z17);
    }

    public static /* synthetic */ boolean H(ModSilentDownloadHelper modSilentDownloadHelper, boolean z16, boolean z17, int i3, boolean z18, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = AdMetricID.Click.SUCCESS;
        }
        if ((i16 & 8) != 0) {
            z18 = false;
        }
        return modSilentDownloadHelper.G(z16, z17, i3, z18);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/silent/ModSilentDownloadHelper$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ar;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements e<ar> {

        /* renamed from: d */
        final /* synthetic */ boolean f334785d;

        d(boolean z16) {
            this.f334785d = z16;
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            r5 = kotlin.collections.ArraysKt___ArraysKt.getIndices(r5);
         */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResultSuccess(ar result) {
            IntRange indices;
            y yVar;
            g gVar;
            f fVar;
            Object orNull;
            Object orNull2;
            Object orNull3;
            g gVar2;
            Object firstOrNull;
            y[] yVarArr;
            y[] yVarArr2;
            int i3;
            Intrinsics.checkNotNullParameter(result, "result");
            boolean z16 = System.currentTimeMillis() - ModSilentDownloadHelper.lastRequestTimeStamp <= 1000;
            if (z16 && (i3 = result.f429999b) != 0) {
                ModSilentDownloadHelper.f334775a.x("silentDownloadReserveModIfNecessary, limit max!!! " + i3);
                return;
            }
            boolean k3 = ZPlanFeatureSwitch.f369852a.k3();
            v vVar = result.f429998a;
            ModSilentDownloadHelper.f334775a.y("silentDownloadReserveModIfNecessary, isNewRequest= " + z16 + ", retCode= " + result.f429999b + ", size= " + ((vVar == null || (yVarArr2 = vVar.f430204a) == null) ? null : Integer.valueOf(yVarArr2.length)) + ", needNotificationSwitch= " + k3);
            ArrayList<v> arrayList = new ArrayList();
            if ((vVar == null || (yVarArr = vVar.f430204a) == null || yVarArr.length != 1) ? false : true) {
                arrayList.add(vVar);
            } else if (vVar != null && (r5 = vVar.f430204a) != null && indices != null) {
                Iterator<Integer> it = indices.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    y[] verControlInfos = vVar.f430204a;
                    if (verControlInfos != null) {
                        Intrinsics.checkNotNullExpressionValue(verControlInfos, "verControlInfos");
                        orNull3 = ArraysKt___ArraysKt.getOrNull(verControlInfos, nextInt);
                        yVar = (y) orNull3;
                    } else {
                        yVar = null;
                    }
                    g[] downloadExtraInfos = vVar.f430205b;
                    if (downloadExtraInfos != null) {
                        Intrinsics.checkNotNullExpressionValue(downloadExtraInfos, "downloadExtraInfos");
                        orNull2 = ArraysKt___ArraysKt.getOrNull(downloadExtraInfos, nextInt);
                        gVar = (g) orNull2;
                    } else {
                        gVar = null;
                    }
                    f[] checkPhoneResults = vVar.f430206c;
                    if (checkPhoneResults != null) {
                        Intrinsics.checkNotNullExpressionValue(checkPhoneResults, "checkPhoneResults");
                        orNull = ArraysKt___ArraysKt.getOrNull(checkPhoneResults, nextInt);
                        fVar = (f) orNull;
                    } else {
                        fVar = null;
                    }
                    if (yVar != null && gVar != null && fVar != null) {
                        v vVar2 = new v();
                        vVar2.f430204a = new y[]{yVar};
                        vVar2.f430205b = new g[]{gVar};
                        vVar2.f430206c = new f[]{fVar};
                        arrayList.add(vVar2);
                    }
                }
            }
            boolean z17 = this.f334785d;
            boolean z18 = z17 && k3;
            for (v vVar3 : arrayList) {
                g[] downloadExtraInfos2 = vVar3.f430205b;
                if (downloadExtraInfos2 != null) {
                    Intrinsics.checkNotNullExpressionValue(downloadExtraInfos2, "downloadExtraInfos");
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(downloadExtraInfos2);
                    gVar2 = (g) firstOrNull;
                } else {
                    gVar2 = null;
                }
                if (gVar2 != null) {
                    ModSilentDownloadHelper modSilentDownloadHelper = ModSilentDownloadHelper.f334775a;
                    modSilentDownloadHelper.y(z17 + " - silentDownloadReserveModIfNecessary - " + gVar2.f430142a + " - userReserved= " + gVar2.f430154m + ", finalNeedNotification= " + z18);
                    if (!z17 || gVar2.f430154m) {
                        modSilentDownloadHelper.v(gVar2.f430142a, vVar3, z16, z18);
                    } else {
                        modSilentDownloadHelper.y("skipped!!!");
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
        }
    }
}
