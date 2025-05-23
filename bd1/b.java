package bd1;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String f28283b = GameBasicInfo.COMMON_PRE + b.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Map<String, String>> f28284a = new HashMap();

    public static b d(String str) {
        Map<String, String> e16;
        if (QLog.isColorLevel()) {
            QLog.i(f28283b, 2, "[parse] config: " + str);
        }
        b bVar = new b();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("testResult");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    if ("qgame_msgassistant_aio_redpoint".equals(str2)) {
                        Map<String, String> f16 = f(optJSONObject.getJSONObject(str2));
                        if (f16 != null) {
                            bVar.a("qgame_msgassistant_aio_redpoint", f16);
                        }
                    } else if ("qgame_msgassistant_box".equals(str2) && (e16 = e(optJSONObject.getJSONObject(str2))) != null) {
                        bVar.a("qgame_msgassistant_box", e16);
                    }
                }
            }
        } catch (Exception e17) {
            QLog.e(f28283b, 1, e17, new Object[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f28283b, 2, "[parse] result tabConfig: " + bVar);
        }
        return bVar;
    }

    public static Map<String, String> e(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.e(f28283b, 1, "[parseBoxSwitchConfig] jsonObject is null.");
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("resultList");
            if (jSONObject2 == null) {
                return null;
            }
            String optString = jSONObject2.optString("style", "0");
            String optString2 = jSONObject2.optString("grayPolicyId", "0");
            QLog.i(f28283b, 1, "parseBoxSwitchConfig save red style:" + optString + ",id:" + optString2);
            HashMap hashMap = new HashMap();
            hashMap.put("style", optString);
            hashMap.put("grayPolicyId", optString2);
            return hashMap;
        } catch (Exception e16) {
            QLog.e(f28283b, 1, "[parseBoxSwitchConfig] err:", e16);
            return null;
        }
    }

    public static Map<String, String> f(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.e(f28283b, 1, "[parseRedDotConfig] jsonObject is null.");
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("resultList");
            if (jSONObject2 == null) {
                return null;
            }
            String optString = jSONObject2.optString("style", "0");
            String optString2 = jSONObject2.optString("grayPolicyId", "0");
            QLog.i(f28283b, 1, "parseRedDotConfig save red style:" + optString);
            HashMap hashMap = new HashMap();
            hashMap.put("style", optString);
            hashMap.put("grayPolicyId", optString2);
            return hashMap;
        } catch (Exception e16) {
            QLog.e(f28283b, 1, "[parseRedDotConfig] err:", e16);
            return null;
        }
    }

    public static void g(AppInterface appInterface, String str) {
        if (appInterface == null) {
            return;
        }
        try {
            appInterface.getApplication().getSharedPreferences("game_center_sp", 0).edit().putString(appInterface.getCurrentAccountUin() + "sp_key_tab_config", str).commit();
        } catch (Throwable th5) {
            QLog.e(f28283b, 1, th5, new Object[0]);
        }
    }

    public void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            if (this.f28284a == null) {
                this.f28284a = new HashMap();
            }
            this.f28284a.put(str, map);
        }
    }

    public Map<String, String> b() {
        Map<String, Map<String, String>> map = this.f28284a;
        if (map != null && map.size() > 0) {
            return this.f28284a.get("qgame_msgassistant_aio_redpoint");
        }
        return null;
    }

    public Map<String, String> c() {
        Map<String, Map<String, String>> map = this.f28284a;
        if (map != null && map.size() > 0) {
            return this.f28284a.get("qgame_msgassistant_box");
        }
        return null;
    }

    public String toString() {
        return "GameMsgTabConfig{tabConfigs=" + this.f28284a.toString() + '}';
    }
}
