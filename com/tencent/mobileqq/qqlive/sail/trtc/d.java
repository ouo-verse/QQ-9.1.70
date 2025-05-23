package com.tencent.mobileqq.qqlive.sail.trtc;

import android.widget.FrameLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u0005H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/d;", "", "", "roomId", "userId", "", "connectRemote", "", "uid", "Landroid/widget/FrameLayout;", "videoView", "startRemoteView", "stopRemoteView", "", "mute", "muteRemoteAudio", "disconnectRemote", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface d {
    void connectRemote(long roomId, long userId);

    void disconnectRemote();

    void muteRemoteAudio(@NotNull String userId, boolean mute);

    void startRemoteView(@NotNull String uid, @NotNull FrameLayout videoView);

    void stopRemoteView(@NotNull String uid);
}
