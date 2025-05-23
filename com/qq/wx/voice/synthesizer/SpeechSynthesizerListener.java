package com.qq.wx.voice.synthesizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface SpeechSynthesizerListener {
    void onGetError(int i3);

    void onGetResult(SpeechSynthesizerResult speechSynthesizerResult);

    void onGetVoiceRecordState(SpeechSynthesizerState speechSynthesizerState);
}
