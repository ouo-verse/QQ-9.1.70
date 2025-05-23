package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class f extends JceStruct {

    /* renamed from: h, reason: collision with root package name */
    static Map<Long, SvcMsgPush> f336561h;

    /* renamed from: a, reason: collision with root package name */
    public long f336562a;

    /* renamed from: b, reason: collision with root package name */
    public byte f336563b;

    /* renamed from: c, reason: collision with root package name */
    public String f336564c;

    /* renamed from: d, reason: collision with root package name */
    public Map<Long, SvcMsgPush> f336565d;

    /* renamed from: e, reason: collision with root package name */
    public int f336566e;

    /* renamed from: f, reason: collision with root package name */
    public byte f336567f;

    /* renamed from: g, reason: collision with root package name */
    public String f336568g;

    public f() {
        this.f336562a = 0L;
        this.f336563b = (byte) 0;
        this.f336564c = "";
        this.f336565d = null;
        this.f336566e = 300;
        this.f336567f = (byte) 0;
        this.f336568g = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336562a = jceInputStream.read(this.f336562a, 0, true);
        this.f336563b = jceInputStream.read(this.f336563b, 1, true);
        this.f336564c = jceInputStream.readString(2, true);
        if (f336561h == null) {
            f336561h = new HashMap();
            f336561h.put(0L, new SvcMsgPush());
        }
        this.f336565d = (Map) jceInputStream.read((JceInputStream) f336561h, 3, true);
        this.f336566e = jceInputStream.read(this.f336566e, 4, false);
        this.f336567f = jceInputStream.read(this.f336567f, 5, false);
        this.f336568g = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336562a, 0);
        jceOutputStream.write(this.f336563b, 1);
        jceOutputStream.write(this.f336564c, 2);
        jceOutputStream.write((Map) this.f336565d, 3);
        jceOutputStream.write(this.f336566e, 4);
        jceOutputStream.write(this.f336567f, 5);
        String str = this.f336568g;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
    }

    public f(long j3, byte b16, String str, Map<Long, SvcMsgPush> map, int i3, byte b17, String str2) {
        this.f336562a = j3;
        this.f336563b = b16;
        this.f336564c = str;
        this.f336565d = map;
        this.f336566e = i3;
        this.f336567f = b17;
        this.f336568g = str2;
    }
}
