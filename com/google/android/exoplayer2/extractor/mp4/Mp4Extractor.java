package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final Stack<Atom.ContainerAtom> containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int firstVideoTrackIndex;
    private final int flags;
    private boolean isQuickTime;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private Mp4Track[] tracks;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new Mp4Extractor()};
        }
    };
    private static final int BRAND_QUICKTIME = Util.getIntegerCodeForString("qt  ");

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Flags {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.track = track;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput;
        }
    }

    public Mp4Extractor() {
        this(0);
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i3 = 0; i3 < mp4TrackArr.length; i3++) {
            jArr[i3] = new long[mp4TrackArr[i3].sampleTable.sampleCount];
            jArr2[i3] = mp4TrackArr[i3].sampleTable.timestampsUs[0];
        }
        long j3 = 0;
        int i16 = 0;
        while (i16 < mp4TrackArr.length) {
            long j16 = Long.MAX_VALUE;
            int i17 = -1;
            for (int i18 = 0; i18 < mp4TrackArr.length; i18++) {
                if (!zArr[i18]) {
                    long j17 = jArr2[i18];
                    if (j17 <= j16) {
                        i17 = i18;
                        j16 = j17;
                    }
                }
            }
            int i19 = iArr[i17];
            long[] jArr3 = jArr[i17];
            jArr3[i19] = j3;
            TrackSampleTable trackSampleTable = mp4TrackArr[i17].sampleTable;
            j3 += trackSampleTable.sizes[i19];
            int i26 = i19 + 1;
            iArr[i17] = i26;
            if (i26 < jArr3.length) {
                jArr2[i17] = trackSampleTable.timestampsUs[i26];
            } else {
                zArr[i17] = true;
                i16++;
            }
        }
        return jArr;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable, long j3) {
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j3);
        if (indexOfEarlierOrEqualSynchronizationSample == -1) {
            return trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j3);
        }
        return indexOfEarlierOrEqualSynchronizationSample;
    }

    private int getTrackIndexOfNextReadSample(long j3) {
        boolean z16;
        int i3 = -1;
        int i16 = -1;
        int i17 = 0;
        long j16 = Long.MAX_VALUE;
        boolean z17 = true;
        long j17 = Long.MAX_VALUE;
        boolean z18 = true;
        long j18 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i17 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i17];
            int i18 = mp4Track.sampleIndex;
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            if (i18 != trackSampleTable.sampleCount) {
                long j19 = trackSampleTable.offsets[i18];
                long j26 = this.accumulatedSampleSizes[i17][i18];
                long j27 = j19 - j3;
                if (j27 >= 0 && j27 < 262144) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if ((!z16 && z18) || (z16 == z18 && j27 < j18)) {
                    z18 = z16;
                    j18 = j27;
                    i16 = i17;
                    j17 = j26;
                }
                if (j26 < j16) {
                    z17 = z16;
                    i3 = i17;
                    j16 = j26;
                }
            }
            i17++;
        }
        if (j16 == Long.MAX_VALUE || !z17 || j17 < j16 + MAXIMUM_READ_AHEAD_BYTES_STREAM) {
            return i16;
        }
        return i3;
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable, long j3, long j16) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j3);
        if (synchronizationSampleIndex == -1) {
            return j16;
        }
        return Math.min(trackSampleTable.offsets[synchronizationSampleIndex], j16);
    }

    private void processAtomEnded(long j3) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j3) {
            Atom.ContainerAtom pop = this.containerAtoms.pop();
            if (pop.type == Atom.TYPE_moov) {
                TraceUtil.beginSection("Mp4Extractor.processMoovAtom");
                processMoovAtom(pop);
                TraceUtil.endSection();
                this.containerAtoms.clear();
                this.parserState = 2;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(pop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private static boolean processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
            return true;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
                return true;
            }
        }
        return false;
    }

    private void processMoovAtom(Atom.ContainerAtom containerAtom) throws ParserException {
        Metadata metadata;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_udta);
        if (leafAtomOfType != null) {
            metadata = AtomParsers.parseUdta(leafAtomOfType, this.isQuickTime);
            if (metadata != null) {
                gaplessInfoHolder.setFromMetadata(metadata);
            }
        } else {
            metadata = null;
        }
        int i3 = -1;
        long j3 = -9223372036854775807L;
        for (int i16 = 0; i16 < containerAtom.containerChildren.size(); i16++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i16);
            if (containerAtom2.type == Atom.TYPE_trak) {
                Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd);
                if ((this.flags & 1) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Track parseTrak = AtomParsers.parseTrak(containerAtom2, leafAtomOfType2, -9223372036854775807L, null, z16, this.isQuickTime);
                if (parseTrak != null) {
                    TrackSampleTable parseStbl = AtomParsers.parseStbl(parseTrak, containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl), gaplessInfoHolder);
                    if (parseStbl.sampleCount != 0) {
                        Mp4Track mp4Track = new Mp4Track(parseTrak, parseStbl, this.extractorOutput.track(i16, parseTrak.type));
                        Format copyWithMaxInputSize = parseTrak.format.copyWithMaxInputSize(parseStbl.maximumSize + 30);
                        if (parseTrak.type == 1) {
                            if (gaplessInfoHolder.hasGaplessInfo()) {
                                copyWithMaxInputSize = copyWithMaxInputSize.copyWithGaplessInfo(gaplessInfoHolder.encoderDelay, gaplessInfoHolder.encoderPadding);
                            }
                            if (metadata != null) {
                                copyWithMaxInputSize = copyWithMaxInputSize.copyWithMetadata(metadata);
                            }
                        }
                        mp4Track.trackOutput.format(copyWithMaxInputSize);
                        long j16 = parseTrak.durationUs;
                        if (j16 == -9223372036854775807L) {
                            j16 = parseStbl.durationUs;
                        }
                        j3 = Math.max(j3, j16);
                        if (parseTrak.type == 2 && i3 == -1) {
                            i3 = arrayList.size();
                        }
                        arrayList.add(mp4Track);
                    }
                }
            }
        }
        this.firstVideoTrackIndex = i3;
        this.durationUs = j3;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList.toArray(new Mp4Track[arrayList.size()]);
        this.tracks = mp4TrackArr;
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(mp4TrackArr);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z16;
        boolean z17;
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j3 = this.atomSize;
        if (j3 == 1) {
            extractorInput.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j3 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + this.atomHeaderBytesRead;
            }
        }
        if (this.atomSize >= this.atomHeaderBytesRead) {
            if (shouldParseContainerAtom(this.atomType)) {
                long position = (extractorInput.getPosition() + this.atomSize) - this.atomHeaderBytesRead;
                this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, position));
                if (this.atomSize == this.atomHeaderBytesRead) {
                    processAtomEnded(position);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                if (this.atomHeaderBytesRead == 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Assertions.checkState(z16);
                if (this.atomSize <= TTL.MAX_VALUE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                Assertions.checkState(z17);
                ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
                this.atomData = parsableByteArray;
                System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
                this.parserState = 1;
            } else {
                this.atomData = null;
                this.parserState = 1;
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    private boolean readAtomPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        boolean z16;
        long j3 = this.atomSize - this.atomHeaderBytesRead;
        long position = extractorInput.getPosition() + j3;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.data, this.atomHeaderBytesRead, (int) j3);
            if (this.atomType == Atom.TYPE_ftyp) {
                this.isQuickTime = processFtypAtom(this.atomData);
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(new Atom.LeafAtom(this.atomType, this.atomData));
            }
        } else if (j3 < 262144) {
            extractorInput.skipFully((int) j3);
        } else {
            positionHolder.position = extractorInput.getPosition() + j3;
            z16 = true;
            processAtomEnded(position);
            if (!z16 && this.parserState != 2) {
                return true;
            }
            return false;
        }
        z16 = false;
        processAtomEnded(position);
        if (!z16) {
        }
        return false;
    }

    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        long position = extractorInput.getPosition();
        if (this.sampleTrackIndex == -1) {
            int trackIndexOfNextReadSample = getTrackIndexOfNextReadSample(position);
            this.sampleTrackIndex = trackIndexOfNextReadSample;
            if (trackIndexOfNextReadSample == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.tracks[this.sampleTrackIndex];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int i3 = mp4Track.sampleIndex;
        TrackSampleTable trackSampleTable = mp4Track.sampleTable;
        long j3 = trackSampleTable.offsets[i3];
        int i16 = trackSampleTable.sizes[i3];
        long j16 = (j3 - position) + this.sampleBytesWritten;
        if (j16 >= 0 && j16 < 262144) {
            if (mp4Track.track.sampleTransformation == 1) {
                j16 += 8;
                i16 -= 8;
            }
            extractorInput.skipFully((int) j16);
            int i17 = mp4Track.track.nalUnitLengthFieldLength;
            if (i17 == 0) {
                while (true) {
                    int i18 = this.sampleBytesWritten;
                    if (i18 >= i16) {
                        break;
                    }
                    int sampleData = trackOutput.sampleData(extractorInput, i16 - i18, false);
                    this.sampleBytesWritten += sampleData;
                    this.sampleCurrentNalBytesRemaining -= sampleData;
                }
            } else {
                byte[] bArr = this.nalLength.data;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i19 = 4 - i17;
                while (this.sampleBytesWritten < i16) {
                    int i26 = this.sampleCurrentNalBytesRemaining;
                    if (i26 == 0) {
                        extractorInput.readFully(this.nalLength.data, i19, i17);
                        this.nalLength.setPosition(0);
                        this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                        this.nalStartCode.setPosition(0);
                        trackOutput.sampleData(this.nalStartCode, 4);
                        this.sampleBytesWritten += 4;
                        i16 += i19;
                    } else {
                        int sampleData2 = trackOutput.sampleData(extractorInput, i26, false);
                        this.sampleBytesWritten += sampleData2;
                        this.sampleCurrentNalBytesRemaining -= sampleData2;
                    }
                }
            }
            TrackSampleTable trackSampleTable2 = mp4Track.sampleTable;
            trackOutput.sampleMetadata(trackSampleTable2.timestampsUs[i3], trackSampleTable2.flags[i3], i16, 0, null);
            mp4Track.sampleIndex++;
            this.sampleTrackIndex = -1;
            this.sampleBytesWritten = 0;
            this.sampleCurrentNalBytesRemaining = 0;
            return 0;
        }
        positionHolder.position = j3;
        return 1;
    }

    private static boolean shouldParseContainerAtom(int i3) {
        if (i3 != Atom.TYPE_moov && i3 != Atom.TYPE_trak && i3 != Atom.TYPE_mdia && i3 != Atom.TYPE_minf && i3 != Atom.TYPE_stbl && i3 != Atom.TYPE_edts) {
            return false;
        }
        return true;
    }

    private static boolean shouldParseLeafAtom(int i3) {
        if (i3 != Atom.TYPE_mdhd && i3 != Atom.TYPE_mvhd && i3 != Atom.TYPE_hdlr && i3 != Atom.TYPE_stsd && i3 != Atom.TYPE_stts && i3 != Atom.TYPE_stss && i3 != Atom.TYPE_ctts && i3 != Atom.TYPE_elst && i3 != Atom.TYPE_stsc && i3 != Atom.TYPE_stsz && i3 != Atom.TYPE_stz2 && i3 != Atom.TYPE_stco && i3 != Atom.TYPE_co64 && i3 != Atom.TYPE_tkhd && i3 != Atom.TYPE_ftyp && i3 != Atom.TYPE_udta) {
            return false;
        }
        return true;
    }

    private void updateSampleIndices(long j3) {
        for (Mp4Track mp4Track : this.tracks) {
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j3);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j3);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j3) {
        long j16;
        long j17;
        int indexOfLaterOrEqualSynchronizationSample;
        Mp4Track[] mp4TrackArr = this.tracks;
        if (mp4TrackArr.length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int i3 = this.firstVideoTrackIndex;
        long j18 = -1;
        if (i3 != -1) {
            TrackSampleTable trackSampleTable = mp4TrackArr[i3].sampleTable;
            int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j3);
            if (synchronizationSampleIndex == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            long j19 = trackSampleTable.timestampsUs[synchronizationSampleIndex];
            j16 = trackSampleTable.offsets[synchronizationSampleIndex];
            if (j19 < j3 && synchronizationSampleIndex < trackSampleTable.sampleCount - 1 && (indexOfLaterOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j3)) != -1 && indexOfLaterOrEqualSynchronizationSample != synchronizationSampleIndex) {
                j17 = trackSampleTable.timestampsUs[indexOfLaterOrEqualSynchronizationSample];
                j18 = trackSampleTable.offsets[indexOfLaterOrEqualSynchronizationSample];
            } else {
                j17 = -9223372036854775807L;
            }
            j3 = j19;
        } else {
            j16 = Long.MAX_VALUE;
            j17 = -9223372036854775807L;
        }
        int i16 = 0;
        while (true) {
            Mp4Track[] mp4TrackArr2 = this.tracks;
            if (i16 >= mp4TrackArr2.length) {
                break;
            }
            if (i16 != this.firstVideoTrackIndex) {
                TrackSampleTable trackSampleTable2 = mp4TrackArr2[i16].sampleTable;
                long maybeAdjustSeekOffset = maybeAdjustSeekOffset(trackSampleTable2, j3, j16);
                if (j17 != -9223372036854775807L) {
                    j18 = maybeAdjustSeekOffset(trackSampleTable2, j17, j18);
                }
                j16 = maybeAdjustSeekOffset;
            }
            i16++;
        }
        SeekPoint seekPoint = new SeekPoint(j3, j16);
        if (j17 == -9223372036854775807L) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j17, j18));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            int i3 = this.parserState;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        TraceUtil.beginSection("Mp4Extractor.readSample");
                        int readSample = readSample(extractorInput, positionHolder);
                        TraceUtil.endSection();
                        return readSample;
                    }
                    throw new IllegalStateException();
                }
                TraceUtil.beginSection("Mp4Extractor.readAtomPayload");
                if (readAtomPayload(extractorInput, positionHolder)) {
                    TraceUtil.endSection();
                    return 1;
                }
                TraceUtil.endSection();
            } else {
                TraceUtil.beginSection("Mp4Extractor.readAtomHeader");
                if (!readAtomHeader(extractorInput)) {
                    TraceUtil.endSection();
                    return -1;
                }
                TraceUtil.endSection();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j3, long j16) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if (j3 == 0) {
            enterReadingAtomHeaderState();
        } else if (this.tracks != null) {
            updateSampleIndices(j16);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.sniffUnfragmented(extractorInput);
    }

    public Mp4Extractor(int i3) {
        this.flags = i3;
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new Stack<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleTrackIndex = -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
