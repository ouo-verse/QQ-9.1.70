package com.tencent.avcore.engine.common;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAVEngineCommon {
    void enableLocalSpeechRecognizeModel(boolean z16);

    int registerAudioDataCallback(int i3, boolean z16);

    int setAudioDataFormat(int i3, int i16, int i17, int i18);

    int setAudioDataVolume(int i3, float f16);

    int unregisterAudioDataCallback(int i3);
}
