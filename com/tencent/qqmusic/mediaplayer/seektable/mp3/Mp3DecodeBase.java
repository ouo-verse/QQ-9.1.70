package com.tencent.qqmusic.mediaplayer.seektable.mp3;

/* compiled from: P */
/* loaded from: classes23.dex */
class Mp3DecodeBase {
    public static boolean hasId3v2(byte[] bArr, int i3) {
        if (bArr == null || i3 < 3 || bArr[0] != 73 || bArr[1] != 68 || bArr[2] != 51) {
            return false;
        }
        return true;
    }

    public static boolean isVBRIVBRHeader(byte[] bArr, int i3) {
        if (bArr == null || i3 < 4 || bArr[0] != 86 || bArr[1] != 66 || bArr[2] != 82 || bArr[3] != 73) {
            return false;
        }
        return true;
    }

    public static boolean isXingVBRheader(byte[] bArr, int i3) {
        if (bArr != null && i3 >= 4) {
            byte b16 = bArr[0];
            if (b16 == 88 && bArr[1] == 105 && bArr[2] == 110 && bArr[3] == 103) {
                return true;
            }
            if (b16 == 73 && bArr[1] == 110 && bArr[2] == 102 && bArr[3] == 111) {
                return true;
            }
        }
        return false;
    }

    public static int readByte(byte[] bArr, int i3) {
        return readByte(bArr, 0, i3);
    }

    public static int readInt(byte[] bArr, int i3, int i16) {
        if (bArr == null || i16 < 4 || bArr.length < i16 + i3) {
            return -1;
        }
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    public static long readLong(byte[] bArr, int i3, int i16) {
        if (bArr == null || i16 < 4 || bArr.length < i16 + i3) {
            return -1L;
        }
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    public static int readShort(byte[] bArr, int i3, int i16) {
        if (bArr == null || i16 < 2 || bArr.length < i16 + i3) {
            return -1;
        }
        return (bArr[i3 + 1] & 255) | ((bArr[i3] & 255) << 8);
    }

    public static int readUnsignedInt24(byte[] bArr, int i3, int i16) {
        if (bArr == null || i16 < 3 || bArr.length < i16 + i3) {
            return -1;
        }
        return (bArr[i3 + 2] & 255) | ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
    }

    public static int readByte(byte[] bArr, int i3, int i16) {
        if (bArr == null || i16 < 1 || bArr.length < i16 + i3) {
            return -1;
        }
        return bArr[i3] & 255;
    }

    public static int readInt(byte[] bArr, int i3) {
        return readInt(bArr, 0, i3);
    }

    public static long readLong(byte[] bArr, int i3) {
        return readLong(bArr, 0, i3);
    }

    public static int readShort(byte[] bArr, int i3) {
        return readShort(bArr, 0, i3);
    }

    public static int readUnsignedInt24(byte[] bArr, int i3) {
        return readUnsignedInt24(bArr, 0, i3);
    }
}
