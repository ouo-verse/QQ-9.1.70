package com.tencent.midas.comm;

import android.content.Context;
import android.text.TextUtils;
import com.pay.http.APPluginUrlConf;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.midas.api.APMidasPayAPI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class APIPConfig {
    private static HashMap<String, String> currentEnvIPList = new HashMap<>();

    public static String getDomain(String str) {
        String str2 = currentEnvIPList.get(str);
        if (TextUtils.isEmpty(str2)) {
            if (str.equals(APMidasPayAPI.ENV_DEV)) {
                return APPluginUrlConf.UNIPAY_DEV_DOMAIN;
            }
            if (str.equals("test")) {
                return APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN;
            }
            if (str.equals("release") || !str.equals(APMidasPayAPI.ENV_TESTING)) {
                return "api.unipay.qq.com";
            }
            return APPluginUrlConf.UNIPAY_TESTING_DOMAIN;
        }
        return str2;
    }

    private static String getFromAssets(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open("IPMappingInfo.json")));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = str + readLine;
                } else {
                    return str;
                }
            }
        } catch (Exception e16) {
            APLog.e("APIPConfig", "Loading ip mapping file, file is null!");
            e16.printStackTrace();
            return null;
        }
    }

    public static void loadIPMappingFile(Context context) {
        JSONObject jSONObject;
        if (context == null) {
            APLog.e("APIPConfig", "Loading ip mapping file, context null!");
            return;
        }
        String fromAssets = getFromAssets(context);
        if (TextUtils.isEmpty(fromAssets)) {
            APLog.e("APIPConfig", "Loading ip mapping file, got empty json!");
            return;
        }
        try {
            jSONObject = new JSONObject(fromAssets);
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            APLog.e("APIPConfig", "Loading ip mapping file, exception json!");
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("info");
        if (optJSONArray == null) {
            APLog.e("APIPConfig", "Loading ip mapping file, json no info!");
            return;
        }
        int length = optJSONArray.length();
        if (length == 0) {
            APLog.e("APIPConfig", "Loading ip mapping file, json info length 0!");
            return;
        }
        for (int i3 = 0; i3 < length; i3++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                currentEnvIPList.put(jSONObject2.optString(MosaicConstants$JsProperty.PROP_ENV), jSONObject2.optString("domain"));
            } catch (JSONException e17) {
                e17.printStackTrace();
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
    }
}
