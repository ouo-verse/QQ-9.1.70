package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("iso3"), Util.getIntegerCodeForString("iso4"), Util.getIntegerCodeForString("iso5"), Util.getIntegerCodeForString("iso6"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")};
    private static final int SEARCH_LENGTH = 4096;

    Sniffer() {
    }

    private static boolean isCompatibleBrand(int i3) {
        if ((i3 >>> 8) == Util.getIntegerCodeForString("3gp")) {
            return true;
        }
        for (int i16 : COMPATIBLE_BRANDS) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, true);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z16) throws IOException, InterruptedException {
        boolean z17;
        boolean z18;
        int i3;
        long length = extractorInput.getLength();
        long j3 = -1;
        if (length == -1 || length > 4096) {
            length = 4096;
        }
        int i16 = (int) length;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i17 = 0;
        boolean z19 = false;
        while (i17 < i16) {
            parsableByteArray.reset(8);
            extractorInput.peekFully(parsableByteArray.data, 0, 8);
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.data, 8, 8);
                parsableByteArray.setLimit(16);
                i3 = 16;
                readUnsignedInt = parsableByteArray.readUnsignedLongToLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j3) {
                        readUnsignedInt = 8 + (length2 - extractorInput.getPosition());
                    }
                }
                i3 = 8;
            }
            long j16 = i3;
            if (readUnsignedInt < j16) {
                return false;
            }
            i17 += i3;
            if (readInt != Atom.TYPE_moov) {
                if (readInt != Atom.TYPE_moof && readInt != Atom.TYPE_mvex) {
                    if ((i17 + readUnsignedInt) - j16 >= i16) {
                        break;
                    }
                    int i18 = (int) (readUnsignedInt - j16);
                    i17 += i18;
                    if (readInt == Atom.TYPE_ftyp) {
                        if (i18 < 8) {
                            return false;
                        }
                        parsableByteArray.reset(i18);
                        extractorInput.peekFully(parsableByteArray.data, 0, i18);
                        int i19 = i18 / 4;
                        int i26 = 0;
                        while (true) {
                            if (i26 >= i19) {
                                break;
                            }
                            if (i26 == 1) {
                                parsableByteArray.skipBytes(4);
                            } else if (isCompatibleBrand(parsableByteArray.readInt())) {
                                z19 = true;
                                break;
                            }
                            i26++;
                        }
                        if (!z19) {
                            return false;
                        }
                    } else if (i18 != 0) {
                        extractorInput.advancePeekPosition(i18);
                    }
                    j3 = -1;
                } else {
                    z17 = true;
                    z18 = true;
                    break;
                }
            }
        }
        z17 = true;
        z18 = false;
        if (!z19 || z16 != z18) {
            return false;
        }
        return z17;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, false);
    }
}
