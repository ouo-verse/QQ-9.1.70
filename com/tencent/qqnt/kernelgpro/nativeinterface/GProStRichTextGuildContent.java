package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStRichTextGuildContent implements Serializable {
    long serialVersionUID = 1;
    public GProStChannelInfo channelInfo = new GProStChannelInfo();

    public GProStChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public String toString() {
        return "GProStRichTextGuildContent{channelInfo=" + this.channelInfo + ",}";
    }
}
