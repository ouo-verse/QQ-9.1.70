package com.qq.e.comm.pi;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.c0.j;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface AppDownloadCallback {
    public static final String APP_LOGO = "applogo";
    public static final String BUTTON_TXT = "button_txt";
    public static final String NOTICE_DESC = "notice_desc";
    public static final String NOTICE_TITLE = "notice_title";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class TGAppNoticeInfo {
        public String buttonText;
        public String logoUrl;
        public String noticeDesc;
        public String noticeTitle;

        public TGAppNoticeInfo(String str, String str2, String str3, String str4) {
            this.noticeTitle = str;
            this.noticeDesc = str2;
            this.buttonText = str3;
            this.logoUrl = str4;
        }

        public static TGAppNoticeInfo createFromJson(JSONObject jSONObject) {
            String str;
            if (jSONObject == null) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(j.T0);
            if (optJSONObject != null && !JSONObject.NULL.equals(optJSONObject)) {
                str = optJSONObject.optString(AppDownloadCallback.APP_LOGO);
            } else {
                str = "";
            }
            return new TGAppNoticeInfo(jSONObject.optString(AppDownloadCallback.NOTICE_TITLE), jSONObject.optString(AppDownloadCallback.NOTICE_DESC), jSONObject.optString(AppDownloadCallback.BUTTON_TXT), str);
        }

        public static TGAppNoticeInfo createFromJsonStr(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return createFromJson(new JSONObject(str));
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    void onDownloadComplete(int i3, String str, String str2, TGAppNoticeInfo tGAppNoticeInfo);

    void onInstallComplete(int i3, String str, String str2);
}
