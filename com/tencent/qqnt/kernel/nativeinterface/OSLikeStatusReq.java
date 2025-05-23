package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OSLikeStatusReq {
    public int businessType;
    public long isCancel;
    public ArrayList<OSLikeItem> likeItems;
    public long uin;

    public OSLikeStatusReq() {
        this.likeItems = new ArrayList<>();
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public long getIsCancel() {
        return this.isCancel;
    }

    public ArrayList<OSLikeItem> getLikeItems() {
        return this.likeItems;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "OSLikeStatusReq{businessType=" + this.businessType + ",uin=" + this.uin + ",likeItems=" + this.likeItems + ",isCancel=" + this.isCancel + ",}";
    }

    public OSLikeStatusReq(int i3, long j3, ArrayList<OSLikeItem> arrayList, long j16) {
        new ArrayList();
        this.businessType = i3;
        this.uin = j3;
        this.likeItems = arrayList;
        this.isCancel = j16;
    }
}
