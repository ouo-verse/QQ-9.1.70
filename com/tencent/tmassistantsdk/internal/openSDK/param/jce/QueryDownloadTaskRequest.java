package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class QueryDownloadTaskRequest extends JceStruct {
    static IPCBaseParam cache_baseParam;
    public IPCBaseParam baseParam;

    public QueryDownloadTaskRequest() {
        this.baseParam = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_baseParam == null) {
            cache_baseParam = new IPCBaseParam();
        }
        this.baseParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_baseParam, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.baseParam, 0);
    }

    public QueryDownloadTaskRequest(IPCBaseParam iPCBaseParam) {
        this.baseParam = iPCBaseParam;
    }
}
