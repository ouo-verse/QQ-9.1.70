package com.qzone.reborn.feedx.util;

import android.text.TextUtils;
import com.qzone.feed.utils.AlbumRecReporter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class n {
    public static String b(long j3) {
        return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault()).format(new Date(j3));
    }

    public static String f(BusinessFeedData businessFeedData, boolean z16, boolean z17) {
        CellSummary cellSummaryV2;
        String str;
        if (businessFeedData == null) {
            return "";
        }
        if (businessFeedData.isAlbumRecFeed()) {
            AlbumRecReporter.c cVar = businessFeedData.albumRecInfo;
            cellSummaryV2 = new CellSummary();
            if (cVar == null) {
                str = "";
            } else {
                str = cVar.content;
            }
            cellSummaryV2.summary = str;
            cellSummaryV2.actionType = 20;
            cellSummaryV2.displayStr = str;
        } else {
            cellSummaryV2 = businessFeedData.getCellSummaryV2();
        }
        if (!z17 || !z16 || businessFeedData.getTitleInfoV2() == null || TextUtils.isEmpty(businessFeedData.getTitleInfoV2().displayTitle)) {
            if (cellSummaryV2 != null) {
                if (!z16 && z17) {
                    return cellSummaryV2.summary;
                }
                if (!TextUtils.isEmpty(cellSummaryV2.displayStr)) {
                    return cellSummaryV2.displayStr;
                }
                if (!TextUtils.isEmpty(cellSummaryV2.summary)) {
                    return cellSummaryV2.summary;
                }
            }
            return "";
        }
        if (cellSummaryV2 != null && !TextUtils.isEmpty(cellSummaryV2.displayStr)) {
            return businessFeedData.getTitleInfoV2().displayTitle + "\n" + cellSummaryV2.displayStr;
        }
        return businessFeedData.getTitleInfoV2().displayTitle;
    }

    public static String e(BusinessFeedData businessFeedData) {
        return f(businessFeedData, false, false);
    }

    public static String c(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getUser() != null) {
            User user = businessFeedData.getUser();
            if (TextUtils.isEmpty(user.nickName)) {
                return String.valueOf(user.uin);
            }
            return user.nickName;
        }
        return "";
    }

    public static String g(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return "";
        }
        if (TextUtils.isEmpty(businessFeedData.getTimeLbsStr())) {
            businessFeedData.calculateTimeDescription();
        }
        return businessFeedData.getTimeLbsStr();
    }

    public static String d(BusinessFeedData businessFeedData) {
        Map<String, String> map;
        CellFeedCommInfo feedCommInfoV2 = businessFeedData == null ? null : businessFeedData.getFeedCommInfoV2();
        if (feedCommInfoV2 == null || (map = feedCommInfoV2.extendInfo) == null || !map.containsKey("intimate_space_url")) {
            return "";
        }
        return feedCommInfoV2.extendInfo.get("intimate_space_url");
    }

    public static String a(Calendar calendar, Calendar calendar2, boolean z16) {
        if (calendar != null && calendar2 != null) {
            int i3 = calendar.get(1);
            int i16 = calendar.get(2) + 1;
            int i17 = calendar2.get(1);
            int i18 = calendar2.get(2) + 1;
            StringBuilder sb5 = new StringBuilder();
            if (z16) {
                sb5.append(i3);
                sb5.append("\u5e74");
                sb5.append(i16);
                sb5.append("\u6708");
            } else if (i3 == i17) {
                if (i16 - i18 == 1) {
                    sb5.append(i3);
                    sb5.append("\u5e74");
                    sb5.append(i16);
                    sb5.append("\u6708");
                } else if (i18 < 12) {
                    sb5.append(i3);
                    sb5.append("\u5e74");
                    sb5.append(i18 + 1);
                    sb5.append("\u6708~");
                    sb5.append(i16);
                    sb5.append("\u6708");
                } else {
                    sb5.append(i3 + 1);
                    sb5.append("\u5e74");
                    sb5.append(1);
                    sb5.append("\u6708~");
                    sb5.append(i16);
                    sb5.append("\u6708");
                }
            } else if (i18 < 12) {
                sb5.append(i17);
                sb5.append("\u5e74");
                sb5.append(i18 + 1);
                sb5.append("\u6708~");
                sb5.append(i3);
                sb5.append("\u5e74");
                sb5.append(i16);
                sb5.append("\u6708");
            } else {
                sb5.append(i17 + 1);
                sb5.append("\u5e74");
                sb5.append(1);
                sb5.append("\u6708~");
                sb5.append(i3);
                sb5.append("\u5e74");
                sb5.append(i16);
                sb5.append("\u6708");
            }
            return sb5.toString();
        }
        return "";
    }
}
