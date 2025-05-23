package com.tencent.icgame.game.liveroom.impl.room.profile;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/ProfileSendGiftClickEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "uid", "nickName", "", "headUrl", "(JJLjava/lang/String;Ljava/lang/String;)V", "getHeadUrl", "()Ljava/lang/String;", "getNickName", "getRoomId", "()J", "getUid", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class ProfileSendGiftClickEvent extends SimpleBaseEvent {

    @NotNull
    private final String headUrl;

    @NotNull
    private final String nickName;
    private final long roomId;
    private final long uid;

    public ProfileSendGiftClickEvent(long j3, long j16, @NotNull String nickName, @NotNull String headUrl) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        this.roomId = j3;
        this.uid = j16;
        this.nickName = nickName;
        this.headUrl = headUrl;
    }

    @NotNull
    public final String getHeadUrl() {
        return this.headUrl;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getUid() {
        return this.uid;
    }
}
