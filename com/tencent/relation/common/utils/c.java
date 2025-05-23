package com.tencent.relation.common.utils;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static String a(String str, String str2) {
        try {
            return new JSONObject(str).optString(QQCustomArkDialogUtil.BIZ_SRC, str2);
        } catch (JSONException unused) {
            QLog.e("ArkUtil", 1, "JSONObject opt getBizSrc is error!");
            return str2;
        }
    }

    public static String b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(str).optJSONObject(DownloadInfo.spKey_Config);
            if (jSONObject == null) {
                return null;
            }
        } catch (JSONException unused) {
            QLog.e("ArkUtil", 1, "JSONObject opt getConfigString is error!");
        }
        return jSONObject.toString();
    }

    public static String c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(str).optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            if (jSONObject == null) {
                return null;
            }
        } catch (JSONException unused) {
            QLog.e("ArkUtil", 1, "JSONObject opt getMetaString is error!");
        }
        return jSONObject.toString();
    }

    public static String d(String str, String str2) {
        try {
            return new JSONObject(str).optString("app", str2);
        } catch (JSONException unused) {
            QLog.e("ArkUtil", 1, "JSONObject opt getName is error!");
            return str2;
        }
    }

    public static String e(String str, String str2) {
        try {
            return new JSONObject(str).optString("prompt", str2);
        } catch (JSONException unused) {
            QLog.e("ArkUtil", 1, "JSONObject opt getPrompt is error!");
            return str2;
        }
    }

    public static String f(String str, String str2) {
        try {
            return new JSONObject(str).optString("ver", str2);
        } catch (JSONException unused) {
            QLog.e("ArkUtil", 1, "JSONObject opt getView is error!");
            return str2;
        }
    }

    public static String g(String str, String str2) {
        try {
            return new JSONObject(str).optString("view", str2);
        } catch (JSONException unused) {
            QLog.e("ArkUtil", 1, "JSONObject opt getView is error!");
            return str2;
        }
    }
}
