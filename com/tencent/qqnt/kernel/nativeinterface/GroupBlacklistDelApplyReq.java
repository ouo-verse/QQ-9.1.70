package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupBlacklistDelApplyReq {
    public long groupCode;
    public ArrayList<Long> uins = new ArrayList<>();

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<Long> getUins() {
        return this.uins;
    }

    public String toString() {
        return "GroupBlacklistDelApplyReq{groupCode=" + this.groupCode + ",uins=" + this.uins + ",}";
    }
}
