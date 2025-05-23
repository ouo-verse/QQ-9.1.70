package com.tencent.icgame.game.app.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/icgame/game/app/event/AnchorAtEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "liveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "quickTip", "", "fromPlayTogether", "", "(JLcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;Ljava/lang/String;Z)V", "getFromPlayTogether", "()Z", "getLiveUserInfo", "()Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "setLiveUserInfo", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;)V", "getQuickTip", "()Ljava/lang/String;", "setQuickTip", "(Ljava/lang/String;)V", "getRoomId", "()J", "setRoomId", "(J)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AnchorAtEvent extends SimpleBaseEvent {
    private final boolean fromPlayTogether;

    @NotNull
    private LiveUserInfo liveUserInfo;

    @NotNull
    private String quickTip;
    private long roomId;

    public /* synthetic */ AnchorAtEvent(long j3, LiveUserInfo liveUserInfo, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, liveUserInfo, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? false : z16);
    }

    public final boolean getFromPlayTogether() {
        return this.fromPlayTogether;
    }

    @NotNull
    public final LiveUserInfo getLiveUserInfo() {
        return this.liveUserInfo;
    }

    @NotNull
    public final String getQuickTip() {
        return this.quickTip;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final void setLiveUserInfo(@NotNull LiveUserInfo liveUserInfo) {
        Intrinsics.checkNotNullParameter(liveUserInfo, "<set-?>");
        this.liveUserInfo = liveUserInfo;
    }

    public final void setQuickTip(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.quickTip = str;
    }

    public final void setRoomId(long j3) {
        this.roomId = j3;
    }

    public AnchorAtEvent(long j3, @NotNull LiveUserInfo liveUserInfo, @NotNull String quickTip, boolean z16) {
        Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
        Intrinsics.checkNotNullParameter(quickTip, "quickTip");
        this.roomId = j3;
        this.liveUserInfo = liveUserInfo;
        this.quickTip = quickTip;
        this.fromPlayTogether = z16;
    }
}
