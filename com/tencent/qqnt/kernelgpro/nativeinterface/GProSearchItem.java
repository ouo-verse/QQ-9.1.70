package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSearchItem implements Serializable {
    public String desc;
    public ArrayList<String> guildLogos;
    long serialVersionUID;

    public GProSearchItem() {
        this.serialVersionUID = 1L;
        this.guildLogos = new ArrayList<>();
        this.desc = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<String> getGuildLogos() {
        return this.guildLogos;
    }

    public String toString() {
        return "GProSearchItem{guildLogos=" + this.guildLogos + ",desc=" + this.desc + ",}";
    }

    public GProSearchItem(ArrayList<String> arrayList, String str) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.guildLogos = arrayList;
        this.desc = str;
    }
}
