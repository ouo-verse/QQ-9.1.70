package com.tencent.richframework.tracer;

import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/richframework/tracer/RFWTraceStreamResult;", "", "", "toString", "sessionId", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "streamName", "getStreamName", "setStreamName", "", VasPerfReportUtils.WHILE_COST_TOTAL, "J", "getTotalCost", "()J", "setTotalCost", "(J)V", "", "costMap", "Ljava/util/Map;", "getCostMap", "()Ljava/util/Map;", "setCostMap", "(Ljava/util/Map;)V", "extraParam", "getExtraParam", "setExtraParam", "<init>", "()V", "trace_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWTraceStreamResult {
    private long totalCost;

    @NotNull
    private String sessionId = "";

    @NotNull
    private String streamName = "";

    @NotNull
    private Map<String, Long> costMap = new LinkedHashMap();

    @NotNull
    private Map<String, Object> extraParam = new LinkedHashMap();

    @NotNull
    public final Map<String, Long> getCostMap() {
        return this.costMap;
    }

    @NotNull
    public final Map<String, Object> getExtraParam() {
        return this.extraParam;
    }

    @NotNull
    public final String getStreamName() {
        return this.streamName;
    }

    public final void setExtraParam(@NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraParam = map;
    }

    public final void setSessionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void setStreamName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.streamName = str;
    }

    public final void setTotalCost(long j3) {
        this.totalCost = j3;
    }

    @NotNull
    public String toString() {
        return "RFWTraceStreamResult(sessionId='" + this.sessionId + "', streamName='" + this.streamName + "', totalCost=" + this.totalCost + ", costMap=" + this.costMap + ", extraParam=" + this.extraParam + ')';
    }
}
