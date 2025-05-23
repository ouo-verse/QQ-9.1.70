package com.tencent.superplayer.config;

import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor;
import com.tencent.qqlive.superplayer.tools.utils.d;
import com.tencent.qqlive.superplayer.tools.utils.g;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.report.reportv1.BeaconAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yt3.a;

/* loaded from: classes26.dex */
public class PullConfigRequest {
    private static int CURRENT_HOST_URL_RETRY_MAX_COUNT = a.c().a();
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static String REQUEST_URL = "https://cgi.kandian.qq.com/trpc.tkdqq.kd_rainbow_proxy.ConfigService/PullConfigReq";
    private static String TAG = "PullConfigRequest";
    private PullConfigCallback mCallback;
    private int mCurrentHostUrlRetryCount = 0;
    private ITVKHttpProcessor.b mPullConfigCb = new ITVKHttpProcessor.b() { // from class: com.tencent.superplayer.config.PullConfigRequest.1
        @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor.b
        public void onFailure(IOException iOException) {
            PullConfigRequest.this.callbackOnFailureOrRetry(iOException);
        }

        @Override // com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor.b
        public void onSuccess(ITVKHttpProcessor.a aVar) {
            PullConfigRequest.this.handleHttpCallbackOnSuccess(aVar);
        }
    };
    private String mRequestRootGroupName;

    /* loaded from: classes26.dex */
    public interface PullConfigCallback {
        void onConfigPulled(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOnFailureOrRetry(Exception exc) {
        int i3 = this.mCurrentHostUrlRetryCount;
        if (i3 > CURRENT_HOST_URL_RETRY_MAX_COUNT) {
            return;
        }
        this.mCurrentHostUrlRetryCount = i3 + 1;
        executeRequest();
    }

    private void executeRequest() {
        executeRequest(this.mRequestRootGroupName, this.mCallback);
    }

    private Map<String, String> generateHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    private Map<String, String> generateParam() {
        return new HashMap();
    }

    private JSONArray getClientInfo() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("client_identified_name", "qmei");
        jSONObject.put("client_identified_value", BeaconAdapter.getQIMEI());
        jSONArray.mo162put(jSONObject);
        return jSONArray;
    }

    private byte[] getRequestRawData() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_id", ConfigManager.RAIN_BOW_KEY);
            jSONObject2.put(VipFunCallConstants.KEY_GROUP, this.mRequestRootGroupName);
            jSONObject2.put("version", SuperPlayerSDKMgr.getSDKVersion());
            jSONObject.put("pull_item", jSONObject2);
            jSONObject.put("client_infos", getClientInfo());
            return jSONObject.toString().getBytes("utf-8");
        } catch (Exception e16) {
            LogUtil.e(TAG, "getRequestRawData error", e16);
            return new byte[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleHttpCallbackOnSuccess(ITVKHttpProcessor.a aVar) {
        String str;
        d.d(TAG, "pullConfigRequest onSuccess.");
        try {
            if (aVar.f345469a.containsKey("Content-Encoding") && aVar.f345469a.get("Content-Encoding").contains("gzip")) {
                byte[] e16 = g.e(aVar.f345470b);
                if (e16 != null) {
                    str = new String(e16, "UTF-8");
                } else {
                    str = "";
                }
            } else {
                str = new String(aVar.f345470b, "UTF-8");
            }
            LogUtil.i(TAG, "handleHttpCallbackOnSuccess response:" + str);
            PullConfigCallback pullConfigCallback = this.mCallback;
            if (pullConfigCallback != null) {
                pullConfigCallback.onConfigPulled(str);
            }
        } catch (Exception e17) {
            d.b(TAG, e17);
            callbackOnFailureOrRetry(e17);
        }
    }

    public void executeRequest(String str, PullConfigCallback pullConfigCallback) {
        this.mRequestRootGroupName = str;
        this.mCallback = pullConfigCallback;
        yt3.d.c().b(this.mCurrentHostUrlRetryCount, REQUEST_URL, generateParam(), generateHeaders(), getRequestRawData(), this.mPullConfigCb);
    }
}
