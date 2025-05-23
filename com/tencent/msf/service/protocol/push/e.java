package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static Map<Long, SvcMsgPush> f336557d;

    /* renamed from: a, reason: collision with root package name */
    public long f336558a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Long, SvcMsgPush> f336559b;

    /* renamed from: c, reason: collision with root package name */
    public String f336560c;

    public e() {
        this.f336558a = 0L;
        this.f336559b = null;
        this.f336560c = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336558a = jceInputStream.read(this.f336558a, 0, true);
        if (f336557d == null) {
            f336557d = new HashMap();
            f336557d.put(0L, new SvcMsgPush());
        }
        this.f336559b = (Map) jceInputStream.read((JceInputStream) f336557d, 1, true);
        this.f336560c = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336558a, 0);
        jceOutputStream.write((Map) this.f336559b, 1);
        jceOutputStream.write(this.f336560c, 2);
    }

    public e(long j3, Map<Long, SvcMsgPush> map, String str) {
        this.f336558a = j3;
        this.f336559b = map;
        this.f336560c = str;
    }
}
