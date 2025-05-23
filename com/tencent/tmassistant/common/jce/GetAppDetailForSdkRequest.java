package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetAppDetailForSdkRequest extends JceStruct {
    static ArrayList<AppDetailSdkReqInfo> cache_reqList = new ArrayList<>();
    public String biz;
    public ArrayList<AppDetailSdkReqInfo> reqList;

    static {
        cache_reqList.add(new AppDetailSdkReqInfo());
    }

    public GetAppDetailForSdkRequest() {
        this.reqList = null;
        this.biz = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqList = (ArrayList) jceInputStream.read((JceInputStream) cache_reqList, 0, false);
        this.biz = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<AppDetailSdkReqInfo> arrayList = this.reqList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.biz;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public GetAppDetailForSdkRequest(ArrayList<AppDetailSdkReqInfo> arrayList, String str) {
        this.reqList = arrayList;
        this.biz = str;
    }
}
