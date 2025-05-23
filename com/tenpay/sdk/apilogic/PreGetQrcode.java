package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.ndk.CertUtil;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.util.QrcodePaySetting;
import com.tenpay.util.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PreGetQrcode {

    /* renamed from: cn, reason: collision with root package name */
    private String f386828cn = "";
    private Context mContext;
    private String muin;

    public PreGetQrcode(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void codeGenReq(Map<String, String> map, ResultReceiver resultReceiver) {
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new Net.NetAdapter(resultReceiver) { // from class: com.tenpay.sdk.apilogic.PreGetQrcode.2
            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onBlError(String str, JSONObject jSONObject) {
                super.onBlError(str, jSONObject);
                QwLog.i("error callback = " + jSONObject.toString());
                ResultReceiver resultReceiver2 = this.callback;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(-1, new Bundle());
                }
            }

            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onSuccess(String str, JSONObject jSONObject) {
                super.onSuccess(str, jSONObject);
                QrcodePaySetting.prepare(PreGetQrcode.this.mContext, PreGetQrcode.this.muin);
                QrcodePaySetting.putBoolean("qrcode_bindcard_refresh", false);
                QrcodePaySetting.putString("qrcode_pay_tokenmd5", jSONObject.optString("token_md5"));
                QrcodePaySetting.putString("qrcode_pay_types", jSONObject.optString("pay_desc"));
                QrcodePaySetting.putString("qrcode_code_prefix", jSONObject.optString("code_prefix"));
                QrcodePaySetting.putInt("forbid_watch", jSONObject.optInt("forbid_watch"));
                QrcodePaySetting.commit();
                CertUtil.getInstance(PreGetQrcode.this.mContext).setTokens(PreGetQrcode.this.f386828cn, jSONObject.optString("token"));
                ResultReceiver resultReceiver2 = this.callback;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, new Bundle());
                }
            }
        });
        tenpayBL.doTask(this.mContext, Cgi.URI_CODE_PAY_CODE_GEN, map, null, "2", this.muin, true);
    }

    public boolean initInfo(String str, boolean z16) {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        this.muin = str;
        QrcodePaySetting.prepare(context, str);
        String string = QrcodePaySetting.getString("qrcode_pay_cid", "");
        this.f386828cn = string;
        if (!TextUtils.isEmpty(string) && CertUtil.getInstance(this.mContext).isCertExist(this.f386828cn)) {
            if (z16) {
                return true;
            }
            int tokenCount = CertUtil.getInstance(this.mContext).getTokenCount(this.f386828cn);
            QwLog.i("tokenCount = " + tokenCount);
            if (tokenCount > 2) {
                return false;
            }
            return true;
        }
        QwLog.i("no valid cid");
        return false;
    }

    public void preCodeStart(Map<String, String> map, ResultReceiver resultReceiver) {
        QwLog.i("pew code gen start...");
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new Net.NetAdapter(resultReceiver) { // from class: com.tenpay.sdk.apilogic.PreGetQrcode.1
            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onBlError(String str, JSONObject jSONObject) {
                super.onBlError(str, jSONObject);
                QwLog.i("error callback = " + jSONObject.toString());
            }

            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onSuccess(String str, JSONObject jSONObject) {
                super.onSuccess(str, jSONObject);
                if (jSONObject.optInt("retcode") != 0) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("uin", PreGetQrcode.this.muin);
                hashMap.put("timestamp", (Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000)) + "");
                hashMap.put("guid", com.tencent.mobileqq.base.b.d());
                hashMap.put("token_md5", QrcodePaySetting.getString("qrcode_pay_tokenmd5", ""));
                hashMap.put("cn", PreGetQrcode.this.f386828cn);
                hashMap.put("device_id", QFuncProxy.getDeviceId(PreGetQrcode.this.mContext));
                hashMap.put("device_type", NetUtil.getDeviceType(PreGetQrcode.this.mContext));
                hashMap.put(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, Integer.toString(new Random(System.currentTimeMillis()).nextInt()));
                hashMap.put("sign", CertUtil.getInstance(PreGetQrcode.this.mContext).genUserSigNoEncode(PreGetQrcode.this.f386828cn, Utils.sortAndCatValues(hashMap)));
                hashMap.put("device_name", NetUtil.getDeviceName(PreGetQrcode.this.mContext));
                hashMap.put("autoReqCode", "1");
                PreGetQrcode.this.codeGenReq(hashMap, this.callback);
            }
        });
        tenpayBL.doTask(this.mContext, Cgi.URL_WALLET_GATE, map, null, "2", this.muin, true);
    }
}
