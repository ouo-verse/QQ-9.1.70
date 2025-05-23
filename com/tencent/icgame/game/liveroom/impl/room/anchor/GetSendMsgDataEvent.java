package com.tencent.icgame.game.liveroom.impl.room.anchor;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nR\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/anchor/GetSendMsgDataEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "text", "", "extDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;", "(JLjava/lang/String;Ljava/util/ArrayList;)V", "getExtDataList", "()Ljava/util/ArrayList;", "getRoomId", "()J", "getText", "()Ljava/lang/String;", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class GetSendMsgDataEvent extends SimpleBaseEvent {

    @NotNull
    private final ArrayList<LiveMessageData.ExtData> extDataList;
    private final long roomId;

    @NotNull
    private final String text;

    public GetSendMsgDataEvent(long j3, @NotNull String text, @NotNull ArrayList<LiveMessageData.ExtData> extDataList) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(extDataList, "extDataList");
        this.roomId = j3;
        this.text = text;
        this.extDataList = extDataList;
    }

    @NotNull
    public final ArrayList<LiveMessageData.ExtData> getExtDataList() {
        return this.extDataList;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
