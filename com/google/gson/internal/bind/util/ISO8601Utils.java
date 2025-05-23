package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    private static boolean checkOffset(String str, int i3, char c16) {
        if (i3 < str.length() && str.charAt(i3) == c16) {
            return true;
        }
        return false;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i3) {
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                i3++;
            } else {
                return i3;
            }
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb5, int i3, int i16) {
        String num = Integer.toString(i3);
        for (int length = i16 - num.length(); length > 0; length--) {
            sb5.append('0');
        }
        sb5.append(num);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ce A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01c7, NumberFormatException -> 0x01c9, IndexOutOfBoundsException -> 0x01cb, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01c7, blocks: (B:3:0x0007, B:5:0x0019, B:6:0x001b, B:8:0x0027, B:9:0x0029, B:11:0x0038, B:13:0x003e, B:18:0x0053, B:20:0x0063, B:21:0x0065, B:23:0x0071, B:24:0x0073, B:26:0x0079, B:30:0x0083, B:35:0x0093, B:37:0x009b, B:42:0x00c8, B:44:0x00ce, B:46:0x00d5, B:47:0x018c, B:53:0x00e1, B:54:0x00fb, B:55:0x00fc, B:58:0x0119, B:60:0x0127, B:63:0x0131, B:65:0x0151, B:68:0x0162, B:69:0x0186, B:71:0x0189, B:72:0x0107, B:73:0x01be, B:74:0x01c6, B:75:0x00b3, B:76:0x00b6), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01be A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01c7, NumberFormatException -> 0x01c9, IndexOutOfBoundsException -> 0x01cb, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01c7, blocks: (B:3:0x0007, B:5:0x0019, B:6:0x001b, B:8:0x0027, B:9:0x0029, B:11:0x0038, B:13:0x003e, B:18:0x0053, B:20:0x0063, B:21:0x0065, B:23:0x0071, B:24:0x0073, B:26:0x0079, B:30:0x0083, B:35:0x0093, B:37:0x009b, B:42:0x00c8, B:44:0x00ce, B:46:0x00d5, B:47:0x018c, B:53:0x00e1, B:54:0x00fb, B:55:0x00fc, B:58:0x0119, B:60:0x0127, B:63:0x0131, B:65:0x0151, B:68:0x0162, B:69:0x0186, B:71:0x0189, B:72:0x0107, B:73:0x01be, B:74:0x01c6, B:75:0x00b3, B:76:0x00b6), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i3;
        int i16;
        int i17;
        int i18;
        int length;
        TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i19 = index + 4;
            int parseInt = parseInt(str, index, i19);
            if (checkOffset(str, i19, '-')) {
                i19++;
            }
            int i26 = i19 + 2;
            int parseInt2 = parseInt(str, i19, i26);
            if (checkOffset(str, i26, '-')) {
                i26++;
            }
            int i27 = i26 + 2;
            int parseInt3 = parseInt(str, i26, i27);
            boolean checkOffset = checkOffset(str, i27, 'T');
            if (!checkOffset && str.length() <= i27) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
                parsePosition.setIndex(i27);
                return gregorianCalendar.getTime();
            }
            if (checkOffset) {
                int i28 = i27 + 1;
                int i29 = i28 + 2;
                int parseInt4 = parseInt(str, i28, i29);
                if (checkOffset(str, i29, ':')) {
                    i29++;
                }
                int i36 = i29 + 2;
                i16 = parseInt(str, i29, i36);
                if (checkOffset(str, i36, ':')) {
                    i36++;
                }
                if (str.length() > i36 && (charAt = str.charAt(i36)) != 'Z' && charAt != '+' && charAt != '-') {
                    int i37 = i36 + 2;
                    i18 = parseInt(str, i36, i37);
                    if (i18 > 59 && i18 < 63) {
                        i18 = 59;
                    }
                    if (checkOffset(str, i37, '.')) {
                        int i38 = i37 + 1;
                        int indexOfNonDigit = indexOfNonDigit(str, i38 + 1);
                        int min = Math.min(indexOfNonDigit, i38 + 3);
                        int parseInt5 = parseInt(str, i38, min);
                        int i39 = min - i38;
                        if (i39 != 1) {
                            if (i39 == 2) {
                                parseInt5 *= 10;
                            }
                        } else {
                            parseInt5 *= 100;
                        }
                        i3 = parseInt4;
                        i27 = indexOfNonDigit;
                        i17 = parseInt5;
                    } else {
                        i3 = parseInt4;
                        i27 = i37;
                        i17 = 0;
                    }
                    if (str.length() <= i27) {
                        char charAt2 = str.charAt(i27);
                        if (charAt2 == 'Z') {
                            timeZone = TIMEZONE_UTC;
                            length = i27 + 1;
                        } else {
                            if (charAt2 != '+' && charAt2 != '-') {
                                throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                            }
                            String substring = str.substring(i27);
                            if (substring.length() < 5) {
                                substring = substring + "00";
                            }
                            length = i27 + substring.length();
                            if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                                String str3 = "GMT" + substring;
                                TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                                String id5 = timeZone2.getID();
                                if (!id5.equals(str3) && !id5.replace(":", "").equals(str3)) {
                                    throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                                }
                                timeZone = timeZone2;
                            }
                            timeZone = TIMEZONE_UTC;
                        }
                        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                        gregorianCalendar2.setLenient(false);
                        gregorianCalendar2.set(1, parseInt);
                        gregorianCalendar2.set(2, parseInt2 - 1);
                        gregorianCalendar2.set(5, parseInt3);
                        gregorianCalendar2.set(11, i3);
                        gregorianCalendar2.set(12, i16);
                        gregorianCalendar2.set(13, i18);
                        gregorianCalendar2.set(14, i17);
                        parsePosition.setIndex(length);
                        return gregorianCalendar2.getTime();
                    }
                    throw new IllegalArgumentException("No time zone indicator");
                }
                i3 = parseInt4;
                i27 = i36;
            } else {
                i3 = 0;
                i16 = 0;
            }
            i17 = 0;
            i18 = 0;
            if (str.length() <= i27) {
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e16) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + "'";
            }
            String message = e16.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e16.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e16);
            throw parseException;
        }
    }

    private static int parseInt(String str, int i3, int i16) throws NumberFormatException {
        int i17;
        int i18;
        if (i3 >= 0 && i16 <= str.length() && i3 <= i16) {
            if (i3 < i16) {
                i18 = i3 + 1;
                int digit = Character.digit(str.charAt(i3), 10);
                if (digit >= 0) {
                    i17 = -digit;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(i3, i16));
                }
            } else {
                i17 = 0;
                i18 = i3;
            }
            while (i18 < i16) {
                int i19 = i18 + 1;
                int digit2 = Character.digit(str.charAt(i18), 10);
                if (digit2 >= 0) {
                    i17 = (i17 * 10) - digit2;
                    i18 = i19;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(i3, i16));
                }
            }
            return -i17;
        }
        throw new NumberFormatException(str);
    }

    public static String format(Date date, boolean z16) {
        return format(date, z16, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z16, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb5 = new StringBuilder(19 + (z16 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb5, gregorianCalendar.get(1), 4);
        sb5.append('-');
        padInt(sb5, gregorianCalendar.get(2) + 1, 2);
        sb5.append('-');
        padInt(sb5, gregorianCalendar.get(5), 2);
        sb5.append('T');
        padInt(sb5, gregorianCalendar.get(11), 2);
        sb5.append(':');
        padInt(sb5, gregorianCalendar.get(12), 2);
        sb5.append(':');
        padInt(sb5, gregorianCalendar.get(13), 2);
        if (z16) {
            sb5.append('.');
            padInt(sb5, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i3 = offset / 60000;
            int abs = Math.abs(i3 / 60);
            int abs2 = Math.abs(i3 % 60);
            sb5.append(offset >= 0 ? '+' : '-');
            padInt(sb5, abs, 2);
            sb5.append(':');
            padInt(sb5, abs2, 2);
        } else {
            sb5.append('Z');
        }
        return sb5.toString();
    }
}
