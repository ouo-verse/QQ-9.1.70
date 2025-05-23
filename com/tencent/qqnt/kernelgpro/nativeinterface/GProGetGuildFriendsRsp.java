package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetGuildFriendsRsp {
    public ArrayList<Long> uinList = new ArrayList<>();

    public ArrayList<Long> getUinList() {
        return this.uinList;
    }

    public String toString() {
        return "GProGetGuildFriendsRsp{uinList=" + this.uinList + ",}";
    }
}
