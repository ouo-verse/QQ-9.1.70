package com.tencent.midas.data;

/* loaded from: classes9.dex */
public class APInitData {
    private static APInitData gInstance;
    private static int initdataCount;
    private String initGUID;
    private long initInterfaceTime;

    APInitData() {
        initdataCount = 0;
        this.initInterfaceTime = 0L;
        this.initGUID = "";
    }

    public static int getInitdataCount() {
        int i3 = initdataCount;
        initdataCount = i3 + 1;
        return i3;
    }

    public static void init() {
        gInstance = new APInitData();
    }

    public static void setInitdataCount(int i3) {
        initdataCount = i3;
    }

    public static APInitData singleton() {
        if (gInstance == null) {
            gInstance = new APInitData();
        }
        return gInstance;
    }

    public String getInitGUID() {
        return this.initGUID;
    }

    public long getInitInterfaceTime() {
        return this.initInterfaceTime;
    }

    public void setInitGUID(String str) {
        this.initGUID = str;
    }

    public void setInitInterfaceTime(long j3) {
        this.initInterfaceTime = j3;
    }
}
