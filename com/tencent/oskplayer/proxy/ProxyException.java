package com.tencent.oskplayer.proxy;

import java.io.IOException;

/* loaded from: classes22.dex */
public class ProxyException extends IOException {
    public final int errCode;

    public ProxyException(String str) {
        super(str);
        this.errCode = 0;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public ProxyException(String str, int i3) {
        super(str);
        this.errCode = i3;
    }
}
