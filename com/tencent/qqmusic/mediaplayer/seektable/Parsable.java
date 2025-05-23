package com.tencent.qqmusic.mediaplayer.seektable;

import java.io.IOException;

/* loaded from: classes23.dex */
public interface Parsable {
    long available() throws IOException;

    void readBytes(byte[] bArr, int i3, int i16) throws IOException;

    int readInt() throws IOException;

    int[] readIntArray(int i3) throws IOException;

    void readIntArrayInterleaved(int i3, int[]... iArr) throws IOException;

    long readLong() throws IOException;

    long[] readLongArray(int i3) throws IOException;

    void readLongArrayInterleaved(int i3, long[]... jArr) throws IOException;

    String readString(int i3) throws IOException;

    long skip(long j3) throws IOException;

    long tell();
}
