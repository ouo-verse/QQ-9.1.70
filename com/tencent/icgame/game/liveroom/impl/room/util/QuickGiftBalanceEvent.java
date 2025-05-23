package com.tencent.icgame.game.liveroom.impl.room.util;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/util/QuickGiftBalanceEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "success", "", "errCode", "", "errMsg", "", "(ZILjava/lang/String;)V", "getErrCode", "()I", "setErrCode", "(I)V", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class QuickGiftBalanceEvent extends SimpleBaseEvent {
    private int errCode;

    @NotNull
    private String errMsg;
    private final boolean success;

    public QuickGiftBalanceEvent(boolean z16, int i3, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.success = z16;
        this.errCode = i3;
        this.errMsg = errMsg;
    }

    public static /* synthetic */ QuickGiftBalanceEvent copy$default(QuickGiftBalanceEvent quickGiftBalanceEvent, boolean z16, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = quickGiftBalanceEvent.success;
        }
        if ((i16 & 2) != 0) {
            i3 = quickGiftBalanceEvent.errCode;
        }
        if ((i16 & 4) != 0) {
            str = quickGiftBalanceEvent.errMsg;
        }
        return quickGiftBalanceEvent.copy(z16, i3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @NotNull
    public final QuickGiftBalanceEvent copy(boolean success, int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        return new QuickGiftBalanceEvent(success, errCode, errMsg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuickGiftBalanceEvent)) {
            return false;
        }
        QuickGiftBalanceEvent quickGiftBalanceEvent = (QuickGiftBalanceEvent) other;
        if (this.success == quickGiftBalanceEvent.success && this.errCode == quickGiftBalanceEvent.errCode && Intrinsics.areEqual(this.errMsg, quickGiftBalanceEvent.errMsg)) {
            return true;
        }
        return false;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    @NotNull
    public final String getErrMsg() {
        return this.errMsg;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.errCode) * 31) + this.errMsg.hashCode();
    }

    public final void setErrCode(int i3) {
        this.errCode = i3;
    }

    public final void setErrMsg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    @NotNull
    public String toString() {
        return "QuickGiftBalanceEvent(success=" + this.success + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
    }
}
