package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetGroupWxNotifyStatusRsp {
    public ArrayList<GroupWxNotifyStatusItem> items = new ArrayList<>();

    public ArrayList<GroupWxNotifyStatusItem> getItems() {
        return this.items;
    }

    public String toString() {
        return "GetGroupWxNotifyStatusRsp{items=" + this.items + ",}";
    }
}
