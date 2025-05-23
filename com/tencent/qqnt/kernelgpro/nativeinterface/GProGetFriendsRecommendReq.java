package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGetFriendsRecommendReq implements Serializable {
    public int pageNum;
    long serialVersionUID = 1;

    public int getPageNum() {
        return this.pageNum;
    }

    public String toString() {
        return "GProGetFriendsRecommendReq{pageNum=" + this.pageNum + ",}";
    }
}
