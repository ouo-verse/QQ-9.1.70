package com.tencent.mobileqq.triton.statistic;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "", "onSubpackageLoaded", "", "name", "", "statistic", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface SubpackageLoadStatisticsCallback {
    @MainThread
    void onSubpackageLoaded(@NotNull String name, @NotNull ScriptLoadStatistic statistic);
}
