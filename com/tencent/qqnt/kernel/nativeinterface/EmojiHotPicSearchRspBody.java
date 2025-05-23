package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class EmojiHotPicSearchRspBody {
    public boolean allowCompose;
    public ArrayList<EmojiHotPicSearchEmojiInfo> composeEmojis;
    public String errorMsg;
    public ArrayList<EmojiHotPicSearchEmojiInfo> infoArray;
    public String other;
    public boolean pageHasNext;
    public int resultCode;
    public byte[] sessionInfo;

    public EmojiHotPicSearchRspBody() {
    }

    public boolean getAllowCompose() {
        return this.allowCompose;
    }

    public ArrayList<EmojiHotPicSearchEmojiInfo> getComposeEmojis() {
        return this.composeEmojis;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public ArrayList<EmojiHotPicSearchEmojiInfo> getInfoArray() {
        return this.infoArray;
    }

    public String getOther() {
        return this.other;
    }

    public boolean getPageHasNext() {
        return this.pageHasNext;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public byte[] getSessionInfo() {
        return this.sessionInfo;
    }

    public EmojiHotPicSearchRspBody(int i3, String str, ArrayList<EmojiHotPicSearchEmojiInfo> arrayList, String str2, boolean z16, byte[] bArr, ArrayList<EmojiHotPicSearchEmojiInfo> arrayList2, boolean z17) {
        this.resultCode = i3;
        this.errorMsg = str;
        this.infoArray = arrayList;
        this.other = str2;
        this.pageHasNext = z16;
        this.sessionInfo = bArr;
        this.composeEmojis = arrayList2;
        this.allowCompose = z17;
    }
}
