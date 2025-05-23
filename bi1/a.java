package bi1;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J4\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lbi1/a;", "", "", "itemId", "traceId", "traceDetail", "", "position", "", "a", "Lorg/json/JSONObject;", "jsonObject", "eventKey", "", "b", "Lbi1/b;", "Lbi1/b;", "adReporter", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f28439a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b adReporter;

    static {
        b bVar = new b();
        adReporter = bVar;
        VideoReport.addReporter(bVar);
        QLog.d("TianShuAdReportHelper", 1, "TianShuAdReporter initialize");
    }

    a() {
    }

    @NotNull
    public final Map<String, String> a(@NotNull String itemId, @NotNull String traceId, @NotNull String traceDetail, int position) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(traceDetail, "traceDetail");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("TianShuAdItemType", "TianShuAdItemType");
        linkedHashMap.put("TianShuAdItemId", itemId);
        linkedHashMap.put("TianShuAdTraceId", traceId);
        linkedHashMap.put("TianShuAdTraceDetail", traceDetail);
        linkedHashMap.put("TianShuPosition", String.valueOf(position));
        return linkedHashMap;
    }

    public final void b(@NotNull JSONObject jsonObject, @NotNull String eventKey) {
        Integer intOrNull;
        int i3;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        if (Intrinsics.areEqual(jsonObject.optString("TianShuAdItemType"), "TianShuAdItemType")) {
            String optString = jsonObject.optString("TianShuPosition");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(TIANSHUPOSITION)");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 0;
            }
            Integer num = null;
            if (Intrinsics.areEqual(eventKey, "dt_imp")) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                num = 141;
                            }
                        } else {
                            num = 139;
                        }
                    } else {
                        num = 137;
                    }
                } else {
                    num = 101;
                }
            } else if (Intrinsics.areEqual(eventKey, "dt_clck")) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                num = 142;
                            }
                        } else {
                            num = 140;
                        }
                    } else {
                        num = 138;
                    }
                } else {
                    num = 102;
                }
            }
            if (num != null) {
                int intValue = num.intValue();
                String optString2 = jsonObject.optString("TianShuAdItemId");
                String optString3 = jsonObject.optString("TianShuAdTraceId");
                String optString4 = jsonObject.optString("TianShuAdTraceDetail");
                ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
                TianShuReportData tianShuReportData = new TianShuReportData();
                tianShuReportData.mItemId = optString2;
                tianShuReportData.mTraceId = optString3;
                tianShuReportData.mTraceDetail = optString4;
                tianShuReportData.mTraceNum = 1;
                tianShuReportData.mAppId = "tianshu.269";
                tianShuReportData.mPageId = "tianshu.269";
                tianShuReportData.mActionId = intValue;
                tianShuReportData.mActionValue = 1;
                tianShuReportData.mOperTime = NetConnInfoCenter.getServerTime();
                iTianshuManager.report(tianShuReportData);
                QLog.i("TianShuAdReportHelper", 1, "TianShuAdReporter " + optString2 + " , " + optString3 + " , " + optString4 + " , " + intValue);
            }
        }
    }
}
