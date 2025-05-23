package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideEmptyItem extends JceStruct {
    static AdOrderItem cache_orderItem = new AdOrderItem();
    public AdOrderItem orderItem;

    public AdInsideEmptyItem() {
        this.orderItem = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.orderItem = (AdOrderItem) jceInputStream.read((JceStruct) cache_orderItem, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AdOrderItem adOrderItem = this.orderItem;
        if (adOrderItem != null) {
            jceOutputStream.write((JceStruct) adOrderItem, 0);
        }
    }

    public AdInsideEmptyItem(AdOrderItem adOrderItem) {
        this.orderItem = adOrderItem;
    }
}
