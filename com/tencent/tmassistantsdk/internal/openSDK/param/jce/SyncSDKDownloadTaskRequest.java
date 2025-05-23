package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class SyncSDKDownloadTaskRequest extends JceStruct {
    static IPCSDKDownloadInfo cache_data = new IPCSDKDownloadInfo();
    public IPCSDKDownloadInfo data;

    public SyncSDKDownloadTaskRequest() {
        this.data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.data = (IPCSDKDownloadInfo) jceInputStream.read((JceStruct) cache_data, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.data, 0);
    }

    public SyncSDKDownloadTaskRequest(IPCSDKDownloadInfo iPCSDKDownloadInfo) {
        this.data = iPCSDKDownloadInfo;
    }
}
