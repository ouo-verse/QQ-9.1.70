package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdLightInteractionCommonInfo extends JceStruct {
    public String desc;
    public int endTime;
    public boolean forbidVibrate;
    public int startTime;
    public String title;
    public String zipUrlStr;

    public AdLightInteractionCommonInfo() {
        this.title = "";
        this.desc = "";
        this.zipUrlStr = "";
        this.startTime = 0;
        this.endTime = 0;
        this.forbidVibrate = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.desc = jceInputStream.readString(1, false);
        this.zipUrlStr = jceInputStream.readString(2, false);
        this.startTime = jceInputStream.read(this.startTime, 3, false);
        this.endTime = jceInputStream.read(this.endTime, 4, false);
        this.forbidVibrate = jceInputStream.read(this.forbidVibrate, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.zipUrlStr;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.startTime, 3);
        jceOutputStream.write(this.endTime, 4);
        jceOutputStream.write(this.forbidVibrate, 5);
    }

    public AdLightInteractionCommonInfo(String str, String str2, String str3, int i3, int i16, boolean z16) {
        this.title = str;
        this.desc = str2;
        this.zipUrlStr = str3;
        this.startTime = i3;
        this.endTime = i16;
        this.forbidVibrate = z16;
    }
}
