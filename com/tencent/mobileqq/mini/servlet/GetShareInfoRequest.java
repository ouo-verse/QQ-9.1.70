package com.tencent.mobileqq.mini.servlet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetShareInfoRequest extends ProtoBufRequest {
    private final byte[] byteData;

    public GetShareInfoRequest(byte[] bArr) {
        this.byteData = bArr;
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.byteData;
    }
}
