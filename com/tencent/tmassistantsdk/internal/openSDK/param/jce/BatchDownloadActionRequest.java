package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BatchDownloadActionRequest extends JceStruct {
    static ArrayList<IPCDownloadParam> cache_batchData;
    public ArrayList<IPCDownloadParam> batchData;
    public int batchRequestType;
    public String uin;
    public String uinType;
    public String via;

    public BatchDownloadActionRequest() {
        this.batchRequestType = 0;
        this.batchData = null;
        this.uin = "";
        this.uinType = "";
        this.via = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.batchRequestType = jceInputStream.read(this.batchRequestType, 0, true);
        if (cache_batchData == null) {
            cache_batchData = new ArrayList<>();
            cache_batchData.add(new IPCDownloadParam());
        }
        this.batchData = (ArrayList) jceInputStream.read((JceInputStream) cache_batchData, 1, false);
        this.uin = jceInputStream.readString(2, false);
        this.uinType = jceInputStream.readString(3, false);
        this.via = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.batchRequestType, 0);
        ArrayList<IPCDownloadParam> arrayList = this.batchData;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.uin;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.uinType;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.via;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public BatchDownloadActionRequest(int i3, ArrayList<IPCDownloadParam> arrayList, String str, String str2, String str3) {
        this.batchRequestType = i3;
        this.batchData = arrayList;
        this.uin = str;
        this.uinType = str2;
        this.via = str3;
    }
}
