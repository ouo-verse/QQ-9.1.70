package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class CustomSigContent extends JceStruct {
    static byte[] cache_SigContent;
    public byte[] SigContent;
    public long length;
    public short sResult;
    public long ulSigType;

    public CustomSigContent() {
        this.ulSigType = 0L;
        this.sResult = (short) 0;
        this.length = 0L;
        this.SigContent = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ulSigType = jceInputStream.read(this.ulSigType, 0, true);
        this.sResult = jceInputStream.read(this.sResult, 1, true);
        this.length = jceInputStream.read(this.length, 2, true);
        if (cache_SigContent == null) {
            cache_SigContent = r0;
            byte[] bArr = {0};
        }
        this.SigContent = jceInputStream.read(cache_SigContent, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ulSigType, 0);
        jceOutputStream.write(this.sResult, 1);
        jceOutputStream.write(this.length, 2);
        jceOutputStream.write(this.SigContent, 3);
    }

    public CustomSigContent(long j3, short s16, long j16, byte[] bArr) {
        this.ulSigType = j3;
        this.sResult = s16;
        this.length = j16;
        this.SigContent = bArr;
    }
}
