package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GroupCardPrefix {
    public String introduction = "";
    public ArrayList<String> rptPrefix = new ArrayList<>();

    public String getIntroduction() {
        return this.introduction;
    }

    public ArrayList<String> getRptPrefix() {
        return this.rptPrefix;
    }

    public String toString() {
        return "GroupCardPrefix{introduction=" + this.introduction + ",rptPrefix=" + this.rptPrefix + ",}";
    }
}
