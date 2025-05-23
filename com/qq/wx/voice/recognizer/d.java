package com.qq.wx.voice.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qq.wx.voice.util.LogTool;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    private boolean f41065c = false;

    /* renamed from: a, reason: collision with root package name */
    b f41063a = null;

    /* renamed from: b, reason: collision with root package name */
    VoiceRecognizerListener f41064b = null;

    /* renamed from: d, reason: collision with root package name */
    private Handler f41066d = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f41065c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i3) {
        if (!this.f41065c) {
            Handler handler = this.f41066d;
            handler.sendMessage(handler.obtainMessage(400, Integer.valueOf(i3)));
            this.f41065c = true;
        }
        LogTool.d("isError = " + this.f41065c + " errorCode = " + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(VoiceRecordState voiceRecordState) {
        Handler handler = this.f41066d;
        handler.sendMessage(handler.obtainMessage(100, voiceRecordState));
        LogTool.d("voice record state = " + voiceRecordState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i3) {
        Handler handler = this.f41066d;
        handler.sendMessage(handler.obtainMessage(200, Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(VoiceRecognizerResult voiceRecognizerResult) {
        Handler handler = this.f41066d;
        handler.sendMessage(handler.obtainMessage(300, voiceRecognizerResult));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(byte[] bArr, String str) {
        Message obtainMessage = this.f41066d.obtainMessage(500);
        Bundle bundle = new Bundle();
        bundle.putByteArray("pack", bArr);
        bundle.putString("url", str);
        obtainMessage.setData(bundle);
        this.f41066d.sendMessage(obtainMessage);
    }
}
