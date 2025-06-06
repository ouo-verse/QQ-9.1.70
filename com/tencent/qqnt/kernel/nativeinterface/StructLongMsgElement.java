package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StructLongMsgElement {
    public String resId;
    public String xmlContent;

    public StructLongMsgElement() {
    }

    public String getResId() {
        return this.resId;
    }

    public String getXmlContent() {
        return this.xmlContent;
    }

    public String toString() {
        return "StructLongMsgElement{xmlContent=" + this.xmlContent + ",resId=" + this.resId + ",}";
    }

    public StructLongMsgElement(String str, String str2) {
        this.xmlContent = str;
        this.resId = str2;
    }
}
