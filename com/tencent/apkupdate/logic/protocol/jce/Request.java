package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class Request extends JceStruct {
    public static byte[] cache_body;
    public static ReqHead cache_head;
    public ReqHead head = null;
    public byte[] body = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_head == null) {
            cache_head = new ReqHead();
        }
        this.head = (ReqHead) jceInputStream.read((JceStruct) cache_head, 0, true);
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
}
