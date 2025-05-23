package com.qq.wx.voice.embedqqegg.recognizer;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ d f40961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f40961a = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        boolean z16;
        c cVar;
        d dVar = this.f40961a;
        VoiceRecognizerListener voiceRecognizerListener = dVar.f40958b;
        if (voiceRecognizerListener == null) {
            return;
        }
        int i3 = message.what;
        if (i3 != 100) {
            if (i3 != 200) {
                if (i3 != 300) {
                    if (i3 == 400) {
                        c cVar2 = dVar.f40957a;
                        if (cVar2 != null) {
                            cVar2.a();
                        }
                        this.f40961a.f40958b.onGetError(((Integer) message.obj).intValue());
                        return;
                    }
                    return;
                }
                VoiceRecognizerResult voiceRecognizerResult = (VoiceRecognizerResult) message.obj;
                if (!voiceRecognizerResult.isHalf && ((!(z16 = InfoRecognizer.f40915f) || (z16 && voiceRecognizerResult.isEnd)) && (cVar = dVar.f40957a) != null)) {
                    cVar.b();
                }
                this.f40961a.f40958b.onGetResult(voiceRecognizerResult);
                return;
            }
            voiceRecognizerListener.onVolumeChanged(((Integer) message.obj).intValue());
            return;
        }
        voiceRecognizerListener.onGetVoiceRecordState((VoiceRecordState) message.obj);
    }
}
