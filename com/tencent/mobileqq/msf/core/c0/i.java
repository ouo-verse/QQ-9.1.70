package com.tencent.mobileqq.msf.core.c0;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class i extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static Map<String, String> f247783e;

    /* renamed from: a, reason: collision with root package name */
    public String f247784a;

    /* renamed from: b, reason: collision with root package name */
    public long f247785b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f247786c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f247787d;

    public i() {
        this.f247784a = "";
        this.f247785b = 0L;
        this.f247786c = null;
        this.f247787d = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f247784a = jceInputStream.readString(1, true);
        this.f247785b = jceInputStream.read(this.f247785b, 2, true);
        if (f247783e == null) {
            HashMap hashMap = new HashMap();
            f247783e = hashMap;
            hashMap.put("", "");
        }
        this.f247786c = (Map) jceInputStream.read((JceInputStream) f247783e, 3, true);
        this.f247787d = jceInputStream.read(this.f247787d, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f247784a, 1);
        jceOutputStream.write(this.f247785b, 2);
        jceOutputStream.write((Map) this.f247786c, 3);
        jceOutputStream.write(this.f247787d, 4);
    }

    public i(String str, long j3, Map<String, String> map, boolean z16) {
        this.f247784a = str;
        this.f247785b = j3;
        this.f247786c = map;
        this.f247787d = z16;
    }
}
