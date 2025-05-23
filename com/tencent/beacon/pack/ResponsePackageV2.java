package com.tencent.beacon.pack;

/* loaded from: classes2.dex */
public final class ResponsePackageV2 extends AbstractResponseCommon implements Cloneable {
    public int result = 0;

    /* renamed from: msg, reason: collision with root package name */
    public String f78092msg = "";

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            com.tencent.beacon.base.util.c.a(e16);
            return null;
        }
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        this.result = aVar.a(this.result, 0, true);
        this.srcGatewayIp = aVar.a(1, true);
        this.serverTime = aVar.a(this.serverTime, 2, true);
        this.f78092msg = aVar.a(3, true);
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        bVar.a(this.result, 0);
        bVar.a(this.srcGatewayIp, 1);
        bVar.a(this.serverTime, 2);
        bVar.a(this.f78092msg, 3);
    }
}
