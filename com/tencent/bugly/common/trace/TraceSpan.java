package com.tencent.bugly.common.trace;

import android.os.SystemClock;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TraceSpan {
    public static final String KEY_END_TIME_UNIX_MS = "end_time_unix_ms";
    public static final String KEY_KIND = "kind";
    public static final String KEY_NAME = "name";
    public static final String KEY_PARENT_SPAN_ID = "parent_span_id";
    public static final String KEY_SPAN_ID = "span_id";
    public static final String KEY_START_TIME_UNIX_MS = "start_time_unix_ms";
    public static final String KEY_TRACE_ID = "trace_id";
    private long endTimeInMs;
    public final String name;
    private final TraceSpan parentSpan;
    public final String spanId;
    private final long startTimeInMs;
    public final String traceId;

    public TraceSpan(String str, String str2, TraceSpan traceSpan) {
        this.endTimeInMs = 0L;
        this.traceId = str;
        this.spanId = TraceGenerator.generateSpanID();
        this.name = str2;
        this.parentSpan = traceSpan;
        this.startTimeInMs = SystemClock.uptimeMillis();
    }

    private long machineTimeToUnixTime(long j3, long j16, long j17) {
        return (j17 + j3) - j16;
    }

    public long getStartTimeInMs() {
        return this.startTimeInMs;
    }

    public boolean isSpanEnd() {
        if (this.endTimeInMs != 0) {
            return true;
        }
        return false;
    }

    public void onSpanEnd() {
        this.endTimeInMs = SystemClock.uptimeMillis();
    }

    public JSONObject toJson(long j3, long j16) throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("trace_id", this.traceId);
        jSONObject.put(KEY_SPAN_ID, this.spanId);
        TraceSpan traceSpan = this.parentSpan;
        if (traceSpan == null) {
            str = "";
        } else {
            str = traceSpan.spanId;
        }
        jSONObject.put(KEY_PARENT_SPAN_ID, str);
        jSONObject.put("name", this.name);
        jSONObject.put(KEY_START_TIME_UNIX_MS, machineTimeToUnixTime(this.startTimeInMs, j3, j16));
        jSONObject.put(KEY_END_TIME_UNIX_MS, machineTimeToUnixTime(this.endTimeInMs, j3, j16));
        jSONObject.put("kind", WidgetCacheConstellationData.INTERVAL);
        return jSONObject;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{name: ");
        sb5.append(this.name);
        sb5.append(", cost: ");
        sb5.append(this.endTimeInMs - this.startTimeInMs);
        sb5.append(", parentSpan: ");
        TraceSpan traceSpan = this.parentSpan;
        if (traceSpan == null) {
            str = "";
        } else {
            str = traceSpan.name;
        }
        sb5.append(str);
        sb5.append("}");
        return sb5.toString();
    }

    public TraceSpan(String str, String str2, TraceSpan traceSpan, long j3, long j16) {
        this.endTimeInMs = 0L;
        this.traceId = str;
        this.spanId = TraceGenerator.generateSpanID();
        this.name = str2;
        this.parentSpan = traceSpan;
        this.startTimeInMs = j3;
        this.endTimeInMs = j16;
    }
}
