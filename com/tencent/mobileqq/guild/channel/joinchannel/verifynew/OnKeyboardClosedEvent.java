package com.tencent.mobileqq.guild.channel.joinchannel.verifynew;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/OnKeyboardClosedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "reason", "", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final /* data */ class OnKeyboardClosedEvent extends SimpleBaseEvent {

    @NotNull
    private final String reason;

    public OnKeyboardClosedEvent(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.reason = reason;
    }

    public static /* synthetic */ OnKeyboardClosedEvent copy$default(OnKeyboardClosedEvent onKeyboardClosedEvent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = onKeyboardClosedEvent.reason;
        }
        return onKeyboardClosedEvent.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    @NotNull
    public final OnKeyboardClosedEvent copy(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        return new OnKeyboardClosedEvent(reason);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof OnKeyboardClosedEvent) && Intrinsics.areEqual(this.reason, ((OnKeyboardClosedEvent) other).reason)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        return this.reason.hashCode();
    }

    @NotNull
    public String toString() {
        return "OnKeyboardClosedEvent(reason=" + this.reason + ")";
    }
}
