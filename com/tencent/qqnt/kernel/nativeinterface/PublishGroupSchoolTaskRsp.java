package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PublishGroupSchoolTaskRsp {
    public ArrayList<GroupSchoolTaskIndex> tasks = new ArrayList<>();

    public ArrayList<GroupSchoolTaskIndex> getTasks() {
        return this.tasks;
    }

    public String toString() {
        return "PublishGroupSchoolTaskRsp{tasks=" + this.tasks + ",}";
    }
}
