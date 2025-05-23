package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class g extends JceStruct {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f336508b = true;

    /* renamed from: a, reason: collision with root package name */
    public int f336509a;

    public g() {
        this.f336509a = 0;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f336508b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        new JceDisplayer(sb5, i3).display(this.f336509a, "status");
    }

    public boolean equals(Object obj) {
        return JceUtil.equals(this.f336509a, ((g) obj).f336509a);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336509a = jceInputStream.read(this.f336509a, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336509a, 1);
    }

    public g(int i3) {
        this.f336509a = i3;
    }
}
