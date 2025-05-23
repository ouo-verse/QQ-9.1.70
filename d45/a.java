package d45;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f392801a;

    static {
        byte[] byteArray;
        ArrayList arrayList = new ArrayList("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".length());
        for (int i3 = 0; i3 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".length(); i3++) {
            arrayList.add(Byte.valueOf((byte) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i3)));
        }
        byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
        f392801a = byteArray;
        ArrayList arrayList2 = new ArrayList("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".length());
        for (int i16 = 0; i16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".length(); i16++) {
            arrayList2.add(Byte.valueOf((byte) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i16)));
        }
        CollectionsKt___CollectionsKt.toByteArray(arrayList2);
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = f392801a;
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = i3 + 1;
            byte b16 = bArr[i3];
            int i18 = i17 + 1;
            byte b17 = bArr[i17];
            int i19 = i18 + 1;
            byte b18 = bArr[i18];
            int i26 = i16 + 1;
            bArr3[i16] = bArr2[(b16 & 255) >> 2];
            int i27 = i26 + 1;
            bArr3[i26] = bArr2[((b16 & 3) << 4) | ((b17 & 255) >> 4)];
            int i28 = i27 + 1;
            bArr3[i27] = bArr2[((b17 & RegisterType.DOUBLE_HI) << 2) | ((b18 & 255) >> 6)];
            i16 = i28 + 1;
            bArr3[i28] = bArr2[b18 & 63];
            i3 = i19;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b19 = bArr[i3];
            int i29 = i16 + 1;
            bArr3[i16] = bArr2[(b19 & 255) >> 2];
            int i36 = i29 + 1;
            bArr3[i29] = bArr2[(b19 & 3) << 4];
            bArr3[i36] = 61;
            bArr3[i36 + 1] = 61;
        } else if (length2 == 2) {
            int i37 = i3 + 1;
            byte b26 = bArr[i3];
            byte b27 = bArr[i37];
            int i38 = i16 + 1;
            bArr3[i16] = bArr2[(b26 & 255) >> 2];
            int i39 = i38 + 1;
            bArr3[i38] = bArr2[((b26 & 3) << 4) | ((b27 & 255) >> 4)];
            bArr3[i39] = bArr2[(b27 & RegisterType.DOUBLE_HI) << 2];
            bArr3[i39 + 1] = 61;
        }
        return bArr3;
    }

    public static final byte[] a(String str) {
        int i3;
        char charAt;
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i16 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i16];
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        while (true) {
            if (i17 < length) {
                char charAt2 = str.charAt(i17);
                if ('A' <= charAt2 && charAt2 < '[') {
                    i3 = charAt2 - 'A';
                } else {
                    if ('a' <= charAt2 && charAt2 < '{') {
                        i3 = charAt2 - 'G';
                    } else {
                        if ('0' <= charAt2 && charAt2 < ':') {
                            i3 = charAt2 + 4;
                        } else if (charAt2 == '+' || charAt2 == '-') {
                            i3 = 62;
                        } else if (charAt2 == '/' || charAt2 == '_') {
                            i3 = 63;
                        } else {
                            if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                                return null;
                            }
                            i17++;
                        }
                    }
                }
                i26 = (i26 << 6) | i3;
                i18++;
                if (i18 % 4 == 0) {
                    int i27 = i19 + 1;
                    bArr[i19] = (byte) (i26 >> 16);
                    int i28 = i27 + 1;
                    bArr[i27] = (byte) (i26 >> 8);
                    bArr[i28] = (byte) i26;
                    i19 = i28 + 1;
                }
                i17++;
            } else {
                int i29 = i18 % 4;
                if (i29 == 1) {
                    return null;
                }
                if (i29 == 2) {
                    bArr[i19] = (byte) ((i26 << 12) >> 16);
                    i19++;
                } else if (i29 == 3) {
                    int i36 = i26 << 6;
                    int i37 = i19 + 1;
                    bArr[i19] = (byte) (i36 >> 16);
                    i19 = i37 + 1;
                    bArr[i37] = (byte) (i36 >> 8);
                }
                if (i19 == i16) {
                    return bArr;
                }
                byte[] copyOf = Arrays.copyOf(bArr, i19);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
        }
    }
}
