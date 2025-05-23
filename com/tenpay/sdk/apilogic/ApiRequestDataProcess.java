package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.helper.PayHelper;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.util.WalletGateData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ApiRequestDataProcess extends ApiBaseInterface {
    private static final String TAG = "ApiRequestDataProcess";
    protected Map<String, String> reqMap;

    public ApiRequestDataProcess(Context context, String str, Map<String, String> map, ResultReceiver resultReceiver) {
        super(context, str, null, resultReceiver);
        this.reqMap = map;
    }

    private void qwallet() {
        QwLog.i("qwallet...");
        WalletGateData walletGateData = WalletGateData.getInstance();
        JSONObject data = walletGateData.getData();
        if (data != null && walletGateData.isDataValid() && this.uin.equals(walletGateData.getUin())) {
            Bundle bundle = new Bundle();
            bundle.putString("retmsg", data.toString());
            this.callback.send(0, bundle);
            return;
        }
        boolean isDataCleared = walletGateData.isDataCleared();
        Map map = this.reqMap;
        if (map == null) {
            map = new HashMap();
        }
        HashMap hashMap = new HashMap(map);
        try {
            hashMap.put("uin", this.uin);
            if (isDataCleared) {
                hashMap.put("query_real_data", "1");
            }
        } catch (Exception unused) {
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiQwalletNetListener(context, this.callback, new UserInfo(this.uin, null)));
        tenpayBL.doTask(context, Cgi.URL_WALLET_GATE, hashMap, "", "0", this.uin, true);
    }

    private void touchPayCheck() {
        QwLog.i("touchPayCheck...");
        Bundle bundle = new Bundle();
        bundle.putBoolean("soter_is_open", SharedHelper.soterOpen(this.uin));
        bundle.putString("soter_entry_name", GetSupportSoterNet.sSupportResCache.soter_suggest_title);
        this.callback.send(0, bundle);
    }

    private void watchPayCode() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        QwLog.i("watchPayCode...");
        RequestWatch.getInstance().requestData(context, this.uin, this.reqMap, this.callback);
    }

    public void requestData(String str) {
        QwLog.i("TAG = " + str);
        try {
            getClass().getDeclaredMethod(str, new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            ResultReceiver resultReceiver = this.callback;
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("error, can't get the specified tag:" + str));
            }
        }
    }
}
