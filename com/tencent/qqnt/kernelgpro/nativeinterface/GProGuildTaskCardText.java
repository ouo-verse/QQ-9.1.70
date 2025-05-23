package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProGuildTaskCardText {
    public int actionType;
    public int textClassify;
    public String content = "";
    public String url = "";

    public int getActionType() {
        return this.actionType;
    }

    public String getContent() {
        return this.content;
    }

    public int getTextClassify() {
        return this.textClassify;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProGuildTaskCardText{textClassify=" + this.textClassify + ",actionType=" + this.actionType + ",content=" + this.content + JefsClass.INDEX_URL + this.url + ",}";
    }
}
