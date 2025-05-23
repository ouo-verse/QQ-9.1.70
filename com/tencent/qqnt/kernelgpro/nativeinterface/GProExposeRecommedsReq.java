package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProExposeRecommedsReq {
    public ArrayList<GProExposeItem> exposeItems;
    public String stage;
    public String traceId;
    public String user;

    public GProExposeRecommedsReq() {
        this.user = "";
        this.traceId = "";
        this.stage = "";
        this.exposeItems = new ArrayList<>();
    }

    public ArrayList<GProExposeItem> getExposeItems() {
        return this.exposeItems;
    }

    public String getStage() {
        return this.stage;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUser() {
        return this.user;
    }

    public void setExposeItems(ArrayList<GProExposeItem> arrayList) {
        this.exposeItems = arrayList;
    }

    public void setStage(String str) {
        this.stage = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public String toString() {
        return "GProExposeRecommedsReq{user=" + this.user + ",traceId=" + this.traceId + ",stage=" + this.stage + ",exposeItems=" + this.exposeItems + ",}";
    }

    public GProExposeRecommedsReq(String str, String str2, String str3, ArrayList<GProExposeItem> arrayList) {
        this.user = "";
        this.traceId = "";
        this.stage = "";
        new ArrayList();
        this.user = str;
        this.traceId = str2;
        this.stage = str3;
        this.exposeItems = arrayList;
    }
}
