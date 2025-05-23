package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tenpay.idverify.IdVerifyModule;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.SDKCallbackManager;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.helper.PayHelper;
import com.tenpay.sdk.util.WalletGateData;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiQwalletIdCardVerifyNetListener extends ApiQwalletNetListener {
    private static final String TAG = "ApiQwalletIdCardVerifyN";
    private RealNameSource realNameSource;

    public ApiQwalletIdCardVerifyNetListener(Context context, ResultReceiver resultReceiver, UserInfo userInfo, RealNameSource realNameSource) {
        super(context, resultReceiver, userInfo);
        this.realNameSource = realNameSource;
    }

    @Override // com.tenpay.sdk.apilogic.ApiQwalletNetListener, com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        boolean z16;
        try {
            String optString = jSONObject.optString("user_attr");
            if (!TextUtils.isEmpty(optString) && !optString.equals("0") && !optString.equals("3")) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.qwallet.utils.g.l("qwallet_is_pws_enter_" + com.tencent.mobileqq.base.a.c(), z16);
            QLog.i(TAG, 1, "hasSetPwd = " + z16);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        if (jSONObject.optInt("name_authing") == 1) {
            Bundle bundle = new Bundle();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("err_msg", jSONObject.optString("name_authing_comment"));
            } catch (JSONException unused) {
            }
            bundle.putString("retmsg", jSONObject2.toString());
            this.callback.send(-11007, bundle);
            return;
        }
        if ((jSONObject.optInt("authen_channel_state") & 1) > 0) {
            this.callback.send(-11005, PayHelper.createResultForError("\u4f60\u5df2\u6210\u529f\u5b8c\u6210\u8eab\u4efd\u9a8c\u8bc1\uff0c\u65e0\u9700\u91cd\u590d\u9a8c\u8bc1\u3002"));
            return;
        }
        WalletGateData.getInstance().setData(this.userInfo.uin, jSONObject, System.currentTimeMillis());
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("uin", this.userInfo.uin);
        intent.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, this.userInfo.nick_name);
        ResultReceiver resultReceiver = this.callback;
        if (resultReceiver != null) {
            intent.putExtra(SDKCallbackManager.SESSION_RECEIVER, resultReceiver);
        }
        intent.putExtra("authen_channel_state", jSONObject.optInt("authen_channel_state"));
        intent.putExtra("user_attr", jSONObject.optInt("user_attr"));
        intent.putExtra("prossesId", System.currentTimeMillis());
        intent.putExtra("no_start_for_result_for_api_go_to_view", true);
        intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, this.realNameSource);
        IdVerifyModule.startFromApiGotoView(this.context, intent);
    }
}
