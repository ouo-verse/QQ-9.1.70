package lx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g implements s43.b {

    /* renamed from: a, reason: collision with root package name */
    protected volatile JSONObject f415717a;

    @Override // s43.b
    public boolean a(String str) {
        JSONArray optJSONArray;
        AuthorizeConfig.y().u0();
        JSONObject jSONObject = this.f415717a;
        if (QLog.isColorLevel()) {
            QLog.d("WhiteListAuthorizeConfigInjector", 1, "isInWhiteScreenWhiteList is called of domain " + str + " config " + jSONObject);
        }
        if (jSONObject != null && !TextUtils.isEmpty(str) && (optJSONArray = jSONObject.optJSONArray("domains")) != null) {
            for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                if (str.endsWith(optJSONArray.optString(length))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // s43.b
    public boolean b(String str, String str2) {
        return false;
    }

    @Override // s43.b
    public void c(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("WebViewWhiteScreenDomains");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f415717a = optJSONArray.optJSONObject(0);
        }
    }

    @Override // s43.b
    public boolean d() {
        return false;
    }

    @Override // s43.b
    @NonNull
    public String getBusinessName() {
        return "white_list_authorize_config";
    }
}
