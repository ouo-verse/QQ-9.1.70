package com.tenpay.sdk.helper;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.util.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HttpHelper {
    private static final String TAG = "HttpHelper";
    private ResultReceiver callback;
    private int channel;

    /* renamed from: l, reason: collision with root package name */
    private Net.NetListener f386891l = new Net.NetListener() { // from class: com.tenpay.sdk.helper.HttpHelper.1
        private Map<String, String> getBackData(JSONObject jSONObject) {
            return Utils.jsonToMap(jSONObject);
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onBlError(String str, JSONObject jSONObject) {
            QwLog.i("BLClassName = " + str + " data = " + jSONObject);
            String optString = jSONObject.optString("retcode", "-1");
            HashMap hashMap = new HashMap();
            hashMap.put("retcode", optString);
            hashMap.put("retmsg", jSONObject.optString("retmsg"));
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("returl", jSONObject.optString("returl"));
            } catch (JSONException e16) {
                QLog.e(HttpHelper.TAG, 1, "", e16);
            }
            hashMap.put("data", jSONObject2.toString());
            HttpHelper.this.callback.send(Integer.parseInt(optString), PayHelper.createResult(hashMap));
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onError(String str, JSONObject jSONObject) {
            String optString;
            if (HttpHelper.this.callback == null) {
                QwLog.i("error, callback is null...");
                return;
            }
            if (jSONObject == null) {
                optString = ErrorCode.ERR_STR_DATA_EMPTY;
            } else {
                optString = jSONObject.optString("retmsg");
            }
            HttpHelper.this.callback.send(-102, PayHelper.createResultForError(optString));
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onSuccess(String str, JSONObject jSONObject) {
            QwLog.i("HttpHelper data = " + jSONObject);
            HttpHelper.this.callback.send(jSONObject.optInt("retcode", -1), PayHelper.createResult(getBackData(jSONObject)));
        }
    };
    private String uin;

    public HttpHelper(ResultReceiver resultReceiver, String str, int i3) {
        this.callback = resultReceiver;
        this.uin = str;
        this.channel = i3;
    }

    public void silenceGrapHb(Context context, String str, Bundle bundle) {
        String str2;
        QwLog.i("grap hb start...");
        HashMap<String, String> jsonToMap = Utils.jsonToMap(bundle.getString("extra_data"));
        jsonToMap.put("uin", str);
        jsonToMap.put("senderuin", bundle.getString("senderuin"));
        if (TenpayUtil.getShareBoolean(context, "qb_tenpay_hb_" + str, "agree_wallet_contrace")) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        jsonToMap.put("agreement", str2);
        new Random();
        jsonToMap.put("senderuin", bundle.getString("senderuin"));
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(this.f386891l);
        tenpayBL.doTask(context, Cgi.URI_HB_NA_GRAP, jsonToMap, "", "0", str, true);
    }
}
