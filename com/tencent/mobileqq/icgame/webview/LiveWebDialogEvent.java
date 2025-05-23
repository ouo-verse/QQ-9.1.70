package com.tencent.mobileqq.icgame.webview;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/icgame/webview/LiveWebDialogEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "cmd", "", "url", "hashKey", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCmd", "()Ljava/lang/String;", "getHashKey", "()I", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ic-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final /* data */ class LiveWebDialogEvent extends SimpleBaseEvent {

    @NotNull
    private final String cmd;
    private final int hashKey;

    @NotNull
    private final String url;

    public LiveWebDialogEvent(@NotNull String cmd, @NotNull String url, int i3) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(url, "url");
        this.cmd = cmd;
        this.url = url;
        this.hashKey = i3;
    }

    public static /* synthetic */ LiveWebDialogEvent copy$default(LiveWebDialogEvent liveWebDialogEvent, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = liveWebDialogEvent.cmd;
        }
        if ((i16 & 2) != 0) {
            str2 = liveWebDialogEvent.url;
        }
        if ((i16 & 4) != 0) {
            i3 = liveWebDialogEvent.hashKey;
        }
        return liveWebDialogEvent.copy(str, str2, i3);
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
    public final int getHashKey() {
        return this.hashKey;
    }

    @NotNull
    public final LiveWebDialogEvent copy(@NotNull String cmd, @NotNull String url, int hashKey) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(url, "url");
        return new LiveWebDialogEvent(cmd, url, hashKey);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveWebDialogEvent)) {
            return false;
        }
        LiveWebDialogEvent liveWebDialogEvent = (LiveWebDialogEvent) other;
        if (Intrinsics.areEqual(this.cmd, liveWebDialogEvent.cmd) && Intrinsics.areEqual(this.url, liveWebDialogEvent.url) && this.hashKey == liveWebDialogEvent.hashKey) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCmd() {
        return this.cmd;
    }

    public final int getHashKey() {
        return this.hashKey;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.cmd.hashCode() * 31) + this.url.hashCode()) * 31) + this.hashKey;
    }

    @NotNull
    public String toString() {
        return "LiveWebDialogEvent(cmd=" + this.cmd + ", url=" + this.url + ", hashKey=" + this.hashKey + ')';
    }
}
