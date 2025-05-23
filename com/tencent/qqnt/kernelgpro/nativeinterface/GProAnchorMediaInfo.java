package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAnchorMediaInfo {
    public String serverPart;
    public String sig;
    public String streamParam;
    public Long timeout;
    public Long type;

    public String getServerPart() {
        return this.serverPart;
    }

    public String getSig() {
        return this.sig;
    }

    public String getStreamParam() {
        return this.streamParam;
    }

    public Long getTimeout() {
        return this.timeout;
    }

    public Long getType() {
        return this.type;
    }

    public String toString() {
        return "GProAnchorMediaInfo{sig=" + this.sig + ",timeout=" + this.timeout + ",type=" + this.type + ",serverPart=" + this.serverPart + ",streamParam=" + this.streamParam + ",}";
    }
}
