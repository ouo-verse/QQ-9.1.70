package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetDownloadStateResponse extends JceStruct {
    static IPCBaseParam cache_requestParam;
    public int errorCode;
    public String errorMsg;
    public IPCBaseParam requestParam;
    public int state;

    public GetDownloadStateResponse() {
        this.requestParam = null;
        this.state = 0;
        this.errorCode = 0;
        this.errorMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_requestParam == null) {
            cache_requestParam = new IPCBaseParam();
        }
        this.requestParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_requestParam, 0, true);
        this.state = jceInputStream.read(this.state, 1, false);
        this.errorCode = jceInputStream.read(this.errorCode, 2, false);
        this.errorMsg = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.requestParam, 0);
        jceOutputStream.write(this.state, 1);
        jceOutputStream.write(this.errorCode, 2);
        String str = this.errorMsg;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public GetDownloadStateResponse(IPCBaseParam iPCBaseParam, int i3, int i16, String str) {
        this.requestParam = iPCBaseParam;
        this.state = i3;
        this.errorCode = i16;
        this.errorMsg = str;
    }
}
