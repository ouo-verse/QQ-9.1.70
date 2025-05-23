package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.InvalidTTLException;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TTL {
    public static final long MAX_VALUE = 2147483647L;

    TTL() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void check(long j3) {
        if (j3 >= 0 && j3 <= MAX_VALUE) {
        } else {
            throw new InvalidTTLException(j3);
        }
    }

    public static String format(long j3) {
        check(j3);
        StringBuilder sb5 = new StringBuilder();
        long j16 = j3 % 60;
        long j17 = j3 / 60;
        long j18 = j17 % 60;
        long j19 = j17 / 60;
        long j26 = j19 % 24;
        long j27 = j19 / 24;
        long j28 = j27 % 7;
        long j29 = j27 / 7;
        if (j29 > 0) {
            sb5.append(j29);
            sb5.append("W");
        }
        if (j28 > 0) {
            sb5.append(j28);
            sb5.append("D");
        }
        if (j26 > 0) {
            sb5.append(j26);
            sb5.append("H");
        }
        if (j18 > 0) {
            sb5.append(j18);
            sb5.append("M");
        }
        if (j16 > 0 || (j29 == 0 && j28 == 0 && j26 == 0 && j18 == 0)) {
            sb5.append(j16);
            sb5.append(ExifInterface.LATITUDE_SOUTH);
        }
        return sb5.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long parse(String str, boolean z16) {
        if (str != null && str.length() != 0) {
            if (Character.isDigit(str.charAt(0))) {
                long j3 = 0;
                long j16 = 0;
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    if (Character.isDigit(charAt)) {
                        long numericValue = (10 * j16) + Character.getNumericValue(charAt);
                        if (numericValue >= j16) {
                            j16 = numericValue;
                        } else {
                            throw new NumberFormatException();
                        }
                    } else {
                        char upperCase = Character.toUpperCase(charAt);
                        if (upperCase != 'D') {
                            if (upperCase != 'H') {
                                if (upperCase != 'M') {
                                    if (upperCase != 'S') {
                                        if (upperCase == 'W') {
                                            j16 *= 7;
                                        } else {
                                            throw new NumberFormatException();
                                        }
                                    }
                                    j3 += j16;
                                    if (j3 > 4294967295L) {
                                        j16 = 0;
                                    } else {
                                        throw new NumberFormatException();
                                    }
                                }
                                j16 *= 60;
                                j3 += j16;
                                if (j3 > 4294967295L) {
                                }
                            }
                            j16 *= 60;
                            j16 *= 60;
                            j3 += j16;
                            if (j3 > 4294967295L) {
                            }
                        }
                        j16 *= 24;
                        j16 *= 60;
                        j16 *= 60;
                        j3 += j16;
                        if (j3 > 4294967295L) {
                        }
                    }
                }
                if (j3 == 0) {
                    j3 = j16;
                }
                if (j3 <= 4294967295L) {
                    if (j3 > MAX_VALUE && z16) {
                        return MAX_VALUE;
                    }
                    return j3;
                }
                throw new NumberFormatException();
            }
        }
        throw new NumberFormatException();
    }

    public static long parseTTL(String str) {
        return parse(str, true);
    }
}
