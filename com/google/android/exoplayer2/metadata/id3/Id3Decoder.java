package com.google.android.exoplayer2.metadata.id3;

import android.util.Log;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.tencent.libra.util.ImageContentType;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Id3Decoder implements MetadataDecoder {
    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    private static final String TAG = "Id3Decoder";
    private final FramePredicate framePredicate;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface FramePredicate {
        boolean evaluate(int i3, int i16, int i17, int i18, int i19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Id3Header {
        private final int framesSize;
        private final boolean isUnsynchronized;
        private final int majorVersion;

        public Id3Header(int i3, boolean z16, int i16) {
            this.majorVersion = i3;
            this.isUnsynchronized = z16;
            this.framesSize = i16;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i3, int i16) {
        if (i16 <= i3) {
            return new byte[0];
        }
        return Arrays.copyOfRange(bArr, i3, i16);
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i3, int i16) throws UnsupportedEncodingException {
        int indexOfZeroByte;
        String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i17 = i3 - 1;
        byte[] bArr = new byte[i17];
        parsableByteArray.readBytes(bArr, 0, i17);
        if (i16 == 2) {
            str = ImageContentType.IMAGE_PREFIX + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals(ImageContentType.MIME_TYPE_JPG)) {
                str = "image/jpeg";
            }
            indexOfZeroByte = 2;
        } else {
            indexOfZeroByte = indexOfZeroByte(bArr, 0);
            String lowerInvariant = Util.toLowerInvariant(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"));
            if (lowerInvariant.indexOf(47) == -1) {
                str = ImageContentType.IMAGE_PREFIX + lowerInvariant;
            } else {
                str = lowerInvariant;
            }
        }
        int i18 = bArr[indexOfZeroByte + 1] & 255;
        int i19 = indexOfZeroByte + 2;
        int indexOfEos = indexOfEos(bArr, i19, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i19, indexOfEos - i19, charsetName), i18, copyOfRangeIfValid(bArr, indexOfEos + delimiterLength(readUnsignedByte), i17));
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i3, String str) {
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i3, int i16, boolean z16, int i17, FramePredicate framePredicate) throws UnsupportedEncodingException {
        long j3;
        long j16;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt == 4294967295L) {
            j3 = -1;
        } else {
            j3 = readUnsignedInt;
        }
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt2 == 4294967295L) {
            j16 = -1;
        } else {
            j16 = readUnsignedInt2;
        }
        ArrayList arrayList = new ArrayList();
        int i18 = position + i3;
        while (parsableByteArray.getPosition() < i18) {
            Id3Frame decodeFrame = decodeFrame(i16, parsableByteArray, z16, i17, framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, readInt, readInt2, j3, j16, id3FrameArr);
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i3, int i16, boolean z16, int i17, FramePredicate framePredicate) throws UnsupportedEncodingException {
        boolean z17;
        boolean z18;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 2) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((readUnsignedByte & 1) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i18 = 0; i18 < readUnsignedByte2; i18++) {
            int position2 = parsableByteArray.getPosition();
            int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray.data, position2);
            strArr[i18] = new String(parsableByteArray.data, position2, indexOfZeroByte2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i19 = position + i3;
        while (parsableByteArray.getPosition() < i19) {
            Id3Frame decodeFrame = decodeFrame(i16, parsableByteArray, z16, i17, framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z17, z18, strArr, id3FrameArr);
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i3) throws UnsupportedEncodingException {
        if (i3 < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i16 = i3 - 4;
        byte[] bArr2 = new byte[i16];
        parsableByteArray.readBytes(bArr2, 0, i16);
        int indexOfEos = indexOfEos(bArr2, 0, readUnsignedByte);
        String str2 = new String(bArr2, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, delimiterLength, indexOfEos(bArr2, delimiterLength, readUnsignedByte), charsetName));
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0192, code lost:
    
        if (r13 == 67) goto L132;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Id3Frame decodeFrame(int i3, ParsableByteArray parsableByteArray, boolean z16, int i16, FramePredicate framePredicate) {
        int i17;
        int readUnsignedInt24;
        int i18;
        String str;
        int i19;
        int i26;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        Id3Frame decodeBinaryFrame;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
        if (i3 >= 3) {
            i17 = parsableByteArray.readUnsignedByte();
        } else {
            i17 = 0;
        }
        if (i3 == 4) {
            readUnsignedInt24 = parsableByteArray.readUnsignedIntToInt();
            if (!z16) {
                readUnsignedInt24 = (((readUnsignedInt24 >> 24) & 255) << 21) | (readUnsignedInt24 & 255) | (((readUnsignedInt24 >> 8) & 255) << 7) | (((readUnsignedInt24 >> 16) & 255) << 14);
            }
        } else if (i3 == 3) {
            readUnsignedInt24 = parsableByteArray.readUnsignedIntToInt();
        } else {
            readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        }
        int i27 = readUnsignedInt24;
        if (i3 >= 3) {
            i18 = parsableByteArray.readUnsignedShort();
        } else {
            i18 = 0;
        }
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && i17 == 0 && i27 == 0 && i18 == 0) {
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        int position = parsableByteArray.getPosition() + i27;
        if (position > parsableByteArray.limit()) {
            Log.w(TAG, "Frame size exceeds remaining tag data");
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        if (framePredicate != null) {
            str = TAG;
            i19 = position;
            i26 = i18;
            if (!framePredicate.evaluate(i3, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i17)) {
                parsableByteArray.setPosition(i19);
                return null;
            }
        } else {
            str = TAG;
            i19 = position;
            i26 = i18;
        }
        if (i3 == 3) {
            int i28 = i26;
            if ((i28 & 128) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if ((i28 & 64) != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if ((i28 & 32) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            z27 = z18;
            z26 = false;
        } else {
            int i29 = i26;
            if (i3 == 4) {
                if ((i29 & 64) != 0) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if ((i29 & 8) != 0) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if ((i29 & 4) != 0) {
                    z36 = true;
                } else {
                    z36 = false;
                }
                if ((i29 & 2) != 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if ((i29 & 1) != 0) {
                    z37 = true;
                } else {
                    z37 = false;
                }
                z17 = z28;
                z18 = z37;
                z27 = z29;
                z19 = z36;
            } else {
                z17 = false;
                z18 = false;
                z19 = false;
                z26 = false;
                z27 = false;
            }
        }
        if (!z27 && !z19) {
            if (z17) {
                i27--;
                parsableByteArray.skipBytes(1);
            }
            if (z18) {
                i27 -= 4;
                parsableByteArray.skipBytes(4);
            }
            if (z26) {
                i27 = removeUnsynchronization(parsableByteArray, i27);
            }
            try {
                try {
                    if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i3 == 2 || i17 == 88)) {
                        decodeBinaryFrame = decodeTxxxFrame(parsableByteArray, i27);
                    } else if (readUnsignedByte == 84) {
                        decodeBinaryFrame = decodeTextInformationFrame(parsableByteArray, i27, getFrameId(i3, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i17));
                    } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i3 == 2 || i17 == 88)) {
                        decodeBinaryFrame = decodeWxxxFrame(parsableByteArray, i27);
                    } else if (readUnsignedByte == 87) {
                        decodeBinaryFrame = decodeUrlLinkFrame(parsableByteArray, i27, getFrameId(i3, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i17));
                    } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && i17 == 86) {
                        decodeBinaryFrame = decodePrivFrame(parsableByteArray, i27);
                    } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (i17 == 66 || i3 == 2)) {
                        decodeBinaryFrame = decodeGeobFrame(parsableByteArray, i27);
                    } else if (i3 == 2) {
                        if (readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) {
                            decodeBinaryFrame = decodeApicFrame(parsableByteArray, i27, i3);
                        }
                        if (readUnsignedByte != 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (i17 == 77 || i3 == 2)) {
                            decodeBinaryFrame = decodeCommentFrame(parsableByteArray, i27);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && i17 == 80) {
                            decodeBinaryFrame = decodeChapterFrame(parsableByteArray, i27, i3, z16, i16, framePredicate);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && i17 == 67) {
                            decodeBinaryFrame = decodeChapterTOCFrame(parsableByteArray, i27, i3, z16, i16, framePredicate);
                        } else {
                            decodeBinaryFrame = decodeBinaryFrame(parsableByteArray, i27, getFrameId(i3, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i17));
                        }
                    } else {
                        if (readUnsignedByte == 65) {
                            if (readUnsignedByte2 == 80) {
                                if (readUnsignedByte3 == 73) {
                                }
                            }
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 67) {
                        }
                        decodeBinaryFrame = decodeBinaryFrame(parsableByteArray, i27, getFrameId(i3, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i17));
                    }
                    if (decodeBinaryFrame == null) {
                        Log.w(str, "Failed to decode frame: id=" + getFrameId(i3, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i17) + ", frameSize=" + i27);
                    }
                    parsableByteArray.setPosition(i19);
                    return decodeBinaryFrame;
                } catch (UnsupportedEncodingException unused) {
                    Log.w(str, "Unsupported character encoding");
                    parsableByteArray.setPosition(i19);
                    return null;
                }
            } catch (Throwable th5) {
                parsableByteArray.setPosition(i19);
                throw th5;
            }
        }
        Log.w(str, "Skipping unsupported compressed or encrypted frame");
        parsableByteArray.setPosition(i19);
        return null;
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i3) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i16 = i3 - 1;
        byte[] bArr = new byte[i16];
        parsableByteArray.readBytes(bArr, 0, i16);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i17 = indexOfZeroByte + 1;
        int indexOfEos = indexOfEos(bArr, i17, readUnsignedByte);
        String decodeStringIfValid = decodeStringIfValid(bArr, i17, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, decodeStringIfValid, decodeStringIfValid(bArr, delimiterLength, indexOfEos2, charsetName), copyOfRangeIfValid(bArr, indexOfEos2 + delimiterLength(readUnsignedByte), i16));
    }

    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w(TAG, "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        if (readUnsignedInt24 != ID3_TAG) {
            Log.w(TAG, "Unexpected first three bytes of ID3 tag header: " + readUnsignedInt24);
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z26 = true;
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                Log.w(TAG, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else if (readUnsignedByte == 4) {
            if ((readUnsignedByte2 & 64) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                readSynchSafeInt -= 10;
            }
        } else {
            Log.w(TAG, "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte);
            return null;
        }
        if (readUnsignedByte >= 4 || (readUnsignedByte2 & 128) == 0) {
            z26 = false;
        }
        return new Id3Header(readUnsignedByte, z26, readSynchSafeInt);
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i3) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, i3));
    }

    private static String decodeStringIfValid(byte[] bArr, int i3, int i16, String str) throws UnsupportedEncodingException {
        if (i16 > i3 && i16 <= bArr.length) {
            return new String(bArr, i3, i16 - i3, str);
        }
        return "";
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i3, String str) throws UnsupportedEncodingException {
        if (i3 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i16 = i3 - 1;
        byte[] bArr = new byte[i16];
        parsableByteArray.readBytes(bArr, 0, i16);
        return new TextInformationFrame(str, null, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i3) throws UnsupportedEncodingException {
        if (i3 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i16 = i3 - 1;
        byte[] bArr = new byte[i16];
        parsableByteArray.readBytes(bArr, 0, i16);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new TextInformationFrame("TXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte), charsetName));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i3, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        return new UrlLinkFrame(str, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i3) throws UnsupportedEncodingException {
        if (i3 < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i16 = i3 - 1;
        byte[] bArr = new byte[i16];
        parsableByteArray.readBytes(bArr, 0, i16);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength), "ISO-8859-1"));
    }

    private static int delimiterLength(int i3) {
        if (i3 != 0 && i3 != 3) {
            return 2;
        }
        return 1;
    }

    private static String getCharsetName(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "ISO-8859-1";
                }
                return "UTF-8";
            }
            return CharEncoding.UTF_16BE;
        }
        return "UTF-16";
    }

    private static String getFrameId(int i3, int i16, int i17, int i18, int i19) {
        if (i3 == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
    }

    private static int indexOfEos(byte[] bArr, int i3, int i16) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i3);
        if (i16 != 0 && i16 != 3) {
            while (indexOfZeroByte < bArr.length - 1) {
                if (indexOfZeroByte % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                    return indexOfZeroByte;
                }
                indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
            }
            return bArr.length;
        }
        return indexOfZeroByte;
    }

    private static int indexOfZeroByte(byte[] bArr, int i3) {
        while (i3 < bArr.length) {
            if (bArr[i3] == 0) {
                return i3;
            }
            i3++;
        }
        return bArr.length;
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i3) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        while (true) {
            int i16 = position + 1;
            if (i16 < i3) {
                if ((bArr[position] & 255) == 255 && bArr[i16] == 0) {
                    System.arraycopy(bArr, position + 2, bArr, i16, (i3 - position) - 2);
                    i3--;
                }
                position = i16;
            } else {
                return i3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if ((r10 & 1) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0086, code lost:
    
        if ((r10 & 128) != 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean validateFrames(ParsableByteArray parsableByteArray, int i3, int i16, boolean z16) {
        int readUnsignedInt24;
        long readUnsignedInt242;
        int i17;
        int i18;
        int position = parsableByteArray.getPosition();
        while (true) {
            try {
                boolean z17 = true;
                if (parsableByteArray.bytesLeft() < i16) {
                    return true;
                }
                if (i3 >= 3) {
                    readUnsignedInt24 = parsableByteArray.readInt();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt();
                    i17 = parsableByteArray.readUnsignedShort();
                } else {
                    readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
                    i17 = 0;
                }
                if (readUnsignedInt24 == 0 && readUnsignedInt242 == 0 && i17 == 0) {
                    return true;
                }
                if (i3 == 4 && !z16) {
                    if ((8421504 & readUnsignedInt242) != 0) {
                        return false;
                    }
                    readUnsignedInt242 = (((readUnsignedInt242 >> 24) & 255) << 21) | (readUnsignedInt242 & 255) | (((readUnsignedInt242 >> 8) & 255) << 7) | (((readUnsignedInt242 >> 16) & 255) << 14);
                }
                if (i3 == 4) {
                    if ((i17 & 64) != 0) {
                        i18 = 1;
                    } else {
                        i18 = 0;
                    }
                } else {
                    if (i3 == 3) {
                        if ((i17 & 32) != 0) {
                            i18 = 1;
                        } else {
                            i18 = 0;
                        }
                    } else {
                        i18 = 0;
                        z17 = false;
                    }
                    if (z17) {
                        i18 += 4;
                    }
                    if (readUnsignedInt242 < i18) {
                        return false;
                    }
                    if (parsableByteArray.bytesLeft() < readUnsignedInt242) {
                        return false;
                    }
                    parsableByteArray.skipBytes((int) readUnsignedInt242);
                }
            } finally {
                parsableByteArray.setPosition(position);
            }
        }
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.framePredicate = framePredicate;
    }

    public Metadata decode(byte[] bArr, int i3) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i3);
        Id3Header decodeHeader = decodeHeader(parsableByteArray);
        if (decodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i16 = decodeHeader.majorVersion == 2 ? 6 : 10;
        int i17 = decodeHeader.framesSize;
        if (decodeHeader.isUnsynchronized) {
            i17 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + i17);
        boolean z16 = false;
        if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i16, false)) {
            if (decodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i16, true)) {
                Log.w(TAG, "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion);
                return null;
            }
            z16 = true;
        }
        while (parsableByteArray.bytesLeft() >= i16) {
            Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z16, i16, this.framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new Metadata(arrayList);
    }
}
