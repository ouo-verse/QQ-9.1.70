package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class Response extends JceStruct {
    public static byte[] cache_body;
    public static RspHead cache_head;
    public RspHead head = null;
    public byte[] body = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_head == null) {
            cache_head = new RspHead();
        }
        this.head = (RspHead) jceInputStream.read((JceStruct) cache_head, 0, true);
        if (cache_body == null) {
            cache_body = r0;
            byte[] bArr = {0};
        }
        this.body = jceInputStream.read(cache_body, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.head, 0);
        jceOutputStream.write(this.body, 1);
    }
}
