package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DigestRichMsg {
    public int serviceId;
    public String xml = "";
    public String longMsgResId = "";

    public String getLongMsgResId() {
        return this.longMsgResId;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public String getXml() {
        return this.xml;
    }

    public String toString() {
        return "DigestRichMsg{serviceId=" + this.serviceId + ",xml=" + this.xml + ",longMsgResId=" + this.longMsgResId + ",}";
    }
}
