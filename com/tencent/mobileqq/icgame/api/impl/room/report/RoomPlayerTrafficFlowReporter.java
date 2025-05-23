package com.tencent.mobileqq.icgame.api.impl.room.report;

import com.tencent.icgame.common.monitor.i;
import com.tencent.mobileqq.icgame.api.monitor.IPlayerStatisticsProvider;
import com.tencent.mobileqq.icgame.api.monitor.IPlayerTrafficFlowReporter;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqperf.reporter.flow.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u0014\u0010\u0017\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00038TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/report/RoomPlayerTrafficFlowReporter;", "Lcom/tencent/icgame/common/monitor/i;", "Lcom/tencent/mobileqq/icgame/api/monitor/IPlayerTrafficFlowReporter;", "", "scene", "entrancePath", "", "report", "Lcom/tencent/qqperf/reporter/flow/b$a;", "createReportParamsBuilder", "updateMediaSize", "resetMediaSize", "", "getMediaSize", "onFirstFrameCome", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onNetWifi2Mobile", "onNetNone2Mobile", "onNetMobile2Wifi", "onNetMobile2None", "onProcess2Background", "onPeriodicallyTrigger", "unInit", "businessScene", "Ljava/lang/String;", "Lcom/tencent/mobileqq/icgame/api/monitor/IPlayerStatisticsProvider;", "playerStatisticsProvider", "Lcom/tencent/mobileqq/icgame/api/monitor/IPlayerStatisticsProvider;", "mediaSizeInByte", "J", "getScene", "()Ljava/lang/String;", "getTAG", "TAG", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/icgame/api/monitor/IPlayerStatisticsProvider;)V", "Companion", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class RoomPlayerTrafficFlowReporter extends i implements IPlayerTrafficFlowReporter {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final String ENTRANCE_PLAYER_PAUSE = "entrance_player_pause";

    @NotNull
    private final String businessScene;
    private long mediaSizeInByte;

    @NotNull
    private final IPlayerStatisticsProvider playerStatisticsProvider;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/report/RoomPlayerTrafficFlowReporter$Companion;", "", "()V", "ENTRANCE_PLAYER_PAUSE", "", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public RoomPlayerTrafficFlowReporter(@NotNull String businessScene, @NotNull IPlayerStatisticsProvider playerStatisticsProvider) {
        Intrinsics.checkNotNullParameter(businessScene, "businessScene");
        Intrinsics.checkNotNullParameter(playerStatisticsProvider, "playerStatisticsProvider");
        this.businessScene = businessScene;
        this.playerStatisticsProvider = playerStatisticsProvider;
        this.mediaSizeInByte = -1L;
    }

    private final b.a createReportParamsBuilder() {
        b.a f16 = new b.a().b(7).g(1).k(this.playerStatisticsProvider.getVideoUrl()).f(Foreground.isCurrentProcessForeground() ? 1 : 0);
        Intrinsics.checkNotNullExpressionValue(f16, "Builder()\n              \u2026sForeground(isForeground)");
        return f16;
    }

    private final long getMediaSize() {
        return this.playerStatisticsProvider.getTotalSize();
    }

    private final String getScene() {
        return this.businessScene + "_" + this.playerStatisticsProvider.getPlayerType();
    }

    private final void report(String scene, String entrancePath) {
        if (this.mediaSizeInByte == -1) {
            getLogger().w(getTAG(), "illegal state,video size not init");
            return;
        }
        long mediaSize = getMediaSize() - this.mediaSizeInByte;
        getLogger().i(getTAG(), "report -> lastDownloadedVideoSizeInByte:" + this.mediaSizeInByte + ",downloadSizeInByte:" + mediaSize);
        if (mediaSize <= 0) {
            getLogger().i(getTAG(), "no need report");
            return;
        }
        b reportParams = createReportParamsBuilder().c(scene).d(entrancePath).e(String.valueOf(byte2KByte(mediaSize))).a();
        Intrinsics.checkNotNullExpressionValue(reportParams, "reportParams");
        report(reportParams);
    }

    private final void resetMediaSize() {
        this.mediaSizeInByte = -1L;
    }

    private final void updateMediaSize() {
        this.mediaSizeInByte = getMediaSize();
        getLogger().i(getTAG(), "update media size:" + this.mediaSizeInByte);
    }

    @Override // com.tencent.icgame.common.monitor.i
    @NotNull
    protected String getTAG() {
        return "PlayerTrafficFlowReporter@" + hashCode();
    }

    @Override // com.tencent.mobileqq.icgame.api.monitor.IPlayerTrafficFlowReporter
    public void onFirstFrameCome() {
        if (isMobileNetwork()) {
            getLogger().i(getTAG(), "onPlayerFirstFrameCome->mobile conn");
            updateMediaSize();
        }
    }

    @Override // com.tencent.icgame.common.monitor.i
    protected void onNetMobile2None() {
        report(getScene(), "entrance_net_change_mobile_2_none");
        resetMediaSize();
    }

    @Override // com.tencent.icgame.common.monitor.i
    protected void onNetMobile2Wifi() {
        report(getScene(), "entrance_net_change_mobile_2_wifi");
        resetMediaSize();
    }

    @Override // com.tencent.icgame.common.monitor.i
    protected void onNetNone2Mobile() {
        updateMediaSize();
    }

    @Override // com.tencent.icgame.common.monitor.i
    protected void onNetWifi2Mobile() {
        updateMediaSize();
    }

    @Override // com.tencent.mobileqq.icgame.api.monitor.IPlayerTrafficFlowReporter
    public void onPause() {
        if (isMobileNetwork()) {
            getLogger().i(getTAG(), "onPlayerPause->mobile conn");
            report(getScene(), ENTRANCE_PLAYER_PAUSE);
            updateMediaSize();
        }
    }

    @Override // com.tencent.icgame.common.monitor.i
    protected void onPeriodicallyTrigger() {
        boolean isMobileNetwork = isMobileNetwork();
        getLogger().i(getTAG(), "onPeriodicallyTrigger->isMobileNet:" + isMobileNetwork + " ");
        if (isMobileNetwork) {
            report(getScene(), i.ENTRANCE_PERIODICALLY_TRIGGER);
            updateMediaSize();
        }
    }

    @Override // com.tencent.icgame.common.monitor.i
    protected void onProcess2Background() {
        boolean isMobileNetwork = isMobileNetwork();
        getLogger().i(getTAG(), "onProcess2Background->isMobileNet:" + isMobileNetwork + " ");
        if (isMobileNetwork) {
            report(getScene(), "entrance_process_change_foreground_2_background");
            updateMediaSize();
        }
    }

    @Override // com.tencent.icgame.common.monitor.i, com.tencent.mobileqq.icgame.api.monitor.IPlayerTrafficFlowReporter
    public void unInit() {
        super.unInit();
        resetMediaSize();
    }
}
