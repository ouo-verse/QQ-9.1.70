package com.tencent.mapsdk.internal;

import com.tencent.mobileqq.text.EmotcationConstants;
import java.nio.ByteBuffer;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f148764b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f148763a = new byte[0];

    private static byte a(char c16) {
        int i3;
        if (c16 < '0' || c16 > '9') {
            char c17 = 'a';
            if (c16 < 'a' || c16 > 'f') {
                c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
                if (c16 < 'A' || c16 > 'F') {
                    return (byte) 0;
                }
            }
            i3 = (c16 - c17) + 10;
        } else {
            i3 = c16 - '0';
        }
        return (byte) i3;
    }

    private static byte b(String str) {
        if (str == null || str.length() != 1) {
            return (byte) 0;
        }
        return a(str.charAt(0));
    }

    private static String a(byte b16) {
        char[] cArr = f148764b;
        return new String(new char[]{cArr[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI], cArr[b16 & RegisterType.DOUBLE_HI]});
    }

    private static String a(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.flip();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        return a(bArr);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b16 = bArr[i3];
            int i16 = i3 * 2;
            char[] cArr2 = f148764b;
            cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
            cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        if (str != null && !str.equals("")) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) ((a(str.charAt(i16)) * RegisterType.UNINIT_REF) + a(str.charAt(i16 + 1)));
            }
            return bArr;
        }
        return f148763a;
    }
}
