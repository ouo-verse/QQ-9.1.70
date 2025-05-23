package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AppUpdateInfo extends JceStruct {
    public static ArrayList<ApkDownUrl> cache_apkDownUrl;
    public static PicInfo cache_iconUrl;
    public static RatingInfo cache_rating;
    public String packageName = "";
    public String appName = "";
    public String signatureMd5 = "";
    public int versionCode = 0;
    public PicInfo iconUrl = null;
    public String newFeature = "";
    public RatingInfo rating = null;
    public String apkMd5 = "";
    public String apkUrl = "";
    public long fileSize = 0;
    public String diffApkMd5 = "";
    public String diffApkUrl = "";
    public long diffFileSize = 0;
    public String versionName = "";
    public long appId = 0;
    public long downCount = 0;
    public int flag = 0;
    public long apkId = 0;
    public ArrayList<ApkDownUrl> apkDownUrl = null;
    public byte isAdded = 0;
    public int grayVersionCode = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.packageName = jceInputStream.readString(0, true);
        this.appName = jceInputStream.readString(1, true);
        this.signatureMd5 = jceInputStream.readString(2, true);
        this.versionCode = jceInputStream.read(this.versionCode, 3, true);
        if (cache_iconUrl == null) {
            cache_iconUrl = new PicInfo();
        }
        this.iconUrl = (PicInfo) jceInputStream.read((JceStruct) cache_iconUrl, 4, true);
        this.newFeature = jceInputStream.readString(5, true);
        if (cache_rating == null) {
            cache_rating = new RatingInfo();
        }
        this.rating = (RatingInfo) jceInputStream.read((JceStruct) cache_rating, 6, true);
        this.apkMd5 = jceInputStream.readString(7, true);
        this.apkUrl = jceInputStream.readString(8, true);
        this.fileSize = jceInputStream.read(this.fileSize, 9, true);
        this.diffApkMd5 = jceInputStream.readString(10, false);
        this.diffApkUrl = jceInputStream.readString(11, false);
        this.diffFileSize = jceInputStream.read(this.diffFileSize, 12, false);
        this.versionName = jceInputStream.readString(13, false);
        this.appId = jceInputStream.read(this.appId, 14, false);
        this.downCount = jceInputStream.read(this.downCount, 15, false);
        this.flag = jceInputStream.read(this.flag, 16, false);
        this.apkId = jceInputStream.read(this.apkId, 18, false);
        if (cache_apkDownUrl == null) {
            cache_apkDownUrl = new ArrayList<>();
            cache_apkDownUrl.add(new ApkDownUrl());
        }
        this.apkDownUrl = (ArrayList) jceInputStream.read((JceInputStream) cache_apkDownUrl, 19, false);
        this.isAdded = jceInputStream.read(this.isAdded, 21, false);
        this.grayVersionCode = jceInputStream.read(this.grayVersionCode, 22, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.packageName, 0);
        jceOutputStream.write(this.appName, 1);
        jceOutputStream.write(this.signatureMd5, 2);
        jceOutputStream.write(this.versionCode, 3);
        jceOutputStream.write((JceStruct) this.iconUrl, 4);
        jceOutputStream.write(this.newFeature, 5);
        jceOutputStream.write((JceStruct) this.rating, 6);
        jceOutputStream.write(this.apkMd5, 7);
        jceOutputStream.write(this.apkUrl, 8);
        jceOutputStream.write(this.fileSize, 9);
        String str = this.diffApkMd5;
        if (str != null) {
            jceOutputStream.write(str, 10);
        }
        String str2 = this.diffApkUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 11);
        }
        jceOutputStream.write(this.diffFileSize, 12);
        String str3 = this.versionName;
        if (str3 != null) {
            jceOutputStream.write(str3, 13);
        }
        jceOutputStream.write(this.appId, 14);
        jceOutputStream.write(this.downCount, 15);
        jceOutputStream.write(this.flag, 16);
        jceOutputStream.write(this.apkId, 18);
        ArrayList<ApkDownUrl> arrayList = this.apkDownUrl;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 19);
        }
        jceOutputStream.write(this.isAdded, 21);
        jceOutputStream.write(this.grayVersionCode, 22);
    }
}
