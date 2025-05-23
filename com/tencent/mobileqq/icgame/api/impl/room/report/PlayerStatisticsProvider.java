package com.tencent.mobileqq.icgame.api.impl.room.report;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.monitor.IPlayerStatisticsProvider;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/report/PlayerStatisticsProvider;", "Lb32/a;", "Lcom/tencent/mobileqq/icgame/api/monitor/IPlayerStatisticsProvider;", "Lcom/tencent/mobileqq/icgame/api/room/StreamType;", "streamType", "", "url", "Lcom/tencent/mobileqq/icgame/api/room/PlayerConfig;", "playerConfig", "", "onPreparing", "", "totalSize", "cacheSize", "cacheDuration", "speed", "onUpdateDownloadInfo", "sendBytes", "receiveBytes", "onStatistics", "getVideoUrl", "getDownloadSizeInBytes", "getPlayerType", "Lcom/tencent/mobileqq/icgame/api/room/StreamType;", "Ljava/lang/String;", "J", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "<init>", "()V", "Companion", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PlayerStatisticsProvider extends b32.a implements IPlayerStatisticsProvider {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String TAG = "PlayerStatisticsProvider";

    @NotNull
    private final IAegisLogApi aegisLogger;
    private long totalSize;

    @NotNull
    private StreamType streamType = StreamType.NONE;

    @Nullable
    private String url = "";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/report/PlayerStatisticsProvider$Companion;", "", "()V", "TAG", "", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public PlayerStatisticsProvider() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
    }

    @Override // com.tencent.mobileqq.icgame.api.monitor.IPlayerStatisticsProvider
    /* renamed from: getDownloadSizeInBytes, reason: from getter */
    public long getTotalSize() {
        return this.totalSize;
    }

    @Override // com.tencent.mobileqq.icgame.api.monitor.IPlayerStatisticsProvider
    @NotNull
    public String getPlayerType() {
        return this.streamType.name();
    }

    @Override // com.tencent.mobileqq.icgame.api.monitor.IPlayerStatisticsProvider
    @NotNull
    public String getVideoUrl() {
        String str = this.url;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // b32.a
    public void onPreparing(@NotNull StreamType streamType, @Nullable String url, @Nullable PlayerConfig playerConfig) {
        Intrinsics.checkNotNullParameter(streamType, "streamType");
        this.aegisLogger.i(TAG, "onPreparing:" + streamType.name());
        this.streamType = streamType;
        this.url = url;
    }

    @Override // b32.a
    public void onStatistics(long sendBytes, long receiveBytes) {
        long j3 = sendBytes + receiveBytes;
        this.totalSize = j3;
        this.aegisLogger.d(TAG, "onStatistics:" + j3);
    }

    @Override // b32.a
    public void onUpdateDownloadInfo(long totalSize, long cacheSize, long cacheDuration, long speed) {
        this.totalSize = totalSize;
        this.aegisLogger.d(TAG, "onUpdateDownloadInfo:" + totalSize);
    }
}
