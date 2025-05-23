package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BatchSDKDownloadActionResponse extends JceStruct {
    static ArrayList<IPCSDKDownloadInfo> cache_batchData = new ArrayList<>();
    public ArrayList<IPCSDKDownloadInfo> batchData;
    public int batchRequestType;

    static {
        cache_batchData.add(new IPCSDKDownloadInfo());
    }

    public BatchSDKDownloadActionResponse() {
        this.batchRequestType = 0;
        this.batchData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.batchRequestType = jceInputStream.read(this.batchRequestType, 0, true);
        this.batchData = (ArrayList) jceInputStream.read((JceInputStream) cache_batchData, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.batchRequestType, 0);
        ArrayList<IPCSDKDownloadInfo> arrayList = this.batchData;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public BatchSDKDownloadActionResponse(int i3, ArrayList<IPCSDKDownloadInfo> arrayList) {
        this.batchRequestType = i3;
        this.batchData = arrayList;
    }
}
