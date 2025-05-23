package com.tencent.replacemonitor.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes25.dex */
public final class GetMobilePhoneQqApkInfoRequest extends JceStruct {
    public long apkId;
    public long appId;
    public String downloadUrl;
    public String pkgName;

    public GetMobilePhoneQqApkInfoRequest() {
        this.apkId = 0L;
        this.pkgName = "";
        this.appId = 0L;
        this.downloadUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.apkId = jceInputStream.read(this.apkId, 0, false);
        this.pkgName = jceInputStream.readString(1, false);
        this.appId = jceInputStream.read(this.appId, 2, false);
        this.downloadUrl = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.apkId, 0);
        String str = this.pkgName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.appId, 2);
        String str2 = this.downloadUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public GetMobilePhoneQqApkInfoRequest(long j3, String str, long j16, String str2) {
        this.apkId = j3;
        this.pkgName = str;
        this.appId = j16;
        this.downloadUrl = str2;
    }
}
