package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultExtractorInput implements ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 524288;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private final DataSource dataSource;
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final long streamLength;
    private byte[] peekBuffer = new byte[65536];
    private final byte[] scratchSpace = new byte[4096];

    public DefaultExtractorInput(DataSource dataSource, long j3, long j16) {
        this.dataSource = dataSource;
        this.position = j3;
        this.streamLength = j16;
    }

    private void commitBytesRead(int i3) {
        if (i3 != -1) {
            this.position += i3;
        }
    }

    private void ensureSpaceForPeek(int i3) {
        int i16 = this.peekBufferPosition + i3;
        byte[] bArr = this.peekBuffer;
        if (i16 > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i16, i16 + 524288));
        }
    }

    private int readFromDataSource(byte[] bArr, int i3, int i16, int i17, boolean z16) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.dataSource.read(bArr, i3 + i17, i16 - i17);
            if (read == -1) {
                if (i17 == 0 && z16) {
                    return -1;
                }
                throw new EOFException();
            }
            return i17 + read;
        }
        throw new InterruptedException();
    }

    private int readFromPeekBuffer(byte[] bArr, int i3, int i16) {
        int i17 = this.peekBufferLength;
        if (i17 == 0) {
            return 0;
        }
        int min = Math.min(i17, i16);
        System.arraycopy(this.peekBuffer, 0, bArr, i3, min);
        updatePeekBuffer(min);
        return min;
    }

    private int skipFromPeekBuffer(int i3) {
        int min = Math.min(this.peekBufferLength, i3);
        updatePeekBuffer(min);
        return min;
    }

    private void updatePeekBuffer(int i3) {
        byte[] bArr;
        int i16 = this.peekBufferLength - i3;
        this.peekBufferLength = i16;
        this.peekBufferPosition = 0;
        byte[] bArr2 = this.peekBuffer;
        if (i16 < bArr2.length - 524288) {
            bArr = new byte[65536 + i16];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i3, bArr, 0, i16);
        this.peekBuffer = bArr;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i3, boolean z16) throws IOException, InterruptedException {
        ensureSpaceForPeek(i3);
        int min = Math.min(this.peekBufferLength - this.peekBufferPosition, i3);
        while (min < i3) {
            min = readFromDataSource(this.peekBuffer, this.peekBufferPosition, i3, min, z16);
            if (min == -1) {
                return false;
            }
        }
        int i16 = this.peekBufferPosition + i3;
        this.peekBufferPosition = i16;
        this.peekBufferLength = Math.max(this.peekBufferLength, i16);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.streamLength;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.position + this.peekBufferPosition;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.position;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i3, int i16, boolean z16) throws IOException, InterruptedException {
        if (!advancePeekPosition(i16, z16)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - i16, bArr, i3, i16);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] bArr, int i3, int i16) throws IOException, InterruptedException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i3, i16);
        if (readFromPeekBuffer == 0) {
            readFromPeekBuffer = readFromDataSource(bArr, i3, i16, 0, true);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i3, int i16, boolean z16) throws IOException, InterruptedException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i3, i16);
        while (readFromPeekBuffer < i16 && readFromPeekBuffer != -1) {
            readFromPeekBuffer = readFromDataSource(bArr, i3, i16, readFromPeekBuffer, z16);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j3, E e16) throws Throwable {
        boolean z16;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        this.position = j3;
        throw e16;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i3) throws IOException, InterruptedException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i3);
        if (skipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            skipFromPeekBuffer = readFromDataSource(bArr, 0, Math.min(i3, bArr.length), 0, true);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i3, boolean z16) throws IOException, InterruptedException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i3);
        while (skipFromPeekBuffer < i3 && skipFromPeekBuffer != -1) {
            skipFromPeekBuffer = readFromDataSource(this.scratchSpace, -skipFromPeekBuffer, Math.min(i3, this.scratchSpace.length + skipFromPeekBuffer), skipFromPeekBuffer, z16);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i3, int i16) throws IOException, InterruptedException {
        peekFully(bArr, i3, i16, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i3, int i16) throws IOException, InterruptedException {
        readFully(bArr, i3, i16, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i3) throws IOException, InterruptedException {
        advancePeekPosition(i3, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i3) throws IOException, InterruptedException {
        skipFully(i3, false);
    }
}
