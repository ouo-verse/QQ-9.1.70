package cooperation.qqcircle.report;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Map;
import uq3.g;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportFirstLogin {
    public static String FEED_ID = "feedid";
    public static String FIRST_LOGIN_SOURCE_LOWER_CASE = "first_login_source";
    public static String FIRST_LOGIN_SOURCE_UPPER_CASE = "FIRST_LOGIN_SOURCE";
    public static String FROM_OUTSIDE = "from";
    public static final int H5_PAGE_CONTENT = 10;
    public static final int H5_PAGE_USER = 5;
    public static final int H5_PAG_TAG = 15;
    public static String JUMP_FROM = "key_jump_from";
    public static final int QQTAB_SEARCH = 27;
    public static final int QQ_AIO_CONTENT = 6;
    public static final int QQ_AIO_TAG = 11;
    public static final int QQ_AIO_USER = 1;
    public static final int QQ_GROUP_ROBOT_DETAIL = 30;
    public static final int QQ_GROUP_ROBOT_TAGPAGE = 31;
    public static final int QQ_GROUP_ROBOT_UPDTE = 32;
    public static final int QQ_GROUP_UPDATE = 24;
    public static final int QQ_KANDIAN = 22;
    public static final int QQ_SEARCH = 23;
    public static final int QQ_SEARCH_ICON = 26;
    public static final int QZONE_CONTENT = 7;
    public static final int QZONE_TAG = 12;
    public static final int QZONE_USER = 2;
    public static String SHARE_CATEGORY = "sharecategory";
    public static String SHARE_ENTRANCE = "shareentrance";
    public static String SHARE_ID = "shareuin";
    private static final String TAG = "QCircleReportFirstLogin";
    public static final int TICKET_INVIET = 16;
    public static final int UNKNOWN = 999;
    public static final int WECHAT_AIO_CONTENT = 8;
    public static final int WECHAT_AIO_TAG = 13;
    public static final int WECHAT_AIO_USER = 3;
    public static final int WECHAT_MOMENTS_CONTENT = 9;
    public static final int WECHAT_MOMENTS_TAG = 14;
    public static final int WECHAT_MOMENTS_USER = 4;
    public static final int WEWORLD_ACTIVE_TAB = 19;
    public static final int WEWORLD_AIO_ARK = 20;
    public static final int WEWORLD_MEGPAGE = 18;
    public static final int WEWORLD_PROFILE = 17;
    public static final int WEWORLD_PUB_MSG = 21;
    public static boolean firstEnterQCircle = false;
    private static String mFirstLoginSource = "";

    public static FeedCloudCommon$Entry getFirstLoginEntry() {
        QLog.d(TAG, 1, "getFirstLoginEntry" + mFirstLoginSource);
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set(FIRST_LOGIN_SOURCE_UPPER_CASE);
        feedCloudCommon$Entry.value.set(getFirstLoginSource());
        return feedCloudCommon$Entry;
    }

    public static String getFirstLoginSource() {
        return mFirstLoginSource;
    }

    private static int getLoginSourceWithEntrance(int i3, int i16) {
        if (i16 == 5) {
            return 30;
        }
        if (i16 == 6) {
            return 31;
        }
        if (i16 == 7) {
            return 32;
        }
        return i3;
    }

    private static int getLoginSourceWithJumpInfo(String str, int i3) {
        int i16;
        try {
            i16 = Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "jumpFrom exception:" + e16.toString());
            i16 = 0;
        }
        if (i16 != 3) {
            if (i16 != 4) {
                if (i16 != 5 && i16 != 9) {
                    int i17 = 20;
                    if (i16 != 20) {
                        i17 = 24;
                        if (i16 != 24) {
                            return i3;
                        }
                    }
                    return i17;
                }
                return 17;
            }
            return 18;
        }
        return 19;
    }

    private static int getLoginSourceWithShareInfo(String str, String str2) {
        int i3;
        int i16 = 0;
        try {
            i3 = Integer.parseInt(str);
            try {
                i16 = Integer.parseInt(str2);
            } catch (Exception e16) {
                e = e16;
                QLog.d(TAG, 1, "share exception:" + e.toString());
                int i17 = ((i3 - 1) * 5) + i16;
                if (i3 != 2) {
                }
                return 27;
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
        int i172 = ((i3 - 1) * 5) + i16;
        if ((i3 != 2 || i3 == 3) && i16 == 7) {
            return 27;
        }
        if (i3 == 1 && i16 == 7) {
            return 26;
        }
        if (i16 == 10) {
            return getLoginSourceWithEntrance(i172, i3);
        }
        return i172;
    }

    public static SharedPreferences getSharedPreferences(String str, int i3) {
        boolean z16;
        if (i3 == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        return g.a(str, false, z16);
    }

    private static String parseFirstLoginSource(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        String str = map.get(FIRST_LOGIN_SOURCE_UPPER_CASE);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = map.get(FIRST_LOGIN_SOURCE_LOWER_CASE);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }

    public static void recordFirstLoginSource(Map<String, String> map) {
        int i3;
        int i16;
        String parseFirstLoginSource = parseFirstLoginSource(map);
        mFirstLoginSource = parseFirstLoginSource;
        if (!TextUtils.isEmpty(parseFirstLoginSource)) {
            return;
        }
        String str = map.get(SHARE_CATEGORY);
        String str2 = map.get(SHARE_ENTRANCE);
        String str3 = map.get(JUMP_FROM);
        String str4 = map.get(FROM_OUTSIDE);
        if (str != null && str2 != null) {
            i16 = getLoginSourceWithShareInfo(str, str2);
        } else if (str3 != null) {
            i16 = getLoginSourceWithJumpInfo(str3, 999);
        } else {
            if (str4 != null) {
                try {
                    i3 = Integer.parseInt(str4);
                } catch (Exception e16) {
                    QLog.d(TAG, 1, "fromOutside exception:" + e16.toString());
                    i3 = 0;
                }
                if (i3 == 10) {
                    i16 = 16;
                }
            }
            i16 = 999;
        }
        mFirstLoginSource = i16 + "";
    }

    public void setIsReported(boolean z16) {
        getSharedPreferences("isReported", 0).edit().putString("", Boolean.toString(z16));
    }
}
