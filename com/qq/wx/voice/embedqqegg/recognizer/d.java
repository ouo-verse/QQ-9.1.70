package com.qq.wx.voice.embedqqegg.recognizer;

import android.os.Handler;
import com.qq.wx.voice.embedqqegg.util.LogTool;

/* compiled from: P */
/* loaded from: classes3.dex */
final class d {

    /* renamed from: c, reason: collision with root package name */
    private boolean f40959c = false;

    /* renamed from: a, reason: collision with root package name */
    c f40957a = null;

    /* renamed from: b, reason: collision with root package name */
    VoiceRecognizerListener f40958b = null;

    /* renamed from: d, reason: collision with root package name */
    private Handler f40960d = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f40959c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i3) {
        if (!this.f40959c) {
            Handler handler = this.f40960d;
            handler.sendMessage(handler.obtainMessage(400, Integer.valueOf(i3)));
            this.f40959c = true;
        }
        LogTool.d("isError = " + this.f40959c + " errorCode = " + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(VoiceRecordState voiceRecordState) {
        Handler handler = this.f40960d;
        handler.sendMessage(handler.obtainMessage(100, voiceRecordState));
        LogTool.d("voice record state = " + voiceRecordState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i3) {
        Handler handler = this.f40960d;
        handler.sendMessage(handler.obtainMessage(200, Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(VoiceRecognizerResult voiceRecognizerResult) {
        Handler handler = this.f40960d;
        handler.sendMessage(handler.obtainMessage(300, voiceRecognizerResult));
    }
}
