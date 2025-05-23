package com.tencent.mobileqq.icgame.api.config;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u001a\"\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\b\u001a\"\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\n\u001a\"\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\f\u001a\"\u0010\r\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"getBoolean", "", "Lcom/tencent/mobileqq/icgame/api/config/IICGameConfigApi;", "key", "", QAdRewardDefine$SecurityData.DATA_KEY, AdMetricTag.FALLBACK, "getDouble", "", "getInt", "", "getLong", "", "getString", "ic-game-common-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ConfigApiExtKt {
    public static final boolean getBoolean(@NotNull IICGameConfigApi iICGameConfigApi, @NotNull String key, @NotNull String dataKey, boolean z16) {
        Intrinsics.checkNotNullParameter(iICGameConfigApi, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        return iICGameConfigApi.getSinglePrimaryData(key, dataKey).getBoolean(z16);
    }

    public static final double getDouble(@NotNull IICGameConfigApi iICGameConfigApi, @NotNull String key, @NotNull String dataKey, double d16) {
        Intrinsics.checkNotNullParameter(iICGameConfigApi, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        return iICGameConfigApi.getSinglePrimaryData(key, dataKey).getDouble(d16);
    }

    public static final int getInt(@NotNull IICGameConfigApi iICGameConfigApi, @NotNull String key, @NotNull String dataKey, int i3) {
        Intrinsics.checkNotNullParameter(iICGameConfigApi, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        return iICGameConfigApi.getSinglePrimaryData(key, dataKey).getInt(i3);
    }

    public static final long getLong(@NotNull IICGameConfigApi iICGameConfigApi, @NotNull String key, @NotNull String dataKey, long j3) {
        Intrinsics.checkNotNullParameter(iICGameConfigApi, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        return iICGameConfigApi.getSinglePrimaryData(key, dataKey).getLong(j3);
    }

    @NotNull
    public static final String getString(@NotNull IICGameConfigApi iICGameConfigApi, @NotNull String key, @NotNull String dataKey, @NotNull String fallback) {
        Intrinsics.checkNotNullParameter(iICGameConfigApi, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        return iICGameConfigApi.getSinglePrimaryData(key, dataKey).getString(fallback);
    }
}
