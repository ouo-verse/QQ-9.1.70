package com.tencent.luggage.wxa.eh;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        int a(int i3, int i16);

        void a();

        void b();

        void c(int i3, int i16);

        void d(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void b(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.eh.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6170d {
        void e();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void h();
    }

    void a(double d16);

    void a(double d16, boolean z16);

    int getCurrentPosition();

    int getDuration();

    long getLastSurfaceUpdateTime();

    String getVideoPath();

    boolean isPlaying();

    void pause();

    void setMinBufferDuration(long j3);

    void setMute(boolean z16);

    void setOnInfoCallback(b bVar);

    void setOnSeekCompleteCallback(c cVar);

    void setOnSurfaceCallback(InterfaceC6170d interfaceC6170d);

    void setOneTimeVideoTextureUpdateCallback(e eVar);

    void setVideoCallback(a aVar);

    void setVideoPath(String str);

    boolean start();

    void stop();
}
