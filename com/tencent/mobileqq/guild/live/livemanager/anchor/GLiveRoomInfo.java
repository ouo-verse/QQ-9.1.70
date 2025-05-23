package com.tencent.mobileqq.guild.live.livemanager.anchor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/anchor/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setRoomTitle", "(Ljava/lang/String;)V", "roomTitle", "setRoomCover", "roomCover", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.live.livemanager.anchor.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GLiveRoomInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String roomTitle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String roomCover;

    public GLiveRoomInfo(@NotNull String roomTitle, @NotNull String roomCover) {
        Intrinsics.checkNotNullParameter(roomTitle, "roomTitle");
        Intrinsics.checkNotNullParameter(roomCover, "roomCover");
        this.roomTitle = roomTitle;
        this.roomCover = roomCover;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getRoomCover() {
        return this.roomCover;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRoomTitle() {
        return this.roomTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GLiveRoomInfo)) {
            return false;
        }
        GLiveRoomInfo gLiveRoomInfo = (GLiveRoomInfo) other;
        if (Intrinsics.areEqual(this.roomTitle, gLiveRoomInfo.roomTitle) && Intrinsics.areEqual(this.roomCover, gLiveRoomInfo.roomCover)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.roomTitle.hashCode() * 31) + this.roomCover.hashCode();
    }

    @NotNull
    public String toString() {
        return "GLiveRoomInfo(roomTitle=" + this.roomTitle + ", roomCover=" + this.roomCover + ")";
    }
}
