package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes26.dex */
public final class IPCHead extends JceStruct {
    public int cmdId;
    public String hostPackageName;
    public String hostVersionCode;
    public int requestId;
    public int sdkIpcJceVersion;
    public String traceId;

    public IPCHead() {
        this.requestId = 0;
        this.cmdId = 0;
        this.hostPackageName = "";
        this.hostVersionCode = "";
        this.traceId = "";
        this.sdkIpcJceVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.hostPackageName = jceInputStream.readString(2, true);
        this.hostVersionCode = jceInputStream.readString(3, true);
        this.traceId = jceInputStream.readString(4, false);
        this.sdkIpcJceVersion = jceInputStream.read(this.sdkIpcJceVersion, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.hostPackageName, 2);
        jceOutputStream.write(this.hostVersionCode, 3);
        String str = this.traceId;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.sdkIpcJceVersion, 5);
    }

    public IPCHead(int i3, int i16, String str, String str2, String str3, int i17) {
        this.requestId = i3;
        this.cmdId = i16;
        this.hostPackageName = str;
        this.hostVersionCode = str2;
        this.traceId = str3;
        this.sdkIpcJceVersion = i17;
    }
}
