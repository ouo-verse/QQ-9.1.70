package com.tencent.mobileqq.ecshop.conf;

import androidx.annotation.NonNull;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class EcshopConfProcessor extends BaseConfigParser<EcshopConfBean> {
    static IPatchRedirector $redirector_ = null;
    public static final String CONFIG_ID = "qshopping_common_config";
    private static final String TAG = "EcshopConfProcessor";
    private static final Gson mDefaultGson;
    private static final Gson mGson;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41887);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            mGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            mDefaultGson = new Gson();
        }
    }

    public EcshopConfProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    public EcshopConfBean defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new EcshopConfBean() : (EcshopConfBean) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    public EcshopConfBean parse(@NonNull byte[] bArr) {
        JSONArray optJSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EcshopConfBean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        EcshopConfBean ecshopConfBean = new EcshopConfBean();
        if (bArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr, StandardCharsets.UTF_8));
                ecshopConfBean.jumpType = jSONObject.optInt("jump_type", 1);
                ecshopConfBean.forbidPreloadMsg = jSONObject.optInt("forbid_preload_msg", 0) == 1;
                ecshopConfBean.forbidTransFirstPageData = jSONObject.optInt("forbid_trans_firstpage_data", 0) == 1;
                ecshopConfBean.adClickAreaSwitch = jSONObject.optInt("ad_click_area_switch", 0);
                try {
                    String optString = jSONObject.optString("shake_effect");
                    QLog.d(TAG, 1, "shake effect content: " + optString);
                    EcshopConfBean.ShakeAdEffectBean shakeAdEffectBean = (EcshopConfBean.ShakeAdEffectBean) mGson.fromJson(optString, EcshopConfBean.ShakeAdEffectBean.class);
                    if (shakeAdEffectBean != null) {
                        ecshopConfBean.shakeAdEffectBean = shakeAdEffectBean;
                    }
                } catch (JsonSyntaxException e16) {
                    QLog.e(TAG, 1, "parse: error when parse shake ad effect config", e16);
                }
                try {
                    String optString2 = jSONObject.optString("msgTabPageConfig");
                    f.a(TAG, "msgTabPageConfig content: " + optString2);
                    EcshopConfBean.MsgTabPageConfig msgTabPageConfig = (EcshopConfBean.MsgTabPageConfig) mDefaultGson.fromJson(optString2, EcshopConfBean.MsgTabPageConfig.class);
                    if (msgTabPageConfig != null) {
                        ecshopConfBean.msgTabPageConfig = msgTabPageConfig;
                    }
                } catch (JsonSyntaxException e17) {
                    QLog.d(TAG, 1, "error when parse msgTabPageConfig", e17);
                }
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("forbidJumpThirdAppConfig");
                    if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("rules")) != null) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                            ecshopConfBean.rules.add(new EcshopConfBean.ForbidJumpThirdAppRule(jSONObject2.optString("keyPath"), jSONObject2.optString("value")));
                        }
                    }
                } catch (JSONException e18) {
                    QLog.d(TAG, 1, "error when parse forbidJumpThirdAppConfig", e18);
                }
            } catch (JSONException e19) {
                e19.printStackTrace();
            }
        }
        return ecshopConfBean;
    }
}
