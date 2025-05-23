package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupNotifyUser implements Serializable {
    long serialVersionUID = 1;
    public String uid = "";
    public String nickName = "";

    public String getNickName() {
        return this.nickName;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "GroupNotifyUser{uid=" + this.uid + ",nickName=" + this.nickName + ",}";
    }
}
