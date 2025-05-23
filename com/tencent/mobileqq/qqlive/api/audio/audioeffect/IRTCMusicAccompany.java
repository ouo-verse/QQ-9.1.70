package com.tencent.mobileqq.qqlive.api.audio.audioeffect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IRTCMusicAccompany extends IRTCAuxiliaryEffect {
    void enableMixPublish(boolean z16);

    long getCurrentPositionMs();

    long getDurationMs();

    void pause() throws IllegalStateException;

    void resume() throws IllegalStateException;

    void setListener(@Nullable IRTCMusicAccompanyListener iRTCMusicAccompanyListener);

    void setLocalVolume(int i3);

    void setLoopback(boolean z16);

    void setPublishVolume(int i3);

    void start(@NonNull RTCMusicAccompanyParam rTCMusicAccompanyParam) throws IllegalArgumentException, IllegalStateException;

    void stop();

    void switchAccompanyType(int i3) throws IllegalStateException;
}
