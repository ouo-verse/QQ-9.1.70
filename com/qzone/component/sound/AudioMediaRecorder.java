package com.qzone.component.sound;

import android.os.Handler;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AudioMediaRecorder {

    /* compiled from: P */
    /* renamed from: com.qzone.component.sound.AudioMediaRecorder$2, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ AudioMediaRecorder this$0;

        @Override // java.lang.Runnable
        public void run() {
            double currentTimeMillis = (System.currentTimeMillis() - AudioMediaRecorder.f(null)) / 1000.0d;
            AudioMediaRecorder.e(null);
            if (AudioMediaRecorder.d(null) > 0.0d && currentTimeMillis > AudioMediaRecorder.d(null)) {
                throw null;
            }
            if (AudioMediaRecorder.c(null)) {
                AudioMediaRecorder.b(null).postDelayed(AudioMediaRecorder.a(null), 1000L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
    }

    static /* bridge */ /* synthetic */ Runnable a(AudioMediaRecorder audioMediaRecorder) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Handler b(AudioMediaRecorder audioMediaRecorder) {
        throw null;
    }

    static /* bridge */ /* synthetic */ boolean c(AudioMediaRecorder audioMediaRecorder) {
        throw null;
    }

    static /* bridge */ /* synthetic */ double d(AudioMediaRecorder audioMediaRecorder) {
        throw null;
    }

    static /* bridge */ /* synthetic */ a e(AudioMediaRecorder audioMediaRecorder) {
        throw null;
    }

    static /* bridge */ /* synthetic */ double f(AudioMediaRecorder audioMediaRecorder) {
        throw null;
    }
}
