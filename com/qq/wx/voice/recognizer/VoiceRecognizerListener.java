package com.qq.wx.voice.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface VoiceRecognizerListener {
    void onGetError(int i3);

    void onGetResult(VoiceRecognizerResult voiceRecognizerResult);

    void onGetVoicePackage(byte[] bArr, String str);

    void onGetVoiceRecordState(VoiceRecordState voiceRecordState);

    void onVolumeChanged(int i3);
}
