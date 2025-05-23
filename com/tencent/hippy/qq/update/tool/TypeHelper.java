package com.tencent.hippy.qq.update.tool;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TypeHelper {
    public static String byteToHexString(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if ((bArr[i3] & 255) < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Long.toString(bArr[i3] & 255, 16));
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static int byteToInt(byte[] bArr) throws Exception {
        if (bArr.length == 4) {
            return ((bArr[3] & 255) << 0) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
        throw new Exception();
    }

    public static long byteToLong(byte[] bArr) throws Exception {
        if (bArr.length == 8) {
            return ((bArr[0] & 255) << 56) | ((bArr[1] & 255) << 48) | ((bArr[2] & 255) << 40) | ((bArr[3] & 255) << 32) | ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | ((bArr[6] & 255) << 8) | ((bArr[7] & 255) << 0);
        }
        throw new Exception();
    }

    public static byte[] hexStringToByte(String str) {
        if (str != null && !str.equals("") && str.length() % 2 == 0) {
            byte[] bArr = new byte[str.length() / 2];
            int i3 = 0;
            while (i3 < str.length()) {
                int i16 = i3 + 2;
                bArr[i3 / 2] = (byte) (Integer.parseInt(str.substring(i3, i16), 16) & 255);
                i3 = i16;
            }
            return bArr;
        }
        return null;
    }

    public static byte[] intToByte(int i3) {
        byte[] bArr = new byte[4];
        for (int i16 = 3; i16 >= 0; i16--) {
            bArr[i16] = (byte) (i3 % 256);
            i3 >>= 8;
        }
        return bArr;
    }

    public static byte[] longToByte(long j3) {
        byte[] bArr = new byte[8];
        for (int i3 = 7; i3 >= 0; i3--) {
            bArr[i3] = (byte) (j3 % 256);
            j3 >>= 8;
        }
        return bArr;
    }
}
