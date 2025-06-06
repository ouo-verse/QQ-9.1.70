package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUnifiedEssenceInfo implements Serializable {
    public ArrayList<GProEssenceChannel> channels;
    public String content;
    public Long operatorName;
    long serialVersionUID;
    public Integer status;
    public String title;
    public Integer type;
    public long uniqueId;
    public String visitorMsg;

    public GProUnifiedEssenceInfo() {
        this.serialVersionUID = 1L;
        this.content = "";
        this.channels = new ArrayList<>();
        this.visitorMsg = "";
    }

    public ArrayList<GProEssenceChannel> getChannels() {
        return this.channels;
    }

    public String getContent() {
        return this.content;
    }

    public Long getOperatorName() {
        return this.operatorName;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getType() {
        return this.type;
    }

    public long getUniqueId() {
        return this.uniqueId;
    }

    public String getVisitorMsg() {
        return this.visitorMsg;
    }

    public void setChannels(ArrayList<GProEssenceChannel> arrayList) {
        this.channels = arrayList;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setOperatorName(Long l3) {
        this.operatorName = l3;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public void setUniqueId(long j3) {
        this.uniqueId = j3;
    }

    public void setVisitorMsg(String str) {
        this.visitorMsg = str;
    }

    public String toString() {
        return "GProUnifiedEssenceInfo{type=" + this.type + ",title=" + this.title + ",content=" + this.content + ",operatorName=" + this.operatorName + ",channels=" + this.channels + ",status=" + this.status + ",uniqueId=" + this.uniqueId + ",visitorMsg=" + this.visitorMsg + ",}";
    }

    public GProUnifiedEssenceInfo(Integer num, String str, String str2, Long l3, ArrayList<GProEssenceChannel> arrayList, Integer num2, long j3, String str3) {
        this.serialVersionUID = 1L;
        this.content = "";
        new ArrayList();
        this.type = num;
        this.title = str;
        this.content = str2;
        this.operatorName = l3;
        this.channels = arrayList;
        this.status = num2;
        this.uniqueId = j3;
        this.visitorMsg = str3;
    }
}
