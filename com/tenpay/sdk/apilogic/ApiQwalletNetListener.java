package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.util.ConfigUtil;
import com.tenpay.sdk.util.WalletGateData;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiQwalletNetListener extends ApiNetListener {
    public ApiQwalletNetListener(Context context, ResultReceiver resultReceiver, UserInfo userInfo) {
        super(context, resultReceiver, userInfo, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSuccess$0(JSONObject jSONObject) {
        ConfigUtil.saveUserInfoExtend(this.userInfo.uin, jSONObject);
    }

    @Override // com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, final JSONObject jSONObject) {
        if (jSONObject != null) {
            WalletGateData.getInstance().setData(this.userInfo.uin, jSONObject, System.currentTimeMillis());
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.apilogic.c
                @Override // java.lang.Runnable
                public final void run() {
                    ApiQwalletNetListener.this.lambda$onSuccess$0(jSONObject);
                }
            }, 64, null, false);
            Bundle bundle = new Bundle();
            bundle.putString("retmsg", jSONObject.toString());
            new ApiConfigGet(this.context, this.userInfo).checkCacheVersion(jSONObject.optString("interf_cache_ver"));
            this.callback.send(0, bundle);
        }
    }
}
