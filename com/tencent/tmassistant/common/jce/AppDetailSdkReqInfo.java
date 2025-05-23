package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class AppDetailSdkReqInfo extends JceStruct {
    public String channelId;
    public String packageName;

    public AppDetailSdkReqInfo() {
        this.channelId = "";
        this.packageName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.channelId = jceInputStream.readString(0, false);
        this.packageName = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.channelId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.packageName;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public AppDetailSdkReqInfo(String str, String str2) {
        this.channelId = str;
        this.packageName = str2;
    }
}
