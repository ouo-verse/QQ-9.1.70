package com.tencent.luggage.wxa.fl;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    void a(d dVar);

    boolean b();

    a c();

    boolean d();

    ByteBuffer f();
}
