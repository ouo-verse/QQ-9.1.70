package com.tencent.luggage.wxa.ag;

import com.tencent.luggage.wxa.p004if.r;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface j {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(j jVar);

        void a(j jVar, float f16);

        void a(j jVar, boolean z16);

        void b(j jVar);

        void c(j jVar);

        void d(j jVar);

        void e(j jVar);

        void f(j jVar);

        void g(j jVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        Video,
        LivePlayer,
        LivePusher
    }

    void a(a aVar);

    boolean c();

    Integer d();

    r g();

    String getKey();

    b getType();

    int getVideoHeight();

    int getVideoWidth();

    void pause();

    void release();

    void start();
}
