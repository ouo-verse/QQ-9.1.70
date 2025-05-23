package com.tencent.mobileqq.mini.out.nativePlugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.out.nativePlugins.WeiyunNativeBusiness;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class WeiyunDownloadFilePlugin implements NativePlugin {
    private static final String ACTION_CANCEL_DOWNLOAD_TASK = "cancelDownloadTask";
    private static final String ACTION_CREATE_DOWNLOAD_TASK = "createDownloadTask";
    private static final String ACTION_PAUSE_DOWNLOAD_TASK = "pauseDownloadTask";
    public static final String TAG = "[mini] WeiyunDownloadFilePlugin";
    private JSContext mJSContext;
    private WeiyunNativeBusiness.WeiyunDownloadBussiness mWeiyunDownloadBussiness;

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        try {
            this.mJSContext = jSContext;
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            String string = jSONObject2.getString("action");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (string.equals("createDownloadTask") || string.equals(ACTION_PAUSE_DOWNLOAD_TASK) || string.equals(ACTION_CANCEL_DOWNLOAD_TASK)) {
                QLog.d(TAG, 2, "create weiyun Download");
                if (this.mWeiyunDownloadBussiness == null) {
                    this.mWeiyunDownloadBussiness = new WeiyunNativeBusiness.WeiyunDownloadBussiness();
                }
                JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("data"));
                if (string.equals("createDownloadTask")) {
                    if (this.mWeiyunDownloadBussiness.isLegal(jSONObject3)) {
                        this.mWeiyunDownloadBussiness.doDownloadWeiyun(jSONObject3, jSONObject3.getString("file_id"), jSContext);
                        jSContext.evaluateCallback(true, null, "");
                        return;
                    } else {
                        jSContext.evaluateCallback(false, null, "download params illegal.");
                        return;
                    }
                }
                if (string.equals(ACTION_PAUSE_DOWNLOAD_TASK)) {
                    QLog.d(TAG, 2, "pause weiyun Download");
                    this.mWeiyunDownloadBussiness.pause(jSONObject3.getString("file_id"), jSContext);
                } else if (string.equals(ACTION_CANCEL_DOWNLOAD_TASK)) {
                    QLog.d(TAG, 2, "cacel weiyun Download");
                    this.mWeiyunDownloadBussiness.cancel(jSONObject3.getString("file_id"), jSContext);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
