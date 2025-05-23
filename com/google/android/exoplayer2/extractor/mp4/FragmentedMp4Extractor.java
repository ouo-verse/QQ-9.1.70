package com.google.android.exoplayer2.extractor.mp4;

import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class FragmentedMp4Extractor implements Extractor {
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    private static final int FLAG_SIDELOADED = 8;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";

    @Nullable
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] cea608TrackOutputs;
    private final List<Format> closedCaptionFormats;
    private final Stack<Atom.ContainerAtom> containerAtoms;
    private TrackBundle currentTrackBundle;
    private final ParsableByteArray defaultInitializationVector;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private final ParsableByteArray encryptionSignalByte;
    private long endOfMdatPosition;
    private final byte[] extendedTypeScratch;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private long segmentIndexEarliestPresentationTimeUs;
    private final DrmInitData sideloadedDrmInitData;
    private final Track sideloadedTrack;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new FragmentedMp4Extractor()};
        }
    };
    private static final int SAMPLE_GROUP_TYPE_seig = Util.getIntegerCodeForString("seig");
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, -94, 68, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 66, 124, 100, -115, -12};
    private static final Format EMSG_FORMAT = Format.createSampleFormat(null, "application/x-emsg", Long.MAX_VALUE);

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Flags {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class MetadataSampleInfo {
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long j3, int i3) {
            this.presentationTimeDeltaUs = j3;
            this.size = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class TrackBundle {
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        public DefaultSampleValues defaultSampleValues;
        public final TrackFragment fragment = new TrackFragment();
        public final TrackOutput output;
        public Track track;

        public TrackBundle(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        public void init(Track track, DefaultSampleValues defaultSampleValues) {
            this.track = (Track) Assertions.checkNotNull(track);
            this.defaultSampleValues = (DefaultSampleValues) Assertions.checkNotNull(defaultSampleValues);
            this.output.format(track.format);
            reset();
        }

        public void reset() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
        }

        public void updateDrmInitData(DrmInitData drmInitData) {
            String str;
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
            if (sampleDescriptionEncryptionBox != null) {
                str = sampleDescriptionEncryptionBox.schemeType;
            } else {
                str = null;
            }
            this.output.format(this.track.format.copyWithDrmInitData(drmInitData.copyWithSchemeType(str)));
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    private int appendSampleEncryptionData(TrackBundle trackBundle) {
        ParsableByteArray parsableByteArray;
        int i3;
        TrackFragment trackFragment = trackBundle.fragment;
        int i16 = trackFragment.header.sampleDescriptionIndex;
        TrackEncryptionBox trackEncryptionBox = trackFragment.trackEncryptionBox;
        if (trackEncryptionBox == null) {
            trackEncryptionBox = trackBundle.track.getSampleDescriptionEncryptionBox(i16);
        }
        int i17 = trackEncryptionBox.initializationVectorSize;
        if (i17 != 0) {
            parsableByteArray = trackFragment.sampleEncryptionData;
        } else {
            byte[] bArr = trackEncryptionBox.defaultInitializationVector;
            this.defaultInitializationVector.reset(bArr, bArr.length);
            parsableByteArray = this.defaultInitializationVector;
            i17 = bArr.length;
        }
        boolean z16 = trackFragment.sampleHasSubsampleEncryptionTable[trackBundle.currentSampleIndex];
        ParsableByteArray parsableByteArray2 = this.encryptionSignalByte;
        byte[] bArr2 = parsableByteArray2.data;
        if (z16) {
            i3 = 128;
        } else {
            i3 = 0;
        }
        bArr2[0] = (byte) (i3 | i17);
        parsableByteArray2.setPosition(0);
        TrackOutput trackOutput = trackBundle.output;
        trackOutput.sampleData(this.encryptionSignalByte, 1);
        trackOutput.sampleData(parsableByteArray, i17);
        if (!z16) {
            return i17 + 1;
        }
        ParsableByteArray parsableByteArray3 = trackFragment.sampleEncryptionData;
        int readUnsignedShort = parsableByteArray3.readUnsignedShort();
        parsableByteArray3.skipBytes(-2);
        int i18 = (readUnsignedShort * 6) + 2;
        trackOutput.sampleData(parsableByteArray3, i18);
        return i17 + 1 + i18;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            Atom.LeafAtom leafAtom = list.get(i3);
            if (leafAtom.type == Atom.TYPE_pssh) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = leafAtom.data.data;
                UUID parseUuid = PsshAtomUtil.parseUuid(bArr);
                if (parseUuid == null) {
                    Log.w(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(parseUuid, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static TrackBundle getNextFragmentRun(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j3 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < size; i3++) {
            TrackBundle valueAt = sparseArray.valueAt(i3);
            int i16 = valueAt.currentTrackRunIndex;
            TrackFragment trackFragment = valueAt.fragment;
            if (i16 != trackFragment.trunCount) {
                long j16 = trackFragment.trunDataPosition[i16];
                if (j16 < j3) {
                    trackBundle = valueAt;
                    j3 = j16;
                }
            }
        }
        return trackBundle;
    }

    private void maybeInitExtraTracks() {
        int i3;
        if (this.emsgTrackOutputs == null) {
            TrackOutput[] trackOutputArr = new TrackOutput[2];
            this.emsgTrackOutputs = trackOutputArr;
            TrackOutput trackOutput = this.additionalEmsgTrackOutput;
            if (trackOutput != null) {
                trackOutputArr[0] = trackOutput;
                i3 = 1;
            } else {
                i3 = 0;
            }
            if ((this.flags & 4) != 0) {
                trackOutputArr[i3] = this.extractorOutput.track(this.trackBundles.size(), 4);
                i3++;
            }
            TrackOutput[] trackOutputArr2 = (TrackOutput[]) Arrays.copyOf(this.emsgTrackOutputs, i3);
            this.emsgTrackOutputs = trackOutputArr2;
            for (TrackOutput trackOutput2 : trackOutputArr2) {
                trackOutput2.format(EMSG_FORMAT);
            }
        }
        if (this.cea608TrackOutputs == null) {
            this.cea608TrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
            for (int i16 = 0; i16 < this.cea608TrackOutputs.length; i16++) {
                TrackOutput track = this.extractorOutput.track(this.trackBundles.size() + 1 + i16, 3);
                track.format(this.closedCaptionFormats.get(i16));
                this.cea608TrackOutputs[i16] = track;
            }
        }
    }

    private void onContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        int i3 = containerAtom.type;
        if (i3 == Atom.TYPE_moov) {
            onMoovContainerAtomRead(containerAtom);
        } else if (i3 == Atom.TYPE_moof) {
            onMoofContainerAtomRead(containerAtom);
        } else if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(containerAtom);
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray parsableByteArray) {
        TrackOutput[] trackOutputArr = this.emsgTrackOutputs;
        if (trackOutputArr != null && trackOutputArr.length != 0) {
            parsableByteArray.setPosition(12);
            int bytesLeft = parsableByteArray.bytesLeft();
            parsableByteArray.readNullTerminatedString();
            parsableByteArray.readNullTerminatedString();
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000L, parsableByteArray.readUnsignedInt());
            for (TrackOutput trackOutput : this.emsgTrackOutputs) {
                parsableByteArray.setPosition(12);
                trackOutput.sampleData(parsableByteArray, bytesLeft);
            }
            if (this.segmentIndexEarliestPresentationTimeUs != -9223372036854775807L) {
                for (TrackOutput trackOutput2 : this.emsgTrackOutputs) {
                    trackOutput2.sampleMetadata(this.segmentIndexEarliestPresentationTimeUs + scaleLargeTimestamp, 1, bytesLeft, 0, null);
                }
                return;
            }
            this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(scaleLargeTimestamp, bytesLeft));
            this.pendingMetadataSampleBytes += bytesLeft;
        }
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j3) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafAtom);
            return;
        }
        int i3 = leafAtom.type;
        if (i3 == Atom.TYPE_sidx) {
            Pair<Long, ChunkIndex> parseSidx = parseSidx(leafAtom.data, j3);
            this.segmentIndexEarliestPresentationTimeUs = ((Long) parseSidx.first).longValue();
            this.extractorOutput.seekMap((SeekMap) parseSidx.second);
            this.haveOutputSeekMap = true;
            return;
        }
        if (i3 == Atom.TYPE_emsg) {
            onEmsgLeafAtomRead(leafAtom.data);
        }
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        DrmInitData drmInitDataFromAtoms;
        parseMoof(containerAtom, this.trackBundles, this.flags, this.extendedTypeScratch);
        if (this.sideloadedDrmInitData != null) {
            drmInitDataFromAtoms = null;
        } else {
            drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        }
        if (drmInitDataFromAtoms != null) {
            int size = this.trackBundles.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.trackBundles.valueAt(i3).updateDrmInitData(drmInitDataFromAtoms);
            }
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z16;
        int i3;
        int i16;
        boolean z17;
        boolean z18 = true;
        int i17 = 0;
        if (this.sideloadedTrack == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16, "Unexpected moov box.");
        DrmInitData drmInitData = this.sideloadedDrmInitData;
        if (drmInitData == null) {
            drmInitData = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        }
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mvex);
        SparseArray sparseArray = new SparseArray();
        int size = containerAtomOfType.leafChildren.size();
        long j3 = -9223372036854775807L;
        for (int i18 = 0; i18 < size; i18++) {
            Atom.LeafAtom leafAtom = containerAtomOfType.leafChildren.get(i18);
            int i19 = leafAtom.type;
            if (i19 == Atom.TYPE_trex) {
                Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                sparseArray.put(((Integer) parseTrex.first).intValue(), parseTrex.second);
            } else if (i19 == Atom.TYPE_mehd) {
                j3 = parseMehd(leafAtom.data);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = containerAtom.containerChildren.size();
        int i26 = 0;
        while (i26 < size2) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i26);
            if (containerAtom2.type == Atom.TYPE_trak) {
                Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd);
                if ((this.flags & 16) != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                i3 = i26;
                boolean z19 = z17;
                i16 = size2;
                Track parseTrak = AtomParsers.parseTrak(containerAtom2, leafAtomOfType, j3, drmInitData, z19, false);
                if (parseTrak != null) {
                    sparseArray2.put(parseTrak.f32942id, parseTrak);
                }
            } else {
                i3 = i26;
                i16 = size2;
            }
            i26 = i3 + 1;
            size2 = i16;
        }
        int size3 = sparseArray2.size();
        if (this.trackBundles.size() == 0) {
            while (i17 < size3) {
                Track track = (Track) sparseArray2.valueAt(i17);
                TrackBundle trackBundle = new TrackBundle(this.extractorOutput.track(i17, track.type));
                trackBundle.init(track, (DefaultSampleValues) sparseArray.get(track.f32942id));
                this.trackBundles.put(track.f32942id, trackBundle);
                this.durationUs = Math.max(this.durationUs, track.durationUs);
                i17++;
            }
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
            return;
        }
        if (this.trackBundles.size() != size3) {
            z18 = false;
        }
        Assertions.checkState(z18);
        while (i17 < size3) {
            Track track2 = (Track) sparseArray2.valueAt(i17);
            this.trackBundles.get(track2.f32942id).init(track2, (DefaultSampleValues) sparseArray.get(track2.f32942id));
            i17++;
        }
    }

    private void outputPendingMetadataSamples(long j3) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo removeFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= removeFirst.size;
            for (TrackOutput trackOutput : this.emsgTrackOutputs) {
                trackOutput.sampleMetadata(removeFirst.presentationTimeDeltaUs + j3, 1, removeFirst.size, this.pendingMetadataSampleBytes, null);
            }
        }
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0) {
            return parsableByteArray.readUnsignedInt();
        }
        return parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i3, byte[] bArr) throws ParserException {
        int size = containerAtom.containerChildren.size();
        for (int i16 = 0; i16 < size; i16++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i16);
            if (containerAtom2.type == Atom.TYPE_traf) {
                parseTraf(containerAtom2, sparseArray, i3, bArr);
            }
        }
    }

    private static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        long readUnsignedLongToLong;
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if ((Atom.parseFullAtomFlags(readInt) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == 1) {
            int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt);
            long j3 = trackFragment.auxiliaryDataPosition;
            if (parseFullAtomVersion == 0) {
                readUnsignedLongToLong = parsableByteArray.readUnsignedInt();
            } else {
                readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            }
            trackFragment.auxiliaryDataPosition = j3 + readUnsignedLongToLong;
            return;
        }
        throw new ParserException("Unexpected saio entry count: " + readUnsignedIntToInt);
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i3;
        boolean z16;
        int i16 = trackEncryptionBox.initializationVectorSize;
        parsableByteArray.setPosition(8);
        boolean z17 = true;
        if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == trackFragment.sampleCount) {
            if (readUnsignedByte == 0) {
                boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
                i3 = 0;
                for (int i17 = 0; i17 < readUnsignedIntToInt; i17++) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    i3 += readUnsignedByte2;
                    if (readUnsignedByte2 > i16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    zArr[i17] = z16;
                }
            } else {
                if (readUnsignedByte <= i16) {
                    z17 = false;
                }
                i3 = (readUnsignedByte * readUnsignedIntToInt) + 0;
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z17);
            }
            trackFragment.initEncryptionData(i3);
            return;
        }
        throw new ParserException("Length mismatch: " + readUnsignedIntToInt + ", " + trackFragment.sampleCount);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static void parseSgpd(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, String str, TrackFragment trackFragment) throws ParserException {
        boolean z16;
        byte[] bArr;
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        int i3 = SAMPLE_GROUP_TYPE_seig;
        if (readInt2 != i3) {
            return;
        }
        if (Atom.parseFullAtomVersion(readInt) == 1) {
            parsableByteArray.skipBytes(4);
        }
        if (parsableByteArray.readInt() == 1) {
            parsableByteArray2.setPosition(8);
            int readInt3 = parsableByteArray2.readInt();
            if (parsableByteArray2.readInt() != i3) {
                return;
            }
            int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt3);
            if (parseFullAtomVersion == 1) {
                if (parsableByteArray2.readUnsignedInt() == 0) {
                    throw new ParserException("Variable length description in sgpd found (unsupported)");
                }
            } else if (parseFullAtomVersion >= 2) {
                parsableByteArray2.skipBytes(4);
            }
            if (parsableByteArray2.readUnsignedInt() == 1) {
                parsableByteArray2.skipBytes(1);
                int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                int i16 = (readUnsignedByte & 240) >> 4;
                int i17 = readUnsignedByte & 15;
                if (parsableByteArray2.readUnsignedByte() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return;
                }
                int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray2.readBytes(bArr2, 0, 16);
                if (z16 && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                    byte[] bArr3 = new byte[readUnsignedByte3];
                    parsableByteArray2.readBytes(bArr3, 0, readUnsignedByte3);
                    bArr = bArr3;
                } else {
                    bArr = null;
                }
                trackFragment.definesEncryptionData = true;
                trackFragment.trackEncryptionBox = new TrackEncryptionBox(z16, str, readUnsignedByte2, bArr2, i16, i17, bArr);
                return;
            }
            throw new ParserException("Entry count in sgpd != 1 (unsupported).");
        }
        throw new ParserException("Entry count in sbgp != 1 (unsupported).");
    }

    private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j3) throws ParserException {
        long readUnsignedLongToLong;
        long readUnsignedLongToLong2;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            readUnsignedLongToLong = parsableByteArray.readUnsignedInt();
            readUnsignedLongToLong2 = parsableByteArray.readUnsignedInt();
        } else {
            readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            readUnsignedLongToLong2 = parsableByteArray.readUnsignedLongToLong();
        }
        long j16 = readUnsignedLongToLong;
        long j17 = j3 + readUnsignedLongToLong2;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j16, 1000000L, readUnsignedInt);
        parsableByteArray.skipBytes(2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j18 = scaleLargeTimestamp;
        int i3 = 0;
        long j19 = j16;
        while (i3 < readUnsignedShort) {
            int readInt = parsableByteArray.readInt();
            if ((readInt & Integer.MIN_VALUE) == 0) {
                long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                iArr[i3] = readInt & Integer.MAX_VALUE;
                jArr[i3] = j17;
                jArr3[i3] = j18;
                long j26 = j19 + readUnsignedInt2;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i16 = readUnsignedShort;
                long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j26, 1000000L, readUnsignedInt);
                jArr4[i3] = scaleLargeTimestamp2 - jArr5[i3];
                parsableByteArray.skipBytes(4);
                j17 += r1[i3];
                i3++;
                iArr = iArr;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                readUnsignedShort = i16;
                j19 = j26;
                j18 = scaleLargeTimestamp2;
            } else {
                throw new ParserException("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(scaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1) {
            return parsableByteArray.readUnsignedLongToLong();
        }
        return parsableByteArray.readUnsignedInt();
    }

    private static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray, int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        int readInt = parsableByteArray.readInt();
        if ((i3 & 8) != 0) {
            readInt = 0;
        }
        TrackBundle trackBundle = sparseArray.get(readInt);
        if (trackBundle == null) {
            return null;
        }
        if ((parseFullAtomFlags & 1) != 0) {
            long readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            TrackFragment trackFragment = trackBundle.fragment;
            trackFragment.dataPosition = readUnsignedLongToLong;
            trackFragment.auxiliaryDataPosition = readUnsignedLongToLong;
        }
        DefaultSampleValues defaultSampleValues = trackBundle.defaultSampleValues;
        if ((parseFullAtomFlags & 2) != 0) {
            i16 = parsableByteArray.readUnsignedIntToInt() - 1;
        } else {
            i16 = defaultSampleValues.sampleDescriptionIndex;
        }
        if ((parseFullAtomFlags & 8) != 0) {
            i17 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i17 = defaultSampleValues.duration;
        }
        if ((parseFullAtomFlags & 16) != 0) {
            i18 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i18 = defaultSampleValues.size;
        }
        if ((parseFullAtomFlags & 32) != 0) {
            i19 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i19 = defaultSampleValues.flags;
        }
        trackBundle.fragment.header = new DefaultSampleValues(i16, i17, i18, i19);
        return trackBundle;
    }

    private static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i3, byte[] bArr) throws ParserException {
        String str;
        TrackBundle parseTfhd = parseTfhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd).data, sparseArray, i3);
        if (parseTfhd == null) {
            return;
        }
        TrackFragment trackFragment = parseTfhd.fragment;
        long j3 = trackFragment.nextFragmentDecodeTime;
        parseTfhd.reset();
        int i16 = Atom.TYPE_tfdt;
        if (containerAtom.getLeafAtomOfType(i16) != null && (i3 & 2) == 0) {
            j3 = parseTfdt(containerAtom.getLeafAtomOfType(i16).data);
        }
        parseTruns(containerAtom, parseTfhd, j3, i3);
        TrackEncryptionBox sampleDescriptionEncryptionBox = parseTfhd.track.getSampleDescriptionEncryptionBox(trackFragment.header.sampleDescriptionIndex);
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
        if (leafAtomOfType != null) {
            parseSaiz(sampleDescriptionEncryptionBox, leafAtomOfType.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_saio);
        if (leafAtomOfType2 != null) {
            parseSaio(leafAtomOfType2.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_senc);
        if (leafAtomOfType3 != null) {
            parseSenc(leafAtomOfType3.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_sbgp);
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_sgpd);
        if (leafAtomOfType4 != null && leafAtomOfType5 != null) {
            ParsableByteArray parsableByteArray = leafAtomOfType4.data;
            ParsableByteArray parsableByteArray2 = leafAtomOfType5.data;
            if (sampleDescriptionEncryptionBox != null) {
                str = sampleDescriptionEncryptionBox.schemeType;
            } else {
                str = null;
            }
            parseSgpd(parsableByteArray, parsableByteArray2, str, trackFragment);
        }
        int size = containerAtom.leafChildren.size();
        for (int i17 = 0; i17 < size; i17++) {
            Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i17);
            if (leafAtom.type == Atom.TYPE_uuid) {
                parseUuid(leafAtom.data, trackFragment, bArr);
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readUnsignedIntToInt() - 1, parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readInt()));
    }

    private static int parseTrun(TrackBundle trackBundle, int i3, long j3, int i16, ParsableByteArray parsableByteArray, int i17) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        long j16;
        int i18;
        boolean z28;
        int i19;
        boolean z29;
        int i26;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z46;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        Track track = trackBundle.track;
        TrackFragment trackFragment = trackBundle.fragment;
        DefaultSampleValues defaultSampleValues = trackFragment.header;
        trackFragment.trunLength[i3] = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = trackFragment.trunDataPosition;
        long j17 = trackFragment.dataPosition;
        jArr[i3] = j17;
        if ((parseFullAtomFlags & 1) != 0) {
            jArr[i3] = j17 + parsableByteArray.readInt();
        }
        if ((parseFullAtomFlags & 4) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i27 = defaultSampleValues.flags;
        if (z16) {
            i27 = parsableByteArray.readUnsignedIntToInt();
        }
        if ((parseFullAtomFlags & 256) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((parseFullAtomFlags & 512) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if ((parseFullAtomFlags & 1024) != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if ((parseFullAtomFlags & 2048) != 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        long[] jArr2 = track.editListDurations;
        long j18 = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            j18 = Util.scaleLargeTimestamp(track.editListMediaTimes[0], 1000L, track.timescale);
        }
        int[] iArr = trackFragment.sampleSizeTable;
        int[] iArr2 = trackFragment.sampleCompositionTimeOffsetTable;
        long[] jArr3 = trackFragment.sampleDecodingTimeTable;
        boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
        int i28 = i27;
        if (track.type == 2 && (i16 & 1) != 0) {
            z27 = true;
        } else {
            z27 = false;
        }
        int i29 = i17 + trackFragment.trunLength[i3];
        long j19 = track.timescale;
        long j26 = j18;
        if (i3 > 0) {
            j16 = trackFragment.nextFragmentDecodeTime;
        } else {
            j16 = j3;
        }
        long j27 = j16;
        int i36 = i17;
        while (i36 < i29) {
            if (z17) {
                i18 = parsableByteArray.readUnsignedIntToInt();
            } else {
                i18 = defaultSampleValues.duration;
            }
            if (z18) {
                z28 = z17;
                i19 = parsableByteArray.readUnsignedIntToInt();
            } else {
                z28 = z17;
                i19 = defaultSampleValues.size;
            }
            if (i36 == 0 && z16) {
                z29 = z16;
                i26 = i28;
            } else if (z19) {
                z29 = z16;
                i26 = parsableByteArray.readInt();
            } else {
                z29 = z16;
                i26 = defaultSampleValues.flags;
            }
            if (z26) {
                z36 = z26;
                z37 = z18;
                z38 = z19;
                iArr2[i36] = (int) ((parsableByteArray.readInt() * 1000) / j19);
                z39 = false;
            } else {
                z36 = z26;
                z37 = z18;
                z38 = z19;
                z39 = false;
                iArr2[i36] = 0;
            }
            jArr3[i36] = Util.scaleLargeTimestamp(j27, 1000L, j19) - j26;
            iArr[i36] = i19;
            if (((i26 >> 16) & 1) == 0 && (!z27 || i36 == 0)) {
                z46 = true;
            } else {
                z46 = z39;
            }
            zArr[i36] = z46;
            i36++;
            j27 += i18;
            j19 = j19;
            z17 = z28;
            z16 = z29;
            z26 = z36;
            z18 = z37;
            z19 = z38;
        }
        trackFragment.nextFragmentDecodeTime = j27;
        return i29;
    }

    private static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, long j3, int i3) {
        List<Atom.LeafAtom> list = containerAtom.leafChildren;
        int size = list.size();
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            Atom.LeafAtom leafAtom = list.get(i18);
            if (leafAtom.type == Atom.TYPE_trun) {
                ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt > 0) {
                    i17 += readUnsignedIntToInt;
                    i16++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i16, i17);
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < size; i27++) {
            Atom.LeafAtom leafAtom2 = list.get(i27);
            if (leafAtom2.type == Atom.TYPE_trun) {
                i26 = parseTrun(trackBundle, i19, j3, i3, leafAtom2.data, i26);
                i19++;
            }
        }
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (!Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            return;
        }
        parseSenc(parsableByteArray, 16, trackFragment);
    }

    private void processAtomEnded(long j3) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j3) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
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
            long position = extractorInput.getPosition() - this.atomHeaderBytesRead;
            if (this.atomType == Atom.TYPE_moof) {
                int size = this.trackBundles.size();
                for (int i3 = 0; i3 < size; i3++) {
                    TrackFragment trackFragment = this.trackBundles.valueAt(i3).fragment;
                    trackFragment.atomPosition = position;
                    trackFragment.auxiliaryDataPosition = position;
                    trackFragment.dataPosition = position;
                }
            }
            int i16 = this.atomType;
            if (i16 == Atom.TYPE_mdat) {
                this.currentTrackBundle = null;
                this.endOfMdatPosition = this.atomSize + position;
                if (!this.haveOutputSeekMap) {
                    this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position));
                    this.haveOutputSeekMap = true;
                }
                this.parserState = 2;
                return true;
            }
            if (shouldParseContainerAtom(i16)) {
                long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
                this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, position2));
                if (this.atomSize == this.atomHeaderBytesRead) {
                    processAtomEnded(position2);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                if (this.atomHeaderBytesRead == 8) {
                    long j16 = this.atomSize;
                    if (j16 <= TTL.MAX_VALUE) {
                        ParsableByteArray parsableByteArray = new ParsableByteArray((int) j16);
                        this.atomData = parsableByteArray;
                        System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
                        this.parserState = 1;
                    } else {
                        throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.atomSize <= TTL.MAX_VALUE) {
                this.atomData = null;
                this.parserState = 1;
            } else {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i3 = ((int) this.atomSize) - this.atomHeaderBytesRead;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.data, 8, i3);
            onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i3);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int size = this.trackBundles.size();
        TrackBundle trackBundle = null;
        long j3 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < size; i3++) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i3).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill) {
                long j16 = trackFragment.auxiliaryDataPosition;
                if (j16 < j3) {
                    trackBundle = this.trackBundles.valueAt(i3);
                    j3 = j16;
                }
            }
        }
        if (trackBundle == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j3 - extractorInput.getPosition());
        if (position >= 0) {
            extractorInput.skipFully(position);
            trackBundle.fragment.fillEncryptionData(extractorInput);
            return;
        }
        throw new ParserException("Offset to encryption data was negative.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i3;
        TrackOutput.CryptoData cryptoData;
        int sampleData;
        boolean z16;
        int i16 = 4;
        int i17 = 1;
        int i18 = 0;
        if (this.parserState == 3) {
            if (this.currentTrackBundle == null) {
                TrackBundle nextFragmentRun = getNextFragmentRun(this.trackBundles);
                if (nextFragmentRun == null) {
                    int position = (int) (this.endOfMdatPosition - extractorInput.getPosition());
                    if (position >= 0) {
                        extractorInput.skipFully(position);
                        enterReadingAtomHeaderState();
                        return false;
                    }
                    throw new ParserException("Offset to end of mdat was negative.");
                }
                int position2 = (int) (nextFragmentRun.fragment.trunDataPosition[nextFragmentRun.currentTrackRunIndex] - extractorInput.getPosition());
                if (position2 < 0) {
                    Log.w(TAG, "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                extractorInput.skipFully(position2);
                this.currentTrackBundle = nextFragmentRun;
            }
            TrackBundle trackBundle = this.currentTrackBundle;
            TrackFragment trackFragment = trackBundle.fragment;
            this.sampleSize = trackFragment.sampleSizeTable[trackBundle.currentSampleIndex];
            if (trackFragment.definesEncryptionData) {
                int appendSampleEncryptionData = appendSampleEncryptionData(trackBundle);
                this.sampleBytesWritten = appendSampleEncryptionData;
                this.sampleSize += appendSampleEncryptionData;
            } else {
                this.sampleBytesWritten = 0;
            }
            if (this.currentTrackBundle.track.sampleTransformation == 1) {
                this.sampleSize -= 8;
                extractorInput.skipFully(8);
            }
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
        }
        TrackBundle trackBundle2 = this.currentTrackBundle;
        TrackFragment trackFragment2 = trackBundle2.fragment;
        Track track = trackBundle2.track;
        TrackOutput trackOutput = trackBundle2.output;
        int i19 = trackBundle2.currentSampleIndex;
        int i26 = track.nalUnitLengthFieldLength;
        if (i26 == 0) {
            while (true) {
                int i27 = this.sampleBytesWritten;
                int i28 = this.sampleSize;
                if (i27 >= i28) {
                    break;
                }
                this.sampleBytesWritten += trackOutput.sampleData(extractorInput, i28 - i27, false);
            }
        } else {
            byte[] bArr = this.nalPrefix.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i29 = i26 + 1;
            int i36 = 4 - i26;
            while (this.sampleBytesWritten < this.sampleSize) {
                int i37 = this.sampleCurrentNalBytesRemaining;
                if (i37 == 0) {
                    extractorInput.readFully(bArr, i36, i29);
                    this.nalPrefix.setPosition(i18);
                    this.sampleCurrentNalBytesRemaining = this.nalPrefix.readUnsignedIntToInt() - i17;
                    this.nalStartCode.setPosition(i18);
                    trackOutput.sampleData(this.nalStartCode, i16);
                    trackOutput.sampleData(this.nalPrefix, i17);
                    if (this.cea608TrackOutputs.length > 0 && NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, bArr[i16])) {
                        z16 = i17;
                    } else {
                        z16 = i18;
                    }
                    this.processSeiNalUnitPayload = z16;
                    this.sampleBytesWritten += 5;
                    this.sampleSize += i36;
                } else {
                    if (this.processSeiNalUnitPayload) {
                        this.nalBuffer.reset(i37);
                        extractorInput.readFully(this.nalBuffer.data, i18, this.sampleCurrentNalBytesRemaining);
                        trackOutput.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                        sampleData = this.sampleCurrentNalBytesRemaining;
                        ParsableByteArray parsableByteArray = this.nalBuffer;
                        int unescapeStream = NalUnitUtil.unescapeStream(parsableByteArray.data, parsableByteArray.limit());
                        this.nalBuffer.setPosition("video/hevc".equals(track.format.sampleMimeType) ? 1 : 0);
                        this.nalBuffer.setLimit(unescapeStream);
                        CeaUtil.consume(trackFragment2.getSamplePresentationTime(i19) * 1000, this.nalBuffer, this.cea608TrackOutputs);
                    } else {
                        sampleData = trackOutput.sampleData(extractorInput, i37, i18);
                    }
                    this.sampleBytesWritten += sampleData;
                    this.sampleCurrentNalBytesRemaining -= sampleData;
                    i16 = 4;
                    i17 = 1;
                    i18 = 0;
                }
            }
        }
        long samplePresentationTime = trackFragment2.getSamplePresentationTime(i19) * 1000;
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null) {
            samplePresentationTime = timestampAdjuster.adjustSampleTimestamp(samplePresentationTime);
        }
        boolean z17 = trackFragment2.sampleIsSyncFrameTable[i19];
        if (trackFragment2.definesEncryptionData) {
            int i38 = (z17 ? 1 : 0) | 1073741824;
            TrackEncryptionBox trackEncryptionBox = trackFragment2.trackEncryptionBox;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = track.getSampleDescriptionEncryptionBox(trackFragment2.header.sampleDescriptionIndex);
            }
            i3 = i38;
            cryptoData = trackEncryptionBox.cryptoData;
        } else {
            i3 = z17 ? 1 : 0;
            cryptoData = null;
        }
        trackOutput.sampleMetadata(samplePresentationTime, i3, this.sampleSize, 0, cryptoData);
        outputPendingMetadataSamples(samplePresentationTime);
        TrackBundle trackBundle3 = this.currentTrackBundle;
        trackBundle3.currentSampleIndex++;
        int i39 = trackBundle3.currentSampleInTrackRun + 1;
        trackBundle3.currentSampleInTrackRun = i39;
        int[] iArr = trackFragment2.trunLength;
        int i46 = trackBundle3.currentTrackRunIndex;
        if (i39 == iArr[i46]) {
            trackBundle3.currentTrackRunIndex = i46 + 1;
            trackBundle3.currentSampleInTrackRun = 0;
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return true;
    }

    private static boolean shouldParseContainerAtom(int i3) {
        if (i3 != Atom.TYPE_moov && i3 != Atom.TYPE_trak && i3 != Atom.TYPE_mdia && i3 != Atom.TYPE_minf && i3 != Atom.TYPE_stbl && i3 != Atom.TYPE_moof && i3 != Atom.TYPE_traf && i3 != Atom.TYPE_mvex && i3 != Atom.TYPE_edts) {
            return false;
        }
        return true;
    }

    private static boolean shouldParseLeafAtom(int i3) {
        if (i3 != Atom.TYPE_hdlr && i3 != Atom.TYPE_mdhd && i3 != Atom.TYPE_mvhd && i3 != Atom.TYPE_sidx && i3 != Atom.TYPE_stsd && i3 != Atom.TYPE_tfdt && i3 != Atom.TYPE_tfhd && i3 != Atom.TYPE_tkhd && i3 != Atom.TYPE_trex && i3 != Atom.TYPE_trun && i3 != Atom.TYPE_pssh && i3 != Atom.TYPE_saiz && i3 != Atom.TYPE_saio && i3 != Atom.TYPE_senc && i3 != Atom.TYPE_uuid && i3 != Atom.TYPE_sbgp && i3 != Atom.TYPE_sgpd && i3 != Atom.TYPE_elst && i3 != Atom.TYPE_mehd && i3 != Atom.TYPE_emsg) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        Track track = this.sideloadedTrack;
        if (track != null) {
            TrackBundle trackBundle = new TrackBundle(extractorOutput.track(0, track.type));
            trackBundle.init(this.sideloadedTrack, new DefaultSampleValues(0, 0, 0, 0));
            this.trackBundles.put(0, trackBundle);
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            int i3 = this.parserState;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (readSample(extractorInput)) {
                            return 0;
                        }
                    } else {
                        readEncryptionData(extractorInput);
                    }
                } else {
                    readAtomPayload(extractorInput);
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j3, long j16) {
        int size = this.trackBundles.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.trackBundles.valueAt(i3).reset();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.sniffFragmented(extractorInput);
    }

    public FragmentedMp4Extractor(int i3) {
        this(i3, null);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, int i3, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i3 + 8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if ((parseFullAtomFlags & 1) == 0) {
            boolean z16 = (parseFullAtomFlags & 2) != 0;
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == trackFragment.sampleCount) {
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z16);
                trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
                trackFragment.fillEncryptionData(parsableByteArray);
                return;
            } else {
                throw new ParserException("Length mismatch: " + readUnsignedIntToInt + ", " + trackFragment.sampleCount);
            }
        }
        throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    public FragmentedMp4Extractor(int i3, TimestampAdjuster timestampAdjuster) {
        this(i3, timestampAdjuster, null, null);
    }

    public FragmentedMp4Extractor(int i3, TimestampAdjuster timestampAdjuster, Track track, DrmInitData drmInitData) {
        this(i3, timestampAdjuster, track, drmInitData, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i3, TimestampAdjuster timestampAdjuster, Track track, DrmInitData drmInitData, List<Format> list) {
        this(i3, timestampAdjuster, track, drmInitData, list, null);
    }

    public FragmentedMp4Extractor(int i3, TimestampAdjuster timestampAdjuster, Track track, DrmInitData drmInitData, List<Format> list, @Nullable TrackOutput trackOutput) {
        this.flags = i3 | (track != null ? 8 : 0);
        this.timestampAdjuster = timestampAdjuster;
        this.sideloadedTrack = track;
        this.sideloadedDrmInitData = drmInitData;
        this.closedCaptionFormats = Collections.unmodifiableList(list);
        this.additionalEmsgTrackOutput = trackOutput;
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        this.encryptionSignalByte = new ParsableByteArray(1);
        this.defaultInitializationVector = new ParsableByteArray();
        this.extendedTypeScratch = new byte[16];
        this.containerAtoms = new Stack<>();
        this.pendingMetadataSampleInfos = new ArrayDeque<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = -9223372036854775807L;
        this.segmentIndexEarliestPresentationTimeUs = -9223372036854775807L;
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
