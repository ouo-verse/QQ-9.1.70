package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdOpenCanvasItem extends JceStruct {
    public String horizontalUrl;
    public String verticalUrl;

    public AdOpenCanvasItem() {
        this.verticalUrl = "";
        this.horizontalUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.verticalUrl = jceInputStream.readString(0, false);
        this.horizontalUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.verticalUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.horizontalUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public AdOpenCanvasItem(String str, String str2) {
        this.verticalUrl = str;
        this.horizontalUrl = str2;
    }
}
