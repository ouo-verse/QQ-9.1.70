package com.tencent.oskplayer.proxy;

/* loaded from: classes22.dex */
public class LivePlayListException extends Exception {
    private static final long serialVersionUID = 8852006662656030558L;

    public LivePlayListException(String str) {
        super(str);
    }

    public LivePlayListException(Throwable th5) {
        super(th5 == null ? null : th5.toString(), th5);
    }
}
