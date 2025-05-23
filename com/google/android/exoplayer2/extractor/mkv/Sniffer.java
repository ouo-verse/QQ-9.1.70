package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    private long readUint(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i3 = 0;
        extractorInput.peekFully(this.scratch.data, 0, 1);
        int i16 = this.scratch.data[0] & 255;
        if (i16 == 0) {
            return Long.MIN_VALUE;
        }
        int i17 = 128;
        int i18 = 0;
        while ((i16 & i17) == 0) {
            i17 >>= 1;
            i18++;
        }
        int i19 = i16 & (~i17);
        extractorInput.peekFully(this.scratch.data, 1, i18);
        while (i3 < i18) {
            i3++;
            i19 = (this.scratch.data[i3] & 255) + (i19 << 8);
        }
        this.peekLength += i18 + 1;
        return i19;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        long length = extractorInput.getLength();
        long j3 = 1024;
        if (length != -1 && length <= 1024) {
            j3 = length;
        }
        int i3 = (int) j3;
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i16 = this.peekLength + 1;
            this.peekLength = i16;
            if (i16 == i3) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.scratch.data[0] & 255);
        }
        long readUint = readUint(extractorInput);
        long j16 = this.peekLength;
        if (readUint == Long.MIN_VALUE) {
            return false;
        }
        if (length == -1 || j16 + readUint < length) {
            while (true) {
                int i17 = this.peekLength;
                long j17 = j16 + readUint;
                if (i17 < j17) {
                    if (readUint(extractorInput) == Long.MIN_VALUE) {
                        return false;
                    }
                    long readUint2 = readUint(extractorInput);
                    if (readUint2 < 0 || readUint2 > TTL.MAX_VALUE) {
                        break;
                    }
                    if (readUint2 != 0) {
                        extractorInput.advancePeekPosition((int) readUint2);
                        this.peekLength = (int) (this.peekLength + readUint2);
                    }
                } else {
                    if (i17 != j17) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
