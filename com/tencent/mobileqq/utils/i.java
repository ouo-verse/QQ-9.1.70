package com.tencent.mobileqq.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i {
    public static MessageForArkApp a(Bundle bundle, QQAppInterface qQAppInterface, String str, int i3, String str2) {
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        arkAppMessage.appMinVersion = Constants.DEFAULT_MIN_APP_VERSION;
        arkAppMessage.appName = "com.tencent.structmsg";
        arkAppMessage.bizSrc = "";
        arkAppMessage.appView = b(bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE));
        Map<String, String> applicationFromManifest = ArkAppCacheMgr.getApplicationFromManifest(arkAppMessage.appName, arkAppMessage.bizSrc, arkAppMessage.appMinVersion);
        if (applicationFromManifest != null) {
            arkAppMessage.appDesc = applicationFromManifest.get("desc");
            arkAppMessage.appMinVersion = applicationFromManifest.get("version");
        }
        if (TextUtils.isEmpty(arkAppMessage.appDesc)) {
            arkAppMessage.appDesc = arkAppMessage.appName;
        }
        String string = bundle.getString("title");
        if (TextUtils.isEmpty(string)) {
            string = arkAppMessage.appDesc;
        }
        arkAppMessage.promptText = String.format(HardCodeUtil.qqStr(R.string.f171602jp0), string);
        arkAppMessage.metaList = QQCustomArkDialog.F0(bundle, arkAppMessage.appName);
        arkAppMessage.config = c();
        MessageForArkApp u16 = com.tencent.mobileqq.service.message.q.u(qQAppInterface, str, str2, i3, arkAppMessage);
        u16.msgData = arkAppMessage.toBytes();
        u16.parse();
        return u16;
    }

    public static String b(int i3) {
        if (i3 == 2) {
            return "music";
        }
        if (i3 == 4) {
            return "video";
        }
        return "news";
    }

    public static String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("forward", 1);
            jSONObject.put("autosize", 1);
            jSONObject.put("type", "normal");
        } catch (JSONException e16) {
            QLog.e("ArkMessageBuilder", 1, "getConfigValue", e16);
        }
        return jSONObject.toString();
    }
}
