package org.tencwebrtc.audio;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface AudioDeviceModule {
    long getNativeAudioDeviceModulePointer();

    void release();

    void setMicrophoneMute(boolean z16);

    void setSpeakerMute(boolean z16);
}
