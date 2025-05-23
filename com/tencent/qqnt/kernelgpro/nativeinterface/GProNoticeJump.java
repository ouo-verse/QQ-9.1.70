package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProNoticeJump {
    public int iconUrlIndex;
    public int placeHolderIndex;
    public String text = "";
    public String url = "";
    public String iconUrl = "";

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getIconUrlIndex() {
        return this.iconUrlIndex;
    }

    public int getPlaceHolderIndex() {
        return this.placeHolderIndex;
    }

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProNoticeJump{text=" + this.text + JefsClass.INDEX_URL + this.url + ",placeHolderIndex=" + this.placeHolderIndex + ",iconUrl=" + this.iconUrl + ",iconUrlIndex=" + this.iconUrlIndex + ",}";
    }
}
