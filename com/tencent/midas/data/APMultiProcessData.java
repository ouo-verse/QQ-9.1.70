package com.tencent.midas.data;

/* loaded from: classes9.dex */
public class APMultiProcessData {
    private String guid = "";
    private long payInterfaceTime = 0;
    private int intervalTime = 0;

    public String getGuid() {
        return this.guid;
    }

    public int getIntervalTime() {
        return this.intervalTime;
    }

    public long getPayInterfaceTime() {
        return this.payInterfaceTime;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setIntervalTime(int i3) {
        this.intervalTime = i3;
    }

    public void setPayInterfaceTime(long j3) {
        this.payInterfaceTime = j3;
    }
}
