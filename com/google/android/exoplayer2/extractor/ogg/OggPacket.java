package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class OggPacket {
    private boolean populated;
    private int segmentCount;
    private final OggPageHeader pageHeader = new OggPageHeader();
    private final ParsableByteArray packetArray = new ParsableByteArray(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private int currentSegmentIndex = -1;

    private int calculatePacketSize(int i3) {
        int i16;
        int i17 = 0;
        this.segmentCount = 0;
        do {
            int i18 = this.segmentCount;
            int i19 = i3 + i18;
            OggPageHeader oggPageHeader = this.pageHeader;
            if (i19 >= oggPageHeader.pageSegmentCount) {
                break;
            }
            int[] iArr = oggPageHeader.laces;
            this.segmentCount = i18 + 1;
            i16 = iArr[i18 + i3];
            i17 += i16;
        } while (i16 == 255);
        return i17;
    }

    public OggPageHeader getPageHeader() {
        return this.pageHeader;
    }

    public ParsableByteArray getPayload() {
        return this.packetArray;
    }

    public boolean populate(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z16;
        boolean z17;
        int i3;
        if (extractorInput != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        if (this.populated) {
            this.populated = false;
            this.packetArray.reset();
        }
        while (!this.populated) {
            if (this.currentSegmentIndex < 0) {
                if (!this.pageHeader.populate(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.pageHeader;
                int i16 = oggPageHeader.headerSize;
                if ((oggPageHeader.type & 1) == 1 && this.packetArray.limit() == 0) {
                    i16 += calculatePacketSize(0);
                    i3 = this.segmentCount + 0;
                } else {
                    i3 = 0;
                }
                extractorInput.skipFully(i16);
                this.currentSegmentIndex = i3;
            }
            int calculatePacketSize = calculatePacketSize(this.currentSegmentIndex);
            int i17 = this.currentSegmentIndex + this.segmentCount;
            if (calculatePacketSize > 0) {
                if (this.packetArray.capacity() < this.packetArray.limit() + calculatePacketSize) {
                    ParsableByteArray parsableByteArray = this.packetArray;
                    parsableByteArray.data = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit() + calculatePacketSize);
                }
                ParsableByteArray parsableByteArray2 = this.packetArray;
                extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), calculatePacketSize);
                ParsableByteArray parsableByteArray3 = this.packetArray;
                parsableByteArray3.setLimit(parsableByteArray3.limit() + calculatePacketSize);
                if (this.pageHeader.laces[i17 - 1] != 255) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                this.populated = z17;
            }
            if (i17 == this.pageHeader.pageSegmentCount) {
                i17 = -1;
            }
            this.currentSegmentIndex = i17;
        }
        return true;
    }

    public void reset() {
        this.pageHeader.reset();
        this.packetArray.reset();
        this.currentSegmentIndex = -1;
        this.populated = false;
    }

    public void trimPayload() {
        ParsableByteArray parsableByteArray = this.packetArray;
        byte[] bArr = parsableByteArray.data;
        if (bArr.length == 65025) {
            return;
        }
        parsableByteArray.data = Arrays.copyOf(bArr, Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, parsableByteArray.limit()));
    }
}
