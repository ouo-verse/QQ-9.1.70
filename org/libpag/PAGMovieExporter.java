package org.libpag;

import android.util.Log;
import com.tencent.tav.decoder.EncoderWriter;

/* loaded from: classes29.dex */
public class PAGMovieExporter {
    private long nativeContext;

    /* loaded from: classes29.dex */
    public interface Callback {
        void onProgress(float f16);

        void onStatusChange(Status status, String[] strArr);
    }

    /* loaded from: classes29.dex */
    private static class CallbackWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final Callback f423749a;

        public CallbackWrapper(Callback callback) {
            this.f423749a = callback;
        }

        private void onProgress(float f16) {
            this.f423749a.onProgress(f16);
        }

        private void onStatusChange(int i3, String[] strArr) {
            Status[] values = Status.values();
            if (i3 >= values.length) {
                Log.e("PAGMovieExporter", "onStatusChange: status value illegal, is " + i3);
                return;
            }
            this.f423749a.onStatusChange(values[i3], strArr);
        }
    }

    /* loaded from: classes29.dex */
    public static class Config {
        public String outputPath = "";
        public int sampleRate = 44100;
        public int channels = 2;
        public int audioBitrate = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
        public int width = 1280;
        public int height = 720;
        public int frameRate = 30;
        public int videoBitrate = 8000000;
        public int profile = 0;
    }

    /* loaded from: classes29.dex */
    public enum Status {
        UnKnow,
        Exporting,
        Failed,
        Canceled,
        Complete
    }

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    PAGMovieExporter(long j3) {
        this.nativeContext = j3;
    }

    public static PAGMovieExporter Make(PAGComposition pAGComposition, Config config, Callback callback) {
        long nativeMake = nativeMake(pAGComposition, config, new CallbackWrapper(callback));
        if (nativeMake == 0) {
            return null;
        }
        return new PAGMovieExporter(nativeMake);
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private static native long nativeMake(PAGComposition pAGComposition, Config config, CallbackWrapper callbackWrapper);

    public native void cancel();

    protected void finalize() {
        Log.i("PAGMovieExporter", "finalize() called");
        nativeFinalize();
    }

    public native void release();

    public native void start();
}
