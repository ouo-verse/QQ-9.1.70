package com.tencent.beacon.event.immediate;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Beacon2MsfTransferArgs extends BeaconTransferArgs {

    /* renamed from: d, reason: collision with root package name */
    private String f77968d;

    public Beacon2MsfTransferArgs(byte[] bArr) {
        super(bArr);
        this.f77968d = "trpc.Beacon.BeaconLogServerLC.blslongconnection.SsoProcess";
    }

    @Override // com.tencent.beacon.event.immediate.BeaconTransferArgs
    public String getCommand() {
        return this.f77968d;
    }

    @Override // com.tencent.beacon.event.immediate.BeaconTransferArgs
    public void setCommand(String str) {
        this.f77968d = str;
    }
}
