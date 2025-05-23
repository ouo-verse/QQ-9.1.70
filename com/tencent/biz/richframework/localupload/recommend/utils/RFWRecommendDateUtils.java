package com.tencent.biz.richframework.localupload.recommend.utils;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.luggage.wxa.nf.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWRecommendDateUtils {
    private static final SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
    private static final long[] LUNAR_INFO = {19416, 19168, 42352, 21717, 53856, 55632, 21844, 22191, 39632, 21970, 19168, 42422, 42192, 53840, 53845, 46415, 54944, 44450, 38320, 18807, 18815, 42160, 46261, 27216, 27968, 43860, 11119, 38256, 21234, 18800, 25958, 54432, 59984, 27285, 23263, 11104, 34531, 37615, 51415, 51551, 54432, 55462, 46431, 22176, 42420, 9695, 37584, 53938, 43344, 46423, 27808, 46416, 21333, 19887, 42416, 17779, 21183, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 38310, 38335, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 20854, 21183, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 53430, 53855, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 45653, 27951, 44448, 19299, 37759, 18936, 18800, 25776, 26790, 59999, 27424, 42692, 43759, 37600, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 19285, 19311, 42352, 21732, 53856, 59752, 54560, 55968, 27302, 22239, 19168, 43476, 42192, 53584, 62034, 54560};
    private static final String[] LUNAR_HOLIDAY = {"0101 \u6625\u8282", "0115 \u5143\u5bb5\u8282", "0505 \u7aef\u5348\u8282", "0707 \u4e03\u5915\u60c5\u4eba\u8282", "0815 \u4e2d\u79cb\u8282", "0909 \u91cd\u9633\u8282", "1208 \u814a\u516b\u8282", "1223 \u5c0f\u5e74"};
    private static final String[] SOLAR_HOLIDAY = {"0101 \u5143\u65e6\u8282", "0214 \u60c5\u4eba\u8282", "0501 \u52b3\u52a8\u8282", "0601 \u513f\u7ae5\u8282", "0910 \u6559\u5e08\u8282", "1001 \u56fd\u5e86\u8282"};

    public static long convertDayToTimeMillis(int i3) {
        return i3 * 24 * 60 * 60 * 1000;
    }

    public static String getDateTime(long j3) {
        return getDateTime(j3, "yyyy\u5e74MM\u6708dd\u65e5");
    }

    public static String getDayOfWeek(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        switch (calendar.get(7)) {
            case 1:
                return "\u661f\u671f\u65e5";
            case 2:
                return "\u661f\u671f\u4e00";
            case 3:
                return "\u661f\u671f\u4e8c";
            case 4:
                return "\u661f\u671f\u4e09";
            case 5:
                return "\u661f\u671f\u56db";
            case 6:
                return "\u661f\u671f\u4e94";
            case 7:
                return "\u661f\u671f\u516d";
            default:
                return "\u672a\u77e5";
        }
    }

    public static long getDayTimeStamp(String str) {
        try {
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault()).parse(str).getTime();
        } catch (ParseException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static int getDaysOfTwoDate(int i3, int i16, int i17, int i18, int i19, int i26) {
        Date date;
        SimpleDateFormat simpleDateFormat;
        Date date2 = null;
        try {
            simpleDateFormat = chineseDateFormat;
            date = simpleDateFormat.parse(i3 + "\u5e74" + i16 + "\u6708" + i17 + "\u65e5");
        } catch (ParseException e16) {
            e = e16;
            date = null;
        }
        try {
            date2 = simpleDateFormat.parse(i18 + "\u5e74" + i19 + "\u6708" + i26 + "\u65e5");
        } catch (ParseException e17) {
            e = e17;
            e.printStackTrace();
            return date == null ? -1 : -1;
        }
        if (date == null && date2 != null) {
            return (int) ((date2.getTime() - date.getTime()) / 86400000);
        }
    }

    private static String getGregorianHolidays(int i3, int i16) {
        String str;
        String str2;
        StringBuilder sb5;
        String str3;
        for (String str4 : SOLAR_HOLIDAY) {
            if (!TextUtils.isEmpty(str4)) {
                String[] split = str4.split(" ");
                if (split.length <= 0) {
                    str = "";
                } else {
                    str = split[0];
                }
                if (split.length <= 1) {
                    str2 = "";
                } else {
                    str2 = split[1];
                }
                if (i3 < 10) {
                    sb5 = new StringBuilder();
                    sb5.append("0");
                } else {
                    sb5 = new StringBuilder();
                    sb5.append("");
                }
                sb5.append(i3);
                String sb6 = sb5.toString();
                if (i16 < 10) {
                    str3 = "0" + i16;
                } else {
                    str3 = "" + i16;
                }
                if (TextUtils.equals(str, sb6 + str3)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public static String getHolidayName(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(1);
        int i16 = calendar.get(2) + 1;
        int i17 = calendar.get(5);
        int lunarDateINT = getLunarDateINT(i3, i16, i17);
        int i18 = (lunarDateINT % 10000) / 100;
        String lunarHolidays = getLunarHolidays(i18, (lunarDateINT - ((lunarDateINT / 10000) * 10000)) - (i18 * 100));
        if (!TextUtils.isEmpty(lunarHolidays)) {
            return lunarHolidays;
        }
        return getGregorianHolidays(i16, i17);
    }

    public static int getLunarDateINT(int i3, int i16, int i17) {
        int daysOfTwoDate;
        int i18 = 1900;
        if (i3 < 1900 || i3 > 2100 || (daysOfTwoDate = getDaysOfTwoDate(1900, 1, 31, i3, i16, i17)) == -1) {
            return 0;
        }
        int i19 = 0;
        while (i18 < 2100 && daysOfTwoDate > 0) {
            i19 = yearDays(i18);
            daysOfTwoDate -= i19;
            i18++;
        }
        if (daysOfTwoDate < 0) {
            daysOfTwoDate += i19;
            i18--;
        }
        int leapMonth = leapMonth(i18);
        int i26 = 1;
        boolean z16 = false;
        int i27 = 0;
        while (i26 < 13 && daysOfTwoDate > 0) {
            if (leapMonth > 0 && i26 == leapMonth + 1 && !z16) {
                i26--;
                i27 = leapDays(i18);
                z16 = true;
            } else {
                i27 = monthDays(i18, i26);
            }
            if (z16 && i26 == leapMonth + 1) {
                z16 = false;
            }
            daysOfTwoDate -= i27;
            i26++;
        }
        if (daysOfTwoDate == 0 && leapMonth > 0 && i26 == leapMonth + 1 && !z16) {
            i26--;
        }
        if (daysOfTwoDate < 0) {
            daysOfTwoDate += i27;
            i26--;
        }
        return (i18 * 10000) + (i26 * 100) + daysOfTwoDate + 1;
    }

    private static String getLunarHolidays(int i3, int i16) {
        String str;
        String str2;
        StringBuilder sb5;
        String str3;
        for (String str4 : LUNAR_HOLIDAY) {
            if (!TextUtils.isEmpty(str4)) {
                String[] split = str4.split(" ");
                if (split.length <= 0) {
                    str = "";
                } else {
                    str = split[0];
                }
                if (split.length <= 1) {
                    str2 = "";
                } else {
                    str2 = split[1];
                }
                if (i3 < 10) {
                    sb5 = new StringBuilder();
                    sb5.append("0");
                } else {
                    sb5 = new StringBuilder();
                    sb5.append("");
                }
                sb5.append(i3);
                String sb6 = sb5.toString();
                if (i16 < 10) {
                    str3 = "0" + i16;
                } else {
                    str3 = "" + i16;
                }
                if (TextUtils.equals(str, sb6 + str3)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public static String getMonthAndDay(long j3) {
        return getDateTime(j3, "MM\u6708dd\u65e5");
    }

    public static int getYear(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return calendar.get(1);
    }

    public static boolean isDifferentDay(long j3, long j16) {
        Date date = new Date(j3);
        Date date2 = new Date(j16);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int i3 = calendar.get(1);
        int i16 = calendar.get(2);
        int i17 = calendar.get(5);
        int i18 = calendar2.get(1);
        int i19 = calendar2.get(2);
        int i26 = calendar2.get(5);
        if (i3 != i18 || i16 != i19 || i17 != i26) {
            return true;
        }
        return false;
    }

    public static int leapDays(int i3) {
        if (leapMonth(i3) != 0) {
            int i16 = i3 - 1899;
            if (i16 >= 0) {
                long[] jArr = LUNAR_INFO;
                if (i16 < jArr.length && (jArr[i16] & 15) != 0) {
                    return 30;
                }
                return 29;
            }
            return 29;
        }
        return 0;
    }

    public static int leapMonth(int i3) {
        int i16 = i3 - 1900;
        if (i16 >= 0) {
            long[] jArr = LUNAR_INFO;
            if (i16 < jArr.length) {
                long j3 = jArr[i16] & 15;
                if (j3 == 15) {
                    j3 = 0;
                }
                return (int) j3;
            }
            return 0;
        }
        return 0;
    }

    public static int monthDays(int i3, int i16) {
        int i17 = i3 - 1900;
        if (i17 >= 0) {
            long[] jArr = LUNAR_INFO;
            if (i17 < jArr.length) {
                if (((65536 >> i16) & jArr[i17]) == 0) {
                    return 29;
                }
                return 30;
            }
            return 30;
        }
        return 30;
    }

    public static int yearDays(int i3) {
        int i16 = f.b.CTRL_INDEX;
        for (int i17 = 32768; i17 > 8; i17 >>= 1) {
            int i18 = i3 - 1900;
            if (i18 >= 0) {
                long[] jArr = LUNAR_INFO;
                if (i18 < jArr.length && (jArr[i18] & i17) != 0) {
                    i16++;
                }
            }
        }
        return i16 + leapDays(i3);
    }

    public static String getDateTime(long j3, String str) {
        return new SimpleDateFormat(str).format(new Date(j3));
    }

    public static String getMonthAndDay(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 8) {
            return "";
        }
        return str.substring(4, 6) + "\u6708" + str.substring(6, 8) + "\u65e5";
    }
}
