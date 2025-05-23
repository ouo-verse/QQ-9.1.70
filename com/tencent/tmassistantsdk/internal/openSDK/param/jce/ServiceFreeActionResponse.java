package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ServiceFreeActionResponse extends JceStruct {
    static byte[] cache_revertField;
    public byte[] revertField;

    public ServiceFreeActionResponse() {
        this.revertField = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_revertField == null) {
            cache_revertField = r0;
            byte[] bArr = {0};
        }
        this.revertField = jceInputStream.read(cache_revertField, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.revertField;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }

    public ServiceFreeActionResponse(byte[] bArr) {
        this.revertField = bArr;
    }
}
