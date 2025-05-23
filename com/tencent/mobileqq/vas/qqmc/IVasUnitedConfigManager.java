package com.tencent.mobileqq.vas.qqmc;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0019\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007H&\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/IVasUnitedConfigManager;", "", "isSwitchOn", "", AdMetricTag.FALLBACK, "loadConfig", "T", "Lcom/tencent/freesia/IConfigData;", "()Lcom/tencent/freesia/IConfigData;", "loadRawConfig", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IVasUnitedConfigManager {
    boolean isSwitchOn(boolean fallback);

    @Nullable
    <T extends IConfigData> T loadConfig();

    @Nullable
    byte[] loadRawConfig(@NotNull byte[] fallback);
}
