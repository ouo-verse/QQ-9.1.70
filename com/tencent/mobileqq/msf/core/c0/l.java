package com.tencent.mobileqq.msf.core.c0;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class l extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static Map<String, Long> f247875d;

    /* renamed from: e, reason: collision with root package name */
    static Map<String, Long> f247876e;

    /* renamed from: a, reason: collision with root package name */
    public String f247877a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, Long> f247878b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Long> f247879c;

    public l() {
        this.f247877a = "";
        this.f247878b = null;
        this.f247879c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f247877a = jceInputStream.readString(1, true);
        if (f247875d == null) {
            f247875d = new HashMap();
            f247875d.put("", 0L);
        }
        this.f247878b = (Map) jceInputStream.read((JceInputStream) f247875d, 2, true);
        if (f247876e == null) {
            f247876e = new HashMap();
            f247876e.put("", 0L);
        }
        this.f247879c = (Map) jceInputStream.read((JceInputStream) f247876e, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f247877a, 1);
        jceOutputStream.write((Map) this.f247878b, 2);
        jceOutputStream.write((Map) this.f247879c, 3);
    }

    public l(String str, Map<String, Long> map, Map<String, Long> map2) {
        this.f247877a = str;
        this.f247878b = map;
        this.f247879c = map2;
    }
}
