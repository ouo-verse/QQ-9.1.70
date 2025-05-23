package com.tencent.timi.game.liveroom.impl.room.payguide.showdialog;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/payguide/showdialog/ShowDialogEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "cmd", "", "url", "webViewHashCode", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCmd", "()Ljava/lang/String;", "getUrl", "getWebViewHashCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final /* data */ class ShowDialogEvent extends SimpleBaseEvent {

    @NotNull
    private final String cmd;

    @NotNull
    private final String url;
    private final int webViewHashCode;

    public ShowDialogEvent(@NotNull String cmd, @NotNull String url, int i3) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(url, "url");
        this.cmd = cmd;
        this.url = url;
        this.webViewHashCode = i3;
    }

    public static /* synthetic */ ShowDialogEvent copy$default(ShowDialogEvent showDialogEvent, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = showDialogEvent.cmd;
        }
        if ((i16 & 2) != 0) {
            str2 = showDialogEvent.url;
        }
        if ((i16 & 4) != 0) {
            i3 = showDialogEvent.webViewHashCode;
        }
        return showDialogEvent.copy(str, str2, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCmd() {
        return this.cmd;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWebViewHashCode() {
        return this.webViewHashCode;
    }

    @NotNull
    public final ShowDialogEvent copy(@NotNull String cmd, @NotNull String url, int webViewHashCode) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(url, "url");
        return new ShowDialogEvent(cmd, url, webViewHashCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShowDialogEvent)) {
            return false;
        }
        ShowDialogEvent showDialogEvent = (ShowDialogEvent) other;
        if (Intrinsics.areEqual(this.cmd, showDialogEvent.cmd) && Intrinsics.areEqual(this.url, showDialogEvent.url) && this.webViewHashCode == showDialogEvent.webViewHashCode) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCmd() {
        return this.cmd;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWebViewHashCode() {
        return this.webViewHashCode;
    }

    public int hashCode() {
        return (((this.cmd.hashCode() * 31) + this.url.hashCode()) * 31) + this.webViewHashCode;
    }

    @NotNull
    public String toString() {
        return "ShowDialogEvent(cmd=" + this.cmd + ", url=" + this.url + ", webViewHashCode=" + this.webViewHashCode + ")";
    }
}
