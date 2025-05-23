package com.tencent.mtt.hippy.common;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class HippyJsException extends Exception {
    private final String mStack;

    public HippyJsException(String str, String str2) {
        super(str);
        this.mStack = str2;
    }

    public String getStack() {
        return this.mStack;
    }
}
