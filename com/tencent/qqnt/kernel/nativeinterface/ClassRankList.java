package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ClassRankList {
    public ClassItem msgClass = new ClassItem();
    public ArrayList<AppDetail> classApps = new ArrayList<>();

    public ArrayList<AppDetail> getClassApps() {
        return this.classApps;
    }

    public ClassItem getMsgClass() {
        return this.msgClass;
    }

    public String toString() {
        return "ClassRankList{msgClass=" + this.msgClass + ",classApps=" + this.classApps + ",}";
    }
}
