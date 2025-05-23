package com.tencent.mapsdk.internal;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private static final int f149730a = 37;

    /* renamed from: b, reason: collision with root package name */
    private static final int f149731b = 17;

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f149732c;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f149733d;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i3 = 0; i3 < 256; i3++) {
            bArr2[i3] = bArr[i3 >>> 4];
            bArr3[i3] = bArr[i3 & 15];
        }
        f149732c = bArr2;
        f149733d = bArr3;
    }

    private static int a(byte b16) {
        return b16 + IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR;
    }

    private static int b(byte b16, byte b17) {
        if (b16 < b17) {
            return -1;
        }
        return b16 > b17 ? 1 : 0;
    }

    private static int a(char c16) {
        return c16 + '\u0275';
    }

    private static int b(char c16, char c17) {
        if (c16 < c17) {
            return -1;
        }
        return c16 > c17 ? 1 : 0;
    }

    private static int a(int i3) {
        return i3 + 629;
    }

    private static int b(double d16, double d17) {
        if (d16 < d17) {
            return -1;
        }
        return d16 > d17 ? 1 : 0;
    }

    private static int a(long j3) {
        return ((int) (j3 ^ (j3 >> 32))) + 629;
    }

    private static int b(float f16, float f17) {
        if (f16 < f17) {
            return -1;
        }
        return f16 > f17 ? 1 : 0;
    }

    private static int a(short s16) {
        return s16 + 629;
    }

    private static int b(int i3, int i16) {
        if (i3 < i16) {
            return -1;
        }
        return i3 > i16 ? 1 : 0;
    }

    private static int a(boolean z16) {
        return (!z16 ? 1 : 0) + 629;
    }

    private static int b(long j3, long j16) {
        if (j3 < j16) {
            return -1;
        }
        return j3 > j16 ? 1 : 0;
    }

    public static boolean a(byte b16, byte b17) {
        return b16 == b17;
    }

    private static int b(short s16, short s17) {
        if (s16 < s17) {
            return -1;
        }
        return s16 > s17 ? 1 : 0;
    }

    private static boolean a(char c16, char c17) {
        return c16 == c17;
    }

    private static int b(boolean z16, boolean z17) {
        return (z16 ? 1 : 0) - (z17 ? 1 : 0);
    }

    private static boolean a(double d16, double d17) {
        return d16 == d17;
    }

    private static String b(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int remaining = wrap.remaining();
        if (remaining == 0) {
            return GlobalUtil.DEF_STRING;
        }
        StringBuffer stringBuffer = new StringBuffer((wrap.remaining() * 3) - 1);
        int position = wrap.position();
        int i3 = wrap.get() & 255;
        stringBuffer.append((char) f149732c[i3]);
        stringBuffer.append((char) f149733d[i3]);
        while (true) {
            remaining--;
            if (remaining > 0) {
                stringBuffer.append(TokenParser.SP);
                int i16 = wrap.get() & 255;
                stringBuffer.append((char) f149732c[i16]);
                stringBuffer.append((char) f149733d[i16]);
            } else {
                wrap.position(position);
                return stringBuffer.toString();
            }
        }
    }

    private static boolean a(float f16, float f17) {
        return f16 == f17;
    }

    public static boolean a(int i3, int i16) {
        return i3 == i16;
    }

    public static boolean a(long j3, long j16) {
        return j3 == j16;
    }

    public static boolean a(short s16, short s17) {
        return s16 == s17;
    }

    private static boolean a(boolean z16, boolean z17) {
        return z16 == z17;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj == obj2;
        }
        return obj.equals(obj2);
    }

    private static <T extends Comparable<T>> int a(T t16, T t17) {
        return t16.compareTo(t17);
    }

    private static <T extends Comparable<T>> int a(List<T> list, List<T> list2) {
        Iterator<T> it = list.iterator();
        Iterator<T> it5 = list2.iterator();
        while (it.hasNext() && it5.hasNext()) {
            int compareTo = it.next().compareTo(it5.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return b(it.hasNext(), it5.hasNext());
    }

    private static <T extends Comparable<T>> int a(T[] tArr, T[] tArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < tArr.length && i16 < tArr2.length; i16++) {
            int compareTo = tArr[i3].compareTo(tArr2[i16]);
            if (compareTo != 0) {
                return compareTo;
            }
            i3++;
        }
        return b(tArr.length, tArr2.length);
    }

    private static String b(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return GlobalUtil.DEF_STRING;
        }
        StringBuffer stringBuffer = new StringBuffer((byteBuffer.remaining() * 3) - 1);
        int position = byteBuffer.position();
        int i3 = byteBuffer.get() & 255;
        stringBuffer.append((char) f149732c[i3]);
        stringBuffer.append((char) f149733d[i3]);
        while (true) {
            remaining--;
            if (remaining > 0) {
                stringBuffer.append(TokenParser.SP);
                int i16 = byteBuffer.get() & 255;
                stringBuffer.append((char) f149732c[i16]);
                stringBuffer.append((char) f149733d[i16]);
            } else {
                byteBuffer.position(position);
                return stringBuffer.toString();
            }
        }
    }

    private static int a(boolean[] zArr, boolean[] zArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < zArr.length && i16 < zArr2.length; i16++) {
            int b16 = b(zArr[i3], zArr2[i16]);
            if (b16 != 0) {
                return b16;
            }
            i3++;
        }
        return b(zArr.length, zArr2.length);
    }

    private static int a(byte[] bArr, byte[] bArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < bArr.length && i16 < bArr2.length; i16++) {
            byte b16 = bArr[i3];
            byte b17 = bArr2[i16];
            int i17 = b16 < b17 ? -1 : b16 > b17 ? 1 : 0;
            if (i17 != 0) {
                return i17;
            }
            i3++;
        }
        return b(bArr.length, bArr2.length);
    }

    private static int a(char[] cArr, char[] cArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < cArr.length && i16 < cArr2.length; i16++) {
            char c16 = cArr[i3];
            char c17 = cArr2[i16];
            int i17 = c16 < c17 ? -1 : c16 > c17 ? 1 : 0;
            if (i17 != 0) {
                return i17;
            }
            i3++;
        }
        return b(cArr.length, cArr2.length);
    }

    private static int a(short[] sArr, short[] sArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < sArr.length && i16 < sArr2.length; i16++) {
            short s16 = sArr[i3];
            short s17 = sArr2[i16];
            int i17 = s16 < s17 ? -1 : s16 > s17 ? 1 : 0;
            if (i17 != 0) {
                return i17;
            }
            i3++;
        }
        return b(sArr.length, sArr2.length);
    }

    private static int a(int[] iArr, int[] iArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < iArr.length && i16 < iArr2.length; i16++) {
            int b16 = b(iArr[i3], iArr2[i16]);
            if (b16 != 0) {
                return b16;
            }
            i3++;
        }
        return b(iArr.length, iArr2.length);
    }

    private static int a(long[] jArr, long[] jArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < jArr.length && i16 < jArr2.length; i16++) {
            long j3 = jArr[i3];
            long j16 = jArr2[i16];
            int i17 = j3 < j16 ? -1 : j3 > j16 ? 1 : 0;
            if (i17 != 0) {
                return i17;
            }
            i3++;
        }
        return b(jArr.length, jArr2.length);
    }

    private static int a(float[] fArr, float[] fArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < fArr.length && i16 < fArr2.length; i16++) {
            float f16 = fArr[i3];
            float f17 = fArr2[i16];
            int i17 = f16 < f17 ? -1 : f16 > f17 ? 1 : 0;
            if (i17 != 0) {
                return i17;
            }
            i3++;
        }
        return b(fArr.length, fArr2.length);
    }

    private static int a(double[] dArr, double[] dArr2) {
        int i3 = 0;
        for (int i16 = 0; i3 < dArr.length && i16 < dArr2.length; i16++) {
            double d16 = dArr[i3];
            double d17 = dArr2[i16];
            int i17 = d16 < d17 ? -1 : d16 > d17 ? 1 : 0;
            if (i17 != 0) {
                return i17;
            }
            i3++;
        }
        return b(dArr.length, dArr2.length);
    }

    private static int a(boolean[] zArr) {
        if (zArr == null) {
            return 629;
        }
        int i3 = 17;
        for (boolean z16 : zArr) {
            i3 = (i3 * 37) + (!z16 ? 1 : 0);
        }
        return i3;
    }

    private static int a(byte[] bArr) {
        if (bArr == null) {
            return 629;
        }
        int i3 = 17;
        for (byte b16 : bArr) {
            i3 = (i3 * 37) + b16;
        }
        return i3;
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 629;
        }
        int i3 = 17;
        for (char c16 : cArr) {
            i3 = (i3 * 37) + c16;
        }
        return i3;
    }

    private static int a(double d16) {
        long doubleToLongBits = Double.doubleToLongBits(d16);
        return ((int) (doubleToLongBits ^ (doubleToLongBits >> 32))) + 629;
    }

    private static int a(double[] dArr) {
        if (dArr == null) {
            return 629;
        }
        int i3 = 17;
        for (int i16 = 0; i16 < dArr.length; i16++) {
            i3 = (i3 * 37) + ((int) (Double.doubleToLongBits(dArr[i16]) ^ (Double.doubleToLongBits(dArr[i16]) >> 32)));
        }
        return i3;
    }

    private static int a(float f16) {
        return Float.floatToIntBits(f16) + 629;
    }

    private static int a(float[] fArr) {
        if (fArr == null) {
            return 629;
        }
        int i3 = 17;
        for (float f16 : fArr) {
            i3 = (i3 * 37) + Float.floatToIntBits(f16);
        }
        return i3;
    }

    private static int a(short[] sArr) {
        if (sArr == null) {
            return 629;
        }
        int i3 = 17;
        for (short s16 : sArr) {
            i3 = (i3 * 37) + s16;
        }
        return i3;
    }

    private static int a(int[] iArr) {
        if (iArr == null) {
            return 629;
        }
        int i3 = 17;
        for (int i16 : iArr) {
            i3 = (i3 * 37) + i16;
        }
        return i3;
    }

    private static int a(long[] jArr) {
        if (jArr == null) {
            return 629;
        }
        int i3 = 17;
        for (long j3 : jArr) {
            i3 = (i3 * 37) + ((int) (j3 ^ (j3 >> 32)));
        }
        return i3;
    }

    private static int a(p[] pVarArr) {
        if (pVarArr == null) {
            return 629;
        }
        int i3 = 17;
        for (p pVar : pVarArr) {
            i3 = (i3 * 37) + pVar.hashCode();
        }
        return i3;
    }

    private static int a(Object obj) {
        while (obj != null) {
            if (obj.getClass().isArray()) {
                if (obj instanceof p[]) {
                    int i3 = 17;
                    for (p pVar : (p[]) obj) {
                        i3 = (i3 * 37) + pVar.hashCode();
                    }
                    return i3;
                }
                obj = (Object[]) obj;
            } else {
                return obj.hashCode() + 629;
            }
        }
        return 629;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
