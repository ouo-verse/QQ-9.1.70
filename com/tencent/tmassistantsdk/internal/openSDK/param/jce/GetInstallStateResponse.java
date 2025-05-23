package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetInstallStateResponse extends JceStruct {
    static IPCBaseParam cache_requestParam = new IPCBaseParam();
    public IPCBaseParam requestParam;
    public int state;

    public GetInstallStateResponse() {
        this.requestParam = null;
        this.state = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.requestParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_requestParam, 0, true);
        this.state = jceInputStream.read(this.state, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.requestParam, 0);
        jceOutputStream.write(this.state, 1);
    }

    public GetInstallStateResponse(IPCBaseParam iPCBaseParam, int i3) {
        this.requestParam = iPCBaseParam;
        this.state = i3;
    }
}
