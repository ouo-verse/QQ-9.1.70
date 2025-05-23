package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProExtra implements Serializable {
    public ArrayList<GProEntry> bizDataList;
    public GProMVPItemCbData callback;
    public boolean isRead;
    public ArrayList<GProEntry> reports;
    long serialVersionUID;
    public String sessionId;
    public ArrayList<GProTag> tags;

    public GProExtra() {
        this.serialVersionUID = 1L;
        this.tags = new ArrayList<>();
        this.reports = new ArrayList<>();
        this.bizDataList = new ArrayList<>();
        this.callback = new GProMVPItemCbData();
        this.sessionId = "";
    }

    public ArrayList<GProEntry> getBizDataList() {
        return this.bizDataList;
    }

    public GProMVPItemCbData getCallback() {
        return this.callback;
    }

    public boolean getIsRead() {
        return this.isRead;
    }

    public ArrayList<GProEntry> getReports() {
        return this.reports;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public ArrayList<GProTag> getTags() {
        return this.tags;
    }

    public void setBizDataList(ArrayList<GProEntry> arrayList) {
        this.bizDataList = arrayList;
    }

    public void setCallback(GProMVPItemCbData gProMVPItemCbData) {
        this.callback = gProMVPItemCbData;
    }

    public void setIsRead(boolean z16) {
        this.isRead = z16;
    }

    public void setReports(ArrayList<GProEntry> arrayList) {
        this.reports = arrayList;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTags(ArrayList<GProTag> arrayList) {
        this.tags = arrayList;
    }

    public String toString() {
        return "GProExtra{tags=" + this.tags + ",reports=" + this.reports + ",bizDataList=" + this.bizDataList + ",callback=" + this.callback + ",sessionId=" + this.sessionId + ",isRead=" + this.isRead + ",}";
    }

    public GProExtra(ArrayList<GProTag> arrayList, ArrayList<GProEntry> arrayList2, ArrayList<GProEntry> arrayList3, GProMVPItemCbData gProMVPItemCbData, String str) {
        this.serialVersionUID = 1L;
        this.tags = new ArrayList<>();
        this.reports = new ArrayList<>();
        this.bizDataList = new ArrayList<>();
        new GProMVPItemCbData();
        this.tags = arrayList;
        this.reports = arrayList2;
        this.bizDataList = arrayList3;
        this.callback = gProMVPItemCbData;
        this.sessionId = str;
    }
}
