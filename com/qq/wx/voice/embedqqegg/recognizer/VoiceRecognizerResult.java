package com.qq.wx.voice.embedqqegg.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceRecognizerResult {
    public boolean isEnd;
    public String text = new String();
    public byte[] voiceRecordPCMData = null;
    public boolean isHalf = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VoiceRecognizerResult(boolean z16) {
        this.isEnd = z16;
    }
}
