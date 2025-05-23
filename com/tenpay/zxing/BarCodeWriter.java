package com.tenpay.zxing;

import android.text.TextUtils;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class BarCodeWriter {
    /* JADX INFO: Access modifiers changed from: protected */
    public static int appendPattern(boolean[] zArr, int i3, int[] iArr, boolean z16) {
        int i16 = 0;
        for (int i17 : iArr) {
            int i18 = 0;
            while (i18 < i17) {
                zArr[i3] = z16;
                i18++;
                i3++;
            }
            i16 += i17;
            z16 = !z16;
        }
        return i16;
    }

    private static BitMatrix renderResult(boolean[] zArr, int i3, int i16) {
        int length = zArr.length;
        int ceil = ((int) Math.ceil((i3 * 1.0d) / length)) * length;
        int max = Math.max(1, i16);
        int i17 = ceil / length;
        int i18 = (ceil - (length * i17)) / 2;
        BitMatrix bitMatrix = new BitMatrix(ceil, max);
        int i19 = 0;
        while (i19 < zArr.length) {
            if (zArr[i19]) {
                bitMatrix.setRegion(i18, 0, i17, max);
            }
            i19++;
            i18 += i17;
        }
        return bitMatrix;
    }

    public final BitMatrix encode(String str, int i3, int i16) {
        return encode(str, i3, i16, null);
    }

    public abstract boolean[] encode(String str);

    public BitMatrix encode(String str, int i3, int i16, Map<EncodeHintType, ?> map) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i3 >= 0 && i16 >= 0) {
            return renderResult(encode(str), i3, i16);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i3 + 'x' + i16);
    }
}
