package com.qq.wx.voice.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes3.dex */
final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ d f41067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f41067a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        d dVar = this.f41067a;
        VoiceRecognizerListener voiceRecognizerListener = dVar.f41064b;
        if (voiceRecognizerListener == null) {
            return;
        }
        int i3 = message.what;
        if (i3 != 100) {
            if (i3 != 200) {
                if (i3 != 300) {
                    if (i3 != 400) {
                        if (i3 == 500) {
                            Bundle data = message.getData();
                            this.f41067a.f41064b.onGetVoicePackage(data.getByteArray("pack"), data.getString("url"));
                            return;
                        }
                        return;
                    }
                    b bVar = dVar.f41063a;
                    if (bVar != null) {
                        bVar.c();
                    }
                    this.f41067a.f41064b.onGetError(((Integer) message.obj).intValue());
                    return;
                }
                VoiceRecognizerResult voiceRecognizerResult = (VoiceRecognizerResult) message.obj;
                b bVar2 = dVar.f41063a;
                if (bVar2 != null && !InfoRecognizer.f40976f && voiceRecognizerResult.isEnd) {
                    bVar2.b();
                }
                this.f41067a.f41064b.onGetResult(voiceRecognizerResult);
                return;
            }
            voiceRecognizerListener.onVolumeChanged(((Integer) message.obj).intValue());
            return;
        }
        voiceRecognizerListener.onGetVoiceRecordState((VoiceRecordState) message.obj);
    }
}
