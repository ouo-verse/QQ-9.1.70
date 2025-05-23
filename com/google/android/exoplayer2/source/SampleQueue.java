package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleMetadataQueue;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SampleQueue implements TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private final SampleMetadataQueue.SampleExtrasHolder extrasHolder;
    private AllocationNode firstAllocationNode;
    private Format lastUnadjustedFormat;
    private final SampleMetadataQueue metadataQueue;
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private final ParsableByteArray scratch;
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private AllocationNode writeAllocationNode;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class AllocationNode {

        @Nullable
        public Allocation allocation;
        public final long endPosition;

        @Nullable
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j3, int i3) {
            this.startPosition = j3;
            this.endPosition = j3 + i3;
        }

        public AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }

        public void initialize(Allocation allocation, AllocationNode allocationNode) {
            this.allocation = allocation;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public int translateOffset(long j3) {
            return ((int) (j3 - this.startPosition)) + this.allocation.offset;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator) {
        this.allocator = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        this.metadataQueue = new SampleMetadataQueue();
        this.extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
        this.scratch = new ParsableByteArray(32);
        AllocationNode allocationNode = new AllocationNode(0L, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    private void advanceReadTo(long j3) {
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (j3 >= allocationNode.endPosition) {
                this.readAllocationNode = allocationNode.next;
            } else {
                return;
            }
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (!allocationNode.wasInitialized) {
            return;
        }
        AllocationNode allocationNode2 = this.writeAllocationNode;
        boolean z16 = allocationNode2.wasInitialized;
        int i3 = (z16 ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
        Allocation[] allocationArr = new Allocation[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            allocationArr[i16] = allocationNode.allocation;
            allocationNode = allocationNode.clear();
        }
        this.allocator.release(allocationArr);
    }

    private void discardDownstreamTo(long j3) {
        AllocationNode allocationNode;
        if (j3 == -1) {
            return;
        }
        while (true) {
            allocationNode = this.firstAllocationNode;
            if (j3 < allocationNode.endPosition) {
                break;
            }
            this.allocator.release(allocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
            this.readAllocationNode = allocationNode;
        }
    }

    private static Format getAdjustedSampleFormat(Format format, long j3) {
        if (format == null) {
            return null;
        }
        if (j3 != 0) {
            long j16 = format.subsampleOffsetUs;
            if (j16 != Long.MAX_VALUE) {
                return format.copyWithSubsampleOffsetUs(j16 + j3);
            }
            return format;
        }
        return format;
    }

    private void postAppend(int i3) {
        long j3 = this.totalBytesWritten + i3;
        this.totalBytesWritten = j3;
        AllocationNode allocationNode = this.writeAllocationNode;
        if (j3 == allocationNode.endPosition) {
            this.writeAllocationNode = allocationNode.next;
        }
    }

    private int preAppend(int i3) {
        AllocationNode allocationNode = this.writeAllocationNode;
        if (!allocationNode.wasInitialized) {
            allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i3, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void readData(long j3, ByteBuffer byteBuffer, int i3) {
        advanceReadTo(j3);
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.readAllocationNode.endPosition - j3));
            AllocationNode allocationNode = this.readAllocationNode;
            byteBuffer.put(allocationNode.allocation.data, allocationNode.translateOffset(j3), min);
            i3 -= min;
            j3 += min;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j3 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        boolean z16;
        long j3 = sampleExtrasHolder.offset;
        int i3 = 1;
        this.scratch.reset(1);
        readData(j3, this.scratch.data, 1);
        long j16 = j3 + 1;
        byte b16 = this.scratch.data[0];
        if ((b16 & 128) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = b16 & Byte.MAX_VALUE;
        CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        if (cryptoInfo.f32940iv == null) {
            cryptoInfo.f32940iv = new byte[16];
        }
        readData(j16, cryptoInfo.f32940iv, i16);
        long j17 = j16 + i16;
        if (z16) {
            this.scratch.reset(2);
            readData(j17, this.scratch.data, 2);
            j17 += 2;
            i3 = this.scratch.readUnsignedShort();
        }
        int i17 = i3;
        CryptoInfo cryptoInfo2 = decoderInputBuffer.cryptoInfo;
        int[] iArr = cryptoInfo2.numBytesOfClearData;
        if (iArr == null || iArr.length < i17) {
            iArr = new int[i17];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo2.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i17) {
            iArr3 = new int[i17];
        }
        int[] iArr4 = iArr3;
        if (z16) {
            int i18 = i17 * 6;
            this.scratch.reset(i18);
            readData(j17, this.scratch.data, i18);
            j17 += i18;
            this.scratch.setPosition(0);
            for (int i19 = 0; i19 < i17; i19++) {
                iArr2[i19] = this.scratch.readUnsignedShort();
                iArr4[i19] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder.size - ((int) (j17 - sampleExtrasHolder.offset));
        }
        TrackOutput.CryptoData cryptoData = sampleExtrasHolder.cryptoData;
        CryptoInfo cryptoInfo3 = decoderInputBuffer.cryptoInfo;
        cryptoInfo3.set(i17, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo3.f32940iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j18 = sampleExtrasHolder.offset;
        int i26 = (int) (j17 - j18);
        sampleExtrasHolder.offset = j18 + i26;
        sampleExtrasHolder.size -= i26;
    }

    public int advanceTo(long j3, boolean z16, boolean z17) {
        return this.metadataQueue.advanceTo(j3, z16, z17);
    }

    public int advanceToEnd() {
        return this.metadataQueue.advanceToEnd();
    }

    public void discardTo(long j3, boolean z16, boolean z17) {
        discardDownstreamTo(this.metadataQueue.discardTo(j3, z16, z17));
    }

    public void discardToEnd() {
        discardDownstreamTo(this.metadataQueue.discardToEnd());
    }

    public void discardToRead() {
        discardDownstreamTo(this.metadataQueue.discardToRead());
    }

    public void discardUpstreamSamples(int i3) {
        long discardUpstreamSamples = this.metadataQueue.discardUpstreamSamples(i3);
        this.totalBytesWritten = discardUpstreamSamples;
        if (discardUpstreamSamples != 0) {
            AllocationNode allocationNode = this.firstAllocationNode;
            if (discardUpstreamSamples != allocationNode.startPosition) {
                while (this.totalBytesWritten > allocationNode.endPosition) {
                    allocationNode = allocationNode.next;
                }
                AllocationNode allocationNode2 = allocationNode.next;
                clearAllocationNodes(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.endPosition, this.allocationLength);
                allocationNode.next = allocationNode3;
                if (this.totalBytesWritten == allocationNode.endPosition) {
                    allocationNode = allocationNode3;
                }
                this.writeAllocationNode = allocationNode;
                if (this.readAllocationNode == allocationNode2) {
                    this.readAllocationNode = allocationNode3;
                    return;
                }
                return;
            }
        }
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = allocationNode4;
        this.readAllocationNode = allocationNode4;
        this.writeAllocationNode = allocationNode4;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean format2 = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener != null && format2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
        }
    }

    public int getFirstIndex() {
        return this.metadataQueue.getFirstIndex();
    }

    public long getFirstTimestampUs() {
        return this.metadataQueue.getFirstTimestampUs();
    }

    public long getLargestQueuedTimestampUs() {
        return this.metadataQueue.getLargestQueuedTimestampUs();
    }

    public int getReadIndex() {
        return this.metadataQueue.getReadIndex();
    }

    public Format getUpstreamFormat() {
        return this.metadataQueue.getUpstreamFormat();
    }

    public int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public boolean hasNextSample() {
        return this.metadataQueue.hasNextSample();
    }

    public int peekSourceId() {
        return this.metadataQueue.peekSourceId();
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16, boolean z17, long j3) {
        int read = this.metadataQueue.read(formatHolder, decoderInputBuffer, z16, z17, this.downstreamFormat, this.extrasHolder);
        if (read != -5) {
            if (read != -4) {
                if (read == -3) {
                    return -3;
                }
                throw new IllegalStateException();
            }
            if (!decoderInputBuffer.isEndOfStream()) {
                if (decoderInputBuffer.timeUs < j3) {
                    decoderInputBuffer.addFlag(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer.isEncrypted()) {
                    readEncryptionData(decoderInputBuffer, this.extrasHolder);
                }
                decoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
                SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder = this.extrasHolder;
                readData(sampleExtrasHolder.offset, decoderInputBuffer.data, sampleExtrasHolder.size);
            }
            return -4;
        }
        this.downstreamFormat = formatHolder.format;
        return -5;
    }

    public void reset() {
        reset(false);
    }

    public void rewind() {
        this.metadataQueue.rewind();
        this.readAllocationNode = this.firstAllocationNode;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i3, boolean z16) throws IOException, InterruptedException {
        int preAppend = preAppend(i3);
        AllocationNode allocationNode = this.writeAllocationNode;
        int read = extractorInput.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
        if (read != -1) {
            postAppend(read);
            return read;
        }
        if (z16) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j3, int i3, int i16, int i17, TrackOutput.CryptoData cryptoData) {
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        if (this.pendingSplice) {
            if ((i3 & 1) != 0 && this.metadataQueue.attemptSplice(j3)) {
                this.pendingSplice = false;
            } else {
                return;
            }
        }
        this.metadataQueue.commitSample(j3 + this.sampleOffsetUs, i3, (this.totalBytesWritten - i16) - i17, i16, cryptoData);
    }

    public boolean setReadPosition(int i3) {
        return this.metadataQueue.setReadPosition(i3);
    }

    public void setSampleOffsetUs(long j3) {
        if (this.sampleOffsetUs != j3) {
            this.sampleOffsetUs = j3;
            this.pendingFormatAdjustment = true;
        }
    }

    public void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public void sourceId(int i3) {
        this.metadataQueue.sourceId(i3);
    }

    public void splice() {
        this.pendingSplice = true;
    }

    public void reset(boolean z16) {
        this.metadataQueue.reset(z16);
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode = new AllocationNode(0L, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0L;
        this.allocator.trim();
    }

    private void readData(long j3, byte[] bArr, int i3) {
        advanceReadTo(j3);
        int i16 = i3;
        while (i16 > 0) {
            int min = Math.min(i16, (int) (this.readAllocationNode.endPosition - j3));
            AllocationNode allocationNode = this.readAllocationNode;
            System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(j3), bArr, i3 - i16, min);
            i16 -= min;
            j3 += min;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j3 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i3) {
        while (i3 > 0) {
            int preAppend = preAppend(i3);
            AllocationNode allocationNode = this.writeAllocationNode;
            parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
            i3 -= preAppend;
            postAppend(preAppend);
        }
    }
}
