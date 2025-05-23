package com.qq.jce.wup;

import com.tencent.mobileqq.text.EmotcationConstants;
import java.nio.ByteBuffer;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WupHexUtil {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] emptybytes = new byte[0];

    public static String byte2HexStr(byte b16) {
        char[] cArr = digits;
        return new String(new char[]{cArr[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI], cArr[b16 & RegisterType.DOUBLE_HI]});
    }

    public static String bytes2HexStr(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.flip();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        return bytes2HexStr(bArr);
    }

    public static byte char2Byte(char c16) {
        int i3;
        if (c16 >= '0' && c16 <= '9') {
            i3 = c16 - '0';
        } else {
            char c17 = 'a';
            if (c16 < 'a' || c16 > 'f') {
                c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
                if (c16 < 'A' || c16 > 'F') {
                    return (byte) 0;
                }
            }
            i3 = (c16 - c17) + 10;
        }
        return (byte) i3;
    }

    public static byte hexStr2Byte(String str) {
        if (str == null || str.length() != 1) {
            return (byte) 0;
        }
        return char2Byte(str.charAt(0));
    }

    public static byte[] hexStr2Bytes(String str) {
        if (str != null && !str.equals("")) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) ((char2Byte(str.charAt(i16)) * RegisterType.UNINIT_REF) + char2Byte(str.charAt(i16 + 1)));
            }
            return bArr;
        }
        return emptybytes;
    }

    public static void main(String[] strArr) {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i3 = 0; i3 < 1000000; i3++) {
            String str = "234" + i3;
            if (!new String(hexStr2Bytes(bytes2HexStr(str.getBytes()))).equals(str)) {
                System.out.println("error:" + str);
            }
        }
        System.out.println("use:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b16 = bArr[i3];
            int i16 = i3 * 2;
            char[] cArr2 = digits;
            cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
            cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
        }
        return new String(cArr);
    }
}
