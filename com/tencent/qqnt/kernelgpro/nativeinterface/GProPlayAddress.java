package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPlayAddress implements Serializable {
    public Integer bitRate;
    public String formats;
    long serialVersionUID = 1;
    public String url;

    public Integer getBitRate() {
        return this.bitRate;
    }

    public String getFormats() {
        return this.formats;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProPlayAddress{url=" + this.url + ",bitRate=" + this.bitRate + ",formats=" + this.formats + ",}";
    }
}
