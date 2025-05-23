package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AnonyStatus {
    public int forbidTalking;
    public String statusInfo;

    public AnonyStatus() {
        this.statusInfo = "";
    }

    public int getForbidTalking() {
        return this.forbidTalking;
    }

    public String getStatusInfo() {
        return this.statusInfo;
    }

    public String toString() {
        return "AnonyStatus{forbidTalking=" + this.forbidTalking + ",statusInfo=" + this.statusInfo + ",}";
    }

    public AnonyStatus(int i3, String str) {
        this.forbidTalking = i3;
        this.statusInfo = str;
    }
}
