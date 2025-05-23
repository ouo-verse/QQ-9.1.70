package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class PackageAction extends JceStruct {
    public String coordinatesStr;
    public String universalLinkUrl;
    public String url;

    public PackageAction() {
        this.url = "";
        this.coordinatesStr = "";
        this.universalLinkUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, false);
        this.coordinatesStr = jceInputStream.readString(1, false);
        this.universalLinkUrl = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.coordinatesStr;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.universalLinkUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public PackageAction(String str, String str2, String str3) {
        this.url = str;
        this.coordinatesStr = str2;
        this.universalLinkUrl = str3;
    }
}
