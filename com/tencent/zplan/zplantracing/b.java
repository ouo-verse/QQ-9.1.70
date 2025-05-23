package com.tencent.zplan.zplantracing;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/zplan/zplantracing/b;", "", "Lcom/tencent/zplan/zplantracing/c;", "c", "", "d", "", "key", "value", "e", "b", "errMSg", "a", "Lcom/tencent/zplan/zplantracing/ZPlanSpanData;", "Lcom/tencent/zplan/zplantracing/ZPlanSpanData;", "spanData", "Lcom/tencent/zplan/zplantracing/ZPlanSpanFactory;", "Lcom/tencent/zplan/zplantracing/ZPlanSpanFactory;", "getFactory", "()Lcom/tencent/zplan/zplantracing/ZPlanSpanFactory;", "factory", "name", "parentContext", "<init>", "(Lcom/tencent/zplan/zplantracing/ZPlanSpanFactory;Ljava/lang/String;Lcom/tencent/zplan/zplantracing/c;)V", "zplan-tracing_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ZPlanSpanData spanData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZPlanSpanFactory factory;

    public b(@NotNull ZPlanSpanFactory factory, @NotNull String name, @Nullable c cVar) {
        String str;
        String traceId;
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(name, "name");
        this.factory = factory;
        fy4.a aVar = fy4.a.f400951b;
        String a16 = aVar.a();
        if (cVar != null) {
            str = cVar.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String();
        } else {
            str = null;
        }
        if (cVar == null) {
            traceId = aVar.b();
        } else {
            traceId = cVar.getTraceId();
        }
        ZPlanSpanData zPlanSpanData = new ZPlanSpanData(a16, traceId, str);
        zPlanSpanData.setName(name);
        Unit unit = Unit.INSTANCE;
        this.spanData = zPlanSpanData;
    }

    public final void a(@Nullable String errMSg) {
        this.spanData.setEndTime(TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()));
        this.spanData.setStatus(ZPlanSpanStatusCode.ERROR);
        this.spanData.setErrorMessage(errMSg);
        this.factory.handleSpanData(this.spanData);
    }

    public final void b() {
        this.spanData.setEndTime(TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()));
        this.spanData.setStatus(ZPlanSpanStatusCode.OK);
        this.factory.handleSpanData(this.spanData);
    }

    @NotNull
    public final c c() {
        return new c(this.spanData.getTraceId(), this.spanData.getSpanId());
    }

    public final void d() {
        this.spanData.setStartTime(TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()));
    }

    public final void e(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.spanData.updateAttribute(key, value);
    }
}
