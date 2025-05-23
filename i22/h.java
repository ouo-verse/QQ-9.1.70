package i22;

import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Li22/h;", "Lg32/b;", "", "c", "J", "d", "()J", "roomId", "", "Ljava/lang/String;", "e", "()Ljava/lang/String;", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "()Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "<init>", "(JLjava/lang/String;Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String videoUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LiveRoomExtraInfo extraInfo;

    public h(long j3, @Nullable String str, @Nullable LiveRoomExtraInfo liveRoomExtraInfo) {
        this.roomId = j3;
        this.videoUrl = str;
        this.extraInfo = liveRoomExtraInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final LiveRoomExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    /* renamed from: d, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }
}
