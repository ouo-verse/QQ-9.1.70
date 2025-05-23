package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddyGrayElement implements Serializable {
    public NewBuddyGrayElement elem;
    long serialVersionUID = 1;
    public int type;

    public BuddyGrayElement() {
    }

    public NewBuddyGrayElement getElem() {
        return this.elem;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "BuddyGrayElement{type=" + this.type + ",elem=" + this.elem + ",}";
    }

    public BuddyGrayElement(int i3, NewBuddyGrayElement newBuddyGrayElement) {
        this.type = i3;
        this.elem = newBuddyGrayElement;
    }
}
