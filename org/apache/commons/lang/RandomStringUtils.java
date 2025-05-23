package org.apache.commons.lang;

import java.util.Random;
import okio.Utf8;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int i3) {
        return random(i3, false, false);
    }

    public static String randomAlphabetic(int i3) {
        return random(i3, true, false);
    }

    public static String randomAlphanumeric(int i3) {
        return random(i3, true, true);
    }

    public static String randomAscii(int i3) {
        return random(i3, 32, 127, false, false);
    }

    public static String randomNumeric(int i3) {
        return random(i3, false, true);
    }

    public static String random(int i3, boolean z16, boolean z17) {
        return random(i3, 0, 0, z16, z17);
    }

    public static String random(int i3, int i16, int i17, boolean z16, boolean z17) {
        return random(i3, i16, i17, z16, z17, null, RANDOM);
    }

    public static String random(int i3, int i16, int i17, boolean z16, boolean z17, char[] cArr) {
        return random(i3, i16, i17, z16, z17, cArr, RANDOM);
    }

    public static String random(int i3, int i16, int i17, boolean z16, boolean z17, char[] cArr, Random random) {
        char c16;
        if (i3 == 0) {
            return "";
        }
        if (i3 >= 0) {
            if (i16 == 0 && i17 == 0) {
                if (z16 || z17) {
                    i17 = 123;
                    i16 = 32;
                } else {
                    i16 = 0;
                    i17 = Integer.MAX_VALUE;
                }
            }
            char[] cArr2 = new char[i3];
            int i18 = i17 - i16;
            while (true) {
                int i19 = i3 - 1;
                if (i3 != 0) {
                    if (cArr == null) {
                        c16 = (char) (random.nextInt(i18) + i16);
                    } else {
                        c16 = cArr[random.nextInt(i18) + i16];
                    }
                    if ((z16 && Character.isLetter(c16)) || ((z17 && Character.isDigit(c16)) || (!z16 && !z17))) {
                        if (c16 < '\udc00' || c16 > '\udfff') {
                            if (c16 < '\ud800' || c16 > '\udb7f') {
                                if (c16 < '\udb80' || c16 > '\udbff') {
                                    cArr2[i19] = c16;
                                }
                            } else if (i19 != 0) {
                                cArr2[i19] = (char) (random.nextInt(128) + Utf8.LOG_SURROGATE_HEADER);
                                i19--;
                                cArr2[i19] = c16;
                            }
                        } else if (i19 != 0) {
                            cArr2[i19] = c16;
                            i19--;
                            cArr2[i19] = (char) (random.nextInt(128) + 55296);
                        }
                        i3 = i19;
                    }
                    i19++;
                    i3 = i19;
                } else {
                    return new String(cArr2);
                }
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Requested random string length ");
            stringBuffer.append(i3);
            stringBuffer.append(" is less than 0.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public static String random(int i3, String str) {
        if (str == null) {
            return random(i3, 0, 0, false, false, null, RANDOM);
        }
        return random(i3, str.toCharArray());
    }

    public static String random(int i3, char[] cArr) {
        if (cArr == null) {
            return random(i3, 0, 0, false, false, null, RANDOM);
        }
        return random(i3, 0, cArr.length, false, false, cArr, RANDOM);
    }
}
