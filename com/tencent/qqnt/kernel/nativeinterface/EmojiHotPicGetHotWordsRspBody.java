package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class EmojiHotPicGetHotWordsRspBody {
    public String errorMsg;
    public ArrayList<EmojiHotPicHotWordsItem> items;
    public int resultCode;
    public int size;
    public String traceId;

    public EmojiHotPicGetHotWordsRspBody() {
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public ArrayList<EmojiHotPicHotWordsItem> getItems() {
        return this.items;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public int getSize() {
        return this.size;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public EmojiHotPicGetHotWordsRspBody(int i3, String str, String str2, int i16, ArrayList<EmojiHotPicHotWordsItem> arrayList) {
        this.resultCode = i3;
        this.errorMsg = str;
        this.traceId = str2;
        this.size = i16;
        this.items = arrayList;
    }
}
