package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception;

import java.io.IOException;

/* loaded from: classes23.dex */
public class WireParseException extends IOException {
    public WireParseException() {
    }

    public WireParseException(String str) {
        super(str);
    }

    public WireParseException(String str, Throwable th5) {
        super(str);
        initCause(th5);
    }
}
