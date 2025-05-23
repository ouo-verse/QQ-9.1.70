package cooperation.qzone.report.lp;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneLoginReportHelper {
    public static final String KEY_LOGIN_FROM_MQQ = "login_from_mqq";
    public static final String KEY_TO_UIN = "to_uin";
    public static final int LOGIN_FROM_ACTIVATE_FRIEND = 24;
    public static final int LOGIN_FROM_AIO_FEED_CARD = 3;
    public static final int LOGIN_FROM_AIO_SHARE = 4;
    public static final int LOGIN_FROM_AI_ELIMINATE = 67;
    public static final int LOGIN_FROM_FRIEND_PROFILE = 2;
    public static final int LOGIN_FROM_GROUP_ALBUM_NATIVE = 46;
    public static final int LOGIN_FROM_INTIMATE_SPACE = 36;
    public static final int LOGIN_FROM_LEBA_TAB = 1;
    public static final int LOGIN_FROM_MQQ_AIO = 26;
    public static final int LOGIN_FROM_MQQ_PUSH = 13;
    public static final int LOGIN_FROM_MQQ_SEARCH = 12;
    public static final int LOGIN_FROM_MY_ALBUM = 5;
    public static final int LOGIN_FROM_MY_FAV = 6;
    public static final int LOGIN_FROM_PUBLIC_ACCOUNT = 16;
    public static final int LOGIN_FROM_PUBLIC_ACCOUNT_BTM_MY_ALBUM = 11;
    public static final int LOGIN_FROM_PUBLIC_ACCOUNT_BTM_VIEW_FRIEND_FEEDS = 10;
    public static final int LOGIN_FROM_PUBLIC_ACCOUNT_OTHER_MSG = 8;
    public static final int LOGIN_FROM_PUBLIC_ACCOUNT_VIEW_FRIEND_FEEDS_MSG = 9;
    public static final int LOGIN_FROM_QAV = 28;
    public static final int LOGIN_FROM_QQ_ADD_FRIEND = 42;
    public static final int LOGIN_FROM_QUN_ALBUM = 14;
    public static final int LOGIN_FROM_QZONE_FRIEND_DEFAULT = 43;
    public static final int LOGIN_FROM_QZONE_PROFILE_DEFAULT = 44;
    public static final int LOGIN_FROM_SCHEMA = 33;
    public static final int LOGIN_FROM_SIMPLE_MODE = 27;
    public static final int LOGIN_FROM_THIRD_PARTY_SHARE_FORWARD = 59;
    public static final int LOGIN_FROM_THIRD_PARTY_SHARE_PUBLISH = 60;
    public static final int LOGIN_FROM_USERHOME_FORBIDDEN_PAGE = 39;
    public static final int PA_TYPE_BTM_VIEW_FRIEND_FEEDS = 11;
    public static final int PA_TYPE_BTM_VIEW_MY_ALBUM = 12;
    public static final int PA_TYPE_VIEW_FRIEND_FEEDS_MSG = 8;
    public static final String SCHEME_AROUSE_INTIMATE_SPACE = "mqzone://arouse/intimate/";
    public static final String TAG = "QZoneLoginReportHelper";

    public static void addLoginInfo(Intent intent, int i3) {
        addLoginInfo(intent, i3, "");
    }

    public static void handleLoginFromIntent(Intent intent) {
        int detectLoginFromInIntent;
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(KEY_LOGIN_FROM_MQQ, 0);
        String stringExtra = intent.getStringExtra("to_uin");
        QLog.i(TAG, 1, "handleLoginFromIntent: " + intExtra);
        if (intExtra == 0 && (detectLoginFromInIntent = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).detectLoginFromInIntent(intent)) != 0) {
            QLog.i(TAG, 1, "handleLoginFromIntent,detectLoginFromInIntent:" + detectLoginFromInIntent);
            QZoneDTLoginReporter.daTongLoginReport(detectLoginFromInIntent, stringExtra);
        }
    }

    public static void handleLoginToMyAlbum(Intent intent, int i3) {
        if (intent != null && i3 > 0) {
            if (i3 != 5) {
                if (i3 == 12) {
                    setLoginFromSearch(intent);
                    return;
                }
                return;
            }
            setLoginFromMyAlbum(intent);
        }
    }

    public static boolean needAddLoginFromAIOFeedCard(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            return str.equals(QZoneHelper.QZoneAppConstants.REFER_QQ_CHAT_QZONE_NEWEST_FEED);
        }
        return false;
    }

    public static boolean needAddLoginFromAIOFeedShare(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            return str.equals("mqqChat");
        }
        return false;
    }

    public static boolean needAddLoginFromFriendProfile(Intent intent, String str, int i3) {
        if (intent == null || TextUtils.isEmpty(str) || i3 != 5) {
            return false;
        }
        return true;
    }

    public static boolean needAddLoginFromLebaTab(Intent intent, String str) {
        boolean z16;
        if (intent == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith("QZoneFriendFeedActivity") && !str.endsWith("QZoneFriendFeedxActivity")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!str.startsWith("com.qzone") || !z16) {
            return false;
        }
        return true;
    }

    public static boolean needAddLoginFromQunAlbum(Intent intent, int i3) {
        if (intent == null || i3 != ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getChatSettingForTroopQZONEPHOTOCode()) {
            return false;
        }
        return true;
    }

    public static void reportLoginFromAIEliminate() {
        reportLpDaTongByLoginFrom(67);
    }

    public static void reportLoginFromActivateFriend() {
        reportLpDaTongByLoginFrom(24);
    }

    public static void reportLoginFromFriendProfile(String str) {
        QZoneDTLoginReporter.daTongLoginReport(2, str);
    }

    public static void reportLoginFromGroupAlbum(String str) {
        reportLpDaTongByLoginFrom(46, str, "");
    }

    public static void reportLoginFromIntimateSpace() {
        reportLpDaTongByLoginFrom(36);
    }

    public static void reportLoginFromMQQPublicAccount(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt <= 0) {
                return;
            }
            int i3 = 8;
            if (parseInt != 8) {
                if (parseInt != 11) {
                    if (parseInt == 12) {
                        i3 = 11;
                    }
                } else {
                    i3 = 10;
                }
            } else {
                i3 = 9;
            }
            reportLpDaTongByLoginFrom(i3);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public static void reportLoginFromMQQPush() {
        reportLpDaTongByLoginFrom(13);
    }

    public static void reportLoginFromMQQSearchH5() {
        reportLpDaTongByLoginFrom(12);
    }

    public static void reportLoginFromQQAddFriend(String str) {
        QZoneDTLoginReporter.daTongLoginReport(42, str);
    }

    public static void reportLoginFromQQAio() {
        reportLpDaTongByLoginFrom(26);
    }

    public static void reportLoginFromQZoneMsgBox() {
        reportLpDaTongByLoginFrom(16);
    }

    public static void reportLoginFromQunAlbum() {
        reportLpDaTongByLoginFrom(14);
    }

    public static void reportLoginFromSchema(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith(SCHEME_AROUSE_INTIMATE_SPACE)) {
            String str2 = "";
            int i3 = 0;
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("loginfrom");
                String queryParameter2 = parse.getQueryParameter("uin");
                if (!TextUtils.isEmpty(queryParameter)) {
                    i3 = Integer.parseInt(queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    str2 = queryParameter2;
                }
                new JSONObject().put(QZoneDTLoginReporter.SCHEMA, str);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "parse loginfrom error" + e16);
            }
            if (i3 != 0) {
                QZoneDTLoginReporter.daTongLoginReport(i3, str, str2);
            } else {
                QZoneDTLoginReporter.daTongLoginReport(33, str, str2);
            }
        }
    }

    public static void reportLoginFromSimpleMode() {
        reportLpDaTongByLoginFrom(27);
    }

    public static void reportLoginFromThirdPartyShare(long j3, String str) {
        QZoneDTLoginReporter.daTongLoginReport(59, j3, str);
    }

    public static void reportLoginFromThirdSharePublish(long j3, String str) {
        QZoneDTLoginReporter.daTongLoginReport(60, j3, str);
    }

    public static void reportLoginFromUserHomeForbiddenPage() {
        reportLpDaTongByLoginFrom(39);
    }

    private static void reportLpDaTongByLoginFrom(int i3) {
        reportLpDaTongByLoginFrom(i3, "", "");
    }

    public static void setLoginFromAIOFeedCard(Intent intent, String str) {
        addLoginInfo(intent, 3, str);
    }

    public static void setLoginFromAIOFeedShare(Intent intent) {
        addLoginInfo(intent, 4);
    }

    public static void setLoginFromFriendProfile(Intent intent, String str) {
        addLoginInfo(intent, 2, str);
    }

    public static void setLoginFromLebaTab(Intent intent) {
        addLoginInfo(intent, 1);
    }

    public static void setLoginFromMyAlbum(Intent intent) {
        addLoginInfo(intent, 5);
    }

    public static void setLoginFromMyFav(Intent intent) {
        addLoginInfo(intent, 6);
    }

    public static void setLoginFromQAV(Intent intent) {
        addLoginInfo(intent, 28);
    }

    public static void setLoginFromSearch(Intent intent) {
        addLoginInfo(intent, 12);
    }

    private static void addLoginInfo(Intent intent, int i3, String str) {
        if (intent == null || i3 <= 0) {
            return;
        }
        intent.putExtra(KEY_LOGIN_FROM_MQQ, i3);
        intent.putExtra("to_uin", str);
        QZoneDTLoginReporter.daTongLoginReport(i3, str);
    }

    private static void reportLpDaTongByLoginFrom(int i3, String str, String str2) {
        QZoneDTLoginReporter.daTongLoginReport(i3, str, str2);
    }
}
