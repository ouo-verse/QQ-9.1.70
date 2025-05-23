package com.tencent.zplan.zplantracing;

import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/zplan/zplantracing/c;", "", "", "<set-?>", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "traceId", TPReportKeys.LiveExKeys.LIVE_FX_SPANID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "zplan-tracing_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String spanId;

    public c(@NotNull String traceId, @NotNull String spanId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        this.traceId = traceId;
        this.spanId = spanId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getSpanId() {
        return this.spanId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }
}
