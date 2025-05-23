package com.tencent.component.network.module.common.dns;

import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ByteBase {
    private static final DecimalFormat byteFormat = new DecimalFormat();

    public static String byteString(byte[] bArr, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i16 = 0; i16 < i3; i16++) {
            int i17 = bArr[i16] & 255;
            if (i17 > 32 && i17 < 127) {
                if (i17 != 34 && i17 != 40 && i17 != 41 && i17 != 46 && i17 != 59 && i17 != 92 && i17 != 64 && i17 != 36) {
                    stringBuffer.append((char) i17);
                } else {
                    stringBuffer.append('\\');
                    stringBuffer.append((char) i17);
                }
            } else {
                stringBuffer.append('\\');
                stringBuffer.append(byteFormat.format(i17));
            }
        }
        return stringBuffer.toString();
    }
}
