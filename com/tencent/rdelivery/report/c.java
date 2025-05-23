package com.tencent.rdelivery.report;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.BaseProto$Platform;
import com.tencent.rdelivery.net.BaseProto$PullTarget;
import com.tencent.rdelivery.net.BaseProto$ServerType;
import com.tencent.rdelivery.net.RDeliveryRequest;
import com.tencent.rdelivery.net.i;
import com.tencent.rdelivery.util.d;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105JD\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J.\u0010\u0011\u001a\u00020\u000b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J*\u0010\u0017\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J:\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J\u0016\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 J\u001e\u0010&\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010)\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$J\u0016\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u001a\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ@\u0010/\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00100R\u0016\u00103\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/rdelivery/report/c;", "", "", "eventCode", "", "params", "", "isRealTime", "isImmediatelyUpload", "Lcom/tencent/rdelivery/util/c;", "logger", "", "a", h.F, "", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", Const.BUNDLE_KEY_REQUEST, "d", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "c", "key", "value", "i", "netResult", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "errorMsg", "o", "e", "Landroid/content/Context;", "ctx", "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "f", "isSuccess", "", QCircleWeakNetReporter.KEY_COST, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "context", "initSuccess", DomainData.DOMAIN_NAME, "cfgInfo", "j", "", "count", "g", "k", "Lcom/tencent/raft/standard/net/IRNetwork;", "b", "I", "decryptDecodeErrReportedCount", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IRNetwork netInterface;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int decryptDecodeErrReportedCount;

    /* renamed from: c, reason: collision with root package name */
    public static final c f364376c = new c();

    c() {
    }

    private final void a(String eventCode, Map<String, String> params, boolean isRealTime, boolean isImmediatelyUpload, com.tencent.rdelivery.util.c logger) {
        if (h()) {
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDelivery_Reporter", "doReport return", false, 4, null);
                return;
            }
            return;
        }
        b.b(eventCode, params, isRealTime, isImmediatelyUpload);
    }

    static /* synthetic */ void b(c cVar, String str, Map map, boolean z16, boolean z17, com.tencent.rdelivery.util.c cVar2, int i3, Object obj) {
        boolean z18;
        boolean z19;
        if ((i3 & 4) != 0) {
            z18 = true;
        } else {
            z18 = z16;
        }
        if ((i3 & 8) != 0) {
            z19 = true;
        } else {
            z19 = z17;
        }
        if ((i3 & 16) != 0) {
            cVar2 = null;
        }
        cVar.a(str, map, z18, z19, cVar2);
    }

    private final void c(Map<String, String> params, RDeliverySetting setting) {
        String str = setting.getCom.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder.RequestParamKey.QIMEI36 java.lang.String();
        if (str == null) {
            str = "";
        }
        params.put("dev_id", str);
        params.put("sys_id", setting.getSystemId());
        params.put(HiAnalyticsConstant.BI_KEY_SDK_VER, "1.3.36-RC01");
        params.put("dev_type", setting.getDevModel());
        params.put("dev_manu", setting.getDevManufacturer());
        params.put("sys_ver", setting.getAndroidSystemVersion());
        params.put("app_id", setting.getAppId());
        params.put("host_app_ver", setting.getHostAppVersion());
        params.put("user_id", setting.getUserId());
        i(params, "logic_env_id", setting.getLogicEnvironment());
    }

    private final void d(Map<String, String> params, RDeliveryRequest request, com.tencent.rdelivery.util.c logger) {
        String str;
        String str2;
        String str3;
        params.put(CheckForwardServlet.KEY_REQ_ID, request.getRequestId());
        params.put("app_id", request.getAppId());
        params.put(AppConstants.Key.SHARE_REQ_TYPE, String.valueOf(request.getPullType().getValue()));
        params.put("dev_type", request.getDevModel());
        params.put("dev_manu", request.getDevManufacturer());
        params.put("sys_ver", request.getAndroidSystemVersion());
        params.put(HiAnalyticsConstant.BI_KEY_SDK_VER, "1.3.36-RC01");
        params.put("sys_id", request.getSystemId());
        params.put("user_id", request.getUserId());
        params.put("host_app_ver", request.getAppVersion());
        String str4 = request.getCom.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder.RequestParamKey.QIMEI36 java.lang.String();
        if (str4 == null) {
            str4 = "";
        }
        params.put("dev_id", str4);
        IRNetwork iRNetwork = netInterface;
        if (iRNetwork != null) {
            IRNetwork.NetworkStatus networkStatus = iRNetwork.getNetworkStatus();
            Intrinsics.checkExpressionValueIsNotNull(networkStatus, "it.networkStatus");
            params.put("net_type", String.valueOf(networkStatus.getValue()));
        }
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, "RDelivery_Reporter", "fillCommonReportArgs netType = " + params.get("net_type"), false, 4, null);
        }
        RDeliveryRequest.RequestSource requestSrc = request.getRequestSrc();
        String str5 = null;
        if (requestSrc != null) {
            str = String.valueOf(requestSrc.getValue());
        } else {
            str = null;
        }
        i(params, "req_src", str);
        List<String> l3 = request.l();
        if (l3 != null) {
            str2 = CollectionsKt___CollectionsKt.joinToString$default(l3, "_", null, null, 0, null, null, 62, null);
        } else {
            str2 = null;
        }
        i(params, "req_keys", str2);
        i(params, "scene_id", String.valueOf(request.getGroupID()));
        i(params, "logic_env_id", request.getLogicEnvironment());
        if (request.getMergeReqId() != null) {
            str3 = "1";
        } else {
            str3 = null;
        }
        i(params, "is_merge_req", str3);
        BaseProto$PullTarget pullTarget = request.getPullTarget();
        if (pullTarget != null) {
            str5 = String.valueOf(pullTarget.getValue());
        }
        i(params, "pull_target", str5);
    }

    private final boolean h() {
        if (BaseProto$ServerType.RELEASE.getValue() != 0) {
            return true;
        }
        return false;
    }

    private final void i(@NotNull Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    public static /* synthetic */ void l(c cVar, RDeliveryRequest rDeliveryRequest, boolean z16, String str, String str2, String str3, RDeliverySetting rDeliverySetting, int i3, Object obj) {
        String str4;
        String str5;
        String str6;
        RDeliverySetting rDeliverySetting2;
        if ((i3 & 4) != 0) {
            str4 = "";
        } else {
            str4 = str;
        }
        if ((i3 & 8) != 0) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if ((i3 & 16) != 0) {
            str6 = "";
        } else {
            str6 = str3;
        }
        if ((i3 & 32) != 0) {
            rDeliverySetting2 = null;
        } else {
            rDeliverySetting2 = rDeliverySetting;
        }
        cVar.k(rDeliveryRequest, z16, str4, str5, str6, rDeliverySetting2);
    }

    private final void o(boolean netResult, String errorType, RDeliveryRequest request, RDeliverySetting setting, String errorCode, String errorMsg) {
        com.tencent.rdelivery.util.c logger;
        com.tencent.rdelivery.util.c cVar;
        if (!netResult) {
            try {
                if (decryptDecodeErrReportedCount < 5) {
                    if (Intrinsics.areEqual(errorType, "22") || Intrinsics.areEqual(errorType, "21")) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (setting != null) {
                            cVar = setting.getLogger();
                        } else {
                            cVar = null;
                        }
                        d(linkedHashMap, request, cVar);
                        linkedHashMap.put("req_result", "1");
                        linkedHashMap.put("err_type", errorType);
                        linkedHashMap.put(CheckForwardServlet.KEY_ERR_CODE, errorCode);
                        linkedHashMap.put("err_msg", errorMsg);
                        linkedHashMap.put("platform", BaseProto$Platform.ANDROID.name());
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        i.Companion companion = i.INSTANCE;
                        companion.c(i.Companion.b(companion, jSONObject, null, 2, null), netInterface, setting);
                        decryptDecodeErrReportedCount++;
                    }
                }
            } catch (Exception e16) {
                if (setting != null && (logger = setting.getLogger()) != null) {
                    logger.d("RDelivery_Reporter", "tryReportDecryptDecodeErrToShiplyServer exception", e16);
                }
            }
        }
    }

    @NotNull
    public final synchronized String e() {
        return String.valueOf(SystemClock.elapsedRealtime());
    }

    public final void f(@NotNull Context ctx, @NotNull IRNetwork netInterface2) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        Intrinsics.checkParameterIsNotNull(netInterface2, "netInterface");
        b.a(ctx);
        netInterface = netInterface2;
    }

    public final boolean g(int count, @Nullable com.tencent.rdelivery.util.c logger) {
        IntRange until;
        int random;
        boolean z16 = false;
        if (count > 0) {
            until = RangesKt___RangesKt.until(0, count);
            random = RangesKt___RangesKt.random(until, Random.INSTANCE);
            if (random == 0) {
                z16 = true;
            }
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDelivery_Reporter", "isHitSampling count = " + count + ", randomNum = " + random, false, 4, null);
            }
        }
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, "RDelivery_Reporter", "isHitSampling result = " + z16, false, 4, null);
        }
        return z16;
    }

    public final void j(@NotNull String cfgInfo, @NotNull RDeliverySetting setting) {
        Intrinsics.checkParameterIsNotNull(cfgInfo, "cfgInfo");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c(linkedHashMap, setting);
        linkedHashMap.put("cfg_info", cfgInfo);
        b(this, "rdcfg_change", linkedHashMap, false, false, null, 28, null);
    }

    public final void k(@NotNull RDeliveryRequest request, boolean netResult, @NotNull String errorType, @NotNull String errorCode, @NotNull String errorMsg, @Nullable RDeliverySetting setting) {
        com.tencent.rdelivery.util.c cVar;
        com.tencent.rdelivery.util.c logger;
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(errorType, "errorType");
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        o(netResult, errorType, request, setting, errorCode, errorMsg);
        int reportSampling = request.getReportSampling();
        com.tencent.rdelivery.util.c cVar2 = null;
        if (setting != null) {
            cVar = setting.getLogger();
        } else {
            cVar = null;
        }
        if (!g(reportSampling, cVar)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (setting != null) {
            cVar2 = setting.getLogger();
        }
        d(linkedHashMap, request, cVar2);
        linkedHashMap.put("req_size", String.valueOf(request.getReqSize()));
        linkedHashMap.put("queue_cost", String.valueOf(request.getRequestDequeueTS() - request.getRequestEnqueueTS()));
        linkedHashMap.put("schedule_cost", String.valueOf(request.getRequestExecuteTS() - request.getRequestDequeueTS()));
        linkedHashMap.put("net_cost", String.valueOf(request.getResponseTS() - request.getRequestExecuteTS()));
        if (netResult) {
            linkedHashMap.put("req_result", "0");
        } else {
            linkedHashMap.put("req_result", "1");
        }
        linkedHashMap.put("err_type", errorType);
        linkedHashMap.put(CheckForwardServlet.KEY_ERR_CODE, errorCode);
        linkedHashMap.put("err_msg", errorMsg);
        Long respDecFinishTS = request.getRespDecFinishTS();
        if (respDecFinishTS != null) {
            linkedHashMap.put("decode_cost", String.valueOf(respDecFinishTS.longValue() - request.getResponseTS()));
        }
        Boolean decodeResult = request.getDecodeResult();
        if (decodeResult != null) {
            if (decodeResult.booleanValue()) {
                linkedHashMap.put("decode_result", "0");
            } else {
                linkedHashMap.put("decode_result", "1");
            }
        }
        linkedHashMap.put("t_cost", String.valueOf(SystemClock.elapsedRealtime() - request.getRequestEnqueueTS()));
        linkedHashMap.put("sampling", String.valueOf(request.getReportSampling()));
        if (setting != null && (logger = setting.getLogger()) != null) {
            com.tencent.rdelivery.util.c.b(logger, "RDelivery_Reporter", "reportReceiveRemoteCfg params = " + linkedHashMap, false, 4, null);
        }
        b(this, "rd_get_r_all", linkedHashMap, false, false, null, 28, null);
    }

    public final void m(boolean isSuccess, long cost, @NotNull RDeliverySetting setting) {
        String str;
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        if (!g(1000, setting.getLogger())) {
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, d.a("RDelivery_Reporter", setting.getRdInstanceIdentifier()), "reportStartUp return for miss sampling", false, 4, null);
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c(linkedHashMap, setting);
        linkedHashMap.put("sampling", String.valueOf(1000));
        linkedHashMap.put(ReportDataBuilder.KEY_BUNDLE_ID, setting.getBundleId());
        linkedHashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(cost));
        if (isSuccess) {
            str = "0";
        } else {
            str = "1";
        }
        linkedHashMap.put("result", str);
        com.tencent.rdelivery.util.c logger2 = setting.getLogger();
        if (logger2 != null) {
            com.tencent.rdelivery.util.c.b(logger2, d.a("RDelivery_Reporter", setting.getRdInstanceIdentifier()), "reportStartUp params = " + linkedHashMap, false, 4, null);
        }
        b(this, "rdcfg_startup", linkedHashMap, false, false, null, 28, null);
    }

    public final void n(@NotNull Context context, boolean initSuccess, long cost) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (h()) {
            return;
        }
        a.f364372b.a(context, initSuccess, cost);
    }
}
