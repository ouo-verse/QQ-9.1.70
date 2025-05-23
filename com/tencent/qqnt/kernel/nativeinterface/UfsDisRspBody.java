package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisRspBody {
    public int expireTime;
    public long expireTimeStamp;
    public boolean isJumpToNetResultPage;
    public int resultCode;
    public ArrayList<UfsDisResult> resultItems = new ArrayList<>();
    public String errorMsg = "";
    public String bucketId = "";
    public byte[] rspExt = new byte[0];
    public ArrayList<UfsDisTabBizPair> tabConfigList = new ArrayList<>();

    public String getBucketId() {
        return this.bucketId;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getExpireTime() {
        return this.expireTime;
    }

    public long getExpireTimeStamp() {
        return this.expireTimeStamp;
    }

    public boolean getIsJumpToNetResultPage() {
        return this.isJumpToNetResultPage;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public ArrayList<UfsDisResult> getResultItems() {
        return this.resultItems;
    }

    public byte[] getRspExt() {
        return this.rspExt;
    }

    public ArrayList<UfsDisTabBizPair> getTabConfigList() {
        return this.tabConfigList;
    }

    public String toString() {
        return "UfsDisRspBody{resultItems=" + this.resultItems + ",resultCode=" + this.resultCode + ",errorMsg=" + this.errorMsg + ",expireTime=" + this.expireTime + ",bucketId=" + this.bucketId + ",rspExt=" + this.rspExt + ",isJumpToNetResultPage=" + this.isJumpToNetResultPage + ",tabConfigList=" + this.tabConfigList + ",expireTimeStamp=" + this.expireTimeStamp + ",}";
    }
}
