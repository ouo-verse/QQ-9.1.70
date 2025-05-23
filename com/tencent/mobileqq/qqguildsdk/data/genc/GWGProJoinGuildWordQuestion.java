package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GWGProJoinGuildWordQuestion implements Serializable {
    protected ArrayList<GWGProJoinGuildWordQuestionItem> mItems = new ArrayList<>();

    public ArrayList<GWGProJoinGuildWordQuestionItem> getItems() {
        return this.mItems;
    }

    public void setItems(ArrayList<GWGProJoinGuildWordQuestionItem> arrayList) {
        this.mItems = arrayList;
    }

    public String toString() {
        return "GWGProJoinGuildWordQuestion{mItems=" + this.mItems + "}";
    }
}
