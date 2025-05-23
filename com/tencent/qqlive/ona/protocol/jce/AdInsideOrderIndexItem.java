package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideOrderIndexItem extends JceStruct {
    static int cache_viewType;
    public String orderId;
    public int viewType;

    public AdInsideOrderIndexItem() {
        this.viewType = 0;
        this.orderId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.viewType = jceInputStream.read(this.viewType, 0, true);
        this.orderId = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.viewType, 0);
        String str = this.orderId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public AdInsideOrderIndexItem(int i3, String str) {
        this.viewType = i3;
        this.orderId = str;
    }
}
