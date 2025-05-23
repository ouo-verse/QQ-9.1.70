package com.tencent.biz.pubaccount.accountdetail.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GetRecvMsgStateRsp extends JceStruct implements Cloneable {
    public int result = 0;
    public String reason = "";
    public int state = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.reason = jceInputStream.readString(1, false);
        this.state = jceInputStream.read(this.state, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        String str = this.reason;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.state, 2);
    }
}
