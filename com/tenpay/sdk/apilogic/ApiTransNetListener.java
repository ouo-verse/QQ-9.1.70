package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleConstants;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.activity.PayActivity;
import com.tenpay.sdk.basebl.UserInfo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiTransNetListener extends ApiNetListener {
    private static final String TAG = "ApiTransNetListener";
    private JSONObject ejson;
    private Intent intent;
    private HashMap<String, String> netData;

    public ApiTransNetListener(Context context, Intent intent, ResultReceiver resultReceiver, HashMap<String, String> hashMap, JSONObject jSONObject, UserInfo userInfo) {
        super(context, resultReceiver, userInfo, false, false);
        this.intent = intent;
        this.netData = hashMap;
        this.ejson = jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean startPayeeConfirmDlg(final Context context, String str, final Intent intent, final ResultReceiver resultReceiver) {
        int i3;
        String str2;
        JSONObject jSONObject;
        String str3 = null;
        try {
            jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("getpayee_type", 0);
        } catch (Exception unused) {
            i3 = 0;
        }
        try {
            str2 = jSONObject.optString("payee_uin");
            try {
                str3 = jSONObject.optString("payee_nick");
                if (str2 == null) {
                    return false;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            str2 = null;
            if (i3 == 1) {
            }
        }
        if (i3 == 1) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (str3 != null) {
            stringBuffer.append(context.getString(R.string.eew));
            stringBuffer.append(str3);
            stringBuffer.append("(");
            stringBuffer.append(str2);
            stringBuffer.append(")");
        } else {
            stringBuffer.append(str2);
        }
        QUIProxy.createCustomDialog(context, 230, null, stringBuffer.toString(), context.getString(R.string.cancel), context.getString(R.string.eep), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.apilogic.ApiTransNetListener.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i16) {
                com.tencent.mobileqq.base.c.d(context, intent, PayActivity.class);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.apilogic.ApiTransNetListener.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i16) {
                resultReceiver.send(-1, new Bundle());
            }
        });
        return true;
    }

    @Override // com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        dismissLoading();
        if (jSONObject != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("transMap", this.netData);
            this.intent.putExtra(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA, bundle);
            this.intent.putExtra("token_id", jSONObject.optString("token_id"));
            this.intent.putExtra("come_from", this.ejson.optInt("ComeFrom"));
            this.intent.putExtra("h5_success", this.ejson.optBoolean("h5_success", false));
            this.intent.putExtra("exec_code", jSONObject.optString("exec_code"));
            String optString = this.ejson.optString("transPay_data");
            if (optString != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    int optInt = jSONObject.optInt("is_confirm");
                    if (optInt == 1) {
                        this.intent.putExtra("is_callback", optInt);
                        this.intent.putExtra("fromPage", jSONObject2.getString("fromPage"));
                    }
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "", e16);
                }
            }
            if (optString != null && startPayeeConfirmDlg(this.context, optString, this.intent, this.callback)) {
                return;
            }
            com.tencent.mobileqq.base.c.d(this.context, this.intent, PayActivity.class);
        }
    }
}
