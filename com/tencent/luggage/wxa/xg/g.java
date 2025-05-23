package com.tencent.luggage.wxa.xg;

import android.view.Surface;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface g {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(g gVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(g gVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        boolean a(g gVar, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        boolean a(g gVar, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
        void a(g gVar);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xg.g$g, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC6908g {
        void a(g gVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface h {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface i {
        void a(g gVar, int i3, int i16);
    }

    g a(Class cls);

    void a(double d16);

    void a(float f16, float f17);

    void a(long j3);

    void a(a aVar);

    void a(b bVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(InterfaceC6908g interfaceC6908g);

    void a(h hVar);

    void a(i iVar);

    void a(String str, String str2);

    void a(String str, String str2, c cVar);

    void a(String str, String str2, String str3, boolean z16);

    void a(boolean z16);

    boolean a(float f16);

    int getCurrentPosition();

    int getDuration();

    int getPlayerType();

    int getState();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void setMinBufferDuration(long j3);

    void setMute(boolean z16);

    void setSurface(Surface surface);

    void start();

    void stop();
}
