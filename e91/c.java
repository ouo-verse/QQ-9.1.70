package e91;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.n;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements n<String> {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f395958a = new HashMap<>();

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("ArkAIKeyWordSDKShareConfig", 1, "onParse,fileOrRes is null");
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(AppConstants.Preferences.ARK_AI_SDK_SHARE_APP_INFO);
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.get(i3);
                    String string = jSONObject.getString("appID");
                    String string2 = jSONObject.getString("appName");
                    QLog.i("ArkAIKeyWordSDKShareConfig", 1, "onParse ark_ai_keyword_sdk_share_app_info id=" + string + ", name=" + string2);
                    this.f395958a.put(string, string2);
                }
                return;
            }
            QLog.i("ArkAIKeyWordSDKShareConfig", 1, "getArkShareConfig,ark_ai_keyword_sdk_share_app_info is empty");
        } catch (JSONException e16) {
            QLog.e("ArkAIKeyWordSDKShareConfig", 1, "onParse error e = ", e16);
        }
    }
}
