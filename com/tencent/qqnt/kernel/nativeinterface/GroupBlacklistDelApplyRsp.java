package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupBlacklistDelApplyRsp {
    public ArrayList<Long> failUins = new ArrayList<>();

    public ArrayList<Long> getFailUins() {
        return this.failUins;
    }

    public String toString() {
        return "GroupBlacklistDelApplyRsp{failUins=" + this.failUins + ",}";
    }
}
