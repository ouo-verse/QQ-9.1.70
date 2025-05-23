package com.tencent.mobileqq.icgame.room.player;

import android.view.View;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\u0004H&J\b\u0010\u001c\u001a\u00020\u0004H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/player/j;", "", "", "url", "", "a", "Landroid/view/View;", "getView", "play", "pause", "resume", "stop", "", "degree", "setVideoRotation", "Lcom/tencent/mobileqq/icgame/room/player/k;", "player", "setVideoPlayer", "Lfv0/f;", "liveGestureListener", "setGameLiveGestureListener", "Lcom/tencent/mobileqq/icgame/room/player/i;", "liveStatusListener", "setStatusListener", "b", "status", "setStatus", "onResume", DKHippyEvent.EVENT_STOP, "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface j {
    void a(@Nullable String url);

    void b(@Nullable i liveStatusListener);

    @NotNull
    View getView();

    void onResume();

    void onStop();

    void pause(@Nullable String url);

    void play(@Nullable String url);

    void resume(@Nullable String url);

    void setGameLiveGestureListener(@Nullable fv0.f liveGestureListener);

    void setStatus(int status);

    void setStatusListener(@Nullable i liveStatusListener);

    void setVideoPlayer(@NotNull k player);

    void setVideoRotation(int degree);

    void stop(@Nullable String url);
}
