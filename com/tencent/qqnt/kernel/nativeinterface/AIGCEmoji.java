package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AIGCEmoji {
    public int refId;
    public int templateId;
    public String packId = "";
    public String md5 = "";
    public String url = "";

    public String getMd5() {
        return this.md5;
    }

    public String getPackId() {
        return this.packId;
    }

    public int getRefId() {
        return this.refId;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "AIGCEmoji{packId=" + this.packId + ",templateId=" + this.templateId + ",refId=" + this.refId + ",md5=" + this.md5 + JefsClass.INDEX_URL + this.url + ",}";
    }
}
