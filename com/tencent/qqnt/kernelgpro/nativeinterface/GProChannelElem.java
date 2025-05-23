package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelElem implements Serializable {
    long serialVersionUID = 1;
    public GProStRichTextChannelContent channelContent = new GProStRichTextChannelContent();

    public GProStRichTextChannelContent getChannelContent() {
        return this.channelContent;
    }

    public String toString() {
        return "GProChannelElem{channelContent=" + this.channelContent + ",}";
    }
}
