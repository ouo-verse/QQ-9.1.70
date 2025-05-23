package ei2;

import android.widget.FrameLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lei2/a;", "", "", "roomId", "userId", "", "connectRemote", "disconnectRemote", "", "uid", "Landroid/widget/FrameLayout;", "videoView", "startRemoteView", "stopRemoteView", "", "mute", "muteRemoteAudio", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface a {
    void connectRemote(long roomId, long userId);

    void disconnectRemote();

    void muteRemoteAudio(@NotNull String userId, boolean mute);

    void startRemoteView(@NotNull String uid, @NotNull FrameLayout videoView);

    void stopRemoteView(@NotNull String uid);
}
