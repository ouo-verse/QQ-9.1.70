package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AtomParsers {
    private static final String TAG = "AtomParsers";
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_text = Util.getIntegerCodeForString("text");
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString(PublicAccountMessageUtilImpl.META_NAME);

    /* loaded from: classes2.dex */
    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z16) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z16;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long readUnsignedInt;
            int i3;
            int i16 = this.index + 1;
            this.index = i16;
            if (i16 == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                readUnsignedInt = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                readUnsignedInt = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = readUnsignedInt;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i17 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i17;
                if (i17 > 0) {
                    i3 = this.stsc.readUnsignedIntToInt() - 1;
                } else {
                    i3 = -1;
                }
                this.nextSamplesPerChunkChangeIndex = i3;
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i3) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i3];
        }
    }

    /* loaded from: classes2.dex */
    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = parsableByteArray.readUnsignedIntToInt();
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            if (this.fixedSampleSize != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i3 = this.fixedSampleSize;
            if (i3 == 0) {
                return this.data.readUnsignedIntToInt();
            }
            return i3;
        }
    }

    /* loaded from: classes2.dex */
    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i3 = this.fieldSize;
            if (i3 == 8) {
                return this.data.readUnsignedByte();
            }
            if (i3 == 16) {
                return this.data.readUnsignedShort();
            }
            int i16 = this.sampleIndex;
            this.sampleIndex = i16 + 1;
            if (i16 % 2 == 0) {
                int readUnsignedByte = this.data.readUnsignedByte();
                this.currentByte = readUnsignedByte;
                return (readUnsignedByte & 240) >> 4;
            }
            return this.currentByte & 15;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class TkhdData {
        private final long duration;

        /* renamed from: id, reason: collision with root package name */
        private final int f32941id;
        private final int rotationDegrees;

        public TkhdData(int i3, long j3, int i16) {
            this.f32941id = i3;
            this.duration = j3;
            this.rotationDegrees = i16;
        }
    }

    AtomParsers() {
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i3, int i16) {
        boolean z16;
        int position = parsableByteArray.getPosition();
        while (position - i3 < i16) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            if (readInt > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Assertions.checkArgument(z16, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i3, int i16, int i17, int i18, String str, boolean z16, DrmInitData drmInitData, StsdData stsdData, int i19) throws ParserException {
        int i26;
        int readUnsignedFixedPoint1616;
        int i27;
        String str2;
        String str3;
        String str4;
        DrmInitData drmInitData2;
        boolean z17;
        int i28;
        int i29;
        int i36;
        int i37 = i16;
        DrmInitData drmInitData3 = drmInitData;
        parsableByteArray.setPosition(i37 + 8 + 8);
        int i38 = 0;
        if (z16) {
            i26 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            i26 = 0;
        }
        int i39 = 2;
        boolean z18 = true;
        if (i26 == 0 || i26 == 1) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            if (i26 == 1) {
                parsableByteArray.skipBytes(16);
            }
            i27 = readUnsignedShort;
        } else {
            if (i26 != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            readUnsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            i27 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
        }
        int position = parsableByteArray.getPosition();
        int i46 = i3;
        if (i46 == Atom.TYPE_enca) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i37, i17);
            if (parseSampleEntryEncryptionData != null) {
                i46 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i19] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData4 = drmInitData3;
        String str5 = "audio/raw";
        if (i46 == Atom.TYPE_ac_3) {
            str2 = "audio/ac3";
        } else if (i46 == Atom.TYPE_ec_3) {
            str2 = "audio/eac3";
        } else if (i46 == Atom.TYPE_dtsc) {
            str2 = "audio/vnd.dts";
        } else if (i46 == Atom.TYPE_dtsh || i46 == Atom.TYPE_dtsl) {
            str2 = "audio/vnd.dts.hd";
        } else if (i46 == Atom.TYPE_dtse) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i46 == Atom.TYPE_samr) {
            str2 = "audio/3gpp";
        } else if (i46 == Atom.TYPE_sawb) {
            str2 = "audio/amr-wb";
        } else if (i46 == Atom.TYPE_lpcm || i46 == Atom.TYPE_sowt) {
            str2 = "audio/raw";
        } else if (i46 == Atom.TYPE__mp3) {
            str2 = "audio/mpeg";
        } else {
            str2 = i46 == Atom.TYPE_alac ? "audio/alac" : null;
        }
        String str6 = str2;
        int i47 = readUnsignedFixedPoint1616;
        int i48 = i27;
        int i49 = position;
        byte[] bArr = null;
        while (i49 - i37 < i17) {
            parsableByteArray.setPosition(i49);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0 ? z18 : i38, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            int i56 = Atom.TYPE_esds;
            if (readInt2 == i56) {
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData4;
                z17 = z18;
                i28 = i39;
                i29 = i38;
            } else if (z16 && readInt2 == Atom.TYPE_wave) {
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData4;
                i28 = i39;
                i29 = i38;
                z17 = true;
            } else {
                if (readInt2 == Atom.TYPE_dac3) {
                    parsableByteArray.setPosition(i49 + 8);
                    stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i18), str, drmInitData4);
                } else if (readInt2 == Atom.TYPE_dec3) {
                    parsableByteArray.setPosition(i49 + 8);
                    stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i18), str, drmInitData4);
                } else {
                    if (readInt2 == Atom.TYPE_ddts) {
                        str3 = str6;
                        str4 = str5;
                        drmInitData2 = drmInitData4;
                        i36 = i49;
                        z17 = true;
                        i28 = i39;
                        i29 = i38;
                        stsdData.format = Format.createAudioSampleFormat(Integer.toString(i18), str6, null, -1, -1, i48, i47, null, drmInitData2, 0, str);
                        readInt = readInt;
                    } else {
                        i36 = i49;
                        str3 = str6;
                        str4 = str5;
                        drmInitData2 = drmInitData4;
                        i28 = i39;
                        i29 = i38;
                        z17 = true;
                        if (readInt2 == Atom.TYPE_alac) {
                            byte[] bArr2 = new byte[readInt];
                            i49 = i36;
                            parsableByteArray.setPosition(i49);
                            parsableByteArray.readBytes(bArr2, i29, readInt);
                            bArr = bArr2;
                            str6 = str3;
                            i49 += readInt;
                            i38 = i29;
                            z18 = z17;
                            drmInitData4 = drmInitData2;
                            i39 = i28;
                            str5 = str4;
                            i37 = i16;
                        }
                    }
                    i49 = i36;
                    str6 = str3;
                    i49 += readInt;
                    i38 = i29;
                    z18 = z17;
                    drmInitData4 = drmInitData2;
                    i39 = i28;
                    str5 = str4;
                    i37 = i16;
                }
                str3 = str6;
                str4 = str5;
                drmInitData2 = drmInitData4;
                i28 = i39;
                i29 = i38;
                z17 = true;
                str6 = str3;
                i49 += readInt;
                i38 = i29;
                z18 = z17;
                drmInitData4 = drmInitData2;
                i39 = i28;
                str5 = str4;
                i37 = i16;
            }
            int findEsdsPosition = readInt2 == i56 ? i49 : findEsdsPosition(parsableByteArray, i49, readInt);
            if (findEsdsPosition != -1) {
                Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, findEsdsPosition);
                str6 = (String) parseEsdsFromParent.first;
                bArr = (byte[]) parseEsdsFromParent.second;
                if ("audio/mp4a-latm".equals(str6)) {
                    Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                    i47 = ((Integer) parseAacAudioSpecificConfig.first).intValue();
                    i48 = ((Integer) parseAacAudioSpecificConfig.second).intValue();
                }
                i49 += readInt;
                i38 = i29;
                z18 = z17;
                drmInitData4 = drmInitData2;
                i39 = i28;
                str5 = str4;
                i37 = i16;
            }
            str6 = str3;
            i49 += readInt;
            i38 = i29;
            z18 = z17;
            drmInitData4 = drmInitData2;
            i39 = i28;
            str5 = str4;
            i37 = i16;
        }
        String str7 = str6;
        String str8 = str5;
        DrmInitData drmInitData5 = drmInitData4;
        int i57 = i39;
        if (stsdData.format != null || str7 == null) {
            return;
        }
        stsdData.format = Format.createAudioSampleFormat(Integer.toString(i18), str7, null, -1, -1, i48, i47, str8.equals(str7) ? i57 : -1, bArr != null ? Collections.singletonList(bArr) : null, drmInitData5, 0, str);
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i3, int i16) {
        boolean z16;
        boolean z17;
        int i17 = i3 + 8;
        boolean z18 = false;
        int i18 = -1;
        int i19 = 0;
        String str = null;
        Integer num = null;
        while (i17 - i3 < i16) {
            parsableByteArray.setPosition(i17);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_frma) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == Atom.TYPE_schi) {
                i18 = i17;
                i19 = readInt;
            }
            i17 += readInt;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        if (num != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16, "frma atom is mandatory");
        if (i18 != -1) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkArgument(z17, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i18, i19, str);
        if (parseSchiFromParent != null) {
            z18 = true;
        }
        Assertions.checkArgument(z18, "tenc atom is mandatory");
        return Pair.create(num, parseSchiFromParent);
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        long readUnsignedInt;
        long readInt;
        if (containerAtom != null && (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) != null) {
            ParsableByteArray parsableByteArray = leafAtomOfType.data;
            parsableByteArray.setPosition(8);
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            long[] jArr = new long[readUnsignedIntToInt];
            long[] jArr2 = new long[readUnsignedIntToInt];
            for (int i3 = 0; i3 < readUnsignedIntToInt; i3++) {
                if (parseFullAtomVersion == 1) {
                    readUnsignedInt = parsableByteArray.readUnsignedLongToLong();
                } else {
                    readUnsignedInt = parsableByteArray.readUnsignedInt();
                }
                jArr[i3] = readUnsignedInt;
                if (parseFullAtomVersion == 1) {
                    readInt = parsableByteArray.readLong();
                } else {
                    readInt = parsableByteArray.readInt();
                }
                jArr2[i3] = readInt;
                if (parsableByteArray.readShort() == 1) {
                    parsableByteArray.skipBytes(2);
                } else {
                    throw new IllegalArgumentException("Unsupported media rate.");
                }
            }
            return Pair.create(jArr, jArr2);
        }
        return Pair.create(null, null);
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i3) {
        String str;
        parsableByteArray.setPosition(i3 + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        if (readUnsignedByte2 != 32) {
            if (readUnsignedByte2 != 33) {
                if (readUnsignedByte2 != 35) {
                    if (readUnsignedByte2 != 64) {
                        str = null;
                        if (readUnsignedByte2 != 107) {
                            if (readUnsignedByte2 != 96 && readUnsignedByte2 != 97) {
                                if (readUnsignedByte2 != 165) {
                                    if (readUnsignedByte2 != 166) {
                                        switch (readUnsignedByte2) {
                                            case 102:
                                            case 103:
                                            case 104:
                                                break;
                                            default:
                                                switch (readUnsignedByte2) {
                                                    case 169:
                                                    case 172:
                                                        return Pair.create("audio/vnd.dts", null);
                                                    case 170:
                                                    case 171:
                                                        return Pair.create("audio/vnd.dts.hd", null);
                                                }
                                        }
                                    } else {
                                        str = "audio/eac3";
                                    }
                                } else {
                                    str = "audio/ac3";
                                }
                            } else {
                                str = "video/mpeg2";
                            }
                        } else {
                            return Pair.create("audio/mpeg", null);
                        }
                    }
                    str = "audio/mp4a-latm";
                } else {
                    str = "video/hevc";
                }
            } else {
                str = "video/avc";
            }
        } else {
            str = "video/mp4v-es";
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(str, bArr);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i3 = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i3 = (i3 << 7) | (readUnsignedByte & 127);
        }
        return i3;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int readInt = parsableByteArray.readInt();
        if (readInt == TYPE_soun) {
            return 1;
        }
        if (readInt == TYPE_vide) {
            return 2;
        }
        if (readInt != TYPE_text && readInt != TYPE_sbtl && readInt != TYPE_subt && readInt != TYPE_clcp) {
            if (readInt == TYPE_meta) {
                return 4;
            }
            return -1;
        }
        return 3;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i3) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i3;
        int i16 = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion == 0) {
            i3 = 8;
        } else {
            i3 = 16;
        }
        parsableByteArray.skipBytes(i3);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i16 = 4;
        }
        parsableByteArray.skipBytes(i16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i3) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i3 = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i3 = 16;
        }
        parsableByteArray.skipBytes(i3);
        return parsableByteArray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.setPosition(i3 + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i3, int i16) {
        int i17 = i3 + 8;
        while (i17 - i3 < i16) {
            parsableByteArray.setPosition(i17);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i17, readInt + i17);
            }
            i17 += readInt;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i3, int i16) {
        boolean z16;
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i3 < i16) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            if (readInt > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Assertions.checkArgument(z16, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i3, int i16, String str) {
        int i17;
        int i18;
        boolean z16;
        int i19 = i3 + 8;
        while (true) {
            byte[] bArr = null;
            if (i19 - i3 >= i16) {
                return null;
            }
            parsableByteArray.setPosition(i19);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i18 = 0;
                    i17 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i17 = readUnsignedByte & 15;
                    i18 = (readUnsignedByte & 240) >> 4;
                }
                if (parsableByteArray.readUnsignedByte() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z16 && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z16, str, readUnsignedByte2, bArr2, i18, i17, bArr);
            }
            i19 += readInt;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:215:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z16;
        int i3;
        int i16;
        Track track2;
        int i17;
        String str;
        long[] jArr;
        int[] iArr;
        int i18;
        long[] jArr2;
        int[] iArr2;
        long j3;
        long[] jArr3;
        int[] iArr3;
        int[] iArr4;
        int i19;
        long scaleLargeTimestamp;
        long[] jArr4;
        long[] jArr5;
        int[] iArr5;
        int[] iArr6;
        long[] jArr6;
        boolean z17;
        int[] iArr7;
        int[] iArr8;
        int[] iArr9;
        String str2;
        int[] iArr10;
        int i26;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 != null) {
                stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
            } else {
                throw new ParserException("Track has no sample table size information");
            }
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_co64);
            z16 = true;
        } else {
            z16 = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsableByteArray3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray4 = null;
        ParsableByteArray parsableByteArray5 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray6 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z16);
        parsableByteArray3.setPosition(12);
        int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
        int readUnsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray6 != null) {
            parsableByteArray6.setPosition(12);
            i3 = parsableByteArray6.readUnsignedIntToInt();
        } else {
            i3 = 0;
        }
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            i16 = parsableByteArray5.readUnsignedIntToInt();
            r16 = i16 > 0 ? parsableByteArray5.readUnsignedIntToInt() - 1 : -1;
            long j16 = 0;
            if (!stz2SampleSizeBox.isFixedSampleSize() && "audio/raw".equals(track.format.sampleMimeType) && readUnsignedIntToInt == 0 && i3 == 0 && i16 == 0) {
                jArr = new long[sampleCount];
                iArr = new int[sampleCount];
                int i27 = i16;
                jArr2 = new long[sampleCount];
                iArr2 = new int[sampleCount];
                int i28 = readUnsignedIntToInt3;
                long j17 = 0;
                long j18 = 0;
                int i29 = readUnsignedIntToInt;
                int i36 = 0;
                i18 = 0;
                int i37 = 0;
                int i38 = 0;
                int i39 = 0;
                int i46 = i27;
                int i47 = r16;
                int i48 = i3;
                int i49 = readUnsignedIntToInt2;
                while (i36 < sampleCount) {
                    while (i39 == 0) {
                        Assertions.checkState(chunkIterator.moveNext());
                        j18 = chunkIterator.offset;
                        i39 = chunkIterator.numSamples;
                        i29 = i29;
                        i49 = i49;
                    }
                    int i56 = i29;
                    int i57 = i49;
                    if (parsableByteArray6 != null) {
                        while (i37 == 0 && i48 > 0) {
                            i37 = parsableByteArray6.readUnsignedIntToInt();
                            i38 = parsableByteArray6.readInt();
                            i48--;
                        }
                        i37--;
                    }
                    int i58 = i38;
                    jArr[i36] = j18;
                    int readNextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                    iArr[i36] = readNextSampleSize;
                    int i59 = sampleCount;
                    if (readNextSampleSize > i18) {
                        i18 = readNextSampleSize;
                    }
                    SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
                    jArr2[i36] = j17 + i58;
                    iArr2[i36] = parsableByteArray4 == null ? 1 : 0;
                    if (i36 == i47) {
                        iArr2[i36] = 1;
                        i46--;
                        if (i46 > 0) {
                            i47 = parsableByteArray4.readUnsignedIntToInt() - 1;
                        }
                    }
                    j17 += i28;
                    int i65 = i57 - 1;
                    if (i65 == 0 && i56 > 0) {
                        i56--;
                        i65 = parsableByteArray3.readUnsignedIntToInt();
                        i28 = parsableByteArray3.readInt();
                    }
                    int i66 = i65;
                    j18 += iArr[i36];
                    i39--;
                    i36++;
                    stz2SampleSizeBox = sampleSizeBox;
                    sampleCount = i59;
                    i28 = i28;
                    i49 = i66;
                    i38 = i58;
                    i29 = i56;
                }
                int i67 = i29;
                int i68 = i49;
                int i69 = i38;
                i17 = sampleCount;
                j3 = j17 + i69;
                Assertions.checkArgument(i37 == 0);
                while (i48 > 0) {
                    Assertions.checkArgument(parsableByteArray6.readUnsignedIntToInt() == 0);
                    parsableByteArray6.readInt();
                    i48--;
                }
                if (i46 == 0 && i68 == 0) {
                    i26 = i39;
                    if (i26 == 0 && i67 == 0) {
                        track2 = track;
                        str = TAG;
                    }
                } else {
                    i26 = i39;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Inconsistent stbl box for track ");
                track2 = track;
                sb5.append(track2.f32942id);
                sb5.append(": remainingSynchronizationSamples ");
                sb5.append(i46);
                sb5.append(", remainingSamplesAtTimestampDelta ");
                sb5.append(i68);
                sb5.append(", remainingSamplesInChunk ");
                sb5.append(i26);
                sb5.append(", remainingTimestampDeltaChanges ");
                sb5.append(i67);
                String sb6 = sb5.toString();
                str = TAG;
                Log.w(str, sb6);
            } else {
                track2 = track;
                i17 = sampleCount;
                SampleSizeBox sampleSizeBox2 = stz2SampleSizeBox;
                str = TAG;
                int i75 = chunkIterator.length;
                long[] jArr7 = new long[i75];
                int[] iArr11 = new int[i75];
                while (chunkIterator.moveNext()) {
                    int i76 = chunkIterator.index;
                    jArr7[i76] = chunkIterator.offset;
                    iArr11[i76] = chunkIterator.numSamples;
                }
                FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(sampleSizeBox2.readNextSampleSize(), jArr7, iArr11, readUnsignedIntToInt3);
                jArr = rechunk.offsets;
                iArr = rechunk.sizes;
                i18 = rechunk.maximumSize;
                jArr2 = rechunk.timestamps;
                iArr2 = rechunk.flags;
                j3 = rechunk.duration;
            }
            jArr3 = jArr2;
            iArr3 = iArr;
            iArr4 = iArr2;
            i19 = i18;
            scaleLargeTimestamp = Util.scaleLargeTimestamp(j3, 1000000L, track2.timescale);
            if (track2.editListDurations == null && !gaplessInfoHolder.hasGaplessInfo()) {
                long[] jArr8 = track2.editListDurations;
                if (jArr8.length == 1 && track2.type == 1 && jArr3.length >= 2) {
                    long j19 = track2.editListMediaTimes[0];
                    long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(jArr8[0], track2.timescale, track2.movieTimescale) + j19;
                    long j26 = jArr3[0];
                    if (j26 <= j19 && j19 < jArr3[1] && jArr3[jArr3.length - 1] < scaleLargeTimestamp2 && scaleLargeTimestamp2 <= j3) {
                        long j27 = j3 - scaleLargeTimestamp2;
                        long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j19 - j26, track2.format.sampleRate, track2.timescale);
                        long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(j27, track2.format.sampleRate, track2.timescale);
                        if ((scaleLargeTimestamp3 != 0 || scaleLargeTimestamp4 != 0) && scaleLargeTimestamp3 <= TTL.MAX_VALUE && scaleLargeTimestamp4 <= TTL.MAX_VALUE) {
                            gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp3;
                            gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp4;
                            Util.scaleLargeTimestampsInPlace(jArr3, 1000000L, track2.timescale);
                            return new TrackSampleTable(jArr, iArr3, i19, jArr3, iArr4, scaleLargeTimestamp);
                        }
                    }
                }
                long[] jArr9 = track2.editListDurations;
                if (jArr9.length == 1 && jArr9[0] == 0) {
                    long j28 = track2.editListMediaTimes[0];
                    for (int i77 = 0; i77 < jArr3.length; i77++) {
                        jArr3[i77] = Util.scaleLargeTimestamp(jArr3[i77] - j28, 1000000L, track2.timescale);
                    }
                    return new TrackSampleTable(jArr, iArr3, i19, jArr3, iArr4, Util.scaleLargeTimestamp(j3 - j28, 1000000L, track2.timescale));
                }
                boolean z18 = track2.type == 1;
                boolean z19 = false;
                int i78 = 0;
                int i79 = 0;
                int i85 = 0;
                while (true) {
                    long[] jArr10 = track2.editListDurations;
                    if (i85 >= jArr10.length) {
                        break;
                    }
                    long j29 = track2.editListMediaTimes[i85];
                    if (j29 != -1) {
                        iArr10 = iArr4;
                        iArr9 = iArr3;
                        str2 = str;
                        long scaleLargeTimestamp5 = Util.scaleLargeTimestamp(jArr10[i85], track2.timescale, track2.movieTimescale);
                        int binarySearchCeil = Util.binarySearchCeil(jArr3, j29, true, true);
                        int binarySearchCeil2 = Util.binarySearchCeil(jArr3, j29 + scaleLargeTimestamp5, z18, false);
                        i78 += binarySearchCeil2 - binarySearchCeil;
                        z19 = (i79 != binarySearchCeil) | z19;
                        i79 = binarySearchCeil2;
                    } else {
                        iArr9 = iArr3;
                        str2 = str;
                        iArr10 = iArr4;
                    }
                    i85++;
                    iArr4 = iArr10;
                    str = str2;
                    iArr3 = iArr9;
                }
                int[] iArr12 = iArr3;
                String str3 = str;
                int[] iArr13 = iArr4;
                boolean z26 = (i78 != i17) | z19;
                long[] jArr11 = z26 ? new long[i78] : jArr;
                int[] iArr14 = z26 ? new int[i78] : iArr12;
                int i86 = z26 ? 0 : i19;
                int[] iArr15 = z26 ? new int[i78] : iArr13;
                long[] jArr12 = new long[i78];
                int i87 = i86;
                int i88 = 0;
                int i89 = 0;
                while (true) {
                    long[] jArr13 = track2.editListDurations;
                    if (i88 >= jArr13.length) {
                        break;
                    }
                    int i95 = i87;
                    int[] iArr16 = iArr13;
                    long j36 = track2.editListMediaTimes[i88];
                    long j37 = jArr13[i88];
                    if (j36 != -1) {
                        jArr5 = jArr12;
                        int[] iArr17 = iArr15;
                        long scaleLargeTimestamp6 = Util.scaleLargeTimestamp(j37, track2.timescale, track2.movieTimescale) + j36;
                        int binarySearchCeil3 = Util.binarySearchCeil(jArr3, j36, true, true);
                        int binarySearchCeil4 = Util.binarySearchCeil(jArr3, scaleLargeTimestamp6, z18, false);
                        if (z26) {
                            int i96 = binarySearchCeil4 - binarySearchCeil3;
                            System.arraycopy(jArr, binarySearchCeil3, jArr11, i89, i96);
                            iArr5 = iArr12;
                            System.arraycopy(iArr5, binarySearchCeil3, iArr14, i89, i96);
                            z17 = z18;
                            iArr8 = iArr16;
                            jArr6 = jArr11;
                            iArr7 = iArr17;
                            System.arraycopy(iArr8, binarySearchCeil3, iArr7, i89, i96);
                        } else {
                            iArr5 = iArr12;
                            z17 = z18;
                            iArr8 = iArr16;
                            jArr6 = jArr11;
                            iArr7 = iArr17;
                        }
                        int i97 = i95;
                        while (binarySearchCeil3 < binarySearchCeil4) {
                            long[] jArr14 = jArr;
                            int[] iArr18 = iArr8;
                            long j38 = j36;
                            jArr5[i89] = Util.scaleLargeTimestamp(j16, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr3[binarySearchCeil3] - j36, 1000000L, track2.timescale);
                            if (z26 && iArr14[i89] > i97) {
                                i97 = iArr5[binarySearchCeil3];
                            }
                            i89++;
                            binarySearchCeil3++;
                            jArr = jArr14;
                            j36 = j38;
                            iArr8 = iArr18;
                        }
                        jArr4 = jArr;
                        iArr6 = iArr8;
                        i87 = i97;
                    } else {
                        jArr4 = jArr;
                        jArr5 = jArr12;
                        iArr5 = iArr12;
                        iArr6 = iArr16;
                        jArr6 = jArr11;
                        z17 = z18;
                        iArr7 = iArr15;
                        i87 = i95;
                    }
                    j16 += j37;
                    i88++;
                    iArr15 = iArr7;
                    z18 = z17;
                    jArr11 = jArr6;
                    jArr = jArr4;
                    jArr12 = jArr5;
                    iArr13 = iArr6;
                    iArr12 = iArr5;
                }
                long[] jArr15 = jArr11;
                long[] jArr16 = jArr;
                long[] jArr17 = jArr12;
                int[] iArr19 = iArr15;
                int i98 = i87;
                int[] iArr20 = iArr13;
                int[] iArr21 = iArr12;
                long scaleLargeTimestamp7 = Util.scaleLargeTimestamp(j16, 1000000L, track2.timescale);
                boolean z27 = false;
                for (int i99 = 0; i99 < iArr19.length && !z27; i99++) {
                    z27 |= (iArr19[i99] & 1) != 0;
                }
                if (!z27) {
                    Log.w(str3, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
                    Util.scaleLargeTimestampsInPlace(jArr3, 1000000L, track2.timescale);
                    return new TrackSampleTable(jArr16, iArr21, i19, jArr3, iArr20, scaleLargeTimestamp);
                }
                return new TrackSampleTable(jArr15, iArr14, i98, jArr17, iArr19, scaleLargeTimestamp7);
            }
            Util.scaleLargeTimestampsInPlace(jArr3, 1000000L, track2.timescale);
            return new TrackSampleTable(jArr, iArr3, i19, jArr3, iArr4, scaleLargeTimestamp);
        }
        i16 = 0;
        parsableByteArray4 = parsableByteArray5;
        long j162 = 0;
        if (!stz2SampleSizeBox.isFixedSampleSize() && "audio/raw".equals(track.format.sampleMimeType) && readUnsignedIntToInt == 0 && i3 == 0 && i16 == 0) {
        }
        jArr3 = jArr2;
        iArr3 = iArr;
        iArr4 = iArr2;
        i19 = i18;
        scaleLargeTimestamp = Util.scaleLargeTimestamp(j3, 1000000L, track2.timescale);
        if (track2.editListDurations == null) {
        }
        Util.scaleLargeTimestampsInPlace(jArr3, 1000000L, track2.timescale);
        return new TrackSampleTable(jArr, iArr3, i19, jArr3, iArr4, scaleLargeTimestamp);
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i3, int i16, String str, DrmInitData drmInitData, boolean z16) throws ParserException {
        boolean z17;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i17 = 0; i17 < readInt; i17++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            Assertions.checkArgument(z17, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 != Atom.TYPE_avc1 && readInt3 != Atom.TYPE_avc3 && readInt3 != Atom.TYPE_encv && readInt3 != Atom.TYPE_mp4v && readInt3 != Atom.TYPE_hvc1 && readInt3 != Atom.TYPE_hev1 && readInt3 != Atom.TYPE_s263 && readInt3 != Atom.TYPE_vp08 && readInt3 != Atom.TYPE_vp09) {
                if (readInt3 != Atom.TYPE_mp4a && readInt3 != Atom.TYPE_enca && readInt3 != Atom.TYPE_ac_3 && readInt3 != Atom.TYPE_ec_3 && readInt3 != Atom.TYPE_dtsc && readInt3 != Atom.TYPE_dtse && readInt3 != Atom.TYPE_dtsh && readInt3 != Atom.TYPE_dtsl && readInt3 != Atom.TYPE_samr && readInt3 != Atom.TYPE_sawb && readInt3 != Atom.TYPE_lpcm && readInt3 != Atom.TYPE_sowt && readInt3 != Atom.TYPE__mp3 && readInt3 != Atom.TYPE_alac) {
                    if (readInt3 != Atom.TYPE_TTML && readInt3 != Atom.TYPE_tx3g && readInt3 != Atom.TYPE_wvtt && readInt3 != Atom.TYPE_stpp && readInt3 != Atom.TYPE_c608) {
                        if (readInt3 == Atom.TYPE_camm) {
                            stsdData.format = Format.createSampleFormat(Integer.toString(i3), "application/x-camera-motion", null, -1, null);
                        }
                    } else {
                        parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i3, str, stsdData);
                    }
                } else {
                    parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i3, str, z16, drmInitData, stsdData, i17);
                }
            } else {
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i3, i16, drmInitData, stsdData, i17);
            }
            parsableByteArray.setPosition(position + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i3, int i16, int i17, int i18, String str, StsdData stsdData) throws ParserException {
        parsableByteArray.setPosition(i16 + 8 + 8);
        String str2 = "application/ttml+xml";
        List list = null;
        long j3 = Long.MAX_VALUE;
        if (i3 != Atom.TYPE_TTML) {
            if (i3 == Atom.TYPE_tx3g) {
                int i19 = (i17 - 8) - 8;
                byte[] bArr = new byte[i19];
                parsableByteArray.readBytes(bArr, 0, i19);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i3 == Atom.TYPE_wvtt) {
                str2 = "application/x-mp4-vtt";
            } else if (i3 == Atom.TYPE_stpp) {
                j3 = 0;
            } else if (i3 == Atom.TYPE_c608) {
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = Format.createTextSampleFormat(Integer.toString(i18), str2, null, -1, 0, str, -1, null, j3, list);
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        int i3;
        boolean z16;
        long readUnsignedLongToLong;
        int i16 = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        if (parseFullAtomVersion == 0) {
            i3 = 8;
        } else {
            i3 = 16;
        }
        parsableByteArray.skipBytes(i3);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i16 = 4;
        }
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i18 < i16) {
                if (parsableByteArray.data[position + i18] != -1) {
                    z16 = false;
                    break;
                }
                i18++;
            } else {
                z16 = true;
                break;
            }
        }
        long j3 = -9223372036854775807L;
        if (z16) {
            parsableByteArray.skipBytes(i16);
        } else {
            if (parseFullAtomVersion == 0) {
                readUnsignedLongToLong = parsableByteArray.readUnsignedInt();
            } else {
                readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            }
            if (readUnsignedLongToLong != 0) {
                j3 = readUnsignedLongToLong;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i17 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i17 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i17 = 180;
        }
        return new TkhdData(readInt, j3, i17);
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j3, DrmInitData drmInitData, boolean z16, boolean z17) throws ParserException {
        Atom.LeafAtom leafAtom2;
        long j16;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
        int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (parseHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long j17 = -9223372036854775807L;
        if (j3 == -9223372036854775807L) {
            leafAtom2 = leafAtom;
            j16 = parseTkhd.duration;
        } else {
            leafAtom2 = leafAtom;
            j16 = j3;
        }
        long parseMvhd = parseMvhd(leafAtom2.data);
        if (j16 != -9223372036854775807L) {
            j17 = Util.scaleLargeTimestamp(j16, 1000000L, parseMvhd);
        }
        long j18 = j17;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.f32941id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z17);
        if (!z16) {
            Pair<long[], long[]> parseEdts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
            long[] jArr3 = (long[]) parseEdts.first;
            jArr2 = (long[]) parseEdts.second;
            jArr = jArr3;
        } else {
            jArr = null;
            jArr2 = null;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.f32941id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j18, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z16) {
        if (z16) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseMetaAtom(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i3, int i16, int i17, int i18, int i19, DrmInitData drmInitData, StsdData stsdData, int i26) throws ParserException {
        boolean z16;
        String str;
        DrmInitData drmInitData2 = drmInitData;
        parsableByteArray.setPosition(i16 + 8 + 8);
        parsableByteArray.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str2 = null;
        int i27 = i3;
        if (i27 == Atom.TYPE_encv) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i16, i17);
            if (parseSampleEntryEncryptionData != null) {
                i27 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData.trackEncryptionBoxes[i26] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData3 = drmInitData2;
        float f16 = 1.0f;
        List<byte[]> list = null;
        byte[] bArr = null;
        int i28 = -1;
        boolean z17 = false;
        while (position - i16 < i17) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (readInt == 0 && parsableByteArray.getPosition() - i16 == i17) {
                break;
            }
            int i29 = 1;
            boolean z18 = true;
            boolean z19 = true;
            boolean z26 = true;
            boolean z27 = true;
            boolean z28 = true;
            if (readInt > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Assertions.checkArgument(z16, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_avcC) {
                if (str2 != null) {
                    z18 = false;
                }
                Assertions.checkState(z18);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list = parse.initializationData;
                stsdData.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z17) {
                    f16 = parse.pixelWidthAspectRatio;
                }
                str2 = "video/avc";
            } else if (readInt2 == Atom.TYPE_hvcC) {
                if (str2 != null) {
                    z19 = false;
                }
                Assertions.checkState(z19);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list = parse2.initializationData;
                stsdData.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                str2 = "video/hevc";
            } else if (readInt2 == Atom.TYPE_vpcC) {
                if (str2 != null) {
                    z26 = false;
                }
                Assertions.checkState(z26);
                if (i27 == Atom.TYPE_vp08) {
                    str = "video/x-vnd.on2.vp8";
                } else {
                    str = "video/x-vnd.on2.vp9";
                }
                str2 = str;
            } else if (readInt2 == Atom.TYPE_d263) {
                if (str2 != null) {
                    z27 = false;
                }
                Assertions.checkState(z27);
                str2 = "video/3gpp";
            } else if (readInt2 == Atom.TYPE_esds) {
                if (str2 != null) {
                    z28 = false;
                }
                Assertions.checkState(z28);
                Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                str2 = (String) parseEsdsFromParent.first;
                list = Collections.singletonList(parseEsdsFromParent.second);
            } else if (readInt2 == Atom.TYPE_pasp) {
                f16 = parsePaspFromParent(parsableByteArray, position2);
                z17 = true;
            } else if (readInt2 == Atom.TYPE_sv3d) {
                bArr = parseProjFromParent(parsableByteArray, position2, readInt);
            } else if (readInt2 == Atom.TYPE_st3d) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(3);
                if (readUnsignedByte == 0) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    if (readUnsignedByte2 != 0) {
                        if (readUnsignedByte2 != 1) {
                            i29 = 2;
                            if (readUnsignedByte2 != 2) {
                                if (readUnsignedByte2 == 3) {
                                    i28 = 3;
                                }
                            }
                        }
                        i28 = i29;
                    } else {
                        i28 = 0;
                    }
                }
            }
            position += readInt;
        }
        if (str2 == null) {
            return;
        }
        stsdData.format = Format.createVideoSampleFormat(Integer.toString(i18), str2, null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i19, f16, bArr, i28, null, drmInitData3);
    }
}
