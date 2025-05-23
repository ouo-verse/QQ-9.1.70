package com.tencent.cache.core.manager.api;

import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/cache/core/manager/api/a;", "", "", "onLowMemory", "", "level", "onTrimMemory", "onAppBackground", "Lcom/tencent/cache/api/memory/b;", ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "Lcom/tencent/cache/api/memory/d;", "pss", "a", "Lcom/tencent/cache/api/d;", "fromPage", "toPage", "b", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface a {
    void a(@Nullable com.tencent.cache.api.memory.b java2, @Nullable com.tencent.cache.api.memory.d pss);

    void b(@Nullable com.tencent.cache.api.d fromPage, @Nullable com.tencent.cache.api.d toPage);

    void onAppBackground();

    void onLowMemory();

    void onTrimMemory(int level);
}
