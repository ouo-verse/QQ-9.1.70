package org.apache.commons.lang.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DateUtils {
    public static final int MILLIS_IN_DAY = 86400000;
    public static final int MILLIS_IN_HOUR = 3600000;
    public static final int MILLIS_IN_MINUTE = 60000;
    public static final int MILLIS_IN_SECOND = 1000;
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    private static final int MODIFY_CEILING = 2;
    private static final int MODIFY_ROUND = 1;
    private static final int MODIFY_TRUNCATE = 0;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DateIterator implements Iterator {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return this.spot.clone();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static Date add(Date date, int i3, int i16) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(i3, i16);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date addDays(Date date, int i3) {
        return add(date, 5, i3);
    }

    public static Date addHours(Date date, int i3) {
        return add(date, 11, i3);
    }

    public static Date addMilliseconds(Date date, int i3) {
        return add(date, 14, i3);
    }

    public static Date addMinutes(Date date, int i3) {
        return add(date, 12, i3);
    }

    public static Date addMonths(Date date, int i3) {
        return add(date, 2, i3);
    }

    public static Date addSeconds(Date date, int i3) {
        return add(date, 13, i3);
    }

    public static Date addWeeks(Date date, int i3) {
        return add(date, 3, i3);
    }

    public static Date addYears(Date date, int i3) {
        return add(date, 1, i3);
    }

    public static Date ceiling(Date date, int i3) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            modify(calendar, i3, 2);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    private static long getFragment(Date date, int i3, int i16) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return getFragment(calendar, i3, i16);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragmentInDays(Date date, int i3) {
        return getFragment(date, i3, 6);
    }

    public static long getFragmentInHours(Date date, int i3) {
        return getFragment(date, i3, 11);
    }

    public static long getFragmentInMilliseconds(Date date, int i3) {
        return getFragment(date, i3, 14);
    }

    public static long getFragmentInMinutes(Date date, int i3) {
        return getFragment(date, i3, 12);
    }

    public static long getFragmentInSeconds(Date date, int i3) {
        return getFragment(date, i3, 13);
    }

    private static long getMillisPerUnit(int i3) {
        if (i3 != 5 && i3 != 6) {
            switch (i3) {
                case 11:
                    return 3600000L;
                case 12:
                    return 60000L;
                case 13:
                    return 1000L;
                case 14:
                    return 1L;
                default:
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The unit ");
                    stringBuffer.append(i3);
                    stringBuffer.append(" cannot be represented is milleseconds");
                    throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
        return 86400000L;
    }

    private static int indexOfSignChars(String str, int i3) {
        int indexOf = StringUtils.indexOf(str, '+', i3);
        if (indexOf < 0) {
            return StringUtils.indexOf(str, '-', i3);
        }
        return indexOf;
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date != null && date2 != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            return isSameDay(calendar, calendar2);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return date.getTime() == date2.getTime();
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            if (calendar.get(14) != calendar2.get(14) || calendar.get(13) != calendar2.get(13) || calendar.get(12) != calendar2.get(12) || calendar.get(10) != calendar2.get(10) || calendar.get(6) != calendar2.get(6) || calendar.get(1) != calendar2.get(1) || calendar.get(0) != calendar2.get(0) || calendar.getClass() != calendar2.getClass()) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator iterator(Date date, int i3) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return iterator(calendar, i3);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c1, code lost:
    
        if (r17 == 9) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c3, code lost:
    
        if (r17 == 1001) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c5, code lost:
    
        r7 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f7, code lost:
    
        r4 = false;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f9, code lost:
    
        if (r4 != false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00fb, code lost:
    
        r4 = r16.getActualMinimum(r9[r5][0]);
        r8 = r16.getActualMaximum(r9[r5][0]);
        r11 = r16.get(r9[r5][0]) - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0118, code lost:
    
        if (r11 <= ((r8 - r4) / 2)) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x011a, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011d, code lost:
    
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011c, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x011e, code lost:
    
        if (r11 == 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0120, code lost:
    
        r4 = r9[r5][0];
        r16.set(r4, r16.get(r4) - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012f, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ca, code lost:
    
        if (r10[0] != 5) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00cc, code lost:
    
        r4 = r16.get(5) - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00d1, code lost:
    
        if (r4 < 15) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00d3, code lost:
    
        r4 = r4 - 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00d6, code lost:
    
        if (r4 <= 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d8, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00db, code lost:
    
        r11 = r4;
        r7 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00f5, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00da, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00e2, code lost:
    
        if (r10[0] != 11) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00e4, code lost:
    
        r4 = r16.get(11);
        r7 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ea, code lost:
    
        if (r4 < 12) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00ec, code lost:
    
        r4 = r4 - 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00ef, code lost:
    
        if (r4 < 6) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00f1, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00f4, code lost:
    
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00f3, code lost:
    
        r6 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void modify(Calendar calendar, int i3, int i16) {
        boolean z16;
        if (calendar.get(1) <= 280000000) {
            if (i3 == 14) {
                return;
            }
            Date time = calendar.getTime();
            long time2 = time.getTime();
            int i17 = calendar.get(14);
            if (i16 == 0 || i17 < 500) {
                time2 -= i17;
            }
            if (i3 == 13) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i18 = calendar.get(13);
            if (!z16 && (i16 == 0 || i18 < 30)) {
                time2 -= i18 * 1000;
            }
            if (i3 == 12) {
                z16 = true;
            }
            int i19 = calendar.get(12);
            if (!z16 && (i16 == 0 || i19 < 30)) {
                time2 -= i19 * 60000;
            }
            if (time.getTime() != time2) {
                time.setTime(time2);
                calendar.setTime(time);
            }
            int i26 = 0;
            boolean z17 = false;
            while (i26 < fields.length) {
                int i27 = 0;
                while (true) {
                    int[][] iArr = fields;
                    int[] iArr2 = iArr[i26];
                    if (i27 >= iArr2.length) {
                        break;
                    }
                    if (iArr2[i27] == i3) {
                        if (i16 == 2 || (i16 == 1 && z17)) {
                            if (i3 == 1001) {
                                if (calendar.get(5) == 1) {
                                    calendar.add(5, 15);
                                    return;
                                } else {
                                    calendar.add(5, -15);
                                    calendar.add(2, 1);
                                    return;
                                }
                            }
                            if (i3 == 9) {
                                if (calendar.get(11) == 0) {
                                    calendar.add(11, 12);
                                    return;
                                } else {
                                    calendar.add(11, -12);
                                    calendar.add(5, 1);
                                    return;
                                }
                            }
                            calendar.add(iArr2[0], 1);
                            return;
                        }
                        return;
                    }
                    i27++;
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The field ");
            stringBuffer.append(i3);
            stringBuffer.append(" is not supported");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new ArithmeticException("Calendar value too large for accurate calculations");
    }

    public static Date parseDate(String str, String[] strArr) throws ParseException {
        return parseDateWithLeniency(str, strArr, true);
    }

    public static Date parseDateStrictly(String str, String[] strArr) throws ParseException {
        return parseDateWithLeniency(str, strArr, false);
    }

    private static Date parseDateWithLeniency(String str, String[] strArr, boolean z16) throws ParseException {
        String str2;
        if (str != null && strArr != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.setLenient(z16);
            ParsePosition parsePosition = new ParsePosition(0);
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str3 = strArr[i3];
                if (str3.endsWith("ZZ")) {
                    str3 = str3.substring(0, str3.length() - 1);
                }
                simpleDateFormat.applyPattern(str3);
                parsePosition.setIndex(0);
                if (strArr[i3].endsWith("ZZ")) {
                    int indexOfSignChars = indexOfSignChars(str, 0);
                    str2 = str;
                    while (indexOfSignChars >= 0) {
                        str2 = reformatTimezone(str2, indexOfSignChars);
                        indexOfSignChars = indexOfSignChars(str2, indexOfSignChars + 1);
                    }
                } else {
                    str2 = str;
                }
                Date parse = simpleDateFormat.parse(str2, parsePosition);
                if (parse != null && parsePosition.getIndex() == str2.length()) {
                    return parse;
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to parse the date: ");
            stringBuffer.append(str);
            throw new ParseException(stringBuffer.toString(), -1);
        }
        throw new IllegalArgumentException("Date and Patterns must not be null");
    }

    private static String reformatTimezone(String str, int i3) {
        int i16;
        if (i3 >= 0 && (i16 = i3 + 5) < str.length() && Character.isDigit(str.charAt(i3 + 1)) && Character.isDigit(str.charAt(i3 + 2))) {
            int i17 = i3 + 3;
            if (str.charAt(i17) == ':') {
                int i18 = i3 + 4;
                if (Character.isDigit(str.charAt(i18)) && Character.isDigit(str.charAt(i16))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str.substring(0, i17));
                    stringBuffer.append(str.substring(i18));
                    return stringBuffer.toString();
                }
                return str;
            }
            return str;
        }
        return str;
    }

    public static Date round(Date date, int i3) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            modify(calendar, i3, 1);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    private static Date set(Date date, int i3, int i16) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);
            calendar.setTime(date);
            calendar.set(i3, i16);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date setDays(Date date, int i3) {
        return set(date, 5, i3);
    }

    public static Date setHours(Date date, int i3) {
        return set(date, 11, i3);
    }

    public static Date setMilliseconds(Date date, int i3) {
        return set(date, 14, i3);
    }

    public static Date setMinutes(Date date, int i3) {
        return set(date, 12, i3);
    }

    public static Date setMonths(Date date, int i3) {
        return set(date, 2, i3);
    }

    public static Date setSeconds(Date date, int i3) {
        return set(date, 13, i3);
    }

    public static Date setYears(Date date, int i3) {
        return set(date, 1, i3);
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date truncate(Date date, int i3) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            modify(calendar, i3, 0);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i3) {
        return truncate(calendar, i3).getTime().compareTo(truncate(calendar2, i3).getTime());
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i3) {
        return truncatedCompareTo(calendar, calendar2, i3) == 0;
    }

    public static long getFragmentInDays(Calendar calendar, int i3) {
        return getFragment(calendar, i3, 6);
    }

    public static long getFragmentInHours(Calendar calendar, int i3) {
        return getFragment(calendar, i3, 11);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i3) {
        return getFragment(calendar, i3, 14);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i3) {
        return getFragment(calendar, i3, 12);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i3) {
        return getFragment(calendar, i3, 13);
    }

    public static boolean truncatedEquals(Date date, Date date2, int i3) {
        return truncatedCompareTo(date, date2, i3) == 0;
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.getTime().getTime() == calendar2.getTime().getTime();
    }

    public static int truncatedCompareTo(Date date, Date date2, int i3) {
        return truncate(date, i3).compareTo(truncate(date2, i3));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x002c. Please report as an issue. */
    private static long getFragment(Calendar calendar, int i3, int i16) {
        long j3;
        if (calendar != null) {
            long millisPerUnit = getMillisPerUnit(i16);
            long j16 = 0;
            if (i3 == 1) {
                j3 = (calendar.get(6) * 86400000) / millisPerUnit;
            } else {
                if (i3 == 2) {
                    j3 = (calendar.get(5) * 86400000) / millisPerUnit;
                }
                if (i3 != 1 || i3 == 2 || i3 == 5 || i3 == 6) {
                    j16 += (calendar.get(11) * 3600000) / millisPerUnit;
                } else {
                    switch (i3) {
                        case 11:
                            break;
                        case 12:
                            j16 += (calendar.get(13) * 1000) / millisPerUnit;
                        case 13:
                            return j16 + ((calendar.get(14) * 1) / millisPerUnit);
                        case 14:
                            return j16;
                        default:
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("The fragment ");
                            stringBuffer.append(i3);
                            stringBuffer.append(" is not supported");
                            throw new IllegalArgumentException(stringBuffer.toString());
                    }
                }
                j16 += (calendar.get(12) * 60000) / millisPerUnit;
                j16 += (calendar.get(13) * 1000) / millisPerUnit;
                return j16 + ((calendar.get(14) * 1) / millisPerUnit);
            }
            j16 = 0 + j3;
            if (i3 != 1) {
            }
            j16 += (calendar.get(11) * 3600000) / millisPerUnit;
            j16 += (calendar.get(12) * 60000) / millisPerUnit;
            j16 += (calendar.get(13) * 1000) / millisPerUnit;
            return j16 + ((calendar.get(14) * 1) / millisPerUnit);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[LOOP:0: B:20:0x0078->B:22:0x007e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088 A[LOOP:1: B:24:0x0082->B:26:0x0088, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Iterator iterator(Calendar calendar, int i3) {
        Calendar truncate;
        Calendar truncate2;
        int i16;
        if (calendar != null) {
            int i17 = 2;
            switch (i3) {
                case 1:
                case 2:
                case 3:
                case 4:
                    truncate = truncate(calendar, 5);
                    truncate2 = truncate(calendar, 5);
                    if (i3 != 2) {
                        if (i3 == 3) {
                            i17 = calendar.get(7);
                            i16 = i17 - 1;
                        } else if (i3 != 4) {
                            i17 = 1;
                            i16 = 7;
                        } else {
                            int i18 = calendar.get(7) - 3;
                            i16 = calendar.get(7) + 3;
                            i17 = i18;
                        }
                        if (i17 < 1) {
                            i17 += 7;
                        }
                        if (i17 > 7) {
                            i17 -= 7;
                        }
                        if (i16 < 1) {
                            i16 += 7;
                        }
                        if (i16 > 7) {
                            i16 -= 7;
                        }
                        while (truncate.get(7) != i17) {
                            truncate.add(5, -1);
                        }
                        while (truncate2.get(7) != i16) {
                            truncate2.add(5, 1);
                        }
                        return new DateIterator(truncate, truncate2);
                    }
                    i16 = 1;
                    if (i17 < 1) {
                    }
                    if (i17 > 7) {
                    }
                    if (i16 < 1) {
                    }
                    if (i16 > 7) {
                    }
                    while (truncate.get(7) != i17) {
                    }
                    while (truncate2.get(7) != i16) {
                    }
                    return new DateIterator(truncate, truncate2);
                case 5:
                case 6:
                    Calendar truncate3 = truncate(calendar, 2);
                    Calendar calendar2 = (Calendar) truncate3.clone();
                    calendar2.add(2, 1);
                    calendar2.add(5, -1);
                    if (i3 == 6) {
                        truncate2 = calendar2;
                        truncate = truncate3;
                        i16 = 1;
                        if (i17 < 1) {
                        }
                        if (i17 > 7) {
                        }
                        if (i16 < 1) {
                        }
                        if (i16 > 7) {
                        }
                        while (truncate.get(7) != i17) {
                        }
                        while (truncate2.get(7) != i16) {
                        }
                        return new DateIterator(truncate, truncate2);
                    }
                    i17 = 1;
                    truncate2 = calendar2;
                    truncate = truncate3;
                    i16 = 7;
                    if (i17 < 1) {
                    }
                    if (i17 > 7) {
                    }
                    if (i16 < 1) {
                    }
                    if (i16 > 7) {
                    }
                    while (truncate.get(7) != i17) {
                    }
                    while (truncate2.get(7) != i16) {
                    }
                    return new DateIterator(truncate, truncate2);
                default:
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The range style ");
                    stringBuffer.append(i3);
                    stringBuffer.append(" is not valid.");
                    throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar ceiling(Calendar calendar, int i3) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i3, 2);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar round(Calendar calendar, int i3) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i3, 1);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar truncate(Calendar calendar, int i3) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i3, 0);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static Date ceiling(Object obj, int i3) {
        if (obj != null) {
            if (obj instanceof Date) {
                return ceiling((Date) obj, i3);
            }
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i3).getTime();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find ceiling of for type: ");
            stringBuffer.append(obj.getClass());
            throw new ClassCastException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i3) {
        if (obj != null) {
            if (obj instanceof Date) {
                return round((Date) obj, i3);
            }
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i3).getTime();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not round ");
            stringBuffer.append(obj);
            throw new ClassCastException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Object obj, int i3) {
        if (obj != null) {
            if (obj instanceof Date) {
                return truncate((Date) obj, i3);
            }
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i3).getTime();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not truncate ");
            stringBuffer.append(obj);
            throw new ClassCastException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator iterator(Object obj, int i3) {
        if (obj != null) {
            if (obj instanceof Date) {
                return iterator((Date) obj, i3);
            }
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i3);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not iterate based on ");
            stringBuffer.append(obj);
            throw new ClassCastException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("The date must not be null");
    }
}
