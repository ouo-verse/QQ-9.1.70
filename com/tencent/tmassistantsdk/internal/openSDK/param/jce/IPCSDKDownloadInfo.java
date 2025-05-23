package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes26.dex */
public final class IPCSDKDownloadInfo extends JceStruct {
    public String appIconUrl;
    public String appId;
    public String appName;
    public int appState;
    public long downloadFinishTime;
    public String extra;
    public String grayVersionCode;
    public long installFinishTime;
    public String packageName;
    public long receivedLen;
    public long totalLen;
    public String url;
    public String versionCode;
    public String via;

    public IPCSDKDownloadInfo() {
        this.packageName = "";
        this.appId = "";
        this.appName = "";
        this.appIconUrl = "";
        this.appState = 0;
        this.receivedLen = 0L;
        this.totalLen = 0L;
        this.downloadFinishTime = 0L;
        this.installFinishTime = 0L;
        this.via = "";
        this.extra = "";
        this.url = "";
        this.versionCode = "";
        this.grayVersionCode = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.packageName = jceInputStream.readString(0, true);
        this.appId = jceInputStream.readString(1, false);
        this.appName = jceInputStream.readString(3, false);
        this.appIconUrl = jceInputStream.readString(4, false);
        this.appState = jceInputStream.read(this.appState, 5, false);
        this.receivedLen = jceInputStream.read(this.receivedLen, 6, false);
        this.totalLen = jceInputStream.read(this.totalLen, 7, false);
        this.downloadFinishTime = jceInputStream.read(this.downloadFinishTime, 8, false);
        this.installFinishTime = jceInputStream.read(this.installFinishTime, 9, false);
        this.via = jceInputStream.readString(10, false);
        this.extra = jceInputStream.readString(11, false);
        this.url = jceInputStream.readString(12, false);
        this.versionCode = jceInputStream.readString(13, false);
        this.grayVersionCode = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.packageName, 0);
        String str = this.appId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.appName;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.appIconUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.appState, 5);
        jceOutputStream.write(this.receivedLen, 6);
        jceOutputStream.write(this.totalLen, 7);
        jceOutputStream.write(this.downloadFinishTime, 8);
        jceOutputStream.write(this.installFinishTime, 9);
        String str4 = this.via;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        String str5 = this.extra;
        if (str5 != null) {
            jceOutputStream.write(str5, 11);
        }
        String str6 = this.url;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        String str7 = this.versionCode;
        if (str7 != null) {
            jceOutputStream.write(str7, 13);
        }
        String str8 = this.grayVersionCode;
        if (str8 != null) {
            jceOutputStream.write(str8, 14);
        }
    }

    public IPCSDKDownloadInfo(String str, String str2, String str3, String str4, int i3, long j3, long j16, long j17, long j18, String str5, String str6, String str7, String str8, String str9) {
        this.packageName = str;
        this.appId = str2;
        this.appName = str3;
        this.appIconUrl = str4;
        this.appState = i3;
        this.receivedLen = j3;
        this.totalLen = j16;
        this.downloadFinishTime = j17;
        this.installFinishTime = j18;
        this.via = str5;
        this.extra = str6;
        this.url = str7;
        this.versionCode = str8;
        this.grayVersionCode = str9;
    }
}
