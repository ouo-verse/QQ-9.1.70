package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TsExtractor implements Extractor {
    private static final int BUFFER_SIZE = 9400;
    private static final int MAX_PID_PLUS_ONE = 8192;
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    private static final int SNIFF_TS_PACKET_COUNT = 5;
    private static final int TS_PACKET_SIZE = 188;
    private static final int TS_PAT_PID = 0;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    private static final int TS_SYNC_BYTE = 71;
    private final SparseIntArray continuityCounters;
    private TsPayloadReader id3Reader;
    private final int mode;
    private ExtractorOutput output;
    private final TsPayloadReader.Factory payloadReaderFactory;
    private int remainingPmts;
    private final List<TimestampAdjuster> timestampAdjusters;
    private final SparseBooleanArray trackIds;
    private boolean tracksEnded;
    private final ParsableByteArray tsPacketBuffer;
    private final SparseArray<TsPayloadReader> tsPayloadReaders;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.ts.TsExtractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new TsExtractor()};
        }
    };
    private static final long AC3_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("AC-3");
    private static final long E_AC3_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("EAC3");
    private static final long HEVC_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("HEVC");

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Mode {
    }

    public TsExtractor() {
        this(0);
    }

    static /* synthetic */ int access$108(TsExtractor tsExtractor) {
        int i3 = tsExtractor.remainingPmts;
        tsExtractor.remainingPmts = i3 + 1;
        return i3;
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        SparseArray<TsPayloadReader> createInitialPayloadReaders = this.payloadReaderFactory.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.tsPayloadReaders.put(createInitialPayloadReaders.keyAt(i3), createInitialPayloadReaders.valueAt(i3));
        }
        this.tsPayloadReaders.put(0, new SectionReader(new PatReader()));
        this.id3Reader = null;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
        extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        boolean z16;
        boolean z17;
        boolean z18;
        TsPayloadReader tsPayloadReader;
        ParsableByteArray parsableByteArray = this.tsPacketBuffer;
        byte[] bArr = parsableByteArray.data;
        if (9400 - parsableByteArray.getPosition() < 188) {
            int bytesLeft = this.tsPacketBuffer.bytesLeft();
            if (bytesLeft > 0) {
                System.arraycopy(bArr, this.tsPacketBuffer.getPosition(), bArr, 0, bytesLeft);
            }
            this.tsPacketBuffer.reset(bArr, bytesLeft);
        }
        while (this.tsPacketBuffer.bytesLeft() < 188) {
            int limit = this.tsPacketBuffer.limit();
            int read = extractorInput.read(bArr, limit, 9400 - limit);
            if (read == -1) {
                return -1;
            }
            this.tsPacketBuffer.setLimit(limit + read);
        }
        int limit2 = this.tsPacketBuffer.limit();
        int position = this.tsPacketBuffer.getPosition();
        while (position < limit2 && bArr[position] != 71) {
            position++;
        }
        this.tsPacketBuffer.setPosition(position);
        int i3 = position + 188;
        if (i3 > limit2) {
            return 0;
        }
        int readInt = this.tsPacketBuffer.readInt();
        if ((8388608 & readInt) != 0) {
            this.tsPacketBuffer.setPosition(i3);
            return 0;
        }
        if ((4194304 & readInt) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = (2096896 & readInt) >> 8;
        if ((readInt & 32) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((readInt & 16) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            tsPayloadReader = this.tsPayloadReaders.get(i16);
        } else {
            tsPayloadReader = null;
        }
        if (tsPayloadReader == null) {
            this.tsPacketBuffer.setPosition(i3);
            return 0;
        }
        if (this.mode != 2) {
            int i17 = readInt & 15;
            int i18 = this.continuityCounters.get(i16, i17 - 1);
            this.continuityCounters.put(i16, i17);
            if (i18 == i17) {
                this.tsPacketBuffer.setPosition(i3);
                return 0;
            }
            if (i17 != ((i18 + 1) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z17) {
            this.tsPacketBuffer.skipBytes(this.tsPacketBuffer.readUnsignedByte());
        }
        this.tsPacketBuffer.setLimit(i3);
        tsPayloadReader.consume(this.tsPacketBuffer, z16);
        this.tsPacketBuffer.setLimit(limit2);
        this.tsPacketBuffer.setPosition(i3);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j3, long j16) {
        int size = this.timestampAdjusters.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.timestampAdjusters.get(i3).reset();
        }
        this.tsPacketBuffer.reset();
        this.continuityCounters.clear();
        resetPayloadReaders();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        byte[] bArr = this.tsPacketBuffer.data;
        extractorInput.peekFully(bArr, 0, 940);
        int i3 = 0;
        while (i3 < 188) {
            for (int i16 = 0; i16 != 5; i16++) {
                if (bArr[(i16 * 188) + i3] != 71) {
                    break;
                }
            }
            extractorInput.skipFully(i3);
            return true;
        }
        return false;
    }

    public TsExtractor(int i3) {
        this(1, i3);
    }

    public TsExtractor(int i3, int i16) {
        this(i3, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(i16));
    }

    public TsExtractor(int i3, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this.payloadReaderFactory = (TsPayloadReader.Factory) Assertions.checkNotNull(factory);
        this.mode = i3;
        if (i3 != 1 && i3 != 2) {
            ArrayList arrayList = new ArrayList();
            this.timestampAdjusters = arrayList;
            arrayList.add(timestampAdjuster);
        } else {
            this.timestampAdjusters = Collections.singletonList(timestampAdjuster);
        }
        this.tsPacketBuffer = new ParsableByteArray(BUFFER_SIZE);
        this.trackIds = new SparseBooleanArray();
        this.tsPayloadReaders = new SparseArray<>();
        this.continuityCounters = new SparseIntArray();
        resetPayloadReaders();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class PatReader implements SectionPayloadReader {
        private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);

        public PatReader() {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.readUnsignedByte() != 0) {
                return;
            }
            parsableByteArray.skipBytes(7);
            int bytesLeft = parsableByteArray.bytesLeft() / 4;
            for (int i3 = 0; i3 < bytesLeft; i3++) {
                parsableByteArray.readBytes(this.patScratch, 4);
                int readBits = this.patScratch.readBits(16);
                this.patScratch.skipBits(3);
                if (readBits == 0) {
                    this.patScratch.skipBits(13);
                } else {
                    int readBits2 = this.patScratch.readBits(13);
                    TsExtractor.this.tsPayloadReaders.put(readBits2, new SectionReader(new PmtReader(readBits2)));
                    TsExtractor.access$108(TsExtractor.this);
                }
            }
            if (TsExtractor.this.mode != 2) {
                TsExtractor.this.tsPayloadReaders.remove(0);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class PmtReader implements SectionPayloadReader {
        private static final int TS_PMT_DESC_AC3 = 106;
        private static final int TS_PMT_DESC_DTS = 123;
        private static final int TS_PMT_DESC_DVBSUBS = 89;
        private static final int TS_PMT_DESC_EAC3 = 122;
        private static final int TS_PMT_DESC_ISO639_LANG = 10;
        private static final int TS_PMT_DESC_REGISTRATION = 5;
        private final int pid;
        private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
        private final SparseArray<TsPayloadReader> trackIdToReaderScratch = new SparseArray<>();
        private final SparseIntArray trackIdToPidScratch = new SparseIntArray();

        public PmtReader(int i3) {
            this.pid = i3;
        }

        private TsPayloadReader.EsInfo readEsInfo(ParsableByteArray parsableByteArray, int i3) {
            int position = parsableByteArray.getPosition();
            int i16 = i3 + position;
            int i17 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (parsableByteArray.getPosition() < i16) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int position2 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
                if (readUnsignedByte == 5) {
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    if (readUnsignedInt != TsExtractor.AC3_FORMAT_IDENTIFIER) {
                        if (readUnsignedInt != TsExtractor.E_AC3_FORMAT_IDENTIFIER) {
                            if (readUnsignedInt == TsExtractor.HEVC_FORMAT_IDENTIFIER) {
                                i17 = 36;
                            }
                        }
                        i17 = 135;
                    }
                    i17 = 129;
                } else {
                    if (readUnsignedByte != 106) {
                        if (readUnsignedByte != 122) {
                            if (readUnsignedByte == 123) {
                                i17 = 138;
                            } else if (readUnsignedByte == 10) {
                                str = parsableByteArray.readString(3).trim();
                            } else if (readUnsignedByte == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (parsableByteArray.getPosition() < position2) {
                                    String trim = parsableByteArray.readString(3).trim();
                                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                    byte[] bArr = new byte[4];
                                    parsableByteArray.readBytes(bArr, 0, 4);
                                    arrayList2.add(new TsPayloadReader.DvbSubtitleInfo(trim, readUnsignedByte2, bArr));
                                }
                                arrayList = arrayList2;
                                i17 = 89;
                            }
                        }
                        i17 = 135;
                    }
                    i17 = 129;
                }
                parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
            }
            parsableByteArray.setPosition(i16);
            return new TsPayloadReader.EsInfo(i17, str, arrayList, Arrays.copyOfRange(parsableByteArray.data, position, i16));
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            int i3;
            TsPayloadReader createPayloadReader;
            if (parsableByteArray.readUnsignedByte() != 2) {
                return;
            }
            if (TsExtractor.this.mode != 1 && TsExtractor.this.mode != 2 && TsExtractor.this.remainingPmts != 1) {
                timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) TsExtractor.this.timestampAdjusters.get(0)).getFirstSampleTimestampUs());
                TsExtractor.this.timestampAdjusters.add(timestampAdjuster);
            } else {
                timestampAdjuster = (TimestampAdjuster) TsExtractor.this.timestampAdjusters.get(0);
            }
            parsableByteArray.skipBytes(2);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int i16 = 5;
            parsableByteArray.skipBytes(5);
            parsableByteArray.readBytes(this.pmtScratch, 2);
            int i17 = 4;
            this.pmtScratch.skipBits(4);
            parsableByteArray.skipBytes(this.pmtScratch.readBits(12));
            if (TsExtractor.this.mode == 2 && TsExtractor.this.id3Reader == null) {
                TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, null, null, new byte[0]);
                TsExtractor tsExtractor = TsExtractor.this;
                tsExtractor.id3Reader = tsExtractor.payloadReaderFactory.createPayloadReader(21, esInfo);
                TsExtractor.this.id3Reader.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, 21, 8192));
            }
            this.trackIdToReaderScratch.clear();
            this.trackIdToPidScratch.clear();
            int bytesLeft = parsableByteArray.bytesLeft();
            while (bytesLeft > 0) {
                parsableByteArray.readBytes(this.pmtScratch, i16);
                int readBits = this.pmtScratch.readBits(8);
                this.pmtScratch.skipBits(3);
                int readBits2 = this.pmtScratch.readBits(13);
                this.pmtScratch.skipBits(i17);
                int readBits3 = this.pmtScratch.readBits(12);
                TsPayloadReader.EsInfo readEsInfo = readEsInfo(parsableByteArray, readBits3);
                if (readBits == 6) {
                    readBits = readEsInfo.streamType;
                }
                bytesLeft -= readBits3 + 5;
                if (TsExtractor.this.mode == 2) {
                    i3 = readBits;
                } else {
                    i3 = readBits2;
                }
                if (!TsExtractor.this.trackIds.get(i3)) {
                    if (TsExtractor.this.mode == 2 && readBits == 21) {
                        createPayloadReader = TsExtractor.this.id3Reader;
                    } else {
                        createPayloadReader = TsExtractor.this.payloadReaderFactory.createPayloadReader(readBits, readEsInfo);
                    }
                    if (TsExtractor.this.mode != 2 || readBits2 < this.trackIdToPidScratch.get(i3, 8192)) {
                        this.trackIdToPidScratch.put(i3, readBits2);
                        this.trackIdToReaderScratch.put(i3, createPayloadReader);
                    }
                }
                i16 = 5;
                i17 = 4;
            }
            int size = this.trackIdToPidScratch.size();
            for (int i18 = 0; i18 < size; i18++) {
                int keyAt = this.trackIdToPidScratch.keyAt(i18);
                TsExtractor.this.trackIds.put(keyAt, true);
                TsPayloadReader valueAt = this.trackIdToReaderScratch.valueAt(i18);
                if (valueAt != null) {
                    if (valueAt != TsExtractor.this.id3Reader) {
                        valueAt.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, keyAt, 8192));
                    }
                    TsExtractor.this.tsPayloadReaders.put(this.trackIdToPidScratch.valueAt(i18), valueAt);
                }
            }
            if (TsExtractor.this.mode == 2) {
                if (!TsExtractor.this.tracksEnded) {
                    TsExtractor.this.output.endTracks();
                    TsExtractor.this.remainingPmts = 0;
                    TsExtractor.this.tracksEnded = true;
                    return;
                }
                return;
            }
            TsExtractor.this.tsPayloadReaders.remove(this.pid);
            TsExtractor tsExtractor2 = TsExtractor.this;
            tsExtractor2.remainingPmts = tsExtractor2.mode != 1 ? TsExtractor.this.remainingPmts - 1 : 0;
            if (TsExtractor.this.remainingPmts == 0) {
                TsExtractor.this.output.endTracks();
                TsExtractor.this.tracksEnded = true;
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }
}
