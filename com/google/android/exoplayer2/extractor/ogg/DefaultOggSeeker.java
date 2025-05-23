package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultOggSeeker implements OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    public static final int MATCH_BYTE_RANGE = 100000;
    public static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 3;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private long end;
    private long endGranule;
    private final long endPosition;
    private final OggPageHeader pageHeader = new OggPageHeader();
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private final long startPosition;
    private int state;
    private final StreamReader streamReader;
    private long targetGranule;
    private long totalGranules;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class OggSeekMap implements SeekMap {
        OggSeekMap() {
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long j3) {
            if (j3 == 0) {
                return new SeekMap.SeekPoints(new SeekPoint(0L, DefaultOggSeeker.this.startPosition));
            }
            long convertTimeToGranule = DefaultOggSeeker.this.streamReader.convertTimeToGranule(j3);
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            return new SeekMap.SeekPoints(new SeekPoint(j3, defaultOggSeeker.getEstimatedPosition(defaultOggSeeker.startPosition, convertTimeToGranule, 30000L)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    public DefaultOggSeeker(long j3, long j16, StreamReader streamReader, int i3, long j17) {
        boolean z16;
        if (j3 >= 0 && j16 > j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        this.streamReader = streamReader;
        this.startPosition = j3;
        this.endPosition = j16;
        if (i3 == j16 - j3) {
            this.totalGranules = j17;
            this.state = 3;
        } else {
            this.state = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getEstimatedPosition(long j3, long j16, long j17) {
        long j18 = this.endPosition;
        long j19 = this.startPosition;
        long j26 = j3 + (((j16 * (j18 - j19)) / this.totalGranules) - j17);
        if (j26 >= j19) {
            j19 = j26;
        }
        if (j19 >= j18) {
            return j18 - 1;
        }
        return j19;
    }

    public long getNextSeekPosition(long j3, ExtractorInput extractorInput) throws IOException, InterruptedException {
        long j16 = 2;
        if (this.start == this.end) {
            return -(this.startGranule + 2);
        }
        long position = extractorInput.getPosition();
        if (!skipToNextPage(extractorInput, this.end)) {
            long j17 = this.start;
            if (j17 != position) {
                return j17;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        OggPageHeader oggPageHeader = this.pageHeader;
        long j18 = oggPageHeader.granulePosition;
        long j19 = j3 - j18;
        int i3 = oggPageHeader.headerSize + oggPageHeader.bodySize;
        if (j19 >= 0 && j19 <= 72000) {
            extractorInput.skipFully(i3);
            return -(this.pageHeader.granulePosition + 2);
        }
        if (j19 < 0) {
            this.end = position;
            this.endGranule = j18;
        } else {
            long j26 = i3;
            long position2 = extractorInput.getPosition() + j26;
            this.start = position2;
            this.startGranule = this.pageHeader.granulePosition;
            if ((this.end - position2) + j26 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
                extractorInput.skipFully(i3);
                return -(this.startGranule + 2);
            }
        }
        long j27 = this.end;
        long j28 = this.start;
        if (j27 - j28 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
            this.end = j28;
            return j28;
        }
        long j29 = i3;
        if (j19 > 0) {
            j16 = 1;
        }
        long position3 = extractorInput.getPosition();
        long j36 = this.end;
        long j37 = this.start;
        return Math.min(Math.max((position3 - (j29 * j16)) + ((j19 * (j36 - j37)) / (this.endGranule - this.startGranule)), j37), this.end - 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i3 = this.state;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                long j3 = this.targetGranule;
                long j16 = 0;
                if (j3 != 0) {
                    long nextSeekPosition = getNextSeekPosition(j3, extractorInput);
                    if (nextSeekPosition >= 0) {
                        return nextSeekPosition;
                    }
                    j16 = skipToPageOfGranule(extractorInput, this.targetGranule, -(nextSeekPosition + 2));
                }
                this.state = 3;
                return -(j16 + 2);
            }
        } else {
            long position = extractorInput.getPosition();
            this.positionBeforeSeekToEnd = position;
            this.state = 1;
            long j17 = this.endPosition - 65307;
            if (j17 > position) {
                return j17;
            }
        }
        this.totalGranules = readGranuleOfLastPage(extractorInput);
        this.state = 3;
        return this.positionBeforeSeekToEnd;
    }

    long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        skipToNextPage(extractorInput);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.endPosition) {
            this.pageHeader.populate(extractorInput, false);
            OggPageHeader oggPageHeader = this.pageHeader;
            extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    public void resetSeeking() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.startGranule = 0L;
        this.endGranule = this.totalGranules;
    }

    void skipToNextPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (!skipToNextPage(extractorInput, this.endPosition)) {
            throw new EOFException();
        }
    }

    long skipToPageOfGranule(ExtractorInput extractorInput, long j3, long j16) throws IOException, InterruptedException {
        this.pageHeader.populate(extractorInput, false);
        while (true) {
            OggPageHeader oggPageHeader = this.pageHeader;
            if (oggPageHeader.granulePosition < j3) {
                extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
                OggPageHeader oggPageHeader2 = this.pageHeader;
                long j17 = oggPageHeader2.granulePosition;
                oggPageHeader2.populate(extractorInput, false);
                j16 = j17;
            } else {
                extractorInput.resetPeekPosition();
                return j16;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long startSeek(long j3) {
        boolean z16;
        int i3 = this.state;
        if (i3 != 3 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        Assertions.checkArgument(z16);
        long j16 = 0;
        if (j3 != 0) {
            j16 = this.streamReader.convertTimeToGranule(j3);
        }
        this.targetGranule = j16;
        this.state = 2;
        resetSeeking();
        return this.targetGranule;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    boolean skipToNextPage(ExtractorInput extractorInput, long j3) throws IOException, InterruptedException {
        int i3;
        long min = Math.min(j3 + 3, this.endPosition);
        int i16 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i17 = 0;
            if (extractorInput.getPosition() + i16 > min && (i16 = (int) (min - extractorInput.getPosition())) < 4) {
                return false;
            }
            extractorInput.peekFully(bArr, 0, i16, false);
            while (true) {
                i3 = i16 - 3;
                if (i17 < i3) {
                    if (bArr[i17] == 79 && bArr[i17 + 1] == 103 && bArr[i17 + 2] == 103 && bArr[i17 + 3] == 83) {
                        extractorInput.skipFully(i17);
                        return true;
                    }
                    i17++;
                }
            }
            extractorInput.skipFully(i3);
        }
    }
}
