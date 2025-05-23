package com.tencent.luggage.wxa.cf;

import com.tencent.luggage.wxa.tn.w;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static String a(byte[] bArr, int i3) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        if (bArr.length < i3) {
            w.f("MicroMsg.JsApiBeaconUtil", "data length is shorter then print command length");
            i3 = bArr.length;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            int i17 = bArr[i16] & 255;
            if (i17 < 16) {
                sb5.append("0");
            }
            sb5.append(Integer.toHexString(i17));
        }
        return sb5.toString().toUpperCase(Locale.US);
    }

    public static double a(int i3, double d16) {
        if (d16 == 0.0d) {
            return -1.0d;
        }
        double d17 = (d16 * 1.0d) / i3;
        if (d17 < 1.0d) {
            return Math.pow(d17, 10.0d);
        }
        return (Math.pow(d17, 9.9476d) * 0.92093d) + 0.54992d;
    }
}
