package com.qq.wx.voice.synthesizer;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ SpeechSynthesizerCallback f41101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SpeechSynthesizerCallback speechSynthesizerCallback) {
        this.f41101a = speechSynthesizerCallback;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        SpeechSynthesizerCallback speechSynthesizerCallback = this.f41101a;
        SpeechSynthesizerListener speechSynthesizerListener = speechSynthesizerCallback.f41095b;
        if (speechSynthesizerListener == null) {
            return;
        }
        int i3 = message.what;
        if (i3 != 100) {
            if (i3 != 200) {
                if (i3 == 300) {
                    a aVar = speechSynthesizerCallback.f41094a;
                    if (aVar != null) {
                        aVar.f41099a = null;
                    }
                    speechSynthesizerListener.onGetResult((SpeechSynthesizerResult) message.obj);
                    return;
                }
                return;
            }
            a aVar2 = speechSynthesizerCallback.f41094a;
            if (aVar2 != null) {
                aVar2.a();
            }
            this.f41101a.f41095b.onGetError(((Integer) message.obj).intValue());
            return;
        }
        speechSynthesizerListener.onGetVoiceRecordState((SpeechSynthesizerState) message.obj);
    }
}
