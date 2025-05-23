package com.tencent.mobileqq.kandian.base.utils;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u00100\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0002J\u001e\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\rJ\u0018\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0016J\u0018\u00108\u001a\u00020,2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002J\u0018\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0018\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/ReadInJoyTimeUtils;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyTimeUtils;", "()V", "BEFORE", "", "kotlin.jvm.PlatformType", "BEFOREY_YESTERDAY", "COLON", "DAY", "DAYS_AGO", "DAY_MILLIS_SECOND", "", "DAY_SECOND", "", "DIAN", "HOUR", "HOURS_AGO", "getHOURS_AGO", "()Ljava/lang/String;", "JUST_MINS", "getJUST_MINS", "MIN", "MINS_AGO", "getMINS_AGO", "MONTH", "MONTH_AGO", "TAG", "TIME_ZONE_SPACE", "TODAY", "TWO_DAY_MILLIS_SECOND", "TWO_DAY_SECOND", "YEAR", "YEAR_AGO", "YESTERDAY", "getDateTimeString", "secondTime", "getFullTimeString", QQPermissionConstants.Permission.CALENDAR_GROUP, "Ljava/util/Calendar;", "getMMDDTimeString", "ms", "getRelativeDisplayForTime", "timeSecond", "compareToServerTime", "", "getRelativeDisplayTimeString", "getServerTime", "getTimeStringWithMinAndSecond", "getTimeStringWithoutYear", "isInTheLimitDay", "timeAfter", "timeBefore", "limitDay", "isOnTheSameDay", "time1", "time2", "isOnTheSameYear", "isYesterday", "timeToCompare", "nowTime", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ReadInJoyTimeUtils implements IReadInJoyTimeUtils {
    private static final String COLON = ":";
    private static final long DAY_MILLIS_SECOND = 86400000;
    private static final int DAY_SECOND = 86400;
    private static final String TAG = "ReadInJoyTimeUtilsImpl";
    private static final int TIME_ZONE_SPACE = 28800;
    private static final long TWO_DAY_MILLIS_SECOND = 172800000;
    private static final int TWO_DAY_SECOND = 172800;
    public static final ReadInJoyTimeUtils INSTANCE = new ReadInJoyTimeUtils();
    private static final String JUST_MINS = HardCodeUtil.qqStr(R.string.sif);
    private static final String MINS_AGO = HardCodeUtil.qqStr(R.string.sny);
    private static final String HOURS_AGO = HardCodeUtil.qqStr(R.string.sow);
    private static final String TODAY = HardCodeUtil.qqStr(R.string.f172615si0);
    private static final String YESTERDAY = HardCodeUtil.qqStr(R.string.f172620ss1);
    private static final String BEFOREY_YESTERDAY = HardCodeUtil.qqStr(R.string.spa);
    private static final String DAYS_AGO = HardCodeUtil.qqStr(R.string.f172617sl1);
    private static final String MONTH_AGO = HardCodeUtil.qqStr(R.string.siz);
    private static final String YEAR_AGO = HardCodeUtil.qqStr(R.string.sit);
    private static final String HOUR = HardCodeUtil.qqStr(R.string.srf);
    private static final String YEAR = HardCodeUtil.qqStr(R.string.f172619sp2);
    private static final String MONTH = HardCodeUtil.qqStr(R.string.sjc);
    private static final String DAY = HardCodeUtil.qqStr(R.string.sjs);
    private static final String MIN = HardCodeUtil.qqStr(R.string.sjy);
    private static final String BEFORE = HardCodeUtil.qqStr(R.string.sj_);
    private static final String DIAN = HardCodeUtil.qqStr(R.string.snt);

    ReadInJoyTimeUtils() {
    }

    private final long getServerTime() {
        return NetConnInfoCenter.getServerTime();
    }

    private final String getTimeStringWithMinAndSecond(Calendar calendar) {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(calendar.time)");
        return format;
    }

    private final String getTimeStringWithoutYear(Calendar calendar) {
        String format = new SimpleDateFormat("MM-dd HH:mm").format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(calendar.time)");
        return format;
    }

    private final boolean isOnTheSameYear(long time1, long time2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(time2);
        return calendar.get(1) == calendar2.get(1);
    }

    private final boolean isYesterday(long timeToCompare, long nowTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(nowTime);
        calendar.add(6, -1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(timeToCompare);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public String getFullTimeString(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        String format = new SimpleDateFormat("yy-MM-dd HH:mm").format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(calendar.time)");
        return format;
    }

    public final String getHOURS_AGO() {
        return HOURS_AGO;
    }

    public final String getJUST_MINS() {
        return JUST_MINS;
    }

    public final String getMINS_AGO() {
        return MINS_AGO;
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public String getMMDDTimeString(long ms5) {
        String format = new SimpleDateFormat("MM\u6708dd\u65e5").format(Long.valueOf(ms5 * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"MM\u6708dd\u65e5\").format(ms * 1000)");
        return format;
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public String getRelativeDisplayForTime(long timeSecond, boolean compareToServerTime) {
        return getRelativeDisplayTimeString(timeSecond, compareToServerTime);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public boolean isOnTheSameDay(long time1, long time2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(time2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    private final String getRelativeDisplayTimeString(long timeSecond, boolean compareToServerTime) {
        long timeInMillis;
        long j3 = 1000;
        long j16 = timeSecond * j3;
        Calendar nowCalendar = Calendar.getInstance();
        Calendar publishCalendar = Calendar.getInstance();
        if (compareToServerTime) {
            timeInMillis = getServerTime() * j3;
        } else {
            timeInMillis = nowCalendar.getTimeInMillis();
        }
        if (timeInMillis != nowCalendar.getTimeInMillis()) {
            nowCalendar.setTimeInMillis(timeInMillis);
        }
        publishCalendar.setTimeInMillis(j16);
        long j17 = (timeInMillis - j16) / j3;
        Intrinsics.checkNotNullExpressionValue(publishCalendar, "publishCalendar");
        String JUST_MINS2 = getFullTimeString(publishCalendar);
        if (j17 >= 0) {
            if (isOnTheSameDay(j16, timeInMillis)) {
                if (j17 < 60) {
                    JUST_MINS2 = JUST_MINS;
                    Intrinsics.checkNotNullExpressionValue(JUST_MINS2, "JUST_MINS");
                } else if (j17 < 3600) {
                    JUST_MINS2 = (j17 / 60) + MINS_AGO;
                } else if (j17 < 86400) {
                    JUST_MINS2 = (j17 / 3600) + HOURS_AGO;
                }
            } else if (isYesterday(j16, timeInMillis)) {
                JUST_MINS2 = YESTERDAY + " " + getTimeStringWithMinAndSecond(publishCalendar);
            } else if (isOnTheSameYear(j16, timeInMillis)) {
                JUST_MINS2 = getTimeStringWithoutYear(publishCalendar);
            }
        }
        if (QLog.isColorLevel()) {
            Intrinsics.checkNotNullExpressionValue(nowCalendar, "nowCalendar");
            QLog.d(TAG, 2, "getRelativeDisplayTimeString = ", JUST_MINS2, ", now = ", getFullTimeString(nowCalendar), ", publish = ", getFullTimeString(publishCalendar));
        }
        return JUST_MINS2;
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public String getDateTimeString(long secondTime) {
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(secondTime * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyy-MM-dd\").format(date)");
        return format;
    }

    public final boolean isInTheLimitDay(long timeAfter, long timeBefore, int limitDay) {
        return (timeAfter - timeBefore) / 86400000 >= ((long) limitDay);
    }
}
