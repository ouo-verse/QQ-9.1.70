package com.tencent.mobileqq.listentogether.player;

import com.tencent.mobileqq.listentogether.data.ISong;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface e {
    void a(c cVar);

    boolean b(ISong iSong);

    void c(d dVar);

    void d(b bVar);

    int e();

    void f(f fVar);

    int getPlayState();

    void init();

    boolean isConnected();

    boolean pausePlay();

    boolean resumePlay();

    boolean stopPlay();
}
