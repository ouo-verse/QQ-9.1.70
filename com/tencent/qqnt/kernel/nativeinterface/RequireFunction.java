package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RequireFunction {
    public String title = "";
    public ArrayList<RequireList> requireList = new ArrayList<>();

    public ArrayList<RequireList> getRequireList() {
        return this.requireList;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "RequireFunction{title=" + this.title + ",requireList=" + this.requireList + ",}";
    }
}
