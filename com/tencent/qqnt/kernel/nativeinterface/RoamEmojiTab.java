package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RoamEmojiTab {
    public ArrayList<Integer> epIds;
    public ArrayList<TabEmojiInfo> magicTabinfoList;
    public ArrayList<TabEmojiInfo> ordinaryTabinfoList;
    public ArrayList<TabEmojiInfo> smallTabinfoList;

    public RoamEmojiTab() {
        this.ordinaryTabinfoList = new ArrayList<>();
        this.magicTabinfoList = new ArrayList<>();
        this.smallTabinfoList = new ArrayList<>();
        this.epIds = new ArrayList<>();
    }

    public ArrayList<Integer> getEpIds() {
        return this.epIds;
    }

    public ArrayList<TabEmojiInfo> getMagicTabinfoList() {
        return this.magicTabinfoList;
    }

    public ArrayList<TabEmojiInfo> getOrdinaryTabinfoList() {
        return this.ordinaryTabinfoList;
    }

    public ArrayList<TabEmojiInfo> getSmallTabinfoList() {
        return this.smallTabinfoList;
    }

    public String toString() {
        return "RoamEmojiTab{ordinaryTabinfoList=" + this.ordinaryTabinfoList + ",magicTabinfoList=" + this.magicTabinfoList + ",smallTabinfoList=" + this.smallTabinfoList + ",epIds=" + this.epIds + ",}";
    }

    public RoamEmojiTab(ArrayList<TabEmojiInfo> arrayList, ArrayList<TabEmojiInfo> arrayList2, ArrayList<TabEmojiInfo> arrayList3, ArrayList<Integer> arrayList4) {
        this.ordinaryTabinfoList = new ArrayList<>();
        this.magicTabinfoList = new ArrayList<>();
        this.smallTabinfoList = new ArrayList<>();
        new ArrayList();
        this.ordinaryTabinfoList = arrayList;
        this.magicTabinfoList = arrayList2;
        this.smallTabinfoList = arrayList3;
        this.epIds = arrayList4;
    }
}
