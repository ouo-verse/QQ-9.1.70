package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AppDownloadChannelInfo extends JceStruct {
    public String appName;
    public String authorName;
    public long packageSizeBytes;
    public String permissionsText;
    public String permissionsUrl;
    public String privacyAgreementText;
    public String privacyAgreementUrl;
    public String versionName;

    public AppDownloadChannelInfo() {
        this.authorName = "";
        this.packageSizeBytes = 0L;
        this.versionName = "";
        this.permissionsText = "";
        this.permissionsUrl = "";
        this.privacyAgreementText = "";
        this.privacyAgreementUrl = "";
        this.appName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.authorName = jceInputStream.readString(0, false);
        this.packageSizeBytes = jceInputStream.read(this.packageSizeBytes, 1, false);
        this.versionName = jceInputStream.readString(2, false);
        this.permissionsText = jceInputStream.readString(3, false);
        this.permissionsUrl = jceInputStream.readString(4, false);
        this.privacyAgreementText = jceInputStream.readString(5, false);
        this.privacyAgreementUrl = jceInputStream.readString(6, false);
        this.appName = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.authorName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.packageSizeBytes, 1);
        String str2 = this.versionName;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.permissionsText;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.permissionsUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.privacyAgreementText;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.privacyAgreementUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.appName;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
    }

    public AppDownloadChannelInfo(String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.authorName = str;
        this.packageSizeBytes = j3;
        this.versionName = str2;
        this.permissionsText = str3;
        this.permissionsUrl = str4;
        this.privacyAgreementText = str5;
        this.privacyAgreementUrl = str6;
        this.appName = str7;
    }
}
