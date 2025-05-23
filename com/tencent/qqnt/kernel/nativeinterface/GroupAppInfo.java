package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupAppInfo {
    public long appid;
    public int pushRedPoint;
    public int showFrame;
    public String name = "";
    public String url = "";
    public String icon = "";

    public long getAppid() {
        return this.appid;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public int getPushRedPoint() {
        return this.pushRedPoint;
    }

    public int getShowFrame() {
        return this.showFrame;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GroupAppInfo{appid=" + this.appid + ",name=" + this.name + JefsClass.INDEX_URL + this.url + ",icon=" + this.icon + ",pushRedPoint=" + this.pushRedPoint + ",showFrame=" + this.showFrame + ",}";
    }
}
