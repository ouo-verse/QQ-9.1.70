package com.tencent.mobileqq.icgame.api.monitor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/monitor/IPlayerStatisticsProvider;", "", "getDownloadSizeInBytes", "", "getPlayerType", "", "getVideoUrl", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface IPlayerStatisticsProvider {
    long getDownloadSizeInBytes();

    @NotNull
    String getPlayerType();

    @NotNull
    String getVideoUrl();
}
