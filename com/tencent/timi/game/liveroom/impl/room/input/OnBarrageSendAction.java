package com.tencent.timi.game.liveroom.impl.room.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$MsgContent;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u0010\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/w;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/timi/game/liveroom/impl/room/input/y;", "a", "Lcom/tencent/timi/game/liveroom/impl/room/input/y;", "d", "()Lcom/tencent/timi/game/liveroom/impl/room/input/y;", "result", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "b", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "()Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "barrageData", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "()Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/input/y;Lcom/tencent/timi/game/liveroom/impl/room/input/o;Ljava/lang/String;Ltrpc/yes/common/MessageOuterClass$MsgContent;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.input.w, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class OnBarrageSendAction {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SendResult result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final BarrageData barrageData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String message;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final MessageOuterClass$MsgContent content;

    public OnBarrageSendAction(@NotNull SendResult result, @Nullable BarrageData barrageData, @Nullable String str, @Nullable MessageOuterClass$MsgContent messageOuterClass$MsgContent) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
        this.barrageData = barrageData;
        this.message = str;
        this.content = messageOuterClass$MsgContent;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final BarrageData getBarrageData() {
        return this.barrageData;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final MessageOuterClass$MsgContent getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final SendResult getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnBarrageSendAction)) {
            return false;
        }
        OnBarrageSendAction onBarrageSendAction = (OnBarrageSendAction) other;
        if (Intrinsics.areEqual(this.result, onBarrageSendAction.result) && Intrinsics.areEqual(this.barrageData, onBarrageSendAction.barrageData) && Intrinsics.areEqual(this.message, onBarrageSendAction.message) && Intrinsics.areEqual(this.content, onBarrageSendAction.content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.result.hashCode() * 31;
        BarrageData barrageData = this.barrageData;
        int i3 = 0;
        if (barrageData == null) {
            hashCode = 0;
        } else {
            hashCode = barrageData.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        String str = this.message;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = this.content;
        if (messageOuterClass$MsgContent != null) {
            i3 = messageOuterClass$MsgContent.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "OnBarrageSendAction(result=" + this.result + ", barrageData=" + this.barrageData + ", message=" + this.message + ", content=" + this.content + ")";
    }

    public /* synthetic */ OnBarrageSendAction(SendResult sendResult, BarrageData barrageData, String str, MessageOuterClass$MsgContent messageOuterClass$MsgContent, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(sendResult, (i3 & 2) != 0 ? null : barrageData, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : messageOuterClass$MsgContent);
    }
}
