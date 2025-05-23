package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class AdPositionItem extends JceStruct {
    public int absPosition;
    public String adSpace;
    public String channelId;
    public int position;

    public AdPositionItem() {
        this.channelId = "";
        this.position = 0;
        this.absPosition = 0;
        this.adSpace = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.channelId = jceInputStream.readString(0, false);
        this.position = jceInputStream.read(this.position, 1, false);
        this.absPosition = jceInputStream.read(this.absPosition, 2, false);
        this.adSpace = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.channelId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.position, 1);
        jceOutputStream.write(this.absPosition, 2);
        String str2 = this.adSpace;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public AdPositionItem(String str, int i3, int i16, String str2) {
        this.channelId = str;
        this.position = i3;
        this.absPosition = i16;
        this.adSpace = str2;
    }
}
