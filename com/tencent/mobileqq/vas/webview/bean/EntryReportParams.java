package com.tencent.mobileqq.vas.webview.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class EntryReportParams {
    String appId;
    String itemId;
    String itemType;
    String pageId;

    public EntryReportParams(int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.appId = str;
        } else {
            this.appId = VasWebConstants.REPORT_ORIGIN;
        }
        this.pageId = String.valueOf(i3);
        this.itemId = "";
        this.itemType = "";
    }

    public String base64Json() {
        return PluginBaseInfoHelper.Base64Helper.encodeToString(toJson().getBytes(), 0);
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.appId);
            jSONObject.put("page_id", this.pageId);
            jSONObject.put("item_id", this.itemId);
            jSONObject.put("item_type", this.itemType);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("WebReportAdapter", 2, "vas_web_report\uff0cjson: " + e16);
            }
        }
        return jSONObject.toString();
    }
}
