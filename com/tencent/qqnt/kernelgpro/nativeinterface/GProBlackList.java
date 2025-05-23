package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBlackList {
    public int listId;
    public String listName;
    public ArrayList<GProBlackUserInfo> memberList;

    public GProBlackList() {
        this.listName = "";
        this.memberList = new ArrayList<>();
    }

    public int getListId() {
        return this.listId;
    }

    public String getListName() {
        return this.listName;
    }

    public ArrayList<GProBlackUserInfo> getMemberList() {
        return this.memberList;
    }

    public String toString() {
        return "GProBlackList{listId=" + this.listId + ",listName=" + this.listName + ",memberList=" + this.memberList + ",}";
    }

    public GProBlackList(int i3, String str, ArrayList<GProBlackUserInfo> arrayList) {
        this.listName = "";
        new ArrayList();
        this.listId = i3;
        this.listName = str;
        this.memberList = arrayList;
    }
}
