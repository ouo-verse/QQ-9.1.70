package com.qq.wx.voice.synthesizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public enum SpeechSynthesizerState {
    Canceling,
    Canceled;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static SpeechSynthesizerState[] valuesCustom() {
        SpeechSynthesizerState[] speechSynthesizerStateArr = new SpeechSynthesizerState[2];
        System.arraycopy(values(), 0, speechSynthesizerStateArr, 0, 2);
        return speechSynthesizerStateArr;
    }
}
