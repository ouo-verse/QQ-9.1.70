package com.tencent.luggage.wxa.qb;

import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface f extends Closeable {
    int getAudioType();

    long getSize();

    boolean isOpen();

    void open();

    int readAt(long j3, byte[] bArr, int i3, int i16);
}
