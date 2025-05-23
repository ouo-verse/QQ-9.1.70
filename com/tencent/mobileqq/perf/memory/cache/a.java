package com.tencent.mobileqq.perf.memory.cache;

import com.tencent.cache.core.manager.api.ClearMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/cache/a;", "", "Lcom/tencent/cache/core/manager/api/ClearMode;", "clearMode", "", "targetRatio", "", "onClear", "", "level", "onTrimMemory", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface a {
    void onClear(@NotNull ClearMode clearMode, float targetRatio);

    void onTrimMemory(int level);
}
