package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class AppDetailSdkInfo extends JceStruct {
    public String apkDownUrl;
    public long apkId;
    public String apkMd5;
    public long appId;
    public String appName;
    public String channelId;
    public long fileSize;
    public String iconUrl;
    public String packageName;
    public String signatureMd5;
    public int versionCode;

    public AppDetailSdkInfo() {
        this.appId = 0L;
        this.apkId = 0L;
        this.appName = "";
        this.iconUrl = "";
        this.packageName = "";
        this.versionCode = 0;
        this.signatureMd5 = "";
        this.apkMd5 = "";
        this.fileSize = 0L;
        this.apkDownUrl = "";
        this.channelId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.apkId = jceInputStream.read(this.apkId, 1, false);
        this.appName = jceInputStream.readString(2, false);
        this.iconUrl = jceInputStream.readString(3, false);
        this.packageName = jceInputStream.readString(4, false);
        this.versionCode = jceInputStream.read(this.versionCode, 5, false);
        this.signatureMd5 = jceInputStream.readString(6, false);
        this.apkMd5 = jceInputStream.readString(7, false);
        this.fileSize = jceInputStream.read(this.fileSize, 8, false);
        this.apkDownUrl = jceInputStream.readString(9, false);
        this.channelId = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appId, 0);
        jceOutputStream.write(this.apkId, 1);
        String str = this.appName;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.iconUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.packageName;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.versionCode, 5);
        String str4 = this.signatureMd5;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.apkMd5;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.fileSize, 8);
        String str6 = this.apkDownUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        String str7 = this.channelId;
        if (str7 != null) {
            jceOutputStream.write(str7, 10);
        }
    }

    public AppDetailSdkInfo(long j3, long j16, String str, String str2, String str3, int i3, String str4, String str5, long j17, String str6, String str7) {
        this.appId = j3;
        this.apkId = j16;
        this.appName = str;
        this.iconUrl = str2;
        this.packageName = str3;
        this.versionCode = i3;
        this.signatureMd5 = str4;
        this.apkMd5 = str5;
        this.fileSize = j17;
        this.apkDownUrl = str6;
        this.channelId = str7;
    }
}
