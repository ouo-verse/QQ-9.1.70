package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GroupPermission implements Serializable {
    public int key;
    long serialVersionUID = 1;
    public GroupAuthority authority = new GroupAuthority();

    public GroupAuthority getAuthority() {
        return this.authority;
    }

    public int getKey() {
        return this.key;
    }

    public String toString() {
        return "GroupPermission{key=" + this.key + ",authority=" + this.authority + ",}";
    }
}
