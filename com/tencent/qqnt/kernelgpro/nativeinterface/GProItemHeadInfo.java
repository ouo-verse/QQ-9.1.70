package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProItemHeadInfo implements Serializable {
    public String onlineNums;
    long serialVersionUID;
    public ArrayList<GProConditionalTag> tags;

    public GProItemHeadInfo() {
        this.serialVersionUID = 1L;
        this.onlineNums = "";
        this.tags = new ArrayList<>();
    }

    public String getOnlineNums() {
        return this.onlineNums;
    }

    public ArrayList<GProConditionalTag> getTags() {
        return this.tags;
    }

    public String toString() {
        return "GProItemHeadInfo{onlineNums=" + this.onlineNums + ",tags=" + this.tags + ",}";
    }

    public GProItemHeadInfo(String str, ArrayList<GProConditionalTag> arrayList) {
        this.serialVersionUID = 1L;
        this.onlineNums = "";
        new ArrayList();
        this.onlineNums = str;
        this.tags = arrayList;
    }
}
