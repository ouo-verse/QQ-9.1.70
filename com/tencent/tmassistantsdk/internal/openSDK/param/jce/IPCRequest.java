package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes26.dex */
public final class IPCRequest extends JceStruct {
    static byte[] cache_body;
    static IPCHead cache_head;
    public byte[] body;
    public IPCHead head;

    public IPCRequest() {
        this.head = null;
        this.body = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_head == null) {
            cache_head = new IPCHead();
        }
        this.head = (IPCHead) jceInputStream.read((JceStruct) cache_head, 0, true);
        if (cache_body == null) {
            cache_body = r0;
            byte[] bArr = {0};
        }
        this.body = jceInputStream.read(cache_body, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.head, 0);
        byte[] bArr = this.body;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public IPCRequest(IPCHead iPCHead, byte[] bArr) {
        this.head = iPCHead;
        this.body = bArr;
    }
}
