package com.tencent.luggage.wxa.n3;

import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface u extends Closeable {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(int i3, int i16, byte[] bArr);

        void a(byte[] bArr);
    }

    int a(b bVar);

    long getUin();

    void v();

    void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17, int i17);
}
