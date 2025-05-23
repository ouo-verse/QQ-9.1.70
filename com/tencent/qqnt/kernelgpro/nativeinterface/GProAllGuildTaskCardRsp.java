package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAllGuildTaskCardRsp {
    public ArrayList<GProGuildTaskCard> taskCards = new ArrayList<>();

    public ArrayList<GProGuildTaskCard> getTaskCards() {
        return this.taskCards;
    }

    public String toString() {
        return "GProAllGuildTaskCardRsp{taskCards=" + this.taskCards + ",}";
    }
}
