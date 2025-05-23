package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    TimeUtils() {
    }

    private static int accumField(int i3, int i16, boolean z16, int i17) {
        if (i3 <= 99 && (!z16 || i17 < 3)) {
            if (i3 <= 9 && (!z16 || i17 < 2)) {
                if (!z16 && i3 <= 0) {
                    return 0;
                }
                return i16 + 1;
            }
            return i16 + 2;
        }
        return i16 + 3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j3, StringBuilder sb5) {
        synchronized (sFormatSync) {
            sb5.append(sFormatStr, 0, formatDurationLocked(j3, 0));
        }
    }

    private static int formatDurationLocked(long j3, int i3) {
        char c16;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        boolean z16;
        boolean z17;
        int i27;
        boolean z18;
        int i28;
        boolean z19;
        int i29;
        int i36;
        boolean z26;
        boolean z27;
        boolean z28;
        int i37;
        long j16 = j3;
        if (sFormatStr.length < i3) {
            sFormatStr = new char[i3];
        }
        char[] cArr = sFormatStr;
        if (j16 == 0) {
            int i38 = i3 - 1;
            while (i38 > 0) {
                cArr[0] = TokenParser.SP;
            }
            cArr[0] = '0';
            return 1;
        }
        if (j16 > 0) {
            c16 = '+';
        } else {
            j16 = -j16;
            c16 = '-';
        }
        int i39 = (int) (j16 % 1000);
        int floor = (int) Math.floor(j16 / 1000);
        if (floor > 86400) {
            i16 = floor / 86400;
            floor -= 86400 * i16;
        } else {
            i16 = 0;
        }
        if (floor > 3600) {
            i17 = floor / 3600;
            floor -= i17 * 3600;
        } else {
            i17 = 0;
        }
        if (floor > 60) {
            int i46 = floor / 60;
            i18 = floor - (i46 * 60);
            i19 = i46;
        } else {
            i18 = floor;
            i19 = 0;
        }
        if (i3 != 0) {
            int accumField = accumField(i16, 1, false, 0);
            if (accumField > 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            int accumField2 = accumField + accumField(i17, 1, z26, 2);
            if (accumField2 > 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            int accumField3 = accumField2 + accumField(i19, 1, z27, 2);
            if (accumField3 > 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            int accumField4 = accumField3 + accumField(i18, 1, z28, 2);
            if (accumField4 > 0) {
                i37 = 3;
            } else {
                i37 = 0;
            }
            i26 = 0;
            for (int accumField5 = accumField4 + accumField(i39, 2, true, i37) + 1; accumField5 < i3; accumField5++) {
                cArr[i26] = TokenParser.SP;
                i26++;
            }
        } else {
            i26 = 0;
        }
        cArr[i26] = c16;
        int i47 = i26 + 1;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int printField = printField(cArr, i16, 'd', i47, false, 0);
        if (printField != i47) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            i27 = 2;
        } else {
            i27 = 0;
        }
        int printField2 = printField(cArr, i17, 'h', printField, z17, i27);
        if (printField2 != i47) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16) {
            i28 = 2;
        } else {
            i28 = 0;
        }
        int printField3 = printField(cArr, i19, 'm', printField2, z18, i28);
        if (printField3 != i47) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z16) {
            i29 = 2;
        } else {
            i29 = 0;
        }
        int printField4 = printField(cArr, i18, 's', printField3, z19, i29);
        if (z16 && printField4 != i47) {
            i36 = 3;
        } else {
            i36 = 0;
        }
        int printField5 = printField(cArr, i39, 'm', printField4, true, i36);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i3, char c16, int i16, boolean z16, int i17) {
        int i18;
        if (z16 || i3 > 0) {
            if ((z16 && i17 >= 3) || i3 > 99) {
                int i19 = i3 / 100;
                cArr[i16] = (char) (i19 + 48);
                i18 = i16 + 1;
                i3 -= i19 * 100;
            } else {
                i18 = i16;
            }
            if ((z16 && i17 >= 2) || i3 > 9 || i16 != i18) {
                int i26 = i3 / 10;
                cArr[i18] = (char) (i26 + 48);
                i18++;
                i3 -= i26 * 10;
            }
            cArr[i18] = (char) (i3 + 48);
            int i27 = i18 + 1;
            cArr[i27] = c16;
            return i27 + 1;
        }
        return i16;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j3, PrintWriter printWriter, int i3) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j3, i3)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j3, PrintWriter printWriter) {
        formatDuration(j3, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j3, long j16, PrintWriter printWriter) {
        if (j3 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j3 - j16, printWriter, 0);
        }
    }
}
