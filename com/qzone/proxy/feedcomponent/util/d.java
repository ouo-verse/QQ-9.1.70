package com.qzone.proxy.feedcomponent.util;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellForwardListInfo;
import com.qzone.proxy.feedcomponent.model.CellInterest;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f50900a = "FeedDataCalculateHelper";

    static void b(StringBuilder sb5, String str) {
        sb5.append(str);
    }

    public static String d(CellForwardListInfo cellForwardListInfo, String str, int i3, boolean z16) {
        int i16 = cellForwardListInfo.num;
        ArrayList<User> arrayList = cellForwardListInfo.fwdmans;
        if (arrayList == null || arrayList.size() <= 0 || z16) {
            if (i16 <= 0) {
                return "";
            }
            com.qzone.proxy.feedcomponent.b.e(f50900a, "forward num =" + cellForwardListInfo.num);
            return l(i16) + "\u4eba\u8f6c\u53d1";
        }
        StringBuilder sb5 = new StringBuilder();
        int min = Math.min(arrayList.size(), i3);
        for (int i17 = 0; i17 < min; i17++) {
            User user = arrayList.get(i17);
            if (user != null) {
                if (i17 < min - 1) {
                    sb5.append(h.d(user.uin, user.nickName + str));
                } else {
                    sb5.append(h.d(user.uin, user.nickName));
                }
            }
        }
        if (sb5.length() > 0 && (arrayList.size() != i16 || arrayList.size() > i3)) {
            String str2 = cellForwardListInfo.forwardNumInfoFoldText;
            if (str2 != null && !str2.equals("")) {
                com.qzone.proxy.feedcomponent.b.e(f50900a, "forwardinfo.forwardNumInfoFoldText =" + cellForwardListInfo.forwardNumInfoFoldText);
                b(sb5, " " + cellForwardListInfo.forwardNumInfoFoldText);
            } else if ((arrayList.size() < i16 && arrayList.size() > i3) || ((arrayList.size() < i16 && arrayList.size() <= i3) || (arrayList.size() == i16 && arrayList.size() > i3))) {
                a(sb5, "\u8f6c\u53d1", i16, false);
            }
        }
        return sb5.toString();
    }

    public static String e(CellInterest cellInterest, String str, int i3) {
        int i16 = cellInterest.num;
        ArrayList<User> arrayList = cellInterest.users;
        String str2 = cellInterest.desc;
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            int min = Math.min(arrayList.size(), i3);
            for (int i17 = 0; i17 < min; i17++) {
                User user = arrayList.get(i17);
                if (i17 < min - 1) {
                    sb5.append(g(user.uin, user.nickName + str));
                } else {
                    sb5.append(g(user.uin, user.nickName));
                }
            }
            StringBuilder sb6 = new StringBuilder();
            if (sb5.length() > 0) {
                if (arrayList.size() >= i16 && i16 <= i3) {
                    sb6.append(str2);
                } else {
                    sb6.append("\u7b49");
                    sb6.append(str2);
                }
            }
            return sb6.toString();
        }
        return "";
    }

    public static String f(CellInterest cellInterest, String str, int i3) {
        int i16 = cellInterest.num;
        ArrayList<User> arrayList = cellInterest.users;
        String str2 = cellInterest.desc;
        if (arrayList == null || arrayList.size() <= 0) {
            return str2;
        }
        StringBuilder sb5 = new StringBuilder();
        int min = Math.min(arrayList.size(), i3);
        for (int i17 = 0; i17 < min; i17++) {
            User user = arrayList.get(i17);
            if (i17 < min - 1) {
                sb5.append(g(user.uin, user.nickName + str));
            } else {
                sb5.append(g(user.uin, user.nickName));
            }
        }
        if (sb5.length() > 0) {
            if (arrayList.size() >= i16 && i16 <= i3) {
                sb5.append(str2);
            } else {
                sb5.append("\u7b49");
                sb5.append(str2);
            }
        }
        return sb5.toString();
    }

    public static String h(long j3, String str, int i3) {
        String t16 = t(str, i3);
        try {
            t16 = URLEncoder.encode(t16, "UTF-8");
        } catch (Exception unused) {
        }
        return "<uin:" + j3 + ",nickname:" + t16 + ">";
    }

    private static boolean i(long j3, int i3) {
        return false;
    }

    static boolean k(BusinessFeedData businessFeedData, int i3) {
        return j(businessFeedData.getFeedCommInfo().operatemask, i3);
    }

    public static Pair<CellPictureInfo, Boolean> m(BusinessFeedData businessFeedData) {
        boolean z16;
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        if (businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getPictureInfo() == null) {
            z16 = false;
        } else {
            pictureInfo = businessFeedData.getOriginalInfo().getPictureInfo();
            z16 = true;
        }
        return new Pair<>(pictureInfo, Boolean.valueOf(z16));
    }

    public static int n(String str, int i3) {
        int length = str.length();
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            i16 += Character.charCount(str.codePointAt(i16));
            i17++;
            if (i17 >= i3) {
                return i16;
            }
        }
        return length;
    }

    public static boolean p(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        return calendar.get(2) == calendar2.get(2) && calendar.get(1) == calendar2.get(1);
    }

    public static String t(String str, int i3) {
        if (str == null || str.equals("") || i3 < 1) {
            return "";
        }
        if (str.length() <= i3) {
            return str;
        }
        String s16 = s(str, i3);
        if (s16.length() >= str.length()) {
            return str;
        }
        return s16 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    static void a(StringBuilder sb5, String str, int i3, boolean z16) {
        if (i3 > 10000 && z16) {
            sb5.append(" \u7b49");
            sb5.append(i3 / 10000.0d);
            sb5.append("\u4e07\u4eba" + str);
            return;
        }
        sb5.append(" \u7b49");
        sb5.append(l(i3));
        sb5.append("\u4eba" + str);
    }

    public static String c(CellPictureInfo cellPictureInfo) {
        ArrayList<User> arrayList;
        if (cellPictureInfo != null && (arrayList = cellPictureInfo.facemans) != null && arrayList.size() > 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "\u7167\u7247\u91cc\u6709:");
            for (int i3 = 0; i3 < Math.min(cellPictureInfo.facemans.size(), 30); i3++) {
                User user = cellPictureInfo.facemans.get(i3);
                if (user != null) {
                    if (i3 > 0) {
                        spannableStringBuilder.append((CharSequence) ", ");
                    }
                    spannableStringBuilder.append((CharSequence) h.b(user.uin, user.nickName, false));
                }
            }
            if (cellPictureInfo.faceman_num > Math.min(cellPictureInfo.facemans.size(), 30)) {
                spannableStringBuilder.append((CharSequence) ("\u7b49" + cellPictureInfo.faceman_num + "\u4eba"));
            }
            return spannableStringBuilder.toString();
        }
        return "";
    }

    public static String g(long j3, String str) {
        return h(j3, str, Integer.MAX_VALUE);
    }

    public static boolean q(Activity activity, BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.isFunctionGuideFeed()) {
            return false;
        }
        if (businessFeedData != null && businessFeedData.isFriendAnniversaryFeed()) {
            return false;
        }
        if ((businessFeedData != null && businessFeedData.isDeleteOnTimeFeed()) || businessFeedData == null) {
            return false;
        }
        if (businessFeedData.getFeedCommInfo().feedsType != 0 && 2 != businessFeedData.getFeedCommInfo().feedsType) {
            return false;
        }
        int i3 = businessFeedData.feedType;
        if ((i3 == 4097 || i3 == 3) && com.qzone.adapter.feedcomponent.i.H().j0() == businessFeedData.getUser().uin && !businessFeedData.isFakeFeedSafe()) {
            return businessFeedData.getFeedCommInfo().appid == 311 || businessFeedData.getFeedCommInfo().appid == 4 || businessFeedData.getFeedCommInfo().appid == 2;
        }
        return false;
    }

    public static boolean r(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        if (businessFeedData.hasCustomDropList() || k(businessFeedData, 14) || k(businessFeedData, 13) || k(businessFeedData, 17) || k(businessFeedData, 7) || k(businessFeedData, 24) || k(businessFeedData, 25) || k(businessFeedData, 10) || k(businessFeedData, 21) || k(businessFeedData, 27) || k(businessFeedData, 20)) {
            return true;
        }
        return businessFeedData.hasCustomDropList();
    }

    public static String s(String str, int i3) {
        if (str == null) {
            return null;
        }
        int n3 = n(str, i3);
        return n3 >= str.length() ? str : str.substring(0, n3);
    }

    public static boolean o(PictureItem pictureItem, String str) {
        int indexOf;
        if (pictureItem == null || str == null || str.length() <= 0 || (indexOf = str.indexOf(".com")) == -1) {
            return false;
        }
        int indexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER);
        int indexOf3 = str.indexOf("#");
        if (indexOf2 > indexOf3 && indexOf3 >= 0) {
            indexOf2 = indexOf3;
        }
        if (indexOf2 < 0) {
            indexOf2 = str.length() - 1;
        }
        String substring = str.substring(indexOf, indexOf2);
        String str2 = pictureItem.bigUrl.url;
        if (str2 != null && str2.contains(substring)) {
            return true;
        }
        String str3 = pictureItem.originUrl.url;
        return str3 != null && str3.contains(substring);
    }

    public static String l(int i3) {
        if (i3 >= 10000) {
            return String.format("%.1f\u4e07", Float.valueOf(i3 / 10000.0f));
        }
        return String.valueOf(i3);
    }

    public static boolean j(long j3, int i3) {
        return (((long) (1 << i3)) & j3) != 0 || i(j3, i3);
    }
}
