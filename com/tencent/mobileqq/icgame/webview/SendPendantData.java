package com.tencent.mobileqq.icgame.webview;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/webview/SendPendantData;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "cmd", "", "(Ljava/lang/String;)V", "getCmd", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ic-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final /* data */ class SendPendantData extends SimpleBaseEvent {

    @NotNull
    private final String cmd;

    public SendPendantData(@NotNull String cmd) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        this.cmd = cmd;
    }

    public static /* synthetic */ SendPendantData copy$default(SendPendantData sendPendantData, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sendPendantData.cmd;
        }
        return sendPendantData.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCmd() {
        return this.cmd;
    }

    @NotNull
    public final SendPendantData copy(@NotNull String cmd) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        return new SendPendantData(cmd);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SendPendantData) && Intrinsics.areEqual(this.cmd, ((SendPendantData) other).cmd)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCmd() {
        return this.cmd;
    }

    public int hashCode() {
        return this.cmd.hashCode();
    }

    @NotNull
    public String toString() {
        return "SendPendantData(cmd=" + this.cmd + ')';
    }
}
