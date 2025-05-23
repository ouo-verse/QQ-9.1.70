package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OSCheckLikeReq {
    public int businessType;
    public ArrayList<Long> uins;

    public OSCheckLikeReq() {
        this.uins = new ArrayList<>();
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public ArrayList<Long> getUins() {
        return this.uins;
    }

    public String toString() {
        return "OSCheckLikeReq{businessType=" + this.businessType + ",uins=" + this.uins + ",}";
    }

    public OSCheckLikeReq(int i3, ArrayList<Long> arrayList) {
        new ArrayList();
        this.businessType = i3;
        this.uins = arrayList;
    }
}
