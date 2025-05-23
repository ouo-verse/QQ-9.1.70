package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GrayTipMember implements Serializable {
    public String name;
    long serialVersionUID;
    public String uid;

    public GrayTipMember() {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "GrayTipMember{uid=" + this.uid + ",name=" + this.name + ",}";
    }

    public GrayTipMember(String str, String str2) {
        this.serialVersionUID = 1L;
        this.uid = str;
        this.name = str2;
    }
}
