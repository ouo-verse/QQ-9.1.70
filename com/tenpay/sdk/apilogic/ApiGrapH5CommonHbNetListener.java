package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.sdk.basebl.UserInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiGrapH5CommonHbNetListener extends ApiNetListener {
    private static final String TAG = "ApiGrapH5CommonHbNetListener";
    private ApiGotoview mApiGotoview;

    public ApiGrapH5CommonHbNetListener(Context context, ResultReceiver resultReceiver, UserInfo userInfo, boolean z16, boolean z17, ApiGotoview apiGotoview) {
        super(context, resultReceiver, userInfo, z16, z17);
        this.mApiGotoview = apiGotoview;
    }

    @Override // com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onError(String str, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("retcode");
            String optString2 = jSONObject.optString("retmsg");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("retcode", optString);
            jSONObject2.put("retmsg", optString2);
            Bundle bundle = new Bundle();
            bundle.putString("grapH5CommonHbResult", jSONObject2.toString());
            this.callback.send(0, bundle);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    @Override // com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        QwLog.i("ApiGrapH5CommonHbNetListener: " + jSONObject);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("send_object");
            if (optJSONObject != null && "1".equals(optJSONObject.optString("native_show"))) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("retcode", jSONObject.optString("retcode"));
                jSONObject2.put("retmsg", jSONObject.optString("retmsg"));
                jSONObject2.put("hb_data", jSONObject);
                Bundle bundle = new Bundle();
                bundle.putString("grapH5CommonHbResult", jSONObject2.toString());
                this.callback.send(0, bundle);
                return;
            }
            if (jSONObject.optInt("state", -1) == 0) {
                this.mApiGotoview.silence_redgiftH5CommonDetail();
                return;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("self_object");
            JSONArray optJSONArray = jSONObject.optJSONArray("recv_array");
            JSONObject jSONObject3 = new JSONObject();
            if (optJSONObject != null) {
                jSONObject3.put("send_object", optJSONObject);
            }
            if (optJSONObject2 != null) {
                jSONObject3.put("self_object", optJSONObject2);
            }
            if (optJSONArray != null) {
                jSONObject3.put("recv_array", optJSONArray);
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("retcode", jSONObject.optString("retcode"));
            jSONObject4.put("retmsg", jSONObject.optString("retmsg"));
            jSONObject4.put("detail", jSONObject3);
            Bundle bundle2 = new Bundle();
            bundle2.putString("grapH5CommonHbResult", jSONObject4.toString());
            this.callback.send(0, bundle2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }
}
