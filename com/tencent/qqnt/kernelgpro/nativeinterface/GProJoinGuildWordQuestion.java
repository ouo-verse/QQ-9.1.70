package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProJoinGuildWordQuestion implements Serializable {
    public ArrayList<GProJoinGuildWordQuestionItem> items;
    long serialVersionUID;

    public GProJoinGuildWordQuestion() {
        this.serialVersionUID = 1L;
        this.items = new ArrayList<>();
    }

    public ArrayList<GProJoinGuildWordQuestionItem> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<GProJoinGuildWordQuestionItem> arrayList) {
        this.items = arrayList;
    }

    public String toString() {
        return "GProJoinGuildWordQuestion{items=" + this.items + ",}";
    }

    public GProJoinGuildWordQuestion(ArrayList<GProJoinGuildWordQuestionItem> arrayList) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.items = arrayList;
    }
}
