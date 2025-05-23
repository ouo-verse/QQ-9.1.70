package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class SmsPlugin implements NativePlugin {
    public static final String API_SEND_SMS = "sendMsg";
    public static final String KEY_CONTENT = "text";
    public static final String KEY_DATA = "data";
    public static final String KEY_NUMBER = "to";
    public static final String KEY_SYSTEM_SMS_CONTENT = "sms_body";
    public static final String KEY_SYSTEM_SMS_PHONE = "address";
    public static final String KEY_SYSTEM_SMS_TYPE = "vnd.android-dir/mms-sms";
    public static final String KEY_SYSTEM_SMS_URI = "smsto:";
    private static final String TAG = "SmsPlugin";

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        QLog.d(TAG, 1, "start onInvoke");
        Activity activity = jSContext.getActivity();
        if (activity == null) {
            QLog.d(TAG, 1, "SmsPlugin invoke, but activity is null");
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            QLog.d(TAG, 1, "SmsPlugin invoke, but dataJson is null");
            return;
        }
        String optString = optJSONObject.optString("to", "");
        String optString2 = optJSONObject.optString("text", "");
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(KEY_SYSTEM_SMS_URI));
            intent.setType(KEY_SYSTEM_SMS_TYPE);
            intent.putExtra("address", optString);
            intent.putExtra(KEY_SYSTEM_SMS_CONTENT, optString2);
            activity.startActivity(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "sendSms exception : ", e16.getMessage());
            Intent intent2 = new Intent("android.intent.action.SENDTO");
            intent2.setData(Uri.parse(KEY_SYSTEM_SMS_URI + optString));
            intent2.putExtra(KEY_SYSTEM_SMS_CONTENT, optString2);
            activity.startActivity(intent2);
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
