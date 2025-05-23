package com.tencent.beacon.event.immediate;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BeaconTransferResult {

    /* renamed from: a, reason: collision with root package name */
    private int f77977a;

    /* renamed from: b, reason: collision with root package name */
    private int f77978b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f77979c;

    /* renamed from: d, reason: collision with root package name */
    private String f77980d;

    public byte[] getBizBuffer() {
        return this.f77979c;
    }

    public int getBizCode() {
        return this.f77978b;
    }

    public String getBizMsg() {
        return this.f77980d;
    }

    public int getCode() {
        return this.f77977a;
    }

    public void setBizBuffer(byte[] bArr) {
        this.f77979c = bArr;
    }

    public void setBizCode(int i3) {
        this.f77978b = i3;
    }

    public void setBizMsg(String str) {
        this.f77980d = str;
    }

    public void setCode(int i3) {
        this.f77977a = i3;
    }

    public String toString() {
        return "BeaconTransferResult{returnCode=" + this.f77977a + ", bizReturnCode=" + this.f77978b + ", bizMsg='" + this.f77980d + "'}";
    }
}
