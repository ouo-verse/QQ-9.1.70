package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AudioListeners {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    interface OnPlayCompletionListener {
        void onAudioPlayComplete(IAudioPlayer iAudioPlayer);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    interface OnPlayErrorListener {
        boolean onAudioError(IAudioPlayer iAudioPlayer, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    interface OnPlayInfoListener {
        boolean onAudioInfo(IAudioPlayer iAudioPlayer, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    interface OnPlayPreparedListener {
        void onAudioPlayPrepared(IAudioPlayer iAudioPlayer);
    }

    AudioListeners() {
    }
}
