package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SubscribeMsgTemplateInfo {
    public SubscribeMsgTemplateID templateId = new SubscribeMsgTemplateID();
    public String templateTitle = "";

    public SubscribeMsgTemplateID getTemplateId() {
        return this.templateId;
    }

    public String getTemplateTitle() {
        return this.templateTitle;
    }

    public String toString() {
        return "SubscribeMsgTemplateInfo{templateId=" + this.templateId + ",templateTitle=" + this.templateTitle + ",}";
    }
}
