package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdAdvertiserInfo extends JceStruct {
    public String advertiserActionName;
    public String advertiserDescription;
    public String advertiserIconUrl;
    public String advertiserName;

    public AdAdvertiserInfo() {
        this.advertiserIconUrl = "";
        this.advertiserName = "";
        this.advertiserActionName = "";
        this.advertiserDescription = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.advertiserIconUrl = jceInputStream.readString(0, false);
        this.advertiserName = jceInputStream.readString(1, false);
        this.advertiserActionName = jceInputStream.readString(2, false);
        this.advertiserDescription = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.advertiserIconUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.advertiserName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.advertiserActionName;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.advertiserDescription;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public AdAdvertiserInfo(String str, String str2, String str3, String str4) {
        this.advertiserIconUrl = str;
        this.advertiserName = str2;
        this.advertiserActionName = str3;
        this.advertiserDescription = str4;
    }
}
