package com.tencent.zplan.zplantracing;

import androidx.annotation.Keep;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030*J\u0010\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010,\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020\u0003H\u0016J\u0016\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u001a\u0010\u001d\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000f\u00a8\u00063"}, d2 = {"Lcom/tencent/zplan/zplantracing/ZPlanSpanData;", "", TPReportKeys.LiveExKeys.LIVE_FX_SPANID, "", "traceId", "parentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "innerAttribute", "", "getInnerAttribute", "()Ljava/util/Map;", "setInnerAttribute", "(Ljava/util/Map;)V", "name", "getName", "setName", "getParentId", "getSpanId", "startTime", "getStartTime", "setStartTime", "status", "Lcom/tencent/zplan/zplantracing/ZPlanSpanStatusCode;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/zplan/zplantracing/ZPlanSpanStatusCode;", "setStatus", "(Lcom/tencent/zplan/zplantracing/ZPlanSpanStatusCode;)V", "timeCostMs", "getTimeCostMs", "getTraceId", "getAttribute", "", "getAttributeByKey", "key", "toJson", "Lorg/json/JSONObject;", "toString", "updateAttribute", "", "value", "zplan-tracing_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanSpanData {
    private long endTime;

    @Nullable
    private String errorMessage;

    @NotNull
    private Map<String, String> innerAttribute;

    @NotNull
    private String name;

    @Nullable
    private final String parentId;

    @NotNull
    private final String spanId;
    private long startTime;

    @NotNull
    private ZPlanSpanStatusCode status;

    @NotNull
    private final String traceId;

    public ZPlanSpanData(@NotNull String spanId, @NotNull String traceId, @Nullable String str) {
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.spanId = spanId;
        this.traceId = traceId;
        this.parentId = str;
        this.name = "";
        this.status = ZPlanSpanStatusCode.UNSET;
        this.innerAttribute = new LinkedHashMap();
    }

    @NotNull
    public final Map<String, String> getAttribute() {
        Map<String, String> map;
        map = MapsKt__MapsKt.toMap(this.innerAttribute);
        return map;
    }

    @Nullable
    public final String getAttributeByKey(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.innerAttribute.get(key);
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final Map<String, String> getInnerAttribute() {
        return this.innerAttribute;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getParentId() {
        return this.parentId;
    }

    @NotNull
    public final String getSpanId() {
        return this.spanId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final ZPlanSpanStatusCode getStatus() {
        return this.status;
    }

    public final long getTimeCostMs() {
        return TimeUnit.NANOSECONDS.toMillis(this.endTime - this.startTime);
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    public final void setEndTime(long j3) {
        this.endTime = j3;
    }

    public final void setErrorMessage(@Nullable String str) {
        this.errorMessage = str;
    }

    public final void setInnerAttribute(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.innerAttribute = map;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setStartTime(long j3) {
        this.startTime = j3;
    }

    public final void setStatus(@NotNull ZPlanSpanStatusCode zPlanSpanStatusCode) {
        Intrinsics.checkNotNullParameter(zPlanSpanStatusCode, "<set-?>");
        this.status = zPlanSpanStatusCode;
    }

    @NotNull
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("traceId", this.traceId);
        jSONObject.put(TPReportKeys.LiveExKeys.LIVE_FX_SPANID, this.spanId);
        jSONObject.put("parentId", this.parentId);
        jSONObject.put("name", this.name);
        jSONObject.put("status", this.status);
        jSONObject.put("startTime", this.startTime);
        jSONObject.put("endTime", this.endTime);
        jSONObject.put("timeCostMs", getTimeCostMs());
        jSONObject.put("errorMessage", this.errorMessage);
        if (!this.innerAttribute.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : this.innerAttribute.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("attribute", jSONObject2);
        }
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "ZPlanSpanData, traceId: " + this.traceId + ", spanId: " + this.spanId + ", parendId: " + this.parentId + ", name: " + this.name + ", status: " + this.status + ", startTime: " + this.startTime + ", endTime: " + this.endTime + ", timeCostMs: " + getTimeCostMs() + ", errorMessage: " + this.errorMessage + ", attribute: " + this.innerAttribute;
    }

    public final void updateAttribute(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.innerAttribute.put(key, value);
    }
}
