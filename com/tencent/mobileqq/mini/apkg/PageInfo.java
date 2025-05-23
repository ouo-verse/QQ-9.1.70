package com.tencent.mobileqq.mini.apkg;

import org.json.JSONObject;

/* loaded from: classes33.dex */
public class PageInfo implements Cloneable {
    public WindowInfo windowInfo;

    public static PageInfo getDefault() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.windowInfo = WindowInfo.getDefault();
        return pageInfo;
    }

    public void updateInfo(JSONObject jSONObject) {
        WindowInfo windowInfo = this.windowInfo;
        if (windowInfo != null) {
            windowInfo.updateInfo(jSONObject == null ? null : jSONObject.optJSONObject("window"));
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PageInfo m201clone() {
        PageInfo pageInfo;
        Throwable th5;
        try {
            pageInfo = (PageInfo) super.clone();
        } catch (Throwable th6) {
            pageInfo = null;
            th5 = th6;
        }
        try {
            pageInfo.windowInfo = this.windowInfo.m204clone();
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return pageInfo;
        }
        return pageInfo;
    }
}
