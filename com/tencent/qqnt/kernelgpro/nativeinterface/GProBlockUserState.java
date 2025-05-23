package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBlockUserState {
    public ArrayList<Long> blockUserList;

    public GProBlockUserState() {
        this.blockUserList = new ArrayList<>();
    }

    public ArrayList<Long> getBlockUserList() {
        return this.blockUserList;
    }

    public String toString() {
        return "GProBlockUserState{blockUserList=" + this.blockUserList + ",}";
    }

    public GProBlockUserState(ArrayList<Long> arrayList) {
        new ArrayList();
        this.blockUserList = arrayList;
    }
}
