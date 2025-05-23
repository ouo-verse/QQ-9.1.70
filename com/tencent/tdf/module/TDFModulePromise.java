package com.tencent.tdf.module;

/* loaded from: classes26.dex */
public interface TDFModulePromise {
    String getCallId();

    boolean isCallback();

    void reject(Object obj);

    void resolve(Object obj);
}
