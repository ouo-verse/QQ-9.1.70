package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WeiboSsoSdkConfig implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String smid = "";
    private String from = "";

    /* renamed from: wm, reason: collision with root package name */
    private String f387949wm = "";
    private String oldwm = "";
    private String sub = "";
    private String smApiKey = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public void addExtra(String str, String str2) {
        this.extra.put(str, str2);
    }

    public Object clone() {
        try {
            WeiboSsoSdkConfig weiboSsoSdkConfig = (WeiboSsoSdkConfig) super.clone();
            HashMap<String, String> hashMap = new HashMap<>();
            for (Map.Entry<String, String> entry : weiboSsoSdkConfig.extra.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            weiboSsoSdkConfig.extra = hashMap;
            return weiboSsoSdkConfig;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getAppKey(boolean z16) {
        if (z16) {
            return urlEncode(this.appKey);
        }
        return this.appKey;
    }

    public Context getApplicationContext() {
        return this.appContext;
    }

    public String getExtraString(boolean z16) {
        if (this.extra.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : this.extra.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
                return "";
            }
        }
        if (z16) {
            return urlEncode(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String getFrom(boolean z16) {
        if (z16) {
            return urlEncode(this.from);
        }
        return this.from;
    }

    public String getOldWm(boolean z16) {
        if (z16) {
            return urlEncode(this.oldwm);
        }
        return this.oldwm;
    }

    public String getSmApiKey() {
        return this.smApiKey;
    }

    public String getSmid(boolean z16) {
        if (z16) {
            return urlEncode(this.smid);
        }
        return this.smid;
    }

    public String getSub(boolean z16) {
        if (z16) {
            return urlEncode(this.sub);
        }
        return this.sub;
    }

    public String getWm(boolean z16) {
        if (z16) {
            return urlEncode(this.f387949wm);
        }
        return this.f387949wm;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setContext(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setOldWm(String str) {
        this.oldwm = str;
    }

    public void setSmApiKey(String str) {
        this.smApiKey = str;
    }

    public void setSmid(String str) {
        this.smid = str;
    }

    public void setSub(String str) {
        this.sub = str;
    }

    public void setWm(String str) {
        this.f387949wm = str;
    }

    public boolean verify() {
        if (this.appContext != null && !TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.from) && !TextUtils.isEmpty(this.f387949wm)) {
            return true;
        }
        return false;
    }
}
