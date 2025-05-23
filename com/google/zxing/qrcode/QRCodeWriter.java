package com.google.zxing.qrcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;
import v1.b;
import v1.c;
import v1.f;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class QRCodeWriter {
    private static final int QUIET_ZONE_SIZE = 4;

    private static BitMatrix renderResult(f fVar, int i3, int i16, int i17) {
        b a16 = fVar.a();
        if (a16 != null) {
            int e16 = a16.e();
            int d16 = a16.d();
            int i18 = i17 << 1;
            int i19 = e16 + i18;
            int i26 = i18 + d16;
            int max = Math.max(i3, i19);
            int max2 = Math.max(i16, i26);
            int min = Math.min(max / i19, max2 / i26);
            int i27 = (max - (e16 * min)) / 2;
            int i28 = (max2 - (d16 * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i29 = 0;
            while (i29 < d16) {
                int i36 = 0;
                int i37 = i27;
                while (i36 < e16) {
                    if (a16.b(i36, i29) == 1) {
                        bitMatrix.setRegion(i37, i28, min, min);
                    }
                    i36++;
                    i37 += min;
                }
                i29++;
                i28 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }

    public BitMatrix encode(String str, int i3, int i16) throws WriterException {
        return encode(str, i3, i16, null);
    }

    public BitMatrix encode(String str, int i3, int i16, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i3 >= 0 && i16 >= 0) {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int i17 = 4;
            if (map != null) {
                ErrorCorrectionLevel errorCorrectionLevel2 = (ErrorCorrectionLevel) map.get(EncodeHintType.ERROR_CORRECTION);
                if (errorCorrectionLevel2 != null) {
                    errorCorrectionLevel = errorCorrectionLevel2;
                }
                Integer num = (Integer) map.get(EncodeHintType.MARGIN);
                if (num != null) {
                    i17 = num.intValue();
                }
            }
            return renderResult(c.m(str, errorCorrectionLevel, map), i3, i16, i17);
        }
        throw new IllegalArgumentException("Requested dimensions are too small: " + i3 + 'x' + i16);
    }
}
