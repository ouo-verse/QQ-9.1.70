package com.tencent.icgame.game.gift.impl.timi;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "giftMsg", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "roomId", "", WadlProxyConsts.SCENE_ID, "", "(Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;JI)V", "getGiftMsg", "()Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "getRoomId", "()J", "getSceneId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class TimiGiftEvent extends SimpleBaseEvent {

    @NotNull
    private final GiftMessage giftMsg;
    private final long roomId;
    private final int sceneId;

    public TimiGiftEvent(@NotNull GiftMessage giftMsg, long j3, int i3) {
        Intrinsics.checkNotNullParameter(giftMsg, "giftMsg");
        this.giftMsg = giftMsg;
        this.roomId = j3;
        this.sceneId = i3;
    }

    public static /* synthetic */ TimiGiftEvent copy$default(TimiGiftEvent timiGiftEvent, GiftMessage giftMessage, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            giftMessage = timiGiftEvent.giftMsg;
        }
        if ((i16 & 2) != 0) {
            j3 = timiGiftEvent.roomId;
        }
        if ((i16 & 4) != 0) {
            i3 = timiGiftEvent.sceneId;
        }
        return timiGiftEvent.copy(giftMessage, j3, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final GiftMessage getGiftMsg() {
        return this.giftMsg;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    @NotNull
    public final TimiGiftEvent copy(@NotNull GiftMessage giftMsg, long roomId, int sceneId) {
        Intrinsics.checkNotNullParameter(giftMsg, "giftMsg");
        return new TimiGiftEvent(giftMsg, roomId, sceneId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimiGiftEvent)) {
            return false;
        }
        TimiGiftEvent timiGiftEvent = (TimiGiftEvent) other;
        if (Intrinsics.areEqual(this.giftMsg, timiGiftEvent.giftMsg) && this.roomId == timiGiftEvent.roomId && this.sceneId == timiGiftEvent.sceneId) {
            return true;
        }
        return false;
    }

    @NotNull
    public final GiftMessage getGiftMsg() {
        return this.giftMsg;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final int getSceneId() {
        return this.sceneId;
    }

    public int hashCode() {
        return (((this.giftMsg.hashCode() * 31) + a.a(this.roomId)) * 31) + this.sceneId;
    }

    @NotNull
    public String toString() {
        return "TimiGiftEvent(giftMsg=" + this.giftMsg + ", roomId=" + this.roomId + ", sceneId=" + this.sceneId + ")";
    }
}
