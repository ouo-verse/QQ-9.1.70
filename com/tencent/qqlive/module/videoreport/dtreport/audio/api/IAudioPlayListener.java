package com.tencent.qqlive.module.videoreport.dtreport.audio.api;

import android.support.annotation.NonNull;

/* loaded from: classes22.dex */
public interface IAudioPlayListener {
    void onAudioComplete(@NonNull IAudioPlayer iAudioPlayer);

    void onAudioError(@NonNull IAudioPlayer iAudioPlayer, int i3, int i16);

    void onAudioPause(IAudioPlayer iAudioPlayer);

    void onAudioStart(boolean z16, @NonNull IAudioPlayer iAudioPlayer);

    void onAudioStop(@NonNull IAudioPlayer iAudioPlayer);

    void onBufferingEnd(@NonNull IAudioPlayer iAudioPlayer);

    void onBufferingStart(@NonNull IAudioPlayer iAudioPlayer);
}
