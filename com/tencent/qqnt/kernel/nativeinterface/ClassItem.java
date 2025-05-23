package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ClassItem implements Serializable {
    public int itemId;
    long serialVersionUID = 1;
    public String name = "";

    public int getItemId() {
        return this.itemId;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "ClassItem{itemId=" + this.itemId + ",name=" + this.name + ",}";
    }
}
