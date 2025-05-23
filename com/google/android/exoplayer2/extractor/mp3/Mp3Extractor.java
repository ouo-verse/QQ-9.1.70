package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Mp3Extractor implements Extractor {
    public static final int FLAG_DISABLE_ID3_METADATA = 2;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_SNIFF_BYTES = 16384;
    private static final int MAX_SYNC_BYTES = 131072;
    private static final int MPEG_AUDIO_HEADER_MASK = -128000;
    private static final int SCRATCH_LENGTH = 10;
    private static final int SEEK_HEADER_UNSET = 0;
    private long basisTimeUs;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private Metadata metadata;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private Seeker seeker;
    private final MpegAudioHeader synchronizedHeader;
    private int synchronizedHeaderData;
    private TrackOutput trackOutput;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new Mp3Extractor()};
        }
    };
    private static final int SEEK_HEADER_XING = Util.getIntegerCodeForString("Xing");
    private static final int SEEK_HEADER_INFO = Util.getIntegerCodeForString("Info");
    private static final int SEEK_HEADER_VBRI = Util.getIntegerCodeForString("VBRI");

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Flags {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Seeker extends SeekMap {
        long getTimeUs(long j3);
    }

    public Mp3Extractor() {
        this(0);
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader);
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int i3) {
        if (parsableByteArray.limit() >= i3 + 4) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (readInt == SEEK_HEADER_XING || readInt == SEEK_HEADER_INFO) {
                return readInt;
            }
        }
        if (parsableByteArray.limit() >= 40) {
            parsableByteArray.setPosition(36);
            int readInt2 = parsableByteArray.readInt();
            int i16 = SEEK_HEADER_VBRI;
            if (readInt2 == i16) {
                return i16;
            }
            return 0;
        }
        return 0;
    }

    private static boolean headersMatch(int i3, long j3) {
        if ((i3 & MPEG_AUDIO_HEADER_MASK) == (j3 & (-128000))) {
            return true;
        }
        return false;
    }

    private Seeker maybeReadSeekFrame(ExtractorInput extractorInput) throws IOException, InterruptedException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.synchronizedHeader.frameSize);
        extractorInput.peekFully(parsableByteArray.data, 0, this.synchronizedHeader.frameSize);
        MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
        int i3 = mpegAudioHeader.version & 1;
        int i16 = 21;
        int i17 = mpegAudioHeader.channels;
        if (i3 != 0) {
            if (i17 != 1) {
                i16 = 36;
            }
        } else if (i17 == 1) {
            i16 = 13;
        }
        int i18 = i16;
        int seekFrameHeader = getSeekFrameHeader(parsableByteArray, i18);
        if (seekFrameHeader != SEEK_HEADER_XING && seekFrameHeader != SEEK_HEADER_INFO) {
            if (seekFrameHeader == SEEK_HEADER_VBRI) {
                VbriSeeker create = VbriSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
                extractorInput.skipFully(this.synchronizedHeader.frameSize);
                return create;
            }
            extractorInput.resetPeekPosition();
            return null;
        }
        XingSeeker create2 = XingSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
        if (create2 != null && !this.gaplessInfoHolder.hasGaplessInfo()) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition(i18 + 141);
            extractorInput.peekFully(this.scratch.data, 0, 3);
            this.scratch.setPosition(0);
            this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
        }
        extractorInput.skipFully(this.synchronizedHeader.frameSize);
        if (create2 != null && !create2.isSeekable() && seekFrameHeader == SEEK_HEADER_INFO) {
            return getConstantBitrateSeeker(extractorInput);
        }
        return create2;
    }

    private void peekId3Data(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Id3Decoder.FramePredicate framePredicate;
        int i3 = 0;
        while (true) {
            extractorInput.peekFully(this.scratch.data, 0, 10);
            this.scratch.setPosition(0);
            if (this.scratch.readUnsignedInt24() != Id3Decoder.ID3_TAG) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i3);
                return;
            }
            this.scratch.skipBytes(3);
            int readSynchSafeInt = this.scratch.readSynchSafeInt();
            int i16 = readSynchSafeInt + 10;
            if (this.metadata == null) {
                byte[] bArr = new byte[i16];
                System.arraycopy(this.scratch.data, 0, bArr, 0, 10);
                extractorInput.peekFully(bArr, 10, readSynchSafeInt);
                if ((this.flags & 2) != 0) {
                    framePredicate = GaplessInfoHolder.GAPLESS_INFO_ID3_FRAME_PREDICATE;
                } else {
                    framePredicate = null;
                }
                Metadata decode = new Id3Decoder(framePredicate).decode(bArr, i16);
                this.metadata = decode;
                if (decode != null) {
                    this.gaplessInfoHolder.setFromMetadata(decode);
                }
            } else {
                extractorInput.advancePeekPosition(readSynchSafeInt);
            }
            i3 += i16;
        }
    }

    private int readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (!extractorInput.peekFully(this.scratch.data, 0, 4, true)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if (headersMatch(readInt, this.synchronizedHeaderData) && MpegAudioHeader.getFrameSize(readInt) != -1) {
                MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
                if (this.basisTimeUs == -9223372036854775807L) {
                    this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                    if (this.forcedFirstSampleTimestampUs != -9223372036854775807L) {
                        this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0L);
                    }
                }
                this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
            } else {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
        }
        int sampleData = this.trackOutput.sampleData(extractorInput, this.sampleBytesRemaining, true);
        if (sampleData == -1) {
            return -1;
        }
        int i3 = this.sampleBytesRemaining - sampleData;
        this.sampleBytesRemaining = i3;
        if (i3 > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.basisTimeUs + ((this.samplesRead * 1000000) / r14.sampleRate), 1, this.synchronizedHeader.frameSize, 0, null);
        this.samplesRead += this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z16) throws IOException, InterruptedException {
        int i3;
        int i16;
        int i17;
        boolean z17;
        int frameSize;
        if (z16) {
            i3 = 16384;
        } else {
            i3 = 131072;
        }
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            peekId3Data(extractorInput);
            i16 = (int) extractorInput.getPeekPosition();
            if (!z16) {
                extractorInput.skipFully(i16);
            }
            i17 = 0;
        } else {
            i16 = 0;
            i17 = 0;
        }
        int i18 = i17;
        int i19 = i18;
        while (true) {
            byte[] bArr = this.scratch.data;
            if (i17 > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!extractorInput.peekFully(bArr, 0, 4, z17)) {
                break;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if ((i18 != 0 && !headersMatch(readInt, i18)) || (frameSize = MpegAudioHeader.getFrameSize(readInt)) == -1) {
                int i26 = i19 + 1;
                if (i19 == i3) {
                    if (z16) {
                        return false;
                    }
                    throw new ParserException("Searched too many bytes.");
                }
                if (z16) {
                    extractorInput.resetPeekPosition();
                    extractorInput.advancePeekPosition(i16 + i26);
                } else {
                    extractorInput.skipFully(1);
                }
                i18 = 0;
                i19 = i26;
                i17 = 0;
            } else {
                i17++;
                if (i17 == 1) {
                    MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
                    i18 = readInt;
                } else if (i17 == 4) {
                    break;
                }
                extractorInput.advancePeekPosition(frameSize - 4);
            }
        }
        if (z16) {
            extractorInput.skipFully(i16 + i19);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i18;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        this.extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        Metadata metadata;
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.seeker == null) {
            Seeker maybeReadSeekFrame = maybeReadSeekFrame(extractorInput);
            this.seeker = maybeReadSeekFrame;
            if (maybeReadSeekFrame == null || (!maybeReadSeekFrame.isSeekable() && (this.flags & 1) != 0)) {
                this.seeker = getConstantBitrateSeeker(extractorInput);
            }
            this.extractorOutput.seekMap(this.seeker);
            TrackOutput trackOutput = this.trackOutput;
            MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
            String str = mpegAudioHeader.mimeType;
            int i3 = mpegAudioHeader.channels;
            int i16 = mpegAudioHeader.sampleRate;
            GaplessInfoHolder gaplessInfoHolder = this.gaplessInfoHolder;
            int i17 = gaplessInfoHolder.encoderDelay;
            int i18 = gaplessInfoHolder.encoderPadding;
            if ((this.flags & 2) != 0) {
                metadata = null;
            } else {
                metadata = this.metadata;
            }
            trackOutput.format(Format.createAudioSampleFormat(null, str, null, -1, 4096, i3, i16, -1, i17, i18, null, null, 0, null, metadata));
        }
        return readSample(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j3, long j16) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = -9223372036854775807L;
        this.samplesRead = 0L;
        this.sampleBytesRemaining = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return synchronize(extractorInput, true);
    }

    public Mp3Extractor(int i3) {
        this(i3, -9223372036854775807L);
    }

    public Mp3Extractor(int i3, long j3) {
        this.flags = i3;
        this.forcedFirstSampleTimestampUs = j3;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioHeader();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
