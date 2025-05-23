package com.tencent.ark;

/* compiled from: P */
/* loaded from: classes3.dex */
interface IArkEGLContextManager {
    EGLContextHolder createContext(String str);

    EGLContextHolder getContext(String str);

    boolean releaseContext(String str);
}
