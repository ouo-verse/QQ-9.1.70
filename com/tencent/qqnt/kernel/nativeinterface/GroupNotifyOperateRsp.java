package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupNotifyOperateRsp {
    public GroupNotifyMsg item = new GroupNotifyMsg();
    public ArrayList<GroupNotifyTemplateItem> templates = new ArrayList<>();

    public GroupNotifyMsg getItem() {
        return this.item;
    }

    public ArrayList<GroupNotifyTemplateItem> getTemplates() {
        return this.templates;
    }

    public String toString() {
        return "GroupNotifyOperateRsp{item=" + this.item + ",templates=" + this.templates + ",}";
    }
}
