package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OSCheckLikeRsp {
    public int businessType;
    public int errCode;
    public String errMsg;
    public ArrayList<OSUinLikeInfo> likeInfo;

    public OSCheckLikeRsp() {
        this.likeInfo = new ArrayList<>();
        this.errMsg = "";
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public ArrayList<OSUinLikeInfo> getLikeInfo() {
        return this.likeInfo;
    }

    public String toString() {
        return "OSCheckLikeRsp{businessType=" + this.businessType + ",likeInfo=" + this.likeInfo + ",errCode=" + this.errCode + ",errMsg=" + this.errMsg + ",}";
    }

    public OSCheckLikeRsp(int i3, ArrayList<OSUinLikeInfo> arrayList, int i16, String str) {
        new ArrayList();
        this.businessType = i3;
        this.likeInfo = arrayList;
        this.errCode = i16;
        this.errMsg = str;
    }
}
