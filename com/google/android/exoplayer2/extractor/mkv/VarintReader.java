package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
final class VarintReader {
    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final long[] VARINT_LENGTH_MASKS = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private final byte[] scratch = new byte[8];
    private int state;

    public static long assembleVarint(byte[] bArr, int i3, boolean z16) {
        long j3 = bArr[0] & 255;
        if (z16) {
            j3 &= ~VARINT_LENGTH_MASKS[i3 - 1];
        }
        for (int i16 = 1; i16 < i3; i16++) {
            j3 = (j3 << 8) | (bArr[i16] & 255);
        }
        return j3;
    }

    public static int parseUnsignedVarintLength(int i3) {
        int i16 = 0;
        while (true) {
            long[] jArr = VARINT_LENGTH_MASKS;
            if (i16 < jArr.length) {
                if ((jArr[i16] & i3) != 0) {
                    return i16 + 1;
                }
                i16++;
            } else {
                return -1;
            }
        }
    }

    public int getLastLength() {
        return this.length;
    }

    public long readUnsignedVarint(ExtractorInput extractorInput, boolean z16, boolean z17, int i3) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!extractorInput.readFully(this.scratch, 0, 1, z16)) {
                return -1L;
            }
            int parseUnsignedVarintLength = parseUnsignedVarintLength(this.scratch[0] & 255);
            this.length = parseUnsignedVarintLength;
            if (parseUnsignedVarintLength != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i16 = this.length;
        if (i16 > i3) {
            this.state = 0;
            return -2L;
        }
        if (i16 != 1) {
            extractorInput.readFully(this.scratch, 1, i16 - 1);
        }
        this.state = 0;
        return assembleVarint(this.scratch, this.length, z17);
    }

    public void reset() {
        this.state = 0;
        this.length = 0;
    }
}
