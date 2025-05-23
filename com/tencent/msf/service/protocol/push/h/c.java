package com.tencent.msf.service.protocol.push.h;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f336589a;

    /* renamed from: b, reason: collision with root package name */
    public String f336590b;

    public c() {
        this.f336589a = "";
        this.f336590b = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336589a = jceInputStream.readString(0, false);
        this.f336590b = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f336589a;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.f336590b;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public c(String str, String str2) {
        this.f336589a = str;
        this.f336590b = str2;
    }
}
