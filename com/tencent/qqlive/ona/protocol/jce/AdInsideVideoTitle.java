package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideVideoTitle extends JceStruct {
    public String dspName;
    public String fullTitle;
    public String fullUnInstallTitle;
    public String shortTitle;
    public String shortUnInstallTitle;

    public AdInsideVideoTitle() {
        this.dspName = "";
        this.fullTitle = "";
        this.fullUnInstallTitle = "";
        this.shortTitle = "";
        this.shortUnInstallTitle = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dspName = jceInputStream.readString(0, false);
        this.fullTitle = jceInputStream.readString(1, false);
        this.fullUnInstallTitle = jceInputStream.readString(2, false);
        this.shortTitle = jceInputStream.readString(3, false);
        this.shortUnInstallTitle = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.dspName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.fullTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.fullUnInstallTitle;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.shortTitle;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.shortUnInstallTitle;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
    }

    public AdInsideVideoTitle(String str, String str2, String str3, String str4, String str5) {
        this.dspName = str;
        this.fullTitle = str2;
        this.fullUnInstallTitle = str3;
        this.shortTitle = str4;
        this.shortUnInstallTitle = str5;
    }
}
