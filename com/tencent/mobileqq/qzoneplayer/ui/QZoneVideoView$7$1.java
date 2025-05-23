package com.tencent.mobileqq.qzoneplayer.ui;

import com.tencent.oskplayer.util.PlayerUtils;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: P */
/* loaded from: classes35.dex */
class QZoneVideoView$7$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final IMediaPlayer f279558d;

    @Override // java.lang.Runnable
    public void run() {
        IMediaPlayer iMediaPlayer = this.f279558d;
        if (iMediaPlayer != null) {
            try {
                iMediaPlayer.pause();
            } catch (IMediaPlayer.InternalOperationException e16) {
                PlayerUtils.log(6, "QZoneVideoView", e16.toString());
            }
        }
    }
}
