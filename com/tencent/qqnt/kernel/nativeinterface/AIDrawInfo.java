package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AIDrawInfo {
    public StyleFunction styleFunction = new StyleFunction();
    public RequireFunction requireFunction = new RequireFunction();
    public ReviseFunction reviseFunction = new ReviseFunction();

    public RequireFunction getRequireFunction() {
        return this.requireFunction;
    }

    public ReviseFunction getReviseFunction() {
        return this.reviseFunction;
    }

    public StyleFunction getStyleFunction() {
        return this.styleFunction;
    }

    public String toString() {
        return "AIDrawInfo{styleFunction=" + this.styleFunction + ",requireFunction=" + this.requireFunction + ",reviseFunction=" + this.reviseFunction + ",}";
    }
}
