package com.tencent.mobileqq.guild.media.thirdapp;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;", "appInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyStateInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyStateInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyStateInfo;", "roomInfo", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyStateInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProLobbyAppInfo appInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProLobbyStateInfo roomInfo;

    public d(@NotNull IGProLobbyAppInfo appInfo, @NotNull IGProLobbyStateInfo roomInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        this.appInfo = appInfo;
        this.roomInfo = roomInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final IGProLobbyAppInfo getAppInfo() {
        return this.appInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final IGProLobbyStateInfo getRoomInfo() {
        return this.roomInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.appInfo, dVar.appInfo) && Intrinsics.areEqual(this.roomInfo, dVar.roomInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.appInfo.hashCode() * 31) + this.roomInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "appId[" + this.appInfo.getAppId() + "] screenMode[" + this.appInfo.getScreenMode() + "] lobbyId[" + this.roomInfo.getLobbyId() + "] userCount[" + this.roomInfo.getLobbyRoomCurrUserNum() + "]";
    }
}
