package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdLongVideoInfo extends JceStruct {
    public int fullVideoButtonShowTime;
    public String fullVideoButtonText;
    public int playDuration;

    public AdLongVideoInfo() {
        this.playDuration = 0;
        this.fullVideoButtonShowTime = 0;
        this.fullVideoButtonText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.playDuration = jceInputStream.read(this.playDuration, 0, false);
        this.fullVideoButtonShowTime = jceInputStream.read(this.fullVideoButtonShowTime, 1, false);
        this.fullVideoButtonText = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.playDuration, 0);
        jceOutputStream.write(this.fullVideoButtonShowTime, 1);
        String str = this.fullVideoButtonText;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public AdLongVideoInfo(int i3, int i16, String str) {
        this.playDuration = i3;
        this.fullVideoButtonShowTime = i16;
        this.fullVideoButtonText = str;
    }
}
