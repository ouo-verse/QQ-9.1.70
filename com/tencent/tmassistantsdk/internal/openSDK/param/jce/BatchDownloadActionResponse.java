package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BatchDownloadActionResponse extends JceStruct {
    static ArrayList<IPCQueryDownloadInfo> cache_batchData;
    public ArrayList<IPCQueryDownloadInfo> batchData;
    public int batchRequestType;

    public BatchDownloadActionResponse() {
        this.batchRequestType = 0;
        this.batchData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.batchRequestType = jceInputStream.read(this.batchRequestType, 0, true);
        if (cache_batchData == null) {
            cache_batchData = new ArrayList<>();
            cache_batchData.add(new IPCQueryDownloadInfo());
        }
        this.batchData = (ArrayList) jceInputStream.read((JceInputStream) cache_batchData, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.batchRequestType, 0);
        ArrayList<IPCQueryDownloadInfo> arrayList = this.batchData;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public BatchDownloadActionResponse(int i3, ArrayList<IPCQueryDownloadInfo> arrayList) {
        this.batchRequestType = i3;
        this.batchData = arrayList;
    }
}
