package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchGetGroupSchoolRoleRsp {
    public ArrayList<GroupSchoolRole> roles = new ArrayList<>();

    public ArrayList<GroupSchoolRole> getRoles() {
        return this.roles;
    }

    public String toString() {
        return "BatchGetGroupSchoolRoleRsp{roles=" + this.roles + ",}";
    }
}
