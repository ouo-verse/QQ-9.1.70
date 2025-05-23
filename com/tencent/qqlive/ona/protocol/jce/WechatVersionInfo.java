package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class WechatVersionInfo extends JceStruct {
    public boolean isSupportApi;
    public int wxOpenSdkVersion;
    public int wxSupportVersion;
    public int wxaSdkVersion;

    public WechatVersionInfo() {
        this.wxSupportVersion = 0;
        this.isSupportApi = true;
        this.wxOpenSdkVersion = 0;
        this.wxaSdkVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.wxSupportVersion = jceInputStream.read(this.wxSupportVersion, 0, false);
        this.isSupportApi = jceInputStream.read(this.isSupportApi, 1, false);
        this.wxOpenSdkVersion = jceInputStream.read(this.wxOpenSdkVersion, 2, false);
        this.wxaSdkVersion = jceInputStream.read(this.wxaSdkVersion, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wxSupportVersion, 0);
        jceOutputStream.write(this.isSupportApi, 1);
        jceOutputStream.write(this.wxOpenSdkVersion, 2);
        jceOutputStream.write(this.wxaSdkVersion, 3);
    }

    public WechatVersionInfo(int i3, boolean z16, int i16, int i17) {
        this.wxSupportVersion = i3;
        this.isSupportApi = z16;
        this.wxOpenSdkVersion = i16;
        this.wxaSdkVersion = i17;
    }
}
