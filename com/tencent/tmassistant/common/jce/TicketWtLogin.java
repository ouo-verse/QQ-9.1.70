package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TicketWtLogin extends JceStruct {
    static byte[] cache_A2;
    public byte[] A2;
    public long uin;

    static {
        cache_A2 = r0;
        byte[] bArr = {0};
    }

    public TicketWtLogin() {
        this.A2 = null;
        this.uin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.A2 = jceInputStream.read(cache_A2, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.A2;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        jceOutputStream.write(this.uin, 1);
    }

    public TicketWtLogin(byte[] bArr, long j3) {
        this.A2 = bArr;
        this.uin = j3;
    }
}
