package com.tencent.replacemonitor.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes25.dex */
public final class GetMobilePhoneQqApkInfoResponse extends JceStruct {
    public String apkMd5;
    public String channelId;
    public long fileSize;
    public int maxFileSize;

    /* renamed from: msg, reason: collision with root package name */
    public String f364887msg;
    public int ret;
    public int strategy;

    public GetMobilePhoneQqApkInfoResponse() {
        this.ret = 0;
        this.f364887msg = "";
        this.strategy = 0;
        this.apkMd5 = "";
        this.fileSize = 0L;
        this.channelId = "";
        this.maxFileSize = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f364887msg = jceInputStream.readString(1, false);
        this.strategy = jceInputStream.read(this.strategy, 2, false);
        this.apkMd5 = jceInputStream.readString(3, false);
        this.fileSize = jceInputStream.read(this.fileSize, 4, false);
        this.channelId = jceInputStream.readString(5, false);
        this.maxFileSize = jceInputStream.read(this.maxFileSize, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f364887msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.strategy, 2);
        String str2 = this.apkMd5;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.fileSize, 4);
        String str3 = this.channelId;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.maxFileSize, 6);
    }

    public GetMobilePhoneQqApkInfoResponse(int i3, String str, int i16, String str2, long j3, String str3, int i17) {
        this.ret = i3;
        this.f364887msg = str;
        this.strategy = i16;
        this.apkMd5 = str2;
        this.fileSize = j3;
        this.channelId = str3;
        this.maxFileSize = i17;
    }
}
