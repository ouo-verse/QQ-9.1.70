package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgTypeFilter {
    public ArrayList<Integer> subType;
    public int type;

    public MsgTypeFilter() {
        this.subType = new ArrayList<>();
    }

    public ArrayList<Integer> getSubType() {
        return this.subType;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "MsgTypeFilter{type=" + this.type + ",subType=" + this.subType + ",}";
    }

    public MsgTypeFilter(int i3, ArrayList<Integer> arrayList) {
        new ArrayList();
        this.type = i3;
        this.subType = arrayList;
    }
}
