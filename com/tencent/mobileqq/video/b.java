package com.tencent.mobileqq.video;

import android.view.SurfaceHolder;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.video.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8953b {
        void onPlayStateChanged(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void a(b bVar);
    }

    void a(a aVar);

    void b(InterfaceC8953b interfaceC8953b);

    void c(c cVar);

    boolean d(String str, int i3);

    int getCurrentPosition();

    int getDuration();

    int getPlayState();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void release();

    boolean resume();

    void seekTo(int i3);

    void setDisplay(SurfaceHolder surfaceHolder);

    void start();
}
