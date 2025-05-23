package com.tencent.msf.service.protocol.push.h;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f336617a;

    /* renamed from: b, reason: collision with root package name */
    public String f336618b;

    public e() {
        this.f336617a = "";
        this.f336618b = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336617a = jceInputStream.readString(0, false);
        this.f336618b = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f336617a;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.f336618b;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public e(String str, String str2) {
        this.f336617a = str;
        this.f336618b = str2;
    }
}
