package com.qq.wx.voice.embedqqegg.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public enum InnerAudioState {
    begin,
    middle,
    end,
    stop,
    cancel;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static InnerAudioState[] valuesCustom() {
        InnerAudioState[] innerAudioStateArr = new InnerAudioState[5];
        System.arraycopy(values(), 0, innerAudioStateArr, 0, 5);
        return innerAudioStateArr;
    }
}
