package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellShare;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellSummary;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellTitle;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRichMsg;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import fj.s;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mk.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0001*\u00020\u0013H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u0013H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0013H\u0002\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0013H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0001*\u0004\u0018\u00010\u0018\u001a\f\u0010\u0019\u001a\u00020\u0001*\u0004\u0018\u00010\u0018\u001a\f\u0010\u001a\u001a\u00020\u0001*\u0004\u0018\u00010\u0018\u001a\f\u0010\u001b\u001a\u00020\u0001*\u0004\u0018\u00010\u0018\u001a\u0014\u0010\u001c\u001a\u00020\u0001*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u001d\u00a8\u0006\u001e"}, d2 = {"formatFullDate", "", QQPermissionConstants.Permission.CALENDAR_GROUP, "Ljava/util/Calendar;", "formatMonthDay", "formatTime", "formatTimestamp", "seconds", "", "isDayBeforeYesterday", "", "cal", "now", "isSameDay", "cal1", "cal2", "isSameYear", "isYesterday", "formatAtRichMsg", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "formatTopicRichMsg", "formatUrlRichMsg", "formatUserRichMsg", "getFeedContentSummary", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "getFeedShareSummary", "getFeedShareTitle", "getFeedTitle", "msgToString", "", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonFeedDataUtilKt {
    private static final String formatAtRichMsg(CommonRichMsg commonRichMsg) {
        String a16 = s.f399470a.a(String.valueOf(commonRichMsg.getUin()), commonRichMsg.getName());
        return "@{uin:" + commonRichMsg.getUin() + ",nick:" + a16 + ",who:" + commonRichMsg.getWho() + "}";
    }

    private static final String formatFullDate(Calendar calendar) {
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT, Locale.getDefault()).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyy-M\u2026()).format(calendar.time)");
        return format;
    }

    private static final String formatMonthDay(Calendar calendar) {
        String format = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"MM-dd \u2026()).format(calendar.time)");
        return format;
    }

    private static final String formatTime(Calendar calendar) {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.getDefault()).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"HH:mm\"\u2026()).format(calendar.time)");
        return format;
    }

    private static final String formatTopicRichMsg(CommonRichMsg commonRichMsg) {
        return "{topic:#" + commonRichMsg.getContent() + ",url:" + commonRichMsg.getUrl() + "}";
    }

    private static final String formatUrlRichMsg(CommonRichMsg commonRichMsg) {
        return "{url:" + h.f416877a.a(commonRichMsg.getUrl(), null) + ",text:" + commonRichMsg.getContent() + "}";
    }

    private static final String formatUserRichMsg(CommonRichMsg commonRichMsg) {
        return "<uin:" + commonRichMsg.getUin() + ",nickname:" + commonRichMsg.getName() + ">";
    }

    public static final String getFeedContentSummary(CommonFeed commonFeed) {
        CommonCellSummary cellSummary;
        List<CommonRichMsg> summary;
        String msgToString;
        return (commonFeed == null || (cellSummary = commonFeed.getCellSummary()) == null || (summary = cellSummary.getSummary()) == null || (msgToString = msgToString(summary)) == null) ? "" : msgToString;
    }

    public static final String getFeedShareSummary(CommonFeed commonFeed) {
        CommonCellShare cellShare;
        List<CommonRichMsg> summary;
        String msgToString;
        return (commonFeed == null || (cellShare = commonFeed.getCellShare()) == null || (summary = cellShare.getSummary()) == null || (msgToString = msgToString(summary)) == null) ? "" : msgToString;
    }

    public static final String getFeedShareTitle(CommonFeed commonFeed) {
        CommonCellShare cellShare;
        List<CommonRichMsg> title;
        String msgToString;
        return (commonFeed == null || (cellShare = commonFeed.getCellShare()) == null || (title = cellShare.getTitle()) == null || (msgToString = msgToString(title)) == null) ? "" : msgToString;
    }

    public static final String getFeedTitle(CommonFeed commonFeed) {
        CommonCellTitle cellTitle;
        List<CommonRichMsg> title;
        String msgToString;
        return (commonFeed == null || (cellTitle = commonFeed.getCellTitle()) == null || (title = cellTitle.getTitle()) == null || (msgToString = msgToString(title)) == null) ? "" : msgToString;
    }

    private static final boolean isDayBeforeYesterday(Calendar calendar, Calendar calendar2) {
        Object clone = calendar2.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar3 = (Calendar) clone;
        calendar3.add(5, -2);
        return isSameDay(calendar, calendar3);
    }

    private static final boolean isYesterday(Calendar calendar, Calendar calendar2) {
        Object clone = calendar2.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar3 = (Calendar) clone;
        calendar3.add(5, -1);
        return isSameDay(calendar, calendar3);
    }

    public static final String msgToString(List<CommonRichMsg> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null) {
            for (CommonRichMsg commonRichMsg : list) {
                Integer type = commonRichMsg != null ? commonRichMsg.getType() : null;
                if (type != null && type.intValue() == 0) {
                    sb5.append(commonRichMsg.getContent());
                } else if (type != null && type.intValue() == 1) {
                    sb5.append(formatAtRichMsg(commonRichMsg));
                } else if (type != null && type.intValue() == 2) {
                    sb5.append(formatUrlRichMsg(commonRichMsg));
                } else if (type != null && type.intValue() == 4) {
                    sb5.append(formatTopicRichMsg(commonRichMsg));
                } else if (type != null && type.intValue() == 5) {
                    sb5.append(formatUserRichMsg(commonRichMsg));
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    private static final boolean isSameDay(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    private static final boolean isSameYear(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1);
    }

    public static final String formatTimestamp(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3 * 1000);
        Calendar now = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "calendar");
        Intrinsics.checkNotNullExpressionValue(now, "now");
        if (isSameDay(calendar, now)) {
            return "\u4eca\u5929" + formatTime(calendar);
        }
        if (isYesterday(calendar, now)) {
            return "\u6628\u5929" + formatTime(calendar);
        }
        if (isDayBeforeYesterday(calendar, now)) {
            return "\u524d\u5929" + formatTime(calendar);
        }
        if (isSameYear(calendar, now)) {
            return formatMonthDay(calendar);
        }
        return formatFullDate(calendar);
    }
}
