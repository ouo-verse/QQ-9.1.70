package cooperation.qqcircle.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qzone.PlatformInfor;
import ee2.d;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleCommonUtil {
    public static final String KEY_GPS_INFO = "key_gps_info";
    public static final String KEY_PARSE_DATA_ERROR_MSG = "key_parse_data_error_msg";
    public static final String KEY_SELECTED_LABEL_ID = "key_selected_label_id";
    public static final String KEY_SELECTED_LABEL_NAME = "key_selected_label_name";
    public static final String KEY_SELECTED_LABEL_RANK = "key_selected_label_rank";
    private static final String TAG = "QCircleCommonUtil";

    public static void cancelPermissionManagementReport() {
        d.b(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE);
    }

    public static Bitmap getAvatarBitmap(String str) {
        try {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            return ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface).getBitmapFromCache(1, str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getAvatarBitmap, error ", e16);
            return null;
        }
    }

    public static int getColorFromJSON(JSONObject jSONObject, String str) {
        try {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
                return Color.parseColor(jSONObject.getString(str));
            }
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static String getCurrentAccount() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static long getCurrentAccountLongUin() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
    }

    public static String getDeviceName() {
        return PlatformInfor.getDeviceName();
    }

    public static String getNickName(String str) {
        try {
            return ((IFriendNameService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendNameService.class, "")).getFriendNick(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getNickName, error ", e16);
            return null;
        }
    }

    public static void initPermissionManagementReport() {
        d.a(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE);
    }

    public static boolean isFriend(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG);
        QLog.d(TAG, 1, "[isFriend] uin=" + str + ", uid=" + uidFromUin + ", isFriend=" + isFriend);
        return isFriend;
    }

    public static boolean isInNightMode() {
        boolean isDarkMode = QCircleSkinHelper.getInstance().isDarkMode();
        QLog.d(TAG, 1, "isInNightMode isNight = " + isDarkMode);
        return isDarkMode;
    }

    public static boolean isOwner(String str) {
        return getCurrentAccount().equals(str);
    }

    public static Bundle jsonToLabel(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("selectedLabel");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        arrayList.add(jSONObject.getString("id"));
                        arrayList2.add(jSONObject.getString("name"));
                        arrayList3.add(jSONObject.getString("rank"));
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "jsonToLabel error.", e16);
            bundle.putString("key_parse_data_error_msg", e16.getMessage());
        }
        bundle.putStringArrayList("key_selected_label_id", arrayList);
        bundle.putStringArrayList("key_selected_label_name", arrayList2);
        bundle.putStringArrayList("key_selected_label_rank", arrayList3);
        return bundle;
    }

    public static String labelToJson(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("key_selected_label_id");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("key_selected_label_name");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("key_selected_label_rank");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (stringArrayList != null && stringArrayList2 != null) {
            try {
                if (stringArrayList.size() == stringArrayList2.size() && stringArrayList.size() == stringArrayList3.size()) {
                    for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", stringArrayList.get(i3));
                        jSONObject2.put("name", stringArrayList2.get(i3));
                        jSONObject2.put("rank", stringArrayList3.get(i3));
                        jSONArray.mo162put(jSONObject2);
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "labelToJson error.", e16);
            }
        }
        jSONObject.put("selectedLabel", jSONArray);
        return jSONObject.toString();
    }
}
