package com.tencent.qqmini.sdk.launcher.model;

import org.json.JSONObject;

/* loaded from: classes23.dex */
public class PageInfo implements Cloneable {
    public WindowInfo windowInfo;

    public static PageInfo getDefault() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.windowInfo = WindowInfo.getDefault();
        return pageInfo;
    }

    public void updateInfo(JSONObject jSONObject) {
        JSONObject optJSONObject;
        WindowInfo windowInfo = this.windowInfo;
        if (windowInfo != null) {
            if (jSONObject == null) {
                optJSONObject = null;
            } else {
                optJSONObject = jSONObject.optJSONObject("window");
            }
            windowInfo.updateInfo(optJSONObject);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PageInfo m243clone() {
        PageInfo pageInfo;
        Throwable th5;
        try {
            pageInfo = (PageInfo) super.clone();
        } catch (Throwable th6) {
            pageInfo = null;
            th5 = th6;
        }
        try {
            pageInfo.windowInfo = this.windowInfo.m246clone();
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return pageInfo;
        }
        return pageInfo;
    }
}
