package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class BitEncoding {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean FORCE_8TO7_ENCODING;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 1 && i3 != 3 && i3 != 6 && i3 != 8 && i3 != 10 && i3 != 12 && i3 != 14) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 1 && i3 != 3 && i3 != 6 && i3 != 8 && i3 != 10 && i3 != 12 && i3 != 14) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        if (i3 != 1 && i3 != 3 && i3 != 6 && i3 != 8 && i3 != 10 && i3 != 12 && i3 != 14) {
            objArr[0] = "data";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        }
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 6) {
                    if (i3 != 8) {
                        if (i3 != 10) {
                            if (i3 != 12) {
                                if (i3 != 14) {
                                    objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
                                } else {
                                    objArr[1] = "decode7to8";
                                }
                            } else {
                                objArr[1] = "combineStringArrayIntoBytes";
                            }
                        } else {
                            objArr[1] = "dropMarker";
                        }
                    } else {
                        objArr[1] = "decodeBytes";
                    }
                } else {
                    objArr[1] = "splitBytesToStringArray";
                }
            } else {
                objArr[1] = "encode8to7";
            }
        } else {
            objArr[1] = "encodeBytes";
        }
        switch (i3) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        if (i3 == 1 || i3 == 3 || i3 == 6 || i3 == 8 || i3 == 10 || i3 == 12 || i3 == 14) {
            throw new IllegalStateException(format);
        }
    }

    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        FORCE_8TO7_ENCODING = "true".equals(str);
    }

    BitEncoding() {
    }

    private static void addModuloByte(@NotNull byte[] bArr, int i3) {
        if (bArr == null) {
            $$$reportNull$$$0(4);
        }
        int length = bArr.length;
        for (int i16 = 0; i16 < length; i16++) {
            bArr[i16] = (byte) ((bArr[i16] + i3) & 127);
        }
    }

    @NotNull
    private static byte[] combineStringArrayIntoBytes(@NotNull String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(11);
        }
        int i3 = 0;
        for (String str : strArr) {
            i3 += str.length();
        }
        byte[] bArr = new byte[i3];
        int i16 = 0;
        for (String str2 : strArr) {
            int length = str2.length();
            int i17 = 0;
            while (i17 < length) {
                bArr[i16] = (byte) str2.charAt(i17);
                i17++;
                i16++;
            }
        }
        return bArr;
    }

    @NotNull
    private static byte[] decode7to8(@NotNull byte[] bArr) {
        if (bArr == null) {
            $$$reportNull$$$0(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            int i18 = (bArr[i3] & 255) >>> i16;
            i3++;
            int i19 = i16 + 1;
            bArr2[i17] = (byte) (i18 + ((bArr[i3] & ((1 << i19) - 1)) << (7 - i16)));
            if (i16 == 6) {
                i3++;
                i16 = 0;
            } else {
                i16 = i19;
            }
        }
        return bArr2;
    }

    @NotNull
    public static byte[] decodeBytes(@NotNull String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                byte[] stringsToBytes = UtfEncodingKt.stringsToBytes(dropMarker(strArr));
                if (stringsToBytes == null) {
                    $$$reportNull$$$0(8);
                }
                return stringsToBytes;
            }
            if (charAt == '\uffff') {
                strArr = dropMarker(strArr);
            }
        }
        byte[] combineStringArrayIntoBytes = combineStringArrayIntoBytes(strArr);
        addModuloByte(combineStringArrayIntoBytes, 127);
        return decode7to8(combineStringArrayIntoBytes);
    }

    @NotNull
    private static String[] dropMarker(@NotNull String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        return strArr2;
    }
}
