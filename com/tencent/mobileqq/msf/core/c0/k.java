package com.tencent.mobileqq.msf.core.c0;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class k extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public long f247869a;

    /* renamed from: b, reason: collision with root package name */
    public long f247870b;

    /* renamed from: c, reason: collision with root package name */
    public long f247871c;

    /* renamed from: d, reason: collision with root package name */
    public long f247872d;

    /* renamed from: e, reason: collision with root package name */
    public long f247873e;

    /* renamed from: f, reason: collision with root package name */
    public long f247874f;

    public k() {
        this.f247869a = 0L;
        this.f247870b = 0L;
        this.f247871c = 0L;
        this.f247872d = 0L;
        this.f247873e = 0L;
        this.f247874f = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f247869a = jceInputStream.read(this.f247869a, 1, true);
        this.f247870b = jceInputStream.read(this.f247870b, 2, true);
        this.f247871c = jceInputStream.read(this.f247871c, 3, true);
        this.f247872d = jceInputStream.read(this.f247872d, 4, true);
        this.f247873e = jceInputStream.read(this.f247873e, 5, true);
        this.f247874f = jceInputStream.read(this.f247874f, 6, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f247869a, 1);
        jceOutputStream.write(this.f247870b, 2);
        jceOutputStream.write(this.f247871c, 3);
        jceOutputStream.write(this.f247872d, 4);
        jceOutputStream.write(this.f247873e, 5);
        jceOutputStream.write(this.f247874f, 6);
    }

    public k(long j3, long j16, long j17, long j18, long j19, long j26) {
        this.f247869a = j3;
        this.f247870b = j16;
        this.f247871c = j17;
        this.f247872d = j18;
        this.f247873e = j19;
        this.f247874f = j26;
    }
}
