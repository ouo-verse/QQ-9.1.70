package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f336527d = true;

    /* renamed from: a, reason: collision with root package name */
    public long f336528a;

    /* renamed from: b, reason: collision with root package name */
    public String f336529b;

    /* renamed from: c, reason: collision with root package name */
    public long f336530c;

    public b() {
        this.f336528a = 0L;
        this.f336529b = "";
        this.f336530c = 0L;
    }

    public String a() {
        return "CustomStatus";
    }

    public String b() {
        return "CustomStatus";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f336527d) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.f336528a, "ufaceIndex");
        jceDisplayer.display(this.f336529b, "sWording");
        jceDisplayer.display(this.f336530c, "ufaceType");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        b bVar = (b) obj;
        if (!JceUtil.equals(this.f336528a, bVar.f336528a) || !JceUtil.equals(this.f336529b, bVar.f336529b) || !JceUtil.equals(this.f336530c, bVar.f336530c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336528a = jceInputStream.read(this.f336528a, 0, false);
        this.f336529b = jceInputStream.readString(1, false);
        this.f336530c = jceInputStream.read(this.f336530c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336528a, 0);
        String str = this.f336529b;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.f336530c, 2);
    }

    public b(long j3, String str, long j16) {
        this.f336528a = j3;
        this.f336529b = str;
        this.f336530c = j16;
    }
}
