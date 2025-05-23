package org.jf.util;

import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NumberUtils {
    private static final int canonicalFloatNaN = Float.floatToRawIntBits(Float.NaN);
    private static final int maxFloat = Float.floatToRawIntBits(Float.MAX_VALUE);
    private static final int piFloat = Float.floatToRawIntBits(3.1415927f);
    private static final int eFloat = Float.floatToRawIntBits(2.7182817f);
    private static final long canonicalDoubleNaN = Double.doubleToRawLongBits(Double.NaN);
    private static final long maxDouble = Double.doubleToLongBits(Double.MAX_VALUE);
    private static final long piDouble = Double.doubleToLongBits(3.141592653589793d);
    private static final long eDouble = Double.doubleToLongBits(2.718281828459045d);
    private static final DecimalFormat format = new DecimalFormat("0.####################E0");

    public static boolean isLikelyDouble(long j3) {
        if (j3 == canonicalDoubleNaN || j3 == maxDouble || j3 == piDouble || j3 == eDouble) {
            return true;
        }
        if (j3 == Long.MAX_VALUE || j3 == Long.MIN_VALUE) {
            return false;
        }
        double longBitsToDouble = Double.longBitsToDouble(j3);
        if (Double.isNaN(longBitsToDouble)) {
            return false;
        }
        DecimalFormat decimalFormat = format;
        String format2 = decimalFormat.format(j3);
        String format3 = decimalFormat.format(longBitsToDouble);
        int indexOf = format3.indexOf(46);
        int indexOf2 = format3.indexOf("E");
        int indexOf3 = format3.indexOf(TVKUpdateInfo.APP_ID);
        if (indexOf3 > indexOf && indexOf3 < indexOf2) {
            format3 = format3.substring(0, indexOf3) + format3.substring(indexOf2);
        } else {
            int indexOf4 = format3.indexOf("999");
            if (indexOf4 > indexOf && indexOf4 < indexOf2) {
                format3 = format3.substring(0, indexOf4) + format3.substring(indexOf2);
            }
        }
        if (format3.length() < format2.length()) {
            return true;
        }
        return false;
    }

    public static boolean isLikelyFloat(int i3) {
        if (i3 == canonicalFloatNaN || i3 == maxFloat || i3 == piFloat || i3 == eFloat) {
            return true;
        }
        if (i3 == Integer.MAX_VALUE || i3 == Integer.MIN_VALUE) {
            return false;
        }
        int i16 = i3 >> 24;
        int i17 = (i3 >> 16) & 255;
        int i18 = 65535 & i3;
        if ((i16 == 127 || i16 == 1) && i17 < 31 && i18 < 4095) {
            return false;
        }
        float intBitsToFloat = Float.intBitsToFloat(i3);
        if (Float.isNaN(intBitsToFloat)) {
            return false;
        }
        DecimalFormat decimalFormat = format;
        String format2 = decimalFormat.format(i3);
        String format3 = decimalFormat.format(intBitsToFloat);
        int indexOf = format3.indexOf(46);
        int indexOf2 = format3.indexOf("E");
        int indexOf3 = format3.indexOf(TVKUpdateInfo.APP_ID);
        if (indexOf3 > indexOf && indexOf3 < indexOf2) {
            format3 = format3.substring(0, indexOf3) + format3.substring(indexOf2);
        } else {
            int indexOf4 = format3.indexOf("999");
            if (indexOf4 > indexOf && indexOf4 < indexOf2) {
                format3 = format3.substring(0, indexOf4) + format3.substring(indexOf2);
            }
        }
        if (format3.length() < format2.length()) {
            return true;
        }
        return false;
    }
}
