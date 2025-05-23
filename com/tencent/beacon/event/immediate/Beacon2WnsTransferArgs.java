package com.tencent.beacon.event.immediate;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Beacon2WnsTransferArgs extends BeaconTransferArgs {

    /* renamed from: d, reason: collision with root package name */
    private String f77969d;

    public Beacon2WnsTransferArgs(byte[] bArr) {
        super(bArr);
        this.f77969d = "bls.longconnection";
    }

    @Override // com.tencent.beacon.event.immediate.BeaconTransferArgs
    public String getCommand() {
        return this.f77969d;
    }

    @Override // com.tencent.beacon.event.immediate.BeaconTransferArgs
    public void setCommand(String str) {
        this.f77969d = str;
    }
}
