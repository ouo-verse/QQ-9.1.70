package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Buffer;
import okio.internal._ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0015H\u0000\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0015H\u0080\b\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0080\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0015H\u0080\f\u001a\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\f\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0000\u001a\f\u0010!\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010!\u001a\u00020\u0015*\u00020\u0015H\u0000\u001a\f\u0010!\u001a\u00020\"*\u00020\"H\u0000\u001a\u0015\u0010#\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010$\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\f\u0010&\u001a\u00020'*\u00020\u001bH\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u0001H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u0015H\u0000\u001a\u0015\u0010(\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0080\f\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006)"}, d2 = {"DEFAULT__ByteString_size", "", "getDEFAULT__ByteString_size", "()I", "DEFAULT__new_UnsafeCursor", "Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "arrayRangeEquals", "", "a", "", "aOffset", "b", "bOffset", "byteCount", "checkOffsetAndCount", "", "size", "", "offset", "minOf", "resolveDefaultParameter", "unsafeCursor", "and", "", "other", "leftRotate", "bitCount", "Lokio/ByteString;", "position", "reverseBytes", "", "rightRotate", "shl", "shr", "toHexString", "", "xor", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _UtilKt {

    @NotNull
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
    private static final int DEFAULT__ByteString_size = -1234567890;

    public static final int and(byte b16, int i3) {
        return b16 & i3;
    }

    public static final boolean arrayRangeEquals(@NotNull byte[] a16, int i3, @NotNull byte[] b16, int i16, int i17) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        if (i17 > 0) {
            int i18 = 0;
            while (true) {
                int i19 = i18 + 1;
                if (a16[i18 + i3] != b16[i18 + i16]) {
                    return false;
                }
                if (i19 < i17) {
                    i18 = i19;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }

    public static final void checkOffsetAndCount(long j3, long j16, long j17) {
        if ((j16 | j17) >= 0 && j16 <= j3 && j3 - j16 >= j17) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("size=" + j3 + " offset=" + j16 + " byteCount=" + j17);
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    @NotNull
    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static final int leftRotate(int i3, int i16) {
        return (i3 >>> (32 - i16)) | (i3 << i16);
    }

    public static final long minOf(long j3, int i3) {
        return Math.min(j3, i3);
    }

    @NotNull
    public static final Buffer.UnsafeCursor resolveDefaultParameter(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return unsafeCursor == DEFAULT__new_UnsafeCursor ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    public static final int reverseBytes(int i3) {
        return ((i3 & 255) << 24) | (((-16777216) & i3) >>> 24) | ((16711680 & i3) >>> 8) | ((65280 & i3) << 8);
    }

    public static final long rightRotate(long j3, int i3) {
        return (j3 << (64 - i3)) | (j3 >>> i3);
    }

    public static final int shl(byte b16, int i3) {
        return b16 << i3;
    }

    public static final int shr(byte b16, int i3) {
        return b16 >> i3;
    }

    @NotNull
    public static final String toHexString(byte b16) {
        String concatToString;
        concatToString = StringsKt__StringsJVMKt.concatToString(new char[]{_ByteStringKt.getHEX_DIGIT_CHARS()[(b16 >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[b16 & RegisterType.DOUBLE_HI]});
        return concatToString;
    }

    public static final byte xor(byte b16, byte b17) {
        return (byte) (b16 ^ b17);
    }

    public static final long and(byte b16, long j3) {
        return b16 & j3;
    }

    public static final long minOf(int i3, long j3) {
        return Math.min(i3, j3);
    }

    public static final int resolveDefaultParameter(@NotNull ByteString byteString, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return i3 == DEFAULT__ByteString_size ? byteString.size() : i3;
    }

    public static final long reverseBytes(long j3) {
        return ((j3 & 255) << 56) | (((-72057594037927936L) & j3) >>> 56) | ((71776119061217280L & j3) >>> 40) | ((280375465082880L & j3) >>> 24) | ((1095216660480L & j3) >>> 8) | ((4278190080L & j3) << 8) | ((16711680 & j3) << 24) | ((65280 & j3) << 40);
    }

    public static final long and(int i3, long j3) {
        return i3 & j3;
    }

    public static final short reverseBytes(short s16) {
        int i3 = s16 & 65535;
        return (short) (((i3 & 255) << 8) | ((65280 & i3) >>> 8));
    }

    @NotNull
    public static final String toHexString(int i3) {
        String concatToString;
        if (i3 == 0) {
            return "0";
        }
        int i16 = 0;
        char[] cArr = {_ByteStringKt.getHEX_DIGIT_CHARS()[(i3 >> 28) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i3 >> 24) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i3 >> 20) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i3 >> 16) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i3 >> 12) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i3 >> 8) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i3 >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[i3 & 15]};
        while (i16 < 8 && cArr[i16] == '0') {
            i16++;
        }
        concatToString = StringsKt__StringsJVMKt.concatToString(cArr, i16, 8);
        return concatToString;
    }

    @NotNull
    public static final String toHexString(long j3) {
        String concatToString;
        if (j3 == 0) {
            return "0";
        }
        int i3 = 0;
        char[] cArr = {_ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 60) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 56) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 52) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 48) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 44) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 40) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 36) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 32) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 28) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 24) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 20) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 16) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 12) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 8) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j3 >> 4) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) (j3 & 15)]};
        while (i3 < 16 && cArr[i3] == '0') {
            i3++;
        }
        concatToString = StringsKt__StringsJVMKt.concatToString(cArr, i3, 16);
        return concatToString;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }
}
