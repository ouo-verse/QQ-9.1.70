package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class SubScribeSDKDownloadTaskByViaRequest extends JceStruct {
    static ArrayList<IPCSDKDownloadInfo> cache_data;
    static ArrayList<String> cache_viaList;
    public ArrayList<IPCSDKDownloadInfo> data;
    public ArrayList<String> viaList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_viaList = arrayList;
        arrayList.add("");
        cache_data = new ArrayList<>();
        cache_data.add(new IPCSDKDownloadInfo());
    }

    public SubScribeSDKDownloadTaskByViaRequest() {
        this.viaList = null;
        this.data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.viaList = (ArrayList) jceInputStream.read((JceInputStream) cache_viaList, 0, true);
        this.data = (ArrayList) jceInputStream.read((JceInputStream) cache_data, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.viaList, 0);
        ArrayList<IPCSDKDownloadInfo> arrayList = this.data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public SubScribeSDKDownloadTaskByViaRequest(ArrayList<String> arrayList, ArrayList<IPCSDKDownloadInfo> arrayList2) {
        this.viaList = arrayList;
        this.data = arrayList2;
    }
}
