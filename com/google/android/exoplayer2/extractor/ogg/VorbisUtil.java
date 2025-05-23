package com.google.android.exoplayer2.extractor.ogg;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
final class VorbisUtil {
    private static final String TAG = "VorbisUtil";

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class CodeBook {
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int i3, int i16, long[] jArr, int i17, boolean z16) {
            this.dimensions = i3;
            this.entries = i16;
            this.lengthMap = jArr;
            this.lookupType = i17;
            this.isOrdered = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i3) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z16, int i3, int i16, int i17) {
            this.blockFlag = z16;
            this.windowType = i3;
            this.transformType = i16;
            this.mapping = i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class VorbisIdHeader {
        public final int bitrateMax;
        public final int bitrateMin;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final long sampleRate;
        public final long version;

        public VorbisIdHeader(long j3, int i3, long j16, int i16, int i17, int i18, int i19, int i26, boolean z16, byte[] bArr) {
            this.version = j3;
            this.channels = i3;
            this.sampleRate = j16;
            this.bitrateMax = i16;
            this.bitrateNominal = i17;
            this.bitrateMin = i18;
            this.blockSize0 = i19;
            this.blockSize1 = i26;
            this.framingFlag = z16;
            this.data = bArr;
        }

        public int getApproximateBitrate() {
            int i3 = this.bitrateNominal;
            if (i3 == 0) {
                return (this.bitrateMin + this.bitrateMax) / 2;
            }
            return i3;
        }
    }

    VorbisUtil() {
    }

    public static int iLog(int i3) {
        int i16 = 0;
        while (i3 > 0) {
            i16++;
            i3 >>>= 1;
        }
        return i16;
    }

    private static long mapType1QuantValues(long j3, long j16) {
        return (long) Math.floor(Math.pow(j3, 1.0d / j16));
    }

    private static CodeBook readBook(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.readBits(24) == 5653314) {
            int readBits = vorbisBitArray.readBits(16);
            int readBits2 = vorbisBitArray.readBits(24);
            long[] jArr = new long[readBits2];
            boolean readBit = vorbisBitArray.readBit();
            long j3 = 0;
            if (!readBit) {
                boolean readBit2 = vorbisBitArray.readBit();
                for (int i3 = 0; i3 < readBits2; i3++) {
                    if (readBit2) {
                        if (vorbisBitArray.readBit()) {
                            jArr[i3] = vorbisBitArray.readBits(5) + 1;
                        } else {
                            jArr[i3] = 0;
                        }
                    } else {
                        jArr[i3] = vorbisBitArray.readBits(5) + 1;
                    }
                }
            } else {
                int readBits3 = vorbisBitArray.readBits(5) + 1;
                int i16 = 0;
                while (i16 < readBits2) {
                    int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i16));
                    for (int i17 = 0; i17 < readBits4 && i16 < readBits2; i17++) {
                        jArr[i16] = readBits3;
                        i16++;
                    }
                    readBits3++;
                }
            }
            int readBits5 = vorbisBitArray.readBits(4);
            if (readBits5 <= 2) {
                if (readBits5 == 1 || readBits5 == 2) {
                    vorbisBitArray.skipBits(32);
                    vorbisBitArray.skipBits(32);
                    int readBits6 = vorbisBitArray.readBits(4) + 1;
                    vorbisBitArray.skipBits(1);
                    if (readBits5 == 1) {
                        if (readBits != 0) {
                            j3 = mapType1QuantValues(readBits2, readBits);
                        }
                    } else {
                        j3 = readBits2 * readBits;
                    }
                    vorbisBitArray.skipBits((int) (j3 * readBits6));
                }
                return new CodeBook(readBits, readBits2, jArr, readBits5, readBit);
            }
            throw new ParserException("lookup type greater than 2 not decodable: " + readBits5);
        }
        throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.getPosition());
    }

    private static void readFloors(VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i3 = 0; i3 < readBits; i3++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 != 0) {
                if (readBits2 == 1) {
                    int readBits3 = vorbisBitArray.readBits(5);
                    int[] iArr = new int[readBits3];
                    int i16 = -1;
                    for (int i17 = 0; i17 < readBits3; i17++) {
                        int readBits4 = vorbisBitArray.readBits(4);
                        iArr[i17] = readBits4;
                        if (readBits4 > i16) {
                            i16 = readBits4;
                        }
                    }
                    int i18 = i16 + 1;
                    int[] iArr2 = new int[i18];
                    for (int i19 = 0; i19 < i18; i19++) {
                        iArr2[i19] = vorbisBitArray.readBits(3) + 1;
                        int readBits5 = vorbisBitArray.readBits(2);
                        if (readBits5 > 0) {
                            vorbisBitArray.skipBits(8);
                        }
                        for (int i26 = 0; i26 < (1 << readBits5); i26++) {
                            vorbisBitArray.skipBits(8);
                        }
                    }
                    vorbisBitArray.skipBits(2);
                    int readBits6 = vorbisBitArray.readBits(4);
                    int i27 = 0;
                    int i28 = 0;
                    for (int i29 = 0; i29 < readBits3; i29++) {
                        i27 += iArr2[iArr[i29]];
                        while (i28 < i27) {
                            vorbisBitArray.skipBits(readBits6);
                            i28++;
                        }
                    }
                } else {
                    throw new ParserException("floor type greater than 1 not decodable: " + readBits2);
                }
            } else {
                vorbisBitArray.skipBits(8);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(6);
                vorbisBitArray.skipBits(8);
                int readBits7 = vorbisBitArray.readBits(4) + 1;
                for (int i36 = 0; i36 < readBits7; i36++) {
                    vorbisBitArray.skipBits(8);
                }
            }
        }
    }

    private static void readMappings(int i3, VorbisBitArray vorbisBitArray) throws ParserException {
        int i16;
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i17 = 0; i17 < readBits; i17++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 != 0) {
                Log.e(TAG, "mapping type other than 0 not supported: " + readBits2);
            } else {
                if (vorbisBitArray.readBit()) {
                    i16 = vorbisBitArray.readBits(4) + 1;
                } else {
                    i16 = 1;
                }
                if (vorbisBitArray.readBit()) {
                    int readBits3 = vorbisBitArray.readBits(8) + 1;
                    for (int i18 = 0; i18 < readBits3; i18++) {
                        int i19 = i3 - 1;
                        vorbisBitArray.skipBits(iLog(i19));
                        vorbisBitArray.skipBits(iLog(i19));
                    }
                }
                if (vorbisBitArray.readBits(2) == 0) {
                    if (i16 > 1) {
                        for (int i26 = 0; i26 < i3; i26++) {
                            vorbisBitArray.skipBits(4);
                        }
                    }
                    for (int i27 = 0; i27 < i16; i27++) {
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                    }
                } else {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    private static Mode[] readModes(VorbisBitArray vorbisBitArray) {
        int readBits = vorbisBitArray.readBits(6) + 1;
        Mode[] modeArr = new Mode[readBits];
        for (int i3 = 0; i3 < readBits; i3++) {
            modeArr[i3] = new Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
        }
        return modeArr;
    }

    private static void readResidues(VorbisBitArray vorbisBitArray) throws ParserException {
        int i3;
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i16 = 0; i16 < readBits; i16++) {
            if (vorbisBitArray.readBits(16) <= 2) {
                vorbisBitArray.skipBits(24);
                vorbisBitArray.skipBits(24);
                vorbisBitArray.skipBits(24);
                int readBits2 = vorbisBitArray.readBits(6) + 1;
                vorbisBitArray.skipBits(8);
                int[] iArr = new int[readBits2];
                for (int i17 = 0; i17 < readBits2; i17++) {
                    int readBits3 = vorbisBitArray.readBits(3);
                    if (vorbisBitArray.readBit()) {
                        i3 = vorbisBitArray.readBits(5);
                    } else {
                        i3 = 0;
                    }
                    iArr[i17] = (i3 * 8) + readBits3;
                }
                for (int i18 = 0; i18 < readBits2; i18++) {
                    for (int i19 = 0; i19 < 8; i19++) {
                        if ((iArr[i18] & (1 << i19)) != 0) {
                            vorbisBitArray.skipBits(8);
                        }
                    }
                }
            } else {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) throws ParserException {
        verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        int length = 11 + readString.length();
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        String[] strArr = new String[(int) readLittleEndianUnsignedInt];
        int i3 = length + 4;
        for (int i16 = 0; i16 < readLittleEndianUnsignedInt; i16++) {
            String readString2 = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            strArr[i16] = readString2;
            i3 = i3 + 4 + readString2.length();
        }
        if ((parsableByteArray.readUnsignedByte() & 1) != 0) {
            return new CommentHeader(readString, strArr, i3 + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z16;
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        long readLittleEndianUnsignedInt2 = parsableByteArray.readLittleEndianUnsignedInt();
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int pow = (int) Math.pow(2.0d, readUnsignedByte2 & 15);
        int pow2 = (int) Math.pow(2.0d, (readUnsignedByte2 & 240) >> 4);
        if ((parsableByteArray.readUnsignedByte() & 1) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new VorbisIdHeader(readLittleEndianUnsignedInt, readUnsignedByte, readLittleEndianUnsignedInt2, readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, pow, pow2, z16, Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit()));
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i3) throws ParserException {
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.data);
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        for (int i16 = 0; i16 < readUnsignedByte; i16++) {
            readBook(vorbisBitArray);
        }
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i17 = 0; i17 < readBits; i17++) {
            if (vorbisBitArray.readBits(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        readFloors(vorbisBitArray);
        readResidues(vorbisBitArray);
        readMappings(i3, vorbisBitArray);
        Mode[] readModes = readModes(vorbisBitArray);
        if (vorbisBitArray.readBit()) {
            return readModes;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i3, ParsableByteArray parsableByteArray, boolean z16) throws ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z16) {
                return false;
            }
            throw new ParserException("too short header: " + parsableByteArray.bytesLeft());
        }
        if (parsableByteArray.readUnsignedByte() != i3) {
            if (z16) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i3));
        }
        if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        }
        if (z16) {
            return false;
        }
        throw new ParserException("expected characters 'vorbis'");
    }
}
