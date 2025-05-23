package com.qq.taf.jce;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class JceUtil {
    private static final byte[] highDigits;
    private static final int iConstant = 37;
    private static final int iTotal = 17;
    private static final byte[] lowDigits;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i3 = 0; i3 < 256; i3++) {
            bArr2[i3] = bArr[i3 >>> 4];
            bArr3[i3] = bArr[i3 & 15];
        }
        highDigits = bArr2;
        lowDigits = bArr3;
    }

    public static int compareTo(byte b16, byte b17) {
        if (b16 < b17) {
            return -1;
        }
        return b16 > b17 ? 1 : 0;
    }

    public static boolean equals(byte b16, byte b17) {
        return b16 == b17;
    }

    public static String getHexdump(byte[] bArr) {
        return getHexdump(ByteBuffer.wrap(bArr));
    }

    public static byte[] getJceBufArray(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }

    public static int hashCode(byte b16) {
        return b16 + IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR;
    }

    public static int compareTo(char c16, char c17) {
        if (c16 < c17) {
            return -1;
        }
        return c16 > c17 ? 1 : 0;
    }

    public static boolean equals(char c16, char c17) {
        return c16 == c17;
    }

    public static String getHexdump(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return GlobalUtil.DEF_STRING;
        }
        StringBuffer stringBuffer = new StringBuffer((byteBuffer.remaining() * 3) - 1);
        int position = byteBuffer.position();
        int i3 = byteBuffer.get() & 255;
        stringBuffer.append((char) highDigits[i3]);
        stringBuffer.append((char) lowDigits[i3]);
        while (true) {
            remaining--;
            if (remaining > 0) {
                stringBuffer.append(TokenParser.SP);
                int i16 = byteBuffer.get() & 255;
                stringBuffer.append((char) highDigits[i16]);
                stringBuffer.append((char) lowDigits[i16]);
            } else {
                byteBuffer.position(position);
                return stringBuffer.toString();
            }
        }
    }

    public static int hashCode(char c16) {
        return c16 + '\u0275';
    }

    public static int compareTo(double d16, double d17) {
        if (d16 < d17) {
            return -1;
        }
        return d16 > d17 ? 1 : 0;
    }

    public static boolean equals(double d16, double d17) {
        return d16 == d17;
    }

    public static int hashCode(int i3) {
        return i3 + 629;
    }

    public static int compareTo(float f16, float f17) {
        if (f16 < f17) {
            return -1;
        }
        return f16 > f17 ? 1 : 0;
    }

    public static boolean equals(float f16, float f17) {
        return f16 == f17;
    }

    public static int hashCode(long j3) {
        return ((int) (j3 ^ (j3 >> 32))) + 629;
    }

    public static int compareTo(int i3, int i16) {
        if (i3 < i16) {
            return -1;
        }
        return i3 > i16 ? 1 : 0;
    }

    public static boolean equals(int i3, int i16) {
        return i3 == i16;
    }

    public static int hashCode(short s16) {
        return s16 + 629;
    }

    public static int compareTo(long j3, long j16) {
        if (j3 < j16) {
            return -1;
        }
        return j3 > j16 ? 1 : 0;
    }

    public static boolean equals(long j3, long j16) {
        return j3 == j16;
    }

    public static int hashCode(boolean z16) {
        return (!z16 ? 1 : 0) + 629;
    }

    public static int compareTo(short s16, short s17) {
        if (s16 < s17) {
            return -1;
        }
        return s16 > s17 ? 1 : 0;
    }

    public static boolean equals(short s16, short s17) {
        return s16 == s17;
    }

    public static int hashCode(boolean[] zArr) {
        if (zArr == null) {
            return 629;
        }
        int i3 = 17;
        for (boolean z16 : zArr) {
            i3 = (i3 * 37) + (!z16 ? 1 : 0);
        }
        return i3;
    }

    public static int compareTo(boolean z16, boolean z17) {
        return (z16 ? 1 : 0) - (z17 ? 1 : 0);
    }

    public static boolean equals(boolean z16, boolean z17) {
        return z16 == z17;
    }

    public static <T extends Comparable<T>> int compareTo(T t16, T t17) {
        return t16.compareTo(t17);
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 629;
        }
        int i3 = 17;
        for (byte b16 : bArr) {
            i3 = (i3 * 37) + b16;
        }
        return i3;
    }

    public static <T extends Comparable<T>> int compareTo(List<T> list, List<T> list2) {
        Iterator<T> it = list.iterator();
        Iterator<T> it5 = list2.iterator();
        while (it.hasNext() && it5.hasNext()) {
            int compareTo = it.next().compareTo(it5.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return compareTo(it.hasNext(), it5.hasNext());
    }

    public static int hashCode(char[] cArr) {
        if (cArr == null) {
            return 629;
        }
        int i3 = 17;
        for (char c16 : cArr) {
            i3 = (i3 * 37) + c16;
        }
        return i3;
    }

    public static int hashCode(double d16) {
        return hashCode(Double.doubleToLongBits(d16));
    }

    public static <T extends Comparable<T>> int compareTo(T[] tArr, T[] tArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < tArr.length && i16 < tArr2.length; i16++) {
            int compareTo = tArr[i3].compareTo(tArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(tArr.length, tArr2.length);
    }

    public static int hashCode(double[] dArr) {
        if (dArr == null) {
            return 629;
        }
        int i3 = 17;
        for (int i16 = 0; i16 < dArr.length; i16++) {
            i3 = (i3 * 37) + ((int) (Double.doubleToLongBits(dArr[i16]) ^ (Double.doubleToLongBits(dArr[i16]) >> 32)));
        }
        return i3;
    }

    public static int hashCode(float f16) {
        return Float.floatToIntBits(f16) + 629;
    }

    public static int compareTo(boolean[] zArr, boolean[] zArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < zArr.length && i16 < zArr2.length; i16++) {
            int compareTo = compareTo(zArr[i3], zArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(zArr.length, zArr2.length);
    }

    public static int hashCode(float[] fArr) {
        if (fArr == null) {
            return 629;
        }
        int i3 = 17;
        for (float f16 : fArr) {
            i3 = (i3 * 37) + Float.floatToIntBits(f16);
        }
        return i3;
    }

    public static int hashCode(short[] sArr) {
        if (sArr == null) {
            return 629;
        }
        int i3 = 17;
        for (short s16 : sArr) {
            i3 = (i3 * 37) + s16;
        }
        return i3;
    }

    public static int compareTo(byte[] bArr, byte[] bArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < bArr.length && i16 < bArr2.length; i16++) {
            int compareTo = compareTo(bArr[i3], bArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(bArr.length, bArr2.length);
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 629;
        }
        int i3 = 17;
        for (int i16 : iArr) {
            i3 = (i3 * 37) + i16;
        }
        return i3;
    }

    public static int compareTo(char[] cArr, char[] cArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < cArr.length && i16 < cArr2.length; i16++) {
            int compareTo = compareTo(cArr[i3], cArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(cArr.length, cArr2.length);
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null) {
            return 629;
        }
        int i3 = 17;
        for (long j3 : jArr) {
            i3 = (i3 * 37) + ((int) (j3 ^ (j3 >> 32)));
        }
        return i3;
    }

    public static int hashCode(JceStruct[] jceStructArr) {
        if (jceStructArr == null) {
            return 629;
        }
        int i3 = 17;
        for (JceStruct jceStruct : jceStructArr) {
            i3 = (i3 * 37) + jceStruct.hashCode();
        }
        return i3;
    }

    public static int compareTo(short[] sArr, short[] sArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < sArr.length && i16 < sArr2.length; i16++) {
            int compareTo = compareTo(sArr[i3], sArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(sArr.length, sArr2.length);
    }

    public static int hashCode(Object obj) {
        if (obj == null) {
            return 629;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof long[]) {
                return hashCode((long[]) obj);
            }
            if (obj instanceof int[]) {
                return hashCode((int[]) obj);
            }
            if (obj instanceof short[]) {
                return hashCode((short[]) obj);
            }
            if (obj instanceof char[]) {
                return hashCode((char[]) obj);
            }
            if (obj instanceof byte[]) {
                return hashCode((byte[]) obj);
            }
            if (obj instanceof double[]) {
                return hashCode((double[]) obj);
            }
            if (obj instanceof float[]) {
                return hashCode((float[]) obj);
            }
            if (obj instanceof boolean[]) {
                return hashCode((boolean[]) obj);
            }
            if (obj instanceof JceStruct[]) {
                return hashCode((JceStruct[]) obj);
            }
            return hashCode((Object[]) obj);
        }
        if (obj instanceof JceStruct) {
            return obj.hashCode();
        }
        return obj.hashCode() + 629;
    }

    public static int compareTo(int[] iArr, int[] iArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < iArr.length && i16 < iArr2.length; i16++) {
            int compareTo = compareTo(iArr[i3], iArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(iArr.length, iArr2.length);
    }

    public static int compareTo(long[] jArr, long[] jArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < jArr.length && i16 < jArr2.length; i16++) {
            int compareTo = compareTo(jArr[i3], jArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(jArr.length, jArr2.length);
    }

    public static int compareTo(float[] fArr, float[] fArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < fArr.length && i16 < fArr2.length; i16++) {
            int compareTo = compareTo(fArr[i3], fArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(fArr.length, fArr2.length);
    }

    public static int compareTo(double[] dArr, double[] dArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < dArr.length && i16 < dArr2.length; i16++) {
            int compareTo = compareTo(dArr[i3], dArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return compareTo(dArr.length, dArr2.length);
    }
}
