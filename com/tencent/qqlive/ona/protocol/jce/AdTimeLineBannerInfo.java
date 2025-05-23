package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdTimeLineBannerInfo extends JceStruct {
    public String bannerColor;
    public String bannerLogoUrl;
    public String bannerTitle;
    public long countDownTime;
    public String pendantIconUrl;

    public AdTimeLineBannerInfo() {
        this.bannerTitle = "";
        this.pendantIconUrl = "";
        this.countDownTime = 0L;
        this.bannerColor = "";
        this.bannerLogoUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bannerTitle = jceInputStream.readString(0, false);
        this.pendantIconUrl = jceInputStream.readString(1, false);
        this.countDownTime = jceInputStream.read(this.countDownTime, 2, false);
        this.bannerColor = jceInputStream.readString(3, false);
        this.bannerLogoUrl = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.bannerTitle;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.pendantIconUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.countDownTime, 2);
        String str3 = this.bannerColor;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.bannerLogoUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }

    public AdTimeLineBannerInfo(String str, String str2, long j3, String str3, String str4) {
        this.bannerTitle = str;
        this.pendantIconUrl = str2;
        this.countDownTime = j3;
        this.bannerColor = str3;
        this.bannerLogoUrl = str4;
    }
}
