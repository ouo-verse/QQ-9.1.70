package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class WeChatOCRResultChar {
    public WeChatOcrBox charBox;
    public String charText;

    public WeChatOCRResultChar() {
        this.charText = "";
        this.charBox = new WeChatOcrBox();
    }

    public WeChatOcrBox getCharBox() {
        return this.charBox;
    }

    public String getCharText() {
        return this.charText;
    }

    public String toString() {
        return "WeChatOCRResultChar{charText=" + this.charText + ",charBox=" + this.charBox + ",}";
    }

    public WeChatOCRResultChar(String str, WeChatOcrBox weChatOcrBox) {
        this.charText = "";
        new WeChatOcrBox();
        this.charText = str;
        this.charBox = weChatOcrBox;
    }
}
