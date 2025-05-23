package com.tencent.mobileqq.msf.core.c0;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class c extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static Map<String, l> f247590d;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, l> f247591a;

    /* renamed from: b, reason: collision with root package name */
    public long f247592b;

    /* renamed from: c, reason: collision with root package name */
    public long f247593c;

    public c() {
        this.f247591a = null;
        this.f247592b = 0L;
        this.f247593c = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f247590d == null) {
            f247590d = new HashMap();
            f247590d.put("", new l());
        }
        this.f247591a = (Map) jceInputStream.read((JceInputStream) f247590d, 1, true);
        this.f247592b = jceInputStream.read(this.f247592b, 2, true);
        this.f247593c = jceInputStream.read(this.f247593c, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.f247591a, 1);
        jceOutputStream.write(this.f247592b, 2);
        jceOutputStream.write(this.f247593c, 3);
    }

    public c(Map<String, l> map, long j3, long j16) {
        this.f247591a = map;
        this.f247592b = j3;
        this.f247593c = j16;
    }
}
