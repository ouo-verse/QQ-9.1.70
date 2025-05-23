package com.tencent.beacon.event.immediate;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class BeaconTransferArgs {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f77974a;

    /* renamed from: b, reason: collision with root package name */
    private String f77975b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f77976c = "";

    public BeaconTransferArgs(byte[] bArr) {
        this.f77974a = bArr;
    }

    public String getAppkey() {
        return this.f77975b;
    }

    public abstract String getCommand();

    public byte[] getData() {
        return this.f77974a;
    }

    public String getEventCode() {
        return this.f77976c;
    }

    public void setAppkey(String str) {
        this.f77975b = str;
    }

    public abstract void setCommand(String str);

    public void setData(byte[] bArr) {
        this.f77974a = bArr;
    }

    public void setEventCode(String str) {
        this.f77976c = str;
    }
}
