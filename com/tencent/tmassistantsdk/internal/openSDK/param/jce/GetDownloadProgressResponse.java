package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes26.dex */
public final class GetDownloadProgressResponse extends JceStruct {
    static IPCBaseParam cache_requestParam;
    public long allTaskTotalLength;
    public long allTaskTotalProgress;
    public long receivedLen;
    public IPCBaseParam requestParam;
    public long totalLen;

    public GetDownloadProgressResponse() {
        this.requestParam = null;
        this.receivedLen = 0L;
        this.totalLen = 0L;
        this.allTaskTotalProgress = 0L;
        this.allTaskTotalLength = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_requestParam == null) {
            cache_requestParam = new IPCBaseParam();
        }
        this.requestParam = (IPCBaseParam) jceInputStream.read((JceStruct) cache_requestParam, 0, true);
        this.receivedLen = jceInputStream.read(this.receivedLen, 1, false);
        this.totalLen = jceInputStream.read(this.totalLen, 2, false);
        this.allTaskTotalProgress = jceInputStream.read(this.allTaskTotalProgress, 3, false);
        this.allTaskTotalLength = jceInputStream.read(this.allTaskTotalLength, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.requestParam, 0);
        jceOutputStream.write(this.receivedLen, 1);
        jceOutputStream.write(this.totalLen, 2);
        jceOutputStream.write(this.allTaskTotalProgress, 3);
        jceOutputStream.write(this.allTaskTotalLength, 4);
    }

    public GetDownloadProgressResponse(IPCBaseParam iPCBaseParam, long j3, long j16, long j17, long j18) {
        this.requestParam = iPCBaseParam;
        this.receivedLen = j3;
        this.totalLen = j16;
        this.allTaskTotalProgress = j17;
        this.allTaskTotalLength = j18;
    }
}
