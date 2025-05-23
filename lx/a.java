package lx;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements s43.b {

    /* renamed from: a, reason: collision with root package name */
    protected volatile JSONObject f415709a;

    @Override // s43.b
    public boolean a(String str) {
        JSONArray optJSONArray;
        AuthorizeConfig.y().u0();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return false;
        }
        if ("ti.qq.com".equalsIgnoreCase(parse.getHost())) {
            return true;
        }
        String host = parse.getHost();
        JSONObject jSONObject = this.f415709a;
        if (QLog.isColorLevel()) {
            QLog.d("AIOAuthorizeConfigInjector", 1, "WebViewSwitchAio call canSwitchAIO url " + str + " config " + jSONObject);
        }
        if (jSONObject != null && !TextUtils.isEmpty(host) && jSONObject.optInt("enable", 0) == 1 && (optJSONArray = jSONObject.optJSONArray("domains")) != null) {
            for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                if (host.endsWith(optJSONArray.optString(length))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // s43.b
    public boolean b(String str, String str2) {
        return false;
    }

    @Override // s43.b
    public void c(JSONObject jSONObject) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAuthorizeConfigInjector", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return " + jSONObject.toString());
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("WebViewSwitchAioConfig");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f415709a = optJSONArray.optJSONObject(0);
        }
    }

    @Override // s43.b
    public boolean d() {
        if (this.f415709a == null) {
            return true;
        }
        return false;
    }

    @Override // s43.b
    @NonNull
    public String getBusinessName() {
        return "aio_authorize_config";
    }
}
