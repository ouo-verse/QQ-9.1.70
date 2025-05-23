package com.tencent.biz.pubaccount.accountdetail.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GetRecvMsgStateReq extends JceStruct implements Cloneable {
    public long puin = 0;
    public long uin = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.puin = jceInputStream.read(this.puin, 0, true);
        this.uin = jceInputStream.read(this.uin, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.puin, 0);
        jceOutputStream.write(this.uin, 1);
    }
}
