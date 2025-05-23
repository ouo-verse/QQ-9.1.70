package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisGuessWantSearch {
    public String title = "";
    public ArrayList<UfsDisGuessWantItem> items = new ArrayList<>();

    public ArrayList<UfsDisGuessWantItem> getItems() {
        return this.items;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "UfsDisGuessWantSearch{title=" + this.title + ",items=" + this.items + ",}";
    }
}
