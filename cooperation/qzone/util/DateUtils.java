package cooperation.qzone.util;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DateUtils {
    public static final String COLON = ":";
    public static final long DAY_MILLIS_SECOND = 86400000;
    public static final int DAY_SECOND = 86400;
    public static final long TWO_DAY_MILLIS_SECOND = 172800000;
    public static final String JUST_MINS = HardCodeUtil.qqStr(R.string.la8);
    public static final String YESTERDAY = HardCodeUtil.qqStr(R.string.l_f);
    public static final String TODAY = HardCodeUtil.qqStr(R.string.l9x);
    public static final String BEFOREY_YESTERDAY = HardCodeUtil.qqStr(R.string.f171831la0);
    public static final String YEAR = HardCodeUtil.qqStr(R.string.l_7);
    public static final String MONTH = HardCodeUtil.qqStr(R.string.l_1);
    public static final String DAY = HardCodeUtil.qqStr(R.string.f171834la3);
    private static final SimpleDateFormat CHINESE_FORMAT = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5", Locale.CHINA);

    static String doubleD(int i3) {
        if (i3 < 10) {
            return '0' + String.valueOf(i3);
        }
        return String.valueOf(i3);
    }

    public static final String getChineseDayToSecond(long j3) {
        return CHINESE_FORMAT.format(new Date(j3 * 1000));
    }

    public static final String getDisplayTime(long j3, Calendar calendar) {
        long timeInMillis = ((calendar.getTimeInMillis() - (((calendar.get(11) * 60) * 60) * 1000)) - ((calendar.get(12) * 60) * 1000)) - (calendar.get(13) * 1000);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        long timeInMillis2 = calendar.getTimeInMillis() - j3;
        long j16 = timeInMillis - j3;
        int i3 = calendar2.get(11);
        int i16 = calendar2.get(12);
        if (timeInMillis2 >= 0) {
            if (j16 < 0) {
                return TODAY + doubleD(i3) + ":" + doubleD(i16);
            }
            if (j16 >= 0 && j16 < 86400000) {
                return YESTERDAY + doubleD(i3) + ":" + doubleD(i16);
            }
            if (j16 >= 86400000 && j16 <= 172800500) {
                return BEFOREY_YESTERDAY + doubleD(i3) + ":" + doubleD(i16);
            }
        } else if (j16 < 0 && isSameDay(calendar.getTimeInMillis(), j3)) {
            return TODAY + doubleD(i3) + ":" + doubleD(i16);
        }
        int i17 = calendar2.get(1);
        int i18 = calendar2.get(2) + 1;
        int i19 = calendar2.get(5);
        if (calendar.get(1) != i17) {
            return i17 + YEAR + doubleD(i18) + MONTH + doubleD(i19) + DAY + " " + doubleD(i3) + ":" + doubleD(i16);
        }
        return doubleD(i18) + MONTH + doubleD(i19) + DAY + doubleD(i3) + ":" + doubleD(i16);
    }

    public static final String getDisplayTimeForFeedEntry(long j3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        long timeInMillis = calendar.getTimeInMillis();
        long todayTime0 = getTodayTime0(calendar);
        long timeInMillis2 = timeInMillis - calendar2.getTimeInMillis();
        long timeInMillis3 = todayTime0 - calendar2.getTimeInMillis();
        long j16 = timeInMillis2 / 1000;
        if (j16 >= 0 && j16 < 7200) {
            return JUST_MINS;
        }
        if (timeInMillis3 < 0) {
            return TODAY;
        }
        if (timeInMillis3 > 0 && timeInMillis3 < 86400000) {
            return YESTERDAY;
        }
        if (timeInMillis3 >= 86400000 && timeInMillis3 <= 777600000) {
            return ((int) (timeInMillis3 / 86400000)) + HardCodeUtil.qqStr(R.string.l_o);
        }
        return "";
    }

    public static final long getTodayTime0(Calendar calendar) {
        return (((calendar.getTimeInMillis() - (((calendar.get(11) * 60) * 60) * 1000)) - ((calendar.get(12) * 60) * 1000)) - (calendar.get(13) * 1000)) - calendar.get(14);
    }

    public static boolean isSameDay(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }

    public static boolean isSameWeek(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(3) == calendar2.get(3)) {
            return true;
        }
        return false;
    }
}
