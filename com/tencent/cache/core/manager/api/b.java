package com.tencent.cache.core.manager.api;

import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J4\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\rH&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH&J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/cache/core/manager/api/b;", "", "Landroid/content/Context;", "getAppContext", "Lcom/tencent/cache/core/manager/api/ClearMode;", "clearMode", "", "targetRatio", "", "a", "", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "d", "", "level", "onTrimMemory", "key", "value", "c", "b", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface b {
    void a(@NotNull ClearMode clearMode, float targetRatio);

    @NotNull
    String b(@NotNull String key);

    void c(@NotNull String key, @NotNull String value);

    void d(@NotNull String eventName, @NotNull HashMap<String, String> params);

    @NotNull
    Context getAppContext();

    void onTrimMemory(int level);
}
