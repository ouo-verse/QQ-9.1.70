package com.tencent.luggage.wxa.kh;

import com.tencent.luggage.wxa.gl.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(int i3, String str);

        void a(com.tencent.luggage.wxa.gl.a aVar);

        void a(h hVar, Map map);

        void a(String str);

        void a(ByteBuffer byteBuffer);

        void b(String str);
    }

    void a();

    void a(a aVar);

    void a(String str);

    void a(String str, int i3);

    void a(Socket socket);

    void a(ByteBuffer byteBuffer);

    void a(Timer timer);

    String b();

    void b(boolean z16);

    Socket c();

    void close();

    Timer d();

    boolean isOpen();

    void send(String str);
}
