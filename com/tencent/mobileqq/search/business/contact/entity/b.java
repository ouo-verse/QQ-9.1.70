package com.tencent.mobileqq.search.business.contact.entity;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Integer f282927a;

    /* renamed from: b, reason: collision with root package name */
    public Long f282928b;

    public b(Integer num, Long l3) {
        this.f282927a = num;
        this.f282928b = l3;
    }

    public static int a(b bVar) {
        Integer num;
        if (bVar != null && (num = bVar.f282927a) != null) {
            return num.intValue();
        }
        return 0;
    }

    public static long b(b bVar) {
        Long l3;
        if (bVar != null && (l3 = bVar.f282928b) != null) {
            return l3.longValue();
        }
        return 0L;
    }
}
