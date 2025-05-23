package com.tencent.biz.pubaccount.weishi.player.wrapper;

import android.content.Context;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface b {
    void a(h hVar);

    void b(h hVar, ViewGroup viewGroup);

    void c(Context context, long j3, int i3, a aVar);

    int d();

    void e(int i3, int i16, int i17);

    void f(e eVar);

    l g();

    long getCurrentPosition();

    long getDuration();

    String getStreamDumpInfo();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPausing();

    boolean isPlaying();

    void pause();

    void pauseDownload();

    void release();

    void resumeDownload();

    void seekTo(int i3);

    void setLoopback(boolean z16);

    void setOutputMute(boolean z16);

    void setPlaySpeedRatio(float f16);

    void setXYAxis(int i3);

    void start();

    void stop();
}
