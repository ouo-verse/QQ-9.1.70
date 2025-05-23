package com.tencent.timi.game.component.qqlive.impl.anchor;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/component/qqlive/impl/anchor/QQLiveEndLiveEventByAdmin;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "result", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "", "(Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;Ljava/lang/String;)V", "getCloseReason", "()Ljava/lang/String;", "getResult", "()Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class QQLiveEndLiveEventByAdmin extends SimpleBaseEvent {

    @NotNull
    private final String closeReason;

    @NotNull
    private final EndPageRealTimeInfo result;

    public QQLiveEndLiveEventByAdmin(@NotNull EndPageRealTimeInfo result, @NotNull String closeReason) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        this.result = result;
        this.closeReason = closeReason;
    }

    @NotNull
    public final String getCloseReason() {
        return this.closeReason;
    }

    @NotNull
    public final EndPageRealTimeInfo getResult() {
        return this.result;
    }
}
