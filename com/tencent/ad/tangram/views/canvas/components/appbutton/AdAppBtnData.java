package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.mobileqq.data.MessageForQQStory;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAppBtnData implements Serializable {
    public String apkUrlhttp;
    public String authorName;
    public volatile int cProgerss;
    public volatile int cState = 0;

    @Nullable
    public String mGdtAdAppId;
    public String name;
    public String packageName;
    public String signatureMd5Molo;
    public String versionName;

    @Nullable
    public String via;

    @Nullable
    public static AdAppBtnData parseJson(@Nullable JSONObject jSONObject) {
        JSONObject jSONObject2;
        AdAppBtnData adAppBtnData;
        AdAppBtnData adAppBtnData2 = null;
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            return null;
        }
        try {
            jSONObject2 = jSONObject.getJSONObject("appData");
            adAppBtnData = new AdAppBtnData();
        } catch (JSONException e16) {
            e = e16;
        }
        try {
            adAppBtnData.apkUrlhttp = jSONObject2.optString("apkUrl");
            adAppBtnData.packageName = jSONObject2.optString("packageName");
            adAppBtnData.name = jSONObject2.optString("name");
            adAppBtnData.signatureMd5Molo = jSONObject2.optString("signatureMd5Molo");
            adAppBtnData.authorName = jSONObject2.optString(MessageForQQStory.KEY_AUTHOR_NAME);
            adAppBtnData.versionName = jSONObject2.optString("versionName");
            return adAppBtnData;
        } catch (JSONException e17) {
            e = e17;
            adAppBtnData2 = adAppBtnData;
            e.printStackTrace();
            return adAppBtnData2;
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.apkUrlhttp);
    }
}
