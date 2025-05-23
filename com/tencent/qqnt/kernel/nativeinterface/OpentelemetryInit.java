package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OpentelemetryInit {
    public boolean isInit;
    public boolean isReport;

    public OpentelemetryInit() {
    }

    public boolean getIsInit() {
        return this.isInit;
    }

    public boolean getIsReport() {
        return this.isReport;
    }

    public String toString() {
        return "OpentelemetryInit{isInit=" + this.isInit + ",isReport=" + this.isReport + ",}";
    }

    public OpentelemetryInit(boolean z16, boolean z17) {
        this.isInit = z16;
        this.isReport = z17;
    }
}
