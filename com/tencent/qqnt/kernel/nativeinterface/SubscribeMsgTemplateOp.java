package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SubscribeMsgTemplateOp {

    /* renamed from: op, reason: collision with root package name */
    public int f359228op;
    public SubscribeMsgTemplateID templateId;

    public SubscribeMsgTemplateOp() {
        this.templateId = new SubscribeMsgTemplateID();
    }

    public int getOp() {
        return this.f359228op;
    }

    public SubscribeMsgTemplateID getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "SubscribeMsgTemplateOp{templateId=" + this.templateId + ",op=" + this.f359228op + ",}";
    }

    public SubscribeMsgTemplateOp(SubscribeMsgTemplateID subscribeMsgTemplateID, int i3) {
        new SubscribeMsgTemplateID();
        this.templateId = subscribeMsgTemplateID;
        this.f359228op = i3;
    }
}
