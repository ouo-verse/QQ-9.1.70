package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CreateGroupGrayElement implements Serializable {
    public ArrayList<GrayTipMember> memberInfo;
    long serialVersionUID;

    public CreateGroupGrayElement() {
        this.serialVersionUID = 1L;
        this.memberInfo = new ArrayList<>();
    }

    public ArrayList<GrayTipMember> getMemberInfo() {
        return this.memberInfo;
    }

    public String toString() {
        return "CreateGroupGrayElement{memberInfo=" + this.memberInfo + ",}";
    }

    public CreateGroupGrayElement(ArrayList<GrayTipMember> arrayList) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.memberInfo = arrayList;
    }
}
