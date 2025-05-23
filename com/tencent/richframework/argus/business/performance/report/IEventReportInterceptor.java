package com.tencent.richframework.argus.business.performance.report;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/IEventReportInterceptor;", "", "dispatchEvent", "", "eventId", "", "map", "", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface IEventReportInterceptor {
    boolean dispatchEvent(@Nullable String eventId, @Nullable Map<String, ? extends Object> map);
}
