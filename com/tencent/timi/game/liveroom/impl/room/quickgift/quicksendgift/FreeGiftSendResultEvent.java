package com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/FreeGiftSendResultEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "success", "", "isPackage", "(ZZ)V", "()Z", "getSuccess", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final /* data */ class FreeGiftSendResultEvent extends SimpleBaseEvent {
    private final boolean isPackage;
    private final boolean success;

    public FreeGiftSendResultEvent(boolean z16, boolean z17) {
        this.success = z16;
        this.isPackage = z17;
    }

    public static /* synthetic */ FreeGiftSendResultEvent copy$default(FreeGiftSendResultEvent freeGiftSendResultEvent, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = freeGiftSendResultEvent.success;
        }
        if ((i3 & 2) != 0) {
            z17 = freeGiftSendResultEvent.isPackage;
        }
        return freeGiftSendResultEvent.copy(z16, z17);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsPackage() {
        return this.isPackage;
    }

    @NotNull
    public final FreeGiftSendResultEvent copy(boolean success, boolean isPackage) {
        return new FreeGiftSendResultEvent(success, isPackage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FreeGiftSendResultEvent)) {
            return false;
        }
        FreeGiftSendResultEvent freeGiftSendResultEvent = (FreeGiftSendResultEvent) other;
        if (this.success == freeGiftSendResultEvent.success && this.isPackage == freeGiftSendResultEvent.isPackage) {
            return true;
        }
        return false;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.success;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.isPackage;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i16 + i3;
    }

    public final boolean isPackage() {
        return this.isPackage;
    }

    @NotNull
    public String toString() {
        return "FreeGiftSendResultEvent(success=" + this.success + ", isPackage=" + this.isPackage + ")";
    }
}
