package com.tencent.mobileqq.qqaudio.audioplayer;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface i {
    void a(float f16);

    void b(int i3, byte b16);

    String c();

    void d(j jVar);

    void e(int i3);

    int f();

    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void pause();

    void prepare() throws IOException;

    void release();

    void reset();

    void seekTo(int i3);

    void setDataSource(String str) throws IOException;

    void start();

    void stop();
}
