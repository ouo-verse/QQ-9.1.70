package com.heytap.databaseengine.utils;

import com.tencent.image.SafeBitmapFactory;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DateUtil {
    public static final String DATE_FORMAT_12 = "yyyyMMddHHmm";
    public static final String DATE_FORMAT_14 = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_17 = "yyyyMMddHHmmssfff";
    public static final String DATE_FORMAT_6 = "yyyyMM";
    public static final String DATE_FORMAT_8 = "yyyyMMdd";
    public static final String DATE_FORMAT_HOUR = "HH:mm";
    public static final String DATE_FORMAT_MILS = "yyyy-MM-dd HH:mm:ss:sss";
    public static final String DATE_FORMAT_YEAR = "yyyy";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final int HALF_HOUR_IN_MILS = 1800000;
    public static final int HOURS_OF_DAY = 24;
    public static final int MILS_OF_SECOND = 1000;
    public static final int MINUTES_OF_HOURS = 60;
    public static final int MINUTE_IN_MILS = 60000;
    public static final long ONE_DAY = 86400000;
    public static final long ONE_HOUR_IN_MILS = 3600000;
    public static final int SECONDS_OF_MINUTE = 60;
    public static final String TIME_ZONE_0 = "GMT";
    public static final String TIME_ZONE_8 = "GMT+8";
    private static final DateTimeFormatter yyyyMMdd;

    static {
        DateTimeFormatter ofPattern;
        ofPattern = DateTimeFormatter.ofPattern(DATE_FORMAT_8);
        yyyyMMdd = ofPattern;
    }

    public static long addMinutes(long j3, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.add(12, i3);
        return getMinutes(calendar.getTimeInMillis());
    }

    public static Integer adjustGender(Integer num) {
        if (num == null || num.intValue() > 2 || num.intValue() < -1) {
            return -1;
        }
        return num;
    }

    public static int compareDate(String str, String str2, String str3) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(parseDate(str, str3));
        calendar2.setTime(parseDate(str2, str3));
        return calendar.compareTo(calendar2);
    }

    public static long dayToTime(int i3) {
        LocalDate of5;
        LocalTime localTime;
        LocalDateTime of6;
        ZoneId systemDefault;
        ZonedDateTime atZone;
        long epochMilli;
        if (i3 >= 10000000 && i3 <= 100000000) {
            of5 = LocalDate.of(i3 / 10000, (i3 % 10000) / 100, i3 % 100);
            localTime = LocalTime.MIN;
            of6 = LocalDateTime.of(of5, localTime);
            systemDefault = ZoneId.systemDefault();
            atZone = of6.atZone(systemDefault);
            epochMilli = atZone.toInstant().toEpochMilli();
            return epochMilli;
        }
        return 0L;
    }

    public static String formatDate(Date date, String str) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(str, Locale.ENGLISH).format(date);
    }

    public static long getAfterNightEightHour(long j3) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        LocalDateTime withHour;
        LocalDateTime plusDays;
        ZonedDateTime atZone;
        long epochMilli;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MIN;
        of5 = LocalDateTime.of(localDate, localTime);
        withHour = of5.withHour(20);
        plusDays = withHour.plusDays(1L);
        atZone = plusDays.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static int getBeforeDay(long j3, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.add(6, -i3);
        return getDay(calendar.getTimeInMillis());
    }

    public static long getBeforeNightEightHour(long j3) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        LocalDateTime withHour;
        LocalDateTime minusDays;
        ZonedDateTime atZone;
        long epochMilli;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MIN;
        of5 = LocalDateTime.of(localDate, localTime);
        withHour = of5.withHour(20);
        minusDays = withHour.minusDays(1L);
        atZone = minusDays.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static Integer getCurrYear(String str) {
        if (str != null) {
            try {
                if (str.length() > 4) {
                    return Integer.valueOf(Integer.parseInt(str.substring(0, 4)));
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getCurrentDate(String str) {
        LocalDateTime now;
        now = LocalDateTime.now();
        return formatDate(now, str);
    }

    public static long getCurrentMinite(long j3) {
        return j3 - (j3 % 60000);
    }

    public static String getDateBegin(String str, int i3) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(str, DATE_FORMAT_8));
        calendar.add(6, -(i3 - 1));
        return formatDate(calendar.getTime(), DATE_FORMAT_8);
    }

    public static int getDateDuration(String str, String str2) throws ParseException {
        return (int) ((parseDate(str2, DATE_FORMAT_8).getTime() - parseDate(str, DATE_FORMAT_8).getTime()) / 86400000);
    }

    public static String getDateSomeDay(String str, int i3) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(str, DATE_FORMAT_8));
        calendar.add(6, i3);
        return formatDate(calendar.getTime(), DATE_FORMAT_8);
    }

    public static int getDay(long j3) {
        int year;
        int monthValue;
        int dayOfMonth;
        LocalDateTime dayLocalDatedTime = getDayLocalDatedTime(j3);
        year = dayLocalDatedTime.getYear();
        monthValue = dayLocalDatedTime.getMonthValue();
        dayOfMonth = dayLocalDatedTime.getDayOfMonth();
        return (year * 10000) + (monthValue * 100) + dayOfMonth;
    }

    public static int getDayByZone(long j3, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.add(14, ((((i3 / 100) * 3600) * 1000) + (((i3 % 100) * 60) * 1000)) - (calendar.get(15) + calendar.get(16)));
        return getDay(calendar.getTimeInMillis());
    }

    public static LocalDateTime getDayLocalDatedTime(long j3) {
        ZoneId systemDefault;
        Instant ofEpochMilli;
        LocalDateTime ofInstant;
        systemDefault = ZoneId.systemDefault();
        ofEpochMilli = Instant.ofEpochMilli(j3);
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        return ofInstant;
    }

    public static int getDayOfYear(String str) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(DATE_FORMAT_8, Locale.ENGLISH).parse(str));
        return calendar.get(6);
    }

    public static int getDayTime(long j3) {
        ZoneId systemDefault;
        Instant ofEpochMilli;
        LocalDateTime ofInstant;
        String format;
        systemDefault = ZoneId.systemDefault();
        ofEpochMilli = Instant.ofEpochMilli(j3);
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        format = ofInstant.format(yyyyMMdd);
        return parseString2Int(format);
    }

    public static String getEndDate(String str, int i3) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(str, DATE_FORMAT_12));
        calendar.add(12, i3);
        return formatDate(calendar.getTime(), DATE_FORMAT_12);
    }

    public static long getEndSecond(long j3) {
        return (((j3 / 1000) * 1000) + 1000) - 1;
    }

    public static long getEndTime(long j3) {
        ZoneId systemDefault;
        Instant ofEpochMilli;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        ZonedDateTime atZone;
        long epochMilli;
        systemDefault = ZoneId.systemDefault();
        ofEpochMilli = Instant.ofEpochMilli(j3);
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MAX;
        of5 = LocalDateTime.of(localDate, localTime);
        atZone = of5.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static String getFutrueSomeDate(String str, String str2, int i3) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        if (str != null && str.length() > 0) {
            date = parseDate(str, str2);
        }
        calendar.setTime(date);
        calendar.add(6, i3);
        return formatDate(calendar.getTime(), str2);
    }

    public static String getInitSleepStart(String str, String str2) {
        try {
            if (str2.startsWith("-")) {
                str = getPreviousSomeDate(str, DATE_FORMAT_8, 1);
                str2 = str2.substring(1);
            }
            return str + str2;
        } catch (ParseException e16) {
            throw new RuntimeException("parse time failed", e16);
        }
    }

    public static int getIntervalDays(int i3, int i16, String str) throws ParseException {
        return getIntervalDays(Integer.toString(i3), Integer.toString(i16), str);
    }

    public static int getMinutes(String str, String str2) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(str, str2));
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    public static int getMinutesIndex(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return (calendar.get(11) * 24) + calendar.get(12);
    }

    public static int getMonthTotalDay(int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i3 / 100);
        calendar.set(2, (i3 % 100) - 1);
        return calendar.getActualMaximum(5);
    }

    public static int getNextDay(long j3) {
        Calendar calendar = Calendar.getInstance();
        if (j3 > 0) {
            calendar.setTimeInMillis(j3);
        }
        calendar.add(5, 1);
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static long getNextDayTenHour(long j3) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        LocalDateTime withHour;
        LocalDateTime plusDays;
        ZonedDateTime atZone;
        long epochMilli;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MIN;
        of5 = LocalDateTime.of(localDate, localTime);
        withHour = of5.withHour(10);
        plusDays = withHour.plusDays(1L);
        atZone = plusDays.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static long getNextStartTime(long j3) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        LocalDateTime plusDays;
        ZonedDateTime atZone;
        long epochMilli;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MIN;
        of5 = LocalDateTime.of(localDate, localTime);
        plusDays = of5.plusDays(1L);
        atZone = plusDays.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static long getNightSleepEndTime(long j3) {
        long nextDayTenHour;
        if (j3 < getToNightEightHour(j3)) {
            nextDayTenHour = getTodayTenHour(j3);
        } else {
            nextDayTenHour = getNextDayTenHour(j3);
        }
        return nextDayTenHour - 1;
    }

    public static String getNow(long j3) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j3));
    }

    public static int getPercent(int i3, int i16) {
        return (i3 * 100) / i16;
    }

    public static long getPreDayStartTime(long j3) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        LocalDateTime minusDays;
        ZonedDateTime atZone;
        long epochMilli;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MIN;
        of5 = LocalDateTime.of(localDate, localTime);
        minusDays = of5.minusDays(1L);
        atZone = minusDays.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static String getPreviousDate(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(6, -1);
        return formatDate(calendar.getTime(), str);
    }

    public static String getPreviousMonth() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(2, -1);
        return formatDate(calendar.getTime(), DATE_FORMAT_6);
    }

    public static String getPreviousSomeDate(String str, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(6, -i3);
        return formatDate(calendar.getTime(), str);
    }

    public static long getSleepEndTime(long j3) {
        long toNightEightHour = getToNightEightHour(j3);
        if (j3 < toNightEightHour) {
            return toNightEightHour - 1;
        }
        return getAfterNightEightHour(j3) - 1;
    }

    public static long getSleepStartTime(long j3) {
        long toNightEightHour = getToNightEightHour(j3);
        if (j3 >= toNightEightHour) {
            return toNightEightHour;
        }
        return getBeforeNightEightHour(j3);
    }

    public static long getSleepStatTime(long j3) {
        if (j3 < getToNightEightHour(j3)) {
            return getStartTime(j3);
        }
        return getNextStartTime(j3);
    }

    public static int getSomeMonth(int i3, int i16) {
        Calendar calendar = Calendar.getInstance();
        if (i3 > 0) {
            calendar.set(1, i3 / 10000);
            calendar.set(2, (((i3 / 100) % 100) + i16) - 1);
        }
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100);
    }

    public static long getStartSecond(long j3) {
        return (j3 / 1000) * 1000;
    }

    public static long getStartTime(long j3) {
        ZoneId systemDefault;
        Instant ofEpochMilli;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        ZonedDateTime atZone;
        long epochMilli;
        systemDefault = ZoneId.systemDefault();
        ofEpochMilli = Instant.ofEpochMilli(j3);
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MIN;
        of5 = LocalDateTime.of(localDate, localTime);
        atZone = of5.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static int getTimeDiffMinutes(String str, String str2, String str3) throws ParseException {
        return (int) (((parseDate(str2, str3).getTime() - parseDate(str, str3).getTime()) / 1000) / 60);
    }

    public static String getTimeFromTimestamp(long j3) {
        return new SimpleDateFormat(DATE_FORMAT_HOUR).format(Long.valueOf(j3));
    }

    public static int getTimePosition1440(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    public static String getTimeZone(String str) {
        if (str != null && !str.isEmpty()) {
            return str;
        }
        return new SimpleDateFormat("Z").format(Calendar.getInstance().getTime());
    }

    public static String getTimestampToStringDate(long j3, String str) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        DateTimeFormatter ofPattern;
        String format;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        ofPattern = DateTimeFormatter.ofPattern(str);
        format = ofInstant.format(ofPattern);
        return format;
    }

    public static long getToNightEightHour(long j3) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        LocalDateTime withHour;
        ZonedDateTime atZone;
        long epochMilli;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MIN;
        of5 = LocalDateTime.of(localDate, localTime);
        withHour = of5.withHour(20);
        atZone = withHour.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static long getTodayTenHour(long j3) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        LocalDate localDate;
        LocalTime localTime;
        LocalDateTime of5;
        LocalDateTime withHour;
        ZonedDateTime atZone;
        long epochMilli;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        localDate = ofInstant.toLocalDate();
        localTime = LocalTime.MIN;
        of5 = LocalDateTime.of(localDate, localTime);
        withHour = of5.withHour(10);
        atZone = withHour.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static long getTotalMinutesInCurrentDayNow() {
        LocalDateTime now;
        int hour;
        LocalDateTime now2;
        int minute;
        now = LocalDateTime.now();
        hour = now.getHour();
        now2 = LocalDateTime.now();
        minute = now2.getMinute();
        return (hour * 60) + minute + 1;
    }

    public static int getTotalWeekOfYear(String str) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(DATE_FORMAT_8, Locale.ENGLISH).parse(str));
        return calendar.getActualMaximum(3);
    }

    public static int getVaildArraySize(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        int i3 = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                i3++;
            }
        }
        return i3;
    }

    public static int getWeekFirstDay(int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.set(i3 / 10000, ((i3 % 10000) / 100) - 1, i3 % 100);
        calendar.add(5, calendar.getFirstDayOfWeek() - calendar.get(7));
        calendar.set(7, calendar.getFirstDayOfWeek());
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static String getWeekFirstDayByDate(String str, String str2) {
        try {
            Date parseDate = parseDate(str, str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parseDate);
            calendar.add(5, calendar.getFirstDayOfWeek() - calendar.get(7));
            return simpleDateFormat.format(calendar.getTime());
        } catch (ParseException unused) {
            return null;
        }
    }

    public static int getWeekOfYear(String str) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(DATE_FORMAT_8, Locale.ENGLISH).parse(str));
        return calendar.get(3);
    }

    public static int getYearDayNum(String str) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(DATE_FORMAT_8, Locale.ENGLISH).parse(str));
        return calendar.getActualMaximum(6);
    }

    public static int getYearFirstDay(int i3) {
        return ((i3 / 10000) * 10000) + 101;
    }

    public static String getYearMonthDayHalfAnHour(long j3) {
        ZoneId systemDefault;
        Instant ofEpochMilli;
        LocalDateTime ofInstant;
        int minute;
        LocalDateTime withMinute;
        LocalDateTime withSecond;
        LocalDateTime withNano;
        ZonedDateTime atZone;
        long epochMilli;
        LocalDateTime withMinute2;
        LocalDateTime withSecond2;
        LocalDateTime withNano2;
        ZonedDateTime atZone2;
        systemDefault = ZoneId.systemDefault();
        ofEpochMilli = Instant.ofEpochMilli(j3);
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        minute = ofInstant.getMinute();
        if (minute < 30) {
            withMinute2 = ofInstant.withMinute(0);
            withSecond2 = withMinute2.withSecond(0);
            withNano2 = withSecond2.withNano(0);
            atZone2 = withNano2.atZone(systemDefault);
            epochMilli = atZone2.toInstant().toEpochMilli();
        } else {
            withMinute = ofInstant.withMinute(30);
            withSecond = withMinute.withSecond(0);
            withNano = withSecond.withNano(0);
            atZone = withNano.atZone(systemDefault);
            epochMilli = atZone.toInstant().toEpochMilli();
        }
        return String.valueOf(epochMilli);
    }

    public static String getYearMonthDayHour(long j3) {
        return new SimpleDateFormat("yyyyMMddHH", Locale.CHINA).format(new Date(j3));
    }

    public static String getYearMonthDayHourMinute(long j3) {
        return new SimpleDateFormat(DATE_FORMAT_12, Locale.CHINA).format(new Date(j3));
    }

    public static long getYearMonthDayTheNumOfHalfAnHour(long j3) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        LocalDateTime ofInstant;
        DateTimeFormatter ofPattern;
        String format;
        ofEpochMilli = Instant.ofEpochMilli(j3);
        systemDefault = ZoneId.systemDefault();
        ofInstant = LocalDateTime.ofInstant(ofEpochMilli, systemDefault);
        ofPattern = DateTimeFormatter.ofPattern(DATE_FORMAT_12);
        format = ofInstant.format(ofPattern);
        return Long.parseLong(format.substring(0, 8)) + (Long.parseLong(format.substring(8, 10)) * 60) + Long.parseLong(format.substring(10));
    }

    public static boolean isInSameWeek(int i3, int i16) {
        if (getWeekFirstDay(i3) == getWeekFirstDay(i16)) {
            return true;
        }
        return false;
    }

    public static boolean isLinkedDay(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return str.equals(getPreviousSomeDate(str2, DATE_FORMAT_8, 1));
            } catch (ParseException unused) {
                return false;
            }
        }
        if (str == null && str2 != null) {
            return true;
        }
        return false;
    }

    public static boolean isMidNightTime(long j3) {
        long startTime = getStartTime(j3);
        long j16 = 21600000 + startTime;
        if (startTime < j3 && j16 > j3) {
            return true;
        }
        return false;
    }

    public static boolean isNextDay(String str, String str2) throws ParseException {
        if (Integer.valueOf(Integer.parseInt(str)).intValue() <= Integer.valueOf(Integer.parseInt(str2)).intValue()) {
            return true;
        }
        return false;
    }

    public static boolean isNightTime(long j3) {
        long startTime = getStartTime(j3);
        long j16 = startTime - 7200000;
        long j17 = MiniBoxNoticeInfo.HOUR_8 + startTime;
        long j18 = 79200000 + startTime;
        long j19 = startTime + 115200000;
        if (j16 <= j3 && j17 >= j3) {
            return true;
        }
        if (j18 <= j3 && j19 >= j3) {
            return true;
        }
        return false;
    }

    public static boolean isTimeStartEnd(String str, String str2) {
        boolean z16;
        boolean z17;
        int parseInt;
        int parseInt2;
        if (str == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (str2 == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (str != null && str2 != null) {
            try {
                parseInt = Integer.parseInt(str);
                parseInt2 = Integer.parseInt(str2);
            } catch (RuntimeException | Exception unused) {
            }
            if (parseInt2 <= 0 || parseInt >= parseInt2) {
                return false;
            }
            if (parseInt < 0 && parseInt + parseInt2 > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDateStr(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        try {
            Long.parseLong(str);
            parseDate(str, str2);
            return true;
        } catch (ParseException | Exception unused) {
            return false;
        }
    }

    public static boolean isValidSegDateStr(String str, String str2) {
        if (str == null || str.length() < 2 || !isValidDateStr(str, str2) || Integer.parseInt(str.substring(str.length() - 2, str.length())) % 10 != 0) {
            return false;
        }
        return true;
    }

    public static boolean isWeekFirstDay(String str, String str2) {
        return str.equals(getWeekFirstDayByDate(str, str2));
    }

    public static Date parseDate(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(str);
    }

    public static Date parseGMTDate(String str, String str2) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
        return simpleDateFormat.parse(str);
    }

    public static int parseString2Int(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            HLog.e("DateUtil", "parseString2Int e = " + e16.getMessage());
            return -1;
        }
    }

    public static boolean sameDay(long j3, long j16) {
        if (getDay(j3) == getDay(j16)) {
            return true;
        }
        return false;
    }

    public static long second2MinuteMillis(long j3) {
        ZoneId systemDefault;
        Instant ofEpochSecond;
        LocalDateTime ofInstant;
        DateTimeFormatter ofPattern;
        String format;
        DateTimeFormatter ofPattern2;
        LocalDateTime parse;
        ZonedDateTime atZone;
        long epochMilli;
        systemDefault = ZoneId.systemDefault();
        ofEpochSecond = Instant.ofEpochSecond(j3);
        ofInstant = LocalDateTime.ofInstant(ofEpochSecond, systemDefault);
        ofPattern = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm");
        format = ofInstant.format(ofPattern);
        ofPattern2 = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm");
        parse = LocalDateTime.parse(format, ofPattern2);
        atZone = parse.atZone(systemDefault);
        epochMilli = atZone.toInstant().toEpochMilli();
        return epochMilli;
    }

    public static <K, V> Map<K, V> trimNullValue(Map<K, V> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    public static int getIntervalDays(String str, String str2, String str3) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, Locale.ENGLISH);
        return ((int) ((simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime()) / 8.64E7d)) + 1;
    }

    public static String formatDate(LocalDateTime localDateTime, String str) {
        DateTimeFormatter ofPattern;
        String format;
        if (localDateTime == null) {
            localDateTime = LocalDateTime.now();
        }
        ofPattern = DateTimeFormatter.ofPattern(str, Locale.ENGLISH);
        format = ofPattern.format(localDateTime);
        return format;
    }

    public static Date parseDate(String str, String str2) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.parse(str);
    }

    public static long getMinutes(long j3) {
        Calendar.getInstance().setTimeInMillis(j3);
        return (r0.get(1) * SafeBitmapFactory.PX_THRESHOID_DEFAULTS) + ((r0.get(2) + 1) * 1000000) + (r0.get(5) * 10000) + (r0.get(11) * 100) + r0.get(12);
    }

    public static String getPreviousSomeDate(String str, String str2, int i3) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(str, str2));
        calendar.add(6, -i3);
        return formatDate(calendar.getTime(), str2);
    }

    public static int getTimeDiffMinutes(long j3, long j16) {
        return (int) (((j16 - j3) / 1000) / 60);
    }

    public static String formatDate(String str, String str2) throws ParseException {
        return new SimpleDateFormat(str2, Locale.ENGLISH).format(parseDate(str, DATE_FORMAT_14));
    }
}
