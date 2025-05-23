package com.tencent.icgame.game.liveroom.impl.room.audience.preload;

import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/audience/preload/a;", "Lg32/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "c", "J", "()J", "roomId", "d", "Ljava/lang/String;", "()Ljava/lang/String;", AppConstants.Key.KEY_QZONE_VIDEO_URL, "<init>", "(JLjava/lang/String;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.icgame.game.liveroom.impl.room.audience.preload.a, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class ExitRoomAndPreloadSucEvent extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String videoUrl;

    public ExitRoomAndPreloadSucEvent(long j3, @NotNull String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        this.roomId = j3;
        this.videoUrl = videoUrl;
    }

    /* renamed from: c, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExitRoomAndPreloadSucEvent)) {
            return false;
        }
        ExitRoomAndPreloadSucEvent exitRoomAndPreloadSucEvent = (ExitRoomAndPreloadSucEvent) other;
        if (this.roomId == exitRoomAndPreloadSucEvent.roomId && Intrinsics.areEqual(this.videoUrl, exitRoomAndPreloadSucEvent.videoUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.roomId) * 31) + this.videoUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExitRoomAndPreloadSucEvent(roomId=" + this.roomId + ", videoUrl=" + this.videoUrl + ")";
    }
}
