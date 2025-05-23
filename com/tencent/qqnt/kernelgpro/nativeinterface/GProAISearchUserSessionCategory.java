package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAISearchUserSessionCategory {
    public String categoryName = "";
    public ArrayList<GProAISearchSession> sessionList = new ArrayList<>();

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<GProAISearchSession> getSessionList() {
        return this.sessionList;
    }

    public String toString() {
        return "GProAISearchUserSessionCategory{categoryName=" + this.categoryName + ",sessionList=" + this.sessionList + ",}";
    }
}
