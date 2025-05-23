package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdAppInstallInfo extends JceStruct {
    public String packageName;
    public String posId;
    public String schemeUrl;
    public int serverAppStatus;

    public AdAppInstallInfo() {
        this.serverAppStatus = 0;
        this.packageName = "";
        this.schemeUrl = "";
        this.posId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.serverAppStatus = jceInputStream.read(this.serverAppStatus, 0, false);
        this.packageName = jceInputStream.readString(1, false);
        this.schemeUrl = jceInputStream.readString(2, false);
        this.posId = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.serverAppStatus, 0);
        String str = this.packageName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.schemeUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.posId;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public AdAppInstallInfo(int i3, String str, String str2, String str3) {
        this.serverAppStatus = i3;
        this.packageName = str;
        this.schemeUrl = str2;
        this.posId = str3;
    }
}
