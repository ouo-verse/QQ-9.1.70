package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class StreamReader {
    private static final int STATE_END_OF_INPUT = 3;
    private static final int STATE_READ_HEADERS = 0;
    private static final int STATE_READ_PAYLOAD = 2;
    private static final int STATE_SKIP_HEADERS = 1;
    private long currentGranule;
    private ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private final OggPacket oggPacket = new OggPacket();
    private OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private SetupData setupData;
    private int state;
    private long targetGranule;
    private TrackOutput trackOutput;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SetupData {
        Format format;
        OggSeeker oggSeeker;

        SetupData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class UnseekableOggSeeker implements OggSeeker {
        UnseekableOggSeeker() {
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap createSeekMap() {
            return new SeekMap.Unseekable(-9223372036854775807L);
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long startSeek(long j3) {
            return 0L;
        }
    }

    private int readHeaders(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z16 = true;
        while (z16) {
            if (!this.oggPacket.populate(extractorInput)) {
                this.state = 3;
                return -1;
            }
            this.lengthOfReadPacket = extractorInput.getPosition() - this.payloadStartPosition;
            z16 = readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData);
            if (z16) {
                this.payloadStartPosition = extractorInput.getPosition();
            }
        }
        Format format = this.setupData.format;
        this.sampleRate = format.sampleRate;
        if (!this.formatSet) {
            this.trackOutput.format(format);
            this.formatSet = true;
        }
        OggSeeker oggSeeker = this.setupData.oggSeeker;
        if (oggSeeker != null) {
            this.oggSeeker = oggSeeker;
        } else if (extractorInput.getLength() == -1) {
            this.oggSeeker = new UnseekableOggSeeker();
        } else {
            OggPageHeader pageHeader = this.oggPacket.getPageHeader();
            this.oggSeeker = new DefaultOggSeeker(this.payloadStartPosition, extractorInput.getLength(), this, pageHeader.headerSize + pageHeader.bodySize, pageHeader.granulePosition);
        }
        this.setupData = null;
        this.state = 2;
        this.oggPacket.trimPayload();
        return 0;
    }

    private int readPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        long read = this.oggSeeker.read(extractorInput);
        if (read >= 0) {
            positionHolder.position = read;
            return 1;
        }
        if (read < -1) {
            onSeekEnd(-(read + 2));
        }
        if (!this.seekMapSet) {
            this.extractorOutput.seekMap(this.oggSeeker.createSeekMap());
            this.seekMapSet = true;
        }
        if (this.lengthOfReadPacket <= 0 && !this.oggPacket.populate(extractorInput)) {
            this.state = 3;
            return -1;
        }
        this.lengthOfReadPacket = 0L;
        ParsableByteArray payload = this.oggPacket.getPayload();
        long preparePayload = preparePayload(payload);
        if (preparePayload >= 0) {
            long j3 = this.currentGranule;
            if (j3 + preparePayload >= this.targetGranule) {
                long convertGranuleToTime = convertGranuleToTime(j3);
                this.trackOutput.sampleData(payload, payload.limit());
                this.trackOutput.sampleMetadata(convertGranuleToTime, 1, payload.limit(), 0, null);
                this.targetGranule = -1L;
            }
        }
        this.currentGranule += preparePayload;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long convertGranuleToTime(long j3) {
        return (j3 * 1000000) / this.sampleRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long convertTimeToGranule(long j3) {
        return (this.sampleRate * j3) / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = trackOutput;
        reset(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSeekEnd(long j3) {
        this.currentGranule = j3;
    }

    protected abstract long preparePayload(ParsableByteArray parsableByteArray);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        int i3 = this.state;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return readPayload(extractorInput, positionHolder);
                }
                throw new IllegalStateException();
            }
            extractorInput.skipFully((int) this.payloadStartPosition);
            this.state = 2;
            return 0;
        }
        return readHeaders(extractorInput);
    }

    protected abstract boolean readHeaders(ParsableByteArray parsableByteArray, long j3, SetupData setupData) throws IOException, InterruptedException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset(boolean z16) {
        if (z16) {
            this.setupData = new SetupData();
            this.payloadStartPosition = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.targetGranule = -1L;
        this.currentGranule = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void seek(long j3, long j16) {
        this.oggPacket.reset();
        if (j3 == 0) {
            reset(!this.seekMapSet);
        } else if (this.state != 0) {
            this.targetGranule = this.oggSeeker.startSeek(j16);
            this.state = 2;
        }
    }
}
