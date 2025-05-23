package lx;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements s43.b {

    /* renamed from: b, reason: collision with root package name */
    protected static final JSONArray f415712b;

    /* renamed from: a, reason: collision with root package name */
    protected volatile JSONObject f415713a;

    static {
        JSONArray jSONArray = new JSONArray();
        f415712b = jSONArray;
        jSONArray.mo162put("com.tencent.qqcomic.aiogift");
        jSONArray.mo162put("com.tencent.gamecenter.hebao");
        jSONArray.mo162put("com.tencent.gamecenter.hebao2020");
    }

    @Override // s43.b
    public boolean a(String str) {
        JSONArray jSONArray;
        if (QLog.isColorLevel()) {
            QLog.i("ArkAuthorizeConfigInjector", 2, "[canShareArkMsg] ArkName: " + str + " ArkShareConfig: " + this.f415713a);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        AuthorizeConfig.y().u0();
        JSONObject jSONObject = this.f415713a;
        if (jSONObject != null) {
            jSONArray = jSONObject.optJSONArray("validArkNames");
        } else {
            jSONArray = null;
        }
        if (jSONObject == null || jSONArray == null) {
            jSONArray = f415712b;
        }
        for (int length = jSONArray.length() - 1; length >= 0; length--) {
            if (str.equals(jSONArray.optString(length))) {
                return true;
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
        JSONArray optJSONArray = jSONObject.optJSONArray("arkShareWhiteList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f415713a = optJSONArray.optJSONObject(0);
        }
    }

    @Override // s43.b
    public boolean d() {
        if (this.f415713a == null) {
            return true;
        }
        return false;
    }

    @Override // s43.b
    @NonNull
    public String getBusinessName() {
        return "ark_authorize_config";
    }
}
