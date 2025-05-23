package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdMaxViewItem extends JceStruct {
    public String adTips;
    public String destUrl;
    public int showTime;
    public int showType;

    public AdMaxViewItem() {
        this.showType = 0;
        this.showTime = 0;
        this.destUrl = "";
        this.adTips = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.showType = jceInputStream.read(this.showType, 0, false);
        this.showTime = jceInputStream.read(this.showTime, 1, false);
        this.destUrl = jceInputStream.readString(2, false);
        this.adTips = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.showType, 0);
        jceOutputStream.write(this.showTime, 1);
        String str = this.destUrl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.adTips;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public AdMaxViewItem(int i3, int i16, String str, String str2) {
        this.showType = i3;
        this.showTime = i16;
        this.destUrl = str;
        this.adTips = str2;
    }
}
