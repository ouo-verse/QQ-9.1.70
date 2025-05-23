package k22;

import android.util.Size;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.icgame.game.api.live.BaseGameLiveAudienceView;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lk22/f;", "", "Lk22/d;", "Lk22/e;", "Lcom/tencent/icgame/game/api/live/BaseGameLiveAudienceView$a;", "listener", "", "d", "Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "c", "", MiniChatConstants.MINI_APP_LANDSCAPE, "a", "shouldExitRoom", "b", "t", "Lcom/tencent/icgame/game/api/live/BaseGameLiveAudienceView$a;", "liveViewListener", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f implements d, e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private BaseGameLiveAudienceView.a liveViewListener;

    @Override // k22.e
    public void a(boolean isLandscape) {
        BaseGameLiveAudienceView.a aVar = this.liveViewListener;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveViewListener");
            aVar = null;
        }
        aVar.a(isLandscape);
    }

    @Override // k22.d
    public void b(boolean shouldExitRoom) {
        BaseGameLiveAudienceView.a aVar = this.liveViewListener;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveViewListener");
            aVar = null;
        }
        aVar.b(shouldExitRoom);
    }

    @Override // k22.e
    public void c(@NotNull Size videoSize) {
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        BaseGameLiveAudienceView.a aVar = this.liveViewListener;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveViewListener");
            aVar = null;
        }
        aVar.c(videoSize);
    }

    public void d(@NotNull BaseGameLiveAudienceView.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.liveViewListener = listener;
    }

    @Override // k22.d
    public boolean t() {
        BaseGameLiveAudienceView.a aVar = this.liveViewListener;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveViewListener");
            aVar = null;
        }
        return aVar.d();
    }
}
