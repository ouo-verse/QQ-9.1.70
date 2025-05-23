package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendTextChannel implements Serializable {
    public ArrayList<String> avatars;
    public boolean isActive;
    public ArrayList<String> memberAvatars;
    public ArrayList<MsgAbstract> msgAbstracts;
    public String msgSummary;
    public int noreadNum;
    long serialVersionUID;
    public String tagMsg;

    public GProRecommendTextChannel() {
        this.serialVersionUID = 1L;
        this.msgAbstracts = new ArrayList<>();
        this.avatars = new ArrayList<>();
        this.tagMsg = "";
        this.msgSummary = "";
        this.memberAvatars = new ArrayList<>();
    }

    public ArrayList<String> getAvatars() {
        return this.avatars;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public ArrayList<String> getMemberAvatars() {
        return this.memberAvatars;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public String getMsgSummary() {
        return this.msgSummary;
    }

    public int getNoreadNum() {
        return this.noreadNum;
    }

    public String getTagMsg() {
        return this.tagMsg;
    }

    public String toString() {
        return "GProRecommendTextChannel{msgAbstracts=" + this.msgAbstracts + ",avatars=" + this.avatars + ",noreadNum=" + this.noreadNum + ",isActive=" + this.isActive + ",tagMsg=" + this.tagMsg + ",msgSummary=" + this.msgSummary + ",memberAvatars=" + this.memberAvatars + ",}";
    }

    public GProRecommendTextChannel(ArrayList<MsgAbstract> arrayList, ArrayList<String> arrayList2, int i3, boolean z16, String str, String str2, ArrayList<String> arrayList3) {
        this.serialVersionUID = 1L;
        this.msgAbstracts = new ArrayList<>();
        this.avatars = new ArrayList<>();
        this.tagMsg = "";
        this.msgSummary = "";
        new ArrayList();
        this.msgAbstracts = arrayList;
        this.avatars = arrayList2;
        this.noreadNum = i3;
        this.isActive = z16;
        this.tagMsg = str;
        this.msgSummary = str2;
        this.memberAvatars = arrayList3;
    }
}
