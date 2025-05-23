package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendGuildState implements Serializable {
    public String desc;
    public ArrayList<String> iconUrls;
    long serialVersionUID;
    public int state;

    public GProRecommendGuildState() {
        this.serialVersionUID = 1L;
        this.desc = "";
        this.iconUrls = new ArrayList<>();
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<String> getIconUrls() {
        return this.iconUrls;
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        return "GProRecommendGuildState{state=" + this.state + ",desc=" + this.desc + ",iconUrls=" + this.iconUrls + ",}";
    }

    public GProRecommendGuildState(int i3, String str, ArrayList<String> arrayList) {
        this.serialVersionUID = 1L;
        this.desc = "";
        new ArrayList();
        this.state = i3;
        this.desc = str;
        this.iconUrls = arrayList;
    }
}
