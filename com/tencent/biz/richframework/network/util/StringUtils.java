package com.tencent.biz.richframework.network.util;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StringUtils {
    public static String byte2HexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (Integer.toHexString(bArr[i3] & 255).length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(bArr[i3] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(bArr[i3] & 255));
            }
        }
        return stringBuffer.toString();
    }

    public static String formatSize(long j3) {
        String str = "" + j3;
        if (j3 >= 0 && j3 < 1024) {
            return str + "B";
        }
        if (j3 >= 1024 && j3 < 1048576) {
            return Long.toString(j3 / 1024) + "KB";
        }
        if (j3 >= 1048576 && j3 < 1073741824) {
            return Long.toString(j3 / 1048576) + "MB";
        }
        if (j3 < 1073741824) {
            return "";
        }
        return Long.toString(j3 / 1073741824) + "GB";
    }

    public static boolean isEmpty(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }
}
