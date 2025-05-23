package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ModifyBottomEmojiTableSwitchStatusReq {
    public CommonBottomEmojiReq commonBottomEmojiReqInfo = new CommonBottomEmojiReq();
    public ArrayList<CommonTabEmojiInfo> emojiNewTabs = new ArrayList<>();

    public CommonBottomEmojiReq getCommonBottomEmojiReqInfo() {
        return this.commonBottomEmojiReqInfo;
    }

    public ArrayList<CommonTabEmojiInfo> getEmojiNewTabs() {
        return this.emojiNewTabs;
    }

    public String toString() {
        return "ModifyBottomEmojiTableSwitchStatusReq{commonBottomEmojiReqInfo=" + this.commonBottomEmojiReqInfo + ",emojiNewTabs=" + this.emojiNewTabs + ",}";
    }
}
