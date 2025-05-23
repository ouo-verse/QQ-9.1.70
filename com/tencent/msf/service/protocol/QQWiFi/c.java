package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f336462a = "";

    /* renamed from: b, reason: collision with root package name */
    public int f336463b = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336462a = jceInputStream.readString(0, true);
        this.f336463b = jceInputStream.read(this.f336463b, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "NearbyAvailWiFiInfoRsp [msg=" + this.f336462a + "][ status=" + this.f336463b + "]";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336462a, 0);
        jceOutputStream.write(this.f336463b, 1);
    }
}
