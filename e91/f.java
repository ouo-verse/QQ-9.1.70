package e91;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {
    public static boolean a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            QLog.e("DialogConfig", 1, "getArkBoolConfig, dictConfigJsonString is empty");
            return false;
        }
        String optString = jSONObject.optString(str);
        if (!TextUtils.isEmpty(optString)) {
            QLog.i("DialogConfig", 1, String.format("getArkBoolConfig, " + str + "=%s", optString));
            return optString.equals("true");
        }
        QLog.i("DialogConfig", 1, "getArkBoolConfig, " + str + " is empty");
        return false;
    }

    public static String b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            QLog.e("DialogConfig", 1, "getArkStringConfig, json is empty");
            return "";
        }
        String optString = jSONObject.optString(str);
        if (!TextUtils.isEmpty(optString)) {
            QLog.i("DialogConfig", 1, String.format("getArkStringConfig, " + str + "=%s", optString));
            return optString;
        }
        QLog.i("DialogConfig", 1, "getArkStringConfig, " + str + " is empty");
        return "";
    }
}
