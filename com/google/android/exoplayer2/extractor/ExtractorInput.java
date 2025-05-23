package com.google.android.exoplayer2.extractor;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ExtractorInput {
    void advancePeekPosition(int i3) throws IOException, InterruptedException;

    boolean advancePeekPosition(int i3, boolean z16) throws IOException, InterruptedException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int i3, int i16) throws IOException, InterruptedException;

    boolean peekFully(byte[] bArr, int i3, int i16, boolean z16) throws IOException, InterruptedException;

    int read(byte[] bArr, int i3, int i16) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i3, int i16) throws IOException, InterruptedException;

    boolean readFully(byte[] bArr, int i3, int i16, boolean z16) throws IOException, InterruptedException;

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long j3, E e16) throws Throwable;

    int skip(int i3) throws IOException, InterruptedException;

    void skipFully(int i3) throws IOException, InterruptedException;

    boolean skipFully(int i3, boolean z16) throws IOException, InterruptedException;
}
