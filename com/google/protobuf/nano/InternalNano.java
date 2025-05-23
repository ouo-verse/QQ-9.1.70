package com.google.protobuf.nano;

import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class InternalNano {
    public static final int TYPE_BOOL = 8;
    public static final int TYPE_BYTES = 12;
    public static final int TYPE_DOUBLE = 1;
    public static final int TYPE_ENUM = 14;
    public static final int TYPE_FIXED32 = 7;
    public static final int TYPE_FIXED64 = 6;
    public static final int TYPE_FLOAT = 2;
    public static final int TYPE_GROUP = 10;
    public static final int TYPE_INT32 = 5;
    public static final int TYPE_INT64 = 3;
    public static final int TYPE_MESSAGE = 11;
    public static final int TYPE_SFIXED32 = 15;
    public static final int TYPE_SFIXED64 = 16;
    public static final int TYPE_SINT32 = 17;
    public static final int TYPE_SINT64 = 18;
    public static final int TYPE_STRING = 9;
    public static final int TYPE_UINT32 = 13;
    public static final int TYPE_UINT64 = 4;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Object LAZY_INIT_LOCK = new Object();

    InternalNano() {
    }

    public static byte[] bytesDefaultValue(String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static void cloneUnknownFieldData(ExtendableMessageNano extendableMessageNano, ExtendableMessageNano extendableMessageNano2) {
        FieldArray fieldArray = extendableMessageNano.unknownFieldData;
        if (fieldArray != null) {
            extendableMessageNano2.unknownFieldData = fieldArray.m67clone();
        }
    }

    public static <K, V> int computeMapFieldSize(Map<K, V> map, int i3, int i16, int i17) {
        int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i3);
        int i18 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key != null && value != null) {
                int computeFieldSize = CodedOutputByteBufferNano.computeFieldSize(1, i16, key) + CodedOutputByteBufferNano.computeFieldSize(2, i17, value);
                i18 += computeTagSize + computeFieldSize + CodedOutputByteBufferNano.computeRawVarint32Size(computeFieldSize);
            } else {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
        }
        return i18;
    }

    public static byte[] copyFromUtf8(String str) {
        return str.getBytes(UTF_8);
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length == 0) {
            return iArr2 == null || iArr2.length == 0;
        }
        return Arrays.equals(iArr, iArr2);
    }

    private static boolean equalsMapValue(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                return Arrays.equals((byte[]) obj, (byte[]) obj2);
            }
            return obj.equals(obj2);
        }
        throw new IllegalStateException("keys and values in maps cannot be null");
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(iArr);
    }

    private static int hashCodeForMap(Object obj) {
        if (obj instanceof byte[]) {
            return Arrays.hashCode((byte[]) obj);
        }
        return obj.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> mergeMapEntry(CodedInputByteBufferNano codedInputByteBufferNano, Map<K, V> map, MapFactories.MapFactory mapFactory, int i3, int i16, V v3, int i17, int i18) throws IOException {
        Map<K, V> forMap = mapFactory.forMap(map);
        int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
        Object obj = null;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            }
            if (readTag == i17) {
                obj = codedInputByteBufferNano.readPrimitiveField(i3);
            } else if (readTag == i18) {
                if (i16 == 11) {
                    codedInputByteBufferNano.readMessage(v3);
                } else {
                    v3 = (V) codedInputByteBufferNano.readPrimitiveField(i16);
                }
            } else if (!codedInputByteBufferNano.skipField(readTag)) {
                break;
            }
        }
        codedInputByteBufferNano.checkLastTagWas(0);
        codedInputByteBufferNano.popLimit(pushLimit);
        if (obj == null) {
            obj = primitiveDefaultValue(i3);
        }
        if (v3 == 0) {
            v3 = primitiveDefaultValue(i16);
        }
        forMap.put(obj, v3);
        return forMap;
    }

    private static Object primitiveDefaultValue(int i3) {
        switch (i3) {
            case 1:
                return Double.valueOf(0.0d);
            case 2:
                return Float.valueOf(0.0f);
            case 3:
            case 4:
            case 6:
            case 16:
            case 18:
                return 0L;
            case 5:
            case 7:
            case 13:
            case 14:
            case 15:
            case 17:
                return 0;
            case 8:
                return Boolean.FALSE;
            case 9:
                return "";
            case 10:
            case 11:
            default:
                throw new IllegalArgumentException("Type: " + i3 + " is not a primitive type.");
            case 12:
                return WireFormatNano.EMPTY_BYTES;
        }
    }

    public static <K, V> void serializeMapField(CodedOutputByteBufferNano codedOutputByteBufferNano, Map<K, V> map, int i3, int i16, int i17) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key != null && value != null) {
                int computeFieldSize = CodedOutputByteBufferNano.computeFieldSize(1, i16, key) + CodedOutputByteBufferNano.computeFieldSize(2, i17, value);
                codedOutputByteBufferNano.writeTag(i3, 2);
                codedOutputByteBufferNano.writeRawVarint32(computeFieldSize);
                codedOutputByteBufferNano.writeField(1, i16, key);
                codedOutputByteBufferNano.writeField(2, i17, value);
            } else {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
        }
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(jArr);
    }

    public static int hashCode(float[] fArr) {
        if (fArr == null || fArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(fArr);
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        if (jArr == null || jArr.length == 0) {
            return jArr2 == null || jArr2.length == 0;
        }
        return Arrays.equals(jArr, jArr2);
    }

    public static int hashCode(double[] dArr) {
        if (dArr == null || dArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(dArr);
    }

    public static int hashCode(boolean[] zArr) {
        if (zArr == null || zArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(zArr);
    }

    public static int hashCode(byte[][] bArr) {
        int length = bArr == null ? 0 : bArr.length;
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            byte[] bArr2 = bArr[i16];
            if (bArr2 != null) {
                i3 = (i3 * 31) + Arrays.hashCode(bArr2);
            }
        }
        return i3;
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr.length == 0) {
            return fArr2 == null || fArr2.length == 0;
        }
        return Arrays.equals(fArr, fArr2);
    }

    public static int hashCode(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            Object obj = objArr[i16];
            if (obj != null) {
                i3 = (i3 * 31) + obj.hashCode();
            }
        }
        return i3;
    }

    public static boolean equals(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr.length == 0) {
            return dArr2 == null || dArr2.length == 0;
        }
        return Arrays.equals(dArr, dArr2);
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        int i3 = 0;
        if (map == null) {
            return 0;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i3 += hashCodeForMap(entry.getValue()) ^ hashCodeForMap(entry.getKey());
        }
        return i3;
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        if (zArr == null || zArr.length == 0) {
            return zArr2 == null || zArr2.length == 0;
        }
        return Arrays.equals(zArr, zArr2);
    }

    public static boolean equals(byte[][] bArr, byte[][] bArr2) {
        int length = bArr == null ? 0 : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i3 >= length || bArr[i3] != null) {
                while (i16 < length2 && bArr2[i16] == null) {
                    i16++;
                }
                boolean z16 = i3 >= length;
                boolean z17 = i16 >= length2;
                if (z16 && z17) {
                    return true;
                }
                if (z16 != z17 || !Arrays.equals(bArr[i3], bArr2[i16])) {
                    return false;
                }
                i3++;
                i16++;
            } else {
                i3++;
            }
        }
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i3 >= length || objArr[i3] != null) {
                while (i16 < length2 && objArr2[i16] == null) {
                    i16++;
                }
                boolean z16 = i3 >= length;
                boolean z17 = i16 >= length2;
                if (z16 && z17) {
                    return true;
                }
                if (z16 != z17 || !objArr[i3].equals(objArr2[i16])) {
                    return false;
                }
                i3++;
                i16++;
            } else {
                i3++;
            }
        }
    }

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null) {
            return map2.size() == 0;
        }
        if (map2 == null) {
            return map.size() == 0;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !equalsMapValue(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
