package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupAppTabInfo {
    public long appid;
    public int num;
    public int redPoint;
    public int type;
    public String name = "";
    public String desc = "";
    public String url = "";
    public String pic = "";

    public long getAppid() {
        return this.appid;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public int getNum() {
        return this.num;
    }

    public String getPic() {
        return this.pic;
    }

    public int getRedPoint() {
        return this.redPoint;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GroupAppTabInfo{type=" + this.type + ",name=" + this.name + ",desc=" + this.desc + JefsClass.INDEX_URL + this.url + ",num=" + this.num + ",appid=" + this.appid + ",pic=" + this.pic + ",redPoint=" + this.redPoint + ",}";
    }
}
