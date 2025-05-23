package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class SampleMetadataQueue {
    private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private int absoluteFirstIndex;
    private int length;
    private int readPosition;
    private int relativeFirstIndex;
    private Format upstreamFormat;
    private int upstreamSourceId;
    private int capacity = 1000;
    private int[] sourceIds = new int[1000];
    private long[] offsets = new long[1000];
    private long[] timesUs = new long[1000];
    private int[] flags = new int[1000];
    private int[] sizes = new int[1000];
    private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    private Format[] formats = new Format[1000];
    private long largestDiscardedTimestampUs = Long.MIN_VALUE;
    private long largestQueuedTimestampUs = Long.MIN_VALUE;
    private boolean upstreamFormatRequired = true;
    private boolean upstreamKeyframeRequired = true;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;
    }

    private long discardSamples(int i3) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i3));
        int i16 = this.length - i3;
        this.length = i16;
        this.absoluteFirstIndex += i3;
        int i17 = this.relativeFirstIndex + i3;
        this.relativeFirstIndex = i17;
        int i18 = this.capacity;
        if (i17 >= i18) {
            this.relativeFirstIndex = i17 - i18;
        }
        int i19 = this.readPosition - i3;
        this.readPosition = i19;
        if (i19 < 0) {
            this.readPosition = 0;
        }
        if (i16 == 0) {
            int i26 = this.relativeFirstIndex;
            if (i26 != 0) {
                i18 = i26;
            }
            return this.offsets[i18 - 1] + this.sizes[r2];
        }
        return this.offsets[this.relativeFirstIndex];
    }

    private int findSampleBefore(int i3, int i16, long j3, boolean z16) {
        int i17 = -1;
        for (int i18 = 0; i18 < i16 && this.timesUs[i3] <= j3; i18++) {
            if (!z16 || (this.flags[i3] & 1) != 0) {
                i17 = i18;
            }
            i3++;
            if (i3 == this.capacity) {
                i3 = 0;
            }
        }
        return i17;
    }

    private long getLargestTimestamp(int i3) {
        long j3 = Long.MIN_VALUE;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i3 - 1);
        for (int i16 = 0; i16 < i3; i16++) {
            j3 = Math.max(j3, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                break;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return j3;
    }

    private int getRelativeIndex(int i3) {
        int i16 = this.relativeFirstIndex + i3;
        int i17 = this.capacity;
        if (i16 >= i17) {
            return i16 - i17;
        }
        return i16;
    }

    public synchronized int advanceTo(long j3, boolean z16, boolean z17) {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample() && j3 >= this.timesUs[relativeIndex] && (j3 <= this.largestQueuedTimestampUs || z17)) {
            int findSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j3, z16);
            if (findSampleBefore == -1) {
                return -1;
            }
            this.readPosition += findSampleBefore;
            return findSampleBefore;
        }
        return -1;
    }

    public synchronized int advanceToEnd() {
        int i3;
        int i16 = this.length;
        i3 = i16 - this.readPosition;
        this.readPosition = i16;
        return i3;
    }

    public synchronized boolean attemptSplice(long j3) {
        boolean z16 = false;
        if (this.length == 0) {
            if (j3 > this.largestDiscardedTimestampUs) {
                z16 = true;
            }
            return z16;
        }
        if (Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition)) >= j3) {
            return false;
        }
        int i3 = this.length;
        int relativeIndex = getRelativeIndex(i3 - 1);
        while (i3 > this.readPosition && this.timesUs[relativeIndex] >= j3) {
            i3--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        discardUpstreamSamples(this.absoluteFirstIndex + i3);
        return true;
    }

    public synchronized void commitSample(long j3, int i3, long j16, int i16, TrackOutput.CryptoData cryptoData) {
        boolean z16;
        if (this.upstreamKeyframeRequired) {
            if ((i3 & 1) == 0) {
                return;
            } else {
                this.upstreamKeyframeRequired = false;
            }
        }
        if (!this.upstreamFormatRequired) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        commitSampleTimestamp(j3);
        int relativeIndex = getRelativeIndex(this.length);
        this.timesUs[relativeIndex] = j3;
        long[] jArr = this.offsets;
        jArr[relativeIndex] = j16;
        this.sizes[relativeIndex] = i16;
        this.flags[relativeIndex] = i3;
        this.cryptoDatas[relativeIndex] = cryptoData;
        this.formats[relativeIndex] = this.upstreamFormat;
        this.sourceIds[relativeIndex] = this.upstreamSourceId;
        int i17 = this.length + 1;
        this.length = i17;
        int i18 = this.capacity;
        if (i17 == i18) {
            int i19 = i18 + 1000;
            int[] iArr = new int[i19];
            long[] jArr2 = new long[i19];
            long[] jArr3 = new long[i19];
            int[] iArr2 = new int[i19];
            int[] iArr3 = new int[i19];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i19];
            Format[] formatArr = new Format[i19];
            int i26 = this.relativeFirstIndex;
            int i27 = i18 - i26;
            System.arraycopy(jArr, i26, jArr2, 0, i27);
            System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr3, 0, i27);
            System.arraycopy(this.flags, this.relativeFirstIndex, iArr2, 0, i27);
            System.arraycopy(this.sizes, this.relativeFirstIndex, iArr3, 0, i27);
            System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i27);
            System.arraycopy(this.formats, this.relativeFirstIndex, formatArr, 0, i27);
            System.arraycopy(this.sourceIds, this.relativeFirstIndex, iArr, 0, i27);
            int i28 = this.relativeFirstIndex;
            System.arraycopy(this.offsets, 0, jArr2, i27, i28);
            System.arraycopy(this.timesUs, 0, jArr3, i27, i28);
            System.arraycopy(this.flags, 0, iArr2, i27, i28);
            System.arraycopy(this.sizes, 0, iArr3, i27, i28);
            System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i27, i28);
            System.arraycopy(this.formats, 0, formatArr, i27, i28);
            System.arraycopy(this.sourceIds, 0, iArr, i27, i28);
            this.offsets = jArr2;
            this.timesUs = jArr3;
            this.flags = iArr2;
            this.sizes = iArr3;
            this.cryptoDatas = cryptoDataArr;
            this.formats = formatArr;
            this.sourceIds = iArr;
            this.relativeFirstIndex = 0;
            this.length = this.capacity;
            this.capacity = i19;
        }
    }

    public synchronized void commitSampleTimestamp(long j3) {
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j3);
    }

    public synchronized long discardTo(long j3, boolean z16, boolean z17) {
        int i3;
        int i16 = this.length;
        if (i16 != 0) {
            long[] jArr = this.timesUs;
            int i17 = this.relativeFirstIndex;
            if (j3 >= jArr[i17]) {
                if (z17 && (i3 = this.readPosition) != i16) {
                    i16 = i3 + 1;
                }
                int findSampleBefore = findSampleBefore(i17, i16, j3, z16);
                if (findSampleBefore == -1) {
                    return -1L;
                }
                return discardSamples(findSampleBefore);
            }
        }
        return -1L;
    }

    public synchronized long discardToEnd() {
        int i3 = this.length;
        if (i3 == 0) {
            return -1L;
        }
        return discardSamples(i3);
    }

    public synchronized long discardToRead() {
        int i3 = this.readPosition;
        if (i3 == 0) {
            return -1L;
        }
        return discardSamples(i3);
    }

    public long discardUpstreamSamples(int i3) {
        boolean z16;
        int writeIndex = getWriteIndex() - i3;
        if (writeIndex >= 0 && writeIndex <= this.length - this.readPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        int i16 = this.length - writeIndex;
        this.length = i16;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i16));
        int i17 = this.length;
        if (i17 == 0) {
            return 0L;
        }
        return this.offsets[getRelativeIndex(i17 - 1)] + this.sizes[r6];
    }

    public synchronized boolean format(Format format) {
        if (format == null) {
            this.upstreamFormatRequired = true;
            return false;
        }
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        this.upstreamFormat = format;
        return true;
    }

    public int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public synchronized long getFirstTimestampUs() {
        long j3;
        if (this.length == 0) {
            j3 = Long.MIN_VALUE;
        } else {
            j3 = this.timesUs[this.relativeFirstIndex];
        }
        return j3;
    }

    public synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public synchronized Format getUpstreamFormat() {
        Format format;
        if (this.upstreamFormatRequired) {
            format = null;
        } else {
            format = this.upstreamFormat;
        }
        return format;
    }

    public int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public synchronized boolean hasNextSample() {
        boolean z16;
        if (this.readPosition != this.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public int peekSourceId() {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample()) {
            return this.sourceIds[relativeIndex];
        }
        return this.upstreamSourceId;
    }

    public synchronized int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16, boolean z17, Format format, SampleExtrasHolder sampleExtrasHolder) {
        if (!hasNextSample()) {
            if (z17) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            Format format2 = this.upstreamFormat;
            if (format2 == null || (!z16 && format2 == format)) {
                return -3;
            }
            formatHolder.format = format2;
            return -5;
        }
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (!z16 && this.formats[relativeIndex] == format) {
            if (decoderInputBuffer.isFlagsOnly()) {
                return -3;
            }
            decoderInputBuffer.timeUs = this.timesUs[relativeIndex];
            decoderInputBuffer.setFlags(this.flags[relativeIndex]);
            sampleExtrasHolder.size = this.sizes[relativeIndex];
            sampleExtrasHolder.offset = this.offsets[relativeIndex];
            sampleExtrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
            this.readPosition++;
            return -4;
        }
        formatHolder.format = this.formats[relativeIndex];
        return -5;
    }

    public void reset(boolean z16) {
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        if (z16) {
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public synchronized void rewind() {
        this.readPosition = 0;
    }

    public synchronized boolean setReadPosition(int i3) {
        int i16 = this.absoluteFirstIndex;
        if (i16 <= i3 && i3 <= this.length + i16) {
            this.readPosition = i3 - i16;
            return true;
        }
        return false;
    }

    public void sourceId(int i3) {
        this.upstreamSourceId = i3;
    }
}
