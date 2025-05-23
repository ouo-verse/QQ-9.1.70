package com.google.android.exoplayer2.decoder;

import java.lang.Exception;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface Decoder<I, O, E extends Exception> {
    I dequeueInputBuffer() throws Exception;

    O dequeueOutputBuffer() throws Exception;

    void flush();

    String getName();

    void queueInputBuffer(I i3) throws Exception;

    void release();
}
