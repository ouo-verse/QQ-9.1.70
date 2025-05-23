package com.tencent.beacon.pack;

/* loaded from: classes2.dex */
public final class ResponsePackage extends AbstractResponseCommon {
    static byte[] cache_sBuffer;
    public int cmd;
    public String encryKey;
    public String encryPublicKey;
    public byte encryType;
    public byte result;
    public byte[] sBuffer;
    public byte zipType;

    public ResponsePackage() {
        this.result = (byte) 0;
        this.cmd = 0;
        this.sBuffer = null;
        this.encryType = (byte) 0;
        this.zipType = (byte) 0;
        this.encryKey = "";
        this.encryPublicKey = "";
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        this.result = aVar.a(this.result, 0, true);
        this.cmd = aVar.a(this.cmd, 1, true);
        if (cache_sBuffer == null) {
            cache_sBuffer = r0;
            byte[] bArr = {0};
        }
        this.sBuffer = aVar.a(cache_sBuffer, 2, true);
        this.srcGatewayIp = aVar.a(3, true);
        this.encryType = aVar.a(this.encryType, 4, true);
        this.zipType = aVar.a(this.zipType, 5, true);
        this.serverTime = aVar.a(this.serverTime, 6, true);
        this.encryKey = aVar.a(7, false);
        this.encryPublicKey = aVar.a(8, false);
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        bVar.a(this.result, 0);
        bVar.a(this.cmd, 1);
        bVar.a(this.sBuffer, 2);
        bVar.a(this.srcGatewayIp, 3);
        bVar.a(this.encryType, 4);
        bVar.a(this.zipType, 5);
        bVar.a(this.serverTime, 6);
        String str = this.encryKey;
        if (str != null) {
            bVar.a(str, 7);
        }
        String str2 = this.encryPublicKey;
        if (str2 != null) {
            bVar.a(str2, 8);
        }
    }

    public ResponsePackage(byte b16, int i3, byte[] bArr, String str, byte b17, byte b18, long j3, String str2, String str3) {
        this.result = b16;
        this.cmd = i3;
        this.sBuffer = bArr;
        this.srcGatewayIp = str;
        this.encryType = b17;
        this.zipType = b18;
        this.serverTime = j3;
        this.encryKey = str2;
        this.encryPublicKey = str3;
    }
}
