package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProQuickJoinItem implements Serializable {
    public String coverUrl;
    public ArrayList<String> membersAvatar;
    public String name;
    public String onlineNumTag;
    public int order;
    long serialVersionUID;
    public int statusTag;
    public int voiceType;

    public GProQuickJoinItem() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.coverUrl = "";
        this.onlineNumTag = "";
        this.membersAvatar = new ArrayList<>();
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public ArrayList<String> getMembersAvatar() {
        return this.membersAvatar;
    }

    public String getName() {
        return this.name;
    }

    public String getOnlineNumTag() {
        return this.onlineNumTag;
    }

    public int getOrder() {
        return this.order;
    }

    public int getStatusTag() {
        return this.statusTag;
    }

    public int getVoiceType() {
        return this.voiceType;
    }

    public String toString() {
        return "GProQuickJoinItem{name=" + this.name + ",voiceType=" + this.voiceType + ",coverUrl=" + this.coverUrl + ",onlineNumTag=" + this.onlineNumTag + ",membersAvatar=" + this.membersAvatar + ",statusTag=" + this.statusTag + ",order=" + this.order + ",}";
    }

    public GProQuickJoinItem(String str, int i3, String str2, String str3, ArrayList<String> arrayList, int i16, int i17) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.coverUrl = "";
        this.onlineNumTag = "";
        new ArrayList();
        this.name = str;
        this.voiceType = i3;
        this.coverUrl = str2;
        this.onlineNumTag = str3;
        this.membersAvatar = arrayList;
        this.statusTag = i16;
        this.order = i17;
    }
}
