package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdShareItem extends JceStruct {
    public boolean shareEnable;
    public boolean shareFromH5;
    public String shareImgUrl;
    public String sharePage;
    public String shareSubtitle;
    public String shareTitle;
    public String shareUrl;

    public AdShareItem() {
        this.shareUrl = "";
        this.shareTitle = "";
        this.shareSubtitle = "";
        this.shareImgUrl = "";
        this.shareFromH5 = true;
        this.sharePage = "";
        this.shareEnable = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shareUrl = jceInputStream.readString(0, false);
        this.shareTitle = jceInputStream.readString(1, false);
        this.shareSubtitle = jceInputStream.readString(2, false);
        this.shareImgUrl = jceInputStream.readString(3, false);
        this.shareFromH5 = jceInputStream.read(this.shareFromH5, 4, false);
        this.sharePage = jceInputStream.readString(5, false);
        this.shareEnable = jceInputStream.read(this.shareEnable, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.shareUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.shareTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.shareSubtitle;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.shareImgUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.shareFromH5, 4);
        String str5 = this.sharePage;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.shareEnable, 6);
    }

    public AdShareItem(String str, String str2, String str3, String str4, boolean z16, String str5, boolean z17) {
        this.shareUrl = str;
        this.shareTitle = str2;
        this.shareSubtitle = str3;
        this.shareImgUrl = str4;
        this.shareFromH5 = z16;
        this.sharePage = str5;
        this.shareEnable = z17;
    }
}
