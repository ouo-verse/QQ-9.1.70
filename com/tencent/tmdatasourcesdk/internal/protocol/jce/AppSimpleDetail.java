package com.tencent.tmdatasourcesdk.internal.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class AppSimpleDetail extends JceStruct {
    static ArrayList<ApkDownUrl> cache_apkDownUrl;
    public ArrayList<ApkDownUrl> apkDownUrl;
    public long apkId;
    public String apkMd5;
    public long appId;
    public String appName;
    public String channelId;
    public String diffApkMd5;
    public long diffFileSize;
    public long fileSize;
    public String iconUrl;
    public String packageName;
    public String signatureMd5;
    public int versionCode;
    public String versionName;

    public AppSimpleDetail() {
        this.appId = 0L;
        this.apkId = 0L;
        this.appName = "";
        this.iconUrl = "";
        this.packageName = "";
        this.versionName = "";
        this.versionCode = 0;
        this.signatureMd5 = "";
        this.apkMd5 = "";
        this.fileSize = 0L;
        this.apkDownUrl = null;
        this.diffApkMd5 = "";
        this.diffFileSize = 0L;
        this.channelId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.apkId = jceInputStream.read(this.apkId, 1, false);
        this.appName = jceInputStream.readString(2, false);
        this.iconUrl = jceInputStream.readString(3, false);
        this.packageName = jceInputStream.readString(4, false);
        this.versionName = jceInputStream.readString(5, false);
        this.versionCode = jceInputStream.read(this.versionCode, 6, false);
        this.signatureMd5 = jceInputStream.readString(7, false);
        this.apkMd5 = jceInputStream.readString(8, false);
        this.fileSize = jceInputStream.read(this.fileSize, 9, false);
        if (cache_apkDownUrl == null) {
            cache_apkDownUrl = new ArrayList<>();
            cache_apkDownUrl.add(new ApkDownUrl());
        }
        this.apkDownUrl = (ArrayList) jceInputStream.read((JceInputStream) cache_apkDownUrl, 10, false);
        this.diffApkMd5 = jceInputStream.readString(11, false);
        this.diffFileSize = jceInputStream.read(this.diffFileSize, 12, false);
        this.channelId = jceInputStream.readString(13, false);
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
        String str4 = this.versionName;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.versionCode, 6);
        String str5 = this.signatureMd5;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.apkMd5;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        jceOutputStream.write(this.fileSize, 9);
        ArrayList<ApkDownUrl> arrayList = this.apkDownUrl;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 10);
        }
        String str7 = this.diffApkMd5;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
        jceOutputStream.write(this.diffFileSize, 12);
        String str8 = this.channelId;
        if (str8 != null) {
            jceOutputStream.write(str8, 13);
        }
    }

    public AppSimpleDetail(long j3, long j16, String str, String str2, String str3, String str4, int i3, String str5, String str6, long j17, ArrayList<ApkDownUrl> arrayList, String str7, long j18, String str8) {
        this.appId = j3;
        this.apkId = j16;
        this.appName = str;
        this.iconUrl = str2;
        this.packageName = str3;
        this.versionName = str4;
        this.versionCode = i3;
        this.signatureMd5 = str5;
        this.apkMd5 = str6;
        this.fileSize = j17;
        this.apkDownUrl = arrayList;
        this.diffApkMd5 = str7;
        this.diffFileSize = j18;
        this.channelId = str8;
    }
}
