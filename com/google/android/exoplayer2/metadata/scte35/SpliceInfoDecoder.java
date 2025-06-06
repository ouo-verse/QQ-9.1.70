package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SpliceInfoDecoder implements MetadataDecoder {
    private static final int TYPE_PRIVATE_COMMAND = 255;
    private static final int TYPE_SPLICE_INSERT = 5;
    private static final int TYPE_SPLICE_NULL = 0;
    private static final int TYPE_SPLICE_SCHEDULE = 4;
    private static final int TYPE_TIME_SIGNAL = 6;
    private final ParsableByteArray sectionData = new ParsableByteArray();
    private final ParsableBitArray sectionHeader = new ParsableBitArray();
    private TimestampAdjuster timestampAdjuster;

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) throws MetadataDecoderException {
        Metadata.Entry spliceNullCommand;
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster == null || metadataInputBuffer.subsampleOffsetUs != timestampAdjuster.getTimestampOffsetUs()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.timeUs);
            this.timestampAdjuster = timestampAdjuster2;
            timestampAdjuster2.adjustSampleTimestamp(metadataInputBuffer.timeUs - metadataInputBuffer.subsampleOffsetUs);
        }
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.sectionData.reset(array, limit);
        this.sectionHeader.reset(array, limit);
        this.sectionHeader.skipBits(39);
        long readBits = (this.sectionHeader.readBits(1) << 32) | this.sectionHeader.readBits(32);
        this.sectionHeader.skipBits(20);
        int readBits2 = this.sectionHeader.readBits(12);
        int readBits3 = this.sectionHeader.readBits(8);
        this.sectionData.skipBytes(14);
        if (readBits3 != 0) {
            if (readBits3 != 255) {
                if (readBits3 != 4) {
                    if (readBits3 != 5) {
                        if (readBits3 != 6) {
                            spliceNullCommand = null;
                        } else {
                            spliceNullCommand = TimeSignalCommand.parseFromSection(this.sectionData, readBits, this.timestampAdjuster);
                        }
                    } else {
                        spliceNullCommand = SpliceInsertCommand.parseFromSection(this.sectionData, readBits, this.timestampAdjuster);
                    }
                } else {
                    spliceNullCommand = SpliceScheduleCommand.parseFromSection(this.sectionData);
                }
            } else {
                spliceNullCommand = PrivateCommand.parseFromSection(this.sectionData, readBits2, readBits);
            }
        } else {
            spliceNullCommand = new SpliceNullCommand();
        }
        if (spliceNullCommand == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(spliceNullCommand);
    }
}
