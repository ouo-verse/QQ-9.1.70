package com.tencent.msf.service.protocol.QQWiFi;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e extends JceStruct {

    /* renamed from: c, reason: collision with root package name */
    static LBSInfo f336467c;

    /* renamed from: a, reason: collision with root package name */
    public LBSInfo f336468a = null;

    /* renamed from: b, reason: collision with root package name */
    public long f336469b = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336467c == null) {
            f336467c = new LBSInfo();
        }
        this.f336468a = (LBSInfo) jceInputStream.read((JceStruct) f336467c, 0, false);
        this.f336469b = jceInputStream.read(this.f336469b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "WiFiMapReq [lbsInfo=" + this.f336468a + ", last_id=" + this.f336469b + "]";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LBSInfo lBSInfo = this.f336468a;
        if (lBSInfo != null) {
            jceOutputStream.write((JceStruct) lBSInfo, 0);
        }
        jceOutputStream.write(this.f336469b, 1);
    }
}
