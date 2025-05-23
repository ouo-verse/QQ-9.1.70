package com.tencent.ecommerce.base.opentelemtry.api;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH&J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH&J\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003H&J$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "", "serviceName", "", "getServiceName", "()Ljava/lang/String;", "addEvent", "", "spanName", "event", "attributes", "", "endSpan", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "getTraceInfo", "setAttribute", "startSpan", "startSpanWithParent", "parentSpanName", "updateAttribute", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECSpan {
    void addEvent(@NotNull String spanName, @NotNull String event, @NotNull Map<String, String> attributes);

    void endSpan(@NotNull String spanName, int statusCode);

    @NotNull
    String getServiceName();

    @NotNull
    String getTraceInfo(@NotNull String spanName);

    void setAttribute(@NotNull String spanName, @NotNull Map<String, String> attributes);

    void startSpan(@NotNull String spanName, @NotNull String serviceName);

    void startSpanWithParent(@NotNull String spanName, @NotNull String serviceName, @NotNull String parentSpanName);

    void updateAttribute(@NotNull String spanName, @NotNull Map<String, String> attributes);
}
