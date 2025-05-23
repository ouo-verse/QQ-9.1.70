package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetAppSimpleDetailRequest extends JceStruct {
    static ArrayList<AppDetailParam> cache_appReqList;
    public ArrayList<AppDetailParam> appReqList;

    public GetAppSimpleDetailRequest() {
        this.appReqList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_appReqList == null) {
            cache_appReqList = new ArrayList<>();
            cache_appReqList.add(new AppDetailParam());
        }
        this.appReqList = (ArrayList) jceInputStream.read((JceInputStream) cache_appReqList, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<AppDetailParam> arrayList = this.appReqList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public GetAppSimpleDetailRequest(ArrayList<AppDetailParam> arrayList) {
        this.appReqList = arrayList;
    }
}
