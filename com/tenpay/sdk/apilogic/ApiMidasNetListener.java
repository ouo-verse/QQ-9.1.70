package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.ResultReceiver;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.helper.PayHelper;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiMidasNetListener extends ApiNetListener {
    public ApiMidasNetListener(Context context, ResultReceiver resultReceiver, UserInfo userInfo) {
        super(context, resultReceiver, userInfo, false, false);
    }

    @Override // com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("user_attr", jSONObject.optString("user_attr"));
            jSONObject2.put("balance", jSONObject.optString("balance"));
            jSONObject2.put("bind_banks", jSONObject.optJSONArray("bind_banks"));
            jSONObject2.put("bind_ad_flag", jSONObject.optString("bind_ad_flag"));
            jSONObject2.put("bind_ad_url", jSONObject.optString("bind_ad_url"));
            jSONObject2.put("bind_ad_title", jSONObject.optString("bind_ad_title"));
            this.callback.send(0, PayHelper.createResult(jSONObject2.toString()));
        } catch (Exception e16) {
            this.callback.send(-104, PayHelper.createResultForError(e16.getMessage()));
        }
    }
}
