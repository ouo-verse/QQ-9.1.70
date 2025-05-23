package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupGameList {
    public ArrayList<GroupGame> gameInfos = new ArrayList<>();

    public ArrayList<GroupGame> getGameInfos() {
        return this.gameInfos;
    }

    public String toString() {
        return "GroupGameList{gameInfos=" + this.gameInfos + ",}";
    }
}
