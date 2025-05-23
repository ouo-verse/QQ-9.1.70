package com.tencent.filament.zplanservice.cpp;

import androidx.annotation.Keep;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.zplan.zplantracing.ZPlanSpanData;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.ZPlanSpanStatusCode;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplanservice/cpp/ZPlanSpanDataUtil;", "", "()V", "handleSpanData", "", "jsonString", "", "toZPlanSpanData", "Lcom/tencent/zplan/zplantracing/ZPlanSpanData;", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanSpanDataUtil {

    @NotNull
    public static final ZPlanSpanDataUtil INSTANCE = new ZPlanSpanDataUtil();

    ZPlanSpanDataUtil() {
    }

    @JvmStatic
    @NativeMethodProxy
    public static final void handleSpanData(@Nullable String jsonString) {
        ZPlanSpanData zPlanSpanData;
        if (jsonString != null && (zPlanSpanData = INSTANCE.toZPlanSpanData(jsonString)) != null) {
            ZPlanSpanFactory.INSTANCE.handleSpanData(zPlanSpanData);
        }
    }

    private final ZPlanSpanData toZPlanSpanData(String str) {
        boolean z16;
        JSONObject jSONObject = new JSONObject(str);
        String spanId = jSONObject.optString(TPReportKeys.LiveExKeys.LIVE_FX_SPANID);
        String traceId = jSONObject.optString("traceId");
        String optString = jSONObject.optString("parentSpanId");
        Intrinsics.checkNotNullExpressionValue(spanId, "spanId");
        boolean z17 = true;
        if (spanId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Intrinsics.checkNotNullExpressionValue(traceId, "traceId");
            if (traceId.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                String name = jSONObject.optString("name");
                String optString2 = jSONObject.optString("startTimeStr");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"startTimeStr\")");
                long parseLong = Long.parseLong(optString2);
                String optString3 = jSONObject.optString("endTimeStr");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"endTimeStr\")");
                long parseLong2 = Long.parseLong(optString3);
                int optDouble = (int) jSONObject.optDouble("status");
                String optString4 = jSONObject.optString("errorMessage");
                JSONObject optJSONObject = jSONObject.optJSONObject("attributes");
                ZPlanSpanData zPlanSpanData = new ZPlanSpanData(spanId, traceId, optString);
                Intrinsics.checkNotNullExpressionValue(name, "name");
                zPlanSpanData.setName(name);
                zPlanSpanData.setStartTime(parseLong);
                zPlanSpanData.setEndTime(parseLong2);
                zPlanSpanData.setErrorMessage(optString4);
                ZPlanSpanStatusCode zPlanSpanStatusCode = ZPlanSpanStatusCode.UNSET;
                if (optDouble == zPlanSpanStatusCode.ordinal()) {
                    zPlanSpanData.setStatus(zPlanSpanStatusCode);
                } else {
                    ZPlanSpanStatusCode zPlanSpanStatusCode2 = ZPlanSpanStatusCode.OK;
                    if (optDouble == zPlanSpanStatusCode2.ordinal()) {
                        zPlanSpanData.setStatus(zPlanSpanStatusCode2);
                    } else {
                        ZPlanSpanStatusCode zPlanSpanStatusCode3 = ZPlanSpanStatusCode.ERROR;
                        if (optDouble == zPlanSpanStatusCode3.ordinal()) {
                            zPlanSpanData.setStatus(zPlanSpanStatusCode3);
                        } else {
                            zPlanSpanData.setStatus(zPlanSpanStatusCode);
                        }
                    }
                }
                if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
                    while (keys.hasNext()) {
                        Object next = keys.next();
                        if (next != null) {
                            String str2 = (String) next;
                            String optString5 = optJSONObject.optString(str2);
                            Intrinsics.checkNotNullExpressionValue(optString5, "it.optString(key)");
                            zPlanSpanData.updateAttribute(str2, optString5);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                }
                return zPlanSpanData;
            }
            return null;
        }
        return null;
    }
}
