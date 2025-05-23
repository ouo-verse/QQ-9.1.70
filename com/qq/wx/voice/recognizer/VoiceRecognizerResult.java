package com.qq.wx.voice.recognizer;

import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceRecognizerResult {
    public boolean isEnd;
    public String text = new String();
    public byte[] voiceRecordPCMData = null;
    public byte[] voiceSpeexData = null;
    public List words = null;
    public boolean isAllEnd = false;
    public double startTime = 0.0d;
    public double stopTime = 0.0d;
    public int type = 0;
    public byte[] httpRes = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Word {
        public String text = null;
        public JSONObject semanticJsonObject = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VoiceRecognizerResult(boolean z16) {
        this.isEnd = z16;
    }
}
