package com.qq.wx.voice.synthesizer;

import android.os.Handler;
import com.qq.wx.voice.util.LogTool;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SpeechSynthesizerCallback {

    /* renamed from: c, reason: collision with root package name */
    private boolean f41096c = false;

    /* renamed from: a, reason: collision with root package name */
    a f41094a = null;

    /* renamed from: b, reason: collision with root package name */
    SpeechSynthesizerListener f41095b = null;

    /* renamed from: d, reason: collision with root package name */
    private Handler f41097d = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f41096c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(SpeechSynthesizerState speechSynthesizerState) {
        Handler handler = this.f41097d;
        handler.sendMessage(handler.obtainMessage(100, speechSynthesizerState));
        LogTool.d("voice record state = " + speechSynthesizerState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(SpeechSynthesizerResult speechSynthesizerResult) {
        Handler handler = this.f41097d;
        handler.sendMessage(handler.obtainMessage(300, speechSynthesizerResult));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i3) {
        if (!this.f41096c) {
            Handler handler = this.f41097d;
            handler.sendMessage(handler.obtainMessage(200, Integer.valueOf(i3)));
            this.f41096c = true;
        }
        LogTool.d("isError = " + this.f41096c + " errorCode = " + i3);
    }
}
