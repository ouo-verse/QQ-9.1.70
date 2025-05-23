package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QuerySubscribeMsgTemplateReq {
    public long robotUin;
    public ArrayList<SubscribeMsgTemplateID> templateId;

    public QuerySubscribeMsgTemplateReq() {
        this.templateId = new ArrayList<>();
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public ArrayList<SubscribeMsgTemplateID> getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "QuerySubscribeMsgTemplateReq{robotUin=" + this.robotUin + ",templateId=" + this.templateId + ",}";
    }

    public QuerySubscribeMsgTemplateReq(long j3, ArrayList<SubscribeMsgTemplateID> arrayList) {
        new ArrayList();
        this.robotUin = j3;
        this.templateId = arrayList;
    }
}
