package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRobotInlineSearchRsp {
    public String keyword;
    public ArrayList<GProGuildRobotInlineLayout> layoutList;

    public GProGuildRobotInlineSearchRsp() {
        this.keyword = "";
        this.layoutList = new ArrayList<>();
    }

    public String getKeyword() {
        return this.keyword;
    }

    public ArrayList<GProGuildRobotInlineLayout> getLayoutList() {
        return this.layoutList;
    }

    public String toString() {
        return "GProGuildRobotInlineSearchRsp{keyword=" + this.keyword + ",layoutList=" + this.layoutList + ",}";
    }

    public GProGuildRobotInlineSearchRsp(String str, ArrayList<GProGuildRobotInlineLayout> arrayList) {
        this.keyword = "";
        new ArrayList();
        this.keyword = str;
        this.layoutList = arrayList;
    }
}
