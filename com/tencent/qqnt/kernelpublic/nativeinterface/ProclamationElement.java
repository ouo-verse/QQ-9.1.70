package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class ProclamationElement implements Serializable {
    public int isSetProclamation;
    long serialVersionUID = 1;

    public ProclamationElement() {
    }

    public int getIsSetProclamation() {
        return this.isSetProclamation;
    }

    public String toString() {
        return "ProclamationElement{isSetProclamation=" + this.isSetProclamation + ",}";
    }

    public ProclamationElement(int i3) {
        this.isSetProclamation = i3;
    }
}
