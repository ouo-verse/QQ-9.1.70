package cooperation.qqcircle.utils;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleHostStubUtil {
    public static final String KEY_GPS_INFO = "key_gps_info";
    public static final String KEY_PARSE_DATA_ERROR_MSG = "key_parse_data_error_msg";
    public static final String KEY_SELECTED_LABEL_ID = "key_selected_label_id";
    public static final String KEY_SELECTED_LABEL_NAME = "key_selected_label_name";
    public static final String KEY_SELECTED_LABEL_RANK = "key_selected_label_rank";
    private static final String TAG = "QCircleHostUtil";

    public static boolean checkOperateMaskEnabled(long j3, int i3) {
        if ((j3 & (1 << i3)) != 0) {
            return true;
        }
        return false;
    }

    public static String fansNumberFormatTranfer(long j3) {
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < 1000000) {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(1);
            decimalFormat.setGroupingSize(0);
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat.format(j3 / 10000.0d) + "w";
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return (j3 / 10000) + "w";
        }
        return "9999w";
    }

    public static AppRuntime getAppRunTime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
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

    public static EntityManager getEntityManager() {
        if (getAppRunTime() != null) {
            return getAppRunTime().getEntityManagerFactory(getAppRunTime().getAccount()).createEntityManager();
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        return waitAppRuntime.getEntityManagerFactory(waitAppRuntime.getAccount()).createEntityManager();
    }

    public static String getMobileResolution() {
        return MobileInfoUtil.getResolution();
    }

    public static int getNightModeColor(int i3) {
        return ((int) ((i3 & 16777215) * 0.6d)) | (-16777216);
    }

    public static String getQQProcessName() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            return mobileQQ.getQQProcessName();
        }
        return "";
    }

    public static String getUrlHost(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean isInNightMode() {
        return QQTheme.isNowThemeIsNight();
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

    public static void setIsUnLockSuccess(boolean z16) {
        QBaseActivity.setIsUnLockSuccess(true);
    }

    public static void setStatusBarColor(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
        window.setNavigationBarColor(i3);
    }
}
