package com.tencent.gamematrix.gmcg.sdk.nonage.bean;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNonageUser {
    private String appId;
    private String key;
    private String openId;
    private long saveTime;
    private String token;
    private String userId;

    public String getAppId() {
        return this.appId;
    }

    public String getKey() {
        return this.key;
    }

    public String getOpenId() {
        return this.openId;
    }

    public long getSaveTime() {
        return this.saveTime;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isExpire() {
        if (this.saveTime > 0 && (System.currentTimeMillis() / 1000) - this.saveTime > 1209600) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.key)) {
            return true;
        }
        return false;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public void setSaveTime(long j3) {
        this.saveTime = j3;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
