package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProNoticeCover {
    public long linkId;
    public int type;
    public String url = "";

    public long getLinkId() {
        return this.linkId;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProNoticeCover{type=" + this.type + ",linkId=" + this.linkId + JefsClass.INDEX_URL + this.url + ",}";
    }
}
