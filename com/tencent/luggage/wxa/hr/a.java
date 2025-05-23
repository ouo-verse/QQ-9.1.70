package com.tencent.luggage.wxa.hr;

import com.tencent.luggage.wxa.fn.c;
import com.tencent.luggage.wxa.ir.b;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f129176a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.kr.a f129177b;

    /* renamed from: c, reason: collision with root package name */
    public int f129178c = 0;

    public a(byte[] bArr, b bVar) {
        this.f129177b = com.tencent.luggage.wxa.kr.a.a(bArr);
        this.f129176a = bVar;
    }

    public boolean a(int i3) {
        return this.f129177b.a();
    }

    public c b(int i3) {
        return this.f129177b.b();
    }

    public double c(int i3) {
        return this.f129177b.c();
    }

    public float d(int i3) {
        return this.f129177b.d();
    }

    public int e(int i3) {
        return this.f129177b.e();
    }

    public int f(int i3) {
        return e(i3);
    }

    public long g(int i3) {
        return this.f129177b.f();
    }

    public LinkedList h(int i3) {
        return this.f129177b.b(i3);
    }

    public String i(int i3) {
        return this.f129177b.l();
    }

    public int a() {
        int m3 = this.f129177b.m();
        this.f129178c = m3;
        return com.tencent.luggage.wxa.jr.a.a(m3);
    }

    public void b() {
        int b16 = com.tencent.luggage.wxa.jr.a.b(this.f129178c);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ");
        stringBuffer.append(com.tencent.luggage.wxa.jr.a.a(this.f129178c));
        stringBuffer.append(" - ");
        if (b16 == 0) {
            stringBuffer.append("varint (long, int or boolean) value: ");
            stringBuffer.append(this.f129177b.k());
        } else if (b16 == 1) {
            stringBuffer.append("double value: ");
            stringBuffer.append(Double.toString(this.f129177b.c()));
        } else if (b16 == 2) {
            stringBuffer.append("Length delimited (String or ByteString) value: ");
            stringBuffer.append(this.f129177b.l());
        } else if (b16 == 5) {
            stringBuffer.append("float value: ");
            stringBuffer.append(Float.toString(this.f129177b.d()));
        }
        this.f129176a.a(stringBuffer.toString());
    }
}
