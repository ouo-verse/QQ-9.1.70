package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import android.view.View;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.event.DKEventCenter;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.ParamsKey;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.tvideo.protocol.pb.DynamicInfo;
import com.tencent.tvideo.protocol.pb.RewardAdInfo;
import com.tencent.tvideo.protocol.pb.RewardAdItem;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import pw2.w;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010'\u001a\u00020%\u00a2\u0006\u0004\b(\u0010)J2\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002JY\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011Ja\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0016\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013H\u0002J\u0018\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH\u0002J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J*\u0010\u001f\u001a\u00020\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ*\u0010 \u001a\u00020\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ@\u0010\"\u001a\u00020\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0006J4\u0010#\u001a\u00020\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ,\u0010$\u001a\u00020\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fR\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/a;", "", "", "callid", "Lcom/tencent/ams/dsdk/event/DKEventCenter$EngineType;", TagName.ENGINE_TYPE, "", "reportStatus", "", "c", "i", "callId", "", "timeCost", "bundleId", "failReason", "d", "(Ljava/lang/String;Lcom/tencent/ams/dsdk/event/DKEventCenter$EngineType;IJLjava/lang/String;Ljava/lang/Integer;)Ljava/util/Map;", "isWarmUp", "", "e", "(Ljava/lang/String;Lcom/tencent/ams/dsdk/event/DKEventCenter$EngineType;IJLjava/lang/String;Ljava/lang/Integer;I)Ljava/util/Map;", "a", "Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;", "rewardAdInfo", "b", "g", h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "j", "k", "errorCode", DomainData.DOMAIN_NAME, "l", "p", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/g;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/g;", "vrProvider", "<init>", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/g;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private g vrProvider;

    public a(@NotNull g vrProvider) {
        Intrinsics.checkNotNullParameter(vrProvider, "vrProvider");
        this.vrProvider = vrProvider;
    }

    private final String a() {
        RewardAdInfo g16 = this.vrProvider.g();
        if (g16 != null) {
            return b(g16);
        }
        return null;
    }

    private final String b(RewardAdInfo rewardAdInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        DynamicInfo dynamicInfo;
        RewardAdItem rewardAdItem = rewardAdInfo.ad_reward_item;
        String str9 = null;
        if (rewardAdItem != null && (dynamicInfo = rewardAdItem.dynamicInfo) != null) {
            str = dynamicInfo.moduleId;
        } else {
            str = null;
        }
        Map<String, String> g16 = g();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ad_vid=");
        if (g16 != null) {
            str2 = g16.get(AdReportParamsKey.AD_VID);
        } else {
            str2 = null;
        }
        sb5.append(str2);
        sb5.append("&dyn_model_id=");
        sb5.append(str);
        sb5.append("&ad_reportkey_fst=");
        if (g16 != null) {
            str3 = g16.get(VRReportDefine$ReportParam.AD_REPORTKEY_FST);
        } else {
            str3 = null;
        }
        sb5.append(str3);
        sb5.append("&ad_reportkey_scd=");
        if (g16 != null) {
            str4 = g16.get(VRReportDefine$ReportParam.AD_REPORTKEY_SCD);
        } else {
            str4 = null;
        }
        sb5.append(str4);
        sb5.append("&ad_playmode=");
        if (g16 != null) {
            str5 = g16.get(VRReportDefine$ReportParam.AD_PLAYMODE);
        } else {
            str5 = null;
        }
        sb5.append(str5);
        sb5.append("&whole_ad_type=");
        if (g16 != null) {
            str6 = g16.get(VRReportDefine$ReportParam.WHOLE_AD_TYPE);
        } else {
            str6 = null;
        }
        sb5.append(str6);
        sb5.append("&ad_group_id=");
        if (g16 != null) {
            str7 = g16.get("ad_group_id");
        } else {
            str7 = null;
        }
        sb5.append(str7);
        sb5.append("&is_auto_play=");
        if (g16 != null) {
            str8 = g16.get("is_auto_play");
        } else {
            str8 = null;
        }
        sb5.append(str8);
        sb5.append("&ad_is_bidding=");
        if (g16 != null) {
            str9 = g16.get(VRReportDefine$ReportParam.AD_IS_BIDDING);
        }
        sb5.append(str9);
        return sb5.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Map<String, Object> c(String callid, DKEventCenter.EngineType engineType, int reportStatus) {
        Map<String, Object> linkedHashMap;
        Map<String, Object> h16 = h();
        if (h16 == null || linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put("business", "ad");
        linkedHashMap.put(VRReportDefine$ReportParam.REPORT_STATUS, Integer.valueOf(reportStatus));
        ParamsKey.Companion companion = ParamsKey.INSTANCE;
        linkedHashMap.put(companion.b(), callid);
        if (engineType == DKEventCenter.EngineType.HIPPY) {
            linkedHashMap.put(companion.c(), Integer.valueOf(EngineType.INSTANCE.a()));
        }
        return linkedHashMap;
    }

    private final Map<String, Object> d(String callId, @EngineType DKEventCenter.EngineType engineType, @ReportStatus int reportStatus, long timeCost, String bundleId, Integer failReason) {
        Map<String, Object> c16 = c(callId, engineType, reportStatus);
        ParamsKey.Companion companion = ParamsKey.INSTANCE;
        c16.put(companion.e(), Long.valueOf(timeCost));
        c16.put(companion.a(), bundleId);
        if (failReason != null) {
            c16.put(companion.d(), Integer.valueOf(failReason.intValue()));
        }
        return c16;
    }

    private final Map<String, Object> e(String callId, DKEventCenter.EngineType engineType, int reportStatus, long timeCost, String bundleId, Integer failReason, int isWarmUp) {
        Map<String, Object> d16 = d(callId, engineType, reportStatus, timeCost, bundleId, failReason);
        d16.put("ad_request_id", this.vrProvider.getRequestId());
        d16.put(VRReportDefine$ReportParam.AD_REPORT_PARAMS, a());
        if (isWarmUp != 0) {
            d16.put(AdReportParamsKey.IS_WARM_UP, Integer.valueOf(isWarmUp));
        }
        return d16;
    }

    static /* synthetic */ Map f(a aVar, String str, DKEventCenter.EngineType engineType, int i3, long j3, String str2, Integer num, int i16, int i17, Object obj) {
        Integer num2;
        int i18;
        if ((i17 & 32) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i17 & 64) != 0) {
            i18 = 2;
        } else {
            i18 = i16;
        }
        return aVar.e(str, engineType, i3, j3, str2, num2, i18);
    }

    private final Map<String, String> g() {
        return QAdVrReport.b(this.vrProvider.f());
    }

    private final Map<String, Object> h() {
        View e16 = this.vrProvider.e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("business", "ad");
        if (e16 != null) {
            try {
                Map<String, Object> g16 = w.g(e16);
                if (g16 != null) {
                    Object obj = g16.get("cur_pg");
                    if (TypeIntrinsics.isMutableMap(obj)) {
                        Object obj2 = ((Map) obj).get("pgid");
                        if (obj2 != null) {
                            linkedHashMap.put("pgid", obj2);
                        }
                        Object obj3 = ((Map) obj).get("ref_pg");
                        if (obj3 != null) {
                            linkedHashMap.put("ref_pg", obj3);
                        }
                    }
                    linkedHashMap.put("cur_pg", obj);
                }
            } catch (Exception unused) {
                n.b("QAdDynamicReporter", "getReportParams, convert error");
            }
        }
        return linkedHashMap;
    }

    private final String i() {
        ModuleInfo moduleInfo = ModuleConfigCache.getModuleInfo(DKConfiguration.Directory.VENDOR);
        if (moduleInfo != null) {
            return moduleInfo.getName();
        }
        return null;
    }

    public static /* synthetic */ void o(a aVar, String str, DKEventCenter.EngineType engineType, int i3, long j3, String str2, int i16, int i17, Object obj) {
        String str3;
        int i18;
        if ((i17 & 16) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i17 & 32) != 0) {
            i18 = 0;
        } else {
            i18 = i16;
        }
        aVar.n(str, engineType, i3, j3, str3, i18);
    }

    public final void j(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType, int statusCode, long timeCost) {
        int i3;
        Integer valueOf;
        if (statusCode == 0) {
            i3 = 13;
        } else {
            i3 = 14;
        }
        int i16 = i3;
        if (statusCode == 0) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(statusCode);
        }
        w.i(EventId.INSTANCE.a(), d(callId, engineType, i16, timeCost, i(), valueOf));
    }

    public final void k(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType, int statusCode, long timeCost) {
        int i3;
        Integer valueOf;
        if (statusCode == HippyEngine.EngineInitStatus.STATUS_OK.value()) {
            i3 = 15;
        } else {
            i3 = 16;
        }
        if (i3 == 15) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(statusCode);
        }
        w.i(EventId.INSTANCE.b(), d(callId, engineType, i3, timeCost, i(), valueOf));
    }

    public final void l(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType, @Nullable String bundleId, int statusCode, long timeCost) {
        int i3;
        Integer num;
        if (statusCode == HippyEngine.ModuleLoadStatus.STATUS_OK.value()) {
            i3 = 19;
        } else {
            i3 = 20;
        }
        if (i3 == 19) {
            num = null;
        } else {
            num = 1;
        }
        w.i(EventId.INSTANCE.c(), f(this, callId, engineType, i3, timeCost, bundleId, num, 0, 64, null));
    }

    public final void m(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType) {
        w.i(EventId.INSTANCE.f(), c(callId, engineType, 11));
    }

    public final void n(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType, int errorCode, long timeCost, @Nullable String bundleId, int isWarmUp) {
        int i3;
        Integer num;
        if (errorCode == 9000) {
            i3 = 17;
        } else {
            i3 = 18;
        }
        int i16 = i3;
        switch (errorCode) {
            case 9000:
                num = null;
                break;
            case 9001:
            default:
                num = 4;
                break;
            case 9002:
                num = 1;
                break;
            case 9003:
            case 9004:
            case 9005:
                num = 2;
                break;
            case 9006:
                num = 3;
                break;
        }
        w.i(EventId.INSTANCE.d(), e(callId, engineType, i16, timeCost, bundleId, num, isWarmUp));
    }

    public final void p(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType, @Nullable String bundleId, long timeCost) {
        w.i(EventId.INSTANCE.e(), f(this, callId, engineType, 21, timeCost, bundleId, null, 0, 96, null));
    }
}
