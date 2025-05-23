package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RegisterRes {
    public int batteryInterval;
    public int extStatus;
    public int helloInterval;

    /* renamed from: msg, reason: collision with root package name */
    public String f359205msg;
    public int result;
    public long serverTime;
    public int status;
    public int statusInterval;

    public RegisterRes() {
        this.f359205msg = "";
    }

    public int getBatteryInterval() {
        return this.batteryInterval;
    }

    public int getExtStatus() {
        return this.extStatus;
    }

    public int getHelloInterval() {
        return this.helloInterval;
    }

    public String getMsg() {
        return this.f359205msg;
    }

    public int getResult() {
        return this.result;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public int getStatus() {
        return this.status;
    }

    public int getStatusInterval() {
        return this.statusInterval;
    }

    public String toString() {
        return "RegisterRes{result=" + this.result + ",msg=" + this.f359205msg + ",serverTime=" + this.serverTime + ",helloInterval=" + this.helloInterval + ",status=" + this.status + ",extStatus=" + this.extStatus + ",batteryInterval=" + this.batteryInterval + ",statusInterval=" + this.statusInterval + ",}";
    }

    public RegisterRes(int i3, String str, long j3, int i16, int i17, int i18, int i19, int i26) {
        this.result = i3;
        this.f359205msg = str;
        this.serverTime = j3;
        this.helloInterval = i16;
        this.status = i17;
        this.extStatus = i18;
        this.batteryInterval = i19;
        this.statusInterval = i26;
    }
}
