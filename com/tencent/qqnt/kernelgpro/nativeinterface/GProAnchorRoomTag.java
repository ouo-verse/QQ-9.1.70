package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProAnchorRoomTag {
    public String text;
    public Integer type;
    public String url;

    public String getText() {
        return this.text;
    }

    public Integer getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProAnchorRoomTag{type=" + this.type + ",text=" + this.text + JefsClass.INDEX_URL + this.url + ",}";
    }
}
