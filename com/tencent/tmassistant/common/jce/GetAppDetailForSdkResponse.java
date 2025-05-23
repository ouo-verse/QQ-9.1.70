package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetAppDetailForSdkResponse extends JceStruct {
    static ArrayList<AppDetailSdkInfo> cache_detailList = new ArrayList<>();
    public ArrayList<AppDetailSdkInfo> detailList;
    public int ret;

    static {
        cache_detailList.add(new AppDetailSdkInfo());
    }

    public GetAppDetailForSdkResponse() {
        this.ret = 0;
        this.detailList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.detailList = (ArrayList) jceInputStream.read((JceInputStream) cache_detailList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        ArrayList<AppDetailSdkInfo> arrayList = this.detailList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public GetAppDetailForSdkResponse(int i3, ArrayList<AppDetailSdkInfo> arrayList) {
        this.ret = i3;
        this.detailList = arrayList;
    }
}
