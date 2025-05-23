package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

/* loaded from: classes22.dex */
class AudioProgressTimer {
    private IAudioPlayer mAudioPlayer;
    private IAudioPlayerProxy mAudioPlayerProxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"HandlerLeak"})
    public AudioProgressTimer(@NonNull IAudioPlayer iAudioPlayer, @NonNull IAudioPlayerProxy iAudioPlayerProxy) {
        this.mAudioPlayer = iAudioPlayer;
        this.mAudioPlayerProxy = iAudioPlayerProxy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void start() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void stop() {
    }
}
