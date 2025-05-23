package com.tencent.qqlive.module.videoreport.sample.interceptor;

/* compiled from: P */
/* loaded from: classes22.dex */
public enum InterceptorIndex {
    INTERCEPTOR_HEAD(0),
    INTERCEPTOR_EVENT(1),
    INTERCEPTOR_PAGE(2),
    INTERCEPTOR_ELEMENT(3),
    INTERCEPTOR_PARAMS(4),
    INTERCEPTOR_RATE(5);

    private final int index;

    InterceptorIndex(int i3) {
        this.index = i3;
    }

    public int getIndex() {
        return this.index;
    }

    public int next() {
        return this.index + 1;
    }
}
