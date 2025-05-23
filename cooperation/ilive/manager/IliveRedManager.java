package cooperation.ilive.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.ilive.util.d;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class IliveRedManager {
    private static final String TAG = "IliveRedManager";

    public static String getDrawerLiveReportStr2(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.buffer.has() && appInfo.iNewFlag.get() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(appInfo.buffer.get());
                if (jSONObject.has("param")) {
                    return "1";
                }
                if (jSONObject.has("msg")) {
                    return "2";
                }
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        return "3";
    }

    public static Pair<String, String> getIliveRecomRedInfo() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return parseIliveRecomRedInfo(((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(1, String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MY_SHOPPING)));
    }

    public static long getRedAdId(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.buffer.has() && appInfo.iNewFlag.get() != 0) {
            try {
                return new JSONObject(appInfo.buffer.get()).optLong("ad_id");
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return 0L;
            }
        }
        return 0L;
    }

    public static boolean isRecomRedJumpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!d.a(str).containsKey("recom_info")) {
            return false;
        }
        return !TextUtils.isEmpty(r3.get("recom_info"));
    }

    public static Pair<String, String> parseIliveRecomRedInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        JSONObject optJSONObject;
        if (appInfo != null && appInfo.buffer.has() && appInfo.iNewFlag.get() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(appInfo.buffer.get());
                long optLong = jSONObject.optLong("ad_id");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("msg");
                if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(String.valueOf(optLong))) == null) {
                    return null;
                }
                String optString = optJSONObject.optString(QZoneHelper.INTENT_EXTINFO);
                String optString2 = jSONObject.optString("_jump_url");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "parseIliveRecomRedInfo extendInfo = " + optString + " \njson = " + jSONObject.toString());
                }
                return new Pair<>(optString, optString2);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "parseIliveRecomRedInfo exception", e16);
            }
        }
        return null;
    }

    public static String parseShopRedBuffer(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null && appInfo.buffer.has() && appInfo.iNewFlag.get() != 0) {
            try {
                return new JSONObject(appInfo.buffer.get()).optString("_jump_url");
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return null;
            }
        }
        return null;
    }
}
