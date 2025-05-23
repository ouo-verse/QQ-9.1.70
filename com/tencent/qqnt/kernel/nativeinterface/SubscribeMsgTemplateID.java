package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SubscribeMsgTemplateID {
    public String customTemplateId;
    public int templateId;

    public SubscribeMsgTemplateID() {
        this.customTemplateId = "";
    }

    public String getCustomTemplateId() {
        return this.customTemplateId;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "SubscribeMsgTemplateID{templateId=" + this.templateId + ",customTemplateId=" + this.customTemplateId + ",}";
    }

    public SubscribeMsgTemplateID(int i3, String str) {
        this.templateId = i3;
        this.customTemplateId = str;
    }
}
