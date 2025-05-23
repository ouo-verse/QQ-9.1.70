package com.qq.wx.voice.embedqqegg.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public enum VoiceRecordState {
    Start,
    Recording,
    Complete,
    Canceling,
    Canceled,
    AllFinished;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static VoiceRecordState[] valuesCustom() {
        VoiceRecordState[] voiceRecordStateArr = new VoiceRecordState[6];
        System.arraycopy(values(), 0, voiceRecordStateArr, 0, 6);
        return voiceRecordStateArr;
    }
}
