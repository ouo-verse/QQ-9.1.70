package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MoveBottomEmojiTableReq {
    public CommonBottomEmojiReq commonBottomEmojiReqInfo = new CommonBottomEmojiReq();
    public ArrayList<Integer> tabIdList = new ArrayList<>();
    public ArrayList<CommonTabEmojiInfo> emojiNewTabs = new ArrayList<>();

    public CommonBottomEmojiReq getCommonBottomEmojiReqInfo() {
        return this.commonBottomEmojiReqInfo;
    }

    public ArrayList<CommonTabEmojiInfo> getEmojiNewTabs() {
        return this.emojiNewTabs;
    }

    public ArrayList<Integer> getTabIdList() {
        return this.tabIdList;
    }

    public String toString() {
        return "MoveBottomEmojiTableReq{commonBottomEmojiReqInfo=" + this.commonBottomEmojiReqInfo + ",tabIdList=" + this.tabIdList + ",emojiNewTabs=" + this.emojiNewTabs + ",}";
    }
}
