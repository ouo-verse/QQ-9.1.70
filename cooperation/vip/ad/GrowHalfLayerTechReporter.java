package cooperation.vip.ad;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J.\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ6\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000bJ\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000eJ\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000eJ\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000eJ\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000eRh\u0010$\u001aV\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020!j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\"0!j*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020!j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\"`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010#\u00a8\u0006("}, d2 = {"Lcooperation/vip/ad/GrowHalfLayerTechReporter;", "", "", "traceId", "", "i", "adId", "bundleName", "numberOfRequests", "", "isInMsgTabOnStart", "", "startTimeStamp", "d", "", "jsBundleLoadErrorCode", "soLoadErrorCode", "showErrorCode", "isNativeShowSucceed", "nativeShowTimestamp", "c", "hippyTechInfoStr", "b", "Lcooperation/vip/ad/GrowHalfLayerTechReporter$DismissReason;", "dismissReason", "timestamp", "a", tl.h.F, "e", "reason", "j", "g", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "adIdToTechReportData", "<init>", "()V", "DismissReason", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class GrowHalfLayerTechReporter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GrowHalfLayerTechReporter f391039a = new GrowHalfLayerTechReporter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, HashMap<String, String>> adIdToTechReportData = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcooperation/vip/ad/GrowHalfLayerTechReporter$DismissReason;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "ContentClick", "BackgroundClick", "SlideClose", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public enum DismissReason {
        ContentClick(1),
        BackgroundClick(2),
        SlideClose(3);

        private final int code;

        DismissReason(int i3) {
            this.code = i3;
        }

        public final int getCode() {
            return this.code;
        }
    }

    GrowHalfLayerTechReporter() {
    }

    @JvmStatic
    public static final void i(@NotNull String traceId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("trace_id", traceId));
        VideoReport.reportEvent("ev_bas_halfscreen_client_trigger", mapOf);
    }

    public final void a(@NotNull String adId, @NotNull DismissReason dismissReason, long timestamp) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(dismissReason, "dismissReason");
        HashMap<String, String> hashMap = adIdToTechReportData.get(adId);
        if (hashMap == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        hashMap2.put("dismissCode", String.valueOf(dismissReason.getCode()));
        hashMap2.put("dismissTimestamp", String.valueOf(timestamp));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("growHalfLayerDismiss", hashMap2);
    }

    public final void b(@NotNull String adId, @NotNull String hippyTechInfoStr) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(hippyTechInfoStr, "hippyTechInfoStr");
        HashMap<String, String> hashMap = adIdToTechReportData.get(adId);
        if (hashMap == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        try {
            jSONObject = new JSONObject(hippyTechInfoStr);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "techJSONInfo.keys()");
        while (keys.hasNext()) {
            Object next = keys.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
            String str = (String) next;
            String optString = jSONObject.optString(str);
            Intrinsics.checkNotNullExpressionValue(optString, "techJSONInfo.optString(key)");
            hashMap2.put(str, optString);
        }
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("growHalfLayerHippyShow", hashMap2);
    }

    public final void c(@NotNull String adId, int jsBundleLoadErrorCode, int soLoadErrorCode, int showErrorCode, boolean isNativeShowSucceed, long nativeShowTimestamp) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        HashMap<String, String> hashMap = adIdToTechReportData.get(adId);
        if (hashMap == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        hashMap2.put("jsBundleLoadErrorCode", String.valueOf(jsBundleLoadErrorCode));
        hashMap2.put("soLoadErrorCode", String.valueOf(soLoadErrorCode));
        hashMap2.put("showErrorCode", String.valueOf(showErrorCode));
        hashMap2.put("nativeShowSuccessed", String.valueOf(isNativeShowSucceed));
        hashMap2.put("nativeShowTimestamp", String.valueOf(nativeShowTimestamp));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("growHalfLayerNativeShow", hashMap2);
    }

    public final void d(@NotNull String adId, @NotNull String bundleName, @NotNull String numberOfRequests, boolean isInMsgTabOnStart, long startTimeStamp) {
        String str;
        HashMap<String, String> hashMapOf;
        Map<String, ? extends Object> map;
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        Intrinsics.checkNotNullParameter(numberOfRequests, "numberOfRequests");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("startTimestamp", String.valueOf(startTimeStamp));
        pairArr[1] = TuplesKt.to("adID", adId);
        pairArr[2] = TuplesKt.to("bundleName", bundleName);
        if (isInMsgTabOnStart) {
            str = "1";
        } else {
            str = "0";
        }
        pairArr[3] = TuplesKt.to("isInMsgTabOnStart", str);
        pairArr[4] = TuplesKt.to("numberOfRequests", numberOfRequests);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        adIdToTechReportData.put(adId, hashMapOf);
        ITroopBeaconReporter iTroopBeaconReporter = (ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class);
        map = MapsKt__MapsKt.toMap(hashMapOf);
        iTroopBeaconReporter.report("growHalfLayerStart", map);
    }

    public final void e(@NotNull String traceId, int adId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("trace_id", traceId), TuplesKt.to("adpos_id", Integer.valueOf(adId)));
        VideoReport.reportEvent("ev_bas_local_cache_delivery", mapOf);
    }

    public final void f(@NotNull String traceId, int adId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("trace_id", traceId), TuplesKt.to("adpos_id", Integer.valueOf(adId)));
        VideoReport.reportEvent("ev_bas_halfscreen_exit_click", mapOf);
    }

    public final void g(@NotNull String traceId, int adId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("trace_id", traceId), TuplesKt.to("adpos_id", Integer.valueOf(adId)));
        VideoReport.reportEvent("ev_bas_halfscreen_imp", mapOf);
    }

    public final void h(@NotNull String traceId, int adId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("trace_id", traceId), TuplesKt.to("adpos_id", Integer.valueOf(adId)));
        VideoReport.reportEvent("ev_bas_halfscreen_client_reception", mapOf);
    }

    public final void j(@NotNull String traceId, int adId, int reason) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("trace_id", traceId), TuplesKt.to("adpos_id", Integer.valueOf(adId)), TuplesKt.to("failreason", Integer.valueOf(reason)));
        VideoReport.reportEvent("ev_bas_halfscreen_client_delivery", mapOf);
    }
}
