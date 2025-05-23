package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes26.dex */
public final class IPCQueryDownloadInfo extends JceStruct {
    public long allTaskTotalLength;
    public long allTaskTotalProgress;
    public long receivedLen;
    public String savePath;
    public int state;
    public long totalLen;
    public String url;

    public IPCQueryDownloadInfo() {
        this.url = "";
        this.savePath = "";
        this.state = 0;
        this.receivedLen = 0L;
        this.totalLen = 0L;
        this.allTaskTotalProgress = 0L;
        this.allTaskTotalLength = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, true);
        this.savePath = jceInputStream.readString(1, false);
        this.state = jceInputStream.read(this.state, 2, false);
        this.receivedLen = jceInputStream.read(this.receivedLen, 3, false);
        this.totalLen = jceInputStream.read(this.totalLen, 4, false);
        this.allTaskTotalProgress = jceInputStream.read(this.allTaskTotalProgress, 5, false);
        this.allTaskTotalLength = jceInputStream.read(this.allTaskTotalLength, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.url, 0);
        String str = this.savePath;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.state, 2);
        jceOutputStream.write(this.receivedLen, 3);
        jceOutputStream.write(this.totalLen, 4);
        jceOutputStream.write(this.allTaskTotalProgress, 5);
        jceOutputStream.write(this.allTaskTotalLength, 6);
    }

    public IPCQueryDownloadInfo(String str, String str2, int i3, long j3, long j16, long j17, long j18) {
        this.url = str;
        this.savePath = str2;
        this.state = i3;
        this.receivedLen = j3;
        this.totalLen = j16;
        this.allTaskTotalProgress = j17;
        this.allTaskTotalLength = j18;
    }
}
