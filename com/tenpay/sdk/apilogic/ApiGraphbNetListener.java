package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.basebl.UserInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiGraphbNetListener extends ApiNetListener {
    private static final String TAG = "ApiGraphbNetListener";

    public ApiGraphbNetListener(Context context, ResultReceiver resultReceiver, UserInfo userInfo) {
        super(context, resultReceiver, userInfo, false, false);
    }

    @Override // com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        try {
            Bundle bundle = new Bundle();
            String optString = jSONObject.optString("state");
            if (optString.equals("0")) {
                bundle.putString("amount", new JSONObject(jSONObject.optString("recv_object")).optString("amount"));
            }
            bundle.putString("state", optString);
            this.callback.send(0, bundle);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }
}
