package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FetchBottomEmojiTableListReq {
    public CommonBottomEmojiReq commonReqInfo = new CommonBottomEmojiReq();
    public int segmentFlag;
    public int timeStamp;

    public CommonBottomEmojiReq getCommonReqInfo() {
        return this.commonReqInfo;
    }

    public int getSegmentFlag() {
        return this.segmentFlag;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public String toString() {
        return "FetchBottomEmojiTableListReq{commonReqInfo=" + this.commonReqInfo + ",timeStamp=" + this.timeStamp + ",segmentFlag=" + this.segmentFlag + ",}";
    }
}
