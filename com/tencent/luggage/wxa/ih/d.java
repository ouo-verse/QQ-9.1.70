package com.tencent.luggage.wxa.ih;

import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread;
import com.tencent.tav.decoder.EncoderWriter;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d extends com.tencent.luggage.wxa.h1.b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        AUTO(0, "auto"),
        MIC(1, MiniGameLameMp3EncodeThread.AUDIO_SOURCE_MIC),
        CAMCORDER(5, MiniGameLameMp3EncodeThread.AUDIO_SOURCE_CAMCORDER),
        VOICE_RECOGNITION(6, MiniGameLameMp3EncodeThread.AUDIO_SOURCE_VOICE_RECOGNITION),
        VOICE_COMMUNICATION(7, MiniGameLameMp3EncodeThread.AUDIO_SOURCE_VOICE_COMMUNICATION),
        UNPROCESSED(9, "unprocessed");


        /* renamed from: a, reason: collision with root package name */
        public int f130379a;

        /* renamed from: b, reason: collision with root package name */
        public String f130380b;

        a(int i3, String str) {
            this.f130379a = i3;
            this.f130380b = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements c {
        @Override // com.tencent.luggage.wxa.ih.d.c
        public void a(String str, int i3, int i16) {
        }

        @Override // com.tencent.luggage.wxa.ih.d.c
        public void a(byte[] bArr, boolean z16) {
        }

        @Override // com.tencent.luggage.wxa.ih.d.c
        public void onStart() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(String str, int i3, int i16);

        void a(byte[] bArr, boolean z16);

        void onStart();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ih.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6305d {

        /* renamed from: a, reason: collision with root package name */
        public String f130381a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f130382b = 600000;

        /* renamed from: c, reason: collision with root package name */
        public int f130383c = 44100;

        /* renamed from: d, reason: collision with root package name */
        public int f130384d = 2;

        /* renamed from: e, reason: collision with root package name */
        public String f130385e = "pcm";

        /* renamed from: f, reason: collision with root package name */
        public int f130386f = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;

        /* renamed from: g, reason: collision with root package name */
        public double f130387g = 0.0d;

        /* renamed from: h, reason: collision with root package name */
        public a f130388h = a.MIC;

        public String toString() {
            return "RecordParams{filePath='" + this.f130381a + "', duration=" + this.f130382b + ", sampleRate=" + this.f130383c + ", numberOfChannels=" + this.f130384d + ", format='" + this.f130385e + "', encodeBitRate=" + this.f130386f + ", frameSize=" + this.f130387g + ", audioSource=" + this.f130388h + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum e {
        START("start"),
        PAUSE("pause"),
        STOP("stop"),
        ERROR("error"),
        FRAMERECORDED("frameRecorded"),
        INTERRUPTIONBEGIN("interruptionBegin"),
        INTERUPTIONEND("interruptionEnd");


        /* renamed from: a, reason: collision with root package name */
        public String f130397a;

        e(String str) {
            this.f130397a = str;
        }
    }

    com.tencent.luggage.wxa.hh.g a(C6305d c6305d);

    void a(String str, c cVar);

    c c(String str);

    void i(String str);

    com.tencent.luggage.wxa.hh.g j();

    void onBackground();

    void onDestroy();

    void onForeground();
}
