package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class SyncSDKHandShakeRequest extends JceStruct {
    public String extra;

    public SyncSDKHandShakeRequest() {
        this.extra = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.extra = jceInputStream.readString(0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.extra, 0);
    }

    public SyncSDKHandShakeRequest(String str) {
        this.extra = str;
    }
}
