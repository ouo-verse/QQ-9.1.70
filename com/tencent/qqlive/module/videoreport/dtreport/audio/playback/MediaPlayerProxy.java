package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.MediaPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

/* loaded from: classes22.dex */
class MediaPlayerProxy extends BaseAudioPlayerProxy implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaPlayerProxy(IAudioPlayer iAudioPlayer) {
        super(iAudioPlayer);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        onAudioCompletion(this.mAudioPlayer);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        return onAudioError(this.mAudioPlayer, i3, i16);
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
        return onAudioInfo(this.mAudioPlayer, i3, i16);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        onAudioPrepared(this.mAudioPlayer);
    }
}
