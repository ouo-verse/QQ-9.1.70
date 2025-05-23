package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class SubScribeSDKDownloadTaskByViaResponse extends JceStruct {
    static ArrayList<String> cache_viaList;
    public int subscribeType;
    public ArrayList<String> viaList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_viaList = arrayList;
        arrayList.add("");
    }

    public SubScribeSDKDownloadTaskByViaResponse() {
        this.viaList = null;
        this.subscribeType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.viaList = (ArrayList) jceInputStream.read((JceInputStream) cache_viaList, 0, true);
        this.subscribeType = jceInputStream.read(this.subscribeType, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.viaList, 0);
        jceOutputStream.write(this.subscribeType, 1);
    }

    public SubScribeSDKDownloadTaskByViaResponse(ArrayList<String> arrayList, int i3) {
        this.viaList = arrayList;
        this.subscribeType = i3;
    }
}
