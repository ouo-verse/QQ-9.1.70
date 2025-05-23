package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class OpentelemetryTracePlan {
    public boolean isOpen;
    public boolean isReport;

    public OpentelemetryTracePlan() {
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public boolean getIsReport() {
        return this.isReport;
    }

    public String toString() {
        return "OpentelemetryTracePlan{isOpen=" + this.isOpen + ",isReport=" + this.isReport + ",}";
    }

    public OpentelemetryTracePlan(boolean z16, boolean z17) {
        this.isOpen = z16;
        this.isReport = z17;
    }
}
