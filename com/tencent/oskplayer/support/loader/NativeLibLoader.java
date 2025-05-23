package com.tencent.oskplayer.support.loader;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface NativeLibLoader {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum State {
        WAIT,
        TRUE,
        FALSE
    }

    State isLibReadyToLoad(String str);

    void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException;
}
