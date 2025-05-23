package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdGetVInfoItem extends JceStruct {
    public String videoId;

    public AdGetVInfoItem() {
        this.videoId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.videoId = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.videoId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public AdGetVInfoItem(String str) {
        this.videoId = str;
    }
}
