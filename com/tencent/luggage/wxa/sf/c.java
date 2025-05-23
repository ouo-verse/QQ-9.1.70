package com.tencent.luggage.wxa.sf;

import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static String a(byte[] bArr) {
        int i3;
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                int i16 = b16 & RegisterType.DOUBLE_HI;
                int i17 = 48;
                if (i16 < 10) {
                    i3 = 48;
                } else {
                    i3 = 55;
                }
                int i18 = i16 + i3;
                int i19 = (b16 & 240) >> 4;
                if (i19 >= 10) {
                    i17 = 55;
                }
                sb5.append(i19 + i17);
                sb5.append(i18);
            }
            return sb5.toString();
        }
        return "";
    }
}
