package com.huawei.hms.support.api.client;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SubAppInfo {
    private String subAppID;

    public SubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.subAppID = subAppInfo.getSubAppID();
        }
    }

    public String getSubAppID() {
        return this.subAppID;
    }

    public void setSubAppInfoID(String str) {
        this.subAppID = str;
    }

    public SubAppInfo(String str) {
        this.subAppID = str;
    }
}
