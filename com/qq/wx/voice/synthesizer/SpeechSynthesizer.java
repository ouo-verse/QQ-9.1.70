package com.qq.wx.voice.synthesizer;

import android.content.Context;
import com.qq.wx.voice.util.LogTool;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SpeechSynthesizer {

    /* renamed from: a, reason: collision with root package name */
    private static SpeechSynthesizer f41092a;

    /* renamed from: b, reason: collision with root package name */
    private a f41093b = new a();

    SpeechSynthesizer() {
    }

    public static SpeechSynthesizer shareInstance() {
        if (f41092a == null) {
            f41092a = new SpeechSynthesizer();
        }
        return f41092a;
    }

    public void cancel() {
        this.f41093b.a();
    }

    public void destroy() {
        this.f41093b.b();
    }

    public int init(Context context, String str) {
        return this.f41093b.a(context, str);
    }

    public void setFormat(int i3) {
        a.a(i3);
    }

    public void setListener(SpeechSynthesizerListener speechSynthesizerListener) {
        a.a(speechSynthesizerListener);
    }

    public void setOpenLogCat(boolean z16) {
        LogTool.isShow = z16;
    }

    public void setVolume(float f16) {
        a.a(f16);
    }

    public int start(String str) {
        return this.f41093b.a(str);
    }
}
