package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideOfflineIndexItem extends JceStruct {
    static ArrayList<AdInsideOrderIndexItem> cache_orderIndexItemList = new ArrayList<>();
    public ArrayList<AdInsideOrderIndexItem> orderIndexItemList;

    static {
        cache_orderIndexItemList.add(new AdInsideOrderIndexItem());
    }

    public AdInsideOfflineIndexItem() {
        this.orderIndexItemList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.orderIndexItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_orderIndexItemList, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<AdInsideOrderIndexItem> arrayList = this.orderIndexItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public AdInsideOfflineIndexItem(ArrayList<AdInsideOrderIndexItem> arrayList) {
        this.orderIndexItemList = arrayList;
    }
}
