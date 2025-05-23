package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DelMarketEmojiTabReq {
    public int tabId;
    public CommonBottomEmojiReq commonBottomEmojiReqInfo = new CommonBottomEmojiReq();
    public ArrayList<Integer> tabIds = new ArrayList<>();

    public CommonBottomEmojiReq getCommonBottomEmojiReqInfo() {
        return this.commonBottomEmojiReqInfo;
    }

    public int getTabId() {
        return this.tabId;
    }

    public ArrayList<Integer> getTabIds() {
        return this.tabIds;
    }

    public String toString() {
        return "DelMarketEmojiTabReq{commonBottomEmojiReqInfo=" + this.commonBottomEmojiReqInfo + ",tabId=" + this.tabId + ",tabIds=" + this.tabIds + ",}";
    }
}
