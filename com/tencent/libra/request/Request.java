package com.tencent.libra.request;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface Request {
    void begin();

    void clear();

    boolean isAnyResourceSet();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(Request request);

    boolean isRunning();

    void pause();
}
