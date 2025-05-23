package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.basebl.UserInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiHbDetailNetListener extends ApiNetListener {
    private static final String TAG = "ApiHbDetailNetListener";

    public ApiHbDetailNetListener(Context context, ResultReceiver resultReceiver, UserInfo userInfo) {
        super(context, resultReceiver, userInfo, false, false);
    }

    @Override // com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject.has("recv_array")) {
                jSONObject2.put("recv_array", jSONObject.optJSONArray("recv_array"));
            }
            if (jSONObject.has("self_object")) {
                jSONObject2.put("self_object", jSONObject.optJSONObject("self_object"));
            }
            jSONObject2.put("send_object", jSONObject.optJSONObject("send_object"));
            jSONObject2.put("retcode", jSONObject.optString("retcode"));
            jSONObject2.put("retmsg", jSONObject.optString("retmsg"));
            Bundle bundle = new Bundle();
            bundle.putString("detail", jSONObject2.toString());
            this.callback.send(0, bundle);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }
}
