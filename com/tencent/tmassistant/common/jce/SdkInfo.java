package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class SdkInfo extends JceStruct {
    public String builderNum;
    public String channel;
    public String name;
    public String subChannel;
    public int versionCode;
    public String versionName;

    public SdkInfo() {
        this.name = "";
        this.versionName = "";
        this.versionCode = 0;
        this.channel = "";
        this.subChannel = "";
        this.builderNum = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.name = jceInputStream.readString(0, false);
        this.versionName = jceInputStream.readString(1, false);
        this.versionCode = jceInputStream.read(this.versionCode, 2, false);
        this.channel = jceInputStream.readString(3, false);
        this.subChannel = jceInputStream.readString(4, false);
        this.builderNum = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.versionName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.versionCode, 2);
        String str3 = this.channel;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.subChannel;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.builderNum;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
    }

    public SdkInfo(String str, String str2, int i3, String str3, String str4, String str5) {
        this.name = str;
        this.versionName = str2;
        this.versionCode = i3;
        this.channel = str3;
        this.subChannel = str4;
        this.builderNum = str5;
    }
}
