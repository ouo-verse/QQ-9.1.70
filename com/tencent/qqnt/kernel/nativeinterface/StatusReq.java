package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StatusReq {
    public int batteryStatus;
    public CustomStatus customStatus;
    public int extStatus;
    public int status;

    public StatusReq() {
    }

    public int getBatteryStatus() {
        return this.batteryStatus;
    }

    public CustomStatus getCustomStatus() {
        return this.customStatus;
    }

    public int getExtStatus() {
        return this.extStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public void setBatteryStatus(int i3) {
        this.batteryStatus = i3;
    }

    public void setCustomStatus(CustomStatus customStatus) {
        this.customStatus = customStatus;
    }

    public void setExtStatus(int i3) {
        this.extStatus = i3;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public String toString() {
        return "StatusReq{status=" + this.status + ",extStatus=" + this.extStatus + ",batteryStatus=" + this.batteryStatus + ",customStatus=" + this.customStatus + ",}";
    }

    public StatusReq(int i3, int i16, int i17, CustomStatus customStatus) {
        this.status = i3;
        this.extStatus = i16;
        this.batteryStatus = i17;
        this.customStatus = customStatus;
    }
}
