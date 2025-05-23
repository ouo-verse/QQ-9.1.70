package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioListeners;

/* loaded from: classes22.dex */
public interface IAudioPlayerProxy {
    boolean isPaused();

    void onAudioCompletion(IAudioPlayer iAudioPlayer);

    boolean onAudioError(IAudioPlayer iAudioPlayer, int i3, int i16);

    boolean onAudioInfo(IAudioPlayer iAudioPlayer, int i3, int i16);

    void onAudioPrepared(IAudioPlayer iAudioPlayer);

    void pause();

    void prepare();

    void reset();

    void setOnCompletionListener(AudioListeners.OnPlayCompletionListener onPlayCompletionListener);

    void setOnErrorListener(AudioListeners.OnPlayErrorListener onPlayErrorListener);

    void setOnInfoListener(AudioListeners.OnPlayInfoListener onPlayInfoListener);

    void setOnPreparedListener(AudioListeners.OnPlayPreparedListener onPlayPreparedListener);

    void start();

    void stop();
}
