package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class SetSpacePermissionReq {
    public Integer domain;
    public ArrayList<UserPermission> friendPermissionList;

    public SetSpacePermissionReq() {
        this.friendPermissionList = new ArrayList<>();
    }

    public Integer getDomain() {
        return this.domain;
    }

    public ArrayList<UserPermission> getFriendPermissionList() {
        return this.friendPermissionList;
    }

    public SetSpacePermissionReq(ArrayList<UserPermission> arrayList, Integer num) {
        new ArrayList();
        this.friendPermissionList = arrayList;
        this.domain = num;
    }
}
