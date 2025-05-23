package com.tencent.timi.game.gift.impl.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u000bH\u00c6\u0003JD\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H\u00d6\u0003J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001J\t\u0010%\u001a\u00020\u000bH\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/timi/game/gift/impl/event/GiftPanelControlEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "show", "", "triggerReason", "", "chosenUid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "roomId", "", "subSceneId", "", "(ZILtrpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/Long;Ljava/lang/String;)V", "getChosenUid", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "getRoomId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShow", "()Z", "setShow", "(Z)V", "getSubSceneId", "()Ljava/lang/String;", "getTriggerReason", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "(ZILtrpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/Long;Ljava/lang/String;)Lcom/tencent/timi/game/gift/impl/event/GiftPanelControlEvent;", "equals", "other", "", "hashCode", "toString", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final /* data */ class GiftPanelControlEvent extends SimpleBaseEvent {

    @Nullable
    private final CommonOuterClass$QQUserId chosenUid;

    @Nullable
    private final Long roomId;
    private boolean show;

    @NotNull
    private final String subSceneId;
    private final int triggerReason;

    public /* synthetic */ GiftPanelControlEvent(boolean z16, int i3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, Long l3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, i3, (i16 & 4) != 0 ? null : commonOuterClass$QQUserId, (i16 & 8) != 0 ? null : l3, str);
    }

    public static /* synthetic */ GiftPanelControlEvent copy$default(GiftPanelControlEvent giftPanelControlEvent, boolean z16, int i3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, Long l3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = giftPanelControlEvent.show;
        }
        if ((i16 & 2) != 0) {
            i3 = giftPanelControlEvent.triggerReason;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            commonOuterClass$QQUserId = giftPanelControlEvent.chosenUid;
        }
        CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = commonOuterClass$QQUserId;
        if ((i16 & 8) != 0) {
            l3 = giftPanelControlEvent.roomId;
        }
        Long l16 = l3;
        if ((i16 & 16) != 0) {
            str = giftPanelControlEvent.subSceneId;
        }
        return giftPanelControlEvent.copy(z16, i17, commonOuterClass$QQUserId2, l16, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTriggerReason() {
        return this.triggerReason;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final CommonOuterClass$QQUserId getChosenUid() {
        return this.chosenUid;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getRoomId() {
        return this.roomId;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getSubSceneId() {
        return this.subSceneId;
    }

    @NotNull
    public final GiftPanelControlEvent copy(boolean show, int triggerReason, @Nullable CommonOuterClass$QQUserId chosenUid, @Nullable Long roomId, @NotNull String subSceneId) {
        Intrinsics.checkNotNullParameter(subSceneId, "subSceneId");
        return new GiftPanelControlEvent(show, triggerReason, chosenUid, roomId, subSceneId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftPanelControlEvent)) {
            return false;
        }
        GiftPanelControlEvent giftPanelControlEvent = (GiftPanelControlEvent) other;
        if (this.show == giftPanelControlEvent.show && this.triggerReason == giftPanelControlEvent.triggerReason && Intrinsics.areEqual(this.chosenUid, giftPanelControlEvent.chosenUid) && Intrinsics.areEqual(this.roomId, giftPanelControlEvent.roomId) && Intrinsics.areEqual(this.subSceneId, giftPanelControlEvent.subSceneId)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final CommonOuterClass$QQUserId getChosenUid() {
        return this.chosenUid;
    }

    @Nullable
    public final Long getRoomId() {
        return this.roomId;
    }

    public final boolean getShow() {
        return this.show;
    }

    @NotNull
    public final String getSubSceneId() {
        return this.subSceneId;
    }

    public final int getTriggerReason() {
        return this.triggerReason;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.show;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = ((r06 * 31) + this.triggerReason) * 31;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.chosenUid;
        int i16 = 0;
        if (commonOuterClass$QQUserId == null) {
            hashCode = 0;
        } else {
            hashCode = commonOuterClass$QQUserId.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        Long l3 = this.roomId;
        if (l3 != null) {
            i16 = l3.hashCode();
        }
        return ((i17 + i16) * 31) + this.subSceneId.hashCode();
    }

    public final void setShow(boolean z16) {
        this.show = z16;
    }

    @NotNull
    public String toString() {
        return "GiftPanelControlEvent(show=" + this.show + ", triggerReason=" + this.triggerReason + ", chosenUid=" + this.chosenUid + ", roomId=" + this.roomId + ", subSceneId=" + this.subSceneId + ")";
    }

    public GiftPanelControlEvent(boolean z16, int i3, @Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId, @Nullable Long l3, @NotNull String subSceneId) {
        Intrinsics.checkNotNullParameter(subSceneId, "subSceneId");
        this.show = z16;
        this.triggerReason = i3;
        this.chosenUid = commonOuterClass$QQUserId;
        this.roomId = l3;
        this.subSceneId = subSceneId;
    }
}
