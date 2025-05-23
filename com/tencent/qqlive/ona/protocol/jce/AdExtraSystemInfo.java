package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdExtraSystemInfo extends JceStruct {
    public String chromeVersion;
    public String javaVmVersion;
    public String manufacturer;
    public int swSize;
    public String systemBuildId;
    public String systemBuildVersionCodeName;
    public String systemBuildVersionRelease;
    public String systemIncremental;
    public String systemReleaseOrCodename;
    public String webviewUserAgent;

    public AdExtraSystemInfo() {
        this.systemBuildVersionCodeName = "";
        this.systemBuildId = "";
        this.manufacturer = "";
        this.chromeVersion = "";
        this.swSize = 0;
        this.javaVmVersion = "";
        this.systemIncremental = "";
        this.systemReleaseOrCodename = "";
        this.webviewUserAgent = "";
        this.systemBuildVersionRelease = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.systemBuildVersionCodeName = jceInputStream.readString(0, false);
        this.systemBuildId = jceInputStream.readString(1, false);
        this.manufacturer = jceInputStream.readString(2, false);
        this.chromeVersion = jceInputStream.readString(3, false);
        this.swSize = jceInputStream.read(this.swSize, 4, false);
        this.javaVmVersion = jceInputStream.readString(5, false);
        this.systemIncremental = jceInputStream.readString(6, false);
        this.systemReleaseOrCodename = jceInputStream.readString(7, false);
        this.webviewUserAgent = jceInputStream.readString(8, false);
        this.systemBuildVersionRelease = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.systemBuildVersionCodeName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.systemBuildId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.manufacturer;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.chromeVersion;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.swSize, 4);
        String str5 = this.javaVmVersion;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.systemIncremental;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.systemReleaseOrCodename;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.webviewUserAgent;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
        String str9 = this.systemBuildVersionRelease;
        if (str9 != null) {
            jceOutputStream.write(str9, 9);
        }
    }

    public AdExtraSystemInfo(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9) {
        this.systemBuildVersionCodeName = str;
        this.systemBuildId = str2;
        this.manufacturer = str3;
        this.chromeVersion = str4;
        this.swSize = i3;
        this.javaVmVersion = str5;
        this.systemIncremental = str6;
        this.systemReleaseOrCodename = str7;
        this.webviewUserAgent = str8;
        this.systemBuildVersionRelease = str9;
    }
}
