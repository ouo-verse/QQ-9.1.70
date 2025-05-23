package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GetAppSimpleDetailResponse extends JceStruct {
    static ArrayList<AppSimpleDetail> cache_appSimpleDetailList;
    public ArrayList<AppSimpleDetail> appSimpleDetailList;
    public int ret;

    public GetAppSimpleDetailResponse() {
        this.ret = 0;
        this.appSimpleDetailList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        if (cache_appSimpleDetailList == null) {
            cache_appSimpleDetailList = new ArrayList<>();
            cache_appSimpleDetailList.add(new AppSimpleDetail());
        }
        this.appSimpleDetailList = (ArrayList) jceInputStream.read((JceInputStream) cache_appSimpleDetailList, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write((Collection) this.appSimpleDetailList, 1);
    }

    public GetAppSimpleDetailResponse(int i3, ArrayList<AppSimpleDetail> arrayList) {
        this.ret = i3;
        this.appSimpleDetailList = arrayList;
    }
}
