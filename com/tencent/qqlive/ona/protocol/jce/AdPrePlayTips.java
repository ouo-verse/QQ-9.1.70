package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class AdPrePlayTips extends JceStruct {
    static int cache_skipVideoAdType;
    public String actionButtonText;
    public String desc;
    public boolean enable;
    public int skipVideoAdType;
    public String title;
    public String unlockFailedTips;
    public String unlockSuccessTips;

    public AdPrePlayTips() {
        this.enable = false;
        this.title = "";
        this.desc = "";
        this.actionButtonText = "";
        this.skipVideoAdType = 0;
        this.unlockSuccessTips = "";
        this.unlockFailedTips = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enable = jceInputStream.read(this.enable, 0, false);
        this.title = jceInputStream.readString(1, false);
        this.desc = jceInputStream.readString(2, false);
        this.actionButtonText = jceInputStream.readString(3, false);
        this.skipVideoAdType = jceInputStream.read(this.skipVideoAdType, 4, false);
        this.unlockSuccessTips = jceInputStream.readString(5, false);
        this.unlockFailedTips = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.enable, 0);
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.actionButtonText;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.skipVideoAdType, 4);
        String str4 = this.unlockSuccessTips;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.unlockFailedTips;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
    }

    public AdPrePlayTips(boolean z16, String str, String str2, String str3, int i3, String str4, String str5) {
        this.enable = z16;
        this.title = str;
        this.desc = str2;
        this.actionButtonText = str3;
        this.skipVideoAdType = i3;
        this.unlockSuccessTips = str4;
        this.unlockFailedTips = str5;
    }
}
