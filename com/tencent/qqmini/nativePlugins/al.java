package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class al extends BaseJsPlugin {
    @JsEvent({SmsPlugin.API_SEND_SMS})
    public void sendMsg(RequestEvent requestEvent) {
        Exception exc;
        String str;
        String str2 = "";
        QLog.d("SmsPlugin", 1, "start sendMsg");
        if (this.mContext == null) {
            QLog.d("SmsPlugin", 1, "sendMsg, but mContext is null");
            return;
        }
        String str3 = requestEvent.jsonParams;
        try {
            JSONObject optJSONObject = new JSONObject(str3).optJSONObject("data");
            String optString = optJSONObject.optString("to", "");
            try {
                str2 = optJSONObject.optString("text", "");
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setData(Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI));
                intent.setType(SmsPlugin.KEY_SYSTEM_SMS_TYPE);
                intent.putExtra("address", optString);
                intent.putExtra(SmsPlugin.KEY_SYSTEM_SMS_CONTENT, str2);
                if (!(this.mContext instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                this.mContext.startActivity(intent);
            } catch (Exception e16) {
                str = str2;
                str2 = optString;
                exc = e16;
                QLog.e("SmsPlugin", 1, "sendSms exception : ", exc.getMessage(), "jsonParams : ", str3);
                Intent intent2 = new Intent("android.intent.action.SENDTO");
                intent2.setData(Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI + str2));
                intent2.putExtra(SmsPlugin.KEY_SYSTEM_SMS_CONTENT, str);
                this.mContext.startActivity(intent2);
            }
        } catch (Exception e17) {
            exc = e17;
            str = "";
        }
    }
}
