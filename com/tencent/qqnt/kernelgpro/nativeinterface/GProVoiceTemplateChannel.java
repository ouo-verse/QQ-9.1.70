package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProVoiceTemplateChannel implements Serializable {
    public GProRecommendCoverInfo cover;
    public int currentNum;
    public String icon;
    public int maxNum;
    public ArrayList<GProMemberInfo> members;
    public String name;
    public String playDesc;
    long serialVersionUID;
    public int status;
    public String statusDesc;
    public String statusIcon;

    public GProVoiceTemplateChannel() {
        this.serialVersionUID = 1L;
        this.cover = new GProRecommendCoverInfo();
        this.statusDesc = "";
        this.statusIcon = "";
        this.members = new ArrayList<>();
        this.name = "";
        this.icon = "";
        this.playDesc = "";
    }

    public GProRecommendCoverInfo getCover() {
        return this.cover;
    }

    public int getCurrentNum() {
        return this.currentNum;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getMaxNum() {
        return this.maxNum;
    }

    public ArrayList<GProMemberInfo> getMembers() {
        return this.members;
    }

    public String getName() {
        return this.name;
    }

    public String getPlayDesc() {
        return this.playDesc;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusDesc() {
        return this.statusDesc;
    }

    public String getStatusIcon() {
        return this.statusIcon;
    }

    public String toString() {
        return "GProVoiceTemplateChannel{cover=" + this.cover + ",statusDesc=" + this.statusDesc + ",statusIcon=" + this.statusIcon + ",members=" + this.members + ",name=" + this.name + ",status=" + this.status + ",icon=" + this.icon + ",playDesc=" + this.playDesc + ",currentNum=" + this.currentNum + ",maxNum=" + this.maxNum + ",}";
    }

    public GProVoiceTemplateChannel(GProRecommendCoverInfo gProRecommendCoverInfo, String str, String str2, ArrayList<GProMemberInfo> arrayList, String str3, int i3, String str4, String str5, int i16, int i17) {
        this.serialVersionUID = 1L;
        this.cover = new GProRecommendCoverInfo();
        this.statusDesc = "";
        this.statusIcon = "";
        new ArrayList();
        this.cover = gProRecommendCoverInfo;
        this.statusDesc = str;
        this.statusIcon = str2;
        this.members = arrayList;
        this.name = str3;
        this.status = i3;
        this.icon = str4;
        this.playDesc = str5;
        this.currentNum = i16;
        this.maxNum = i17;
    }
}
