package com.tencent.luggage.wxa.l0;

import android.net.Uri;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface g {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        g createDataSource();
    }

    long a(j jVar);

    void close();

    Uri getUri();

    int read(byte[] bArr, int i3, int i16);
}
