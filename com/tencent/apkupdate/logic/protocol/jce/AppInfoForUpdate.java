package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AppInfoForUpdate extends JceStruct {
    public String packageName = "";
    public String signatureMd5 = "";
    public int versionCode = 0;
    public String manifestMd5 = "";
    public long appId = 0;
    public byte appType = 1;
    public String versionName = "";
    public byte actionFlag = 0;
    public int grayVersionCode = 0;
    public int targetVersionCode = 0;
    public int targetGrayVersionCode = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.packageName = jceInputStream.readString(0, true);
        this.signatureMd5 = jceInputStream.readString(1, true);
        this.versionCode = jceInputStream.read(this.versionCode, 2, true);
        this.manifestMd5 = jceInputStream.readString(3, false);
        this.appId = jceInputStream.read(this.appId, 4, false);
        this.appType = jceInputStream.read(this.appType, 5, false);
        this.versionName = jceInputStream.readString(6, false);
        this.actionFlag = jceInputStream.read(this.actionFlag, 7, false);
        this.grayVersionCode = jceInputStream.read(this.grayVersionCode, 8, false);
        this.targetVersionCode = jceInputStream.read(this.targetVersionCode, 9, false);
        this.targetGrayVersionCode = jceInputStream.read(this.targetGrayVersionCode, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.packageName, 0);
        jceOutputStream.write(this.signatureMd5, 1);
        jceOutputStream.write(this.versionCode, 2);
        String str = this.manifestMd5;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.appId, 4);
        jceOutputStream.write(this.appType, 5);
        String str2 = this.versionName;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.actionFlag, 7);
        jceOutputStream.write(this.grayVersionCode, 8);
        jceOutputStream.write(this.targetVersionCode, 9);
        jceOutputStream.write(this.targetGrayVersionCode, 10);
    }
}
