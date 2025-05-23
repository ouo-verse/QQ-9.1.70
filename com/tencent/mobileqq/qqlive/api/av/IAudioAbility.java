package com.tencent.mobileqq.qqlive.api.av;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IAudioAbility {
    void addAudioVolumeListener(@NonNull AudioVolumeListener audioVolumeListener);

    void addUserAudioAvailableListener(@NonNull UserAudioAvailableListener userAudioAvailableListener);

    void addVoiceRoomListener(@NonNull VoiceRoomListener voiceRoomListener);

    void enableMic(boolean z16);

    boolean isMicEnable();

    void muteUserVoice(String str, boolean z16);

    void releaseTrtc();

    void removeAudioVolumeListener(@NonNull AudioVolumeListener audioVolumeListener);

    void removeUserAudioAvailableListener(@NonNull UserAudioAvailableListener userAudioAvailableListener);

    void removeVoiceRoomListener(@NonNull VoiceRoomListener voiceRoomListener);

    void startSpeaking();

    void stopSpeaking();
}
