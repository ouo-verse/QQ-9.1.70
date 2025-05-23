package com.qq.wx.voice.embedqqegg.recognizer;

import android.content.Context;
import com.qq.wx.voice.embedqqegg.util.LogTool;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceRecognizer {

    /* renamed from: a, reason: collision with root package name */
    private static VoiceRecognizer f40935a;

    /* renamed from: b, reason: collision with root package name */
    private c f40936b = new c();

    VoiceRecognizer() {
    }

    public static VoiceRecognizer shareInstance() {
        if (f40935a == null) {
            f40935a = new VoiceRecognizer();
        }
        return f40935a;
    }

    public int appendData(byte[] bArr, int i3, int i16, boolean z16) {
        return this.f40936b.a(bArr, i3, i16, z16);
    }

    public int cancel() {
        this.f40936b.a();
        return 0;
    }

    public void destroy() {
        this.f40936b.c();
    }

    public int getVersion(SDKVersion sDKVersion) {
        return this.f40936b.a(sDKVersion);
    }

    public int init(Context context) {
        return this.f40936b.a(context);
    }

    public void setBackRecord(boolean z16) {
        c.b(z16);
    }

    public void setContReco(boolean z16) {
        c.a(z16);
    }

    public int setKeywordSetIndex(int i3) {
        return this.f40936b.b(i3);
    }

    public void setListener(VoiceRecognizerListener voiceRecognizerListener) {
        c.a(voiceRecognizerListener);
    }

    public void setOpenLogCat(boolean z16) {
        LogTool.isShow = z16;
    }

    public void setSaveVoice(boolean z16) {
        c.c(z16);
    }

    public void setSilentTime(int i3) {
        c.a(i3);
    }

    public int setWakeupThres(int i3) {
        return c.c(i3);
    }

    public int start() {
        return 0;
    }

    public int startReceiving() {
        return this.f40936b.d();
    }

    public int stop() {
        return 0;
    }

    public int init(Context context, String str, String str2) {
        return this.f40936b.a(context, str, str2);
    }
}
